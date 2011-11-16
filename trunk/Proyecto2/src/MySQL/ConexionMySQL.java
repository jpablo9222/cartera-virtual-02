package MySQL;

/**
 *
 * @author Juan Pablo
 */
import java.sql.*;
import java.util.ArrayList;
public class ConexionMySQL {
    private String user;
    private String password;
    private String url;
    private Connection conexion = null;
    private Statement stm;
    private ResultSet rs;
    
    /**
     * Método Constructor Que Crea la Base Para Una Nueva Conexión a MySQL
     * @param server
     * @param usuario
     * @param contraseña
     * @param bd
     */
    public ConexionMySQL (String server, String usuario, String contraseña, String bd)
    {
        this.user = usuario;
        this.password = contraseña;
        this.url = "jdbc:mysql://" + server + "/" + bd;
    }
    
    /**
     * Método que Realiza la Conexión con MySQL
     */
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
    
    /**
     * Método que Busca los Títulos de una Categoría y los Devuelve dentro de un Arreglo
     * @param categoria
     * @return
     * @throws SQLException
     */
    public String[] mostrarT(String categoria) throws SQLException
   {
       int columnas = this.verificar(categoria);
       rs = stm.executeQuery("SELECT tc1,tc2,tc3,tc4,tc5,tc6,tc7 FROM Categoria WHERE nombreCat LIKE '%"+categoria+"%' LIMIT 1");
       rs.next();
       String[] titulos = new String[columnas+1];
       titulos[0]="Titulo";
       for (int i=1; i<=columnas; i++){
           titulos[i] = rs.getString(i);
       }
       return titulos;
   }
   
   /**
    * Método que Devuelve un ArrayList con todas las Categorias Existentes
    * @return
    * @throws SQLException
    */
   public ArrayList<String> getCategoria() throws SQLException
   {
       ArrayList<String> categoria = new ArrayList<String>();
       rs = stm.executeQuery("SELECT nombreCat FROM Categoria");
       while (rs.next()){
           categoria.add(rs.getString(1));
       }
       return categoria;
   }
   
   public String getCategorias(String titulo, String usuario) throws SQLException
   {
       rs = stm.executeQuery("SELECT nombreCat FROM Categoria JOIN Cuenta ON Cuenta.cat_id=Categoria.categoria_id JOIN Usuario ON Usuario.usuario_id=Cuenta.user_id WHERE Cuenta.titulo = '"+titulo+"' AND Usuario.usuario = '"+usuario+"'");    
       System.out.println("entro al metodos");
       if (rs != null && rs.next()){
           System.out.println(rs.getString(1));
           return rs.getString(1);
       } else {
           return "";
       }
   }
   
   /**
    * Método que Devuelve los Registros Asociados a una Categoria y un Usuario Especificos
    * @param categoria
    * @param usuario
    * @return
    * @throws SQLException
    */
   public ResultSet mostrar(String categoria, String usuario) throws SQLException
   {
       rs = stm.executeQuery("SELECT titulo,c1,c2,c3,c4,c5,c6,c7 FROM Cuenta JOIN Categoria ON Categoria.categoria_id=Cuenta.cat_id JOIN Usuario ON Usuario.usuario_id=Cuenta.user_id WHERE Categoria.nombreCat = '"+categoria+"' AND Usuario.usuario = '"+usuario+"'");
       return rs;
   }
   
   /**
    * Método que Devuelve los Registros Asociados al Título de una Categoría y a un Usuario Específicos
    * @param titulo
    * @param usuario
    * @return
    * @throws SQLException
    */
   public ResultSet buscarTitulo(String titulo, String usuario) throws SQLException
   {
       try{
           rs = stm.executeQuery("SELECT titulo,c1,c2,c3,c4,c5,c6,c7 FROM Cuenta JOIN Usuario ON Usuario.usuario_id=Cuenta.user_id WHERE Cuenta.titulo = '"+ titulo +"' AND Usuario.usuario = '"+ usuario +"'");
       }catch(SQLException ex){System.out.println(ex);}
       return rs;
   }
   
   /**
    * Método que Verifica si los Datos de Ingreso son Válidos Y Pertenecen a un Usuario con Información en la Cartera
    * @param user
    * @param pass
    * @return
    * @throws SQLException
    */
   public String login(String user, String pass) throws SQLException
   {
       rs = stm.executeQuery("SELECT usuario, contrasenia FROM Usuario WHERE usuario = '"+ user +"' AND contrasenia = '"+pass+"' LIMIT 1");
       if (rs != null && rs.next()){
           return user;
       } else {
           return "";
       }
   }
   
   /**
    * Método que Verifica Cuantos Campos Utiliza una Categoria en Especifico
    * @param categoria
    * @return
    * @throws SQLException
    */
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
   
   /**
    * Método que Ingresa un Nuevo Registro en la Tabla de Cuentas, Asociado a una Categoria y a un Usuario Específicos
    * @param categoria
    * @param usuario
    * @param titulo
    * @param c1
    * @param c2
    * @param c3
    * @param c4
    * @param c5
    * @param c6
    * @param c7
    * @throws SQLException
    */
   public void insertarCuenta(String categoria, String usuario, String titulo, String c1, String c2, String c3, String c4, String c5, String c6, String c7) throws SQLException
   {
        ResultSet rsU = stm.executeQuery("SELECT usuario_id FROM Usuario WHERE usuario = '"+ usuario +"' LIMIT 1");
        rsU.next();
        int u = rsU.getInt(1);
        ResultSet rsC = stm.executeQuery("SELECT categoria_id FROM Categoria WHERE nombreCat = '"+ categoria +"' LIMIT 1");
        rsC.next();
        int c = rsC.getInt(1);
        
        stm.execute("INSERT INTO Cuenta (user_id,cat_id,titulo,c1,c2,c3,c4,c5,c6,c7) VALUES ("+ u +","+ c +",'"+ titulo +"','"+ c1 +"','"+ c2 +"','"+ c3 +"','"+ c4 +"','"+ c5 +"','"+ c6 +"','"+ c7 +"')"); 
   }
   
   /**
    * Método que Ingresa un Nuevo Registro en la Tabla de Categorias
    * @param nombre
    * @param tc1
    * @param tc2
    * @param tc3
    * @param tc4
    * @param tc5
    * @param tc6
    * @param tc7
    * @throws SQLException
    */
   public void insertarCategoria(String nombre, String tc1, String tc2, String tc3, String tc4, String tc5, String tc6, String tc7) throws SQLException
   {
       stm.execute("INSERT INTO Categoria (nombreCat,tc1,tc2,tc3,tc4,tc5,tc6,tc7) VALUES ('"+ nombre +"','"+ tc1 +"','"+ tc2 +"','"+ tc3 +"','"+ tc4 +"','"+ tc5 +"','"+ tc6 +"','"+ tc7 +"')");
   }
   
   /**
    * Método que Ingresa un Nuevo Registro a la Tabla de Usuarios
    * @param user
    * @param pass
    * @throws SQLException
    */
   public void insertarUsuario(String user, String pass) throws SQLException
   {
       stm.execute("INSERT INTO Usuario (usuario,contrasenia) VALUES ('"+ user +"','"+ pass +"')");
   }
   
   /**
    * Método que Actualiza/Modifica la Contraseña de Un Usuario.
    * @param user
    * @param pass
    */
   public void actualizarPass(String user, String pass)
    {
        try {
            stm.execute("UPDATE Usuario SET contrasenia = '" + pass + "' WHERE usuario = "+ user +" ");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
   
   /**
    * Método que Elimina la Información de la Cartera de Un Usuario en Específico
    * @param user
    */
   public void eliminarCartera(String user) 
   {
        try {
            stm.execute("DELETE Cuenta FROM Cuenta JOIN Usuario ON Usuario.usuario_id=Cuenta.user_id  WHERE Usuario.usuario = '" + user + "'");
        } catch (SQLException ex) {
            System.out.println(ex);
        }
   }
}
