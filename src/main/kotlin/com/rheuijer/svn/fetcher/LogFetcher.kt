package com.rheuijer.svn.fetcher

import com.rheuijer.commandline.CommandLine
import com.rheuijer.svn.SVNLogEntry


/**
 * Created by rick on 14/01/2017 in project 'SVNUtils'.
 */
class LogFetcher(val repositoryURI: String) {

    fun fetch(range: Pair<String, String>? = null) {

        val command = createSVNLogCommand(uri = repositoryURI, range = range)

        val commandLine = CommandLine()

        commandLine.execute(command)

        if (commandLine.error.isNotEmpty()) {
            println(commandLine.error)
            error("error executing command")
        }

        println(commandLine.output)

        val svnLogEntryList: List<SVNLogEntry> = parseSVNLogXml(commandLine.output)

        println(svnLogEntryList)
    }
}