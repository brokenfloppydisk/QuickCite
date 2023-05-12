package lib.publication;

import java.util.ArrayList;
import java.util.Date;

public class Book implements Publication {
    private ArrayList<String> authors;
    private String title;
    private Date publishDate;
    private String iSBNString;

    public Book(ArrayList<String> authors, String title, Date publishDate, String iSBNString) {
        this.authors = authors;
        this.title = title;
        this.publishDate = publishDate;
        this.iSBNString = iSBNString;
    }

    public String toAPA() {
        
        return "";
    }

    public String toMLA() {

        return "";
    }
}
