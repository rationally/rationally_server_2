package model;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Ruben on 15-Feb-17.
 */
public class RelatedDocument {
    @JsonProperty("Path")
    private String path;
    @JsonProperty("Name")
    private String name;
    @JsonProperty("IsFile")
    private boolean isFile;


    public RelatedDocument() {

    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isFile() {
        return isFile;
    }

    public void setFile(boolean file) {
        isFile = file;
    }
}
