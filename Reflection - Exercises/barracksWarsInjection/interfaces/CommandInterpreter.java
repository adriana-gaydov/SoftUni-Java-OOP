package barracksWars.interfaces;

public interface CommandInterpreter {

	Command interpretCommand(String[] data, String commandName);
}
