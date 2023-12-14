package homework1.task1;

/*
 * В классе Calculator создайте метод calculateDiscount,
 * который принимает сумму покупки и процент скидки и возвращает сумму с учетом скидки.
 * Ваша задача - проверить этот метод с использованием библиотеки AssertJ.
 * Если метод calculateDiscount получает недопустимые аргументы, он должен выбрасывать
 * исключение ArithmeticException. Не забудьте написать тесты для проверки этого поведения.
 */

public class Calculator {

    /*
     * Рассчет итоговой стоимости покупки
     * @param purchaseAmount - базвоая стоимость покупки
     * @param discountAmount - скидка на покупку
     * @return итоговая стоимость покупки
     */

    public double calculateDiscount(double purchaseAmount, double discountAmount) {
        if (purchaseAmount <= 0) {
            throw new ArithmeticException("Cost cannot be less than or equal to 0");
        }
        if (discountAmount > 100) {
            throw new ArithmeticException("The discount cannot be more than 100%");
        }
        if (discountAmount < 0) {
            throw new ArithmeticException("The discount cannot be negative");
        }
        return purchaseAmount * ((100 - discountAmount) / 100);
    }
}
