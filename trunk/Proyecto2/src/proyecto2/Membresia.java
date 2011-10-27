package proyecto2;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tono
 */
import java.util.Date;
public class Membresia extends Cuenta{
    private Date fechaExp,fechaAd;
    
    public Membresia(String titulo, String usuario,String pass, Date fecha1,Date fecha2){
        super(titulo,usuario,pass);
        fechaAd=fecha1;
        fechaExp=fecha2;
    }
    public Date getFechaExp(){
        return fechaExp;
    }
    public Date getFechaAd(){
        return fechaAd;
    }
}
