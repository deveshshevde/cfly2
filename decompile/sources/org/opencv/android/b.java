package org.opencv.android;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import java.util.Arrays;
import java.util.concurrent.Semaphore;

public class b extends c {

    /* renamed from: a  reason: collision with root package name */
    protected final String f34004a = "Camera2Renderer";
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public CameraDevice f34005q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public CameraCaptureSession f34006r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public CaptureRequest.Builder f34007s;

    /* renamed from: t  reason: collision with root package name */
    private String f34008t;

    /* renamed from: u  reason: collision with root package name */
    private Size f34009u = new Size(-1, -1);

    /* renamed from: v  reason: collision with root package name */
    private HandlerThread f34010v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public Handler f34011w;
    /* access modifiers changed from: private */

    /* renamed from: x  reason: collision with root package name */
    public Semaphore f34012x = new Semaphore(1);

    /* renamed from: y  reason: collision with root package name */
    private final CameraDevice.StateCallback f34013y = new CameraDevice.StateCallback() {
        public void onDisconnected(CameraDevice cameraDevice) {
            cameraDevice.close();
            CameraDevice unused = b.this.f34005q = null;
            b.this.f34012x.release();
        }

        public void onError(CameraDevice cameraDevice, int i2) {
            cameraDevice.close();
            CameraDevice unused = b.this.f34005q = null;
            b.this.f34012x.release();
        }

        public void onOpened(CameraDevice cameraDevice) {
            CameraDevice unused = b.this.f34005q = cameraDevice;
            b.this.f34012x.release();
            b.this.i();
        }
    };

    b(CameraGLSurfaceView cameraGLSurfaceView) {
        super(cameraGLSurfaceView);
    }

    /* access modifiers changed from: private */
    public void i() {
        int width = this.f34009u.getWidth();
        int height = this.f34009u.getHeight();
        Log.i("Camera2Renderer", "createCameraPreviewSession(" + width + "x" + height + ")");
        if (width >= 0 && height >= 0) {
            try {
                this.f34012x.acquire();
                if (this.f34005q == null) {
                    this.f34012x.release();
                    Log.e("Camera2Renderer", "createCameraPreviewSession: camera isn't opened");
                } else if (this.f34006r != null) {
                    this.f34012x.release();
                    Log.e("Camera2Renderer", "createCameraPreviewSession: mCaptureSession is already started");
                } else if (this.f34025j == null) {
                    this.f34012x.release();
                    Log.e("Camera2Renderer", "createCameraPreviewSession: preview SurfaceTexture is null");
                } else {
                    this.f34025j.setDefaultBufferSize(width, height);
                    Surface surface = new Surface(this.f34025j);
                    CaptureRequest.Builder createCaptureRequest = this.f34005q.createCaptureRequest(1);
                    this.f34007s = createCaptureRequest;
                    createCaptureRequest.addTarget(surface);
                    this.f34005q.createCaptureSession(Arrays.asList(new Surface[]{surface}), new CameraCaptureSession.StateCallback() {
                        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                            Log.e("Camera2Renderer", "createCameraPreviewSession failed");
                            b.this.f34012x.release();
                        }

                        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                            CameraCaptureSession unused = b.this.f34006r = cameraCaptureSession;
                            try {
                                b.this.f34007s.set(CaptureRequest.CONTROL_AF_MODE, 4);
                                b.this.f34007s.set(CaptureRequest.CONTROL_AE_MODE, 2);
                                b.this.f34006r.setRepeatingRequest(b.this.f34007s.build(), (CameraCaptureSession.CaptureCallback) null, b.this.f34011w);
                                Log.i("Camera2Renderer", "CameraPreviewSession has been started");
                            } catch (CameraAccessException unused2) {
                                Log.e("Camera2Renderer", "createCaptureSession failed");
                            }
                            b.this.f34012x.release();
                        }
                    }, this.f34011w);
                }
            } catch (CameraAccessException unused) {
                Log.e("Camera2Renderer", "createCameraPreviewSession");
            } catch (InterruptedException e2) {
                throw new RuntimeException("Interrupted while createCameraPreviewSession", e2);
            }
        }
    }

    private void j() {
        Log.i("Camera2Renderer", "startBackgroundThread");
        k();
        HandlerThread handlerThread = new HandlerThread("CameraBackground");
        this.f34010v = handlerThread;
        handlerThread.start();
        this.f34011w = new Handler(this.f34010v.getLooper());
    }

    private void k() {
        Log.i("Camera2Renderer", "stopBackgroundThread");
        HandlerThread handlerThread = this.f34010v;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            try {
                this.f34010v.join();
                this.f34010v = null;
                this.f34011w = null;
            } catch (InterruptedException unused) {
                Log.e("Camera2Renderer", "stopBackgroundThread");
            }
        }
    }

    /* access modifiers changed from: protected */
    public void a() {
        Log.d("Camera2Renderer", "doStart");
        j();
        super.a();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0059, code lost:
        r9.f34008t = r5;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(int r10) {
        /*
            r9 = this;
            java.lang.String r0 = "Camera2Renderer"
            java.lang.String r1 = "openCamera"
            android.util.Log.i(r0, r1)
            org.opencv.android.CameraGLSurfaceView r1 = r9.f34031p
            android.content.Context r1 = r1.getContext()
            java.lang.String r2 = "camera"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.hardware.camera2.CameraManager r1 = (android.hardware.camera2.CameraManager) r1
            java.lang.String[] r2 = r1.getCameraIdList()     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            int r3 = r2.length     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            if (r3 != 0) goto L_0x0022
            java.lang.String r10 = "Error: camera isn't detected."
            android.util.Log.e(r0, r10)     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            return
        L_0x0022:
            r3 = -1
            r4 = 0
            if (r10 != r3) goto L_0x002b
            r10 = r2[r4]     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            r9.f34008t = r10     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            goto L_0x005f
        L_0x002b:
            int r3 = r2.length     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
        L_0x002c:
            if (r4 >= r3) goto L_0x005f
            r5 = r2[r4]     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            android.hardware.camera2.CameraCharacteristics r6 = r1.getCameraCharacteristics(r5)     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            r7 = 99
            if (r10 != r7) goto L_0x0047
            android.hardware.camera2.CameraCharacteristics$Key r7 = android.hardware.camera2.CameraCharacteristics.LENS_FACING     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            java.lang.Object r7 = r6.get(r7)     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            int r7 = r7.intValue()     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            r8 = 1
            if (r7 == r8) goto L_0x0059
        L_0x0047:
            r7 = 98
            if (r10 != r7) goto L_0x005c
            android.hardware.camera2.CameraCharacteristics$Key r7 = android.hardware.camera2.CameraCharacteristics.LENS_FACING     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            java.lang.Object r6 = r6.get(r7)     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            int r6 = r6.intValue()     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            if (r6 != 0) goto L_0x005c
        L_0x0059:
            r9.f34008t = r5     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            goto L_0x005f
        L_0x005c:
            int r4 = r4 + 1
            goto L_0x002c
        L_0x005f:
            java.lang.String r10 = r9.f34008t     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            if (r10 == 0) goto L_0x00a5
            java.util.concurrent.Semaphore r10 = r9.f34012x     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            r2 = 2500(0x9c4, double:1.235E-320)
            java.util.concurrent.TimeUnit r4 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            boolean r10 = r10.tryAcquire(r2, r4)     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            if (r10 == 0) goto L_0x008f
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            r10.<init>()     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            java.lang.String r2 = "Opening camera: "
            r10.append(r2)     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            java.lang.String r2 = r9.f34008t     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            r10.append(r2)     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            java.lang.String r10 = r10.toString()     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            android.util.Log.i(r0, r10)     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            java.lang.String r10 = r9.f34008t     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            android.hardware.camera2.CameraDevice$StateCallback r2 = r9.f34013y     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            android.os.Handler r3 = r9.f34011w     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            r1.openCamera(r10, r2, r3)     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            goto L_0x00a5
        L_0x008f:
            java.lang.RuntimeException r10 = new java.lang.RuntimeException     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            java.lang.String r1 = "Time out waiting to lock camera opening."
            r10.<init>(r1)     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
            throw r10     // Catch:{ CameraAccessException -> 0x00a0, IllegalArgumentException -> 0x009d, SecurityException -> 0x009a, InterruptedException -> 0x0097 }
        L_0x0097:
            java.lang.String r10 = "OpenCamera - Interrupted Exception"
            goto L_0x00a2
        L_0x009a:
            java.lang.String r10 = "OpenCamera - Security Exception"
            goto L_0x00a2
        L_0x009d:
            java.lang.String r10 = "OpenCamera - Illegal Argument Exception"
            goto L_0x00a2
        L_0x00a0:
            java.lang.String r10 = "OpenCamera - Camera Access Exception"
        L_0x00a2:
            android.util.Log.e(r0, r10)
        L_0x00a5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: org.opencv.android.b.a(int):void");
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2, int i3) {
        String str;
        int i4 = i2;
        int i5 = i3;
        Log.i("Camera2Renderer", "cacPreviewSize: " + i4 + "x" + i5);
        if (this.f34008t == null) {
            Log.e("Camera2Renderer", "Camera isn't initialized!");
            return false;
        }
        try {
            float f2 = ((float) i4) / ((float) i5);
            int i6 = 0;
            int i7 = 0;
            for (Size size : ((StreamConfigurationMap) ((CameraManager) this.f34031p.getContext().getSystemService("camera")).getCameraCharacteristics(this.f34008t).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(SurfaceTexture.class)) {
                int width = size.getWidth();
                int height = size.getHeight();
                Log.d("Camera2Renderer", "trying size: " + width + "x" + height);
                if (i4 >= width && i5 >= height && i6 <= width && i7 <= height && ((double) Math.abs(f2 - (((float) width) / ((float) height)))) < 0.2d) {
                    i7 = height;
                    i6 = width;
                }
            }
            Log.i("Camera2Renderer", "best size: " + i6 + "x" + i7);
            if (!(i6 == 0 || i7 == 0)) {
                if (this.f34009u.getWidth() != i6 || this.f34009u.getHeight() != i7) {
                    this.f34009u = new Size(i6, i7);
                    return true;
                }
            }
            return false;
        } catch (CameraAccessException unused) {
            str = "cacPreviewSize - Camera Access Exception";
            Log.e("Camera2Renderer", str);
            return false;
        } catch (IllegalArgumentException unused2) {
            str = "cacPreviewSize - Illegal Argument Exception";
            Log.e("Camera2Renderer", str);
            return false;
        } catch (SecurityException unused3) {
            str = "cacPreviewSize - Security Exception";
            Log.e("Camera2Renderer", str);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void b() {
        Log.d("Camera2Renderer", "doStop");
        super.b();
        k();
    }

    /* access modifiers changed from: protected */
    public void b(int i2, int i3) {
        Log.i("Camera2Renderer", "setCameraPreviewSize(" + i2 + "x" + i3 + ")");
        if (this.f34022g > 0 && this.f34022g < i2) {
            i2 = this.f34022g;
        }
        if (this.f34023h > 0 && this.f34023h < i3) {
            i3 = this.f34023h;
        }
        try {
            this.f34012x.acquire();
            boolean a2 = a(i2, i3);
            this.f34018c = this.f34009u.getWidth();
            this.f34019d = this.f34009u.getHeight();
            if (!a2) {
                this.f34012x.release();
                return;
            }
            if (this.f34006r != null) {
                Log.d("Camera2Renderer", "closing existing previewSession");
                this.f34006r.close();
                this.f34006r = null;
            }
            this.f34012x.release();
            i();
        } catch (InterruptedException e2) {
            this.f34012x.release();
            throw new RuntimeException("Interrupted while setCameraPreviewSize.", e2);
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        Log.i("Camera2Renderer", "closeCamera");
        try {
            this.f34012x.acquire();
            CameraCaptureSession cameraCaptureSession = this.f34006r;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.close();
                this.f34006r = null;
            }
            CameraDevice cameraDevice = this.f34005q;
            if (cameraDevice != null) {
                cameraDevice.close();
                this.f34005q = null;
            }
            this.f34012x.release();
        } catch (InterruptedException e2) {
            throw new RuntimeException("Interrupted while trying to lock camera closing.", e2);
        } catch (Throwable th) {
            this.f34012x.release();
            throw th;
        }
    }
}
