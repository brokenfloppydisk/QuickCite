package lib.parse;

import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Duration;

import lib.publication.Publication;

public class DOIParser extends Parser {
    private String doiLink;
    
    public DOIParser(String doiLink) {
        this.doiLink = doiLink;
    }

    public String getDOIJSON() {
        HttpRequest request = HttpRequest.newBuilder(
            URI.create(doiLink))
            .timeout(Duration.ofSeconds(10))
            .GET()
            .header("accept", "application/x-bibtex; charset=utf-8")
            .build();

        return super.getRequest(
            request
        );
    }


    public Publication toPublication() {
        return null;
    }
}