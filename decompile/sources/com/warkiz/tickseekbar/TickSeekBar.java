package com.warkiz.tickseekbar;

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
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import com.amap.api.mapcore.util.fx;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;

public class TickSeekBar extends View {
    private int A;
    private String[] B;
    private float[] C;
    private float[] D;
    private float E;
    private int F;
    private Typeface G;
    private int H;
    private int I;
    private int J;
    private int K;
    private CharSequence[] L;
    private float[] M;
    private int N;
    private int O;
    private int P;
    private float Q;
    private Bitmap R;
    private Bitmap S;
    private Drawable T;
    private int U;
    private boolean V;
    private boolean W;

    /* renamed from: a  reason: collision with root package name */
    private Context f21992a;
    private float aA;
    private long aB;

    /* renamed from: aa  reason: collision with root package name */
    private int f21993aa;

    /* renamed from: ab  reason: collision with root package name */
    private boolean f21994ab;

    /* renamed from: ac  reason: collision with root package name */
    private RectF f21995ac;

    /* renamed from: ad  reason: collision with root package name */
    private RectF f21996ad;

    /* renamed from: ae  reason: collision with root package name */
    private int f21997ae;

    /* renamed from: af  reason: collision with root package name */
    private int f21998af;

    /* renamed from: ag  reason: collision with root package name */
    private int f21999ag;

    /* renamed from: ah  reason: collision with root package name */
    private int f22000ah;

    /* renamed from: ai  reason: collision with root package name */
    private int[] f22001ai;

    /* renamed from: aj  reason: collision with root package name */
    private boolean f22002aj;

    /* renamed from: ak  reason: collision with root package name */
    private float f22003ak;

    /* renamed from: al  reason: collision with root package name */
    private float f22004al;

    /* renamed from: am  reason: collision with root package name */
    private Bitmap f22005am;

    /* renamed from: an  reason: collision with root package name */
    private int f22006an;

    /* renamed from: ao  reason: collision with root package name */
    private int f22007ao;

    /* renamed from: ap  reason: collision with root package name */
    private Drawable f22008ap;

    /* renamed from: aq  reason: collision with root package name */
    private Bitmap f22009aq;

    /* renamed from: ar  reason: collision with root package name */
    private int f22010ar;

    /* renamed from: as  reason: collision with root package name */
    private int f22011as;

    /* renamed from: at  reason: collision with root package name */
    private float f22012at;

    /* renamed from: au  reason: collision with root package name */
    private int f22013au;

    /* renamed from: av  reason: collision with root package name */
    private boolean f22014av;

    /* renamed from: aw  reason: collision with root package name */
    private d f22015aw;

    /* renamed from: ax  reason: collision with root package name */
    private int f22016ax;

    /* renamed from: ay  reason: collision with root package name */
    private boolean f22017ay;

    /* renamed from: az  reason: collision with root package name */
    private float f22018az;

    /* renamed from: b  reason: collision with root package name */
    private Paint f22019b;

    /* renamed from: c  reason: collision with root package name */
    private TextPaint f22020c;

    /* renamed from: d  reason: collision with root package name */
    private c f22021d;

    /* renamed from: e  reason: collision with root package name */
    private Rect f22022e;

    /* renamed from: f  reason: collision with root package name */
    private float f22023f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public float f22024g;

    /* renamed from: h  reason: collision with root package name */
    private float f22025h;

    /* renamed from: i  reason: collision with root package name */
    private int f22026i;

    /* renamed from: j  reason: collision with root package name */
    private int f22027j;

    /* renamed from: k  reason: collision with root package name */
    private int f22028k;

    /* renamed from: l  reason: collision with root package name */
    private int f22029l;

    /* renamed from: m  reason: collision with root package name */
    private float f22030m;

    /* renamed from: n  reason: collision with root package name */
    private float f22031n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f22032o;

    /* renamed from: p  reason: collision with root package name */
    private float f22033p;

    /* renamed from: q  reason: collision with root package name */
    private float f22034q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public float f22035r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f22036s;

    /* renamed from: t  reason: collision with root package name */
    private boolean f22037t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f22038u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f22039v;
    /* access modifiers changed from: private */

    /* renamed from: w  reason: collision with root package name */
    public float[] f22040w;

    /* renamed from: x  reason: collision with root package name */
    private boolean f22041x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f22042y;

    /* renamed from: z  reason: collision with root package name */
    private int f22043z;

    public TickSeekBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public TickSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TickSeekBar(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f22025h = -1.0f;
        this.f22016ax = 1;
        this.aB = 0;
        this.f21992a = context;
        a(context, attributeSet);
        a();
    }

    private int a(Drawable drawable, int i2) {
        return Math.round(((((float) i2) * 1.0f) * ((float) drawable.getIntrinsicHeight())) / ((float) drawable.getIntrinsicWidth()));
    }

    private Bitmap a(Drawable drawable, boolean z2) {
        int i2;
        if (drawable == null) {
            return null;
        }
        int a2 = e.a(this.f21992a, 30.0f);
        if (drawable.getIntrinsicWidth() > a2) {
            int i3 = z2 ? this.f22007ao : this.f21993aa;
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

    private d a(boolean z2) {
        String[] strArr;
        if (this.f22015aw == null) {
            this.f22015aw = new d(this);
        }
        this.f22015aw.f22076b = getProgress();
        this.f22015aw.f22077c = getProgressFloat();
        this.f22015aw.f22078d = z2;
        if (this.N > 2) {
            int thumbPosOnTick = getThumbPosOnTick();
            if (!(this.f22043z == 0 || (strArr = this.B) == null)) {
                this.f22015aw.f22080f = strArr[thumbPosOnTick];
            }
            if (this.f22041x) {
                this.f22015aw.f22079e = (this.N - thumbPosOnTick) - 1;
            } else {
                this.f22015aw.f22079e = thumbPosOnTick;
            }
        }
        return this.f22015aw;
    }

    private String a(int i2) {
        CharSequence[] charSequenceArr = this.L;
        return charSequenceArr == null ? d(this.f22040w[i2]) : i2 < charSequenceArr.length ? String.valueOf(charSequenceArr[i2]) : "";
    }

    private void a() {
        float f2;
        int i2 = this.N;
        if (i2 < 0 || i2 > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between 0-50, Now is " + this.N);
        }
        d();
        int i3 = this.f21997ae;
        int i4 = this.f21998af;
        if (i3 > i4) {
            this.f21997ae = i4;
        }
        if (this.f22008ap == null) {
            float f3 = ((float) this.f22007ao) / 2.0f;
            this.f22003ak = f3;
            f2 = f3 * 1.2f;
        } else {
            f2 = ((float) Math.min(e.a(this.f21992a, 30.0f), this.f22007ao)) / 2.0f;
            this.f22003ak = f2;
        }
        this.f22004al = f2;
        this.Q = ((float) (this.T == null ? this.f21993aa : Math.min(e.a(this.f21992a, 30.0f), this.f21993aa))) / 2.0f;
        this.f22023f = Math.max(this.f22004al, this.Q) * 2.0f;
        e();
        l();
        this.f22024g = this.f22035r;
        b();
        this.f21995ac = new RectF();
        this.f21996ad = new RectF();
        c();
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
                this.G = typeface;
                return;
            }
            this.G = typeface2;
        }
        typeface2 = Typeface.DEFAULT;
        this.G = typeface2;
    }

    private void a(Context context, AttributeSet attributeSet) {
        a aVar = new a(context);
        if (attributeSet == null) {
            a(aVar);
            return;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.TickSeekBar);
        this.f22033p = obtainStyledAttributes.getFloat(R.styleable.TickSeekBar_tsb_max, aVar.f22049b);
        this.f22034q = obtainStyledAttributes.getFloat(R.styleable.TickSeekBar_tsb_min, aVar.f22050c);
        this.f22035r = obtainStyledAttributes.getFloat(R.styleable.TickSeekBar_tsb_progress, aVar.f22051d);
        this.f22036s = obtainStyledAttributes.getBoolean(R.styleable.TickSeekBar_tsb_progress_value_float, aVar.f22052e);
        this.f22037t = obtainStyledAttributes.getBoolean(R.styleable.TickSeekBar_tsb_user_seekable, aVar.f22055h);
        this.f22014av = obtainStyledAttributes.getBoolean(R.styleable.TickSeekBar_tsb_clear_default_padding, aVar.J);
        this.f22038u = obtainStyledAttributes.getBoolean(R.styleable.TickSeekBar_tsb_only_thumb_draggable, aVar.f22056i);
        this.f22039v = obtainStyledAttributes.getBoolean(R.styleable.TickSeekBar_tsb_seek_smoothly, aVar.f22053f);
        this.f22041x = obtainStyledAttributes.getBoolean(R.styleable.TickSeekBar_tsb_r2l, aVar.f22054g);
        this.f22042y = obtainStyledAttributes.getBoolean(R.styleable.TickSeekBar_tsb_show_line, false);
        this.f21997ae = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TickSeekBar_tsb_track_background_size, aVar.f22057j);
        this.f21998af = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TickSeekBar_tsb_track_progress_size, aVar.f22059l);
        this.f21999ag = obtainStyledAttributes.getColor(R.styleable.TickSeekBar_tsb_track_background_color, aVar.f22058k);
        this.f22000ah = obtainStyledAttributes.getColor(R.styleable.TickSeekBar_tsb_track_progress_color, aVar.f22060m);
        this.f21994ab = obtainStyledAttributes.getBoolean(R.styleable.TickSeekBar_tsb_track_rounded_corners, aVar.f22061n);
        this.f22007ao = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TickSeekBar_tsb_thumb_size, aVar.f22064q);
        this.f22008ap = obtainStyledAttributes.getDrawable(R.styleable.TickSeekBar_tsb_thumb_drawable);
        a(obtainStyledAttributes.getColorStateList(R.styleable.TickSeekBar_tsb_thumb_color), aVar.f22065r);
        this.f22017ay = obtainStyledAttributes.getBoolean(R.styleable.TickSeekBar_tsb_thumb_adjust_auto, aVar.f22066s);
        this.f22011as = obtainStyledAttributes.getInt(R.styleable.TickSeekBar_tsb_show_thumb_text, aVar.f22063p);
        this.f22013au = obtainStyledAttributes.getColor(R.styleable.TickSeekBar_tsb_thumb_text_color, aVar.f22062o);
        this.N = obtainStyledAttributes.getInt(R.styleable.TickSeekBar_tsb_ticks_count, aVar.B);
        this.U = obtainStyledAttributes.getInt(R.styleable.TickSeekBar_tsb_show_tick_marks_type, aVar.C);
        this.f21993aa = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TickSeekBar_tsb_tick_marks_size, aVar.E);
        b(obtainStyledAttributes.getColorStateList(R.styleable.TickSeekBar_tsb_tick_marks_color), aVar.D);
        this.T = obtainStyledAttributes.getDrawable(R.styleable.TickSeekBar_tsb_tick_marks_drawable);
        this.W = obtainStyledAttributes.getBoolean(R.styleable.TickSeekBar_tsb_tick_marks_swept_hide, aVar.H);
        this.V = obtainStyledAttributes.getBoolean(R.styleable.TickSeekBar_tsb_tick_marks_ends_hide, aVar.G);
        this.f22043z = obtainStyledAttributes.getInt(R.styleable.TickSeekBar_tsb_show_tick_texts, 0);
        this.F = obtainStyledAttributes.getDimensionPixelSize(R.styleable.TickSeekBar_tsb_tick_texts_size, aVar.f22071x);
        c(obtainStyledAttributes.getColorStateList(R.styleable.TickSeekBar_tsb_tick_texts_color), aVar.f22070w);
        this.L = obtainStyledAttributes.getTextArray(R.styleable.TickSeekBar_tsb_tick_texts_array);
        a(obtainStyledAttributes.getInt(R.styleable.TickSeekBar_tsb_tick_texts_typeface, -1), aVar.f22073z);
        obtainStyledAttributes.recycle();
    }

    private void a(ColorStateList colorStateList, int i2) {
        if (colorStateList == null) {
            this.f22006an = i2;
            this.f22010ar = i2;
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
                    this.f22006an = i3;
                    this.f22010ar = i3;
                } else if (iArr.length == 2) {
                    for (int i4 = 0; i4 < iArr.length; i4++) {
                        int[] iArr3 = iArr[i4];
                        if (iArr3.length == 0) {
                            this.f22010ar = iArr2[i4];
                        } else if (iArr3[0] == 16842919) {
                            this.f22006an = iArr2[i4];
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
        if (this.f22002aj) {
            int i4 = this.N;
            int i5 = i4 + -1 > 0 ? i4 - 1 : 1;
            for (int i6 = 0; i6 < i5; i6++) {
                if (this.f22041x) {
                    paint = this.f22019b;
                    i2 = this.f22001ai[(i5 - i6) - 1];
                } else {
                    paint = this.f22019b;
                    i2 = this.f22001ai[i6];
                }
                paint.setColor(i2);
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                float f2 = (float) i6;
                if (f2 < thumbPosOnTickFloat) {
                    int i7 = i6 + 1;
                    if (thumbPosOnTickFloat < ((float) i7)) {
                        float thumbCenterX = getThumbCenterX();
                        this.f22019b.setStrokeWidth((float) getLeftSideTrackSize());
                        Canvas canvas2 = canvas;
                        canvas2.drawLine(this.M[i6], this.f21995ac.top, thumbCenterX, this.f21995ac.bottom, this.f22019b);
                        this.f22019b.setStrokeWidth((float) getRightSideTrackSize());
                        canvas2.drawLine(thumbCenterX, this.f21995ac.top, this.M[i7], this.f21995ac.bottom, this.f22019b);
                    }
                }
                if (f2 < thumbPosOnTickFloat) {
                    paint2 = this.f22019b;
                    i3 = getLeftSideTrackSize();
                } else {
                    paint2 = this.f22019b;
                    i3 = getRightSideTrackSize();
                }
                paint2.setStrokeWidth((float) i3);
                canvas.drawLine(this.M[i6], this.f21995ac.top, this.M[i6 + 1], this.f21995ac.bottom, this.f22019b);
            }
            return;
        }
        this.f22019b.setColor(this.f22000ah);
        this.f22019b.setStrokeWidth((float) this.f21998af);
        canvas.drawLine(this.f21995ac.left, this.f21995ac.top, this.f21995ac.right, this.f21995ac.bottom, this.f22019b);
        this.f22019b.setColor(this.f21999ag);
        this.f22019b.setStrokeWidth((float) this.f21997ae);
        canvas.drawLine(this.f21996ad.left, this.f21996ad.top, this.f21996ad.right, this.f21996ad.bottom, this.f22019b);
    }

    private void a(MotionEvent motionEvent) {
        a(b(c(b(motionEvent))));
        setSeekListener(true);
        invalidate();
    }

    private void a(a aVar) {
        this.f22033p = aVar.f22049b;
        this.f22034q = aVar.f22050c;
        this.f22035r = aVar.f22051d;
        this.f22036s = aVar.f22052e;
        this.f22039v = aVar.f22053f;
        this.f22041x = aVar.f22054g;
        this.f22037t = aVar.f22055h;
        this.f22014av = aVar.J;
        this.f22038u = aVar.f22056i;
        this.f21997ae = aVar.f22057j;
        this.f21999ag = aVar.f22058k;
        this.f21998af = aVar.f22059l;
        this.f22000ah = aVar.f22060m;
        this.f21994ab = aVar.f22061n;
        this.f22007ao = aVar.f22064q;
        this.f22008ap = aVar.f22068u;
        this.f22013au = aVar.f22062o;
        a(aVar.f22067t, aVar.f22065r);
        this.f22011as = aVar.f22063p;
        this.N = aVar.B;
        this.U = aVar.C;
        this.f21993aa = aVar.E;
        this.T = aVar.F;
        this.V = aVar.G;
        this.W = aVar.H;
        b(aVar.I, aVar.D);
        this.f22043z = aVar.f22069v;
        this.F = aVar.f22071x;
        this.L = aVar.f22072y;
        this.G = aVar.f22073z;
        c(aVar.A, aVar.f22070w);
    }

    private boolean a(float f2, float f3) {
        if (this.f22025h == -1.0f) {
            this.f22025h = (float) e.a(this.f21992a, 1.0f);
        }
        float f4 = this.f22025h;
        return ((f2 > (((float) this.f22026i) - (f4 * 2.0f)) ? 1 : (f2 == (((float) this.f22026i) - (f4 * 2.0f)) ? 0 : -1)) >= 0 && (f2 > (((float) (this.f22028k - this.f22027j)) + (f4 * 2.0f)) ? 1 : (f2 == (((float) (this.f22028k - this.f22027j)) + (f4 * 2.0f)) ? 0 : -1)) <= 0) && ((f3 > ((this.f21995ac.top - this.f22004al) - this.f22025h) ? 1 : (f3 == ((this.f21995ac.top - this.f22004al) - this.f22025h) ? 0 : -1)) >= 0 && (f3 > ((this.f21995ac.top + this.f22004al) + this.f22025h) ? 1 : (f3 == ((this.f21995ac.top + this.f22004al) + this.f22025h) ? 0 : -1)) <= 0);
    }

    private float b(float f2) {
        this.f22024g = this.f22035r;
        float f3 = this.f22034q;
        float f4 = f3 + (((this.f22033p - f3) * (f2 - ((float) this.f22026i))) / this.f22030m);
        this.f22035r = f4;
        return f4;
    }

    private float b(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        int i2 = this.f22026i;
        if (x2 >= ((float) i2)) {
            float x3 = motionEvent.getX();
            int i3 = this.f22028k;
            int i4 = this.f22027j;
            if (x3 <= ((float) (i3 - i4))) {
                return motionEvent.getX();
            }
            i2 = i3 - i4;
        }
        return (float) i2;
    }

    private void b() {
        int i2 = this.N;
        if (i2 < 0 || i2 > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.N);
        } else if (i2 != 0) {
            this.M = new float[i2];
            if (this.f22043z != 0) {
                this.D = new float[i2];
                this.C = new float[i2];
            }
            this.f22040w = new float[i2];
            int i3 = 0;
            while (true) {
                float[] fArr = this.f22040w;
                if (i3 < fArr.length) {
                    float f2 = this.f22034q;
                    float f3 = ((float) i3) * (this.f22033p - f2);
                    int i4 = this.N;
                    fArr[i3] = f2 + (f3 / ((float) (i4 + -1 > 0 ? i4 - 1 : 1)));
                    i3++;
                } else {
                    return;
                }
            }
        }
    }

    private void b(ColorStateList colorStateList, int i2) {
        if (colorStateList == null) {
            this.P = i2;
            this.O = i2;
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
                    this.P = i3;
                    this.O = i3;
                } else if (iArr.length == 2) {
                    for (int i4 = 0; i4 < iArr.length; i4++) {
                        int[] iArr3 = iArr[i4];
                        if (iArr3.length == 0) {
                            this.O = iArr2[i4];
                        } else if (iArr3[0] == 16842913) {
                            this.P = iArr2[i4];
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
        if (this.N == 0) {
            return;
        }
        if (this.U != 0 || this.T != null) {
            float thumbCenterX = getThumbCenterX();
            for (int i3 = 0; i3 < this.M.length; i3++) {
                float thumbPosOnTickFloat = getThumbPosOnTickFloat();
                if ((!this.W || thumbCenterX < this.M[i3]) && ((!this.V || !(i3 == 0 || i3 == this.M.length - 1)) && (i3 != getThumbPosOnTick() || this.N <= 2 || this.f22039v))) {
                    float f7 = (float) i3;
                    if (f7 <= thumbPosOnTickFloat) {
                        paint = this.f22019b;
                        i2 = getLeftSideTickColor();
                    } else {
                        paint = this.f22019b;
                        i2 = getRightSideTickColor();
                    }
                    paint.setColor(i2);
                    if (this.T != null) {
                        if (this.S == null || this.R == null) {
                            k();
                        }
                        Bitmap bitmap2 = this.S;
                        if (bitmap2 == null || (bitmap = this.R) == null) {
                            throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
                        } else if (f7 <= thumbPosOnTickFloat) {
                            canvas.drawBitmap(bitmap2, this.M[i3] - (((float) bitmap.getWidth()) / 2.0f), this.f21995ac.top - (((float) this.R.getHeight()) / 2.0f), this.f22019b);
                        } else {
                            canvas.drawBitmap(bitmap, this.M[i3] - (((float) bitmap.getWidth()) / 2.0f), this.f21995ac.top - (((float) this.R.getHeight()) / 2.0f), this.f22019b);
                        }
                    } else {
                        int i4 = this.U;
                        if (i4 == 1) {
                            canvas.drawCircle(this.M[i3], this.f21995ac.top, this.Q, this.f22019b);
                        } else {
                            if (i4 == 3) {
                                int a2 = e.a(this.f21992a, 1.0f);
                                int leftSideTrackSize = thumbCenterX >= this.M[i3] ? getLeftSideTrackSize() : getRightSideTrackSize();
                                float f8 = (float) a2;
                                f4 = this.M[i3] - f8;
                                f5 = ((float) leftSideTrackSize) / 2.0f;
                                f3 = this.f21995ac.top - f5;
                                f2 = this.M[i3] + f8;
                                f6 = this.f21995ac.top;
                            } else if (i4 == 2) {
                                f4 = this.M[i3] - (((float) this.f21993aa) / 2.0f);
                                float f9 = this.f21995ac.top;
                                int i5 = this.f21993aa;
                                f3 = f9 - (((float) i5) / 2.0f);
                                f2 = this.M[i3] + (((float) i5) / 2.0f);
                                f6 = this.f21995ac.top;
                                f5 = ((float) this.f21993aa) / 2.0f;
                            }
                            canvas.drawRect(f4, f3, f2, f6 + f5, this.f22019b);
                        }
                    }
                }
            }
        }
    }

    private float c(float f2) {
        if (this.N > 2 && !this.f22039v) {
            f2 = ((float) this.f22026i) + (this.f22031n * ((float) Math.round((f2 - ((float) this.f22026i)) / this.f22031n)));
        }
        return this.f22041x ? (this.f22030m - f2) + ((float) (this.f22026i * 2)) : f2;
    }

    private void c() {
        if (!this.f22014av) {
            int a2 = e.a(this.f21992a, 16.0f);
            if (getPaddingLeft() == 0) {
                setPadding(a2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
            }
            if (getPaddingRight() == 0) {
                setPadding(getPaddingLeft(), getPaddingTop(), a2, getPaddingBottom());
            }
        }
    }

    private void c(ColorStateList colorStateList, int i2) {
        if (colorStateList == null) {
            this.H = i2;
            this.I = i2;
            this.J = i2;
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
                    this.H = i3;
                    this.I = i3;
                    this.J = i3;
                } else if (iArr.length == 3) {
                    for (int i4 = 0; i4 < iArr.length; i4++) {
                        int[] iArr3 = iArr[i4];
                        if (iArr3.length == 0) {
                            this.H = iArr2[i4];
                        } else {
                            int i5 = iArr3[0];
                            if (i5 == 16842913) {
                                this.I = iArr2[i4];
                            } else if (i5 == 16843623) {
                                this.J = iArr2[i4];
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

    /* JADX WARNING: Removed duplicated region for block: B:19:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x004b  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0052  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00c3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void c(android.graphics.Canvas r17) {
        /*
            r16 = this;
            r0 = r16
            r7 = r17
            java.lang.String[] r1 = r0.B
            if (r1 != 0) goto L_0x0009
            return
        L_0x0009:
            float r8 = r16.getThumbPosOnTickFloat()
            r9 = 0
            r10 = 0
        L_0x000f:
            java.lang.String[] r1 = r0.B
            int r1 = r1.length
            if (r10 >= r1) goto L_0x00fa
            int r1 = r16.getThumbPosOnTick()
            if (r10 != r1) goto L_0x002a
            boolean r1 = r16.q()
            if (r1 == 0) goto L_0x0026
            android.text.TextPaint r1 = r0.f22020c
            r1.setColor(r9)
            goto L_0x003f
        L_0x0026:
            android.text.TextPaint r1 = r0.f22020c
            r2 = -1
            goto L_0x003c
        L_0x002a:
            float r1 = (float) r10
            int r1 = (r1 > r8 ? 1 : (r1 == r8 ? 0 : -1))
            if (r1 >= 0) goto L_0x0036
            android.text.TextPaint r1 = r0.f22020c
            int r2 = r16.getLeftSideTickTextsColor()
            goto L_0x003c
        L_0x0036:
            android.text.TextPaint r1 = r0.f22020c
            int r2 = r16.getRightSideTickTextsColor()
        L_0x003c:
            r1.setColor(r2)
        L_0x003f:
            boolean r1 = r0.f22041x
            if (r1 == 0) goto L_0x004b
            java.lang.String[] r1 = r0.B
            int r1 = r1.length
            int r1 = r1 + -1
            int r1 = r1 - r10
            r11 = r1
            goto L_0x004c
        L_0x004b:
            r11 = r10
        L_0x004c:
            boolean r1 = r0.f22042y
            r12 = 1073741824(0x40000000, float:2.0)
            if (r1 == 0) goto L_0x00c3
            android.content.Context r1 = r0.f21992a
            r2 = 1065353216(0x3f800000, float:1.0)
            int r1 = com.warkiz.tickseekbar.e.a(r1, r2)
            android.content.Context r3 = r0.f21992a
            r4 = 1086324736(0x40c00000, float:6.0)
            int r3 = com.warkiz.tickseekbar.e.a(r3, r4)
            float r13 = (float) r3
            android.content.Context r3 = r0.f21992a
            r4 = 1092616192(0x41200000, float:10.0)
            int r3 = com.warkiz.tickseekbar.e.a(r3, r4)
            android.content.Context r4 = r0.f21992a
            int r14 = com.warkiz.tickseekbar.e.a(r4, r2)
            float[] r2 = r0.M
            r2 = r2[r10]
            float r1 = (float) r1
            float r2 = r2 - r1
            android.graphics.RectF r4 = r0.f21995ac
            float r4 = r4.bottom
            float r15 = (float) r3
            float r3 = r4 + r15
            float[] r4 = r0.M
            r4 = r4[r10]
            float r4 = r4 + r1
            android.graphics.RectF r1 = r0.f21995ac
            float r1 = r1.bottom
            float r1 = r1 + r13
            float r5 = r1 + r15
            android.text.TextPaint r6 = r0.f22020c
            r1 = r17
            r1.drawRect(r2, r3, r4, r5, r6)
            java.lang.String[] r1 = r0.B
            if (r10 != 0) goto L_0x00a8
            r1 = r1[r11]
            float[] r2 = r0.D
            r2 = r2[r10]
            float[] r3 = r0.C
            r3 = r3[r11]
            float r3 = r3 / r12
            float r2 = r2 + r3
            float r3 = r0.f22012at
        L_0x00a3:
            float r3 = r3 + r15
            float r4 = (float) r14
            float r3 = r3 + r4
            float r3 = r3 + r13
            goto L_0x00d5
        L_0x00a8:
            int r2 = r1.length
            int r2 = r2 + -1
            if (r10 != r2) goto L_0x00ba
            r1 = r1[r11]
            float[] r2 = r0.D
            r2 = r2[r10]
            float[] r3 = r0.C
            r3 = r3[r11]
            float r3 = r3 / r12
            float r2 = r2 - r3
            goto L_0x00c0
        L_0x00ba:
            r1 = r1[r11]
            float[] r2 = r0.D
            r2 = r2[r10]
        L_0x00c0:
            float r3 = r0.E
            goto L_0x00a3
        L_0x00c3:
            java.lang.String[] r1 = r0.B
            if (r10 != 0) goto L_0x00db
            r1 = r1[r11]
            float[] r2 = r0.D
            r2 = r2[r10]
            float[] r3 = r0.C
            r3 = r3[r11]
            float r3 = r3 / r12
            float r2 = r2 + r3
            float r3 = r0.f22012at
        L_0x00d5:
            android.text.TextPaint r4 = r0.f22020c
            r7.drawText(r1, r2, r3, r4)
            goto L_0x00f6
        L_0x00db:
            int r2 = r1.length
            int r2 = r2 + -1
            if (r10 != r2) goto L_0x00ed
            r1 = r1[r11]
            float[] r2 = r0.D
            r2 = r2[r10]
            float[] r3 = r0.C
            r3 = r3[r11]
            float r3 = r3 / r12
            float r2 = r2 - r3
            goto L_0x00f3
        L_0x00ed:
            r1 = r1[r11]
            float[] r2 = r0.D
            r2 = r2[r10]
        L_0x00f3:
            float r3 = r0.E
            goto L_0x00d5
        L_0x00f6:
            int r10 = r10 + 1
            goto L_0x000f
        L_0x00fa:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.warkiz.tickseekbar.TickSeekBar.c(android.graphics.Canvas):void");
    }

    private String d(float f2) {
        return this.f22036s ? b.a((double) f2, this.f22016ax) : String.valueOf(Math.round(f2));
    }

    private void d() {
        float f2 = this.f22033p;
        float f3 = this.f22034q;
        if (f2 >= f3) {
            if (this.f22035r < f3) {
                this.f22035r = f3;
            }
            if (this.f22035r > f2) {
                this.f22035r = f2;
                return;
            }
            return;
        }
        throw new IllegalArgumentException("the Argument: MAX's value must be larger than MIN's.");
    }

    private void d(Canvas canvas) {
        int i2;
        Paint paint;
        Bitmap bitmap;
        float f2;
        Bitmap bitmap2;
        float f3;
        float thumbCenterX = getThumbCenterX();
        if (this.f22008ap != null) {
            if (this.f22005am == null || this.f22009aq == null) {
                j();
            }
            if (this.f22005am == null || this.f22009aq == null) {
                throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
            }
            this.f22019b.setAlpha(255);
            if (this.f22032o) {
                bitmap2 = this.f22009aq;
                f3 = thumbCenterX - (((float) bitmap2.getWidth()) / 2.0f);
                f2 = this.f21995ac.top;
                bitmap = this.f22009aq;
            } else {
                bitmap2 = this.f22005am;
                f3 = thumbCenterX - (((float) bitmap2.getWidth()) / 2.0f);
                f2 = this.f21995ac.top;
                bitmap = this.f22005am;
            }
            canvas.drawBitmap(bitmap2, f3, f2 - (((float) bitmap.getHeight()) / 2.0f), this.f22019b);
            return;
        }
        if (this.f22032o) {
            paint = this.f22019b;
            i2 = this.f22010ar;
        } else {
            paint = this.f22019b;
            i2 = this.f22006an;
        }
        paint.setColor(i2);
        canvas.drawCircle(thumbCenterX, this.f21995ac.top, this.f22032o ? this.f22004al : this.f22003ak, this.f22019b);
    }

    private void e() {
        if (this.f22019b == null) {
            this.f22019b = new Paint();
        }
        if (this.f21994ab) {
            this.f22019b.setStrokeCap(Paint.Cap.ROUND);
        }
        this.f22019b.setAntiAlias(true);
        int i2 = this.f21997ae;
        if (i2 > this.f21998af) {
            this.f21998af = i2;
        }
    }

    private void e(Canvas canvas) {
        float f2;
        float f3;
        String str;
        int i2 = this.f22011as;
        if (i2 != 0 && this.f22043z != i2) {
            this.f22020c.setColor(this.f22013au);
            if (q()) {
                str = this.B[getThumbPosOnTick()];
                f3 = getThumbCenterX();
                f2 = this.f22012at + this.f22023f;
            } else {
                str = d(this.f22035r);
                f3 = getThumbCenterX();
                f2 = this.f22012at;
            }
            canvas.drawText(str, f3, f2, this.f22020c);
        }
    }

    private boolean e(float f2) {
        float touchX = getTouchX();
        int i2 = this.f22007ao;
        return touchX - (((float) i2) / 2.0f) <= f2 && f2 <= touchX + (((float) i2) / 2.0f);
    }

    private void f() {
        int i2;
        this.f22028k = getMeasuredWidth();
        if (Build.VERSION.SDK_INT < 17) {
            this.f22026i = getPaddingLeft();
            i2 = getPaddingRight();
        } else {
            this.f22026i = getPaddingStart();
            i2 = getPaddingEnd();
        }
        this.f22027j = i2;
        this.f22029l = getPaddingTop();
        float f2 = (float) ((this.f22028k - this.f22026i) - this.f22027j);
        this.f22030m = f2;
        int i3 = this.N;
        int i4 = 1;
        if (i3 - 1 > 0) {
            i4 = i3 - 1;
        }
        this.f22031n = f2 / ((float) i4);
    }

    private void g() {
        i();
        o();
        if (this.M != null) {
            h();
            if (this.N > 2) {
                float f2 = this.f22040w[getClosestIndex()];
                this.f22035r = f2;
                this.f22024g = f2;
            }
            a(this.f22035r);
        }
    }

    private int getClosestIndex() {
        float abs = Math.abs(this.f22033p - this.f22034q);
        int i2 = 0;
        int i3 = 0;
        while (true) {
            float[] fArr = this.f22040w;
            if (i2 >= fArr.length) {
                return i3;
            }
            float abs2 = Math.abs(fArr[i2] - this.f22035r);
            if (abs2 <= abs) {
                i3 = i2;
                abs = abs2;
            }
            i2++;
        }
    }

    private int getLeftSideTickColor() {
        return this.f22041x ? this.O : this.P;
    }

    private int getLeftSideTickTextsColor() {
        return this.f22041x ? this.H : this.I;
    }

    private int getLeftSideTrackSize() {
        return this.f22041x ? this.f21997ae : this.f21998af;
    }

    private int getRightSideTickColor() {
        return this.f22041x ? this.P : this.O;
    }

    private int getRightSideTickTextsColor() {
        return this.f22041x ? this.H : this.H;
    }

    private int getRightSideTrackSize() {
        return this.f22041x ? this.f21998af : this.f21997ae;
    }

    private float getThumbCenterX() {
        return (this.f22041x ? this.f21996ad : this.f21995ac).right;
    }

    private int getThumbPosOnTick() {
        if (this.N != 0) {
            return Math.round((getThumbCenterX() - ((float) this.f22026i)) / this.f22031n);
        }
        return 0;
    }

    private float getThumbPosOnTickFloat() {
        if (this.N != 0) {
            return (getThumbCenterX() - ((float) this.f22026i)) / this.f22031n;
        }
        return 0.0f;
    }

    private void h() {
        if (this.M != null) {
            if (this.f22043z != 0) {
                this.B = new String[this.N];
            }
            for (int i2 = 0; i2 < this.M.length; i2++) {
                if (this.f22043z != 0) {
                    this.B[i2] = a(i2);
                    TextPaint textPaint = this.f22020c;
                    String[] strArr = this.B;
                    textPaint.getTextBounds(strArr[i2], 0, strArr[i2].length(), this.f22022e);
                    this.C[i2] = (float) this.f22022e.width();
                    this.D[i2] = ((float) this.f22026i) + (this.f22031n * ((float) i2));
                }
                this.M[i2] = ((float) this.f22026i) + (this.f22031n * ((float) i2));
            }
        }
    }

    private void i() {
        RectF rectF;
        RectF rectF2;
        if (this.f22041x) {
            this.f21996ad.left = (float) this.f22026i;
            if (q()) {
                this.f21996ad.top = ((float) this.f22029l) + this.f22004al + ((float) this.K) + ((float) e.a(this.f21992a, 3.0f));
            } else {
                this.f21996ad.top = ((float) this.f22029l) + this.f22004al;
            }
            RectF rectF3 = this.f21996ad;
            float f2 = this.f22030m;
            float f3 = this.f22035r;
            float f4 = this.f22034q;
            rectF3.right = ((float) this.f22026i) + (f2 * (1.0f - ((f3 - f4) / (this.f22033p - f4))));
            RectF rectF4 = this.f21996ad;
            rectF4.bottom = rectF4.top;
            this.f21995ac.left = this.f21996ad.right;
            this.f21995ac.top = this.f21996ad.top;
            this.f21995ac.right = (float) (this.f22028k - this.f22027j);
            rectF2 = this.f21995ac;
            rectF = this.f21996ad;
        } else {
            this.f21995ac.left = (float) this.f22026i;
            if (q()) {
                this.f21995ac.top = ((float) this.f22029l) + this.f22004al + ((float) this.K) + ((float) e.a(this.f21992a, 3.0f));
            } else {
                this.f21995ac.top = ((float) this.f22029l) + this.f22004al;
            }
            RectF rectF5 = this.f21995ac;
            float f5 = this.f22035r;
            float f6 = this.f22034q;
            rectF5.right = (((f5 - f6) * this.f22030m) / (this.f22033p - f6)) + ((float) this.f22026i);
            RectF rectF6 = this.f21995ac;
            rectF6.bottom = rectF6.top;
            this.f21996ad.left = this.f21995ac.right;
            this.f21996ad.top = this.f21995ac.bottom;
            this.f21996ad.right = (float) (this.f22028k - this.f22027j);
            rectF2 = this.f21996ad;
            rectF = this.f21995ac;
        }
        rectF2.bottom = rectF.bottom;
    }

    private void j() {
        Drawable drawable = this.f22008ap;
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
                                this.f22005am = a((Drawable) method2.invoke(stateListDrawable, new Object[]{Integer.valueOf(i2)}), true);
                            } else if (iArr[0] == 16842919) {
                                this.f22009aq = a((Drawable) method2.invoke(stateListDrawable, new Object[]{Integer.valueOf(i2)}), true);
                            } else {
                                throw new IllegalArgumentException("the state of the selector thumb drawable is wrong!");
                            }
                        }
                        return;
                    }
                    throw new IllegalArgumentException("the format of the selector thumb drawable is wrong!");
                } catch (Exception unused) {
                    drawable = this.f22008ap;
                }
            }
            Bitmap a2 = a(drawable, true);
            this.f22005am = a2;
            this.f22009aq = a2;
        }
    }

    private void k() {
        Drawable drawable = this.T;
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
                            this.R = a((Drawable) method2.invoke(stateListDrawable, new Object[]{Integer.valueOf(i2)}), false);
                        } else if (iArr[0] == 16842913) {
                            this.S = a((Drawable) method2.invoke(stateListDrawable, new Object[]{Integer.valueOf(i2)}), false);
                        } else {
                            throw new IllegalArgumentException("the state of the selector TickMarks drawable is wrong!");
                        }
                    }
                    return;
                }
                throw new IllegalArgumentException("the format of the selector TickMarks drawable is wrong!");
            } catch (Exception unused) {
                drawable = this.T;
            }
        }
        Bitmap a2 = a(drawable, false);
        this.R = a2;
        this.S = a2;
    }

    private void l() {
        if (m()) {
            n();
            this.f22020c.setTypeface(this.G);
            this.f22020c.getTextBounds(fx.f8869j, 0, 1, this.f22022e);
            this.A = this.f22022e.height() + e.a(this.f21992a, 3.0f);
        }
    }

    private boolean m() {
        return ((this.f22043z == 0 || this.N == 0) && this.f22011as == 0) ? false : true;
    }

    private void n() {
        if (this.f22020c == null) {
            TextPaint textPaint = new TextPaint();
            this.f22020c = textPaint;
            textPaint.setAntiAlias(true);
            this.f22020c.setTextAlign(Paint.Align.CENTER);
            this.f22020c.setTextSize((float) this.F);
        }
        if (this.f22022e == null) {
            this.f22022e = new Rect();
        }
    }

    private void o() {
        float round;
        if (m()) {
            this.f22020c.getTextBounds(fx.f8869j, 0, 1, this.f22022e);
            this.K = this.f22022e.height();
            if (!r()) {
                if (p()) {
                    round = ((float) this.f22029l) + this.f22023f + ((float) Math.round(((float) this.K) - this.f22020c.descent())) + ((float) e.a(this.f21992a, 3.0f));
                } else {
                    if (q()) {
                        round = (float) (this.f22029l + Math.round(((float) this.K) - this.f22020c.descent()) + e.a(this.f21992a, 3.0f));
                    }
                    this.f22012at = this.E;
                }
                this.E = round;
                this.f22012at = this.E;
            } else if (this.f22043z == 1) {
                this.f22012at = (float) (this.f22029l + Math.round(((float) this.K) - this.f22020c.descent()) + e.a(this.f21992a, 3.0f));
                this.E = ((float) (this.A + this.f22029l)) + this.f22023f + ((float) Math.round(((float) this.K) - this.f22020c.descent())) + ((float) e.a(this.f21992a, 3.0f));
            } else {
                this.E = (float) (this.f22029l + Math.round(((float) this.K) - this.f22020c.descent()) + e.a(this.f21992a, 3.0f));
                this.f22012at = ((float) (this.A + this.f22029l)) + this.f22023f + ((float) Math.round(((float) this.K) - this.f22020c.descent())) + ((float) e.a(this.f21992a, 3.0f));
            }
        }
    }

    private boolean p() {
        return (this.N != 0 && this.f22043z == 1) || this.f22011as == 1;
    }

    private boolean q() {
        return (this.N != 0 && this.f22043z == 2) || this.f22011as == 2;
    }

    private boolean r() {
        int i2 = this.N;
        if (i2 != 0 && this.f22043z == 2 && this.f22011as == 1) {
            return true;
        }
        return i2 != 0 && this.f22043z == 1 && this.f22011as == 2;
    }

    private boolean s() {
        if (this.N < 3 || !this.f22039v || !this.f22017ay) {
            return false;
        }
        final int closestIndex = getClosestIndex();
        final float f2 = this.f22035r;
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, Math.abs(f2 - this.f22040w[closestIndex])});
        ofFloat.start();
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float f2;
                TickSeekBar tickSeekBar;
                TickSeekBar tickSeekBar2 = TickSeekBar.this;
                float unused = tickSeekBar2.f22024g = tickSeekBar2.f22035r;
                if (f2 - TickSeekBar.this.f22040w[closestIndex] > 0.0f) {
                    tickSeekBar = TickSeekBar.this;
                    f2 = f2 - ((Float) valueAnimator.getAnimatedValue()).floatValue();
                } else {
                    tickSeekBar = TickSeekBar.this;
                    f2 = f2 + ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
                float unused2 = tickSeekBar.f22035r = f2;
                TickSeekBar tickSeekBar3 = TickSeekBar.this;
                tickSeekBar3.a(tickSeekBar3.f22035r);
                TickSeekBar.this.setSeekListener(false);
                TickSeekBar.this.invalidate();
            }
        });
        return true;
    }

    /* access modifiers changed from: private */
    public void setSeekListener(boolean z2) {
        if (this.f22021d != null && t()) {
            this.f22021d.a(a(z2));
        }
    }

    private boolean t() {
        return this.f22036s ? this.f22024g != this.f22035r : Math.round(this.f22024g) != Math.round(this.f22035r);
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        RectF rectF;
        RectF rectF2;
        if (this.f22041x) {
            RectF rectF3 = this.f21996ad;
            float f3 = this.f22030m;
            float f4 = this.f22034q;
            rectF3.right = ((float) this.f22026i) + (f3 * (1.0f - ((f2 - f4) / (this.f22033p - f4))));
            rectF = this.f21995ac;
            rectF2 = this.f21996ad;
        } else {
            RectF rectF4 = this.f21995ac;
            float f5 = this.f22034q;
            rectF4.right = (((f2 - f5) * this.f22030m) / (this.f22033p - f5)) + ((float) this.f22026i);
            rectF = this.f21996ad;
            rectF2 = this.f21995ac;
        }
        rectF.left = rectF2.right;
    }

    public void a(String[] strArr) {
        this.L = strArr;
        if (this.B != null) {
            int i2 = 0;
            while (i2 < this.B.length) {
                String valueOf = i2 < strArr.length ? String.valueOf(strArr[i2]) : "";
                int i3 = this.f22041x ? (this.N - 1) - i2 : i2;
                this.B[i3] = valueOf;
                TextPaint textPaint = this.f22020c;
                if (!(textPaint == null || this.f22022e == null)) {
                    textPaint.getTextBounds(valueOf, 0, valueOf.length(), this.f22022e);
                    this.C[i3] = (float) this.f22022e.width();
                }
                i2++;
            }
            invalidate();
        }
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

    public float getMax() {
        return this.f22033p;
    }

    public float getMin() {
        return this.f22034q;
    }

    public c getOnSeekChangeListener() {
        return this.f22021d;
    }

    public int getProgress() {
        return Math.round(this.f22035r);
    }

    public synchronized float getProgressFloat() {
        return BigDecimal.valueOf((double) this.f22035r).setScale(this.f22016ax, 4).floatValue();
    }

    public int getTickCount() {
        return this.N;
    }

    /* access modifiers changed from: package-private */
    public synchronized float getTouchX() {
        a(this.f22035r);
        if (this.f22041x) {
            return this.f21996ad.right;
        }
        return this.f21995ac.right;
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
        int i4;
        int i5;
        super.onMeasure(i2, i3);
        int round = Math.round(this.f22023f + ((float) getPaddingTop()) + ((float) getPaddingBottom()));
        if (r()) {
            i4 = resolveSize(e.a(this.f21992a, 170.0f), i2);
            i5 = this.A * 2;
        } else {
            i4 = resolveSize(e.a(this.f21992a, 170.0f), i2);
            i5 = this.A;
        }
        setMeasuredDimension(i4, round + i5);
        f();
        g();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            float f2 = bundle.getFloat("tsb_progress");
            this.f22035r = f2;
            setProgress(f2);
            super.onRestoreInstanceState(bundle.getParcelable("tsb_instance_state"));
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable("tsb_instance_state", super.onSaveInstanceState());
        bundle.putFloat("tsb_progress", this.f22035r);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        post(new Runnable() {
            public void run() {
                TickSeekBar.this.requestLayout();
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0019, code lost:
        if (r0 != 3) goto L_0x006e;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            boolean r0 = r5.f22037t
            r1 = 0
            if (r0 == 0) goto L_0x0073
            boolean r0 = r5.isEnabled()
            if (r0 != 0) goto L_0x000c
            goto L_0x0073
        L_0x000c:
            int r0 = r6.getAction()
            r2 = 1
            if (r0 == 0) goto L_0x0033
            if (r0 == r2) goto L_0x0020
            r2 = 2
            if (r0 == r2) goto L_0x001c
            r2 = 3
            if (r0 == r2) goto L_0x0020
            goto L_0x006e
        L_0x001c:
            r5.a((android.view.MotionEvent) r6)
            goto L_0x006e
        L_0x0020:
            com.warkiz.tickseekbar.c r0 = r5.f22021d
            if (r0 == 0) goto L_0x0027
            r0.b(r5)
        L_0x0027:
            r5.f22032o = r1
            boolean r0 = r5.s()
            if (r0 != 0) goto L_0x006e
            r5.invalidate()
            goto L_0x006e
        L_0x0033:
            r5.performClick()
            float r0 = r6.getX()
            float r3 = r6.getX()
            r5.f22018az = r3
            float r3 = r6.getY()
            r5.aA = r3
            long r3 = java.lang.System.currentTimeMillis()
            r5.aB = r3
            float r3 = r6.getY()
            boolean r3 = r5.a((float) r0, (float) r3)
            if (r3 == 0) goto L_0x006e
            boolean r3 = r5.f22038u
            if (r3 == 0) goto L_0x0061
            boolean r0 = r5.e((float) r0)
            if (r0 != 0) goto L_0x0061
            return r1
        L_0x0061:
            com.warkiz.tickseekbar.c r0 = r5.f22021d
            if (r0 == 0) goto L_0x0068
            r0.a((com.warkiz.tickseekbar.TickSeekBar) r5)
        L_0x0068:
            r5.f22032o = r2
            r5.a((android.view.MotionEvent) r6)
            return r2
        L_0x006e:
            boolean r6 = super.onTouchEvent(r6)
            return r6
        L_0x0073:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.warkiz.tickseekbar.TickSeekBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public boolean performClick() {
        return super.performClick();
    }

    public void setDecimalScale(int i2) {
        this.f22016ax = i2;
    }

    public void setEnabled(boolean z2) {
        if (z2 != isEnabled()) {
            super.setEnabled(z2);
            setAlpha(isEnabled() ? 1.0f : 0.3f);
        }
    }

    public synchronized void setMax(float f2) {
        this.f22033p = Math.max(this.f22034q, f2);
        d();
        g();
        invalidate();
    }

    public synchronized void setMin(float f2) {
        this.f22034q = Math.min(this.f22033p, f2);
        d();
        g();
        invalidate();
    }

    public void setOnSeekChangeListener(c cVar) {
        this.f22021d = cVar;
    }

    public void setPadding(int i2, int i3, int i4, int i5) {
        super.setPadding(i2, i3, i4, i5);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void setProgress(float r3) {
        /*
            r2 = this;
            monitor-enter(r2)
            float r0 = r2.f22035r     // Catch:{ all -> 0x0033 }
            r2.f22024g = r0     // Catch:{ all -> 0x0033 }
            float r0 = r2.f22034q     // Catch:{ all -> 0x0033 }
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 >= 0) goto L_0x000d
        L_0x000b:
            r3 = r0
            goto L_0x0014
        L_0x000d:
            float r0 = r2.f22033p     // Catch:{ all -> 0x0033 }
            int r1 = (r3 > r0 ? 1 : (r3 == r0 ? 0 : -1))
            if (r1 <= 0) goto L_0x0014
            goto L_0x000b
        L_0x0014:
            r2.f22035r = r3     // Catch:{ all -> 0x0033 }
            int r3 = r2.N     // Catch:{ all -> 0x0033 }
            r0 = 2
            if (r3 <= r0) goto L_0x0025
            float[] r3 = r2.f22040w     // Catch:{ all -> 0x0033 }
            int r0 = r2.getClosestIndex()     // Catch:{ all -> 0x0033 }
            r3 = r3[r0]     // Catch:{ all -> 0x0033 }
            r2.f22035r = r3     // Catch:{ all -> 0x0033 }
        L_0x0025:
            r3 = 0
            r2.setSeekListener(r3)     // Catch:{ all -> 0x0033 }
            float r3 = r2.f22035r     // Catch:{ all -> 0x0033 }
            r2.a((float) r3)     // Catch:{ all -> 0x0033 }
            r2.postInvalidate()     // Catch:{ all -> 0x0033 }
            monitor-exit(r2)
            return
        L_0x0033:
            r3 = move-exception
            monitor-exit(r2)
            goto L_0x0037
        L_0x0036:
            throw r3
        L_0x0037:
            goto L_0x0036
        */
        throw new UnsupportedOperationException("Method not decompiled: com.warkiz.tickseekbar.TickSeekBar.setProgress(float):void");
    }

    public void setR2L(boolean z2) {
        this.f22041x = z2;
        requestLayout();
        invalidate();
    }

    public void setThumbAdjustAuto(boolean z2) {
        this.f22017ay = z2;
    }

    public void setThumbDrawable(Drawable drawable) {
        this.f22008ap = drawable;
        float min = ((float) Math.min(e.a(this.f21992a, 30.0f), this.f22007ao)) / 2.0f;
        this.f22003ak = min;
        this.f22004al = min;
        this.f22023f = Math.max(min, this.Q) * 2.0f;
        j();
        requestLayout();
        invalidate();
    }

    public synchronized void setTickCount(int i2) {
        int i3 = this.N;
        if (i3 < 0 || i3 > 50) {
            throw new IllegalArgumentException("the Argument: TICK COUNT must be limited between (0-50), Now is " + this.N);
        }
        this.N = i2;
        b();
        h();
        f();
        g();
        invalidate();
    }

    public void setTickMarksDrawable(Drawable drawable) {
        this.T = drawable;
        float min = ((float) Math.min(e.a(this.f21992a, 30.0f), this.f21993aa)) / 2.0f;
        this.Q = min;
        this.f22023f = Math.max(this.f22004al, min) * 2.0f;
        k();
        invalidate();
    }
}
