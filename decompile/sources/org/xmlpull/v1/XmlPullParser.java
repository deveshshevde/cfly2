package org.xmlpull.v1;

import java.io.IOException;
import java.io.Reader;

public interface XmlPullParser {
    public static final byte CDSECT = 5;
    public static final int COMMENT = 9;
    public static final int DOCDECL = 10;
    public static final int END_DOCUMENT = 1;
    public static final int END_TAG = 3;
    public static final byte ENTITY_REF = 6;
    public static final String FEATURE_PROCESS_DOCDECL = "http://xmlpull.org/v1/doc/features.html#process-docdecl";
    public static final String FEATURE_PROCESS_NAMESPACES = "http://xmlpull.org/v1/doc/features.html#process-namespaces";
    public static final String FEATURE_REPORT_NAMESPACE_ATTRIBUTES = "http://xmlpull.org/v1/doc/features.html#report-namespace-prefixes";
    public static final String FEATURE_VALIDATION = "http://xmlpull.org/v1/doc/features.html#validation";
    public static final byte IGNORABLE_WHITESPACE = 7;
    public static final String NO_NAMESPACE = "";
    public static final byte PROCESSING_INSTRUCTION = 8;
    public static final int START_DOCUMENT = 0;
    public static final int START_TAG = 2;
    public static final int TEXT = 4;
    public static final String[] TYPES = {"START_DOCUMENT", "END_DOCUMENT", "START_TAG", "END_TAG", "TEXT", "CDSECT", "ENTITY_REF", "IGNORABLE_WHITESPACE", "PROCESSING_INSTRUCTION", "COMMENT", "DOCDECL"};

    void defineEntityReplacementText(String str, String str2) throws XmlPullParserException;

    int getAttributeCount();

    String getAttributeName(int i2);

    String getAttributeNamespace(int i2);

    String getAttributePrefix(int i2);

    String getAttributeValue(int i2);

    String getAttributeValue(String str, String str2);

    int getColumnNumber();

    int getDepth();

    int getEventType() throws XmlPullParserException;

    boolean getFeature(String str);

    int getLineNumber();

    String getName();

    String getNamespace();

    String getNamespace(String str) throws XmlPullParserException;

    int getNamespaceCount(int i2) throws XmlPullParserException;

    String getNamespacePrefix(int i2) throws XmlPullParserException;

    String getNamespaceUri(int i2) throws XmlPullParserException;

    String getPositionDescription();

    String getPrefix();

    Object getProperty(String str);

    String getText();

    char[] getTextCharacters(int[] iArr);

    boolean isEmptyElementTag() throws XmlPullParserException;

    boolean isWhitespace() throws XmlPullParserException;

    int next() throws XmlPullParserException, IOException;

    int nextToken() throws XmlPullParserException, IOException;

    String readText() throws XmlPullParserException, IOException;

    void require(int i2, String str, String str2) throws XmlPullParserException, IOException;

    void setFeature(String str, boolean z2) throws XmlPullParserException;

    void setInput(Reader reader) throws XmlPullParserException;

    void setProperty(String str, Object obj) throws XmlPullParserException;
}
