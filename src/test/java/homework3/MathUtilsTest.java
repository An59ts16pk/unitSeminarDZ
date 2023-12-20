package homework3;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

class MathUtilsTest {

    @ParameterizedTest
    @ValueSource(ints = {-8, -4, 0, 6, 20})
    void testEvenNumbers(int n) {
        assertTrue(MathUtils.evenOddNumber(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {-13, -5, 7, 23})
    void testOddNumbers(int n) {
        assertFalse(MathUtils.evenOddNumber(n));
    }

    @ParameterizedTest
    @ValueSource(ints = {25, 30, 100})
    void numberInIntervalTrue() {
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 5, 26, 101, 230})
    void numberInIntervalFalse() {
    }
}