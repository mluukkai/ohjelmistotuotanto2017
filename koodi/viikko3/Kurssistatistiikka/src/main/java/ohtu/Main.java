package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "011120775";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/" + studentNr + "/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();

        System.out.println("json-muotoinen data:");
//        System.out.println( bodyText );

        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);

        int yhteensa = 0;
        double tunnit = 0;
        System.out.println("opiskelijanumero: " + studentNr);
        System.out.println();
        for (Submission submission : subs) {
            System.out.print("Viikko: ");
            System.out.println(submission.getWeek());
            System.out.print(", aikaa kului: ");
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
