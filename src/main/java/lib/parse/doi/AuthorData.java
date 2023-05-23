package lib.parse.doi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lib.publication.Author;

@JsonIgnoreProperties(ignoreUnknown = true)
public class AuthorData {
    @JsonProperty("given")
    private String firstName;

    @JsonProperty("family")
    private String lastName;

    @JsonProperty("sequence")
    private String sequence;

    public AuthorData() {}

    public Author toAuthor() {
        return new Author(firstName + " " + lastName);
    }
}
