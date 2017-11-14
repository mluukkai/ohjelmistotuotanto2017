package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "011120775";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/" + studentNr + "/submissions";
        String url2 = "https://studies.cs.helsinki.fi/ohtustats/courseinfo";
        

        String bodyText = Request.Get(url).execute().returnContent().asString();
        String bodyText2 = Request.Get(url2).execute().returnContent().asString();
        
        String statsResponse = "https://studies.cs.helsinki.fi/ohtustats/stats";
        JsonParser parser = new JsonParser();
        JsonObject parsittuData = parser.parse(statsResponse).getAsJsonObject();
        System.out.println("parsittu data");
//        parsittuData.toString();

        System.out.println("json-muotoinen data:");
        System.out.println( bodyText );
        System.out.println(bodyText2);

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        Gson mapper2 = new Gson();
        
        Course course = mapper2.fromJson(bodyText2, Course.class);
        
        System.out.println("Kurssi: " + course.getName() + ", " + course.getTerm());
        System.out.println();

        int yhteensa = 0;
        double tunnit = 0;
        System.out.println("Opiskelijanumero: " + studentNr);
        System.out.println();
        for (Submission submission : subs) {
            System.out.print("Viikko: ");
            System.out.println(submission.getWeek());
            System.out.print("\t, aikaa kului: ");
            System.out.print(submission.getHours());
            tunnit += submission.getHours();
            System.out.print(", tehdyt tehtävät: ");
            System.out.print(submission.getExercises());
            yhteensa += submission.getExercises().size();
            System.out.println();
        }
        System.out.println();
        System.out.println("Yhteensä kului " + yhteensa + " tuntia ja tehtäviä tuli tehtyä " + tunnit);

    }
}
