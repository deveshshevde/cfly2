package com.xeagle.android.vjoystick;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.Display;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.WindowManager;
import android.view.animation.Interpolator;
import android.widget.FrameLayout;
import android.widget.Scroller;
import com.xeagle.R;
import java.util.Random;
import t.ad;
import t.l;

public class SlidingLayer extends FrameLayout {

    /* renamed from: e  reason: collision with root package name */
    private static final Interpolator f24870e = new Interpolator() {
        public float getInterpolation(float f2) {
            return ((float) Math.pow((double) (f2 - 1.0f), 5.0d)) + 1.0f;
        }
    };
    private a A;
    private int B;
    private int C;
    private boolean D;

    /* renamed from: a  reason: collision with root package name */
    protected int f24871a;

    /* renamed from: b  reason: collision with root package name */
    protected VelocityTracker f24872b;

    /* renamed from: c  reason: collision with root package name */
    protected int f24873c;

    /* renamed from: d  reason: collision with root package name */
    protected Bundle f24874d;

    /* renamed from: f  reason: collision with root package name */
    private Random f24875f;

    /* renamed from: g  reason: collision with root package name */
    private Scroller f24876g;

    /* renamed from: h  reason: collision with root package name */
    private int f24877h;

    /* renamed from: i  reason: collision with root package name */
    private Drawable f24878i;

    /* renamed from: j  reason: collision with root package name */
    private boolean f24879j;

    /* renamed from: k  reason: collision with root package name */
    private int f24880k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f24881l;

    /* renamed from: m  reason: collision with root package name */
    private int f24882m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f24883n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f24884o;

    /* renamed from: p  reason: collision with root package name */
    private boolean f24885p;

    /* renamed from: q  reason: collision with root package name */
    private boolean f24886q;

    /* renamed from: r  reason: collision with root package name */
    private boolean f24887r;

    /* renamed from: s  reason: collision with root package name */
    private boolean f24888s;

    /* renamed from: t  reason: collision with root package name */
    private int f24889t;

    /* renamed from: u  reason: collision with root package name */
    private float f24890u;

    /* renamed from: v  reason: collision with root package name */
    private float f24891v;

    /* renamed from: w  reason: collision with root package name */
    private float f24892w;

    /* renamed from: x  reason: collision with root package name */
    private float f24893x;

    /* renamed from: y  reason: collision with root package name */
    private boolean f24894y;

    /* renamed from: z  reason: collision with root package name */
    private boolean f24895z;

    static class SavedState extends View.BaseSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        Bundle f24896a;

        public SavedState(Parcel parcel) {
            super(parcel);
            this.f24896a = parcel.readBundle();
        }

        public SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeBundle(this.f24896a);
        }
    }

    public interface a {
        void a();

        void b();

        void c();

        void d();
    }

    public SlidingLayer(Context context) {
        this(context.getApplicationContext(), (AttributeSet) null);
    }

    public SlidingLayer(Context context, AttributeSet attributeSet) {
        this(context.getApplicationContext(), attributeSet, 0);
    }

    public SlidingLayer(Context context, AttributeSet attributeSet, int i2) {
        super(context.getApplicationContext(), attributeSet, i2);
        this.f24871a = -1;
        this.f24882m = 0;
        this.f24883n = true;
        this.f24884o = true;
        this.f24885p = true;
        this.f24886q = true;
        this.f24890u = -1.0f;
        this.f24891v = -1.0f;
        this.f24892w = -1.0f;
        this.f24893x = -1.0f;
        this.D = false;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SlidingLayer);
        setStickTo(obtainStyledAttributes.getInt(5, 0));
        int resourceId = obtainStyledAttributes.getResourceId(3, -1);
        if (resourceId != -1) {
            setShadowDrawable(resourceId);
        }
        setShadowWidth((int) obtainStyledAttributes.getDimension(4, 0.0f));
        this.f24883n = obtainStyledAttributes.getBoolean(0, true);
        this.f24884o = obtainStyledAttributes.getBoolean(2, true);
        setOffsetWidth(obtainStyledAttributes.getDimensionPixelOffset(1, 0));
        obtainStyledAttributes.recycle();
        b();
    }

    private int a(int i2, int i3) {
        int i4;
        int i5 = this.f24882m;
        if (i5 != 0) {
            return i5;
        }
        Display defaultDisplay = ((WindowManager) getContext().getSystemService("window")).getDefaultDisplay();
        boolean z2 = false;
        Class<Display> cls = Display.class;
        try {
            Point point = new Point();
            cls.getMethod("getSize", new Class[]{Point.class}).invoke(defaultDisplay, new Object[]{point});
            i4 = point.x;
        } catch (Exception unused) {
            i4 = defaultDisplay.getWidth();
        }
        boolean z3 = i2 == 0;
        if (i3 == i4) {
            z2 = true;
        }
        if (z3 == z2 && getLayoutParams().width == -1) {
            return -3;
        }
        return z3 ? -2 : -1;
    }

    private void a(MotionEvent motionEvent) {
        int b2 = l.b(motionEvent);
        if (l.b(motionEvent, b2) == this.f24871a) {
            int i2 = b2 == 0 ? 1 : 0;
            this.f24890u = l.c(motionEvent, i2);
            this.f24871a = l.b(motionEvent, i2);
            VelocityTracker velocityTracker = this.f24872b;
            if (velocityTracker != null) {
                velocityTracker.clear();
            }
        }
    }

    private void a(boolean z2, boolean z3) {
        a(true, z2, z3, 0, 0);
    }

    private void a(boolean z2, boolean z3, boolean z4) {
        a(z2, z3, z4, 0, 0);
    }

    private void a(boolean z2, boolean z3, boolean z4, int i2, int i3) {
        if (z4 || z2 != this.f24894y) {
            a aVar = this.A;
            if (z2) {
                if (aVar != null) {
                    aVar.a();
                }
            } else if (aVar != null) {
                aVar.b();
            }
            this.f24894y = z2;
            float width = this.f24890u - ((float) (getWidth() / 2));
            float height = this.f24891v - ((float) (getHeight() / 2));
            boolean z5 = this.f24882m == -3 && Math.abs(i2) < this.B && Math.abs(i3) < this.B;
            int[] b2 = b(z5 ? (int) width : i2, z5 ? (int) height : i3);
            if (z3) {
                a(b2[0], b2[1], Math.max(i2, i3));
                return;
            }
            d();
            scrollTo(b2[0], b2[1]);
            return;
        }
        setDrawingCacheEnabled(false);
    }

    private boolean a(float f2, float f3) {
        int i2;
        if ((this.f24894y && ((float) getLeft()) <= f3) || ((float) getRight()) >= f3) {
            int i3 = this.f24882m;
            if (i3 == -3) {
                return f2 != 0.0f;
            }
            if (i3 == -2) {
                return f2 < 0.0f;
            }
            if (i3 == -1) {
                return f2 > 0.0f;
            }
        }
        if (!this.f24894y && (i2 = this.f24880k) > 0 && f2 > 0.0f) {
            int i4 = this.f24882m;
            return i4 != -3 ? i4 != -2 ? i4 == -1 && f3 >= ((float) (getWidth() - this.f24880k)) && f2 < 0.0f : f3 <= ((float) i2) && f2 > 0.0f : f2 != 0.0f;
        }
        return false;
    }

    private boolean a(MotionEvent motionEvent, float f2) {
        int i2;
        int i3 = this.f24882m;
        if (i3 != -3 && i3 != -2 && i3 != -1) {
            return false;
        }
        boolean z2 = this.f24894y;
        if (z2) {
            return true;
        }
        if (z2 || (i2 = this.f24880k) <= 0) {
            return false;
        }
        return i3 != -2 ? i3 == -1 && f2 >= ((float) (getWidth() - this.f24880k)) : f2 <= ((float) i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0032, code lost:
        if (r12 <= 0) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0036, code lost:
        if (r12 > 0) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0050, code lost:
        if (r13 <= 0) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x0054, code lost:
        if (r13 > 0) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0072, code lost:
        if (r10 > ((float) ((-r9) / 2))) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x007a, code lost:
        if (r10 < ((float) (r9 / 2))) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x0091, code lost:
        if (java.lang.Math.abs(r11) < ((float) (r12 / 2))) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0099, code lost:
        if (r11 < ((float) (r12 / 2))) goto L_0x00a4;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x00a2, code lost:
        if (r11 > ((float) ((-r12) / 2))) goto L_0x00a4;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x003a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(boolean r9, float r10, float r11, int r12, int r13, int r14, int r15) {
        /*
            r8 = this;
            int r9 = r8.f24882m
            r0 = -3
            r1 = -1
            r2 = -2
            r3 = -4
            r4 = -5
            r5 = 0
            r6 = 1
            if (r9 == r4) goto L_0x001a
            if (r9 == r3) goto L_0x001a
            if (r9 == r0) goto L_0x0018
            if (r9 == r2) goto L_0x0015
            if (r9 == r1) goto L_0x0015
            r9 = 0
            goto L_0x0016
        L_0x0015:
            r9 = 1
        L_0x0016:
            r7 = 0
            goto L_0x001c
        L_0x0018:
            r9 = 1
            goto L_0x001b
        L_0x001a:
            r9 = 0
        L_0x001b:
            r7 = 1
        L_0x001c:
            if (r9 == 0) goto L_0x003a
            int r9 = java.lang.Math.abs(r14)
            int r14 = r8.C
            if (r9 <= r14) goto L_0x003a
            int r9 = java.lang.Math.abs(r12)
            int r14 = r8.B
            if (r9 <= r14) goto L_0x003a
            int r9 = r8.f24882m
            if (r9 != r1) goto L_0x0034
            if (r12 <= 0) goto L_0x00a4
        L_0x0034:
            if (r9 != r2) goto L_0x00a5
            if (r12 <= 0) goto L_0x00a5
            goto L_0x00a4
        L_0x003a:
            if (r7 == 0) goto L_0x0057
            int r9 = java.lang.Math.abs(r15)
            int r12 = r8.C
            if (r9 <= r12) goto L_0x0057
            int r9 = java.lang.Math.abs(r13)
            int r12 = r8.B
            if (r9 <= r12) goto L_0x0057
            int r9 = r8.f24882m
            if (r9 != r4) goto L_0x0052
            if (r13 <= 0) goto L_0x00a4
        L_0x0052:
            if (r9 != r3) goto L_0x00a5
            if (r13 <= 0) goto L_0x00a5
            goto L_0x00a4
        L_0x0057:
            int r9 = r8.getWidth()
            int r12 = r8.getHeight()
            int r13 = r8.f24882m
            if (r13 == r4) goto L_0x009c
            if (r13 == r3) goto L_0x0094
            if (r13 == r0) goto L_0x007d
            if (r13 == r2) goto L_0x0075
            if (r13 == r1) goto L_0x006c
            goto L_0x00a6
        L_0x006c:
            int r9 = -r9
            int r9 = r9 / 2
            float r9 = (float) r9
            int r9 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
            if (r9 <= 0) goto L_0x00a5
            goto L_0x00a4
        L_0x0075:
            int r9 = r9 / 2
            float r9 = (float) r9
            int r9 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
            if (r9 >= 0) goto L_0x00a5
            goto L_0x00a4
        L_0x007d:
            float r10 = java.lang.Math.abs(r10)
            int r9 = r9 / 2
            float r9 = (float) r9
            int r9 = (r10 > r9 ? 1 : (r10 == r9 ? 0 : -1))
            if (r9 >= 0) goto L_0x00a5
            float r9 = java.lang.Math.abs(r11)
            int r12 = r12 / 2
            float r10 = (float) r12
            int r9 = (r9 > r10 ? 1 : (r9 == r10 ? 0 : -1))
            if (r9 >= 0) goto L_0x00a5
            goto L_0x00a4
        L_0x0094:
            int r12 = r12 / 2
            float r9 = (float) r12
            int r9 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r9 >= 0) goto L_0x00a5
            goto L_0x00a4
        L_0x009c:
            int r9 = -r12
            int r9 = r9 / 2
            float r9 = (float) r9
            int r9 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r9 <= 0) goto L_0x00a5
        L_0x00a4:
            r5 = 1
        L_0x00a5:
            r6 = r5
        L_0x00a6:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.SlidingLayer.a(boolean, float, float, int, int, int, int):boolean");
    }

    private int b(float f2) {
        if (this.f24875f == null) {
            return 1;
        }
        if (Math.abs(f2) >= ((float) this.B)) {
            return f2 > 0.0f ? -1 : 1;
        }
        if (this.f24875f.nextBoolean()) {
            return 1;
        }
    }

    private void b() {
        setWillNotDraw(false);
        setDescendantFocusability(262144);
        setFocusable(true);
        Context context = getContext();
        this.f24876g = new Scroller(context, f24870e);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f24889t = ad.a(viewConfiguration);
        this.B = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f24873c = viewConfiguration.getScaledMaximumFlingVelocity();
        this.C = (int) (context.getResources().getDisplayMetrics().density * 25.0f);
        this.f24875f = new Random();
    }

    private void b(boolean z2, boolean z3) {
        a(false, z2, z3, 0, 0);
    }

    private boolean b(float f2, float f3) {
        int i2;
        if ((this.f24894y && ((float) getTop()) <= f3) || ((float) getBottom()) >= f3) {
            int i3 = this.f24882m;
            if (i3 == -5) {
                return this.f24894y && f2 > 0.0f;
            }
            if (i3 == -4) {
                return this.f24894y && f2 < 0.0f;
            }
            if (i3 == -3) {
                return this.f24894y && f2 != 0.0f;
            }
        }
        if (!this.f24894y && (i2 = this.f24880k) > 0 && f2 > 0.0f) {
            int i4 = this.f24882m;
            return i4 != -5 ? i4 != -4 ? i4 == -3 && f2 != 0.0f : f3 <= ((float) i2) && f2 > 0.0f : f3 >= ((float) (getHeight() - this.f24880k)) && f2 < 0.0f;
        }
        return false;
    }

    private boolean b(MotionEvent motionEvent, float f2) {
        int i2;
        int i3 = this.f24882m;
        if (i3 != -5 && i3 != -4 && i3 != -3) {
            return false;
        }
        boolean z2 = this.f24894y;
        if (z2) {
            return true;
        }
        if (z2 || (i2 = this.f24880k) <= 0) {
            return false;
        }
        return i3 != -5 ? i3 == -4 && f2 <= ((float) i2) : f2 >= ((float) (getHeight() - this.f24880k));
    }

    /* JADX WARNING: Removed duplicated region for block: B:28:0x0073  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00a2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int[] b(int r13, int r14) {
        /*
            r12 = this;
            r0 = 2
            int[] r1 = new int[r0]
            boolean r2 = r12.f24894y
            if (r2 == 0) goto L_0x0008
            return r1
        L_0x0008:
            int r2 = r12.f24882m
            r3 = -5
            r4 = 1
            if (r2 == r3) goto L_0x00dc
            r3 = -4
            if (r2 == r3) goto L_0x00d2
            r3 = -3
            r5 = 0
            if (r2 == r3) goto L_0x0034
            r13 = -2
            if (r2 == r13) goto L_0x0029
            r13 = -1
            if (r2 == r13) goto L_0x001d
            goto L_0x00e6
        L_0x001d:
            int r13 = r12.getWidth()
            int r13 = -r13
            int r14 = r12.f24880k
            int r13 = r13 + r14
            r1[r5] = r13
            goto L_0x00e6
        L_0x0029:
            int r13 = r12.getWidth()
            int r14 = r12.f24880k
            int r13 = r13 - r14
            r1[r5] = r13
            goto L_0x00e6
        L_0x0034:
            r2 = 1065353216(0x3f800000, float:1.0)
            r6 = 4609753056924675352(0x3ff921fb54442d18, double:1.5707963267948966)
            if (r13 != 0) goto L_0x005b
            if (r14 != 0) goto L_0x005b
            java.util.Random r3 = r12.f24875f
            if (r3 == 0) goto L_0x0058
            float r3 = r3.nextFloat()
            double r8 = (double) r3
            r10 = 4614256656552045848(0x400921fb54442d18, double:3.141592653589793)
            java.lang.Double.isNaN(r8)
            double r8 = r8 * r10
            double r8 = r8 - r6
            double r6 = java.lang.Math.tan(r8)
            goto L_0x0061
        L_0x0058:
            r3 = 1065353216(0x3f800000, float:1.0)
            goto L_0x0066
        L_0x005b:
            if (r13 != 0) goto L_0x0063
            double r6 = java.lang.Math.tan(r6)
        L_0x0061:
            float r3 = (float) r6
            goto L_0x0066
        L_0x0063:
            float r3 = (float) r14
            float r6 = (float) r13
            float r3 = r3 / r6
        L_0x0066:
            float r6 = java.lang.Math.abs(r3)
            int r2 = (r6 > r2 ? 1 : (r6 == r2 ? 0 : -1))
            float r13 = (float) r13
            int r13 = r12.b((float) r13)
            if (r2 < 0) goto L_0x00a2
            int r2 = r12.getHeight()
            int r13 = r13 * r2
            float r13 = (float) r13
            float r2 = java.lang.Math.abs(r3)
            float r13 = r13 / r2
            float r2 = r12.f24890u
            int r3 = r12.getWidth()
            int r3 = r3 / r0
            float r0 = (float) r3
            float r2 = r2 - r0
            float r13 = r13 - r2
            int r13 = java.lang.Math.round(r13)
            r1[r5] = r13
            float r13 = (float) r14
            int r13 = r12.b((float) r13)
            int r14 = r12.getHeight()
            int r13 = r13 * r14
            float r13 = (float) r13
            int r13 = java.lang.Math.round(r13)
            r1[r4] = r13
            goto L_0x00e6
        L_0x00a2:
            int r2 = r12.getWidth()
            int r13 = r13 * r2
            float r13 = (float) r13
            int r13 = java.lang.Math.round(r13)
            r1[r5] = r13
            float r13 = (float) r14
            int r13 = r12.b((float) r13)
            int r14 = r12.getWidth()
            int r13 = r13 * r14
            float r13 = (float) r13
            float r14 = java.lang.Math.abs(r3)
            float r13 = r13 * r14
            float r14 = r12.f24891v
            int r2 = r12.getHeight()
            int r2 = r2 / r0
            float r0 = (float) r2
            float r14 = r14 - r0
            float r13 = r13 - r14
            int r13 = java.lang.Math.round(r13)
            r1[r4] = r13
            goto L_0x00e6
        L_0x00d2:
            int r13 = r12.getHeight()
            int r14 = r12.f24880k
            int r13 = r13 - r14
            r1[r4] = r13
            goto L_0x00e6
        L_0x00dc:
            int r13 = r12.getHeight()
            int r13 = -r13
            int r14 = r12.f24880k
            int r13 = r13 + r14
            r1[r4] = r13
        L_0x00e6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.SlidingLayer.b(int, int):int[]");
    }

    private void c() {
        this.f24887r = false;
        this.f24888s = false;
        this.D = false;
        VelocityTracker velocityTracker = this.f24872b;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f24872b = null;
        }
    }

    private void d() {
        if (this.f24895z) {
            setDrawingCacheEnabled(false);
            this.f24876g.abortAnimation();
            int scrollX = getScrollX();
            int scrollY = getScrollY();
            int currX = this.f24876g.getCurrX();
            int currY = this.f24876g.getCurrY();
            if (!(scrollX == currX && scrollY == currY)) {
                scrollTo(currX, currY);
            }
            if (this.f24894y) {
                a aVar = this.A;
                if (aVar != null) {
                    aVar.c();
                }
            } else {
                a aVar2 = this.A;
                if (aVar2 != null) {
                    aVar2.d();
                }
            }
        }
        this.f24895z = false;
    }

    private int[] getDestScrollPos() {
        return b(0, 0);
    }

    /* access modifiers changed from: package-private */
    public float a(float f2) {
        double d2 = (double) (f2 - 0.5f);
        Double.isNaN(d2);
        return (float) Math.sin((double) ((float) (d2 * 0.4712389167638204d)));
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, int i4) {
        if (getChildCount() == 0) {
            setDrawingCacheEnabled(false);
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int i5 = i2 - scrollX;
        int i6 = i3 - scrollY;
        if (i5 == 0 && i6 == 0) {
            d();
            if (this.f24894y) {
                a aVar = this.A;
                if (aVar != null) {
                    aVar.c();
                    return;
                }
                return;
            }
            a aVar2 = this.A;
            if (aVar2 != null) {
                aVar2.d();
                return;
            }
            return;
        }
        setDrawingCacheEnabled(true);
        this.f24895z = true;
        int width = getWidth();
        float f2 = (float) (width / 2);
        float a2 = f2 + (a(Math.min(1.0f, (((float) Math.abs(i5)) * 1.0f) / ((float) width))) * f2);
        int abs = Math.abs(i4);
        this.f24876g.startScroll(scrollX, scrollY, i5, i6, Math.min(abs > 0 ? Math.round(Math.abs(a2 / ((float) abs)) * 1000.0f) * 4 : 600, 600));
        invalidate();
    }

    public void a(Parcelable parcelable) {
        Bundle bundle = (Bundle) parcelable;
        this.f24874d = bundle;
        if (bundle.getBoolean("is_open")) {
            a(true);
        }
    }

    public void a(boolean z2) {
        a(z2, false);
    }

    public boolean a() {
        return this.f24894y;
    }

    public void b(boolean z2) {
        b(z2, false);
    }

    public void computeScroll() {
        if (this.f24876g.isFinished() || !this.f24876g.computeScrollOffset()) {
            d();
            return;
        }
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        int currX = this.f24876g.getCurrX();
        int currY = this.f24876g.getCurrY();
        if (!(scrollX == currX && scrollY == currY)) {
            scrollTo(currX, currY);
        }
        invalidate(getLeft() + scrollX, getTop() + scrollY, getRight() - scrollX, getBottom() - scrollY);
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        Drawable drawable;
        super.dispatchDraw(canvas);
        int i2 = this.f24877h;
        if (i2 > 0 && (drawable = this.f24878i) != null) {
            if (this.f24882m == -1) {
                drawable.setBounds(0, 0, i2, getHeight());
            }
            if (this.f24882m == -4) {
                this.f24878i.setBounds(0, getHeight() - this.f24877h, getWidth(), getHeight());
            }
            if (this.f24882m == -2) {
                this.f24878i.setBounds(getWidth() - this.f24877h, 0, getWidth(), getHeight());
            }
            if (this.f24882m == -5) {
                this.f24878i.setBounds(0, 0, getWidth(), this.f24877h);
            }
            this.f24878i.draw(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        Drawable drawable = this.f24878i;
        if (drawable != null && drawable.isStateful()) {
            drawable.setState(getDrawableState());
        }
    }

    public int getContentLeft() {
        return getLeft() + getPaddingLeft();
    }

    public int getOffsetWidth() {
        return this.f24880k;
    }

    public int getShadowWidth() {
        return this.f24877h;
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (!this.f24885p) {
            return false;
        }
        int action = motionEvent.getAction() & 255;
        if (action == 3 || action == 1) {
            this.f24887r = false;
            this.f24888s = false;
            this.f24871a = -1;
            VelocityTracker velocityTracker = this.f24872b;
            if (velocityTracker != null) {
                velocityTracker.recycle();
                this.f24872b = null;
            }
            return false;
        }
        if (action != 0) {
            if (this.f24887r) {
                return true;
            }
            if (this.f24888s) {
                return false;
            }
        }
        if (action == 0) {
            int action2 = motionEvent.getAction();
            int i2 = Build.VERSION.SDK_INT;
            int i3 = action2 & 65280;
            this.f24871a = i3;
            float c2 = l.c(motionEvent, i3);
            this.f24892w = c2;
            this.f24890u = c2;
            float d2 = l.d(motionEvent, this.f24871a);
            this.f24893x = d2;
            this.f24891v = d2;
            if (!a(motionEvent, this.f24892w) && !b(motionEvent, this.f24893x)) {
                this.f24888s = true;
            } else {
                this.f24887r = false;
                this.f24888s = false;
                return super.onInterceptTouchEvent(motionEvent);
            }
        } else if (action == 2) {
            int i4 = this.f24871a;
            if (i4 != -1) {
                int a2 = l.a(motionEvent, i4);
                if (a2 == -1) {
                    this.f24871a = -1;
                } else {
                    float c3 = l.c(motionEvent, a2);
                    float f2 = c3 - this.f24890u;
                    float abs = Math.abs(f2);
                    float d3 = l.d(motionEvent, a2);
                    float f3 = this.f24891v;
                    float f4 = d3 - f3;
                    float abs2 = Math.abs(d3 - f3);
                    if (abs > ((float) this.f24889t) && abs > abs2 && a(f2, this.f24892w)) {
                        this.f24890u = c3;
                    } else if (abs2 > ((float) this.f24889t) && abs2 > abs && b(f4, this.f24893x)) {
                        this.f24891v = d3;
                    }
                    setDrawingCacheEnabled(true);
                }
            }
        } else if (action == 6) {
            a(motionEvent);
        }
        if (!this.f24887r) {
            if (this.f24872b == null) {
                this.f24872b = VelocityTracker.obtain();
            }
            this.f24872b.addMovement(motionEvent);
        }
        return this.f24887r;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        int paddingLeft;
        int paddingLeft2;
        int paddingTop;
        int paddingRight;
        int paddingBottom;
        int i6 = this.f24882m;
        if (i6 == 0) {
            i6 = a(i2, i4);
        }
        if (i6 != this.f24882m || this.f24879j) {
            this.f24879j = false;
            this.f24882m = i6;
            if (!this.f24894y) {
                b(false, true);
            }
            int i7 = this.f24882m;
            if (i7 == -1) {
                paddingLeft2 = getPaddingLeft() + this.f24877h;
                paddingTop = getPaddingTop();
            } else if (i7 == -5) {
                paddingLeft2 = getPaddingLeft();
                paddingTop = getPaddingTop() + this.f24877h;
            } else {
                if (i7 == -2) {
                    paddingLeft = getPaddingLeft();
                } else if (i7 == -4) {
                    paddingLeft2 = getPaddingLeft();
                    paddingTop = getPaddingTop();
                    paddingRight = getPaddingRight();
                    paddingBottom = getPaddingBottom() + this.f24877h;
                    setPadding(paddingLeft2, paddingTop, paddingRight, paddingBottom);
                } else if (i7 == -3) {
                    paddingLeft = getPaddingLeft() + this.f24877h;
                }
                paddingTop = getPaddingTop();
                paddingRight = getPaddingRight() + this.f24877h;
                paddingBottom = getPaddingBottom();
                setPadding(paddingLeft2, paddingTop, paddingRight, paddingBottom);
            }
            paddingRight = getPaddingRight();
            paddingBottom = getPaddingBottom();
            setPadding(paddingLeft2, paddingTop, paddingRight, paddingBottom);
        }
        super.onLayout(z2, i2, i3, i4, i5);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int defaultSize = getDefaultSize(0, i2);
        int defaultSize2 = getDefaultSize(0, i3);
        setMeasuredDimension(defaultSize, defaultSize2);
        super.onMeasure(getChildMeasureSpec(i2, 0, defaultSize), getChildMeasureSpec(i3, 0, defaultSize2));
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        a((Parcelable) savedState.f24896a);
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f24874d == null) {
            this.f24874d = new Bundle();
        }
        this.f24874d.putBoolean("is_open", a());
        savedState.f24896a = this.f24874d;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4) {
            d();
            int[] destScrollPos = getDestScrollPos();
            scrollTo(destScrollPos[0], destScrollPos[1]);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:58:0x013d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r14) {
        /*
            r13 = this;
            boolean r0 = r13.f24885p
            r1 = 0
            if (r0 == 0) goto L_0x0140
            boolean r0 = r13.f24887r
            if (r0 != 0) goto L_0x001f
            boolean r0 = r13.D
            if (r0 != 0) goto L_0x001f
            float r0 = r13.f24892w
            boolean r0 = r13.a((android.view.MotionEvent) r14, (float) r0)
            if (r0 != 0) goto L_0x001f
            float r0 = r13.f24893x
            boolean r0 = r13.b((android.view.MotionEvent) r14, (float) r0)
            if (r0 != 0) goto L_0x001f
            goto L_0x0140
        L_0x001f:
            int r0 = r14.getAction()
            r2 = 3
            r3 = 1
            if (r0 == r3) goto L_0x0030
            if (r0 == r2) goto L_0x0030
            r4 = 4
            if (r0 != r4) goto L_0x002d
            goto L_0x0030
        L_0x002d:
            r13.D = r3
            goto L_0x0032
        L_0x0030:
            r13.D = r1
        L_0x0032:
            android.view.VelocityTracker r4 = r13.f24872b
            if (r4 != 0) goto L_0x003c
            android.view.VelocityTracker r4 = android.view.VelocityTracker.obtain()
            r13.f24872b = r4
        L_0x003c:
            android.view.VelocityTracker r4 = r13.f24872b
            r4.addMovement(r14)
            r0 = r0 & 255(0xff, float:3.57E-43)
            r4 = -1
            if (r0 == 0) goto L_0x0120
            if (r0 == r3) goto L_0x00b9
            r5 = 2
            if (r0 == r5) goto L_0x0093
            if (r0 == r2) goto L_0x0088
            r2 = 5
            if (r0 == r2) goto L_0x0072
            r2 = 6
            if (r0 == r2) goto L_0x0055
            goto L_0x0139
        L_0x0055:
            r13.a((android.view.MotionEvent) r14)
            int r0 = r13.f24871a
            int r0 = t.l.a(r14, r0)
            float r0 = t.l.c(r14, r0)
            r13.f24890u = r0
            int r0 = r13.f24871a
            int r0 = t.l.a(r14, r0)
            float r14 = t.l.d(r14, r0)
            r13.f24891v = r14
            goto L_0x0139
        L_0x0072:
            int r0 = t.l.b(r14)
            float r2 = t.l.c(r14, r0)
            r13.f24890u = r2
            float r2 = t.l.d(r14, r0)
            r13.f24891v = r2
            int r14 = t.l.b(r14, r0)
            goto L_0x0137
        L_0x0088:
            boolean r14 = r13.f24887r
            if (r14 == 0) goto L_0x0139
            boolean r14 = r13.f24894y
            r13.a((boolean) r14, (boolean) r3, (boolean) r3)
            goto L_0x0104
        L_0x0093:
            boolean r0 = r13.f24887r
            if (r0 != 0) goto L_0x0139
            int r0 = r13.f24871a
            int r0 = t.l.a(r14, r0)
            if (r0 != r4) goto L_0x00a3
            r13.f24871a = r4
            goto L_0x0139
        L_0x00a3:
            float r2 = t.l.c(r14, r0)
            float r5 = r13.f24890u
            float r2 = r2 - r5
            java.lang.Math.abs(r2)
            float r14 = t.l.d(r14, r0)
            float r0 = r13.f24891v
            float r14 = r14 - r0
            java.lang.Math.abs(r14)
            goto L_0x0139
        L_0x00b9:
            boolean r0 = r13.f24887r
            if (r0 == 0) goto L_0x010a
            android.view.VelocityTracker r0 = r13.f24872b
            r2 = 1000(0x3e8, float:1.401E-42)
            int r5 = r13.f24873c
            float r5 = (float) r5
            r0.computeCurrentVelocity(r2, r5)
            int r2 = r13.f24871a
            float r2 = t.ab.a(r0, r2)
            int r2 = (int) r2
            int r5 = r13.f24871a
            float r0 = t.ab.b(r0, r5)
            int r0 = (int) r0
            int r5 = r13.getScrollX()
            int r6 = r13.getScrollY()
            int r7 = r13.f24871a
            int r7 = t.l.a(r14, r7)
            float r8 = t.l.c(r14, r7)
            float r14 = t.l.d(r14, r7)
            float r7 = r13.f24892w
            float r8 = r8 - r7
            int r11 = (int) r8
            float r7 = r13.f24893x
            float r14 = r14 - r7
            int r12 = (int) r14
            boolean r14 = r13.f24894y
            float r7 = (float) r5
            float r8 = (float) r6
            r5 = r13
            r6 = r14
            r9 = r2
            r10 = r0
            boolean r6 = r5.a(r6, r7, r8, r9, r10, r11, r12)
            r7 = 1
            r8 = 1
            r5.a(r6, r7, r8, r9, r10)
        L_0x0104:
            r13.f24871a = r4
            r13.c()
            goto L_0x0139
        L_0x010a:
            boolean r14 = r13.f24894y
            if (r14 == 0) goto L_0x0116
            boolean r0 = r13.f24883n
            if (r0 == 0) goto L_0x0116
            r13.b((boolean) r3)
            goto L_0x0139
        L_0x0116:
            if (r14 != 0) goto L_0x0139
            boolean r14 = r13.f24884o
            if (r14 == 0) goto L_0x0139
            r13.a((boolean) r3)
            goto L_0x0139
        L_0x0120:
            r13.d()
            float r0 = r14.getX()
            r13.f24892w = r0
            r13.f24890u = r0
            float r0 = r14.getY()
            r13.f24893x = r0
            r13.f24891v = r0
            int r14 = t.l.b(r14, r1)
        L_0x0137:
            r13.f24871a = r14
        L_0x0139:
            int r14 = r13.f24871a
            if (r14 != r4) goto L_0x013f
            r13.D = r1
        L_0x013f:
            return r3
        L_0x0140:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.vjoystick.SlidingLayer.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setCloseOnTapEnabled(boolean z2) {
        this.f24883n = z2;
    }

    public void setDrawingCacheEnabled(boolean z2) {
        if (this.f24881l != z2) {
            super.setDrawingCacheEnabled(z2);
            this.f24881l = z2;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                View childAt = getChildAt(i2);
                if (childAt.getVisibility() != 8) {
                    childAt.setDrawingCacheEnabled(z2);
                }
            }
        }
    }

    public void setOffsetWidth(int i2) {
        this.f24880k = i2;
        invalidate(getLeft(), getTop(), getRight(), getBottom());
    }

    public void setOnInteractListener(a aVar) {
        this.A = aVar;
    }

    public void setOpenOnTapEnabled(boolean z2) {
        this.f24884o = z2;
    }

    public void setShadowDrawable(int i2) {
        setShadowDrawable(getContext().getResources().getDrawable(i2));
    }

    public void setShadowDrawable(Drawable drawable) {
        this.f24878i = drawable;
        refreshDrawableState();
        setWillNotDraw(false);
        invalidate(getLeft(), getTop(), getRight(), getBottom());
    }

    public void setShadowWidth(int i2) {
        this.f24877h = i2;
        invalidate(getLeft(), getTop(), getRight(), getBottom());
    }

    public void setShadowWidthRes(int i2) {
        setShadowWidth((int) getResources().getDimension(i2));
    }

    public void setSlidingEnabled(boolean z2) {
        this.f24885p = z2;
    }

    public void setSlidingFromShadowEnabled(boolean z2) {
        this.f24886q = z2;
    }

    public void setStickTo(int i2) {
        if (i2 != 0) {
            this.f24879j = true;
        }
        this.f24882m = i2;
        b(false, true);
    }

    /* access modifiers changed from: protected */
    public boolean verifyDrawable(Drawable drawable) {
        return super.verifyDrawable(drawable) || drawable == this.f24878i;
    }
}
