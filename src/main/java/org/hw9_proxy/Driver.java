package org.hw9_proxy;

import org.hw9_proxy.Data.SongData;
import org.hw9_proxy.Service.SongServiceProxy;
import org.hw9_proxy.model.Song;

import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Driver {
    public static void main(String[] args) {
        SongServiceProxy songServiceProxy = new SongServiceProxy();
        List<String> songTitles = SongData.getSongTitles();
        List<String> songAlbums = SongData.getSongAlbums();

        System.out.println("CACHE EMPTY");

        Song currSong;
        System.out.println("--------------------------------");
        System.out.println("GET SONGS BY ID");
        for(int i = 1; i <= 10; i++){
           System.out.println("ID searched for: " + i);
           currSong = songServiceProxy.searchById(i);
           System.out.println(currSong.toString());
           System.out.println();
        }

        System.out.println();
        System.out.println("GET SONGS BY TITLE");
        List<Song> currSongs;
        for(String title: songTitles){
            System.out.println("Title searched for: " + title);
            currSongs = songServiceProxy.searchByTitle(title);
            for(Song song: currSongs){
            System.out.println(song.toString());
            }
            System.out.println();
        }

        System.out.println();
        System.out.println("GET SONGS BY ALBUM");
        for(String album: songAlbums){
            System.out.println("Album searched for: " + album);
            currSongs = songServiceProxy.searchByAlbum(album);
            for(Song song: currSongs){
                System.out.println(song.toString());
            }
            System.out.println();
        }

        System.out.println("--------------------------------");

        System.out.println("CACHE FULL");
        System.out.println("--------------------------------");
        System.out.println();

        System.out.println("GET SONGS BY ID");
        for(int i = 1; i <= 10; i++){
            System.out.println("ID searched for: " + i);
            currSong = songServiceProxy.searchById(i);
            System.out.println(currSong.toString());
            System.out.println();

        }
        System.out.println();
        System.out.println("GET SONGS BY TITLE");
        for(String title: songTitles){
            System.out.println("Title searched for: " + title);
            currSongs = songServiceProxy.searchByTitle(title);
            for(Song song: currSongs){
                System.out.println(song.toString());
            }
            System.out.println();
        }
        System.out.println();
        System.out.println("GET SONGS BY ALBUM");
        for(String album: songAlbums){
            System.out.println("Album searched for: " + album);
            currSongs = songServiceProxy.searchByAlbum(album);
            for(Song song: currSongs){
                System.out.println(song.toString());
            }
            System.out.println();
        }
        System.out.println("--------------------------------");

    }
}