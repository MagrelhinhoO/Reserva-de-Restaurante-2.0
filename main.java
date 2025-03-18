import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    private static ArrayList<Reserva> reservas = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);

    private static void agendarReserva() {
        System.out.println("\n--- Agendar Reserva ---");
        System.out.print("Nome do Cliente: ");
        String nome = scanner.nextLine();
        System.out.print("Telefone: ");
        String telefone = scanner.nextLine();
        Cliente cliente = new Cliente(nome, telefone);

        // Solicitar data usando LocalDate
        LocalDate data = null;
        while (data == null) {
            System.out.print("Data (Formato: YYYY-MM-DD): ");
            try {
                data = LocalDate.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Formato inválido. Use YYYY-MM-DD.");
            }
        }

        // Solicitar horário usando LocalTime
        LocalTime horario = null;
        while (horario == null) {
            System.out.print("Horário (Formato: HH:MM): ");
            try {
                horario = LocalTime.parse(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Formato inválido. Use HH:MM.");
            }
        }

        System.out.print("Número de pessoas: ");
        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, insira um número válido: ");
            scanner.next();
        }
        int numPessoas = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Deseja uma reserva VIP? (S/N): ");
        String vip = scanner.nextLine().toUpperCase();

        if (vip.equals("S")) {
            System.out.print("Área Especial (Ex: Varanda, Sala VIP): ");
            String areaEspecial = scanner.nextLine();
            reservas.add(new ReservaVip(cliente, data, horario, numPessoas, areaEspecial));
        } else {
            reservas.add(new Reserva(cliente, data, horario, numPessoas));
        }

        System.out.println("Reserva feita com sucesso!");
    }

    private static void visualizarReservas() {
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

    private static void cancelarReserva() {
        if (reservas.isEmpty()) {
            System.out.println("\nNenhuma reserva para cancelar.");
            return;
        }

        visualizarReservas();
        System.out.print("\nDigite o número da reserva para cancelar: ");

        while (!scanner.hasNextInt()) {
            System.out.print("Por favor, insira um número válido: ");
            scanner.next();
        }
        int indice = scanner.nextInt();
        scanner.nextLine();

        if (indice < 1 || indice > reservas.size()) {
            System.out.println("Número inválido.");
            return;
        }

        Reserva reserva = reservas.get(indice - 1);
        reserva.cancelarReserva();
    }

    private static void processarPagamento() {
        System.out.println("\n--- Pagamento ---");
        System.out.println("Pagamento realizado com sucesso!");
    }

    public static void main(String[] args) {
        int opcao;
        do {
            System.out.println("\n--- Restaurante - Sistema de Reservas ---");
            System.out.println("1. Agendar Reserva");
            System.out.println("2. Visualizar Reservas");
            System.out.println("3. Cancelar Reserva");
            System.out.println("4. Pagamento");
            System.out.println("5. Sair");
            System.out.print("Escolha uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, insira um número válido: ");
                scanner.next();
            }
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    agendarReserva();
                    break;
                case 2:
                    visualizarReservas();
                    break;
                case 3:
                    cancelarReserva();
                    break;
                case 4:
                    processarPagamento();
                    break;
                case 5:
                    System.out.println("\nSaindo do sistema...");
                    break;
                default:
                    System.out.println("\nOpção inválida! Tente novamente.");
            }
        } while (opcao != 5);

        scanner.close();
    }
}
