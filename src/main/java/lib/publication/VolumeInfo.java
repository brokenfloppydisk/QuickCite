package lib.publication;

import java.util.ArrayList;
import java.util.Date;

public class VolumeInfo {
    private ArrayList<Author> authors;
    private String title;
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