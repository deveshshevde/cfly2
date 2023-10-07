package org.apache.commons.net.ftp.parser;

import com.amap.api.maps.AMap;
import java.text.DateFormatSymbols;
import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
import org.apache.commons.net.ftp.a;
import org.apache.commons.net.ftp.d;

public class f implements a, e {

    /* renamed from: f  reason: collision with root package name */
    private static final int[] f32878f = {14, 13, 12, 11, 5, 2, 1};

    /* renamed from: a  reason: collision with root package name */
    private SimpleDateFormat f32879a;

    /* renamed from: b  reason: collision with root package name */
    private int f32880b;

    /* renamed from: c  reason: collision with root package name */
    private SimpleDateFormat f32881c;

    /* renamed from: d  reason: collision with root package name */
    private int f32882d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f32883e;

    public f() {
        a("MMM d yyyy", (DateFormatSymbols) null);
        b("MMM d HH:mm", (DateFormatSymbols) null);
    }

    private static int a(int i2) {
        int i3 = 0;
        while (true) {
            int[] iArr = f32878f;
            if (i3 >= iArr.length) {
                return 0;
            }
            if (i2 == iArr[i3]) {
                return i3;
            }
            i3++;
        }
    }

    private static int a(SimpleDateFormat simpleDateFormat) {
        int i2;
        if (simpleDateFormat == null) {
            return 0;
        }
        String pattern = simpleDateFormat.toPattern();
        for (char c2 : "SsmHdM".toCharArray()) {
            if (pattern.indexOf(c2) != -1) {
                if (c2 == 'H') {
                    i2 = 11;
                } else if (c2 == 'M') {
                    i2 = 2;
                } else if (c2 == 'S') {
                    i2 = 14;
                } else if (c2 == 'd') {
                    i2 = 5;
                } else if (c2 == 'm') {
                    i2 = 12;
                } else if (c2 == 's') {
                    i2 = 13;
                }
                return a(i2);
            }
        }
        return 0;
    }

    private static void a(int i2, Calendar calendar) {
        if (i2 > 0) {
            int i3 = f32878f[i2 - 1];
            if (calendar.get(i3) == 0) {
                calendar.clear(i3);
            }
        }
    }

    private void a(String str, DateFormatSymbols dateFormatSymbols) {
        if (str != null) {
            if (dateFormatSymbols != null) {
                this.f32879a = new SimpleDateFormat(str, dateFormatSymbols);
            } else {
                this.f32879a = new SimpleDateFormat(str);
            }
            this.f32879a.setLenient(false);
        } else {
            this.f32879a = null;
        }
        this.f32880b = a(this.f32879a);
    }

    private void b(String str) {
        TimeZone timeZone = TimeZone.getDefault();
        if (str != null) {
            timeZone = TimeZone.getTimeZone(str);
        }
        this.f32879a.setTimeZone(timeZone);
        SimpleDateFormat simpleDateFormat = this.f32881c;
        if (simpleDateFormat != null) {
            simpleDateFormat.setTimeZone(timeZone);
        }
    }

    private void b(String str, DateFormatSymbols dateFormatSymbols) {
        if (str != null) {
            if (dateFormatSymbols != null) {
                this.f32881c = new SimpleDateFormat(str, dateFormatSymbols);
            } else {
                this.f32881c = new SimpleDateFormat(str);
            }
            this.f32881c.setLenient(false);
        } else {
            this.f32881c = null;
        }
        this.f32882d = a(this.f32881c);
    }

    public Calendar a(String str) throws ParseException {
        return a(str, Calendar.getInstance());
    }

    public Calendar a(String str, Calendar calendar) throws ParseException {
        int i2;
        Calendar calendar2 = (Calendar) calendar.clone();
        calendar2.setTimeZone(a());
        if (this.f32881c != null) {
            Calendar calendar3 = (Calendar) calendar.clone();
            calendar3.setTimeZone(a());
            if (this.f32883e) {
                calendar3.add(5, 1);
            }
            String str2 = str + " " + Integer.toString(calendar3.get(1));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(this.f32881c.toPattern() + " yyyy", this.f32881c.getDateFormatSymbols());
            simpleDateFormat.setLenient(false);
            simpleDateFormat.setTimeZone(this.f32881c.getTimeZone());
            ParsePosition parsePosition = new ParsePosition(0);
            Date parse = simpleDateFormat.parse(str2, parsePosition);
            if (parse != null && parsePosition.getIndex() == str2.length()) {
                calendar2.setTime(parse);
                if (calendar2.after(calendar3)) {
                    calendar2.add(1, -1);
                }
                i2 = this.f32882d;
                a(i2, calendar2);
                return calendar2;
            }
        }
        ParsePosition parsePosition2 = new ParsePosition(0);
        Date parse2 = this.f32879a.parse(str, parsePosition2);
        if (parse2 == null || parsePosition2.getIndex() != str.length()) {
            throw new ParseException("Timestamp '" + str + "' could not be parsed using a server time of " + calendar.getTime().toString(), parsePosition2.getErrorIndex());
        }
        calendar2.setTime(parse2);
        i2 = this.f32880b;
        a(i2, calendar2);
        return calendar2;
    }

    public TimeZone a() {
        return this.f32879a.getTimeZone();
    }

    public void a(d dVar) {
        DateFormatSymbols dateFormatSymbols;
        String f2 = dVar.f();
        String e2 = dVar.e();
        if (e2 != null) {
            dateFormatSymbols = d.d(e2);
        } else {
            if (f2 == null) {
                f2 = AMap.ENGLISH;
            }
            dateFormatSymbols = d.c(f2);
        }
        b(dVar.c(), dateFormatSymbols);
        String b2 = dVar.b();
        if (b2 != null) {
            a(b2, dateFormatSymbols);
            b(dVar.d());
            this.f32883e = dVar.g();
            return;
        }
        throw new IllegalArgumentException("defaultFormatString cannot be null");
    }
}
