package org.harundemir.gamestore.utils

import kotlin.random.Random

object Utils {
    fun generateTransactionCode(): String {
        val alphanumericChars = ('A'..'Z') + ('0'..'9')
        return (1..8)
            .map { alphanumericChars[Random.nextInt(alphanumericChars.size)] }
            .joinToString("")
    }
}