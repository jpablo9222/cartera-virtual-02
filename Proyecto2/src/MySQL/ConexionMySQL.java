package MySQL;

/**
 *
 * @author Juan Pablo
 */
import java.sql.*;
public class ConexionMySQL {
    private String user;
    private String password;
    private String url;
    private Connection conexion = null;
    private Statement stm;
    private ResultSet rs;
    
    public ConexionMySQL (String server, String usuario, String contraseña, String bd)
    {
        this.user = usuario;
        this.password = contraseña;
        this.url = "jdbc:mysql://" + server + "/" + bd;
    }
    
    public void conectar()
    {
        try {
            Class.forName("org.gjt.mm.mysql.Driver");
            conexion = DriverManager.getConnection(url, user, password);
            if (conexion != null)
            {
                System.out.println("Conexión a base de datos "+url+" ... Ok");
                stm = conexion.createStatement();
            }
        } catch(SQLException ex) {
            System.out.println("Hubo un problema al intentar conectarse con la base de datos "+url);
        } catch(ClassNotFoundException ex) {
            System.out.println(ex);
        }
    }
    
   public ResultSet mostrarT(String categoria) throws SQLException
   {
       rs = stm.executeQuery("SELECT tc1,tc2,tc3,tc4,tc5,tc6,tc7 FROM Categoria WHERE nombreCat LIKE '%"+categoria+"%'" );
       return rs;
   }
    
   public ResultSet mostrar(String categoria) throws SQLException
   {
       rs = stm.executeQuery("SELECT titulo,c1,c2,c3,c4,c5,c6,c7 FROM Cuenta JOIN Categoria ON Categoria.categoria_id=Cuenta.cat_id WHERE Categoria.nombreCat = '"+categoria+"' LIMIT 1");
       return rs;
   }
   
   public ResultSet buscarTitulo(String titulo, String usuario) throws SQLException
   {
       try{
           rs = stm.executeQuery("SELECT titulo,c1,c2,c3,c4,c5,c6,c7 FROM Cuenta JOIN Usuario ON Usuario.usuario_id=Cuenta.user_id WHERE Cuenta.titulo = '"+ titulo +"' AND Usuario.usuario = '"+ usuario +"'");
       }catch(SQLException ex){System.out.println(ex);}
       return rs;
   }
   
   public String login(String user, String pass) throws SQLException
   {
       rs = stm.executeQuery("SELECT usuario, contrasenia FROM Usuario WHERE usuario = '"+ user +"' AND contrasenia = ' LIMIT 1");
       if (rs.next()){
           return user;
       } else {
           return "";
       }
   }
   
   public int verificar(String categoria) throws SQLException
   {
       int count = 0;
       rs = stm.executeQuery("SELECT tc1,tc2,tc3,tc4,tc5,tc6,tc7 FROM Categoria WHERE nombreCat = '"+categoria+"' LIMIT 1");
       rs.next();
       for (int i=1; i<=7; i++){
           if (!rs.getString(i).equals("")){
               count++;
           }
       }
       return count;
   }
   
   public void insertarCuenta(String categoria, String usuario, String titulo, String c1, String c2, String c3, String c4, String c5, String c6, String c7) throws SQLException
   {
        ResultSet rsU = stm.executeQuery("SELECT usuario_id FROM Usuario WHERE usuario = '"+ usuario +"' LIMIT 1");
        rsU.next();
        int u = rsU.getInt(1);
        ResultSet rsC = stm.executeQuery("SELECT categoria_id FROM Categoria WHERE nombreCat = '"+ categoria +"' LIMIT 1");
        rsC.next();
        int c = rsC.getInt(1);
        
        stm.execute("INSERT INTO Cuenta (user_id,cat_id,titulo,c1,c2,c3,c4,c5,c6,c7) VALUES ("+ u +","+ c +",,"+ titulo +","+ c1 +","+ c2 +","+ c3 +","+ c4 +","+ c5 +","+ c6 +","+ c7 +")"); 
   }
   
   public void insertarCategoria(String nombre, String tc1, String tc2, String tc3, String tc4, String tc5, String tc6, String tc7) throws SQLException
   {
       stm.execute("INSERT INTO Categoria (nombreCat,tc1,tc2,tc3,tc4,tc5,tc6,tc7) VALUES ("+ nombre +","+ tc1 +","+ tc2 +","+ tc3 +","+ tc4 +","+ tc5 +","+ tc6 +","+ tc7 +")");
   }
   
   public void insertarUsuario(String user, String pass) throws SQLException
   {
       stm.execute("INSERT INTO Usuario (usuario,contrasenia) VALUES ("+ user +","+ pass +")");
   }
   
   public void actualizarPass(String user, String pass)
    {
        try {
            stm.execute("UPDATE Usuario SET contrasenia = '" + pass + "' WHERE usuario = "+ user +" ");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
   
   public void eliminarCartera(String user) 
   {
        try {
            stm.execute("DELETE Cuenta FROM Cuenta JOIN Usuario ON Usuario.usuario_id=Cuenta.user_id  WHERE Usuario.usuario = '" + user + "'");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
   }
}
