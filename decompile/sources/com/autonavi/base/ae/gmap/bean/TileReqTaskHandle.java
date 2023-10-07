package com.autonavi.base.ae.gmap.bean;

import com.amap.api.maps.model.Tile;

public class TileReqTaskHandle {
    long nativeObj;
    int status;
    Tile tile;

    public void finish(Tile tile2) {
        this.tile = tile2;
    }
}
