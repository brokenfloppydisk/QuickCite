package lib.publication;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;

public class Book implements Publication {
    private ArrayList<Author> authors;
    private String title;
    private String publisher;
    private LocalDate publishDate;
    private String iSBNString;

    public Book(ArrayList<Author> authors, String title, LocalDate publishDate, String iSBNString, String publisher) {
        this.authors = authors;
        this.title = title;
        this.publishDate = publishDate;
        this.iSBNString = iSBNString;
        this.publisher = publisher;
    }

    public Book(String title, ArrayList<String> authors, LocalDate publishDate, String iSBNString, String publisher) {
        ArrayList<Author> authorsList = new ArrayList<Author>();
        for (String author: authors) {
            authorsList.add(new Author(author));
        }
        this.authors = authorsList;
        this.title = title;
        this.publishDate = publishDate;
        this.iSBNString = iSBNString;
        this.publisher = publisher;
    }

    public String toAPA() {
//         https://www.grammarly.com/citations/apa
//         Last name, First Initial. Middle Initial. (Year). Title. Source Info.
        String str = String.format("%s, %s.", 
            authors.get(0).getLastName(), 
            authors.get(0).getFirstInitial());
        
        if (authors.size() > 1) {
            for (int i = 1; i < authors.size(); i++) {
                if (i == authors.size() - 1) {
                    str = String.format("%s, & %s, %s.", 
                        str,
                        authors.get(i).getLastName(), 
                        authors.get(i).getFirstInitial());
                } else {
                    str = String.format("%s, %s, %s.", 
                        str,
                        authors.get(i).getLastName(), 
                        authors.get(i).getFirstInitial());
                }
            }
        }

        str = String.format("%s (%s). %s. %s.", 
            str,
            publishDate.getYear(),
            this.title,
            this.publisher);
        
        str.replaceAll("\\.{2,}", ".");

        return str;
    }

    public String toMLA() {
//      https://www.grammarly.com/citations/mla
//      Last name, First name. Title of Source. Other contributors, Version, Publisher, Year.
//         return String.format("%s, %s. %s. %d", "Hunag", "K", this.title, this.publishDate.getYear());
        String str = String.format("%s, %s.", 
            authors.get(0).getLastName(), 
            authors.get(0).getFirstName());
        
        if (authors.size() > 1) {
            for (int i = 1; i < authors.size(); i++) {
                if (i == authors.size() - 1) {
                    str = String.format("%s, & %s, %s", 
                        str,
                        authors.get(i).getLastName(), 
                        authors.get(i).getFirstName());
                } else {
                    str = String.format("%s, %s, %s", 
                        str,
                        authors.get(i).getLastName(), 
                        authors.get(i).getFirstName());
                }
            }
        }
        str = String.format("%s. %s. %s. %s.", 
            str,
            this.title,
            this.publisher,
            publishDate.getYear());

        str.replaceAll("\\.{2,}", ".");

        return str;
    }

    public String getTitle() {
        return this.title;
    }

    public ArrayList<Author> getAuthors() {
        return this.authors;
    }

    public String getFormattedDate() {
        // DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd. MMM yyyy");
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy, MMMM dd");
        return formatter.format(publishDate);
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
