import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BuscarCEPConsumer {

        public void buscarCEP(String cep) {
                try {
                        String sURLTexto = "https://brasilapi.com.br/api/cep/v2/" + cep;
                        URL url = new URL(sURLTexto);
                        HttpURLConnection conexao = (HttpURLConnection) url.openConnection();

                        conexao.setRequestMethod("GET");
                        BufferedReader leitorLinha = new BufferedReader(
                                        new InputStreamReader(conexao.getInputStream()) {
                                        });

                        String sLinha;
                        StringBuilder resposta = new StringBuilder();
                        while ((sLinha = leitorLinha.readLine()) != null) {
                                resposta.append(sLinha);
                        }

                        leitorLinha.close();

                        String json = resposta.toString();
                        System.out.println("Resposta da API: " + json);

                        extrairDados(json);

                } catch (Exception erro) {
                        System.out.println("Erro: " + erro.getMessage());
                }
        }

        private void extrairDados(String json) {
                System.out.println("\nDados Endereco:");
                if (json.contains("\"cep\":")) {
                        String cep = extrairCampo(json, "cep");
                        System.out.println("CEP: " + cep);
                }
                if (json.contains("\"street\":")) {
                        String rua = extrairCampo(json, "street");
                        System.out.println("Rua: " + rua);
                }
                if (json.contains("\"state\":")) {
                        String estado = extrairCampo(json, "state");
                        System.out.println("Estado: " + estado);
                }
                if (json.contains("\"city\":")) {
                        String cidade = extrairCampo(json, "city");
                        System.out.println("Cidade: " + cidade);
                }
                if (json.contains("\"neighborhood\":")) {
                        String bairro = extrairCampo(json, "neighborhood");
                        System.out.println("Bairro: " + bairro);
                }
        }

        private String extrairCampo(String json, String campo) {
                String buscar = "\"" + campo + "\":\"";
                int iInicio = json.indexOf(buscar);
                if (iInicio == -1) {
                        return "Errou! Não existe";
                }
                iInicio += buscar.length();

                int iFim = json.indexOf("\"", iInicio);
                return json.substring(iInicio, iFim);
        }

        public static void main(String[] args) {
                BuscarCEPConsumer busca = new BuscarCEPConsumer();
                busca.buscarCEP("89136000");
        }
}