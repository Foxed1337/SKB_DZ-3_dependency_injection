package com.example.SKB_DZ._dependency_injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.io.IOException;
import java.util.Scanner;

@Component
@Scope("singleton")
public class MusicPlayer {

    private PlayList playList;

    @Value("${MusicPlayer.musicPlayerTime}")
    private int musicPlayerTime;

    @Autowired
    public MusicPlayer(PlayList playList) {
        this.playList = playList;
    }

    private MyLogger logger;

    @Autowired
    public void setLogger(MyLogger logger) {
        this.logger = logger;
    }

    public void play() throws InterruptedException {
        System.out.println("Choose a music genre: ");
        System.out.println(playList.getMusicList());
        Scanner scanner = new Scanner(System.in);
        var curMusic = playList.getMusic(scanner.nextInt() - 1);
        for (int i = 0; i < curMusic.length(); i++) {
            System.out.print(curMusic.charAt(i));
            Thread.sleep(musicPlayerTime);
        }
        System.out.println("\n\nEnd of music((((((");
    }

    @PostConstruct
    public void init() throws IOException {
        logger.log("info", "The MusicPlayer class Bean has been created");
    }

    @PreDestroy
    public void destroy() {
        logger.log("info", "The MusicPlayer class Bean has been destroy");
    }
}
