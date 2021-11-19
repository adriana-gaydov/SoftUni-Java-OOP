package barracksWars.core.commands;

import barracksWars.core.factories.UnitFactoryImpl;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class Retire extends Command {

    public Retire(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        String unitType = getData()[1];
        try {
            getRepository().removeUnit(unitType);
            return String.format("%s retired!", unitType);
        } catch (IllegalArgumentException e) {
            return e.getMessage();
        }
    }
}
