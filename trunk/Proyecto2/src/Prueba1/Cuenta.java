/**
 *
 * @author Juan Pablo
 */
import java.util.ArrayList;
public class Cuenta {
    private ArrayList<String> nombreCampos, campos;
    
    public Cuenta()
    {
        nombreCampos = new ArrayList<String>();
        campos = new ArrayList<String>();
    }
    
    public ArrayList<String> getNombreCamp()
    {
        return nombreCampos;
    }
    
    public ArrayList<String> getCampos()
    {
        return campos;
    }
    
    public void addCampo(String nombre, String campo)
    {
        nombreCampos.add(nombre);
        campos.add(campo);
    }
    
}
