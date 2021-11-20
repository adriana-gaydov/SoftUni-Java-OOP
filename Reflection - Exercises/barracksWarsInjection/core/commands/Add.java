package barracksWars.core.commands;

import barracksWars.annotations.Inject;
import barracksWars.core.factories.UnitFactoryImpl;
import barracksWars.interfaces.Repository;
import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class Add extends Command {

    @Inject
    private Repository repository;

    public Add(String[] data) {
        super(data);
    }

    @Override
    public String execute() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException {
        UnitFactory unitFactory = new UnitFactoryImpl();
        String unitType = getData()[1];
        Unit unit = unitFactory.createUnit(unitType);

       this.repository.addUnit(unit);
       return unitType + " added!";
    }
}
