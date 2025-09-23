public class TratativasCNPJ {
    Validacoes validacoesCNPJ;
    public void TratativasCNPJ(Validacoes validacoesCNPJ) {
        System.out.println("Qual o numero do CNPJ: ");
        String numeroCNPJ = validacoesCNPJ.scanner.nextLine();
        validacoesCNPJ.buscaCNPJ.buscarCNPJ(numeroCNPJ);
        validacoesCNPJ.contador.contarCNPJ();
        validacoesCNPJ.historico.adicionarCNPJ(numeroCNPJ);
    }
}
