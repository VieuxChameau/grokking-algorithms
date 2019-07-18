package org.vieuxchameau.miscellaneous

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FizzbuzzKtTest {
    @Test
    fun `should display the number for non multiple of 3 nor 5`() {
        val fizzbuzzResult = fizzbuzz()

        assertThat(fizzbuzzResult).containsEntry(1, "1")
                .containsEntry(2, "2")
                .containsEntry(14, "14")
                .containsEntry(22, "22")
                .containsEntry(86, "86")
                .containsEntry(98, "98")
    }

    @Test
    fun `should display Fizz for multiples of three`() {
        val fizzbuzzResult = fizzbuzz()

        assertThat(fizzbuzzResult).containsEntry(3, "Fizz")
                .containsEntry(6, "Fizz")
                .containsEntry(9, "Fizz")
                .containsEntry(81, "Fizz")
                .containsEntry(72, "Fizz")
                .containsEntry(99, "Fizz")
    }

    @Test
    fun `should display Buzz for multiples of five`() {
        val fizzbuzzResult = fizzbuzz()

        assertThat(fizzbuzzResult).containsEntry(5, "Buzz")
                .containsEntry(10, "Buzz")
                .containsEntry(40, "Buzz")
                .containsEntry(65, "Buzz")
                .containsEntry(95, "Buzz")
                .containsEntry(100, "Buzz")
    }

    @Test
    fun `should display FizzBuzz for multiples of both three and five`() {
        val fizzbuzzResult = fizzbuzz()

        assertThat(fizzbuzzResult).containsEntry(15, "FizzBuzz")
                .containsEntry(30, "FizzBuzz")
                .containsEntry(45, "FizzBuzz")
                .containsEntry(60, "FizzBuzz")
                .containsEntry(75, "FizzBuzz")
    }
}