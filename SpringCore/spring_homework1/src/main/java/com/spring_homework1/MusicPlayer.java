package com.spring_homework1;

public class MusicPlayer {
    private Music music;

    public MusicPlayer (Music music) {
        this.music = music;
    }

    public void playMusic () {
        System.out.println(music.getSong());
    }
}
