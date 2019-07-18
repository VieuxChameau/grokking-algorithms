package org.vieuxchameau.dynamicProgramming

fun findLongestCommonSubstring(left: String, right: String): String {
    val solution = mutableListOf<MutableList<String>>()
    for (i in left.indices) {
        val row = mutableListOf<String>()
        for (j in right.indices) {
            row.add(if (left[i] == right[j]) {
                val previous = solution.getOrElse(i - 1) { emptyList<String>() }.getOrElse(j - 1) { "" }
                "$previous${left[i]}"
            } else {
                ""
            })
        }
        solution.add(row)
    }
    return solution.flatten().maxBy { it.length } ?: ""
}