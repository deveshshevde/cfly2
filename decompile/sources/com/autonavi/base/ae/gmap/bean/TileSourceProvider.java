package com.autonavi.base.ae.gmap.bean;

import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;

public interface TileSourceProvider extends TileProvider {
    void cancel(TileSourceReq tileSourceReq);

    Tile getTile(TileSourceReq tileSourceReq);
}
