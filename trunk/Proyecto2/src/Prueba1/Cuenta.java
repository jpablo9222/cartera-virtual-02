/**
 *
 * @author Juan Pablo
 */
public class Cuenta {
    private String[] nombreCampos, campos;
    private int numCampo;
    
    public Cuenta()
    {
        nombreCampos = new String[8];
        campos = new String[8];
        numCampo = 0;
    }
    
    public String[] getNombreCamp()
    {
        return nombreCampos;
    }
    
    public String[] getCampos()
    {
        return campos;
    }
    
    public int getNumCampo()
    {
        return numCampo;
    }
    
    public void addCampo(String nombre, String campo)
    {
        nombreCampos[numCampo] = nombre;
        campos[numCampo] = campo;
        numCampo+=1;
    }
    
}
