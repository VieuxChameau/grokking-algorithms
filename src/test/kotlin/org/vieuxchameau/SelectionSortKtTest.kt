package org.vieuxchameau

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class SelectionSortKtTest {
    @CsvSource(
            "0",
            "1",
            "100"
    )
    @ParameterizedTest
    fun `should sort array`(size: UInt) {
        val numbers = arrayOfRandomInts(size)

        println("Array = ${numbers.asString()}")
        selectionSort(numbers)

        assertThat(numbers).isSorted()
        println("Sorted Array = ${numbers.asString()}")
    }
}

