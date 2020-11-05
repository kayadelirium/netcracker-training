import junit.framework.TestCase;

public class ArrayTest extends TestCase {

    public void testSize() {
        Array<Integer> array = new Array<Integer>();
        assertEquals(0, array.size());
        array.add(1);
        assertEquals(1, array.size());
    }

    public void testRemoveNotResize() {
        Array<String> array = new Array<String>();
        array.add("lalala");
        assertEquals(1, array.size());
        array.remove(0);
        assertEquals(0, array.size());
    }
    public void testRemoveResize() {
        Array array = new Array<Integer>();
        int [] massive = {1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8,9,0};
        for (int j : massive) {
            array.add(j);
        }
        int expectedSize = array.getCurrentBufferSize();

        for (int i = 6; i < massive.length; i++){
            array.remove(i);
        }
        int [] expMassive = {1,2,3,4,5,6};
        assertEquals(expMassive.length, array.size());
        for (int i = 0; i < expMassive.length; i++){
            assertEquals(expMassive[i], array.get(i));
        }
        assertTrue("resizing should lead to decreasing the buffer size", expectedSize > array.getCurrentBufferSize());
    }

    public void testAddNotResize() {
        Array array = new Array<Integer>();
        int [] massive = {1,2,3,4,5,6,7,8,9,0,1,2,3};
        int expectedSize = array.getCurrentBufferSize();
        for (int j : massive) {
            array.add(j);
        }
        for (int i = 0; i < massive.length; i++){
            assertEquals(massive[i], array.get(i));
        }
        assertEquals(expectedSize, array.getCurrentBufferSize());
    }

    public void testAddResize() {
        Array array = new Array<Integer>();
        int [] massive = {1,2,3,4,5,6,7,8,9,0,1,2,3,4,5,6,7,8};
        int expectedSize = array.getCurrentBufferSize();
        for (int j : massive) {
            array.add(j);
        }
        for (int i = 0; i < massive.length; i++){
            assertEquals(massive[i], array.get(i));
        }
        assertTrue("resizing should lead to increasing the buffer size", expectedSize < array.getCurrentBufferSize());
    }
}