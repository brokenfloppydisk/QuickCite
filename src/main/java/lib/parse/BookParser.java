package lib.parse;

import lib.publication.Publication;

public class BookParser implements Parser {
    private String iSBNString;
    
    public BookParser(String iSBNString) {
        this.iSBNString = iSBNString;
    }

    public Publication toPublication() {
        return null;
    }
}
