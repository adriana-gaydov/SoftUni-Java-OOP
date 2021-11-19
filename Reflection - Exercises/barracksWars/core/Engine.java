package barracksWars.core;

import barracksWars.core.commands.Command;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Runnable;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Locale;

public class Engine implements Runnable {

	private Repository repository;
	private UnitFactory unitFactory;

	public Engine(Repository repository, UnitFactory unitFactory) {
		this.repository = repository;
		this.unitFactory = unitFactory;
	}

	@Override
	public void run() {
		BufferedReader reader = new BufferedReader(
				new InputStreamReader(System.in));
		while (true) {
			try {
				String input = reader.readLine();
				String[] data = input.split("\\s+");
				String commandName = data[0];
				String result = interpretCommand(data, commandName);
				if (result.equals("fight")) {
					break;
				}
				System.out.println(result);
			} catch (RuntimeException e) {
				System.out.println(e.getMessage());
			} catch (IOException | IllegalAccessException | ClassNotFoundException | InvocationTargetException | NoSuchMethodException | InstantiationException e) {
				e.printStackTrace();
			}
		}
	}

	// TODO: refactor for problem 4
	private String interpretCommand(String[] data, String commandName) throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
		String result;

		String command = commandName.substring(0, 1).toUpperCase() + commandName.substring(1);

		Class<?> clazz = Class.forName("barracksWars.core.commands." + command);
		Constructor<Command> ctor = (Constructor<Command>) clazz.getConstructor(String[].class, Repository.class, UnitFactory.class);

		Command c = ctor.newInstance(data, this.repository, this.unitFactory);

		return 	c.execute();
	}
}
