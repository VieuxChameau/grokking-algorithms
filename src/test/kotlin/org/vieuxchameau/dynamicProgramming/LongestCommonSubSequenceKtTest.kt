package org.vieuxchameau.dynamicProgramming

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LongestCommonSubSequenceKtTest {
    @CsvSource("fosh, fort, fo",
            "fosh, fish, fsh",
            "fosh, f, f",
            "AGGTAB, GXTXAYB, GTAB"
    )
    @ParameterizedTest
    fun `should find the longest common substring`(left: String, right: String, expectedOutput: String) {
        val output = findLongestCommonSubSequence(left, right)

        println("Longest common substring between '$left' and '$right' is '$output'")
        Assertions.assertThat(output).isEqualTo(expectedOutput)
    }

    @Test
    fun `should be equal if same size`() {
        val byLengthComparator = ByLengthComparator()

        val compare = byLengthComparator.compare("somerandomstring", "gnirtsmodnaremos")

        Assertions.assertThat(compare).isZero()
    }

    @Test
    fun `should be smaller if left shorter size`() {
        val byLengthComparator = ByLengthComparator()

        val compare = byLengthComparator.compare("some", "gnirtsmodnaremos")

        Assertions.assertThat(compare).isLessThan(0)
    }

    @Test
    fun `should be greater if right shorter size`() {
        val byLengthComparator = ByLengthComparator()

        val compare = byLengthComparator.compare("gnirtsmodnaremos", "some")

        Assertions.assertThat(compare).isGreaterThan(0)
    }
}