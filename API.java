import org.json.JSONObject;

import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.*;
/*
 * This class calls a Hearthstone API to gather up to date
 * information about cards, classes and sets from the game
 * Updated on 2/15/2021
 * @author jtw5477 Jayson Williamson
 */


public class API {
    public static void getHearthstoneInfo(){
        try {
            //Connects to the desired endpointS
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create("https://omgvamp-hearthstone-v1.p.rapidapi.com/info"))
                    .header("x-rapidapi-key", "4d8bcf4474msh9e0ef762eb76f3bp1886d1jsn8339e1ed14cc")
                    .header("x-rapidapi-host", "omgvamp-hearthstone-v1.p.rapidapi.com")
                    .method("GET", HttpRequest.BodyPublishers.noBody())
                    .build();
            HttpResponse<String> response = HttpClient.newHttpClient().send(request, HttpResponse.BodyHandlers.ofString());
            //Print out all the info available currently in game about cards, classes, sets etc.
            System.out.println(response.body());

        } catch(Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
