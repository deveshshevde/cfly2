package com.sothree.slidinguppanel;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.blankj.utilcode.constant.MemoryConstants;
import com.sothree.slidinguppanel.a;
import com.sothree.slidinguppanel.library.R;
import t.ac;
import t.l;

public class SlidingUpPanelLayout extends ViewGroup {

    /* renamed from: a  reason: collision with root package name */
    private static final String f21694a = "SlidingUpPanelLayout";

    /* renamed from: b  reason: collision with root package name */
    private static SlideState f21695b = SlideState.COLLAPSED;

    /* renamed from: c  reason: collision with root package name */
    private static final int[] f21696c = {16842927};
    /* access modifiers changed from: private */
    public final a A;
    private boolean B;
    private final Rect C;

    /* renamed from: d  reason: collision with root package name */
    private int f21697d;

    /* renamed from: e  reason: collision with root package name */
    private int f21698e;

    /* renamed from: f  reason: collision with root package name */
    private final Paint f21699f;

    /* renamed from: g  reason: collision with root package name */
    private final Drawable f21700g;

    /* renamed from: h  reason: collision with root package name */
    private int f21701h;

    /* renamed from: i  reason: collision with root package name */
    private int f21702i;

    /* renamed from: j  reason: collision with root package name */
    private int f21703j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public boolean f21704k;

    /* renamed from: l  reason: collision with root package name */
    private boolean f21705l;

    /* renamed from: m  reason: collision with root package name */
    private View f21706m;

    /* renamed from: n  reason: collision with root package name */
    private int f21707n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public View f21708o;

    /* renamed from: p  reason: collision with root package name */
    private View f21709p;
    /* access modifiers changed from: private */

    /* renamed from: q  reason: collision with root package name */
    public SlideState f21710q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public float f21711r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public int f21712s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public boolean f21713t;

    /* renamed from: u  reason: collision with root package name */
    private boolean f21714u;

    /* renamed from: v  reason: collision with root package name */
    private boolean f21715v;

    /* renamed from: w  reason: collision with root package name */
    private float f21716w;

    /* renamed from: x  reason: collision with root package name */
    private float f21717x;
    /* access modifiers changed from: private */

    /* renamed from: y  reason: collision with root package name */
    public float f21718y;

    /* renamed from: z  reason: collision with root package name */
    private b f21719z;

    /* renamed from: com.sothree.slidinguppanel.SlidingUpPanelLayout$2  reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f21721a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.sothree.slidinguppanel.SlidingUpPanelLayout$SlideState[] r0 = com.sothree.slidinguppanel.SlidingUpPanelLayout.SlideState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f21721a = r0
                com.sothree.slidinguppanel.SlidingUpPanelLayout$SlideState r1 = com.sothree.slidinguppanel.SlidingUpPanelLayout.SlideState.EXPANDED     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f21721a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.sothree.slidinguppanel.SlidingUpPanelLayout$SlideState r1 = com.sothree.slidinguppanel.SlidingUpPanelLayout.SlideState.ANCHORED     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f21721a     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.sothree.slidinguppanel.SlidingUpPanelLayout$SlideState r1 = com.sothree.slidinguppanel.SlidingUpPanelLayout.SlideState.HIDDEN     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.sothree.slidinguppanel.SlidingUpPanelLayout.AnonymousClass2.<clinit>():void");
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: a  reason: collision with root package name */
        private static final int[] f21722a = {16843137};

        public LayoutParams() {
            super(-1, -1);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
            context.obtainStyledAttributes(attributeSet, f21722a).recycle();
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }
    }

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
        SlideState f21723a;

        private SavedState(Parcel parcel) {
            super(parcel);
            try {
                this.f21723a = (SlideState) Enum.valueOf(SlideState.class, parcel.readString());
            } catch (IllegalArgumentException unused) {
                this.f21723a = SlideState.COLLAPSED;
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeString(this.f21723a.toString());
        }
    }

    private enum SlideState {
        EXPANDED,
        COLLAPSED,
        ANCHORED,
        HIDDEN,
        DRAGGING
    }

    private class a extends a.C0142a {
        private a() {
        }

        public int a(View view) {
            return SlidingUpPanelLayout.this.f21712s;
        }

        public int a(View view, int i2, int i3) {
            int b2 = SlidingUpPanelLayout.this.b(0.0f);
            int b3 = SlidingUpPanelLayout.this.b(1.0f);
            return SlidingUpPanelLayout.this.f21704k ? Math.min(Math.max(i2, b3), b2) : Math.min(Math.max(i2, b2), b3);
        }

        public void a(int i2) {
            if (SlidingUpPanelLayout.this.A.a() == 0) {
                SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
                float unused = slidingUpPanelLayout.f21711r = slidingUpPanelLayout.a(slidingUpPanelLayout.f21708o.getTop());
                if (SlidingUpPanelLayout.this.f21711r == 1.0f) {
                    if (SlidingUpPanelLayout.this.f21710q != SlideState.EXPANDED) {
                        SlidingUpPanelLayout.this.b();
                        SlideState unused2 = SlidingUpPanelLayout.this.f21710q = SlideState.EXPANDED;
                        SlidingUpPanelLayout slidingUpPanelLayout2 = SlidingUpPanelLayout.this;
                        slidingUpPanelLayout2.b(slidingUpPanelLayout2.f21708o);
                    }
                } else if (SlidingUpPanelLayout.this.f21711r == 0.0f) {
                    if (SlidingUpPanelLayout.this.f21710q != SlideState.COLLAPSED) {
                        SlideState unused3 = SlidingUpPanelLayout.this.f21710q = SlideState.COLLAPSED;
                        SlidingUpPanelLayout slidingUpPanelLayout3 = SlidingUpPanelLayout.this;
                        slidingUpPanelLayout3.c(slidingUpPanelLayout3.f21708o);
                    }
                } else if (SlidingUpPanelLayout.this.f21711r < 0.0f) {
                    SlideState unused4 = SlidingUpPanelLayout.this.f21710q = SlideState.HIDDEN;
                    SlidingUpPanelLayout.this.f21708o.setVisibility(8);
                    SlidingUpPanelLayout slidingUpPanelLayout4 = SlidingUpPanelLayout.this;
                    slidingUpPanelLayout4.e(slidingUpPanelLayout4.f21708o);
                } else if (SlidingUpPanelLayout.this.f21710q != SlideState.ANCHORED) {
                    SlidingUpPanelLayout.this.b();
                    SlideState unused5 = SlidingUpPanelLayout.this.f21710q = SlideState.ANCHORED;
                    SlidingUpPanelLayout slidingUpPanelLayout5 = SlidingUpPanelLayout.this;
                    slidingUpPanelLayout5.d(slidingUpPanelLayout5.f21708o);
                }
            }
        }

        public void a(View view, float f2, float f3) {
            int i2;
            if (SlidingUpPanelLayout.this.f21704k) {
                f3 = -f3;
            }
            if (f3 <= 0.0f) {
                if (f3 >= 0.0f) {
                    if ((SlidingUpPanelLayout.this.f21718y == 1.0f || SlidingUpPanelLayout.this.f21711r < (SlidingUpPanelLayout.this.f21718y + 1.0f) / 2.0f) && (SlidingUpPanelLayout.this.f21718y != 1.0f || SlidingUpPanelLayout.this.f21711r < 0.5f)) {
                        if ((SlidingUpPanelLayout.this.f21718y != 1.0f && SlidingUpPanelLayout.this.f21711r >= SlidingUpPanelLayout.this.f21718y) || (SlidingUpPanelLayout.this.f21718y != 1.0f && SlidingUpPanelLayout.this.f21711r >= SlidingUpPanelLayout.this.f21718y / 2.0f)) {
                            SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
                            i2 = slidingUpPanelLayout.b(slidingUpPanelLayout.f21718y);
                            SlidingUpPanelLayout.this.A.a(view.getLeft(), i2);
                            SlidingUpPanelLayout.this.invalidate();
                        }
                    }
                }
                i2 = SlidingUpPanelLayout.this.b(0.0f);
                SlidingUpPanelLayout.this.A.a(view.getLeft(), i2);
                SlidingUpPanelLayout.this.invalidate();
            }
            i2 = SlidingUpPanelLayout.this.b(1.0f);
            SlidingUpPanelLayout.this.A.a(view.getLeft(), i2);
            SlidingUpPanelLayout.this.invalidate();
        }

        public void a(View view, int i2, int i3, int i4, int i5) {
            SlidingUpPanelLayout.this.b(i3);
            SlidingUpPanelLayout.this.invalidate();
        }

        public boolean a(View view, int i2) {
            return !SlidingUpPanelLayout.this.f21713t && view == SlidingUpPanelLayout.this.f21708o;
        }

        public void b(View view, int i2) {
            SlidingUpPanelLayout.this.c();
        }
    }

    public interface b {
        void a(View view);

        void a(View view, float f2);

        void b(View view);

        void c(View view);

        void d(View view);
    }

    public SlidingUpPanelLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SlidingUpPanelLayout(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        Resources resources;
        int i3;
        this.f21697d = 400;
        this.f21698e = -1728053248;
        this.f21699f = new Paint();
        this.f21701h = -1;
        this.f21702i = -1;
        this.f21703j = -1;
        this.f21705l = false;
        this.f21707n = -1;
        this.f21710q = SlideState.COLLAPSED;
        this.f21718y = 1.0f;
        this.B = true;
        this.C = new Rect();
        if (isInEditMode()) {
            this.f21700g = null;
            this.A = null;
            return;
        }
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, f21696c);
            if (obtainStyledAttributes != null) {
                int i4 = obtainStyledAttributes.getInt(0, 0);
                if (i4 == 48 || i4 == 80) {
                    this.f21704k = i4 == 80;
                } else {
                    throw new IllegalArgumentException("gravity must be set to either top or bottom");
                }
            }
            obtainStyledAttributes.recycle();
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, R.styleable.SlidingUpPanelLayout);
            if (obtainStyledAttributes2 != null) {
                this.f21701h = obtainStyledAttributes2.getDimensionPixelSize(0, -1);
                this.f21702i = obtainStyledAttributes2.getDimensionPixelSize(1, -1);
                this.f21703j = obtainStyledAttributes2.getDimensionPixelSize(2, -1);
                this.f21697d = obtainStyledAttributes2.getInt(4, 400);
                this.f21698e = obtainStyledAttributes2.getColor(3, -1728053248);
                this.f21707n = obtainStyledAttributes2.getResourceId(5, -1);
                this.f21705l = obtainStyledAttributes2.getBoolean(6, false);
                this.f21718y = obtainStyledAttributes2.getFloat(7, 1.0f);
                this.f21710q = SlideState.values()[obtainStyledAttributes2.getInt(8, f21695b.ordinal())];
            }
            obtainStyledAttributes2.recycle();
        }
        float f2 = context.getResources().getDisplayMetrics().density;
        if (this.f21701h == -1) {
            this.f21701h = (int) ((68.0f * f2) + 0.5f);
        }
        if (this.f21702i == -1) {
            this.f21702i = (int) ((4.0f * f2) + 0.5f);
        }
        if (this.f21703j == -1) {
            this.f21703j = (int) (0.0f * f2);
        }
        if (this.f21702i > 0) {
            if (this.f21704k) {
                resources = getResources();
                i3 = R.drawable.above_shadow;
            } else {
                resources = getResources();
                i3 = R.drawable.below_shadow;
            }
            this.f21700g = resources.getDrawable(i3);
        } else {
            this.f21700g = null;
        }
        setWillNotDraw(false);
        a a2 = a.a((ViewGroup) this, 0.5f, (a.C0142a) new a());
        this.A = a2;
        a2.a(((float) this.f21697d) * f2);
        this.f21714u = true;
    }

    /* access modifiers changed from: private */
    public float a(int i2) {
        int b2 = b(0.0f);
        return (this.f21704k ? (float) (b2 - i2) : (float) (i2 - b2)) / ((float) this.f21712s);
    }

    private boolean a(int i2, int i3) {
        View view = this.f21706m;
        if (view == null) {
            return false;
        }
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        int[] iArr2 = new int[2];
        getLocationOnScreen(iArr2);
        int i4 = iArr2[0] + i2;
        int i5 = iArr2[1] + i3;
        return i4 >= iArr[0] && i4 < iArr[0] + this.f21706m.getWidth() && i5 >= iArr[1] && i5 < iArr[1] + this.f21706m.getHeight();
    }

    private boolean a(View view, int i2) {
        return this.B || a(0.0f, i2);
    }

    private boolean a(View view, int i2, float f2) {
        return this.B || a(f2, i2);
    }

    /* access modifiers changed from: private */
    public int b(float f2) {
        View view = this.f21708o;
        int measuredHeight = view != null ? view.getMeasuredHeight() : 0;
        int i2 = (int) (f2 * ((float) this.f21712s));
        return this.f21704k ? ((getMeasuredHeight() - getPaddingBottom()) - this.f21701h) - i2 : (getPaddingTop() - measuredHeight) + this.f21701h + i2;
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        this.f21710q = SlideState.DRAGGING;
        float a2 = a(i2);
        this.f21711r = a2;
        if (this.f21703j > 0 && a2 >= 0.0f) {
            int currentParalaxOffset = getCurrentParalaxOffset();
            if (Build.VERSION.SDK_INT >= 11) {
                this.f21709p.setTranslationY((float) currentParalaxOffset);
            } else {
                iu.a.a(this.f21709p).j((float) currentParalaxOffset);
            }
        }
        a(this.f21708o);
        if (this.f21711r <= 0.0f && !this.f21705l) {
            ((LayoutParams) this.f21709p.getLayoutParams()).height = this.f21704k ? i2 - getPaddingBottom() : ((getHeight() - getPaddingBottom()) - this.f21708o.getMeasuredHeight()) - i2;
            this.f21709p.requestLayout();
        }
    }

    private static boolean f(View view) {
        Drawable background = view.getBackground();
        return background != null && background.getOpacity() == -1;
    }

    /* access modifiers changed from: package-private */
    public void a(View view) {
        b bVar = this.f21719z;
        if (bVar != null) {
            bVar.a(view, this.f21711r);
        }
    }

    public boolean a() {
        return this.f21714u && this.f21708o != null;
    }

    public boolean a(float f2) {
        if (this.f21708o == null || this.f21710q == SlideState.EXPANDED) {
            return false;
        }
        this.f21708o.setVisibility(0);
        return a(this.f21708o, 0, f2);
    }

    /* access modifiers changed from: package-private */
    public boolean a(float f2, int i2) {
        if (!a()) {
            return false;
        }
        int b2 = b(f2);
        a aVar = this.A;
        View view = this.f21708o;
        if (!aVar.a(view, view.getLeft(), b2)) {
            return false;
        }
        c();
        ac.e(this);
        return true;
    }

    /* access modifiers changed from: package-private */
    public void b() {
        int i2;
        int i3;
        int i4;
        int i5;
        if (getChildCount() != 0) {
            int paddingLeft = getPaddingLeft();
            int width = getWidth() - getPaddingRight();
            int paddingTop = getPaddingTop();
            int height = getHeight() - getPaddingBottom();
            View view = this.f21708o;
            int i6 = 0;
            if (view == null || !f(view)) {
                i5 = 0;
                i4 = 0;
                i3 = 0;
                i2 = 0;
            } else {
                i5 = this.f21708o.getLeft();
                i4 = this.f21708o.getRight();
                i3 = this.f21708o.getTop();
                i2 = this.f21708o.getBottom();
            }
            View childAt = getChildAt(0);
            int max = Math.max(paddingLeft, childAt.getLeft());
            int max2 = Math.max(paddingTop, childAt.getTop());
            int min = Math.min(width, childAt.getRight());
            int min2 = Math.min(height, childAt.getBottom());
            if (max >= i5 && max2 >= i3 && min <= i4 && min2 <= i2) {
                i6 = 4;
            }
            childAt.setVisibility(i6);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(View view) {
        b bVar = this.f21719z;
        if (bVar != null) {
            bVar.b(view);
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        int childCount = getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = getChildAt(i2);
            if (childAt.getVisibility() == 4) {
                childAt.setVisibility(0);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(View view) {
        b bVar = this.f21719z;
        if (bVar != null) {
            bVar.a(view);
        }
        sendAccessibilityEvent(32);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && super.checkLayoutParams(layoutParams);
    }

    public void computeScroll() {
        a aVar = this.A;
        if (aVar != null && aVar.a(true)) {
            if (!a()) {
                this.A.d();
            } else {
                ac.e(this);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void d(View view) {
        b bVar = this.f21719z;
        if (bVar != null) {
            bVar.c(view);
        }
        sendAccessibilityEvent(32);
    }

    public boolean d() {
        if (this.B) {
            this.f21710q = SlideState.COLLAPSED;
            return true;
        } else if (this.f21710q == SlideState.HIDDEN || this.f21710q == SlideState.COLLAPSED) {
            return false;
        } else {
            return a(this.f21708o, 0);
        }
    }

    public void draw(Canvas canvas) {
        int i2;
        int i3;
        super.draw(canvas);
        if (a()) {
            int right = this.f21708o.getRight();
            if (this.f21704k) {
                i3 = this.f21708o.getTop() - this.f21702i;
                i2 = this.f21708o.getTop();
            } else {
                i3 = this.f21708o.getBottom();
                i2 = this.f21708o.getBottom() + this.f21702i;
            }
            int left = this.f21708o.getLeft();
            Drawable drawable = this.f21700g;
            if (drawable != null) {
                drawable.setBounds(left, i3, right, i2);
                this.f21700g.draw(canvas);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean drawChild(Canvas canvas, View view, long j2) {
        int save = canvas.save(2);
        if (a() && this.f21708o != view && !this.f21705l) {
            canvas.getClipBounds(this.C);
            if (this.f21704k) {
                Rect rect = this.C;
                rect.bottom = Math.min(rect.bottom, this.f21708o.getTop());
            } else {
                Rect rect2 = this.C;
                rect2.top = Math.max(rect2.top, this.f21708o.getBottom());
            }
            canvas.clipRect(this.C);
        }
        boolean drawChild = super.drawChild(canvas, view, j2);
        canvas.restoreToCount(save);
        int i2 = this.f21698e;
        if (i2 != 0) {
            float f2 = this.f21711r;
            if (f2 > 0.0f) {
                this.f21699f.setColor((i2 & 16777215) | (((int) (((float) ((-16777216 & i2) >>> 24)) * f2)) << 24));
                canvas.drawRect(this.C, this.f21699f);
            }
        }
        return drawChild;
    }

    /* access modifiers changed from: package-private */
    public void e(View view) {
        b bVar = this.f21719z;
        if (bVar != null) {
            bVar.d(view);
        }
        sendAccessibilityEvent(32);
    }

    public boolean e() {
        if (!this.B) {
            return a(1.0f);
        }
        this.f21710q = SlideState.EXPANDED;
        return true;
    }

    public boolean f() {
        return this.f21710q == SlideState.EXPANDED;
    }

    public boolean g() {
        return this.f21710q == SlideState.ANCHORED;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams();
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
    }

    public float getAnchorPoint() {
        return this.f21718y;
    }

    public int getCoveredFadeColor() {
        return this.f21698e;
    }

    public int getCurrentParalaxOffset() {
        int max = (int) (((float) this.f21703j) * Math.max(this.f21711r, 0.0f));
        return this.f21704k ? -max : max;
    }

    public int getPanelHeight() {
        return this.f21701h;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.B = true;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.B = true;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i2 = this.f21707n;
        if (i2 != -1) {
            setDragView(findViewById(i2));
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int a2 = l.a(motionEvent);
        if (!isEnabled() || !this.f21714u || (this.f21713t && a2 != 0)) {
            this.A.c();
            return super.onInterceptTouchEvent(motionEvent);
        } else if (a2 == 3 || a2 == 1) {
            this.A.c();
            return false;
        } else {
            float x2 = motionEvent.getX();
            float y2 = motionEvent.getY();
            if (a2 == 0) {
                this.f21713t = false;
                this.f21716w = x2;
                this.f21717x = y2;
            } else if (a2 == 2) {
                float abs = Math.abs(x2 - this.f21716w);
                float abs2 = Math.abs(y2 - this.f21717x);
                int b2 = this.A.b();
                if (this.f21715v) {
                    float f2 = (float) b2;
                    if (abs > f2 && abs2 < f2) {
                        return super.onInterceptTouchEvent(motionEvent);
                    }
                }
                if ((abs2 > ((float) b2) && abs > abs2) || !a((int) this.f21716w, (int) this.f21717x)) {
                    this.A.c();
                    this.f21713t = true;
                    return false;
                }
            }
            return this.A.a(motionEvent);
        }
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        float f2;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int childCount = getChildCount();
        if (this.B) {
            int i6 = AnonymousClass2.f21721a[this.f21710q.ordinal()];
            if (i6 == 1) {
                f2 = 1.0f;
            } else if (i6 == 2) {
                f2 = this.f21718y;
            } else if (i6 != 3) {
                this.f21711r = 0.0f;
            } else {
                f2 = a(b(0.0f) + (this.f21704k ? this.f21701h : -this.f21701h));
            }
            this.f21711r = f2;
        }
        for (int i7 = 0; i7 < childCount; i7++) {
            View childAt = getChildAt(i7);
            if (childAt.getVisibility() != 8 || (i7 != 0 && !this.B)) {
                int measuredHeight = childAt.getMeasuredHeight();
                int b2 = childAt == this.f21708o ? b(this.f21711r) : paddingTop;
                if (!this.f21704k && childAt == this.f21709p && !this.f21705l) {
                    b2 = b(this.f21711r) + this.f21708o.getMeasuredHeight();
                }
                childAt.layout(paddingLeft, b2, childAt.getMeasuredWidth() + paddingLeft, measuredHeight + b2);
            }
        }
        if (this.B) {
            b();
        }
        this.B = false;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i3);
        int size2 = View.MeasureSpec.getSize(i3);
        if (mode != 1073741824) {
            throw new IllegalStateException("Width must have an exact value or MATCH_PARENT");
        } else if (mode2 == 1073741824) {
            int childCount = getChildCount();
            if (childCount == 2) {
                this.f21709p = getChildAt(0);
                View childAt = getChildAt(1);
                this.f21708o = childAt;
                if (this.f21706m == null) {
                    setDragView(childAt);
                }
                if (this.f21708o.getVisibility() == 8) {
                    this.f21710q = SlideState.HIDDEN;
                }
                int paddingTop = (size2 - getPaddingTop()) - getPaddingBottom();
                for (int i4 = 0; i4 < childCount; i4++) {
                    View childAt2 = getChildAt(i4);
                    LayoutParams layoutParams = (LayoutParams) childAt2.getLayoutParams();
                    if (childAt2.getVisibility() != 8 || i4 != 0) {
                        int i5 = (childAt2 != this.f21709p || this.f21705l || this.f21710q == SlideState.HIDDEN) ? paddingTop : paddingTop - this.f21701h;
                        childAt2.measure(layoutParams.width == -2 ? View.MeasureSpec.makeMeasureSpec(size, Integer.MIN_VALUE) : layoutParams.width == -1 ? View.MeasureSpec.makeMeasureSpec(size, MemoryConstants.GB) : View.MeasureSpec.makeMeasureSpec(layoutParams.width, MemoryConstants.GB), layoutParams.height == -2 ? View.MeasureSpec.makeMeasureSpec(i5, Integer.MIN_VALUE) : layoutParams.height == -1 ? View.MeasureSpec.makeMeasureSpec(i5, MemoryConstants.GB) : View.MeasureSpec.makeMeasureSpec(layoutParams.height, MemoryConstants.GB));
                        View view = this.f21708o;
                        if (childAt2 == view) {
                            this.f21712s = view.getMeasuredHeight() - this.f21701h;
                        }
                    }
                }
                setMeasuredDimension(size, size2);
                return;
            }
            throw new IllegalStateException("Sliding up panel layout must have exactly 2 children!");
        } else {
            throw new IllegalStateException("Height must have an exact value or MATCH_PARENT");
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        this.f21710q = savedState.f21723a;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        savedState.f21723a = this.f21710q;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i3 != i5) {
            this.B = true;
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (!a()) {
            return super.onTouchEvent(motionEvent);
        }
        this.A.b(motionEvent);
        return true;
    }

    public void setAnchorPoint(float f2) {
        if (f2 > 0.0f && f2 <= 1.0f) {
            this.f21718y = f2;
        }
    }

    public void setCoveredFadeColor(int i2) {
        this.f21698e = i2;
        invalidate();
    }

    public void setDragView(View view) {
        View view2 = this.f21706m;
        if (view2 != null) {
            view2.setOnClickListener((View.OnClickListener) null);
        }
        this.f21706m = view;
        if (view != null) {
            view.setClickable(true);
            this.f21706m.setFocusable(false);
            this.f21706m.setFocusableInTouchMode(false);
            this.f21706m.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    if (SlidingUpPanelLayout.this.isEnabled()) {
                        if (SlidingUpPanelLayout.this.f() || SlidingUpPanelLayout.this.g()) {
                            SlidingUpPanelLayout.this.d();
                            return;
                        }
                        SlidingUpPanelLayout slidingUpPanelLayout = SlidingUpPanelLayout.this;
                        slidingUpPanelLayout.a(slidingUpPanelLayout.f21718y);
                    }
                }
            });
        }
    }

    public void setEnableDragViewTouchEvents(boolean z2) {
        this.f21715v = z2;
    }

    public void setEnabled(boolean z2) {
        if (!z2) {
            d();
        }
        super.setEnabled(z2);
    }

    public void setOverlayed(boolean z2) {
        this.f21705l = z2;
    }

    public void setPanelHeight(int i2) {
        this.f21701h = i2;
        requestLayout();
    }

    public void setPanelSlideListener(b bVar) {
        this.f21719z = bVar;
    }

    public void setSlidingEnabled(boolean z2) {
        this.f21714u = z2;
    }
}
