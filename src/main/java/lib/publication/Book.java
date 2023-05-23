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
//         https://www.grammarly.com/citations/apa
//         Last name, First Initial. Middle Initial. (Year). Title. Source Info.
//         return String.format("%s, %s. (%d). %s. %s", "Huang", "K", this.publishDate.getYear(), this.title, "idk");
        return "";
    }

    public String toMLA() {
//      https://www.grammarly.com/citations/mla
//      Last name, First name. Title of Source. Other contributors, Version, Publisher, Year.
//         return String.format("%s, %s. %s. %d", "Hunag", "K", this.title, this.publishDate.getYear());
        return "";
    }

    public String getTitle() {
        return this.title;
    }

    public ArrayList<Author> getAuthors() {
        return this.authors;
    }

    public Date getDate() {
        return this.publishDate;
    }

    public String getISBN() {
        return this.iSBNString;
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
