package week01;

public class Temp {
    private double temperature;
    private static final double MIN_TEMP = -89.2; // lowest recorded temperature on Earth
    private static final double MAX_TEMP = 56.7; // highest recorded temperature on Earth

    public Temp(String temperature) {
        if (temperature == null || temperature.isEmpty()) {
            throw new IllegalArgumentException("Temperature cannot be null or empty");
        }
        try {
            validateTemperature(Double.parseDouble(temperature));
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid number format - please enter a temperature in Celsius without any special characters");
        }
    }

    private void validateTemperature(double temperature) {
        if (temperature < MIN_TEMP) {
            throw new IllegalArgumentException("Way too cold - We don't live on Neptune. Temperature: " + temperature + "°C");
        }
        if (temperature > MAX_TEMP) {
            throw new IllegalArgumentException("Way too warm - We don't live on Mars. Temperature: " + temperature + "°C");
        }
        this.temperature = temperature;
    }

    public double getTemperature() {
        return temperature;
    }

    @Override
    public String toString() {
        return String.format("%.2f°C", temperature);
    }
}