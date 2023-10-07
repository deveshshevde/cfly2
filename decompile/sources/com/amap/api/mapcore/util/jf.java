package com.amap.api.mapcore.util;

import android.os.SystemClock;
import android.util.LongSparseArray;
import java.util.Iterator;
import java.util.List;

public final class jf {

    /* renamed from: g  reason: collision with root package name */
    private static volatile jf f9438g;

    /* renamed from: h  reason: collision with root package name */
    private static Object f9439h = new Object();

    /* renamed from: a  reason: collision with root package name */
    private LongSparseArray<a> f9440a = new LongSparseArray<>();

    /* renamed from: b  reason: collision with root package name */
    private LongSparseArray<a> f9441b = new LongSparseArray<>();

    /* renamed from: c  reason: collision with root package name */
    private LongSparseArray<a> f9442c = new LongSparseArray<>();

    /* renamed from: d  reason: collision with root package name */
    private LongSparseArray<a> f9443d = new LongSparseArray<>();

    /* renamed from: e  reason: collision with root package name */
    private Object f9444e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private Object f9445f = new Object();

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        int f9446a;

        /* renamed from: b  reason: collision with root package name */
        long f9447b;

        /* renamed from: c  reason: collision with root package name */
        boolean f9448c;

        private a() {
        }

        /* synthetic */ a(byte b2) {
            this();
        }
    }

    private jf() {
    }

    public static jf a() {
        if (f9438g == null) {
            synchronized (f9439h) {
                if (f9438g == null) {
                    f9438g = new jf();
                }
            }
        }
        return f9438g;
    }

    private static void a(List<je> list, LongSparseArray<a> longSparseArray, LongSparseArray<a> longSparseArray2) {
        long b2 = b();
        int size = longSparseArray.size();
        Iterator<je> it2 = list.iterator();
        if (size == 0) {
            while (it2.hasNext()) {
                je next = it2.next();
                a aVar = new a((byte) 0);
                aVar.f9446a = next.b();
                aVar.f9447b = b2;
                aVar.f9448c = false;
                longSparseArray2.put(next.a(), aVar);
            }
            return;
        }
        while (it2.hasNext()) {
            je next2 = it2.next();
            long a2 = next2.a();
            a aVar2 = longSparseArray.get(a2);
            if (aVar2 == null) {
                aVar2 = new a((byte) 0);
            } else if (aVar2.f9446a == next2.b()) {
                longSparseArray2.put(a2, aVar2);
            }
            aVar2.f9446a = next2.b();
            aVar2.f9447b = b2;
            aVar2.f9448c = true;
            longSparseArray2.put(a2, aVar2);
        }
    }

    private static long b() {
        return SystemClock.elapsedRealtime();
    }

    /* access modifiers changed from: package-private */
    public final void a(List<je> list) {
        if (!list.isEmpty()) {
            synchronized (this.f9444e) {
                a(list, this.f9440a, this.f9441b);
                LongSparseArray<a> longSparseArray = this.f9440a;
                this.f9440a = this.f9441b;
                this.f9441b = longSparseArray;
                longSparseArray.clear();
            }
        }
    }
}
