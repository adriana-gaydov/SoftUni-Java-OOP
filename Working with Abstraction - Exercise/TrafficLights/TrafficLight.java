package TrafficLights;

public class TrafficLight {
    private Colors color;

    public TrafficLight(Colors color) {
        this.color = color;
    }

    public void changeColor() {
        switch (this.color) {
            case RED:
                this.color = Colors.valueOf("GREEN");
                return;
            case GREEN:
                this.color = Colors.valueOf("YELLOW");
                return;
            case YELLOW:
                this.color = Colors.valueOf("RED");
        }
    }

    @Override
    public String toString() {
        return color.toString();
    }
}
