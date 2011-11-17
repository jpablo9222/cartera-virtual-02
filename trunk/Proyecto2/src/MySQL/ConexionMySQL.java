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
    public String[] mostrarT(String categoria)
   {
       String[] titulos = {};
       try{
           int columnas = this.verificar(categoria);
           titulos = new String[columnas+1];
           titulos[0]="Titulo";
           rs = stm.executeQuery("SELECT tc1,tc2,tc3,tc4,tc5,tc6,tc7 FROM Categoria WHERE nombreCat = '"+categoria+"' LIMIT 1");
           rs.next();
           for (int i=1; i<=columnas; i++){
               titulos[i] = rs.getString(i);
           }
       } catch (SQLException e){System.out.println("Error en Mostrar Titulo");}
       return titulos;
   }
   
   /**
    * Método que Devuelve un ArrayList con todas las Categorias Existentes
    * @return
    * @throws SQLException
    */
   public ArrayList<String> getCategoria()
   {
       ArrayList<String> categoria = new ArrayList<String>();
       try{
           rs = stm.executeQuery("SELECT nombreCat FROM Categoria");
           while (rs.next()){
               categoria.add(rs.getString(1));
           }
       } catch (SQLException e){System.out.println("Error en getCategoria");}
       return categoria;
   }
   
   public ArrayList<String> getUsuario()
   {
       ArrayList<String> usuario = new ArrayList<String>();
       try{
           rs = stm.executeQuery("SELECT usuario FROM Usuario");
           while (rs.next()){
               usuario.add(rs.getString(1));
           }
       } catch (SQLException e){System.out.println("Error en getCategoria");}
       return usuario;
   }
   
   public String getCategorias(String titulo, String usuario)
   {
       try{
           rs = stm.executeQuery("SELECT nombreCat FROM Categoria JOIN Cuenta ON Cuenta.cat_id=Categoria.categoria_id JOIN Usuario ON Usuario.usuario_id=Cuenta.user_id WHERE Cuenta.titulo = '"+titulo+"' AND Usuario.usuario = '"+usuario+"'");    
           if (rs != null && rs.next()){
               System.out.println(rs.getString(1));
               return rs.getString(1);
           } else {
               return "";
           }
       } catch (SQLException e){System.out.println("Error en getCategorias");}
       return null;
   }
   
   /**
    * Método que Devuelve los Registros Asociados a una Categoria y un Usuario Especificos
    * @param categoria
    * @param usuario
    * @return
    * @throws SQLException
    */
   public ArrayList<ArrayList<Object>> mostrar(String categoria, String usuario)
   {
       ArrayList<ArrayList<Object>> datos = new ArrayList<ArrayList<Object>>();
       int columnas = verificar(categoria);
       try{
           rs = stm.executeQuery("SELECT titulo,c1,c2,c3,c4,c5,c6,c7 FROM Cuenta JOIN Categoria ON Categoria.categoria_id=Cuenta.cat_id JOIN Usuario ON Usuario.usuario_id=Cuenta.user_id WHERE Categoria.nombreCat = '"+categoria+"' AND Usuario.usuario = '"+usuario+"'");
       
           while (rs.next())
           {
               ArrayList<Object> reg = new ArrayList<Object>();
               for (int i=0;i<(columnas+1);i++){
                   reg.add(rs.getObject(i+1)); 
               }
                // Se añade al modelo la fila completa.

               datos.add(reg);
           }
       } catch (SQLException e){System.out.println("Error en Mostrar Datos");}
       return datos;
   }
   
   /**
    * Método que Devuelve los Registros Asociados al Título de una Categoría y a un Usuario Específicos
    * @param titulo
    * @param usuario
    * @return
    * @throws SQLException
    */
   public ArrayList<ArrayList<Object>> buscarTitulo(String titulo, String usuario, String categoria)
   {
       ArrayList<ArrayList<Object>> datos = new ArrayList<ArrayList<Object>>();
       int columnas = verificar(categoria);
       try{
           rs = stm.executeQuery("SELECT titulo,c1,c2,c3,c4,c5,c6,c7 FROM Cuenta JOIN Usuario ON Usuario.usuario_id=Cuenta.user_id WHERE Cuenta.titulo = '"+ titulo +"' AND Usuario.usuario = '"+ usuario +"'");
           while (rs.next())
           {
               ArrayList<Object> reg = new ArrayList<Object>();
               for (int i=0;i<(columnas+1);i++){
                   reg.add(rs.getObject(i+1)); 
               }
                // Se añade al modelo la fila completa.

               datos.add(reg);
           }
       }catch(SQLException ex){System.out.println(ex);}
       return datos;
   }
   
   /**
    * Método que Verifica si los Datos de Ingreso son Válidos Y Pertenecen a un Usuario con Información en la Cartera
    * @param user
    * @param pass
    * @return
    * @throws SQLException
    */
   public String login(String user, String pass)
   {
       System.out.println(user+" "+pass);
       try{
           rs = stm.executeQuery("SELECT usuario, contrasenia FROM Usuario WHERE usuario = '"+ user +"' AND contrasenia = '"+pass+"' LIMIT 1");
           if (rs != null && rs.next()){
               return user;
           } else {
               return "";
           }
       } catch (SQLException e){System.out.println("Error en Login");}
       return "";
   }
   
   public String getPass(String user)
   {
       try{
           rs = stm.executeQuery("SELECT contrasenia FROM Usuario WHERE usuario = '"+ user +"' LIMIT 1");
           if (rs != null && rs.next()){
               return rs.getString(1);
           } else {
              return "";
           }
       } catch (SQLException e){System.out.println("Error en getPass");}
       return "";
   }
   
   /**
    * Método que Verifica Cuantos Campos Utiliza una Categoria en Especifico
    * @param categoria
    * @return
    * @throws SQLException
    */
   public int verificar(String categoria)
   {
       int count = 0;
       try{
           rs = stm.executeQuery("SELECT tc1,tc2,tc3,tc4,tc5,tc6,tc7 FROM Categoria WHERE nombreCat = '"+categoria+"' LIMIT 1");
           rs.next();
           for (int i=1; i<=7; i++){
               if (!rs.getString(i).equals("")){
                   count++;
               }
           }
       } catch (SQLException e){System.out.println("Error en Verificar Categoria");}
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
   public void insertarCuenta(String categoria, String usuario, String titulo, String c1, String c2, String c3, String c4, String c5, String c6, String c7)
   {
       try{ 
           ResultSet rsU = stm.executeQuery("SELECT usuario_id FROM Usuario WHERE usuario = '"+ usuario +"' LIMIT 1");
           rsU.next();
           int u = rsU.getInt(1);
           ResultSet rsC = stm.executeQuery("SELECT categoria_id FROM Categoria WHERE nombreCat = '"+ categoria +"' LIMIT 1");
           rsC.next();
           int c = rsC.getInt(1);
           System.out.println("usuario"+u+", campo"+c);
           stm.execute("INSERT INTO Cuenta (user_id,cat_id,titulo,c1,c2,c3,c4,c5,c6,c7) VALUES ("+u+","+c+",'"+ titulo +"','"+ c1 +"','"+ c2 +"','"+ c3 +"','"+ c4 +"','"+ c5 +"','"+ c6 +"','"+ c7 +"')"); 
       } catch (SQLException e){System.out.println("Error en Insertar Cuenta");} 
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
   public void insertarCategoria(String nombre, String tc1, String tc2, String tc3, String tc4, String tc5, String tc6, String tc7)
   {
       try{
           stm.execute("INSERT INTO Categoria (nombreCat,tc1,tc2,tc3,tc4,tc5,tc6,tc7) VALUES ('"+ nombre +"','"+ tc1 +"','"+ tc2 +"','"+ tc3 +"','"+ tc4 +"','"+ tc5 +"','"+ tc6 +"','"+ tc7 +"')");
       } catch (SQLException e){System.out.println("Error en Insertar Categoria");}    
   }
   
   public void insertarCampo(String nombre, String tc1, String tc2, String tc3, String tc4, String tc5, String tc6, String tc7)
   {
       try{
           stm.execute("UPDATE Categoria SET tc1 = '"+ tc1 +"', tc2 = '"+ tc2 +"', tc3 = '"+ tc3 +"', tc4 = '"+ tc4 +"', tc5 = '"+ tc5 +"', tc6 = '"+ tc6 +"', tc7 = '"+ tc7 +"' WHERE nombreCat = '"+nombre+"'");
       } catch (SQLException e){System.out.println("Error en Insertar Campo");}
   }
   
   /**
    * Método que Ingresa un Nuevo Registro a la Tabla de Usuarios
    * @param user
    * @param pass
    * @throws SQLException
    */
   public void insertarUsuario(String user, String pass)
   {
       try{
           stm.execute("INSERT INTO Usuario (usuario,contrasenia) VALUES ('"+ user +"','"+ pass +"')");
       } catch (SQLException e){System.out.println("Error en Insertar Usuario");}
   }
   
   /**
    * Método que Actualiza/Modifica la Contraseña de Un Usuario.
    * @param user
    * @param pass
    */
   public void actualizarPass(String user, String pass)
    {
        try {
            stm.execute("UPDATE Usuario SET contrasenia = '" + pass + "' WHERE usuario = '"+ user +"'");
        } catch (SQLException ex) {System.out.println("Error en Actualizar Pass");}
    }
   
   /**
    * Método que Elimina la Información de la Cartera de Un Usuario en Específico
    * @param user
    */
   public void eliminarCartera(String user) 
   {
        try {
            stm.execute("DELETE Cuenta FROM Cuenta JOIN Usuario ON Usuario.usuario_id=Cuenta.user_id  WHERE Usuario.usuario = '" + user + "'");
        } catch (SQLException ex) {System.out.println("Error en Eliminar Cartera");}
   }
}
