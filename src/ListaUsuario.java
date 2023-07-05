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
}
