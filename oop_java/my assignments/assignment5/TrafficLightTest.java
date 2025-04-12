package assignment5;

public class TrafficLightTest {
    public static void main(String[] args) {
    	
        for (TrafficLight light : TrafficLight.values()) {
            System.out.println(light + " light lasts for " + light.getDuration() + " seconds.");
        }
    }
}