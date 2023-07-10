import java.util.ArrayList;
import java.util.List;
public class Grafo {
    private int numVertices;
    private List<List<Vehiculo>> adyacencia;

    public Grafo(int numVertices) {
        this.numVertices = numVertices;
        this.adyacencia = new ArrayList<>();

        for (int i = 0; i < numVertices; i++) {
            adyacencia.add(new ArrayList<>());
        }
    }

    public void agregarArista(int origen, int destino, Vehiculo vehiculo) {
        adyacencia.get(origen).add(vehiculo);
        adyacencia.get(destino).add(vehiculo);
    }

    public void imprimirGrafo() {
        for (int i = 0; i < numVertices; i++) {
            System.out.print("Vértice " + i + ": ");
            for (Vehiculo vehiculo : adyacencia.get(i)) {
                System.out.print(vehiculo + " ");
            }
            System.out.println();
        }
    }
}
