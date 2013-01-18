package org.javatalks.algorithms.sort;

import java.util.ArrayList;
import java.util.List;

/**
 * Contains the initial logic for every sorting algorithm like checking weather the specified list is null or empty or
 * its size is 1. Other sorting algorithms should extend it by implementing only {@link #doSort(java.util.List)} which
 * is the method for real algorithm-specific sorting.
 *
 * @author stanislav bashkirtsev
 */
public abstract class InitialChecksSorter implements Sorter {
    @Override
    public <E extends Comparable<? super E>> List<E> sort(List<E> toSort) {
        if (toSort == null || toSort.isEmpty()) {
            return new ArrayList<>();
        }
        List<E> result = new ArrayList<>(toSort);
        if (result.size() == 1) {
            return result;
        }
        return doSort(result);
    }

    /**
     * That's a real place for sorting after all the checks are passed in {@link #sort(java.util.List)}. Sorts the
     * incoming list itself, thus the specified list is modified.
     *
     * @param toSort a list to be sorted, should be already checked for nulls and emptiness
     * @param <E>    sortable
     * @return the same list as was passed, but already after sorting
     */
    abstract <E extends Comparable<? super E>> List<E> doSort(List<E> toSort);
}
