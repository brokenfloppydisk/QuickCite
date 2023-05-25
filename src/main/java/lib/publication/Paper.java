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
    private String page;

    public Paper(ArrayList<Author> authors, String title, LocalDate publishDate, 
                String link, String journal, String volume, String issue, String page) {
        this.authors = authors;
        this.title = title;
        this.publishDate = publishDate;
        this.link = link;
        this.journal = journal;
        this.volume = volume;
        this.issue = issue;
        this.page = page;
    }

    public Paper(String title, ArrayList<String> authors, LocalDate publishDate, 
                String link, String journal, String volume, String issue, String page) {
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
        this.page = page;
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
                        authors.get(i).getNonSurnameInitials());
                } else {
                    str = String.format("%s, %s, %s.",
                        str,
                        authors.get(i).getLastName(),
                        authors.get(i).getNonSurnameInitials());
                }
            }
        }

        str = String.format("%s (%s). %s. \033[3m%s\033[0m, %s(%s), %s. %s",
            str,
            this.publishDate.getYear(),
            this.title,
            this.journal,
            this.volume,
            this.issue,
            this.page,
            this.link);
        
        str = str.replaceAll("\\.{2,}", ".");
        
        return str;
    }

    public String toMLA() {
        // Last, First. "Title" Journal Title, vol #, no #, Month Year, pp. #-#, DOI link  
        String str = "";

        if (authors.size() == 1) {
            str = String.format("%s, %s.",
                    authors.get(0).getLastName(),
                    authors.get(0).getFirstNameMiddleInitial());
        } else if (authors.size() > 2) {
            str = String.format("%s, %s, et al",
                    authors.get(0).getLastName(),
                    authors.get(0).getFirstNameMiddleInitial());
        } else {
            str = String.format("%s, %s, and %s",
                    authors.get(0).getLastName(),
                    authors.get(0).getFirstNameMiddleInitial(),
                    authors.get(1).getFullName());
        }

        str = String.format("%s. \"%s\". \033[3m%s\033[0m, vol. %s, no. %s, %s %s, pp. %s, %s",
            str,
            this.title,
            this.journal,
            this.volume,
            this.issue,
            publishDate.getMonth().getDisplayName(TextStyle.SHORT, Locale.ENGLISH).replace("\\.", ""),
            publishDate.getYear(),
            this.page,
            this.link);

        str = str.replaceAll("\\.{2,}", ".");

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
