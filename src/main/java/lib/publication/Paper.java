package lib.publication;

import java.time.LocalDate;
import java.time.format.TextStyle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;

public class Paper implements Publication {
    private ArrayList<Author> authors;
    private String title;
    private LocalDate publishDate;
    private String link;
    private String journal;
    private String volume;
    private String issue;

    public Paper(ArrayList<Author> authors, String title, LocalDate publishDate, 
                String link, String journal, String volume, String issue) {
        this.authors = authors;
        this.title = title;
        this.publishDate = publishDate;
        this.link = link;
        this.journal = journal;
        this.volume = volume;
        this.issue = issue;
    }

    public Paper(String title, ArrayList<String> authors, LocalDate publishDate, 
                String link, String journal, String volume, String issue) {
        ArrayList<Author> authorsList = new ArrayList<Author>();
        for (String author: authors) {
            authorsList.add(new Author(author));
        }
        this.authors = authorsList;
        this.title = title;
        this.publishDate = publishDate;
        this.link = link;
        this.journal = journal;
        this.volume = volume;
        this.issue = issue;
    }

    public String getTitle() {
        return this.title;
    }

    public ArrayList<Author> getAuthors() {
        return this.authors;
    }

    public LocalDate getDate() {
        return this.publishDate;
    }

    public String getLink() {
        return this.link;
    }

    public String toAPA() {
        // Author, A. A., & Author, B. B. (Date of publication). Article Title. Journal Title, Vol. #(Issue # if available), page range. doi #
        String str = String.format("%s, %s",
            authors.get(0).getLastName(),
            authors.get(0).getFirstInitial());

        if (authors.size() > 1) {
            for (int i = 1; i < authors.size(); i++) {
                if (i == authors.size() - 1){
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
            this.publishDate.getYear(),
            this.title,
            this.journal);
        
        str.replaceAll("\\.{2,}", ".");
        
        return str;
    }

    public String toMLA() {

// Last, First. "Title" Journal Title, vol #, no #, Month Year, pp. #-#, DOI link  

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
                    str = String.format("%s, & %s, %s",
                        str,
                        authors.get(i).getLastName(),
                        authors.get(i).getFirstName());
                }
            }
        }

        str = String.format("%s. \"%s\". %s. vol. %s, no. %s, %s %s.",
            str,
            this.title,
            this.journal,
            this.volume,
            this.issue,
            publishDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH).replace("\\.", ""),
            publishDate.getYear());

        str.replaceAll("\\.{2,}", ".");

        return str;
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
