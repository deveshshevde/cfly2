package com.amap.api.mapcore.util;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import android.view.ViewParent;
import com.autonavi.base.amap.api.mapcore.IAMapDelegate;
import com.autonavi.base.amap.api.mapcore.IGLSurfaceView;

public final class c implements IGLSurfaceView {

    /* renamed from: a  reason: collision with root package name */
    protected boolean f8113a;

    /* renamed from: b  reason: collision with root package name */
    private IAMapDelegate f8114b;

    public c(Context context) {
        this(context, (byte) 0);
    }

    private c(Context context, byte b2) {
        this.f8114b = null;
        this.f8113a = false;
        this.f8114b = new b(this, context);
    }

    public final IAMapDelegate a() {
        return this.f8114b;
    }

    public final int getHeight() {
        return 0;
    }

    public final SurfaceHolder getHolder() {
        return null;
    }

    public final ViewParent getParent() {
        return null;
    }

    public final int getRenderMode() {
        return 0;
    }

    public final int getWidth() {
        return 0;
    }

    public final boolean isEnabled() {
        return this.f8114b != null;
    }

    public final void onDetachedGLThread() {
    }

    public final boolean post(Runnable runnable) {
        return false;
    }

    public final boolean postDelayed(Runnable runnable, long j2) {
        return false;
    }

    public final void queueEvent(Runnable runnable) {
        if (runnable != null) {
            runnable.run();
        }
    }

    public final void requestRender() {
    }

    public final void setBackgroundColor(int i2) {
    }

    public final void setEGLConfigChooser(cv cvVar) {
    }

    public final void setEGLContextFactory(cw cwVar) {
    }

    public final void setRenderMode(int i2) {
    }

    public final void setRenderer(GLSurfaceView.Renderer renderer) {
    }

    public final void setVisibility(int i2) {
    }

    public final void setZOrderOnTop(boolean z2) {
    }
}
