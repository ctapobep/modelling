package org.javatalks.algorithms.sort;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * This algorithm first goes upwards and checks weather current element is smaller than previous one. If yes, then it
 * goes downwards and insert current element into the position where: {@code previousElement =< currentElement =<
 * nextElement}. And then we move our marker next and check with previous element again. <p>The worst complexity of the
 * algorithm is {@code O=n*n}. Here is what wiki says: The average case is also quadratic, which makes insertion sort
 * impractical for sorting large arrays. However, insertion sort is one of the fastest algorithms for sorting very small
 * arrays, even faster than quicksort; indeed, good quicksort implementations use insertion sort for arrays smaller than
 * a certain threshold, also when arising as subproblems; the exact threshold must be determined experimentally and
 * depends on the machine, but is commonly around ten.</p>
 *
 * @author stanislav bashkirtsev
 * @see <a href="http://en.wikipedia.org/wiki/Insertion_sort">Wikipedia</a>
 * @see <a href="http://www.youtube.com/watch?v=Kg4bqzAqRBM&feature=player_detailpage#t=601s">MIT Lecture</a>
 * @see <a href="http://www.youtube.com/watch?v=ROalU379l3U">Romanian Folk Dance</a>
 */
public class InsertionSort implements Sorter {
    @Override
    public <E extends Comparable<? super E>> List<E> sort(List<E> toSort) {
        if (toSort == null || toSort.isEmpty()) {
            return new ArrayList<>();
        }
        List<E> result = new ArrayList<>(toSort);
        if(result.size() == 1){
            return result;
        }
        return doSort(result);
    }

    /**
     * Sorts the incoming list. The specified list is modified.
     *
     * @param toSort a list to be sorted, should be already checked for nulls and emptiness
     * @param <E>    sortable
     * @return the same list as was passed, but already after sorting
     */
    private <E extends Comparable<? super E>> List<E> doSort(List<E> toSort) {
        for (int i = 1; i < toSort.size(); i++) {
            int comparison = toSort.get(i).compareTo(toSort.get(i - 1));
            if (comparison < 0) {
                Collections.swap(toSort, i, i - 1);
                sortDown(toSort, i - 1);
            }
        }
        return toSort;
    }

    /**
     * Puts the element at {@code indexToStartFrom} into the position it fits where left element is less or equal to the
     * {@code startFrom} and right element is bigger.
     *
     * @param toSort           list to sort (move {@code indexToStartFrom} element to the right position, the rest is
     *                         sorted yet)
     * @param indexToStartFrom an element that might be not in the right position, e.g. if we consider this stage:
     *                         {@code 1, 2, 1, 3} and {@code indexToStartFrom = 2}, then we should move that element to
     *                         position 1
     * @param <E>              the comparable
     * @return the same list that was passed
     */
    private <E extends Comparable<? super E>> List<E> sortDown(List<E> toSort, int indexToStartFrom) {
        for (int i = indexToStartFrom; i >= 1; i--) {
            int comparison = toSort.get(i).compareTo(toSort.get(i - 1));
            if (comparison < 0) {
                Collections.swap(toSort, i, i - 1);
            } else {
                break;
            }
        }
        return toSort;
    }
}
