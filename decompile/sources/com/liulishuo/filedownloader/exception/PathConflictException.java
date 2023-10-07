package com.liulishuo.filedownloader.exception;

import iq.f;

public class PathConflictException extends IllegalAccessException {

    /* renamed from: a  reason: collision with root package name */
    private final String f21346a;

    /* renamed from: b  reason: collision with root package name */
    private final String f21347b;

    /* renamed from: c  reason: collision with root package name */
    private final int f21348c;

    public PathConflictException(int i2, String str, String str2) {
        super(f.a("There is an another running task(%d) with the same downloading path(%s), because of they are with the same target-file-path(%s), so if the current task is started, the path of the file is sure to be written by multiple tasks, it is wrong, then you receive this exception to avoid such conflict.", Integer.valueOf(i2), str, str2));
        this.f21348c = i2;
        this.f21346a = str;
        this.f21347b = str2;
    }
}
