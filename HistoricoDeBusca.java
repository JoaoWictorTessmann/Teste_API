import java.util.ArrayList;
import java.util.List;

public class HistoricoDeBusca {

    private ArrayList<String> armazenarBuscas = new ArrayList<>();

    public void adicionarCEP(String cep) {
        armazenarBuscas.add("Foi pesquisado o CEP: " + cep);
    }

    public void adicionarJog(String JOGADOR) {
        armazenarBuscas.add("Foi pesquisado o Jogador: " + JOGADOR);
    }

    public void adicionarCNPJ(String CNPJ) {
        armazenarBuscas.add("Foi pesquisado o CNPJ: " + CNPJ);
    }

    public List<String> getHistorico() {
        int tamanho = armazenarBuscas.size();
        int inicio = Math.max(0, tamanho - 5);
        return armazenarBuscas.subList(inicio, tamanho);
    }
}
