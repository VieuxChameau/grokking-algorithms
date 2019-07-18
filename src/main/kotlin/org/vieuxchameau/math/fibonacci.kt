package org.vieuxchameau.math

fun fibonacci(index: UInt): UInt {
    if (index < 2u) {
        return index
    }
    return fibonacci(index - 1u) + fibonacci(index - 2u)
}


fun fibonacciMemoized(index: UInt): UInt {
    val cache = mutableMapOf<UInt, UInt>()
    fun fibonacci(index: UInt): UInt {
        return cache.getOrPut(index) {
            return@getOrPut if (index < 2u) {
                index
            } else {
                fibonacci(index - 1u) + fibonacci(index - 2u)
            }
        }
    }
    return fibonacci(index)
}