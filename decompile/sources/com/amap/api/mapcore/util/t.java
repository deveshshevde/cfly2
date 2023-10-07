package com.amap.api.mapcore.util;

import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileOverlaySource;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.ae.gmap.bean.TileSourceProvider;
import com.autonavi.base.ae.gmap.bean.TileSourceReq;

public final class t implements TileSourceProvider {

    /* renamed from: a  reason: collision with root package name */
    private int f9695a = 256;

    /* renamed from: b  reason: collision with root package name */
    private final TileOverlaySource f9696b;

    /* renamed from: c  reason: collision with root package name */
    private final TileOverlaySource f9697c;

    private class a extends ct {

        /* renamed from: f  reason: collision with root package name */
        private String f9699f = "";

        public a(int i2, int i3, int i4, String str) {
            this.f9699f = String.format(str, new Object[]{Integer.valueOf(i4), Integer.valueOf(i2), Integer.valueOf(i3)});
        }

        public final String getURL() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=");
            stringBuffer.append(ev.f(p.f9676a));
            stringBuffer.append("&channel=amapapi");
            return this.f9699f + a(stringBuffer.toString());
        }
    }

    public t(TileOverlaySource tileOverlaySource, TileOverlaySource tileOverlaySource2) {
        this.f9696b = tileOverlaySource;
        this.f9697c = tileOverlaySource2;
    }

    private byte[] a(int i2, int i3, int i4, String str) {
        try {
            return new a(i2, i3, i4, str).makeHttpRequestWithInterrupted();
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public final void cancel(TileSourceReq tileSourceReq) {
    }

    public final Tile getTile(int i2, int i3, int i4) {
        return null;
    }

    public final Tile getTile(TileSourceReq tileSourceReq) {
        if (tileSourceReq == null) {
            return TileProvider.NO_TILE;
        }
        try {
            String url = (tileSourceReq.sourceType == this.f9697c.getId() ? this.f9697c : this.f9696b).getUrl();
            if (url == null) {
                return TileProvider.NO_TILE;
            }
            int i2 = this.f9695a;
            return new Tile(i2, i2, a(tileSourceReq.f10015x, tileSourceReq.f10016y, tileSourceReq.zoom, url), true);
        } catch (Exception e2) {
            Tile tile = TileProvider.NO_TILE;
            e2.printStackTrace();
            return tile;
        }
    }

    public final int getTileHeight() {
        return this.f9695a;
    }

    public final int getTileWidth() {
        return this.f9695a;
    }
}
