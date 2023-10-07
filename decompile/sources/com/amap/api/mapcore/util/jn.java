package com.amap.api.mapcore.util;

public final class jn {

    /* renamed from: a  reason: collision with root package name */
    public long f9481a;

    /* renamed from: b  reason: collision with root package name */
    public String f9482b;

    /* renamed from: c  reason: collision with root package name */
    public int f9483c = -113;

    /* renamed from: d  reason: collision with root package name */
    public int f9484d;

    /* renamed from: e  reason: collision with root package name */
    public long f9485e;

    /* renamed from: f  reason: collision with root package name */
    public long f9486f = 0;

    /* renamed from: g  reason: collision with root package name */
    public short f9487g;

    /* renamed from: h  reason: collision with root package name */
    public boolean f9488h;

    public jn(boolean z2) {
        this.f9488h = z2;
    }

    public static long a(String str) {
        long j2;
        if (str == null || str.length() == 0) {
            return 0;
        }
        int i2 = 0;
        long j3 = 0;
        for (int length = str.length() - 1; length >= 0; length--) {
            long charAt = (long) str.charAt(length);
            if (charAt < 48 || charAt > 57) {
                long j4 = 97;
                if (charAt < 97 || charAt > 102) {
                    j4 = 65;
                    if (charAt < 65 || charAt > 70) {
                        if (!(charAt == 58 || charAt == 124)) {
                            return 0;
                        }
                    }
                }
                j2 = (charAt - j4) + 10;
            } else {
                j2 = charAt - 48;
            }
            j3 += j2 << i2;
            i2 += 4;
        }
        if (i2 != 48) {
            return 0;
        }
        return j3;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public jn clone() {
        jn jnVar = new jn(this.f9488h);
        jnVar.f9481a = this.f9481a;
        jnVar.f9482b = this.f9482b;
        jnVar.f9483c = this.f9483c;
        jnVar.f9484d = this.f9484d;
        jnVar.f9485e = this.f9485e;
        jnVar.f9486f = this.f9486f;
        jnVar.f9487g = this.f9487g;
        jnVar.f9488h = this.f9488h;
        return jnVar;
    }

    public final String toString() {
        return "AmapWifi{mac=" + this.f9481a + ", ssid='" + this.f9482b + '\'' + ", rssi=" + this.f9483c + ", frequency=" + this.f9484d + ", timestamp=" + this.f9485e + ", lastUpdateUtcMills=" + this.f9486f + ", freshness=" + this.f9487g + ", connected=" + this.f9488h + '}';
    }
}
