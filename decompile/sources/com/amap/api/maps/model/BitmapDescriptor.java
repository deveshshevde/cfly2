package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore.util.dl;

public final class BitmapDescriptor implements Parcelable, Cloneable {
    public static final BitmapDescriptorCreator CREATOR = new BitmapDescriptorCreator();

    /* renamed from: a  reason: collision with root package name */
    int f9730a = 0;

    /* renamed from: b  reason: collision with root package name */
    int f9731b = 0;
    protected Object mBitmap;
    private String mId;

    private BitmapDescriptor(Bitmap bitmap, int i2, int i3, String str) {
        this.f9730a = i2;
        this.f9731b = i3;
        this.mBitmap = bitmap;
        this.mId = str;
    }

    BitmapDescriptor(Bitmap bitmap, String str) {
        if (bitmap != null) {
            try {
                this.f9730a = bitmap.getWidth();
                this.f9731b = bitmap.getHeight();
                this.mBitmap = bitmap.getConfig() == null ? bitmap.copy(Bitmap.Config.ARGB_8888, true) : bitmap.copy(bitmap.getConfig(), true);
            } catch (Throwable th) {
                dl.a(th);
                return;
            }
        }
        this.mId = str;
    }

    public final BitmapDescriptor clone() {
        try {
            Object obj = this.mBitmap;
            return new BitmapDescriptor(((Bitmap) obj).copy(((Bitmap) obj).getConfig(), true), this.f9730a, this.f9731b, this.mId);
        } catch (Throwable th) {
            th.printStackTrace();
            dl.a(th);
            return null;
        }
    }

    public final int describeContents() {
        return 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0020, code lost:
        r4 = (com.amap.api.maps.model.BitmapDescriptor) r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean equals(java.lang.Object r4) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.mBitmap
            r1 = 0
            if (r0 == 0) goto L_0x0051
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            boolean r0 = r0.isRecycled()
            if (r0 == 0) goto L_0x000e
            goto L_0x0051
        L_0x000e:
            if (r4 != 0) goto L_0x0011
            return r1
        L_0x0011:
            if (r3 != r4) goto L_0x0015
            r4 = 1
            return r4
        L_0x0015:
            java.lang.Class r0 = r3.getClass()
            java.lang.Class r2 = r4.getClass()
            if (r0 == r2) goto L_0x0020
            return r1
        L_0x0020:
            com.amap.api.maps.model.BitmapDescriptor r4 = (com.amap.api.maps.model.BitmapDescriptor) r4
            java.lang.Object r0 = r4.mBitmap
            if (r0 == 0) goto L_0x0051
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0
            boolean r0 = r0.isRecycled()
            if (r0 == 0) goto L_0x002f
            goto L_0x0051
        L_0x002f:
            int r0 = r3.f9730a
            int r2 = r4.getWidth()
            if (r0 != r2) goto L_0x0051
            int r0 = r3.f9731b
            int r2 = r4.getHeight()
            if (r0 == r2) goto L_0x0040
            goto L_0x0051
        L_0x0040:
            java.lang.Object r0 = r3.mBitmap     // Catch:{ all -> 0x004d }
            android.graphics.Bitmap r0 = (android.graphics.Bitmap) r0     // Catch:{ all -> 0x004d }
            java.lang.Object r4 = r4.mBitmap     // Catch:{ all -> 0x004d }
            android.graphics.Bitmap r4 = (android.graphics.Bitmap) r4     // Catch:{ all -> 0x004d }
            boolean r4 = r0.sameAs(r4)     // Catch:{ all -> 0x004d }
            return r4
        L_0x004d:
            r4 = move-exception
            com.amap.api.mapcore.util.dl.a((java.lang.Throwable) r4)
        L_0x0051:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.model.BitmapDescriptor.equals(java.lang.Object):boolean");
    }

    public final Bitmap getBitmap() {
        return (Bitmap) this.mBitmap;
    }

    public final int getHeight() {
        return this.f9731b;
    }

    public final String getId() {
        return this.mId;
    }

    public final int getWidth() {
        return this.f9730a;
    }

    public final int hashCode() {
        return super.hashCode();
    }

    public final void recycle() {
        try {
            dl.a((Bitmap) this.mBitmap);
        } catch (Throwable th) {
            dl.a(th);
        }
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeString(this.mId);
        parcel.writeParcelable((Bitmap) this.mBitmap, i2);
        parcel.writeInt(this.f9730a);
        parcel.writeInt(this.f9731b);
    }
}
