import java.util.LinkedList;

public class MusicPlaylist {

    LinkedList<String> playlist = new LinkedList<>();

    // Play a Song
    public void playSong(String song) {

        playlist.addFirst(song); // Add at the beginning

        // Keep only latest 10 songs
        if (playlist.size() > 10) {
            playlist.removeLast();
        }

        System.out.println(song + " added to Recently Played.");
    }

    // Search Song
    public void searchSong(String song) {
        if (playlist.contains(song)) {
            System.out.println(song + " is present in Recently Played.");
        } else {
            System.out.println(song + " is not present.");
        }
    }

    // Display Playlist
    public void displayPlaylist() {
        System.out.println("\nRecently Played Songs:");

        for (String song : playlist) {
            System.out.println(song);
        }
    }

    public static void main(String[] args) {

        MusicPlaylist mp = new MusicPlaylist();

        mp.playSong("Shape of You");
        mp.playSong("Believer");
        mp.playSong("Perfect");
        mp.playSong("Levitating");
        mp.playSong("Blinding Lights");
        mp.playSong("Closer");
        mp.playSong("Senorita");
        mp.playSong("Peaches");
        mp.playSong("Stay");
        mp.playSong("Calm Down");
        mp.playSong("Heat Waves"); // Removes oldest song

        mp.searchSong("Perfect");

        mp.displayPlaylist();
    }
}