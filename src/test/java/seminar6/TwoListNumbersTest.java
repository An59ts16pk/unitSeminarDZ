package seminar6;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class TwoListNumbersTest {
    /**
    * listFirst - first list for test.
    */
    List<Integer> listFirst = Arrays.asList(5, 6, 7, 8, 9);
    /**
     * listSecond - second list for test.
     */
    List<Integer> listSecond = Arrays.asList(0, 1, 2, 3, 4);

    @Test
    void testCalculateAverageValueList() {
        TwoListNumbers towListNumbers = new TwoListNumbers(listFirst, listSecond);
        double sum = listFirst.stream().reduce(0, Integer::sum);
        double avg = sum / listFirst.size();
        assertEquals(avg, towListNumbers.calculateAverageValueList(towListNumbers.firstList));
    }

    @Test
    void testAverageFirstMoreThanSecondAverage() {
        TwoListNumbers listNumbers = new TwoListNumbers(listFirst, listSecond);
        assertEquals("Первый список имеет большее среднее значение",
                listNumbers.compareAverageValueLists(listNumbers.firstList, listNumbers.secondList));
    }

    @Test
    void testAverageSecondMoreThanFirstAverage() {
        TwoListNumbers listNumbers = new TwoListNumbers(listSecond, listFirst);
        assertEquals("Второй список имеет большее среднее значение",
                listNumbers.compareAverageValueLists(listNumbers.firstList, listNumbers.secondList));
    }

    @Test
    void testAverageValuesAreEqual() {
        TwoListNumbers listNumbers = new TwoListNumbers(listSecond, listSecond);
        assertEquals("Средние значения равны",
                listNumbers.compareAverageValueLists(listNumbers.firstList, listNumbers.secondList));
    }

    @Test
    void testEmptyList() {
        List<Integer> listEmpty = new ArrayList<>();
        TwoListNumbers listNumbers = new TwoListNumbers(listEmpty, listEmpty);
        TwoListNumbers listNumbersFirst = new TwoListNumbers(listFirst, listEmpty);
        TwoListNumbers listNumbersSecond = new TwoListNumbers(listEmpty, listSecond);
        assertEquals("Один или оба списка пустые, сравнивать нечего!",
                listNumbers.compareAverageValueLists(listNumbers.firstList, listNumbers.secondList));
        assertEquals("Один или оба списка пустые, сравнивать нечего!",
                listNumbersFirst.compareAverageValueLists(listNumbersFirst.firstList, listNumbersFirst.secondList));
        assertEquals("Один или оба списка пустые, сравнивать нечего!",
                listNumbersSecond.compareAverageValueLists(listNumbersSecond.firstList, listNumbersSecond.secondList));
    }
}
