package threather;

import java.util.List;
import java.util.UUID;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/8/2 下午1:08
 */
public class Client {

    private TheaterManager theaterManager = TheaterManager.getInstance();

    private List<Ticket> preCheckAndLock(String threatherName, String movieName, Long startTime, List<Seat> seats) {
        Order order = new Order();
        String uuid = UUID.randomUUID().toString();
        order.uuid = uuid;
        order.threaterName = uuid;
        Movie movie = theaterManager.getMovie(movieName, startTime);
        order.Movie = movie;
        order.uuid = uuid;
        List<Seat> seatsInfo = theaterManager.checkAndLock(order);
        if (seatsInfo == null || seats.isEmpty()) {
            throw new IllegalArgumentException("Movies order failed");
        }
        return theaterManager.buyAndPay(order);
        //TODO

    }


}
