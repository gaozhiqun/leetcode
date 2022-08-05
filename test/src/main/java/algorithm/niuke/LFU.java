package algorithm.niuke;

import java.util.*;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/6/19 下午5:37
 */
public class LFU {


    /**
     * 被调用set或者get的次数最少
     *
     * @param operators
     * @param k
     * @return
     */

    private Map<Integer, Entry> map;
    private Map<Integer, LinkedList<Entry>> freqMap;
    int size, minFreq;


    public int[] LFU(int[][] operators, int k) {
        // write code here
        this.map = new HashMap<>();
        this.freqMap = new HashMap<>();
        this.size = k;
        this.minFreq = 0;
        int len = (int)Arrays.stream(operators).filter(x -> x[0] == 2).count();
        int[] res = new int[len];
        //遍历所有操作
        for(int i = 0, j = 0; i < operators.length; i++){
            if(operators[i][0] == 1)
                //set操作
                set(operators[i][1], operators[i][2]);
            else
                //get操作
                res[j++] = get(operators[i][1]);
        }
        return res;


    }

    private void update(Entry entry, int k, int v) {
        int freq = entry.fre;
        freqMap.get(freq).remove(entry);
        if (freqMap.get(freq).isEmpty()) {
            freqMap.remove(freq);
            if (minFreq == freq) {
                minFreq++;
            }
        }
        LinkedList<Entry> list = freqMap.computeIfAbsent(freq + 1, f -> new LinkedList<>());
        entry.fre++;
        list.addFirst(entry);
    }

    private void set(int k, int v) {
        Entry entry = map.get(k);
        if (entry == null) {
            if (size == 0) {
                int oldkey = freqMap.get(minFreq).getLast().key;
                freqMap.get(minFreq).removeLast();
                if (freqMap.get(minFreq).isEmpty())
                    freqMap.remove(minFreq);
                map.remove(oldkey);
            } else {
                --size;
                minFreq = 1;
                if (!freqMap.containsKey(1))
                    freqMap.put(1, new LinkedList<Entry>());
                freqMap.get(1).addFirst(new Entry(1, k, v));
                map.put(k, freqMap.get(1).getFirst());
            }
        } else {
            update(entry, k, v);
        }
    }

    private int get(int key) {
        int res = -1;
        //查找哈希表
        if (map.containsKey(key)) {
            Entry entry = map.get(key);
            //根据哈希表直接获取值
            res = entry.val;
            //更新频率
            update(entry, key, res);
        }
        return res;
    }

    public static class Entry {
        int key;
        int val;
        int fre;

        public Entry(int freq, int k, int v) {
            this.fre = freq;
            this.key = k;
            this.val = v;
        }
    }

}
