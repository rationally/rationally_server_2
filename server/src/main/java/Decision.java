/**
 * Created by Ruben on 15-Feb-17.
 */
import static spark.Spark.*;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.field.DatabaseField;
import com.j256.ormlite.jdbc.JdbcConnectionSource;
import com.j256.ormlite.support.ConnectionSource;
import com.j256.ormlite.table.DatabaseTable;
import model.Alternative;
import model.Force;
import model.RelatedDocument;
import model.Stakeholder;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

@DatabaseTable(tableName = "Decisions")
public class Decision {
    @JsonProperty("DecisionName")
    @DatabaseField
    private String decisionName;
    @JsonProperty("Author")
    @DatabaseField
    private String author;
    @JsonProperty("Version")
    @DatabaseField
    private String version;
    @JsonProperty("DateString")
    @DatabaseField
    private String dateString;

    @JsonProperty("Alternatives")
    private ArrayList<Alternative> alternatives;
    @JsonProperty("Forces")
    private ArrayList<Force> forces;
    @JsonProperty("Documents")
    private ArrayList<RelatedDocument> documents;
    @JsonProperty("Stakeholders")
    private ArrayList<Stakeholder> stakeholders;

    @JsonProperty("AlternativeStateColors")
    private HashMap<String,String> alternativeStateColors;
    @JsonProperty("DefaultStates")
    private HashMap<String,String> defaultStates;

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

            JdbcConnectionSource connectionSource = new JdbcConnectionSource("jdbc:hsqldb:file:rationallyDB");
            connectionSource.setUsername(Constants.DatabaseUsername);
            connectionSource.setPassword(Constants.DatabasePassword);


            /*Dao<Decision, String> accountDao =
                    DaoManager.createDao(connectionSource, Decision.class);*/

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

    public HashMap<String, String> getAlternativeStateColors() {
        return alternativeStateColors;
    }

    public void setAlternativeStateColors(HashMap<String, String> alternativeStateColors) {
        this.alternativeStateColors = alternativeStateColors;
    }

    public HashMap<String, String> getDefaultStates() {
        return defaultStates;
    }

    public void setDefaultStates(HashMap<String, String> defaultStates) {
        this.defaultStates = defaultStates;
    }

    public ArrayList<Alternative> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(ArrayList<Alternative> alternatives) {
        this.alternatives = alternatives;
    }

    public ArrayList<Force> getForces() {
        return forces;
    }

    public void setForces(ArrayList<Force> forces) {
        this.forces = forces;
    }


    public ArrayList<Stakeholder> getStakeholders() {
        return stakeholders;
    }

    public void setStakeholders(ArrayList<Stakeholder> stakeholders) {
        this.stakeholders = stakeholders;
    }

    public ArrayList<RelatedDocument> getDocuments() {
        return documents;
    }

    public void setDocuments(ArrayList<RelatedDocument> documents) {
        this.documents = documents;
    }
}
