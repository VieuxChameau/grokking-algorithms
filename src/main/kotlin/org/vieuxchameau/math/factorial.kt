package org.vieuxchameau.math

fun factorial(number: UInt): UInt {
    return if (number == 0u) {
        1u
    } else {
        number * factorial(number - 1u)
    }
}

tailrec fun factorialTailRec(number: UInt, res: UInt = 1u): UInt {
    return if (number == 0u) {
        res
    } else {
        factorialTailRec(number - 1u, res * number)
    }
}