package com.liulishuo.filedownloader;

import android.content.Context;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import com.liulishuo.filedownloader.services.e;
import iq.e;

public class m implements u {

    /* renamed from: a  reason: collision with root package name */
    private final u f21366a;

    private static final class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final m f21367a = new m();
    }

    private m() {
        this.f21366a = e.a().f29061d ? new n() : new o();
    }

    public static m a() {
        return a.f21367a;
    }

    public static e.a b() {
        if (a().f21366a instanceof n) {
            return (e.a) a().f21366a;
        }
        return null;
    }

    public void a(Context context) {
        this.f21366a.a(context);
    }

    public void a(boolean z2) {
        this.f21366a.a(z2);
    }

    public boolean a(int i2) {
        return this.f21366a.a(i2);
    }

    public boolean a(String str, String str2, boolean z2, int i2, int i3, int i4, boolean z3, FileDownloadHeader fileDownloadHeader, boolean z4) {
        return this.f21366a.a(str, str2, z2, i2, i3, i4, z3, fileDownloadHeader, z4);
    }

    public byte b(int i2) {
        return this.f21366a.b(i2);
    }

    public void b(Context context) {
        this.f21366a.b(context);
    }

    public void c() {
        this.f21366a.c();
    }

    public boolean c(int i2) {
        return this.f21366a.c(i2);
    }

    public boolean d() {
        return this.f21366a.d();
    }

    public void e() {
        this.f21366a.e();
    }

    public boolean f() {
        return this.f21366a.f();
    }
}
