package com.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Test {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(SpringConfig.class);

        MusicPlayer musicPlayer = context.getBean("musicPlayer", MusicPlayer.class);
        musicPlayer.playSong();

        System.out.println(musicPlayer.getVolume());
        System.out.println(musicPlayer.getNameOfAuthor());

        context.close();
    }
}
