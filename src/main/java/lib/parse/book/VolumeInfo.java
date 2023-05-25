package lib.parse.book;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class VolumeInfo {
    @JsonProperty("authors")
    private ArrayList<String> authors;

    @JsonProperty("title")
    private String title;

    @JsonProperty("subtitle")
    private String subtitle;

    @JsonProperty("publisher")
    private String publisher;

    // TODO: Stop using java.util.Date and switch to java.util.Calendar
    @JsonProperty("publishedDate")
    private String publishDate;

    public VolumeInfo() {}

    public ArrayList<String> getAuthors() {
        return authors;
    }

    public String getTitle() {
        if (subtitle != null && !subtitle.equals("")) {
            return String.format("%s: %s", title, subtitle);
        }
        return title;
    }

    public String getPublisher() {
        return publisher;
    }

    public LocalDate getDate() {
        LocalDate date;
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ISO_LOCAL_DATE;
            date = LocalDate.parse(publishDate, formatter);
        } catch (DateTimeParseException e) {
            date = LocalDate.of(Integer.parseInt(publishDate), 1, 1);
        }

        return date;
    }


    public String toString() {
        return String.format(
            "Volume Info: {Title: %s, Publication Date: %s, Authors: {%s}}",
            title,
            publishDate,
            Arrays.toString(authors.toArray())
        );
    }
}