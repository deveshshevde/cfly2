package com.sun.mail.smtp;

import java.io.InputStream;
import javax.mail.MessagingException;
import javax.mail.Session;
import javax.mail.internet.MimeMessage;

public class SMTPMessage extends MimeMessage {
    public static final int NOTIFY_DELAY = 4;
    public static final int NOTIFY_FAILURE = 2;
    public static final int NOTIFY_NEVER = -1;
    public static final int NOTIFY_SUCCESS = 1;
    public static final int RETURN_FULL = 1;
    public static final int RETURN_HDRS = 2;
    private static final String[] returnOptionString;
    private boolean allow8bitMIME = false;
    private String envelopeFrom;
    private String extension = null;
    private int notifyOptions = 0;
    private int returnOption = 0;
    private boolean sendPartial = false;
    private String submitter = null;

    static {
        String[] strArr = new String[3];
        strArr[1] = "FULL";
        strArr[2] = "HDRS";
        returnOptionString = strArr;
    }

    public SMTPMessage(Session session) {
        super(session);
    }

    public SMTPMessage(Session session, InputStream inputStream) throws MessagingException {
        super(session, inputStream);
    }

    public SMTPMessage(MimeMessage mimeMessage) throws MessagingException {
        super(mimeMessage);
    }

    public boolean getAllow8bitMIME() {
        return this.allow8bitMIME;
    }

    /* access modifiers changed from: package-private */
    public String getDSNNotify() {
        int i2 = this.notifyOptions;
        if (i2 == 0) {
            return null;
        }
        if (i2 == -1) {
            return "NEVER";
        }
        StringBuffer stringBuffer = new StringBuffer();
        if ((this.notifyOptions & 1) != 0) {
            stringBuffer.append("SUCCESS");
        }
        if ((this.notifyOptions & 2) != 0) {
            if (stringBuffer.length() != 0) {
                stringBuffer.append(',');
            }
            stringBuffer.append("FAILURE");
        }
        if ((this.notifyOptions & 4) != 0) {
            if (stringBuffer.length() != 0) {
                stringBuffer.append(',');
            }
            stringBuffer.append("DELAY");
        }
        return stringBuffer.toString();
    }

    /* access modifiers changed from: package-private */
    public String getDSNRet() {
        return returnOptionString[this.returnOption];
    }

    public String getEnvelopeFrom() {
        return this.envelopeFrom;
    }

    public String getMailExtension() {
        return this.extension;
    }

    public int getNotifyOptions() {
        return this.notifyOptions;
    }

    public int getReturnOption() {
        return this.returnOption;
    }

    public boolean getSendPartial() {
        return this.sendPartial;
    }

    public String getSubmitter() {
        return this.submitter;
    }

    public void setAllow8bitMIME(boolean z2) {
        this.allow8bitMIME = z2;
    }

    public void setEnvelopeFrom(String str) {
        this.envelopeFrom = str;
    }

    public void setMailExtension(String str) {
        this.extension = str;
    }

    public void setNotifyOptions(int i2) {
        if (i2 < -1 || i2 >= 8) {
            throw new IllegalArgumentException("Bad return option");
        }
        this.notifyOptions = i2;
    }

    public void setReturnOption(int i2) {
        if (i2 < 0 || i2 > 2) {
            throw new IllegalArgumentException("Bad return option");
        }
        this.returnOption = i2;
    }

    public void setSendPartial(boolean z2) {
        this.sendPartial = z2;
    }

    public void setSubmitter(String str) {
        this.submitter = str;
    }
}
