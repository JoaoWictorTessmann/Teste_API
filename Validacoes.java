import java.util.Scanner;

public class Validacoes {
    Scanner scanner = new Scanner(System.in);
    public TratativasCEP TrataCEP;
    public TratativasJogador TrataJog;
    public TratativasCNPJ TrataCNPJ;
    ContadorDeAPIs contador = new ContadorDeAPIs();
    HistoricoDeBusca historico = new HistoricoDeBusca();
    BuscarCNPJConsumer buscaCNPJ = new BuscarCNPJConsumer();
    BuscarJOGADORConsumer buscaJogador = new BuscarJOGADORConsumer();
    BuscarCEPConsumer buscaCep = new BuscarCEPConsumer();
}
