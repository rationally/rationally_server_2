package model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Ruben on 15-Feb-17.
 */
public class Stakeholder {
    @JsonProperty("Role")
    private String role;
    @JsonProperty("Name")
    private String name;

    public Stakeholder() {

    }


    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
