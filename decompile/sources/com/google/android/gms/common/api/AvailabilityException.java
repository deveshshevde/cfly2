package com.google.android.gms.common.api;

import android.text.TextUtils;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.internal.b;
import com.google.android.gms.common.internal.m;
import j.a;
import java.util.ArrayList;

public class AvailabilityException extends Exception {

    /* renamed from: a  reason: collision with root package name */
    private final a<b<?>, ConnectionResult> f17370a;

    public AvailabilityException(a<b<?>, ConnectionResult> aVar) {
        this.f17370a = aVar;
    }

    public String getMessage() {
        ArrayList arrayList = new ArrayList();
        boolean z2 = true;
        for (b next : this.f17370a.keySet()) {
            ConnectionResult connectionResult = (ConnectionResult) m.a(this.f17370a.get(next));
            z2 &= !connectionResult.e();
            String a2 = next.a();
            String valueOf = String.valueOf(connectionResult);
            StringBuilder sb = new StringBuilder(String.valueOf(a2).length() + 2 + String.valueOf(valueOf).length());
            sb.append(a2);
            sb.append(": ");
            sb.append(valueOf);
            arrayList.add(sb.toString());
        }
        StringBuilder sb2 = new StringBuilder();
        sb2.append(z2 ? "None of the queried APIs are available. " : "Some of the queried APIs are unavailable. ");
        sb2.append(TextUtils.join("; ", arrayList));
        return sb2.toString();
    }
}
