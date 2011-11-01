package proyecto2;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tono
 */
public class AppsInternet extends Cuenta {
    private String link;
    public AppsInternet(String titulo,String usuario, String pass,String link){
        super(titulo,usuario,pass);
    }
    public String getLink(){
        return link;
    }
}
