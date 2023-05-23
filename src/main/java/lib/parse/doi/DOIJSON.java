package lib.parse.doi;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import lib.publication.Paper;

@JsonIgnoreProperties(ignoreUnknown = true)
public class DOIJSON {
    @JsonProperty("message")
    private Message message;

    public DOIJSON() {}

    public Paper toPaper(String doiLink) {
        return message.toPaper(doiLink);
    }

    public Paper toPaper() {
        return message.toPaper();
    }
}
