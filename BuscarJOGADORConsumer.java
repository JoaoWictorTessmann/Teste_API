import java.net.HttpURLConnection;
import java.net.URL;
import java.io.BufferedReader;
import java.io.InputStreamReader;

public class BuscarJOGADORConsumer {
        public void BuscarJogador(String id) {
                try {
                        String sURLTexto = "https://api.opendota.com/api/players/" + id;
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
                System.out.println("\nJogador: ");
                if (json.contains("\"account_id\":")) {
                        String idConta = extrairCampo(json, "account_id");
                        System.out.println("ID da Conta: " + idConta);
                }
                if (json.contains("\"steamid\":")) {
                        String idSteam = extrairCampo(json, "steamid");
                        System.out.println("ID da Steam: " + idSteam);
                }
                if (json.contains("\"personaname\":")) {
                        String nomePerso = extrairCampo(json, "personaname");
                        System.out.println("Nome Do Personagem: " + nomePerso);
                }
                if (json.contains("\"computed_rating\":")) {
                        String mmr = extrairCampo(json, "computed_rating");
                        System.out.println("MMR do Jogador: " + mmr);
                }
                if (json.contains("\"rank_tier\":")) {
                        String rank = extrairCampo(json, "rank_tier");
                        System.out.println("Rank do Jogador: " + rank);
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