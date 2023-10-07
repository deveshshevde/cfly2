package com.hoho.android.usb.usb.data_proxy.log;

public final class b extends a {

    /* renamed from: b  reason: collision with root package name */
    private static final b f20283b = new b();

    /* renamed from: c  reason: collision with root package name */
    private LogLevel f20284c = LogLevel.INFO;

    private b() {
    }

    public static void e(String str, String str2, Object... objArr) {
        f20283b.a(str, str2, objArr);
    }

    public static void f(String str, String str2, Object... objArr) {
        f20283b.b(str, str2, objArr);
    }

    public static void g(String str, String str2, Object... objArr) {
        f20283b.c(str, str2, objArr);
    }

    public static void h(String str, String str2, Object... objArr) {
        f20283b.d(str, str2, objArr);
    }

    /* access modifiers changed from: protected */
    public boolean a(LogLevel logLevel) {
        return logLevel.ordinal() >= this.f20284c.ordinal();
    }
}
