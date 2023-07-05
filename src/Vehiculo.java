import java.sql.Time;
import java.util.Date;

public class Vehiculo {
    private String placa;
    private String tipoVehiculo;
    private Date fecha;
    private Time horaEntrada;
    private Time horaSalida;

    public Vehiculo(String placa, String tipoVehiculo, Date fecha, Time horaEntrada, Time horaSalida) {
        this.placa = placa;
        this.tipoVehiculo = tipoVehiculo;
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
    }

    public String getPlaca() {
        return placa;
    }

    public String getTipoVehiculo() {
        return tipoVehiculo;
    }

    public Date getFecha() {
        return fecha;
    }

    public Time getHoraEntrada() {
        return horaEntrada;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public void setTipoVehiculo(String tipoVehiculo) {
        this.tipoVehiculo = tipoVehiculo;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setHoraEntrada(Time horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    @Override
    public String toString() {
        return "Vehiculo{" +
                "placa='" + placa + '\'' +
                ", tipoVehiculo='" + tipoVehiculo + '\'' +
                ", fecha=" + fecha +
                ", horaEntrada=" + horaEntrada +
                ", horaSalida=" + horaSalida +
                '}';
    }
}
