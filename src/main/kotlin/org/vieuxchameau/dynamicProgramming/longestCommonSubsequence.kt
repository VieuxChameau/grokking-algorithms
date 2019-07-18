package org.vieuxchameau.dynamicProgramming

import java.util.*

private typealias SubsequenceGrid = List<List<String>>

private fun SubsequenceGrid.get(i: Int, j: Int): String {
    return getOrElse(i) { emptyList() }.getOrElse(j) { "" }
}

class ByLengthComparator : Comparator<String> {
    override fun compare(o1: String, o2: String): Int {
        return o1.length.compareTo(o2.length)
    }

}

fun findLongestCommonSubSequence(left: String, right: String): String {
    val solution = mutableListOf<MutableList<String>>()
    for (i in left.indices) {
        val row = mutableListOf<String>()
        for (j in right.indices) {
            row.add(if (left[i] == right[j]) {
                val previous = solution.get(i - 1, j - 1)
                "$previous${left[i]}"
            } else {
                maxOf(solution.get(i - 1, j), row.getOrElse(j - 1) { "" }, ByLengthComparator())
            })
        }
        solution.add(row)
    }
    return solution.last().last()
}