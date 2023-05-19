package lib.publication;

// import com.fasterxml.jackson.core.JsonProperty;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Items {
    //https://stackabuse.com/definitive-guide-to-jackson-objectmapper-serialize-and-deserialize-java-objects/
    private VolumeInfo volumeInfo;

    // public Items(VolumeInfo volumeInfo) {
    //     this.volumeInfo = volumeInfo;
    // }

    public Items() {
        
    }

    public VolumeInfo getVolumeInfo() {
        return volumeInfo;
    }

    public void setVolumeInfo(VolumeInfo volumeInfo) {
        this.volumeInfo = volumeInfo;
    }
}