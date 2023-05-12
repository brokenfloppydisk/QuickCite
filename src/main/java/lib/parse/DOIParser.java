package lib.parse;

import lib.publication.Publication;

public class DOIParser implements Parser {
    private String doiLink;
    
    public DOIParser(String doiLink) {
        this.doiLink = doiLink;
    }

    public Publication toPublication() {
        return null;
    }
}
