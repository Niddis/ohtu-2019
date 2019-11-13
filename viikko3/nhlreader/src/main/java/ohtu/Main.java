package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import java.text.SimpleDateFormat;
import static java.util.Arrays.sort;
import java.util.Date;
import org.apache.http.client.fluent.Request;

public class Main {
    public static void main(String[] args) throws IOException{
        String url = "https://nhlstatisticsforohtu.herokuapp.com/players";
        
        String bodyText = Request.Get(url).execute().returnContent().asString();
        
        //System.out.println("json-muotoinen data:");
        //System.out.println(bodyText);
        
        Gson mapper = new Gson();
        Player[] players = mapper.fromJson(bodyText, Player[].class);
        sort(players);
        
        String date = new SimpleDateFormat("dd-MM-yy").format(new Date());
        
        System.out.println("Suomalaiset pelaajat " + date);
        for (Player player : players) {
            if (player.getNationality().equals("FIN")) {
                System.out.println(player);
            }           
        }
    }
}
