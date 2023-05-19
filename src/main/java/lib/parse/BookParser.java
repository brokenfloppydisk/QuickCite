package lib.parse;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import lib.publication.Book;
import lib.publication.EntireJSON;
import lib.publication.Items;
import lib.publication.Publication;
import lib.publication.VolumeInfo;

public class BookParser extends Parser {
    private String iSBNString;
    
    public BookParser(String iSBNString) {
        this.iSBNString = iSBNString;
    }

    public String getBookJSON() {
        return super.getRequest(
            "https://www.googleapis.com/books/v1/volumes?q=isbn:"
            .concat(iSBNString)
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
        
        // Deserialization into the `Book` class
        try {
            EntireJSON entire = objectMapper.readValue(bookJSON, EntireJSON.class);
            Items items = entire.getItems();
            VolumeInfo volumeInfo = items.getVolumeInfo();
            
            return new Book(volumeInfo.getAuthors(), volumeInfo.getTitle(), volumeInfo.getDate(), iSBNString);
        } catch (JsonProcessingException e) {
            System.out.println(e);
            return null;
        }
    }
    

    public String toString() {
        return String.format("Book %s", iSBNString);
    }
}
