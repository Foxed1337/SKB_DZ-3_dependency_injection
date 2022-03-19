package com.example.SKB_DZ._dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;

@Component
public class RockMusic implements Music {

    private static final String genre = "Rock";

    @Value("${RockMusic.name}")
    private String name;

    @Value("${RockMusic.text}")
    private String text;

    private MyLogger logger;

    @Autowired
    public void setLogger(MyLogger logger) {
        this.logger = logger;
    }

    @Override
    public String getComposition() {
        return String.format("Now playing: %s...\n", name) + text;
    }

    @Override
    public String getGenre() {
        return genre;
    }

    @PostConstruct
    public void init() throws IOException {
        logger.log("info", "The RockMusic class Bean has been created");
    }

    @PreDestroy
    public void destroy() {
        logger.log("info", "The RockMusic class Bean has been destroy");
    }
}
