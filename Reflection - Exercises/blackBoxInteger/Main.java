package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner sc = new Scanner(System.in);

        Class<BlackBoxInt> clazz = BlackBoxInt.class;
        Constructor<BlackBoxInt> ctor = clazz.getDeclaredConstructor();

        ctor.setAccessible(true);
        BlackBoxInt blackBoxInt = ctor.newInstance();

        String input = sc.nextLine();
        while (!input.equals("END")) {
            String[] tokens = input.split("_");

            Method declaredMethods = clazz.getDeclaredMethod(tokens[0], int.class);
            declaredMethods.setAccessible(true);
            declaredMethods.invoke(blackBoxInt, Integer.parseInt(tokens[1]));

            Field innerValue = clazz.getDeclaredField("innerValue");
            innerValue.setAccessible(true);
            System.out.println(innerValue.get(blackBoxInt));

            input = sc.nextLine();
        }
    }
}
