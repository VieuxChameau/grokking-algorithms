package org.vieuxchameau

fun fizzbuzz(): Map<Int, String> {
    return (1..100).map { it to getLabel(it) }.toMap()
}

private fun getLabel(number: Int): String {
    return when {
        (number isMultipleOf 15) -> "FizzBuzz"
        (number isMultipleOf 3) -> "Fizz"
        (number isMultipleOf 5) -> "Buzz"
        else -> number.toString()
    }
}

private infix fun Int.isMultipleOf(number: Int): Boolean {
    return this % number == 0
}

