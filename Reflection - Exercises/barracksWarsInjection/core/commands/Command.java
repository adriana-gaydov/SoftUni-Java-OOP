package barracksWars.core.commands;

public abstract class Command implements barracksWars.interfaces.Command {

    private String[] data;

    protected Command(String[] data) {
        this.data = data;
    }

    public String[] getData() {
        return data;
    }


}
