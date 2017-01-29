package com.rheuijer.svn.fetcher

import com.rheuijer.TestConfig
import org.junit.AfterClass
import org.junit.BeforeClass
import org.junit.Test
import java.io.File


/**
 * Created by rick on 13/01/2017 in project 'SVNUtils'.
 */
class LogFetcherTest {

    /**
     * The companion object contains the java static methods required for JUnit.
     */
    companion object {
        @JvmStatic @BeforeClass fun setUp() {
            val pathToBatchFile = this.javaClass.classLoader.getResource("createLocalRepo.bat").path

            // Start the script and wait till it's finished. If we don't wait then the test is run before the setUp is finished.
            val process = ProcessBuilder()
                    .command(pathToBatchFile, TestConfig.testDir)
                    .start()
                    .waitFor()
        }

        @JvmStatic @AfterClass fun tearDown() {
            // Now delete the test directories.
            File("${TestConfig.testDir}\\testrepo").deleteRecursively()
            File("${TestConfig.testDir}\\local").deleteRecursively()
        }
    }

    @Test
    fun testFetchAll() {
        val fetcher = LogFetcher("file:///${TestConfig.testDir}/testrepo")
        fetcher.fetch(null)
    }

    @Test
    fun testFetchByDateRange() {
        val fetcher = LogFetcher("file:///${TestConfig.testDir}/testrepo")
        fetcher.fetch(Pair("2016-01-01", "2016-06-03"))
    }
    @Test
    fun testFetchByRevsionsRange() {
        val fetcher = LogFetcher("file:///${TestConfig.testDir}/testrepo")
        fetcher.fetch(Pair("1", "2"))
    }

}