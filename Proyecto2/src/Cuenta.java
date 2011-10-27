/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Tono
 */
public class Cuenta {
    private String titulo, usuario, contrasena;
    
    public Cuenta(String title, String user, String pass){
        titulo=title; usuario=user; contrasena=pass;
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
    public void agregarCampo(String nombre, String valor){
        
    }
}
