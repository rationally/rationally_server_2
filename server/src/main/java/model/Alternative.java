package model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Ruben on 15-Feb-17.
 */
public class Alternative {
    @JsonProperty("Status")
    private String status;
    @JsonProperty("Title")
    private String title;
    @JsonProperty("IdentifierString")
    private String identifierString;
    @JsonProperty("UniqueIdentifier")
    private int uniqueIdentifier;

    public Alternative() {

    }


    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIdentifierString() {
        return identifierString;
    }

    public void setIdentifierString(String identifierString) {
        this.identifierString = identifierString;
    }

    public int getUniqueIdentifier() {
        return uniqueIdentifier;
    }

    public void setUniqueIdentifier(int uniqueIdentifier) {
        this.uniqueIdentifier = uniqueIdentifier;
    }
}
