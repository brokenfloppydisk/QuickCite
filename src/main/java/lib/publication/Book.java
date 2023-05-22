package lib.publication;

import java.util.ArrayList;
import java.util.Arrays;
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

    public String toString() {
        return String.format(
            "Book: {Authors: %s, Title: %s, Publication Date: %s, ISBN: %s}",
            Arrays.toString(authors.toArray()),
            title,
            publishDate.toString(),
            iSBNString
        );
    }
}
