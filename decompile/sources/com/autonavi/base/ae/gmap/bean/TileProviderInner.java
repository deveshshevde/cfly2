package com.autonavi.base.ae.gmap.bean;

import android.text.TextUtils;
import com.amap.api.mapcore.util.ie;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.Tile;
import com.amap.api.maps.model.TileOverlaySource;
import com.amap.api.maps.model.TileProvider;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.List;

public class TileProviderInner {
    private WeakReference<IGlOverlayLayer> glOverlayLayerRef;
    private List<TileOverlaySource> mTileSource;
    private String overlayName;
    /* access modifiers changed from: private */
    public final HashMap<String, ie> reqTaskHandleHashMap = new HashMap<>();
    /* access modifiers changed from: private */
    public final TileProvider tileProvider;

    public TileProviderInner(TileProvider tileProvider2) {
        this.tileProvider = tileProvider2;
    }

    private Object callNativeFunction(String str, Object[] objArr) {
        try {
            IGlOverlayLayer iGlOverlayLayer = (IGlOverlayLayer) this.glOverlayLayerRef.get();
            if (TextUtils.isEmpty(this.overlayName) || iGlOverlayLayer == null) {
                return null;
            }
            return iGlOverlayLayer.getNativeProperties(this.overlayName, str, objArr);
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    private String createKey(int i2, int i3, int i4, long j2) {
        return i2 + " " + i3 + " " + i4 + "-" + j2;
    }

    /* access modifiers changed from: private */
    public void finishDownload(Tile tile, TileReqTaskHandle tileReqTaskHandle, String str) {
        synchronized (this.reqTaskHandleHashMap) {
            if (this.reqTaskHandleHashMap.containsKey(str)) {
                tileReqTaskHandle.finish(tile);
                callNativeFunction("finishTileReqTask", new Object[]{tileReqTaskHandle});
                this.reqTaskHandleHashMap.remove(str);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0025, code lost:
        com.amap.api.mapcore.util.dj.a();
        com.amap.api.mapcore.util.dj.b(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002b, code lost:
        if (r8 == null) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x002d, code lost:
        r8.status = 1;
        finishDownload(com.amap.api.maps.model.TileProvider.NO_TILE, r8, r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r8 = r6.tileProvider;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0039, code lost:
        if ((r8 instanceof com.autonavi.base.ae.gmap.bean.TileSourceProvider) == false) goto L_?;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x003b, code lost:
        ((com.autonavi.base.ae.gmap.bean.TileSourceProvider) r8).cancel(r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0041, code lost:
        r7 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0042, code lost:
        r7.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0045, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0023, code lost:
        if (r2 == null) goto L_0x002b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void cancelTile(com.autonavi.base.ae.gmap.bean.TileSourceReq r7, com.autonavi.base.ae.gmap.bean.TileReqTaskHandle r8) {
        /*
            r6 = this;
            int r1 = r7.f10015x
            int r2 = r7.f10016y
            int r3 = r7.zoom
            long r4 = r8.nativeObj
            r0 = r6
            java.lang.String r0 = r0.createKey(r1, r2, r3, r4)
            java.util.HashMap<java.lang.String, com.amap.api.mapcore.util.ie> r1 = r6.reqTaskHandleHashMap
            monitor-enter(r1)
            java.util.HashMap<java.lang.String, com.amap.api.mapcore.util.ie> r2 = r6.reqTaskHandleHashMap     // Catch:{ all -> 0x0046 }
            boolean r2 = r2.containsKey(r0)     // Catch:{ all -> 0x0046 }
            if (r2 != 0) goto L_0x001a
            monitor-exit(r1)     // Catch:{ all -> 0x0046 }
            return
        L_0x001a:
            java.util.HashMap<java.lang.String, com.amap.api.mapcore.util.ie> r2 = r6.reqTaskHandleHashMap     // Catch:{ all -> 0x0046 }
            java.lang.Object r2 = r2.get(r0)     // Catch:{ all -> 0x0046 }
            com.amap.api.mapcore.util.ie r2 = (com.amap.api.mapcore.util.ie) r2     // Catch:{ all -> 0x0046 }
            monitor-exit(r1)     // Catch:{ all -> 0x0046 }
            if (r2 == 0) goto L_0x002b
            com.amap.api.mapcore.util.dj.a()
            com.amap.api.mapcore.util.dj.b(r2)
        L_0x002b:
            if (r8 == 0) goto L_0x0035
            r1 = 1
            r8.status = r1
            com.amap.api.maps.model.Tile r1 = com.amap.api.maps.model.TileProvider.NO_TILE
            r6.finishDownload(r1, r8, r0)
        L_0x0035:
            com.amap.api.maps.model.TileProvider r8 = r6.tileProvider     // Catch:{ all -> 0x0041 }
            boolean r0 = r8 instanceof com.autonavi.base.ae.gmap.bean.TileSourceProvider     // Catch:{ all -> 0x0041 }
            if (r0 == 0) goto L_0x0040
            com.autonavi.base.ae.gmap.bean.TileSourceProvider r8 = (com.autonavi.base.ae.gmap.bean.TileSourceProvider) r8     // Catch:{ all -> 0x0041 }
            r8.cancel(r7)     // Catch:{ all -> 0x0041 }
        L_0x0040:
            return
        L_0x0041:
            r7 = move-exception
            r7.printStackTrace()
            return
        L_0x0046:
            r7 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0046 }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.bean.TileProviderInner.cancelTile(com.autonavi.base.ae.gmap.bean.TileSourceReq, com.autonavi.base.ae.gmap.bean.TileReqTaskHandle):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:11:0x002a, code lost:
        com.amap.api.mapcore.util.dj.a().a(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0031, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getTile(final com.autonavi.base.ae.gmap.bean.TileSourceReq r7, final com.autonavi.base.ae.gmap.bean.TileReqTaskHandle r8) {
        /*
            r6 = this;
            int r1 = r7.f10015x
            int r2 = r7.f10016y
            int r3 = r7.zoom
            long r4 = r8.nativeObj
            r0 = r6
            java.lang.String r0 = r0.createKey(r1, r2, r3, r4)
            com.autonavi.base.ae.gmap.bean.TileProviderInner$1 r1 = new com.autonavi.base.ae.gmap.bean.TileProviderInner$1
            r1.<init>(r0, r7, r8)
            java.util.HashMap<java.lang.String, com.amap.api.mapcore.util.ie> r7 = r6.reqTaskHandleHashMap
            monitor-enter(r7)
            java.util.HashMap<java.lang.String, com.amap.api.mapcore.util.ie> r8 = r6.reqTaskHandleHashMap     // Catch:{ all -> 0x0032 }
            boolean r8 = r8.containsKey(r0)     // Catch:{ all -> 0x0032 }
            if (r8 == 0) goto L_0x001f
            monitor-exit(r7)     // Catch:{ all -> 0x0032 }
            return
        L_0x001f:
            int r8 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0032 }
            r2 = 5
            if (r8 < r2) goto L_0x0029
            java.util.HashMap<java.lang.String, com.amap.api.mapcore.util.ie> r8 = r6.reqTaskHandleHashMap     // Catch:{ all -> 0x0032 }
            r8.put(r0, r1)     // Catch:{ all -> 0x0032 }
        L_0x0029:
            monitor-exit(r7)     // Catch:{ all -> 0x0032 }
            com.amap.api.mapcore.util.dj r7 = com.amap.api.mapcore.util.dj.a()
            r7.a(r1)
            return
        L_0x0032:
            r8 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0032 }
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.ae.gmap.bean.TileProviderInner.getTile(com.autonavi.base.ae.gmap.bean.TileSourceReq, com.autonavi.base.ae.gmap.bean.TileReqTaskHandle):void");
    }

    public int getTileHeight() {
        TileProvider tileProvider2 = this.tileProvider;
        if (tileProvider2 != null) {
            return tileProvider2.getTileHeight();
        }
        return 0;
    }

    public int getTileWidth() {
        TileProvider tileProvider2 = this.tileProvider;
        if (tileProvider2 != null) {
            return tileProvider2.getTileWidth();
        }
        return 0;
    }

    public void init(IGlOverlayLayer iGlOverlayLayer, String str) {
        this.glOverlayLayerRef = new WeakReference<>(iGlOverlayLayer);
        this.overlayName = str;
    }

    public void setTileSource(List<TileOverlaySource> list) {
        this.mTileSource = list;
    }
}
