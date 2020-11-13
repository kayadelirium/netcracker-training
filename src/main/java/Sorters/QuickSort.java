package Sorters;

import MyArrays.Array;

import java.util.Comparator;


/**
 * QuickSort - sorter variant, implements ISorting {@link ISorting} interface
 */
public class QuickSort<T> implements ISorting<T>{

    /**
     * quick sorting implementation
     * @param array - array should be sorted
     * @param comparator - sorting rule for specified key
     * @return sorted array
     */
    @Override
    public Array<T> sort(Array<T> array, Comparator<T> comparator){
        quickSort(array, comparator, 0, array.size() - 1);
        return array;
    }

    /**
     * static recurrent method describing quicksort
     * @param array - array should be sorted
     * @param comparator - sorting rule for specified key
     * @param left - left subarray boundary
     * @param right - right subarray boundary
     */
    private void quickSort(Array<T> array, Comparator<T> comparator, int left, int right){
        if (array.size() <=1) return;
        if (left > right) return;
        int middle = left + (right - left)/2;
        T base = array.get(middle);

        int i = left, j = right;
        while (i<=j){
            while (comparator.compare(array.get(i), base) < 0) i++;
            while (comparator.compare(array.get(j), base) > 0) j--;
            if (i<=j){
                array.swap(i,j);
                i++;
                j--;
            }
        }
        if (left < j) quickSort(array, comparator, left, j);
        if (i < right) quickSort(array, comparator, i, right);
    }
}
