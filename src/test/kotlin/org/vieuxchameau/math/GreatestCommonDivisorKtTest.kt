package org.vieuxchameau.math

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource
import org.vieuxchameau.math.gcd

class GreatestCommonDivisorKtTest {
    @CsvSource(
            "1680, 640, 80",
            "640, 1680, 80",
            "10, 2, 2",
            "182664, 154875, 177"
    )
    @ParameterizedTest
    fun `should find gcd`(left: Int, right: Int, expectedGCD: Int) {
        val solution = gcd(left, right)


        assertThat(solution).isEqualTo(expectedGCD)
    }
}