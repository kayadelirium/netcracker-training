public class Array<T>{
    private final int INITIAL = 16;
    private Object [] array = new Object[INITIAL];
    private int pointer = 0;

    public void add(T item){
        if (pointer == array.length - 1)
            resize(array.length*2);
        array[pointer] = item;
        pointer++;
    }
    public void remove(int index) {
        if (pointer - index >= 0)
            System.arraycopy(array, index + 1, array, index, pointer - index);
        array[pointer] = null;
        pointer--;
        if (array.length > INITIAL && pointer < array.length /4)
            resize(array.length / 2);
    }
    public T get(int index) {
        return (T) array[index];
    }
    private void resize(int newLength){
        Object [] newArray = new Object[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

    public int size(){
        return pointer;
    }
}

