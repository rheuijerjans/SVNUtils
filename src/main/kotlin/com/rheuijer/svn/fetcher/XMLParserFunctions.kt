package com.rheuijer.svn.fetcher

import com.rheuijer.svn.SVNLogEntry
import com.rheuijer.svn.jaxb.log.LogType
import com.rheuijer.svn.jaxb.log.ObjectFactory
import javax.xml.bind.JAXBContext
import javax.xml.bind.JAXBElement

/**
 * Created by rick on 18/01/2017 in project 'SVNUtils'.
 */
fun parseSVNLogXml(output: String): List<SVNLogEntry> {
    val xml = output.trim()

    val jc = JAXBContext.newInstance(ObjectFactory::class.java)
    val unmarshaller = jc.createUnmarshaller()


    val stringReader = xml.reader()
    val unmarshal: Any = unmarshaller.unmarshal(stringReader)

    stringReader.close()

    val result = (unmarshal as JAXBElement<LogType>).value

    val svnLogEntryList: List<SVNLogEntry> = result.logentry.map {
        SVNLogEntry(
                author = it.author,
                dateTime = it.date.toGregorianCalendar().time,
                message = it.msg,
                revision = it.revision)
    }
    return svnLogEntryList
}