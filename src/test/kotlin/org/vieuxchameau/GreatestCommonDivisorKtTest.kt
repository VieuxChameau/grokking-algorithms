package org.vieuxchameau

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class GreatestCommonDivisorKtTest {
    @CsvSource(
            "1680, 640, 80",
            "640, 1680, 80",
            "10, 2, 2",
            "182664, 154875, 177"
    )
    @ParameterizedTest
    fun `should find gcd`(left: Int, right: Int, expectedSolution: Int) {
        val solution = gcd(left, right)


        Assertions.assertThat(solution).isEqualTo(expectedSolution)
    }
}