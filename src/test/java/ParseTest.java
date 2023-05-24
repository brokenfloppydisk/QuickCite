// package src.test.java;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import lib.parse.BookParser;
import lib.parse.DOIParser;
import lib.publication.Book;
import lib.publication.Paper;

public class ParseTest {
    @Test
    public void testFullDOIValidity() {
        DOIParser doiParser = new DOIParser("https://doi.org/10.2105/ajph.2018.304895");

        assertTrue(doiParser.isValid());
    }

    @Test
    public void testShortDOIValidity() {
        DOIParser doiParser = new DOIParser("10.2105/ajph.2018.304895");

        assertTrue(doiParser.isValid());
    }

    @Test
    public void testBadDOI() {
        DOIParser doiParser = new DOIParser("asdfasdfasdf");

        assertFalse(doiParser.isValid());
    }

    @Test
    public void testISBN13Validity() {
        BookParser testParser = new BookParser("978-0134092668");

        assertTrue(testParser.isValid());
    }

    @Test
    public void testISBN10Validity() {
        BookParser testParser = new BookParser("0-345-24223-8");

        assertTrue(testParser.isValid());
    }
    
    @Test
    public void testBookFetch() {
        BookParser testParser = new BookParser("9780134092669");
        Book result = testParser.toPublication();
        assertTrue(result.getTitle().equals("Computer Systems"));

        System.out.println("APA: " + result.toAPA());
        System.out.println("MLA: " + result.toMLA());
    }

    @Test
    public void testDOIFetch() {
        DOIParser testParser = new DOIParser("10.1037/0003-066X.59.1.29/");
        Paper result = testParser.toPublication();

        assertTrue(result.getTitle().equals("How the Mind Hurts and Heals the Body"));

        System.out.println("APA: " + result.toAPA());
        System.out.println("MLA: " + result.toMLA());
    }
}
