package GreedyTimes;

import java.util.LinkedHashMap;

public class Sorter {
    public static LinkedHashMap<String, Long> sort(LinkedHashMap<String, Long> data) {
        LinkedHashMap<String, Long> sortedMap = new LinkedHashMap<>();
        data.entrySet().stream().sorted((e1, e2) -> {
            int sortedResult = e2.getKey().compareTo(e1.getKey());
            if (sortedResult == 0) {
                sortedResult = Long.compare(e1.getValue(), e2.getValue());
            }
            return sortedResult;
        }).forEach(e -> sortedMap.put(e.getKey(), e.getValue()));
        return sortedMap;
    }
}
