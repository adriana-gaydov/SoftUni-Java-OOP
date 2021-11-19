package barracksWars.interfaces;

import java.lang.reflect.InvocationTargetException;

public interface Executable {

	String execute() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

}
