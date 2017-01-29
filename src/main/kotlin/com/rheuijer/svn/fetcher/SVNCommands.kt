package com.rheuijer.svn.fetcher

import com.rheuijer.isDate
import com.rheuijer.isNumber

fun createSVNLogCommand(uri: String,
                        limit: Int? = null,
                        asXML: Boolean = true,
                        range: Pair<String, String>? = null): MutableList<String> {

    val cmd = mutableListOf("svn", "log")

    cmd.add(uri)
    if (limit != null) cmd.add("-l $limit")
    if (asXML) cmd.add("--xml")

    if (range != null) {
        cmd.add(parseRange(range))
    }

    return cmd
}

/**
 * Parses the range. The range can contain revision numbers or dates, but not both. Although,
 * that could actually be supported later on.
 */
private fun parseRange(range: Pair<String, String>): String {
    val bounds = range.toList()

    return if (bounds.any { it.isNumber() }) {
        "-r${range.first}:${range.second}"

    } else if (bounds.any { it.isDate("yyyy-MM-dd") }) {
        "-r{${range.first}}:{${range.second}}"

    } else {
        error("range is not valid")
    }
}


