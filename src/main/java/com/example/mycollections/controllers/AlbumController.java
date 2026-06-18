package com.example.mycollections.controllers;

import com.example.mycollections.models.Music;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/albums")
public class AlbumController {

    private final List<Music> albums = new ArrayList<>() {{
        add(new Music("Abbey Road", "The Beatles", 1969, 17));
        add(new Music("Thriller", "Michael Jackson", 1982, 9));
        add(new Music("Rumours", "Fleetwood Mac", 1977, 11));
    }};

    @GetMapping("/json")
    public List<Music> getAlbumsJson() {
        return albums;
    }

    @GetMapping("/html")
    public String getAlbumsHtml() {
        String albumList = "<ul>";
        for (Music album : albums) {
            albumList += "<li>" + album + "</li>";
        }
        albumList += "</ul>";

        return """
                <html>
                    <body>
                        <h1>Albums</h1>
                        <ul>
                """ +
                albumList +
                """
                        </ul>
                    </body>
                """;
    }

}