package jp.co.cyberagent.android.gpuimage;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.IntBuffer;
import java.util.LinkedList;
import java.util.Queue;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;
import jp.co.cyberagent.android.gpuimage.GPUImage;
import mh.a;

public class d implements Camera.PreviewCallback, GLSurfaceView.Renderer {

    /* renamed from: a  reason: collision with root package name */
    static final float[] f29683a = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f};

    /* renamed from: b  reason: collision with root package name */
    public final Object f29684b = new Object();
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f29685c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public int f29686d = -1;

    /* renamed from: e  reason: collision with root package name */
    private SurfaceTexture f29687e = null;

    /* renamed from: f  reason: collision with root package name */
    private final FloatBuffer f29688f;

    /* renamed from: g  reason: collision with root package name */
    private final FloatBuffer f29689g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public IntBuffer f29690h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public int f29691i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public int f29692j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public int f29693k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public int f29694l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public int f29695m;

    /* renamed from: n  reason: collision with root package name */
    private final Queue<Runnable> f29696n;

    /* renamed from: o  reason: collision with root package name */
    private final Queue<Runnable> f29697o;

    /* renamed from: p  reason: collision with root package name */
    private Rotation f29698p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f29699q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f29700r;

    /* renamed from: s  reason: collision with root package name */
    private GPUImage.ScaleType f29701s = GPUImage.ScaleType.CENTER_CROP;

    /* renamed from: t  reason: collision with root package name */
    private float f29702t = 0.0f;

    /* renamed from: u  reason: collision with root package name */
    private float f29703u = 0.0f;

    /* renamed from: v  reason: collision with root package name */
    private float f29704v = 0.0f;

    public d(a aVar) {
        this.f29685c = aVar;
        this.f29696n = new LinkedList();
        this.f29697o = new LinkedList();
        float[] fArr = f29683a;
        FloatBuffer asFloatBuffer = ByteBuffer.allocateDirect(fArr.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.f29688f = asFloatBuffer;
        asFloatBuffer.put(fArr).position(0);
        this.f29689g = ByteBuffer.allocateDirect(a.f31202a.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        a(Rotation.NORMAL, false, false);
    }

    private float a(float f2, float f3) {
        return f2 == 0.0f ? f3 : 1.0f - f3;
    }

    private void a(Queue<Runnable> queue) {
        synchronized (queue) {
            while (!queue.isEmpty()) {
                queue.poll().run();
            }
        }
    }

    /* access modifiers changed from: private */
    public void f() {
        float f2 = (float) this.f29691i;
        float f3 = (float) this.f29692j;
        if (this.f29698p == Rotation.ROTATION_270 || this.f29698p == Rotation.ROTATION_90) {
            f2 = (float) this.f29692j;
            f3 = (float) this.f29691i;
        }
        float max = Math.max(f2 / ((float) this.f29693k), f3 / ((float) this.f29694l));
        float round = ((float) Math.round(((float) this.f29693k) * max)) / f2;
        float round2 = ((float) Math.round(((float) this.f29694l) * max)) / f3;
        float[] fArr = f29683a;
        float[] a2 = a.a(this.f29698p, this.f29699q, this.f29700r);
        if (this.f29701s == GPUImage.ScaleType.CENTER_CROP) {
            float f4 = (1.0f - (1.0f / round)) / 2.0f;
            float f5 = (1.0f - (1.0f / round2)) / 2.0f;
            a2 = new float[]{a(a2[0], f4), a(a2[1], f5), a(a2[2], f4), a(a2[3], f5), a(a2[4], f4), a(a2[5], f5), a(a2[6], f4), a(a2[7], f5)};
        } else {
            fArr = new float[]{fArr[0] / round2, fArr[1] / round, fArr[2] / round2, fArr[3] / round, fArr[4] / round2, fArr[5] / round, fArr[6] / round2, fArr[7] / round};
        }
        this.f29688f.clear();
        this.f29688f.put(fArr).position(0);
        this.f29689g.clear();
        this.f29689g.put(a2).position(0);
    }

    public void a() {
        a((Runnable) new Runnable() {
            public void run() {
                GLES20.glDeleteTextures(1, new int[]{d.this.f29686d}, 0);
                int unused = d.this.f29686d = -1;
            }
        });
    }

    public void a(final Bitmap bitmap, final boolean z2) {
        if (bitmap != null) {
            a((Runnable) new Runnable() {
                public void run() {
                    Bitmap bitmap = null;
                    if (bitmap.getWidth() % 2 == 1) {
                        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth() + 1, bitmap.getHeight(), Bitmap.Config.ARGB_8888);
                        Canvas canvas = new Canvas(createBitmap);
                        canvas.drawARGB(0, 0, 0, 0);
                        canvas.drawBitmap(bitmap, 0.0f, 0.0f, (Paint) null);
                        int unused = d.this.f29695m = 1;
                        bitmap = createBitmap;
                    } else {
                        int unused2 = d.this.f29695m = 0;
                    }
                    d dVar = d.this;
                    int unused3 = dVar.f29686d = f.a(bitmap != null ? bitmap : bitmap, dVar.f29686d, z2);
                    if (bitmap != null) {
                        bitmap.recycle();
                    }
                    int unused4 = d.this.f29693k = bitmap.getWidth();
                    int unused5 = d.this.f29694l = bitmap.getHeight();
                    d.this.f();
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void a(Runnable runnable) {
        synchronized (this.f29696n) {
            this.f29696n.add(runnable);
        }
    }

    public void a(GPUImage.ScaleType scaleType) {
        this.f29701s = scaleType;
    }

    public void a(Rotation rotation) {
        this.f29698p = rotation;
        f();
    }

    public void a(Rotation rotation, boolean z2, boolean z3) {
        this.f29699q = z2;
        this.f29700r = z3;
        a(rotation);
    }

    public void a(final a aVar) {
        a((Runnable) new Runnable() {
            public void run() {
                a e2 = d.this.f29685c;
                a unused = d.this.f29685c = aVar;
                if (e2 != null) {
                    e2.d();
                }
                d.this.f29685c.a();
                GLES20.glUseProgram(d.this.f29685c.k());
                d.this.f29685c.a(d.this.f29691i, d.this.f29692j);
            }
        });
    }

    /* access modifiers changed from: protected */
    public int b() {
        return this.f29691i;
    }

    /* access modifiers changed from: protected */
    public int c() {
        return this.f29692j;
    }

    public boolean d() {
        return this.f29699q;
    }

    public boolean e() {
        return this.f29700r;
    }

    public void onDrawFrame(GL10 gl10) {
        GLES20.glClear(16640);
        a(this.f29696n);
        this.f29685c.a(this.f29686d, this.f29688f, this.f29689g);
        a(this.f29697o);
        SurfaceTexture surfaceTexture = this.f29687e;
        if (surfaceTexture != null) {
            surfaceTexture.updateTexImage();
        }
    }

    public void onPreviewFrame(final byte[] bArr, final Camera camera) {
        final Camera.Size previewSize = camera.getParameters().getPreviewSize();
        if (this.f29690h == null) {
            this.f29690h = IntBuffer.allocate(previewSize.width * previewSize.height);
        }
        if (this.f29696n.isEmpty()) {
            a((Runnable) new Runnable() {
                public void run() {
                    GPUImageNativeLibrary.YUVtoRBGA(bArr, previewSize.width, previewSize.height, d.this.f29690h.array());
                    d dVar = d.this;
                    int unused = dVar.f29686d = f.a(dVar.f29690h, previewSize, d.this.f29686d);
                    camera.addCallbackBuffer(bArr);
                    if (d.this.f29693k != previewSize.width) {
                        int unused2 = d.this.f29693k = previewSize.width;
                        int unused3 = d.this.f29694l = previewSize.height;
                        d.this.f();
                    }
                }
            });
        }
    }

    public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
        this.f29691i = i2;
        this.f29692j = i3;
        GLES20.glViewport(0, 0, i2, i3);
        GLES20.glUseProgram(this.f29685c.k());
        this.f29685c.a(i2, i3);
        f();
        synchronized (this.f29684b) {
            this.f29684b.notifyAll();
        }
    }

    public void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
        GLES20.glClearColor(this.f29702t, this.f29703u, this.f29704v, 1.0f);
        GLES20.glDisable(2929);
        this.f29685c.a();
    }
}
