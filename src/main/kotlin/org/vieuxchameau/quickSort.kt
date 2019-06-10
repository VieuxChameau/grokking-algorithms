package org.vieuxchameau

import kotlin.random.Random

/**
 * This version is not memory efficient as we create intermediaries array/list
 */
fun quickSort(numbers: IntArray): IntArray {
    if (numbers.size < 2) {
        return numbers
    }
    val pivotIndex = Random.nextInt(numbers.size - 1)
    val pivotValue = numbers[pivotIndex]
    val lowers = arrayListOf<Int>()
    val greaters = arrayListOf<Int>()
    for (i in numbers.indices) {
        if (i == pivotIndex) {
            continue
        }
        val number = numbers[i]
        if (number < pivotValue) {
            lowers.add(number)
        } else {
            greaters.add(number)
        }
    }
    return intArrayOf(*quickSort(lowers.toIntArray()), pivotValue, *quickSort(greaters.toIntArray()))
}

// TODO take the pivot strategy as a parameter
fun inPlaceQuickSort(numbers: IntArray, lowIndex: Int = 0, highIndex: Int = numbers.size - 1): IntArray {
    if (highIndex - lowIndex < 1) {
        return numbers
    }
    var pivotIndex = lowIndex + Random.nextInt(highIndex - lowIndex)
    val pivotValue = numbers[pivotIndex]
    numbers.swap(pivotIndex, highIndex)
    var left = lowIndex
    var right = highIndex - 1

    while (left <= right) {
        if (numbers[left] >= pivotValue && numbers[right] <= pivotValue) {
            numbers.swap(left, right)
            left++
            right--
        } else {
            if (numbers[left] < pivotValue) {
                left++
            }
            if (numbers[right] > pivotValue) {
                right--
            }
        }
    }
    numbers.swap(left, highIndex)
    pivotIndex = left

    inPlaceQuickSort(numbers, lowIndex, pivotIndex - 1)
    inPlaceQuickSort(numbers, pivotIndex + 1, highIndex)
    return numbers
}


private fun IntArray.swap(index1: Int, index2: Int) {
    val temp = this[index1]
    this[index1] = this[index2]
    this[index2] = temp

}
