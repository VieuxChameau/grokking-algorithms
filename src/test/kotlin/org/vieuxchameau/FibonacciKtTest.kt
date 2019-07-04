package org.vieuxchameau

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource


class FibonacciKtTest {

    @CsvSource(
            "0, 0",
            "1, 1",
            "2, 1",
            "7, 13",
            "35 , 9227465",
            "42 , 267914296"

    )
    @ParameterizedTest
    fun `should calculate the nth element of the fibonacci sequence`(index: UInt, expectedResult: UInt) {
        val result = fibonacci(index)

        assertThat(result).isEqualTo(expectedResult)
    }

    @CsvSource(
            "0, 0",
            "1, 1",
            "2, 1",
            "7, 13",
            "35 , 9227465",
            "42 , 267914296"
    )
    @ParameterizedTest
    fun `should calculate the nth element of the fibonacci sequence (memoized version)`(index: UInt, expectedResult: UInt) {
        val result = fibonacciMemoized(index)

        assertThat(result).isEqualTo(expectedResult)
    }
}