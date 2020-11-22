package pflorindo.tfg.buysales.data;

public class Usuario {

    public static Usuario currentUser = null;

    String nombre,apellidos,clave,email;

    public Usuario(String nombre, String apellidos, String clave, String email) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.clave = clave;
        this.email = email;
    }

    public String getContraseña() {
        return clave;
    }


    public String getNombre() {
        return nombre;
    }


    public String getApellidos() {
        return apellidos;
    }

    public String getEmail() {
        return email;
    }



}
