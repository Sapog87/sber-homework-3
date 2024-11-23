import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.sber.task1.CountMap;
import org.sber.task1.CountMapImpl;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

public class CountMapTest {

    CountMap<Integer> countMap;

    @BeforeEach
    public void beforeEach() {
        countMap = new CountMapImpl<>();
        countMap.add(10);
        countMap.add(10);
        countMap.add(10);
        countMap.add(5);
        countMap.add(6);
        countMap.add(5);
    }

    @Test
    public void testAdd() {
        assertEquals(countMap.getCount(5), 2);
        assertEquals(countMap.getCount(6), 1);
        assertEquals(countMap.getCount(10), 3);
        assertEquals(countMap.getCount(11), 0);
    }

    @Test
    public void testRemove() {
        assertEquals(countMap.remove(5), 2);
        assertEquals(countMap.remove(5), 1);
        assertEquals(countMap.remove(5), 0);
        assertEquals(countMap.remove(11), 0);
    }

    @Test
    public void testSize() {
        assertEquals(countMap.size(), 3);
    }

    @Test
    public void testAddAll() {
        CountMap<Integer> localCountMap = new CountMapImpl<>();
        localCountMap.add(6);
        localCountMap.add(10);

        localCountMap.addAll(countMap);

        assertEquals(localCountMap.size(), 3);
        assertEquals(localCountMap.getCount(5), 2);
        assertEquals(localCountMap.getCount(6), 2);
        assertEquals(localCountMap.getCount(10), 4);
        assertEquals(localCountMap.getCount(11), 0);
    }

    @Test
    public void testToMapThatReturnsMap() {
        Map<Integer, Integer> mapFromCountMap = countMap.toMap();

        assertEquals(mapFromCountMap.size(), 3);
        assertEquals(mapFromCountMap.get(5), 2);
        assertEquals(mapFromCountMap.get(6), 1);
        assertEquals(mapFromCountMap.get(10), 3);
        assertNull(mapFromCountMap.get(11));

        //Проверка того, что изменение полученной Map не влияет на СountMap
        mapFromCountMap.put(11, 5);
        assertEquals(countMap.getCount(11), 0);
    }

    @Test
    public void testToMapThatUsesGivenMap() {
        Map<Integer, Integer> mapFromCountMap = new HashMap<>();

        countMap.toMap(mapFromCountMap);

        assertEquals(mapFromCountMap.size(), 3);
        assertEquals(mapFromCountMap.get(5), 2);
        assertEquals(mapFromCountMap.get(6), 1);
        assertEquals(mapFromCountMap.get(10), 3);
        assertNull(mapFromCountMap.get(11));

        //Проверка того, что изменение полученной Map не влияет на СountMap
        mapFromCountMap.put(11, 5);
        assertEquals(countMap.getCount(11), 0);
    }
}
