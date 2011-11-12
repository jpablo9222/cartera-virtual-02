package MySQL;

/**
 *
 * @author Juan Pablo
 */
import java.sql.*;
public class ConexionMySQL {
    private String user;
    private String password;
    private String db;
    private String url;
    private Connection conexion = null;
    private Statement stm;
    private ResultSet rs;
    
    public ConexionMySQL (String server, String usuario, String contraseña, String bd)
    {
        this.user = usuario;
        this.password = contraseña;
        this.db = bd;
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
   
   public ResultSet buscarTitulo(String titulo) throws SQLException
   {
       try{
           rs = stm.executeQuery("SELECT titulo,c1,c2,c3,c4,c5,c6,c7 FROM Cuenta WHERE titulo = '"+ titulo +"'");
       }catch(SQLException ex){System.out.println(ex);}
       return rs;
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
   
   public void insertar(String categoria) 
   {
        try {
            stm.execute("INSERT INTO Cuenta () VALUES ('" + usuario.get("nombre") + "','" + usuario.get("contraseña") + "')");            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
   }
   
   /**
    *  
   
   public void actualizar(String tabla, Hashtable usuario, String nombre)
    {
        try {
            stm.execute("UPDATE " + tabla + " SET nombre='" + usuario.get("nombre") + "' WHERE nombre='" + nombre + "'");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
   
   public void eliminar(String tabla, String nombre) 
   {
        try {
            stm.execute("DELETE FROM " + tabla + " WHERE nombre='" + nombre + "'");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
   }
    */
}
