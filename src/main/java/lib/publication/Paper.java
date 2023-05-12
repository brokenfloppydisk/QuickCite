package lib.publication;

import java.util.ArrayList;
import java.util.Date;

public class Paper implements Publication {
    private ArrayList<String> authors;
    private String title;
    private Date publishDate;
    private String link;

    public Paper(ArrayList<String> authors, String title, Date publishDate, String link) {
        this.authors = authors;
        this.title = title;
        this.publishDate = publishDate;
        this.link = link;
    }

    public String toAPA() {

        return "";
    }

    public String toMLA() {

        return "";
    }
}
