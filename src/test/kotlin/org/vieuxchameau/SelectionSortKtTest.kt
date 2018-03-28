package org.vieuxchameau

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class SelectionSortKtTest {
    @CsvSource(
            "1",
            "100"
    )
    @ParameterizedTest
    fun `should sort array`(size: Int) {
        val numbers = IntArray(size) { it * 2 }
        numbers.reverse()

        val copy = numbers.copyOf()
        copy.sort()

        selectionSort(numbers)

        Assertions.assertThat(numbers).isEqualTo(copy)
    }
}