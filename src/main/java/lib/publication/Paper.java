package lib.publication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;

public class Paper implements Publication {
    private ArrayList<Author> authors;
    private String title;
    private Date publishDate;
    private String link;

    public Paper(ArrayList<Author> authors, String title, Date publishDate, String link) {
        this.authors = authors;
        this.title = title;
        this.publishDate = publishDate;
        this.link = link;
    }

    public Paper(String title, ArrayList<String> authors, Date publishDate, String link) {
        ArrayList<Author> authorsList = new ArrayList<Author>();
        for (String author: authors) {
            authorsList.add(new Author(author));
        }
        this.authors = authorsList;
        this.title = title;
        this.publishDate = publishDate;
        this.link = link;
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

    public String getLink() {
        return this.link;
    }

    public String toAPA() {
        // Author, A. A., & Author, B. B. (Date of publication). Article Title. Journal Title, Vol. #(Issue # if available), page range. doi #
        String str = String.format("%s, %s",
            author.getAuthors
        )
        return "";
    }

    public String toMLA() {

        return "";
    }

    public String toString() {
        return String.format(
            "Paper: {Authors: %s, Title: %s, Publication Date: %s, DOI Link: %s}",
            Arrays.toString(authors.toArray()),
            title,
            publishDate.toString(),
            link
        );
    }
}
