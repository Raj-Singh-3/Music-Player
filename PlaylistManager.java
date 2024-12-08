import java.util.*;

public class PlaylistManager {
    private ArrayList<String> playlist;

    public PlaylistManager() {
        playlist = new ArrayList<>();
    }

    public void addSong(String songPath) {
        playlist.add(songPath);
    }

    public void removeSong(String songPath) {
        playlist.remove(songPath);
    }

    public ArrayList<String> getPlaylist() {
        return playlist;
    }
}
