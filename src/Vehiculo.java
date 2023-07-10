import java.sql.Time;
import java.util.Date;

public class Vehiculo {
    private String placa;
    private String tipoVehiculo;
    private String marca;

    public Vehiculo(String placa, String tipoVehiculo, String marca) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }
    public String getMarca() {
        return marca;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public void setMarca(String marca) {
        this.tipoVehiculo = marca;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", tipoVehiculo='" + tipoVehiculo + '\'' +
                ", marca=" + marca +
                '}';
    }
}
