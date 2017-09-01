import org.junit.Test;
import static org.junit.Assert.assertEquals;
import java.util.HashMap;
import java.util.Random;

public class HashMapTest {

    @Test
    public void testStandard() {
        final EasyHashMap map = new EasyHashMap();
        map.put(10, 1);
        map.put(9, 12);
        map.put(53, 2);

        assertEquals(1, map.get(10), 0);
        assertEquals(12, map.get(9), 0);
        assertEquals(2, map.get(53), 0);
        assertEquals(null, map.get(11));
    }

    @Test
    public void testRandom(){
        final EasyHashMap map = new EasyHashMap();
        final HashMap <Integer, Long> mapJdK = new HashMap <Integer, Long> (53);
        Random random = new Random();
        for(int j = 0; j < 38; j++){
            int k = random.nextInt(100);
            long v = (long)random.nextInt(1000);
            map.put(k, v);
            mapJdK.put(k,v);
            assertEquals(map.get(k), mapJdK.get(k), 0);
        }
    }

    @Test
    public void testDoublePut() {
        final EasyHashMap map = new EasyHashMap();
        map.put(10, 1);
        map.put(9, 12);

        assertEquals(1, map.get(10), 0);
        assertEquals(12, map.get(9), 0);

        map.put(10, 14);
        map.put(9, 122);
        map.put(53, 11111);
        assertEquals(14, map.get(10), 0);
        assertEquals(122, map.get(9), 0);
    }

    @Test
    public void testSize() {
        final EasyHashMap map = new EasyHashMap();
        map.put(10, 1);
        map.put(9, 12);
        assertEquals(2, map.size(), 0);

        map.put(53, 11111);
        assertEquals(3, map.size(), 0);

        map.put(10, 14);
        map.put(9, 122);
        assertEquals(3, map.size(), 0);

    }
}
