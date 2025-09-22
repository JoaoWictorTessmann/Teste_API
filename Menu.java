import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContadorDeAPIs contador = new ContadorDeAPIs();
        HistoricoDeBusca historico = new HistoricoDeBusca();
        int numeroEscolhido = 0;

        while (numeroEscolhido != 7) {

            System.out.println("+--+--+--+--+--+--+--+--+--+\n");
            System.out.println("1º Buscar CEP\n");
            System.out.println("2º Buscar JOGADOR\n");
            System.out.println("3º Buscar CNPJ\n");
            System.out.println("4º Mostrar Contadores de busca");
            System.err.println("5º Mostrar Histórico de Consultas");
            System.err.println("6º Consultar tudo junto");
            System.out.println("7º Sair\n");
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
                    contador.contarCEP();
                    historico.adicionarCEP(numeroCEP);
                    break;
                case 2:
                    BuscarJOGADORConsumer buscaJogador = new BuscarJOGADORConsumer();
                    System.out.println("Qual o ID do jogador: ");
                    String idJogador = scanner.nextLine();
                    buscaJogador.BuscarJogador(idJogador);
                    contador.contarJog();
                    historico.adicionarJog(idJogador);
                    break;
                case 3:
                    BuscarCNPJConsumer buscaCNPJ = new BuscarCNPJConsumer();
                    System.out.println("Qual o numero do CNPJ: ");
                    String numeroCNPJ = scanner.nextLine();
                    buscaCNPJ.buscarCNPJ(numeroCNPJ);
                    contador.contarCNPJ();
                    historico.adicionarCNPJ(numeroCNPJ);
                    break;
                case 4:
                    System.out.println("A busca de CEP foi realizada: " + contador.getContadorCEP() + " vezes!");
                    System.out.println("A busca de Jogadores foi realizada: " + contador.getContadorJog() + " vezes!");
                    System.out.println("A busca de CNPJ foi realizada: " + contador.getContadorCNPJ() + " vezes!");
                    break;
                case 5:
                    System.out.println(historico.getHistorico());
                    break;
                case 6:
                    System.out.println("Sistema Encerrado!");
                    System.exit(numeroEscolhido);
                    break;
            }
        }
    }
}