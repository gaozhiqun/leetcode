package threather;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/8/2 下午1:06
 */
public class Seat {

    public String movieName;

    public String theatherName;

    public int row;

    public int col;

    // 0: empty 1: locked 2: sold

    public int status;

    public String lockUUID;

    public Long startTime;

    public Long endTime;


}
