package com.amap.api.maps.model;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Parcel;
import android.os.Parcelable;
import com.amap.api.mapcore.util.dl;
import com.autonavi.ae.gmap.maploader.Pools;

public final class Tile implements Parcelable {
    public static final b CREATOR = new b();
    private static final Pools.SynchronizedPool<Tile> M_POOL = new Pools.SynchronizedPool<>(18);
    private BitmapDescriptor bitmapDescriptor;
    public final byte[] data;
    public final int height;
    private final boolean isBitmap;
    private final int mVersionCode;
    public final int width;

    Tile(int i2, int i3, int i4, byte[] bArr, boolean z2) {
        this.mVersionCode = i2;
        this.width = i3;
        this.height = i4;
        this.data = bArr;
        if (bArr != null) {
            try {
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                this.bitmapDescriptor = BitmapDescriptorFactory.fromBitmap(decodeByteArray);
                dl.a(decodeByteArray);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
        this.isBitmap = z2;
    }

    public Tile(int i2, int i3, byte[] bArr) {
        this(1, i2, i3, bArr, true);
    }

    public Tile(int i2, int i3, byte[] bArr, boolean z2) {
        this(1, i2, i3, bArr, z2);
    }

    public static Tile obtain(int i2, int i3, byte[] bArr) {
        Tile acquire = M_POOL.acquire();
        return acquire != null ? acquire : new Tile(i2, i3, bArr);
    }

    public final int describeContents() {
        return 0;
    }

    public final void recycle() {
        M_POOL.release(this);
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeInt(this.width);
        parcel.writeInt(this.height);
        parcel.writeByteArray(this.data);
        parcel.writeInt(this.isBitmap ? 1 : 0);
    }
}
