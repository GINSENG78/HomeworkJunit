import org.junit.Test;
import Week.Week;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class WeekTest {
    @Test
    public void getPositiveDay() {
        int a = 1;
        String actualResult = Week.getPositiveDay(1);
        String expectedResult = "Sunday";
        assertEquals(actualResult, expectedResult);

    }

    @Test
    public void getNegativeDay() {
        int a = 1;
        String actualResult = Week.getPositiveDay(0);
        String expectedResult = "The number should be equal or larger than 1";
        assertEquals(actualResult, expectedResult);

    }

    @Test
    @DisplayName("Null pointer Exception test")
            public void nullDay(){
        Week week = new Week();
        assertThrows(NullPointerException.class,()->{week.getPositiveDay(null);});
    }

    @ParameterizedTest
    @MethodSource ("getDay")
    void getDay(int dayNumber, String dayName) {
        assertEquals(dayName,Week.getPositiveDay(dayNumber));
    }
        private static Stream<Arguments> getDay() {
            return Stream.of(
                    Arguments.of(1, "Sunday"),
            Arguments.of(2, "Monday"),
            Arguments.of(3, "Tuesday"),
            Arguments.of(4, "Wednesday"),
            Arguments.of(5, "Thursday"),
            Arguments.of(6, "Friday"),
            Arguments.of(7, "Saturday")
    );
        }


}
