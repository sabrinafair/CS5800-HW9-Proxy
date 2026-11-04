package org.hw9_proxy.Service;

import org.hw9_proxy.model.Song;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SongServiceProxy implements ISongService{
    private final SongService songService;
    private final List<Song> songCache;
    private final Map<String, List<Song>> titleCache;
    private final Map<String, List<Song>> albumCache;

    public SongServiceProxy() {
        this.songService = new SongService();
        this.songCache = new ArrayList<>();
        this.titleCache = new HashMap<>();
        this.albumCache = new HashMap<>();
    }

    @Override
    public Song searchById(Integer songID) {
        for(Song song: this.songCache){
            if(song.getId() == songID){
                return song;
            }
        }

        Song song = this.songService.searchById(songID);
        this.songCache.add(song);
        return song;
    }

    @Override
    public List<Song> searchByTitle(String title) {
        for(String key: this.titleCache.keySet()){
            if(key.equals(title)) return this.titleCache.get(key);
        }

        List<Song> songs = this.songService.searchByTitle(title);
        this.titleCache.put(title, songs);
        return this.titleCache.get(title);
    }

    @Override
    public List<Song> searchByAlbum(String album) {
        for(String key: this.albumCache.keySet()){
            if(key.equals(album)) return this.albumCache.get(key);
        }

        List<Song> songs = this.songService.searchByAlbum(album);
        this.albumCache.put(album, songs);
        return this.albumCache.get(album);
    }
}
