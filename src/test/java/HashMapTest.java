import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HashMapTest {

    HashMap hashMap;

    @Before
    public void setUp() throws Exception {
        hashMap = new HashMap();
    }

    @Test
    public void put() {     // test put element from hashmap - success
        hashMap.put(3, 3l);

        long expectedResult = 3l;
        long actualResult = hashMap.get(3);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void get() {   // test get element from hashmap - success
        hashMap.put(1, 1l);
        hashMap.put(2, 2l);
        hashMap.put(3, 3l);

        long expectedResult = 2l;
        long actualResult = hashMap.get(2);

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void testIdentical_RewriteKeys() { // test for rewrite a element if in hashmap is identical keys - success

        hashMap.put(1, 1l);
        hashMap.put(1, 3l);

        long expectedResult = 3l;
        long actualResult = hashMap.get(1);

        assertEquals(expectedResult, actualResult);

    }

    @Test
    public void testResize() { // test which shows increase capacity if load_factor more than 0.75 - success
        long value = 1l;
        for (int i = 1; i < 20; i++) {
            hashMap.put(i, value);
        }

        int expectedResult = 19;
        int actualResult = hashMap.getSize();

        assertEquals(expectedResult, actualResult);
    }

    @Test
    public void size() { // test get Size for hashMap - success
        hashMap.put(1, 1l);
        int expectedResult = 1;
        int actualResult = hashMap.getSize();

        assertEquals(expectedResult, actualResult);

    }
}