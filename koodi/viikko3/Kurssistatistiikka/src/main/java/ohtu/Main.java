package ohtu;

import com.google.gson.Gson;
import java.io.IOException;
import org.apache.http.client.fluent.Request;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "011120775";
        if ( args.length>0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/"+studentNr+"/submissions";

        String bodyText = Request.Get(url).execute().returnContent().asString();


        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        int tehtYht = 0;
        double tuntYht = 0.0;
        System.out.println("\nOpiskelijanumero: "+studentNr);
        System.out.println("");
        for (Submission submission : subs) {
            System.out.print("Viikko "+submission.getWeek()+": tehtyjä tehtäviä yhteensä: "+submission.getExercises().size()+", aikaa kului "+submission.getHours()+" tuntia, tehdyt tehtävät: ");
            for (Integer exercise : submission.getExercises()) {
                System.out.print(exercise+" ");
            }
            System.out.println("");
            tehtYht += submission.getExercises().size();
            tuntYht += submission.getHours();
        }
        
        System.out.println("");
        System.out.println("yhteensä: "+tehtYht+" tehtävää "+tuntYht+" tuntia");
        
    }
}