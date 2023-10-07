package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Point;
import android.graphics.PointF;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.view.GestureDetector;
import android.view.MotionEvent;
import com.amap.api.mapcore.util.ad;
import com.amap.api.mapcore.util.ae;
import com.amap.api.mapcore.util.ag;
import com.amap.api.mapcore.util.ah;
import com.amap.api.maps.model.AMapGestureListener;
import com.amap.api.maps.utils.SpatialRelationUtil;
import com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.mapcore.message.HoverGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.MoveGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage;
import com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    IAMapDelegate f9617a;

    /* renamed from: b  reason: collision with root package name */
    Context f9618b;

    /* renamed from: c  reason: collision with root package name */
    GestureDetector f9619c;

    /* renamed from: d  reason: collision with root package name */
    public AMapGestureListener f9620d;

    /* renamed from: e  reason: collision with root package name */
    private ag f9621e;

    /* renamed from: f  reason: collision with root package name */
    private ae f9622f;

    /* renamed from: g  reason: collision with root package name */
    private ad f9623g;

    /* renamed from: h  reason: collision with root package name */
    private ah f9624h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public boolean f9625i = false;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public int f9626j = 0;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public int f9627k = 0;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f9628l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public int f9629m = 0;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public int f9630n = 0;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public boolean f9631o = false;
    /* access modifiers changed from: private */

    /* renamed from: p  reason: collision with root package name */
    public boolean f9632p = false;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public boolean f9633q = true;

    /* renamed from: r  reason: collision with root package name */
    private int f9634r;

    /* renamed from: s  reason: collision with root package name */
    private int f9635s;

    /* renamed from: t  reason: collision with root package name */
    private Handler f9636t = new Handler(Looper.getMainLooper());

    private class a implements GestureDetector.OnDoubleTapListener, GestureDetector.OnGestureListener {

        /* renamed from: a  reason: collision with root package name */
        float f9637a;

        /* renamed from: b  reason: collision with root package name */
        long f9638b;

        /* renamed from: d  reason: collision with root package name */
        private int f9640d;

        /* renamed from: e  reason: collision with root package name */
        private EAMapPlatformGestureInfo f9641e;

        private a() {
            this.f9640d = 0;
            this.f9637a = 0.0f;
            this.f9641e = new EAMapPlatformGestureInfo();
            this.f9638b = 0;
        }

        /* synthetic */ a(n nVar, byte b2) {
            this();
        }

        public final boolean onDoubleTap(MotionEvent motionEvent) {
            n.this.f9619c.setIsLongpressEnabled(false);
            this.f9640d = motionEvent.getPointerCount();
            if (n.this.f9620d != null) {
                n.this.f9620d.onDoubleTap(motionEvent.getX(), motionEvent.getY());
            }
            return false;
        }

        public final boolean onDoubleTapEvent(MotionEvent motionEvent) {
            if (this.f9640d < motionEvent.getPointerCount()) {
                this.f9640d = motionEvent.getPointerCount();
            }
            int action = motionEvent.getAction() & 255;
            if (this.f9640d != 1) {
                return false;
            }
            try {
                if (!n.this.f9617a.getUiSettings().isZoomGesturesEnabled()) {
                    return false;
                }
            } catch (Throwable th) {
                fz.c(th, "GLMapGestrureDetector", "onDoubleTapEvent");
                th.printStackTrace();
            }
            if (action == 0) {
                this.f9641e.mGestureState = 1;
                this.f9641e.mGestureType = 9;
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f9641e;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                int engineIDWithGestureInfo = n.this.f9617a.getEngineIDWithGestureInfo(this.f9641e);
                this.f9637a = motionEvent.getY();
                n.this.f9617a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, 0, 0));
                this.f9638b = SystemClock.uptimeMillis();
                return true;
            } else if (action == 2) {
                boolean unused = n.this.f9631o = true;
                float y2 = this.f9637a - motionEvent.getY();
                if (Math.abs(y2) < 20.0f) {
                    return true;
                }
                this.f9641e.mGestureState = 2;
                this.f9641e.mGestureType = 9;
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo2 = this.f9641e;
                eAMapPlatformGestureInfo2.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                n.this.f9617a.addGestureMapMessage(n.this.f9617a.getEngineIDWithGestureInfo(this.f9641e), ScaleGestureMapMessage.obtain(101, (y2 * 4.0f) / ((float) n.this.f9617a.getMapHeight()), 0, 0));
                this.f9637a = motionEvent.getY();
                return true;
            } else {
                this.f9641e.mGestureState = 3;
                this.f9641e.mGestureType = 9;
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo3 = this.f9641e;
                eAMapPlatformGestureInfo3.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                int engineIDWithGestureInfo2 = n.this.f9617a.getEngineIDWithGestureInfo(this.f9641e);
                n.this.f9619c.setIsLongpressEnabled(true);
                n.this.f9617a.addGestureMapMessage(engineIDWithGestureInfo2, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
                if (action == 1) {
                    n.this.f9617a.setGestureStatus(engineIDWithGestureInfo2, 3);
                    long uptimeMillis = SystemClock.uptimeMillis() - this.f9638b;
                    if (!n.this.f9631o || uptimeMillis < 200) {
                        return n.this.f9617a.onDoubleTap(engineIDWithGestureInfo2, motionEvent);
                    }
                }
                boolean unused2 = n.this.f9631o = false;
                return true;
            }
        }

        public final boolean onDown(MotionEvent motionEvent) {
            boolean unused = n.this.f9631o = false;
            return true;
        }

        public final boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (n.this.f9620d != null) {
                n.this.f9620d.onFling(f2, f3);
            }
            try {
                if (n.this.f9617a.getUiSettings().isScrollGesturesEnabled() && n.this.f9629m <= 0 && n.this.f9627k <= 0 && n.this.f9628l == 0 && !n.this.f9633q) {
                    this.f9641e.mGestureState = 3;
                    this.f9641e.mGestureType = 3;
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f9641e;
                    eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent2.getX(), motionEvent2.getY()};
                    int engineIDWithGestureInfo = n.this.f9617a.getEngineIDWithGestureInfo(this.f9641e);
                    n.this.f9617a.onFling();
                    n.this.f9617a.getGLMapEngine().startMapSlidAnim(engineIDWithGestureInfo, new Point((int) motionEvent2.getX(), (int) motionEvent2.getY()), f2, f3);
                }
                return true;
            } catch (Throwable th) {
                fz.c(th, "GLMapGestrureDetector", "onFling");
                th.printStackTrace();
                return true;
            }
        }

        public final void onLongPress(MotionEvent motionEvent) {
            if (n.this.f9630n == 1) {
                this.f9641e.mGestureState = 3;
                this.f9641e.mGestureType = 7;
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f9641e;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                n.this.f9617a.onLongPress(n.this.f9617a.getEngineIDWithGestureInfo(this.f9641e), motionEvent);
                if (n.this.f9620d != null) {
                    n.this.f9620d.onLongPress(motionEvent.getX(), motionEvent.getY());
                }
            }
        }

        public final boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f2, float f3) {
            if (n.this.f9620d == null) {
                return false;
            }
            n.this.f9620d.onScroll(f2, f3);
            return false;
        }

        public final void onShowPress(MotionEvent motionEvent) {
            try {
                this.f9641e.mGestureState = 3;
                this.f9641e.mGestureType = 7;
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f9641e;
                eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
                n.this.f9617a.getGLMapEngine().clearAnimations(n.this.f9617a.getEngineIDWithGestureInfo(this.f9641e), false);
            } catch (Throwable th) {
                th.printStackTrace();
            }
        }

        public final boolean onSingleTapConfirmed(MotionEvent motionEvent) {
            if (n.this.f9630n != 1) {
                return false;
            }
            this.f9641e.mGestureState = 3;
            this.f9641e.mGestureType = 8;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f9641e;
            eAMapPlatformGestureInfo.mLocation = new float[]{motionEvent.getX(), motionEvent.getY()};
            int engineIDWithGestureInfo = n.this.f9617a.getEngineIDWithGestureInfo(this.f9641e);
            if (n.this.f9620d != null) {
                try {
                    n.this.f9620d.onSingleTap(motionEvent.getX(), motionEvent.getY());
                } catch (Throwable th) {
                    th.printStackTrace();
                }
            }
            return n.this.f9617a.onSingleTapConfirmed(engineIDWithGestureInfo, motionEvent);
        }

        public final boolean onSingleTapUp(MotionEvent motionEvent) {
            return false;
        }
    }

    private class b implements ad.a {

        /* renamed from: b  reason: collision with root package name */
        private EAMapPlatformGestureInfo f9643b;

        private b() {
            this.f9643b = new EAMapPlatformGestureInfo();
        }

        /* synthetic */ b(n nVar, byte b2) {
            this();
        }

        public final boolean a(ad adVar) {
            this.f9643b.mGestureState = 2;
            this.f9643b.mGestureType = 6;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f9643b;
            boolean z2 = false;
            eAMapPlatformGestureInfo.mLocation = new float[]{adVar.c().getX(), adVar.c().getY()};
            try {
                if (!n.this.f9617a.getUiSettings().isTiltGesturesEnabled()) {
                    return true;
                }
                int engineIDWithGestureInfo = n.this.f9617a.getEngineIDWithGestureInfo(this.f9643b);
                if (n.this.f9617a.isLockMapCameraDegree(engineIDWithGestureInfo) || n.this.f9628l > 3) {
                    return false;
                }
                float f2 = adVar.d().x;
                float f3 = adVar.d().y;
                if (!n.this.f9625i) {
                    PointF a2 = adVar.a(0);
                    PointF a3 = adVar.a(1);
                    if ((a2.y > 10.0f && a3.y > 10.0f) || (a2.y < -10.0f && a3.y < -10.0f)) {
                        z2 = true;
                    }
                    if (z2 && Math.abs(f3) > 10.0f && Math.abs(f2) < 10.0f) {
                        boolean unused = n.this.f9625i = true;
                    }
                }
                if (n.this.f9625i) {
                    boolean unused2 = n.this.f9625i = true;
                    float f4 = f3 / 6.0f;
                    if (Math.abs(f4) > 1.0f) {
                        n.this.f9617a.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(101, f4));
                        n.m(n.this);
                    }
                }
                return true;
            } catch (Throwable th) {
                fz.c(th, "GLMapGestrureDetector", "onHove");
                th.printStackTrace();
                return true;
            }
        }

        public final boolean b(ad adVar) {
            this.f9643b.mGestureState = 1;
            this.f9643b.mGestureType = 6;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f9643b;
            eAMapPlatformGestureInfo.mLocation = new float[]{adVar.c().getX(), adVar.c().getY()};
            try {
                if (!n.this.f9617a.getUiSettings().isTiltGesturesEnabled()) {
                    return true;
                }
                int engineIDWithGestureInfo = n.this.f9617a.getEngineIDWithGestureInfo(this.f9643b);
                if (n.this.f9617a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                    return false;
                }
                n.this.f9617a.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(100, n.this.f9617a.getCameraDegree(engineIDWithGestureInfo)));
                return true;
            } catch (Throwable th) {
                fz.c(th, "GLMapGestrureDetector", "onHoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        public final void c(ad adVar) {
            this.f9643b.mGestureState = 3;
            this.f9643b.mGestureType = 6;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f9643b;
            eAMapPlatformGestureInfo.mLocation = new float[]{adVar.c().getX(), adVar.c().getY()};
            try {
                if (n.this.f9617a.getUiSettings().isTiltGesturesEnabled()) {
                    int engineIDWithGestureInfo = n.this.f9617a.getEngineIDWithGestureInfo(this.f9643b);
                    if (!n.this.f9617a.isLockMapCameraDegree(engineIDWithGestureInfo)) {
                        if (n.this.f9617a.getCameraDegree(engineIDWithGestureInfo) >= 0.0f && n.this.f9629m > 0) {
                            n.this.f9617a.setGestureStatus(engineIDWithGestureInfo, 7);
                        }
                        boolean unused = n.this.f9625i = false;
                        n.this.f9617a.addGestureMapMessage(engineIDWithGestureInfo, HoverGestureMapMessage.obtain(102, n.this.f9617a.getCameraDegree(engineIDWithGestureInfo)));
                    }
                }
            } catch (Throwable th) {
                fz.c(th, "GLMapGestrureDetector", "onHoveEnd");
                th.printStackTrace();
            }
        }
    }

    private class c implements ae.a {

        /* renamed from: b  reason: collision with root package name */
        private EAMapPlatformGestureInfo f9645b;

        private c() {
            this.f9645b = new EAMapPlatformGestureInfo();
        }

        /* synthetic */ c(n nVar, byte b2) {
            this();
        }

        public final boolean a(ae aeVar) {
            if (n.this.f9625i) {
                return true;
            }
            try {
                if (n.this.f9617a.getUiSettings().isScrollGesturesEnabled() && !n.this.f9632p) {
                    this.f9645b.mGestureState = 2;
                    this.f9645b.mGestureType = 3;
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f9645b;
                    eAMapPlatformGestureInfo.mLocation = new float[]{aeVar.c().getX(), aeVar.c().getY()};
                    int engineIDWithGestureInfo = n.this.f9617a.getEngineIDWithGestureInfo(this.f9645b);
                    PointF d2 = aeVar.d();
                    float f2 = 1.0f;
                    if (n.this.f9626j == 0) {
                        f2 = 4.0f;
                    }
                    if (Math.abs(d2.x) <= f2 && Math.abs(d2.y) <= f2) {
                        return false;
                    }
                    if (n.this.f9626j == 0) {
                        n.this.f9617a.getGLMapEngine().clearAnimations(engineIDWithGestureInfo, false);
                    }
                    n.this.f9617a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(101, d2.x, d2.y));
                    n.l(n.this);
                }
                return true;
            } catch (Throwable th) {
                fz.c(th, "GLMapGestrureDetector", "onMove");
                th.printStackTrace();
                return true;
            }
        }

        public final boolean b(ae aeVar) {
            try {
                if (!n.this.f9617a.getUiSettings().isScrollGesturesEnabled()) {
                    return true;
                }
                this.f9645b.mGestureState = 1;
                this.f9645b.mGestureType = 3;
                EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f9645b;
                eAMapPlatformGestureInfo.mLocation = new float[]{aeVar.c().getX(), aeVar.c().getY()};
                n.this.f9617a.addGestureMapMessage(n.this.f9617a.getEngineIDWithGestureInfo(this.f9645b), MoveGestureMapMessage.obtain(100, 0.0f, 0.0f));
                return true;
            } catch (Throwable th) {
                fz.c(th, "GLMapGestrureDetector", "onMoveBegin");
                th.printStackTrace();
                return true;
            }
        }

        public final void c(ae aeVar) {
            try {
                if (n.this.f9617a.getUiSettings().isScrollGesturesEnabled()) {
                    this.f9645b.mGestureState = 3;
                    this.f9645b.mGestureType = 3;
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f9645b;
                    eAMapPlatformGestureInfo.mLocation = new float[]{aeVar.c().getX(), aeVar.c().getY()};
                    int engineIDWithGestureInfo = n.this.f9617a.getEngineIDWithGestureInfo(this.f9645b);
                    if (n.this.f9626j > 0) {
                        n.this.f9617a.setGestureStatus(engineIDWithGestureInfo, 5);
                    }
                    n.this.f9617a.addGestureMapMessage(engineIDWithGestureInfo, MoveGestureMapMessage.obtain(102, 0.0f, 0.0f));
                }
            } catch (Throwable th) {
                fz.c(th, "GLMapGestrureDetector", "onMoveEnd");
                th.printStackTrace();
            }
        }
    }

    private class d extends ag.a {

        /* renamed from: b  reason: collision with root package name */
        private boolean f9647b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f9648c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f9649d;

        /* renamed from: e  reason: collision with root package name */
        private Point f9650e;

        /* renamed from: f  reason: collision with root package name */
        private float[] f9651f;

        /* renamed from: g  reason: collision with root package name */
        private float f9652g;

        /* renamed from: h  reason: collision with root package name */
        private float[] f9653h;

        /* renamed from: i  reason: collision with root package name */
        private float f9654i;

        /* renamed from: j  reason: collision with root package name */
        private EAMapPlatformGestureInfo f9655j;

        private d() {
            this.f9647b = false;
            this.f9648c = false;
            this.f9649d = false;
            this.f9650e = new Point();
            this.f9651f = new float[10];
            this.f9652g = 0.0f;
            this.f9653h = new float[10];
            this.f9654i = 0.0f;
            this.f9655j = new EAMapPlatformGestureInfo();
        }

        /* synthetic */ d(n nVar, byte b2) {
            this();
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x00f9 A[Catch:{ all -> 0x010c }] */
        /* JADX WARNING: Removed duplicated region for block: B:34:0x0102 A[Catch:{ all -> 0x010c }] */
        /* JADX WARNING: Removed duplicated region for block: B:65:0x016c A[Catch:{ all -> 0x01a2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:66:0x016e A[Catch:{ all -> 0x01a2 }] */
        /* JADX WARNING: Removed duplicated region for block: B:68:0x0171 A[Catch:{ all -> 0x01a2 }] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final boolean a(com.amap.api.mapcore.util.ag r18) {
            /*
                r17 = this;
                r1 = r17
                java.lang.String r2 = "onScaleRotate"
                java.lang.String r3 = "GLMapGestrureDetector"
                com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo r0 = r1.f9655j
                r4 = 2
                r0.mGestureState = r4
                com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo r0 = r1.f9655j
                r5 = 4
                r0.mGestureType = r5
                com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo r0 = r1.f9655j
                float[] r5 = new float[r4]
                android.view.MotionEvent r6 = r18.a()
                float r6 = r6.getX()
                r7 = 0
                r5[r7] = r6
                android.view.MotionEvent r6 = r18.a()
                float r6 = r6.getY()
                r8 = 1
                r5[r8] = r6
                r0.mLocation = r5
                com.amap.api.mapcore.util.n r0 = com.amap.api.mapcore.util.n.this
                com.autonavi.base.amap.api.mapcore.IAMapDelegate r0 = r0.f9617a
                com.autonavi.base.ae.gmap.gesture.EAMapPlatformGestureInfo r5 = r1.f9655j
                int r5 = r0.getEngineIDWithGestureInfo(r5)
                float r0 = r18.h()
                long r9 = r18.i()
                float r6 = (float) r9
                float r9 = r18.b()
                int r9 = (int) r9
                float r10 = r18.c()
                int r10 = (int) r10
                android.graphics.Point r11 = r1.f9650e
                int r11 = r11.x
                int r11 = r9 - r11
                int r11 = java.lang.Math.abs(r11)
                float r11 = (float) r11
                android.graphics.Point r12 = r1.f9650e
                int r12 = r12.y
                int r12 = r10 - r12
                int r12 = java.lang.Math.abs(r12)
                float r12 = (float) r12
                android.graphics.Point r13 = r1.f9650e
                r13.x = r9
                android.graphics.Point r13 = r1.f9650e
                r13.y = r10
                double r13 = (double) r0
                double r13 = java.lang.Math.log(r13)
                float r0 = (float) r13
                com.amap.api.mapcore.util.n r13 = com.amap.api.mapcore.util.n.this
                int r13 = r13.f9627k
                if (r13 > 0) goto L_0x0082
                float r13 = java.lang.Math.abs(r0)
                r14 = 1045220557(0x3e4ccccd, float:0.2)
                int r13 = (r13 > r14 ? 1 : (r13 == r14 ? 0 : -1))
                if (r13 <= 0) goto L_0x0082
                r1.f9649d = r8
            L_0x0082:
                r13 = 101(0x65, float:1.42E-43)
                r14 = 1073741824(0x40000000, float:2.0)
                com.amap.api.mapcore.util.n r15 = com.amap.api.mapcore.util.n.this     // Catch:{ all -> 0x0112 }
                com.autonavi.base.amap.api.mapcore.IAMapDelegate r15 = r15.f9617a     // Catch:{ all -> 0x0112 }
                com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate r15 = r15.getUiSettings()     // Catch:{ all -> 0x0112 }
                boolean r15 = r15.isZoomGesturesEnabled()     // Catch:{ all -> 0x0112 }
                if (r15 == 0) goto L_0x0110
                boolean r15 = r1.f9647b     // Catch:{ all -> 0x0112 }
                if (r15 != 0) goto L_0x00a5
                r15 = 1031127695(0x3d75c28f, float:0.06)
                float r16 = java.lang.Math.abs(r0)     // Catch:{ all -> 0x0112 }
                int r15 = (r15 > r16 ? 1 : (r15 == r16 ? 0 : -1))
                if (r15 >= 0) goto L_0x00a5
                r1.f9647b = r8     // Catch:{ all -> 0x0112 }
            L_0x00a5:
                boolean r15 = r1.f9647b     // Catch:{ all -> 0x0112 }
                if (r15 == 0) goto L_0x0110
                r15 = 1008981770(0x3c23d70a, float:0.01)
                float r16 = java.lang.Math.abs(r0)     // Catch:{ all -> 0x0112 }
                int r15 = (r15 > r16 ? 1 : (r15 == r16 ? 0 : -1))
                if (r15 >= 0) goto L_0x0110
                int r15 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
                if (r15 > 0) goto L_0x00bc
                int r15 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r15 <= 0) goto L_0x00c9
            L_0x00bc:
                float r15 = java.lang.Math.abs(r0)     // Catch:{ all -> 0x010c }
                r16 = 1017370378(0x3ca3d70a, float:0.02)
                int r15 = (r15 > r16 ? 1 : (r15 == r16 ? 0 : -1))
                if (r15 >= 0) goto L_0x00c9
                r15 = 1
                goto L_0x00ca
            L_0x00c9:
                r15 = 0
            L_0x00ca:
                if (r15 != 0) goto L_0x010a
                r15 = 0
                int r16 = (r6 > r15 ? 1 : (r6 == r15 ? 0 : -1))
                if (r16 <= 0) goto L_0x010a
                float r7 = r0 / r6
                r1.f9652g = r7     // Catch:{ all -> 0x010c }
                float r7 = java.lang.Math.abs(r7)     // Catch:{ all -> 0x010c }
                float[] r14 = r1.f9651f     // Catch:{ all -> 0x010c }
                com.amap.api.mapcore.util.n r4 = com.amap.api.mapcore.util.n.this     // Catch:{ all -> 0x010c }
                int r4 = r4.f9627k     // Catch:{ all -> 0x010c }
                int r4 = r4 % 10
                r14[r4] = r7     // Catch:{ all -> 0x010c }
                com.amap.api.mapcore.util.n r4 = com.amap.api.mapcore.util.n.this     // Catch:{ all -> 0x010c }
                com.amap.api.mapcore.util.n.g(r4)     // Catch:{ all -> 0x010c }
                com.amap.api.mapcore.util.n r4 = com.amap.api.mapcore.util.n.this     // Catch:{ all -> 0x010c }
                com.autonavi.base.amap.api.mapcore.IAMapDelegate r4 = r4.f9617a     // Catch:{ all -> 0x010c }
                com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage r7 = com.autonavi.base.amap.mapcore.message.ScaleGestureMapMessage.obtain(r13, r0, r9, r10)     // Catch:{ all -> 0x010c }
                r4.addGestureMapMessage(r5, r7)     // Catch:{ all -> 0x010c }
                int r0 = (r0 > r15 ? 1 : (r0 == r15 ? 0 : -1))
                if (r0 <= 0) goto L_0x0102
                com.amap.api.mapcore.util.n r0 = com.amap.api.mapcore.util.n.this     // Catch:{ all -> 0x010c }
                com.autonavi.base.amap.api.mapcore.IAMapDelegate r0 = r0.f9617a     // Catch:{ all -> 0x010c }
                r0.setGestureStatus(r5, r8)     // Catch:{ all -> 0x010c }
                r4 = 1
                goto L_0x011c
            L_0x0102:
                com.amap.api.mapcore.util.n r0 = com.amap.api.mapcore.util.n.this     // Catch:{ all -> 0x010c }
                com.autonavi.base.amap.api.mapcore.IAMapDelegate r0 = r0.f9617a     // Catch:{ all -> 0x010c }
                r4 = 2
                r0.setGestureStatus(r5, r4)     // Catch:{ all -> 0x010c }
            L_0x010a:
                r0 = 1
                goto L_0x011b
            L_0x010c:
                r0 = move-exception
                r4 = r0
                r0 = 1
                goto L_0x0115
            L_0x0110:
                r0 = 0
                goto L_0x011b
            L_0x0112:
                r0 = move-exception
                r4 = r0
                r0 = 0
            L_0x0115:
                com.amap.api.mapcore.util.fz.c(r4, r3, r2)
                r4.printStackTrace()
            L_0x011b:
                r4 = r0
            L_0x011c:
                com.amap.api.mapcore.util.n r0 = com.amap.api.mapcore.util.n.this     // Catch:{ all -> 0x01a2 }
                com.autonavi.base.amap.api.mapcore.IAMapDelegate r0 = r0.f9617a     // Catch:{ all -> 0x01a2 }
                com.autonavi.base.amap.api.mapcore.IUiSettingsDelegate r0 = r0.getUiSettings()     // Catch:{ all -> 0x01a2 }
                boolean r0 = r0.isRotateGesturesEnabled()     // Catch:{ all -> 0x01a2 }
                if (r0 == 0) goto L_0x01a0
                com.amap.api.mapcore.util.n r0 = com.amap.api.mapcore.util.n.this     // Catch:{ all -> 0x01a2 }
                com.autonavi.base.amap.api.mapcore.IAMapDelegate r0 = r0.f9617a     // Catch:{ all -> 0x01a2 }
                boolean r0 = r0.isLockMapAngle(r5)     // Catch:{ all -> 0x01a2 }
                if (r0 != 0) goto L_0x01a0
                boolean r0 = r1.f9649d     // Catch:{ all -> 0x01a2 }
                if (r0 != 0) goto L_0x01a0
                float r0 = r18.j()     // Catch:{ all -> 0x01a2 }
                boolean r7 = r1.f9648c     // Catch:{ all -> 0x01a2 }
                r14 = 1082130432(0x40800000, float:4.0)
                if (r7 != 0) goto L_0x014c
                float r7 = java.lang.Math.abs(r0)     // Catch:{ all -> 0x01a2 }
                int r7 = (r7 > r14 ? 1 : (r7 == r14 ? 0 : -1))
                if (r7 < 0) goto L_0x014c
                r1.f9648c = r8     // Catch:{ all -> 0x01a2 }
            L_0x014c:
                boolean r7 = r1.f9648c     // Catch:{ all -> 0x01a2 }
                if (r7 == 0) goto L_0x01a0
                r7 = 1065353216(0x3f800000, float:1.0)
                float r15 = java.lang.Math.abs(r0)     // Catch:{ all -> 0x01a2 }
                int r7 = (r7 > r15 ? 1 : (r7 == r15 ? 0 : -1))
                if (r7 >= 0) goto L_0x01a0
                int r7 = (r11 > r14 ? 1 : (r11 == r14 ? 0 : -1))
                if (r7 > 0) goto L_0x0162
                int r7 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
                if (r7 <= 0) goto L_0x016e
            L_0x0162:
                float r7 = java.lang.Math.abs(r0)     // Catch:{ all -> 0x01a2 }
                r11 = 1073741824(0x40000000, float:2.0)
                int r7 = (r7 > r11 ? 1 : (r7 == r11 ? 0 : -1))
                if (r7 >= 0) goto L_0x016e
                r7 = 1
                goto L_0x016f
            L_0x016e:
                r7 = 0
            L_0x016f:
                if (r7 != 0) goto L_0x01a0
                float r6 = r0 / r6
                r1.f9654i = r6     // Catch:{ all -> 0x01a2 }
                float r6 = java.lang.Math.abs(r6)     // Catch:{ all -> 0x01a2 }
                float[] r7 = r1.f9653h     // Catch:{ all -> 0x01a2 }
                com.amap.api.mapcore.util.n r11 = com.amap.api.mapcore.util.n.this     // Catch:{ all -> 0x01a2 }
                int r11 = r11.f9628l     // Catch:{ all -> 0x01a2 }
                int r11 = r11 % 10
                r7[r11] = r6     // Catch:{ all -> 0x01a2 }
                com.amap.api.mapcore.util.n r6 = com.amap.api.mapcore.util.n.this     // Catch:{ all -> 0x01a2 }
                com.amap.api.mapcore.util.n.h(r6)     // Catch:{ all -> 0x01a2 }
                com.amap.api.mapcore.util.n r6 = com.amap.api.mapcore.util.n.this     // Catch:{ all -> 0x01a2 }
                com.autonavi.base.amap.api.mapcore.IAMapDelegate r6 = r6.f9617a     // Catch:{ all -> 0x01a2 }
                com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage r0 = com.autonavi.base.amap.mapcore.message.RotateGestureMapMessage.obtain(r13, r0, r9, r10)     // Catch:{ all -> 0x01a2 }
                r6.addGestureMapMessage(r5, r0)     // Catch:{ all -> 0x01a2 }
                com.amap.api.mapcore.util.n r0 = com.amap.api.mapcore.util.n.this     // Catch:{ all -> 0x019e }
                com.autonavi.base.amap.api.mapcore.IAMapDelegate r0 = r0.f9617a     // Catch:{ all -> 0x019e }
                r4 = 6
                r0.setGestureStatus(r5, r4)     // Catch:{ all -> 0x019e }
                goto L_0x01aa
            L_0x019e:
                r0 = move-exception
                goto L_0x01a4
            L_0x01a0:
                r8 = r4
                goto L_0x01aa
            L_0x01a2:
                r0 = move-exception
                r8 = r4
            L_0x01a4:
                com.amap.api.mapcore.util.fz.c(r0, r3, r2)
                r0.printStackTrace()
            L_0x01aa:
                return r8
            */
            throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.n.d.a(com.amap.api.mapcore.util.ag):boolean");
        }

        public final boolean b(ag agVar) {
            this.f9655j.mGestureState = 1;
            this.f9655j.mGestureType = 4;
            EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f9655j;
            eAMapPlatformGestureInfo.mLocation = new float[]{agVar.a().getX(), agVar.a().getY()};
            int engineIDWithGestureInfo = n.this.f9617a.getEngineIDWithGestureInfo(this.f9655j);
            int b2 = (int) agVar.b();
            int c2 = (int) agVar.c();
            this.f9649d = false;
            this.f9650e.x = b2;
            this.f9650e.y = c2;
            this.f9647b = false;
            this.f9648c = false;
            n.this.f9617a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(100, 1.0f, b2, c2));
            try {
                if (n.this.f9617a.getUiSettings().isRotateGesturesEnabled() && !n.this.f9617a.isLockMapAngle(engineIDWithGestureInfo)) {
                    n.this.f9617a.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(100, n.this.f9617a.getMapAngle(engineIDWithGestureInfo), b2, c2));
                }
            } catch (Throwable th) {
                fz.c(th, "GLMapGestrureDetector", "onScaleRotateBegin");
                th.printStackTrace();
            }
            return true;
        }

        public final void c(ag agVar) {
            float f2;
            float f3;
            float f4;
            this.f9655j.mGestureState = 3;
            this.f9655j.mGestureType = 4;
            boolean z2 = false;
            this.f9655j.mLocation = new float[]{agVar.a().getX(), agVar.a().getY()};
            int engineIDWithGestureInfo = n.this.f9617a.getEngineIDWithGestureInfo(this.f9655j);
            this.f9649d = false;
            n.this.f9617a.addGestureMapMessage(engineIDWithGestureInfo, ScaleGestureMapMessage.obtain(102, 1.0f, 0, 0));
            if (n.this.f9627k > 0) {
                int b2 = n.this.f9627k > 10 ? 10 : n.this.f9627k;
                float f5 = 0.0f;
                for (int i2 = 0; i2 < 10; i2++) {
                    float[] fArr = this.f9651f;
                    f5 += fArr[i2];
                    fArr[i2] = 0.0f;
                }
                float f6 = f5 / ((float) b2);
                if (0.004f <= f6) {
                    float f7 = f6 * 300.0f;
                    if (f7 >= 1.5f) {
                        f7 = 1.5f;
                    }
                    if (this.f9652g < 0.0f) {
                        f7 = -f7;
                    }
                    f4 = n.this.f9617a.getPreciseLevel(engineIDWithGestureInfo) + f7;
                } else {
                    f4 = -9999.0f;
                }
                this.f9652g = 0.0f;
                f2 = f4;
            } else {
                f2 = -9999.0f;
            }
            if (!n.this.f9617a.isLockMapAngle(engineIDWithGestureInfo)) {
                try {
                    if (n.this.f9617a.getUiSettings().isRotateGesturesEnabled()) {
                        n.this.f9617a.addGestureMapMessage(engineIDWithGestureInfo, RotateGestureMapMessage.obtain(102, n.this.f9617a.getMapAngle(engineIDWithGestureInfo), 0, 0));
                    }
                } catch (Throwable th) {
                    fz.c(th, "GLMapGestrureDetector", "onScaleRotateEnd");
                    th.printStackTrace();
                }
                if (n.this.f9628l > 0) {
                    n.this.f9617a.setGestureStatus(engineIDWithGestureInfo, 6);
                    int c2 = n.this.f9628l > 10 ? 10 : n.this.f9628l;
                    float f8 = 0.0f;
                    for (int i3 = 0; i3 < 10; i3++) {
                        float[] fArr2 = this.f9653h;
                        f8 += fArr2[i3];
                        fArr2[i3] = 0.0f;
                    }
                    float f9 = f8 / ((float) c2);
                    if (0.1f <= f9) {
                        float f10 = f9 * 200.0f;
                        int mapAngle = ((int) n.this.f9617a.getMapAngle(engineIDWithGestureInfo)) % SpatialRelationUtil.A_CIRCLE_DEGREE;
                        if (f10 >= 60.0f) {
                            f10 = 60.0f;
                        }
                        if (this.f9654i < 0.0f) {
                            f10 = -f10;
                        }
                        f3 = (float) (((int) (((float) mapAngle) + f10)) % SpatialRelationUtil.A_CIRCLE_DEGREE);
                        this.f9652g = 0.0f;
                    }
                }
                f3 = -9999.0f;
                this.f9652g = 0.0f;
            } else {
                f3 = -9999.0f;
            }
            if (!(f2 == -9999.0f && f3 == -9999.0f)) {
                z2 = true;
            }
            if (z2) {
                n.this.f9617a.getGLMapEngine().startPivotZoomRotateAnim(engineIDWithGestureInfo, this.f9650e, f2, (int) f3, 500);
            }
        }
    }

    private class e extends ah.b {

        /* renamed from: a  reason: collision with root package name */
        EAMapPlatformGestureInfo f9656a;

        private e() {
            this.f9656a = new EAMapPlatformGestureInfo();
        }

        /* synthetic */ e(n nVar, byte b2) {
            this();
        }

        public final void a(ah ahVar) {
            try {
                if (n.this.f9617a.getUiSettings().isZoomGesturesEnabled() && Math.abs(ahVar.d()) <= 10.0f && Math.abs(ahVar.e()) <= 10.0f && ahVar.b() < 200) {
                    boolean unused = n.this.f9633q = true;
                    this.f9656a.mGestureState = 2;
                    this.f9656a.mGestureType = 2;
                    EAMapPlatformGestureInfo eAMapPlatformGestureInfo = this.f9656a;
                    eAMapPlatformGestureInfo.mLocation = new float[]{ahVar.c().getX(), ahVar.c().getY()};
                    int engineIDWithGestureInfo = n.this.f9617a.getEngineIDWithGestureInfo(this.f9656a);
                    n.this.f9617a.setGestureStatus(engineIDWithGestureInfo, 4);
                    n.this.f9617a.zoomOut(engineIDWithGestureInfo);
                }
            } catch (Throwable th) {
                fz.c(th, "GLMapGestrureDetector", "onZoomOut");
                th.printStackTrace();
            }
        }
    }

    public n(IAMapDelegate iAMapDelegate) {
        this.f9618b = iAMapDelegate.getContext();
        this.f9617a = iAMapDelegate;
        a aVar = new a(this, (byte) 0);
        GestureDetector gestureDetector = new GestureDetector(this.f9618b, aVar, this.f9636t);
        this.f9619c = gestureDetector;
        gestureDetector.setOnDoubleTapListener(aVar);
        this.f9621e = new ag(this.f9618b, new d(this, (byte) 0));
        this.f9622f = new ae(this.f9618b, new c(this, (byte) 0));
        this.f9623g = new ad(this.f9618b, new b(this, (byte) 0));
        this.f9624h = new ah(this.f9618b, new e(this, (byte) 0));
    }

    static /* synthetic */ int g(n nVar) {
        int i2 = nVar.f9627k;
        nVar.f9627k = i2 + 1;
        return i2;
    }

    static /* synthetic */ int h(n nVar) {
        int i2 = nVar.f9628l;
        nVar.f9628l = i2 + 1;
        return i2;
    }

    static /* synthetic */ int l(n nVar) {
        int i2 = nVar.f9626j;
        nVar.f9626j = i2 + 1;
        return i2;
    }

    static /* synthetic */ int m(n nVar) {
        int i2 = nVar.f9629m;
        nVar.f9629m = i2 + 1;
        return i2;
    }

    public final void a() {
        this.f9626j = 0;
        this.f9628l = 0;
        this.f9627k = 0;
        this.f9629m = 0;
        this.f9630n = 0;
    }

    public final void a(int i2, int i3) {
        this.f9634r = i2;
        this.f9635s = i3;
        ag agVar = this.f9621e;
        if (agVar != null) {
            agVar.a(i2, i3);
        }
        ae aeVar = this.f9622f;
        if (aeVar != null) {
            aeVar.a(i2, i3);
        }
        ad adVar = this.f9623g;
        if (adVar != null) {
            adVar.a(i2, i3);
        }
        ah ahVar = this.f9624h;
        if (ahVar != null) {
            ahVar.a(i2, i3);
        }
    }

    public final void a(AMapGestureListener aMapGestureListener) {
        this.f9620d = aMapGestureListener;
    }

    public final boolean a(MotionEvent motionEvent) {
        if (this.f9630n < motionEvent.getPointerCount()) {
            this.f9630n = motionEvent.getPointerCount();
        }
        if ((motionEvent.getAction() & 255) == 0) {
            this.f9632p = false;
            this.f9633q = false;
        }
        if (motionEvent.getAction() == 6 && motionEvent.getPointerCount() > 0) {
            this.f9632p = true;
        }
        if (this.f9631o && this.f9630n >= 2) {
            this.f9631o = false;
        }
        try {
            int[] iArr = {0, 0};
            IAMapDelegate iAMapDelegate = this.f9617a;
            if (!(iAMapDelegate == null || iAMapDelegate.getGLMapView() == null)) {
                this.f9617a.getGLMapView().getLocationOnScreen(iArr);
            }
            if (this.f9620d != null) {
                if (motionEvent.getAction() == 0) {
                    this.f9620d.onDown(motionEvent.getX(), motionEvent.getY());
                } else if (motionEvent.getAction() == 1) {
                    this.f9620d.onUp(motionEvent.getX(), motionEvent.getY());
                }
            }
            this.f9619c.onTouchEvent(motionEvent);
            this.f9623g.b(motionEvent, iArr[0], iArr[1]);
            if (!this.f9625i || this.f9629m <= 0) {
                this.f9624h.b(motionEvent, iArr[0], iArr[1]);
                if (!this.f9631o) {
                    this.f9621e.a(motionEvent);
                    this.f9622f.b(motionEvent, iArr[0], iArr[1]);
                }
            }
            return true;
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    public final int b() {
        return this.f9634r;
    }

    public final int c() {
        return this.f9635s;
    }
}
