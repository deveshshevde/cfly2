package com.google.android.gms.common.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;

public class ClientIdentity extends AbstractSafeParcelable {
    public static final Parcelable.Creator<ClientIdentity> CREATOR = new r();

    /* renamed from: a  reason: collision with root package name */
    public final int f17735a;

    /* renamed from: b  reason: collision with root package name */
    public final String f17736b;

    public ClientIdentity(int i2, String str) {
        this.f17735a = i2;
        this.f17736b = str;
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof ClientIdentity)) {
            return false;
        }
        ClientIdentity clientIdentity = (ClientIdentity) obj;
        return clientIdentity.f17735a == this.f17735a && l.a(clientIdentity.f17736b, this.f17736b);
    }

    public final int hashCode() {
        return this.f17735a;
    }

    public final String toString() {
        int i2 = this.f17735a;
        String str = this.f17736b;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
        sb.append(i2);
        sb.append(":");
        sb.append(str);
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17735a);
        a.a(parcel, 2, this.f17736b, false);
        a.a(parcel, a2);
    }
}
