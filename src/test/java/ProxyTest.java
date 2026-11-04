import org.hw9_proxy.Data.SongData;
import org.hw9_proxy.Service.SongServiceProxy;
import org.hw9_proxy.model.Song;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.*;

public class ProxyTest {
    SongServiceProxy songServiceProxy = new SongServiceProxy();
    List<Song> allSongs = SongData.getSongs();
    String songTitle = SongData.getSongTitles().get(1);
    String songAlbum = SongData.getSongAlbums().get(1);
    Song song;
    List<Song> songs;

    //TIMED TESTS
    @Test
    public void testGetSongByIDNoCache() {
        long startTime = System.nanoTime();

        // should take 1 second
        song = songServiceProxy.searchById(1);
        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime) / 1_000_000;

        assertTrue(durationMs >= 1000, "Expected method to take at least 1000ms, but it took " + durationMs + "ms");
    }

    @Test
    public void testGetSongByIDCache() {
        song = songServiceProxy.searchById(1); //make sure in cache first

        long startTime = System.nanoTime();
        // should take 1 second
        song = songServiceProxy.searchById(1);
        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime) / 1_000_000;

        assertTrue(durationMs < 1000, "Expected method to take at least 1000ms, but it took " + durationMs + "ms");
    }

    @Test
    public void testGetSongByTitleNoCache() {
        long startTime = System.nanoTime();

        // should take 1 second
        songs = songServiceProxy.searchByTitle(songTitle);
        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime) / 1_000_000;

        assertTrue(durationMs >= 1000, "Expected method to take at least 1000ms, but it took " + durationMs + "ms");
    }

    @Test
    public void testGetSongByTitleCache() {
        songs = songServiceProxy.searchByTitle(songTitle); //make sure in cache first

        long startTime = System.nanoTime();
        // should take 1 second
        songs = songServiceProxy.searchByTitle(songTitle);
        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime) / 1_000_000;

        assertTrue(durationMs < 1000, "Expected method to take at least 1000ms, but it took " + durationMs + "ms");
    }

    @Test
    public void testGetSongByAlbumNoCache() {
        long startTime = System.nanoTime();

        // should take 1 second
        songs = songServiceProxy.searchByAlbum(songAlbum);
        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime) / 1_000_000;

        assertTrue(durationMs >= 1000, "Expected method to take at least 1000ms, but it took " + durationMs + "ms");
    }

    @Test
    public void testGetSongByAlbumCache() {
        songs = songServiceProxy.searchByAlbum(songAlbum); //make sure in cache first

        long startTime = System.nanoTime();
        // should take 1 second
        songs = songServiceProxy.searchByAlbum(songAlbum);
        long endTime = System.nanoTime();
        long durationMs = (endTime - startTime) / 1_000_000;

        assertTrue(durationMs < 1000, "Expected method to take at least 1000ms, but it took " + durationMs + "ms");
    }

    //UNTIMED TEST
    @Test
    public void testGetSongByID() {
        Song expected = allSongs.get(0);
        Song actual = songServiceProxy.searchById(1);
        assertEquals(expected, actual,"Song is different that method returns");
    }

    @Test
    public void testGetSongByTitle() {
        List<Song> expected = allSongs.stream()
                .filter(song -> songTitle.equalsIgnoreCase(song.getTitle()))
                .collect(Collectors.toList());

        List<Song> actual = songServiceProxy.searchByTitle(songTitle);
        assertEquals(expected, actual,"Songs are different that method returns");
    }

    @Test
    public void testGetSongByAlbum() {
        List<Song> expected = allSongs.stream()
                .filter(song -> songAlbum.equalsIgnoreCase(song.getAlbum()))
                .collect(Collectors.toList());

        List<Song> actual = songServiceProxy.searchByAlbum(songAlbum);
        assertEquals(expected, actual,"Songs are different that method returns");
    }

}
