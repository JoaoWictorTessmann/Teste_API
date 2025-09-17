import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int numeroEscolhido = 0;

        while (numeroEscolhido != 4) {

            System.out.println("+--+--+--+--+--+--+--+--+--+\n");
            System.out.println("1º Buscar CEP\n");
            System.out.println("2º Buscar TOP JOGADORES\n");
            System.out.println("3º Buscar CNPJ\n");
            System.out.println("4º Sair\n");
            System.out.println("+--+--+--+--+--+--+--+--+--+\n");
            System.out.println("Escolha uma opção: ");

            numeroEscolhido = scanner.nextInt();
            scanner.nextLine();

            switch (numeroEscolhido) {
                case 1:
                    BuscarCEPConsumer buscaCep = new BuscarCEPConsumer();
                    System.out.println("Qual o numero do CEP: ");
                    String numeroCEP = scanner.nextLine();
                    buscaCep.buscarCEP(numeroCEP);
                    break;
                case 2:
                    BuscarJOGADORConsumer buscaJogador = new BuscarJOGADORConsumer();
                    System.out.println("Qual o ID do jogador: ");
                    String idJogador = scanner.nextLine();
                    buscaJogador.BuscarJogador(idJogador);
                    break;
                case 3:
                    BuscarCNPJConsumer buscaCNPJ = new BuscarCNPJConsumer();
                    System.out.println("Qual o numero do CNPJ: ");
                    String numeroCNPJ = scanner.nextLine();
                    buscaCNPJ.buscarCNPJ(numeroCNPJ);
                    break;
                case 4:
                    System.out.println("Sistema Encerrado!");
                    System.exit(numeroEscolhido);
                    break;
            }
        }
    }
}