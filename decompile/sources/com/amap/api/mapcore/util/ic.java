package com.amap.api.mapcore.util;

import android.text.TextUtils;
import java.lang.Thread;
import java.util.Objects;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicLong;

public final class ic implements ThreadFactory {

    /* renamed from: k  reason: collision with root package name */
    private static final int f9199k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public static final int f9200l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public static final int f9201m;

    /* renamed from: a  reason: collision with root package name */
    private final AtomicLong f9202a;

    /* renamed from: b  reason: collision with root package name */
    private final ThreadFactory f9203b;

    /* renamed from: c  reason: collision with root package name */
    private final Thread.UncaughtExceptionHandler f9204c;

    /* renamed from: d  reason: collision with root package name */
    private final String f9205d;

    /* renamed from: e  reason: collision with root package name */
    private final Integer f9206e;

    /* renamed from: f  reason: collision with root package name */
    private final Boolean f9207f;

    /* renamed from: g  reason: collision with root package name */
    private final int f9208g;

    /* renamed from: h  reason: collision with root package name */
    private final int f9209h;

    /* renamed from: i  reason: collision with root package name */
    private final BlockingQueue<Runnable> f9210i;

    /* renamed from: j  reason: collision with root package name */
    private final int f9211j;

    public static class a {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public ThreadFactory f9212a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public Thread.UncaughtExceptionHandler f9213b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public String f9214c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public Integer f9215d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public Boolean f9216e;
        /* access modifiers changed from: private */

        /* renamed from: f  reason: collision with root package name */
        public int f9217f = ic.f9200l;

        /* renamed from: g  reason: collision with root package name */
        private int f9218g = ic.f9201m;
        /* access modifiers changed from: private */

        /* renamed from: h  reason: collision with root package name */
        public int f9219h = 30;
        /* access modifiers changed from: private */

        /* renamed from: i  reason: collision with root package name */
        public BlockingQueue<Runnable> f9220i;

        private void c() {
            this.f9212a = null;
            this.f9213b = null;
            this.f9214c = null;
            this.f9215d = null;
            this.f9216e = null;
        }

        public final a a() {
            this.f9217f = 1;
            return this;
        }

        public final a a(int i2) {
            if (this.f9217f > 0) {
                this.f9218g = i2;
                return this;
            }
            throw new NullPointerException("corePoolSize  must > 0!");
        }

        public final a a(String str) {
            Objects.requireNonNull(str, "Naming pattern must not be null!");
            this.f9214c = str;
            return this;
        }

        public final a a(BlockingQueue<Runnable> blockingQueue) {
            this.f9220i = blockingQueue;
            return this;
        }

        public final ic b() {
            ic icVar = new ic(this, (byte) 0);
            c();
            return icVar;
        }
    }

    static {
        int availableProcessors = Runtime.getRuntime().availableProcessors();
        f9199k = availableProcessors;
        f9200l = Math.max(2, Math.min(availableProcessors - 1, 4));
        f9201m = (availableProcessors * 2) + 1;
    }

    private ic(a aVar) {
        this.f9203b = aVar.f9212a == null ? Executors.defaultThreadFactory() : aVar.f9212a;
        int b2 = aVar.f9217f;
        this.f9208g = b2;
        int i2 = f9201m;
        this.f9209h = i2;
        if (i2 >= b2) {
            this.f9211j = aVar.f9219h;
            this.f9210i = aVar.f9220i == null ? new LinkedBlockingQueue<>(256) : aVar.f9220i;
            this.f9205d = TextUtils.isEmpty(aVar.f9214c) ? "amap-threadpool" : aVar.f9214c;
            this.f9206e = aVar.f9215d;
            this.f9207f = aVar.f9216e;
            this.f9204c = aVar.f9213b;
            this.f9202a = new AtomicLong();
            return;
        }
        throw new NullPointerException("maxPoolSize must > corePoolSize!");
    }

    /* synthetic */ ic(a aVar, byte b2) {
        this(aVar);
    }

    private ThreadFactory g() {
        return this.f9203b;
    }

    private String h() {
        return this.f9205d;
    }

    private Boolean i() {
        return this.f9207f;
    }

    private Integer j() {
        return this.f9206e;
    }

    private Thread.UncaughtExceptionHandler k() {
        return this.f9204c;
    }

    public final int a() {
        return this.f9208g;
    }

    public final int b() {
        return this.f9209h;
    }

    public final BlockingQueue<Runnable> c() {
        return this.f9210i;
    }

    public final int d() {
        return this.f9211j;
    }

    public final Thread newThread(Runnable runnable) {
        Thread newThread = g().newThread(runnable);
        if (h() != null) {
            Long valueOf = Long.valueOf(this.f9202a.incrementAndGet());
            newThread.setName(String.format(h() + "-%d", new Object[]{valueOf}));
        }
        if (k() != null) {
            newThread.setUncaughtExceptionHandler(k());
        }
        if (j() != null) {
            newThread.setPriority(j().intValue());
        }
        if (i() != null) {
            newThread.setDaemon(i().booleanValue());
        }
        return newThread;
    }
}
