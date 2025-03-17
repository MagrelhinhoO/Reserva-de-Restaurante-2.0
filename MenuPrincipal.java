import java.util.Scanner;

public class MenuPrincipal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ReservaManager reservaManager = new ReservaManager(scanner);

        int opcao;
        do {
            System.out.println("\n--- Restaurante - Sistema de Reservas ---");
            System.out.println("1. Agendar Reserva");
            System.out.println("2. Visualizar Reservas");
            System.out.println("3. Pagamento");
            System.out.println("4. Sair");
            System.out.print("Escolha uma opção: ");

            while (!scanner.hasNextInt()) {
                System.out.print("Por favor, insira um número válido: ");
                scanner.next(); // Limpa a entrada inválida
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a quebra de linha

            switch (opcao) {
                case 1 -> reservaManager.agendarReserva();
                case 2 -> reservaManager.visualizarReservas();
                case 3 -> reservaManager.processarPagamento();
                case 4 -> System.out.println("\nSaindo do sistema... Obrigado!");
                default -> System.out.println("\nOpção inválida! Tente novamente.");
            }
        } while (opcao != 4);

        scanner.close();
    }
}