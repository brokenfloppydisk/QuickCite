package lib.parse.doi;

import java.time.LocalDate;
import java.util.ArrayList;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DateInfo {
    @JsonProperty("date-parts")
    private ArrayList<ArrayList<Integer>> dates;

    @JsonProperty("date-time")
    private String dateString;

    public DateInfo() {}

    public boolean hasDetailedTime() {
        if (dateString != null && !dateString.equals("")) {
            return true;   
        }
        return dates.get(0).size() > 2;
    }

    public LocalDate toDate() {
        // if (dateString != null) {
        //     DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-mm-ddTHH:mm:ssZ", Locale.ENGLISH);
        //     // DateTimeFormatter formatter = DateTimeFormatter.ISO_INSTANT.localizedBy(Locale.ENGLISH);
        //     try {
        //         System.out.println("asdf");
        //         return LocalDate.parse(dateString, formatter);
        //     } catch (DateTimeParseException e) {
        //         System.out.println(e);
        //     }
        // }
        // System.out.println("asdf");

        ArrayList<Integer> dateInfo = dates.get(0);
        if (dateInfo.size() < 2) {
            return LocalDate.of(dateInfo.get(0), 0, 0);
        } else {
            return LocalDate.of(dateInfo.get(0), dateInfo.get(1), dateInfo.get(2));
        }
    }
}
