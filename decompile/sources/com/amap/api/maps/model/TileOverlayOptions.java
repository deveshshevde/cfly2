package com.amap.api.maps.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;

public final class TileOverlayOptions extends BaseOptions implements Parcelable {
    public static final TileOverlayOptionsCreator CREATOR = new TileOverlayOptionsCreator();
    private TileProvider _tileProvider;
    private String diskCacheDir;
    private boolean diskCacheEnabled;
    private long diskCacheSize;
    private TileProviderInner mTileProvider;
    private final int mVersionCode;
    private boolean mVisible;
    private float mZIndex;
    private int memCacheSize;
    private boolean memoryCacheEnabled;

    public TileOverlayOptions() {
        this.mVisible = true;
        this.memCacheSize = 5242880;
        this.diskCacheSize = 20971520;
        this.diskCacheDir = null;
        this.memoryCacheEnabled = true;
        this.diskCacheEnabled = true;
        this.mVersionCode = 1;
        this.type = "TileOverlayOptions";
    }

    TileOverlayOptions(int i2, boolean z2, float f2) {
        this.mVisible = true;
        this.memCacheSize = 5242880;
        this.diskCacheSize = 20971520;
        this.diskCacheDir = null;
        this.memoryCacheEnabled = true;
        this.diskCacheEnabled = true;
        this.mVersionCode = i2;
        this.mVisible = z2;
        this.mZIndex = f2;
        this.type = "TileOverlayOptions";
    }

    public final int describeContents() {
        return 0;
    }

    public final TileOverlayOptions diskCacheDir(String str) {
        this.diskCacheDir = str;
        return this;
    }

    public final TileOverlayOptions diskCacheEnabled(boolean z2) {
        this.diskCacheEnabled = z2;
        return this;
    }

    public final TileOverlayOptions diskCacheSize(int i2) {
        this.diskCacheSize = (long) (i2 * 1024);
        return this;
    }

    public final String getDiskCacheDir() {
        return this.diskCacheDir;
    }

    public final boolean getDiskCacheEnabled() {
        return this.diskCacheEnabled;
    }

    public final long getDiskCacheSize() {
        return this.diskCacheSize;
    }

    public final int getMemCacheSize() {
        return this.memCacheSize;
    }

    public final boolean getMemoryCacheEnabled() {
        return this.memoryCacheEnabled;
    }

    public final TileProvider getTileProvider() {
        return this._tileProvider;
    }

    /* access modifiers changed from: protected */
    public final TileProviderInner getTileProviderInner() {
        return this.mTileProvider;
    }

    public final float getZIndex() {
        return this.mZIndex;
    }

    public final boolean isVisible() {
        return this.mVisible;
    }

    public final TileOverlayOptions memCacheSize(int i2) {
        this.memCacheSize = i2;
        return this;
    }

    public final TileOverlayOptions memoryCacheEnabled(boolean z2) {
        this.memoryCacheEnabled = z2;
        return this;
    }

    public final TileOverlayOptions tileProvider(TileProvider tileProvider) {
        this._tileProvider = tileProvider;
        this.mTileProvider = new TileProviderInner(tileProvider);
        return this;
    }

    public final TileOverlayOptions visible(boolean z2) {
        this.mVisible = z2;
        return this;
    }

    public final void writeToParcel(Parcel parcel, int i2) {
        parcel.writeInt(this.mVersionCode);
        parcel.writeValue(this.mTileProvider);
        parcel.writeByte(this.mVisible ? (byte) 1 : 0);
        parcel.writeFloat(this.mZIndex);
        parcel.writeInt(this.memCacheSize);
        parcel.writeLong(this.diskCacheSize);
        parcel.writeString(this.diskCacheDir);
        parcel.writeByte(this.memoryCacheEnabled ? (byte) 1 : 0);
        parcel.writeByte(this.diskCacheEnabled ? (byte) 1 : 0);
    }

    public final TileOverlayOptions zIndex(float f2) {
        this.mZIndex = f2;
        return this;
    }
}
