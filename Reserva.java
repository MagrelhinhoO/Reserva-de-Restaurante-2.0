public class Reserva {
    private String nome;
    private String data;
    private String horario;
    private int numPessoas;

    public Reserva(String nome, String data, String horario, int numPessoas) {
        this.nome = nome;
        this.data = data;
        this.horario = horario;
        this.numPessoas = numPessoas;
    }

    public void exibirReserva() {
        System.out.println("Nome: " + nome + ", Data: " + data + ", Horário: " + horario + ", Pessoas: " + numPessoas);
    }
}