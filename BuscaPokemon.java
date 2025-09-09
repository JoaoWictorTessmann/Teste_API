import java.net.URL;
import javax.net.ssl.HttpsURLConnection;

public class BuscaPokemon {
        public void buscar (String pokemon){
            try{
               // Atribui a String link para a palavra "link" e adiciona o ".toLowerCase()" para deixar a escrita tudo em minusculo
               String link = " https://pokeapi.co/api/v2/pokemon/" + pokemon.toLowerCase();              
               URL url = new URL (link); //Estancia a string que possui o link
               HttpsURLConnection conexao = (HttpsURLConnection) url.openConnection(); //Usa "HttpsURLConnection" para buscar a conexao, e o ".openConnection()" para conectar

               conexao.setRequestMethod("GET"); //Qual o metodo, GET_POST_DELETE_PUT
               conexao.setRequestProperty("Accept", "application/json");
               //Aqui o "Accept" é utilizado pra dizer que estou aceitando o retorno(Normalmente usado em Metodo "GET")
               //No "Value" é a forma que vai ser retornada, nesse caso retorna um arquivo JSON

               int status = conexao.getResponseCode();
               System.out.println("Status: " + status);

            } catch (Exception e){
                System.out.println("Erro: " + e.getMessage());
            }
        }

    private String extrairCampo(String json, String campo){

    }

    private static void main(String[] args){
        BuscaPokemon consumer = new BuscaPokemon();
        consumer.buscar("pikachu");
    }
}
