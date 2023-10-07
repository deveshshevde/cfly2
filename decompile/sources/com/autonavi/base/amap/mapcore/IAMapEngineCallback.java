package com.autonavi.base.amap.mapcore;

import com.amap.api.maps.model.BitmapDescriptor;
import com.autonavi.base.ae.gmap.bean.TileProviderInner;
import java.util.List;

public interface IAMapEngineCallback {
    void OnIndoorBuildingActivity(int i2, byte[] bArr);

    void cancelRequireMapData(Object obj);

    int generateRequestId();

    List<BitmapDescriptor> getSkyBoxImages();

    TileProviderInner getTerrainTileProvider();

    void onMapRender(int i2, int i3);

    void reloadMapResource(int i2, String str, int i3);

    byte[] requireCharBitmap(int i2, int i3, int i4);

    byte[] requireCharsWidths(int i2, int[] iArr, int i3, int i4);

    @Deprecated
    void requireMapData(int i2, byte[] bArr);

    int requireMapDataAsyn(int i2, byte[] bArr);

    void requireMapRender(int i2, int i3, int i4);

    byte[] requireMapResource(int i2, String str);
}
