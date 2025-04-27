package Part1;

public class Main {
    public static void main(String[] args) {

        Series series = new Series();

        Season season1 = new Season();
        season1.addEpisode(new Episode("S1E1: Pilot", 1800));
        season1.addEpisode(new Episode("S1E2: First Blood", 1900));
        season1.addEpisode(new Episode("S1E3: Revenge", 2000));

        Season season2 = new Season();
        season2.addEpisode(new Episode("S2E1: Return", 2100));
        season2.addEpisode(new Episode("S2E2: Darkness", 2200));


        series.addSeason(season1);
        series.addSeason(season2);

        System.out.println("--- Normal Order Season 1 ---");
        EpisodeIterator normal = season1.createIterator();
        while (normal.hasNext()) {
            System.out.println(normal.next());
        }

        System.out.println("\n--- Reverse Order Season 1 ---");
        EpisodeIterator reverse = season1.createReverseIterator();
        while (reverse.hasNext()) {
            System.out.println(reverse.next());
        }

        System.out.println("\n--- Shuffle Order Season 1 (seed=42) ---");
        EpisodeIterator shuffle = season1.createShuffleIterator(42);
        while (shuffle.hasNext()) {
            System.out.println(shuffle.next());
        }

        System.out.println("\n--- Binge Watch Entire Series ---");
        EpisodeIterator binge = series.createBingeIterator();
        while (binge.hasNext()) {
            System.out.println(binge.next());
        }
    }
}
