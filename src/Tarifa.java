public class Tarifa {
    private int idTarifa;
    private String tipoVehiculo;
    private double valorTarifa;

    public Tarifa(int idTarifa, String tipoVehiculo, double valorTarifa) {
        this.idTarifa = idTarifa;
        this.tipoVehiculo = tipoVehiculo;
        this.valorTarifa = valorTarifa;
    }

    public int getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(int idTarifa) {
        this.idTarifa = idTarifa;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public double getValorTarifa() {
        return valorTarifa;
    }

    public void setValorTarifa(double valorTarifa) {
        this.valorTarifa = valorTarifa;
    }

    @Override
    public String toString() {
        return "Tarifa{" +
                "idTarifa=" + idTarifa +
                ", tipoVehiculo='" + tipoVehiculo + '\'' +
                ", valorTarifa=" + valorTarifa +
                '}';
    }
}
