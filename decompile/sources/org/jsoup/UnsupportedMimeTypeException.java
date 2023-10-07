package org.jsoup;

import java.io.IOException;

public class UnsupportedMimeTypeException extends IOException {

    /* renamed from: a  reason: collision with root package name */
    private String f33569a;

    /* renamed from: b  reason: collision with root package name */
    private String f33570b;

    public UnsupportedMimeTypeException(String str, String str2, String str3) {
        super(str);
        this.f33569a = str2;
        this.f33570b = str3;
    }

    public String toString() {
        return super.toString() + ". Mimetype=" + this.f33569a + ", URL=" + this.f33570b;
    }
}
