package com.github.barteksc.pdfviewer.exception;

public class PageRenderingException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private final int f14627a;

    public PageRenderingException(int i2, Throwable th) {
        super(th);
        this.f14627a = i2;
    }

    public int a() {
        return this.f14627a;
    }
}
