package lib.parse;

import lib.publication.Publication;

public class BookParser extends Parser {
    private String iSBNString;
    
    public BookParser(String iSBNString) {
        this.iSBNString = iSBNString;
    }

    private String getBookJSON() {
        return super.getRequest(
            "https://www.googleapis.com/books/v1/volumes?q=isbn:"
            .concat(iSBNString)
        );
    }

    public Publication toPublication() {
        return null;
    }
}
