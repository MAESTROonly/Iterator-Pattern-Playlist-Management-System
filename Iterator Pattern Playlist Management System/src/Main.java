public class Main {
    public static void main(String[] args) {
        Playlist playlist = new Playlist();

        // Adding songs to the playlist
        playlist.addSong(new Song("Song A", "Artist 1", "Pop"));
        playlist.addSong(new Song("Song B", "Artist 2", "Rock"));
        playlist.addSong(new Song("Song C", "Artist 1", "Pop"));
        playlist.addSong(new Song("Song D", "Artist 3", "Jazz"));
        playlist.addSong(new Song("Song E", "Artist 2", "Rock"));

        System.out.println("Sequential Order:");
        Iterator<Song> sequentialIterator = playlist.getSequentialIterator();
        while (sequentialIterator.hasNext()) {
            System.out.println(sequentialIterator.next());
        }

        System.out.println("\nShuffle Order:");
        Iterator<Song> shuffleIterator = playlist.getShuffleIterator();
        while (shuffleIterator.hasNext()) {
            System.out.println(shuffleIterator.next());
        }

        System.out.println("\nFiltered by Genre (Pop):");
        Iterator<Song> genreFilterIterator = playlist.getGenreFilterIterator("Pop");
        while (genreFilterIterator.hasNext()) {
            System.out.println(genreFilterIterator.next());
        }
    }
}
