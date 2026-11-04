package org.hw9_proxy.Service;

import org.hw9_proxy.Data.SongData;
import org.hw9_proxy.model.Song;

import java.util.ArrayList;
import java.util.List;

public class SongService implements ISongService{
    private final List<Song> songs = SongData.getSongs();
    @Override
    public Song searchById(Integer songID) {
        try {
            Thread.sleep(1000);
        } catch (Exception ignored) {}

        for(Song song: this.songs){
            if(song.getId() == songID){
                return song;
            }
        }
        return null;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        List<Song> songsByTitle = new ArrayList<>();
        try {
            Thread.sleep(1000);
        } catch (Exception ignored) {}

        for(Song song: this.songs){
            if(song.getTitle().equals(title)) songsByTitle.add(song);
        }
        return songsByTitle;
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        List<Song> songsByAlbum = new ArrayList<>();
        try {
            Thread.sleep(1000);
        } catch (Exception ignored) {}

        for(Song song: this.songs){
            if(song.getAlbum().equals(album)) songsByAlbum.add(song);
        }
        return songsByAlbum;
    }
}
