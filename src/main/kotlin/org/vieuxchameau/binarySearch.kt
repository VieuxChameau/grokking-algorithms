package org.vieuxchameau

/**
 * numbers has to be sorted
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
    return -1
}
