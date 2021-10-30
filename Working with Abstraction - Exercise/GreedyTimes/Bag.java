package GreedyTimes;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Bag {
    private Gold gold;
    private Cash cash;
    private Gem gem;
    private long capacity;

    public Bag(long capacity) {
        this.capacity = capacity;
        cash = new Cash();
        gem = new Gem();
        gold = new Gold();
    }

    public void add(String type, String name, long amount) {
        if (hasCapacity(amount)) {
            switch (type) {
                case "Gold":
                    gold.add(name, amount);
                    if (!keepRules()) {
                        gold.removeValue(name, amount);
                    }
                    break;
                case "Gem":
                    gem.add(name, amount);
                    if (!keepRules()) {
                        gem.removeValue(name, amount);
                    }
                    break;
                case "Cash":
                    cash.add(name, amount);
                    if (!keepRules()) {
                        cash.removeValue(name, amount);
                    }
                    break;
            }
        }
    }

    private boolean hasCapacity(long amount) {
        return gold.getTotalAmount() + gem.getTotalAmount() + cash.getTotalAmount() + amount <= capacity;
    }

    private boolean keepRules() {
        return gem.getTotalAmount() >= cash.getTotalAmount() && gold.getTotalAmount() >= gem.getTotalAmount();
    }

    private void sortItems() {
        gold.sort();
        gem.sort();
        cash.sort();
    }

    private List<Item> sort() {
        sortItems();
        List<Item> itemList = new ArrayList<>();
        itemList.add(gold);
        itemList.add(gem);
        itemList.add(cash);
        itemList.sort(Comparator.comparingLong(Item::getTotalAmount).reversed());
        return itemList;
    }

    public void print() {
        sort().stream().filter(e -> e.getItemCount() > 0).forEach(System.out::print);
    }

}
