package org.apache.commons.math3.linear;

import java.text.FieldPosition;
import java.text.NumberFormat;
import java.util.Locale;
import nl.a;

public class k {

    /* renamed from: a  reason: collision with root package name */
    private final String f32727a;

    /* renamed from: b  reason: collision with root package name */
    private final String f32728b;

    /* renamed from: c  reason: collision with root package name */
    private final String f32729c;

    /* renamed from: d  reason: collision with root package name */
    private final String f32730d;

    /* renamed from: e  reason: collision with root package name */
    private final String f32731e;

    /* renamed from: f  reason: collision with root package name */
    private final String f32732f;

    /* renamed from: g  reason: collision with root package name */
    private final NumberFormat f32733g;

    public k() {
        this("{", "}", "; ", a.a());
    }

    public k(String str, String str2, String str3, NumberFormat numberFormat) {
        this.f32727a = str;
        this.f32728b = str2;
        this.f32729c = str3;
        this.f32730d = str.trim();
        this.f32731e = str2.trim();
        this.f32732f = str3.trim();
        this.f32733g = numberFormat;
    }

    public k(NumberFormat numberFormat) {
        this("{", "}", "; ", numberFormat);
    }

    public static k a() {
        return a(Locale.getDefault());
    }

    public static k a(Locale locale) {
        return new k(a.a(locale));
    }

    public String a(j jVar) {
        return a(jVar, new StringBuffer(), new FieldPosition(0)).toString();
    }

    public StringBuffer a(j jVar, StringBuffer stringBuffer, FieldPosition fieldPosition) {
        fieldPosition.setBeginIndex(0);
        fieldPosition.setEndIndex(0);
        stringBuffer.append(this.f32727a);
        for (int i2 = 0; i2 < jVar.c(); i2++) {
            if (i2 > 0) {
                stringBuffer.append(this.f32729c);
            }
            a.a(jVar.a(i2), this.f32733g, stringBuffer, fieldPosition);
        }
        stringBuffer.append(this.f32728b);
        return stringBuffer;
    }
}
