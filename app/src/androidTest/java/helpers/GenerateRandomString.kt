package helpers

import  kotlin.random.Random

fun generateRandomString(length: Int = 4): String = List(length) {
    (('a'..'z') + ('A'..'Z') + ('0'..'9')).random(Random(System.currentTimeMillis()))
}.joinToString("")
