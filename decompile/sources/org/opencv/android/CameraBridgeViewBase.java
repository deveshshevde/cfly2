package org.opencv.android;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.List;
import org.opencv.R;
import org.opencv.core.Mat;

public abstract class CameraBridgeViewBase extends SurfaceView implements SurfaceHolder.Callback {

    /* renamed from: a  reason: collision with root package name */
    protected int f33931a;

    /* renamed from: b  reason: collision with root package name */
    protected int f33932b;

    /* renamed from: c  reason: collision with root package name */
    protected int f33933c;

    /* renamed from: d  reason: collision with root package name */
    protected int f33934d;

    /* renamed from: e  reason: collision with root package name */
    protected float f33935e = 0.0f;

    /* renamed from: f  reason: collision with root package name */
    protected int f33936f = 1;

    /* renamed from: g  reason: collision with root package name */
    protected int f33937g = -1;

    /* renamed from: h  reason: collision with root package name */
    protected boolean f33938h;

    /* renamed from: i  reason: collision with root package name */
    protected boolean f33939i = false;

    /* renamed from: j  reason: collision with root package name */
    protected e f33940j = null;

    /* renamed from: k  reason: collision with root package name */
    private int f33941k = 0;

    /* renamed from: l  reason: collision with root package name */
    private Bitmap f33942l;

    /* renamed from: m  reason: collision with root package name */
    private c f33943m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f33944n;

    /* renamed from: o  reason: collision with root package name */
    private final Object f33945o = new Object();

    public interface a {
        Mat a();

        Mat b();
    }

    public interface b {
        Mat a(Mat mat);

        void a();

        void a(int i2, int i3);
    }

    public interface c {
        Mat a(a aVar);

        void a();

        void a(int i2, int i3);
    }

    protected class d implements c {

        /* renamed from: b  reason: collision with root package name */
        private int f33948b = 1;

        /* renamed from: c  reason: collision with root package name */
        private b f33949c;

        public d(b bVar) {
            this.f33949c = bVar;
        }

        public Mat a(a aVar) {
            Mat mat;
            b bVar;
            int i2 = this.f33948b;
            if (i2 == 1) {
                bVar = this.f33949c;
                mat = aVar.a();
            } else if (i2 != 2) {
                Log.e("CameraBridge", "Invalid frame format! Only RGBA and Gray Scale are supported!");
                return null;
            } else {
                bVar = this.f33949c;
                mat = aVar.b();
            }
            return bVar.a(mat);
        }

        public void a() {
            this.f33949c.a();
        }

        public void a(int i2) {
            this.f33948b = i2;
        }

        public void a(int i2, int i3) {
            this.f33949c.a(i2, i3);
        }
    }

    public interface e {
        int a(Object obj);

        int b(Object obj);
    }

    public CameraBridgeViewBase(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int attributeCount = attributeSet.getAttributeCount();
        Log.d("CameraBridge", "Attr count: " + Integer.valueOf(attributeCount));
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.CameraBridgeViewBase);
        if (obtainStyledAttributes.getBoolean(R.styleable.CameraBridgeViewBase_show_fps, false)) {
            b();
        }
        this.f33937g = obtainStyledAttributes.getInt(R.styleable.CameraBridgeViewBase_camera_id, -1);
        getHolder().addCallback(this);
        this.f33934d = -1;
        this.f33933c = -1;
        obtainStyledAttributes.recycle();
    }

    private void a(int i2) {
        Log.d("CameraBridge", "call processEnterState: " + i2);
        if (i2 == 0) {
            f();
            c cVar = this.f33943m;
            if (cVar != null) {
                cVar.a();
            }
        } else if (i2 == 1) {
            h();
            c cVar2 = this.f33943m;
            if (cVar2 != null) {
                cVar2.a(this.f33931a, this.f33932b);
            }
        }
    }

    private void b(int i2) {
        Log.d("CameraBridge", "call processExitState: " + i2);
        if (i2 == 0) {
            g();
        } else if (i2 == 1) {
            i();
        }
    }

    private void e() {
        Log.d("CameraBridge", "call checkCurrentState");
        int i2 = (!this.f33938h || !this.f33939i || !this.f33944n || getVisibility() != 0) ? 0 : 1;
        int i3 = this.f33941k;
        if (i2 != i3) {
            b(i3);
            this.f33941k = i2;
            a(i2);
        }
    }

    private void f() {
    }

    private void g() {
    }

    private void h() {
        Log.d("CameraBridge", "call onEnterStartedState");
        if (!a(getWidth(), getHeight())) {
            AlertDialog create = new AlertDialog.Builder(getContext()).create();
            create.setCancelable(false);
            create.setMessage("It seems that you device does not support camera (or it is locked). Application will be closed.");
            create.setButton(-3, "OK", new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    ((Activity) CameraBridgeViewBase.this.getContext()).finish();
                }
            });
            create.show();
        }
    }

    private void i() {
        c();
        Bitmap bitmap = this.f33942l;
        if (bitmap != null) {
            bitmap.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public org.opencv.core.b a(List<?> list, e eVar, int i2, int i3) {
        int i4 = this.f33934d;
        if (i4 != -1 && i4 < i2) {
            i2 = i4;
        }
        int i5 = this.f33933c;
        if (i5 != -1 && i5 < i3) {
            i3 = i5;
        }
        int i6 = 0;
        int i7 = 0;
        for (Object next : list) {
            int a2 = eVar.a(next);
            int b2 = eVar.b(next);
            Log.d("CameraBridge", "trying size: " + a2 + "x" + b2);
            if (a2 <= i2 && b2 <= i3 && a2 >= i6 && b2 >= i7) {
                i7 = b2;
                i6 = a2;
            }
        }
        if ((i6 == 0 || i7 == 0) && list.size() > 0) {
            Log.i("CameraBridge", "fallback to the first frame size");
            Object obj = list.get(0);
            i6 = eVar.a(obj);
            i7 = eVar.b(obj);
        }
        return new org.opencv.core.b((double) i6, (double) i7);
    }

    public void a() {
        synchronized (this.f33945o) {
            this.f33939i = true;
            e();
        }
    }

    /* access modifiers changed from: protected */
    public void a(a aVar) {
        Canvas lockCanvas;
        Rect rect;
        Rect rect2;
        Bitmap bitmap;
        c cVar = this.f33943m;
        Mat a2 = cVar != null ? cVar.a(aVar) : aVar.a();
        boolean z2 = true;
        if (a2 != null) {
            try {
                Utils.a(a2, this.f33942l);
            } catch (Exception e2) {
                Log.e("CameraBridge", "Mat type: " + a2);
                Log.e("CameraBridge", "Bitmap type: " + this.f33942l.getWidth() + "*" + this.f33942l.getHeight());
                StringBuilder sb = new StringBuilder();
                sb.append("Utils.matToBitmap() throws an exception: ");
                sb.append(e2.getMessage());
                Log.e("CameraBridge", sb.toString());
                z2 = false;
            }
        }
        if (z2 && this.f33942l != null && (lockCanvas = getHolder().lockCanvas()) != null) {
            lockCanvas.drawColor(0, PorterDuff.Mode.CLEAR);
            if (this.f33935e != 0.0f) {
                bitmap = this.f33942l;
                rect = new Rect(0, 0, this.f33942l.getWidth(), this.f33942l.getHeight());
                rect2 = new Rect((int) ((((float) lockCanvas.getWidth()) - (this.f33935e * ((float) this.f33942l.getWidth()))) / 2.0f), (int) ((((float) lockCanvas.getHeight()) - (this.f33935e * ((float) this.f33942l.getHeight()))) / 2.0f), (int) (((((float) lockCanvas.getWidth()) - (this.f33935e * ((float) this.f33942l.getWidth()))) / 2.0f) + (this.f33935e * ((float) this.f33942l.getWidth()))), (int) (((((float) lockCanvas.getHeight()) - (this.f33935e * ((float) this.f33942l.getHeight()))) / 2.0f) + (this.f33935e * ((float) this.f33942l.getHeight()))));
            } else {
                bitmap = this.f33942l;
                rect = new Rect(0, 0, this.f33942l.getWidth(), this.f33942l.getHeight());
                rect2 = new Rect((lockCanvas.getWidth() - this.f33942l.getWidth()) / 2, (lockCanvas.getHeight() - this.f33942l.getHeight()) / 2, ((lockCanvas.getWidth() - this.f33942l.getWidth()) / 2) + this.f33942l.getWidth(), ((lockCanvas.getHeight() - this.f33942l.getHeight()) / 2) + this.f33942l.getHeight());
            }
            lockCanvas.drawBitmap(bitmap, rect, rect2, (Paint) null);
            e eVar = this.f33940j;
            if (eVar != null) {
                eVar.b();
                this.f33940j.a(lockCanvas, 20.0f, 30.0f);
            }
            getHolder().unlockCanvasAndPost(lockCanvas);
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean a(int i2, int i3);

    public void b() {
        if (this.f33940j == null) {
            e eVar = new e();
            this.f33940j = eVar;
            eVar.a(this.f33931a, this.f33932b);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void c();

    /* access modifiers changed from: protected */
    public void d() {
        this.f33942l = Bitmap.createBitmap(this.f33931a, this.f33932b, Bitmap.Config.ARGB_8888);
    }

    public void setCameraIndex(int i2) {
        this.f33937g = i2;
    }

    public void setCvCameraViewListener(b bVar) {
        d dVar = new d(bVar);
        dVar.a(this.f33936f);
        this.f33943m = dVar;
    }

    public void setCvCameraViewListener(c cVar) {
        this.f33943m = cVar;
    }

    public void surfaceChanged(SurfaceHolder surfaceHolder, int i2, int i3, int i4) {
        Log.d("CameraBridge", "call surfaceChanged event");
        synchronized (this.f33945o) {
            if (!this.f33944n) {
                this.f33944n = true;
            } else {
                this.f33944n = false;
                e();
                this.f33944n = true;
            }
            e();
        }
    }

    public void surfaceCreated(SurfaceHolder surfaceHolder) {
    }

    public void surfaceDestroyed(SurfaceHolder surfaceHolder) {
        synchronized (this.f33945o) {
            this.f33944n = false;
            e();
        }
    }
}
