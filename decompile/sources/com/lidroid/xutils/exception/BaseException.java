package com.lidroid.xutils.exception;

public class BaseException extends Exception {
    private static final long serialVersionUID = 1;

    public BaseException() {
    }

    public BaseException(String str) {
        super(str);
    }

    public BaseException(Throwable th) {
        super(th);
    }
}
