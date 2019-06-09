package org.vieuxchameau

import kotlin.random.Random

fun IntArray.asString() = this.joinToString(prefix = "[", postfix = "]")

fun arrayOfRandomInts(size: UInt = 10u) = IntArray(size.toInt()) { Random.nextInt() }