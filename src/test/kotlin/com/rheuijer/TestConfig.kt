package com.rheuijer

import java.util.Properties

/**
 * Created by rick on 26/01/2017 in project 'SVNUtils'.
 */
object TestConfig {

    init {
        loadResources()
    }

    lateinit var testDir: String;

    private fun loadResources() {
        val propResourceAsStream = this.javaClass.classLoader.getResourceAsStream("test_config.properties")
        val properties = Properties()
        properties.load(propResourceAsStream)

        testDir = properties.getProperty("testDir")
    }

}