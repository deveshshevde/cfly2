package com.google.android.gms.maps.model;

import android.os.RemoteException;
import com.google.android.gms.internal.maps.zzaf;

final class aa implements h {

    /* renamed from: b  reason: collision with root package name */
    private final zzaf f18309b;

    /* renamed from: c  reason: collision with root package name */
    private final /* synthetic */ TileOverlayOptions f18310c;

    aa(TileOverlayOptions tileOverlayOptions) {
        this.f18310c = tileOverlayOptions;
        this.f18309b = tileOverlayOptions.f18297a;
    }

    public final Tile getTile(int i2, int i3, int i4) {
        try {
            return this.f18309b.getTile(i2, i3, i4);
        } catch (RemoteException unused) {
            return null;
        }
    }
}
