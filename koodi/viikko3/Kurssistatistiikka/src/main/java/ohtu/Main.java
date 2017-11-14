package ohtu;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import java.io.IOException;
import org.apache.http.client.fluent.Request;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.util.Map;
import java.util.Set;

public class Main {

    public static void main(String[] args) throws IOException {
        // vaihda oma opiskelijanumerosi seuraavaan, ÄLÄ kuitenkaan laita githubiin omaa opiskelijanumeroasi
        String studentNr = "011120775";
        if (args.length > 0) {
            studentNr = args[0];
        }

        String url = "https://studies.cs.helsinki.fi/ohtustats/students/" + studentNr + "/submissions";
        String url2 = "https://studies.cs.helsinki.fi/ohtustats/courseinfo";
        String url3 = "https://studies.cs.helsinki.fi/ohtustats/stats";

        String bodyText = Request.Get(url).execute().returnContent().asString();
        String bodyText2 = Request.Get(url2).execute().returnContent().asString();
        
        String statsResponse = Request.Get(url3).execute().returnContent().asString();
        JsonParser parser = new JsonParser();
        
        JsonObject parsittuData = parser.parse(statsResponse).getAsJsonObject();
        



        Gson mapper = new Gson();
        Submission[] subs = mapper.fromJson(bodyText, Submission[].class);
        Gson mapper2 = new Gson();

        Course course = mapper2.fromJson(bodyText2, Course.class);
        int tehtYht = 0;
        double tuntYht = 0.0;

        System.out.println("Kurssi: " + course.getName() + ", " + course.getTerm());
        System.out.println();
        System.out.println("Opiskelijanumero: " + studentNr);
        System.out.println("");
        for (Submission submission : subs) {
            System.out.print("Viikko " + submission.getWeek() + ": tehtyjä tehtäviä yhteensä: " + submission.getExercises().size() + ", aikaa kului " + submission.getHours() + " tuntia, tehdyt tehtävät: ");
            for (Integer exercise : submission.getExercises()) {
                System.out.print(exercise + " ");
            }
            System.out.println("");
            tehtYht += submission.getExercises().size();
            tuntYht += submission.getHours();
        }

        System.out.println("");
        System.out.println("yhteensä: " + tehtYht + " tehtävää " + tuntYht + " tuntia");
        System.out.println();
        
        
        int tehtavia = 0;
        int palautuksia = 0;

        Set<Map.Entry<String, JsonElement>> entries = parsittuData.entrySet();
        for (Map.Entry<String, JsonElement> entry : entries) {
            String mjono = entry.toString();
            String split1[] = mjono.split("exercise_total");
            String split2[] = split1[1].split("hours");
            tehtavia += Integer.valueOf(split2[0].replace(",","").replace("\"","").replace(":", ""));
            String sss[] = mjono.split(",\"exercises\":");
            String[] arr = sss[1].replace("}", "").replaceAll("null", "0").replace("[", "").replace("]", "").split(",");
            for (int i = 1; i < arr.length; i++) {
                palautuksia += (Integer.valueOf(arr[i]) / i);
            }
        }

        System.out.println("kurssilla yhteensä palautuksia " + palautuksia + ", palautettuja tehtäviä " + tehtavia + " kpl");

    }
}
