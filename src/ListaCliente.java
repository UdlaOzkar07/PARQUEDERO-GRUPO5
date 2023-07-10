import java.util.ArrayList;
import java.util.List;

public class ListaCliente {
    private List<Cliente> clientes;

    public ListaCliente() {
        clientes = new ArrayList<>();

        clientes.add(new Cliente("9999999999999","R","Consumidor final","","consumidorfinal@correo.com","0984694855","NA"));
    }

    public List<Cliente> listarClientes() {
        return clientes;
    }
    public void agregarCliente(Cliente cliente){
        clientes.add(cliente);
    }
    public void eliminarCliente(int index){
        clientes.remove(index);
    }
    public void actualizarCliente(Cliente cliente, int index){
        clientes.set(index,cliente);
    }
}
