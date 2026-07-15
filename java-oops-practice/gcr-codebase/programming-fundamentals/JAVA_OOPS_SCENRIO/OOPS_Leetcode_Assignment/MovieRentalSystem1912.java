import java.util.*;

class MovieRentalSystem {

    class Entry {
        int shop;
        int movie;
        int price;

        Entry(int shop, int movie, int price) {
            this.shop = shop;
            this.movie = movie;
            this.price = price;
        }
    }

    // movie -> available copies
    Map<Integer, TreeSet<Entry>> available;

    // rented movies
    TreeSet<Entry> rented;

    // (shop,movie) -> price
    Map<String, Integer> priceMap;

    public MovieRentalSystem(int n, int[][] entries) {

        available = new HashMap<>();

        priceMap = new HashMap<>();

        rented = new TreeSet<>((a, b) -> {

            if (a.price != b.price)
                return a.price - b.price;

            if (a.shop != b.shop)
                return a.shop - b.shop;

            return a.movie - b.movie;
        });

        for (int[] e : entries) {

            int shop = e[0];
            int movie = e[1];
            int price = e[2];

            Entry obj = new Entry(shop, movie, price);

            available.putIfAbsent(movie,
                    new TreeSet<>((a, b) -> {

                        if (a.price != b.price)
                            return a.price - b.price;

                        return a.shop - b.shop;
                    }));

            available.get(movie).add(obj);

            priceMap.put(shop + "#" + movie,
                    price);
        }
    }

    public List<Integer> search(int movie) {

        List<Integer> ans =
                new ArrayList<>();

        if (!available.containsKey(movie))
            return ans;

        int count = 0;

        for (Entry e :
                available.get(movie)) {

            ans.add(e.shop);

            count++;

            if (count == 5)
                break;
        }

        return ans;
    }

    public void rent(int shop,
                     int movie) {

        int price =
                priceMap.get(shop + "#" + movie);

        Entry target =
                new Entry(shop,
                        movie,
                        price);

        available.get(movie)
                .removeIf(e ->
                        e.shop == shop);

        rented.add(target);
    }

    public void drop(int shop,
                     int movie) {

        int price =
                priceMap.get(shop + "#" + movie);

        Entry target =
                new Entry(shop,
                        movie,
                        price);

        rented.removeIf(e ->
                e.shop == shop
                        &&
                        e.movie == movie);

        available.get(movie)
                .add(target);
    }

    public List<List<Integer>> report() {

        List<List<Integer>> ans =
                new ArrayList<>();

        int count = 0;

        for (Entry e : rented) {

            ans.add(
                    Arrays.asList(
                            e.shop,
                            e.movie
                    )
            );

            count++;

            if (count == 5)
                break;
        }

        return ans;
    }
}