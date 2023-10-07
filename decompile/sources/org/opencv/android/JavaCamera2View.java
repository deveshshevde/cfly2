package org.opencv.android;

import android.content.Context;
import android.hardware.camera2.CameraAccessException;
import android.hardware.camera2.CameraCaptureSession;
import android.hardware.camera2.CameraCharacteristics;
import android.hardware.camera2.CameraDevice;
import android.hardware.camera2.CameraManager;
import android.hardware.camera2.CaptureRequest;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.Image;
import android.media.ImageReader;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Size;
import android.view.Surface;
import fg.i;
import java.nio.ByteBuffer;
import java.util.Arrays;
import org.opencv.android.CameraBridgeViewBase;
import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

public class JavaCamera2View extends CameraBridgeViewBase {

    /* renamed from: s  reason: collision with root package name */
    static final /* synthetic */ boolean f33952s = true;

    /* renamed from: k  reason: collision with root package name */
    protected ImageReader f33953k;

    /* renamed from: l  reason: collision with root package name */
    protected int f33954l = 35;

    /* renamed from: m  reason: collision with root package name */
    protected CameraDevice f33955m;

    /* renamed from: n  reason: collision with root package name */
    protected CameraCaptureSession f33956n;

    /* renamed from: o  reason: collision with root package name */
    protected CaptureRequest.Builder f33957o;

    /* renamed from: p  reason: collision with root package name */
    protected String f33958p;

    /* renamed from: q  reason: collision with root package name */
    protected Size f33959q = new Size(-1, -1);

    /* renamed from: r  reason: collision with root package name */
    protected Handler f33960r;

    /* renamed from: t  reason: collision with root package name */
    private HandlerThread f33961t;

    /* renamed from: u  reason: collision with root package name */
    private final CameraDevice.StateCallback f33962u = new CameraDevice.StateCallback() {
        public void onDisconnected(CameraDevice cameraDevice) {
            cameraDevice.close();
            JavaCamera2View.this.f33955m = null;
        }

        public void onError(CameraDevice cameraDevice, int i2) {
            cameraDevice.close();
            JavaCamera2View.this.f33955m = null;
        }

        public void onOpened(CameraDevice cameraDevice) {
            JavaCamera2View.this.f33955m = cameraDevice;
            JavaCamera2View.this.h();
        }
    };

    private class a implements CameraBridgeViewBase.a {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ boolean f33967a = true;

        /* renamed from: c  reason: collision with root package name */
        private Image f33969c;

        /* renamed from: d  reason: collision with root package name */
        private Mat f33970d = new Mat();

        /* renamed from: e  reason: collision with root package name */
        private Mat f33971e = new Mat();

        static {
            Class<JavaCamera2View> cls = JavaCamera2View.class;
        }

        public a(Image image) {
            this.f33969c = image;
        }

        public Mat a() {
            int i2;
            Image.Plane[] planes = this.f33969c.getPlanes();
            int width = this.f33969c.getWidth();
            int height = this.f33969c.getHeight();
            if (planes[1].getPixelStride() == 2) {
                boolean z2 = f33967a;
                if (!z2 && planes[0].getPixelStride() != 1) {
                    throw new AssertionError();
                } else if (z2 || planes[2].getPixelStride() == 2) {
                    ByteBuffer buffer = planes[0].getBuffer();
                    int rowStride = planes[0].getRowStride();
                    ByteBuffer buffer2 = planes[1].getBuffer();
                    int rowStride2 = planes[1].getRowStride();
                    ByteBuffer buffer3 = planes[2].getBuffer();
                    int rowStride3 = planes[2].getRowStride();
                    long j2 = (long) rowStride;
                    Mat mat = new Mat(height, width, org.opencv.core.a.f34062a, buffer, j2);
                    int i3 = height / 2;
                    int i4 = width / 2;
                    Mat mat2 = mat;
                    Mat mat3 = new Mat(i3, i4, org.opencv.core.a.f34063b, buffer2, (long) rowStride2);
                    Mat mat4 = new Mat(i3, i4, org.opencv.core.a.f34063b, buffer3, (long) rowStride3);
                    long c2 = mat4.c() - mat3.c();
                    if (c2 > 0) {
                        if (z2 || c2 == 1) {
                            Imgproc.a(mat2, mat3, this.f33970d, 94);
                        } else {
                            throw new AssertionError();
                        }
                    } else if (z2 || c2 == -1) {
                        Imgproc.a(mat2, mat4, this.f33970d, 96);
                    } else {
                        throw new AssertionError();
                    }
                    return this.f33970d;
                } else {
                    throw new AssertionError();
                }
            } else {
                int i5 = height / 2;
                int i6 = height + i5;
                byte[] bArr = new byte[(width * i6)];
                ByteBuffer buffer4 = planes[0].getBuffer();
                ByteBuffer buffer5 = planes[1].getBuffer();
                ByteBuffer buffer6 = planes[2].getBuffer();
                int rowStride4 = planes[0].getRowStride();
                if (rowStride4 == width) {
                    i2 = width * height;
                    buffer4.get(bArr, 0, i2);
                } else {
                    int i7 = rowStride4 - width;
                    int i8 = 0;
                    for (int i9 = 0; i9 < height; i9++) {
                        buffer4.get(bArr, i8, width);
                        i8 += width;
                        if (i9 < height - 1) {
                            buffer4.position(buffer4.position() + i7);
                        }
                    }
                    if (f33967a || i8 == width * height) {
                        i2 = i8;
                    } else {
                        throw new AssertionError();
                    }
                }
                int i10 = width / 2;
                int rowStride5 = planes[1].getRowStride() - i10;
                if (rowStride5 == 0) {
                    int i11 = (height * width) / 4;
                    buffer5.get(bArr, i2, i11);
                    buffer6.get(bArr, i2 + i11, i11);
                } else {
                    for (int i12 = 0; i12 < i5; i12++) {
                        buffer5.get(bArr, i2, i10);
                        i2 += i10;
                        if (i12 < i5 - 1) {
                            buffer5.position(buffer5.position() + rowStride5);
                        }
                    }
                    for (int i13 = 0; i13 < i5; i13++) {
                        buffer6.get(bArr, i2, i10);
                        i2 += i10;
                        if (i13 < i5 - 1) {
                            buffer6.position(buffer6.position() + rowStride5);
                        }
                    }
                }
                Mat mat5 = new Mat(i6, width, org.opencv.core.a.f34062a);
                mat5.a(0, 0, bArr);
                Imgproc.a(mat5, this.f33970d, 104, 4);
                return this.f33970d;
            }
        }

        public Mat b() {
            Image.Plane[] planes = this.f33969c.getPlanes();
            int width = this.f33969c.getWidth();
            int height = this.f33969c.getHeight();
            if (f33967a || planes[0].getPixelStride() == 1) {
                Mat mat = new Mat(height, width, org.opencv.core.a.f34062a, planes[0].getBuffer(), (long) planes[0].getRowStride());
                this.f33971e = mat;
                return mat;
            }
            throw new AssertionError();
        }

        public void c() {
            this.f33970d.g();
            this.f33971e.g();
        }
    }

    public static class b implements CameraBridgeViewBase.e {
        public int a(Object obj) {
            return ((Size) obj).getWidth();
        }

        public int b(Object obj) {
            return ((Size) obj).getHeight();
        }
    }

    public JavaCamera2View(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private void f() {
        Log.i("JavaCamera2View", "startBackgroundThread");
        g();
        HandlerThread handlerThread = new HandlerThread("OpenCVCameraBackground");
        this.f33961t = handlerThread;
        handlerThread.start();
        this.f33960r = new Handler(this.f33961t.getLooper());
    }

    private void g() {
        Log.i("JavaCamera2View", "stopBackgroundThread");
        HandlerThread handlerThread = this.f33961t;
        if (handlerThread != null) {
            handlerThread.quitSafely();
            try {
                this.f33961t.join();
                this.f33961t = null;
                this.f33960r = null;
            } catch (InterruptedException e2) {
                Log.e("JavaCamera2View", "stopBackgroundThread", e2);
            }
        }
    }

    /* access modifiers changed from: private */
    public void h() {
        int width = this.f33959q.getWidth();
        int height = this.f33959q.getHeight();
        Log.i("JavaCamera2View", "createCameraPreviewSession(" + width + "x" + height + ")");
        if (width >= 0 && height >= 0) {
            try {
                if (this.f33955m == null) {
                    Log.e("JavaCamera2View", "createCameraPreviewSession: camera isn't opened");
                } else if (this.f33956n != null) {
                    Log.e("JavaCamera2View", "createCameraPreviewSession: mCaptureSession is already started");
                } else {
                    ImageReader newInstance = ImageReader.newInstance(width, height, this.f33954l, 2);
                    this.f33953k = newInstance;
                    newInstance.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() {

                        /* renamed from: a  reason: collision with root package name */
                        static final /* synthetic */ boolean f33964a = true;

                        static {
                            Class<JavaCamera2View> cls = JavaCamera2View.class;
                        }

                        public void onImageAvailable(ImageReader imageReader) {
                            Image acquireLatestImage = imageReader.acquireLatestImage();
                            if (acquireLatestImage != null) {
                                Image.Plane[] planes = acquireLatestImage.getPlanes();
                                boolean z2 = f33964a;
                                if (!z2 && planes.length != 3) {
                                    throw new AssertionError();
                                } else if (z2 || acquireLatestImage.getFormat() == JavaCamera2View.this.f33954l) {
                                    a aVar = new a(acquireLatestImage);
                                    JavaCamera2View.this.a((CameraBridgeViewBase.a) aVar);
                                    aVar.c();
                                    acquireLatestImage.close();
                                } else {
                                    throw new AssertionError();
                                }
                            }
                        }
                    }, this.f33960r);
                    Surface surface = this.f33953k.getSurface();
                    CaptureRequest.Builder createCaptureRequest = this.f33955m.createCaptureRequest(1);
                    this.f33957o = createCaptureRequest;
                    createCaptureRequest.addTarget(surface);
                    this.f33955m.createCaptureSession(Arrays.asList(new Surface[]{surface}), new CameraCaptureSession.StateCallback() {
                        public void onConfigureFailed(CameraCaptureSession cameraCaptureSession) {
                            Log.e("JavaCamera2View", "createCameraPreviewSession failed");
                        }

                        public void onConfigured(CameraCaptureSession cameraCaptureSession) {
                            Log.i("JavaCamera2View", "createCaptureSession::onConfigured");
                            if (JavaCamera2View.this.f33955m != null) {
                                JavaCamera2View.this.f33956n = cameraCaptureSession;
                                try {
                                    JavaCamera2View.this.f33957o.set(CaptureRequest.CONTROL_AF_MODE, 4);
                                    JavaCamera2View.this.f33957o.set(CaptureRequest.CONTROL_AE_MODE, 2);
                                    JavaCamera2View.this.f33956n.setRepeatingRequest(JavaCamera2View.this.f33957o.build(), (CameraCaptureSession.CaptureCallback) null, JavaCamera2View.this.f33960r);
                                    Log.i("JavaCamera2View", "CameraPreviewSession has been started");
                                } catch (Exception e2) {
                                    Log.e("JavaCamera2View", "createCaptureSession failed", e2);
                                }
                            }
                        }
                    }, (Handler) null);
                }
            } catch (CameraAccessException e2) {
                Log.e("JavaCamera2View", "createCameraPreviewSession", e2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean a(int i2, int i3) {
        Log.i("JavaCamera2View", "setCameraPreviewSize(" + i2 + "x" + i3 + ")");
        f();
        e();
        try {
            boolean b2 = b(i2, i3);
            this.f33931a = this.f33959q.getWidth();
            this.f33932b = this.f33959q.getHeight();
            if (getLayoutParams().width == -1 && getLayoutParams().height == -1) {
                this.f33935e = Math.min(((float) i3) / ((float) this.f33932b), ((float) i2) / ((float) this.f33931a));
            } else {
                this.f33935e = 0.0f;
            }
            d();
            if (!b2) {
                return true;
            }
            if (this.f33956n != null) {
                Log.d("JavaCamera2View", "closing existing previewSession");
                this.f33956n.close();
                this.f33956n = null;
            }
            h();
            return true;
        } catch (RuntimeException e2) {
            throw new RuntimeException("Interrupted while setCameraPreviewSize.", e2);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i2, int i3) {
        String str;
        Log.i("JavaCamera2View", "calcPreviewSize: " + i2 + "x" + i3);
        if (this.f33958p == null) {
            Log.e("JavaCamera2View", "Camera isn't initialized!");
            return false;
        }
        try {
            org.opencv.core.b a2 = a(Arrays.asList(((StreamConfigurationMap) ((CameraManager) getContext().getSystemService("camera")).getCameraCharacteristics(this.f33958p).get(CameraCharacteristics.SCALER_STREAM_CONFIGURATION_MAP)).getOutputSizes(ImageReader.class)), new b(), i2, i3);
            Log.i("JavaCamera2View", "Selected preview size to " + Integer.valueOf((int) a2.f34088a) + "x" + Integer.valueOf((int) a2.f34089b));
            if (!f33952s) {
                if (a2.f34088a == i.f27244a || a2.f34089b == i.f27244a) {
                    throw new AssertionError();
                }
            }
            if (((double) this.f33959q.getWidth()) == a2.f34088a && ((double) this.f33959q.getHeight()) == a2.f34089b) {
                return false;
            }
            this.f33959q = new Size((int) a2.f34088a, (int) a2.f34089b);
            return true;
        } catch (CameraAccessException e2) {
            e = e2;
            str = "calcPreviewSize - Camera Access Exception";
            Log.e("JavaCamera2View", str, e);
            return false;
        } catch (IllegalArgumentException e3) {
            e = e3;
            str = "calcPreviewSize - Illegal Argument Exception";
            Log.e("JavaCamera2View", str, e);
            return false;
        } catch (SecurityException e4) {
            e = e4;
            str = "calcPreviewSize - Security Exception";
            Log.e("JavaCamera2View", str, e);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public void c() {
        Log.i("JavaCamera2View", "close camera");
        try {
            CameraDevice cameraDevice = this.f33955m;
            this.f33955m = null;
            CameraCaptureSession cameraCaptureSession = this.f33956n;
            if (cameraCaptureSession != null) {
                cameraCaptureSession.close();
                this.f33956n = null;
            }
            if (cameraDevice != null) {
                cameraDevice.close();
            }
            Log.i("JavaCamera2View", "camera closed!");
        } finally {
            g();
            ImageReader imageReader = this.f33953k;
            if (imageReader != null) {
                imageReader.close();
                this.f33953k = null;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x005e, code lost:
        r11.f33958p = r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean e() {
        /*
            r11 = this;
            java.lang.String r0 = "JavaCamera2View"
            java.lang.String r1 = "initializeCamera"
            android.util.Log.i(r0, r1)
            android.content.Context r1 = r11.getContext()
            java.lang.String r2 = "camera"
            java.lang.Object r1 = r1.getSystemService(r2)
            android.hardware.camera2.CameraManager r1 = (android.hardware.camera2.CameraManager) r1
            r2 = 0
            java.lang.String[] r3 = r1.getCameraIdList()     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            int r4 = r3.length     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            if (r4 != 0) goto L_0x0021
            java.lang.String r1 = "Error: camera isn't detected."
            android.util.Log.e(r0, r1)     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            return r2
        L_0x0021:
            int r4 = r11.f33937g     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            r5 = -1
            r6 = 1
            if (r4 != r5) goto L_0x002c
            r4 = r3[r2]     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            r11.f33958p = r4     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            goto L_0x0064
        L_0x002c:
            int r4 = r3.length     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            r5 = 0
        L_0x002e:
            if (r5 >= r4) goto L_0x0064
            r7 = r3[r5]     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            android.hardware.camera2.CameraCharacteristics r8 = r1.getCameraCharacteristics(r7)     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            int r9 = r11.f33937g     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            r10 = 99
            if (r9 != r10) goto L_0x004a
            android.hardware.camera2.CameraCharacteristics$Key r9 = android.hardware.camera2.CameraCharacteristics.LENS_FACING     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            java.lang.Object r9 = r8.get(r9)     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            java.lang.Integer r9 = (java.lang.Integer) r9     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            int r9 = r9.intValue()     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            if (r9 == r6) goto L_0x005e
        L_0x004a:
            int r9 = r11.f33937g     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            r10 = 98
            if (r9 != r10) goto L_0x0061
            android.hardware.camera2.CameraCharacteristics$Key r9 = android.hardware.camera2.CameraCharacteristics.LENS_FACING     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            java.lang.Object r8 = r8.get(r9)     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            java.lang.Integer r8 = (java.lang.Integer) r8     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            int r8 = r8.intValue()     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            if (r8 != 0) goto L_0x0061
        L_0x005e:
            r11.f33958p = r7     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            goto L_0x0064
        L_0x0061:
            int r5 = r5 + 1
            goto L_0x002e
        L_0x0064:
            java.lang.String r4 = r11.f33958p     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            if (r4 == 0) goto L_0x0088
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            r3.<init>()     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            java.lang.String r4 = "Opening camera: "
            r3.append(r4)     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            java.lang.String r4 = r11.f33958p     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            r3.append(r4)     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            java.lang.String r3 = r3.toString()     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            android.util.Log.i(r0, r3)     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            java.lang.String r3 = r11.f33958p     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            android.hardware.camera2.CameraDevice$StateCallback r4 = r11.f33962u     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            android.os.Handler r5 = r11.f33960r     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
        L_0x0084:
            r1.openCamera(r3, r4, r5)     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            goto L_0x00b3
        L_0x0088:
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            r4.<init>()     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            java.lang.String r5 = "Trying to open camera with the value ("
            r4.append(r5)     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            int r5 = r11.f33937g     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            r4.append(r5)     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            java.lang.String r5 = ")"
            r4.append(r5)     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            java.lang.String r4 = r4.toString()     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            android.util.Log.i(r0, r4)     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            int r4 = r11.f33937g     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            int r5 = r3.length     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            if (r4 >= r5) goto L_0x00b4
            int r4 = r11.f33937g     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            r3 = r3[r4]     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            r11.f33958p = r3     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            android.hardware.camera2.CameraDevice$StateCallback r4 = r11.f33962u     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            android.os.Handler r5 = r11.f33960r     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            goto L_0x0084
        L_0x00b3:
            return r6
        L_0x00b4:
            android.hardware.camera2.CameraAccessException r1 = new android.hardware.camera2.CameraAccessException     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            r3 = 2
            r1.<init>(r3)     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
            throw r1     // Catch:{ CameraAccessException -> 0x00c3, IllegalArgumentException -> 0x00bf, SecurityException -> 0x00bb }
        L_0x00bb:
            r1 = move-exception
            java.lang.String r3 = "OpenCamera - Security Exception"
            goto L_0x00c6
        L_0x00bf:
            r1 = move-exception
            java.lang.String r3 = "OpenCamera - Illegal Argument Exception"
            goto L_0x00c6
        L_0x00c3:
            r1 = move-exception
            java.lang.String r3 = "OpenCamera - Camera Access Exception"
        L_0x00c6:
            android.util.Log.e(r0, r3, r1)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: org.opencv.android.JavaCamera2View.e():boolean");
    }
}
