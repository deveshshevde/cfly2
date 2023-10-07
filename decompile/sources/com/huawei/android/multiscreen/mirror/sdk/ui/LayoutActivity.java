package com.huawei.android.multiscreen.mirror.sdk.ui;

import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import com.huawei.android.multiscreen.R;
import com.huawei.android.multiscreen.mirror.sdk.api.MRBaseLayoutActivity;

public class LayoutActivity extends MRBaseLayoutActivity {
    private static final String TAG = "MIRROR_SDK";
    private SurfaceView surfaceView;

    public void connected() {
        super.connected();
    }

    public Class<?> getServiceClass() {
        return SinkService.class;
    }

    public SurfaceHolder getSurfaceHolder() {
        setContentView(R.layout.sink_main);
        SurfaceView surfaceView2 = (SurfaceView) findViewById(R.id.sink_view);
        this.surfaceView = surfaceView2;
        SurfaceHolder holder = surfaceView2.getHolder();
        holder.addCallback(new SurfaceHolder.Callback() {
            public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
            }

            public void surfaceCreated(SurfaceHolder surfaceHolder) {
                Canvas canvas = null;
                try {
                    canvas = surfaceHolder.lockCanvas();
                    synchronized (surfaceHolder) {
                        canvas.drawBitmap(BitmapFactory.decodeResource(LayoutActivity.this.getResources(), R.drawable.mirrorloading), 480.0f, 300.0f, new Paint());
                    }
                    if (canvas == null) {
                    }
                } catch (Exception e2) {
                    try {
                        Log.e(LayoutActivity.TAG, "Thread.sleep Exception", e2);
                    } finally {
                        if (canvas != null) {
                            surfaceHolder.unlockCanvasAndPost(canvas);
                        }
                    }
                }
            }

            public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
            }
        });
        return holder;
    }
}
