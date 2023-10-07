package com.google.android.gms.common.images;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.l;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.a;
import java.util.Locale;

public final class WebImage extends AbstractSafeParcelable {
    public static final Parcelable.Creator<WebImage> CREATOR = new f();

    /* renamed from: a  reason: collision with root package name */
    final int f17719a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f17720b;

    /* renamed from: c  reason: collision with root package name */
    private final int f17721c;

    /* renamed from: d  reason: collision with root package name */
    private final int f17722d;

    WebImage(int i2, Uri uri, int i3, int i4) {
        this.f17719a = i2;
        this.f17720b = uri;
        this.f17721c = i3;
        this.f17722d = i4;
    }

    public int a() {
        return this.f17722d;
    }

    public int b() {
        return this.f17721c;
    }

    public Uri c() {
        return this.f17720b;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && (obj instanceof WebImage)) {
            WebImage webImage = (WebImage) obj;
            return l.a(this.f17720b, webImage.f17720b) && this.f17721c == webImage.f17721c && this.f17722d == webImage.f17722d;
        }
    }

    public int hashCode() {
        return l.a(this.f17720b, Integer.valueOf(this.f17721c), Integer.valueOf(this.f17722d));
    }

    public String toString() {
        return String.format(Locale.US, "Image %dx%d %s", new Object[]{Integer.valueOf(this.f17721c), Integer.valueOf(this.f17722d), this.f17720b.toString()});
    }

    public void writeToParcel(Parcel parcel, int i2) {
        int a2 = a.a(parcel);
        a.a(parcel, 1, this.f17719a);
        a.a(parcel, 2, (Parcelable) c(), i2, false);
        a.a(parcel, 3, b());
        a.a(parcel, 4, a());
        a.a(parcel, a2);
    }
}
