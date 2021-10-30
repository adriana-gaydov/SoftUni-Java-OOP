package GreedyTimes;

import java.util.LinkedHashMap;

public abstract class Item {
    private LinkedHashMap<String, Long> data;
    private String name;

    public Item(String name) {
        data = new LinkedHashMap<>();
        this.name = name;
    }

    public void add(String name, long value) {
        if (!data.containsKey(name)) {
            data.put(name, value);
        } else {
            data.put(name, data.get(name) + value);
        }
    }

    public void removeValue(String name, long value) {
        if (data.containsKey(name)) {
            data.put(name, data.get(name) - value);
            if (data.get(name) == 0) {
                data.remove(name);
            }
        }
    }

    public long getTotalAmount() {
        return this.data.values().stream().mapToLong(e -> e).sum();
    }

    public long getItemCount() {
        return this.data.size();
    }

    public String toString() {
        StringBuilder out = new StringBuilder(String.format("<%s> $%d%n",name, getTotalAmount()));
        this.data.forEach((key, value) ->out.append(String.format("##%s - %d%n", key, value)));
        return out.toString();
    }

    public void sort() {
        data = Sorter.sort(this.data);
    }
}
