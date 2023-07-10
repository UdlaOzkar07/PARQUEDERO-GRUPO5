import java.util.List;

public class ListaIngresoVehiculo {
    private List<IngresoVehiculo> ingresoVehiculos;

    public List<IngresoVehiculo> listarIngresoVehiculos() {
        return ingresoVehiculos;
    }
    public void agregarIngresoVehiculo(IngresoVehiculo IngresoVehiculo){
        ingresoVehiculos.add(IngresoVehiculo);
    }
    public void eliminarIngresoVehiculo(int index){
        ingresoVehiculos.remove(index);
    }
    public void actualizarIngresoVehiculo(IngresoVehiculo IngresoVehiculo, int index){
        ingresoVehiculos.set(index,IngresoVehiculo);
    }
    public IngresoVehiculo obtenerIngresoVehiculo(int index){
        return  ingresoVehiculos.get(index);
    }
}
