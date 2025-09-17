import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class BuscarCNPJConsumer {
    public void buscarCNPJ(String cnpj) {
                try {
                        String sURLTexto = "https://brasilapi.com.br/api/cnpj/v1/" + cnpj;
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
                System.out.println("\nDados do CNPJ:");
                if (json.contains("\"cnpj\":")) {
                        String sCNPJ = extrairCampo(json, "cnpj");
                        System.out.println("CNPJ: " + sCNPJ);
                }
                if (json.contains("\"razao_social\":")) {
                        String nomeEmpresa = extrairCampo(json, "razao_social");
                        System.out.println("Nome da Empresa: " + nomeEmpresa);
                }
                if (json.contains("\"municipio\":")) {
                        String sMunicipio = extrairCampo(json, "municipio");
                        System.out.println("Municipio: " + sMunicipio);
                }
                if (json.contains("\"bairro\":")) {
                        String sBairro = extrairCampo(json, "bairro");
                        System.out.println("Bairro: " + sBairro);
                }
                if (json.contains("\"logradouro\":")) {
                        String sRua = extrairCampo(json, "logradouro");
                        System.out.println("Logradouro: " + sRua);
                }
                if (json.contains("\"numero\":")) {
                        String sNumero = extrairCampo(json, "numero");
                        System.out.println("Numero: " + sNumero);
                }
                
        }

        private String extrairCampo(String json, String campo) {
            // Busca apenas pelo campo, sem assumir tipo
            String buscar = "\"" + campo + "\":";
            int iInicio = json.indexOf(buscar);
            if (iInicio == -1) {
                    return "Errou! Não existe";
            }
            iInicio += buscar.length();

            // Pula espaços em branco
            while (iInicio < json.length() && Character.isWhitespace(json.charAt(iInicio))) {
                    iInicio++;
            }

            // Se começar com aspas, é string
            if (json.charAt(iInicio) == '"') {
                    iInicio++; // pula aspas inicial
                    int iFim = json.indexOf("\"", iInicio);
                    return json.substring(iInicio, iFim);
            } else {
                    // Caso seja número ou booleano, pega até vírgula ou fim de objeto
                    int iFim = json.indexOf(",", iInicio);
                    if (iFim == -1) {
                            iFim = json.indexOf("}", iInicio);
                    }
                    return json.substring(iInicio, iFim).trim();
            }
    }
}
