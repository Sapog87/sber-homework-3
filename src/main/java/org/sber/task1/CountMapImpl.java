package org.sber.task1;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

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
        return Objects.requireNonNullElse(countValueStorage.remove(value), 0);
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
        return countValueStorage
                .entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
    }

    @Override
    public void toMap(Map<V, Integer> destination) {
        destination.putAll(countValueStorage);
    }
}
