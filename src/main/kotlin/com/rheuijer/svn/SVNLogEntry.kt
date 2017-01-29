package com.rheuijer.svn

import java.util.Date

/**
 * Created by rick on 16/01/2017 in project 'SVNUtils'.
 */
data class SVNLogEntry(val revision: Long, val author: String, val dateTime: Date, val message: String)