package com.lidroid.xutils.exception;

public class HttpException extends BaseException {
    private static final long serialVersionUID = 1;

    /* renamed from: a  reason: collision with root package name */
    private int f21011a;

    public HttpException() {
    }

    public HttpException(int i2, String str) {
        super(str);
        this.f21011a = i2;
    }

    public HttpException(String str) {
        super(str);
    }

    public HttpException(Throwable th) {
        super(th);
    }
}
