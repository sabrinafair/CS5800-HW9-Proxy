package org.hw9_proxy.Service;

import org.hw9_proxy.model.Song;

import java.util.List;

public interface ISongService {
    Song searchById(Integer songID);
    List<Song> searchByTitle(String title);
    List<Song> searchByAlbum(String album);
}
