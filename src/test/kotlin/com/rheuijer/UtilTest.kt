package com.rheuijer

import org.junit.Test
import kotlin.test.assertEquals

/**
 * Created by rick on 25/01/2017 in project 'SVNUtils'.
 */
class UtilTest {

    @Test
    fun testFloor() {
        assertEquals(20, floor(20, 10))
        assertEquals(20, floor(23, 4))
        assertEquals(24, floor(24, 4))
        assertEquals(9, floor(10, 3))
        assertEquals(8, floor(10, 4))
    }

}