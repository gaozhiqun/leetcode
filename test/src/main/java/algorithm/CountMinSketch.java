package algorithm;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @author zhiqungao@tencent.com
 * @date 2021/2/22 12:39 下午
 */
public class CountMinSketch {
    /**
     * 创建一个长度为 x 的数组，用来计数，初始化每个元素的计数值为 0；
     * 对于一个新来的元素，哈希到 0 到 x 之间的一个数，比如哈希值为 i，作为数组的位置索引；
     * 这时，数组对应的位置索引 i 的计数值加 1；
     * 多个Hash，获取最小值，也是bloom filter的一个变种
     *
     */
    public static final int NUM_SLOTS=1024*1024*8;
    public static final int NUM_HASH=8;
    private BigInteger bitmap = new BigInteger("0");

    /***
     * 使用了md5值来生成n个不同的hash值
     * @param message
     * @param n
     * @return
     */
    private int getHash(String message,int n){
        try {
            MessageDigest md5 = MessageDigest.getInstance("md5");
            message  = message +String.valueOf(n);
            byte[] bytes = message.getBytes();
            md5.update(bytes);
            BigInteger bi = new BigInteger(md5.digest());

            return Math.abs(bi.intValue())%NUM_SLOTS;
        } catch (NoSuchAlgorithmException ex) {
            Logger.getLogger(CountMinSketch.class.getName()).log(Level.SEVERE, null, ex);
        }
        return -1;
    }

    public void addElement(String message){
        for(int i=0;i<NUM_HASH;i++){
            int hashcode = getHash(message,i);
            if(!bitmap.testBit(hashcode)){
                bitmap = bitmap.or(new BigInteger("1").shiftLeft(hashcode));
            }
        }

    }

    public boolean check(String message){
        for(int i=0;i<NUM_HASH;i++){
            int hashcode = getHash(message,i);
            if(!this.bitmap.testBit(hashcode)){
                return false;
            }
        }
        return true;
    }
}
