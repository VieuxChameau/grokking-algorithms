package org.vieuxchameau

// todo use UInt instead or ULong
fun factorial(number : Int) : Int {
    return if (number == 0) {
        1
    } else {
        number * factorial(number - 1)
    }
}