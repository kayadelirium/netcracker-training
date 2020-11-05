package my_arrays;

import java.util.Arrays;
/**
 * my_arrays.Array - generic array class with possibility to add and remove elements
 * with automatic regulation of the buffer size
 */
public class Array<T>{
    /**
     * constant - the first value of buffer size;
     * minimal possible array capacity;
     */
    private final int INITIAL = 16;
    private Object[] array;
    /**
     * the current value of buffer size
     */
    private int currentBufferSize;
    /**
     * the real size of array; the number of not-null elements;
     */
    private int pointer;

    Array(){
        array = new Object[INITIAL];
        currentBufferSize = INITIAL;
        pointer = 0;
    }

    public int getCurrentBufferSize() {
        return currentBufferSize;
    }

    /**
     * function adds the element in array;
     * with possible increasing the array capacity;
     * @param item
     */
    public void add(T item){
        if (pointer == array.length - 1)
            resize(array.length*2);
        array[pointer] = item;
        pointer++;
    }

    @Override
    public String toString() {
        return Arrays.toString(array);
    }
    /**
     * function removes the element with specified index in array;
     * with possible decreasing the array capacity;
     * @param index
     */
    public void remove(int index) {
        if (pointer >= index) {
            System.arraycopy(array, index + 1, array, index, pointer - index);
        }

        array[pointer] = null;
        pointer--;
        if (array.length > INITIAL && pointer < array.length /4)
            resize(array.length / 2);
    }

    /**
     * @param index
     * @return the array element with specified index;
     */
    public T get(int index) {
        return (T) array[index];
    }

    /**
     * auxiliary function - changes the capacity of array;
     * @param newLength - new size of the buffer
     */
    private void resize(int newLength){
        Object [] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
        currentBufferSize = newLength;
    }

    /**
     * @return actual size of the array
     */
    public int size(){
        return pointer;
    }
}

