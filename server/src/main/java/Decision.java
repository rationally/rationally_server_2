/**
 * Created by Ruben on 15-Feb-17.
 */
import static spark.Spark.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Alternative;


import java.io.IOException;
import java.util.ArrayList;


public class Decision {
    @JsonProperty("DecisionName")
    private String decisionName;
    @JsonProperty("Author")
    private String author;
    @JsonProperty("Version")
    private String version;
    @JsonProperty("DateString")
    private String dateString;
    @JsonProperty("Alternatives")
    private ArrayList<Alternative> alternatives;

    public Decision() {

    }

    public static void RegisterPaths() {
        post("/decision/",  (request, response) -> {postDecision(request.body());

            return "decision created";
        } );

        post("/decision/:id",  (request, response) -> {

                postDecision(request.body(),Integer.parseInt(request.params("id")));

            return "decision updated";
        } );
    }

    public static void postDecision(String decisionJson){
        System.out.println("Creating decision");
        ObjectMapper mapper = new ObjectMapper();
        try {
            Decision decision = mapper.readValue(decisionJson, Decision.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Created decision object");

    }
    public static void postDecision(String decisionJson, int id) {
        System.out.println("Updating decision");
    }

    public String getDecisionName() {
        return decisionName;
    }

    public void setDecisionName(String decisionName) {
        this.decisionName = decisionName;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getVersion() {
        return version;
    }

    public void setVersion(String version) {
        this.version = version;
    }

    public String getDateString() {
        return dateString;
    }

    public void setDateString(String dateString) {
        this.dateString = dateString;
    }
}
