package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Point;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.amap.api.mapcore.util.dt;
import com.amap.api.maps.MapsInitializer;
import com.amap.api.maps.interfaces.IGlOverlayLayer;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.CameraPosition;
import com.autonavi.amap.mapcore.IPoint;
import com.autonavi.base.ae.gmap.GLMapState;
import com.autonavi.base.ae.gmap.listener.AMapWidgetListener;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;
import com.autonavi.base.amap.mapcore.FPoint;
import com.autonavi.base.amap.mapcore.MapConfig;

public final class dv extends ViewGroup implements dw {

    /* renamed from: a  reason: collision with root package name */
    dx f8330a;

    /* renamed from: b  reason: collision with root package name */
    aj f8331b;

    /* renamed from: c  reason: collision with root package name */
    private IAMapDelegate f8332c;

    /* renamed from: d  reason: collision with root package name */
    private IGlOverlayLayer f8333d;

    /* renamed from: e  reason: collision with root package name */
    private Context f8334e;

    /* renamed from: f  reason: collision with root package name */
    private dz f8335f;

    /* renamed from: g  reason: collision with root package name */
    private du f8336g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ds f8337h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public dy f8338i;

    /* renamed from: j  reason: collision with root package name */
    private dr f8339j;

    /* renamed from: k  reason: collision with root package name */
    private dt f8340k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public ea f8341l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public View f8342m;

    /* renamed from: n  reason: collision with root package name */
    private BasePointOverlay f8343n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public Drawable f8344o = null;

    /* renamed from: p  reason: collision with root package name */
    private boolean f8345p;

    /* renamed from: q  reason: collision with root package name */
    private View f8346q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f8347r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f8348s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f8349t;

    public static class a extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public FPoint f8356a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f8357b;

        /* renamed from: c  reason: collision with root package name */
        public int f8358c;

        /* renamed from: d  reason: collision with root package name */
        public int f8359d;

        /* renamed from: e  reason: collision with root package name */
        public int f8360e;

        public a(int i2, int i3, float f2, float f3, int i4, int i5, int i6) {
            super(i2, i3);
            FPoint fPoint = new FPoint();
            this.f8356a = fPoint;
            this.f8357b = false;
            this.f8358c = 0;
            this.f8359d = 0;
            this.f8360e = 51;
            fPoint.x = f2;
            this.f8356a.y = f3;
            this.f8358c = i4;
            this.f8359d = i5;
            this.f8360e = i6;
        }

        public a(FPoint fPoint, int i2) {
            this(-2, -2, fPoint.x, fPoint.y, 0, 0, i2);
        }
    }

    public dv(Context context, IAMapDelegate iAMapDelegate, IGlOverlayLayer iGlOverlayLayer) {
        super(context);
        int i2 = 1;
        this.f8345p = true;
        this.f8348s = true;
        this.f8349t = true;
        try {
            this.f8333d = iGlOverlayLayer;
            this.f8332c = iAMapDelegate;
            this.f8334e = context;
            this.f8330a = new dx();
            this.f8339j = new dr(context);
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
            if (this.f8332c.getGLMapView() != null) {
                addView(this.f8332c.getGLMapView(), 0, layoutParams);
            } else {
                i2 = 0;
            }
            addView(this.f8339j, i2, layoutParams);
            if (!this.f8348s) {
                a(context);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            dl.a(th);
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:37:0x0071=Splitter:B:37:0x0071, B:57:0x00a1=Splitter:B:57:0x00a1, B:8:0x0022=Splitter:B:8:0x0022} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.view.View a(com.amap.api.maps.model.BasePointOverlay r8) throws android.os.RemoteException {
        /*
            r7 = this;
            boolean r0 = r8 instanceof com.amap.api.maps.model.Marker
            r1 = 0
            java.lang.String r2 = "getInfoWindow or getInfoContents"
            java.lang.String r3 = "infowindow_bg.9.png"
            java.lang.String r4 = "showInfoWindow decodeDrawableFromAsset"
            r5 = 0
            java.lang.String r6 = "MapOverlayViewGroup"
            if (r0 == 0) goto L_0x005d
            android.graphics.drawable.Drawable r0 = r7.f8344o     // Catch:{ all -> 0x001b }
            if (r0 != 0) goto L_0x0022
            android.content.Context r0 = r7.f8334e     // Catch:{ all -> 0x001b }
            android.graphics.drawable.Drawable r0 = com.amap.api.mapcore.util.da.a((android.content.Context) r0, (java.lang.String) r3)     // Catch:{ all -> 0x001b }
            r7.f8344o = r0     // Catch:{ all -> 0x001b }
            goto L_0x0022
        L_0x001b:
            r0 = move-exception
            com.amap.api.mapcore.util.fz.c(r0, r6, r4)
            r0.printStackTrace()
        L_0x0022:
            boolean r0 = r7.f8347r     // Catch:{ all -> 0x00ad }
            if (r0 == 0) goto L_0x0039
            com.amap.api.mapcore.util.aj r0 = r7.f8331b     // Catch:{ all -> 0x00ad }
            android.view.View r0 = r0.a((com.amap.api.maps.model.BasePointOverlay) r8)     // Catch:{ all -> 0x00ad }
            if (r0 != 0) goto L_0x0034
            com.amap.api.mapcore.util.aj r3 = r7.f8331b     // Catch:{ all -> 0x009d }
            android.view.View r0 = r3.b((com.amap.api.maps.model.BasePointOverlay) r8)     // Catch:{ all -> 0x009d }
        L_0x0034:
            r7.f8346q = r0     // Catch:{ all -> 0x009d }
            r7.f8347r = r1     // Catch:{ all -> 0x009d }
            goto L_0x003b
        L_0x0039:
            android.view.View r0 = r7.f8346q     // Catch:{ all -> 0x00ad }
        L_0x003b:
            if (r0 != 0) goto L_0x004e
            com.amap.api.mapcore.util.aj r1 = r7.f8331b     // Catch:{ all -> 0x009d }
            boolean r1 = r1.a()     // Catch:{ all -> 0x009d }
            if (r1 != 0) goto L_0x0046
            return r5
        L_0x0046:
            com.amap.api.mapcore.util.aj r1 = r7.f8331b     // Catch:{ all -> 0x009d }
            android.view.View r8 = r1.a((com.amap.api.maps.model.BasePointOverlay) r8)     // Catch:{ all -> 0x009d }
            r5 = r8
            goto L_0x004f
        L_0x004e:
            r5 = r0
        L_0x004f:
            if (r5 == 0) goto L_0x00b4
            android.graphics.drawable.Drawable r8 = r5.getBackground()     // Catch:{ all -> 0x00ad }
            if (r8 != 0) goto L_0x00b4
            android.graphics.drawable.Drawable r8 = r7.f8344o     // Catch:{ all -> 0x00ad }
            r5.setBackground(r8)     // Catch:{ all -> 0x00ad }
            goto L_0x00b4
        L_0x005d:
            android.graphics.drawable.Drawable r0 = r7.f8344o     // Catch:{ all -> 0x006a }
            if (r0 != 0) goto L_0x0071
            android.content.Context r0 = r7.f8334e     // Catch:{ all -> 0x006a }
            android.graphics.drawable.Drawable r0 = com.amap.api.mapcore.util.da.a((android.content.Context) r0, (java.lang.String) r3)     // Catch:{ all -> 0x006a }
            r7.f8344o = r0     // Catch:{ all -> 0x006a }
            goto L_0x0071
        L_0x006a:
            r0 = move-exception
            com.amap.api.mapcore.util.fz.c(r0, r6, r4)
            r0.printStackTrace()
        L_0x0071:
            boolean r0 = r7.f8347r     // Catch:{ all -> 0x00ad }
            if (r0 == 0) goto L_0x0088
            com.amap.api.mapcore.util.aj r0 = r7.f8331b     // Catch:{ all -> 0x00ad }
            android.view.View r0 = r0.a((com.amap.api.maps.model.BasePointOverlay) r8)     // Catch:{ all -> 0x00ad }
            if (r0 != 0) goto L_0x0083
            com.amap.api.mapcore.util.aj r3 = r7.f8331b     // Catch:{ all -> 0x009d }
            android.view.View r0 = r3.b((com.amap.api.maps.model.BasePointOverlay) r8)     // Catch:{ all -> 0x009d }
        L_0x0083:
            r7.f8346q = r0     // Catch:{ all -> 0x009d }
            r7.f8347r = r1     // Catch:{ all -> 0x009d }
            goto L_0x008a
        L_0x0088:
            android.view.View r0 = r7.f8346q     // Catch:{ all -> 0x00ad }
        L_0x008a:
            if (r0 != 0) goto L_0x00a0
            com.amap.api.mapcore.util.aj r1 = r7.f8331b     // Catch:{ all -> 0x009d }
            boolean r1 = r1.a()     // Catch:{ all -> 0x009d }
            if (r1 != 0) goto L_0x0095
            return r5
        L_0x0095:
            com.amap.api.mapcore.util.aj r1 = r7.f8331b     // Catch:{ all -> 0x009d }
            android.view.View r8 = r1.a((com.amap.api.maps.model.BasePointOverlay) r8)     // Catch:{ all -> 0x009d }
            r5 = r8
            goto L_0x00a1
        L_0x009d:
            r8 = move-exception
            r5 = r0
            goto L_0x00ae
        L_0x00a0:
            r5 = r0
        L_0x00a1:
            android.graphics.drawable.Drawable r8 = r5.getBackground()     // Catch:{ all -> 0x00ad }
            if (r8 != 0) goto L_0x00ac
            android.graphics.drawable.Drawable r8 = r7.f8344o     // Catch:{ all -> 0x00ad }
            r5.setBackground(r8)     // Catch:{ all -> 0x00ad }
        L_0x00ac:
            return r5
        L_0x00ad:
            r8 = move-exception
        L_0x00ae:
            com.amap.api.mapcore.util.fz.c(r8, r6, r2)
            r8.printStackTrace()
        L_0x00b4:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.dv.a(com.amap.api.maps.model.BasePointOverlay):android.view.View");
    }

    private void a(Context context) {
        dz dzVar = new dz(context);
        this.f8335f = dzVar;
        dzVar.c(this.f8349t);
        this.f8338i = new dy(context, this.f8332c);
        this.f8340k = new dt(context);
        this.f8341l = new ea(context, this.f8332c);
        this.f8336g = new du(context, this.f8332c);
        this.f8337h = new ds(context, this.f8332c);
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        addView(this.f8335f, layoutParams);
        addView(this.f8338i, layoutParams);
        addView(this.f8340k, new ViewGroup.LayoutParams(-2, -2));
        addView(this.f8341l, new a(new FPoint(0.0f, 0.0f), 83));
        addView(this.f8336g, new a(FPoint.obtain(0.0f, 0.0f), 83));
        addView(this.f8337h, new a(FPoint.obtain(0.0f, 0.0f), 51));
        this.f8337h.setVisibility(8);
        this.f8332c.setMapWidgetListener(new AMapWidgetListener() {
            public final void invalidateCompassView() {
                if (dv.this.f8337h != null) {
                    dv.this.f8337h.post(new Runnable() {
                        public final void run() {
                            dv.this.f8337h.b();
                        }
                    });
                }
            }

            public final void invalidateScaleView() {
                if (dv.this.f8338i != null) {
                    dv.this.f8338i.post(new Runnable() {
                        public final void run() {
                            dv.this.f8338i.b();
                        }
                    });
                }
            }

            public final void invalidateZoomController(final float f2) {
                if (dv.this.f8341l != null) {
                    dv.this.f8341l.post(new Runnable() {
                        public final void run() {
                            dv.this.f8341l.a(f2);
                        }
                    });
                }
            }

            public final void setFrontViewVisibility(boolean z2) {
            }
        });
        try {
            if (!this.f8332c.getUiSettings().isMyLocationButtonEnabled()) {
                this.f8336g.setVisibility(8);
            }
        } catch (Throwable th) {
            fz.c(th, "AMapDelegateImpGLSurfaceView", "locationView gone");
            th.printStackTrace();
        }
    }

    private void a(View view, int i2, int i3, int i4, int i5) throws RemoteException {
        int i6;
        int i7;
        if (view != null) {
            View view2 = this.f8342m;
            if (view2 != null) {
                if (view != view2) {
                    view2.clearFocus();
                    removeView(this.f8342m);
                } else {
                    return;
                }
            }
            this.f8342m = view;
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            this.f8342m.setDrawingCacheEnabled(true);
            this.f8342m.setDrawingCacheQuality(0);
            if (layoutParams != null) {
                int i8 = layoutParams.width;
                i6 = layoutParams.height;
                i7 = i8;
            } else {
                i7 = -2;
                i6 = -2;
            }
            addView(this.f8342m, new a(i7, i6, (float) i2, (float) i3, i4, i5, 81));
        }
    }

    private void a(View view, int i2, int i3, int i4, int i5, int i6) {
        int i7 = i6 & 7;
        int i8 = i6 & 112;
        if (i7 == 5) {
            i4 -= i2;
        } else if (i7 == 1) {
            i4 -= i2 / 2;
        }
        if (i8 == 80) {
            i5 -= i3;
        } else {
            if (i8 != 17) {
                if (i8 == 16) {
                    i5 /= 2;
                }
            }
            i5 -= i3 / 2;
        }
        view.layout(i4, i5, i4 + i2, i5 + i3);
        if (view instanceof IGLSurfaceView) {
            this.f8332c.changeSize(i2, i3);
        }
    }

    private void a(View view, int i2, int i3, int[] iArr) {
        View view2;
        if ((view instanceof ListView) && (view2 = (View) view.getParent()) != null) {
            iArr[0] = view2.getWidth();
            iArr[1] = view2.getHeight();
        }
        if (i2 <= 0 || i3 <= 0) {
            view.measure(0, 0);
        }
        if (i2 == -2) {
            iArr[0] = view.getMeasuredWidth();
        } else if (i2 == -1) {
            iArr[0] = getMeasuredWidth();
        } else {
            iArr[0] = i2;
        }
        if (i3 == -2) {
            iArr[1] = view.getMeasuredHeight();
        } else if (i3 == -1) {
            iArr[1] = getMeasuredHeight();
        } else {
            iArr[1] = i3;
        }
    }

    private void a(View view, ViewGroup.LayoutParams layoutParams) {
        dv dvVar;
        View view2;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int[] iArr = new int[2];
        a(view, layoutParams.width, layoutParams.height, iArr);
        if (view instanceof dt) {
            int i7 = iArr[0];
            int i8 = iArr[1];
            int i9 = (this.f8332c.getWaterMarkerPositon().y - 80) - iArr[1];
            dvVar = this;
            view2 = view;
            i2 = i7;
            i3 = i8;
            i4 = 20;
            i5 = i9;
            i6 = 51;
        } else {
            int i10 = iArr[0];
            int i11 = iArr[1];
            dvVar = this;
            view2 = view;
            i2 = i10;
            i3 = i11;
            i4 = 0;
            i5 = 0;
            i6 = 51;
        }
        dvVar.a(view2, i2, i3, i4, i5, i6);
    }

    private void a(View view, a aVar) {
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = new int[2];
        a(view, aVar.width, aVar.height, iArr);
        if (view instanceof ea) {
            i2 = iArr[0];
            i3 = iArr[1];
            i4 = getWidth() - iArr[0];
            i5 = getHeight();
        } else if (view instanceof du) {
            i2 = iArr[0];
            i3 = iArr[1];
            i4 = getWidth() - iArr[0];
            i5 = iArr[1];
        } else if (view instanceof ds) {
            i2 = iArr[0];
            i3 = iArr[1];
            i4 = 0;
            i5 = 0;
        } else if (aVar.f8356a != null) {
            IPoint obtain = IPoint.obtain();
            MapConfig mapConfig = this.f8332c.getMapConfig();
            GLMapState mapProjection = this.f8332c.getMapProjection();
            if (!(mapConfig == null || mapProjection == null)) {
                obtain.x = (int) aVar.f8356a.x;
                obtain.y = (int) aVar.f8356a.y;
            }
            obtain.x += aVar.f8358c;
            obtain.y += aVar.f8359d;
            a(view, iArr[0], iArr[1], obtain.x, obtain.y, aVar.f8360e);
            obtain.recycle();
            return;
        } else {
            return;
        }
        a(view, i2, i3, i4, i5, aVar.f8360e);
    }

    private void k() {
        dy dyVar = this.f8338i;
        if (dyVar == null) {
            this.f8330a.a(this, new Object[0]);
        } else if (dyVar != null && dyVar.getVisibility() == 0) {
            this.f8338i.postInvalidate();
        }
    }

    private void l() {
        ea eaVar = this.f8341l;
        if (eaVar != null) {
            eaVar.a();
        }
        dy dyVar = this.f8338i;
        if (dyVar != null) {
            dyVar.a();
        }
        dz dzVar = this.f8335f;
        if (dzVar != null) {
            dzVar.a();
        }
        du duVar = this.f8336g;
        if (duVar != null) {
            duVar.a();
        }
        ds dsVar = this.f8337h;
        if (dsVar != null) {
            dsVar.a();
        }
        dt dtVar = this.f8340k;
        if (dtVar != null) {
            dtVar.a();
        }
    }

    public final float a(int i2) {
        if (this.f8335f == null) {
            return 0.0f;
        }
        k();
        return this.f8335f.d(i2);
    }

    public final Point a() {
        dz dzVar = this.f8335f;
        if (dzVar == null) {
            return null;
        }
        return dzVar.b();
    }

    public final void a(Canvas canvas) {
        Bitmap drawingCache;
        View view = this.f8342m;
        if (view != null && this.f8343n != null && (drawingCache = view.getDrawingCache(true)) != null) {
            canvas.drawBitmap(drawingCache, (float) this.f8342m.getLeft(), (float) this.f8342m.getTop(), new Paint());
        }
    }

    public final void a(dt.a aVar) {
        dt dtVar = this.f8340k;
        if (dtVar == null) {
            this.f8330a.a(this, aVar);
            return;
        }
        dtVar.a(aVar);
    }

    public final void a(CameraPosition cameraPosition) {
        if (this.f8335f == null) {
            this.f8330a.a(this, cameraPosition);
        } else if (this.f8332c.getUiSettings().isLogoEnable()) {
            if (MapsInitializer.isLoadWorldGridMap() && cameraPosition.zoom >= 6.0f && !de.a(cameraPosition.target.latitude, cameraPosition.target.longitude)) {
                this.f8335f.setVisibility(8);
            } else if (this.f8332c.getMaskLayerType() == -1) {
                this.f8335f.setVisibility(0);
            }
        }
    }

    public final void a(Boolean bool) {
        dt dtVar = this.f8340k;
        if (dtVar == null) {
            this.f8330a.a(this, bool);
        } else if (dtVar != null && bool.booleanValue() && this.f8332c.canShowIndoorSwitch()) {
            this.f8340k.a(true);
        }
    }

    public final void a(Float f2) {
        ea eaVar = this.f8341l;
        if (eaVar == null) {
            this.f8330a.a(this, f2);
        } else if (eaVar != null) {
            eaVar.a(f2.floatValue());
        }
    }

    public final void a(Integer num) {
        ea eaVar = this.f8341l;
        if (eaVar == null) {
            this.f8330a.a(this, num);
        } else if (eaVar != null) {
            eaVar.a(num.intValue());
        }
    }

    public final void a(Integer num, Float f2) {
        dz dzVar = this.f8335f;
        if (dzVar != null) {
            this.f8330a.a(this, num, f2);
        } else if (dzVar != null) {
            dzVar.a(num.intValue(), f2.floatValue());
            k();
        }
    }

    public final void a(String str, Boolean bool, Integer num) {
        if (this.f8335f == null) {
            this.f8330a.a(this, str, bool, num);
        } else if (num.intValue() == 2) {
            this.f8335f.b(bool.booleanValue());
        } else if (!TextUtils.isEmpty(str)) {
            this.f8335f.a(str, num.intValue());
            this.f8335f.d(bool.booleanValue());
        }
    }

    public final void a(boolean z2) {
        dz dzVar = this.f8335f;
        if (dzVar != null) {
            dzVar.c(z2);
        }
        this.f8349t = z2;
    }

    public final void b(Boolean bool) {
        ea eaVar = this.f8341l;
        if (eaVar == null) {
            this.f8330a.a(this, bool);
            return;
        }
        eaVar.a(bool.booleanValue());
    }

    public final void b(Integer num) {
        dz dzVar = this.f8335f;
        if (dzVar == null) {
            this.f8330a.a(this, num);
        } else if (dzVar != null) {
            dzVar.a(num.intValue());
            this.f8335f.postInvalidate();
            k();
        }
    }

    public final boolean b() {
        dz dzVar = this.f8335f;
        if (dzVar != null) {
            return dzVar.d();
        }
        return false;
    }

    public final void c() {
        dz dzVar = this.f8335f;
        if (dzVar == null) {
            this.f8330a.a(this, new Object[0]);
        } else if (dzVar != null) {
            dzVar.c();
        }
    }

    public final void c(Boolean bool) {
        if (this.f8336g == null) {
            this.f8330a.a(this, bool);
        } else if (bool.booleanValue()) {
            this.f8336g.setVisibility(0);
        } else {
            this.f8336g.setVisibility(8);
        }
    }

    public final void c(Integer num) {
        dz dzVar = this.f8335f;
        if (dzVar == null) {
            this.f8330a.a(this, num);
        } else if (dzVar != null) {
            dzVar.b(num.intValue());
            k();
        }
    }

    public final dr d() {
        return this.f8339j;
    }

    public final void d(Boolean bool) {
        ds dsVar = this.f8337h;
        if (dsVar == null) {
            this.f8330a.a(this, bool);
            return;
        }
        dsVar.a(bool.booleanValue());
    }

    public final void d(Integer num) {
        dz dzVar = this.f8335f;
        if (dzVar == null) {
            this.f8330a.a(this, num);
        } else if (dzVar != null) {
            dzVar.c(num.intValue());
            k();
        }
    }

    public final dt e() {
        return this.f8340k;
    }

    public final void e(Boolean bool) {
        dy dyVar = this.f8338i;
        if (dyVar == null) {
            this.f8330a.a(this, bool);
            return;
        }
        dyVar.a(bool.booleanValue());
    }

    public final dz f() {
        return this.f8335f;
    }

    public final void f(Boolean bool) {
        dz dzVar = this.f8335f;
        int i2 = 0;
        if (dzVar == null) {
            this.f8330a.a(this, bool);
            return;
        }
        if (!bool.booleanValue()) {
            i2 = 8;
        }
        dzVar.setVisibility(i2);
    }

    public final void g() {
        hideInfoWindow();
        dl.a(this.f8344o);
        l();
        removeAllViews();
        this.f8346q = null;
    }

    public final void g(Boolean bool) {
        dz dzVar = this.f8335f;
        if (dzVar == null) {
            this.f8330a.a(this, bool);
        } else if (dzVar == null || !bool.booleanValue()) {
            dz dzVar2 = this.f8335f;
            if (dzVar2 != null) {
                dzVar2.a(false);
            }
        } else {
            this.f8335f.a(true);
        }
    }

    public final void h() {
        ds dsVar = this.f8337h;
        if (dsVar == null) {
            this.f8330a.a(this, new Object[0]);
        } else {
            dsVar.b();
        }
    }

    public final void h(Boolean bool) {
        du duVar = this.f8336g;
        if (duVar == null) {
            this.f8330a.a(this, bool);
            return;
        }
        duVar.a(bool.booleanValue());
    }

    public final void hideInfoWindow() {
        try {
            IAMapDelegate iAMapDelegate = this.f8332c;
            if (iAMapDelegate != null && iAMapDelegate.getMainHandler() != null) {
                this.f8332c.getMainHandler().post(new Runnable() {
                    public final void run() {
                        if (dv.this.f8342m != null) {
                            dv.this.f8342m.clearFocus();
                            dv dvVar = dv.this;
                            dvVar.removeView(dvVar.f8342m);
                            dl.a(dv.this.f8342m.getBackground());
                            dl.a(dv.this.f8344o);
                            View unused = dv.this.f8342m = null;
                        }
                    }
                });
                BasePointOverlay basePointOverlay = this.f8343n;
                if (basePointOverlay != null) {
                    this.f8333d.getNativeProperties(basePointOverlay.getId(), "setInfoWindowShown", new Object[]{Boolean.FALSE});
                }
                this.f8343n = null;
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void i() {
        Context context;
        if (this.f8348s && (context = this.f8334e) != null) {
            a(context);
            dx dxVar = this.f8330a;
            if (dxVar != null) {
                dxVar.a();
            }
        }
    }

    public final void i(Boolean bool) {
        dt dtVar = this.f8340k;
        if (dtVar == null) {
            this.f8330a.a(this, bool);
            return;
        }
        dtVar.a(bool.booleanValue());
    }

    public final boolean isInfoWindowShown() {
        return false;
    }

    public final View j() {
        return this;
    }

    public final boolean onInfoWindowTap(MotionEvent motionEvent) {
        return (this.f8342m == null || this.f8343n == null || !dl.a(new Rect(this.f8342m.getLeft(), this.f8342m.getTop(), this.f8342m.getRight(), this.f8342m.getBottom()), (int) motionEvent.getX(), (int) motionEvent.getY())) ? false : true;
    }

    public final void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        try {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                View childAt = getChildAt(i6);
                if (childAt != null) {
                    if (childAt.getLayoutParams() instanceof a) {
                        a(childAt, (a) childAt.getLayoutParams());
                    } else {
                        a(childAt, childAt.getLayoutParams());
                    }
                }
            }
            dz dzVar = this.f8335f;
            if (dzVar != null) {
                dzVar.c();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public final void redrawInfoWindow() {
        try {
            BasePointOverlay basePointOverlay = this.f8343n;
            if (basePointOverlay == null || !this.f8333d.checkInBounds(basePointOverlay.getId())) {
                View view = this.f8342m;
                if (view != null && view.getVisibility() == 0) {
                    this.f8342m.setVisibility(8);
                }
            } else if (this.f8345p) {
                FPoint obtain = FPoint.obtain();
                this.f8333d.getMarkerInfoWindowOffset(this.f8343n.getId(), obtain);
                int i2 = (int) obtain.x;
                int i3 = (int) (obtain.y + 2.0f);
                obtain.recycle();
                View a2 = a(this.f8343n);
                if (a2 == null) {
                    View view2 = this.f8342m;
                    if (view2 != null && view2.getVisibility() == 0) {
                        hideInfoWindow();
                        return;
                    }
                    return;
                }
                FPoint obtain2 = FPoint.obtain();
                this.f8333d.getOverlayScreenPos(this.f8343n.getId(), obtain2);
                a(a2, (int) obtain2.x, (int) obtain2.y, i2, i3);
                View view3 = this.f8342m;
                if (view3 != null) {
                    a aVar = (a) view3.getLayoutParams();
                    if (aVar != null) {
                        aVar.f8356a = FPoint.obtain(obtain2.x, obtain2.y);
                        aVar.f8358c = i2;
                        aVar.f8359d = i3;
                    }
                    onLayout(false, 0, 0, 0, 0);
                    if (this.f8331b.a()) {
                        this.f8331b.a(this.f8343n.getTitle(), this.f8343n.getSnippet());
                    }
                    if (this.f8342m.getVisibility() == 8) {
                        this.f8342m.setVisibility(0);
                    }
                }
                obtain2.recycle();
            }
        } catch (Throwable th) {
            fz.c(th, "MapOverlayViewGroup", "redrawInfoWindow");
            dl.a(th);
        }
    }

    public final void setInfoWindowAdapterManager(aj ajVar) {
        this.f8331b = ajVar;
    }

    public final void showInfoWindow(BasePointOverlay basePointOverlay) {
        if (basePointOverlay != null) {
            try {
                aj ajVar = this.f8331b;
                if ((ajVar == null || !ajVar.a() || basePointOverlay.getTitle() != null || basePointOverlay.getSnippet() != null) && basePointOverlay.isInfoWindowEnable()) {
                    BasePointOverlay basePointOverlay2 = this.f8343n;
                    if (basePointOverlay2 != null && !basePointOverlay2.getId().equals(basePointOverlay.getId())) {
                        hideInfoWindow();
                    }
                    if (this.f8331b != null) {
                        this.f8343n = basePointOverlay;
                        this.f8347r = true;
                        this.f8333d.getNativeProperties(basePointOverlay.getId(), "setInfoWindowShown", new Object[]{Boolean.TRUE});
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }

    public final void showInfoWindow(BaseOverlayImp baseOverlayImp) {
        if (baseOverlayImp != null) {
            try {
                aj ajVar = this.f8331b;
                if ((ajVar == null || !ajVar.a() || baseOverlayImp.getTitle() != null || baseOverlayImp.getSnippet() != null) && baseOverlayImp.isInfoWindowEnable()) {
                    BasePointOverlay basePointOverlay = this.f8343n;
                    if (basePointOverlay != null && !basePointOverlay.getId().equals(baseOverlayImp.getId())) {
                        hideInfoWindow();
                    }
                    if (this.f8331b != null) {
                        baseOverlayImp.setInfoWindowShown(true);
                        this.f8347r = true;
                    }
                }
            } catch (Throwable unused) {
            }
        }
    }
}
