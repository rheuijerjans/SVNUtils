package com.rheuijer.svn.analyser

import com.rheuijer.floor
import com.rheuijer.svn.SVNLogEntry
import java.util.Calendar
import java.util.Date

/**
 * Analyser for SVN logs.
 *
 * @param svnLogEntries a list with SVNLogEntries.
 * @param analysisPeriod the period on which the analysis is run. For example, if the analysisPeriod is AnalysisPeriod.WEEK,
 * then the analyser considers groups all Monday's together. For AnalysisPeriod.YEAR, then all first Mondays of January are grouped.
 * @param binSize
 *
 */
class Analyser(private val svnLogEntries: List<SVNLogEntry>,
               private val binSize: Int,
               private val analysisPeriod: AnalysisPeriod) {

    fun calculateDataForHistogram(): Map<Int, Int> {

        val selectorSVNLogEntryListMap: Map<Int, List<SVNLogEntry>> = groupIntoBlocks()

        return countNumberInBlocks(selectorSVNLogEntryListMap)
    }

    /**
     * Groups the svnLogEntries into the blocks.
     *
     * @return a map that with key the starting hour count of the group, and value the number of items in the group.
     */
    fun groupIntoBlocks(): Map<Int, List<SVNLogEntry>> {
        return svnLogEntries.groupBy { createSelector(it.dateTime) }
    }

    fun countNumberInBlocks(selectorSVNLogEntryListMap: Map<Int, List<SVNLogEntry>>): Map<Int, Int> {
        return selectorSVNLogEntryListMap.mapValues { it.value.size }
    }

    /**
     * Creates a selector for a given date and time.
     */
    fun createSelector(dateTime: Date): Int {
        val calendar = Calendar.getInstance()
        calendar.time = dateTime

        val result = when (analysisPeriod) {
            AnalysisPeriod.DAY -> {
                addHours(calendar)
            }
            AnalysisPeriod.WEEK -> {
                addDaysOfTheWeek(calendar) + addHours(calendar)

            }
            AnalysisPeriod.YEAR -> {
                addWeeks(calendar) + addDaysOfTheWeek(calendar) + addHours(calendar)
            }
            else -> {
                error("not supported")
            }
        }

        return floor(result, binSize)

    }

    /**
     * @return the total number of hours in the weeks that passed in the year.
     */
    private fun addWeeks(calendar: Calendar): Int {
        return calendar.get(Calendar.WEEK_OF_YEAR) * 7 * 24
    }

    /**
     * @return the number of hours calculated in the days that passed in the week.
     */
    private fun addDaysOfTheWeek(calendar: Calendar): Int {
        return (calendar.get(Calendar.DAY_OF_WEEK) - 1) * 24
    }

    /**
     * @return the hours that passed in the day.
     */
    private fun addHours(calendar: Calendar): Int {
        return calendar.get(Calendar.DAY_OF_WEEK)
    }
}

