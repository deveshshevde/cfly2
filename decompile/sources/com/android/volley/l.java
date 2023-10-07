package com.android.volley;

import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class l {

    /* renamed from: a  reason: collision with root package name */
    public static String f9935a = "Volley";

    /* renamed from: b  reason: collision with root package name */
    public static final boolean f9936b = Log.isLoggable("Volley", 2);

    static class a {

        /* renamed from: a  reason: collision with root package name */
        public static final boolean f9937a = l.f9936b;

        /* renamed from: b  reason: collision with root package name */
        private final List<C0078a> f9938b = new ArrayList();

        /* renamed from: c  reason: collision with root package name */
        private boolean f9939c = false;

        /* renamed from: com.android.volley.l$a$a  reason: collision with other inner class name */
        private static class C0078a {

            /* renamed from: a  reason: collision with root package name */
            public final String f9940a;

            /* renamed from: b  reason: collision with root package name */
            public final long f9941b;

            /* renamed from: c  reason: collision with root package name */
            public final long f9942c;

            public C0078a(String str, long j2, long j3) {
                this.f9940a = str;
                this.f9941b = j2;
                this.f9942c = j3;
            }
        }

        a() {
        }

        private long a() {
            if (this.f9938b.size() == 0) {
                return 0;
            }
            long j2 = this.f9938b.get(0).f9942c;
            List<C0078a> list = this.f9938b;
            return list.get(list.size() - 1).f9942c - j2;
        }

        public synchronized void a(String str) {
            this.f9939c = true;
            long a2 = a();
            if (a2 > 0) {
                long j2 = this.f9938b.get(0).f9942c;
                l.b("(%-4d ms) %s", Long.valueOf(a2), str);
                for (C0078a next : this.f9938b) {
                    long j3 = next.f9942c;
                    l.b("(+%-4d) [%2d] %s", Long.valueOf(j3 - j2), Long.valueOf(next.f9941b), next.f9940a);
                    j2 = j3;
                }
            }
        }

        public synchronized void a(String str, long j2) {
            if (!this.f9939c) {
                this.f9938b.add(new C0078a(str, j2, SystemClock.elapsedRealtime()));
            } else {
                throw new IllegalStateException("Marker added to finished log");
            }
        }

        /* access modifiers changed from: protected */
        public void finalize() throws Throwable {
            if (!this.f9939c) {
                a("Request on the loose");
                l.c("Marker log finalized without finish() - uncaught exit point for request", new Object[0]);
            }
        }
    }

    public static void a(String str, Object... objArr) {
        if (f9936b) {
            Log.v(f9935a, d(str, objArr));
        }
    }

    public static void a(Throwable th, String str, Object... objArr) {
        Log.e(f9935a, d(str, objArr), th);
    }

    public static void b(String str, Object... objArr) {
        Log.d(f9935a, d(str, objArr));
    }

    public static void c(String str, Object... objArr) {
        Log.e(f9935a, d(str, objArr));
    }

    private static String d(String str, Object... objArr) {
        String str2;
        if (objArr != null) {
            str = String.format(Locale.US, str, objArr);
        }
        StackTraceElement[] stackTrace = new Throwable().fillInStackTrace().getStackTrace();
        int i2 = 2;
        while (true) {
            if (i2 >= stackTrace.length) {
                str2 = "<unknown>";
                break;
            } else if (!stackTrace[i2].getClass().equals(l.class)) {
                String className = stackTrace[i2].getClassName();
                String substring = className.substring(className.lastIndexOf(46) + 1);
                str2 = String.valueOf(substring.substring(substring.lastIndexOf(36) + 1)) + "." + stackTrace[i2].getMethodName();
                break;
            } else {
                i2++;
            }
        }
        return String.format(Locale.US, "[%d] %s: %s", new Object[]{Long.valueOf(Thread.currentThread().getId()), str2, str});
    }
}
