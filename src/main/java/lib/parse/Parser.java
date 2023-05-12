package lib.parse;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

import lib.publication.Publication;

public abstract class Parser {
    private static HttpClient client;

    public Publication toPublication() {
        return null;
    }

    public HttpClient getClient() {
        if (client == null) {
            client = HttpClient.newHttpClient();
        }

        return client;
    }

    public String getRequest(String link) throws IOException, InterruptedException {
        // https://www.twilio.com/blog/5-ways-to-make-http-requests-in-java
        HttpClient client = getClient();

        HttpRequest request = HttpRequest.newBuilder(
            URI.create(
                link
                // "https://www.googleapis.com/books/v1/volumes?q=isbn:"
                // .concat(iSBNString)
            ))
            .timeout(Duration.ofSeconds(10))
            .GET()
            .header("accept", "text/html,application/json")
            .build();
        
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        return response.body();
    }
}
