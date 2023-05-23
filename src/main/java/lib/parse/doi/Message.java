package lib.parse.doi;

import java.sql.Date;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lib.publication.Author;
import lib.publication.Paper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Message {
    // See https://api.crossref.org/swagger-ui/index.html
    @JsonProperty("DOI")
    private String DOI;

    @JsonProperty("page")
    private String page;

    @JsonProperty("issue")
    private String issue;

    @JsonProperty("volume")
    private String volume;

    @JsonProperty("title")
    private ArrayList<String> title;

    @JsonProperty("container-title")
    private ArrayList<String> journalTitles;

    @JsonProperty("short-container-title")
    private ArrayList<String> shortJournalTitles;

    @JsonProperty("publisher")
    private String publisher;

    @JsonProperty("published-online")
    private DateInfo onlinePublishDate;

    @JsonProperty("author")
    private ArrayList<AuthorData> authors;

    private class DateInfo {
        @JsonProperty("date-parts")
        private ArrayList<ArrayList<Integer>> dates;

        @JsonProperty("date-time")
        private String dateString;

        private DateInfo() {}
    }

    public ArrayList<Author> getAuthors() {
        ArrayList<Author> authorsList = new ArrayList<Author>();
        for (AuthorData data : this.authors) {
            authorsList.add(data.toAuthor());
        }
        return authorsList;
    }

    public Paper toPaper(String doiLink) {
        // TODO: Add date parsing
        return new Paper(getAuthors(), title.get(0), new Date(0), doiLink);
    }
}
