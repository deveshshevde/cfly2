package com.amap.api.mapcore.util;

import android.opengl.GLSurfaceView;
import com.amap.api.mapcore.util.m;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;

public class cw implements GLSurfaceView.EGLContextFactory, m.f {
    public EGLContext createContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLConfig eGLConfig) {
        return null;
    }

    public void destroyContext(EGL10 egl10, EGLDisplay eGLDisplay, EGLContext eGLContext) {
    }
}
