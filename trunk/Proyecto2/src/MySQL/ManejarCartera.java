package MySQL;

/**
 *
 * @author Juan Pablo
 */
import javax.swing.table.DefaultTableModel;
import javax.swing.ListModel;
import java.util.ArrayList;
import java.util.Arrays;
public class ManejarCartera {
    private ConexionMySQL sql;
    private String usuario;
    private DefaultTableModel modelo;
    
    public ManejarCartera()
    {
        sql = new ConexionMySQL("localhost","root","JAMB2091","proyecto2");
        sql.conectar();
    }
    
    /**
     * Método que Establece el Usuario del Programa
     * @param user
     */
    public void setUsuario(String user){
        usuario = user;
    }
    
    public ArrayList<ArrayList<Object>> getReg(String cat){
        return sql.mostrar(cat,usuario);
    }
    
    public ArrayList<ArrayList<Object>> getBusqueda(String titulo, String cat){
        return sql.buscarTitulo(titulo, usuario, cat);
    }
    
    public DefaultTableModel mostrarInfo(ArrayList<ArrayList<Object>> registros, String cat){
        modelo = new DefaultTableModel();
        String[] titulos = sql.mostrarT(cat);
        for (int i=0; i<titulos.length; i++){
            modelo.addColumn(titulos[i]);
        }
        for(ArrayList<Object> reg:registros){
                // Se crea un array que será una de las filas de la tabla.
                Object[] fila = new Object[titulos.length]; // Hay tres columnas en la tabla
                // Se rellena cada posición del array con una de las columnas de la tabla en base de datos.
                for (int i=0;i<(titulos.length);i++){
                    fila[i] = reg.get(i); 
                }
                // Se añade al modelo la fila completa.
               modelo.addRow(fila);
        }
        return modelo;
    }
    
    public boolean cambiarPass(char[] p1, char[] p2, char[] p3){
        boolean iguales = true;
        String passActual;
        String pass = "";
        String passNueva = "";
        if (p2.length != p3.length) {
            iguales = false;
        } else {
            iguales = Arrays.equals(p2,p3);
        }
        if (iguales){
            for (int i=0;i<p1.length;i++){
                pass+=""+p1[i];
            }
            for (int i=0;i<p2.length;i++){
                passNueva+=""+p2[i];
            }
            passActual = sql.getPass(usuario);
            if (pass.equals(passActual)){
                sql.actualizarPass(usuario,passNueva);
                return true;
            }else{
                return false;
            }    
        }else{
            return false;
        }
        
    }
    
    public boolean ingresarUsuario(char[] p1, char[] p2, String user){
        boolean iguales;
        if (p1.length != p2.length) {
            iguales = false;
        } else {
            iguales = Arrays.equals(p1,p2);
        }
        if (iguales){
            String pass = "";
            for (int i=0;i<p1.length;i++){
                pass+=""+p1[i];
            }
            ArrayList<String> usuarioo = sql.getUsuario();
            for (String usuario1:usuarioo){
                if (usuario1.equals(user)){
                    return false;
                } else {
                    sql.insertarUsuario(user, pass);
                }
            }
            return true;
        }else{
            return false;
        }
    }
    
    public boolean insertarCampo(String cat, String campo){
        int columnas = sql.verificar(cat);
        if (columnas==7){
            return false;
        } else {
            boolean insertar = true;
            String[] titulos = {"","","","","","",""};
            String[] campos = sql.mostrarT(cat);
            System.arraycopy(campos, 1, titulos, 0, campos.length-1);
            for (int i=0;i<7;i++){
                if (titulos[i].equals("")&&(insertar)){
                    titulos[i] = campo;
                    insertar = false;
                }
            }
            sql.insertarCampo(cat, titulos[0], titulos[1], titulos[2], titulos[3], titulos[4], titulos[5], titulos[6]);
            return true;
        }
    }
    
    public boolean borrarInfo(char[] p1, char[] p2){
        boolean iguales;
        String passActual;
        if (p1.length != p2.length) {
            iguales = false;
        } else {
            iguales = Arrays.equals(p1,p2);
        }
        if (iguales){
                String pass = "";
                for (int i=0;i<p1.length;i++){
                    pass+=""+p1[i];
                }
                passActual = sql.getPass(usuario);
                if (pass.equals(passActual)){
                    sql.eliminarCartera(usuario);
                    return true;
                }else{
                    return false;
                }
                
        }else{
            return false;
        }
    }
    
    public String login(String user, char[] pas){
        String pass = "";
        for (int i=0;i<pas.length;i++){
            pass+=""+pas[i];
        }
        if (!sql.login(user, pass).equals("")){
            usuario = sql.login(user, pass);
        }
        return sql.login(user, pass);
    }
    
    public boolean ingresarCat(String cat, ListModel modelo){
        ArrayList<String> listaCat = sql.getCategoria();
        for (String listaa:listaCat){
            if (listaa.equals(cat)){
                return false;
            }
        }
        String[] tc = {"","","","","","",""};
        for (int i=1;i<modelo.getSize();i++){
            tc[i-1] = ""+modelo.getElementAt(i);
        }
        sql.insertarCategoria(cat, tc[0], tc[1], tc[2], tc[3], tc[4], tc[5], tc[6]);
        return true;
    }
    
    public void ingresarCuenta(String cat, String t1, String t2, String t3, String t4, String t5, String t6, String t7, String t8){
        sql.insertarCuenta(cat, usuario, t1, t2, t3, t4, t5, t6, t7, t8);
    }
    
    public int verificar(String cat){
        return sql.verificar(cat);
    }
    
    public String[] getCampos(String cat){
        return sql.mostrarT(cat);
    }
    
    public ArrayList<String> getCategoria(){
        return sql.getCategoria();
    }
    
    public String getCat(String titulo){
        return sql.getCategorias(titulo, usuario);
    }
}
