package com.google.android.exoplayer2.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class v {

    /* renamed from: a  reason: collision with root package name */
    private static final Comparator<a> f17169a = $$Lambda$v$Avd65m_UCXOwxtu0V5beCyodFF4.INSTANCE;

    /* renamed from: b  reason: collision with root package name */
    private static final Comparator<a> f17170b = $$Lambda$v$TYG6jFaT7XyQUWBzFtnE0J7tJwc.INSTANCE;

    /* renamed from: c  reason: collision with root package name */
    private final int f17171c;

    /* renamed from: d  reason: collision with root package name */
    private final ArrayList<a> f17172d = new ArrayList<>();

    /* renamed from: e  reason: collision with root package name */
    private final a[] f17173e = new a[5];

    /* renamed from: f  reason: collision with root package name */
    private int f17174f = -1;

    /* renamed from: g  reason: collision with root package name */
    private int f17175g;

    /* renamed from: h  reason: collision with root package name */
    private int f17176h;

    /* renamed from: i  reason: collision with root package name */
    private int f17177i;

    private static class a {

        /* renamed from: a  reason: collision with root package name */
        public int f17178a;

        /* renamed from: b  reason: collision with root package name */
        public int f17179b;

        /* renamed from: c  reason: collision with root package name */
        public float f17180c;

        private a() {
        }
    }

    public v(int i2) {
        this.f17171c = i2;
    }

    /* access modifiers changed from: private */
    public static /* synthetic */ int b(a aVar, a aVar2) {
        return aVar.f17178a - aVar2.f17178a;
    }

    private void b() {
        if (this.f17174f != 1) {
            Collections.sort(this.f17172d, f17169a);
            this.f17174f = 1;
        }
    }

    private void c() {
        if (this.f17174f != 0) {
            Collections.sort(this.f17172d, f17170b);
            this.f17174f = 0;
        }
    }

    public float a(float f2) {
        c();
        float f3 = f2 * ((float) this.f17176h);
        int i2 = 0;
        for (int i3 = 0; i3 < this.f17172d.size(); i3++) {
            a aVar = this.f17172d.get(i3);
            i2 += aVar.f17179b;
            if (((float) i2) >= f3) {
                return aVar.f17180c;
            }
        }
        if (this.f17172d.isEmpty()) {
            return Float.NaN;
        }
        ArrayList<a> arrayList = this.f17172d;
        return arrayList.get(arrayList.size() - 1).f17180c;
    }

    public void a() {
        this.f17172d.clear();
        this.f17174f = -1;
        this.f17175g = 0;
        this.f17176h = 0;
    }

    public void a(int i2, float f2) {
        a aVar;
        int i3;
        a aVar2;
        b();
        int i4 = this.f17177i;
        if (i4 > 0) {
            a[] aVarArr = this.f17173e;
            int i5 = i4 - 1;
            this.f17177i = i5;
            aVar = aVarArr[i5];
        } else {
            aVar = new a();
        }
        int i6 = this.f17175g;
        this.f17175g = i6 + 1;
        aVar.f17178a = i6;
        aVar.f17179b = i2;
        aVar.f17180c = f2;
        this.f17172d.add(aVar);
        int i7 = this.f17176h + i2;
        while (true) {
            this.f17176h = i7;
            while (true) {
                int i8 = this.f17176h;
                int i9 = this.f17171c;
                if (i8 > i9) {
                    i3 = i8 - i9;
                    aVar2 = this.f17172d.get(0);
                    if (aVar2.f17179b > i3) {
                        break;
                    }
                    this.f17176h -= aVar2.f17179b;
                    this.f17172d.remove(0);
                    int i10 = this.f17177i;
                    if (i10 < 5) {
                        a[] aVarArr2 = this.f17173e;
                        this.f17177i = i10 + 1;
                        aVarArr2[i10] = aVar2;
                    }
                } else {
                    return;
                }
            }
            aVar2.f17179b -= i3;
            i7 = this.f17176h - i3;
        }
    }
}
