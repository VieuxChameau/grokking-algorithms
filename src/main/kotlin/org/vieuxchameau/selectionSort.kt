package org.vieuxchameau

fun selectionSort(numbers: IntArray): IntArray {
    for (i in numbers.indices) {
        var min = numbers[i]
        var index = i
        for (x in i + 1 until numbers.size) {
            if (numbers[x] < min) {
                min = numbers[x]
                index = x
            }
        }
        numbers[index] = numbers[i]
        numbers[i] = min
    }

    return numbers
}