package proyecto2;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tono
 */
import java.util.ArrayList;
public class Cuenta {
    private String titulo, usuario, contrasena;
    ArrayList<Cuenta> cuentas;
    
    public Cuenta(String titulox, String user, String pass){
        titulo=titulox; usuario=user; contrasena=pass;
        cuentas=new ArrayList();
    }
    public String getTitulo(){
        return titulo;
    }
    public String getUsuario(){
        return usuario;
    }
    public String getPass(){
        return contrasena;
    }
    public void setContrasena(String pass){
        contrasena=pass;
    }
    public ArrayList getAppsInternet(){
        ArrayList<Cuenta> Apps=new ArrayList();
        for(int x=0; x<cuentas.size()-1;x++){
            if(cuentas.get(x).getTitulo().equals("Applicaciones de Internet")){
                Apps.add(cuentas.get(x));
            }
        }
        return Apps;
    }
    public ArrayList getDispositivosE(){
        ArrayList<Cuenta> DispositivosE=new ArrayList();
        for(int x=0; x<cuentas.size()-1;x++){
            if(cuentas.get(x).getTitulo().equals("Dispositivos Electronicos")){
                DispositivosE.add(cuentas.get(x));
            }
        }
        return DispositivosE;
    }
    public ArrayList getMembresia(){
        ArrayList<Cuenta> Membresia=new ArrayList();
        for(int x=0; x<cuentas.size()-1;x++){
            if(cuentas.get(x).getTitulo().equals("Membresia")){
                Membresia.add(cuentas.get(x));
            }
        }
        return Membresia;
    }
    public ArrayList getProductosInfo(){
        ArrayList<Cuenta> ProductosInfo=new ArrayList();
        for(int x=0; x<cuentas.size()-1;x++){
            if(cuentas.get(x).getTitulo().equals("Informacion de Productos")){
                ProductosInfo.add(cuentas.get(x));
            }
        }
        return ProductosInfo;
    }
}
