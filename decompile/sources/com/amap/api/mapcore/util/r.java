package com.amap.api.mapcore.util;

import android.graphics.Point;
import android.graphics.PointF;
import android.os.RemoteException;
import com.amap.api.maps.model.AMapCameraInfo;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.LatLngBounds;
import com.amap.api.maps.model.TileProjection;
import com.amap.api.maps.model.VisibleRegion;
import com.autonavi.amap.api.mapcore.IGLMapState;
import com.autonavi.amap.mapcore.DPoint;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IProjectionDelegate;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;

final class r implements IProjectionDelegate {

    /* renamed from: a  reason: collision with root package name */
    private IAMapDelegate f9684a;

    public r(IAMapDelegate iAMapDelegate) {
        this.f9684a = iAMapDelegate;
    }

    public final float calculateMapZoomer(LatLng latLng, int i2) {
        IAMapDelegate iAMapDelegate = this.f9684a;
        if (iAMapDelegate == null || latLng == null) {
            return 3.0f;
        }
        GLMapState mapProjection = iAMapDelegate.getMapProjection();
        MapConfig mapConfig = this.f9684a.getMapConfig();
        if (mapProjection == null || mapConfig == null) {
            return 3.0f;
        }
        return dl.a((IGLMapState) mapProjection, (int) mapConfig.getSX(), (int) mapConfig.getSY(), latLng.latitude, latLng.longitude, i2);
    }

    public final TileProjection fromBoundsToTile(LatLngBounds latLngBounds, int i2, int i3) throws RemoteException {
        LatLngBounds latLngBounds2 = latLngBounds;
        int i4 = i2;
        if (latLngBounds2 == null || i4 < 0 || i4 > 20 || i3 <= 0) {
            return null;
        }
        IPoint obtain = IPoint.obtain();
        IPoint obtain2 = IPoint.obtain();
        this.f9684a.latlon2Geo(latLngBounds2.southwest.latitude, latLngBounds2.southwest.longitude, obtain);
        this.f9684a.latlon2Geo(latLngBounds2.northeast.latitude, latLngBounds2.northeast.longitude, obtain2);
        int i5 = 20 - i4;
        int i6 = (obtain.x >> i5) / i3;
        int i7 = (obtain.y >> i5) / i3;
        int i8 = (obtain2.x >> i5) / i3;
        int i9 = (obtain2.y >> i5) / i3;
        int i10 = obtain.x;
        int i11 = obtain2.y;
        obtain.recycle();
        obtain2.recycle();
        return new TileProjection((i10 - ((i6 << i5) * i3)) >> i5, (i11 - ((i9 << i5) * i3)) >> i5, i6, i8, i9, i7);
    }

    public final LatLng fromScreenLocation(Point point) throws RemoteException {
        if (point == null) {
            return null;
        }
        DPoint obtain = DPoint.obtain();
        this.f9684a.getPixel2LatLng(point.x, point.y, obtain);
        LatLng latLng = new LatLng(obtain.f10010y, obtain.f10009x);
        obtain.recycle();
        return latLng;
    }

    public final AMapCameraInfo getCameraInfo() {
        return this.f9684a.getCamerInfo();
    }

    public final LatLngBounds getMapBounds(LatLng latLng, float f2) throws RemoteException {
        IAMapDelegate iAMapDelegate = this.f9684a;
        if (iAMapDelegate == null || latLng == null) {
            return null;
        }
        return iAMapDelegate.getMapBounds(latLng, f2, 0.0f, 0.0f);
    }

    public final VisibleRegion getVisibleRegion() throws RemoteException {
        int mapWidth = this.f9684a.getMapWidth();
        int mapHeight = this.f9684a.getMapHeight();
        LatLng fromScreenLocation = fromScreenLocation(new Point(0, 0));
        LatLng fromScreenLocation2 = fromScreenLocation(new Point(mapWidth, 0));
        LatLng fromScreenLocation3 = fromScreenLocation(new Point(0, mapHeight));
        LatLng fromScreenLocation4 = fromScreenLocation(new Point(mapWidth, mapHeight));
        return new VisibleRegion(fromScreenLocation3, fromScreenLocation4, fromScreenLocation, fromScreenLocation2, LatLngBounds.builder().include(fromScreenLocation3).include(fromScreenLocation4).include(fromScreenLocation).include(fromScreenLocation2).build());
    }

    public final float toMapLenWithWin(int i2) {
        if (i2 <= 0) {
            return 0.0f;
        }
        return this.f9684a.toMapLenWithWin(i2);
    }

    public final PointF toMapLocation(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        FPoint obtain = FPoint.obtain();
        this.f9684a.getLatLng2Map(latLng.latitude, latLng.longitude, obtain);
        PointF pointF = new PointF(obtain.x, obtain.y);
        obtain.recycle();
        return pointF;
    }

    public final Point toScreenLocation(LatLng latLng) throws RemoteException {
        if (latLng == null) {
            return null;
        }
        IPoint obtain = IPoint.obtain();
        this.f9684a.getLatLng2Pixel(latLng.latitude, latLng.longitude, obtain);
        Point point = new Point(obtain.x, obtain.y);
        obtain.recycle();
        return point;
    }
}
