package lib.parse.book;

import java.util.Arrays;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookJSON {
    @JsonProperty("items")
    private List<BookData> items;

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("totalItems")
    private int totalItems;

    public BookJSON() {
        // this.items = items;
    }

    public String getKind() {
        return kind;
    }

    public int getTotalItems() {
        return totalItems;
    }

    public List<BookData> getBookData() {
        return items;
    }

    public void setBookData(List<BookData> bookData) {
        this.items = bookData;
    }

    @Override
    public String toString() {
        String bookDataString = "{";
        for (int i = 0; i<items.size(); i++) {
            bookDataString = bookDataString.concat(items.get(i).toString());
            if (i != items.size() - 1) {
                bookDataString = bookDataString.concat(", ");
            }
        }
        bookDataString = bookDataString.concat("}");

        return String.format(
            "Google Books JSON: {Kind: %s, TotalItems %d, Items %s}",
            kind,
            totalItems,
            bookDataString
        );
    }
}