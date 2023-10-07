package org.opencv.android;

import android.hardware.Camera;
import android.util.Log;

public class d extends c {

    /* renamed from: a  reason: collision with root package name */
    private Camera f34042a;

    /* renamed from: q  reason: collision with root package name */
    private boolean f34043q = false;

    d(CameraGLSurfaceView cameraGLSurfaceView) {
        super(cameraGLSurfaceView);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00e6 A[Catch:{ Exception -> 0x0020 }] */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00ee A[Catch:{ Exception -> 0x0020 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(int r7) {
        /*
            r6 = this;
            monitor-enter(r6)
            java.lang.String r0 = "CameraRenderer"
            java.lang.String r1 = "openCamera"
            android.util.Log.i(r0, r1)     // Catch:{ all -> 0x0188 }
            r6.c()     // Catch:{ all -> 0x0188 }
            r0 = -1
            r1 = 9
            r2 = 0
            r3 = 1
            if (r7 != r0) goto L_0x0097
            java.lang.String r7 = "CameraRenderer"
            java.lang.String r0 = "Trying to open camera with old open()"
            android.util.Log.d(r7, r0)     // Catch:{ all -> 0x0188 }
            android.hardware.Camera r7 = android.hardware.Camera.open()     // Catch:{ Exception -> 0x0020 }
            r6.f34042a = r7     // Catch:{ Exception -> 0x0020 }
            goto L_0x003b
        L_0x0020:
            r7 = move-exception
            java.lang.String r0 = "CameraRenderer"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0188 }
            r4.<init>()     // Catch:{ all -> 0x0188 }
            java.lang.String r5 = "Camera is not available (in use or does not exist): "
            r4.append(r5)     // Catch:{ all -> 0x0188 }
            java.lang.String r7 = r7.getLocalizedMessage()     // Catch:{ all -> 0x0188 }
            r4.append(r7)     // Catch:{ all -> 0x0188 }
            java.lang.String r7 = r4.toString()     // Catch:{ all -> 0x0188 }
            android.util.Log.e(r0, r7)     // Catch:{ all -> 0x0188 }
        L_0x003b:
            android.hardware.Camera r7 = r6.f34042a     // Catch:{ all -> 0x0188 }
            if (r7 != 0) goto L_0x013a
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0188 }
            if (r7 < r1) goto L_0x013a
            r7 = 0
        L_0x0044:
            int r0 = android.hardware.Camera.getNumberOfCameras()     // Catch:{ all -> 0x0188 }
            if (r2 >= r0) goto L_0x013a
            java.lang.String r0 = "CameraRenderer"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0188 }
            r1.<init>()     // Catch:{ all -> 0x0188 }
            java.lang.String r4 = "Trying to open camera with new open("
            r1.append(r4)     // Catch:{ all -> 0x0188 }
            r1.append(r2)     // Catch:{ all -> 0x0188 }
            java.lang.String r4 = ")"
            r1.append(r4)     // Catch:{ all -> 0x0188 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0188 }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0188 }
            android.hardware.Camera r0 = android.hardware.Camera.open(r2)     // Catch:{ RuntimeException -> 0x006d }
            r6.f34042a = r0     // Catch:{ RuntimeException -> 0x006d }
            r7 = 1
            goto L_0x0090
        L_0x006d:
            r0 = move-exception
            java.lang.String r1 = "CameraRenderer"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0188 }
            r4.<init>()     // Catch:{ all -> 0x0188 }
            java.lang.String r5 = "Camera #"
            r4.append(r5)     // Catch:{ all -> 0x0188 }
            r4.append(r2)     // Catch:{ all -> 0x0188 }
            java.lang.String r5 = "failed to open: "
            r4.append(r5)     // Catch:{ all -> 0x0188 }
            java.lang.String r0 = r0.getLocalizedMessage()     // Catch:{ all -> 0x0188 }
            r4.append(r0)     // Catch:{ all -> 0x0188 }
            java.lang.String r0 = r4.toString()     // Catch:{ all -> 0x0188 }
            android.util.Log.e(r1, r0)     // Catch:{ all -> 0x0188 }
        L_0x0090:
            if (r7 == 0) goto L_0x0094
            goto L_0x013a
        L_0x0094:
            int r2 = r2 + 1
            goto L_0x0044
        L_0x0097:
            int r7 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0188 }
            if (r7 < r1) goto L_0x013a
            int r7 = r6.f34024i     // Catch:{ all -> 0x0188 }
            int r0 = r6.f34024i     // Catch:{ all -> 0x0188 }
            r1 = 98
            r4 = 99
            if (r0 != r4) goto L_0x00c2
            java.lang.String r0 = "CameraRenderer"
            java.lang.String r3 = "Trying to open BACK camera"
            android.util.Log.i(r0, r3)     // Catch:{ all -> 0x0188 }
            android.hardware.Camera$CameraInfo r0 = new android.hardware.Camera$CameraInfo     // Catch:{ all -> 0x0188 }
            r0.<init>()     // Catch:{ all -> 0x0188 }
        L_0x00b1:
            int r3 = android.hardware.Camera.getNumberOfCameras()     // Catch:{ all -> 0x0188 }
            if (r2 >= r3) goto L_0x00e4
            android.hardware.Camera.getCameraInfo(r2, r0)     // Catch:{ all -> 0x0188 }
            int r3 = r0.facing     // Catch:{ all -> 0x0188 }
            if (r3 != 0) goto L_0x00bf
            goto L_0x00df
        L_0x00bf:
            int r2 = r2 + 1
            goto L_0x00b1
        L_0x00c2:
            int r0 = r6.f34024i     // Catch:{ all -> 0x0188 }
            if (r0 != r1) goto L_0x00e4
            java.lang.String r0 = "CameraRenderer"
            java.lang.String r5 = "Trying to open FRONT camera"
            android.util.Log.i(r0, r5)     // Catch:{ all -> 0x0188 }
            android.hardware.Camera$CameraInfo r0 = new android.hardware.Camera$CameraInfo     // Catch:{ all -> 0x0188 }
            r0.<init>()     // Catch:{ all -> 0x0188 }
        L_0x00d2:
            int r5 = android.hardware.Camera.getNumberOfCameras()     // Catch:{ all -> 0x0188 }
            if (r2 >= r5) goto L_0x00e4
            android.hardware.Camera.getCameraInfo(r2, r0)     // Catch:{ all -> 0x0188 }
            int r5 = r0.facing     // Catch:{ all -> 0x0188 }
            if (r5 != r3) goto L_0x00e1
        L_0x00df:
            r7 = r2
            goto L_0x00e4
        L_0x00e1:
            int r2 = r2 + 1
            goto L_0x00d2
        L_0x00e4:
            if (r7 != r4) goto L_0x00ee
            java.lang.String r7 = "CameraRenderer"
            java.lang.String r0 = "Back camera not found!"
        L_0x00ea:
            android.util.Log.e(r7, r0)     // Catch:{ all -> 0x0188 }
            goto L_0x013a
        L_0x00ee:
            if (r7 != r1) goto L_0x00f5
            java.lang.String r7 = "CameraRenderer"
            java.lang.String r0 = "Front camera not found!"
            goto L_0x00ea
        L_0x00f5:
            java.lang.String r0 = "CameraRenderer"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0188 }
            r1.<init>()     // Catch:{ all -> 0x0188 }
            java.lang.String r2 = "Trying to open camera with new open("
            r1.append(r2)     // Catch:{ all -> 0x0188 }
            r1.append(r7)     // Catch:{ all -> 0x0188 }
            java.lang.String r2 = ")"
            r1.append(r2)     // Catch:{ all -> 0x0188 }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x0188 }
            android.util.Log.d(r0, r1)     // Catch:{ all -> 0x0188 }
            android.hardware.Camera r0 = android.hardware.Camera.open(r7)     // Catch:{ RuntimeException -> 0x0117 }
            r6.f34042a = r0     // Catch:{ RuntimeException -> 0x0117 }
            goto L_0x013a
        L_0x0117:
            r0 = move-exception
            java.lang.String r1 = "CameraRenderer"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0188 }
            r2.<init>()     // Catch:{ all -> 0x0188 }
            java.lang.String r3 = "Camera #"
            r2.append(r3)     // Catch:{ all -> 0x0188 }
            r2.append(r7)     // Catch:{ all -> 0x0188 }
            java.lang.String r7 = "failed to open: "
            r2.append(r7)     // Catch:{ all -> 0x0188 }
            java.lang.String r7 = r0.getLocalizedMessage()     // Catch:{ all -> 0x0188 }
            r2.append(r7)     // Catch:{ all -> 0x0188 }
            java.lang.String r7 = r2.toString()     // Catch:{ all -> 0x0188 }
            android.util.Log.e(r1, r7)     // Catch:{ all -> 0x0188 }
        L_0x013a:
            android.hardware.Camera r7 = r6.f34042a     // Catch:{ all -> 0x0188 }
            if (r7 != 0) goto L_0x0147
            java.lang.String r7 = "CameraRenderer"
            java.lang.String r0 = "Error: can't open camera"
            android.util.Log.e(r7, r0)     // Catch:{ all -> 0x0188 }
            monitor-exit(r6)
            return
        L_0x0147:
            android.hardware.Camera$Parameters r7 = r7.getParameters()     // Catch:{ all -> 0x0188 }
            java.util.List r0 = r7.getSupportedFocusModes()     // Catch:{ all -> 0x0188 }
            if (r0 == 0) goto L_0x015e
            java.lang.String r1 = "continuous-video"
            boolean r0 = r0.contains(r1)     // Catch:{ all -> 0x0188 }
            if (r0 == 0) goto L_0x015e
            java.lang.String r0 = "continuous-video"
            r7.setFocusMode(r0)     // Catch:{ all -> 0x0188 }
        L_0x015e:
            android.hardware.Camera r0 = r6.f34042a     // Catch:{ all -> 0x0188 }
            r0.setParameters(r7)     // Catch:{ all -> 0x0188 }
            android.hardware.Camera r7 = r6.f34042a     // Catch:{ IOException -> 0x016b }
            android.graphics.SurfaceTexture r0 = r6.f34025j     // Catch:{ IOException -> 0x016b }
            r7.setPreviewTexture(r0)     // Catch:{ IOException -> 0x016b }
            goto L_0x0186
        L_0x016b:
            r7 = move-exception
            java.lang.String r0 = "CameraRenderer"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x0188 }
            r1.<init>()     // Catch:{ all -> 0x0188 }
            java.lang.String r2 = "setPreviewTexture() failed: "
            r1.append(r2)     // Catch:{ all -> 0x0188 }
            java.lang.String r7 = r7.getMessage()     // Catch:{ all -> 0x0188 }
            r1.append(r7)     // Catch:{ all -> 0x0188 }
            java.lang.String r7 = r1.toString()     // Catch:{ all -> 0x0188 }
            android.util.Log.e(r0, r7)     // Catch:{ all -> 0x0188 }
        L_0x0186:
            monitor-exit(r6)
            return
        L_0x0188:
            r7 = move-exception
            monitor-exit(r6)
            goto L_0x018c
        L_0x018b:
            throw r7
        L_0x018c:
            goto L_0x018b
        */
        throw new UnsupportedOperationException("Method not decompiled: org.opencv.android.d.a(int):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:40:0x0102  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void b(int r18, int r19) {
        /*
            r17 = this;
            r1 = r17
            r0 = r18
            r2 = r19
            monitor-enter(r17)
            java.lang.String r3 = "CameraRenderer"
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0126 }
            r4.<init>()     // Catch:{ all -> 0x0126 }
            java.lang.String r5 = "setCameraPreviewSize: "
            r4.append(r5)     // Catch:{ all -> 0x0126 }
            r4.append(r0)     // Catch:{ all -> 0x0126 }
            java.lang.String r5 = "x"
            r4.append(r5)     // Catch:{ all -> 0x0126 }
            r4.append(r2)     // Catch:{ all -> 0x0126 }
            java.lang.String r4 = r4.toString()     // Catch:{ all -> 0x0126 }
            android.util.Log.i(r3, r4)     // Catch:{ all -> 0x0126 }
            android.hardware.Camera r3 = r1.f34042a     // Catch:{ all -> 0x0126 }
            if (r3 != 0) goto L_0x0032
            java.lang.String r0 = "CameraRenderer"
            java.lang.String r2 = "Camera isn't initialized!"
            android.util.Log.e(r0, r2)     // Catch:{ all -> 0x0126 }
            monitor-exit(r17)
            return
        L_0x0032:
            int r3 = r1.f34022g     // Catch:{ all -> 0x0126 }
            if (r3 <= 0) goto L_0x003c
            int r3 = r1.f34022g     // Catch:{ all -> 0x0126 }
            if (r3 >= r0) goto L_0x003c
            int r0 = r1.f34022g     // Catch:{ all -> 0x0126 }
        L_0x003c:
            int r3 = r1.f34023h     // Catch:{ all -> 0x0126 }
            if (r3 <= 0) goto L_0x0046
            int r3 = r1.f34023h     // Catch:{ all -> 0x0126 }
            if (r3 >= r2) goto L_0x0046
            int r2 = r1.f34023h     // Catch:{ all -> 0x0126 }
        L_0x0046:
            android.hardware.Camera r3 = r1.f34042a     // Catch:{ all -> 0x0126 }
            android.hardware.Camera$Parameters r3 = r3.getParameters()     // Catch:{ all -> 0x0126 }
            java.util.List r4 = r3.getSupportedPreviewSizes()     // Catch:{ all -> 0x0126 }
            int r5 = r4.size()     // Catch:{ all -> 0x0126 }
            if (r5 <= 0) goto L_0x0110
            float r5 = (float) r0     // Catch:{ all -> 0x0126 }
            float r6 = (float) r2     // Catch:{ all -> 0x0126 }
            float r5 = r5 / r6
            java.util.Iterator r6 = r4.iterator()     // Catch:{ all -> 0x0126 }
            r7 = 0
            r8 = 0
            r9 = 0
        L_0x0060:
            boolean r10 = r6.hasNext()     // Catch:{ all -> 0x0126 }
            if (r10 == 0) goto L_0x00ac
            java.lang.Object r10 = r6.next()     // Catch:{ all -> 0x0126 }
            android.hardware.Camera$Size r10 = (android.hardware.Camera.Size) r10     // Catch:{ all -> 0x0126 }
            int r11 = r10.width     // Catch:{ all -> 0x0126 }
            int r10 = r10.height     // Catch:{ all -> 0x0126 }
            java.lang.String r12 = "CameraRenderer"
            java.lang.StringBuilder r13 = new java.lang.StringBuilder     // Catch:{ all -> 0x0126 }
            r13.<init>()     // Catch:{ all -> 0x0126 }
            java.lang.String r14 = "checking camera preview size: "
            r13.append(r14)     // Catch:{ all -> 0x0126 }
            r13.append(r11)     // Catch:{ all -> 0x0126 }
            java.lang.String r14 = "x"
            r13.append(r14)     // Catch:{ all -> 0x0126 }
            r13.append(r10)     // Catch:{ all -> 0x0126 }
            java.lang.String r13 = r13.toString()     // Catch:{ all -> 0x0126 }
            android.util.Log.d(r12, r13)     // Catch:{ all -> 0x0126 }
            if (r11 > r0) goto L_0x0060
            if (r10 > r2) goto L_0x0060
            if (r11 < r8) goto L_0x0060
            if (r10 < r9) goto L_0x0060
            float r12 = (float) r11     // Catch:{ all -> 0x0126 }
            float r13 = (float) r10     // Catch:{ all -> 0x0126 }
            float r12 = r12 / r13
            float r12 = r5 - r12
            float r12 = java.lang.Math.abs(r12)     // Catch:{ all -> 0x0126 }
            double r12 = (double) r12     // Catch:{ all -> 0x0126 }
            r14 = 4596373779694328218(0x3fc999999999999a, double:0.2)
            int r16 = (r12 > r14 ? 1 : (r12 == r14 ? 0 : -1))
            if (r16 >= 0) goto L_0x0060
            r9 = r10
            r8 = r11
            goto L_0x0060
        L_0x00ac:
            if (r8 <= 0) goto L_0x00d0
            if (r9 > 0) goto L_0x00b1
            goto L_0x00d0
        L_0x00b1:
            java.lang.String r0 = "CameraRenderer"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0126 }
            r2.<init>()     // Catch:{ all -> 0x0126 }
            java.lang.String r4 = "Selected best size: "
            r2.append(r4)     // Catch:{ all -> 0x0126 }
            r2.append(r8)     // Catch:{ all -> 0x0126 }
            java.lang.String r4 = " x "
            r2.append(r4)     // Catch:{ all -> 0x0126 }
            r2.append(r9)     // Catch:{ all -> 0x0126 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0126 }
            android.util.Log.i(r0, r2)     // Catch:{ all -> 0x0126 }
            goto L_0x00fe
        L_0x00d0:
            java.lang.Object r0 = r4.get(r7)     // Catch:{ all -> 0x0126 }
            android.hardware.Camera$Size r0 = (android.hardware.Camera.Size) r0     // Catch:{ all -> 0x0126 }
            int r8 = r0.width     // Catch:{ all -> 0x0126 }
            java.lang.Object r0 = r4.get(r7)     // Catch:{ all -> 0x0126 }
            android.hardware.Camera$Size r0 = (android.hardware.Camera.Size) r0     // Catch:{ all -> 0x0126 }
            int r9 = r0.height     // Catch:{ all -> 0x0126 }
            java.lang.String r0 = "CameraRenderer"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x0126 }
            r2.<init>()     // Catch:{ all -> 0x0126 }
            java.lang.String r4 = "Error: best size was not selected, using "
            r2.append(r4)     // Catch:{ all -> 0x0126 }
            r2.append(r8)     // Catch:{ all -> 0x0126 }
            java.lang.String r4 = " x "
            r2.append(r4)     // Catch:{ all -> 0x0126 }
            r2.append(r9)     // Catch:{ all -> 0x0126 }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x0126 }
            android.util.Log.e(r0, r2)     // Catch:{ all -> 0x0126 }
        L_0x00fe:
            boolean r0 = r1.f34043q     // Catch:{ all -> 0x0126 }
            if (r0 == 0) goto L_0x0109
            android.hardware.Camera r0 = r1.f34042a     // Catch:{ all -> 0x0126 }
            r0.stopPreview()     // Catch:{ all -> 0x0126 }
            r1.f34043q = r7     // Catch:{ all -> 0x0126 }
        L_0x0109:
            r1.f34018c = r8     // Catch:{ all -> 0x0126 }
            r1.f34019d = r9     // Catch:{ all -> 0x0126 }
            r3.setPreviewSize(r8, r9)     // Catch:{ all -> 0x0126 }
        L_0x0110:
            java.lang.String r0 = "orientation"
            java.lang.String r2 = "landscape"
            r3.set(r0, r2)     // Catch:{ all -> 0x0126 }
            android.hardware.Camera r0 = r1.f34042a     // Catch:{ all -> 0x0126 }
            r0.setParameters(r3)     // Catch:{ all -> 0x0126 }
            android.hardware.Camera r0 = r1.f34042a     // Catch:{ all -> 0x0126 }
            r0.startPreview()     // Catch:{ all -> 0x0126 }
            r0 = 1
            r1.f34043q = r0     // Catch:{ all -> 0x0126 }
            monitor-exit(r17)
            return
        L_0x0126:
            r0 = move-exception
            monitor-exit(r17)
            goto L_0x012a
        L_0x0129:
            throw r0
        L_0x012a:
            goto L_0x0129
        */
        throw new UnsupportedOperationException("Method not decompiled: org.opencv.android.d.b(int, int):void");
    }

    /* access modifiers changed from: protected */
    public synchronized void c() {
        Log.i("CameraRenderer", "closeCamera");
        Camera camera = this.f34042a;
        if (camera != null) {
            camera.stopPreview();
            this.f34043q = false;
            this.f34042a.release();
            this.f34042a = null;
        }
    }
}
