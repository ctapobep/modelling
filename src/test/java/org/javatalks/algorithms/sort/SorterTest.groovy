package org.javatalks.algorithms.sort

import org.junit.Test
import org.junit.runner.RunWith
import org.junit.runners.Parameterized

/**
 * @author stanislav bashkirtsev
 */
@RunWith(Parameterized.class)
class SorterTest {

    SorterTest(Sorter sut) {
        this.sut = sut
    }

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

    @Test
    void "benchmark"() {
        int benchMarkSize = 30_000
        Random random = new Random()
        List<Long> input = new ArrayList<>(benchMarkSize)
        for (int i = 0; i < benchMarkSize; i++) {
            input.add(random.nextInt())
        }
        long start = System.currentTimeMillis()
        List<Long> sorted = sut.sort(input)
        long tookTime = System.currentTimeMillis() - start
        println sut.class.simpleName + " on " + sorted.size() + " of elements took: " + tookTime
    }

    @Parameterized.Parameters
    public static Collection<Object[]> allSorters() {
        List<Sorter> sorters = [new InsertionSort(), new MergeSort()]
        return sorters.collect{it as Object[]}
    }

    private Sorter sut
}
