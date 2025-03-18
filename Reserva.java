import java.time.LocalDate;
import java.time.LocalTime;

public class Reserva implements ICancelavel {
    protected Cliente cliente;
    protected LocalDate data;
    protected LocalTime horario;
    protected int numPessoas;
    protected StatusReserva status;

    public Reserva(Cliente cliente, LocalDate data, LocalTime horario, int numPessoas) {
        this.cliente = cliente;
        this.data = data;
        this.horario = horario;
        this.numPessoas = numPessoas;
        this.status = StatusReserva.CONFIRMADA;
    }

    public void exibirReserva() {
        System.out.println("Reserva de " + cliente.getNome() + " | Data: " + data + " | Horário: " + horario + " | Status: " + status);
    }

    @Override
    public void cancelarReserva() {
        this.status = StatusReserva.CANCELADA;
        System.out.println("Reserva cancelada com sucesso.");
    }
}