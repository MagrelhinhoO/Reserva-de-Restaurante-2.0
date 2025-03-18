// ReservaManager.java
import java.util.ArrayList;
import java.util.Scanner;

public class ReservaManager {
    private ArrayList<Reserva> reservas = new ArrayList<>();
    private Scanner scanner;

    public ReservaManager(Scanner scanner) {
        this.scanner = scanner;
    }

    // Método para agendar reserva
    public void agendarReserva() {
        System.out.println("\n--- Agendar Reserva ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Data (DD/MM/AAAA): ");
        String data = scanner.nextLine();
        System.out.print("Horário (HH:MM): ");
        String horario = scanner.nextLine();

        int numPessoas;
        while (true) {
            System.out.print("Número de pessoas: ");
            if (scanner.hasNextInt()) {
                numPessoas = scanner.nextInt();
                scanner.nextLine(); // Consumir a quebra de linha
                break;
            } else {
                System.out.println("Entrada inválida! Insira um número inteiro.");
                scanner.next(); // Descarta a entrada inválida
            }
        }

        reservas.add(new Reserva(nome, data, horario, numPessoas));
        System.out.println("Reserva feita com sucesso!");
    }

    // Método para visualizar reservas
    public void visualizarReservas() {
        if (reservas.isEmpty()) {
            System.out.println("\nNenhuma reserva encontrada.");
        } else {
            System.out.println("\n--- Lista de Reservas ---");
            for (int i = 0; i < reservas.size(); i++) {
                System.out.print((i + 1) + ". ");
                reservas.get(i).exibirReserva();
            }
        }
    }

    // Método para processar pagamento
    public void processarPagamento() {
        System.out.println("\n--- Pagamento ---");
        System.out.println("Escolha a forma de pagamento:");
        System.out.println("1. Dinheiro");
        System.out.println("2. Cartão de Crédito");
        System.out.println("3. Cartão de Débito");

        int opcaoPagamento;
        while (true) {
            System.out.print("Opção: ");
            if (scanner.hasNextInt()) {
                opcaoPagamento = scanner.nextInt();
                scanner.nextLine(); // Consumir quebra de linha
                if (opcaoPagamento >= 1 && opcaoPagamento <= 3) {
                    break; // Entrada válida
                }
            } else {
                scanner.next(); // Descarta entrada inválida
            }
            System.out.println("Opção inválida. Tente novamente.");
        }

        FormaPagamento formaPagamento = switch (opcaoPagamento) {
            case 1 -> FormaPagamento.DINHEIRO;
            case 2 -> FormaPagamento.CARTAO_CREDITO;
            case 3 -> FormaPagamento.CARTAO_DEBITO;
            default -> throw new IllegalStateException("Opção inválida");
        };

        System.out.println("Pagamento realizado com sucesso via " + formaPagamento + "!");
    }
}
