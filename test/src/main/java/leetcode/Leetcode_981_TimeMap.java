package leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author zhiqungao@tencent.com
 * @date 2022/3/22 下午8:56
 */
public class Leetcode_981_TimeMap {

    /**
     * 设计一个基于时间的键值数据结构，该结构可以在不同时间戳存储对应同一个键的多个值，并针对特定时间戳检索键对应的值。
     */
    public static class TimeMap {

        Map<String, TreeMap<Integer, String>> map;

        public TimeMap() {
            map = new HashMap<>();
        }

        public void set(String key, String value, int timestamp) {
            TreeMap<Integer, String> treeMap = map.computeIfAbsent(key, f -> new TreeMap<>());
            treeMap.put(timestamp, value);
        }

        public String get(String key, int timestamp) {
            TreeMap<Integer, String> treeMap = map.computeIfAbsent(key, f -> new TreeMap<>());
            Map.Entry<Integer, String> entry = treeMap.floorEntry(timestamp);
            return entry == null ? "" : entry.getValue();
        }
    }
}
