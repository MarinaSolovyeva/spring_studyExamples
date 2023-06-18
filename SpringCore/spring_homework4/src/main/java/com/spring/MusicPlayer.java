package com.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class MusicPlayer {

    @Value("${musicPlayer.volume}")
    private int volume;

    @Value("${musicPlayer.name}")
    private String nameOfAuthor;

    private Music music;

    public void playSong () {
        System.out.println(music.getSong());
    }

    public int getVolume() {
        return volume;
    }

    public String getNameOfAuthor() {
        return nameOfAuthor;
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setNameOfAuthor(String nameOfAuthor) {
        this.nameOfAuthor = nameOfAuthor;
    }
    @Autowired
    public void setMusic(Music music) {
        this.music = music;
    }
}
