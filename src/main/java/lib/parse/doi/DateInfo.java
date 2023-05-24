package lib.parse.doi;

import java.util.ArrayList;
import java.util.Date;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DateInfo {
    @JsonProperty("date-parts")
    private ArrayList<ArrayList<Integer>> dates;

    @JsonProperty("date-time")
    private String dateString;

    public DateInfo() {}

    public Date toDate() {
        return null;
    }
}
