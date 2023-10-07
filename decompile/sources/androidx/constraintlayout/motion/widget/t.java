package androidx.constraintlayout.motion.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.motion.widget.MotionLayout;
import androidx.constraintlayout.widget.R;
import androidx.core.widget.NestedScrollView;
import org.xmlpull.v1.XmlPullParser;

class t {

    /* renamed from: p  reason: collision with root package name */
    private static final float[][] f2065p = {new float[]{0.5f, 0.0f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}, new float[]{0.5f, 1.0f}, new float[]{0.5f, 0.5f}, new float[]{0.0f, 0.5f}, new float[]{1.0f, 0.5f}};

    /* renamed from: q  reason: collision with root package name */
    private static final float[][] f2066q = {new float[]{0.0f, -1.0f}, new float[]{0.0f, 1.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}, new float[]{-1.0f, 0.0f}, new float[]{1.0f, 0.0f}};

    /* renamed from: a  reason: collision with root package name */
    private int f2067a = 0;

    /* renamed from: b  reason: collision with root package name */
    private int f2068b = 0;

    /* renamed from: c  reason: collision with root package name */
    private int f2069c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f2070d = -1;

    /* renamed from: e  reason: collision with root package name */
    private int f2071e = -1;

    /* renamed from: f  reason: collision with root package name */
    private int f2072f = -1;

    /* renamed from: g  reason: collision with root package name */
    private float f2073g = 0.5f;

    /* renamed from: h  reason: collision with root package name */
    private float f2074h = 0.5f;

    /* renamed from: i  reason: collision with root package name */
    private float f2075i = 0.0f;

    /* renamed from: j  reason: collision with root package name */
    private float f2076j = 1.0f;

    /* renamed from: k  reason: collision with root package name */
    private boolean f2077k = false;

    /* renamed from: l  reason: collision with root package name */
    private float[] f2078l = new float[2];

    /* renamed from: m  reason: collision with root package name */
    private float f2079m;

    /* renamed from: n  reason: collision with root package name */
    private float f2080n;

    /* renamed from: o  reason: collision with root package name */
    private final MotionLayout f2081o;

    /* renamed from: r  reason: collision with root package name */
    private float f2082r = 4.0f;

    /* renamed from: s  reason: collision with root package name */
    private float f2083s = 1.2f;

    /* renamed from: t  reason: collision with root package name */
    private boolean f2084t = true;

    /* renamed from: u  reason: collision with root package name */
    private float f2085u = 1.0f;

    /* renamed from: v  reason: collision with root package name */
    private int f2086v = 0;

    /* renamed from: w  reason: collision with root package name */
    private float f2087w = 10.0f;

    t(Context context, MotionLayout motionLayout, XmlPullParser xmlPullParser) {
        this.f2081o = motionLayout;
        a(context, Xml.asAttributeSet(xmlPullParser));
    }

    private void a(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.OnSwipe);
        a(obtainStyledAttributes);
        obtainStyledAttributes.recycle();
    }

    private void a(TypedArray typedArray) {
        int indexCount = typedArray.getIndexCount();
        for (int i2 = 0; i2 < indexCount; i2++) {
            int index = typedArray.getIndex(i2);
            if (index == R.styleable.OnSwipe_touchAnchorId) {
                this.f2070d = typedArray.getResourceId(index, this.f2070d);
            } else if (index == R.styleable.OnSwipe_touchAnchorSide) {
                int i3 = typedArray.getInt(index, this.f2067a);
                this.f2067a = i3;
                float[][] fArr = f2065p;
                this.f2074h = fArr[i3][0];
                this.f2073g = fArr[i3][1];
            } else if (index == R.styleable.OnSwipe_dragDirection) {
                int i4 = typedArray.getInt(index, this.f2068b);
                this.f2068b = i4;
                float[][] fArr2 = f2066q;
                this.f2075i = fArr2[i4][0];
                this.f2076j = fArr2[i4][1];
            } else if (index == R.styleable.OnSwipe_maxVelocity) {
                this.f2082r = typedArray.getFloat(index, this.f2082r);
            } else if (index == R.styleable.OnSwipe_maxAcceleration) {
                this.f2083s = typedArray.getFloat(index, this.f2083s);
            } else if (index == R.styleable.OnSwipe_moveWhenScrollAtTop) {
                this.f2084t = typedArray.getBoolean(index, this.f2084t);
            } else if (index == R.styleable.OnSwipe_dragScale) {
                this.f2085u = typedArray.getFloat(index, this.f2085u);
            } else if (index == R.styleable.OnSwipe_dragThreshold) {
                this.f2087w = typedArray.getFloat(index, this.f2087w);
            } else if (index == R.styleable.OnSwipe_touchRegionId) {
                this.f2071e = typedArray.getResourceId(index, this.f2071e);
            } else if (index == R.styleable.OnSwipe_onTouchUp) {
                this.f2069c = typedArray.getInt(index, this.f2069c);
            } else if (index == R.styleable.OnSwipe_nestedScrollFlags) {
                this.f2086v = typedArray.getInteger(index, 0);
            } else if (index == R.styleable.OnSwipe_limitBoundsTo) {
                this.f2072f = typedArray.getResourceId(index, 0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public RectF a(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i2 = this.f2071e;
        if (i2 == -1 || (findViewById = viewGroup.findViewById(i2)) == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        View view;
        int i2 = this.f2070d;
        if (i2 != -1) {
            view = this.f2081o.findViewById(i2);
            if (view == null) {
                Log.e("TouchResponse", "cannot find TouchAnchorId @id/" + a.a(this.f2081o.getContext(), this.f2070d));
            }
        } else {
            view = null;
        }
        if (view instanceof NestedScrollView) {
            NestedScrollView nestedScrollView = (NestedScrollView) view;
            nestedScrollView.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return false;
                }
            });
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.b() {
                public void a(NestedScrollView nestedScrollView, int i2, int i3, int i4, int i5) {
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    public void a(float f2, float f3) {
        this.f2079m = f2;
        this.f2080n = f3;
        this.f2077k = false;
    }

    /* access modifiers changed from: package-private */
    public void a(MotionEvent motionEvent, MotionLayout.d dVar, int i2, q qVar) {
        int i3;
        MotionLayout.d dVar2 = dVar;
        dVar2.a(motionEvent);
        int action = motionEvent.getAction();
        if (action == 0) {
            this.f2079m = motionEvent.getRawX();
            this.f2080n = motionEvent.getRawY();
            this.f2077k = false;
        } else if (action == 1) {
            this.f2077k = false;
            dVar2.a(1000);
            float b2 = dVar.b();
            float c2 = dVar.c();
            float progress = this.f2081o.getProgress();
            int i4 = this.f2070d;
            if (i4 != -1) {
                this.f2081o.a(i4, progress, this.f2074h, this.f2073g, this.f2078l);
            } else {
                float min = (float) Math.min(this.f2081o.getWidth(), this.f2081o.getHeight());
                float[] fArr = this.f2078l;
                fArr[1] = this.f2076j * min;
                fArr[0] = min * this.f2075i;
            }
            float f2 = this.f2075i;
            float[] fArr2 = this.f2078l;
            float f3 = fArr2[0];
            float f4 = fArr2[1];
            float f5 = f2 != 0.0f ? b2 / fArr2[0] : c2 / fArr2[1];
            float f6 = !Float.isNaN(f5) ? (f5 / 3.0f) + progress : progress;
            if (f6 != 0.0f && f6 != 1.0f && (i3 = this.f2069c) != 3) {
                this.f2081o.a(i3, ((double) f6) < 0.5d ? 0.0f : 1.0f, f5);
                if (0.0f < progress && 1.0f > progress) {
                    return;
                }
            } else if (0.0f < f6 && 1.0f > f6) {
                return;
            }
            this.f2081o.setState(MotionLayout.TransitionState.FINISHED);
        } else if (action == 2) {
            float rawY = motionEvent.getRawY() - this.f2080n;
            float rawX = motionEvent.getRawX() - this.f2079m;
            if (Math.abs((this.f2075i * rawX) + (this.f2076j * rawY)) > this.f2087w || this.f2077k) {
                float progress2 = this.f2081o.getProgress();
                if (!this.f2077k) {
                    this.f2077k = true;
                    this.f2081o.setProgress(progress2);
                }
                int i5 = this.f2070d;
                if (i5 != -1) {
                    this.f2081o.a(i5, progress2, this.f2074h, this.f2073g, this.f2078l);
                } else {
                    float min2 = (float) Math.min(this.f2081o.getWidth(), this.f2081o.getHeight());
                    float[] fArr3 = this.f2078l;
                    fArr3[1] = this.f2076j * min2;
                    fArr3[0] = min2 * this.f2075i;
                }
                float f7 = this.f2075i;
                float[] fArr4 = this.f2078l;
                if (((double) Math.abs(((f7 * fArr4[0]) + (this.f2076j * fArr4[1])) * this.f2085u)) < 0.01d) {
                    float[] fArr5 = this.f2078l;
                    fArr5[0] = 0.01f;
                    fArr5[1] = 0.01f;
                }
                float max = Math.max(Math.min(progress2 + (this.f2075i != 0.0f ? rawX / this.f2078l[0] : rawY / this.f2078l[1]), 1.0f), 0.0f);
                if (max != this.f2081o.getProgress()) {
                    this.f2081o.setProgress(max);
                    dVar2.a(1000);
                    this.f2081o.f1721d = this.f2075i != 0.0f ? dVar.b() / this.f2078l[0] : dVar.c() / this.f2078l[1];
                } else {
                    this.f2081o.f1721d = 0.0f;
                }
                this.f2079m = motionEvent.getRawX();
                this.f2080n = motionEvent.getRawY();
            }
        }
    }

    public void a(boolean z2) {
        if (z2) {
            float[][] fArr = f2066q;
            fArr[4] = fArr[3];
            fArr[5] = fArr[2];
            float[][] fArr2 = f2065p;
            fArr2[5] = fArr2[2];
            fArr2[6] = fArr2[1];
        } else {
            float[][] fArr3 = f2066q;
            fArr3[4] = fArr3[2];
            fArr3[5] = fArr3[3];
            float[][] fArr4 = f2065p;
            fArr4[5] = fArr4[1];
            fArr4[6] = fArr4[2];
        }
        float[][] fArr5 = f2065p;
        int i2 = this.f2067a;
        this.f2074h = fArr5[i2][0];
        this.f2073g = fArr5[i2][1];
        float[][] fArr6 = f2066q;
        int i3 = this.f2068b;
        this.f2075i = fArr6[i3][0];
        this.f2076j = fArr6[i3][1];
    }

    /* access modifiers changed from: package-private */
    public float b() {
        return this.f2083s;
    }

    /* access modifiers changed from: package-private */
    public RectF b(ViewGroup viewGroup, RectF rectF) {
        View findViewById;
        int i2 = this.f2072f;
        if (i2 == -1 || (findViewById = viewGroup.findViewById(i2)) == null) {
            return null;
        }
        rectF.set((float) findViewById.getLeft(), (float) findViewById.getTop(), (float) findViewById.getRight(), (float) findViewById.getBottom());
        return rectF;
    }

    /* access modifiers changed from: package-private */
    public void b(float f2, float f3) {
        this.f2079m = f2;
        this.f2080n = f3;
    }

    public float c() {
        return this.f2082r;
    }

    /* access modifiers changed from: package-private */
    public float c(float f2, float f3) {
        this.f2081o.a(this.f2070d, this.f2081o.getProgress(), this.f2074h, this.f2073g, this.f2078l);
        float f4 = this.f2075i;
        if (f4 != 0.0f) {
            float[] fArr = this.f2078l;
            if (fArr[0] == 0.0f) {
                fArr[0] = 1.0E-7f;
            }
            return (f2 * f4) / fArr[0];
        }
        float[] fArr2 = this.f2078l;
        if (fArr2[1] == 0.0f) {
            fArr2[1] = 1.0E-7f;
        }
        return (f3 * this.f2076j) / fArr2[1];
    }

    /* access modifiers changed from: package-private */
    public void d(float f2, float f3) {
        boolean z2 = false;
        this.f2077k = false;
        float progress = this.f2081o.getProgress();
        this.f2081o.a(this.f2070d, progress, this.f2074h, this.f2073g, this.f2078l);
        float f4 = this.f2075i;
        float[] fArr = this.f2078l;
        float f5 = fArr[0];
        float f6 = this.f2076j;
        float f7 = fArr[1];
        float f8 = 0.0f;
        float f9 = f4 != 0.0f ? (f2 * f4) / fArr[0] : (f3 * f6) / fArr[1];
        if (!Float.isNaN(f9)) {
            progress += f9 / 3.0f;
        }
        if (progress != 0.0f) {
            boolean z3 = progress != 1.0f;
            int i2 = this.f2069c;
            if (i2 != 3) {
                z2 = true;
            }
            if (z2 && z3) {
                MotionLayout motionLayout = this.f2081o;
                if (((double) progress) >= 0.5d) {
                    f8 = 1.0f;
                }
                motionLayout.a(i2, f8, f9);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean d() {
        return this.f2084t;
    }

    /* access modifiers changed from: package-private */
    public int e() {
        return this.f2071e;
    }

    /* access modifiers changed from: package-private */
    public void e(float f2, float f3) {
        float progress = this.f2081o.getProgress();
        if (!this.f2077k) {
            this.f2077k = true;
            this.f2081o.setProgress(progress);
        }
        this.f2081o.a(this.f2070d, progress, this.f2074h, this.f2073g, this.f2078l);
        float f4 = this.f2075i;
        float[] fArr = this.f2078l;
        if (((double) Math.abs((f4 * fArr[0]) + (this.f2076j * fArr[1]))) < 0.01d) {
            float[] fArr2 = this.f2078l;
            fArr2[0] = 0.01f;
            fArr2[1] = 0.01f;
        }
        float f5 = this.f2075i;
        float max = Math.max(Math.min(progress + (f5 != 0.0f ? (f2 * f5) / this.f2078l[0] : (f3 * this.f2076j) / this.f2078l[1]), 1.0f), 0.0f);
        if (max != this.f2081o.getProgress()) {
            this.f2081o.setProgress(max);
        }
    }

    /* access modifiers changed from: package-private */
    public float f(float f2, float f3) {
        return (f2 * this.f2075i) + (f3 * this.f2076j);
    }

    public int f() {
        return this.f2086v;
    }

    public String toString() {
        return this.f2075i + " , " + this.f2076j;
    }
}
