package Part1;

import java.util.List;

public class BingeIterator implements EpisodeIterator {
    private final List<Season> seasons;
    private int seasonIndex = 0;
    private EpisodeIterator currentIterator;

    public BingeIterator(List<Season> seasons) {
        this.seasons = seasons;
        if (!seasons.isEmpty()) {
            currentIterator = seasons.get(0).createIterator();
        }
    }

    @Override
    public boolean hasNext() {
        if (currentIterator == null) {
            return false;
        }
        if (currentIterator.hasNext()) {
            return true;
        } else {
            seasonIndex++;
            if (seasonIndex < seasons.size()) {
                currentIterator = seasons.get(seasonIndex).createIterator();
                return hasNext();
            } else {
                return false;
            }
        }
    }

    @Override
    public Episode next() {
        if (hasNext()) {
            return currentIterator.next();
        }
        throw new IllegalStateException("No more episodes.");
    }
}
