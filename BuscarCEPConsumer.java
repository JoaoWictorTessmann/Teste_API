import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BuscarCEPConsumer{

        public void buscarCEP(String cep){
            try {
                String sURLTexto = "https://brasilapi.com.br/api/cep/v2/" + cep;
                URL url = new URL(sURLTexto);
                HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

                conexao.setRequestMethod("GET");
                BufferedReader leitorLinha = new BufferedReader(new InputStreamReader(conexao.getInputStream()){});

                String sLinha;
                StringBuilder resposta = new StringBuilder();
                while ((sLinha = leitorLinha.readLine()) != null){
                        resposta.append(sLinha);
                }

                leitorLinha.close();

                String json = resposta.toString();
                System.out.println("Resposta da API: " + json);

            } catch (Exception erro) {
                System.out.println("Erro: " + erro.getMessage());
            }
        }

        public static void main (String[] args){
                BuscarCEPConsumer busca = new BuscarCEPConsumer();
                busca.buscarCEP("89136000");
        }
}