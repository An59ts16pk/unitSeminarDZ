package homework1.task1;

/*
 * В классе Calculator создайте метод calculateDiscount,
 * который принимает сумму покупки и процент скидки и возвращает сумму с учетом скидки.
 * Ваша задача - проверить этот метод с использованием библиотеки AssertJ.
 * Если метод calculateDiscount получает недопустимые аргументы, он должен выбрасывать
 * исключение ArithmeticException. Не забудьте написать тесты для проверки этого поведения.
 */

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {
    private homework1.task1.Calculator calculator;

    @BeforeEach
    void init() {
        calculator = new Calculator();
    }

    @AfterEach
    void cleanup() {
        calculator = null;
    }

    @Test
    @DisplayName("Тест дисконт калькулятора")
    void calculateDiscount() {
        assertEquals(95, calculator.calculateDiscount(100, 5));
    }

    @Test
    @DisplayName("Тест базовой суммы на равенство нолю")
    void purchaseAmountZero () {
        assertThrows(ArithmeticException.class, () -> calculator.calculateDiscount(0, 5),
                "Базовая сумма покупки не может быть равной нулю");
    }

    @Test
    @DisplayName("Тест базовой суммы на отрицательное значение")
    void purchaseAmountNegative () {
        assertThrows(ArithmeticException.class, () -> calculator.calculateDiscount(-50, 5),
                "Базовая сумма покупки не может быть отрицательной");
    }

    @Test
    @DisplayName("Тест дисконта на отрицательное значение")
    void discountAmountZero () {
        assertThrows(ArithmeticException.class, () -> calculator.calculateDiscount(100, -5),
                "Дисконт не может быть отрицательным");
    }

    @Test
    @DisplayName("Тест дисконта на значение больше 100")
    void discountAmountBig () {
        assertThrows(ArithmeticException.class, () -> calculator.calculateDiscount(100, 200),
                "Дисконт не может быть больше 100");
    }
}