package lib.parse;

import java.net.URI;
import java.net.http.HttpRequest;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

import lib.parse.book.BookJSON;
import lib.parse.book.VolumeInfo;
import lib.publication.Book;
import lib.publication.Publication;

public class BookParser extends Parser {
    private String iSBNString;
    
    public BookParser(String iSBNString) {
        this.iSBNString = iSBNString;
    }

    public String getBookJSON() {
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

    public Publication toPublication() {
        String bookJSON = getBookJSON();

        ArrayList<String> authors = new ArrayList<String>();
        String title;
        Date publishDate;
        
        return null;
    }

    // I dont know where this goes
    public Book formatJsonToBook(String bookJSON) {
        // ObjectMapper instantiation
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        
        // Deserialization into the `Book` class
        try {
            // BookJSON entire = objectMapper.readValue(bookJSON, BookJSON.class);
            // var volumeInfo = entire.getBookData().get(0).getVolumeInfo();
            // EntireJSON entire = objectMapper.readValue(bookJSON, EntireJSON.class);
            Items items = objectMapper.readValue(bookJSON, Items.class);
            // entire.getItems();
            VolumeInfo volumeInfo = items.getVolumeInfo();
            
            return new Book(volumeInfo.getAuthors(), volumeInfo.getTitle(), volumeInfo.getDate(), iSBNString);
            // return null;
        } catch (JsonProcessingException e) {
            System.out.println(e);
            return null;
        }
    }
    

    public String toString() {
        return String.format("Book %s", iSBNString);
    }
}
