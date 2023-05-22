package lib.parse.doi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import lib.publication.Author;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Contributor {
    @JacksonXmlProperty(isAttribute = true)
    private String sequence;

    @JacksonXmlProperty(localName = "given_name")
    private String givenName;

    @JacksonXmlProperty(localName = "surname")
    private String surname;

    public Contributor() {}

    public Author toAuthor() {
        return new Author(givenName + " " + surname);
    }
}
