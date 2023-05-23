package lib.parse;

import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lib.parse.book.BookJSON;
import lib.publication.Book;

public class BookParser extends Parser {
    private String iSBNString;
    private boolean isValid;
    
    public BookParser(String iSBNString) {
        // Regex taken from https://stackoverflow.com/questions/41271613/use-regex-to-verify-an-isbn-number
        Pattern isbnPattern = Pattern.compile(
            "^(?=(?:\\D*\\d){10}(?:(?:\\D*\\d){3})?$)[\\d-]+$", 
            Pattern.CASE_INSENSITIVE);
        Matcher matcher = isbnPattern.matcher(iSBNString);

        boolean isISBN = matcher.find();

        if (isISBN) {
            this.iSBNString = matcher.group();
            this.isValid = true;
        } else {
            this.iSBNString = null;
            this.isValid = false;
        }
        
        this.iSBNString = iSBNString;
    }

    public String getBookJSON() {
        if (!isValid()) {
            return "";
        }

        HttpRequest request = HttpRequest.newBuilder(
            URI.create(
                "https://www.googleapis.com/books/v1/volumes?q=isbn:"
                .concat(iSBNString)
            ))
            .timeout(Duration.ofSeconds(10))
            .GET()
            .header("accept", "text/html,application/json")
            .build();

        return super.getRequest(
            request
        );
    }

    public boolean isValid() {
        return this.isValid;
    }

    public Book toPublication() {
        if (!this.isValid)
            return null;

        // ObjectMapper instantiation
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);

        // Deserialization into the `Book` class
        try {
            BookJSON bookPOJO = objectMapper.readValue(getBookJSON(), BookJSON.class);
            return bookPOJO.toBook(iSBNString);
        } catch (JsonProcessingException e) {
            System.out.println(e);
            return null;
        }
    }

    public String toString() {
        return String.format("Book %s", iSBNString);
    }
}
