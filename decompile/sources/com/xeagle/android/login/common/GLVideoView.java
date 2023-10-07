package com.xeagle.android.login.common;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.TextureView;

public class GLVideoView extends TextureView implements TextureView.SurfaceTextureListener {
    private Callback callback;
    private Surface surface;

    public interface Callback {
        void onSurfaceAvailable(Surface surface);

        void onSurfaceDestroyed();
    }

    public GLVideoView(Context context) {
        super(context);
        init();
    }

    public GLVideoView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init();
    }

    public GLVideoView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        init();
    }

    public GLVideoView(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
        init();
    }

    private void init() {
        setSurfaceTextureListener(this);
    }

    public Callback getCallback() {
        return this.callback;
    }

    public void onSurfaceTextureAvailable(SurfaceTexture surfaceTexture, int i2, int i3) {
        Surface surface2 = new Surface(surfaceTexture);
        this.surface = surface2;
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onSurfaceAvailable(surface2);
        }
    }

    public boolean onSurfaceTextureDestroyed(SurfaceTexture surfaceTexture) {
        Callback callback2 = this.callback;
        if (callback2 != null) {
            callback2.onSurfaceDestroyed();
        }
        Surface surface2 = this.surface;
        if (surface2 == null) {
            return true;
        }
        surface2.release();
        this.surface = null;
        return true;
    }

    public void onSurfaceTextureSizeChanged(SurfaceTexture surfaceTexture, int i2, int i3) {
    }

    public void onSurfaceTextureUpdated(SurfaceTexture surfaceTexture) {
    }

    public void setCallback(Callback callback2) {
        this.callback = callback2;
        Surface surface2 = this.surface;
        if (surface2 != null && callback2 != null) {
            callback2.onSurfaceAvailable(surface2);
        }
    }
}
