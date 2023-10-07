package it.sephiroth.android.library.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.TransitionDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextMenu;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.Interpolator;
import android.view.animation.LinearInterpolator;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.widget.Checkable;
import android.widget.ListAdapter;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import it.sephiroth.android.library.R;
import it.sephiroth.android.library.widget.AdapterView;
import java.util.ArrayList;
import md.a;

public abstract class AbsHListView extends AdapterView<ListAdapter> implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnTouchModeChangeListener {
    static final Interpolator T = new LinearInterpolator();
    public static final int[] U = {0};
    protected int A;
    int B;
    int C;
    int D;
    int E;
    protected int F;
    int G;
    int H;
    protected i I;
    protected int J;
    protected boolean K;
    boolean L;
    protected int M;
    protected int N;
    protected Runnable O;
    protected final boolean[] P;
    int Q;
    int R;
    protected boolean S;

    /* renamed from: a  reason: collision with root package name */
    a.C0224a f29186a;
    private int aA;
    /* access modifiers changed from: private */
    public c aB;
    private Runnable aC;
    private b aD;
    private h aE;
    private Runnable aF;
    private int aG;
    private int aH;
    private boolean aI;
    private int aJ;
    private int aK;
    private Runnable aL;
    /* access modifiers changed from: private */
    public int aM;
    /* access modifiers changed from: private */
    public int aN;
    private float aO;
    /* access modifiers changed from: private */
    public int aP;
    /* access modifiers changed from: private */
    public a aQ;
    /* access modifiers changed from: private */
    public a aR;
    private int aS;
    private int aT;
    private int aU;
    private boolean aV;
    private int aW;
    private int aX;
    private f aY;
    private int aZ;
    /* access modifiers changed from: private */

    /* renamed from: au  reason: collision with root package name */
    public VelocityTracker f29187au;

    /* renamed from: av  reason: collision with root package name */
    private e f29188av;

    /* renamed from: aw  reason: collision with root package name */
    private g f29189aw;

    /* renamed from: ax  reason: collision with root package name */
    private boolean f29190ax;

    /* renamed from: ay  reason: collision with root package name */
    private Rect f29191ay;

    /* renamed from: az  reason: collision with root package name */
    private ContextMenu.ContextMenuInfo f29192az;

    /* renamed from: b  reason: collision with root package name */
    protected int f29193b;

    /* renamed from: ba  reason: collision with root package name */
    private int f29194ba;

    /* renamed from: bb  reason: collision with root package name */
    private int f29195bb;

    /* renamed from: bc  reason: collision with root package name */
    private SavedState f29196bc;

    /* renamed from: bd  reason: collision with root package name */
    private float f29197bd;

    /* renamed from: c  reason: collision with root package name */
    public Object f29198c;

    /* renamed from: d  reason: collision with root package name */
    Object f29199d;

    /* renamed from: e  reason: collision with root package name */
    int f29200e;

    /* renamed from: f  reason: collision with root package name */
    protected SparseBooleanArray f29201f;

    /* renamed from: g  reason: collision with root package name */
    j.d<Integer> f29202g;

    /* renamed from: h  reason: collision with root package name */
    protected int f29203h;

    /* renamed from: i  reason: collision with root package name */
    protected a f29204i;

    /* renamed from: j  reason: collision with root package name */
    protected ListAdapter f29205j;

    /* renamed from: k  reason: collision with root package name */
    boolean f29206k;

    /* renamed from: l  reason: collision with root package name */
    boolean f29207l;

    /* renamed from: m  reason: collision with root package name */
    Drawable f29208m;

    /* renamed from: n  reason: collision with root package name */
    int f29209n;

    /* renamed from: o  reason: collision with root package name */
    protected Rect f29210o;

    /* renamed from: p  reason: collision with root package name */
    protected final j f29211p;

    /* renamed from: q  reason: collision with root package name */
    int f29212q;

    /* renamed from: r  reason: collision with root package name */
    int f29213r;

    /* renamed from: s  reason: collision with root package name */
    int f29214s;

    /* renamed from: t  reason: collision with root package name */
    int f29215t;

    /* renamed from: u  reason: collision with root package name */
    protected Rect f29216u;

    /* renamed from: v  reason: collision with root package name */
    protected int f29217v;

    /* renamed from: w  reason: collision with root package name */
    View f29218w;

    /* renamed from: x  reason: collision with root package name */
    View f29219x;

    /* renamed from: y  reason: collision with root package name */
    protected boolean f29220y;

    /* renamed from: z  reason: collision with root package name */
    protected boolean f29221z;

    public static class LayoutParams extends ViewGroup.LayoutParams {

        /* renamed from: a  reason: collision with root package name */
        public int f29226a;

        /* renamed from: b  reason: collision with root package name */
        public boolean f29227b;

        /* renamed from: c  reason: collision with root package name */
        public boolean f29228c;

        /* renamed from: d  reason: collision with root package name */
        public int f29229d;

        /* renamed from: e  reason: collision with root package name */
        public long f29230e = -1;

        public LayoutParams(int i2, int i3, int i4) {
            super(i2, i3);
            this.f29226a = i4;
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
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
        long f29231a;

        /* renamed from: b  reason: collision with root package name */
        long f29232b;

        /* renamed from: c  reason: collision with root package name */
        int f29233c;

        /* renamed from: d  reason: collision with root package name */
        int f29234d;

        /* renamed from: e  reason: collision with root package name */
        int f29235e;

        /* renamed from: f  reason: collision with root package name */
        String f29236f;

        /* renamed from: g  reason: collision with root package name */
        boolean f29237g;

        /* renamed from: h  reason: collision with root package name */
        int f29238h;

        /* renamed from: i  reason: collision with root package name */
        SparseBooleanArray f29239i;

        /* renamed from: j  reason: collision with root package name */
        j.d<Integer> f29240j;

        private SavedState(Parcel parcel) {
            super(parcel);
            this.f29231a = parcel.readLong();
            this.f29232b = parcel.readLong();
            this.f29233c = parcel.readInt();
            this.f29234d = parcel.readInt();
            this.f29235e = parcel.readInt();
            this.f29236f = parcel.readString();
            this.f29237g = parcel.readByte() != 0;
            this.f29238h = parcel.readInt();
            this.f29239i = parcel.readSparseBooleanArray();
            int readInt = parcel.readInt();
            if (readInt > 0) {
                this.f29240j = new j.d<>();
                for (int i2 = 0; i2 < readInt; i2++) {
                    this.f29240j.b(parcel.readLong(), Integer.valueOf(parcel.readInt()));
                }
            }
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        public String toString() {
            return "AbsListView.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " selectedId=" + this.f29231a + " firstId=" + this.f29232b + " viewLeft=" + this.f29233c + " position=" + this.f29234d + " width=" + this.f29235e + " filter=" + this.f29236f + " checkState=" + this.f29239i + "}";
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeLong(this.f29231a);
            parcel.writeLong(this.f29232b);
            parcel.writeInt(this.f29233c);
            parcel.writeInt(this.f29234d);
            parcel.writeInt(this.f29235e);
            parcel.writeString(this.f29236f);
            parcel.writeByte(this.f29237g ? (byte) 1 : 0);
            parcel.writeInt(this.f29238h);
            parcel.writeSparseBooleanArray(this.f29239i);
            j.d<Integer> dVar = this.f29240j;
            int b2 = dVar != null ? dVar.b() : 0;
            parcel.writeInt(b2);
            for (int i3 = 0; i3 < b2; i3++) {
                parcel.writeLong(this.f29240j.b(i3));
                parcel.writeInt(this.f29240j.c(i3).intValue());
            }
        }
    }

    public class a extends AdapterView<ListAdapter>.b {
        public a() {
            super();
        }

        public void onChanged() {
            Log.i("AbsListView", "onChanged");
            super.onChanged();
        }

        public void onInvalidated() {
            Log.i("AbsListView", "onInvalidated");
            super.onInvalidated();
        }
    }

    private class b extends m implements Runnable {
        private b() {
            super();
        }

        public void run() {
            boolean z2;
            if (AbsHListView.this.isPressed() && AbsHListView.this.f29285am >= 0) {
                View childAt = AbsHListView.this.getChildAt(AbsHListView.this.f29285am - AbsHListView.this.V);
                if (!AbsHListView.this.f29282aj) {
                    if (b()) {
                        AbsHListView absHListView = AbsHListView.this;
                        z2 = absHListView.c(childAt, absHListView.f29285am, AbsHListView.this.f29286an);
                    } else {
                        z2 = false;
                    }
                    if (z2) {
                        AbsHListView.this.setPressed(false);
                    } else {
                        return;
                    }
                } else {
                    AbsHListView.this.setPressed(false);
                    if (childAt == null) {
                        return;
                    }
                }
                childAt.setPressed(false);
            }
        }
    }

    private class c extends m implements Runnable {
        private c() {
            super();
        }

        public void run() {
            int i2 = AbsHListView.this.A;
            AbsHListView absHListView = AbsHListView.this;
            View childAt = absHListView.getChildAt(i2 - absHListView.V);
            if (childAt != null) {
                if ((!b() || AbsHListView.this.f29282aj) ? false : AbsHListView.this.c(childAt, AbsHListView.this.A, AbsHListView.this.f29205j.getItemId(AbsHListView.this.A))) {
                    AbsHListView.this.F = -1;
                    AbsHListView.this.setPressed(false);
                    childAt.setPressed(false);
                    return;
                }
                AbsHListView.this.F = 2;
            }
        }
    }

    final class d implements Runnable {
        d() {
        }

        public void run() {
            Drawable current;
            if (AbsHListView.this.F == 0) {
                AbsHListView.this.F = 1;
                AbsHListView absHListView = AbsHListView.this;
                View childAt = absHListView.getChildAt(absHListView.A - AbsHListView.this.V);
                if (childAt != null && !childAt.hasFocusable()) {
                    AbsHListView.this.f29203h = 0;
                    if (!AbsHListView.this.f29282aj) {
                        childAt.setPressed(true);
                        AbsHListView.this.setPressed(true);
                        AbsHListView.this.e();
                        AbsHListView absHListView2 = AbsHListView.this;
                        absHListView2.a(absHListView2.A, childAt);
                        AbsHListView.this.refreshDrawableState();
                        int longPressTimeout = ViewConfiguration.getLongPressTimeout();
                        boolean isLongClickable = AbsHListView.this.isLongClickable();
                        if (!(AbsHListView.this.f29208m == null || (current = AbsHListView.this.f29208m.getCurrent()) == null || !(current instanceof TransitionDrawable))) {
                            TransitionDrawable transitionDrawable = (TransitionDrawable) current;
                            if (isLongClickable) {
                                transitionDrawable.startTransition(longPressTimeout);
                            } else {
                                transitionDrawable.resetTransition();
                            }
                        }
                        if (isLongClickable) {
                            if (AbsHListView.this.aB == null) {
                                AbsHListView absHListView3 = AbsHListView.this;
                                c unused = absHListView3.aB = new c();
                            }
                            AbsHListView.this.aB.a();
                            AbsHListView absHListView4 = AbsHListView.this;
                            absHListView4.postDelayed(absHListView4.aB, (long) longPressTimeout);
                            return;
                        }
                    }
                    AbsHListView.this.F = 2;
                }
            }
        }
    }

    private class e implements Runnable {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public final c f29246b;

        /* renamed from: c  reason: collision with root package name */
        private int f29247c;

        /* renamed from: d  reason: collision with root package name */
        private final Runnable f29248d = new Runnable() {
            public void run() {
                int d2 = AbsHListView.this.aP;
                VelocityTracker e2 = AbsHListView.this.f29187au;
                c a2 = e.this.f29246b;
                if (e2 != null && d2 != -1) {
                    e2.computeCurrentVelocity(1000, (float) AbsHListView.this.aN);
                    float f2 = -e2.getXVelocity(d2);
                    if (Math.abs(f2) < ((float) AbsHListView.this.aM) || !a2.a(f2, 0.0f)) {
                        e.this.b();
                        AbsHListView.this.F = 3;
                        AbsHListView.this.b(1);
                        return;
                    }
                    AbsHListView.this.postDelayed(this, 40);
                }
            }
        };

        e() {
            this.f29246b = new c(AbsHListView.this.getContext());
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.f29246b.a(AbsHListView.this.getScrollX(), 0, 0, 0, 0, 0)) {
                AbsHListView.this.F = 6;
                AbsHListView.this.invalidate();
                AbsHListView.this.f29186a.a((Runnable) this);
                return;
            }
            AbsHListView.this.F = -1;
            AbsHListView.this.b(0);
        }

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            int i3 = i2 < 0 ? SubsamplingScaleImageView.TILE_SIZE_AUTO : 0;
            this.f29247c = i3;
            this.f29246b.a((Interpolator) null);
            this.f29246b.a(i3, 0, i2, 0, 0, SubsamplingScaleImageView.TILE_SIZE_AUTO, 0, SubsamplingScaleImageView.TILE_SIZE_AUTO);
            AbsHListView.this.F = 4;
            AbsHListView.this.f29186a.a((Runnable) this);
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3, boolean z2) {
            int i4 = i2 < 0 ? SubsamplingScaleImageView.TILE_SIZE_AUTO : 0;
            this.f29247c = i4;
            this.f29246b.a(z2 ? AbsHListView.T : null);
            this.f29246b.a(i4, 0, i2, 0, i3);
            AbsHListView.this.F = 4;
            AbsHListView.this.f29186a.a((Runnable) this);
        }

        /* access modifiers changed from: package-private */
        public void b() {
            AbsHListView.this.F = -1;
            AbsHListView.this.removeCallbacks(this);
            AbsHListView.this.removeCallbacks(this.f29248d);
            AbsHListView.this.b(0);
            AbsHListView.this.F();
            this.f29246b.e();
            boolean unused = AbsHListView.this.overScrollBy(0, 0, 0, 0, 0, 0, 0, 0, false);
        }

        /* access modifiers changed from: package-private */
        public void b(int i2) {
            this.f29246b.a((Interpolator) null);
            this.f29246b.a(AbsHListView.this.getScrollX(), 0, i2, 0, Integer.MIN_VALUE, SubsamplingScaleImageView.TILE_SIZE_AUTO, 0, 0, AbsHListView.this.getWidth(), 0);
            AbsHListView.this.F = 6;
            AbsHListView.this.invalidate();
            AbsHListView.this.f29186a.a((Runnable) this);
        }

        /* access modifiers changed from: package-private */
        public void c() {
            AbsHListView.this.postDelayed(this.f29248d, 40);
        }

        /* access modifiers changed from: package-private */
        public void c(int i2) {
            this.f29246b.a(AbsHListView.this.getScrollX(), 0, AbsHListView.this.R);
            int overScrollMode = AbsHListView.this.getOverScrollMode();
            if (overScrollMode == 0 || (overScrollMode == 1 && !AbsHListView.this.z())) {
                AbsHListView.this.F = 6;
                (i2 > 0 ? AbsHListView.this.aQ : AbsHListView.this.aR).a((int) this.f29246b.c());
            } else {
                AbsHListView.this.F = -1;
                if (AbsHListView.this.I != null) {
                    AbsHListView.this.I.a();
                }
            }
            AbsHListView.this.invalidate();
            AbsHListView.this.f29186a.a((Runnable) this);
        }

        /* JADX WARNING: Removed duplicated region for block: B:33:0x0079  */
        /* JADX WARNING: Removed duplicated region for block: B:38:0x008e  */
        /* JADX WARNING: Removed duplicated region for block: B:61:0x0159  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r15 = this;
                it.sephiroth.android.library.widget.AbsHListView r0 = it.sephiroth.android.library.widget.AbsHListView.this
                int r0 = r0.F
                r1 = 3
                r2 = 0
                r3 = 1
                if (r0 == r1) goto L_0x006a
                r1 = 4
                if (r0 == r1) goto L_0x0073
                r1 = 6
                if (r0 == r1) goto L_0x0013
                r15.b()
                return
            L_0x0013:
                it.sephiroth.android.library.widget.c r0 = r15.f29246b
                boolean r1 = r0.d()
                if (r1 == 0) goto L_0x0065
                it.sephiroth.android.library.widget.AbsHListView r1 = it.sephiroth.android.library.widget.AbsHListView.this
                int r1 = r1.getScrollX()
                int r14 = r0.b()
                int r5 = r14 - r1
                it.sephiroth.android.library.widget.AbsHListView r4 = it.sephiroth.android.library.widget.AbsHListView.this
                r6 = 0
                r8 = 0
                r9 = 0
                r10 = 0
                int r11 = r4.R
                r12 = 0
                r13 = 0
                r7 = r1
                boolean r4 = r4.overScrollBy(r5, r6, r7, r8, r9, r10, r11, r12, r13)
                if (r4 == 0) goto L_0x005e
                if (r1 > 0) goto L_0x003e
                if (r14 <= 0) goto L_0x003e
                r4 = 1
                goto L_0x003f
            L_0x003e:
                r4 = 0
            L_0x003f:
                if (r1 < 0) goto L_0x0044
                if (r14 >= 0) goto L_0x0044
                r2 = 1
            L_0x0044:
                if (r4 != 0) goto L_0x004e
                if (r2 == 0) goto L_0x0049
                goto L_0x004e
            L_0x0049:
                r15.a()
                goto L_0x0158
            L_0x004e:
                float r1 = r0.c()
                int r1 = (int) r1
                if (r2 == 0) goto L_0x0056
                int r1 = -r1
            L_0x0056:
                r0.e()
                r15.a((int) r1)
                goto L_0x0158
            L_0x005e:
                it.sephiroth.android.library.widget.AbsHListView r0 = it.sephiroth.android.library.widget.AbsHListView.this
                r0.invalidate()
                goto L_0x0151
            L_0x0065:
                r15.b()
                goto L_0x0158
            L_0x006a:
                it.sephiroth.android.library.widget.c r0 = r15.f29246b
                boolean r0 = r0.a()
                if (r0 == 0) goto L_0x0073
                return
            L_0x0073:
                it.sephiroth.android.library.widget.AbsHListView r0 = it.sephiroth.android.library.widget.AbsHListView.this
                boolean r0 = r0.f29282aj
                if (r0 == 0) goto L_0x007e
                it.sephiroth.android.library.widget.AbsHListView r0 = it.sephiroth.android.library.widget.AbsHListView.this
                r0.e()
            L_0x007e:
                it.sephiroth.android.library.widget.AbsHListView r0 = it.sephiroth.android.library.widget.AbsHListView.this
                int r0 = r0.f29287ao
                if (r0 == 0) goto L_0x0159
                it.sephiroth.android.library.widget.AbsHListView r0 = it.sephiroth.android.library.widget.AbsHListView.this
                int r0 = r0.getChildCount()
                if (r0 != 0) goto L_0x008e
                goto L_0x0159
            L_0x008e:
                it.sephiroth.android.library.widget.c r0 = r15.f29246b
                boolean r1 = r0.d()
                int r0 = r0.b()
                int r4 = r15.f29247c
                int r4 = r4 - r0
                it.sephiroth.android.library.widget.AbsHListView r5 = it.sephiroth.android.library.widget.AbsHListView.this
                if (r4 <= 0) goto L_0x00cb
                int r6 = r5.V
                r5.A = r6
                it.sephiroth.android.library.widget.AbsHListView r5 = it.sephiroth.android.library.widget.AbsHListView.this
                android.view.View r5 = r5.getChildAt(r2)
                it.sephiroth.android.library.widget.AbsHListView r6 = it.sephiroth.android.library.widget.AbsHListView.this
                int r5 = r5.getLeft()
                r6.B = r5
                it.sephiroth.android.library.widget.AbsHListView r5 = it.sephiroth.android.library.widget.AbsHListView.this
                int r5 = r5.getWidth()
                it.sephiroth.android.library.widget.AbsHListView r6 = it.sephiroth.android.library.widget.AbsHListView.this
                int r6 = r6.getPaddingRight()
                int r5 = r5 - r6
                it.sephiroth.android.library.widget.AbsHListView r6 = it.sephiroth.android.library.widget.AbsHListView.this
                int r6 = r6.getPaddingLeft()
                int r5 = r5 - r6
                int r5 = r5 - r3
                int r4 = java.lang.Math.min(r5, r4)
                goto L_0x00ff
            L_0x00cb:
                int r5 = r5.getChildCount()
                int r5 = r5 - r3
                it.sephiroth.android.library.widget.AbsHListView r6 = it.sephiroth.android.library.widget.AbsHListView.this
                int r7 = r6.V
                int r7 = r7 + r5
                r6.A = r7
                it.sephiroth.android.library.widget.AbsHListView r6 = it.sephiroth.android.library.widget.AbsHListView.this
                android.view.View r5 = r6.getChildAt(r5)
                it.sephiroth.android.library.widget.AbsHListView r6 = it.sephiroth.android.library.widget.AbsHListView.this
                int r5 = r5.getLeft()
                r6.B = r5
                it.sephiroth.android.library.widget.AbsHListView r5 = it.sephiroth.android.library.widget.AbsHListView.this
                int r5 = r5.getWidth()
                it.sephiroth.android.library.widget.AbsHListView r6 = it.sephiroth.android.library.widget.AbsHListView.this
                int r6 = r6.getPaddingRight()
                int r5 = r5 - r6
                it.sephiroth.android.library.widget.AbsHListView r6 = it.sephiroth.android.library.widget.AbsHListView.this
                int r6 = r6.getPaddingLeft()
                int r5 = r5 - r6
                int r5 = r5 - r3
                int r5 = -r5
                int r4 = java.lang.Math.max(r5, r4)
            L_0x00ff:
                it.sephiroth.android.library.widget.AbsHListView r5 = it.sephiroth.android.library.widget.AbsHListView.this
                int r6 = r5.A
                it.sephiroth.android.library.widget.AbsHListView r7 = it.sephiroth.android.library.widget.AbsHListView.this
                int r7 = r7.V
                int r6 = r6 - r7
                android.view.View r5 = r5.getChildAt(r6)
                if (r5 == 0) goto L_0x0113
                int r6 = r5.getLeft()
                goto L_0x0114
            L_0x0113:
                r6 = 0
            L_0x0114:
                it.sephiroth.android.library.widget.AbsHListView r7 = it.sephiroth.android.library.widget.AbsHListView.this
                boolean r7 = r7.c(r4, r4)
                if (r7 == 0) goto L_0x011f
                if (r4 == 0) goto L_0x011f
                r2 = 1
            L_0x011f:
                if (r2 == 0) goto L_0x0144
                if (r5 == 0) goto L_0x013e
                int r0 = r5.getLeft()
                int r0 = r0 - r6
                int r0 = r4 - r0
                int r6 = -r0
                it.sephiroth.android.library.widget.AbsHListView r5 = it.sephiroth.android.library.widget.AbsHListView.this
                r7 = 0
                int r8 = r5.getScrollX()
                r9 = 0
                r10 = 0
                r11 = 0
                it.sephiroth.android.library.widget.AbsHListView r0 = it.sephiroth.android.library.widget.AbsHListView.this
                int r12 = r0.R
                r13 = 0
                r14 = 0
                boolean unused = r5.overScrollBy(r6, r7, r8, r9, r10, r11, r12, r13, r14)
            L_0x013e:
                if (r1 == 0) goto L_0x0158
                r15.c(r4)
                goto L_0x0158
            L_0x0144:
                if (r1 == 0) goto L_0x0065
                if (r2 != 0) goto L_0x0065
                if (r7 == 0) goto L_0x014f
                it.sephiroth.android.library.widget.AbsHListView r1 = it.sephiroth.android.library.widget.AbsHListView.this
                r1.invalidate()
            L_0x014f:
                r15.f29247c = r0
            L_0x0151:
                it.sephiroth.android.library.widget.AbsHListView r0 = it.sephiroth.android.library.widget.AbsHListView.this
                md.a$a r0 = r0.f29186a
                r0.a((java.lang.Runnable) r15)
            L_0x0158:
                return
            L_0x0159:
                r15.b()
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.AbsHListView.e.run():void");
        }
    }

    class f extends t.a {
        f() {
        }

        public void a(View view, u.c cVar) {
            int i2;
            super.a(view, cVar);
            int a2 = AbsHListView.this.a(view);
            ListAdapter listAdapter = (ListAdapter) AbsHListView.this.getAdapter();
            if (a2 != -1 && listAdapter != null && AbsHListView.this.isEnabled() && listAdapter.isEnabled(a2)) {
                if (a2 == AbsHListView.this.getSelectedItemPosition()) {
                    cVar.g(true);
                    i2 = 8;
                } else {
                    i2 = 4;
                }
                cVar.a(i2);
                if (AbsHListView.this.isClickable()) {
                    cVar.a(16);
                    cVar.h(true);
                }
                if (AbsHListView.this.isLongClickable()) {
                    cVar.a(32);
                    cVar.i(true);
                }
            }
        }

        public boolean a(View view, int i2, Bundle bundle) {
            if (super.a(view, i2, bundle)) {
                return true;
            }
            int a2 = AbsHListView.this.a(view);
            ListAdapter listAdapter = (ListAdapter) AbsHListView.this.getAdapter();
            if (a2 != -1 && listAdapter != null && AbsHListView.this.isEnabled() && listAdapter.isEnabled(a2)) {
                long g2 = AbsHListView.this.g(a2);
                if (i2 != 4) {
                    if (i2 != 8) {
                        if (i2 != 16) {
                            if (i2 == 32 && AbsHListView.this.isLongClickable()) {
                                return AbsHListView.this.c(view, a2, g2);
                            }
                            return false;
                        } else if (AbsHListView.this.isClickable()) {
                            return AbsHListView.this.a(view, a2, g2);
                        } else {
                            return false;
                        }
                    } else if (AbsHListView.this.getSelectedItemPosition() != a2) {
                        return false;
                    } else {
                        AbsHListView.this.setSelection(-1);
                        return true;
                    }
                } else if (AbsHListView.this.getSelectedItemPosition() != a2) {
                    AbsHListView.this.setSelection(a2);
                    return true;
                }
            }
            return false;
        }
    }

    public interface g {
        void a(AbsHListView absHListView, int i2);

        void a(AbsHListView absHListView, int i2, int i3, int i4);
    }

    private class h extends m implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        int f29251a;

        private h() {
            super();
        }

        public void run() {
            if (!AbsHListView.this.f29282aj) {
                ListAdapter listAdapter = AbsHListView.this.f29205j;
                int i2 = this.f29251a;
                if (listAdapter != null && AbsHListView.this.f29287ao > 0 && i2 != -1 && i2 < listAdapter.getCount() && b()) {
                    AbsHListView absHListView = AbsHListView.this;
                    View childAt = absHListView.getChildAt(i2 - absHListView.V);
                    if (childAt != null) {
                        AbsHListView.this.a(childAt, i2, listAdapter.getItemId(i2));
                    }
                }
            }
        }
    }

    public class i implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ AbsHListView f29253a;

        /* renamed from: b  reason: collision with root package name */
        private int f29254b;

        /* renamed from: c  reason: collision with root package name */
        private int f29255c;

        /* renamed from: d  reason: collision with root package name */
        private int f29256d;

        /* renamed from: e  reason: collision with root package name */
        private int f29257e;

        /* renamed from: f  reason: collision with root package name */
        private int f29258f;

        /* renamed from: g  reason: collision with root package name */
        private final int f29259g;

        /* renamed from: h  reason: collision with root package name */
        private int f29260h;

        public void a() {
            this.f29253a.removeCallbacks(this);
        }

        public void run() {
            AbsHListView absHListView;
            int i2;
            int width;
            int width2 = this.f29253a.getWidth();
            int i3 = this.f29253a.V;
            int i4 = this.f29254b;
            if (i4 != 1) {
                int i5 = 0;
                if (i4 != 2) {
                    if (i4 == 3) {
                        int childCount = this.f29253a.getChildCount();
                        if (i3 != this.f29256d && childCount > 1 && childCount + i3 < this.f29253a.f29287ao) {
                            int i6 = i3 + 1;
                            if (i6 != this.f29257e) {
                                View childAt = this.f29253a.getChildAt(1);
                                int width3 = childAt.getWidth();
                                int left = childAt.getLeft();
                                int max = Math.max(this.f29253a.f29216u.right, this.f29259g);
                                if (i6 < this.f29256d) {
                                    this.f29253a.a(Math.max(0, (width3 + left) - max), this.f29258f, true);
                                    this.f29257e = i6;
                                    this.f29253a.f29186a.a((Runnable) this);
                                    return;
                                } else if (left > max) {
                                    absHListView = this.f29253a;
                                    i2 = left - max;
                                } else {
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    } else if (i4 == 4) {
                        int childCount2 = this.f29253a.getChildCount() - 2;
                        if (childCount2 >= 0) {
                            int i7 = i3 + childCount2;
                            if (i7 != this.f29257e) {
                                View childAt2 = this.f29253a.getChildAt(childCount2);
                                int width4 = childAt2.getWidth();
                                int left2 = childAt2.getLeft();
                                int i8 = width2 - left2;
                                int max2 = Math.max(this.f29253a.f29216u.left, this.f29259g);
                                this.f29257e = i7;
                                if (i7 > this.f29256d) {
                                    this.f29253a.a(-(i8 - max2), this.f29258f, true);
                                    this.f29253a.f29186a.a((Runnable) this);
                                    return;
                                }
                                int i9 = width2 - max2;
                                int i10 = left2 + width4;
                                if (i9 > i10) {
                                    absHListView = this.f29253a;
                                    i2 = -(i9 - i10);
                                } else {
                                    return;
                                }
                            }
                        } else {
                            return;
                        }
                    } else if (i4 == 5) {
                        if (this.f29257e != i3) {
                            this.f29257e = i3;
                            int childCount3 = this.f29253a.getChildCount();
                            int i11 = this.f29255c;
                            int i12 = (i3 + childCount3) - 1;
                            if (i11 < i3) {
                                i5 = (i3 - i11) + 1;
                            } else if (i11 > i12) {
                                i5 = i11 - i12;
                            }
                            float min = Math.min(Math.abs(((float) i5) / ((float) childCount3)), 1.0f);
                            if (i11 < i3) {
                                width = -this.f29253a.getWidth();
                            } else if (i11 > i12) {
                                width = this.f29253a.getWidth();
                            } else {
                                int left3 = this.f29253a.getChildAt(i11 - i3).getLeft() - this.f29260h;
                                this.f29253a.a(left3, (int) (((float) this.f29258f) * (((float) Math.abs(left3)) / ((float) this.f29253a.getWidth()))), true);
                                return;
                            }
                            this.f29253a.a((int) (((float) width) * min), (int) (((float) this.f29258f) * min), true);
                            this.f29253a.f29186a.a((Runnable) this);
                            return;
                        }
                    } else {
                        return;
                    }
                    absHListView.a(i2, this.f29258f, true);
                    return;
                } else if (i3 != this.f29257e) {
                    View childAt3 = this.f29253a.getChildAt(0);
                    if (childAt3 != null) {
                        this.f29253a.a(childAt3.getLeft() - (i3 > 0 ? Math.max(this.f29259g, this.f29253a.f29216u.left) : this.f29253a.f29216u.left), this.f29258f, true);
                        this.f29257e = i3;
                        if (i3 <= this.f29255c) {
                            return;
                        }
                        this.f29253a.f29186a.a((Runnable) this);
                        return;
                    }
                    return;
                }
            } else {
                int childCount4 = this.f29253a.getChildCount() - 1;
                int i13 = i3 + childCount4;
                if (childCount4 >= 0) {
                    if (i13 != this.f29257e) {
                        View childAt4 = this.f29253a.getChildAt(childCount4);
                        this.f29253a.a((childAt4.getWidth() - (width2 - childAt4.getLeft())) + (i13 < this.f29253a.f29287ao - 1 ? Math.max(this.f29253a.f29216u.right, this.f29259g) : this.f29253a.f29216u.right), this.f29258f, true);
                        this.f29257e = i13;
                        if (i13 >= this.f29255c) {
                            return;
                        }
                        this.f29253a.f29186a.a((Runnable) this);
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f29253a.f29186a.a((Runnable) this);
        }
    }

    public class j {
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public k f29262b;

        /* renamed from: c  reason: collision with root package name */
        private int f29263c;

        /* renamed from: d  reason: collision with root package name */
        private View[] f29264d = new View[0];

        /* renamed from: e  reason: collision with root package name */
        private ArrayList<View>[] f29265e;

        /* renamed from: f  reason: collision with root package name */
        private int f29266f;

        /* renamed from: g  reason: collision with root package name */
        private ArrayList<View> f29267g;

        /* renamed from: h  reason: collision with root package name */
        private ArrayList<View> f29268h;

        /* renamed from: i  reason: collision with root package name */
        private j.h<View> f29269i;

        public j() {
        }

        private void f() {
            int length = this.f29264d.length;
            int i2 = this.f29266f;
            ArrayList<View>[] arrayListArr = this.f29265e;
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                ArrayList<View> arrayList = arrayListArr[i4];
                int size = arrayList.size();
                int i5 = size - length;
                int i6 = size - 1;
                int i7 = 0;
                while (i7 < i5) {
                    AbsHListView.this.removeDetachedView(arrayList.remove(i6), false);
                    i7++;
                    i6--;
                }
            }
            if (this.f29269i != null) {
                while (i3 < this.f29269i.b()) {
                    if (!this.f29269i.d(i3).hasTransientState()) {
                        this.f29269i.b(i3);
                        i3--;
                    }
                    i3++;
                }
            }
        }

        public void a() {
            int i2 = this.f29266f;
            if (i2 == 1) {
                ArrayList<View> arrayList = this.f29267g;
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    arrayList.get(i3).forceLayout();
                }
            } else {
                for (int i4 = 0; i4 < i2; i4++) {
                    ArrayList<View> arrayList2 = this.f29265e[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        arrayList2.get(i5).forceLayout();
                    }
                }
            }
            j.h<View> hVar = this.f29269i;
            if (hVar != null) {
                int b2 = hVar.b();
                for (int i6 = 0; i6 < b2; i6++) {
                    this.f29269i.d(i6).forceLayout();
                }
            }
        }

        public void a(int i2) {
            if (i2 >= 1) {
                ArrayList<View>[] arrayListArr = new ArrayList[i2];
                for (int i3 = 0; i3 < i2; i3++) {
                    arrayListArr[i3] = new ArrayList<>();
                }
                this.f29266f = i2;
                this.f29267g = arrayListArr[0];
                this.f29265e = arrayListArr;
                return;
            }
            throw new IllegalArgumentException("Can't have a viewTypeCount < 1");
        }

        public void a(int i2, int i3) {
            if (this.f29264d.length < i2) {
                this.f29264d = new View[i2];
            }
            this.f29263c = i3;
            View[] viewArr = this.f29264d;
            for (int i4 = 0; i4 < i2; i4++) {
                View childAt = AbsHListView.this.getChildAt(i4);
                LayoutParams layoutParams = (LayoutParams) childAt.getLayoutParams();
                if (!(layoutParams == null || layoutParams.f29226a == -2)) {
                    viewArr[i4] = childAt;
                }
            }
        }

        public void a(View view, int i2) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.f29229d = i2;
                int i3 = layoutParams.f29226a;
                boolean z2 = Build.VERSION.SDK_INT >= 16 && view.hasTransientState();
                if (!b(i3) || z2) {
                    if (i3 != -2 || z2) {
                        if (this.f29268h == null) {
                            this.f29268h = new ArrayList<>();
                        }
                        this.f29268h.add(view);
                    }
                    if (z2) {
                        if (this.f29269i == null) {
                            this.f29269i = new j.h<>();
                        }
                        view.onStartTemporaryDetach();
                        this.f29269i.b(i2, view);
                        return;
                    }
                    return;
                }
                view.onStartTemporaryDetach();
                (this.f29266f == 1 ? this.f29267g : this.f29265e[i3]).add(view);
                if (Build.VERSION.SDK_INT >= 14) {
                    view.setAccessibilityDelegate((View.AccessibilityDelegate) null);
                }
                k kVar = this.f29262b;
                if (kVar != null) {
                    kVar.a(view);
                }
            }
        }

        public void b() {
            int i2 = this.f29266f;
            if (i2 == 1) {
                ArrayList<View> arrayList = this.f29267g;
                int size = arrayList.size();
                for (int i3 = 0; i3 < size; i3++) {
                    AbsHListView.this.removeDetachedView(arrayList.remove((size - 1) - i3), false);
                }
            } else {
                for (int i4 = 0; i4 < i2; i4++) {
                    ArrayList<View> arrayList2 = this.f29265e[i4];
                    int size2 = arrayList2.size();
                    for (int i5 = 0; i5 < size2; i5++) {
                        AbsHListView.this.removeDetachedView(arrayList2.remove((size2 - 1) - i5), false);
                    }
                }
            }
            j.h<View> hVar = this.f29269i;
            if (hVar != null) {
                hVar.c();
            }
        }

        public boolean b(int i2) {
            return i2 >= 0;
        }

        public View c(int i2) {
            int i3 = i2 - this.f29263c;
            View[] viewArr = this.f29264d;
            if (i3 < 0 || i3 >= viewArr.length) {
                return null;
            }
            View view = viewArr[i3];
            viewArr[i3] = null;
            return view;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            j.h<View> hVar = this.f29269i;
            if (hVar != null) {
                hVar.c();
            }
        }

        /* access modifiers changed from: package-private */
        public View d(int i2) {
            int e2;
            j.h<View> hVar = this.f29269i;
            if (hVar == null || (e2 = hVar.e(i2)) < 0) {
                return null;
            }
            View d2 = this.f29269i.d(e2);
            this.f29269i.b(e2);
            return d2;
        }

        public void d() {
            ArrayList<View> arrayList = this.f29268h;
            if (arrayList != null) {
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    AbsHListView.this.removeDetachedView(this.f29268h.get(i2), false);
                }
                this.f29268h.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public View e(int i2) {
            ArrayList<View> arrayList;
            if (this.f29266f == 1) {
                arrayList = this.f29267g;
            } else {
                int itemViewType = AbsHListView.this.f29205j.getItemViewType(i2);
                if (itemViewType < 0) {
                    return null;
                }
                ArrayList<View>[] arrayListArr = this.f29265e;
                if (itemViewType >= arrayListArr.length) {
                    return null;
                }
                arrayList = arrayListArr[itemViewType];
            }
            return AbsHListView.a(arrayList, i2);
        }

        public void e() {
            View[] viewArr = this.f29264d;
            boolean z2 = this.f29262b != null;
            boolean z3 = this.f29266f > 1;
            ArrayList<View> arrayList = this.f29267g;
            for (int length = viewArr.length - 1; length >= 0; length--) {
                View view = viewArr[length];
                if (view != null) {
                    LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
                    int i2 = layoutParams.f29226a;
                    viewArr[length] = null;
                    boolean z4 = Build.VERSION.SDK_INT >= 16 && view.hasTransientState();
                    if (!b(i2) || z4) {
                        if (i2 != -2 || z4) {
                            AbsHListView.this.removeDetachedView(view, false);
                        }
                        if (z4) {
                            if (this.f29269i == null) {
                                this.f29269i = new j.h<>();
                            }
                            this.f29269i.b(this.f29263c + length, view);
                        }
                    } else {
                        if (z3) {
                            arrayList = this.f29265e[i2];
                        }
                        view.onStartTemporaryDetach();
                        layoutParams.f29229d = this.f29263c + length;
                        arrayList.add(view);
                        if (Build.VERSION.SDK_INT >= 14) {
                            view.setAccessibilityDelegate((View.AccessibilityDelegate) null);
                        }
                        if (z2) {
                            this.f29262b.a(view);
                        }
                    }
                }
            }
            f();
        }

        /* access modifiers changed from: package-private */
        public void f(int i2) {
            int i3 = this.f29266f;
            if (i3 == 1) {
                ArrayList<View> arrayList = this.f29267g;
                int size = arrayList.size();
                for (int i4 = 0; i4 < size; i4++) {
                    arrayList.get(i4).setDrawingCacheBackgroundColor(i2);
                }
            } else {
                for (int i5 = 0; i5 < i3; i5++) {
                    ArrayList<View> arrayList2 = this.f29265e[i5];
                    int size2 = arrayList2.size();
                    for (int i6 = 0; i6 < size2; i6++) {
                        arrayList2.get(i6).setDrawingCacheBackgroundColor(i2);
                    }
                }
            }
            for (View view : this.f29264d) {
                if (view != null) {
                    view.setDrawingCacheBackgroundColor(i2);
                }
            }
        }
    }

    public interface k {
        void a(View view);
    }

    public interface l {
        void a(Rect rect);
    }

    private class m {

        /* renamed from: a  reason: collision with root package name */
        private int f29270a;

        private m() {
        }

        public void a() {
            this.f29270a = AbsHListView.this.getWindowAttachCount();
        }

        public boolean b() {
            return AbsHListView.this.hasWindowFocus() && AbsHListView.this.getWindowAttachCount() == this.f29270a;
        }
    }

    public AbsHListView(Context context) {
        super(context);
        this.f29193b = 0;
        this.f29203h = 0;
        this.f29207l = false;
        this.f29209n = -1;
        this.f29210o = new Rect();
        this.f29211p = new j();
        this.f29212q = 0;
        this.f29213r = 0;
        this.f29214s = 0;
        this.f29215t = 0;
        this.f29216u = new Rect();
        this.f29217v = 0;
        this.F = -1;
        this.J = 0;
        this.f29190ax = true;
        this.M = -1;
        this.f29192az = null;
        this.aA = -1;
        this.aJ = 0;
        this.aO = 1.0f;
        this.P = new boolean[1];
        this.aP = -1;
        this.aU = 0;
        x();
    }

    public AbsHListView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.sephiroth_absHListViewStyle);
    }

    public AbsHListView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f29193b = 0;
        this.f29203h = 0;
        this.f29207l = false;
        this.f29209n = -1;
        this.f29210o = new Rect();
        this.f29211p = new j();
        this.f29212q = 0;
        this.f29213r = 0;
        this.f29214s = 0;
        this.f29215t = 0;
        this.f29216u = new Rect();
        this.f29217v = 0;
        this.F = -1;
        this.J = 0;
        this.f29190ax = true;
        this.M = -1;
        this.f29192az = null;
        this.aA = -1;
        this.aJ = 0;
        this.aO = 1.0f;
        this.P = new boolean[1];
        this.aP = -1;
        this.aU = 0;
        x();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AbsHListView, i2, 0);
        Drawable drawable = obtainStyledAttributes.getDrawable(R.styleable.AbsHListView_android_listSelector);
        if (drawable != null) {
            setSelector(drawable);
        }
        this.f29207l = obtainStyledAttributes.getBoolean(R.styleable.AbsHListView_android_drawSelectorOnTop, false);
        setStackFromRight(obtainStyledAttributes.getBoolean(R.styleable.AbsHListView_stackFromRight, false));
        setScrollingCacheEnabled(obtainStyledAttributes.getBoolean(R.styleable.AbsHListView_android_scrollingCache, true));
        setTranscriptMode(obtainStyledAttributes.getInt(R.styleable.AbsHListView_transcriptMode, 0));
        setCacheColorHint(obtainStyledAttributes.getColor(R.styleable.AbsHListView_android_cacheColorHint, 0));
        setSmoothScrollbarEnabled(obtainStyledAttributes.getBoolean(R.styleable.AbsHListView_android_smoothScrollbar, true));
        setChoiceMode(obtainStyledAttributes.getInt(R.styleable.AbsHListView_android_choiceMode, 0));
        obtainStyledAttributes.recycle();
    }

    private void A() {
        setSelector(getResources().getDrawable(17301602));
    }

    private void B() {
        VelocityTracker velocityTracker = this.f29187au;
        if (velocityTracker == null) {
            this.f29187au = VelocityTracker.obtain();
        } else {
            velocityTracker.clear();
        }
    }

    private void C() {
        if (this.f29187au == null) {
            this.f29187au = VelocityTracker.obtain();
        }
    }

    private void D() {
        VelocityTracker velocityTracker = this.f29187au;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f29187au = null;
        }
    }

    private void E() {
        if (this.L && !this.f29220y && !this.f29186a.a()) {
            setChildrenDrawnWithCacheEnabled(true);
            setChildrenDrawingCacheEnabled(true);
            this.f29221z = true;
            this.f29220y = true;
        }
    }

    /* access modifiers changed from: private */
    public void F() {
        if (!this.f29186a.a()) {
            if (this.aL == null) {
                this.aL = new Runnable() {
                    public void run() {
                        if (AbsHListView.this.f29220y) {
                            AbsHListView absHListView = AbsHListView.this;
                            absHListView.f29221z = false;
                            absHListView.f29220y = false;
                            AbsHListView.this.setChildrenDrawnWithCacheEnabled(false);
                            if ((AbsHListView.this.getPersistentDrawingCache() & 2) == 0) {
                                AbsHListView.this.setChildrenDrawingCacheEnabled(false);
                            }
                            if (!AbsHListView.this.isAlwaysDrawnWithCacheEnabled()) {
                                AbsHListView.this.invalidate();
                            }
                        }
                    }
                };
            }
            post(this.aL);
        }
    }

    private void G() {
        a aVar = this.aQ;
        if (aVar != null) {
            aVar.b();
            this.aR.b();
        }
    }

    public static int a(Rect rect, Rect rect2, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        if (i2 == 1 || i2 == 2) {
            i3 = rect.right + (rect.width() / 2);
            i5 = (rect.height() / 2) + rect.top;
            i6 = rect2.left + (rect2.width() / 2);
        } else if (i2 != 17) {
            if (i2 == 33) {
                i3 = rect.left + (rect.width() / 2);
                i5 = rect.top;
                i6 = rect2.left + (rect2.width() / 2);
                i4 = rect2.bottom;
            } else if (i2 == 66) {
                i3 = rect.right;
                i5 = (rect.height() / 2) + rect.top;
                i6 = rect2.left;
            } else if (i2 == 130) {
                i3 = rect.left + (rect.width() / 2);
                i5 = rect.bottom;
                i6 = rect2.left + (rect2.width() / 2);
                i4 = rect2.top;
            } else {
                throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT, FOCUS_FORWARD, FOCUS_BACKWARD}.");
            }
            int i7 = i6 - i3;
            int i8 = i4 - i5;
            return (i8 * i8) + (i7 * i7);
        } else {
            i3 = rect.left;
            i5 = (rect.height() / 2) + rect.top;
            i6 = rect2.right;
        }
        i4 = (rect2.height() / 2) + rect2.top;
        int i72 = i6 - i3;
        int i82 = i4 - i5;
        return (i82 * i82) + (i72 * i72);
    }

    static View a(ArrayList<View> arrayList, int i2) {
        int size = arrayList.size();
        if (size <= 0) {
            return null;
        }
        for (int i3 = 0; i3 < size; i3++) {
            View view = arrayList.get(i3);
            if (((LayoutParams) view.getLayoutParams()).f29229d == i2) {
                arrayList.remove(i3);
                return view;
            }
        }
        return arrayList.remove(size - 1);
    }

    private void a(int i2, int i3, int i4, int i5) {
        this.f29210o.set(i2 - this.f29212q, i3 - this.f29213r, i4 + this.f29214s, i5 + this.f29215t);
    }

    private void a(Canvas canvas) {
        if (!this.f29210o.isEmpty()) {
            Drawable drawable = this.f29208m;
            drawable.setBounds(this.f29210o);
            drawable.draw(canvas);
        }
    }

    private void b(MotionEvent motionEvent) {
        int action = (motionEvent.getAction() & 65280) >> 8;
        if (motionEvent.getPointerId(action) == this.aP) {
            int i2 = action == 0 ? 1 : 0;
            this.D = (int) motionEvent.getX(i2);
            this.E = (int) motionEvent.getY(i2);
            this.H = 0;
            this.aP = motionEvent.getPointerId(i2);
        }
    }

    private boolean h(int i2) {
        int i3 = i2 - this.D;
        int abs = Math.abs(i3);
        boolean z2 = getScrollX() != 0;
        if (!z2 && abs <= this.aK) {
            return false;
        }
        E();
        if (z2) {
            this.F = 5;
            this.H = 0;
        } else {
            this.F = 3;
            this.H = i3 > 0 ? this.aK : -this.aK;
        }
        Handler handler = getHandler();
        if (handler != null) {
            handler.removeCallbacks(this.aB);
        }
        setPressed(false);
        View childAt = getChildAt(this.A - this.V);
        if (childAt != null) {
            childAt.setPressed(false);
        }
        b(1);
        ViewParent parent = getParent();
        if (parent != null) {
            parent.requestDisallowInterceptTouchEvent(true);
        }
        i(i2);
        return true;
    }

    private void i(int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Rect a2;
        Rect a3;
        VelocityTracker velocityTracker;
        ViewParent parent;
        int i8 = i2;
        int i9 = i8 - this.D;
        int i10 = i9 - this.H;
        int i11 = this.G;
        int i12 = i11 != Integer.MIN_VALUE ? i8 - i11 : i10;
        int i13 = this.F;
        if (i13 == 3) {
            if (i8 != i11) {
                if (Math.abs(i9) > this.aK && (parent = getParent()) != null) {
                    parent.requestDisallowInterceptTouchEvent(true);
                }
                int i14 = this.A;
                int childCount = i14 >= 0 ? i14 - this.V : getChildCount() / 2;
                View childAt = getChildAt(childCount);
                int left = childAt != null ? childAt.getLeft() : 0;
                boolean c2 = i12 != 0 ? c(i10, i12) : false;
                View childAt2 = getChildAt(childCount);
                if (childAt2 != null) {
                    int left2 = childAt2.getLeft();
                    if (c2) {
                        int i15 = (-i12) - (left2 - left);
                        overScrollBy(i15, 0, getScrollX(), 0, 0, 0, this.Q, 0, true);
                        if (Math.abs(this.Q) == Math.abs(getScrollX()) && (velocityTracker = this.f29187au) != null) {
                            velocityTracker.clear();
                        }
                        int overScrollMode = getOverScrollMode();
                        if (overScrollMode == 0 || (overScrollMode == 1 && !z())) {
                            this.aU = 0;
                            this.F = 5;
                            if (i9 > 0) {
                                this.aQ.a(((float) i15) / ((float) getWidth()));
                                if (!this.aR.a()) {
                                    this.aR.c();
                                }
                                a3 = this.aQ.a(false);
                            } else if (i9 < 0) {
                                this.aR.a(((float) i15) / ((float) getWidth()));
                                if (!this.aQ.a()) {
                                    this.aQ.c();
                                }
                                a3 = this.aR.a(true);
                            }
                            invalidate(a3);
                        }
                    }
                    this.D = i8;
                }
                this.G = i8;
            }
        } else if (i13 == 5 && i8 != i11) {
            int scrollX = getScrollX();
            int i16 = scrollX - i12;
            int i17 = i8 > this.G ? 1 : -1;
            if (this.aU == 0) {
                this.aU = i17;
            }
            int i18 = -i12;
            if ((i16 >= 0 || scrollX < 0) && (i16 <= 0 || scrollX > 0)) {
                i3 = i18;
                i4 = 0;
            } else {
                int i19 = -scrollX;
                i4 = i12 + i19;
                i3 = i19;
            }
            if (i3 != 0) {
                i6 = i4;
                int i20 = i3;
                i5 = i17;
                overScrollBy(i3, 0, getScrollX(), 0, 0, 0, this.Q, 0, true);
                int overScrollMode2 = getOverScrollMode();
                if (overScrollMode2 == 0 || (overScrollMode2 == 1 && !z())) {
                    if (i9 > 0) {
                        this.aQ.a(((float) i20) / ((float) getWidth()));
                        if (!this.aR.a()) {
                            this.aR.c();
                        }
                        a2 = this.aQ.a(false);
                    } else if (i9 < 0) {
                        this.aR.a(((float) i20) / ((float) getWidth()));
                        if (!this.aQ.a()) {
                            this.aQ.c();
                        }
                        a2 = this.aR.a(true);
                    }
                    invalidate(a2);
                }
            } else {
                i6 = i4;
                i5 = i17;
            }
            if (i6 != 0) {
                if (getScrollX() != 0) {
                    i7 = 0;
                    this.f29186a.a(0);
                    k();
                } else {
                    i7 = 0;
                }
                c(i6, i6);
                this.F = 3;
                int e2 = e(i2);
                this.H = i7;
                View childAt3 = getChildAt(e2 - this.V);
                this.B = childAt3 != null ? childAt3.getLeft() : 0;
                this.D = i8;
                this.A = e2;
            }
            this.G = i8;
            this.aU = i5;
        }
    }

    private void x() {
        setClickable(true);
        setFocusableInTouchMode(true);
        setWillNotDraw(false);
        setAlwaysDrawnWithCacheEnabled(false);
        setScrollingCacheEnabled(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        this.aK = viewConfiguration.getScaledTouchSlop();
        this.aM = viewConfiguration.getScaledMinimumFlingVelocity();
        this.aN = viewConfiguration.getScaledMaximumFlingVelocity();
        this.Q = viewConfiguration.getScaledOverscrollDistance();
        this.R = viewConfiguration.getScaledOverflingDistance();
        this.f29186a = md.a.a(this);
    }

    private void y() {
        int i2 = this.V;
        int childCount = getChildCount();
        boolean z2 = Build.VERSION.SDK_INT >= 11;
        for (int i3 = 0; i3 < childCount; i3++) {
            View childAt = getChildAt(i3);
            int i4 = i2 + i3;
            if (childAt instanceof Checkable) {
                ((Checkable) childAt).setChecked(this.f29201f.get(i4));
            } else if (z2) {
                childAt.setActivated(this.f29201f.get(i4));
            }
        }
    }

    /* access modifiers changed from: private */
    public boolean z() {
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        return childCount == this.f29287ao && getChildAt(0).getLeft() >= this.f29216u.left && getChildAt(childCount - 1).getRight() <= getWidth() - this.f29216u.right;
    }

    public int a(int i2, int i3) {
        Rect rect = this.f29191ay;
        if (rect == null) {
            rect = new Rect();
            this.f29191ay = rect;
        }
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            View childAt = getChildAt(childCount);
            if (childAt.getVisibility() == 0) {
                childAt.getHitRect(rect);
                if (rect.contains(i2, i3)) {
                    return this.V + childCount;
                }
            }
        }
        return -1;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0033, code lost:
        if (r8 != 0) goto L_0x0035;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0055, code lost:
        if (r8 != 0) goto L_0x0035;
     */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x005c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View a(int r7, boolean[] r8) {
        /*
            r6 = this;
            r0 = 0
            r8[r0] = r0
            it.sephiroth.android.library.widget.AbsHListView$j r1 = r6.f29211p
            android.view.View r1 = r1.d(r7)
            if (r1 == 0) goto L_0x000c
            return r1
        L_0x000c:
            it.sephiroth.android.library.widget.AbsHListView$j r1 = r6.f29211p
            android.view.View r1 = r1.e(r7)
            r2 = 16
            r3 = 1
            if (r1 == 0) goto L_0x003f
            android.widget.ListAdapter r4 = r6.f29205j
            android.view.View r4 = r4.getView(r7, r1, r6)
            int r5 = android.os.Build.VERSION.SDK_INT
            if (r5 < r2) goto L_0x002a
            int r2 = r4.getImportantForAccessibility()
            if (r2 != 0) goto L_0x002a
            r4.setImportantForAccessibility(r3)
        L_0x002a:
            if (r4 == r1) goto L_0x0039
            it.sephiroth.android.library.widget.AbsHListView$j r8 = r6.f29211p
            r8.a((android.view.View) r1, (int) r7)
            int r8 = r6.aH
            if (r8 == 0) goto L_0x0058
        L_0x0035:
            r4.setDrawingCacheBackgroundColor(r8)
            goto L_0x0058
        L_0x0039:
            r8[r0] = r3
            r4.onFinishTemporaryDetach()
            goto L_0x0058
        L_0x003f:
            android.widget.ListAdapter r8 = r6.f29205j
            r0 = 0
            android.view.View r4 = r8.getView(r7, r0, r6)
            int r8 = android.os.Build.VERSION.SDK_INT
            if (r8 < r2) goto L_0x0053
            int r8 = r4.getImportantForAccessibility()
            if (r8 != 0) goto L_0x0053
            r4.setImportantForAccessibility(r3)
        L_0x0053:
            int r8 = r6.aH
            if (r8 == 0) goto L_0x0058
            goto L_0x0035
        L_0x0058:
            boolean r8 = r6.f29206k
            if (r8 == 0) goto L_0x007f
            android.view.ViewGroup$LayoutParams r8 = r4.getLayoutParams()
            if (r8 != 0) goto L_0x0069
            android.view.ViewGroup$LayoutParams r8 = r6.generateDefaultLayoutParams()
        L_0x0066:
            it.sephiroth.android.library.widget.AbsHListView$LayoutParams r8 = (it.sephiroth.android.library.widget.AbsHListView.LayoutParams) r8
            goto L_0x0074
        L_0x0069:
            boolean r0 = r6.checkLayoutParams(r8)
            if (r0 != 0) goto L_0x0066
            android.view.ViewGroup$LayoutParams r8 = r6.generateLayoutParams((android.view.ViewGroup.LayoutParams) r8)
            goto L_0x0066
        L_0x0074:
            android.widget.ListAdapter r0 = r6.f29205j
            long r0 = r0.getItemId(r7)
            r8.f29230e = r0
            r4.setLayoutParams(r8)
        L_0x007f:
            android.view.accessibility.AccessibilityManager r7 = r6.f29289aq
            boolean r7 = r7.isEnabled()
            if (r7 == 0) goto L_0x0092
            it.sephiroth.android.library.widget.AbsHListView$f r7 = r6.aY
            if (r7 != 0) goto L_0x0092
            it.sephiroth.android.library.widget.AbsHListView$f r7 = new it.sephiroth.android.library.widget.AbsHListView$f
            r7.<init>()
            r6.aY = r7
        L_0x0092:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.AbsHListView.a(int, boolean[]):android.view.View");
    }

    /* renamed from: a */
    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    public void a() {
        SparseBooleanArray sparseBooleanArray = this.f29201f;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.clear();
        }
        j.d<Integer> dVar = this.f29202g;
        if (dVar != null) {
            dVar.d();
        }
        this.f29200e = 0;
    }

    public void a(int i2, int i3, boolean z2) {
        if (this.f29188av == null) {
            this.f29188av = new e();
        }
        int i4 = this.V;
        int childCount = getChildCount();
        int i5 = i4 + childCount;
        int paddingLeft = getPaddingLeft();
        int width = getWidth() - getPaddingRight();
        if (i2 == 0 || this.f29287ao == 0 || childCount == 0 || ((i4 == 0 && getChildAt(0).getLeft() == paddingLeft && i2 < 0) || (i5 == this.f29287ao && getChildAt(childCount - 1).getRight() == width && i2 > 0))) {
            this.f29188av.b();
            i iVar = this.I;
            if (iVar != null) {
                iVar.a();
                return;
            }
            return;
        }
        b(2);
        this.f29188av.a(i2, i3, z2);
    }

    /* access modifiers changed from: protected */
    public void a(int i2, View view) {
        if (i2 != -1) {
            this.f29209n = i2;
        }
        Rect rect = this.f29210o;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        if (view instanceof l) {
            ((l) view).a(rect);
        }
        a(rect.left, rect.top, rect.right, rect.bottom);
        boolean z2 = this.aI;
        if (view.isEnabled() != z2) {
            this.aI = !z2;
            if (getSelectedItemPosition() != -1) {
                refreshDrawableState();
            }
        }
    }

    public void a(int i2, boolean z2) {
        if (this.f29193b != 0) {
            if (Build.VERSION.SDK_INT >= 11 && z2 && this.f29193b == 3 && this.f29198c == null) {
                Object obj = this.f29199d;
                if (obj == null || !((me.b) obj).a()) {
                    throw new IllegalStateException("AbsListView: attempted to start selection mode for CHOICE_MODE_MULTIPLE_MODAL but no choice mode callback was supplied. Call setMultiChoiceModeListener to set a callback.");
                }
                this.f29198c = startActionMode((me.b) this.f29199d);
            }
            if (this.f29193b == 2 || (Build.VERSION.SDK_INT >= 11 && this.f29193b == 3)) {
                boolean z3 = this.f29201f.get(i2);
                this.f29201f.put(i2, z2);
                if (this.f29202g != null && this.f29205j.hasStableIds()) {
                    j.d<Integer> dVar = this.f29202g;
                    long itemId = this.f29205j.getItemId(i2);
                    if (z2) {
                        dVar.b(itemId, Integer.valueOf(i2));
                    } else {
                        dVar.b(itemId);
                    }
                }
                if (z3 != z2) {
                    int i3 = this.f29200e;
                    this.f29200e = z2 ? i3 + 1 : i3 - 1;
                }
                if (this.f29198c != null) {
                    ((me.b) this.f29199d).a((ActionMode) this.f29198c, i2, this.f29205j.getItemId(i2), z2);
                }
            } else {
                boolean z4 = this.f29202g != null && this.f29205j.hasStableIds();
                if (z2 || a(i2)) {
                    this.f29201f.clear();
                    if (z4) {
                        this.f29202g.d();
                    }
                }
                if (z2) {
                    this.f29201f.put(i2, true);
                    if (z4) {
                        this.f29202g.b(this.f29205j.getItemId(i2), Integer.valueOf(i2));
                    }
                    this.f29200e = 1;
                } else if (this.f29201f.size() == 0 || !this.f29201f.valueAt(0)) {
                    this.f29200e = 0;
                }
            }
            if (!this.f29278af && !this.f29292at) {
                this.f29282aj = true;
                w();
                requestLayout();
            }
        }
    }

    /* access modifiers changed from: protected */
    public abstract void a(boolean z2);

    public boolean a(float f2, float f3, int i2) {
        int a2 = a((int) f2, (int) f3);
        if (a2 != -1) {
            long itemId = this.f29205j.getItemId(a2);
            View childAt = getChildAt(a2 - this.V);
            if (childAt != null) {
                this.f29192az = b(childAt, a2, itemId);
                return super.showContextMenuForChild(this);
            }
        }
        return a(f2, f3, i2);
    }

    public boolean a(int i2) {
        SparseBooleanArray sparseBooleanArray;
        if (this.f29193b == 0 || (sparseBooleanArray = this.f29201f) == null) {
            return false;
        }
        return sparseBooleanArray.get(i2);
    }

    /* access modifiers changed from: protected */
    public boolean a(MotionEvent motionEvent) {
        return Build.VERSION.SDK_INT >= 14 && (motionEvent.getButtonState() & 2) != 0 && a(motionEvent.getX(), motionEvent.getY(), motionEvent.getMetaState());
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00b6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean a(android.view.View r10, int r11, long r12) {
        /*
            r9 = this;
            int r0 = r9.f29193b
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L_0x00bb
            r3 = 2
            if (r0 == r3) goto L_0x0069
            int r0 = android.os.Build.VERSION.SDK_INT
            r3 = 11
            if (r0 < r3) goto L_0x0019
            int r0 = r9.f29193b
            r3 = 3
            if (r0 != r3) goto L_0x0019
            java.lang.Object r0 = r9.f29198c
            if (r0 == 0) goto L_0x0019
            goto L_0x0069
        L_0x0019:
            int r0 = r9.f29193b
            if (r0 != r2) goto L_0x0067
            android.util.SparseBooleanArray r0 = r9.f29201f
            boolean r0 = r0.get(r11, r1)
            r0 = r0 ^ r2
            if (r0 == 0) goto L_0x0053
            android.util.SparseBooleanArray r0 = r9.f29201f
            r0.clear()
            android.util.SparseBooleanArray r0 = r9.f29201f
            r0.put(r11, r2)
            j.d<java.lang.Integer> r0 = r9.f29202g
            if (r0 == 0) goto L_0x0050
            android.widget.ListAdapter r0 = r9.f29205j
            boolean r0 = r0.hasStableIds()
            if (r0 == 0) goto L_0x0050
            j.d<java.lang.Integer> r0 = r9.f29202g
            r0.d()
            j.d<java.lang.Integer> r0 = r9.f29202g
            android.widget.ListAdapter r1 = r9.f29205j
            long r3 = r1.getItemId(r11)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            r0.b(r3, r1)
        L_0x0050:
            r9.f29200e = r2
            goto L_0x0065
        L_0x0053:
            android.util.SparseBooleanArray r0 = r9.f29201f
            int r0 = r0.size()
            if (r0 == 0) goto L_0x0063
            android.util.SparseBooleanArray r0 = r9.f29201f
            boolean r0 = r0.valueAt(r1)
            if (r0 != 0) goto L_0x0065
        L_0x0063:
            r9.f29200e = r1
        L_0x0065:
            r0 = 1
            goto L_0x00b3
        L_0x0067:
            r0 = 1
            goto L_0x00b4
        L_0x0069:
            android.util.SparseBooleanArray r0 = r9.f29201f
            boolean r0 = r0.get(r11, r1)
            r8 = r0 ^ 1
            android.util.SparseBooleanArray r0 = r9.f29201f
            r0.put(r11, r8)
            j.d<java.lang.Integer> r0 = r9.f29202g
            if (r0 == 0) goto L_0x0097
            android.widget.ListAdapter r0 = r9.f29205j
            boolean r0 = r0.hasStableIds()
            if (r0 == 0) goto L_0x0097
            j.d<java.lang.Integer> r0 = r9.f29202g
            android.widget.ListAdapter r3 = r9.f29205j
            long r3 = r3.getItemId(r11)
            if (r8 == 0) goto L_0x0094
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)
            r0.b(r3, r5)
            goto L_0x0097
        L_0x0094:
            r0.b((long) r3)
        L_0x0097:
            int r0 = r9.f29200e
            if (r8 == 0) goto L_0x009d
            int r0 = r0 + r2
            goto L_0x009e
        L_0x009d:
            int r0 = r0 - r2
        L_0x009e:
            r9.f29200e = r0
            java.lang.Object r0 = r9.f29198c
            if (r0 == 0) goto L_0x00b1
            java.lang.Object r3 = r9.f29199d
            me.b r3 = (me.b) r3
            r4 = r0
            android.view.ActionMode r4 = (android.view.ActionMode) r4
            r5 = r11
            r6 = r12
            r3.a(r4, r5, r6, r8)
            goto L_0x00b2
        L_0x00b1:
            r1 = 1
        L_0x00b2:
            r0 = r1
        L_0x00b3:
            r1 = 1
        L_0x00b4:
            if (r1 == 0) goto L_0x00b9
            r9.y()
        L_0x00b9:
            r2 = r0
            r1 = 1
        L_0x00bb:
            if (r2 == 0) goto L_0x00c2
            boolean r10 = super.a(r10, r11, r12)
            r1 = r1 | r10
        L_0x00c2:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.AbsHListView.a(android.view.View, int, long):boolean");
    }

    public void addTouchables(ArrayList<View> arrayList) {
        int childCount = getChildCount();
        int i2 = this.V;
        ListAdapter listAdapter = this.f29205j;
        if (listAdapter != null) {
            for (int i3 = 0; i3 < childCount; i3++) {
                View childAt = getChildAt(i3);
                if (listAdapter.isEnabled(i2 + i3)) {
                    arrayList.add(childAt);
                }
                childAt.addTouchables(arrayList);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public ContextMenu.ContextMenuInfo b(View view, int i2, long j2) {
        return new AdapterView.a(view, i2, j2);
    }

    /* access modifiers changed from: protected */
    public void b() {
        g gVar = this.f29189aw;
        if (gVar != null) {
            gVar.a(this, this.V, getChildCount(), this.f29287ao);
        }
        onScrollChanged(0, 0, 0, 0);
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        g gVar;
        if (i2 != this.aJ && (gVar = this.f29189aw) != null) {
            this.aJ = i2;
            gVar.a(this, i2);
        }
    }

    public void b(int i2, int i3) {
        a(i2, i3, false);
    }

    /* access modifiers changed from: package-private */
    public void c() {
        if (getChildCount() > 0) {
            d();
            requestLayout();
            invalidate();
        }
    }

    public void c(int i2) {
        int childCount = getChildCount();
        for (int i3 = 0; i3 < childCount; i3++) {
            getChildAt(i3).offsetLeftAndRight(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean c(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int i7 = i2;
        int i8 = i3;
        int childCount = getChildCount();
        if (childCount == 0) {
            return true;
        }
        int left = getChildAt(0).getLeft();
        int i9 = childCount - 1;
        int right = getChildAt(i9).getRight();
        Rect rect = this.f29216u;
        int i10 = 0 - left;
        int width = right - (getWidth() - 0);
        int width2 = (getWidth() - getPaddingRight()) - getPaddingLeft();
        int i11 = width2 - 1;
        int max = i7 < 0 ? Math.max(-i11, i7) : Math.min(i11, i7);
        int i12 = width2 - 1;
        int max2 = i8 < 0 ? Math.max(-i12, i8) : Math.min(i12, i8);
        int i13 = this.V;
        this.aS = i13 == 0 ? left - rect.left : this.aS + max2;
        int i14 = i13 + childCount;
        this.aT = i14 == this.f29287ao ? rect.right + right : this.aT + max2;
        boolean z2 = i13 == 0 && left >= rect.left && max2 >= 0;
        boolean z3 = i14 == this.f29287ao && right <= getWidth() - rect.right && max2 <= 0;
        if (z2 || z3) {
            return max2 != 0;
        }
        boolean z4 = max2 < 0;
        boolean isInTouchMode = isInTouchMode();
        if (isInTouchMode) {
            l();
        }
        int headerViewsCount = getHeaderViewsCount();
        int footerViewsCount = this.f29287ao - getFooterViewsCount();
        if (z4) {
            int i15 = -max2;
            int i16 = 0;
            i4 = 0;
            while (i16 < childCount) {
                View childAt = getChildAt(i16);
                if (childAt.getRight() >= i15) {
                    break;
                }
                i4++;
                int i17 = i13 + i16;
                if (i17 < headerViewsCount || i17 >= footerViewsCount) {
                    i6 = childCount;
                } else {
                    i6 = childCount;
                    this.f29211p.a(childAt, i17);
                }
                i16++;
                childCount = i6;
            }
            i5 = 0;
        } else {
            int width3 = getWidth() - max2;
            i5 = 0;
            int i18 = 0;
            while (i9 >= 0) {
                View childAt2 = getChildAt(i9);
                if (childAt2.getLeft() <= width3) {
                    break;
                }
                i18 = i4 + 1;
                int i19 = i13 + i9;
                if (i19 >= headerViewsCount && i19 < footerViewsCount) {
                    this.f29211p.a(childAt2, i19);
                }
                int i20 = i9;
                i9--;
                i5 = i20;
            }
        }
        this.C = this.B + max;
        this.f29292at = true;
        if (i4 > 0) {
            detachViewsFromParent(i5, i4);
            this.f29211p.d();
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        c(max2);
        if (z4) {
            this.V += i4;
        }
        int abs = Math.abs(max2);
        if (i10 < abs || width < abs) {
            a(z4);
        }
        if (isInTouchMode || this.f29285am == -1) {
            int i21 = this.f29209n;
            if (i21 != -1) {
                int i22 = i21 - this.V;
                if (i22 >= 0 && i22 < getChildCount()) {
                    a(-1, getChildAt(i22));
                }
            } else {
                this.f29210o.setEmpty();
            }
        } else {
            int i23 = this.f29285am - this.V;
            if (i23 >= 0 && i23 < getChildCount()) {
                a(this.f29285am, getChildAt(i23));
            }
        }
        this.f29292at = false;
        b();
        return false;
    }

    /* access modifiers changed from: package-private */
    public boolean c(View view, int i2, long j2) {
        if (Build.VERSION.SDK_INT < 11 || this.f29193b != 3) {
            boolean b2 = this.f29281ai != null ? this.f29281ai.b(this, view, i2, j2) : false;
            if (!b2) {
                this.f29192az = b(view, i2, j2);
                b2 = super.showContextMenuForChild(this);
            }
            if (b2) {
                performHapticFeedback(0);
            }
            return b2;
        }
        if (this.f29198c == null) {
            ActionMode startActionMode = startActionMode((me.b) this.f29199d);
            this.f29198c = startActionMode;
            if (startActionMode != null) {
                a(i2, true);
                performHapticFeedback(0);
            }
        }
        return true;
    }

    public boolean checkInputConnectionProxy(View view) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    public int computeHorizontalScrollExtent() {
        int childCount = getChildCount();
        if (childCount <= 0) {
            return 0;
        }
        if (!this.f29190ax) {
            return 1;
        }
        int i2 = childCount * 100;
        View childAt = getChildAt(0);
        int left = childAt.getLeft();
        int width = childAt.getWidth();
        if (width > 0) {
            i2 += (left * 100) / width;
        }
        View childAt2 = getChildAt(childCount - 1);
        int right = childAt2.getRight();
        int width2 = childAt2.getWidth();
        return width2 > 0 ? i2 - (((right - getWidth()) * 100) / width2) : i2;
    }

    /* access modifiers changed from: protected */
    public int computeHorizontalScrollOffset() {
        int i2 = this.V;
        int childCount = getChildCount();
        int i3 = 0;
        if (i2 >= 0 && childCount > 0) {
            if (this.f29190ax) {
                View childAt = getChildAt(0);
                int left = childAt.getLeft();
                int width = childAt.getWidth();
                if (width > 0) {
                    return Math.max(((i2 * 100) - ((left * 100) / width)) + ((int) ((((float) getScrollX()) / ((float) getWidth())) * ((float) this.f29287ao) * 100.0f)), 0);
                }
            } else {
                int i4 = this.f29287ao;
                if (i2 != 0) {
                    i3 = i2 + childCount == i4 ? i4 : (childCount / 2) + i2;
                }
                return (int) (((float) i2) + (((float) childCount) * (((float) i3) / ((float) i4))));
            }
        }
        return 0;
    }

    /* access modifiers changed from: protected */
    public int computeHorizontalScrollRange() {
        if (!this.f29190ax) {
            return this.f29287ao;
        }
        int max = Math.max(this.f29287ao * 100, 0);
        return getScrollX() != 0 ? max + Math.abs((int) ((((float) getScrollX()) / ((float) getWidth())) * ((float) this.f29287ao) * 100.0f)) : max;
    }

    /* access modifiers changed from: protected */
    public abstract int d(int i2);

    /* access modifiers changed from: protected */
    public void d() {
        removeAllViewsInLayout();
        this.V = 0;
        this.f29282aj = false;
        this.O = null;
        this.f29276ad = false;
        this.f29196bc = null;
        this.f29290ar = -1;
        this.f29291as = Long.MIN_VALUE;
        setSelectedPositionInt(-1);
        setNextSelectedPositionInt(-1);
        this.J = 0;
        this.f29209n = -1;
        this.f29210o.setEmpty();
        invalidate();
    }

    /* access modifiers changed from: protected */
    public void d(int i2, int i3) {
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        boolean z2 = this.f29207l;
        if (!z2) {
            a(canvas);
        }
        super.dispatchDraw(canvas);
        if (z2) {
            a(canvas);
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchSetPressed(boolean z2) {
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        if (this.aQ != null) {
            int scrollX = getScrollX();
            if (!this.aQ.a()) {
                int save = canvas.save();
                int i2 = this.f29216u.top + this.aW;
                int height = (getHeight() - i2) - (this.f29216u.bottom + this.aX);
                getWidth();
                int min = Math.min(0, this.aS + scrollX);
                canvas.rotate(-90.0f);
                canvas.translate((float) ((-getHeight()) + i2), (float) min);
                this.aQ.a(height, height);
                if (this.aQ.a(canvas)) {
                    this.aQ.b(min, i2);
                    invalidate();
                }
                canvas.restoreToCount(save);
            }
            if (!this.aR.a()) {
                int save2 = canvas.save();
                int i3 = this.f29216u.left + this.aW;
                int height2 = (getHeight() - i3) - (this.f29216u.right + this.aX);
                int max = Math.max(getWidth(), scrollX + this.aT);
                canvas.rotate(90.0f);
                canvas.translate((float) (-i3), (float) (-max));
                this.aR.a(height2, height2);
                if (this.aR.a(canvas)) {
                    invalidate();
                }
                canvas.restoreToCount(save2);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        super.drawableStateChanged();
        j();
    }

    /* access modifiers changed from: protected */
    public int e(int i2) {
        int childCount = getChildCount();
        if (childCount == 0) {
            return -1;
        }
        int d2 = d(i2);
        return d2 != -1 ? d2 : (this.V + childCount) - 1;
    }

    /* access modifiers changed from: protected */
    public void e() {
    }

    /* access modifiers changed from: protected */
    public void f() {
        int i2 = 4;
        boolean z2 = true;
        if (this.f29218w != null) {
            boolean z3 = this.V > 0;
            if (!z3 && getChildCount() > 0) {
                z3 = getChildAt(0).getLeft() < this.f29216u.left;
            }
            this.f29218w.setVisibility(z3 ? 0 : 4);
        }
        if (this.f29219x != null) {
            int childCount = getChildCount();
            boolean z4 = this.V + childCount < this.f29287ao;
            if (!z4 && childCount > 0) {
                if (getChildAt(childCount - 1).getRight() <= getRight() - this.f29216u.right) {
                    z2 = false;
                }
                z4 = z2;
            }
            View view = this.f29219x;
            if (z4) {
                i2 = 0;
            }
            view.setVisibility(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean g() {
        int i2 = this.F;
        return i2 == 1 || i2 == 2;
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -1, 0);
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new LayoutParams(layoutParams);
    }

    @ViewDebug.ExportedProperty(category = "drawing")
    public int getCacheColorHint() {
        return this.aH;
    }

    public int getCheckedItemCount() {
        return this.f29200e;
    }

    public long[] getCheckedItemIds() {
        j.d<Integer> dVar;
        if (this.f29193b == 0 || (dVar = this.f29202g) == null || this.f29205j == null) {
            return new long[0];
        }
        int b2 = dVar.b();
        long[] jArr = new long[b2];
        for (int i2 = 0; i2 < b2; i2++) {
            jArr[i2] = dVar.b(i2);
        }
        return jArr;
    }

    public int getCheckedItemPosition() {
        SparseBooleanArray sparseBooleanArray;
        if (this.f29193b == 1 && (sparseBooleanArray = this.f29201f) != null && sparseBooleanArray.size() == 1) {
            return this.f29201f.keyAt(0);
        }
        return -1;
    }

    public SparseBooleanArray getCheckedItemPositions() {
        if (this.f29193b != 0) {
            return this.f29201f;
        }
        return null;
    }

    public int getChoiceMode() {
        return this.f29193b;
    }

    /* access modifiers changed from: protected */
    public ContextMenu.ContextMenuInfo getContextMenuInfo() {
        return this.f29192az;
    }

    public void getFocusedRect(Rect rect) {
        View selectedView = getSelectedView();
        if (selectedView == null || selectedView.getParent() != this) {
            super.getFocusedRect(rect);
            return;
        }
        selectedView.getFocusedRect(rect);
        offsetDescendantRectToMyCoords(selectedView, rect);
    }

    /* access modifiers changed from: protected */
    public int getFooterViewsCount() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public int getHeaderViewsCount() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public float getHorizontalScrollFactor() {
        if (this.f29197bd == 0.0f) {
            TypedValue typedValue = new TypedValue();
            if (getContext().getTheme().resolveAttribute(R.attr.sephiroth_listPreferredItemWidth, typedValue, true)) {
                this.f29197bd = typedValue.getDimension(getContext().getResources().getDisplayMetrics());
            } else {
                throw new IllegalStateException("Expected theme to define listPreferredItemHeight.");
            }
        }
        return this.f29197bd;
    }

    /* access modifiers changed from: protected */
    public int getHorizontalScrollbarHeight() {
        return super.getHorizontalScrollbarHeight();
    }

    /* access modifiers changed from: protected */
    public float getLeftFadingEdgeStrength() {
        int childCount = getChildCount();
        float leftFadingEdgeStrength = super.getLeftFadingEdgeStrength();
        if (childCount == 0) {
            return leftFadingEdgeStrength;
        }
        if (this.V > 0) {
            return 1.0f;
        }
        int left = getChildAt(0).getLeft();
        return left < getPaddingLeft() ? ((float) (-(left - getPaddingLeft()))) / ((float) getHorizontalFadingEdgeLength()) : leftFadingEdgeStrength;
    }

    public int getListPaddingBottom() {
        return this.f29216u.bottom;
    }

    public int getListPaddingLeft() {
        return this.f29216u.left;
    }

    public int getListPaddingRight() {
        return this.f29216u.right;
    }

    public int getListPaddingTop() {
        return this.f29216u.top;
    }

    /* access modifiers changed from: protected */
    public float getRightFadingEdgeStrength() {
        int childCount = getChildCount();
        float rightFadingEdgeStrength = super.getRightFadingEdgeStrength();
        if (childCount == 0) {
            return rightFadingEdgeStrength;
        }
        if ((this.V + childCount) - 1 < this.f29287ao - 1) {
            return 1.0f;
        }
        int right = getChildAt(childCount - 1).getRight();
        int width = getWidth();
        return right > width - getPaddingRight() ? ((float) ((right - width) + getPaddingRight())) / ((float) getHorizontalFadingEdgeLength()) : rightFadingEdgeStrength;
    }

    @ViewDebug.ExportedProperty
    public View getSelectedView() {
        if (this.f29287ao <= 0 || this.f29285am < 0) {
            return null;
        }
        return getChildAt(this.f29285am - this.V);
    }

    public Drawable getSelector() {
        return this.f29208m;
    }

    public int getSolidColor() {
        return this.aH;
    }

    public int getTranscriptMode() {
        return this.aG;
    }

    /* access modifiers changed from: protected */
    public boolean h() {
        return (hasFocus() && !isInTouchMode()) || g();
    }

    /* access modifiers changed from: protected */
    public void i() {
        if (isEnabled() && isClickable()) {
            Drawable drawable = this.f29208m;
            Rect rect = this.f29210o;
            if (drawable == null) {
                return;
            }
            if ((isFocused() || g()) && !rect.isEmpty()) {
                View childAt = getChildAt(this.f29285am - this.V);
                if (childAt != null) {
                    if (!childAt.hasFocusable()) {
                        childAt.setPressed(true);
                    } else {
                        return;
                    }
                }
                setPressed(true);
                boolean isLongClickable = isLongClickable();
                Drawable current = drawable.getCurrent();
                if (current != null && (current instanceof TransitionDrawable)) {
                    TransitionDrawable transitionDrawable = (TransitionDrawable) current;
                    if (isLongClickable) {
                        transitionDrawable.startTransition(ViewConfiguration.getLongPressTimeout());
                    } else {
                        transitionDrawable.resetTransition();
                    }
                }
                if (isLongClickable && !this.f29282aj) {
                    if (this.aD == null) {
                        this.aD = new b();
                    }
                    this.aD.a();
                    postDelayed(this.aD, (long) ViewConfiguration.getLongPressTimeout());
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void j() {
        if (this.f29208m == null) {
            return;
        }
        if (h()) {
            this.f29208m.setState(getDrawableState());
        } else {
            this.f29208m.setState(U);
        }
    }

    public void jumpDrawablesToCurrentState() {
        super.jumpDrawablesToCurrentState();
        Drawable drawable = this.f29208m;
        if (drawable != null) {
            drawable.jumpToCurrentState();
        }
    }

    /* access modifiers changed from: protected */
    public void k() {
        if (this.f29186a.a() && (getParent() instanceof View)) {
            ((View) getParent()).invalidate();
        }
    }

    /* access modifiers changed from: protected */
    public void l() {
        if (this.f29285am != -1) {
            if (this.f29203h != 4) {
                this.M = this.f29285am;
            }
            if (this.f29283ak >= 0 && this.f29283ak != this.f29285am) {
                this.M = this.f29283ak;
            }
            setSelectedPositionInt(-1);
            setNextSelectedPositionInt(-1);
            this.J = 0;
        }
    }

    /* access modifiers changed from: protected */
    public int m() {
        int i2 = this.f29285am;
        if (i2 < 0) {
            i2 = this.M;
        }
        return Math.min(Math.max(0, i2), this.f29287ao - 1);
    }

    /* access modifiers changed from: protected */
    public boolean n() {
        if (this.f29285am >= 0 || !o()) {
            return false;
        }
        j();
        return true;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x00d5 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:54:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean o() {
        /*
            r12 = this;
            int r0 = r12.getChildCount()
            r1 = 0
            if (r0 > 0) goto L_0x0008
            return r1
        L_0x0008:
            android.graphics.Rect r2 = r12.f29216u
            int r2 = r2.left
            int r3 = r12.getRight()
            int r4 = r12.getLeft()
            int r3 = r3 - r4
            android.graphics.Rect r4 = r12.f29216u
            int r4 = r4.right
            int r3 = r3 - r4
            int r4 = r12.V
            int r5 = r12.M
            r6 = 1
            if (r5 < r4) goto L_0x004c
            int r7 = r4 + r0
            if (r5 >= r7) goto L_0x004c
            int r0 = r12.V
            int r0 = r5 - r0
            android.view.View r0 = r12.getChildAt(r0)
            int r7 = r0.getLeft()
            int r8 = r0.getRight()
            if (r7 >= r2) goto L_0x003e
            int r0 = r12.getHorizontalFadingEdgeLength()
            int r7 = r2 + r0
            goto L_0x0070
        L_0x003e:
            if (r8 <= r3) goto L_0x0070
            int r0 = r0.getMeasuredWidth()
            int r3 = r3 - r0
            int r0 = r12.getHorizontalFadingEdgeLength()
            int r7 = r3 - r0
            goto L_0x0070
        L_0x004c:
            if (r5 >= r4) goto L_0x0072
            r3 = 0
            r5 = 0
        L_0x0050:
            if (r3 >= r0) goto L_0x006e
            android.view.View r7 = r12.getChildAt(r3)
            int r7 = r7.getLeft()
            if (r3 != 0) goto L_0x0066
            if (r4 > 0) goto L_0x0060
            if (r7 >= r2) goto L_0x0065
        L_0x0060:
            int r5 = r12.getHorizontalFadingEdgeLength()
            int r2 = r2 + r5
        L_0x0065:
            r5 = r7
        L_0x0066:
            if (r7 < r2) goto L_0x006b
            int r3 = r3 + r4
            r5 = r3
            goto L_0x0070
        L_0x006b:
            int r3 = r3 + 1
            goto L_0x0050
        L_0x006e:
            r7 = r5
            r5 = r4
        L_0x0070:
            r0 = 1
            goto L_0x00a1
        L_0x0072:
            int r2 = r12.f29287ao
            int r5 = r4 + r0
            int r7 = r5 + -1
            int r0 = r0 - r6
            r9 = r0
            r8 = 0
        L_0x007b:
            if (r9 < 0) goto L_0x009e
            android.view.View r10 = r12.getChildAt(r9)
            int r11 = r10.getLeft()
            int r10 = r10.getRight()
            if (r9 != r0) goto L_0x0095
            if (r5 < r2) goto L_0x008f
            if (r10 <= r3) goto L_0x0094
        L_0x008f:
            int r8 = r12.getHorizontalFadingEdgeLength()
            int r3 = r3 - r8
        L_0x0094:
            r8 = r11
        L_0x0095:
            if (r10 > r3) goto L_0x009b
            int r5 = r4 + r9
            r7 = r11
            goto L_0x00a0
        L_0x009b:
            int r9 = r9 + -1
            goto L_0x007b
        L_0x009e:
            r5 = r7
            r7 = r8
        L_0x00a0:
            r0 = 0
        L_0x00a1:
            r2 = -1
            r12.M = r2
            it.sephiroth.android.library.widget.AbsHListView$e r3 = r12.f29188av
            r12.removeCallbacks(r3)
            it.sephiroth.android.library.widget.AbsHListView$i r3 = r12.I
            if (r3 == 0) goto L_0x00b0
            r3.a()
        L_0x00b0:
            r12.F = r2
            r12.F()
            r12.W = r7
            int r0 = r12.b(r5, r0)
            if (r0 < r4) goto L_0x00d0
            int r3 = r12.getLastVisiblePosition()
            if (r0 > r3) goto L_0x00d0
            r2 = 4
            r12.f29203h = r2
            r12.j()
            r12.setSelectionInt(r0)
            r12.b()
            r2 = r0
        L_0x00d0:
            r12.b((int) r1)
            if (r2 < 0) goto L_0x00d6
            r1 = 1
        L_0x00d6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.AbsHListView.o():boolean");
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        getViewTreeObserver().addOnTouchModeChangeListener(this);
        if (this.f29205j != null && this.f29204i == null) {
            a aVar = new a();
            this.f29204i = aVar;
            this.f29205j.registerDataSetObserver(aVar);
            this.f29282aj = true;
            this.f29288ap = this.f29287ao;
            this.f29287ao = this.f29205j.getCount();
        }
        this.S = true;
    }

    /* access modifiers changed from: protected */
    public int[] onCreateDrawableState(int i2) {
        if (this.aI) {
            return super.onCreateDrawableState(i2);
        }
        int i3 = ENABLED_STATE_SET[0];
        int[] onCreateDrawableState = super.onCreateDrawableState(i2 + 1);
        int length = onCreateDrawableState.length - 1;
        while (true) {
            if (length < 0) {
                length = -1;
                break;
            } else if (onCreateDrawableState[length] == i3) {
                break;
            } else {
                length--;
            }
        }
        if (length >= 0) {
            System.arraycopy(onCreateDrawableState, length + 1, onCreateDrawableState, length, (onCreateDrawableState.length - length) - 1);
        }
        return onCreateDrawableState;
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        return null;
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        a aVar;
        super.onDetachedFromWindow();
        this.f29211p.b();
        getViewTreeObserver().removeOnTouchModeChangeListener(this);
        ListAdapter listAdapter = this.f29205j;
        if (!(listAdapter == null || (aVar = this.f29204i) == null)) {
            listAdapter.unregisterDataSetObserver(aVar);
            this.f29204i = null;
        }
        e eVar = this.f29188av;
        if (eVar != null) {
            removeCallbacks(eVar);
        }
        i iVar = this.I;
        if (iVar != null) {
            iVar.a();
        }
        Runnable runnable = this.aL;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        h hVar = this.aE;
        if (hVar != null) {
            removeCallbacks(hVar);
        }
        Runnable runnable2 = this.aF;
        if (runnable2 != null) {
            removeCallbacks(runnable2);
            this.aF = null;
        }
        this.S = false;
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z2, int i2, Rect rect) {
        super.onFocusChanged(z2, i2, rect);
        if (z2 && this.f29285am < 0 && !isInTouchMode()) {
            if (!this.S && this.f29205j != null) {
                this.f29282aj = true;
                this.f29288ap = this.f29287ao;
                this.f29287ao = this.f29205j.getCount();
            }
            o();
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        if ((motionEvent.getSource() & 2) != 0 && motionEvent.getAction() == 8 && this.F == -1) {
            float axisValue = motionEvent.getAxisValue(10);
            if (axisValue != 0.0f) {
                int horizontalScrollFactor = (int) (axisValue * getHorizontalScrollFactor());
                if (!c(horizontalScrollFactor, horizontalScrollFactor)) {
                    return true;
                }
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setClassName(AbsHListView.class.getName());
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setClassName(AbsHListView.class.getName());
        if (isEnabled()) {
            if (getFirstVisiblePosition() > 0) {
                accessibilityNodeInfo.addAction(8192);
            }
            if (getLastVisiblePosition() < getCount() - 1) {
                accessibilityNodeInfo.addAction(4096);
            }
        }
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        i iVar = this.I;
        if (iVar != null) {
            iVar.a();
        }
        if (!this.S) {
            return false;
        }
        int i2 = action & 255;
        if (i2 != 0) {
            if (i2 != 1) {
                if (i2 != 2) {
                    if (i2 != 3) {
                        if (i2 == 6) {
                            b(motionEvent);
                        }
                    }
                } else if (this.F == 0) {
                    int findPointerIndex = motionEvent.findPointerIndex(this.aP);
                    if (findPointerIndex == -1) {
                        this.aP = motionEvent.getPointerId(0);
                        findPointerIndex = 0;
                    }
                    C();
                    this.f29187au.addMovement(motionEvent);
                    if (h((int) motionEvent.getX(findPointerIndex))) {
                        return true;
                    }
                }
            }
            this.F = -1;
            this.aP = -1;
            D();
            b(0);
        } else {
            int i3 = this.F;
            if (i3 == 6 || i3 == 5) {
                this.H = 0;
                return true;
            }
            int x2 = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            this.aP = motionEvent.getPointerId(0);
            int d2 = d(x2);
            if (i3 != 4 && d2 >= 0) {
                this.B = getChildAt(d2 - this.V).getLeft();
                this.D = x2;
                this.E = y2;
                this.A = d2;
                this.F = 0;
                F();
            }
            this.G = Integer.MIN_VALUE;
            B();
            this.f29187au.addMovement(motionEvent);
            if (i3 == 4) {
                return true;
            }
        }
        return false;
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        return false;
    }

    public boolean onKeyUp(int i2, KeyEvent keyEvent) {
        if (i2 == 23 || i2 == 66) {
            if (!isEnabled()) {
                return true;
            }
            if (isClickable() && isPressed() && this.f29285am >= 0 && this.f29205j != null && this.f29285am < this.f29205j.getCount()) {
                View childAt = getChildAt(this.f29285am - this.V);
                if (childAt != null) {
                    a(childAt, this.f29285am, this.f29286an);
                    childAt.setPressed(false);
                }
                setPressed(false);
                return true;
            }
        }
        return super.onKeyUp(i2, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        super.onLayout(z2, i2, i3, i4, i5);
        this.f29278af = true;
        if (z2) {
            int childCount = getChildCount();
            for (int i6 = 0; i6 < childCount; i6++) {
                getChildAt(i6).forceLayout();
            }
            this.f29211p.a();
        }
        e();
        this.f29278af = false;
        this.N = (i4 - i2) / 3;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        if (this.f29208m == null) {
            A();
        }
        Rect rect = this.f29216u;
        rect.left = this.f29212q + getPaddingLeft();
        rect.top = this.f29213r + getPaddingTop();
        rect.right = this.f29214s + getPaddingRight();
        rect.bottom = this.f29215t + getPaddingBottom();
        boolean z2 = true;
        if (this.aG == 1) {
            int childCount = getChildCount();
            int width = getWidth() - getPaddingRight();
            View childAt = getChildAt(childCount - 1);
            int right = childAt != null ? childAt.getRight() : width;
            if (this.V + childCount < this.f29195bb || right > width) {
                z2 = false;
            }
            this.aV = z2;
        }
    }

    /* access modifiers changed from: protected */
    public void onOverScrolled(int i2, int i3, boolean z2, boolean z3) {
        if (getScrollX() != i2) {
            onScrollChanged(i2, getScrollY(), getScrollX(), getScrollY());
            this.f29186a.a(i2);
            k();
            awakenScrollBars();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0059  */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x0051  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onRestoreInstanceState(android.os.Parcelable r7) {
        /*
            r6 = this;
            it.sephiroth.android.library.widget.AbsHListView$SavedState r7 = (it.sephiroth.android.library.widget.AbsHListView.SavedState) r7
            android.os.Parcelable r0 = r7.getSuperState()
            super.onRestoreInstanceState(r0)
            r0 = 1
            r6.f29282aj = r0
            int r1 = r7.f29235e
            long r1 = (long) r1
            r6.f29275ac = r1
            long r1 = r7.f29231a
            r3 = 0
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x002d
            r6.f29276ad = r0
            r6.f29196bc = r7
            long r0 = r7.f29231a
            r6.f29274ab = r0
            int r0 = r7.f29234d
            r6.f29273aa = r0
            int r0 = r7.f29233c
            r6.W = r0
            r0 = 0
        L_0x002a:
            r6.f29277ae = r0
            goto L_0x004d
        L_0x002d:
            long r1 = r7.f29232b
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x004d
            r1 = -1
            r6.setSelectedPositionInt(r1)
            r6.setNextSelectedPositionInt(r1)
            r6.f29209n = r1
            r6.f29276ad = r0
            r6.f29196bc = r7
            long r1 = r7.f29232b
            r6.f29274ab = r1
            int r1 = r7.f29234d
            r6.f29273aa = r1
            int r1 = r7.f29233c
            r6.W = r1
            goto L_0x002a
        L_0x004d:
            android.util.SparseBooleanArray r0 = r7.f29239i
            if (r0 == 0) goto L_0x0055
            android.util.SparseBooleanArray r0 = r7.f29239i
            r6.f29201f = r0
        L_0x0055:
            j.d<java.lang.Integer> r0 = r7.f29240j
            if (r0 == 0) goto L_0x005d
            j.d<java.lang.Integer> r0 = r7.f29240j
            r6.f29202g = r0
        L_0x005d:
            int r0 = r7.f29238h
            r6.f29200e = r0
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 11
            if (r0 < r1) goto L_0x007c
            boolean r7 = r7.f29237g
            if (r7 == 0) goto L_0x007c
            int r7 = r6.f29193b
            r0 = 3
            if (r7 != r0) goto L_0x007c
            java.lang.Object r7 = r6.f29199d
            if (r7 == 0) goto L_0x007c
            me.b r7 = (me.b) r7
            android.view.ActionMode r7 = r6.startActionMode(r7)
            r6.f29198c = r7
        L_0x007c:
            r6.requestLayout()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: it.sephiroth.android.library.widget.AbsHListView.onRestoreInstanceState(android.os.Parcelable):void");
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.f29196bc;
        if (savedState2 != null) {
            savedState.f29231a = savedState2.f29231a;
            savedState.f29232b = this.f29196bc.f29232b;
            savedState.f29233c = this.f29196bc.f29233c;
            savedState.f29234d = this.f29196bc.f29234d;
            savedState.f29235e = this.f29196bc.f29235e;
            savedState.f29236f = this.f29196bc.f29236f;
            savedState.f29237g = this.f29196bc.f29237g;
            savedState.f29238h = this.f29196bc.f29238h;
            savedState.f29239i = this.f29196bc.f29239i;
            savedState.f29240j = this.f29196bc.f29240j;
            return savedState;
        }
        boolean z2 = true;
        boolean z3 = getChildCount() > 0 && this.f29287ao > 0;
        long selectedItemId = getSelectedItemId();
        savedState.f29231a = selectedItemId;
        savedState.f29235e = getWidth();
        if (selectedItemId >= 0) {
            savedState.f29233c = this.J;
            savedState.f29234d = getSelectedItemPosition();
            savedState.f29232b = -1;
        } else if (!z3 || this.V <= 0) {
            savedState.f29233c = 0;
            savedState.f29232b = -1;
            savedState.f29234d = 0;
        } else {
            savedState.f29233c = getChildAt(0).getLeft();
            int i2 = this.V;
            if (i2 >= this.f29287ao) {
                i2 = this.f29287ao - 1;
            }
            savedState.f29234d = i2;
            savedState.f29232b = this.f29205j.getItemId(i2);
        }
        savedState.f29236f = null;
        if (Build.VERSION.SDK_INT < 11 || this.f29193b != 3 || this.f29198c == null) {
            z2 = false;
        }
        savedState.f29237g = z2;
        SparseBooleanArray sparseBooleanArray = this.f29201f;
        if (sparseBooleanArray != null) {
            try {
                savedState.f29239i = sparseBooleanArray.clone();
            } catch (NoSuchMethodError e2) {
                e2.printStackTrace();
                savedState.f29239i = new SparseBooleanArray();
            }
        }
        if (this.f29202g != null) {
            j.d<Integer> dVar = new j.d<>();
            int b2 = this.f29202g.b();
            for (int i3 = 0; i3 < b2; i3++) {
                dVar.b(this.f29202g.b(i3), this.f29202g.c(i3));
            }
            savedState.f29240j = dVar;
        }
        savedState.f29238h = this.f29200e;
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        if (getChildCount() > 0) {
            this.f29282aj = true;
            w();
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Drawable current;
        int i2 = 0;
        if (!isEnabled()) {
            return isClickable() || isLongClickable();
        }
        i iVar = this.I;
        if (iVar != null) {
            iVar.a();
        }
        if (!this.S) {
            return false;
        }
        int action = motionEvent.getAction();
        C();
        this.f29187au.addMovement(motionEvent);
        int i3 = action & 255;
        if (i3 != 0) {
            if (i3 == 1) {
                int i4 = this.F;
                if (i4 == 0 || i4 == 1 || i4 == 2) {
                    int i5 = this.A;
                    final View childAt = getChildAt(i5 - this.V);
                    float x2 = motionEvent.getX();
                    boolean z2 = x2 > ((float) this.f29216u.left) && x2 < ((float) (getWidth() - this.f29216u.right));
                    if (childAt != null && !childAt.hasFocusable() && z2) {
                        if (this.F != 0) {
                            childAt.setPressed(false);
                        }
                        if (this.aE == null) {
                            this.aE = new h();
                        }
                        final h hVar = this.aE;
                        hVar.f29251a = i5;
                        hVar.a();
                        this.M = i5;
                        int i6 = this.F;
                        if (i6 == 0 || i6 == 1) {
                            Handler handler = getHandler();
                            if (handler != null) {
                                handler.removeCallbacks(this.F == 0 ? this.aC : this.aB);
                            }
                            this.f29203h = 0;
                            if (this.f29282aj || !this.f29205j.isEnabled(i5)) {
                                this.F = -1;
                                j();
                            } else {
                                this.F = 1;
                                setSelectedPositionInt(this.A);
                                e();
                                childAt.setPressed(true);
                                a(this.A, childAt);
                                setPressed(true);
                                Drawable drawable = this.f29208m;
                                if (!(drawable == null || (current = drawable.getCurrent()) == null || !(current instanceof TransitionDrawable))) {
                                    ((TransitionDrawable) current).resetTransition();
                                }
                                Runnable runnable = this.aF;
                                if (runnable != null) {
                                    removeCallbacks(runnable);
                                }
                                AnonymousClass1 r0 = new Runnable() {
                                    public void run() {
                                        AbsHListView.this.F = -1;
                                        childAt.setPressed(false);
                                        AbsHListView.this.setPressed(false);
                                        if (!AbsHListView.this.f29282aj) {
                                            hVar.run();
                                        }
                                    }
                                };
                                this.aF = r0;
                                postDelayed(r0, (long) ViewConfiguration.getPressedStateDuration());
                            }
                            return true;
                        } else if (!this.f29282aj && this.f29205j.isEnabled(i5)) {
                            hVar.run();
                        }
                    }
                    this.F = -1;
                    j();
                } else if (i4 == 3) {
                    int childCount = getChildCount();
                    if (childCount > 0) {
                        int left = getChildAt(0).getLeft();
                        int right = getChildAt(childCount - 1).getRight();
                        int i7 = this.f29216u.left;
                        int width = getWidth() - this.f29216u.right;
                        if (this.V != 0 || left < i7 || this.V + childCount >= this.f29287ao || right > getWidth() - width) {
                            VelocityTracker velocityTracker = this.f29187au;
                            velocityTracker.computeCurrentVelocity(1000, (float) this.aN);
                            int xVelocity = (int) (velocityTracker.getXVelocity(this.aP) * this.aO);
                            if (Math.abs(xVelocity) <= this.aM || ((this.V == 0 && left == i7 - this.Q) || (this.V + childCount == this.f29287ao && right == width + this.Q))) {
                                this.F = -1;
                                b(0);
                                e eVar = this.f29188av;
                                if (eVar != null) {
                                    eVar.b();
                                }
                                i iVar2 = this.I;
                                if (iVar2 != null) {
                                    iVar2.a();
                                }
                            } else {
                                if (this.f29188av == null) {
                                    this.f29188av = new e();
                                }
                                b(2);
                                this.f29188av.a(-xVelocity);
                            }
                        }
                    }
                    this.F = -1;
                    b(0);
                } else if (i4 == 5) {
                    if (this.f29188av == null) {
                        this.f29188av = new e();
                    }
                    VelocityTracker velocityTracker2 = this.f29187au;
                    velocityTracker2.computeCurrentVelocity(1000, (float) this.aN);
                    int xVelocity2 = (int) velocityTracker2.getXVelocity(this.aP);
                    b(2);
                    if (Math.abs(xVelocity2) > this.aM) {
                        this.f29188av.b(-xVelocity2);
                    } else {
                        this.f29188av.a();
                    }
                }
                setPressed(false);
                a aVar = this.aQ;
                if (aVar != null) {
                    aVar.c();
                    this.aR.c();
                }
                invalidate();
                Handler handler2 = getHandler();
                if (handler2 != null) {
                    handler2.removeCallbacks(this.aB);
                }
                D();
            } else if (i3 == 2) {
                int findPointerIndex = motionEvent.findPointerIndex(this.aP);
                if (findPointerIndex == -1) {
                    this.aP = motionEvent.getPointerId(0);
                } else {
                    i2 = findPointerIndex;
                }
                int x3 = (int) motionEvent.getX(i2);
                if (this.f29282aj) {
                    e();
                }
                int i8 = this.F;
                if (i8 == 0 || i8 == 1 || i8 == 2) {
                    h(x3);
                } else if (i8 == 3 || i8 == 5) {
                    i(x3);
                }
            } else if (i3 == 3) {
                int i9 = this.F;
                if (i9 == 5) {
                    if (this.f29188av == null) {
                        this.f29188av = new e();
                    }
                    this.f29188av.a();
                } else if (i9 != 6) {
                    this.F = -1;
                    setPressed(false);
                    View childAt2 = getChildAt(this.A - this.V);
                    if (childAt2 != null) {
                        childAt2.setPressed(false);
                    }
                    F();
                    Handler handler3 = getHandler();
                    if (handler3 != null) {
                        handler3.removeCallbacks(this.aB);
                    }
                    D();
                }
                a aVar2 = this.aQ;
                if (aVar2 != null) {
                    aVar2.c();
                    this.aR.c();
                }
            } else if (i3 == 5) {
                int actionIndex = motionEvent.getActionIndex();
                int pointerId = motionEvent.getPointerId(actionIndex);
                int x4 = (int) motionEvent.getX(actionIndex);
                int y2 = (int) motionEvent.getY(actionIndex);
                this.H = 0;
                this.aP = pointerId;
                this.D = x4;
                this.E = y2;
                int a2 = a(x4, y2);
                if (a2 >= 0) {
                    this.B = getChildAt(a2 - this.V).getLeft();
                    this.A = a2;
                }
                this.G = x4;
            } else if (i3 == 6) {
                b(motionEvent);
                int i10 = this.D;
                int a3 = a(i10, this.E);
                if (a3 >= 0) {
                    this.B = getChildAt(a3 - this.V).getLeft();
                    this.A = a3;
                }
                this.G = i10;
            }
            this.aP = -1;
        } else {
            if (this.F != 6) {
                this.aP = motionEvent.getPointerId(0);
                int x5 = (int) motionEvent.getX();
                int y3 = (int) motionEvent.getY();
                int a4 = a(x5, y3);
                if (!this.f29282aj) {
                    if (this.F != 4 && a4 >= 0 && ((ListAdapter) getAdapter()).isEnabled(a4)) {
                        this.F = 0;
                        if (this.aC == null) {
                            this.aC = new d();
                        }
                        postDelayed(this.aC, (long) ViewConfiguration.getTapTimeout());
                    } else if (this.F == 4) {
                        E();
                        this.F = 3;
                        this.H = 0;
                        a4 = d(x5);
                        this.f29188av.c();
                    }
                }
                if (a4 >= 0) {
                    this.B = getChildAt(a4 - this.V).getLeft();
                }
                this.D = x5;
                this.E = y3;
                this.A = a4;
                this.G = Integer.MIN_VALUE;
            } else {
                this.f29188av.b();
                i iVar3 = this.I;
                if (iVar3 != null) {
                    iVar3.a();
                }
                this.F = 5;
                this.E = (int) motionEvent.getY();
                int x6 = (int) motionEvent.getX();
                this.G = x6;
                this.D = x6;
                this.H = 0;
                this.aP = motionEvent.getPointerId(0);
                this.aU = 0;
            }
            if (a(motionEvent) && this.F == 0) {
                removeCallbacks(this.aC);
            }
        }
        return true;
    }

    public void onTouchModeChanged(boolean z2) {
        if (z2) {
            l();
            if (getWidth() > 0 && getChildCount() > 0) {
                e();
            }
            j();
            return;
        }
        int i2 = this.F;
        if (i2 == 5 || i2 == 6) {
            e eVar = this.f29188av;
            if (eVar != null) {
                eVar.b();
            }
            i iVar = this.I;
            if (iVar != null) {
                iVar.a();
            }
            if (getScrollX() != 0) {
                this.f29186a.a(0);
                G();
                invalidate();
            }
        }
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        boolean z3 = !isInTouchMode();
        if (!z2) {
            setChildrenDrawingCacheEnabled(false);
            e eVar = this.f29188av;
            if (eVar != null) {
                removeCallbacks(eVar);
                this.f29188av.b();
                i iVar = this.I;
                if (iVar != null) {
                    iVar.a();
                }
                if (getScrollX() != 0) {
                    this.f29186a.a(0);
                    G();
                    invalidate();
                }
            }
            if (z3) {
                this.M = this.f29285am;
            }
        } else {
            int i2 = this.aA;
            if (!(z3 == i2 || i2 == -1)) {
                if (z3) {
                    o();
                } else {
                    l();
                    this.f29203h = 0;
                    e();
                }
            }
        }
        this.aA = z3 ? 1 : 0;
    }

    /* access modifiers changed from: package-private */
    public void p() {
        Object obj;
        boolean z2;
        Object obj2;
        Object obj3;
        this.f29201f.clear();
        int i2 = 0;
        boolean z3 = false;
        while (i2 < this.f29202g.b()) {
            long b2 = this.f29202g.b(i2);
            int intValue = this.f29202g.c(i2).intValue();
            if (b2 != this.f29205j.getItemId(intValue)) {
                int max = Math.max(0, intValue - 20);
                int min = Math.min(intValue + 20, this.f29287ao);
                while (true) {
                    if (max >= min) {
                        z2 = false;
                        break;
                    } else if (b2 == this.f29205j.getItemId(max)) {
                        this.f29201f.put(max, true);
                        this.f29202g.a(i2, Integer.valueOf(max));
                        z2 = true;
                        break;
                    } else {
                        max++;
                    }
                }
                if (!z2) {
                    this.f29202g.b(b2);
                    i2--;
                    this.f29200e--;
                    if (!(Build.VERSION.SDK_INT <= 11 || (obj2 = this.f29198c) == null || (obj3 = this.f29199d) == null)) {
                        ((me.b) obj3).a((ActionMode) obj2, intValue, b2, false);
                    }
                    z3 = true;
                }
            } else {
                this.f29201f.put(intValue, true);
            }
            i2++;
        }
        if (z3 && (obj = this.f29198c) != null) {
            ((ActionMode) obj).invalidate();
        }
    }

    public boolean performAccessibilityAction(int i2, Bundle bundle) {
        int width;
        if (super.performAccessibilityAction(i2, bundle)) {
            return true;
        }
        if (i2 != 4096) {
            if (i2 != 8192 || !isEnabled() || this.V <= 0) {
                return false;
            }
            width = -((getWidth() - this.f29216u.left) - this.f29216u.right);
        } else if (!isEnabled() || getLastVisiblePosition() >= getCount() - 1) {
            return false;
        } else {
            width = (getWidth() - this.f29216u.left) - this.f29216u.right;
        }
        b(width, 200);
        return true;
    }

    /* access modifiers changed from: protected */
    public void q() {
        ListAdapter listAdapter;
        int i2 = this.f29287ao;
        int i3 = this.f29195bb;
        this.f29195bb = this.f29287ao;
        if (Build.VERSION.SDK_INT >= 16 && this.f29193b != 0 && (listAdapter = this.f29205j) != null && listAdapter.hasStableIds()) {
            p();
        }
        this.f29211p.c();
        int i4 = 3;
        if (i2 > 0) {
            if (this.f29276ad) {
                this.f29276ad = false;
                this.f29196bc = null;
                int i5 = this.aG;
                if (i5 == 2) {
                    this.f29203h = 3;
                    return;
                }
                if (i5 == 1) {
                    if (this.aV) {
                        this.aV = false;
                        this.f29203h = 3;
                        return;
                    }
                    int childCount = getChildCount();
                    int width = getWidth() - getPaddingRight();
                    View childAt = getChildAt(childCount - 1);
                    int bottom = childAt != null ? childAt.getBottom() : width;
                    if (this.V + childCount < i3 || bottom > width) {
                        awakenScrollBars();
                    } else {
                        this.f29203h = 3;
                        return;
                    }
                }
                int i6 = this.f29277ae;
                if (i6 != 0) {
                    if (i6 == 1) {
                        this.f29203h = 5;
                        this.f29273aa = Math.min(Math.max(0, this.f29273aa), i2 - 1);
                        return;
                    }
                } else if (isInTouchMode()) {
                    this.f29203h = 5;
                    this.f29273aa = Math.min(Math.max(0, this.f29273aa), i2 - 1);
                    return;
                } else {
                    int v2 = v();
                    if (v2 >= 0 && b(v2, true) == v2) {
                        this.f29273aa = v2;
                        if (this.f29275ac == ((long) getWidth())) {
                            this.f29203h = 5;
                        } else {
                            this.f29203h = 2;
                        }
                        setNextSelectedPositionInt(v2);
                        return;
                    }
                }
            }
            if (!isInTouchMode()) {
                int selectedItemPosition = getSelectedItemPosition();
                if (selectedItemPosition >= i2) {
                    selectedItemPosition = i2 - 1;
                }
                if (selectedItemPosition < 0) {
                    selectedItemPosition = 0;
                }
                int b2 = b(selectedItemPosition, true);
                if (b2 >= 0) {
                    setNextSelectedPositionInt(b2);
                    return;
                }
                int b3 = b(selectedItemPosition, false);
                if (b3 >= 0) {
                    setNextSelectedPositionInt(b3);
                    return;
                }
            } else if (this.M >= 0) {
                return;
            }
        }
        if (!this.K) {
            i4 = 1;
        }
        this.f29203h = i4;
        this.f29285am = -1;
        this.f29286an = Long.MIN_VALUE;
        this.f29283ak = -1;
        this.f29284al = Long.MIN_VALUE;
        this.f29276ad = false;
        this.f29196bc = null;
        this.f29209n = -1;
        u();
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        if (z2) {
            D();
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void requestLayout() {
        if (!this.f29292at && !this.f29278af) {
            super.requestLayout();
        }
    }

    public void sendAccessibilityEvent(int i2) {
        if (i2 == 4096) {
            int firstVisiblePosition = getFirstVisiblePosition();
            int lastVisiblePosition = getLastVisiblePosition();
            if (this.aZ != firstVisiblePosition || this.f29194ba != lastVisiblePosition) {
                this.aZ = firstVisiblePosition;
                this.f29194ba = lastVisiblePosition;
            } else {
                return;
            }
        }
        super.sendAccessibilityEvent(i2);
    }

    public void setAdapter(ListAdapter listAdapter) {
        if (listAdapter != null) {
            boolean hasStableIds = this.f29205j.hasStableIds();
            this.f29206k = hasStableIds;
            if (this.f29193b != 0 && hasStableIds && this.f29202g == null) {
                this.f29202g = new j.d<>();
            }
        }
        SparseBooleanArray sparseBooleanArray = this.f29201f;
        if (sparseBooleanArray != null) {
            sparseBooleanArray.clear();
        }
        j.d<Integer> dVar = this.f29202g;
        if (dVar != null) {
            dVar.d();
        }
    }

    public void setCacheColorHint(int i2) {
        if (i2 != this.aH) {
            this.aH = i2;
            int childCount = getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                getChildAt(i3).setDrawingCacheBackgroundColor(i2);
            }
            this.f29211p.f(i2);
        }
    }

    public void setChoiceMode(int i2) {
        ListAdapter listAdapter;
        this.f29193b = i2;
        if (Build.VERSION.SDK_INT >= 11 && this.f29198c != null) {
            if (Build.VERSION.SDK_INT >= 11) {
                ((ActionMode) this.f29198c).finish();
            }
            this.f29198c = null;
        }
        if (this.f29193b != 0) {
            if (this.f29201f == null) {
                this.f29201f = new SparseBooleanArray();
            }
            if (this.f29202g == null && (listAdapter = this.f29205j) != null && listAdapter.hasStableIds()) {
                this.f29202g = new j.d<>();
            }
            if (Build.VERSION.SDK_INT >= 11 && this.f29193b == 3) {
                a();
                setLongClickable(true);
            }
        }
    }

    public void setDrawSelectorOnTop(boolean z2) {
        this.f29207l = z2;
    }

    public void setFriction(float f2) {
        if (this.f29188av == null) {
            this.f29188av = new e();
        }
        this.f29188av.f29246b.b(f2);
    }

    public void setMultiChoiceModeListener(me.a aVar) {
        if (Build.VERSION.SDK_INT >= 11) {
            if (this.f29199d == null) {
                this.f29199d = new me.b(this);
            }
            ((me.b) this.f29199d).a(aVar);
            return;
        }
        Log.e("AbsListView", "setMultiChoiceModeListener not supported for this version of Android");
    }

    public void setOnScrollListener(g gVar) {
        this.f29189aw = gVar;
        b();
    }

    public void setOverScrollMode(int i2) {
        if (i2 == 2) {
            this.aQ = null;
            this.aR = null;
        } else if (this.aQ == null) {
            Context context = getContext();
            this.aQ = new a(context, 1);
            this.aR = new a(context, 1);
        }
        super.setOverScrollMode(i2);
    }

    public void setRecyclerListener(k kVar) {
        k unused = this.f29211p.f29262b = kVar;
    }

    public void setScrollingCacheEnabled(boolean z2) {
        if (this.L && !z2) {
            F();
        }
        this.L = z2;
    }

    public abstract void setSelectionInt(int i2);

    public void setSelector(int i2) {
        setSelector(getResources().getDrawable(i2));
    }

    public void setSelector(Drawable drawable) {
        Drawable drawable2 = this.f29208m;
        if (drawable2 != null) {
            drawable2.setCallback((Drawable.Callback) null);
            unscheduleDrawable(this.f29208m);
        }
        this.f29208m = drawable;
        Rect rect = new Rect();
        drawable.getPadding(rect);
        this.f29212q = rect.left;
        this.f29213r = rect.top;
        this.f29214s = rect.right;
        this.f29215t = rect.bottom;
        drawable.setCallback(this);
        j();
    }

    public void setSmoothScrollbarEnabled(boolean z2) {
        this.f29190ax = z2;
    }

    public void setStackFromRight(boolean z2) {
        if (this.K != z2) {
            this.K = z2;
            c();
        }
    }

    public void setTranscriptMode(int i2) {
        this.aG = i2;
    }

    public void setVelocityScale(float f2) {
        this.aO = f2;
    }

    public boolean showContextMenuForChild(View view) {
        int a2 = a(view);
        boolean z2 = false;
        if (a2 < 0) {
            return false;
        }
        long itemId = this.f29205j.getItemId(a2);
        if (this.f29281ai != null) {
            z2 = this.f29281ai.b(this, view, a2, itemId);
        }
        if (z2) {
            return z2;
        }
        this.f29192az = b(getChildAt(a2 - this.V), a2, itemId);
        return super.showContextMenuForChild(view);
    }

    public boolean verifyDrawable(Drawable drawable) {
        return this.f29208m == drawable || super.verifyDrawable(drawable);
    }
}
