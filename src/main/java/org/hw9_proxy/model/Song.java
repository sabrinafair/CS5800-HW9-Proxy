package org.hw9_proxy.model;

public class Song {
    private String title, artist, album;
    private int id, duration;

    public Song(int id, String title, String artist, String album, int duration) {
        this.id = id;
        this.title = title;
        this.artist = artist;
        this.album = album;
        this.duration = duration;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getAlbum() {
        return album;
    }

    public void setAlbum(String album) {
        this.album = album;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    @Override
    public String toString() {
        return "Song Title: " + this.getTitle() + "\n"
                + "Album: " + this.getAlbum() + "\n"
                + "Artist: " + this.getArtist() + "\n"
                + "Duration: " + this.getDuration() / 60 + "\n"
                ;
    }
}
