package com.amap.api.mapcore.util;

import android.os.RemoteException;
import com.amap.api.maps.AMap;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.TileOverlay;
import com.amap.api.maps.model.TileOverlayOptions;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;

public final class ca {

    /* renamed from: a  reason: collision with root package name */
    private final IAMapDelegate f8115a;

    /* renamed from: b  reason: collision with root package name */
    private TileOverlay f8116b;

    /* renamed from: c  reason: collision with root package name */
    private TileOverlay f8117c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f8118d = false;

    /* renamed from: e  reason: collision with root package name */
    private boolean f8119e = false;

    public ca(IAMapDelegate iAMapDelegate) {
        this.f8115a = iAMapDelegate;
    }

    private void b() {
        if (this.f8116b == null) {
            TileOverlayOptions tileProvider = new TileOverlayOptions().tileProvider(new cs(this.f8115a.getMapConfig()));
            tileProvider.memCacheSize(10485760);
            tileProvider.diskCacheSize(20480);
            tileProvider.visible(this.f8118d);
            try {
                this.f8116b = this.f8115a.addTileOverlay(tileProvider);
                this.f8117c = this.f8115a.addTileOverlay(tileProvider);
            } catch (RemoteException e2) {
                e2.printStackTrace();
            }
        }
    }

    private void c() {
        boolean e2 = e();
        if (e2) {
            b();
        }
        if (this.f8118d != e2) {
            this.f8118d = e2;
            TileOverlay tileOverlay = this.f8116b;
            if (tileOverlay != null) {
                tileOverlay.setVisible(e2);
            }
        }
    }

    private void d() {
        boolean f2 = f();
        if (f2) {
            b();
        }
        if (this.f8119e != f2) {
            this.f8119e = f2;
            TileOverlay tileOverlay = this.f8117c;
            if (tileOverlay != null) {
                tileOverlay.setVisible(f2);
            }
        }
    }

    private boolean e() {
        IAMapDelegate iAMapDelegate = this.f8115a;
        if (iAMapDelegate == null) {
            return false;
        }
        return iAMapDelegate.getMapConfig().getMapLanguage().equals(AMap.ENGLISH);
    }

    private static boolean f() {
        return MapsInitializer.isLoadWorldGridMap();
    }

    public final void a() {
        c();
        d();
    }
}
