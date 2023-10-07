package com.amap.api.maps.utils.overlay;

import com.amap.api.mapcore.util.dk;
import com.amap.api.mapcore.util.id;
import com.amap.api.mapcore.util.ie;
import com.amap.api.maps.AMap;
import com.amap.api.maps.AMapUtils;
import com.amap.api.maps.model.BitmapDescriptor;
import com.amap.api.maps.model.CameraPosition;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.animation.Animation;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.amap.mapcore.MapProjection;
import fg.i;
import java.util.LinkedList;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

public class SmoothMoveMarker {
    public static final float MIN_OFFSET_DISTANCE = 5.0f;
    private BitmapDescriptor descriptor;
    private long duration = 10000;
    private LinkedList<Double> eachDistance = new LinkedList<>();
    AtomicBoolean exitFlag = new AtomicBoolean(false);
    /* access modifiers changed from: private */
    public int index = 0;
    private AMap mAMap;
    /* access modifiers changed from: private */
    public long mAnimationBeginTime = System.currentTimeMillis();
    /* access modifiers changed from: private */
    public Object mLock = new Object();
    /* access modifiers changed from: private */
    public long mStepDuration = 20;
    private id mThreadPools;
    /* access modifiers changed from: private */
    public Marker marker = null;
    private MoveListener moveListener;
    /* access modifiers changed from: private */
    public a moveStatus = a.ACTION_UNKNOWN;
    private long pauseMillis;
    /* access modifiers changed from: private */
    public LinkedList<LatLng> points = new LinkedList<>();
    private double remainDistance = i.f27244a;
    private double totalDistance = i.f27244a;
    private boolean useDefaultDescriptor = false;

    public interface MoveListener {
        void move(double d2);
    }

    private enum a {
        ACTION_UNKNOWN,
        ACTION_START,
        ACTION_RUNNING,
        ACTION_PAUSE,
        ACTION_STOP
    }

    private class b extends ie {
        private b() {
        }

        /* synthetic */ b(SmoothMoveMarker smoothMoveMarker, byte b2) {
            this();
        }

        /* JADX WARNING: Code restructure failed: missing block: B:21:?, code lost:
            java.lang.Thread.sleep(com.amap.api.maps.utils.overlay.SmoothMoveMarker.access$800(r5.f9845a));
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void runTask() {
            /*
                r5 = this;
                com.amap.api.maps.utils.overlay.SmoothMoveMarker r0 = com.amap.api.maps.utils.overlay.SmoothMoveMarker.this     // Catch:{ all -> 0x0092 }
                long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0092 }
                long unused = r0.mAnimationBeginTime = r1     // Catch:{ all -> 0x0092 }
                com.amap.api.maps.utils.overlay.SmoothMoveMarker r0 = com.amap.api.maps.utils.overlay.SmoothMoveMarker.this     // Catch:{ all -> 0x0092 }
                com.amap.api.maps.utils.overlay.SmoothMoveMarker$a r1 = com.amap.api.maps.utils.overlay.SmoothMoveMarker.a.ACTION_START     // Catch:{ all -> 0x0092 }
                com.amap.api.maps.utils.overlay.SmoothMoveMarker.a unused = r0.moveStatus = r1     // Catch:{ all -> 0x0092 }
                com.amap.api.maps.utils.overlay.SmoothMoveMarker r0 = com.amap.api.maps.utils.overlay.SmoothMoveMarker.this     // Catch:{ all -> 0x0092 }
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.exitFlag     // Catch:{ all -> 0x0092 }
                r1 = 0
                r0.set(r1)     // Catch:{ all -> 0x0092 }
            L_0x0018:
                com.amap.api.maps.utils.overlay.SmoothMoveMarker r0 = com.amap.api.maps.utils.overlay.SmoothMoveMarker.this     // Catch:{ all -> 0x0092 }
                java.util.concurrent.atomic.AtomicBoolean r0 = r0.exitFlag     // Catch:{ all -> 0x0092 }
                boolean r0 = r0.get()     // Catch:{ all -> 0x0092 }
                if (r0 != 0) goto L_0x008a
                com.amap.api.maps.utils.overlay.SmoothMoveMarker r0 = com.amap.api.maps.utils.overlay.SmoothMoveMarker.this     // Catch:{ all -> 0x0092 }
                int r0 = r0.index     // Catch:{ all -> 0x0092 }
                com.amap.api.maps.utils.overlay.SmoothMoveMarker r1 = com.amap.api.maps.utils.overlay.SmoothMoveMarker.this     // Catch:{ all -> 0x0092 }
                java.util.LinkedList r1 = r1.points     // Catch:{ all -> 0x0092 }
                int r1 = r1.size()     // Catch:{ all -> 0x0092 }
                int r1 = r1 + -1
                if (r0 > r1) goto L_0x008a
                com.amap.api.maps.utils.overlay.SmoothMoveMarker r0 = com.amap.api.maps.utils.overlay.SmoothMoveMarker.this     // Catch:{ all -> 0x0092 }
                java.lang.Object r0 = r0.mLock     // Catch:{ all -> 0x0092 }
                monitor-enter(r0)     // Catch:{ all -> 0x0092 }
                com.amap.api.maps.utils.overlay.SmoothMoveMarker r1 = com.amap.api.maps.utils.overlay.SmoothMoveMarker.this     // Catch:{ all -> 0x0087 }
                java.util.concurrent.atomic.AtomicBoolean r1 = r1.exitFlag     // Catch:{ all -> 0x0087 }
                boolean r1 = r1.get()     // Catch:{ all -> 0x0087 }
                if (r1 == 0) goto L_0x0049
                monitor-exit(r0)     // Catch:{ all -> 0x0087 }
                return
            L_0x0049:
                com.amap.api.maps.utils.overlay.SmoothMoveMarker r1 = com.amap.api.maps.utils.overlay.SmoothMoveMarker.this     // Catch:{ all -> 0x0087 }
                com.amap.api.maps.utils.overlay.SmoothMoveMarker$a r1 = r1.moveStatus     // Catch:{ all -> 0x0087 }
                com.amap.api.maps.utils.overlay.SmoothMoveMarker$a r2 = com.amap.api.maps.utils.overlay.SmoothMoveMarker.a.ACTION_PAUSE     // Catch:{ all -> 0x0087 }
                if (r1 == r2) goto L_0x007c
                long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0087 }
                com.amap.api.maps.utils.overlay.SmoothMoveMarker r3 = com.amap.api.maps.utils.overlay.SmoothMoveMarker.this     // Catch:{ all -> 0x0087 }
                long r3 = r3.mAnimationBeginTime     // Catch:{ all -> 0x0087 }
                long r1 = r1 - r3
                com.amap.api.maps.utils.overlay.SmoothMoveMarker r3 = com.amap.api.maps.utils.overlay.SmoothMoveMarker.this     // Catch:{ all -> 0x0087 }
                com.autonavi.amap.mapcore.IPoint r1 = r3.getCurPosition(r1)     // Catch:{ all -> 0x0087 }
                com.amap.api.maps.utils.overlay.SmoothMoveMarker r2 = com.amap.api.maps.utils.overlay.SmoothMoveMarker.this     // Catch:{ all -> 0x0087 }
                com.amap.api.maps.model.Marker r2 = r2.marker     // Catch:{ all -> 0x0087 }
                if (r2 == 0) goto L_0x0075
                com.amap.api.maps.utils.overlay.SmoothMoveMarker r2 = com.amap.api.maps.utils.overlay.SmoothMoveMarker.this     // Catch:{ all -> 0x0087 }
                com.amap.api.maps.model.Marker r2 = r2.marker     // Catch:{ all -> 0x0087 }
                r2.setGeoPoint(r1)     // Catch:{ all -> 0x0087 }
            L_0x0075:
                com.amap.api.maps.utils.overlay.SmoothMoveMarker r1 = com.amap.api.maps.utils.overlay.SmoothMoveMarker.this     // Catch:{ all -> 0x0087 }
                com.amap.api.maps.utils.overlay.SmoothMoveMarker$a r2 = com.amap.api.maps.utils.overlay.SmoothMoveMarker.a.ACTION_RUNNING     // Catch:{ all -> 0x0087 }
                com.amap.api.maps.utils.overlay.SmoothMoveMarker.a unused = r1.moveStatus = r2     // Catch:{ all -> 0x0087 }
            L_0x007c:
                monitor-exit(r0)     // Catch:{ all -> 0x0087 }
                com.amap.api.maps.utils.overlay.SmoothMoveMarker r0 = com.amap.api.maps.utils.overlay.SmoothMoveMarker.this     // Catch:{ all -> 0x0092 }
                long r0 = r0.mStepDuration     // Catch:{ all -> 0x0092 }
                java.lang.Thread.sleep(r0)     // Catch:{ all -> 0x0092 }
                goto L_0x0018
            L_0x0087:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0087 }
                throw r1     // Catch:{ all -> 0x0092 }
            L_0x008a:
                com.amap.api.maps.utils.overlay.SmoothMoveMarker r0 = com.amap.api.maps.utils.overlay.SmoothMoveMarker.this     // Catch:{ all -> 0x0092 }
                com.amap.api.maps.utils.overlay.SmoothMoveMarker$a r1 = com.amap.api.maps.utils.overlay.SmoothMoveMarker.a.ACTION_STOP     // Catch:{ all -> 0x0092 }
                com.amap.api.maps.utils.overlay.SmoothMoveMarker.a unused = r0.moveStatus = r1     // Catch:{ all -> 0x0092 }
                return
            L_0x0092:
                r0 = move-exception
                r0.printStackTrace()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.utils.overlay.SmoothMoveMarker.b.runTask():void");
        }
    }

    public SmoothMoveMarker(AMap aMap) {
        this.mAMap = aMap;
        this.mThreadPools = dk.a("AMapSmoothMoveMarkerThread");
    }

    private void checkMarkerIcon() {
        if (this.useDefaultDescriptor) {
            BitmapDescriptor bitmapDescriptor = this.descriptor;
            if (bitmapDescriptor == null) {
                this.useDefaultDescriptor = true;
                return;
            }
            this.marker.setIcon(bitmapDescriptor);
            this.useDefaultDescriptor = false;
        }
    }

    /* access modifiers changed from: private */
    public IPoint getCurPosition(long j2) {
        CameraPosition cameraPosition;
        MoveListener moveListener2;
        long j3 = this.duration;
        int i2 = 0;
        if (j2 > j3) {
            this.exitFlag.set(true);
            IPoint iPoint = new IPoint();
            int size = this.points.size() - 1;
            this.index = size;
            LatLng latLng = this.points.get(size);
            int i3 = this.index - 1;
            this.index = i3;
            this.index = Math.max(i3, 0);
            this.remainDistance = i.f27244a;
            MapProjection.lonlat2Geo(latLng.longitude, latLng.latitude, iPoint);
            MoveListener moveListener3 = this.moveListener;
            if (moveListener3 != null) {
                moveListener3.move(this.remainDistance);
            }
            return iPoint;
        }
        double d2 = (double) j2;
        double d3 = this.totalDistance;
        Double.isNaN(d2);
        double d4 = (double) j3;
        Double.isNaN(d4);
        double d5 = (d2 * d3) / d4;
        this.remainDistance = d3 - d5;
        double d6 = 1.0d;
        int i4 = 0;
        while (true) {
            if (i4 >= this.eachDistance.size()) {
                break;
            }
            double doubleValue = this.eachDistance.get(i4).doubleValue();
            if (d5 > doubleValue) {
                d5 -= doubleValue;
                i4++;
            } else {
                if (doubleValue > i.f27244a) {
                    d6 = d5 / doubleValue;
                }
                i2 = i4;
            }
        }
        if (!(i2 == this.index || (moveListener2 = this.moveListener) == null)) {
            moveListener2.move(this.remainDistance);
        }
        this.index = i2;
        LatLng latLng2 = this.points.get(i2);
        LatLng latLng3 = this.points.get(i2 + 1);
        IPoint iPoint2 = new IPoint();
        MapProjection.lonlat2Geo(latLng2.longitude, latLng2.latitude, iPoint2);
        IPoint iPoint3 = new IPoint();
        MapProjection.lonlat2Geo(latLng3.longitude, latLng3.latitude, iPoint3);
        int i5 = iPoint3.x - iPoint2.x;
        int i6 = iPoint3.y - iPoint2.y;
        if (AMapUtils.calculateLineDistance(latLng2, latLng3) > 5.0f) {
            float rotate = getRotate(iPoint2, iPoint3);
            AMap aMap = this.mAMap;
            if (!(aMap == null || (cameraPosition = aMap.getCameraPosition()) == null)) {
                this.marker.setRotateAngle((360.0f - rotate) + cameraPosition.bearing);
            }
        }
        double d7 = (double) iPoint2.x;
        double d8 = (double) i5;
        Double.isNaN(d8);
        Double.isNaN(d7);
        double d9 = (double) iPoint2.y;
        double d10 = (double) i6;
        Double.isNaN(d10);
        Double.isNaN(d9);
        return new IPoint((int) (d7 + (d8 * d6)), (int) (d9 + (d10 * d6)));
    }

    private float getRotate(IPoint iPoint, IPoint iPoint2) {
        if (iPoint == null || iPoint2 == null) {
            return 0.0f;
        }
        double d2 = (double) iPoint2.y;
        double d3 = (double) iPoint.y;
        double d4 = (double) iPoint.x;
        double d5 = (double) iPoint2.x;
        Double.isNaN(d5);
        Double.isNaN(d4);
        Double.isNaN(d3);
        Double.isNaN(d2);
        return (float) ((Math.atan2(d5 - d4, d3 - d2) / 3.141592653589793d) * 180.0d);
    }

    private void reset() {
        try {
            if (this.moveStatus == a.ACTION_RUNNING || this.moveStatus == a.ACTION_PAUSE) {
                this.exitFlag.set(true);
                this.mThreadPools.a(this.mStepDuration + 20, TimeUnit.MILLISECONDS);
                Marker marker2 = this.marker;
                if (marker2 != null) {
                    marker2.setAnimation((Animation) null);
                }
                this.moveStatus = a.ACTION_UNKNOWN;
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void destroy() {
        try {
            reset();
            this.mThreadPools.c();
            BitmapDescriptor bitmapDescriptor = this.descriptor;
            if (bitmapDescriptor != null) {
                bitmapDescriptor.recycle();
            }
            Marker marker2 = this.marker;
            if (marker2 != null) {
                marker2.destroy();
                this.marker = null;
            }
            synchronized (this.mLock) {
                this.points.clear();
                this.eachDistance.clear();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public int getIndex() {
        return this.index;
    }

    public Marker getMarker() {
        return this.marker;
    }

    public LatLng getPosition() {
        Marker marker2 = this.marker;
        if (marker2 == null) {
            return null;
        }
        return marker2.getPosition();
    }

    public void removeMarker() {
        Marker marker2 = this.marker;
        if (marker2 != null) {
            marker2.remove();
            this.marker = null;
        }
        this.points.clear();
        this.eachDistance.clear();
    }

    public void resetIndex() {
        this.index = 0;
    }

    public void setDescriptor(BitmapDescriptor bitmapDescriptor) {
        BitmapDescriptor bitmapDescriptor2 = this.descriptor;
        if (bitmapDescriptor2 != null) {
            bitmapDescriptor2.recycle();
        }
        this.descriptor = bitmapDescriptor;
        Marker marker2 = this.marker;
        if (marker2 != null) {
            marker2.setIcon(bitmapDescriptor);
        }
    }

    public void setMoveListener(MoveListener moveListener2) {
        this.moveListener = moveListener2;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00bb, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void setPoints(java.util.List<com.amap.api.maps.model.LatLng> r7) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.mLock
            monitor-enter(r0)
            if (r7 == 0) goto L_0x00ba
            int r1 = r7.size()     // Catch:{ all -> 0x00b4 }
            r2 = 2
            if (r1 >= r2) goto L_0x000e
            goto L_0x00ba
        L_0x000e:
            r6.stopMove()     // Catch:{ all -> 0x00b4 }
            java.util.LinkedList<com.amap.api.maps.model.LatLng> r1 = r6.points     // Catch:{ all -> 0x00b4 }
            r1.clear()     // Catch:{ all -> 0x00b4 }
            java.util.Iterator r7 = r7.iterator()     // Catch:{ all -> 0x00b4 }
        L_0x001a:
            boolean r1 = r7.hasNext()     // Catch:{ all -> 0x00b4 }
            if (r1 == 0) goto L_0x002e
            java.lang.Object r1 = r7.next()     // Catch:{ all -> 0x00b4 }
            com.amap.api.maps.model.LatLng r1 = (com.amap.api.maps.model.LatLng) r1     // Catch:{ all -> 0x00b4 }
            if (r1 == 0) goto L_0x001a
            java.util.LinkedList<com.amap.api.maps.model.LatLng> r2 = r6.points     // Catch:{ all -> 0x00b4 }
            r2.add(r1)     // Catch:{ all -> 0x00b4 }
            goto L_0x001a
        L_0x002e:
            java.util.LinkedList<java.lang.Double> r7 = r6.eachDistance     // Catch:{ all -> 0x00b4 }
            r7.clear()     // Catch:{ all -> 0x00b4 }
            r1 = 0
            r6.totalDistance = r1     // Catch:{ all -> 0x00b4 }
            r7 = 0
            r1 = 0
        L_0x0039:
            java.util.LinkedList<com.amap.api.maps.model.LatLng> r2 = r6.points     // Catch:{ all -> 0x00b4 }
            int r2 = r2.size()     // Catch:{ all -> 0x00b4 }
            r3 = 1
            int r2 = r2 - r3
            if (r1 >= r2) goto L_0x006c
            java.util.LinkedList<com.amap.api.maps.model.LatLng> r2 = r6.points     // Catch:{ all -> 0x00b4 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x00b4 }
            com.amap.api.maps.model.LatLng r2 = (com.amap.api.maps.model.LatLng) r2     // Catch:{ all -> 0x00b4 }
            java.util.LinkedList<com.amap.api.maps.model.LatLng> r3 = r6.points     // Catch:{ all -> 0x00b4 }
            int r1 = r1 + 1
            java.lang.Object r3 = r3.get(r1)     // Catch:{ all -> 0x00b4 }
            com.amap.api.maps.model.LatLng r3 = (com.amap.api.maps.model.LatLng) r3     // Catch:{ all -> 0x00b4 }
            float r2 = com.amap.api.maps.AMapUtils.calculateLineDistance(r2, r3)     // Catch:{ all -> 0x00b4 }
            double r2 = (double) r2     // Catch:{ all -> 0x00b4 }
            java.util.LinkedList<java.lang.Double> r4 = r6.eachDistance     // Catch:{ all -> 0x00b4 }
            java.lang.Double r5 = java.lang.Double.valueOf(r2)     // Catch:{ all -> 0x00b4 }
            r4.add(r5)     // Catch:{ all -> 0x00b4 }
            double r4 = r6.totalDistance     // Catch:{ all -> 0x00b4 }
            java.lang.Double.isNaN(r2)
            double r4 = r4 + r2
            r6.totalDistance = r4     // Catch:{ all -> 0x00b4 }
            goto L_0x0039
        L_0x006c:
            double r1 = r6.totalDistance     // Catch:{ all -> 0x00b4 }
            r6.remainDistance = r1     // Catch:{ all -> 0x00b4 }
            java.util.LinkedList<com.amap.api.maps.model.LatLng> r1 = r6.points     // Catch:{ all -> 0x00b4 }
            java.lang.Object r7 = r1.get(r7)     // Catch:{ all -> 0x00b4 }
            com.amap.api.maps.model.LatLng r7 = (com.amap.api.maps.model.LatLng) r7     // Catch:{ all -> 0x00b4 }
            com.amap.api.maps.model.Marker r1 = r6.marker     // Catch:{ all -> 0x00b4 }
            if (r1 == 0) goto L_0x0083
            r1.setPosition(r7)     // Catch:{ all -> 0x00b4 }
            r6.checkMarkerIcon()     // Catch:{ all -> 0x00b4 }
            goto L_0x00b0
        L_0x0083:
            com.amap.api.maps.model.BitmapDescriptor r1 = r6.descriptor     // Catch:{ all -> 0x00b4 }
            if (r1 != 0) goto L_0x0089
            r6.useDefaultDescriptor = r3     // Catch:{ all -> 0x00b4 }
        L_0x0089:
            com.amap.api.maps.AMap r1 = r6.mAMap     // Catch:{ all -> 0x00b4 }
            com.amap.api.maps.model.MarkerOptions r2 = new com.amap.api.maps.model.MarkerOptions     // Catch:{ all -> 0x00b4 }
            r2.<init>()     // Catch:{ all -> 0x00b4 }
            com.amap.api.maps.model.MarkerOptions r2 = r2.belowMaskLayer(r3)     // Catch:{ all -> 0x00b4 }
            com.amap.api.maps.model.MarkerOptions r7 = r2.position(r7)     // Catch:{ all -> 0x00b4 }
            com.amap.api.maps.model.BitmapDescriptor r2 = r6.descriptor     // Catch:{ all -> 0x00b4 }
            com.amap.api.maps.model.MarkerOptions r7 = r7.icon(r2)     // Catch:{ all -> 0x00b4 }
            java.lang.String r2 = ""
            com.amap.api.maps.model.MarkerOptions r7 = r7.title(r2)     // Catch:{ all -> 0x00b4 }
            r2 = 1056964608(0x3f000000, float:0.5)
            com.amap.api.maps.model.MarkerOptions r7 = r7.anchor(r2, r2)     // Catch:{ all -> 0x00b4 }
            com.amap.api.maps.model.Marker r7 = r1.addMarker(r7)     // Catch:{ all -> 0x00b4 }
            r6.marker = r7     // Catch:{ all -> 0x00b4 }
        L_0x00b0:
            r6.reset()     // Catch:{ all -> 0x00b4 }
            goto L_0x00b8
        L_0x00b4:
            r7 = move-exception
            r7.printStackTrace()     // Catch:{ all -> 0x00bc }
        L_0x00b8:
            monitor-exit(r0)     // Catch:{ all -> 0x00bc }
            return
        L_0x00ba:
            monitor-exit(r0)     // Catch:{ all -> 0x00bc }
            return
        L_0x00bc:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00bc }
            goto L_0x00c0
        L_0x00bf:
            throw r7
        L_0x00c0:
            goto L_0x00bf
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.maps.utils.overlay.SmoothMoveMarker.setPoints(java.util.List):void");
    }

    public void setPosition(LatLng latLng) {
        Marker marker2 = this.marker;
        if (marker2 != null) {
            marker2.setPosition(latLng);
            checkMarkerIcon();
            return;
        }
        if (this.descriptor == null) {
            this.useDefaultDescriptor = true;
        }
        this.marker = this.mAMap.addMarker(new MarkerOptions().belowMaskLayer(true).position(latLng).icon(this.descriptor).title("").anchor(0.5f, 0.5f));
    }

    public void setRotate(float f2) {
        AMap aMap;
        CameraPosition cameraPosition;
        if (this.marker != null && (aMap = this.mAMap) != null && aMap != null && (cameraPosition = aMap.getCameraPosition()) != null) {
            this.marker.setRotateAngle((360.0f - f2) + cameraPosition.bearing);
        }
    }

    public void setTotalDuration(int i2) {
        this.duration = (long) (i2 * 1000);
    }

    public void setVisible(boolean z2) {
        Marker marker2 = this.marker;
        if (marker2 != null) {
            marker2.setVisible(z2);
        }
    }

    public void startSmoothMove() {
        if (this.moveStatus == a.ACTION_PAUSE) {
            this.moveStatus = a.ACTION_RUNNING;
            this.mAnimationBeginTime += System.currentTimeMillis() - this.pauseMillis;
        } else if ((this.moveStatus == a.ACTION_UNKNOWN || this.moveStatus == a.ACTION_STOP) && this.points.size() > 0) {
            this.index = 0;
            try {
                this.mThreadPools.a(new b(this, (byte) 0));
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }
    }

    public void stopMove() {
        if (this.moveStatus == a.ACTION_RUNNING) {
            this.moveStatus = a.ACTION_PAUSE;
            this.pauseMillis = System.currentTimeMillis();
        }
    }
}
