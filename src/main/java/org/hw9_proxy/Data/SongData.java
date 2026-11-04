package org.hw9_proxy.Data;

import org.hw9_proxy.model.Song;

import java.util.List;

public final class SongData {

    private SongData() {
    }

    public static List<Song> getSongs() {
        return List.of(
                new Song(1, "Hello", "Adele", "25", 295),
                new Song(2, "Hello", "Lionel Richie", "Can't Slow Down", 245),
                new Song(3, "Hold On", "Justin Bieber", "Justice", 170),
                new Song(4, "Hold On", "Jonas Brothers","Happiness Begins", 183),
                new Song(5, "Cool", "Jonas Brothers", "Happiness Begins", 167),
                new Song(6, "Cool", "Dua Lipa", "Future Nostalgia", 209),
                new Song(7, "Unstoppable", "Sia", "This Is Acting", 217),
                new Song(8, "Attention", "Charlie Puth", "Voicenotes", 208),
                new Song(9, "How Long", "Charlie Puth", "Voicenotes", 191),
                new Song(10, "What Do You Mean?", "Justin Bieber", "Purpose", 206));
    }

    public static List<String> getSongTitles() {
        return List.of("Hello", "Hold On", "Cool", "Unstoppable", "Attention", "How Long", "What Do You Mean?");
    }

    public static List<String> getSongAlbums() {
        return List.of("25", "Can't Slow Down", "Justice", "Happiness Begins", "Future Nostalgia", "This Is Acting", "Voicenotes", "Purpose");
    }
}
