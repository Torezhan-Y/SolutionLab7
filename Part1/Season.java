package Part1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class Season implements Iterable<Episode> {
    private final List<Episode> episodes = new ArrayList<>();

    public void addEpisode(Episode episode) {
        episodes.add(episode);
    }

    public EpisodeIterator createIterator() {
        return new SeasonIterator(episodes);
    }

    public EpisodeIterator createReverseIterator() {
        return new ReverseSeasonIterator(episodes);
    }

    public EpisodeIterator createShuffleIterator(long seed) {
        return new ShuffleSeasonIterator(episodes, seed);
    }

    @Override
    public Iterator<Episode> iterator() {
        return episodes.iterator();
    }

    public List<Episode> getEpisodes() {
        return Collections.unmodifiableList(episodes);
    }
}
