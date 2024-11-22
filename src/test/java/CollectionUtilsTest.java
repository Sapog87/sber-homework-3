import org.junit.jupiter.api.Test;
import org.sber.task2.CollectionUtils;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CollectionUtilsTest {

    @Test
    void testAddAll() {
        List<Integer> dest = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        List<Integer> source = new ArrayList<>(List.of(10, 11, 12));

        CollectionUtils.addAll(source, dest);

        assertEquals(dest, List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12));
    }

    @Test
    void testNewArrayList() {
        List<Integer> arrayListOfInteger = CollectionUtils.newArrayList();
        assertTrue(arrayListOfInteger.add(1));

        List<Double> arrayListOfDouble = CollectionUtils.newArrayList();
        assertTrue(arrayListOfDouble.add(1.0));
    }

    @Test
    void testIndexOf() {
        List<Integer> list = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        assertEquals(CollectionUtils.indexOf(list, 6), 6);
    }

    @Test
    void testLimit() {
        List<Integer> list = List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> limitList = CollectionUtils.limit(list, 4);

        assertEquals(limitList.size(), 4);
        assertEquals(limitList, List.of(0, 1, 2, 3));
    }

    @Test
    void testAdd() {
        List<Integer> dest = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5));

        CollectionUtils.add(dest, 6);

        assertEquals(dest, List.of(0, 1, 2, 3, 4, 5, 6));
    }

    @Test
    void testRemoveAll() {
        List<Integer> list = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        CollectionUtils.removeAll(list, List.of(4, 5, 6));

        assertEquals(list.size(), 7);
        assertEquals(list, List.of(0, 1, 2, 3, 7, 8, 9));
    }

    @Test
    void testContainsAll() {
        List<Integer> list = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        assertTrue(CollectionUtils.containsAll(list, List.of(4, 5, 6)));
        assertFalse(CollectionUtils.containsAll(list, List.of(4, 5, 6, 25)));
    }

    @Test
    void testContainsAny() {
        List<Integer> list = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        assertTrue(CollectionUtils.containsAny(list, List.of(4, 5, 6, 45)));
        assertFalse(CollectionUtils.containsAny(list, List.of(35, 77, 25)));
    }

    @Test
    void testRangeWithComparable() {
        List<Integer> list = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));

        List<Integer> result = CollectionUtils.range(list, 3, 6);

        assertEquals(result, List.of(3, 4, 5, 6));
    }

    @Test
    void testRangeWithComparator() {
        List<Integer> list = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8, 9));
        Comparator<Integer> comparator = Integer::compare;

        List<Integer> result = CollectionUtils.range(list, 3, 6, comparator);

        assertEquals(result, List.of(3, 4, 5, 6));
    }
}