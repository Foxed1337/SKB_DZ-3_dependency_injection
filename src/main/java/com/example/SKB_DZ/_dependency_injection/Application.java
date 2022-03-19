package com.example.SKB_DZ._dependency_injection;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Application {

    public static void main(String[] args) throws InterruptedException {
        var context = SpringApplication.run(Application.class, args);
        MusicPlayer musicPlayer = context.getBean(MusicPlayer.class);
        musicPlayer.play();
    }
}
