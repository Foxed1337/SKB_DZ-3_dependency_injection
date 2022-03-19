package com.example.SKB_DZ._dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.List;

@Component
public class PlayList {

    @Autowired
    private List<Music> musics;

    private MyLogger logger;

    @Autowired
    public void setLogger(MyLogger logger) {
        this.logger = logger;
    }

    public String getMusicList() {
        StringBuilder strB = new StringBuilder();
        int num = 1;
        for (var music : this.musics) {
            strB.append(String.format("%s %s\n", num, music.getGenre()));
            num++;
        }

        return strB.toString();
    }

    public String getMusic(int musicNumber) {
        return musics.get(musicNumber).getComposition();
    }

    @PostConstruct
    private void init() throws IOException {
        logger.log("info","The PlayList class Bean has been created");
    }

    @PreDestroy
    private void destroy() {
        logger.log("info","The PlayList class Bean has been destroy");
    }
}
