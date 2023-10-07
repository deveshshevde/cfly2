package com.google.protobuf;

import java.util.Arrays;

public final class q {

    /* renamed from: a  reason: collision with root package name */
    private static final q f20166a = new q(0, new int[0], new Object[0], false);

    /* renamed from: b  reason: collision with root package name */
    private int f20167b;

    /* renamed from: c  reason: collision with root package name */
    private int[] f20168c;

    /* renamed from: d  reason: collision with root package name */
    private Object[] f20169d;

    /* renamed from: e  reason: collision with root package name */
    private int f20170e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f20171f;

    private q() {
        this(0, new int[8], new Object[8], true);
    }

    private q(int i2, int[] iArr, Object[] objArr, boolean z2) {
        this.f20170e = -1;
        this.f20167b = i2;
        this.f20168c = iArr;
        this.f20169d = objArr;
        this.f20171f = z2;
    }

    public static q a() {
        return f20166a;
    }

    static q a(q qVar, q qVar2) {
        int i2 = qVar.f20167b + qVar2.f20167b;
        int[] copyOf = Arrays.copyOf(qVar.f20168c, i2);
        System.arraycopy(qVar2.f20168c, 0, copyOf, qVar.f20167b, qVar2.f20167b);
        Object[] copyOf2 = Arrays.copyOf(qVar.f20169d, i2);
        System.arraycopy(qVar2.f20169d, 0, copyOf2, qVar.f20167b, qVar2.f20167b);
        return new q(i2, copyOf, copyOf2, true);
    }

    /* access modifiers changed from: package-private */
    public final void a(StringBuilder sb, int i2) {
        for (int i3 = 0; i3 < this.f20167b; i3++) {
            m.a(sb, i2, String.valueOf(WireFormat.b(this.f20168c[i3])), this.f20169d[i3]);
        }
    }

    public void b() {
        this.f20171f = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof q)) {
            return false;
        }
        q qVar = (q) obj;
        return this.f20167b == qVar.f20167b && Arrays.equals(this.f20168c, qVar.f20168c) && Arrays.deepEquals(this.f20169d, qVar.f20169d);
    }

    public int hashCode() {
        return ((((527 + this.f20167b) * 31) + Arrays.hashCode(this.f20168c)) * 31) + Arrays.deepHashCode(this.f20169d);
    }
}
