package org.javatalks.algorithms.sort

import org.junit.Test

/**
 * @author stanislav bashkirtsev
 */
class SorterTest {
    @Test
    void "already sorted should return same order"() {
        List<Integer> result = sut.sort([-1, 0, 1, 2])
        assert result == [-1, 0, 1, 2]
    }

    @Test
    void "opposite order case"() {
        List<Integer> result = sut.sort([2, 1, 0, -1])
        assert result == [-1, 0, 1, 2]
    }

    @Test
    void "only negative numbers"() {
        List<Integer> result = sut.sort([-2, -1, -15])
        assert result == [-15, -2, -1]
    }

    @Test
    void "one element passed -> one element returned"() {
        List<Integer> result = sut.sort([12])
        assert result == [12]
    }

    @Test
    void "only positives"() {
        List<Integer> result = sut.sort([2, 1, 15])
        assert result == [1, 2, 15]
    }

    @Test
    void "only zeroz"() {
        List<Integer> result = sut.sort([0, 0, 0])
        assert result == [0, 0, 0]
    }

    @Test
    void "boundary values"() {
        List<Integer> result = sut.sort([Integer.MAX_VALUE, 0, Integer.MIN_VALUE])
        assert result == [Integer.MIN_VALUE, 0, Integer.MAX_VALUE]
    }

    @Test
    void "empty returns as empty list"(){
        List result = sut.sort([])
        assert result == []
    }

    @Test
    void "null returns as empty list"(){
        List result = sut.sort(null)
        assert result == []
    }

    private Sorter sut = new InsertionSort()
}
