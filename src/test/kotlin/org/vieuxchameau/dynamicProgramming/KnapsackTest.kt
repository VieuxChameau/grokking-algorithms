package org.vieuxchameau.dynamicProgramming

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.Arguments
import org.junit.jupiter.params.provider.MethodSource
import java.util.stream.Stream

class KnapsackTest {

    @MethodSource("knapsackTestFactory")
    @ParameterizedTest
    fun `should find the maximum value for the knapsack problem`(items: List<Item>, knapsackCapacity: UInt, expectedItems: List<Item>) {
        val solution = knapsack(items, knapsackCapacity)

        println("Value of the knapsack $${solution.totalValue} , items taken ${solution.items}")

        assertThat(solution.items).containsExactlyInAnyOrderElementsOf(expectedItems)
    }

    companion object {
        val guitar = Item("Guitar", 1500u, 1u)
        val stereo = Item("Stereo", 3000u, 4u)
        val laptop = Item("Laptop", 2000u, 3u)
        val iphone = Item("Iphone", 2000u, 1u)

        val water = Item("Water", 10u, 3u)
        val book = Item("Book", 3u, 1u)
        val food = Item("Food", 9u, 2u)
        val jacket = Item("Jacket", 5u, 2u)
        val camera = Item("Camera", 6u, 1u)


        @JvmStatic
        fun knapsackTestFactory() = Stream.of(
                Arguments.of(listOf(guitar, stereo, laptop), 4, listOf(guitar, laptop)),
                Arguments.of(listOf(stereo, laptop, guitar), 4, listOf(guitar, laptop)), // verify that if we change the order, result should stay the same
                Arguments.of(listOf(guitar, stereo, laptop, iphone), 4, listOf(iphone, laptop)),
                Arguments.of(listOf(guitar, stereo, laptop, iphone), 5, listOf(iphone, laptop, guitar)),
                Arguments.of(listOf(water, book, food, jacket, camera), 6, listOf(water, food, camera))
        )
    }
}