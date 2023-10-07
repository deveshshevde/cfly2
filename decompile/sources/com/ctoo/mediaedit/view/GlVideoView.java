package com.ctoo.mediaedit.view;

import android.app.ActivityManager;
import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;
import cu.e;
import cx.a;

public class GlVideoView extends GLSurfaceView {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f10977a;

    /* renamed from: b  reason: collision with root package name */
    private Context f10978b;

    public GlVideoView(Context context) {
        super(context);
        a(context, (AttributeSet) null);
    }

    public GlVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(context, attributeSet);
    }

    private void a(Context context, AttributeSet attributeSet) {
        if (a(context)) {
            this.f10978b = context;
            return;
        }
        throw new IllegalStateException("OpenGL ES 2.0 is not supported on this phone.");
    }

    private boolean a(Context context) {
        return ((ActivityManager) context.getSystemService("activity")).getDeviceConfigurationInfo().reqGlEsVersion >= 131072;
    }

    public e getFilter() {
        return this.f10977a.a();
    }

    public String getVersion() {
        return "1.1.0";
    }

    public void setGPUFilter(final e eVar) {
        queueEvent(new Runnable() {
            public void run() {
                GlVideoView.this.f10977a.a(eVar);
            }
        });
    }

    public void setProgress(final float f2) {
        queueEvent(new Runnable() {
            public void run() {
                GlVideoView.this.f10977a.a(f2);
            }
        });
    }
}
