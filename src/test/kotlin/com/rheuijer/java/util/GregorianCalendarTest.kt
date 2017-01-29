package com.rheuijer.java.util

import org.junit.Test
import java.util.Calendar
import java.util.GregorianCalendar
import kotlin.test.assertEquals

/**
 * Created by rick on 20/01/2017 in project 'SVNUtils'.
 */
class GregorianCalendarTest {

    @Test
    fun testGetMaximum() {
        val calendar = GregorianCalendar()
        assertEquals(11, calendar.getActualMaximum(Calendar.MONTH))
        assertEquals(52, calendar.getActualMaximum(Calendar.WEEK_OF_YEAR))
        assertEquals(7, calendar.getActualMaximum(Calendar.DAY_OF_WEEK))
        assertEquals(23, calendar.getActualMaximum(Calendar.HOUR_OF_DAY))
        assertEquals(11, calendar.getActualMaximum(Calendar.HOUR))

    }

    @Test
    fun testGetActualMinimum() {
        val calendar = GregorianCalendar()
        assertEquals(0, calendar.getActualMinimum(Calendar.MONTH))
        assertEquals(1, calendar.getActualMinimum(Calendar.WEEK_OF_YEAR))
        assertEquals(1, calendar.getActualMinimum(Calendar.DAY_OF_WEEK))
        assertEquals(0, calendar.getActualMinimum(Calendar.HOUR_OF_DAY))
        assertEquals(0, calendar.getActualMinimum(Calendar.HOUR))
    }
}