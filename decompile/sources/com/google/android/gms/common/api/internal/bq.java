package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.api.a;
import com.google.android.gms.common.api.g;
import com.google.android.gms.common.api.internal.d;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public interface bq {
    <A extends a.b, R extends g, T extends d.a<R, A>> T a(T t2);

    void a();

    void a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    <A extends a.b, T extends d.a<? extends g, A>> T b(T t2);

    void b();

    void c();

    boolean d();

    boolean e();
}
