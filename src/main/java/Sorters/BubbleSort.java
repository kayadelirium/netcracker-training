package Sorters;

import MyArrays.Array;

import java.util.Comparator;

/**
 * BubbleSort - sorter variant, implements ISorting {@link ISorting} interface
 */
public class BubbleSort<T> implements ISorting<T>{
    /**
     * bubble sorting implementation
     *
     * @param array      - array should be sorted
     * @param comparator - sorting rule for specified key
     * @return sorted array
     */
    @Override
    public Array<T> sort(Array<T> array, Comparator<T> comparator) {
        boolean isSorted = false;
        for (int i = 0; i < array.size() && !isSorted; i++) {
            isSorted = true;
            for (int j = 0; j < array.size() - i - 1; j++) {
                if (comparator.compare(array.get(j), array.get(j+1)) > 0) {
                    isSorted = false;
                    array.swap(j, j+1);
                }
            }
        }
        return array;
    }
}
