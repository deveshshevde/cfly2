package org.jsoup.parser;

public class c {

    /* renamed from: a  reason: collision with root package name */
    private int f33825a;

    /* renamed from: b  reason: collision with root package name */
    private String f33826b;

    c(int i2, String str) {
        this.f33825a = i2;
        this.f33826b = str;
    }

    c(int i2, String str, Object... objArr) {
        this.f33826b = String.format(str, objArr);
        this.f33825a = i2;
    }

    public String toString() {
        return this.f33825a + ": " + this.f33826b;
    }
}
