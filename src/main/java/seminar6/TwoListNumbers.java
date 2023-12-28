/*
Задание 1.
Создайте программу на Python или Java, которая принимает два списка чисел и
выполняет следующие действия:
a. Рассчитывает среднее значение каждого списка.
b. Сравнивает эти средние значения и выводит соответствующее сообщение:
- Первый список имеет большее среднее значение"", если среднее значение
  первого списка больше.
- Второй список имеет большее среднее значение"", если среднее значение
  второго списка больше.
- Средние значения равны"", если средние значения списков равны.
Важно:
Приложение должно быть написано в соответствии с принципами объектно-
ориентированного программирования. Используйте Pytest (для Python) или
JUnit (для Java) для написания тестов, которые проверяют правильность
работы программы. Тесты должны учитывать различные сценарии использования
вашего приложения. Используйте pylint (для Python) или Checkstyle (для Java)
для проверки качества кода. Сгенерируйте отчет о покрытии кода тестами. Ваша
цель - достичь минимум 90% покрытия.
*/

package seminar6;

import java.util.List;

/**
* TwoListNumbers - class for comparing arithmetic averages of two lists.
*/
public class TwoListNumbers {
    /**
    * firstList - first list.
    */
    List<Integer> firstList;
    /**
    * secondList - second list.
    */
    List<Integer> secondList;
    /**
    * @param firstList - first list.
    * @param secondList - second list.
    */
    public TwoListNumbers(List<Integer> firstList, List<Integer> secondList) {
        this.firstList = firstList;
        this.secondList = secondList;
    }

    /**
    * @param numsList - list numbers.
    * @return - return double number.
    */
    public double calculateAverageValueList(List<Integer> numsList) {
        double sum = numsList.stream().reduce(0, Integer::sum);
        return sum / numsList.size();
    }

    /**
    * @param listOne - list numbers.
    * @param listTwo - list numbers.
    * @return - return String result.
    */
    public String compareAverageValueLists(List<Integer> listOne, List<Integer> listTwo) {
        double firstAvg = calculateAverageValueList(listOne);
        double secondAvg = calculateAverageValueList(listTwo);

        if (listOne.isEmpty() || listTwo.isEmpty()) {
            return "Один или оба списка пустые, сравнивать нечего!";
        }

        if (firstAvg > secondAvg) {
            return "Первый список имеет большее среднее значение";
        } else if (firstAvg < secondAvg) {
            return "Второй список имеет большее среднее значение";
        } else {
            return "Средние значения равны";
        }
    }
}
