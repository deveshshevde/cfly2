package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.amap.api.maps.AMap;
import com.amap.api.maps.InfoWindowParams;
import com.amap.api.maps.model.BaseOverlay;
import com.amap.api.maps.model.BasePointOverlay;
import com.amap.api.maps.model.Marker;
import com.autonavi.base.amap.api.mapcore.BaseOverlayImp;
import com.autonavi.base.amap.api.mapcore.infowindow.IInfoWindowAction;

public final class aj {

    /* renamed from: a  reason: collision with root package name */
    AMap.InfoWindowAdapter f7786a = null;

    /* renamed from: b  reason: collision with root package name */
    AMap.CommonInfoWindowAdapter f7787b = null;

    /* renamed from: c  reason: collision with root package name */
    Context f7788c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f7789d = true;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public View f7790e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TextView f7791f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f7792g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public Drawable f7793h = null;

    /* renamed from: i  reason: collision with root package name */
    private IInfoWindowAction f7794i;

    /* renamed from: j  reason: collision with root package name */
    private IInfoWindowAction f7795j;

    /* renamed from: k  reason: collision with root package name */
    private BaseOverlay f7796k;

    /* renamed from: l  reason: collision with root package name */
    private AMap.InfoWindowAdapter f7797l = new AMap.InfoWindowAdapter() {
        public final View getInfoContents(Marker marker) {
            return null;
        }

        public final View getInfoWindow(Marker marker) {
            try {
                if (aj.this.f7793h == null) {
                    aj ajVar = aj.this;
                    Drawable unused = ajVar.f7793h = da.a(ajVar.f7788c, "infowindow_bg.9.png");
                }
                if (aj.this.f7790e == null) {
                    View unused2 = aj.this.f7790e = new LinearLayout(aj.this.f7788c);
                    aj.this.f7790e.setBackground(aj.this.f7793h);
                    TextView unused3 = aj.this.f7791f = new TextView(aj.this.f7788c);
                    aj.this.f7791f.setText(marker.getTitle());
                    aj.this.f7791f.setTextColor(-16777216);
                    TextView unused4 = aj.this.f7792g = new TextView(aj.this.f7788c);
                    aj.this.f7792g.setTextColor(-16777216);
                    aj.this.f7792g.setText(marker.getSnippet());
                    ((LinearLayout) aj.this.f7790e).setOrientation(1);
                    ((LinearLayout) aj.this.f7790e).addView(aj.this.f7791f);
                    ((LinearLayout) aj.this.f7790e).addView(aj.this.f7792g);
                }
            } catch (Throwable th) {
                fz.c(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
            }
            return aj.this.f7790e;
        }
    };

    /* renamed from: m  reason: collision with root package name */
    private AMap.CommonInfoWindowAdapter f7798m = new AMap.CommonInfoWindowAdapter() {

        /* renamed from: b  reason: collision with root package name */
        private InfoWindowParams f7801b = null;

        public final InfoWindowParams getInfoWindowParams(BasePointOverlay basePointOverlay) {
            try {
                if (this.f7801b == null) {
                    this.f7801b = new InfoWindowParams();
                    if (aj.this.f7793h == null) {
                        aj ajVar = aj.this;
                        Drawable unused = ajVar.f7793h = da.a(ajVar.f7788c, "infowindow_bg.9.png");
                    }
                    View unused2 = aj.this.f7790e = new LinearLayout(aj.this.f7788c);
                    aj.this.f7790e.setBackground(aj.this.f7793h);
                    TextView unused3 = aj.this.f7791f = new TextView(aj.this.f7788c);
                    aj.this.f7791f.setText("标题");
                    aj.this.f7791f.setTextColor(-16777216);
                    TextView unused4 = aj.this.f7792g = new TextView(aj.this.f7788c);
                    aj.this.f7792g.setTextColor(-16777216);
                    aj.this.f7792g.setText("内容");
                    ((LinearLayout) aj.this.f7790e).setOrientation(1);
                    ((LinearLayout) aj.this.f7790e).addView(aj.this.f7791f);
                    ((LinearLayout) aj.this.f7790e).addView(aj.this.f7792g);
                    this.f7801b.setInfoWindowType(2);
                    this.f7801b.setInfoWindow(aj.this.f7790e);
                }
                return this.f7801b;
            } catch (Throwable th) {
                fz.c(th, "InfoWindowDelegate", "showInfoWindow decodeDrawableFromAsset");
                th.printStackTrace();
                return null;
            }
        }
    };

    public aj(Context context) {
        this.f7788c = context;
    }

    private static void a(View view, BasePointOverlay basePointOverlay) {
        if (view != null && basePointOverlay != null && basePointOverlay.getPosition() != null && cz.c()) {
            String b2 = dl.b(view);
            if (!TextUtils.isEmpty(b2)) {
                cz.a().a(basePointOverlay.getPosition(), b2, "");
            }
        }
    }

    private synchronized IInfoWindowAction d() {
        AMap.InfoWindowAdapter infoWindowAdapter = this.f7786a;
        if (infoWindowAdapter != null) {
            if (infoWindowAdapter instanceof AMap.ImageInfoWindowAdapter) {
                return this.f7795j;
            } else if (infoWindowAdapter instanceof AMap.MultiPositionInfoWindowAdapter) {
                return this.f7795j;
            }
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f7787b;
        if (commonInfoWindowAdapter == null || commonInfoWindowAdapter.getInfoWindowParams((BasePointOverlay) null).getInfoWindowType() != 1) {
            return this.f7794i;
        }
        return this.f7795j;
    }

    public final View a(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        View infoWindow;
        AMap.InfoWindowAdapter infoWindowAdapter = this.f7786a;
        if (infoWindowAdapter != null) {
            infoWindow = infoWindowAdapter.getInfoWindow((Marker) basePointOverlay);
        } else {
            AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f7787b;
            if (commonInfoWindowAdapter == null || (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) == null) {
                InfoWindowParams infoWindowParams2 = this.f7798m.getInfoWindowParams(basePointOverlay);
                if (infoWindowParams2 != null) {
                    return infoWindowParams2.getInfoWindow();
                }
                return null;
            }
            infoWindow = infoWindowParams.getInfoWindow();
        }
        a(infoWindow, basePointOverlay);
        return infoWindow;
    }

    public final BaseOverlay a(MotionEvent motionEvent) {
        IInfoWindowAction d2 = d();
        if (d2 == null || !d2.onInfoWindowTap(motionEvent)) {
            return null;
        }
        return this.f7796k;
    }

    public final synchronized void a(AMap.CommonInfoWindowAdapter commonInfoWindowAdapter) {
        this.f7787b = commonInfoWindowAdapter;
        this.f7786a = null;
        if (commonInfoWindowAdapter == null) {
            this.f7787b = this.f7798m;
            this.f7789d = true;
        } else {
            this.f7789d = false;
        }
        IInfoWindowAction iInfoWindowAction = this.f7795j;
        if (iInfoWindowAction != null) {
            iInfoWindowAction.hideInfoWindow();
        }
        IInfoWindowAction iInfoWindowAction2 = this.f7794i;
        if (iInfoWindowAction2 != null) {
            iInfoWindowAction2.hideInfoWindow();
        }
    }

    public final synchronized void a(AMap.InfoWindowAdapter infoWindowAdapter) {
        this.f7786a = infoWindowAdapter;
        this.f7787b = null;
        if (infoWindowAdapter == null) {
            this.f7786a = this.f7797l;
            this.f7789d = true;
        } else {
            this.f7789d = false;
        }
        IInfoWindowAction iInfoWindowAction = this.f7795j;
        if (iInfoWindowAction != null) {
            iInfoWindowAction.hideInfoWindow();
        }
        IInfoWindowAction iInfoWindowAction2 = this.f7794i;
        if (iInfoWindowAction2 != null) {
            iInfoWindowAction2.hideInfoWindow();
        }
    }

    public final void a(BaseOverlay baseOverlay) throws RemoteException {
        IInfoWindowAction d2 = d();
        if (d2 != null && (baseOverlay instanceof BasePointOverlay)) {
            d2.showInfoWindow((BasePointOverlay) baseOverlay);
            this.f7796k = baseOverlay;
        }
    }

    public final void a(BaseOverlayImp baseOverlayImp) throws RemoteException {
        IInfoWindowAction d2 = d();
        if (d2 != null) {
            d2.showInfoWindow(baseOverlayImp);
        }
    }

    public final void a(IInfoWindowAction iInfoWindowAction) {
        synchronized (this) {
            this.f7794i = iInfoWindowAction;
            if (iInfoWindowAction != null) {
                iInfoWindowAction.setInfoWindowAdapterManager(this);
            }
        }
    }

    public final void a(String str, String str2) {
        TextView textView = this.f7791f;
        if (textView != null) {
            textView.requestLayout();
            this.f7791f.setText(str);
        }
        TextView textView2 = this.f7792g;
        if (textView2 != null) {
            textView2.requestLayout();
            this.f7792g.setText(str2);
        }
        View view = this.f7790e;
        if (view != null) {
            view.requestLayout();
        }
    }

    public final synchronized boolean a() {
        return this.f7789d;
    }

    public final View b(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        View infoContents;
        AMap.InfoWindowAdapter infoWindowAdapter = this.f7786a;
        if (infoWindowAdapter != null) {
            infoContents = infoWindowAdapter.getInfoContents((Marker) basePointOverlay);
        } else {
            AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f7787b;
            if (commonInfoWindowAdapter == null || (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) == null) {
                InfoWindowParams infoWindowParams2 = this.f7798m.getInfoWindowParams(basePointOverlay);
                if (infoWindowParams2 != null) {
                    return infoWindowParams2.getInfoContents();
                }
                return null;
            }
            infoContents = infoWindowParams.getInfoContents();
        }
        a(infoContents, basePointOverlay);
        return infoContents;
    }

    public final void b() {
        IInfoWindowAction d2 = d();
        if (d2 != null) {
            d2.redrawInfoWindow();
        }
    }

    public final void b(IInfoWindowAction iInfoWindowAction) {
        synchronized (this) {
            this.f7795j = iInfoWindowAction;
            if (iInfoWindowAction != null) {
                iInfoWindowAction.setInfoWindowAdapterManager(this);
            }
        }
    }

    public final long c(BasePointOverlay basePointOverlay) {
        InfoWindowParams infoWindowParams;
        AMap.InfoWindowAdapter infoWindowAdapter = this.f7786a;
        if (infoWindowAdapter != null && (infoWindowAdapter instanceof AMap.ImageInfoWindowAdapter)) {
            return ((AMap.ImageInfoWindowAdapter) infoWindowAdapter).getInfoWindowUpdateTime();
        }
        AMap.CommonInfoWindowAdapter commonInfoWindowAdapter = this.f7787b;
        if (commonInfoWindowAdapter == null || (infoWindowParams = commonInfoWindowAdapter.getInfoWindowParams(basePointOverlay)) == null) {
            return 0;
        }
        return infoWindowParams.getInfoWindowUpdateTime();
    }

    public final void c() {
        IInfoWindowAction d2 = d();
        if (d2 != null) {
            d2.hideInfoWindow();
        }
    }
}
