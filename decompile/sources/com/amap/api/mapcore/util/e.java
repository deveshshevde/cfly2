package com.amap.api.mapcore.util;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.opengl.GLSurfaceView;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import com.amap.api.mapcore.util.m;
import com.amap.api.maps.MapsInitializer;
import com.autonavi.base.ae.gmap.GLMapRender;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;

public final class e extends m implements IGLSurfaceView {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f8402a = false;

    /* renamed from: b  reason: collision with root package name */
    private IAMapDelegate f8403b = null;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public GLMapRender f8404c = null;

    public e(Context context, boolean z2) {
        super(context);
        cx.a(this);
        this.f8403b = new b(this, context, z2);
    }

    public final IAMapDelegate a() {
        return this.f8403b;
    }

    public final void b() {
        String str = dm.f8269c;
        dn.a(str, "AMapGLTextureView onPause mMapRender.mSurfacedestoryed " + this.f8404c.mSurfacedestoryed);
        if (!this.f8404c.mSurfacedestoryed) {
            queueEvent(new Runnable() {
                public final void run() {
                    try {
                        if (e.this.f8404c != null) {
                            e.this.f8404c.onSurfaceDestory();
                        }
                    } catch (Throwable th) {
                        th.printStackTrace();
                        dl.a(th);
                    }
                }
            });
            int i2 = 0;
            while (!this.f8404c.mSurfacedestoryed) {
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
        super.b();
    }

    public final void c() {
        super.c();
        dn.a(dm.f8269c, "AMapGLTextureView onResume");
    }

    public final SurfaceHolder getHolder() {
        return null;
    }

    /* access modifiers changed from: protected */
    public final void onAttachedToWindow() {
        super.onAttachedToWindow();
        dn.a(dm.f8269c, "AMapGLTextureView onAttachedToWindow");
        try {
            GLMapRender gLMapRender = this.f8404c;
            if (gLMapRender != null) {
                gLMapRender.onAttachedToWindow();
            }
        } catch (Throwable th) {
            th.printStackTrace();
        }
        c();
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        String str = dm.f8269c;
        dn.a(str, "AMapGLTextureView onDetachedFromWindow MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (!MapsInitializer.isSupportRecycleView()) {
            b();
            try {
                GLMapRender gLMapRender = this.f8404c;
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
        dn.a(str, "AMapGLTextureView onDetachedGLThread MapsInitializer.isSupportRecycleView() " + MapsInitializer.isSupportRecycleView());
        if (MapsInitializer.isSupportRecycleView()) {
            b();
            try {
                GLMapRender gLMapRender = this.f8404c;
                if (gLMapRender != null) {
                    gLMapRender.onDetachedFromWindow();
                }
            } catch (Throwable th) {
                th.printStackTrace();
            }
            super.onDetachedFromWindow();
        }
    }

    public final boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        dn.a(dm.f8269c, "AMapGLTextureView onSurfaceTextureDestroyed");
        requestRender();
        try {
            if (MapsInitializer.getTextureDestroyRender()) {
                Thread.sleep(100);
            }
        } catch (Throwable th) {
            th.printStackTrace();
            dl.a(th);
        }
        return super.onSurfaceTextureDestroyed(surfaceTexture);
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        super.onTouchEvent(motionEvent);
        try {
            return this.f8403b.onTouchEvent(motionEvent);
        } catch (Throwable th) {
            th.printStackTrace();
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void onWindowVisibilityChanged(int i2) {
        super.onWindowVisibilityChanged(i2);
        dn.a(dm.f8269c, "AMapGLTextureView onWindowVisibilityChanged visibility ".concat(String.valueOf(i2)));
        if (i2 == 8 || i2 == 4) {
            GLMapRender gLMapRender = this.f8404c;
            if (gLMapRender != null) {
                gLMapRender.renderPause();
                this.f8402a = false;
            }
            requestRender();
        } else if (i2 == 0) {
            try {
                GLMapRender gLMapRender2 = this.f8404c;
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
        super.a((m.e) cvVar);
    }

    public final void setEGLContextFactory(cw cwVar) {
        super.a((m.f) cwVar);
    }

    public final void setRenderer(GLSurfaceView.Renderer renderer) {
        this.f8404c = (GLMapRender) renderer;
        super.setRenderer(renderer);
    }

    public final void setZOrderOnTop(boolean z2) {
    }
}
