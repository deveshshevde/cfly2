package com.google.android.exoplayer2.ui.spherical;

import android.content.Context;
import android.graphics.PointF;
import android.graphics.SurfaceTexture;
import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.opengl.GLES20;
import android.opengl.GLSurfaceView;
import android.opengl.Matrix;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.Surface;
import android.view.WindowManager;
import com.google.android.exoplayer2.ui.spherical.a;
import com.google.android.exoplayer2.ui.spherical.e;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.video.g;
import com.google.android.exoplayer2.x;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

public final class SphericalGLSurfaceView extends GLSurfaceView {

    /* renamed from: a  reason: collision with root package name */
    private final SensorManager f16847a;

    /* renamed from: b  reason: collision with root package name */
    private final Sensor f16848b;

    /* renamed from: c  reason: collision with root package name */
    private final a f16849c;

    /* renamed from: d  reason: collision with root package name */
    private final Handler f16850d;

    /* renamed from: e  reason: collision with root package name */
    private final e f16851e;

    /* renamed from: f  reason: collision with root package name */
    private final c f16852f;

    /* renamed from: g  reason: collision with root package name */
    private SurfaceTexture f16853g;

    /* renamed from: h  reason: collision with root package name */
    private Surface f16854h;

    /* renamed from: i  reason: collision with root package name */
    private x.c f16855i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f16856j;

    /* renamed from: k  reason: collision with root package name */
    private boolean f16857k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f16858l;

    class a implements GLSurfaceView.Renderer, a.C0117a, e.a {

        /* renamed from: b  reason: collision with root package name */
        private final c f16860b;

        /* renamed from: c  reason: collision with root package name */
        private final float[] f16861c = new float[16];

        /* renamed from: d  reason: collision with root package name */
        private final float[] f16862d = new float[16];

        /* renamed from: e  reason: collision with root package name */
        private final float[] f16863e;

        /* renamed from: f  reason: collision with root package name */
        private final float[] f16864f;

        /* renamed from: g  reason: collision with root package name */
        private final float[] f16865g;

        /* renamed from: h  reason: collision with root package name */
        private float f16866h;

        /* renamed from: i  reason: collision with root package name */
        private float f16867i;

        /* renamed from: j  reason: collision with root package name */
        private final float[] f16868j;

        /* renamed from: k  reason: collision with root package name */
        private final float[] f16869k;

        public a(c cVar) {
            float[] fArr = new float[16];
            this.f16863e = fArr;
            float[] fArr2 = new float[16];
            this.f16864f = fArr2;
            float[] fArr3 = new float[16];
            this.f16865g = fArr3;
            this.f16868j = new float[16];
            this.f16869k = new float[16];
            this.f16860b = cVar;
            Matrix.setIdentityM(fArr, 0);
            Matrix.setIdentityM(fArr2, 0);
            Matrix.setIdentityM(fArr3, 0);
            this.f16867i = 3.1415927f;
        }

        private float a(float f2) {
            if (!(f2 > 1.0f)) {
                return 90.0f;
            }
            double tan = Math.tan(Math.toRadians(45.0d));
            double d2 = (double) f2;
            Double.isNaN(d2);
            return (float) (Math.toDegrees(Math.atan(tan / d2)) * 2.0d);
        }

        private void a() {
            Matrix.setRotateM(this.f16864f, 0, -this.f16866h, (float) Math.cos((double) this.f16867i), (float) Math.sin((double) this.f16867i), 0.0f);
        }

        public synchronized void a(PointF pointF) {
            this.f16866h = pointF.y;
            a();
            Matrix.setRotateM(this.f16865g, 0, -pointF.x, 0.0f, 1.0f, 0.0f);
        }

        public synchronized void a(float[] fArr, float f2) {
            float[] fArr2 = this.f16863e;
            System.arraycopy(fArr, 0, fArr2, 0, fArr2.length);
            this.f16867i = -f2;
            a();
        }

        public void onDrawFrame(GL10 gl10) {
            synchronized (this) {
                Matrix.multiplyMM(this.f16869k, 0, this.f16863e, 0, this.f16865g, 0);
                Matrix.multiplyMM(this.f16868j, 0, this.f16864f, 0, this.f16869k, 0);
            }
            Matrix.multiplyMM(this.f16862d, 0, this.f16861c, 0, this.f16868j, 0);
            this.f16860b.a(this.f16862d, false);
        }

        public void onSurfaceChanged(GL10 gl10, int i2, int i3) {
            GLES20.glViewport(0, 0, i2, i3);
            float f2 = ((float) i2) / ((float) i3);
            Matrix.perspectiveM(this.f16861c, 0, a(f2), f2, 0.1f, 100.0f);
        }

        public synchronized void onSurfaceCreated(GL10 gl10, EGLConfig eGLConfig) {
            SphericalGLSurfaceView.this.a(this.f16860b.a());
        }
    }

    public SphericalGLSurfaceView(Context context) {
        this(context, (AttributeSet) null);
    }

    public SphericalGLSurfaceView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f16850d = new Handler(Looper.getMainLooper());
        SensorManager sensorManager = (SensorManager) com.google.android.exoplayer2.util.a.b(context.getSystemService("sensor"));
        this.f16847a = sensorManager;
        Sensor defaultSensor = ad.f11755a >= 18 ? sensorManager.getDefaultSensor(15) : null;
        this.f16848b = defaultSensor == null ? sensorManager.getDefaultSensor(11) : defaultSensor;
        c cVar = new c();
        this.f16852f = cVar;
        a aVar = new a(cVar);
        e eVar = new e(context, aVar, 25.0f);
        this.f16851e = eVar;
        this.f16849c = new a(((WindowManager) com.google.android.exoplayer2.util.a.b((WindowManager) context.getSystemService("window"))).getDefaultDisplay(), eVar, aVar);
        this.f16856j = true;
        setEGLContextClientVersion(2);
        setRenderer(aVar);
        setOnTouchListener(eVar);
    }

    private void a() {
        boolean z2 = this.f16856j && this.f16857k;
        Sensor sensor = this.f16848b;
        if (sensor != null && z2 != this.f16858l) {
            if (z2) {
                this.f16847a.registerListener(this.f16849c, sensor, 0);
            } else {
                this.f16847a.unregisterListener(this.f16849c);
            }
            this.f16858l = z2;
        }
    }

    /* access modifiers changed from: private */
    public void a(SurfaceTexture surfaceTexture) {
        this.f16850d.post(new Runnable(surfaceTexture) {
            public final /* synthetic */ SurfaceTexture f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                SphericalGLSurfaceView.this.b(this.f$1);
            }
        });
    }

    private static void a(SurfaceTexture surfaceTexture, Surface surface) {
        if (surfaceTexture != null) {
            surfaceTexture.release();
        }
        if (surface != null) {
            surface.release();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b() {
        Surface surface = this.f16854h;
        if (surface != null) {
            x.c cVar = this.f16855i;
            if (cVar != null) {
                cVar.a(surface);
            }
            a(this.f16853g, this.f16854h);
            this.f16853g = null;
            this.f16854h = null;
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(SurfaceTexture surfaceTexture) {
        SurfaceTexture surfaceTexture2 = this.f16853g;
        Surface surface = this.f16854h;
        this.f16853g = surfaceTexture;
        Surface surface2 = new Surface(surfaceTexture);
        this.f16854h = surface2;
        x.c cVar = this.f16855i;
        if (cVar != null) {
            cVar.b(surface2);
        }
        a(surfaceTexture2, surface);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.f16850d.post(new Runnable() {
            public final void run() {
                SphericalGLSurfaceView.this.b();
            }
        });
    }

    public void onPause() {
        this.f16857k = false;
        a();
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        this.f16857k = true;
        a();
    }

    public void setDefaultStereoMode(int i2) {
        this.f16852f.a(i2);
    }

    public void setSingleTapListener(d dVar) {
        this.f16851e.a(dVar);
    }

    public void setUseSensorRotation(boolean z2) {
        this.f16856j = z2;
        a();
    }

    public void setVideoComponent(x.c cVar) {
        x.c cVar2 = this.f16855i;
        if (cVar != cVar2) {
            if (cVar2 != null) {
                Surface surface = this.f16854h;
                if (surface != null) {
                    cVar2.a(surface);
                }
                this.f16855i.b((g) this.f16852f);
                this.f16855i.b((ge.a) this.f16852f);
            }
            this.f16855i = cVar;
            if (cVar != null) {
                cVar.a((g) this.f16852f);
                this.f16855i.a((ge.a) this.f16852f);
                this.f16855i.b(this.f16854h);
            }
        }
    }
}
