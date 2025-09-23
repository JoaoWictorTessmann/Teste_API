public class TratativasCEP {
    Validacoes validacoesCEP;
    public void TratativaCEP(Validacoes validacoesCEP) {
        System.out.println("Qual o numero do CEP: ");
        String numeroCEP = validacoesCEP.scanner.nextLine();
        validacoesCEP.buscaCep.buscarCEP(numeroCEP);
        validacoesCEP.contador.contarCEP();
        validacoesCEP.historico.adicionarCEP(numeroCEP);
    }
}
