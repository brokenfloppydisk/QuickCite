package lib.parse;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;

import lib.publication.Publication;

public class BookParser extends Parser {
    private String iSBNString;
    
    public BookParser(String iSBNString) {
        this.iSBNString = iSBNString;
    }

    public Publication toPublication() {
        return null;
    }
}
