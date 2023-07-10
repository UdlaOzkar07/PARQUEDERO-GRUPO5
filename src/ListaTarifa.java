import java.util.ArrayList;
import java.util.List;

public class ListaTarifa {
    private List<Tarifa> tarifas;

    public ListaTarifa() {
        tarifas = new ArrayList<>();
        tarifas.add(new Tarifa(1,"Vehículo",1.00));
        tarifas.add(new Tarifa(2,"Motocicleta",0.50));
    }

    public List<Tarifa> listarTarifas() {
        return tarifas;
    }
    public void agregarTarifa(Tarifa tarifa){
        tarifas.add(tarifa);
    }
    public void eliminarTarifa(int index){
        tarifas.remove(index);
    }
    public void actualizarTarifa(Tarifa tarifa, int index){
        tarifas.set(index,tarifa);
    }
    public Tarifa obtenerTarifa(int index){
        return  tarifas.get(index);
    }
}
