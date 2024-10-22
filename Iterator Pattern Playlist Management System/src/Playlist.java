import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private List<Song> songs;

    public Playlist() {
        songs = new ArrayList<>();
    }

    public void addSong(Song song) {
        songs.add(song);
    }

    public int size() {
        return songs.size();
    }

    public Song getSong(int index) {
        return songs.get(index);
    }

    // Method to get a sequential iterator
    public Iterator<Song> getSequentialIterator() {
        return new SequentialIterator();
    }

    // Method to get a shuffle iterator
    public Iterator<Song> getShuffleIterator() {
        return new ShuffleIterator();
    }

    // Method to get a genre filter iterator
    public Iterator<Song> getGenreFilterIterator(String genre) {
        return new GenreFilterIterator(genre);
    }

    private class SequentialIterator implements Iterator<Song> {
        private int index;

        @Override
        public boolean hasNext() {
            return index < songs.size();
        }

        @Override
        public Song next() {
            return songs.get(index++);
        }
    }

    private class ShuffleIterator implements Iterator<Song> {
        private List<Song> shuffledSongs;
        private int index;

        public ShuffleIterator() {
            shuffledSongs = new ArrayList<>(songs);
            java.util.Collections.shuffle(shuffledSongs);
            index = 0;
        }

        @Override
        public boolean hasNext() {
            return index < shuffledSongs.size();
        }

        @Override
        public Song next() {
            return shuffledSongs.get(index++);
        }
    }

    private class GenreFilterIterator implements Iterator<Song> {
        private String genre;
        private int index;

        public GenreFilterIterator(String genre) {
            this.genre = genre;
            index = 0;
            // Move the index to the first matching song
            while (index < songs.size() && !songs.get(index).getGenre().equals(genre)) {
                index++;
            }
        }

        @Override
        public boolean hasNext() {
            while (index < songs.size() && !songs.get(index).getGenre().equals(genre)) {
                index++;
            }
            return index < songs.size();
        }

        @Override
        public Song next() {
            return songs.get(index++);
        }
    }
}
