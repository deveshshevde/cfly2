package com.amap.api.mapcore.util;

import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import java.util.Locale;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

public final class jq {

    /* renamed from: a  reason: collision with root package name */
    public int f9494a = 0;

    /* renamed from: b  reason: collision with root package name */
    public int f9495b = 0;

    /* renamed from: c  reason: collision with root package name */
    public int f9496c = 0;

    /* renamed from: d  reason: collision with root package name */
    public int f9497d = 0;

    /* renamed from: e  reason: collision with root package name */
    public long f9498e = 0;

    /* renamed from: f  reason: collision with root package name */
    public int f9499f = 0;

    /* renamed from: g  reason: collision with root package name */
    public int f9500g = 0;

    /* renamed from: h  reason: collision with root package name */
    public int f9501h = 0;

    /* renamed from: i  reason: collision with root package name */
    public int f9502i = 0;

    /* renamed from: j  reason: collision with root package name */
    public int f9503j = 0;

    /* renamed from: k  reason: collision with root package name */
    public int f9504k = -113;

    /* renamed from: l  reason: collision with root package name */
    public int f9505l = 0;

    /* renamed from: m  reason: collision with root package name */
    public short f9506m = 0;

    /* renamed from: n  reason: collision with root package name */
    public long f9507n = 0;

    /* renamed from: o  reason: collision with root package name */
    public boolean f9508o = false;

    /* renamed from: p  reason: collision with root package name */
    public int f9509p = 32767;

    /* renamed from: q  reason: collision with root package name */
    public int f9510q = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    /* renamed from: r  reason: collision with root package name */
    public int f9511r = SubsamplingScaleImageView.TILE_SIZE_AUTO;

    public jq(int i2, boolean z2) {
        this.f9505l = i2;
        this.f9508o = z2;
    }

    private long c() {
        return this.f9505l == 5 ? this.f9498e : (long) this.f9497d;
    }

    private String d() {
        int i2 = this.f9505l;
        return this.f9505l + "#" + this.f9494a + "#" + this.f9495b + "#" + 0 + "#" + c();
    }

    private String e() {
        return this.f9505l + "#" + this.f9501h + "#" + this.f9502i + "#" + this.f9503j;
    }

    public final int a() {
        return this.f9504k;
    }

    public final String b() {
        int i2 = this.f9505l;
        if (i2 != 1) {
            if (i2 == 2) {
                return e();
            }
            if (!(i2 == 3 || i2 == 4 || i2 == 5)) {
                return null;
            }
        }
        return d();
    }

    public final boolean equals(Object obj) {
        if (obj != null && (obj instanceof jq)) {
            jq jqVar = (jq) obj;
            int i2 = jqVar.f9505l;
            if (i2 != 1) {
                return i2 != 2 ? i2 != 3 ? i2 != 4 ? i2 == 5 && this.f9505l == 5 && jqVar.f9496c == this.f9496c && jqVar.f9498e == this.f9498e && jqVar.f9511r == this.f9511r : this.f9505l == 4 && jqVar.f9496c == this.f9496c && jqVar.f9497d == this.f9497d && jqVar.f9495b == this.f9495b : this.f9505l == 3 && jqVar.f9496c == this.f9496c && jqVar.f9497d == this.f9497d && jqVar.f9495b == this.f9495b : this.f9505l == 2 && jqVar.f9503j == this.f9503j && jqVar.f9502i == this.f9502i && jqVar.f9501h == this.f9501h;
            }
            if (this.f9505l == 1 && jqVar.f9496c == this.f9496c && jqVar.f9497d == this.f9497d && jqVar.f9495b == this.f9495b) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i2;
        int i3;
        int hashCode = String.valueOf(this.f9505l).hashCode();
        if (this.f9505l == 2) {
            i3 = String.valueOf(this.f9503j).hashCode() + String.valueOf(this.f9502i).hashCode();
            i2 = this.f9501h;
        } else {
            i3 = String.valueOf(this.f9496c).hashCode() + String.valueOf(this.f9497d).hashCode();
            i2 = this.f9495b;
        }
        return hashCode + i3 + String.valueOf(i2).hashCode();
    }

    public final String toString() {
        int i2 = this.f9505l;
        if (i2 == 1) {
            return String.format(Locale.CHINA, "GSM lac=%d, cid=%d, mnc=%s,  sig=%d, age=%d, reg=%b", new Object[]{Integer.valueOf(this.f9496c), Integer.valueOf(this.f9497d), Integer.valueOf(this.f9495b), Integer.valueOf(this.f9504k), Short.valueOf(this.f9506m), Boolean.valueOf(this.f9508o)});
        } else if (i2 == 2) {
            return String.format(Locale.CHINA, "CDMA bid=%d, nid=%d, sid=%d,  sig=%d, age=%d, reg=%b", new Object[]{Integer.valueOf(this.f9503j), Integer.valueOf(this.f9502i), Integer.valueOf(this.f9501h), Integer.valueOf(this.f9504k), Short.valueOf(this.f9506m), Boolean.valueOf(this.f9508o)});
        } else if (i2 == 3) {
            return String.format(Locale.CHINA, "LTE lac=%d, cid=%d, mnc=%s, sig=%d, age=%d, reg=%b, pci=%d", new Object[]{Integer.valueOf(this.f9496c), Integer.valueOf(this.f9497d), Integer.valueOf(this.f9495b), Integer.valueOf(this.f9504k), Short.valueOf(this.f9506m), Boolean.valueOf(this.f9508o), Integer.valueOf(this.f9509p)});
        } else if (i2 != 4) {
            return IjkMediaMeta.IJKM_VAL_TYPE__UNKNOWN;
        } else {
            return String.format(Locale.CHINA, "WCDMA lac=%d, cid=%d, mnc=%s,  sig=%d, age=%d, reg=%b, pci=%d", new Object[]{Integer.valueOf(this.f9496c), Integer.valueOf(this.f9497d), Integer.valueOf(this.f9495b), Integer.valueOf(this.f9504k), Short.valueOf(this.f9506m), Boolean.valueOf(this.f9508o), Integer.valueOf(this.f9509p)});
        }
    }
}
