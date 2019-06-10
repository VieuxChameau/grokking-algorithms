package org.vieuxchameau

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class SelectionSortKtTest {
    @CsvSource(
            "0",
            "1",
            "54",
            "79",
            "100"
    )
    @ParameterizedTest
    fun `should sort array`(size: UInt) {
        val numbers = arrayOfRandomInts(size)

        val sortedNumbers = selectionSort(numbers)

        assertThat(sortedNumbers).isSorted()
    }


    @Test
    fun `should sort already ASC ordered array`() {
        val numbers = IntArray(15) { it * 2 }

        val sortedNumbers = selectionSort(numbers)

        assertThat(sortedNumbers).isSorted()
    }

    @Test
    fun `should sort already DESC ordered array`() {
        val numbers = IntArray(15) { it * 2 }

        numbers.reverse()

        val sortedNumbers = selectionSort(numbers)

        assertThat(sortedNumbers).isSorted()
    }

    @Test
    fun `should sort array of similar values`() {
        val numbers = IntArray(2) { 42 }

        val sortedNumbers = selectionSort(numbers)

        assertThat(sortedNumbers).isSorted()
    }
}

