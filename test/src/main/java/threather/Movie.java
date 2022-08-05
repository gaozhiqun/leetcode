package threather;


import java.util.Map;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/8/2 下午1:03
 */

public class Movie {

    public String name;

    public String theaterName;

    private Long startTime;

    private Long endTime;

    Map<Integer, Map<Integer, Seat>> seatMap;

    private int total;

    private int remain;

    private int sold;


}
