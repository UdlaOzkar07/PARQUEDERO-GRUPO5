import java.util.ArrayList;
import java.util.List;

public class ListaUsuario {
    private List<Usuario> usuarios;

    public ListaUsuario() {
        usuarios = new ArrayList<>();
        usuarios.add(new Usuario("admin","admin","Administrador","admin@outlook.com"));
    }
    public List<Usuario> listarUsuarios() {
        return usuarios;
    }
    public void agregarUsuario(Usuario usuario){
        usuarios.add(usuario);
    }
    public void eliminarUsuario(int index){
        usuarios.remove(index);
    }
    public void actualizarUsuario(Usuario usuario, int index){
        usuarios.set(index,usuario);
    }
    public Usuario obtenerUsuario(int index){
        return  usuarios.get(index);
    }
    public Usuario buscarId(String usuario){
        for (Usuario usr: usuarios){
            if (usuario.compareTo(usr.getIdUsuario())==0)
                return usr;
        }
        return null;
    }

    public boolean vaidarUsuario(String usuario,String contrasena){
        Usuario user= buscarId(usuario);
        if (user!=null && user.getIdUsuario().compareTo(contrasena)==0){
            return true;
        }else
            return false;
    }
}
