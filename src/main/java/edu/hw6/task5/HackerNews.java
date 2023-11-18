package edu.hw6.task5;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HackerNews {
    private HackerNews() {}

    public static long[] hackerNewsTopStories() throws URISyntaxException {
        long[] topStoriesId;
        try (HttpClient client = HttpClient.newHttpClient()) {
            HttpRequest request = HttpRequest
                .newBuilder(new URI("https://hacker-news.firebaseio.com/v0/topstories.json"))
                .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            String ans = response.body();
            ans = ans.substring(1, ans.length() - 1);
            topStoriesId = Arrays.stream(ans.split(",")).mapToLong(Long::parseLong).toArray();
        } catch (IOException | InterruptedException e) {
            topStoriesId = new long[0];
        }
        return topStoriesId;
    }

    public static String news(long id) {
        try (HttpClient client = HttpClient.newHttpClient()) {
            URI uriId = URI.create("https://hacker-news.firebaseio.com/v0/item/" + id + ".json");
            HttpResponse<String> response = client
                .send(HttpRequest.newBuilder(uriId).build(), HttpResponse.BodyHandlers.ofString());
            Pattern findTitle = Pattern.compile("\"title\":\"(.+)\",\"type\":\"story\"");
            Matcher matcher = findTitle.matcher(response.body());
            if (!matcher.find()) {
                throw new RuntimeException("Illegal ID, this is not a story.");
            }
            return matcher.group(1);
        } catch (IOException | InterruptedException e) {
            return "";
        }
    }
}
