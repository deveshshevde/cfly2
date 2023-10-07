package com.bumptech.glide.load;

import java.io.IOException;

public final class HttpException extends IOException {
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    private final int f10141a;

    public HttpException(int i2) {
        this("Http request failed", i2);
    }

    public HttpException(String str, int i2) {
        this(str, i2, (Throwable) null);
    }

    public HttpException(String str, int i2, Throwable th) {
        super(str + ", status code: " + i2, th);
        this.f10141a = i2;
    }
}
