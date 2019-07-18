package org.vieuxchameau.math

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class FactorialKtTest {
    @CsvSource(
            "0, 1",
            "1, 1",
            "5, 120",
            "12, 479001600"
    )
    @ParameterizedTest
    fun `should calculate the right factorial result`(number: UInt, expectedResult: UInt) {

        val result = factorial(number)

        assertThat(result).isEqualTo(expectedResult)
    }
}