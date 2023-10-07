package org.opencv.android;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.util.AttributeSet;
import android.util.Log;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class JavaCameraView extends CameraBridgeViewBase implements Camera.PreviewCallback {

    /* renamed from: k  reason: collision with root package name */
    protected Camera f33972k;

    /* renamed from: l  reason: collision with root package name */
    protected b[] f33973l;

    /* renamed from: m  reason: collision with root package name */
    private byte[] f33974m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public Mat[] f33975n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public int f33976o = 0;

    /* renamed from: p  reason: collision with root package name */
    private Thread f33977p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public boolean f33978q;

    /* renamed from: r  reason: collision with root package name */
    private SurfaceTexture f33979r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public int f33980s = 17;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public boolean f33981t = false;

    private class a implements Runnable {
        private a() {
        }

        public void run() {
            boolean z2;
            do {
                synchronized (JavaCameraView.this) {
                    while (!JavaCameraView.this.f33981t && !JavaCameraView.this.f33978q) {
                        try {
                            JavaCameraView.this.wait();
                        } catch (InterruptedException e2) {
                            e2.printStackTrace();
                        }
                    }
                    z2 = false;
                    if (JavaCameraView.this.f33981t) {
                        JavaCameraView javaCameraView = JavaCameraView.this;
                        int unused = javaCameraView.f33976o = 1 - javaCameraView.f33976o;
                        boolean unused2 = JavaCameraView.this.f33981t = false;
                        z2 = true;
                    }
                }
                if (!JavaCameraView.this.f33978q && z2 && !JavaCameraView.this.f33975n[1 - JavaCameraView.this.f33976o].d()) {
                    JavaCameraView javaCameraView2 = JavaCameraView.this;
                    javaCameraView2.a((CameraBridgeViewBase.a) javaCameraView2.f33973l[1 - JavaCameraView.this.f33976o]);
                }
            } while (!JavaCameraView.this.f33978q);
            Log.d("JavaCameraView", "Finish processing thread");
        }
    }

    private class b implements CameraBridgeViewBase.a {

        /* renamed from: b  reason: collision with root package name */
        private Mat f33984b;

        /* renamed from: c  reason: collision with root package name */
        private Mat f33985c = new Mat();

        /* renamed from: d  reason: collision with root package name */
        private int f33986d;

        /* renamed from: e  reason: collision with root package name */
        private int f33987e;

        public b(Mat mat, int i2, int i3) {
            this.f33986d = i2;
            this.f33987e = i3;
            this.f33984b = mat;
        }

        public Mat a() {
            Mat mat;
            Mat mat2;
            int i2;
            if (JavaCameraView.this.f33980s == 17) {
                mat = this.f33984b;
                mat2 = this.f33985c;
                i2 = 96;
            } else if (JavaCameraView.this.f33980s == 842094169) {
                mat = this.f33984b;
                mat2 = this.f33985c;
                i2 = 100;
            } else {
                throw new IllegalArgumentException("Preview Format can be NV21 or YV12");
            }
            Imgproc.a(mat, mat2, i2, 4);
            return this.f33985c;
        }

        public Mat b() {
            return this.f33984b.a(0, this.f33987e, 0, this.f33986d);
        }

        public void c() {
            this.f33985c.g();
        }
    }

    public static class c implements CameraBridgeViewBase.e {
        public int a(Object obj) {
            return ((Camera.Size) obj).width;
        }

        public int b(Object obj) {
            return ((Camera.Size) obj).height;
        }
    }

    public JavaCameraView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    /* access modifiers changed from: protected */
    public boolean a(int i2, int i3) {
        Log.d("JavaCameraView", "Connecting to camera");
        if (!b(i2, i3)) {
            return false;
        }
        this.f33981t = false;
        Log.d("JavaCameraView", "Starting processing thread");
        this.f33978q = false;
        Thread thread = new Thread(new a());
        this.f33977p = thread;
        thread.start();
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:105:0x025a A[Catch:{ Exception -> 0x0313 }] */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x026b A[Catch:{ Exception -> 0x0313 }] */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0272 A[Catch:{ Exception -> 0x0313 }] */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x02f1 A[Catch:{ Exception -> 0x0313 }] */
    /* JADX WARNING: Removed duplicated region for block: B:113:0x0300 A[Catch:{ Exception -> 0x0313 }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x00ef A[Catch:{ Exception -> 0x0022 }] */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x00f7 A[Catch:{ Exception -> 0x0022 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean b(int r11, int r12) {
        /*
            r10 = this;
            java.lang.String r0 = "JavaCameraView"
            java.lang.String r1 = "Initialize java camera"
            android.util.Log.d(r0, r1)
            monitor-enter(r10)
            r0 = 0
            r10.f33972k = r0     // Catch:{ all -> 0x0319 }
            int r1 = r10.f33937g     // Catch:{ all -> 0x0319 }
            r2 = 9
            r3 = -1
            r4 = 0
            r5 = 1
            if (r1 != r3) goto L_0x009e
            java.lang.String r1 = "JavaCameraView"
            java.lang.String r6 = "Trying to open camera with old open()"
            android.util.Log.d(r1, r6)     // Catch:{ all -> 0x0319 }
            android.hardware.Camera r1 = android.hardware.Camera.open()     // Catch:{ Exception -> 0x0022 }
            r10.f33972k = r1     // Catch:{ Exception -> 0x0022 }
            goto L_0x003d
        L_0x0022:
            r1 = move-exception
            java.lang.String r6 = "JavaCameraView"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0319 }
            r7.<init>()     // Catch:{ all -> 0x0319 }
            java.lang.String r8 = "Camera is not available (in use or does not exist): "
            r7.append(r8)     // Catch:{ all -> 0x0319 }
            java.lang.String r1 = r1.getLocalizedMessage()     // Catch:{ all -> 0x0319 }
            r7.append(r1)     // Catch:{ all -> 0x0319 }
            java.lang.String r1 = r7.toString()     // Catch:{ all -> 0x0319 }
            android.util.Log.e(r6, r1)     // Catch:{ all -> 0x0319 }
        L_0x003d:
            android.hardware.Camera r1 = r10.f33972k     // Catch:{ all -> 0x0319 }
            if (r1 != 0) goto L_0x0147
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0319 }
            if (r1 < r2) goto L_0x0147
            r1 = 0
            r2 = 0
        L_0x0047:
            int r6 = android.hardware.Camera.getNumberOfCameras()     // Catch:{ all -> 0x0319 }
            if (r1 >= r6) goto L_0x0147
            java.lang.String r6 = "JavaCameraView"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0319 }
            r7.<init>()     // Catch:{ all -> 0x0319 }
            java.lang.String r8 = "Trying to open camera with new open("
            r7.append(r8)     // Catch:{ all -> 0x0319 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0319 }
            r7.append(r8)     // Catch:{ all -> 0x0319 }
            java.lang.String r8 = ")"
            r7.append(r8)     // Catch:{ all -> 0x0319 }
            java.lang.String r7 = r7.toString()     // Catch:{ all -> 0x0319 }
            android.util.Log.d(r6, r7)     // Catch:{ all -> 0x0319 }
            android.hardware.Camera r6 = android.hardware.Camera.open(r1)     // Catch:{ RuntimeException -> 0x0074 }
            r10.f33972k = r6     // Catch:{ RuntimeException -> 0x0074 }
            r2 = 1
            goto L_0x0097
        L_0x0074:
            r6 = move-exception
            java.lang.String r7 = "JavaCameraView"
            java.lang.StringBuilder r8 = new java.lang.StringBuilder     // Catch:{ all -> 0x0319 }
            r8.<init>()     // Catch:{ all -> 0x0319 }
            java.lang.String r9 = "Camera #"
            r8.append(r9)     // Catch:{ all -> 0x0319 }
            r8.append(r1)     // Catch:{ all -> 0x0319 }
            java.lang.String r9 = "failed to open: "
            r8.append(r9)     // Catch:{ all -> 0x0319 }
            java.lang.String r6 = r6.getLocalizedMessage()     // Catch:{ all -> 0x0319 }
            r8.append(r6)     // Catch:{ all -> 0x0319 }
            java.lang.String r6 = r8.toString()     // Catch:{ all -> 0x0319 }
            android.util.Log.e(r7, r6)     // Catch:{ all -> 0x0319 }
        L_0x0097:
            if (r2 == 0) goto L_0x009b
            goto L_0x0147
        L_0x009b:
            int r1 = r1 + 1
            goto L_0x0047
        L_0x009e:
            int r1 = android.os.Build.VERSION.SDK_INT     // Catch:{ all -> 0x0319 }
            if (r1 < r2) goto L_0x0147
            int r1 = r10.f33937g     // Catch:{ all -> 0x0319 }
            int r2 = r10.f33937g     // Catch:{ all -> 0x0319 }
            r6 = 98
            r7 = 99
            if (r2 != r7) goto L_0x00ca
            java.lang.String r2 = "JavaCameraView"
            java.lang.String r8 = "Trying to open back camera"
            android.util.Log.i(r2, r8)     // Catch:{ all -> 0x0319 }
            android.hardware.Camera$CameraInfo r2 = new android.hardware.Camera$CameraInfo     // Catch:{ all -> 0x0319 }
            r2.<init>()     // Catch:{ all -> 0x0319 }
            r8 = 0
        L_0x00b9:
            int r9 = android.hardware.Camera.getNumberOfCameras()     // Catch:{ all -> 0x0319 }
            if (r8 >= r9) goto L_0x00ed
            android.hardware.Camera.getCameraInfo(r8, r2)     // Catch:{ all -> 0x0319 }
            int r9 = r2.facing     // Catch:{ all -> 0x0319 }
            if (r9 != 0) goto L_0x00c7
            goto L_0x00e8
        L_0x00c7:
            int r8 = r8 + 1
            goto L_0x00b9
        L_0x00ca:
            int r2 = r10.f33937g     // Catch:{ all -> 0x0319 }
            if (r2 != r6) goto L_0x00ed
            java.lang.String r2 = "JavaCameraView"
            java.lang.String r8 = "Trying to open front camera"
            android.util.Log.i(r2, r8)     // Catch:{ all -> 0x0319 }
            android.hardware.Camera$CameraInfo r2 = new android.hardware.Camera$CameraInfo     // Catch:{ all -> 0x0319 }
            r2.<init>()     // Catch:{ all -> 0x0319 }
            r8 = 0
        L_0x00db:
            int r9 = android.hardware.Camera.getNumberOfCameras()     // Catch:{ all -> 0x0319 }
            if (r8 >= r9) goto L_0x00ed
            android.hardware.Camera.getCameraInfo(r8, r2)     // Catch:{ all -> 0x0319 }
            int r9 = r2.facing     // Catch:{ all -> 0x0319 }
            if (r9 != r5) goto L_0x00ea
        L_0x00e8:
            r1 = r8
            goto L_0x00ed
        L_0x00ea:
            int r8 = r8 + 1
            goto L_0x00db
        L_0x00ed:
            if (r1 != r7) goto L_0x00f7
            java.lang.String r1 = "JavaCameraView"
            java.lang.String r2 = "Back camera not found!"
        L_0x00f3:
            android.util.Log.e(r1, r2)     // Catch:{ all -> 0x0319 }
            goto L_0x0147
        L_0x00f7:
            if (r1 != r6) goto L_0x00fe
            java.lang.String r1 = "JavaCameraView"
            java.lang.String r2 = "Front camera not found!"
            goto L_0x00f3
        L_0x00fe:
            java.lang.String r2 = "JavaCameraView"
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x0319 }
            r6.<init>()     // Catch:{ all -> 0x0319 }
            java.lang.String r7 = "Trying to open camera with new open("
            r6.append(r7)     // Catch:{ all -> 0x0319 }
            java.lang.Integer r7 = java.lang.Integer.valueOf(r1)     // Catch:{ all -> 0x0319 }
            r6.append(r7)     // Catch:{ all -> 0x0319 }
            java.lang.String r7 = ")"
            r6.append(r7)     // Catch:{ all -> 0x0319 }
            java.lang.String r6 = r6.toString()     // Catch:{ all -> 0x0319 }
            android.util.Log.d(r2, r6)     // Catch:{ all -> 0x0319 }
            android.hardware.Camera r2 = android.hardware.Camera.open(r1)     // Catch:{ RuntimeException -> 0x0124 }
            r10.f33972k = r2     // Catch:{ RuntimeException -> 0x0124 }
            goto L_0x0147
        L_0x0124:
            r2 = move-exception
            java.lang.String r6 = "JavaCameraView"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x0319 }
            r7.<init>()     // Catch:{ all -> 0x0319 }
            java.lang.String r8 = "Camera #"
            r7.append(r8)     // Catch:{ all -> 0x0319 }
            r7.append(r1)     // Catch:{ all -> 0x0319 }
            java.lang.String r1 = "failed to open: "
            r7.append(r1)     // Catch:{ all -> 0x0319 }
            java.lang.String r1 = r2.getLocalizedMessage()     // Catch:{ all -> 0x0319 }
            r7.append(r1)     // Catch:{ all -> 0x0319 }
            java.lang.String r1 = r7.toString()     // Catch:{ all -> 0x0319 }
            android.util.Log.e(r6, r1)     // Catch:{ all -> 0x0319 }
        L_0x0147:
            android.hardware.Camera r1 = r10.f33972k     // Catch:{ all -> 0x0319 }
            if (r1 != 0) goto L_0x014d
            monitor-exit(r10)     // Catch:{ all -> 0x0319 }
            return r4
        L_0x014d:
            android.hardware.Camera$Parameters r1 = r1.getParameters()     // Catch:{ Exception -> 0x0313 }
            java.lang.String r2 = "JavaCameraView"
            java.lang.String r6 = "getSupportedPreviewSizes()"
            android.util.Log.d(r2, r6)     // Catch:{ Exception -> 0x0313 }
            java.util.List r2 = r1.getSupportedPreviewSizes()     // Catch:{ Exception -> 0x0313 }
            if (r2 == 0) goto L_0x0317
            org.opencv.android.JavaCameraView$c r6 = new org.opencv.android.JavaCameraView$c     // Catch:{ Exception -> 0x0313 }
            r6.<init>()     // Catch:{ Exception -> 0x0313 }
            org.opencv.core.b r2 = r10.a(r2, r6, r11, r12)     // Catch:{ Exception -> 0x0313 }
            java.lang.String r6 = android.os.Build.FINGERPRINT     // Catch:{ Exception -> 0x0313 }
            java.lang.String r7 = "generic"
            boolean r6 = r6.startsWith(r7)     // Catch:{ Exception -> 0x0313 }
            if (r6 != 0) goto L_0x01c8
            java.lang.String r6 = android.os.Build.FINGERPRINT     // Catch:{ Exception -> 0x0313 }
            java.lang.String r7 = "unknown"
            boolean r6 = r6.startsWith(r7)     // Catch:{ Exception -> 0x0313 }
            if (r6 != 0) goto L_0x01c8
            java.lang.String r6 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0313 }
            java.lang.String r7 = "google_sdk"
            boolean r6 = r6.contains(r7)     // Catch:{ Exception -> 0x0313 }
            if (r6 != 0) goto L_0x01c8
            java.lang.String r6 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0313 }
            java.lang.String r7 = "Emulator"
            boolean r6 = r6.contains(r7)     // Catch:{ Exception -> 0x0313 }
            if (r6 != 0) goto L_0x01c8
            java.lang.String r6 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0313 }
            java.lang.String r7 = "Android SDK built for x86"
            boolean r6 = r6.contains(r7)     // Catch:{ Exception -> 0x0313 }
            if (r6 != 0) goto L_0x01c8
            java.lang.String r6 = android.os.Build.MANUFACTURER     // Catch:{ Exception -> 0x0313 }
            java.lang.String r7 = "Genymotion"
            boolean r6 = r6.contains(r7)     // Catch:{ Exception -> 0x0313 }
            if (r6 != 0) goto L_0x01c8
            java.lang.String r6 = android.os.Build.BRAND     // Catch:{ Exception -> 0x0313 }
            java.lang.String r7 = "generic"
            boolean r6 = r6.startsWith(r7)     // Catch:{ Exception -> 0x0313 }
            if (r6 == 0) goto L_0x01b7
            java.lang.String r6 = android.os.Build.DEVICE     // Catch:{ Exception -> 0x0313 }
            java.lang.String r7 = "generic"
            boolean r6 = r6.startsWith(r7)     // Catch:{ Exception -> 0x0313 }
            if (r6 != 0) goto L_0x01c8
        L_0x01b7:
            java.lang.String r6 = "google_sdk"
            java.lang.String r7 = android.os.Build.PRODUCT     // Catch:{ Exception -> 0x0313 }
            boolean r6 = r6.equals(r7)     // Catch:{ Exception -> 0x0313 }
            if (r6 == 0) goto L_0x01c2
            goto L_0x01c8
        L_0x01c2:
            r6 = 17
            r1.setPreviewFormat(r6)     // Catch:{ Exception -> 0x0313 }
            goto L_0x01ce
        L_0x01c8:
            r6 = 842094169(0x32315659, float:1.0322389E-8)
            r1.setPreviewFormat(r6)     // Catch:{ Exception -> 0x0313 }
        L_0x01ce:
            int r6 = r1.getPreviewFormat()     // Catch:{ Exception -> 0x0313 }
            r10.f33980s = r6     // Catch:{ Exception -> 0x0313 }
            java.lang.String r6 = "JavaCameraView"
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0313 }
            r7.<init>()     // Catch:{ Exception -> 0x0313 }
            java.lang.String r8 = "Set preview size to "
            r7.append(r8)     // Catch:{ Exception -> 0x0313 }
            double r8 = r2.f34088a     // Catch:{ Exception -> 0x0313 }
            int r8 = (int) r8     // Catch:{ Exception -> 0x0313 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0313 }
            r7.append(r8)     // Catch:{ Exception -> 0x0313 }
            java.lang.String r8 = "x"
            r7.append(r8)     // Catch:{ Exception -> 0x0313 }
            double r8 = r2.f34089b     // Catch:{ Exception -> 0x0313 }
            int r8 = (int) r8     // Catch:{ Exception -> 0x0313 }
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ Exception -> 0x0313 }
            r7.append(r8)     // Catch:{ Exception -> 0x0313 }
            java.lang.String r7 = r7.toString()     // Catch:{ Exception -> 0x0313 }
            android.util.Log.d(r6, r7)     // Catch:{ Exception -> 0x0313 }
            double r6 = r2.f34088a     // Catch:{ Exception -> 0x0313 }
            int r6 = (int) r6     // Catch:{ Exception -> 0x0313 }
            double r7 = r2.f34089b     // Catch:{ Exception -> 0x0313 }
            int r2 = (int) r7     // Catch:{ Exception -> 0x0313 }
            r1.setPreviewSize(r6, r2)     // Catch:{ Exception -> 0x0313 }
            int r2 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0313 }
            r6 = 14
            if (r2 < r6) goto L_0x021c
            java.lang.String r2 = android.os.Build.MODEL     // Catch:{ Exception -> 0x0313 }
            java.lang.String r6 = "GT-I9100"
            boolean r2 = r2.equals(r6)     // Catch:{ Exception -> 0x0313 }
            if (r2 != 0) goto L_0x021c
            r1.setRecordingHint(r5)     // Catch:{ Exception -> 0x0313 }
        L_0x021c:
            java.util.List r2 = r1.getSupportedFocusModes()     // Catch:{ Exception -> 0x0313 }
            if (r2 == 0) goto L_0x022f
            java.lang.String r6 = "continuous-video"
            boolean r2 = r2.contains(r6)     // Catch:{ Exception -> 0x0313 }
            if (r2 == 0) goto L_0x022f
            java.lang.String r2 = "continuous-video"
            r1.setFocusMode(r2)     // Catch:{ Exception -> 0x0313 }
        L_0x022f:
            android.hardware.Camera r2 = r10.f33972k     // Catch:{ Exception -> 0x0313 }
            r2.setParameters(r1)     // Catch:{ Exception -> 0x0313 }
            android.hardware.Camera r1 = r10.f33972k     // Catch:{ Exception -> 0x0313 }
            android.hardware.Camera$Parameters r1 = r1.getParameters()     // Catch:{ Exception -> 0x0313 }
            android.hardware.Camera$Size r2 = r1.getPreviewSize()     // Catch:{ Exception -> 0x0313 }
            int r2 = r2.width     // Catch:{ Exception -> 0x0313 }
            r10.f33931a = r2     // Catch:{ Exception -> 0x0313 }
            android.hardware.Camera$Size r2 = r1.getPreviewSize()     // Catch:{ Exception -> 0x0313 }
            int r2 = r2.height     // Catch:{ Exception -> 0x0313 }
            r10.f33932b = r2     // Catch:{ Exception -> 0x0313 }
            android.view.ViewGroup$LayoutParams r2 = r10.getLayoutParams()     // Catch:{ Exception -> 0x0313 }
            int r2 = r2.width     // Catch:{ Exception -> 0x0313 }
            if (r2 != r3) goto L_0x026b
            android.view.ViewGroup$LayoutParams r2 = r10.getLayoutParams()     // Catch:{ Exception -> 0x0313 }
            int r2 = r2.height     // Catch:{ Exception -> 0x0313 }
            if (r2 != r3) goto L_0x026b
            float r12 = (float) r12     // Catch:{ Exception -> 0x0313 }
            int r2 = r10.f33932b     // Catch:{ Exception -> 0x0313 }
            float r2 = (float) r2     // Catch:{ Exception -> 0x0313 }
            float r12 = r12 / r2
            float r11 = (float) r11     // Catch:{ Exception -> 0x0313 }
            int r2 = r10.f33931a     // Catch:{ Exception -> 0x0313 }
            float r2 = (float) r2     // Catch:{ Exception -> 0x0313 }
            float r11 = r11 / r2
            float r11 = java.lang.Math.min(r12, r11)     // Catch:{ Exception -> 0x0313 }
            r10.f33935e = r11     // Catch:{ Exception -> 0x0313 }
            goto L_0x026e
        L_0x026b:
            r11 = 0
            r10.f33935e = r11     // Catch:{ Exception -> 0x0313 }
        L_0x026e:
            org.opencv.android.e r11 = r10.f33940j     // Catch:{ Exception -> 0x0313 }
            if (r11 == 0) goto L_0x027b
            org.opencv.android.e r11 = r10.f33940j     // Catch:{ Exception -> 0x0313 }
            int r12 = r10.f33931a     // Catch:{ Exception -> 0x0313 }
            int r2 = r10.f33932b     // Catch:{ Exception -> 0x0313 }
            r11.a(r12, r2)     // Catch:{ Exception -> 0x0313 }
        L_0x027b:
            int r11 = r10.f33931a     // Catch:{ Exception -> 0x0313 }
            int r12 = r10.f33932b     // Catch:{ Exception -> 0x0313 }
            int r11 = r11 * r12
            int r12 = r1.getPreviewFormat()     // Catch:{ Exception -> 0x0313 }
            int r12 = android.graphics.ImageFormat.getBitsPerPixel(r12)     // Catch:{ Exception -> 0x0313 }
            int r11 = r11 * r12
            int r11 = r11 / 8
            byte[] r11 = new byte[r11]     // Catch:{ Exception -> 0x0313 }
            r10.f33974m = r11     // Catch:{ Exception -> 0x0313 }
            android.hardware.Camera r12 = r10.f33972k     // Catch:{ Exception -> 0x0313 }
            r12.addCallbackBuffer(r11)     // Catch:{ Exception -> 0x0313 }
            android.hardware.Camera r11 = r10.f33972k     // Catch:{ Exception -> 0x0313 }
            r11.setPreviewCallbackWithBuffer(r10)     // Catch:{ Exception -> 0x0313 }
            r11 = 2
            org.opencv.core.Mat[] r12 = new org.opencv.core.Mat[r11]     // Catch:{ Exception -> 0x0313 }
            r10.f33975n = r12     // Catch:{ Exception -> 0x0313 }
            org.opencv.core.Mat r1 = new org.opencv.core.Mat     // Catch:{ Exception -> 0x0313 }
            int r2 = r10.f33932b     // Catch:{ Exception -> 0x0313 }
            int r3 = r10.f33932b     // Catch:{ Exception -> 0x0313 }
            int r3 = r3 / r11
            int r2 = r2 + r3
            int r3 = r10.f33931a     // Catch:{ Exception -> 0x0313 }
            int r6 = org.opencv.core.a.f34062a     // Catch:{ Exception -> 0x0313 }
            r1.<init>(r2, r3, r6)     // Catch:{ Exception -> 0x0313 }
            r12[r4] = r1     // Catch:{ Exception -> 0x0313 }
            org.opencv.core.Mat[] r12 = r10.f33975n     // Catch:{ Exception -> 0x0313 }
            org.opencv.core.Mat r1 = new org.opencv.core.Mat     // Catch:{ Exception -> 0x0313 }
            int r2 = r10.f33932b     // Catch:{ Exception -> 0x0313 }
            int r3 = r10.f33932b     // Catch:{ Exception -> 0x0313 }
            int r3 = r3 / r11
            int r2 = r2 + r3
            int r3 = r10.f33931a     // Catch:{ Exception -> 0x0313 }
            int r6 = org.opencv.core.a.f34062a     // Catch:{ Exception -> 0x0313 }
            r1.<init>(r2, r3, r6)     // Catch:{ Exception -> 0x0313 }
            r12[r5] = r1     // Catch:{ Exception -> 0x0313 }
            r10.d()     // Catch:{ Exception -> 0x0313 }
            org.opencv.android.JavaCameraView$b[] r11 = new org.opencv.android.JavaCameraView.b[r11]     // Catch:{ Exception -> 0x0313 }
            r10.f33973l = r11     // Catch:{ Exception -> 0x0313 }
            org.opencv.android.JavaCameraView$b r12 = new org.opencv.android.JavaCameraView$b     // Catch:{ Exception -> 0x0313 }
            org.opencv.core.Mat[] r1 = r10.f33975n     // Catch:{ Exception -> 0x0313 }
            r1 = r1[r4]     // Catch:{ Exception -> 0x0313 }
            int r2 = r10.f33931a     // Catch:{ Exception -> 0x0313 }
            int r3 = r10.f33932b     // Catch:{ Exception -> 0x0313 }
            r12.<init>(r1, r2, r3)     // Catch:{ Exception -> 0x0313 }
            r11[r4] = r12     // Catch:{ Exception -> 0x0313 }
            org.opencv.android.JavaCameraView$b[] r11 = r10.f33973l     // Catch:{ Exception -> 0x0313 }
            org.opencv.android.JavaCameraView$b r12 = new org.opencv.android.JavaCameraView$b     // Catch:{ Exception -> 0x0313 }
            org.opencv.core.Mat[] r1 = r10.f33975n     // Catch:{ Exception -> 0x0313 }
            r1 = r1[r5]     // Catch:{ Exception -> 0x0313 }
            int r2 = r10.f33931a     // Catch:{ Exception -> 0x0313 }
            int r3 = r10.f33932b     // Catch:{ Exception -> 0x0313 }
            r12.<init>(r1, r2, r3)     // Catch:{ Exception -> 0x0313 }
            r11[r5] = r12     // Catch:{ Exception -> 0x0313 }
            int r11 = android.os.Build.VERSION.SDK_INT     // Catch:{ Exception -> 0x0313 }
            r12 = 11
            if (r11 < r12) goto L_0x0300
            android.graphics.SurfaceTexture r11 = new android.graphics.SurfaceTexture     // Catch:{ Exception -> 0x0313 }
            r12 = 10
            r11.<init>(r12)     // Catch:{ Exception -> 0x0313 }
            r10.f33979r = r11     // Catch:{ Exception -> 0x0313 }
            android.hardware.Camera r12 = r10.f33972k     // Catch:{ Exception -> 0x0313 }
            r12.setPreviewTexture(r11)     // Catch:{ Exception -> 0x0313 }
            goto L_0x0305
        L_0x0300:
            android.hardware.Camera r11 = r10.f33972k     // Catch:{ Exception -> 0x0313 }
            r11.setPreviewDisplay(r0)     // Catch:{ Exception -> 0x0313 }
        L_0x0305:
            java.lang.String r11 = "JavaCameraView"
            java.lang.String r12 = "startPreview"
            android.util.Log.d(r11, r12)     // Catch:{ Exception -> 0x0313 }
            android.hardware.Camera r11 = r10.f33972k     // Catch:{ Exception -> 0x0313 }
            r11.startPreview()     // Catch:{ Exception -> 0x0313 }
            r4 = 1
            goto L_0x0317
        L_0x0313:
            r11 = move-exception
            r11.printStackTrace()     // Catch:{ all -> 0x0319 }
        L_0x0317:
            monitor-exit(r10)     // Catch:{ all -> 0x0319 }
            return r4
        L_0x0319:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0319 }
            goto L_0x031d
        L_0x031c:
            throw r11
        L_0x031d:
            goto L_0x031c
        */
        throw new UnsupportedOperationException("Method not decompiled: org.opencv.android.JavaCameraView.b(int, int):boolean");
    }

    /* access modifiers changed from: protected */
    public void c() {
        Log.d("JavaCameraView", "Disconnecting from camera");
        try {
            this.f33978q = true;
            Log.d("JavaCameraView", "Notify thread");
            synchronized (this) {
                notify();
            }
            Log.d("JavaCameraView", "Waiting for thread");
            Thread thread = this.f33977p;
            if (thread != null) {
                thread.join();
            }
        } catch (InterruptedException e2) {
            try {
                e2.printStackTrace();
            } catch (Throwable th) {
                this.f33977p = null;
                throw th;
            }
        }
        this.f33977p = null;
        e();
        this.f33981t = false;
    }

    /* access modifiers changed from: protected */
    public void e() {
        synchronized (this) {
            Camera camera = this.f33972k;
            if (camera != null) {
                camera.stopPreview();
                this.f33972k.setPreviewCallback((Camera.PreviewCallback) null);
                this.f33972k.release();
            }
            this.f33972k = null;
            Mat[] matArr = this.f33975n;
            if (matArr != null) {
                matArr[0].g();
                this.f33975n[1].g();
            }
            b[] bVarArr = this.f33973l;
            if (bVarArr != null) {
                bVarArr[0].c();
                this.f33973l[1].c();
            }
        }
    }

    public void onPreviewFrame(byte[] bArr, Camera camera) {
        synchronized (this) {
            this.f33975n[this.f33976o].a(0, 0, bArr);
            this.f33981t = true;
            notify();
        }
        Camera camera2 = this.f33972k;
        if (camera2 != null) {
            camera2.addCallbackBuffer(this.f33974m);
        }
    }
}
