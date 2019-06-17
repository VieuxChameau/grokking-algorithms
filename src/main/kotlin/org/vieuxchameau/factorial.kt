package org.vieuxchameau

fun factorial(number: UInt): UInt {
    return if (number == 0u) {
        1u
    } else {
        number * factorial(number - 1u)
    }
}