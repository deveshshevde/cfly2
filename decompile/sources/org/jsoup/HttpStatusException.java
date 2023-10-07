package org.jsoup;

import java.io.IOException;

public class HttpStatusException extends IOException {

    /* renamed from: a  reason: collision with root package name */
    private int f33567a;

    /* renamed from: b  reason: collision with root package name */
    private String f33568b;

    public HttpStatusException(String str, int i2, String str2) {
        super(str);
        this.f33567a = i2;
        this.f33568b = str2;
    }

    public String toString() {
        return super.toString() + ". Status=" + this.f33567a + ", URL=" + this.f33568b;
    }
}
