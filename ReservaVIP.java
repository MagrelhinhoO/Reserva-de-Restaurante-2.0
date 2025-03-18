import java.time.LocalDate;
import java.time.LocalTime;

public class ReservaVip extends Reserva {
    private String areaEspecial;

    public ReservaVip(Cliente cliente, LocalDate data, LocalTime horario, int numPessoas, String areaEspecial) {
        super(cliente, data, horario, numPessoas);
        this.areaEspecial = areaEspecial;
    }

    @Override
    public void exibirReserva() {
        System.out.println("[VIP] Reserva de " + cliente.getNome() + " | Data: " + data + " | Área: " + areaEspecial);
    }
}