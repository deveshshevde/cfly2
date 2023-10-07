package com.amap.api.maps.model;

public class TileOverlaySource {
    public static int TILESOURCE_TYPE_FBO_TEXTURE = 4;
    public static int TILESOURCE_TYPE_IMAGE = 1;
    public static int TILESOURCE_TYPE_IMAGE_DEM = 3;
    public static int TILESOURCE_TYPE_VECTOR = 2;
    private static int nextId;
    private String attribute;
    private boolean cacheEnabled = true;

    /* renamed from: id  reason: collision with root package name */
    private final int f9755id;
    private int maxZoom = 20;
    private int minZoom = 3;
    private final int type;
    private final String url;

    public TileOverlaySource(int i2, String str) {
        this.url = str;
        this.type = i2;
        this.f9755id = a();
    }

    private static synchronized int a() {
        int i2;
        synchronized (TileOverlaySource.class) {
            int i3 = nextId + 1;
            nextId = i3;
            if (i3 == Integer.MAX_VALUE) {
                nextId = 1;
            }
            i2 = nextId;
        }
        return i2;
    }

    public int getId() {
        return this.f9755id;
    }

    public int getMaxZoom() {
        return this.maxZoom;
    }

    public int getMinZoom() {
        return this.minZoom;
    }

    public int getType() {
        return this.type;
    }

    public String getUrl() {
        return this.url;
    }

    public boolean isCacheEnabled() {
        return this.cacheEnabled;
    }

    public void setCacheEnabled(boolean z2) {
        this.cacheEnabled = z2;
    }

    public void setMaxZoom(int i2) {
        this.maxZoom = i2;
    }

    public void setMinZoom(int i2) {
        this.minZoom = i2;
    }
}
