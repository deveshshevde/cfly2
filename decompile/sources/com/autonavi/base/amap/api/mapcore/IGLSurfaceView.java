package com.autonavi.base.amap.api.mapcore;

import android.opengl.GLSurfaceView;
import android.view.SurfaceHolder;
import android.view.ViewParent;
import com.amap.api.mapcore.util.cv;
import com.amap.api.mapcore.util.cw;

public interface IGLSurfaceView {
    int getHeight();

    SurfaceHolder getHolder();

    ViewParent getParent();

    int getRenderMode();

    int getWidth();

    boolean isEnabled();

    void onDetachedGLThread();

    boolean post(Runnable runnable);

    boolean postDelayed(Runnable runnable, long j2);

    void queueEvent(Runnable runnable);

    void requestRender();

    void setBackgroundColor(int i2);

    void setEGLConfigChooser(cv cvVar);

    void setEGLContextFactory(cw cwVar);

    void setRenderMode(int i2);

    void setRenderer(GLSurfaceView.Renderer renderer);

    void setVisibility(int i2);

    void setZOrderOnTop(boolean z2);
}
