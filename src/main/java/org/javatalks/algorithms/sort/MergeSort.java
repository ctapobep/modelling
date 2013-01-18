package org.javatalks.algorithms.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

/**
 * A log(n) sorting algorithm. Eats a lot of memory thus. It's more effective than insertion sort only when it comes to
 * more or less big numbers.
 *
 * @author stanislav bashkirtsev
 * @see <a href="http://en.wikipedia.org/wiki/Merge_sort">Wikipedia</a>
 * @see <a href="http://www.youtube.com/watch?v=XaqR3G_NVoo">German Folk Dance</a>
 */
public class MergeSort extends InitialChecksSorter {

    @Override
    <E extends Comparable<? super E>> List<E> doSort(List<E> toSort) {
        List<List<E>> splitLists = splitElementsIntoSeparateLists(toSort);
        while (splitLists.size() > 1) {
            List<List<E>> merged = new ArrayList<>();
            for (int i = 0; i < splitLists.size(); i += 2) {
                merged.add(merge(splitLists.get(i), splitLists.get(i + 1)));
                if (i == splitLists.size() - 3) {
                    merged.add(splitLists.get(i + 2));
                    break;
                }
            }
            splitLists.clear();
            splitLists.addAll(merged);
        }
        return splitLists.get(0);
    }

    private <E extends Comparable<? super E>> List<List<E>> splitElementsIntoSeparateLists(List<E> toSort) {
        List<List<E>> splitLists = new ArrayList<>();
        for (E element : toSort) {
            splitLists.add(Arrays.asList(element));
        }
        return splitLists;
    }


    private <E extends Comparable<? super E>> List<E> merge(List<E> l1, List<E> l2) {
        List<E> merged = new ArrayList<>(l2.size() + l1.size());
        for (int i1 = 0, i2 = 0; i1 < l1.size() || i2 < l2.size(); ) {
            E o1 = l1.get(i1);
            E o2 = l2.get(i2);
            if (o1.compareTo(o2) > 0) {
                merged.add(o2);
                i2++;
            } else {
                merged.add(o1);
                i1++;
            }
            if (listFinished(l1, i1)) {
                merged.addAll(restOfElements(l2, i2));
                break;
            }
            if (listFinished(l2, i2)) {
                merged.addAll(restOfElements(l1, i1));
                break;
            }
        }
        return merged;
    }

    private <E extends Comparable<? super E>> Collection<? extends E> restOfElements(List<E> l2, int i2) {
        return l2.subList(i2, l2.size());
    }

    private <E extends Comparable<? super E>> boolean listFinished(List<E> l1, int i1) {
        return i1 >= l1.size();
    }
}
