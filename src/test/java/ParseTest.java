// package src.test.java;

import org.junit.jupiter.api.Test;

import lib.parse.BookParser;
import lib.parse.DOIParser;

public class ParseTest {
    @Test
    public void testBookFetch() {
        BookParser testParser = new BookParser("9780134092669");
        DOIParser doiParser = new DOIParser("https://doi.org/10.2105/ajph.2018.304895");

        System.out.println(testParser.formatJsonToBook(testParser.getBookJSON()));
        // System.out.println(testParser.getBookJSON());
        // System.out.println(doiParser.getDOIJSON());
    }
}
