package org.harundemir.gamestore.utils

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter
import java.util.Locale
import kotlin.random.Random


object Utils {
    fun generateOrderCode(): String {
        val alphanumericChars = ('A'..'Z') + ('0'..'9')
        return (1..8)
            .map { alphanumericChars[Random.nextInt(alphanumericChars.size)] }
            .joinToString("")
    }

    fun getFormattedDateTime(dateTimeString: String): String {
        return try {
            val instant = Instant.parse(dateTimeString)
            val zoneId = ZoneId.systemDefault()
            val zonedDateTime = instant.atZone(zoneId)
            val currentLocale = Locale.getDefault()
            val formatter = DateTimeFormatter.ofPattern("EEE, MMM dd yyyy", currentLocale)
            zonedDateTime.format(formatter)
        } catch (e: Exception) {
            e.printStackTrace()
            "Error occurred"
        }
    }
}