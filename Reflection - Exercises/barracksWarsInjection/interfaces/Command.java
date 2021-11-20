package barracksWars.interfaces;

import java.lang.reflect.InvocationTargetException;

public interface Command {

	String execute() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException;

}
