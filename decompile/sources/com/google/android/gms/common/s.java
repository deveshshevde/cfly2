package com.google.android.gms.common;

import java.lang.ref.WeakReference;

abstract class s extends p {

    /* renamed from: a  reason: collision with root package name */
    private static final WeakReference<byte[]> f17886a = new WeakReference<>((Object) null);

    /* renamed from: b  reason: collision with root package name */
    private WeakReference<byte[]> f17887b = f17886a;

    s(byte[] bArr) {
        super(bArr);
    }

    /* access modifiers changed from: protected */
    public abstract byte[] c();

    /* access modifiers changed from: package-private */
    public final byte[] d() {
        byte[] bArr;
        synchronized (this) {
            bArr = (byte[]) this.f17887b.get();
            if (bArr == null) {
                bArr = c();
                this.f17887b = new WeakReference<>(bArr);
            }
        }
        return bArr;
    }
}
