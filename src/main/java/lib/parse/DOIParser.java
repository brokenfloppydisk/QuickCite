package lib.parse;

import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lib.parse.doi.DOIJSON;
import lib.publication.Paper;

public class DOIParser extends Parser {
    private String doi;
    private boolean isValid;
    
    public DOIParser(String doiLink) {
        // Regex taken from https://stackoverflow.com/questions/27910/finding-a-doi-in-a-document-or-page
        Pattern doiPattern = Pattern.compile("\\b(10[.][0-9]{4,}(?:[.][0-9]+)*/(?:(?![\"&\\\'<>])\\S)+)\\b", Pattern.CASE_INSENSITIVE);
        Matcher matcher = doiPattern.matcher(doiLink);

        boolean isDOI = matcher.find();

        if (isDOI) {
            this.doi = matcher.group();
            this.isValid = true;
        } else {
            this.doi = null;
            this.isValid = false;
        }
    }

    public boolean isValid() {
        return this.isValid;
    }

    public String getDOIJSON() {
        if (!isValid()) {
            return "";
        }

        HttpRequest request = HttpRequest.newBuilder(
            URI.create("https://api.crossref.org/works/".concat(doi)))
            .timeout(Duration.ofSeconds(10))
            .GET()
            .header("accept", "text/html,application/json")
            .build();

        return super.getRequest(
            request
        );
    }

    public Paper toPublication() {
        if (!this.isValid)
            return null;

        // ObjectMapper instantiation
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        // Deserialization into the `Book` class
        try {
            var entire = objectMapper.readValue(getDOIJSON(), DOIJSON.class);
            return entire.toPaper("https://doi.org/" + this.doi);
        } catch (JsonProcessingException e) {
            System.out.println(e);
            return null;
        }
    }
}