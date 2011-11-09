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
    
   public ResultSet consultar(String tabla, String campo) throws SQLException
   {
        rs = stm.executeQuery("SELECT * FROM " + tabla);
        return rs;
   }
   
   /**
    *  public String buscarNombre(String tabla, String nombre) throws SQLException
   {
       String name = null;
       try{
       rs = stm.executeQuery("SELECT * FROM " + tabla + " WHERE nombre = '"+ nombre +"' LIMIT 1");
       rs.next();
       name = rs.getString(2);
       }catch(SQLException ex){System.out.println(ex);}
       return name;
   }
   
   public void insertar(Hashtable usuario) 
   {
        try {
            stm.execute("INSERT INTO usuarios (nombre, contraseña) VALUES ('" + usuario.get("nombre") + "','" + usuario.get("contraseña") + "')");            
        } catch (SQLException ex) {
            System.out.println(ex);
        }
   }
   
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
