import java.sql.Time;
import java.util.Date;

public class IngresoVehiculo {
    private int id;
    private String placa;
    private Date fecha;
    private Time horaEntrada;
    private Time horaSalida;
    private double valor;
    private boolean cancelado;

    public IngresoVehiculo(int id, String placa, Date fecha, Time horaEntrada, Time horaSalida, double valor, boolean cancelado) {
        this.id = id;
        this.placa = placa;
        this.fecha = fecha;
        this.horaEntrada = horaEntrada;
        this.horaSalida = horaSalida;
        this.valor = valor;
        this.cancelado = cancelado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(Time horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public Time getHoraSalida() {
        return horaSalida;
    }

    public void setHoraSalida(Time horaSalida) {
        this.horaSalida = horaSalida;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public boolean isCancelado() {
        return cancelado;
    }

    public void setCancelado(boolean cancelado) {
        this.cancelado = cancelado;
    }
}
