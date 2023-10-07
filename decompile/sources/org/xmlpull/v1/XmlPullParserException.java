package org.xmlpull.v1;

import java.io.PrintStream;

public class XmlPullParserException extends Exception {
    protected int column = -1;
    protected Throwable detail;
    protected int row = -1;

    public XmlPullParserException() {
    }

    public XmlPullParserException(String str) {
        super(str);
    }

    public XmlPullParserException(String str, int i2, int i3) {
        super(str);
        this.row = i2;
        this.column = i3;
    }

    public XmlPullParserException(String str, Throwable th) {
        super(str);
        this.detail = th;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public XmlPullParserException(java.lang.String r2, org.xmlpull.v1.XmlPullParser r3) {
        /*
            r1 = this;
            java.lang.StringBuffer r0 = new java.lang.StringBuffer
            r0.<init>()
            r0.append(r2)
            java.lang.String r2 = r3.getPositionDescription()
            r0.append(r2)
            java.lang.String r2 = r0.toString()
            r1.<init>(r2)
            r2 = -1
            r1.row = r2
            r1.column = r2
            int r2 = r3.getLineNumber()
            r1.row = r2
            int r2 = r3.getColumnNumber()
            r1.column = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.xmlpull.v1.XmlPullParserException.<init>(java.lang.String, org.xmlpull.v1.XmlPullParser):void");
    }

    public int getColumnNumber() {
        return this.column;
    }

    public Throwable getDetail() {
        return this.detail;
    }

    public int getLineNumber() {
        return this.row;
    }

    public String getMessage() {
        if (this.detail == null) {
            return super.getMessage();
        }
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(super.getMessage());
        stringBuffer.append("; nested exception is: \n\t");
        stringBuffer.append(this.detail.getMessage());
        return stringBuffer.toString();
    }

    public void printStackTrace() {
        if (this.detail == null) {
            super.printStackTrace();
            return;
        }
        synchronized (System.err) {
            PrintStream printStream = System.err;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append(super.getMessage());
            stringBuffer.append("; nested exception is:");
            printStream.println(stringBuffer.toString());
            this.detail.printStackTrace();
        }
    }

    public void setDetail(Throwable th) {
        this.detail = th;
    }
}
