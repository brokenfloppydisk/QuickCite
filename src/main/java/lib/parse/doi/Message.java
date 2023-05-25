package lib.parse.doi;

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

    @JsonProperty("published-print")
    private DateInfo printPublishDate;

    @JsonProperty("created")
    private DateInfo createdDate;

    @JsonProperty("author")
    private ArrayList<AuthorData> authors;

    public Message() {}

    public ArrayList<Author> getAuthors() {
        ArrayList<Author> authorsList = new ArrayList<Author>();
        for (AuthorData data : this.authors) {
            authorsList.add(data.toAuthor());
        }
        return authorsList;
    }

    public Paper toPaper(String doiLink) {
        return new Paper(getAuthors(), title.get(0).replaceAll("\\.", ""), createdDate.toDate(), doiLink, shortJournalTitles.get(0), volume, issue, page);
    }

    public Paper toPaper() {
        return new Paper(getAuthors(), title.get(0).replaceAll("\\.", ""), createdDate.toDate(), DOI, shortJournalTitles.get(0), volume, issue, page);
    }
}
