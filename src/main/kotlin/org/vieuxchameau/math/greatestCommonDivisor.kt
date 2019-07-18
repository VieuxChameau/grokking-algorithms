package org.vieuxchameau.math

import kotlin.math.max
import kotlin.math.min

fun gcd(left: Int, right: Int): Int {
    val max = max(left, right)
    val min = min(left, right)
    val remainder = max % min

    return if (remainder == 0) {
        min
    } else {
        gcd(remainder, min)
    }
}
