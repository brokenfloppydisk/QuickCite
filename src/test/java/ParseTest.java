package src.test.java;

import org.junit.jupiter.api.Test;

import lib.parse.BookParser;

public class ParseTest {
    @Test
    public void testBookFetch() {
        BookParser testParser = new BookParser("9780134092669");

        System.out.println(testParser.getBookJSON());
    }
}
