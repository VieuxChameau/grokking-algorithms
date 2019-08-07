package org.vieuxchameau.math

fun fibonacci(index: UInt): UInt {
    if (index < 2u) {
        return index
    }
    return fibonacci(index - 1u) + fibonacci(index - 2u)
}

fun fibonacciIterative(index: UInt): UInt {
    if (index < 2u) {
        return index
    }
    var low = 0u
    var high = 1u
    for (x in 2u until index) {
        val new = low + high
        low = high
        high = new
    }
    return high + low
}

fun fibonacciTailRec(index: UInt): UInt {
    if (index < 2u) {
        return index
    }
    return fibonacciTailRec(index, 0u, 1u)
}

private tailrec fun fibonacciTailRec(index: UInt, low: UInt, high: UInt): UInt {
    return if (index == 1u) {
        high
    } else {
        fibonacciTailRec(index - 1u, high, low + high)
    }
}

fun fibonacciMemoized(index: UInt): UInt {
    val cache = mutableMapOf(0u to 0u, 1u to 1u)
    fun fibonacciIn(index: UInt): UInt {
        return cache.getOrPut(index) {
            fibonacciIn(index - 1u) + fibonacciIn(index - 2u)
        }
    }
    return fibonacciIn(index)
}