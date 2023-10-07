package com.amap.api.mapcore.util;

import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileProvider;
import com.autonavi.base.amap.mapcore.MapConfig;
import java.io.IOException;
import java.util.Locale;
import java.util.Random;

public final class cs implements TileProvider {

    /* renamed from: a  reason: collision with root package name */
    private final int f8197a = 256;

    /* renamed from: b  reason: collision with root package name */
    private final int f8198b = 256;

    /* renamed from: c  reason: collision with root package name */
    private MapConfig f8199c;

    /* renamed from: d  reason: collision with root package name */
    private final boolean f8200d;

    private class a extends ct {

        /* renamed from: e  reason: collision with root package name */
        Random f8201e = new Random();

        /* renamed from: g  reason: collision with root package name */
        private int f8203g;

        /* renamed from: h  reason: collision with root package name */
        private int f8204h;

        /* renamed from: i  reason: collision with root package name */
        private int f8205i;

        /* renamed from: j  reason: collision with root package name */
        private String f8206j;

        /* renamed from: k  reason: collision with root package name */
        private String f8207k = "";

        public a(int i2, int i3, int i4, String str) {
            this.f8203g = i2;
            this.f8204h = i3;
            this.f8205i = i4;
            this.f8206j = str;
            this.f8207k = c();
        }

        private String c() {
            if (de.a(this.f8203g, this.f8204h, this.f8205i) || this.f8205i < 6) {
                return String.format(Locale.US, "http://wprd0%d.is.autonavi.com/appmaptile?", new Object[]{Integer.valueOf((this.f8201e.nextInt(100000) % 4) + 1)});
            } else if (MapsInitializer.isLoadWorldGridMap()) {
                return "http://restsdk.amap.com/v4/gridmap?";
            } else {
                return null;
            }
        }

        public final String getURL() {
            String str;
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("key=");
            stringBuffer.append(ev.f(p.f9676a));
            stringBuffer.append("&channel=amapapi");
            if (de.a(this.f8203g, this.f8204h, this.f8205i) || this.f8205i < 6) {
                stringBuffer.append("&z=");
                stringBuffer.append(this.f8205i);
                stringBuffer.append("&x=");
                stringBuffer.append(this.f8203g);
                stringBuffer.append("&y=");
                stringBuffer.append(this.f8204h);
                str = "&lang=en&size=1&scale=1&style=7";
            } else {
                if (MapsInitializer.isLoadWorldGridMap()) {
                    stringBuffer.append("&x=");
                    stringBuffer.append(this.f8203g);
                    stringBuffer.append("&y=");
                    stringBuffer.append(this.f8204h);
                    stringBuffer.append("&z=");
                    stringBuffer.append(this.f8205i);
                    stringBuffer.append("&ds=0");
                    stringBuffer.append("&dpitype=webrd");
                    stringBuffer.append("&lang=");
                    stringBuffer.append(this.f8206j);
                    str = "&scale=2";
                }
                return this.f8207k + a(stringBuffer.toString());
            }
            stringBuffer.append(str);
            return this.f8207k + a(stringBuffer.toString());
        }
    }

    public cs(MapConfig mapConfig) {
        this.f8199c = mapConfig;
        this.f8200d = false;
    }

    private byte[] a(int i2, int i3, int i4, String str) throws IOException {
        try {
            return new a(i2, i3, i4, str).makeHttpRequestWithInterrupted();
        } catch (Throwable unused) {
            return null;
        }
    }

    public final Tile getTile(int i2, int i3, int i4) {
        try {
            String str = "zh_cn";
            if (!this.f8200d) {
                if (this.f8199c.getMapLanguage().equals(str)) {
                    if (!MapsInitializer.isLoadWorldGridMap()) {
                        return NO_TILE;
                    }
                    if (i4 < 6 || de.a(i2, i3, i4)) {
                        return NO_TILE;
                    }
                } else if (!MapsInitializer.isLoadWorldGridMap() && i4 >= 6 && !de.a(i2, i3, i4)) {
                    return NO_TILE;
                }
            }
            MapConfig mapConfig = this.f8199c;
            if (mapConfig != null) {
                str = mapConfig.getMapLanguage();
            }
            byte[] a2 = a(i2, i3, i4, str);
            return a2 == null ? NO_TILE : Tile.obtain(this.f8197a, this.f8198b, a2);
        } catch (IOException unused) {
            return NO_TILE;
        }
    }

    public final int getTileHeight() {
        return this.f8198b;
    }

    public final int getTileWidth() {
        return this.f8197a;
    }
}
