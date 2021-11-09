package Telephony;

import java.util.List;
import java.util.regex.Pattern;

public class Smartphone implements Browsable, Callable {
    private final Pattern patternUrl = Pattern.compile("^[^0-9]*$");
    private final Pattern patternNumber = Pattern.compile("^[0-9]+$");

    private List<String> numbers;
    private List<String> urls;

    public Smartphone(List<String> numbers, List<String> urls) {
        this.numbers = numbers;
        this.urls = urls;
    }


    @Override
    public String browse() {
        StringBuilder stringBuilder = new StringBuilder();
        this.urls.forEach(e -> {
            if (!patternUrl.matcher(e).find()) {
                stringBuilder.append("Invalid URL!").append(System.lineSeparator());
            } else {
                stringBuilder.append(String.format("Browsing: %s!%n", e));
            }
        });
        return stringBuilder.toString();
    }

    @Override
    public String call() {
        StringBuilder stringBuilder = new StringBuilder();
        this.numbers.forEach(e -> {
            if (!patternNumber.matcher(e).find()) {
                stringBuilder.append("Invalid number!").append(System.lineSeparator());
            } else {
                stringBuilder.append(String.format("Calling... %s%n", e));
            }
        });
        return stringBuilder.toString();
    }
}
