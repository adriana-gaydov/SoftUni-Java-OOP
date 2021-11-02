package StackOfStrings;

import java.util.ArrayList;

public class StackOfStrings {
    private ArrayList<String> data;
    private int index = -1;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
        index++;
    }

    public String pop() {
        return this.data.remove(index--);
    }

    public String peek() {
        return this.data.get(index);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
