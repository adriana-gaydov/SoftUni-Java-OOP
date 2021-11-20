package barracksWars.core.commands;

import barracksWars.annotations.Inject;
import barracksWars.interfaces.CommandInterpreter;
import barracksWars.interfaces.Command;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMANDS_PACKAGE_PATH = "barracksWars.core.commands.";
    private Repository repository;
    private UnitFactory unitFactory;


    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Command interpretCommand(String[] data, String commandName) {
        Command command = null;
        commandName = Character.toUpperCase(commandName.charAt(0)) + commandName.substring(1);

        try {
            Class<? extends Command> clazz =
                    (Class<? extends Command>) Class.forName(COMMANDS_PACKAGE_PATH + commandName);

            Constructor<? extends Command> ctor =
                    clazz.getDeclaredConstructor(String[].class);

            ctor.setAccessible(true);
            command = ctor.newInstance((Object) data);

            this.injectFields(command);

        } catch (ClassNotFoundException | NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }

        return command;
    }

    private void injectFields(Command command) {
        Field[] fields = command.getClass().getDeclaredFields();
        Field[] currFields = this.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.getAnnotations()[0].toString().contains("Inject")) {
                for (Field currField : currFields) {
                    if (currField.getType().equals(field.getType())) {
                        field.setAccessible(true);
                        try {
                            field.set(command, currField.get(this));
                        } catch (IllegalAccessException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
        }
    }
}