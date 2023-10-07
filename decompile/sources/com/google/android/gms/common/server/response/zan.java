package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public final class zan extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zan> CREATOR = new c();

    /* renamed from: a  reason: collision with root package name */
    final int f17923a;

    /* renamed from: b  reason: collision with root package name */
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> f17924b;

    /* renamed from: c  reason: collision with root package name */
    private final String f17925c;

    zan(int i2, ArrayList<zal> arrayList, String str) {
        this.f17923a = i2;
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i3 = 0; i3 < size; i3++) {
            zal zal = arrayList.get(i3);
            String str2 = zal.f17918b;
            HashMap hashMap2 = new HashMap();
            int size2 = ((ArrayList) m.a(zal.f17919c)).size();
            for (int i4 = 0; i4 < size2; i4++) {
                zam zam = zal.f17919c.get(i4);
                hashMap2.put(zam.f17921b, zam.f17922c);
            }
            hashMap.put(str2, hashMap2);
        }
        this.f17924b = hashMap;
        this.f17925c = (String) m.a(str);
        b();
    }

    public final String a() {
        return this.f17925c;
    }

    public final Map<String, FastJsonResponse.Field<?, ?>> a(String str) {
        return this.f17924b.get(str);
    }

    public final void b() {
        for (String str : this.f17924b.keySet()) {
            Map map = this.f17924b.get(str);
            for (String str2 : map.keySet()) {
                ((FastJsonResponse.Field) map.get(str2)).a(this);
            }
        }
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String next : this.f17924b.keySet()) {
            sb.append(next);
            sb.append(":\n");
            Map map = this.f17924b.get(next);
            for (String str : map.keySet()) {
                sb.append("  ");
                sb.append(str);
                sb.append(": ");
                sb.append(map.get(str));
            }
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17923a);
        ArrayList arrayList = new ArrayList();
        for (String next : this.f17924b.keySet()) {
            arrayList.add(new zal(next, this.f17924b.get(next)));
        }
        a.c(parcel, 2, arrayList, false);
        a.a(parcel, 3, this.f17925c, false);
        a.a(parcel, a2);
    }
}
