package lib.publication;

import java.util.ArrayList;
import java.util.Date;

public class Book implements Publication {
    private ArrayList<Author> authors;
    private String title;
    private Date publishDate;
    private String iSBNString;

    public Book(ArrayList<Author> authors, String title, Date publishDate, String iSBNString) {
        this.authors = authors;
        this.title = title;
        this.publishDate = publishDate;
        this.iSBNString = iSBNString;
    }

    public Book(String title, ArrayList<String> authors, Date publishDate, String iSBNString) {
        ArrayList<Author> authorsList = new ArrayList<Author>();
        for (String author: authors) {
            authorsList.add(new Author(author));
        }
        this.authors = authorsList;
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
