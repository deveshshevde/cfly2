package jp.co.cyberagent.android.gpuimage;

import android.graphics.Bitmap;
import android.opengl.GLSurfaceView;
import android.util.Log;
import java.nio.IntBuffer;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.opengles.GL10;

public class g {

    /* renamed from: a  reason: collision with root package name */
    GLSurfaceView.Renderer f29720a;

    /* renamed from: b  reason: collision with root package name */
    int f29721b;

    /* renamed from: c  reason: collision with root package name */
    int f29722c;

    /* renamed from: d  reason: collision with root package name */
    Bitmap f29723d;

    /* renamed from: e  reason: collision with root package name */
    EGL10 f29724e;

    /* renamed from: f  reason: collision with root package name */
    EGLDisplay f29725f;

    /* renamed from: g  reason: collision with root package name */
    EGLConfig[] f29726g;

    /* renamed from: h  reason: collision with root package name */
    EGLConfig f29727h;

    /* renamed from: i  reason: collision with root package name */
    EGLContext f29728i;

    /* renamed from: j  reason: collision with root package name */
    EGLSurface f29729j;

    /* renamed from: k  reason: collision with root package name */
    GL10 f29730k = ((GL10) this.f29728i.getGL());

    /* renamed from: l  reason: collision with root package name */
    String f29731l = Thread.currentThread().getName();

    public g(int i2, int i3) {
        this.f29721b = i2;
        this.f29722c = i3;
        int[] iArr = {12375, i2, 12374, i3, 12344};
        EGL10 egl10 = (EGL10) EGLContext.getEGL();
        this.f29724e = egl10;
        EGLDisplay eglGetDisplay = egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        this.f29725f = eglGetDisplay;
        this.f29724e.eglInitialize(eglGetDisplay, new int[2]);
        EGLConfig c2 = c();
        this.f29727h = c2;
        this.f29728i = this.f29724e.eglCreateContext(this.f29725f, c2, EGL10.EGL_NO_CONTEXT, new int[]{12440, 2, 12344});
        EGLSurface eglCreatePbufferSurface = this.f29724e.eglCreatePbufferSurface(this.f29725f, this.f29727h, iArr);
        this.f29729j = eglCreatePbufferSurface;
        this.f29724e.eglMakeCurrent(this.f29725f, eglCreatePbufferSurface, eglCreatePbufferSurface, this.f29728i);
    }

    private EGLConfig c() {
        int[] iArr = new int[1];
        int[] iArr2 = {12325, 0, 12326, 0, 12324, 8, 12323, 8, 12322, 8, 12321, 8, 12352, 4, 12344};
        int[] iArr3 = iArr;
        this.f29724e.eglChooseConfig(this.f29725f, iArr2, (EGLConfig[]) null, 0, iArr3);
        int i2 = iArr[0];
        EGLConfig[] eGLConfigArr = new EGLConfig[i2];
        this.f29726g = eGLConfigArr;
        this.f29724e.eglChooseConfig(this.f29725f, iArr2, eGLConfigArr, i2, iArr3);
        return this.f29726g[0];
    }

    private void d() {
        int i2 = this.f29721b;
        int i3 = this.f29722c;
        int[] iArr = new int[(i2 * i3)];
        IntBuffer allocate = IntBuffer.allocate(i2 * i3);
        this.f29730k.glReadPixels(0, 0, this.f29721b, this.f29722c, 6408, 5121, allocate);
        int[] array = allocate.array();
        int i4 = 0;
        while (true) {
            int i5 = this.f29722c;
            if (i4 < i5) {
                int i6 = 0;
                while (true) {
                    int i7 = this.f29721b;
                    if (i6 >= i7) {
                        break;
                    }
                    iArr[(((this.f29722c - i4) - 1) * i7) + i6] = array[(i7 * i4) + i6];
                    i6++;
                }
                i4++;
            } else {
                Bitmap createBitmap = Bitmap.createBitmap(this.f29721b, i5, Bitmap.Config.ARGB_8888);
                this.f29723d = createBitmap;
                createBitmap.copyPixelsFromBuffer(IntBuffer.wrap(iArr));
                return;
            }
        }
    }

    public Bitmap a() {
        String str;
        if (this.f29720a == null) {
            str = "getBitmap: Renderer was not set.";
        } else if (!Thread.currentThread().getName().equals(this.f29731l)) {
            str = "getBitmap: This thread does not own the OpenGL context.";
        } else {
            this.f29720a.onDrawFrame(this.f29730k);
            this.f29720a.onDrawFrame(this.f29730k);
            d();
            return this.f29723d;
        }
        Log.e("PixelBuffer", str);
        return null;
    }

    public void a(GLSurfaceView.Renderer renderer) {
        this.f29720a = renderer;
        if (!Thread.currentThread().getName().equals(this.f29731l)) {
            Log.e("PixelBuffer", "setRenderer: This thread does not own the OpenGL context.");
            return;
        }
        this.f29720a.onSurfaceCreated(this.f29730k, this.f29727h);
        this.f29720a.onSurfaceChanged(this.f29730k, this.f29721b, this.f29722c);
    }

    public void b() {
        this.f29720a.onDrawFrame(this.f29730k);
        this.f29720a.onDrawFrame(this.f29730k);
        this.f29724e.eglMakeCurrent(this.f29725f, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_SURFACE, EGL10.EGL_NO_CONTEXT);
        this.f29724e.eglDestroySurface(this.f29725f, this.f29729j);
        this.f29724e.eglDestroyContext(this.f29725f, this.f29728i);
        this.f29724e.eglTerminate(this.f29725f);
    }
}
