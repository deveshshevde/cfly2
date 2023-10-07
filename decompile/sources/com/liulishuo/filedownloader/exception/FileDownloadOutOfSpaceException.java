package com.liulishuo.filedownloader.exception;

import iq.f;
import java.io.IOException;

public class FileDownloadOutOfSpaceException extends IOException {

    /* renamed from: a  reason: collision with root package name */
    private long f21343a;

    /* renamed from: b  reason: collision with root package name */
    private long f21344b;

    /* renamed from: c  reason: collision with root package name */
    private long f21345c;

    public FileDownloadOutOfSpaceException(long j2, long j3, long j4) {
        super(f.a("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2)));
        a(j2, j3, j4);
    }

    public FileDownloadOutOfSpaceException(long j2, long j3, long j4, Throwable th) {
        super(f.a("The file is too large to store, breakpoint in bytes:  %d, required space in bytes: %d, but free space in bytes: %d", Long.valueOf(j4), Long.valueOf(j3), Long.valueOf(j2)), th);
        a(j2, j3, j4);
    }

    private void a(long j2, long j3, long j4) {
        this.f21343a = j2;
        this.f21344b = j3;
        this.f21345c = j4;
    }
}
