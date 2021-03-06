//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.01.16 at 12:16:04 PM CET 
//


package com.rheuijer.svn.jaxb.log;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.XmlValue;


/**
 * <p>Java class for pathActionType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="pathActionType">
 *   &lt;simpleContent>
 *     &lt;extension base="&lt;http://www.w3.org/2001/XMLSchema>string">
 *       &lt;attribute name="action" use="required" type="{}actionType" />
 *       &lt;attribute name="copyfrom-path" type="{}pathType" />
 *       &lt;attribute name="copyfrom-rev" type="{}revType" />
 *     &lt;/extension>
 *   &lt;/simpleContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "pathActionType", propOrder = {
    "value"
})
public class PathActionType {

    @XmlValue
    protected String value;
    @XmlAttribute(name = "action", required = true)
    protected String action;
    @XmlAttribute(name = "copyfrom-path")
    protected String copyfromPath;
    @XmlAttribute(name = "copyfrom-rev")
    protected Long copyfromRev;

    /**
     * Gets the value of the value property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValue() {
        return value;
    }

    /**
     * Sets the value of the value property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * Gets the value of the action property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAction() {
        return action;
    }

    /**
     * Sets the value of the action property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAction(String value) {
        this.action = value;
    }

    /**
     * Gets the value of the copyfromPath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCopyfromPath() {
        return copyfromPath;
    }

    /**
     * Sets the value of the copyfromPath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCopyfromPath(String value) {
        this.copyfromPath = value;
    }

    /**
     * Gets the value of the copyfromRev property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getCopyfromRev() {
        return copyfromRev;
    }

    /**
     * Sets the value of the copyfromRev property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setCopyfromRev(Long value) {
        this.copyfromRev = value;
    }

}
