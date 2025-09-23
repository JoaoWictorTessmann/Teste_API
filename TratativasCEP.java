public class TratativasCEP {
    Validacoes validacoes;
    public void TratativaCEP(Validacoes validacoes) {
        System.out.println("Qual o numero do CEP: ");
        String numeroCEP = validacoes.scanner.nextLine();
        validacoes.buscaCep.buscarCEP(numeroCEP);
        validacoes.contador.contarCEP();
        validacoes.historico.adicionarCEP(numeroCEP);
    }
}
