package assignment5;

public enum TrafficLight {
    RED(30),    
    GREEN(60),
    YELLOW(10);

    private final int duration;

    TrafficLight(int duration) {
        this.duration = duration;
    }

    public int getDuration() {
        return duration;
    }
}