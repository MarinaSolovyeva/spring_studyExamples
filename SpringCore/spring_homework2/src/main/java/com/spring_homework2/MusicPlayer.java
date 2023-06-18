package com.spring_homework2;

public class MusicPlayer {
    private Music music;
    private int volume;
    private String nameSong;

    public void setMusic(Music music) {
        this.music = music;
    }

    public void playSong() {
        System.out.println("Playing: " + music.getSong());
    }

    public void setVolume(int volume) {
        this.volume = volume;
    }

    public void setNameSong(String nameSong) {
        this.nameSong = nameSong;
    }

    public Music getMusic() {
        return music;
    }

    public int getVolume() {
        return volume;
    }

    public String getNameSong() {
        return nameSong;
    }

    @Override
    public String toString() {
        return "MusicPlayer{" +
                "music=" + music +
                ", volume=" + volume +
                ", nameSong='" + nameSong + '\'' +
                '}';
    }
}
