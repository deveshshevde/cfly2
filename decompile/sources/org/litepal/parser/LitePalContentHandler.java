package org.litepal.parser;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class LitePalContentHandler extends DefaultHandler {
    private LitePalAttr litePalAttr;

    public void characters(char[] cArr, int i2, int i3) throws SAXException {
    }

    public void endDocument() throws SAXException {
    }

    public void endElement(String str, String str2, String str3) throws SAXException {
    }

    public void startDocument() throws SAXException {
        LitePalAttr instance = LitePalAttr.getInstance();
        this.litePalAttr = instance;
        instance.getClassNames().clear();
    }

    public void startElement(String str, String str2, String str3, Attributes attributes) throws SAXException {
        int i2 = 0;
        if ("dbname".equalsIgnoreCase(str2)) {
            while (i2 < attributes.getLength()) {
                if ("value".equalsIgnoreCase(attributes.getLocalName(i2))) {
                    this.litePalAttr.setDbName(attributes.getValue(i2).trim());
                }
                i2++;
            }
        } else if ("version".equalsIgnoreCase(str2)) {
            while (i2 < attributes.getLength()) {
                if ("value".equalsIgnoreCase(attributes.getLocalName(i2))) {
                    this.litePalAttr.setVersion(Integer.parseInt(attributes.getValue(i2).trim()));
                }
                i2++;
            }
        } else if ("mapping".equalsIgnoreCase(str2)) {
            while (i2 < attributes.getLength()) {
                if ("class".equalsIgnoreCase(attributes.getLocalName(i2))) {
                    this.litePalAttr.addClassName(attributes.getValue(i2).trim());
                }
                i2++;
            }
        } else if ("cases".equalsIgnoreCase(str2)) {
            while (i2 < attributes.getLength()) {
                if ("value".equalsIgnoreCase(attributes.getLocalName(i2))) {
                    this.litePalAttr.setCases(attributes.getValue(i2).trim());
                }
                i2++;
            }
        } else if ("storage".equalsIgnoreCase(str2)) {
            while (i2 < attributes.getLength()) {
                if ("value".equalsIgnoreCase(attributes.getLocalName(i2))) {
                    this.litePalAttr.setStorage(attributes.getValue(i2).trim());
                }
                i2++;
            }
        }
    }
}
