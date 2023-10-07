package com.xeagle.android.login.common;

import android.content.Context;
import android.hardware.Camera;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.io.IOException;

public class CameraPreview extends SurfaceView implements SurfaceHolder.Callback {
    private static final String TAG = "CameraPreview";
    private boolean isCameraFront;
    private Camera mCamera;
    private SurfaceHolder mHolder;

    public CameraPreview(Context context) {
        super(context);
        SurfaceHolder holder = getHolder();
        this.mHolder = holder;
        holder.addCallback(this);
        this.mHolder.setType(3);
    }

    public void setCamera(Camera camera, boolean z2) {
        this.mCamera = camera;
        this.isCameraFront = z2;
        SurfaceHolder surfaceHolder = this.mHolder;
        if (surfaceHolder != null) {
            try {
                camera.setPreviewDisplay(surfaceHolder);
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }

    public void startFaceDetection() {
        if (this.mCamera.getParameters().getMaxNumDetectedFaces() > 0) {
            this.mCamera.startFaceDetection();
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:3|4|5|6|(1:8)|9|13) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0051, code lost:
        r1 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0052, code lost:
        android.util.Log.d(TAG, "Error starting camera preview: " + r1.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x000e */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x001e A[Catch:{ Exception -> 0x0051 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void surfaceChanged(android.view.SurfaceHolder r1, int r2, int r3, int r4) {
        /*
            r0 = this;
            android.view.SurfaceHolder r1 = r0.mHolder
            android.view.Surface r1 = r1.getSurface()
            if (r1 != 0) goto L_0x0009
            return
        L_0x0009:
            android.hardware.Camera r1 = r0.mCamera     // Catch:{ Exception -> 0x000e }
            r1.stopPreview()     // Catch:{ Exception -> 0x000e }
        L_0x000e:
            android.hardware.Camera r1 = r0.mCamera     // Catch:{ Exception -> 0x0051 }
            android.hardware.Camera$Parameters r1 = r1.getParameters()     // Catch:{ Exception -> 0x0051 }
            java.util.List r2 = r1.getSupportedPreviewSizes()     // Catch:{ Exception -> 0x0051 }
            android.hardware.Camera$Size r2 = com.xeagle.android.login.common.CameraUtils.choosePreviewSize(r2, r3, r4)     // Catch:{ Exception -> 0x0051 }
            if (r2 == 0) goto L_0x0041
            java.util.List r3 = r1.getSupportedPreviewFrameRates()     // Catch:{ Exception -> 0x0051 }
            int r4 = r2.width     // Catch:{ Exception -> 0x0051 }
            int r2 = r2.height     // Catch:{ Exception -> 0x0051 }
            r1.setPreviewSize(r4, r2)     // Catch:{ Exception -> 0x0051 }
            int r2 = r3.size()     // Catch:{ Exception -> 0x0051 }
            int r2 = r2 + -1
            java.lang.Object r2 = r3.get(r2)     // Catch:{ Exception -> 0x0051 }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ Exception -> 0x0051 }
            int r2 = r2.intValue()     // Catch:{ Exception -> 0x0051 }
            r1.setPreviewFrameRate(r2)     // Catch:{ Exception -> 0x0051 }
            android.hardware.Camera r2 = r0.mCamera     // Catch:{ Exception -> 0x0051 }
            r2.setParameters(r1)     // Catch:{ Exception -> 0x0051 }
        L_0x0041:
            android.hardware.Camera r1 = r0.mCamera     // Catch:{ Exception -> 0x0051 }
            android.view.SurfaceHolder r2 = r0.mHolder     // Catch:{ Exception -> 0x0051 }
            r1.setPreviewDisplay(r2)     // Catch:{ Exception -> 0x0051 }
            android.hardware.Camera r1 = r0.mCamera     // Catch:{ Exception -> 0x0051 }
            r1.startPreview()     // Catch:{ Exception -> 0x0051 }
            r0.startFaceDetection()     // Catch:{ Exception -> 0x0051 }
            goto L_0x006c
        L_0x0051:
            r1 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error starting camera preview: "
            r2.append(r3)
            java.lang.String r1 = r1.getMessage()
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            java.lang.String r2 = "CameraPreview"
            android.util.Log.d(r2, r1)
        L_0x006c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.common.CameraPreview.surfaceChanged(android.view.SurfaceHolder, int, int, int):void");
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        try {
            this.mCamera.setPreviewDisplay(surfaceHolder);
            this.mCamera.startPreview();
            startFaceDetection();
        } catch (IOException e2) {
            Log.d(TAG, "Error setting camera preview: " + e2.getMessage());
        }
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
    }
}
