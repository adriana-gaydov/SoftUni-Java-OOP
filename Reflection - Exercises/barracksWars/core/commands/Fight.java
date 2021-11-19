package barracksWars.core.commands;

import barracksWars.core.factories.UnitFactoryImpl;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class Fight extends Command {

    public Fight(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        return "fight";
    }
}
