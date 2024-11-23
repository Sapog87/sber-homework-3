package org.sber.task2;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class CollectionUtils {
    private CollectionUtils() {
    }

    /**
     * Добавляет все элементы из source списка в конец destination списка
     */
    public static <T> void addAll(List<? extends T> source, List<? super T> destination) {
        destination.addAll(source);
    }

    /**
     * Создает пустой ArrayList
     */
    public static <T> List<T> newArrayList() {
        return new ArrayList<>();
    }

    /**
     * Находит первой вхождение элемента в заданном списке
     */
    public static <T> int indexOf(List<? extends T> source, T o) {
        return source.indexOf(o);
    }

    /**
     * Возвращает новый список не длиннее чем size начиная с первого элемента
     */
    public static <T> List<T> limit(List<T> source, int size) {
        return source.stream().limit(size).collect(Collectors.toList());
    }

    /**
     * Добавляет новый элемент в конец заданного списка
     */
    public static <T> void add(List<? super T> destination, T o) {
        destination.add(o);
    }

    /**
     * Удаляет из списка removeFrom все элементы списка c2
     */
    public static <T> void removeAll(List<? super T> removeFrom, List<? extends T> c2) {
        removeFrom.removeAll(c2);
    }

    /**
     * Проверяет, что список c1 содержит все элементы списка с2
     */
    public static <T> boolean containsAll(List<? super T> c1, List<? extends T> c2) {
        for (T e : c2)
            if (!c1.contains(e))
                return false;
        return true;
    }

    /**
     * Проверяет, что список c1 содержит хотя бы один элемент из списка с2
     */
    public static <T> boolean containsAny(List<? super T> c1, List<? extends T> c2) {
        for (T e : c2)
            if (c1.contains(e))
                return true;
        return false;
    }

    /**
     * Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
     * Элементы сравнивать через Comparable.
     */
    public static <T extends Comparable<? super T>> List<T> range(List<? extends T> list, T min, T max) {
        return list.stream()
                .filter(x -> x.compareTo(min) >= 0 && x.compareTo(max) <= 0)
                .sorted()
                .collect(Collectors.toList());
    }

    /**
     * Возвращает лист, содержащий элементы из входного листа в диапазоне от min до max.
     * Элементы сравнивать через Comparator.
     */
    public static <T> List<T> range(List<? extends T> list, T min, T max, Comparator<? super T> comparator) {
        return list.stream()
                .filter(x -> comparator.compare(x, min) >= 0 && comparator.compare(x, max) <= 0)
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
