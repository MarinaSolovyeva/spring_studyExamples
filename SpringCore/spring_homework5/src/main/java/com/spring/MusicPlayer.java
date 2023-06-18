package com.spring;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;

public class MusicPlayer {

    @Value("${musicPlayer.volume}")
    private int volume;

    @Value("${musicPlayer.name}")
    private String nameOfAuthor;

    private Music music1;
    private Music music2;

    public MusicPlayer (@Qualifier ("rockMusicBean") Music music1,
        @Qualifier("classicalMusicBean") Music music2) {
    this.music1 = music1;
    this.music2 = music2;
    }

    public void playSong () {
        System.out.println(music1.getSong() + "," + music2.getSong());
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


}
