package utilities

import kotlin.math.floor
import kotlin.math.pow

// Rounds any Double Value with given precision
public fun round(n: Double, k: Int): Double {
    val c = (10.0).pow(k)
    return floor(n * c) / c
}