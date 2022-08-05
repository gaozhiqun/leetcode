package threather;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/8/2 下午1:11
 */
public class TheaterManager {

    private Map<String, Theater> nameMap;

    private TreeMap<Long, Movie> timeMap;

    private TheaterManager() {

    }

    public static class HOLDER {
        private static TheaterManager INSTANCE = new TheaterManager();
    }

    public static TheaterManager getInstance() {
        return HOLDER.INSTANCE;
    }


    public void addTheater(String name) {
        nameMap.put(name, new Theater());
    }

    public void addMovie(Movie movie, String theatherName) {
        Theater theater = nameMap.get(theatherName);
        theater.addMovie(movie);
    }

    public Movie getMovie(String movieName, Long startTime) {
        for (Movie movie : timeMap.values()) {
            if (movie.name.equals(movieName)) {
                return movie;
            }
        }
        return null;
    }

    private List<Movie> movieList() {
        return new ArrayList<>(timeMap.values());
    }

    public List<Seat> checkAndLock(Order order) {
        Movie movie = order.Movie;
        List<Seat> availables = new ArrayList<>();
        synchronized (movie) {
            for (Seat seat : order.seats) {
                int row = seat.row;
                int col = seat.col;
                Seat seatInfo = movie.seatMap.get(row).get(col);
                if (seatInfo.status >= 0) {
                    return null;
                }
                availables.add(seatInfo);
            }
        }

        for (Seat seat : availables) {
            seat.status = 1;
            seat.lockUUID = order.uuid;
        }
        return availables;
    }

    public List<Ticket> buyAndPay(Order order) {
        // check uuid
        pay(order);
        List<Ticket> tickets = new ArrayList<>();
        return tickets;

    }

    private void pay(Order order) {

    }

    public List<Movie> rangeSearch(Long startTime, Long endTime) {
        SortedMap<Long, Movie> map1 = timeMap.tailMap(startTime);
        SortedMap<Long, Movie> map2 = timeMap.headMap(endTime);
        List<Movie> list = new ArrayList<>();
        for (Map.Entry<Long, Movie> entry : map1.entrySet()) {
            if (map2.containsKey(entry.getKey())) {
                list.add(entry.getValue());
            }
        }
        return list;

    }
}
