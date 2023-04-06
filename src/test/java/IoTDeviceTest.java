import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

public class IoTDeviceTest {

    @Test
    public void formatReadings_validFormat_returns_true() {
        // Arrange
        Double testReading1 = 2.5, testReading2 = 0.5, testReading3 = 1.5;
        IoTDevice ioTDevice = new IoTDevice();
        ioTDevice.saveReading(testReading1);
        ioTDevice.saveReading(testReading2);
        ioTDevice.saveReading(testReading3);
        String expectedResult = "{ 'reported': [ " + testReading1 + "," + testReading2 + "," + testReading3 + ", ] }";
        // Act
        String result = ioTDevice.formatReadings();
        // Assert
        assertEquals(expectedResult, result);
    }

    @Test
    public void formatAverageReading_averageCorrectAndFormatted_returns_true() {
        // Arrange
        Double testReading1 = 2.5, testReading2 = 0.5, testReading3 = 1.5;
        IoTDevice ioTDevice = new IoTDevice();
        ioTDevice.saveReading(testReading1);
        ioTDevice.saveReading(testReading2);
        ioTDevice.saveReading(testReading3);
        String expectedResult = "{ 'average': " + (testReading1 + testReading2 + testReading3) / 3 + " }";
        // Act
        String result = ioTDevice.formatAverageReading();
        // Assert
        assertEquals(expectedResult, result);
    }

}
