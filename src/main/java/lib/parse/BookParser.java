package lib.parse;

import java.util.ArrayList;
import java.util.Date;

import lib.publication.Publication;

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

    public String toString() {
        return String.format("Book %s", iSBNString);
    }
}
