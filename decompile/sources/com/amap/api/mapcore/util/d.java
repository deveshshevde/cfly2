package com.amap.api.mapcore.util;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import android.view.MotionEvent;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;

public final class d extends GLSurfaceView implements IGLSurfaceView {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f8232a;

    /* renamed from: b  reason: collision with root package name */
    private IAMapDelegate f8233b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public GLMapRender f8234c;

    public d(Context context, boolean z2) {
        this(context, z2, (byte) 0);
    }

    private d(Context context, boolean z2, byte b2) {
        super(context, (AttributeSet) null);
        this.f8233b = null;
        this.f8234c = null;
        this.f8232a = false;
        cx.a(this);
        this.f8233b = new b(this, context, z2);
    }

    public final IAMapDelegate a() {
        return this.f8233b;
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        dn.a(dm.f8269c, "AMapGLSurfaceView onAttachedToWindow");
        try {
            GLMapRender gLMapRender = this.f8234c;
            if (gLMapRender != null) {
                gLMapRender.onAttachedToWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
            dl.a(th);
        }
        onResume();
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        String str = dm.f8269c;
        dn.a(str, "AMapGLSurfaceView onDetachedFromWindow MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (!MapsInitializer.isSupportRecycleView()) {
            onPause();
            try {
                GLMapRender gLMapRender = this.f8234c;
                if (gLMapRender != null) {
                    gLMapRender.onDetachedFromWindow();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            super.onDetachedFromWindow();
        }
    }

    public final void onDetachedGLThread() {
        String str = dm.f8269c;
        dn.a(str, "AMapGLSurfaceView onDetachedGLThread MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            onPause();
            try {
                GLMapRender gLMapRender = this.f8234c;
                if (gLMapRender != null) {
                    gLMapRender.onDetachedFromWindow();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                dl.a(th);
            }
            super.onDetachedFromWindow();
        }
    }

    public final void onPause() {
        String str = dm.f8269c;
        dn.a(str, "AMapGLSurfaceView onPause mMapRender.mSurfacedestoryed " + this.f8234c.mSurfacedestoryed);
        if (!this.f8234c.mSurfacedestoryed) {
            queueEvent(new Runnable() {
                public final void run() {
                    if (d.this.f8234c != null) {
                        try {
                            d.this.f8234c.onSurfaceDestory();
                        } catch (Throwable th) {
                            th.printStackTrace();
                            dl.a(th);
                        }
                    }
                }
            });
            int i2 = 0;
            while (!this.f8234c.mSurfacedestoryed) {
                int i3 = i2 + 1;
                if (i2 >= 50) {
                    break;
                }
                try {
                    Thread.sleep(20);
                } catch (InterruptedException unused) {
                }
                i2 = i3;
            }
        }
        super.onPause();
    }

    public final void onResume() {
        super.onResume();
        dn.a(dm.f8269c, "AMapGLSurfaceView onPause");
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        try {
            return this.f8233b.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        dn.a(dm.f8269c, "AMapGLSurfaceView onWindowVisibilityChanged visibility ".concat(String.valueOf(i2)));
        if (i2 == 8 || i2 == 4) {
            GLMapRender gLMapRender = this.f8234c;
            if (gLMapRender != null) {
                gLMapRender.renderPause();
                this.f8232a = false;
            }
        } else if (i2 == 0) {
            try {
                GLMapRender gLMapRender2 = this.f8234c;
                if (gLMapRender2 != null) {
                    gLMapRender2.renderResume();
                }
            } catch (Throwable th) {
                th.printStackTrace();
                dl.a(th);
            }
        }
    }

    public final void setEGLConfigChooser(cv cvVar) {
        super.setEGLConfigChooser(cvVar);
    }

    public final void setEGLContextFactory(cw cwVar) {
        super.setEGLContextFactory(cwVar);
    }

    public final void setRenderer(GLSurfaceView.Renderer renderer) {
        this.f8234c = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }
}
