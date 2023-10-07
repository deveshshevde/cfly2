package com.google.android.gms.common;

import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.internal.bo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.dynamic.b;
import com.google.android.gms.dynamic.d;

public final class zzs extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzs> CREATOR = new y();

    /* renamed from: a  reason: collision with root package name */
    private final String f17982a;

    /* renamed from: b  reason: collision with root package name */
    private final p f17983b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f17984c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f17985d;

    zzs(String str, IBinder iBinder, boolean z2, boolean z3) {
        this.f17982a = str;
        q qVar = null;
        if (iBinder != null) {
            try {
                b b2 = bo.a(iBinder).b();
                byte[] bArr = b2 == null ? null : (byte[]) d.a(b2);
                if (bArr != null) {
                    qVar = new q(bArr);
                } else {
                    Log.e("GoogleCertificatesQuery", "Could not unwrap certificate");
                }
            } catch (RemoteException e2) {
                Log.e("GoogleCertificatesQuery", "Could not unwrap certificate", e2);
            }
        }
        this.f17983b = qVar;
        this.f17984c = z2;
        this.f17985d = z3;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17982a, false);
        p pVar = this.f17983b;
        if (pVar == null) {
            Log.w("GoogleCertificatesQuery", "certificate binder is null");
            pVar = null;
        }
        a.a(parcel, 2, (IBinder) pVar, false);
        a.a(parcel, 3, this.f17984c);
        a.a(parcel, 4, this.f17985d);
        a.a(parcel, a2);
    }
}
