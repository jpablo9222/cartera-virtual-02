/**
 *
 * @author Juan Pablo
 */
import java.util.ArrayList;
public class Categorias {
    private String nombreCat;
    private int numCuentas;
    private ArrayList<Cuenta> cuentas;
    
    public Categorias(String nombre){
        nombreCat = nombre;
        numCuentas = 0;
        cuentas = new ArrayList<Cuenta>();
    }
    
    public String getNombreCat()
    {
        return nombreCat;
    }
    
    public int getNumCuenta()
    {
        return numCuentas;
    }
    
    public ArrayList<Cuenta> getCuentas()
    {
        return cuentas;
    }
    
    public void addNumCuenta()
    {
        numCuentas += 1;
    }
    
}
