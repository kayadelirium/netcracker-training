package Sorters;

import junit.framework.TestCase;
import MyArrays.Array;

public class BubbleSortTest extends TestCase {

    public void testSort() {
        ISorting<Integer> sorting = new BubbleSort<>();
        Array<Integer> array = new Array<>();

        array.add(2);
        array.add(5);
        array.add(3);
        array.add(4);
        array.add(1);

        Array<Integer> expected = new Array<>();
        for (int i=0; i<array.size(); i++){
            expected.add(i+1);
        }

        sorting.sort(array, Integer::compareTo);
        assertEquals(expected.size(), array.size());
        for(int i=0; i<expected.size(); i++){
            assertEquals(expected, array);
        }
    }
}