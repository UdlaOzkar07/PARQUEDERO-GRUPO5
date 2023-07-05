public class Usuario {
    private String idUsuario;
    private String clave;
    private String nombre;
    private String correo;
    public Usuario(String idUsuario, String clave,String nombre, String correo) {
        this.idUsuario = idUsuario;
        this.clave = clave;
        this.nombre = nombre;
        this.correo = correo;
    }
    public String getIdUsuario() {
        return idUsuario;
    }

    public String getClave() {
        return clave;
    }

    public String getNombre() {
        return nombre;
    }
    public String getCorreo() {
        return correo;
    }
    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "\tId. Usuario: '" + idUsuario + "' " + "\tContraseña: '" + clave + "'" +"\tNombre: '" + nombre + "'" + "\tCorreo: '" + correo + "'";
    }
}
