package org.vieuxchameau.search

const val NOT_FOUND = -1

/**
 * Condition: array has to be sorted
 */
fun binarySearch(numbers: IntArray, toFind: Int): Int {
    var start = 0
    var end = numbers.size - 1
    while (start <= end) {
        val index = ((end - start) / 2) + start
        if (numbers[index] == toFind) {
            return index
        }
        if (numbers[index] > toFind) {
            end = index - 1
        } else {
            start = index + 1
        }
    }
    return NOT_FOUND
}

/**
 * Recursive version of the binary search
 * Condition: array has to be sorted
 */
fun recursiveBinarySearch(numbers: IntArray, toFind: Int, start: Int = 0, end: Int = numbers.size - 1): Int {
    if (start > end) {
        return NOT_FOUND
    }

    val index = ((end - start) / 2) + start
    if (numbers[index] == toFind) {
        return index
    }

    return if (numbers[index] > toFind) {
        recursiveBinarySearch(numbers, toFind, start, index - 1)
    } else {
        recursiveBinarySearch(numbers, toFind, index + 1, end)
    }
}

