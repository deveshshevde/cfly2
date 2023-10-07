package org.jcodec.common.logging;

import java.util.LinkedList;
import java.util.List;

public class Logger {

    /* renamed from: a  reason: collision with root package name */
    private static List<a> f33159a = new LinkedList();

    /* renamed from: b  reason: collision with root package name */
    private static List<a> f33160b;

    public enum Level {
        DEBUG,
        INFO,
        WARN,
        ERROR
    }

    public interface a {
        void a(b bVar);
    }

    public static class b {

        /* renamed from: a  reason: collision with root package name */
        private Level f33166a;

        /* renamed from: b  reason: collision with root package name */
        private String f33167b;

        /* renamed from: c  reason: collision with root package name */
        private String f33168c;

        /* renamed from: d  reason: collision with root package name */
        private int f33169d;

        /* renamed from: e  reason: collision with root package name */
        private String f33170e;

        /* renamed from: f  reason: collision with root package name */
        private String f33171f;

        public b(Level level, String str, String str2, String str3, int i2, String str4) {
            this.f33166a = level;
            this.f33167b = str;
            this.f33168c = str2;
            this.f33171f = str3;
            this.f33170e = str3;
            this.f33169d = i2;
            this.f33170e = str4;
        }

        public Level a() {
            return this.f33166a;
        }

        public String b() {
            return this.f33167b;
        }

        public String c() {
            return this.f33168c;
        }

        public String d() {
            return this.f33171f;
        }

        public int e() {
            return this.f33169d;
        }

        public String f() {
            return this.f33170e;
        }
    }

    public static void a(String str) {
        a(Level.WARN, str);
    }

    private static void a(Level level, String str) {
        if (f33160b == null) {
            synchronized (Logger.class) {
                if (f33160b == null) {
                    List<a> list = f33159a;
                    f33160b = list;
                    f33159a = null;
                    if (list.isEmpty()) {
                        f33160b.add(new a());
                    }
                }
            }
        }
        StackTraceElement stackTraceElement = Thread.currentThread().getStackTrace()[3];
        b bVar = new b(level, stackTraceElement.getFileName(), stackTraceElement.getClassName(), stackTraceElement.getMethodName(), stackTraceElement.getLineNumber(), str);
        for (a a2 : f33160b) {
            a2.a(bVar);
        }
    }
}
