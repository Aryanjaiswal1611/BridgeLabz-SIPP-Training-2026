// Problem 3: Multi-Service Smart TV - Multiple interfaces with default method conflict

interface StreamingService {
    void streamMovie(String movie);

    default void showSubscriptionDetails() {
        System.out.println("[StreamingService] Basic plan: $9.99/mo | Premium: $14.99/mo");
    }
}

interface GamingService {
    void playGame(String game);

    default void showSubscriptionDetails() {
        System.out.println("[GamingService] Game pass: $9.99/mo | Ultimate: $14.99/mo");
    }
}

class SmartTV implements StreamingService, GamingService {
    private String[] movies;
    private String[] games;

    public SmartTV(String[] movies, String[] games) {
        this.movies = movies;
        this.games = games;
    }

    @Override
    public void streamMovie(String movie) {
        System.out.println("Now streaming: " + movie);
    }

    @Override
    public void playGame(String game) {
        System.out.println("Now playing: " + game);
    }

    @Override
    public void showSubscriptionDetails() {
        StreamingService.super.showSubscriptionDetails();
        GamingService.super.showSubscriptionDetails();
        System.out.println("[SmartTV Combo] Both services combined: $19.99/mo");
    }

    public void showAllContent() {
        System.out.println("\n--- Available Movies ---");
        for (String m : movies) {
            System.out.println("  " + m);
        }
        System.out.println("\n--- Available Games ---");
        for (String g : games) {
            System.out.println("  " + g);
        }
    }
}

public class Problem3_SmartTV {
    public static void main(String[] args) {
        System.out.println("=== Problem 3: Multi-Service Smart TV ===\n");

        String[] movies = { "Inception", "The Matrix", "Interstellar", "Tenet" };
        String[] games = { "Cyberpunk 2077", "Elden Ring", "Zelda: TOTK", "God of War" };

        SmartTV tv = new SmartTV(movies, games);

        tv.showAllContent();

        System.out.println("\n--- Resolving default method conflict ---");
        tv.showSubscriptionDetails();

        System.out.println("\n--- Using services ---");
        tv.streamMovie("Inception");
        tv.playGame("Elden Ring");
    }
}
