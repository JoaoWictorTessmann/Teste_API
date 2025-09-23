public class Menu {
    public static void main(String[] args) {
        Validacoes validacoes = new Validacoes();
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

            numeroEscolhido = validacoes.scanner.nextInt();
            validacoes.scanner.nextLine();

            switch (numeroEscolhido) {
                case 1:
                    validacoes.TrataCEP.TratativaCEP();
                    break;
                case 2:
                    validacoes.TrataJog.TratativasJogador();
                    break;
                case 3:
                    validacoes.TrataCNPJ.TratativasCNPJ();
                    break;
                case 4:
                    System.out.println("A busca de CEP foi realizada: " + validacoes.contador.getContadorCEP() + " vezes!");
                    System.out.println("A busca de Jogadores foi realizada: " + validacoes.contador.getContadorJog() + " vezes!");
                    System.out.println("A busca de CNPJ foi realizada: " + validacoes.contador.getContadorCNPJ() + " vezes!");
                    break;
                case 5:
                    System.out.println(validacoes.historico.getHistorico());
                    break;
                case 6:
                    
                    break;
                case 7:
                    System.out.println("Sistema Encerrado!");
                    System.exit(numeroEscolhido);
                    break;
            }
        }
    }
}