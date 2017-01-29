package com.rheuijer

import java.text.ParseException
import java.text.SimpleDateFormat

/**
 * Created by rick on 25/01/2017 in project 'SVNUtils'.
 */
/**
 * Rounds the input down to the nearest multiple. For example, floor(23, 10) returns 20.
 */
fun floor(input: Int, multiple: Int) = input - input.mod(multiple)

/**
 * Checks if the [String] is a number.
 */
fun String.isNumber(): Boolean {
    if (this.isBlank()) {
        return false
    }

    this.forEach {
        if (!it.isDigit()) return false
    }
    return true
}

/**
 * Checks if the [String] is a valid date.
 */
fun String.isDate(dateFormat: String): Boolean {
    try {
        val df = SimpleDateFormat(dateFormat)
        df.isLenient = false
        df.parse(this)
    } catch (e: ParseException) {
        return false
    }
    return true
}