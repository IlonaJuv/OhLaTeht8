package Test;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import TimeUtils.TimeUtils;

public class MainTest {

    @ParameterizedTest(name = "converting seconds")
    @CsvSource({ "3665, 1:01:05","86399, 23:59:59","0, 0:00:00", "1, 0:00:01", "11, 0:00:11", "60, 0:01:00", "600, 0:10:00", "3600, 1:00:00", "36000, 10:00:00" })
    void testSecToTime(int seconds, String expected) {
        String result = TimeUtils.secToTime(seconds);
        String wrongText = "Seconds " + seconds + " printed wrong";
        assertEquals(expected, result, wrongText);
    }

    @Test
    void testInvalidInputString() {
        // Yritetään syöttää merkkijono "abc" ja odotetaan, että se aiheuttaa NumberFormatExceptionin
        assertThrows(NumberFormatException.class, () -> {
            TimeUtils.secToTime(Integer.parseInt("two"));
        });
    }

    @Test
    void testNegativeInput() {
            int invalidInput = -3;
            String wrongText = "Seconds " + invalidInput + " printed wrong";
            String result = TimeUtils.secToTime(invalidInput);
            assertEquals("-1", result, wrongText);
    }
    // yli vuorokauden sekunnit
    @Test
    void testLargeInput() {
        int largeNumber = 86460;
        String result = TimeUtils.secToTime(largeNumber);
        String wrongText = "Seconds " + largeNumber + " printed wrong";
        assertEquals("-1", result, wrongText);
    }
}