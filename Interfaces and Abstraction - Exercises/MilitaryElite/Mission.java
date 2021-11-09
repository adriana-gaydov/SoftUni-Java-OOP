package MilitaryElite;

public class Mission {
    private String codeName;
    private State state;

    public Mission(String codeName, String state) {
        this.codeName = codeName;
        this.setState(state);
    }

    private void setState(String state) {
        if (!(state.equals("inProgress") || state.equals("finished"))) {
            throw new IllegalArgumentException();
        }
        this.state = State.valueOf(state);
    }

    @Override
    public String toString() {
        return String.format("Code Name: %s State: %s", codeName, state);
    }
}
