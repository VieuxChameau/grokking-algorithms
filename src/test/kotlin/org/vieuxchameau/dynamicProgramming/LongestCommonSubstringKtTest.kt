package org.vieuxchameau.dynamicProgramming

import org.assertj.core.api.Assertions
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

class LongestCommonSubstringKtTest {
    @CsvSource("hish, fish, ish",
            "hish, vista, is",
            "GeeksforGeeks, GeeksQuiz, Geeks",
            "abcdxyz, xyzabcd, abcd",
            "lmnop, t, ''",
            "4 Briars Lane, 4 Briars Lane, 4 Briars Lane",
            "5 Jedburgh Street, '5 Bath St, Jedburgh', ' Jedburgh'")
    @ParameterizedTest
    fun `should find the longest common substring`(left: String, right: String, expectedOutput: String) {
        val output = findLongestCommonSubstring(left, right)

        println("Longest common substring between '$left' and '$right' is '$output'")
        Assertions.assertThat(output).isEqualTo(expectedOutput)
    }
}