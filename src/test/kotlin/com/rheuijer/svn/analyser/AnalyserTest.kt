package com.rheuijer.svn.analyser

import com.rheuijer.svn.SVNLogEntry
import com.rheuijer.svn.fetcher.parseSVNLogXml
import org.junit.Test
import java.util.Calendar
import kotlin.test.assertEquals

/**
 * Created by rick on 18/01/2017 in project 'SVNUtils'.
 */
class AnalyserTest {
    @Test
    fun calculateCommitIntensityForWeek() {

        val bufferedReader = this.javaClass.classLoader.getResourceAsStream("test_svn_log.xml").bufferedReader()

        val svnLogEntryList: List<SVNLogEntry> = parseSVNLogXml(bufferedReader.readText())

        val analyser: Analyser = Analyser(svnLogEntryList, 4, AnalysisPeriod.WEEK)

        val result: Map<Int, Int> = analyser.calculateDataForHistogram()

        println(result)

        bufferedReader.close()
    }

    @Test
    fun testCreateSelector() {
        val calendar = Calendar.getInstance()
        val analyser = Analyser(mutableListOf(), 4, AnalysisPeriod.WEEK)

        calendar.set(2017, 0, 1, 0, 9)
        assertEquals(0, analyser.createSelector(calendar.time))

        calendar.set(2017, 0, 2, 0, 9)
        assertEquals(24, analyser.createSelector(calendar.time))

        calendar.set(2017, 0, 2, 1, 9)
        assertEquals(24, analyser.createSelector(calendar.time))

        // todo huh, double check the outcomes!!!
        calendar.set(2017, 0, 2, 4, 9)
        assertEquals(24, analyser.createSelector(calendar.time))

        calendar.set(2017, 0, 2, 8, 9)
        assertEquals(24, analyser.createSelector(calendar.time))

        calendar.set(2017, 0, 15, 8, 9)
        assertEquals(0, analyser.createSelector(calendar.time))

    }

}