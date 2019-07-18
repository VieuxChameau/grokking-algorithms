package org.vieuxchameau.search

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
    fun `should find number in array with recursive method`(arraySize: Int, nbToFind: Int) {
        val numbers = IntArray(arraySize) { it }

        val index = recursiveBinarySearch(numbers, nbToFind)


        assertThat(numbers[index]).isEqualTo(nbToFind)
    }

    @ParameterizedTest
    @MethodSource("arrayTestFactory")
    fun `should not find number in array`(arraySize: Int, nbToFind: Int) {
        val numbers = IntArray(arraySize) { it }

        val index = binarySearch(numbers, nbToFind)

        assertThat(index).isEqualTo(-1)
    }

    @ParameterizedTest
    @MethodSource("arrayTestFactory")
    fun `should not find number in array with recursive method`(arraySize: Int, nbToFind: Int) {
        val numbers = IntArray(arraySize) { it }

        val index = recursiveBinarySearch(numbers, nbToFind)

        assertThat(index).isEqualTo(-1)
    }

    companion object {
        @JvmStatic
        fun arrayTestFactory() = Stream.of(
                Arguments.of(0, 1),
                Arguments.of(1, 1),
                Arguments.of(100, -5),
                Arguments.of(100, 100)
        )
    }
}