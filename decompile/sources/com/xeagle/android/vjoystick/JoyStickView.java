package com.xeagle.android.vjoystick;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Handler;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import com.cfly.uav_pro.R;

public class JoyStickView extends View {
    private Handler A;

    /* renamed from: a  reason: collision with root package name */
    public boolean f24777a;

    /* renamed from: b  reason: collision with root package name */
    public boolean f24778b;

    /* renamed from: c  reason: collision with root package name */
    public boolean f24779c;

    /* renamed from: d  reason: collision with root package name */
    Runnable f24780d;

    /* renamed from: e  reason: collision with root package name */
    a f24781e;

    /* renamed from: f  reason: collision with root package name */
    b f24782f;

    /* renamed from: g  reason: collision with root package name */
    private Rect f24783g;

    /* renamed from: h  reason: collision with root package name */
    private Rect f24784h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public float f24785i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public float f24786j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public float f24787k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public float f24788l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public float f24789m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public float f24790n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public Bitmap f24791o;

    /* renamed from: p  reason: collision with root package name */
    private Bitmap f24792p;

    /* renamed from: q  reason: collision with root package name */
    private Bitmap f24793q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public Bitmap f24794r;

    /* renamed from: s  reason: collision with root package name */
    private Bitmap f24795s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public PointF f24796t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f24797u;

    /* renamed from: v  reason: collision with root package name */
    private int f24798v;

    /* renamed from: w  reason: collision with root package name */
    private int f24799w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f24800x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f24801y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f24802z;

    public interface a {
    }

    public interface b {
    }

    public JoyStickView(Context context) {
        super(context);
        this.f24797u = true;
        this.f24798v = 255;
        this.f24799w = 0;
        this.f24801y = false;
        this.f24802z = true;
        this.f24780d = new Runnable() {
            public void run() {
                JoyStickView.this.a();
            }
        };
        this.f24781e = null;
    }

    public JoyStickView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Resources resources;
        int i2;
        this.f24797u = true;
        this.f24798v = 255;
        this.f24799w = 0;
        this.f24801y = false;
        this.f24802z = true;
        this.f24780d = new Runnable() {
            public void run() {
                JoyStickView.this.a();
            }
        };
        this.f24781e = null;
        this.A = new Handler(Looper.getMainLooper());
        if (this.f24777a) {
            resources = getResources();
            i2 = R.drawable.weili_sitck_left_bg;
        } else {
            resources = getResources();
            i2 = R.drawable.weili_stick_right_bg;
        }
        this.f24793q = BitmapFactory.decodeResource(resources, i2);
        this.f24792p = BitmapFactory.decodeResource(getResources(), R.drawable.weili_stick_bt);
        a(this.f24795s);
        this.f24795s = BitmapFactory.decodeResource(getResources(), R.drawable.little_purple_2);
        a(this.f24791o);
        this.f24791o = a(this.f24793q, 0);
        a(this.f24794r);
        this.f24794r = a(this.f24792p, 0);
        this.f24783g = new Rect();
        this.f24784h = new Rect();
    }

    /* access modifiers changed from: private */
    public void a() {
        postInvalidate();
        this.A.removeCallbacks(this.f24780d);
        this.A.postDelayed(this.f24780d, 10);
    }

    private void a(Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled()) {
            bitmap.recycle();
            System.gc();
        }
    }

    private static void a(Canvas canvas, Bitmap bitmap, float f2, float f3, float f4) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        matrix.postTranslate((float) (-width), (float) (-height));
        matrix.postRotate(f2);
        matrix.postTranslate(f3 + ((float) width), f4 + ((float) height));
        canvas.drawBitmap(bitmap, matrix, (Paint) null);
    }

    public Bitmap a(Bitmap bitmap, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), bitmap.getConfig());
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setAlpha(i2);
        canvas.drawBitmap(bitmap, 0.0f, 0.0f, paint);
        return createBitmap;
    }

    public PointF getPoint() {
        return this.f24796t;
    }

    public float getR() {
        return this.f24787k;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener() {
            public boolean onPreDraw() {
                PointF pointF;
                JoyStickView joyStickView;
                JoyStickView.this.getViewTreeObserver().removeOnPreDrawListener(this);
                if (JoyStickView.this.f24777a) {
                    joyStickView = JoyStickView.this;
                    pointF = new PointF((float) ((JoyStickView.this.getWidth() * 3) / 8), (float) (JoyStickView.this.getHeight() / 2));
                } else {
                    joyStickView = JoyStickView.this;
                    pointF = new PointF((float) ((JoyStickView.this.getWidth() * 5) / 9), (float) (JoyStickView.this.getHeight() / 2));
                }
                PointF unused = joyStickView.f24796t = pointF;
                JoyStickView joyStickView2 = JoyStickView.this;
                float unused2 = joyStickView2.f24785i = joyStickView2.f24796t.x;
                JoyStickView joyStickView3 = JoyStickView.this;
                float unused3 = joyStickView3.f24786j = joyStickView3.f24796t.y;
                JoyStickView joyStickView4 = JoyStickView.this;
                float unused4 = joyStickView4.f24788l = joyStickView4.f24796t.x;
                JoyStickView joyStickView5 = JoyStickView.this;
                float unused5 = joyStickView5.f24789m = joyStickView5.f24796t.y;
                float width = ((float) JoyStickView.this.f24791o.getWidth()) / ((float) (JoyStickView.this.f24791o.getWidth() + JoyStickView.this.f24794r.getWidth()));
                JoyStickView joyStickView6 = JoyStickView.this;
                float unused6 = joyStickView6.f24787k = ((((float) joyStickView6.getWidth()) * width) * 1.0f) / 4.0f;
                JoyStickView joyStickView7 = JoyStickView.this;
                float unused7 = joyStickView7.f24790n = (((1.0f - width) * ((float) joyStickView7.getWidth())) * 1.0f) / 5.0f;
                return true;
            }
        });
        a();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Rect rect = this.f24783g;
        float f2 = this.f24785i;
        float f3 = this.f24787k;
        float f4 = this.f24786j;
        rect.set((int) (f2 - f3), (int) (f4 - f3), (int) (f2 + f3), (int) (f4 + f3));
        canvas.drawBitmap(this.f24791o, (Rect) null, this.f24783g, (Paint) null);
        if (this.f24802z && this.f24796t.x != this.f24788l) {
            float f5 = this.f24796t.y;
            float f6 = this.f24789m;
            if (f5 != f6) {
                a(canvas, this.f24795s, 180.0f - ((float) e.b((double) this.f24785i, (double) this.f24786j, (double) this.f24788l, (double) f6)), this.f24796t.x - ((float) (this.f24795s.getWidth() / 2)), this.f24796t.y - ((float) (this.f24795s.getHeight() / 2)));
            }
        }
        Rect rect2 = this.f24784h;
        float f7 = this.f24788l;
        float f8 = this.f24790n;
        float f9 = this.f24789m;
        rect2.set((int) (f7 - f8), (int) (f9 - f8), (int) (f7 + f8), (int) (f9 + f8));
        canvas.drawBitmap(this.f24794r, (Rect) null, this.f24784h, (Paint) null);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        setMeasuredDimension(i2, i3);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public void setIsRC(boolean z2) {
        Bitmap bitmap;
        int i2;
        this.f24778b = z2;
        if (z2) {
            bitmap = this.f24793q;
            i2 = 0;
        } else {
            bitmap = this.f24793q;
            i2 = 255;
        }
        this.f24791o = a(bitmap, i2);
        this.f24794r = a(this.f24792p, i2);
    }

    public void setLeftHand(boolean z2) {
        this.f24779c = z2;
    }

    public void setLeftStick(boolean z2) {
        this.f24777a = z2;
    }

    public void setMap(boolean z2) {
        this.f24800x = z2;
    }

    public void setRockerChangeListener(a aVar) {
        this.f24781e = aVar;
    }

    public void setStickMoveListener(b bVar) {
        this.f24782f = bVar;
    }

    public void setStickVisible(boolean z2) {
        this.f24801y = z2;
        if (!z2) {
            a(this.f24791o);
            this.f24791o = a(this.f24793q, 0);
            a(this.f24794r);
            this.f24794r = a(this.f24792p, 0);
        }
    }

    public void setmRockerBtn_X(float f2) {
        if (this.f24788l != f2) {
            this.f24788l = f2;
        }
    }

    public void setmRockerBtn_Y(float f2) {
        if (this.f24789m != f2) {
            this.f24789m = f2;
        }
    }
}
