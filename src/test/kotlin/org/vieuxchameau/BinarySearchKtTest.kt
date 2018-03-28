package org.vieuxchameau

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.CsvSource
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class BinarySearchKtTest {
    @CsvSource(
            "1, 0",
            "100, 42",
            "100, 9",
            "101, 43",
            "101, 59",
            "100, 99",
            "100, 0"
    )
    @ParameterizedTest
    fun `should find number in array`(arraySize: Int, nbToFind: Int) {
        val numbers = IntArray(arraySize) { it }

        val index = binarySearch(numbers, nbToFind)


        assertThat(numbers[index]).isEqualTo(nbToFind)
    }

    @CsvSource(
            "1, 0",
            "100, 42",
            "100, 9",
            "101, 43",
            "101, 59",
            "100, 99",
            "100, 0"
    )
    @ParameterizedTest
    fun `should find number in array with rec method`(arraySize: Int, nbToFind: Int) {
        val numbers = IntArray(arraySize) { it }

        val index = binarySearchRec(numbers, nbToFind)


        assertThat(numbers[index]).isEqualTo(nbToFind)
    }

    @ParameterizedTest
    @MethodSource("argProvider")
    fun `should not find number in array`(arraySize: Int, nbToFind: Int) {
        val numbers = IntArray(arraySize) { it }

        val index = binarySearch(numbers, nbToFind)

        assertThat(index).isEqualTo(-1)
    }

    @ParameterizedTest
    @MethodSource("argProvider")
    fun `should not find number in array with rec method`(arraySize: Int, nbToFind: Int) {
        val numbers = IntArray(arraySize) { it }

        val index = binarySearchRec(numbers, nbToFind)

        assertThat(index).isEqualTo(-1)
    }

    companion object {
        @JvmStatic
        fun argProvider() = Stream.of(
                Arguments.of(1, 1),
                Arguments.of(100, -5),
                Arguments.of(100, 100)
        )
    }
}