package barracksWars.core.factories;

import barracksWars.interfaces.Unit;
import barracksWars.interfaces.UnitFactory;
import jdk.jshell.spi.ExecutionControl;

import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

	private static final String UNITS_PACKAGE_NAME =
			"barracksWars.models.units.";

	@Override
	public Unit createUnit(String unitType) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
		Class<?> clazz = Class.forName(UNITS_PACKAGE_NAME + unitType);

		return (Unit) clazz.getConstructor().newInstance();
	}
}
