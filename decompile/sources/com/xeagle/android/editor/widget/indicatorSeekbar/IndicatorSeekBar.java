package com.xeagle.android.editor.widget.indicatorSeekbar;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.WindowManager;
import android.view.animation.AlphaAnimation;
import com.amap.api.mapcore.util.fx;
import com.xeagle.R;
import com.xeagle.android.editor.database.EditorData;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.util.ArrayList;

public class IndicatorSeekBar extends View {
    /* access modifiers changed from: private */
    public float[] A;
    private boolean B;
    private boolean C;
    private boolean D;
    private int E;
    private String[] F;
    private float[] G;
    private float[] H;
    private float I;
    private int J;
    private Typeface K;
    private int L;
    private int M;
    private int N;
    private CharSequence[] O;
    /* access modifiers changed from: private */
    public c P;
    private int Q;
    private int R;
    /* access modifiers changed from: private */
    public boolean S;
    private int T;
    /* access modifiers changed from: private */
    public View U;
    private View V;
    private int W;

    /* renamed from: a  reason: collision with root package name */
    private Context f23046a;
    private int aA;
    private Drawable aB;
    private Bitmap aC;
    private int aD;
    private boolean aE;
    private float aF;
    private int aG;
    private boolean aH;
    private boolean aI;
    private ArrayList<EditorData> aJ;

    /* renamed from: aa  reason: collision with root package name */
    private String f23047aa;

    /* renamed from: ab  reason: collision with root package name */
    private float[] f23048ab;

    /* renamed from: ac  reason: collision with root package name */
    private int f23049ac;

    /* renamed from: ad  reason: collision with root package name */
    private int f23050ad;

    /* renamed from: ae  reason: collision with root package name */
    private int f23051ae;

    /* renamed from: af  reason: collision with root package name */
    private float f23052af;

    /* renamed from: ag  reason: collision with root package name */
    private Bitmap f23053ag;

    /* renamed from: ah  reason: collision with root package name */
    private Bitmap f23054ah;

    /* renamed from: ai  reason: collision with root package name */
    private Drawable f23055ai;

    /* renamed from: aj  reason: collision with root package name */
    private int f23056aj;

    /* renamed from: ak  reason: collision with root package name */
    private boolean f23057ak;

    /* renamed from: al  reason: collision with root package name */
    private boolean f23058al;

    /* renamed from: am  reason: collision with root package name */
    private int f23059am;

    /* renamed from: an  reason: collision with root package name */
    private boolean f23060an;

    /* renamed from: ao  reason: collision with root package name */
    private RectF f23061ao;

    /* renamed from: ap  reason: collision with root package name */
    private RectF f23062ap;

    /* renamed from: aq  reason: collision with root package name */
    private int f23063aq;

    /* renamed from: ar  reason: collision with root package name */
    private int f23064ar;

    /* renamed from: as  reason: collision with root package name */
    private int f23065as;

    /* renamed from: at  reason: collision with root package name */
    private int f23066at;

    /* renamed from: au  reason: collision with root package name */
    private int[] f23067au;

    /* renamed from: av  reason: collision with root package name */
    private boolean f23068av;

    /* renamed from: aw  reason: collision with root package name */
    private float f23069aw;

    /* renamed from: ax  reason: collision with root package name */
    private float f23070ax;

    /* renamed from: ay  reason: collision with root package name */
    private Bitmap f23071ay;

    /* renamed from: az  reason: collision with root package name */
    private int f23072az;

    /* renamed from: b  reason: collision with root package name */
    private Paint f23073b;

    /* renamed from: c  reason: collision with root package name */
    private TextPaint f23074c;

    /* renamed from: d  reason: collision with root package name */
    private d f23075d;

    /* renamed from: e  reason: collision with root package name */
    private Rect f23076e;

    /* renamed from: f  reason: collision with root package name */
    private float f23077f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public float f23078g;

    /* renamed from: h  reason: collision with root package name */
    private float f23079h;

    /* renamed from: i  reason: collision with root package name */
    private float f23080i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f23081j;

    /* renamed from: k  reason: collision with root package name */
    private e f23082k;

    /* renamed from: l  reason: collision with root package name */
    private int f23083l;

    /* renamed from: m  reason: collision with root package name */
    private int f23084m;

    /* renamed from: n  reason: collision with root package name */
    private int f23085n;

    /* renamed from: o  reason: collision with root package name */
    private int f23086o;

    /* renamed from: p  reason: collision with root package name */
    private float f23087p;

    /* renamed from: q  reason: collision with root package name */
    private float f23088q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f23089r;

    /* renamed from: s  reason: collision with root package name */
    private float f23090s;

    /* renamed from: t  reason: collision with root package name */
    private float f23091t;
    /* access modifiers changed from: private */

    /* renamed from: u  reason: collision with root package name */
    public float f23092u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f23093v;

    /* renamed from: w  reason: collision with root package name */
    private int f23094w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f23095x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f23096y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f23097z;

    public IndicatorSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public IndicatorSeekBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23079h = -1.0f;
        this.f23080i = -1.0f;
        this.f23094w = 1;
        this.f23046a = context;
        a(context, attributeSet);
        b();
    }

    public IndicatorSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f23079h = -1.0f;
        this.f23080i = -1.0f;
        this.f23094w = 1;
        this.f23046a = context;
        a(context, attributeSet);
        b();
    }

    private int a(Drawable drawable, int i2) {
        return Math.round(((((float) i2) * 1.0f) * ((float) drawable.getIntrinsicHeight())) / ((float) drawable.getIntrinsicWidth()));
    }

    private Bitmap a(Drawable drawable, boolean z2) {
        int i2;
        if (drawable == null) {
            return null;
        }
        int a2 = f.a(this.f23046a, 30.0f);
        if (drawable.getIntrinsicWidth() > a2) {
            int i3 = z2 ? this.aA : this.f23059am;
            i2 = a(drawable, i3);
            if (i3 > a2) {
                i2 = a(drawable, a2);
            } else {
                a2 = i3;
            }
        } else {
            a2 = drawable.getIntrinsicWidth();
            i2 = drawable.getIntrinsicHeight();
        }
        Bitmap createBitmap = Bitmap.createBitmap(a2, i2, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        drawable.setBounds(0, 0, canvas.getWidth(), canvas.getHeight());
        drawable.draw(canvas);
        return createBitmap;
    }

    private e a(boolean z2) {
        String[] strArr;
        if (this.f23082k == null) {
            this.f23082k = new e(this);
        }
        this.f23082k.f23147b = getProgress();
        this.f23082k.f23148c = getProgressFloat();
        this.f23082k.f23149d = z2;
        if (this.f23049ac > 2) {
            int thumbPosOnTick = getThumbPosOnTick();
            if (this.C && (strArr = this.F) != null) {
                this.f23082k.f23151f = strArr[thumbPosOnTick];
            }
            if (this.B) {
                this.f23082k.f23150e = (this.f23049ac - thumbPosOnTick) - 1;
            } else {
                this.f23082k.f23150e = thumbPosOnTick;
            }
        }
        return this.f23082k;
    }

    private String a(int i2) {
        CharSequence[] charSequenceArr = this.O;
        return charSequenceArr == null ? e(this.A[i2]) : i2 < charSequenceArr.length ? String.valueOf(charSequenceArr[i2]) : "";
    }

    /* access modifiers changed from: private */
    public void a(float f2) {
        RectF rectF;
        RectF rectF2;
        if (this.B) {
            this.f23062ap.right = ((float) this.f23083l) + (this.f23087p * (1.0f - ((f2 - this.f23091t) / getAmplitude())));
            rectF = this.f23061ao;
            rectF2 = this.f23062ap;
        } else {
            this.f23061ao.right = (((f2 - this.f23091t) * this.f23087p) / getAmplitude()) + ((float) this.f23083l);
            rectF = this.f23062ap;
            rectF2 = this.f23061ao;
        }
        rectF.left = rectF2.right;
    }

    private void a(int i2, Typeface typeface) {
        Typeface typeface2;
        if (i2 != 0) {
            if (i2 == 1) {
                typeface2 = Typeface.MONOSPACE;
            } else if (i2 == 2) {
                typeface2 = Typeface.SANS_SERIF;
            } else if (i2 == 3) {
                typeface2 = Typeface.SERIF;
            } else if (typeface != null) {
                this.K = typeface;
                return;
            }
            this.K = typeface2;
        }
        typeface2 = Typeface.DEFAULT;
        this.K = typeface2;
    }

    private void a(Context context, AttributeSet attributeSet) {
        a aVar = new a(context);
        if (attributeSet == null) {
            a(aVar);
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.IndicatorSeekBar);
        this.f23090s = obtainStyledAttributes.getFloat(6, aVar.f23104b);
        this.f23091t = obtainStyledAttributes.getFloat(7, aVar.f23105c);
        this.f23092u = obtainStyledAttributes.getFloat(9, aVar.f23106d);
        this.f23093v = obtainStyledAttributes.getBoolean(10, aVar.f23107e);
        this.f23095x = obtainStyledAttributes.getBoolean(37, aVar.f23110h);
        this.f23081j = obtainStyledAttributes.getBoolean(0, aVar.f23112j);
        this.f23096y = obtainStyledAttributes.getBoolean(8, aVar.f23111i);
        this.f23097z = obtainStyledAttributes.getBoolean(12, aVar.f23108f);
        this.B = obtainStyledAttributes.getBoolean(11, aVar.f23109g);
        this.f23063aq = obtainStyledAttributes.getDimensionPixelSize(33, aVar.f23119q);
        this.f23064ar = obtainStyledAttributes.getDimensionPixelSize(35, aVar.f23121s);
        this.f23065as = obtainStyledAttributes.getColor(32, aVar.f23120r);
        this.f23066at = obtainStyledAttributes.getColor(34, aVar.f23122t);
        this.f23060an = obtainStyledAttributes.getBoolean(36, aVar.f23123u);
        this.aA = obtainStyledAttributes.getDimensionPixelSize(20, aVar.f23126x);
        this.aB = obtainStyledAttributes.getDrawable(19);
        this.aI = obtainStyledAttributes.getBoolean(17, true);
        a(obtainStyledAttributes.getColorStateList(18), aVar.f23127y);
        this.aE = obtainStyledAttributes.getBoolean(14, aVar.f23125w);
        this.aG = obtainStyledAttributes.getColor(21, aVar.f23124v);
        this.f23049ac = obtainStyledAttributes.getInt(31, aVar.H);
        this.f23056aj = obtainStyledAttributes.getInt(15, aVar.I);
        this.f23059am = obtainStyledAttributes.getDimensionPixelSize(25, aVar.K);
        b(obtainStyledAttributes.getColorStateList(22), aVar.J);
        this.f23055ai = obtainStyledAttributes.getDrawable(23);
        this.f23058al = obtainStyledAttributes.getBoolean(26, aVar.N);
        this.f23057ak = obtainStyledAttributes.getBoolean(24, aVar.M);
        this.C = obtainStyledAttributes.getBoolean(16, aVar.B);
        this.J = obtainStyledAttributes.getDimensionPixelSize(29, aVar.D);
        c(obtainStyledAttributes.getColorStateList(28), aVar.C);
        this.O = obtainStyledAttributes.getTextArray(27);
        a(obtainStyledAttributes.getInt(30, -1), aVar.F);
        this.W = obtainStyledAttributes.getInt(13, aVar.f23113k);
        this.Q = obtainStyledAttributes.getColor(1, aVar.f23114l);
        this.T = obtainStyledAttributes.getDimensionPixelSize(4, aVar.f23116n);
        this.R = obtainStyledAttributes.getColor(3, aVar.f23115m);
        int resourceId = obtainStyledAttributes.getResourceId(2, 0);
        if (resourceId > 0) {
            this.U = View.inflate(this.f23046a, resourceId, (ViewGroup) null);
        }
        int resourceId2 = obtainStyledAttributes.getResourceId(5, 0);
        if (resourceId2 > 0) {
            this.V = View.inflate(this.f23046a, resourceId2, (ViewGroup) null);
        }
        obtainStyledAttributes.recycle();
    }

    private void a(ColorStateList colorStateList, int i2) {
        if (colorStateList == null) {
            this.f23072az = i2;
            this.aD = i2;
            return;
        }
        try {
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr != null && iArr2 != null) {
                if (iArr.length == 1) {
                    int i3 = iArr2[0];
                    this.f23072az = i3;
                    this.aD = i3;
                } else if (iArr.length == 2) {
                    for (int i4 = 0; i4 < iArr.length; i4++) {
                        int[] iArr3 = iArr[i4];
                        if (iArr3.length == 0) {
                            this.aD = iArr2[i4];
                        } else if (iArr3[0] == 16842919) {
                            this.f23072az = iArr2[i4];
                        } else {
                            throw new IllegalArgumentException("the selector color file you set for the argument: isb_thumb_color is in wrong format.");
                        }
                    }
                } else {
                    throw new IllegalArgumentException("the selector color file you set for the argument: isb_thumb_color is in wrong format.");
                }
            }
        } catch (Exception unused) {
            throw new RuntimeException("Something wrong happened when parseing thumb selector color.");
        }
    }

    private void a(Canvas canvas) {
        int i2;
        Paint paint;
        int i3;
        Paint paint2;
        if (this.f23068av) {
            int i4 = this.f23049ac;
            int i5 = i4 + -1 > 0 ? i4 - 1 : 1;
            for (int i6 = 0; i6 < i5; i6++) {
                if (this.B) {
                    paint = this.f23073b;
                    i2 = this.f23067au[(i5 - i6) - 1];
                } else {
                    paint = this.f23073b;
                    i2 = this.f23067au[i6];
                }
                paint.setColor(i2);
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                float f2 = (float) i6;
                if (f2 < thumbPosOnTickFloat) {
                    int i7 = i6 + 1;
                    if (thumbPosOnTickFloat < ((float) i7)) {
                        float thumbCenterX = getThumbCenterX();
                        this.f23073b.setStrokeWidth((float) getLeftSideTrackSize());
                        Canvas canvas2 = canvas;
                        canvas2.drawLine(this.f23048ab[i6], this.f23061ao.top, thumbCenterX, this.f23061ao.bottom, this.f23073b);
                        this.f23073b.setStrokeWidth((float) getRightSideTrackSize());
                        canvas2.drawLine(thumbCenterX, this.f23061ao.top, this.f23048ab[i7], this.f23061ao.bottom, this.f23073b);
                    }
                }
                if (f2 < thumbPosOnTickFloat) {
                    paint2 = this.f23073b;
                    i3 = getLeftSideTrackSize();
                } else {
                    paint2 = this.f23073b;
                    i3 = getRightSideTrackSize();
                }
                paint2.setStrokeWidth((float) i3);
                canvas.drawLine(this.f23048ab[i6], this.f23061ao.top, this.f23048ab[i6 + 1], this.f23061ao.bottom, this.f23073b);
            }
            return;
        }
        this.f23073b.setColor(this.f23066at);
        this.f23073b.setStrokeWidth((float) this.f23064ar);
        canvas.drawLine(this.f23061ao.left, this.f23061ao.top, this.f23061ao.right, this.f23061ao.bottom, this.f23073b);
        this.f23073b.setColor(this.f23065as);
        this.f23073b.setStrokeWidth((float) this.f23063aq);
        canvas.drawLine(this.f23062ap.left, this.f23062ap.top, this.f23062ap.right, this.f23062ap.bottom, this.f23073b);
    }

    private void a(MotionEvent motionEvent) {
        a(b(c(b(motionEvent))));
        setSeekListener(true);
        invalidate();
        q();
    }

    private void a(a aVar) {
        this.f23090s = aVar.f23104b;
        this.f23091t = aVar.f23105c;
        this.f23092u = aVar.f23106d;
        this.f23093v = aVar.f23107e;
        this.f23049ac = aVar.H;
        this.f23097z = aVar.f23108f;
        this.B = aVar.f23109g;
        this.f23095x = aVar.f23110h;
        this.f23081j = aVar.f23112j;
        this.f23096y = aVar.f23111i;
        this.W = aVar.f23113k;
        this.Q = aVar.f23114l;
        this.R = aVar.f23115m;
        this.T = aVar.f23116n;
        this.U = aVar.f23117o;
        this.V = aVar.f23118p;
        this.f23063aq = aVar.f23119q;
        this.f23065as = aVar.f23120r;
        this.f23064ar = aVar.f23121s;
        this.f23066at = aVar.f23122t;
        this.f23060an = aVar.f23123u;
        this.aA = aVar.f23126x;
        this.aB = aVar.A;
        this.aG = aVar.f23124v;
        a(aVar.f23128z, aVar.f23127y);
        this.aE = aVar.f23125w;
        this.f23056aj = aVar.I;
        this.f23059am = aVar.K;
        this.f23055ai = aVar.L;
        this.f23057ak = aVar.M;
        this.f23058al = aVar.N;
        b(aVar.O, aVar.J);
        this.C = aVar.B;
        this.J = aVar.D;
        this.O = aVar.E;
        this.K = aVar.F;
        c(aVar.G, aVar.C);
    }

    private boolean a(float f2, float f3) {
        if (this.f23079h == -1.0f) {
            this.f23079h = (float) f.a(this.f23046a, 5.0f);
        }
        float f4 = this.f23079h;
        return ((f2 > (((float) this.f23083l) - (f4 * 2.0f)) ? 1 : (f2 == (((float) this.f23083l) - (f4 * 2.0f)) ? 0 : -1)) >= 0 && (f2 > (((float) (this.f23085n - this.f23084m)) + (f4 * 2.0f)) ? 1 : (f2 == (((float) (this.f23085n - this.f23084m)) + (f4 * 2.0f)) ? 0 : -1)) <= 0) && ((f3 > ((this.f23061ao.top - this.f23070ax) - this.f23079h) ? 1 : (f3 == ((this.f23061ao.top - this.f23070ax) - this.f23079h) ? 0 : -1)) >= 0 && (f3 > ((this.f23061ao.top + this.f23070ax) + this.f23079h) ? 1 : (f3 == ((this.f23061ao.top + this.f23070ax) + this.f23079h) ? 0 : -1)) <= 0);
    }

    private float b(float f2) {
        this.f23078g = this.f23092u;
        float amplitude = this.f23091t + ((getAmplitude() * (f2 - ((float) this.f23083l))) / this.f23087p);
        this.f23092u = amplitude;
        return amplitude;
    }

    private float b(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        int i2 = this.f23083l;
        if (x2 >= ((float) i2)) {
            float x3 = motionEvent.getX();
            int i3 = this.f23085n;
            int i4 = this.f23084m;
            if (x3 <= ((float) (i3 - i4))) {
                return motionEvent.getX();
            }
            i2 = i3 - i4;
        }
        return (float) i2;
    }

    private void b() {
        float f2;
        e();
        int i2 = this.f23063aq;
        int i3 = this.f23064ar;
        if (i2 > i3) {
            this.f23063aq = i3;
        }
        if (this.aB == null) {
            float f3 = ((float) this.aA) / 2.0f;
            this.f23069aw = f3;
            f2 = f3 * 1.2f;
        } else {
            f2 = ((float) Math.min(f.a(this.f23046a, 30.0f), this.aA)) / 2.0f;
            this.f23069aw = f2;
        }
        this.f23070ax = f2;
        this.f23052af = ((float) (this.f23055ai == null ? this.f23059am : Math.min(f.a(this.f23046a, 30.0f), this.f23059am))) / 2.0f;
        this.f23077f = Math.max(this.f23070ax, this.f23052af) * 2.0f;
        f();
        g();
        this.f23078g = this.f23092u;
        c();
        this.f23061ao = new RectF();
        this.f23062ap = new RectF();
        d();
        r();
    }

    private void b(ColorStateList colorStateList, int i2) {
        if (colorStateList == null) {
            this.f23051ae = i2;
            this.f23050ad = i2;
            return;
        }
        try {
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr != null && iArr2 != null) {
                if (iArr.length == 1) {
                    int i3 = iArr2[0];
                    this.f23051ae = i3;
                    this.f23050ad = i3;
                } else if (iArr.length == 2) {
                    for (int i4 = 0; i4 < iArr.length; i4++) {
                        int[] iArr3 = iArr[i4];
                        if (iArr3.length == 0) {
                            this.f23050ad = iArr2[i4];
                        } else if (iArr3[0] == 16842913) {
                            this.f23051ae = iArr2[i4];
                        } else {
                            throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_marks_color is in wrong format.");
                        }
                    }
                } else {
                    throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_marks_color is in wrong format.");
                }
            }
        } catch (Exception e2) {
            throw new RuntimeException("Something wrong happened when parsing thumb selector color." + e2.getMessage());
        }
    }

    private void b(Canvas canvas) {
        int i2;
        Paint paint;
        float f2;
        float f3;
        float f4;
        float f5;
        float f6;
        Bitmap bitmap;
        if (this.f23049ac == 0) {
            return;
        }
        if (this.f23056aj != 0 || this.f23055ai != null) {
            float thumbCenterX = getThumbCenterX();
            for (int i3 = 0; i3 < this.f23048ab.length; i3++) {
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                if ((!this.f23058al || thumbCenterX < this.f23048ab[i3]) && ((!this.f23057ak || !(i3 == 0 || i3 == this.f23048ab.length - 1)) && (i3 != getThumbPosOnTick() || this.f23049ac <= 2 || this.f23097z))) {
                    float f7 = (float) i3;
                    if (f7 <= thumbPosOnTickFloat) {
                        paint = this.f23073b;
                        i2 = getLeftSideTickColor();
                    } else {
                        paint = this.f23073b;
                        i2 = getRightSideTickColor();
                    }
                    paint.setColor(i2);
                    if (this.f23055ai != null) {
                        if (this.f23054ah == null || this.f23053ag == null) {
                            o();
                        }
                        Bitmap bitmap2 = this.f23054ah;
                        if (bitmap2 == null || (bitmap = this.f23053ag) == null) {
                            throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
                        } else if (f7 <= thumbPosOnTickFloat) {
                            canvas.drawBitmap(bitmap2, this.f23048ab[i3] - (((float) bitmap.getWidth()) / 2.0f), this.f23061ao.top - (((float) this.f23053ag.getHeight()) / 2.0f), this.f23073b);
                        } else {
                            canvas.drawBitmap(bitmap, this.f23048ab[i3] - (((float) bitmap.getWidth()) / 2.0f), this.f23061ao.top - (((float) this.f23053ag.getHeight()) / 2.0f), this.f23073b);
                        }
                    } else {
                        int i4 = this.f23056aj;
                        if (i4 == 1) {
                            canvas.drawCircle(this.f23048ab[i3], this.f23061ao.top, this.f23052af, this.f23073b);
                        } else {
                            if (i4 == 3) {
                                int a2 = f.a(this.f23046a, 1.0f);
                                int leftSideTrackSize = thumbCenterX >= this.f23048ab[i3] ? getLeftSideTrackSize() : getRightSideTrackSize();
                                float f8 = (float) a2;
                                f4 = this.f23048ab[i3] - f8;
                                f5 = ((float) leftSideTrackSize) / 2.0f;
                                f3 = this.f23061ao.top - f5;
                                f2 = this.f23048ab[i3] + f8;
                                f6 = this.f23061ao.top;
                            } else if (i4 == 2) {
                                f4 = this.f23048ab[i3] - (((float) this.f23059am) / 2.0f);
                                float f9 = this.f23061ao.top;
                                int i5 = this.f23059am;
                                f3 = f9 - (((float) i5) / 2.0f);
                                f2 = this.f23048ab[i3] + (((float) i5) / 2.0f);
                                f6 = this.f23061ao.top;
                                f5 = ((float) this.f23059am) / 2.0f;
                            }
                            canvas.drawRect(f4, f3, f2, f6 + f5, this.f23073b);
                        }
                    }
                }
            }
        }
    }

    private float c(float f2) {
        if (this.f23049ac > 2 && !this.f23097z) {
            f2 = ((float) this.f23083l) + (this.f23088q * ((float) Math.round((f2 - ((float) this.f23083l)) / this.f23088q)));
        }
        return this.B ? (this.f23087p - f2) + ((float) (this.f23083l * 2)) : f2;
    }

    private void c() {
        int i2 = this.f23049ac;
        if (i2 < 0 || i2 > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.f23049ac);
        } else if (i2 != 0) {
            this.f23048ab = new float[i2];
            if (this.C) {
                this.H = new float[i2];
                this.G = new float[i2];
            }
            this.A = new float[i2];
            ArrayList<EditorData> arrayList = this.aJ;
            int i3 = 0;
            if (arrayList == null || arrayList.size() <= 0) {
                while (true) {
                    float[] fArr = this.A;
                    if (i3 < fArr.length) {
                        float f2 = this.f23091t;
                        float f3 = ((float) i3) * (this.f23090s - f2);
                        int i4 = this.f23049ac;
                        fArr[i3] = f2 + (f3 / ((float) (i4 + -1 > 0 ? i4 - 1 : 1)));
                        i3++;
                    } else {
                        return;
                    }
                }
            } else {
                float f4 = 0.0f;
                while (i3 < this.A.length - 1) {
                    double d2 = (double) f4;
                    double rightProgress = (double) (this.aJ.get(i3).getRightProgress() - this.aJ.get(i3).getLeftProgress());
                    Double.isNaN(rightProgress);
                    double duration = (double) this.aJ.get(i3).getDuration();
                    Double.isNaN(duration);
                    Double.isNaN(d2);
                    f4 = (float) (d2 + ((rightProgress / 100.0d) * duration));
                    this.A[i3] = f4;
                    Log.i("editor", "collectTicksInfo: ===sum===" + this.A[i3]);
                    i3++;
                }
            }
        }
    }

    private void c(ColorStateList colorStateList, int i2) {
        if (colorStateList == null) {
            this.M = i2;
            this.L = i2;
            this.N = i2;
            return;
        }
        try {
            int[][] iArr = null;
            int[] iArr2 = null;
            for (Field field : colorStateList.getClass().getDeclaredFields()) {
                field.setAccessible(true);
                if ("mStateSpecs".equals(field.getName())) {
                    iArr = (int[][]) field.get(colorStateList);
                }
                if ("mColors".equals(field.getName())) {
                    iArr2 = (int[]) field.get(colorStateList);
                }
            }
            if (iArr != null && iArr2 != null) {
                if (iArr.length == 1) {
                    int i3 = iArr2[0];
                    this.M = i3;
                    this.L = i3;
                    this.N = i3;
                } else if (iArr.length == 3) {
                    for (int i4 = 0; i4 < iArr.length; i4++) {
                        int[] iArr3 = iArr[i4];
                        if (iArr3.length == 0) {
                            this.M = iArr2[i4];
                        } else {
                            int i5 = iArr3[0];
                            if (i5 == 16842913) {
                                this.L = iArr2[i4];
                            } else if (i5 == 16843623) {
                                this.N = iArr2[i4];
                            } else {
                                throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_texts_color is in wrong format.");
                            }
                        }
                    }
                } else {
                    throw new IllegalArgumentException("the selector color file you set for the argument: isb_tick_texts_color is in wrong format.");
                }
            }
        } catch (Exception unused) {
            throw new RuntimeException("Something wrong happened when parseing thumb selector color.");
        }
    }

    private void c(Canvas canvas) {
        int i2;
        TextPaint textPaint;
        String str;
        float f2;
        if (this.F != null) {
            float thumbPosOnTickFloat = getThumbPosOnTickFloat();
            int i3 = 0;
            while (true) {
                String[] strArr = this.F;
                if (i3 < strArr.length) {
                    if (!this.D || i3 == 0 || i3 == strArr.length - 1) {
                        if (i3 == getThumbPosOnTick() && ((float) i3) == thumbPosOnTickFloat) {
                            textPaint = this.f23074c;
                            i2 = this.N;
                        } else if (((float) i3) < thumbPosOnTickFloat) {
                            textPaint = this.f23074c;
                            i2 = getLeftSideTickTextsColor();
                        } else {
                            textPaint = this.f23074c;
                            i2 = getRightSideTickTextsColor();
                        }
                        textPaint.setColor(i2);
                        int length = this.B ? (this.F.length - i3) - 1 : i3;
                        String[] strArr2 = this.F;
                        if (i3 == 0) {
                            str = strArr2[length];
                            f2 = this.H[i3] + (this.G[length] / 2.0f);
                        } else if (i3 == strArr2.length - 1) {
                            str = strArr2[length];
                            f2 = this.H[i3] - (this.G[length] / 2.0f);
                        } else {
                            canvas.drawText(strArr2[length], this.H[i3], this.I, this.f23074c);
                        }
                        canvas.drawText(str, f2, this.I, this.f23074c);
                    }
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    private void d() {
        if (!this.f23081j) {
            int a2 = f.a(this.f23046a, 16.0f);
            if (getPaddingLeft() == 0) {
                setPadding(a2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            }
            if (getPaddingRight() == 0) {
                setPadding(getPaddingLeft(), getPaddingTop(), a2, getPaddingBottom());
            }
        }
    }

    private void d(Canvas canvas) {
        int i2;
        Paint paint;
        Bitmap bitmap;
        float f2;
        Bitmap bitmap2;
        float f3;
        if (!this.aH) {
            float thumbCenterX = getThumbCenterX();
            if (this.aB != null) {
                if (this.f23071ay == null || this.aC == null) {
                    n();
                }
                if (this.f23071ay == null || this.aC == null) {
                    throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
                }
                this.f23073b.setAlpha(255);
                if (this.f23089r) {
                    bitmap2 = this.aC;
                    f3 = thumbCenterX - (((float) bitmap2.getWidth()) / 2.0f);
                    f2 = this.f23061ao.top;
                    bitmap = this.aC;
                } else {
                    bitmap2 = this.f23071ay;
                    f3 = thumbCenterX - (((float) bitmap2.getWidth()) / 2.0f);
                    f2 = this.f23061ao.top;
                    bitmap = this.f23071ay;
                }
                canvas.drawBitmap(bitmap2, f3, f2 - (((float) bitmap.getHeight()) / 2.0f), this.f23073b);
                return;
            }
            if (this.f23089r) {
                paint = this.f23073b;
                i2 = this.aD;
            } else {
                paint = this.f23073b;
                i2 = this.f23072az;
            }
            paint.setColor(i2);
            canvas.drawCircle(thumbCenterX, this.f23061ao.top, this.f23089r ? this.f23070ax : this.f23069aw, this.f23073b);
        }
    }

    private boolean d(float f2) {
        a(this.f23092u);
        float f3 = (this.B ? this.f23062ap : this.f23061ao).right;
        int i2 = this.aA;
        return f3 - (((float) i2) / 2.0f) <= f2 && f2 <= f3 + (((float) i2) / 2.0f);
    }

    private String e(float f2) {
        return this.f23093v ? b.a((double) f2, this.f23094w) : String.valueOf(Math.round(f2));
    }

    private void e() {
        float f2 = this.f23090s;
        float f3 = this.f23091t;
        if (f2 >= f3) {
            if (this.f23092u < f3) {
                this.f23092u = f3;
            }
            if (this.f23092u > f2) {
                this.f23092u = f2;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("the Argument: MAX's value must be larger than MIN's.");
    }

    private void e(Canvas canvas) {
        if (!this.aE) {
            return;
        }
        if (!this.C || this.f23049ac <= 2) {
            this.f23074c.setColor(this.aG);
            canvas.drawText(e(this.f23092u), getThumbCenterX(), this.aF, this.f23074c);
        }
    }

    private void f() {
        if (this.f23073b == null) {
            this.f23073b = new Paint();
        }
        if (this.f23060an) {
            this.f23073b.setStrokeCap(Paint.Cap.ROUND);
        }
        this.f23073b.setAntiAlias(true);
        int i2 = this.f23063aq;
        if (i2 > this.f23064ar) {
            this.f23064ar = i2;
        }
    }

    private void g() {
        if (h()) {
            i();
            this.f23074c.setTypeface(this.K);
            this.f23074c.getTextBounds(fx.f8869j, 0, 1, this.f23076e);
            this.E = this.f23076e.height() + f.a(this.f23046a, 3.0f);
        }
    }

    private float getAmplitude() {
        float f2 = this.f23090s;
        float f3 = this.f23091t;
        if (f2 - f3 > 0.0f) {
            return f2 - f3;
        }
        return 1.0f;
    }

    private int getClosestIndex() {
        float abs = Math.abs(this.f23090s - this.f23091t);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            float[] fArr = this.A;
            if (i2 >= fArr.length) {
                return i3;
            }
            float abs2 = Math.abs(fArr[i2] - this.f23092u);
            if (abs2 <= abs) {
                i3 = i2;
                abs = abs2;
            }
            i2++;
        }
    }

    private int getLeftSideTickColor() {
        return this.B ? this.f23050ad : this.f23051ae;
    }

    private int getLeftSideTickTextsColor() {
        return this.B ? this.M : this.L;
    }

    private int getLeftSideTrackSize() {
        return this.B ? this.f23063aq : this.f23064ar;
    }

    private int getRightSideTickColor() {
        return this.B ? this.f23051ae : this.f23050ad;
    }

    private int getRightSideTickTextsColor() {
        return this.B ? this.L : this.M;
    }

    private int getRightSideTrackSize() {
        return this.B ? this.f23064ar : this.f23063aq;
    }

    private float getThumbCenterX() {
        return (this.B ? this.f23062ap : this.f23061ao).right;
    }

    private int getThumbPosOnTick() {
        if (this.f23049ac != 0) {
            return Math.round((getThumbCenterX() - ((float) this.f23083l)) / this.f23088q);
        }
        return 0;
    }

    private float getThumbPosOnTickFloat() {
        if (this.f23049ac != 0) {
            return (getThumbCenterX() - ((float) this.f23083l)) / this.f23088q;
        }
        return 0.0f;
    }

    private boolean h() {
        return this.aE || (this.f23049ac != 0 && this.C);
    }

    private void i() {
        if (this.f23074c == null) {
            TextPaint textPaint = new TextPaint();
            this.f23074c = textPaint;
            textPaint.setAntiAlias(true);
            this.f23074c.setTextAlign(Paint.Align.CENTER);
            this.f23074c.setTextSize((float) this.J);
        }
        if (this.f23076e == null) {
            this.f23076e = new Rect();
        }
    }

    private void j() {
        int i2;
        this.f23085n = getMeasuredWidth();
        if (Build.VERSION.SDK_INT < 17) {
            this.f23083l = getPaddingLeft();
            i2 = getPaddingRight();
        } else {
            this.f23083l = getPaddingStart();
            i2 = getPaddingEnd();
        }
        this.f23084m = i2;
        this.f23086o = getPaddingTop();
        float f2 = (float) ((this.f23085n - this.f23083l) - this.f23084m);
        this.f23087p = f2;
        int i3 = this.f23049ac;
        int i4 = 1;
        if (i3 - 1 > 0) {
            i4 = i3 - 1;
        }
        this.f23088q = f2 / ((float) i4);
    }

    private void k() {
        m();
        if (h()) {
            this.f23074c.getTextBounds(fx.f8869j, 0, 1, this.f23076e);
            float round = ((float) this.f23086o) + this.f23077f + ((float) Math.round(((float) this.f23076e.height()) - this.f23074c.descent())) + ((float) f.a(this.f23046a, 3.0f));
            this.I = round;
            this.aF = round;
        }
        if (this.f23048ab != null) {
            l();
            if (this.f23049ac > 2) {
                float f2 = this.A[getClosestIndex()];
                this.f23092u = f2;
                this.f23078g = f2;
            }
            a(this.f23092u);
        }
    }

    private void l() {
        int i2 = this.f23049ac;
        if (i2 != 0) {
            if (this.C) {
                this.F = new String[i2];
            }
            for (int i3 = 0; i3 < this.f23048ab.length; i3++) {
                if (this.C) {
                    this.F[i3] = a(i3);
                    TextPaint textPaint = this.f23074c;
                    String[] strArr = this.F;
                    textPaint.getTextBounds(strArr[i3], 0, strArr[i3].length(), this.f23076e);
                    this.G[i3] = (float) this.f23076e.width();
                    this.H[i3] = ((float) this.f23083l) + (this.f23088q * ((float) i3));
                }
                this.f23048ab[i3] = ((float) this.f23083l) + (this.f23088q * ((float) i3));
            }
        }
    }

    private void m() {
        RectF rectF;
        RectF rectF2;
        if (this.B) {
            this.f23062ap.left = (float) this.f23083l;
            this.f23062ap.top = ((float) this.f23086o) + this.f23070ax;
            this.f23062ap.right = ((float) this.f23083l) + (this.f23087p * (1.0f - ((this.f23092u - this.f23091t) / getAmplitude())));
            RectF rectF3 = this.f23062ap;
            rectF3.bottom = rectF3.top;
            this.f23061ao.left = this.f23062ap.right;
            this.f23061ao.top = this.f23062ap.top;
            this.f23061ao.right = (float) (this.f23085n - this.f23084m);
            rectF2 = this.f23061ao;
            rectF = this.f23062ap;
        } else {
            this.f23061ao.left = (float) this.f23083l;
            this.f23061ao.top = ((float) this.f23086o) + this.f23070ax;
            this.f23061ao.right = (((this.f23092u - this.f23091t) * this.f23087p) / getAmplitude()) + ((float) this.f23083l);
            RectF rectF4 = this.f23061ao;
            rectF4.bottom = rectF4.top;
            this.f23062ap.left = this.f23061ao.right;
            this.f23062ap.top = this.f23061ao.bottom;
            this.f23062ap.right = (float) (this.f23085n - this.f23084m);
            rectF2 = this.f23062ap;
            rectF = this.f23061ao;
        }
        rectF2.bottom = rectF.bottom;
    }

    private void n() {
        Drawable drawable = this.aB;
        if (drawable != null) {
            if (drawable instanceof StateListDrawable) {
                try {
                    StateListDrawable stateListDrawable = (StateListDrawable) drawable;
                    Class<?> cls = stateListDrawable.getClass();
                    int intValue = ((Integer) cls.getMethod("getStateCount", new Class[0]).invoke(stateListDrawable, new Object[0])).intValue();
                    if (intValue == 2) {
                        Method method = cls.getMethod("getStateSet", new Class[]{Integer.TYPE});
                        Method method2 = cls.getMethod("getStateDrawable", new Class[]{Integer.TYPE});
                        for (int i2 = 0; i2 < intValue; i2++) {
                            int[] iArr = (int[]) method.invoke(stateListDrawable, new Object[]{Integer.valueOf(i2)});
                            if (iArr.length <= 0) {
                                this.f23071ay = a((Drawable) method2.invoke(stateListDrawable, new Object[]{Integer.valueOf(i2)}), true);
                            } else if (iArr[0] == 16842919) {
                                this.aC = a((Drawable) method2.invoke(stateListDrawable, new Object[]{Integer.valueOf(i2)}), true);
                            } else {
                                throw new IllegalArgumentException("the state of the selector thumb drawable is wrong!");
                            }
                        }
                        return;
                    }
                    throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
                } catch (Exception unused) {
                    drawable = this.aB;
                }
            }
            Bitmap a2 = a(drawable, true);
            this.f23071ay = a2;
            this.aC = a2;
        }
    }

    private void o() {
        Drawable drawable = this.f23055ai;
        if (drawable instanceof StateListDrawable) {
            StateListDrawable stateListDrawable = (StateListDrawable) drawable;
            try {
                Class<?> cls = stateListDrawable.getClass();
                int intValue = ((Integer) cls.getMethod("getStateCount", new Class[0]).invoke(stateListDrawable, new Object[0])).intValue();
                if (intValue == 2) {
                    Method method = cls.getMethod("getStateSet", new Class[]{Integer.TYPE});
                    Method method2 = cls.getMethod("getStateDrawable", new Class[]{Integer.TYPE});
                    for (int i2 = 0; i2 < intValue; i2++) {
                        int[] iArr = (int[]) method.invoke(stateListDrawable, new Object[]{Integer.valueOf(i2)});
                        if (iArr.length <= 0) {
                            this.f23053ag = a((Drawable) method2.invoke(stateListDrawable, new Object[]{Integer.valueOf(i2)}), false);
                        } else if (iArr[0] == 16842913) {
                            this.f23054ah = a((Drawable) method2.invoke(stateListDrawable, new Object[]{Integer.valueOf(i2)}), false);
                        } else {
                            throw new IllegalArgumentException("the state of the selector TickMarks drawable is wrong!");
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
            } catch (Exception unused) {
                drawable = this.f23055ai;
            }
        }
        Bitmap a2 = a(drawable, false);
        this.f23053ag = a2;
        this.f23054ah = a2;
    }

    private boolean p() {
        return this.f23093v ? this.f23078g != this.f23092u : Math.round(this.f23078g) != Math.round(this.f23092u);
    }

    private void q() {
        if (this.S) {
            s();
            return;
        }
        c cVar = this.P;
        if (cVar != null) {
            cVar.a();
            if (this.P.e()) {
                this.P.a(getThumbCenterX());
            } else {
                this.P.b(getThumbCenterX());
            }
        }
    }

    private void r() {
        int i2 = this.W;
        if (i2 != 0 && this.P == null) {
            c cVar = new c(this.f23046a, this, this.Q, i2, this.T, this.R, this.U, this.V);
            this.P = cVar;
            this.U = cVar.b();
        }
    }

    /* access modifiers changed from: private */
    public void s() {
        c cVar;
        int i2;
        if (this.S && (cVar = this.P) != null) {
            cVar.a(getIndicatorTextString());
            int i3 = 0;
            this.U.measure(0, 0);
            int measuredWidth = this.U.getMeasuredWidth();
            float thumbCenterX = getThumbCenterX();
            if (this.f23080i == -1.0f) {
                DisplayMetrics displayMetrics = new DisplayMetrics();
                WindowManager windowManager = (WindowManager) this.f23046a.getSystemService("window");
                if (windowManager != null) {
                    windowManager.getDefaultDisplay().getMetrics(displayMetrics);
                    this.f23080i = (float) displayMetrics.widthPixels;
                }
            }
            float f2 = (float) (measuredWidth / 2);
            int i4 = this.f23085n;
            if (f2 + thumbCenterX > ((float) i4)) {
                i3 = i4 - measuredWidth;
                i2 = (int) ((thumbCenterX - ((float) i3)) - f2);
            } else if (thumbCenterX - f2 < 0.0f) {
                i2 = -((int) (f2 - thumbCenterX));
            } else {
                i3 = (int) (getThumbCenterX() - f2);
                i2 = 0;
            }
            this.P.a(i3);
            this.P.b(i2);
        }
    }

    /* access modifiers changed from: private */
    public void setSeekListener(boolean z2) {
        if (this.f23075d != null && p()) {
            this.f23075d.a(a(z2));
        }
    }

    private boolean t() {
        if (this.f23049ac < 3 || !this.f23097z || !this.aI) {
            return false;
        }
        final int closestIndex = getClosestIndex();
        final float f2 = this.f23092u;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, Math.abs(f2 - this.A[closestIndex])});
        ofFloat.start();
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f2;
                IndicatorSeekBar indicatorSeekBar;
                IndicatorSeekBar indicatorSeekBar2 = IndicatorSeekBar.this;
                float unused = indicatorSeekBar2.f23078g = indicatorSeekBar2.f23092u;
                if (f2 - IndicatorSeekBar.this.A[closestIndex] > 0.0f) {
                    indicatorSeekBar = IndicatorSeekBar.this;
                    f2 = f2 - ((Float) valueAnimator.getAnimatedValue()).floatValue();
                } else {
                    indicatorSeekBar = IndicatorSeekBar.this;
                    f2 = f2 + ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
                float unused2 = indicatorSeekBar.f23092u = f2;
                IndicatorSeekBar indicatorSeekBar3 = IndicatorSeekBar.this;
                indicatorSeekBar3.a(indicatorSeekBar3.f23092u);
                IndicatorSeekBar.this.setSeekListener(false);
                if (IndicatorSeekBar.this.P != null && IndicatorSeekBar.this.S) {
                    IndicatorSeekBar.this.P.c();
                    IndicatorSeekBar.this.s();
                }
                IndicatorSeekBar.this.invalidate();
            }
        });
        return true;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.U.setVisibility(4);
        postDelayed(new Runnable() {
            public void run() {
                AlphaAnimation alphaAnimation = new AlphaAnimation(0.1f, 1.0f);
                alphaAnimation.setDuration(180);
                IndicatorSeekBar.this.U.setAnimation(alphaAnimation);
                IndicatorSeekBar.this.s();
                IndicatorSeekBar.this.U.setVisibility(0);
            }
        }, 300);
    }

    public void a(ArrayList<EditorData> arrayList) {
        this.aJ = arrayList;
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        ViewParent parent = getParent();
        if (parent == null) {
            return super.dispatchTouchEvent(motionEvent);
        }
        int action = motionEvent.getAction();
        if (action == 0) {
            parent.requestDisallowInterceptTouchEvent(true);
        } else if (action == 1 || action == 3) {
            parent.requestDisallowInterceptTouchEvent(false);
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public c getIndicator() {
        return this.P;
    }

    /* access modifiers changed from: package-private */
    public View getIndicatorContentView() {
        return this.U;
    }

    /* access modifiers changed from: package-private */
    public String getIndicatorTextString() {
        String[] strArr;
        String str = this.f23047aa;
        if (str == null || !str.contains("${TICK_TEXT}")) {
            String str2 = this.f23047aa;
            if (str2 != null && str2.contains("${PROGRESS}")) {
                return this.f23047aa.replace("${PROGRESS}", e(this.f23092u));
            }
        } else if (this.f23049ac > 2 && (strArr = this.F) != null) {
            return this.f23047aa.replace("${TICK_TEXT}", strArr[getThumbPosOnTick()]);
        }
        return e(this.f23092u);
    }

    public float getMax() {
        return this.f23090s;
    }

    public float getMin() {
        return this.f23091t;
    }

    public d getOnSeekChangeListener() {
        return this.f23075d;
    }

    public int getProgress() {
        return Math.round(this.f23092u);
    }

    public synchronized float getProgressFloat() {
        return BigDecimal.valueOf((double) this.f23092u).setScale(this.f23094w, 4).floatValue();
    }

    public int getTickCount() {
        return this.f23049ac;
    }

    /* access modifiers changed from: protected */
    public synchronized void onDraw(Canvas canvas) {
        a(canvas);
        b(canvas);
        c(canvas);
        d(canvas);
        e(canvas);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        setMeasuredDimension(resolveSize(f.a(this.f23046a, 170.0f), i2), Math.round(this.f23077f + ((float) getPaddingTop()) + ((float) getPaddingBottom())) + this.E);
        j();
        k();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            setProgress(bundle.getFloat("isb_progress"));
            super.onRestoreInstanceState(bundle.getParcelable("isb_instance_state"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("isb_instance_state", super.onSaveInstanceState());
        bundle.putFloat("isb_progress", this.f23092u);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        post(new Runnable() {
            public void run() {
                IndicatorSeekBar.this.requestLayout();
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        if (r0 != 3) goto L_0x0063;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            boolean r0 = r4.f23095x
            r1 = 0
            if (r0 == 0) goto L_0x0068
            boolean r0 = r4.isEnabled()
            if (r0 != 0) goto L_0x000c
            goto L_0x0068
        L_0x000c:
            int r0 = r5.getAction()
            r2 = 1
            if (r0 == 0) goto L_0x003a
            if (r0 == r2) goto L_0x0020
            r2 = 2
            if (r0 == r2) goto L_0x001c
            r2 = 3
            if (r0 == r2) goto L_0x0020
            goto L_0x0063
        L_0x001c:
            r4.a((android.view.MotionEvent) r5)
            goto L_0x0063
        L_0x0020:
            r4.f23089r = r1
            com.xeagle.android.editor.widget.indicatorSeekbar.d r0 = r4.f23075d
            if (r0 == 0) goto L_0x0029
            r0.b(r4)
        L_0x0029:
            boolean r0 = r4.t()
            if (r0 != 0) goto L_0x0032
            r4.invalidate()
        L_0x0032:
            com.xeagle.android.editor.widget.indicatorSeekbar.c r0 = r4.P
            if (r0 == 0) goto L_0x0063
            r0.d()
            goto L_0x0063
        L_0x003a:
            r4.performClick()
            float r0 = r5.getX()
            float r3 = r5.getY()
            boolean r3 = r4.a((float) r0, (float) r3)
            if (r3 == 0) goto L_0x0063
            boolean r3 = r4.f23096y
            if (r3 == 0) goto L_0x0056
            boolean r0 = r4.d((float) r0)
            if (r0 != 0) goto L_0x0056
            return r1
        L_0x0056:
            r4.f23089r = r2
            com.xeagle.android.editor.widget.indicatorSeekbar.d r0 = r4.f23075d
            if (r0 == 0) goto L_0x005f
            r0.a((com.xeagle.android.editor.widget.indicatorSeekbar.IndicatorSeekBar) r4)
        L_0x005f:
            r4.a((android.view.MotionEvent) r5)
            return r2
        L_0x0063:
            boolean r5 = super.onTouchEvent(r5)
            return r5
        L_0x0068:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.editor.widget.indicatorSeekbar.IndicatorSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean performClick() {
        return super.performClick();
    }

    public void setDecimalScale(int i2) {
        this.f23094w = i2;
    }

    public void setEnabled(boolean z2) {
        float f2;
        if (z2 != isEnabled()) {
            super.setEnabled(z2);
            if (isEnabled()) {
                f2 = 1.0f;
                setAlpha(1.0f);
                if (!this.S) {
                    return;
                }
            } else {
                f2 = 0.3f;
                setAlpha(0.3f);
                if (!this.S) {
                    return;
                }
            }
            this.U.setAlpha(f2);
        }
    }

    /* access modifiers changed from: package-private */
    public void setIndicatorStayAlways(boolean z2) {
        this.S = z2;
    }

    public void setIndicatorTextFormat(String str) {
        this.f23047aa = str;
        l();
        s();
    }

    public synchronized void setMax(float f2) {
        this.f23090s = Math.max(this.f23091t, f2);
        e();
        c();
        k();
        invalidate();
        s();
    }

    public synchronized void setMin(float f2) {
        this.f23091t = Math.min(this.f23090s, f2);
        e();
        c();
        k();
        invalidate();
        s();
    }

    public void setOnSeekChangeListener(d dVar) {
        this.f23075d = dVar;
    }

    public synchronized void setProgress(float f2) {
        this.f23078g = this.f23092u;
        float f3 = this.f23091t;
        if (f2 >= f3) {
            f3 = this.f23090s;
            if (f2 > f3) {
            }
            this.f23092u = f2;
            if (!this.f23097z && this.f23049ac > 2) {
                this.f23092u = this.A[getClosestIndex()];
            }
            setSeekListener(false);
            a(this.f23092u);
            postInvalidate();
            s();
        }
        f2 = f3;
        this.f23092u = f2;
        this.f23092u = this.A[getClosestIndex()];
        setSeekListener(false);
        a(this.f23092u);
        postInvalidate();
        s();
    }

    public void setR2L(boolean z2) {
        this.B = z2;
        requestLayout();
        invalidate();
        s();
    }

    public void setThumbAdjustAuto(boolean z2) {
        this.aI = z2;
    }

    public void setThumbDrawable(Drawable drawable) {
        if (drawable == null) {
            this.aB = null;
            this.f23071ay = null;
            this.aC = null;
        } else {
            this.aB = drawable;
            float min = ((float) Math.min(f.a(this.f23046a, 30.0f), this.aA)) / 2.0f;
            this.f23069aw = min;
            this.f23070ax = min;
            this.f23077f = Math.max(min, this.f23052af) * 2.0f;
            n();
        }
        requestLayout();
        invalidate();
    }

    public synchronized void setTickCount(int i2) {
        int i3 = this.f23049ac;
        if (i3 < 0 || i3 > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.f23049ac);
        }
        this.f23049ac = i2;
        c();
        l();
        j();
        k();
        invalidate();
        s();
    }

    public void setTickMarksDrawable(Drawable drawable) {
        if (drawable == null) {
            this.f23055ai = null;
            this.f23053ag = null;
            this.f23054ah = null;
        } else {
            this.f23055ai = drawable;
            float min = ((float) Math.min(f.a(this.f23046a, 30.0f), this.f23059am)) / 2.0f;
            this.f23052af = min;
            this.f23077f = Math.max(this.f23070ax, min) * 2.0f;
            o();
        }
        invalidate();
    }

    public void setUserSeekAble(boolean z2) {
        this.f23095x = z2;
    }
}
