package org.vieuxchameau

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class QuickSortKtTest {
    @CsvSource(
            "0",
            "1",
            "54",
            "79",
            "10000"
    )
    @ParameterizedTest
    fun `should sort array`(size: UInt) {

        val numbers = arrayOfRandomInts(size)

        val sortedNumbers = invokeQuickSort(numbers)

        assertThat(sortedNumbers).isSorted()
    }

    @Test
    fun `should sort already ASC ordered array`() {
        val numbers = IntArray(15) { it * 2 }

        val sortedNumbers = invokeQuickSort(numbers)


        assertThat(sortedNumbers).isSorted()
    }

    @Test
    fun `should sort already DESC ordered array`() {
        val numbers = IntArray(8) { it * 2 }

        numbers.reverse()

        val sortedNumbers = invokeQuickSort(numbers)


        assertThat(sortedNumbers).isSorted()
    }

    @Test
    fun `should sort array of similar values`() {
        val numbers = IntArray(42) { 42 }

        val sortedNumbers = invokeQuickSort(numbers)

        assertThat(sortedNumbers).isSorted()
    }

    private fun invokeQuickSort(numbers: IntArray) = inPlaceQuickSort(numbers)
}