package org.opencv.android;

import android.content.Context;
import android.content.res.TypedArray;
import android.opengl.GLSurfaceView;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import org.opencv.R;

public class CameraGLSurfaceView extends GLSurfaceView {

    /* renamed from: a  reason: collision with root package name */
    private a f33950a;

    /* renamed from: b  reason: collision with root package name */
    private c f33951b;

    public interface a {
        void a();

        void a(int i2, int i3);

        boolean a(int i2, int i3, int i4, int i5);
    }

    public CameraGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CameraBridgeViewBase);
        int i2 = obtainStyledAttributes.getInt(R.styleable.CameraBridgeViewBase_camera_id, -1);
        obtainStyledAttributes.recycle();
        this.f33951b = Build.VERSION.SDK_INT >= 21 ? new b(this) : new d(this);
        setCameraIndex(i2);
        setEGLContextClientVersion(2);
        setRenderer(this.f33951b);
        setRenderMode(0);
    }

    public a getCameraTextureListener() {
        return this.f33950a;
    }

    public void onPause() {
        Log.i("CameraGLSurfaceView", "onPause");
        this.f33951b.h();
        super.onPause();
    }

    public void onResume() {
        Log.i("CameraGLSurfaceView", "onResume");
        super.onResume();
        this.f33951b.g();
    }

    public void setCameraIndex(int i2) {
        this.f33951b.b(i2);
    }

    public void setCameraTextureListener(a aVar) {
        this.f33950a = aVar;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        super.surfaceChanged(surfaceHolder, i2, i3, i4);
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        super.surfaceCreated(surfaceHolder);
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        this.f33951b.f34026k = false;
        super.surfaceDestroyed(surfaceHolder);
    }
}
