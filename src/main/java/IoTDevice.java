import java.util.ArrayList;
import java.util.List;

public class IoTDevice {
    private List<Double> readings;

    public IoTDevice() {
        readings = new ArrayList<>();
    }
    
    public void saveReading(Double reading) {
        readings.add(reading);
    }
    public void clearReadings() {
        readings.clear();
    }
    public String formatReadings() {
        StringBuilder format = new StringBuilder("{ 'reported': [ ");
        for (Double reading : readings) {
            format.append(reading).append(",");
        }
        format.append(" ] }");
        return format.toString();
    }
    public String formatAverageReading() {
        String format = "{ 'average': ";
        Double total = 0.0;
        for (Double reading : readings) {
            total += reading;
        }
        format += total / readings.size() + " }";
        return format;
    }
}
