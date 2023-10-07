package com.google.android.exoplayer2.trackselection;

import com.google.android.exoplayer2.ab;
import com.google.android.exoplayer2.util.ad;

public final class h {

    /* renamed from: a  reason: collision with root package name */
    public final int f16749a;

    /* renamed from: b  reason: collision with root package name */
    public final ab[] f16750b;

    /* renamed from: c  reason: collision with root package name */
    public final f f16751c;

    /* renamed from: d  reason: collision with root package name */
    public final Object f16752d;

    public h(ab[] abVarArr, e[] eVarArr, Object obj) {
        this.f16750b = abVarArr;
        this.f16751c = new f(eVarArr);
        this.f16752d = obj;
        this.f16749a = abVarArr.length;
    }

    public boolean a(int i2) {
        return this.f16750b[i2] != null;
    }

    public boolean a(h hVar) {
        if (hVar == null || hVar.f16751c.f16744a != this.f16751c.f16744a) {
            return false;
        }
        for (int i2 = 0; i2 < this.f16751c.f16744a; i2++) {
            if (!a(hVar, i2)) {
                return false;
            }
        }
        return true;
    }

    public boolean a(h hVar, int i2) {
        return hVar != null && ad.a((Object) this.f16750b[i2], (Object) hVar.f16750b[i2]) && ad.a((Object) this.f16751c.a(i2), (Object) hVar.f16751c.a(i2));
    }
}
