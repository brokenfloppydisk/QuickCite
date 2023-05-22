package lib.parse.doi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Query {
    @JsonProperty("journal_title")
    private String journalTitle;
}
