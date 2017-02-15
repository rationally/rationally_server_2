package model;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.HashMap;

/**
 * Created by Ruben on 15-Feb-17.
 */
public class Force {
    @JsonProperty("ForceValueDictionary")
    private HashMap<Integer,String> forceValueDictionary;
    @JsonProperty("Concern")
    private String concern;
    @JsonProperty("Description")
    private String description;

    public Force() {

    }

    public HashMap<Integer, String> getForceValueDictionary() {
        return forceValueDictionary;
    }

    public void setForceValueDictionary(HashMap<Integer, String> forceValueDictionary) {
        this.forceValueDictionary = forceValueDictionary;
    }

    public String getConcern() {
        return concern;
    }

    public void setConcern(String concern) {
        this.concern = concern;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
