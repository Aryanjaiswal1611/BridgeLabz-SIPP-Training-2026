import java.util.HashMap;
import java.util.Map;

class UndergroundSystem {

    class CheckIn {

        String station;

        int time;

        CheckIn(String station,
                int time) {

            this.station = station;

            this.time = time;
        }
    }

    Map<Integer, CheckIn> checkIns;

    Map<String, int[]> routes;

    public UndergroundSystem() {

        checkIns = new HashMap<>();

        routes = new HashMap<>();
    }

    public void checkIn(
            int id,
            String stationName,
            int t) {

        checkIns.put(
                id,
                new CheckIn(
                        stationName,
                        t
                )
        );
    }

    public void checkOut(
            int id,
            String stationName,
            int t) {

        CheckIn c =
                checkIns.get(id);

        String route =
                c.station +
                        "-" +
                        stationName;

        int duration =
                t - c.time;

        routes.putIfAbsent(
                route,
                new int[2]
        );

        routes.get(route)[0] +=
                duration;

        routes.get(route)[1]++;

        checkIns.remove(id);
    }

    public double getAverageTime(
            String startStation,
            String endStation) {

        String route =
                startStation +
                        "-" +
                        endStation;

        int[] data =
                routes.get(route);

        return
                (double) data[0]
                        / data[1];
    }
}