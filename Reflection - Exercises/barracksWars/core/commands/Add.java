package barracksWars.core.commands;

import barracksWars.core.factories.UnitFactoryImpl;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class Add extends Command {

    public Add(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        UnitFactory unitFactory = new UnitFactoryImpl();
        String unitType = getData()[1];
        Unit unit = unitFactory.createUnit(unitType);

       getRepository().addUnit(unit);
        return unitType + " added!";
    }
}
