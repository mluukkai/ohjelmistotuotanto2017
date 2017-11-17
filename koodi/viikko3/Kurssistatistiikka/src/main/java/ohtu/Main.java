package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "014689116";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/" + studentNr + "/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

//        System.out.println("json-muotoinen data:");
//        System.out.println( bodyText );
        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        String kurssidataURL = "https://studies.cs.helsinki.fi/ohtustats/courseinfo";
        String bodyKurssidata = Request.Get(kurssidataURL).execute().returnContent().asString();

        Gson kurssiMapper = new Gson();

        CourseData data = kurssiMapper.fromJson(bodyKurssidata, CourseData.class);

        System.out.println("Kurssi: " + data.getName() + ", " + data.getTerm() + "\n");

        int index = 0;
        int totalDone = 0;
        int totalHours = 0;
        System.out.println("opiskelijanumero: " + studentNr);
        for (Submission submission : subs) {
            submission.setMax(data.getExercises().get(index));
            System.out.println(submission);
            totalDone = totalDone + submission.getExercises().size();
            totalHours = totalHours + submission.getHours();
            index++;
        }

        System.out.println("\n" + "yhteensä: " + totalDone + " tehtävää " + totalHours + " tuntia");

        String statsUrl = "https://studies.cs.helsinki.fi/ohtustats/stats";
        
        String statsResponse = Request.Get(statsUrl).execute().returnContent().asString();

        JsonParser parser = new JsonParser();
        JsonObject parsittuData = parser.parse(statsResponse).getAsJsonObject();
        
        //System.out.println(parsittuData);
        
        
        
        int palautettujaTehtavia = Integer.parseInt(parsittuData.entrySet().toArray()[0].toString().split(",")[2].split(":")[1].toString()) + Integer.parseInt(parsittuData.entrySet().toArray()[1].toString().split(",")[2].split(":")[1].toString()) + Integer.parseInt(parsittuData.entrySet().toArray()[2].toString().split(",")[2].split(":")[1].toString());
        
        int palautustenMaara = Integer.parseInt(parsittuData.entrySet().toArray()[0].toString().split(",")[0].split(":")[1].toString() + Integer.parseInt(parsittuData.entrySet().toArray()[1].toString().split(",")[0].split(":")[1].toString()) + Integer.parseInt(parsittuData.entrySet().toArray()[2].toString().split(",")[0].split(":")[1].toString()));
        
        System.out.println("");
        System.out.println("Kurssilla on yhteensä: " + palautustenMaara + " palautusta, palautettuja tehtäviä " + palautettujaTehtavia);
        

    }
}
