package lib.parse;

import java.util.ArrayList;
import java.util.Date;

import lib.publication.Book;
import lib.publication.Items;
import lib.publication.Publication;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

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
    public Items formatJsonToItems() {
        // ObjectMapper instantiation
        ObjectMapper objectMapper = new ObjectMapper();
        
        // Deserialization into the `Book` class
        try {
            return objectMapper.readValue(iSBNString, Items.class);
        } catch (JsonProcessingException e) {
            System.out.println(e);
            return null;
        }
    }
    

    public String toString() {
        return String.format("Book %s", iSBNString);
    }
}
