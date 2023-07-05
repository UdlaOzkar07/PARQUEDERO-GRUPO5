import java.util.ArrayList;
import java.util.List;

public class ListaVehiculo {
    List<Vehiculo> vehiculos;

    public ListaVehiculo() {
        vehiculos = new ArrayList<>();
    }

    public List<Vehiculo> mostrarVehiculos() {
        return vehiculos;
    }

    public void agregarVehiculo(Vehiculo vehiculo){
        vehiculos.add(vehiculo);
    }
    public void eliminarVehiculo(int index)
    {
        vehiculos.remove(index);
    }

    public void modificarVehiculo(Vehiculo vehiculo,int index){
        vehiculos.set(index, vehiculo);
    }
}
