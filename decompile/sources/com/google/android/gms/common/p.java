package com.google.android.gms.common;

import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.bo;
import com.google.android.gms.common.internal.bp;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;
import java.io.UnsupportedEncodingException;
import java.util.Arrays;

abstract class p extends bo {

    /* renamed from: a  reason: collision with root package name */
    private final int f17884a;

    protected p(byte[] bArr) {
        m.a(bArr.length == 25);
        this.f17884a = Arrays.hashCode(bArr);
    }

    protected static byte[] a(String str) {
        try {
            return str.getBytes("ISO-8859-1");
        } catch (UnsupportedEncodingException e2) {
            throw new AssertionError(e2);
        }
    }

    public final int a() {
        return this.f17884a;
    }

    public final b b() {
        return d.a(d());
    }

    /* access modifiers changed from: package-private */
    public abstract byte[] d();

    public final boolean equals(Object obj) {
        b b2;
        if (obj != null && (obj instanceof bp)) {
            try {
                bp bpVar = (bp) obj;
                if (bpVar.a() != this.f17884a || (b2 = bpVar.b()) == null) {
                    return false;
                }
                return Arrays.equals(d(), (byte[]) d.a(b2));
            } catch (RemoteException e2) {
                Log.e("GoogleCertificates", "Failed to get Google certificates from remote", e2);
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.f17884a;
    }
}
