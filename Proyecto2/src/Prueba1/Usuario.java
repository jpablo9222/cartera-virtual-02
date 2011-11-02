package Prueba1;

/**
 *
 * @author Juan Pablo
 */
public class Usuario  implements java.io.Serializable {
     private Short usuarioId;
     private String usuario;
     private String contrasenia;

    public Usuario(String usuario, String contrasenia) {
       this.usuario = usuario;
       this.contrasenia = contrasenia;
    }
   
    public Short getUsuarioId() {
        return this.usuarioId;
    }
    
    public void setUsuarioId(Short usuarioId) {
        this.usuarioId = usuarioId;
    }
    
    public String getUsuario() {
        return this.usuario;
    }
    
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    
    public String getContrasenia() {
        return this.contrasenia;
    }
    
    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }




}


