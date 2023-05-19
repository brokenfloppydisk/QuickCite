package lib.parse.book;

import java.util.List;

// import com.fasterxml.jackson.core.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BookData {
    //https://stackabuse.com/definitive-guide-to-jackson-objectmapper-serialize-and-deserialize-java-objects/
    @JsonProperty("volumeInfo")
    private VolumeInfo volumeInfo;

    @JsonProperty("kind")
    private String kind;

    @JsonProperty("id")
    private String id;

    @JsonProperty("etag")
    private String etag;

    @JsonProperty("selfLink")
    private String link;

    public BookData() {}

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }

    @Override
    public String toString() {
        return volumeInfo.toString();
    }
}