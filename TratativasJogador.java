public class TratativasJogador {
    Validacoes validacoesJog;
    public void TratativasJogador(Validacoes validacoesJog) {
        System.out.println("Qual o numero do Jogador: ");
        String numeroJog = validacoesJog.scanner.nextLine();
        validacoesJog.buscaJogador.BuscarJogador(numeroJog);
        validacoesJog.contador.contarJog();
        validacoesJog.historico.adicionarJog(numeroJog);
    }
}
