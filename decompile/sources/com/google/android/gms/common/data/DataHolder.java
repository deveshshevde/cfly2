package com.google.android.gms.common.data;

import android.database.CursorWindow;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import java.io.Closeable;
import java.util.ArrayList;
import java.util.HashMap;

public final class DataHolder extends AbstractSafeParcelable implements Closeable {
    public static final Parcelable.Creator<DataHolder> CREATOR = new d();

    /* renamed from: f  reason: collision with root package name */
    private static final a f17680f = new b(new String[0], (String) null);

    /* renamed from: a  reason: collision with root package name */
    final int f17681a;

    /* renamed from: b  reason: collision with root package name */
    Bundle f17682b;

    /* renamed from: c  reason: collision with root package name */
    int[] f17683c;

    /* renamed from: d  reason: collision with root package name */
    int f17684d;

    /* renamed from: e  reason: collision with root package name */
    boolean f17685e = false;

    /* renamed from: g  reason: collision with root package name */
    private final String[] f17686g;

    /* renamed from: h  reason: collision with root package name */
    private final CursorWindow[] f17687h;

    /* renamed from: i  reason: collision with root package name */
    private final int f17688i;

    /* renamed from: j  reason: collision with root package name */
    private final Bundle f17689j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f17690k = true;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        private final String[] f17691a;

        /* renamed from: b  reason: collision with root package name */
        private final ArrayList<HashMap<String, Object>> f17692b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        private final HashMap<Object, Integer> f17693c = new HashMap<>();

        /* synthetic */ a(String[] strArr, String str, c cVar) {
            this.f17691a = (String[]) m.a(strArr);
        }
    }

    DataHolder(int i2, String[] strArr, CursorWindow[] cursorWindowArr, int i3, Bundle bundle) {
        this.f17681a = i2;
        this.f17686g = strArr;
        this.f17687h = cursorWindowArr;
        this.f17688i = i3;
        this.f17689j = bundle;
    }

    public int a() {
        return this.f17688i;
    }

    public Bundle b() {
        return this.f17689j;
    }

    public boolean c() {
        boolean z2;
        synchronized (this) {
            z2 = this.f17685e;
        }
        return z2;
    }

    public void close() {
        synchronized (this) {
            if (!this.f17685e) {
                this.f17685e = true;
                int i2 = 0;
                while (true) {
                    CursorWindow[] cursorWindowArr = this.f17687h;
                    if (i2 >= cursorWindowArr.length) {
                        break;
                    }
                    cursorWindowArr[i2].close();
                    i2++;
                }
            }
        }
    }

    public final void d() {
        this.f17682b = new Bundle();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            String[] strArr = this.f17686g;
            if (i3 >= strArr.length) {
                break;
            }
            this.f17682b.putInt(strArr[i3], i3);
            i3++;
        }
        this.f17683c = new int[this.f17687h.length];
        int i4 = 0;
        while (true) {
            CursorWindow[] cursorWindowArr = this.f17687h;
            if (i2 < cursorWindowArr.length) {
                this.f17683c[i2] = i4;
                i4 += this.f17687h[i2].getNumRows() - (i4 - cursorWindowArr[i2].getStartPosition());
                i2++;
            } else {
                this.f17684d = i4;
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public final void finalize() throws Throwable {
        try {
            if (this.f17690k && this.f17687h.length > 0 && !c()) {
                close();
                String obj = toString();
                StringBuilder sb = new StringBuilder(String.valueOf(obj).length() + 178);
                sb.append("Internal data leak within a DataBuffer object detected!  Be sure to explicitly call release() on all DataBuffer extending objects when you are done with them. (internal object: ");
                sb.append(obj);
                sb.append(")");
                Log.e("DataBuffer", sb.toString());
            }
        } finally {
            super.finalize();
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        int a2 = com.google.android.gms.common.internal.safeparcel.a.a(parcel);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 1, this.f17686g, false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 2, (T[]) this.f17687h, i2, false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 3, a());
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 4, b(), false);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, 1000, this.f17681a);
        com.google.android.gms.common.internal.safeparcel.a.a(parcel, a2);
        if ((i2 & 1) != 0) {
            close();
        }
    }
}
