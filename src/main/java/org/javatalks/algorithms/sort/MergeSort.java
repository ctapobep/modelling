package org.javatalks.algorithms.sort;

import java.util.List;

/** @author stanislav bashkirtsev */
public class MergeSort extends InitialChecksSorter {

    @Override
    <E extends Comparable<? super E>> List<E> doSort(List<E> toSort) {
        return toSort;
    }
}
