package org.sber.task1;

import java.util.HashMap;
import java.util.Map;

public class CountMapImpl<V> implements CountMap<V> {
    private final Map<V, Integer> countValueStorage = new HashMap<>();

    @Override
    public void add(V value) {
        countValueStorage.compute(value, (k, v) -> v == null ? 1 : v + 1);
    }

    @Override
    public int getCount(V value) {
        return countValueStorage.getOrDefault(value, 0);
    }

    @Override
    public int remove(V value) {
        Integer countBeforeDelete = countValueStorage.getOrDefault(value, 0);
        if (countBeforeDelete > 0)
            countValueStorage.put(value, countBeforeDelete - 1);
        return countBeforeDelete;
    }

    @Override
    public int size() {
        return countValueStorage.size();
    }

    @Override
    public void addAll(CountMap<V> source) {
        source.toMap().forEach((key, value) ->
                countValueStorage.compute(key, (k, v) -> v == null ? value : v + value)
        );
    }

    @Override
    public Map<V, Integer> toMap() {
        return new HashMap<>(countValueStorage);

    }

    @Override
    public void toMap(Map<V, Integer> destination) {
        destination.putAll(countValueStorage);
    }
}
