package com.google.android.material.textfield;

import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStructure;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.appcompat.widget.f;
import androidx.appcompat.widget.q;
import androidx.core.widget.j;
import androidx.customview.view.AbsSavedState;
import com.google.android.material.R;
import com.google.android.material.internal.CheckableImageButton;
import gw.h;
import gw.m;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;
import t.ac;

public class TextInputLayout extends LinearLayout {

    /* renamed from: d  reason: collision with root package name */
    private static final int f19733d = R.style.Widget_Design_TextInputLayout;
    private CharSequence A;
    private final TextView B;
    private boolean C;
    private CharSequence D;
    private boolean E;
    private h F;
    private h G;
    private m H;
    private final int I;
    private int J;
    private int K;
    private int L;
    private int M;
    private int N;
    private int O;
    private int P;
    private int Q;
    private final Rect R;
    private final Rect S;
    private final RectF T;
    private Typeface U;
    private final CheckableImageButton V;
    private ColorStateList W;

    /* renamed from: a  reason: collision with root package name */
    EditText f19734a;
    private int aA;
    private ColorStateList aB;
    private int aC;
    private int aD;
    private int aE;
    private int aF;
    private int aG;
    private boolean aH;
    private boolean aI;
    private boolean aJ;
    private ValueAnimator aK;
    private boolean aL;
    /* access modifiers changed from: private */
    public boolean aM;

    /* renamed from: aa  reason: collision with root package name */
    private boolean f19735aa;

    /* renamed from: ab  reason: collision with root package name */
    private PorterDuff.Mode f19736ab;

    /* renamed from: ac  reason: collision with root package name */
    private boolean f19737ac;

    /* renamed from: ad  reason: collision with root package name */
    private Drawable f19738ad;

    /* renamed from: ae  reason: collision with root package name */
    private int f19739ae;

    /* renamed from: af  reason: collision with root package name */
    private View.OnLongClickListener f19740af;

    /* renamed from: ag  reason: collision with root package name */
    private final LinkedHashSet<b> f19741ag;

    /* renamed from: ah  reason: collision with root package name */
    private int f19742ah;

    /* renamed from: ai  reason: collision with root package name */
    private final SparseArray<e> f19743ai;
    /* access modifiers changed from: private */

    /* renamed from: aj  reason: collision with root package name */
    public final CheckableImageButton f19744aj;

    /* renamed from: ak  reason: collision with root package name */
    private final LinkedHashSet<c> f19745ak;

    /* renamed from: al  reason: collision with root package name */
    private ColorStateList f19746al;

    /* renamed from: am  reason: collision with root package name */
    private boolean f19747am;

    /* renamed from: an  reason: collision with root package name */
    private PorterDuff.Mode f19748an;

    /* renamed from: ao  reason: collision with root package name */
    private boolean f19749ao;

    /* renamed from: ap  reason: collision with root package name */
    private Drawable f19750ap;

    /* renamed from: aq  reason: collision with root package name */
    private int f19751aq;

    /* renamed from: ar  reason: collision with root package name */
    private Drawable f19752ar;

    /* renamed from: as  reason: collision with root package name */
    private View.OnLongClickListener f19753as;

    /* renamed from: at  reason: collision with root package name */
    private View.OnLongClickListener f19754at;

    /* renamed from: au  reason: collision with root package name */
    private final CheckableImageButton f19755au;

    /* renamed from: av  reason: collision with root package name */
    private ColorStateList f19756av;

    /* renamed from: aw  reason: collision with root package name */
    private ColorStateList f19757aw;

    /* renamed from: ax  reason: collision with root package name */
    private ColorStateList f19758ax;

    /* renamed from: ay  reason: collision with root package name */
    private int f19759ay;

    /* renamed from: az  reason: collision with root package name */
    private int f19760az;

    /* renamed from: b  reason: collision with root package name */
    boolean f19761b;

    /* renamed from: c  reason: collision with root package name */
    final com.google.android.material.internal.a f19762c;

    /* renamed from: e  reason: collision with root package name */
    private final FrameLayout f19763e;

    /* renamed from: f  reason: collision with root package name */
    private final LinearLayout f19764f;

    /* renamed from: g  reason: collision with root package name */
    private final LinearLayout f19765g;

    /* renamed from: h  reason: collision with root package name */
    private final FrameLayout f19766h;

    /* renamed from: i  reason: collision with root package name */
    private CharSequence f19767i;

    /* renamed from: j  reason: collision with root package name */
    private int f19768j;

    /* renamed from: k  reason: collision with root package name */
    private int f19769k;

    /* renamed from: l  reason: collision with root package name */
    private final f f19770l;

    /* renamed from: m  reason: collision with root package name */
    private int f19771m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f19772n;

    /* renamed from: o  reason: collision with root package name */
    private TextView f19773o;

    /* renamed from: p  reason: collision with root package name */
    private int f19774p;

    /* renamed from: q  reason: collision with root package name */
    private int f19775q;

    /* renamed from: r  reason: collision with root package name */
    private CharSequence f19776r;
    /* access modifiers changed from: private */

    /* renamed from: s  reason: collision with root package name */
    public boolean f19777s;

    /* renamed from: t  reason: collision with root package name */
    private TextView f19778t;

    /* renamed from: u  reason: collision with root package name */
    private ColorStateList f19779u;

    /* renamed from: v  reason: collision with root package name */
    private int f19780v;

    /* renamed from: w  reason: collision with root package name */
    private ColorStateList f19781w;

    /* renamed from: x  reason: collision with root package name */
    private ColorStateList f19782x;

    /* renamed from: y  reason: collision with root package name */
    private CharSequence f19783y;

    /* renamed from: z  reason: collision with root package name */
    private final TextView f19784z;

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            /* renamed from: a */
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            /* renamed from: a */
            public SavedState[] newArray(int i2) {
                return new SavedState[i2];
            }
        };

        /* renamed from: a  reason: collision with root package name */
        CharSequence f19789a;

        /* renamed from: b  reason: collision with root package name */
        boolean f19790b;

        /* renamed from: d  reason: collision with root package name */
        CharSequence f19791d;

        /* renamed from: e  reason: collision with root package name */
        CharSequence f19792e;

        /* renamed from: f  reason: collision with root package name */
        CharSequence f19793f;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f19789a = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f19790b = parcel.readInt() != 1 ? false : true;
            this.f19791d = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f19792e = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.f19793f = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "TextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.f19789a + " hint=" + this.f19791d + " helperText=" + this.f19792e + " placeholderText=" + this.f19793f + "}";
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            TextUtils.writeToParcel(this.f19789a, parcel, i2);
            parcel.writeInt(this.f19790b ? 1 : 0);
            TextUtils.writeToParcel(this.f19791d, parcel, i2);
            TextUtils.writeToParcel(this.f19792e, parcel, i2);
            TextUtils.writeToParcel(this.f19793f, parcel, i2);
        }
    }

    public static class a extends t.a {

        /* renamed from: a  reason: collision with root package name */
        private final TextInputLayout f19794a;

        public a(TextInputLayout textInputLayout) {
            this.f19794a = textInputLayout;
        }

        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0083, code lost:
            if (r3 != null) goto L_0x0085;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void a(android.view.View r14, u.c r15) {
            /*
                r13 = this;
                super.a((android.view.View) r14, (u.c) r15)
                com.google.android.material.textfield.TextInputLayout r14 = r13.f19794a
                android.widget.EditText r14 = r14.getEditText()
                if (r14 == 0) goto L_0x0010
                android.text.Editable r0 = r14.getText()
                goto L_0x0011
            L_0x0010:
                r0 = 0
            L_0x0011:
                com.google.android.material.textfield.TextInputLayout r1 = r13.f19794a
                java.lang.CharSequence r1 = r1.getHint()
                com.google.android.material.textfield.TextInputLayout r2 = r13.f19794a
                java.lang.CharSequence r2 = r2.getError()
                com.google.android.material.textfield.TextInputLayout r3 = r13.f19794a
                java.lang.CharSequence r3 = r3.getPlaceholderText()
                com.google.android.material.textfield.TextInputLayout r4 = r13.f19794a
                int r4 = r4.getCounterMaxLength()
                com.google.android.material.textfield.TextInputLayout r5 = r13.f19794a
                java.lang.CharSequence r5 = r5.getCounterOverflowDescription()
                boolean r6 = android.text.TextUtils.isEmpty(r0)
                r7 = 1
                r6 = r6 ^ r7
                boolean r8 = android.text.TextUtils.isEmpty(r1)
                r8 = r8 ^ r7
                com.google.android.material.textfield.TextInputLayout r9 = r13.f19794a
                boolean r9 = r9.j()
                r9 = r9 ^ r7
                boolean r10 = android.text.TextUtils.isEmpty(r2)
                r10 = r10 ^ r7
                if (r10 != 0) goto L_0x0051
                boolean r11 = android.text.TextUtils.isEmpty(r5)
                if (r11 != 0) goto L_0x004f
                goto L_0x0051
            L_0x004f:
                r11 = 0
                goto L_0x0052
            L_0x0051:
                r11 = 1
            L_0x0052:
                if (r8 == 0) goto L_0x0059
                java.lang.String r1 = r1.toString()
                goto L_0x005b
            L_0x0059:
                java.lang.String r1 = ""
            L_0x005b:
                java.lang.String r8 = ", "
                if (r6 == 0) goto L_0x0063
                r15.c((java.lang.CharSequence) r0)
                goto L_0x0088
            L_0x0063:
                boolean r12 = android.text.TextUtils.isEmpty(r1)
                if (r12 != 0) goto L_0x0083
                r15.c((java.lang.CharSequence) r1)
                if (r9 == 0) goto L_0x0088
                if (r3 == 0) goto L_0x0088
                java.lang.StringBuilder r9 = new java.lang.StringBuilder
                r9.<init>()
                r9.append(r1)
                r9.append(r8)
                r9.append(r3)
                java.lang.String r3 = r9.toString()
                goto L_0x0085
            L_0x0083:
                if (r3 == 0) goto L_0x0088
            L_0x0085:
                r15.c((java.lang.CharSequence) r3)
            L_0x0088:
                boolean r3 = android.text.TextUtils.isEmpty(r1)
                if (r3 != 0) goto L_0x00b4
                int r3 = android.os.Build.VERSION.SDK_INT
                r9 = 26
                if (r3 < r9) goto L_0x0098
                r15.g((java.lang.CharSequence) r1)
                goto L_0x00af
            L_0x0098:
                if (r6 == 0) goto L_0x00ac
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r0)
                r3.append(r8)
                r3.append(r1)
                java.lang.String r1 = r3.toString()
            L_0x00ac:
                r15.c((java.lang.CharSequence) r1)
            L_0x00af:
                r1 = r6 ^ 1
                r15.o(r1)
            L_0x00b4:
                if (r0 == 0) goto L_0x00bd
                int r0 = r0.length()
                if (r0 != r4) goto L_0x00bd
                goto L_0x00be
            L_0x00bd:
                r4 = -1
            L_0x00be:
                r15.c((int) r4)
                if (r11 == 0) goto L_0x00ca
                if (r10 == 0) goto L_0x00c6
                goto L_0x00c7
            L_0x00c6:
                r2 = r5
            L_0x00c7:
                r15.h((java.lang.CharSequence) r2)
            L_0x00ca:
                int r15 = android.os.Build.VERSION.SDK_INT
                r0 = 17
                if (r15 < r0) goto L_0x00d7
                if (r14 == 0) goto L_0x00d7
                int r15 = com.google.android.material.R.id.textinput_helper_text
                r14.setLabelFor(r15)
            L_0x00d7:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.a.a(android.view.View, u.c):void");
        }
    }

    public interface b {
        void a(TextInputLayout textInputLayout);
    }

    public interface c {
        void a(TextInputLayout textInputLayout, int i2);
    }

    public TextInputLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public TextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.textInputStyle);
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public TextInputLayout(android.content.Context r28, android.util.AttributeSet r29, int r30) {
        /*
            r27 = this;
            r0 = r27
            r7 = r29
            r8 = r30
            int r9 = f19733d
            r1 = r28
            android.content.Context r1 = gx.a.a(r1, r7, r8, r9)
            r0.<init>(r1, r7, r8)
            r10 = -1
            r0.f19768j = r10
            r0.f19769k = r10
            com.google.android.material.textfield.f r1 = new com.google.android.material.textfield.f
            r1.<init>(r0)
            r0.f19770l = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.R = r1
            android.graphics.Rect r1 = new android.graphics.Rect
            r1.<init>()
            r0.S = r1
            android.graphics.RectF r1 = new android.graphics.RectF
            r1.<init>()
            r0.T = r1
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            r0.f19741ag = r1
            r11 = 0
            r0.f19742ah = r11
            android.util.SparseArray r12 = new android.util.SparseArray
            r12.<init>()
            r0.f19743ai = r12
            java.util.LinkedHashSet r1 = new java.util.LinkedHashSet
            r1.<init>()
            r0.f19745ak = r1
            com.google.android.material.internal.a r1 = new com.google.android.material.internal.a
            r1.<init>(r0)
            r0.f19762c = r1
            android.content.Context r13 = r27.getContext()
            r14 = 1
            r0.setOrientation(r14)
            r0.setWillNotDraw(r11)
            r0.setAddStatesFromChildren(r14)
            android.widget.FrameLayout r2 = new android.widget.FrameLayout
            r2.<init>(r13)
            r0.f19763e = r2
            r2.setAddStatesFromChildren(r14)
            r0.addView(r2)
            android.widget.LinearLayout r15 = new android.widget.LinearLayout
            r15.<init>(r13)
            r0.f19764f = r15
            r15.setOrientation(r11)
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
            r6 = -2
            r4 = 8388611(0x800003, float:1.1754948E-38)
            r3.<init>(r6, r10, r4)
            r15.setLayoutParams(r3)
            r2.addView(r15)
            android.widget.LinearLayout r5 = new android.widget.LinearLayout
            r5.<init>(r13)
            r0.f19765g = r5
            r5.setOrientation(r11)
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
            r4 = 8388613(0x800005, float:1.175495E-38)
            r3.<init>(r6, r10, r4)
            r5.setLayoutParams(r3)
            r2.addView(r5)
            android.widget.FrameLayout r4 = new android.widget.FrameLayout
            r4.<init>(r13)
            r0.f19766h = r4
            android.widget.FrameLayout$LayoutParams r2 = new android.widget.FrameLayout$LayoutParams
            r2.<init>(r6, r10)
            r4.setLayoutParams(r2)
            android.animation.TimeInterpolator r2 = gl.a.f28535a
            r1.a((android.animation.TimeInterpolator) r2)
            android.animation.TimeInterpolator r2 = gl.a.f28535a
            r1.b((android.animation.TimeInterpolator) r2)
            r2 = 8388659(0x800033, float:1.1755015E-38)
            r1.c((int) r2)
            int[] r3 = com.google.android.material.R.styleable.TextInputLayout
            r1 = 5
            int[] r2 = new int[r1]
            int r1 = com.google.android.material.R.styleable.TextInputLayout_counterTextAppearance
            r2[r11] = r1
            int r1 = com.google.android.material.R.styleable.TextInputLayout_counterOverflowTextAppearance
            r2[r14] = r1
            int r1 = com.google.android.material.R.styleable.TextInputLayout_errorTextAppearance
            r11 = 2
            r2[r11] = r1
            int r1 = com.google.android.material.R.styleable.TextInputLayout_helperTextTextAppearance
            r11 = 3
            r2[r11] = r1
            int r1 = com.google.android.material.R.styleable.TextInputLayout_hintTextAppearance
            r16 = 4
            r2[r16] = r1
            r1 = r13
            r16 = r2
            r2 = r29
            r11 = r4
            r4 = r30
            r17 = r5
            r5 = r9
            r6 = r16
            androidx.appcompat.widget.af r1 = com.google.android.material.internal.l.b(r1, r2, r3, r4, r5, r6)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_hintEnabled
            boolean r2 = r1.a((int) r2, (boolean) r14)
            r0.C = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_android_hint
            java.lang.CharSequence r2 = r1.c(r2)
            r0.setHint((java.lang.CharSequence) r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_hintAnimationEnabled
            boolean r2 = r1.a((int) r2, (boolean) r14)
            r0.aJ = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_expandedHintEnabled
            boolean r2 = r1.a((int) r2, (boolean) r14)
            r0.aI = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_android_minWidth
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x011c
            int r2 = com.google.android.material.R.styleable.TextInputLayout_android_minWidth
            int r2 = r1.e(r2, r10)
            r0.setMinWidth(r2)
        L_0x011c:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_android_maxWidth
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x012d
            int r2 = com.google.android.material.R.styleable.TextInputLayout_android_maxWidth
            int r2 = r1.e(r2, r10)
            r0.setMaxWidth(r2)
        L_0x012d:
            gw.m$a r2 = gw.m.a((android.content.Context) r13, (android.util.AttributeSet) r7, (int) r8, (int) r9)
            gw.m r2 = r2.a()
            r0.H = r2
            android.content.res.Resources r2 = r13.getResources()
            int r3 = com.google.android.material.R.dimen.mtrl_textinput_box_label_cutout_padding
            int r2 = r2.getDimensionPixelOffset(r3)
            r0.I = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxCollapsedPaddingTop
            r3 = 0
            int r2 = r1.d(r2, r3)
            r0.L = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeWidth
            android.content.res.Resources r3 = r13.getResources()
            int r4 = com.google.android.material.R.dimen.mtrl_textinput_box_stroke_width_default
            int r3 = r3.getDimensionPixelSize(r4)
            int r2 = r1.e(r2, r3)
            r0.N = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeWidthFocused
            android.content.res.Resources r3 = r13.getResources()
            int r4 = com.google.android.material.R.dimen.mtrl_textinput_box_stroke_width_focused
            int r3 = r3.getDimensionPixelSize(r4)
            int r2 = r1.e(r2, r3)
            r0.O = r2
            int r2 = r0.N
            r0.M = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusTopStart
            r3 = -1082130432(0xffffffffbf800000, float:-1.0)
            float r2 = r1.b((int) r2, (float) r3)
            int r4 = com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusTopEnd
            float r4 = r1.b((int) r4, (float) r3)
            int r5 = com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusBottomEnd
            float r5 = r1.b((int) r5, (float) r3)
            int r6 = com.google.android.material.R.styleable.TextInputLayout_boxCornerRadiusBottomStart
            float r3 = r1.b((int) r6, (float) r3)
            gw.m r6 = r0.H
            gw.m$a r6 = r6.n()
            r7 = 0
            int r8 = (r2 > r7 ? 1 : (r2 == r7 ? 0 : -1))
            if (r8 < 0) goto L_0x019c
            r6.b((float) r2)
        L_0x019c:
            int r2 = (r4 > r7 ? 1 : (r4 == r7 ? 0 : -1))
            if (r2 < 0) goto L_0x01a3
            r6.c((float) r4)
        L_0x01a3:
            int r2 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r2 < 0) goto L_0x01aa
            r6.d((float) r5)
        L_0x01aa:
            int r2 = (r3 > r7 ? 1 : (r3 == r7 ? 0 : -1))
            if (r2 < 0) goto L_0x01b1
            r6.e((float) r3)
        L_0x01b1:
            gw.m r2 = r6.a()
            r0.H = r2
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxBackgroundColor
            android.content.res.ColorStateList r2 = gt.c.a((android.content.Context) r13, (androidx.appcompat.widget.af) r1, (int) r2)
            if (r2 == 0) goto L_0x0214
            int r3 = r2.getDefaultColor()
            r0.aC = r3
            r0.Q = r3
            boolean r3 = r2.isStateful()
            r4 = -16842910(0xfffffffffefeff62, float:-1.6947497E38)
            if (r3 == 0) goto L_0x01f1
            int[] r3 = new int[r14]
            r5 = 0
            r3[r5] = r4
            int r3 = r2.getColorForState(r3, r10)
            r0.aD = r3
            r3 = 2
            int[] r4 = new int[r3]
            r4 = {16842908, 16842910} // fill-array
            int r4 = r2.getColorForState(r4, r10)
            r0.aE = r4
            int[] r4 = new int[r3]
            r4 = {16843623, 16842910} // fill-array
            int r2 = r2.getColorForState(r4, r10)
            goto L_0x0211
        L_0x01f1:
            int r2 = r0.aC
            r0.aE = r2
            int r2 = com.google.android.material.R.color.mtrl_filled_background_color
            android.content.res.ColorStateList r2 = c.a.a(r13, r2)
            int[] r3 = new int[r14]
            r5 = 0
            r3[r5] = r4
            int r3 = r2.getColorForState(r3, r10)
            r0.aD = r3
            int[] r3 = new int[r14]
            r4 = 16843623(0x1010367, float:2.3696E-38)
            r3[r5] = r4
            int r2 = r2.getColorForState(r3, r10)
        L_0x0211:
            r0.aF = r2
            goto L_0x021f
        L_0x0214:
            r5 = 0
            r0.Q = r5
            r0.aC = r5
            r0.aD = r5
            r0.aE = r5
            r0.aF = r5
        L_0x021f:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_android_textColorHint
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x0231
            int r2 = com.google.android.material.R.styleable.TextInputLayout_android_textColorHint
            android.content.res.ColorStateList r2 = r1.e(r2)
            r0.f19758ax = r2
            r0.f19757aw = r2
        L_0x0231:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeColor
            android.content.res.ColorStateList r2 = gt.c.a((android.content.Context) r13, (androidx.appcompat.widget.af) r1, (int) r2)
            int r3 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeColor
            r4 = 0
            int r3 = r1.b((int) r3, (int) r4)
            r0.aA = r3
            int r3 = com.google.android.material.R.color.mtrl_textinput_default_box_stroke_color
            int r3 = androidx.core.content.b.c(r13, r3)
            r0.f19759ay = r3
            int r3 = com.google.android.material.R.color.mtrl_textinput_disabled_color
            int r3 = androidx.core.content.b.c(r13, r3)
            r0.aG = r3
            int r3 = com.google.android.material.R.color.mtrl_textinput_hovered_box_stroke_color
            int r3 = androidx.core.content.b.c(r13, r3)
            r0.f19760az = r3
            if (r2 == 0) goto L_0x025d
            r0.setBoxStrokeColorStateList(r2)
        L_0x025d:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeErrorColor
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x026e
            int r2 = com.google.android.material.R.styleable.TextInputLayout_boxStrokeErrorColor
            android.content.res.ColorStateList r2 = gt.c.a((android.content.Context) r13, (androidx.appcompat.widget.af) r1, (int) r2)
            r0.setBoxStrokeErrorColor(r2)
        L_0x026e:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_hintTextAppearance
            int r2 = r1.g(r2, r10)
            if (r2 == r10) goto L_0x0281
            int r2 = com.google.android.material.R.styleable.TextInputLayout_hintTextAppearance
            r3 = 0
            int r2 = r1.g(r2, r3)
            r0.setHintTextAppearance(r2)
            goto L_0x0282
        L_0x0281:
            r3 = 0
        L_0x0282:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_errorTextAppearance
            int r2 = r1.g(r2, r3)
            int r4 = com.google.android.material.R.styleable.TextInputLayout_errorContentDescription
            java.lang.CharSequence r4 = r1.c(r4)
            int r5 = com.google.android.material.R.styleable.TextInputLayout_errorEnabled
            boolean r5 = r1.a((int) r5, (boolean) r3)
            android.content.Context r6 = r27.getContext()
            android.view.LayoutInflater r6 = android.view.LayoutInflater.from(r6)
            int r7 = com.google.android.material.R.layout.design_text_input_end_icon
            r8 = r17
            android.view.View r6 = r6.inflate(r7, r8, r3)
            com.google.android.material.internal.CheckableImageButton r6 = (com.google.android.material.internal.CheckableImageButton) r6
            r0.f19755au = r6
            int r7 = com.google.android.material.R.id.text_input_error_icon
            r6.setId(r7)
            r7 = 8
            r6.setVisibility(r7)
            boolean r9 = gt.c.a(r13)
            if (r9 == 0) goto L_0x02c1
            android.view.ViewGroup$LayoutParams r9 = r6.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r9 = (android.view.ViewGroup.MarginLayoutParams) r9
            t.j.a(r9, r3)
        L_0x02c1:
            int r3 = com.google.android.material.R.styleable.TextInputLayout_errorIconDrawable
            boolean r3 = r1.g(r3)
            if (r3 == 0) goto L_0x02d2
            int r3 = com.google.android.material.R.styleable.TextInputLayout_errorIconDrawable
            android.graphics.drawable.Drawable r3 = r1.a(r3)
            r0.setErrorIconDrawable((android.graphics.drawable.Drawable) r3)
        L_0x02d2:
            int r3 = com.google.android.material.R.styleable.TextInputLayout_errorIconTint
            boolean r3 = r1.g(r3)
            if (r3 == 0) goto L_0x02e3
            int r3 = com.google.android.material.R.styleable.TextInputLayout_errorIconTint
            android.content.res.ColorStateList r3 = gt.c.a((android.content.Context) r13, (androidx.appcompat.widget.af) r1, (int) r3)
            r0.setErrorIconTintList(r3)
        L_0x02e3:
            int r3 = com.google.android.material.R.styleable.TextInputLayout_errorIconTintMode
            boolean r3 = r1.g(r3)
            r9 = 0
            if (r3 == 0) goto L_0x02f9
            int r3 = com.google.android.material.R.styleable.TextInputLayout_errorIconTintMode
            int r3 = r1.a((int) r3, (int) r10)
            android.graphics.PorterDuff$Mode r3 = com.google.android.material.internal.s.a((int) r3, (android.graphics.PorterDuff.Mode) r9)
            r0.setErrorIconTintMode(r3)
        L_0x02f9:
            android.content.res.Resources r3 = r27.getResources()
            int r14 = com.google.android.material.R.string.error_icon_content_description
            java.lang.CharSequence r3 = r3.getText(r14)
            r6.setContentDescription(r3)
            r3 = 2
            t.ac.b((android.view.View) r6, (int) r3)
            r3 = 0
            r6.setClickable(r3)
            r6.setPressable(r3)
            r6.setFocusable(r3)
            int r14 = com.google.android.material.R.styleable.TextInputLayout_helperTextTextAppearance
            int r14 = r1.g(r14, r3)
            int r9 = com.google.android.material.R.styleable.TextInputLayout_helperTextEnabled
            boolean r9 = r1.a((int) r9, (boolean) r3)
            int r7 = com.google.android.material.R.styleable.TextInputLayout_helperText
            java.lang.CharSequence r7 = r1.c(r7)
            int r10 = com.google.android.material.R.styleable.TextInputLayout_placeholderTextAppearance
            int r10 = r1.g(r10, r3)
            int r3 = com.google.android.material.R.styleable.TextInputLayout_placeholderText
            java.lang.CharSequence r3 = r1.c(r3)
            r18 = r10
            int r10 = com.google.android.material.R.styleable.TextInputLayout_prefixTextAppearance
            r19 = r3
            r3 = 0
            int r10 = r1.g(r10, r3)
            int r3 = com.google.android.material.R.styleable.TextInputLayout_prefixText
            java.lang.CharSequence r3 = r1.c(r3)
            r20 = r10
            int r10 = com.google.android.material.R.styleable.TextInputLayout_suffixTextAppearance
            r21 = r3
            r3 = 0
            int r10 = r1.g(r10, r3)
            int r3 = com.google.android.material.R.styleable.TextInputLayout_suffixText
            java.lang.CharSequence r3 = r1.c(r3)
            r22 = r10
            int r10 = com.google.android.material.R.styleable.TextInputLayout_counterEnabled
            r23 = r3
            r3 = 0
            boolean r10 = r1.a((int) r10, (boolean) r3)
            int r3 = com.google.android.material.R.styleable.TextInputLayout_counterMaxLength
            r24 = r10
            r10 = -1
            int r3 = r1.a((int) r3, (int) r10)
            r0.setCounterMaxLength(r3)
            int r3 = com.google.android.material.R.styleable.TextInputLayout_counterTextAppearance
            r10 = 0
            int r3 = r1.g(r3, r10)
            r0.f19775q = r3
            int r3 = com.google.android.material.R.styleable.TextInputLayout_counterOverflowTextAppearance
            int r3 = r1.g(r3, r10)
            r0.f19774p = r3
            android.content.Context r3 = r27.getContext()
            android.view.LayoutInflater r3 = android.view.LayoutInflater.from(r3)
            r25 = r4
            int r4 = com.google.android.material.R.layout.design_text_input_start_icon
            android.view.View r3 = r3.inflate(r4, r15, r10)
            com.google.android.material.internal.CheckableImageButton r3 = (com.google.android.material.internal.CheckableImageButton) r3
            r0.V = r3
            r4 = 8
            r3.setVisibility(r4)
            boolean r4 = gt.c.a(r13)
            if (r4 == 0) goto L_0x03a4
            android.view.ViewGroup$LayoutParams r4 = r3.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r4 = (android.view.ViewGroup.MarginLayoutParams) r4
            t.j.b(r4, r10)
        L_0x03a4:
            r4 = 0
            r0.setStartIconOnClickListener(r4)
            r0.setStartIconOnLongClickListener(r4)
            int r4 = com.google.android.material.R.styleable.TextInputLayout_startIconDrawable
            boolean r4 = r1.g(r4)
            if (r4 == 0) goto L_0x03d7
            int r4 = com.google.android.material.R.styleable.TextInputLayout_startIconDrawable
            android.graphics.drawable.Drawable r4 = r1.a(r4)
            r0.setStartIconDrawable((android.graphics.drawable.Drawable) r4)
            int r4 = com.google.android.material.R.styleable.TextInputLayout_startIconContentDescription
            boolean r4 = r1.g(r4)
            if (r4 == 0) goto L_0x03cd
            int r4 = com.google.android.material.R.styleable.TextInputLayout_startIconContentDescription
            java.lang.CharSequence r4 = r1.c(r4)
            r0.setStartIconContentDescription((java.lang.CharSequence) r4)
        L_0x03cd:
            int r4 = com.google.android.material.R.styleable.TextInputLayout_startIconCheckable
            r10 = 1
            boolean r4 = r1.a((int) r4, (boolean) r10)
            r0.setStartIconCheckable(r4)
        L_0x03d7:
            int r4 = com.google.android.material.R.styleable.TextInputLayout_startIconTint
            boolean r4 = r1.g(r4)
            if (r4 == 0) goto L_0x03e8
            int r4 = com.google.android.material.R.styleable.TextInputLayout_startIconTint
            android.content.res.ColorStateList r4 = gt.c.a((android.content.Context) r13, (androidx.appcompat.widget.af) r1, (int) r4)
            r0.setStartIconTintList(r4)
        L_0x03e8:
            int r4 = com.google.android.material.R.styleable.TextInputLayout_startIconTintMode
            boolean r4 = r1.g(r4)
            if (r4 == 0) goto L_0x03ff
            int r4 = com.google.android.material.R.styleable.TextInputLayout_startIconTintMode
            r10 = -1
            int r4 = r1.a((int) r4, (int) r10)
            r10 = 0
            android.graphics.PorterDuff$Mode r4 = com.google.android.material.internal.s.a((int) r4, (android.graphics.PorterDuff.Mode) r10)
            r0.setStartIconTintMode(r4)
        L_0x03ff:
            int r4 = com.google.android.material.R.styleable.TextInputLayout_boxBackgroundMode
            r10 = 0
            int r4 = r1.a((int) r4, (int) r10)
            r0.setBoxBackgroundMode(r4)
            android.content.Context r4 = r27.getContext()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r26 = r2
            int r2 = com.google.android.material.R.layout.design_text_input_end_icon
            android.view.View r2 = r4.inflate(r2, r11, r10)
            com.google.android.material.internal.CheckableImageButton r2 = (com.google.android.material.internal.CheckableImageButton) r2
            r0.f19744aj = r2
            r11.addView(r2)
            r4 = 8
            r2.setVisibility(r4)
            boolean r4 = gt.c.a(r13)
            if (r4 == 0) goto L_0x0434
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r2 = (android.view.ViewGroup.MarginLayoutParams) r2
            t.j.a(r2, r10)
        L_0x0434:
            com.google.android.material.textfield.b r2 = new com.google.android.material.textfield.b
            r2.<init>(r0)
            r4 = -1
            r12.append(r4, r2)
            com.google.android.material.textfield.g r2 = new com.google.android.material.textfield.g
            r2.<init>(r0)
            r12.append(r10, r2)
            com.google.android.material.textfield.h r2 = new com.google.android.material.textfield.h
            r2.<init>(r0)
            r4 = 1
            r12.append(r4, r2)
            com.google.android.material.textfield.a r2 = new com.google.android.material.textfield.a
            r2.<init>(r0)
            r4 = 2
            r12.append(r4, r2)
            com.google.android.material.textfield.d r2 = new com.google.android.material.textfield.d
            r2.<init>(r0)
            r4 = 3
            r12.append(r4, r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconMode
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x049f
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconMode
            r4 = 0
            int r2 = r1.a((int) r2, (int) r4)
            r0.setEndIconMode(r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconDrawable
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x0483
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconDrawable
            android.graphics.drawable.Drawable r2 = r1.a(r2)
            r0.setEndIconDrawable((android.graphics.drawable.Drawable) r2)
        L_0x0483:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconContentDescription
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x0494
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconContentDescription
            java.lang.CharSequence r2 = r1.c(r2)
            r0.setEndIconContentDescription((java.lang.CharSequence) r2)
        L_0x0494:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconCheckable
            r4 = 1
            boolean r2 = r1.a((int) r2, (boolean) r4)
            r0.setEndIconCheckable(r2)
            goto L_0x04eb
        L_0x049f:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleEnabled
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x04eb
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleEnabled
            r4 = 0
            boolean r2 = r1.a((int) r2, (boolean) r4)
            r0.setEndIconMode(r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleDrawable
            android.graphics.drawable.Drawable r2 = r1.a(r2)
            r0.setEndIconDrawable((android.graphics.drawable.Drawable) r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleContentDescription
            java.lang.CharSequence r2 = r1.c(r2)
            r0.setEndIconContentDescription((java.lang.CharSequence) r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleTint
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x04d4
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleTint
            android.content.res.ColorStateList r2 = gt.c.a((android.content.Context) r13, (androidx.appcompat.widget.af) r1, (int) r2)
            r0.setEndIconTintList(r2)
        L_0x04d4:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleTintMode
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x04eb
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleTintMode
            r4 = -1
            int r2 = r1.a((int) r2, (int) r4)
            r4 = 0
            android.graphics.PorterDuff$Mode r2 = com.google.android.material.internal.s.a((int) r2, (android.graphics.PorterDuff.Mode) r4)
            r0.setEndIconTintMode(r2)
        L_0x04eb:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_passwordToggleEnabled
            boolean r2 = r1.g(r2)
            if (r2 != 0) goto L_0x051b
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconTint
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x0504
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconTint
            android.content.res.ColorStateList r2 = gt.c.a((android.content.Context) r13, (androidx.appcompat.widget.af) r1, (int) r2)
            r0.setEndIconTintList(r2)
        L_0x0504:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconTintMode
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x051b
            int r2 = com.google.android.material.R.styleable.TextInputLayout_endIconTintMode
            r4 = -1
            int r2 = r1.a((int) r2, (int) r4)
            r4 = 0
            android.graphics.PorterDuff$Mode r2 = com.google.android.material.internal.s.a((int) r2, (android.graphics.PorterDuff.Mode) r4)
            r0.setEndIconTintMode(r2)
        L_0x051b:
            androidx.appcompat.widget.AppCompatTextView r2 = new androidx.appcompat.widget.AppCompatTextView
            r2.<init>(r13)
            r0.f19784z = r2
            int r4 = com.google.android.material.R.id.textinput_prefix_text
            r2.setId(r4)
            android.widget.FrameLayout$LayoutParams r4 = new android.widget.FrameLayout$LayoutParams
            r10 = -2
            r4.<init>(r10, r10)
            r2.setLayoutParams(r4)
            r4 = 1
            t.ac.d((android.view.View) r2, (int) r4)
            r15.addView(r3)
            r15.addView(r2)
            androidx.appcompat.widget.AppCompatTextView r2 = new androidx.appcompat.widget.AppCompatTextView
            r2.<init>(r13)
            r0.B = r2
            int r3 = com.google.android.material.R.id.textinput_suffix_text
            r2.setId(r3)
            android.widget.FrameLayout$LayoutParams r3 = new android.widget.FrameLayout$LayoutParams
            r4 = 80
            r3.<init>(r10, r10, r4)
            r2.setLayoutParams(r3)
            r3 = 1
            t.ac.d((android.view.View) r2, (int) r3)
            r8.addView(r2)
            r8.addView(r6)
            r8.addView(r11)
            r0.setHelperTextEnabled(r9)
            r0.setHelperText(r7)
            r0.setHelperTextTextAppearance(r14)
            r0.setErrorEnabled(r5)
            r2 = r26
            r0.setErrorTextAppearance(r2)
            r2 = r25
            r0.setErrorContentDescription(r2)
            int r2 = r0.f19775q
            r0.setCounterTextAppearance(r2)
            int r2 = r0.f19774p
            r0.setCounterOverflowTextAppearance(r2)
            r2 = r19
            r0.setPlaceholderText(r2)
            r2 = r18
            r0.setPlaceholderTextAppearance(r2)
            r2 = r21
            r0.setPrefixText(r2)
            r2 = r20
            r0.setPrefixTextAppearance(r2)
            r2 = r23
            r0.setSuffixText(r2)
            r2 = r22
            r0.setSuffixTextAppearance(r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_errorTextColor
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x05ac
            int r2 = com.google.android.material.R.styleable.TextInputLayout_errorTextColor
            android.content.res.ColorStateList r2 = r1.e(r2)
            r0.setErrorTextColor(r2)
        L_0x05ac:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_helperTextTextColor
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x05bd
            int r2 = com.google.android.material.R.styleable.TextInputLayout_helperTextTextColor
            android.content.res.ColorStateList r2 = r1.e(r2)
            r0.setHelperTextColor(r2)
        L_0x05bd:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_hintTextColor
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x05ce
            int r2 = com.google.android.material.R.styleable.TextInputLayout_hintTextColor
            android.content.res.ColorStateList r2 = r1.e(r2)
            r0.setHintTextColor(r2)
        L_0x05ce:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_counterTextColor
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x05df
            int r2 = com.google.android.material.R.styleable.TextInputLayout_counterTextColor
            android.content.res.ColorStateList r2 = r1.e(r2)
            r0.setCounterTextColor(r2)
        L_0x05df:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_counterOverflowTextColor
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x05f0
            int r2 = com.google.android.material.R.styleable.TextInputLayout_counterOverflowTextColor
            android.content.res.ColorStateList r2 = r1.e(r2)
            r0.setCounterOverflowTextColor(r2)
        L_0x05f0:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_placeholderTextColor
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x0601
            int r2 = com.google.android.material.R.styleable.TextInputLayout_placeholderTextColor
            android.content.res.ColorStateList r2 = r1.e(r2)
            r0.setPlaceholderTextColor(r2)
        L_0x0601:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_prefixTextColor
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x0612
            int r2 = com.google.android.material.R.styleable.TextInputLayout_prefixTextColor
            android.content.res.ColorStateList r2 = r1.e(r2)
            r0.setPrefixTextColor(r2)
        L_0x0612:
            int r2 = com.google.android.material.R.styleable.TextInputLayout_suffixTextColor
            boolean r2 = r1.g(r2)
            if (r2 == 0) goto L_0x0623
            int r2 = com.google.android.material.R.styleable.TextInputLayout_suffixTextColor
            android.content.res.ColorStateList r2 = r1.e(r2)
            r0.setSuffixTextColor(r2)
        L_0x0623:
            r2 = r24
            r0.setCounterEnabled(r2)
            int r2 = com.google.android.material.R.styleable.TextInputLayout_android_enabled
            r3 = 1
            boolean r2 = r1.a((int) r2, (boolean) r3)
            r0.setEnabled(r2)
            r1.b()
            r1 = 2
            t.ac.b((android.view.View) r0, (int) r1)
            int r1 = android.os.Build.VERSION.SDK_INT
            r2 = 26
            if (r1 < r2) goto L_0x0642
            t.ac.a((android.view.View) r0, (int) r3)
        L_0x0642:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.<init>(android.content.Context, android.util.AttributeSet, int):void");
    }

    private void A() {
        if (this.f19734a != null) {
            ac.b(this.B, getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.f19734a.getPaddingTop(), (g() || W()) ? 0 : ac.m(this.f19734a), this.f19734a.getPaddingBottom());
        }
    }

    private void B() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        TextView textView = this.f19773o;
        if (textView != null) {
            a(textView, this.f19772n ? this.f19774p : this.f19775q);
            if (!this.f19772n && (colorStateList2 = this.f19781w) != null) {
                this.f19773o.setTextColor(colorStateList2);
            }
            if (this.f19772n && (colorStateList = this.f19782x) != null) {
                this.f19773o.setTextColor(colorStateList);
            }
        }
    }

    private int C() {
        float d2;
        if (!this.C) {
            return 0;
        }
        int i2 = this.K;
        if (i2 == 0 || i2 == 1) {
            d2 = this.f19762c.d();
        } else if (i2 != 2) {
            return 0;
        } else {
            d2 = this.f19762c.d() / 2.0f;
        }
        return (int) d2;
    }

    private boolean D() {
        return this.K == 1 && (Build.VERSION.SDK_INT < 16 || this.f19734a.getMinLines() <= 1);
    }

    private int E() {
        return this.K == 1 ? gn.a.a(gn.a.a((View) this, R.attr.colorSurface, 0), this.Q) : this.Q;
    }

    private void F() {
        h hVar = this.F;
        if (hVar != null) {
            hVar.setShapeAppearanceModel(this.H);
            if (H()) {
                this.F.a((float) this.M, this.P);
            }
            int E2 = E();
            this.Q = E2;
            this.F.g(ColorStateList.valueOf(E2));
            if (this.f19742ah == 3) {
                this.f19734a.getBackground().invalidateSelf();
            }
            G();
            invalidate();
        }
    }

    private void G() {
        if (this.G != null) {
            if (I()) {
                this.G.g(ColorStateList.valueOf(this.P));
            }
            invalidate();
        }
    }

    private boolean H() {
        return this.K == 2 && I();
    }

    private boolean I() {
        return this.M > -1 && this.P != 0;
    }

    private boolean J() {
        int max;
        if (this.f19734a == null || this.f19734a.getMeasuredHeight() >= (max = Math.max(this.f19765g.getMeasuredHeight(), this.f19764f.getMeasuredHeight()))) {
            return false;
        }
        this.f19734a.setMinimumHeight(max);
        return true;
    }

    private void K() {
        EditText editText;
        if (this.f19778t != null && (editText = this.f19734a) != null) {
            this.f19778t.setGravity(editText.getGravity());
            this.f19778t.setPadding(this.f19734a.getCompoundPaddingLeft(), this.f19734a.getCompoundPaddingTop(), this.f19734a.getCompoundPaddingRight(), this.f19734a.getCompoundPaddingBottom());
        }
    }

    private void L() {
        Iterator it2 = this.f19741ag.iterator();
        while (it2.hasNext()) {
            ((b) it2.next()).a(this);
        }
    }

    private void M() {
        a(this.V, this.f19735aa, this.W, this.f19737ac, this.f19736ab);
    }

    private boolean N() {
        return this.f19742ah != 0;
    }

    private void O() {
        a(this.f19744aj, this.f19747am, this.f19746al, this.f19749ao, this.f19748an);
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00d3  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean P() {
        /*
            r10 = this;
            android.widget.EditText r0 = r10.f19734a
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = r10.Q()
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r0 == 0) goto L_0x0049
            android.widget.LinearLayout r0 = r10.f19764f
            int r0 = r0.getMeasuredWidth()
            android.widget.EditText r6 = r10.f19734a
            int r6 = r6.getPaddingLeft()
            int r0 = r0 - r6
            android.graphics.drawable.Drawable r6 = r10.f19738ad
            if (r6 == 0) goto L_0x0025
            int r6 = r10.f19739ae
            if (r6 == r0) goto L_0x0031
        L_0x0025:
            android.graphics.drawable.ColorDrawable r6 = new android.graphics.drawable.ColorDrawable
            r6.<init>()
            r10.f19738ad = r6
            r10.f19739ae = r0
            r6.setBounds(r1, r1, r0, r5)
        L_0x0031:
            android.widget.EditText r0 = r10.f19734a
            android.graphics.drawable.Drawable[] r0 = androidx.core.widget.j.b(r0)
            r6 = r0[r1]
            android.graphics.drawable.Drawable r7 = r10.f19738ad
            if (r6 == r7) goto L_0x0062
            android.widget.EditText r6 = r10.f19734a
            r8 = r0[r5]
            r9 = r0[r4]
            r0 = r0[r3]
            androidx.core.widget.j.a(r6, r7, r8, r9, r0)
            goto L_0x0060
        L_0x0049:
            android.graphics.drawable.Drawable r0 = r10.f19738ad
            if (r0 == 0) goto L_0x0062
            android.widget.EditText r0 = r10.f19734a
            android.graphics.drawable.Drawable[] r0 = androidx.core.widget.j.b(r0)
            android.widget.EditText r6 = r10.f19734a
            r7 = r0[r5]
            r8 = r0[r4]
            r0 = r0[r3]
            androidx.core.widget.j.a(r6, r2, r7, r8, r0)
            r10.f19738ad = r2
        L_0x0060:
            r0 = 1
            goto L_0x0063
        L_0x0062:
            r0 = 0
        L_0x0063:
            boolean r6 = r10.R()
            if (r6 == 0) goto L_0x00d3
            android.widget.TextView r2 = r10.B
            int r2 = r2.getMeasuredWidth()
            android.widget.EditText r6 = r10.f19734a
            int r6 = r6.getPaddingRight()
            int r2 = r2 - r6
            com.google.android.material.internal.CheckableImageButton r6 = r10.getEndIconToUpdateDummyDrawable()
            if (r6 == 0) goto L_0x008c
            int r7 = r6.getMeasuredWidth()
            int r2 = r2 + r7
            android.view.ViewGroup$LayoutParams r6 = r6.getLayoutParams()
            android.view.ViewGroup$MarginLayoutParams r6 = (android.view.ViewGroup.MarginLayoutParams) r6
            int r6 = t.j.a(r6)
            int r2 = r2 + r6
        L_0x008c:
            android.widget.EditText r6 = r10.f19734a
            android.graphics.drawable.Drawable[] r6 = androidx.core.widget.j.b(r6)
            android.graphics.drawable.Drawable r7 = r10.f19750ap
            if (r7 == 0) goto L_0x00ad
            int r8 = r10.f19751aq
            if (r8 == r2) goto L_0x00ad
            r10.f19751aq = r2
            r7.setBounds(r1, r1, r2, r5)
            android.widget.EditText r0 = r10.f19734a
            r1 = r6[r1]
            r2 = r6[r5]
            android.graphics.drawable.Drawable r4 = r10.f19750ap
            r3 = r6[r3]
            androidx.core.widget.j.a(r0, r1, r2, r4, r3)
            goto L_0x00f4
        L_0x00ad:
            if (r7 != 0) goto L_0x00bb
            android.graphics.drawable.ColorDrawable r7 = new android.graphics.drawable.ColorDrawable
            r7.<init>()
            r10.f19750ap = r7
            r10.f19751aq = r2
            r7.setBounds(r1, r1, r2, r5)
        L_0x00bb:
            r2 = r6[r4]
            android.graphics.drawable.Drawable r7 = r10.f19750ap
            if (r2 == r7) goto L_0x00d1
            r0 = r6[r4]
            r10.f19752ar = r0
            android.widget.EditText r0 = r10.f19734a
            r1 = r6[r1]
            r2 = r6[r5]
            r3 = r6[r3]
            androidx.core.widget.j.a(r0, r1, r2, r7, r3)
            goto L_0x00f4
        L_0x00d1:
            r5 = r0
            goto L_0x00f4
        L_0x00d3:
            android.graphics.drawable.Drawable r6 = r10.f19750ap
            if (r6 == 0) goto L_0x00f5
            android.widget.EditText r6 = r10.f19734a
            android.graphics.drawable.Drawable[] r6 = androidx.core.widget.j.b(r6)
            r4 = r6[r4]
            android.graphics.drawable.Drawable r7 = r10.f19750ap
            if (r4 != r7) goto L_0x00f1
            android.widget.EditText r0 = r10.f19734a
            r1 = r6[r1]
            r4 = r6[r5]
            android.graphics.drawable.Drawable r7 = r10.f19752ar
            r3 = r6[r3]
            androidx.core.widget.j.a(r0, r1, r4, r7, r3)
            goto L_0x00f2
        L_0x00f1:
            r5 = r0
        L_0x00f2:
            r10.f19750ap = r2
        L_0x00f4:
            r0 = r5
        L_0x00f5:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.P():boolean");
    }

    private boolean Q() {
        return !(getStartIconDrawable() == null && this.f19783y == null) && this.f19764f.getMeasuredWidth() > 0;
    }

    private boolean R() {
        return (this.f19755au.getVisibility() == 0 || ((N() && g()) || this.A != null)) && this.f19765g.getMeasuredWidth() > 0;
    }

    private boolean S() {
        return this.C && !TextUtils.isEmpty(this.D) && (this.F instanceof c);
    }

    private void T() {
        if (S()) {
            RectF rectF = this.T;
            this.f19762c.a(rectF, this.f19734a.getWidth(), this.f19734a.getGravity());
            a(rectF);
            this.J = this.M;
            rectF.top = 0.0f;
            rectF.bottom = (float) this.J;
            rectF.offset((float) (-getPaddingLeft()), 0.0f);
            ((c) this.F).a(rectF);
        }
    }

    private void U() {
        if (S() && !this.aH && this.J != this.M) {
            V();
            T();
        }
    }

    private void V() {
        if (S()) {
            ((c) this.F).b();
        }
    }

    private boolean W() {
        return this.f19755au.getVisibility() == 0;
    }

    private int a(int i2, boolean z2) {
        int compoundPaddingLeft = i2 + this.f19734a.getCompoundPaddingLeft();
        return (this.f19783y == null || z2) ? compoundPaddingLeft : (compoundPaddingLeft - this.f19784z.getMeasuredWidth()) + this.f19784z.getPaddingLeft();
    }

    private int a(Rect rect, float f2) {
        return D() ? (int) (((float) rect.centerY()) - (f2 / 2.0f)) : rect.top + this.f19734a.getCompoundPaddingTop();
    }

    private int a(Rect rect, Rect rect2, float f2) {
        return D() ? (int) (((float) rect2.top) + f2) : rect.bottom - this.f19734a.getCompoundPaddingBottom();
    }

    private Rect a(Rect rect) {
        int i2;
        int i3;
        if (this.f19734a != null) {
            Rect rect2 = this.S;
            boolean z2 = ac.i(this) == 1;
            rect2.bottom = rect.bottom;
            int i4 = this.K;
            if (i4 == 1) {
                rect2.left = a(rect.left, z2);
                i2 = rect.top + this.L;
            } else if (i4 != 2) {
                rect2.left = a(rect.left, z2);
                i2 = getPaddingTop();
            } else {
                rect2.left = rect.left + this.f19734a.getPaddingLeft();
                rect2.top = rect.top - C();
                i3 = rect.right - this.f19734a.getPaddingRight();
                rect2.right = i3;
                return rect2;
            }
            rect2.top = i2;
            i3 = b(rect.right, z2);
            rect2.right = i3;
            return rect2;
        }
        throw new IllegalStateException();
    }

    private static void a(Context context, TextView textView, int i2, int i3, boolean z2) {
        textView.setContentDescription(context.getString(z2 ? R.string.character_counter_overflowed_content_description : R.string.character_counter_content_description, new Object[]{Integer.valueOf(i2), Integer.valueOf(i3)}));
    }

    private void a(Canvas canvas) {
        if (this.C) {
            this.f19762c.a(canvas);
        }
    }

    private void a(RectF rectF) {
        rectF.left -= (float) this.I;
        rectF.right += (float) this.I;
    }

    private static void a(ViewGroup viewGroup, boolean z2) {
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            View childAt = viewGroup.getChildAt(i2);
            childAt.setEnabled(z2);
            if (childAt instanceof ViewGroup) {
                a((ViewGroup) childAt, z2);
            }
        }
    }

    private void a(CheckableImageButton checkableImageButton, ColorStateList colorStateList) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (checkableImageButton.getDrawable() != null && colorStateList != null && colorStateList.isStateful()) {
            int colorForState = colorStateList.getColorForState(a(checkableImageButton), colorStateList.getDefaultColor());
            Drawable mutate = androidx.core.graphics.drawable.a.g(drawable).mutate();
            androidx.core.graphics.drawable.a.a(mutate, ColorStateList.valueOf(colorForState));
            checkableImageButton.setImageDrawable(mutate);
        }
    }

    private static void a(CheckableImageButton checkableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnClickListener(onClickListener);
        b(checkableImageButton, onLongClickListener);
    }

    private static void a(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        checkableImageButton.setOnLongClickListener(onLongClickListener);
        b(checkableImageButton, onLongClickListener);
    }

    private void a(CheckableImageButton checkableImageButton, boolean z2, ColorStateList colorStateList, boolean z3, PorterDuff.Mode mode) {
        Drawable drawable = checkableImageButton.getDrawable();
        if (drawable != null && (z2 || z3)) {
            drawable = androidx.core.graphics.drawable.a.g(drawable).mutate();
            if (z2) {
                androidx.core.graphics.drawable.a.a(drawable, colorStateList);
            }
            if (z3) {
                androidx.core.graphics.drawable.a.a(drawable, mode);
            }
        }
        if (checkableImageButton.getDrawable() != drawable) {
            checkableImageButton.setImageDrawable(drawable);
        }
    }

    private void a(boolean z2, boolean z3) {
        ColorStateList colorStateList;
        com.google.android.material.internal.a aVar;
        TextView textView;
        boolean isEnabled = isEnabled();
        EditText editText = this.f19734a;
        boolean z4 = editText != null && !TextUtils.isEmpty(editText.getText());
        EditText editText2 = this.f19734a;
        boolean z5 = editText2 != null && editText2.hasFocus();
        boolean g2 = this.f19770l.g();
        ColorStateList colorStateList2 = this.f19757aw;
        if (colorStateList2 != null) {
            this.f19762c.a(colorStateList2);
            this.f19762c.b(this.f19757aw);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.f19757aw;
            int colorForState = colorStateList3 != null ? colorStateList3.getColorForState(new int[]{-16842910}, this.aG) : this.aG;
            this.f19762c.a(ColorStateList.valueOf(colorForState));
            this.f19762c.b(ColorStateList.valueOf(colorForState));
        } else if (g2) {
            this.f19762c.a(this.f19770l.k());
        } else {
            if (this.f19772n && (textView = this.f19773o) != null) {
                aVar = this.f19762c;
                colorStateList = textView.getTextColors();
            } else if (z5 && (colorStateList = this.f19758ax) != null) {
                aVar = this.f19762c;
            }
            aVar.a(colorStateList);
        }
        if (z4 || !this.aI || (isEnabled() && z5)) {
            if (z3 || this.aH) {
                c(z2);
            }
        } else if (z3 || !this.aH) {
            d(z2);
        }
    }

    private int[] a(CheckableImageButton checkableImageButton) {
        int[] drawableState = getDrawableState();
        int[] drawableState2 = checkableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        return copyOf;
    }

    private int b(int i2, boolean z2) {
        int compoundPaddingRight = i2 - this.f19734a.getCompoundPaddingRight();
        return (this.f19783y == null || !z2) ? compoundPaddingRight : compoundPaddingRight + (this.f19784z.getMeasuredWidth() - this.f19784z.getPaddingRight());
    }

    private Rect b(Rect rect) {
        if (this.f19734a != null) {
            Rect rect2 = this.S;
            float b2 = this.f19762c.b();
            rect2.left = rect.left + this.f19734a.getCompoundPaddingLeft();
            rect2.top = a(rect, b2);
            rect2.right = rect.right - this.f19734a.getCompoundPaddingRight();
            rect2.bottom = a(rect, rect2, b2);
            return rect2;
        }
        throw new IllegalStateException();
    }

    /* access modifiers changed from: private */
    public void b(int i2) {
        if (i2 != 0 || this.aH) {
            u();
        } else {
            t();
        }
    }

    private void b(Canvas canvas) {
        h hVar = this.G;
        if (hVar != null) {
            Rect bounds = hVar.getBounds();
            bounds.top = bounds.bottom - this.M;
            this.G.draw(canvas);
        }
    }

    private static void b(CheckableImageButton checkableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean K2 = ac.K(checkableImageButton);
        boolean z2 = false;
        int i2 = 1;
        boolean z3 = onLongClickListener != null;
        if (K2 || z3) {
            z2 = true;
        }
        checkableImageButton.setFocusable(z2);
        checkableImageButton.setClickable(K2);
        checkableImageButton.setPressable(K2);
        checkableImageButton.setLongClickable(z3);
        if (!z2) {
            i2 = 2;
        }
        ac.b((View) checkableImageButton, i2);
    }

    private void b(boolean z2) {
        if (!z2 || getEndIconDrawable() == null) {
            O();
            return;
        }
        Drawable mutate = androidx.core.graphics.drawable.a.g(getEndIconDrawable()).mutate();
        androidx.core.graphics.drawable.a.a(mutate, this.f19770l.j());
        this.f19744aj.setImageDrawable(mutate);
    }

    private void b(boolean z2, boolean z3) {
        int defaultColor = this.aB.getDefaultColor();
        int colorForState = this.aB.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.aB.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z2) {
            this.P = colorForState2;
        } else if (z3) {
            this.P = colorForState;
        } else {
            this.P = defaultColor;
        }
    }

    private void c(int i2) {
        Iterator it2 = this.f19745ak.iterator();
        while (it2.hasNext()) {
            ((c) it2.next()).a(this, i2);
        }
    }

    private void c(Rect rect) {
        if (this.G != null) {
            this.G.setBounds(rect.left, rect.bottom - this.O, rect.right, rect.bottom);
        }
    }

    private void c(boolean z2) {
        ValueAnimator valueAnimator = this.aK;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.aK.cancel();
        }
        if (!z2 || !this.aJ) {
            this.f19762c.c(1.0f);
        } else {
            a(1.0f);
        }
        this.aH = false;
        if (S()) {
            T();
        }
        s();
        x();
        z();
    }

    private void d(boolean z2) {
        ValueAnimator valueAnimator = this.aK;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.aK.cancel();
        }
        if (!z2 || !this.aJ) {
            this.f19762c.c(0.0f);
        } else {
            a(0.0f);
        }
        if (S() && ((c) this.F).a()) {
            V();
        }
        this.aH = true;
        u();
        x();
        z();
    }

    private e getEndIconDelegate() {
        e eVar = this.f19743ai.get(this.f19742ah);
        return eVar != null ? eVar : this.f19743ai.get(0);
    }

    private CheckableImageButton getEndIconToUpdateDummyDrawable() {
        if (this.f19755au.getVisibility() == 0) {
            return this.f19755au;
        }
        if (!N() || !g()) {
            return null;
        }
        return this.f19744aj;
    }

    private void k() {
        l();
        m();
        i();
        o();
        p();
        if (this.K != 0) {
            q();
        }
    }

    private void l() {
        int i2 = this.K;
        if (i2 == 0) {
            this.F = null;
        } else if (i2 == 1) {
            this.F = new h(this.H);
            this.G = new h();
            return;
        } else if (i2 == 2) {
            this.F = (!this.C || (this.F instanceof c)) ? new h(this.H) : new c(this.H);
        } else {
            throw new IllegalArgumentException(this.K + " is illegal; only @BoxBackgroundMode constants are supported.");
        }
        this.G = null;
    }

    private void m() {
        if (n()) {
            ac.a((View) this.f19734a, (Drawable) this.F);
        }
    }

    private boolean n() {
        EditText editText = this.f19734a;
        return (editText == null || this.F == null || editText.getBackground() != null || this.K == 0) ? false : true;
    }

    private void o() {
        Resources resources;
        int i2;
        if (this.K == 1) {
            if (gt.c.b(getContext())) {
                resources = getResources();
                i2 = R.dimen.material_font_2_0_box_collapsed_padding_top;
            } else if (gt.c.a(getContext())) {
                resources = getResources();
                i2 = R.dimen.material_font_1_3_box_collapsed_padding_top;
            } else {
                return;
            }
            this.L = resources.getDimensionPixelSize(i2);
        }
    }

    private void p() {
        EditText editText;
        int l2;
        int dimensionPixelSize;
        int m2;
        Resources resources;
        int i2;
        if (this.f19734a != null && this.K == 1) {
            if (gt.c.b(getContext())) {
                editText = this.f19734a;
                l2 = ac.l(editText);
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_2_0_padding_top);
                m2 = ac.m(this.f19734a);
                resources = getResources();
                i2 = R.dimen.material_filled_edittext_font_2_0_padding_bottom;
            } else if (gt.c.a(getContext())) {
                editText = this.f19734a;
                l2 = ac.l(editText);
                dimensionPixelSize = getResources().getDimensionPixelSize(R.dimen.material_filled_edittext_font_1_3_padding_top);
                m2 = ac.m(this.f19734a);
                resources = getResources();
                i2 = R.dimen.material_filled_edittext_font_1_3_padding_bottom;
            } else {
                return;
            }
            ac.b(editText, l2, dimensionPixelSize, m2, resources.getDimensionPixelSize(i2));
        }
    }

    private void q() {
        if (this.K != 1) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f19763e.getLayoutParams();
            int C2 = C();
            if (C2 != layoutParams.topMargin) {
                layoutParams.topMargin = C2;
                this.f19763e.requestLayout();
            }
        }
    }

    private void r() {
        if (this.f19773o != null) {
            EditText editText = this.f19734a;
            a(editText == null ? 0 : editText.getText().length());
        }
    }

    private void s() {
        EditText editText = this.f19734a;
        b(editText == null ? 0 : editText.getText().length());
    }

    private void setEditText(EditText editText) {
        if (this.f19734a == null) {
            if (this.f19742ah != 3 && !(editText instanceof TextInputEditText)) {
                Log.i("TextInputLayout", "EditText added is not a TextInputEditText. Please switch to using that class instead.");
            }
            this.f19734a = editText;
            setMinWidth(this.f19768j);
            setMaxWidth(this.f19769k);
            k();
            setTextInputAccessibilityDelegate(new a(this));
            this.f19762c.c(this.f19734a.getTypeface());
            this.f19762c.a(this.f19734a.getTextSize());
            int gravity = this.f19734a.getGravity();
            this.f19762c.c((gravity & -113) | 48);
            this.f19762c.b(gravity);
            this.f19734a.addTextChangedListener(new TextWatcher() {
                public void afterTextChanged(Editable editable) {
                    TextInputLayout textInputLayout = TextInputLayout.this;
                    textInputLayout.a(!textInputLayout.aM);
                    if (TextInputLayout.this.f19761b) {
                        TextInputLayout.this.a(editable.length());
                    }
                    if (TextInputLayout.this.f19777s) {
                        TextInputLayout.this.b(editable.length());
                    }
                }

                public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }

                public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
                }
            });
            if (this.f19757aw == null) {
                this.f19757aw = this.f19734a.getHintTextColors();
            }
            if (this.C) {
                if (TextUtils.isEmpty(this.D)) {
                    CharSequence hint = this.f19734a.getHint();
                    this.f19767i = hint;
                    setHint(hint);
                    this.f19734a.setHint((CharSequence) null);
                }
                this.E = true;
            }
            if (this.f19773o != null) {
                a(this.f19734a.getText().length());
            }
            c();
            this.f19770l.d();
            this.f19764f.bringToFront();
            this.f19765g.bringToFront();
            this.f19766h.bringToFront();
            this.f19755au.bringToFront();
            L();
            y();
            A();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            a(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    private void setErrorIconVisible(boolean z2) {
        int i2 = 0;
        this.f19755au.setVisibility(z2 ? 0 : 8);
        FrameLayout frameLayout = this.f19766h;
        if (z2) {
            i2 = 8;
        }
        frameLayout.setVisibility(i2);
        A();
        if (!N()) {
            P();
        }
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.D)) {
            this.D = charSequence;
            this.f19762c.a(charSequence);
            if (!this.aH) {
                T();
            }
        }
    }

    private void setPlaceholderTextEnabled(boolean z2) {
        if (this.f19777s != z2) {
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f19778t = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_placeholder);
                ac.d((View) this.f19778t, 1);
                setPlaceholderTextAppearance(this.f19780v);
                setPlaceholderTextColor(this.f19779u);
                v();
            } else {
                w();
                this.f19778t = null;
            }
            this.f19777s = z2;
        }
    }

    private void t() {
        TextView textView = this.f19778t;
        if (textView != null && this.f19777s) {
            textView.setText(this.f19776r);
            this.f19778t.setVisibility(0);
            this.f19778t.bringToFront();
        }
    }

    private void u() {
        TextView textView = this.f19778t;
        if (textView != null && this.f19777s) {
            textView.setText((CharSequence) null);
            this.f19778t.setVisibility(4);
        }
    }

    private void v() {
        TextView textView = this.f19778t;
        if (textView != null) {
            this.f19763e.addView(textView);
            this.f19778t.setVisibility(0);
        }
    }

    private void w() {
        TextView textView = this.f19778t;
        if (textView != null) {
            textView.setVisibility(8);
        }
    }

    private void x() {
        this.f19784z.setVisibility((this.f19783y == null || j()) ? 8 : 0);
        P();
    }

    private void y() {
        if (this.f19734a != null) {
            ac.b(this.f19784z, d() ? 0 : ac.l(this.f19734a), this.f19734a.getCompoundPaddingTop(), getContext().getResources().getDimensionPixelSize(R.dimen.material_input_text_to_prefix_suffix_padding), this.f19734a.getCompoundPaddingBottom());
        }
    }

    private void z() {
        int visibility = this.B.getVisibility();
        int i2 = 0;
        boolean z2 = this.A != null && !j();
        TextView textView = this.B;
        if (!z2) {
            i2 = 8;
        }
        textView.setVisibility(i2);
        if (visibility != this.B.getVisibility()) {
            getEndIconDelegate().a(z2);
        }
        P();
    }

    /* access modifiers changed from: package-private */
    public void a(float f2) {
        if (this.f19762c.l() != f2) {
            if (this.aK == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.aK = valueAnimator;
                valueAnimator.setInterpolator(gl.a.f28536b);
                this.aK.setDuration(167);
                this.aK.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        TextInputLayout.this.f19762c.c(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            this.aK.setFloatValues(new float[]{this.f19762c.l(), f2});
            this.aK.start();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2) {
        boolean z2 = this.f19772n;
        int i3 = this.f19771m;
        if (i3 == -1) {
            this.f19773o.setText(String.valueOf(i2));
            this.f19773o.setContentDescription((CharSequence) null);
            this.f19772n = false;
        } else {
            this.f19772n = i2 > i3;
            a(getContext(), this.f19773o, i2, this.f19771m, this.f19772n);
            if (z2 != this.f19772n) {
                B();
            }
            this.f19773o.setText(r.a.a().a(getContext().getString(R.string.character_counter_pattern, new Object[]{Integer.valueOf(i2), Integer.valueOf(this.f19771m)})));
        }
        if (this.f19734a != null && z2 != this.f19772n) {
            a(false);
            i();
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(TextView textView, int i2) {
        boolean z2 = true;
        try {
            j.a(textView, i2);
            if (Build.VERSION.SDK_INT < 23 || textView.getTextColors().getDefaultColor() != -65281) {
                z2 = false;
            }
        } catch (Exception unused) {
        }
        if (z2) {
            j.a(textView, R.style.TextAppearance_AppCompat_Caption);
            textView.setTextColor(androidx.core.content.b.c(getContext(), R.color.design_error));
        }
    }

    public void a(b bVar) {
        this.f19741ag.add(bVar);
        if (this.f19734a != null) {
            bVar.a(this);
        }
    }

    public void a(c cVar) {
        this.f19745ak.add(cVar);
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        a(z2, false);
    }

    public boolean a() {
        return this.E;
    }

    public void addView(View view, int i2, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & -113) | 16;
            this.f19763e.addView(view, layoutParams2);
            this.f19763e.setLayoutParams(layoutParams);
            q();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i2, layoutParams);
    }

    public boolean b() {
        return this.f19770l.f();
    }

    /* access modifiers changed from: package-private */
    public void c() {
        Drawable background;
        TextView textView;
        int currentTextColor;
        EditText editText = this.f19734a;
        if (editText != null && this.K == 0 && (background = editText.getBackground()) != null) {
            if (q.c(background)) {
                background = background.mutate();
            }
            if (this.f19770l.g()) {
                currentTextColor = this.f19770l.j();
            } else if (!this.f19772n || (textView = this.f19773o) == null) {
                androidx.core.graphics.drawable.a.f(background);
                this.f19734a.refreshDrawableState();
                return;
            } else {
                currentTextColor = textView.getCurrentTextColor();
            }
            background.setColorFilter(f.a(currentTextColor, PorterDuff.Mode.SRC_IN));
        }
    }

    public boolean d() {
        return this.V.getVisibility() == 0;
    }

    public void dispatchProvideAutofillStructure(ViewStructure viewStructure, int i2) {
        EditText editText = this.f19734a;
        if (editText == null) {
            super.dispatchProvideAutofillStructure(viewStructure, i2);
            return;
        }
        if (this.f19767i != null) {
            boolean z2 = this.E;
            this.E = false;
            CharSequence hint = editText.getHint();
            this.f19734a.setHint(this.f19767i);
            try {
                super.dispatchProvideAutofillStructure(viewStructure, i2);
            } finally {
                this.f19734a.setHint(hint);
                this.E = z2;
            }
        } else {
            viewStructure.setAutofillId(getAutofillId());
            onProvideAutofillStructure(viewStructure, i2);
            onProvideAutofillVirtualStructure(viewStructure, i2);
            viewStructure.setChildCount(this.f19763e.getChildCount());
            for (int i3 = 0; i3 < this.f19763e.getChildCount(); i3++) {
                View childAt = this.f19763e.getChildAt(i3);
                ViewStructure newChild = viewStructure.newChild(i3);
                childAt.dispatchProvideAutofillStructure(newChild, i2);
                if (childAt == this.f19734a) {
                    newChild.setHint(getHint());
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.aM = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.aM = false;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        a(canvas);
        b(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (!this.aL) {
            boolean z2 = true;
            this.aL = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            com.google.android.material.internal.a aVar = this.f19762c;
            boolean a2 = aVar != null ? aVar.a(drawableState) | false : false;
            if (this.f19734a != null) {
                if (!ac.G(this) || !isEnabled()) {
                    z2 = false;
                }
                a(z2);
            }
            c();
            i();
            if (a2) {
                invalidate();
            }
            this.aL = false;
        }
    }

    public void e() {
        a(this.V, this.W);
    }

    public void f() {
        a(this.f19755au, this.f19756av);
    }

    public boolean g() {
        return this.f19766h.getVisibility() == 0 && this.f19744aj.getVisibility() == 0;
    }

    public int getBaseline() {
        EditText editText = this.f19734a;
        return editText != null ? editText.getBaseline() + getPaddingTop() + C() : super.getBaseline();
    }

    /* access modifiers changed from: package-private */
    public h getBoxBackground() {
        int i2 = this.K;
        if (i2 == 1 || i2 == 2) {
            return this.F;
        }
        throw new IllegalStateException();
    }

    public int getBoxBackgroundColor() {
        return this.Q;
    }

    public int getBoxBackgroundMode() {
        return this.K;
    }

    public float getBoxCornerRadiusBottomEnd() {
        return this.F.ae();
    }

    public float getBoxCornerRadiusBottomStart() {
        return this.F.af();
    }

    public float getBoxCornerRadiusTopEnd() {
        return this.F.ad();
    }

    public float getBoxCornerRadiusTopStart() {
        return this.F.ac();
    }

    public int getBoxStrokeColor() {
        return this.aA;
    }

    public ColorStateList getBoxStrokeErrorColor() {
        return this.aB;
    }

    public int getBoxStrokeWidth() {
        return this.N;
    }

    public int getBoxStrokeWidthFocused() {
        return this.O;
    }

    public int getCounterMaxLength() {
        return this.f19771m;
    }

    /* access modifiers changed from: package-private */
    public CharSequence getCounterOverflowDescription() {
        TextView textView;
        if (!this.f19761b || !this.f19772n || (textView = this.f19773o) == null) {
            return null;
        }
        return textView.getContentDescription();
    }

    public ColorStateList getCounterOverflowTextColor() {
        return this.f19781w;
    }

    public ColorStateList getCounterTextColor() {
        return this.f19781w;
    }

    public ColorStateList getDefaultHintTextColor() {
        return this.f19757aw;
    }

    public EditText getEditText() {
        return this.f19734a;
    }

    public CharSequence getEndIconContentDescription() {
        return this.f19744aj.getContentDescription();
    }

    public Drawable getEndIconDrawable() {
        return this.f19744aj.getDrawable();
    }

    public int getEndIconMode() {
        return this.f19742ah;
    }

    /* access modifiers changed from: package-private */
    public CheckableImageButton getEndIconView() {
        return this.f19744aj;
    }

    public CharSequence getError() {
        if (this.f19770l.e()) {
            return this.f19770l.h();
        }
        return null;
    }

    public CharSequence getErrorContentDescription() {
        return this.f19770l.l();
    }

    public int getErrorCurrentTextColors() {
        return this.f19770l.j();
    }

    public Drawable getErrorIconDrawable() {
        return this.f19755au.getDrawable();
    }

    /* access modifiers changed from: package-private */
    public final int getErrorTextCurrentColor() {
        return this.f19770l.j();
    }

    public CharSequence getHelperText() {
        if (this.f19770l.f()) {
            return this.f19770l.i();
        }
        return null;
    }

    public int getHelperTextCurrentTextColor() {
        return this.f19770l.m();
    }

    public CharSequence getHint() {
        if (this.C) {
            return this.D;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public final float getHintCollapsedTextHeight() {
        return this.f19762c.d();
    }

    /* access modifiers changed from: package-private */
    public final int getHintCurrentCollapsedTextColor() {
        return this.f19762c.m();
    }

    public ColorStateList getHintTextColor() {
        return this.f19758ax;
    }

    public int getMaxWidth() {
        return this.f19769k;
    }

    public int getMinWidth() {
        return this.f19768j;
    }

    @Deprecated
    public CharSequence getPasswordVisibilityToggleContentDescription() {
        return this.f19744aj.getContentDescription();
    }

    @Deprecated
    public Drawable getPasswordVisibilityToggleDrawable() {
        return this.f19744aj.getDrawable();
    }

    public CharSequence getPlaceholderText() {
        if (this.f19777s) {
            return this.f19776r;
        }
        return null;
    }

    public int getPlaceholderTextAppearance() {
        return this.f19780v;
    }

    public ColorStateList getPlaceholderTextColor() {
        return this.f19779u;
    }

    public CharSequence getPrefixText() {
        return this.f19783y;
    }

    public ColorStateList getPrefixTextColor() {
        return this.f19784z.getTextColors();
    }

    public TextView getPrefixTextView() {
        return this.f19784z;
    }

    public CharSequence getStartIconContentDescription() {
        return this.V.getContentDescription();
    }

    public Drawable getStartIconDrawable() {
        return this.V.getDrawable();
    }

    public CharSequence getSuffixText() {
        return this.A;
    }

    public ColorStateList getSuffixTextColor() {
        return this.B.getTextColors();
    }

    public TextView getSuffixTextView() {
        return this.B;
    }

    public Typeface getTypeface() {
        return this.U;
    }

    public void h() {
        a(this.f19744aj, this.f19746al);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0012, code lost:
        r0 = r6.f19734a;
     */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x00a2  */
    /* JADX WARNING: Removed duplicated region for block: B:55:0x00b3  */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x00b6  */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00bf  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00c6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void i() {
        /*
            r6 = this;
            gw.h r0 = r6.F
            if (r0 == 0) goto L_0x00e3
            int r0 = r6.K
            if (r0 != 0) goto L_0x000a
            goto L_0x00e3
        L_0x000a:
            boolean r0 = r6.isFocused()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x001f
            android.widget.EditText r0 = r6.f19734a
            if (r0 == 0) goto L_0x001d
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L_0x001d
            goto L_0x001f
        L_0x001d:
            r0 = 0
            goto L_0x0020
        L_0x001f:
            r0 = 1
        L_0x0020:
            boolean r3 = r6.isHovered()
            if (r3 != 0) goto L_0x0033
            android.widget.EditText r3 = r6.f19734a
            if (r3 == 0) goto L_0x0031
            boolean r3 = r3.isHovered()
            if (r3 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r3 = 0
            goto L_0x0034
        L_0x0033:
            r3 = 1
        L_0x0034:
            boolean r4 = r6.isEnabled()
            if (r4 != 0) goto L_0x003f
            int r4 = r6.aG
        L_0x003c:
            r6.P = r4
            goto L_0x0075
        L_0x003f:
            com.google.android.material.textfield.f r4 = r6.f19770l
            boolean r4 = r4.g()
            if (r4 == 0) goto L_0x0056
            android.content.res.ColorStateList r4 = r6.aB
            if (r4 == 0) goto L_0x004f
        L_0x004b:
            r6.b((boolean) r0, (boolean) r3)
            goto L_0x0075
        L_0x004f:
            com.google.android.material.textfield.f r4 = r6.f19770l
            int r4 = r4.j()
            goto L_0x003c
        L_0x0056:
            boolean r4 = r6.f19772n
            if (r4 == 0) goto L_0x0068
            android.widget.TextView r4 = r6.f19773o
            if (r4 == 0) goto L_0x0068
            android.content.res.ColorStateList r5 = r6.aB
            if (r5 == 0) goto L_0x0063
            goto L_0x004b
        L_0x0063:
            int r4 = r4.getCurrentTextColor()
            goto L_0x003c
        L_0x0068:
            if (r0 == 0) goto L_0x006d
            int r4 = r6.aA
            goto L_0x003c
        L_0x006d:
            if (r3 == 0) goto L_0x0072
            int r4 = r6.f19760az
            goto L_0x003c
        L_0x0072:
            int r4 = r6.f19759ay
            goto L_0x003c
        L_0x0075:
            android.graphics.drawable.Drawable r4 = r6.getErrorIconDrawable()
            if (r4 == 0) goto L_0x008c
            com.google.android.material.textfield.f r4 = r6.f19770l
            boolean r4 = r4.e()
            if (r4 == 0) goto L_0x008c
            com.google.android.material.textfield.f r4 = r6.f19770l
            boolean r4 = r4.g()
            if (r4 == 0) goto L_0x008c
            r1 = 1
        L_0x008c:
            r6.setErrorIconVisible(r1)
            r6.f()
            r6.e()
            r6.h()
            com.google.android.material.textfield.e r1 = r6.getEndIconDelegate()
            boolean r1 = r1.b()
            if (r1 == 0) goto L_0x00ab
            com.google.android.material.textfield.f r1 = r6.f19770l
            boolean r1 = r1.g()
            r6.b((boolean) r1)
        L_0x00ab:
            if (r0 == 0) goto L_0x00b6
            boolean r1 = r6.isEnabled()
            if (r1 == 0) goto L_0x00b6
            int r1 = r6.O
            goto L_0x00b8
        L_0x00b6:
            int r1 = r6.N
        L_0x00b8:
            r6.M = r1
            int r1 = r6.K
            r4 = 2
            if (r1 != r4) goto L_0x00c2
            r6.U()
        L_0x00c2:
            int r1 = r6.K
            if (r1 != r2) goto L_0x00e0
            boolean r1 = r6.isEnabled()
            if (r1 != 0) goto L_0x00d1
            int r0 = r6.aD
        L_0x00ce:
            r6.Q = r0
            goto L_0x00e0
        L_0x00d1:
            if (r3 == 0) goto L_0x00d8
            if (r0 != 0) goto L_0x00d8
            int r0 = r6.aF
            goto L_0x00ce
        L_0x00d8:
            if (r0 == 0) goto L_0x00dd
            int r0 = r6.aE
            goto L_0x00ce
        L_0x00dd:
            int r0 = r6.aC
            goto L_0x00ce
        L_0x00e0:
            r6.F()
        L_0x00e3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.textfield.TextInputLayout.i():void");
    }

    /* access modifiers changed from: package-private */
    public final boolean j() {
        return this.aH;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        EditText editText = this.f19734a;
        if (editText != null) {
            Rect rect = this.R;
            com.google.android.material.internal.c.b(this, editText, rect);
            c(rect);
            if (this.C) {
                this.f19762c.a(this.f19734a.getTextSize());
                int gravity = this.f19734a.getGravity();
                this.f19762c.c((gravity & -113) | 48);
                this.f19762c.b(gravity);
                this.f19762c.b(a(rect));
                this.f19762c.a(b(rect));
                this.f19762c.n();
                if (S() && !this.aH) {
                    T();
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        super.onMeasure(i2, i3);
        boolean J2 = J();
        boolean P2 = P();
        if (J2 || P2) {
            this.f19734a.post(new Runnable() {
                public void run() {
                    TextInputLayout.this.f19734a.requestLayout();
                }
            });
        }
        K();
        y();
        A();
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.a());
        setError(savedState.f19789a);
        if (savedState.f19790b) {
            this.f19744aj.post(new Runnable() {
                public void run() {
                    TextInputLayout.this.f19744aj.performClick();
                    TextInputLayout.this.f19744aj.jumpDrawablesToCurrentState();
                }
            });
        }
        setHint(savedState.f19791d);
        setHelperText(savedState.f19792e);
        setPlaceholderText(savedState.f19793f);
        requestLayout();
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f19770l.g()) {
            savedState.f19789a = getError();
        }
        savedState.f19790b = N() && this.f19744aj.isChecked();
        savedState.f19791d = getHint();
        savedState.f19792e = getHelperText();
        savedState.f19793f = getPlaceholderText();
        return savedState;
    }

    public void setBoxBackgroundColor(int i2) {
        if (this.Q != i2) {
            this.Q = i2;
            this.aC = i2;
            this.aE = i2;
            this.aF = i2;
            F();
        }
    }

    public void setBoxBackgroundColorResource(int i2) {
        setBoxBackgroundColor(androidx.core.content.b.c(getContext(), i2));
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.aC = defaultColor;
        this.Q = defaultColor;
        this.aD = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.aE = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.aF = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        F();
    }

    public void setBoxBackgroundMode(int i2) {
        if (i2 != this.K) {
            this.K = i2;
            if (this.f19734a != null) {
                k();
            }
        }
    }

    public void setBoxStrokeColor(int i2) {
        if (this.aA != i2) {
            this.aA = i2;
            i();
        }
    }

    public void setBoxStrokeColorStateList(ColorStateList colorStateList) {
        int defaultColor;
        if (colorStateList.isStateful()) {
            this.f19759ay = colorStateList.getDefaultColor();
            this.aG = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f19760az = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
            defaultColor = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        } else {
            if (this.aA != colorStateList.getDefaultColor()) {
                defaultColor = colorStateList.getDefaultColor();
            }
            i();
        }
        this.aA = defaultColor;
        i();
    }

    public void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.aB != colorStateList) {
            this.aB = colorStateList;
            i();
        }
    }

    public void setBoxStrokeWidth(int i2) {
        this.N = i2;
        i();
    }

    public void setBoxStrokeWidthFocused(int i2) {
        this.O = i2;
        i();
    }

    public void setBoxStrokeWidthFocusedResource(int i2) {
        setBoxStrokeWidthFocused(getResources().getDimensionPixelSize(i2));
    }

    public void setBoxStrokeWidthResource(int i2) {
        setBoxStrokeWidth(getResources().getDimensionPixelSize(i2));
    }

    public void setCounterEnabled(boolean z2) {
        if (this.f19761b != z2) {
            if (z2) {
                AppCompatTextView appCompatTextView = new AppCompatTextView(getContext());
                this.f19773o = appCompatTextView;
                appCompatTextView.setId(R.id.textinput_counter);
                Typeface typeface = this.U;
                if (typeface != null) {
                    this.f19773o.setTypeface(typeface);
                }
                this.f19773o.setMaxLines(1);
                this.f19770l.a(this.f19773o, 2);
                t.j.a((ViewGroup.MarginLayoutParams) this.f19773o.getLayoutParams(), getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_counter_margin_start));
                B();
                r();
            } else {
                this.f19770l.b(this.f19773o, 2);
                this.f19773o = null;
            }
            this.f19761b = z2;
        }
    }

    public void setCounterMaxLength(int i2) {
        if (this.f19771m != i2) {
            if (i2 <= 0) {
                i2 = -1;
            }
            this.f19771m = i2;
            if (this.f19761b) {
                r();
            }
        }
    }

    public void setCounterOverflowTextAppearance(int i2) {
        if (this.f19774p != i2) {
            this.f19774p = i2;
            B();
        }
    }

    public void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.f19782x != colorStateList) {
            this.f19782x = colorStateList;
            B();
        }
    }

    public void setCounterTextAppearance(int i2) {
        if (this.f19775q != i2) {
            this.f19775q = i2;
            B();
        }
    }

    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.f19781w != colorStateList) {
            this.f19781w = colorStateList;
            B();
        }
    }

    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f19757aw = colorStateList;
        this.f19758ax = colorStateList;
        if (this.f19734a != null) {
            a(false);
        }
    }

    public void setEnabled(boolean z2) {
        a((ViewGroup) this, z2);
        super.setEnabled(z2);
    }

    public void setEndIconActivated(boolean z2) {
        this.f19744aj.setActivated(z2);
    }

    public void setEndIconCheckable(boolean z2) {
        this.f19744aj.setCheckable(z2);
    }

    public void setEndIconContentDescription(int i2) {
        setEndIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setEndIconContentDescription(CharSequence charSequence) {
        if (getEndIconContentDescription() != charSequence) {
            this.f19744aj.setContentDescription(charSequence);
        }
    }

    public void setEndIconDrawable(int i2) {
        setEndIconDrawable(i2 != 0 ? c.a.b(getContext(), i2) : null);
    }

    public void setEndIconDrawable(Drawable drawable) {
        this.f19744aj.setImageDrawable(drawable);
        h();
    }

    public void setEndIconMode(int i2) {
        int i3 = this.f19742ah;
        this.f19742ah = i2;
        c(i3);
        setEndIconVisible(i2 != 0);
        if (getEndIconDelegate().a(this.K)) {
            getEndIconDelegate().a();
            O();
            return;
        }
        throw new IllegalStateException("The current box background mode " + this.K + " is not supported by the end icon mode " + i2);
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        a(this.f19744aj, onClickListener, this.f19753as);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f19753as = onLongClickListener;
        a(this.f19744aj, onLongClickListener);
    }

    public void setEndIconTintList(ColorStateList colorStateList) {
        if (this.f19746al != colorStateList) {
            this.f19746al = colorStateList;
            this.f19747am = true;
            O();
        }
    }

    public void setEndIconTintMode(PorterDuff.Mode mode) {
        if (this.f19748an != mode) {
            this.f19748an = mode;
            this.f19749ao = true;
            O();
        }
    }

    public void setEndIconVisible(boolean z2) {
        if (g() != z2) {
            this.f19744aj.setVisibility(z2 ? 0 : 8);
            A();
            P();
        }
    }

    public void setError(CharSequence charSequence) {
        if (!this.f19770l.e()) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f19770l.b(charSequence);
        } else {
            this.f19770l.b();
        }
    }

    public void setErrorContentDescription(CharSequence charSequence) {
        this.f19770l.c(charSequence);
    }

    public void setErrorEnabled(boolean z2) {
        this.f19770l.a(z2);
    }

    public void setErrorIconDrawable(int i2) {
        setErrorIconDrawable(i2 != 0 ? c.a.b(getContext(), i2) : null);
        f();
    }

    public void setErrorIconDrawable(Drawable drawable) {
        this.f19755au.setImageDrawable(drawable);
        setErrorIconVisible(drawable != null && this.f19770l.e());
    }

    public void setErrorIconOnClickListener(View.OnClickListener onClickListener) {
        a(this.f19755au, onClickListener, this.f19754at);
    }

    public void setErrorIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f19754at = onLongClickListener;
        a(this.f19755au, onLongClickListener);
    }

    public void setErrorIconTintList(ColorStateList colorStateList) {
        this.f19756av = colorStateList;
        Drawable drawable = this.f19755au.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.a.g(drawable).mutate();
            androidx.core.graphics.drawable.a.a(drawable, colorStateList);
        }
        if (this.f19755au.getDrawable() != drawable) {
            this.f19755au.setImageDrawable(drawable);
        }
    }

    public void setErrorIconTintMode(PorterDuff.Mode mode) {
        Drawable drawable = this.f19755au.getDrawable();
        if (drawable != null) {
            drawable = androidx.core.graphics.drawable.a.g(drawable).mutate();
            androidx.core.graphics.drawable.a.a(drawable, mode);
        }
        if (this.f19755au.getDrawable() != drawable) {
            this.f19755au.setImageDrawable(drawable);
        }
    }

    public void setErrorTextAppearance(int i2) {
        this.f19770l.b(i2);
    }

    public void setErrorTextColor(ColorStateList colorStateList) {
        this.f19770l.a(colorStateList);
    }

    public void setExpandedHintEnabled(boolean z2) {
        if (this.aI != z2) {
            this.aI = z2;
            a(false);
        }
    }

    public void setHelperText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!b()) {
                setHelperTextEnabled(true);
            }
            this.f19770l.a(charSequence);
        } else if (b()) {
            setHelperTextEnabled(false);
        }
    }

    public void setHelperTextColor(ColorStateList colorStateList) {
        this.f19770l.b(colorStateList);
    }

    public void setHelperTextEnabled(boolean z2) {
        this.f19770l.b(z2);
    }

    public void setHelperTextTextAppearance(int i2) {
        this.f19770l.c(i2);
    }

    public void setHint(int i2) {
        setHint(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setHint(CharSequence charSequence) {
        if (this.C) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHintAnimationEnabled(boolean z2) {
        this.aJ = z2;
    }

    public void setHintEnabled(boolean z2) {
        if (z2 != this.C) {
            this.C = z2;
            if (!z2) {
                this.E = false;
                if (!TextUtils.isEmpty(this.D) && TextUtils.isEmpty(this.f19734a.getHint())) {
                    this.f19734a.setHint(this.D);
                }
                setHintInternal((CharSequence) null);
            } else {
                CharSequence hint = this.f19734a.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.D)) {
                        setHint(hint);
                    }
                    this.f19734a.setHint((CharSequence) null);
                }
                this.E = true;
            }
            if (this.f19734a != null) {
                q();
            }
        }
    }

    public void setHintTextAppearance(int i2) {
        this.f19762c.d(i2);
        this.f19758ax = this.f19762c.u();
        if (this.f19734a != null) {
            a(false);
            q();
        }
    }

    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f19758ax != colorStateList) {
            if (this.f19757aw == null) {
                this.f19762c.a(colorStateList);
            }
            this.f19758ax = colorStateList;
            if (this.f19734a != null) {
                a(false);
            }
        }
    }

    public void setMaxWidth(int i2) {
        this.f19769k = i2;
        EditText editText = this.f19734a;
        if (editText != null && i2 != -1) {
            editText.setMaxWidth(i2);
        }
    }

    public void setMaxWidthResource(int i2) {
        setMaxWidth(getContext().getResources().getDimensionPixelSize(i2));
    }

    public void setMinWidth(int i2) {
        this.f19768j = i2;
        EditText editText = this.f19734a;
        if (editText != null && i2 != -1) {
            editText.setMinWidth(i2);
        }
    }

    public void setMinWidthResource(int i2) {
        setMinWidth(getContext().getResources().getDimensionPixelSize(i2));
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(int i2) {
        setPasswordVisibilityToggleContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleContentDescription(CharSequence charSequence) {
        this.f19744aj.setContentDescription(charSequence);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(int i2) {
        setPasswordVisibilityToggleDrawable(i2 != 0 ? c.a.b(getContext(), i2) : null);
    }

    @Deprecated
    public void setPasswordVisibilityToggleDrawable(Drawable drawable) {
        this.f19744aj.setImageDrawable(drawable);
    }

    @Deprecated
    public void setPasswordVisibilityToggleEnabled(boolean z2) {
        if (z2 && this.f19742ah != 1) {
            setEndIconMode(1);
        } else if (!z2) {
            setEndIconMode(0);
        }
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintList(ColorStateList colorStateList) {
        this.f19746al = colorStateList;
        this.f19747am = true;
        O();
    }

    @Deprecated
    public void setPasswordVisibilityToggleTintMode(PorterDuff.Mode mode) {
        this.f19748an = mode;
        this.f19749ao = true;
        O();
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (!this.f19777s || !TextUtils.isEmpty(charSequence)) {
            if (!this.f19777s) {
                setPlaceholderTextEnabled(true);
            }
            this.f19776r = charSequence;
        } else {
            setPlaceholderTextEnabled(false);
        }
        s();
    }

    public void setPlaceholderTextAppearance(int i2) {
        this.f19780v = i2;
        TextView textView = this.f19778t;
        if (textView != null) {
            j.a(textView, i2);
        }
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f19779u != colorStateList) {
            this.f19779u = colorStateList;
            TextView textView = this.f19778t;
            if (textView != null && colorStateList != null) {
                textView.setTextColor(colorStateList);
            }
        }
    }

    public void setPrefixText(CharSequence charSequence) {
        this.f19783y = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f19784z.setText(charSequence);
        x();
    }

    public void setPrefixTextAppearance(int i2) {
        j.a(this.f19784z, i2);
    }

    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f19784z.setTextColor(colorStateList);
    }

    public void setStartIconCheckable(boolean z2) {
        this.V.setCheckable(z2);
    }

    public void setStartIconContentDescription(int i2) {
        setStartIconContentDescription(i2 != 0 ? getResources().getText(i2) : null);
    }

    public void setStartIconContentDescription(CharSequence charSequence) {
        if (getStartIconContentDescription() != charSequence) {
            this.V.setContentDescription(charSequence);
        }
    }

    public void setStartIconDrawable(int i2) {
        setStartIconDrawable(i2 != 0 ? c.a.b(getContext(), i2) : null);
    }

    public void setStartIconDrawable(Drawable drawable) {
        this.V.setImageDrawable(drawable);
        if (drawable != null) {
            setStartIconVisible(true);
            e();
            return;
        }
        setStartIconVisible(false);
        setStartIconOnClickListener((View.OnClickListener) null);
        setStartIconOnLongClickListener((View.OnLongClickListener) null);
        setStartIconContentDescription((CharSequence) null);
    }

    public void setStartIconOnClickListener(View.OnClickListener onClickListener) {
        a(this.V, onClickListener, this.f19740af);
    }

    public void setStartIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f19740af = onLongClickListener;
        a(this.V, onLongClickListener);
    }

    public void setStartIconTintList(ColorStateList colorStateList) {
        if (this.W != colorStateList) {
            this.W = colorStateList;
            this.f19735aa = true;
            M();
        }
    }

    public void setStartIconTintMode(PorterDuff.Mode mode) {
        if (this.f19736ab != mode) {
            this.f19736ab = mode;
            this.f19737ac = true;
            M();
        }
    }

    public void setStartIconVisible(boolean z2) {
        if (d() != z2) {
            this.V.setVisibility(z2 ? 0 : 8);
            y();
            P();
        }
    }

    public void setSuffixText(CharSequence charSequence) {
        this.A = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.B.setText(charSequence);
        z();
    }

    public void setSuffixTextAppearance(int i2) {
        j.a(this.B, i2);
    }

    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.B.setTextColor(colorStateList);
    }

    public void setTextInputAccessibilityDelegate(a aVar) {
        EditText editText = this.f19734a;
        if (editText != null) {
            ac.a((View) editText, (t.a) aVar);
        }
    }

    public void setTypeface(Typeface typeface) {
        if (typeface != this.U) {
            this.U = typeface;
            this.f19762c.c(typeface);
            this.f19770l.a(typeface);
            TextView textView = this.f19773o;
            if (textView != null) {
                textView.setTypeface(typeface);
            }
        }
    }
}
