package RandomArrayList;

public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> randomArrayList = new RandomArrayList<Integer>();

        for (int i = 1; i <= 10; i++) {
            randomArrayList.add(i);
        }
        System.out.println(randomArrayList.getRandomElement());
    }
}
