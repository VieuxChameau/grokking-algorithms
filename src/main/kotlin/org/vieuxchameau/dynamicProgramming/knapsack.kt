package org.vieuxchameau.dynamicProgramming

data class Item(val name: String, val value: UInt, val spaceTaken: UInt)

data class KnapsackSolution(val items: List<Item>, val totalValue: UInt) : Comparable<KnapsackSolution> {
    operator fun plus(rhs: KnapsackSolution): KnapsackSolution {
        return KnapsackSolution(items + rhs.items, totalValue + rhs.totalValue)
    }

    override operator fun compareTo(other: KnapsackSolution): Int {
        return totalValue.compareTo(other.totalValue)
    }
}

private typealias KnapsackGrid = List<List<KnapsackSolution>>

private fun KnapsackGrid.get(row: Int, column: Int): KnapsackSolution {
    return this.getOrElse(row) {
        emptyList()
    }.getOrElse(column) {
        EMPTY_KNAPSACK
    }
}

private val EMPTY_KNAPSACK = KnapsackSolution(emptyList(), 0u)

fun knapsack(items: List<Item>, knapsackCapacity: UInt): KnapsackSolution {
    val solutions = mutableListOf<List<KnapsackSolution>>()

    for (i in items.indices) {
        val item = items[i]
        val row = mutableListOf<KnapsackSolution>()
        solutions.add(row)
        for (capacity in 0u until knapsackCapacity) {
            row.add(findMax(solutions, item, i, capacity))
        }
    }

    return solutions.last().last()
}

private fun findMax(solutions: KnapsackGrid, item: Item, row: Int, column: UInt): KnapsackSolution {
    val previousMax = solutions.get(row - 1, column.toInt())

    val spaceTaken = item.spaceTaken
    val capacity = column + 1u
    val current = if (spaceTaken <= capacity) {
        KnapsackSolution(listOf(item), item.value) + solutions.get(row - 1, (capacity - spaceTaken - 1u).toInt())
    } else {
        EMPTY_KNAPSACK
    }

    return maxOf(previousMax, current)
}