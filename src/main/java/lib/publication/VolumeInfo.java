package lib.publication;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VolumeInfo {
    @JsonProperty("authors")
    private ArrayList<Author> authors;
    @JsonProperty("title")
    private String title;
    @JsonProperty("publishedDate")
    private Date publishDate;

    public VolumeInfo(ArrayList<Author> authors, String title, Date publishDate) {
        this.authors = authors;
        this.title = title;
        this.publishDate = publishDate;
    }

    public ArrayList<Author> getAuthors() {
        return authors;
    }

    public String getTitle() {
        return title;
    }

    public Date getDate() {
        return publishDate;
    }
}