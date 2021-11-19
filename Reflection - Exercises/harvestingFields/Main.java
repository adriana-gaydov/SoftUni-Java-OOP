package harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Class<RichSoilLand> clazz = RichSoilLand.class;
		Field[] fields = clazz.getDeclaredFields();
		Scanner sc = new Scanner(System.in);
		
		String input = sc.nextLine();
		while (!input.equals("HARVEST")) {
			printFields(fields, input);
			input = sc.nextLine();
		}
	}

	private static void printFields(Field[] fields, String input) {
		Arrays.stream(getFilteredFields(fields, input))
				.forEach(f -> {
					System.out.printf("%s %s %s%n", Modifier.toString(f.getModifiers()), f.getType().getSimpleName(), f.getName());
				});
	}

	private static Field[] getFilteredFields(Field[] fields, String input) {
		if (input.equals("all")) {
			return fields;
		}

		return 	Arrays.stream(fields)
				.filter(f -> Modifier.toString(f.getModifiers()).contains(input))
				.toArray(Field[]::new);
	}
}
