package Sorters;

import MyArrays.Array;

import java.util.Comparator;

/**
 * ISorting - interface for work with sorting algorithms
 */
public interface ISorting<T> {
    /**
     * sorting method declaration
     * @param array - array should be sorted
     * @param comparator - sorting rule for specified key
     * @return sorted array
     */
    public Array<T> sort(Array<T> array, Comparator<T> comparator);
}
