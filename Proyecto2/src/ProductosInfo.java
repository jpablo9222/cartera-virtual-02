/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tono
 */
import java.util.Date;
public class ProductosInfo extends Cuenta {
    private String licencia;
    private Date fechaAd,fechaExp;
    
    public ProductosInfo(String titulo, String usuario, String pass, Date fecha1, Date fecha2, String lic){
        super(titulo,usuario,pass);
        licencia=lic;
        fechaAd=fecha1;
        fechaExp=fecha2;
    }
    public String getLicencia(){
        return licencia;
    }
    public Date getFechaAd(){
        return fechaAd;
    }
    public Date getFechaExp(){
        return fechaExp;
    }
}
