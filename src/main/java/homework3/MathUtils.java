package homework3;

public class MathUtils {
    private final static int LIMIT_MIN = 25;
    private final static int LIMIT_MAX = 100;

    // HW 3.1. Нужно покрыть тестами метод на 100%
    // Метод проверяет, является ли целое число записанное в переменную n, чётным (true) либо нечётным (false).
    public static boolean evenOddNumber(int n) {
        return n % 2 == 0;
    }

    // HW 3.2. Нужно написать метод который проверяет, попадает ли переданное число в интервал (25;100) и возвращает
    // true, если попадает и false - если нет,
    // покрыть тестами метод на 100%
    public static boolean numberInInterval(int n) {
        return n >= LIMIT_MIN && n <= LIMIT_MAX;
    }
}

