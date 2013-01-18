package org.javatalks.algorithms.sort;

import java.util.List;

/** @author stanislav bashkirtsev */
public interface Sorter {
    /**
     * Sorts the incoming list of {@link Comparable}s by natural order. Original list is never modified. Null and Empty
     * list results in an empty list and doesn't throw exceptions.
     *
     * @param toSort an original list of objects to sort. Empty and null values can be accepted.
     * @param <E>    a comparable element
     * @return a sorted version of the passed list. It's never the same reference to the original array and it's never
     *         null.
     */
    <E extends Comparable<? super E>> List<E> sort(List<E> toSort);
}
