import java.util.ArrayList;

public class HistoricoDeBusca {
    private ArrayList<String> armazenarBuscas = new ArrayList<>();

    public void adicionarCEP(String cep){
        armazenarBuscas.add("Foi pesquisado o CEP: " + cep);
    }

    public void adicionarJog(String JOGADOR){
        armazenarBuscas.add("Foi pesquisado o Jogador: " + JOGADOR);
    }

    public void adicionarCNPJ(String CNPJ){
        armazenarBuscas.add("Foi pesquisado o CNPJ: " + CNPJ);
    }

    public ArrayList<String> getHistorico(){
        return armazenarBuscas;
    }
}
