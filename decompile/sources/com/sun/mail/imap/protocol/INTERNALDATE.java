package com.sun.mail.imap.protocol;

import com.sun.mail.iap.ParsingException;
import java.text.FieldPosition;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import javax.mail.internet.MailDateFormat;

public class INTERNALDATE implements Item {

    /* renamed from: df  reason: collision with root package name */
    private static SimpleDateFormat f21761df = new SimpleDateFormat("dd-MMM-yyyy HH:mm:ss ", Locale.US);
    private static MailDateFormat mailDateFormat = new MailDateFormat();
    static final char[] name = {'I', 'N', 'T', 'E', 'R', 'N', 'A', 'L', 'D', 'A', 'T', 'E'};
    protected Date date;
    public int msgno;

    public INTERNALDATE(FetchResponse fetchResponse) throws ParsingException {
        this.msgno = fetchResponse.getNumber();
        fetchResponse.skipSpaces();
        String readString = fetchResponse.readString();
        if (readString != null) {
            try {
                this.date = mailDateFormat.parse(readString);
            } catch (ParseException unused) {
                throw new ParsingException("INTERNALDATE parse error");
            }
        } else {
            throw new ParsingException("INTERNALDATE is NIL");
        }
    }

    public static String format(Date date2) {
        StringBuffer stringBuffer = new StringBuffer();
        synchronized (f21761df) {
            f21761df.format(date2, stringBuffer, new FieldPosition(0));
        }
        int i2 = -date2.getTimezoneOffset();
        if (i2 < 0) {
            stringBuffer.append('-');
            i2 = -i2;
        } else {
            stringBuffer.append('+');
        }
        int i3 = i2 / 60;
        int i4 = i2 % 60;
        stringBuffer.append(Character.forDigit(i3 / 10, 10));
        stringBuffer.append(Character.forDigit(i3 % 10, 10));
        stringBuffer.append(Character.forDigit(i4 / 10, 10));
        stringBuffer.append(Character.forDigit(i4 % 10, 10));
        return stringBuffer.toString();
    }

    public Date getDate() {
        return this.date;
    }
}
