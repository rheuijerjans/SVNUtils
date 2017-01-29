package com.rheuijer.commandline

/**
 * Command line executor.
 *
 * Execute commands with with [execute]. Check the properties [output] and [error]
 * for the command line output. Each call to [execute] appends the results to the result
 * that is already stored, i.e. the properties [output] and [error] are never cleared.
 */
class CommandLine {

    var output: String = ""
    var error: String = ""

    /**
     * Executes a command in the command line.
     *
     * @param command list with the command. The first value of the list must be the
     * command, the other values are parameters.
     */
    fun execute(command: List<String>) {
        val processBuilder = ProcessBuilder().command(command)

        val process = processBuilder.start()

        process.waitFor() // wait for the process to terminate.

        val outputReader = process.inputStream.bufferedReader()
        val errorReader = process.errorStream.bufferedReader()

        output += outputReader.readText()
        error += errorReader.readText()

    }
}