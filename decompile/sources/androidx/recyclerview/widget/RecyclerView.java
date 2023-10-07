package androidx.recyclerview.widget;

import android.animation.LayoutTransition;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.database.Observable;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.util.Log;
import android.util.SparseArray;
import android.view.Display;
import android.view.FocusFinder;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import android.view.animation.Interpolator;
import android.widget.EdgeEffect;
import android.widget.OverScroller;
import androidx.customview.view.AbsSavedState;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.a;
import androidx.recyclerview.widget.d;
import androidx.recyclerview.widget.j;
import androidx.recyclerview.widget.u;
import androidx.recyclerview.widget.y;
import androidx.recyclerview.widget.z;
import com.blankj.utilcode.constant.MemoryConstants;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.shuyu.gsyvideoplayer.video.base.GSYVideoView;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import java.lang.ref.WeakReference;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import t.ac;
import t.ad;
import t.z;
import u.c;

public class RecyclerView extends ViewGroup implements t.n, t.o, z {
    static final Interpolator M = new Interpolator() {
        public float getInterpolation(float f2) {
            float f3 = f2 - 1.0f;
            return (f3 * f3 * f3 * f3 * f3) + 1.0f;
        }
    };
    private static final int[] N = {16843830};
    private static final boolean O = (Build.VERSION.SDK_INT <= 15);
    private static final boolean P = (Build.VERSION.SDK_INT <= 15);
    private static final Class<?>[] Q = {Context.class, AttributeSet.class, Integer.TYPE, Integer.TYPE};

    /* renamed from: a  reason: collision with root package name */
    static final boolean f3883a = (Build.VERSION.SDK_INT == 18 || Build.VERSION.SDK_INT == 19 || Build.VERSION.SDK_INT == 20);

    /* renamed from: b  reason: collision with root package name */
    static final boolean f3884b = (Build.VERSION.SDK_INT >= 23);

    /* renamed from: c  reason: collision with root package name */
    static final boolean f3885c = (Build.VERSION.SDK_INT >= 16);

    /* renamed from: d  reason: collision with root package name */
    static final boolean f3886d = (Build.VERSION.SDK_INT >= 21);
    boolean A;
    e B;
    final u C;
    j D;
    j.a E;
    final s F;
    boolean G;
    boolean H;
    boolean I;
    u J;
    final int[] K;
    final List<v> L;
    private final p R;
    private final Rect S;
    private final ArrayList<k> T;
    private k U;
    private int V;
    private boolean W;
    private e.b aA;
    private c aB;
    private final int[] aC;
    private t.p aD;
    private final int[] aE;
    private final int[] aF;
    private Runnable aG;
    private boolean aH;
    private int aI;
    private int aJ;
    private final z.b aK;

    /* renamed from: aa  reason: collision with root package name */
    private int f3887aa;

    /* renamed from: ab  reason: collision with root package name */
    private final AccessibilityManager f3888ab;

    /* renamed from: ac  reason: collision with root package name */
    private List<i> f3889ac;

    /* renamed from: ad  reason: collision with root package name */
    private int f3890ad;

    /* renamed from: ae  reason: collision with root package name */
    private int f3891ae;

    /* renamed from: af  reason: collision with root package name */
    private d f3892af;

    /* renamed from: ag  reason: collision with root package name */
    private EdgeEffect f3893ag;

    /* renamed from: ah  reason: collision with root package name */
    private EdgeEffect f3894ah;

    /* renamed from: ai  reason: collision with root package name */
    private EdgeEffect f3895ai;

    /* renamed from: aj  reason: collision with root package name */
    private EdgeEffect f3896aj;

    /* renamed from: ak  reason: collision with root package name */
    private int f3897ak;

    /* renamed from: al  reason: collision with root package name */
    private int f3898al;

    /* renamed from: am  reason: collision with root package name */
    private VelocityTracker f3899am;

    /* renamed from: an  reason: collision with root package name */
    private int f3900an;

    /* renamed from: ao  reason: collision with root package name */
    private int f3901ao;

    /* renamed from: ap  reason: collision with root package name */
    private int f3902ap;

    /* renamed from: aq  reason: collision with root package name */
    private int f3903aq;

    /* renamed from: ar  reason: collision with root package name */
    private int f3904ar;

    /* renamed from: as  reason: collision with root package name */
    private j f3905as;

    /* renamed from: at  reason: collision with root package name */
    private final int f3906at;

    /* renamed from: au  reason: collision with root package name */
    private final int f3907au;

    /* renamed from: av  reason: collision with root package name */
    private float f3908av;

    /* renamed from: aw  reason: collision with root package name */
    private float f3909aw;

    /* renamed from: ax  reason: collision with root package name */
    private boolean f3910ax;

    /* renamed from: ay  reason: collision with root package name */
    private l f3911ay;

    /* renamed from: az  reason: collision with root package name */
    private List<l> f3912az;

    /* renamed from: e  reason: collision with root package name */
    final n f3913e;

    /* renamed from: f  reason: collision with root package name */
    SavedState f3914f;

    /* renamed from: g  reason: collision with root package name */
    a f3915g;

    /* renamed from: h  reason: collision with root package name */
    d f3916h;

    /* renamed from: i  reason: collision with root package name */
    final z f3917i;

    /* renamed from: j  reason: collision with root package name */
    boolean f3918j;

    /* renamed from: k  reason: collision with root package name */
    final Runnable f3919k;

    /* renamed from: l  reason: collision with root package name */
    final Rect f3920l;

    /* renamed from: m  reason: collision with root package name */
    final RectF f3921m;

    /* renamed from: n  reason: collision with root package name */
    Adapter f3922n;

    /* renamed from: o  reason: collision with root package name */
    h f3923o;

    /* renamed from: p  reason: collision with root package name */
    o f3924p;

    /* renamed from: q  reason: collision with root package name */
    final List<o> f3925q;

    /* renamed from: r  reason: collision with root package name */
    final ArrayList<g> f3926r;

    /* renamed from: s  reason: collision with root package name */
    boolean f3927s;

    /* renamed from: t  reason: collision with root package name */
    boolean f3928t;

    /* renamed from: u  reason: collision with root package name */
    boolean f3929u;

    /* renamed from: v  reason: collision with root package name */
    boolean f3930v;

    /* renamed from: w  reason: collision with root package name */
    boolean f3931w;

    /* renamed from: x  reason: collision with root package name */
    boolean f3932x;

    /* renamed from: y  reason: collision with root package name */
    boolean f3933y;

    /* renamed from: z  reason: collision with root package name */
    boolean f3934z;

    /* renamed from: androidx.recyclerview.widget.RecyclerView$7  reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f3940a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy[] r0 = androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f3940a = r0
                androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy r1 = androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.PREVENT     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f3940a     // Catch:{ NoSuchFieldError -> 0x001d }
                androidx.recyclerview.widget.RecyclerView$Adapter$StateRestorationPolicy r1 = androidx.recyclerview.widget.RecyclerView.Adapter.StateRestorationPolicy.PREVENT_WHEN_EMPTY     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.AnonymousClass7.<clinit>():void");
        }
    }

    public static abstract class Adapter<VH extends v> {
        private boolean mHasStableIds = false;
        private final a mObservable = new a();
        private StateRestorationPolicy mStateRestorationPolicy = StateRestorationPolicy.ALLOW;

        public enum StateRestorationPolicy {
            ALLOW,
            PREVENT_WHEN_EMPTY,
            PREVENT
        }

        public final void bindViewHolder(VH vh, int i2) {
            boolean z2 = vh.mBindingAdapter == null;
            if (z2) {
                vh.mPosition = i2;
                if (hasStableIds()) {
                    vh.mItemId = getItemId(i2);
                }
                vh.setFlags(1, 519);
                androidx.core.os.i.a("RV OnBindView");
            }
            vh.mBindingAdapter = this;
            onBindViewHolder(vh, i2, vh.getUnmodifiedPayloads());
            if (z2) {
                vh.clearPayload();
                ViewGroup.LayoutParams layoutParams = vh.itemView.getLayoutParams();
                if (layoutParams instanceof LayoutParams) {
                    ((LayoutParams) layoutParams).f3947e = true;
                }
                androidx.core.os.i.a();
            }
        }

        /* access modifiers changed from: package-private */
        public boolean canRestoreState() {
            int i2 = AnonymousClass7.f3940a[this.mStateRestorationPolicy.ordinal()];
            if (i2 != 1) {
                return i2 != 2 || getItemCount() > 0;
            }
            return false;
        }

        public final VH createViewHolder(ViewGroup viewGroup, int i2) {
            try {
                androidx.core.os.i.a("RV CreateView");
                VH onCreateViewHolder = onCreateViewHolder(viewGroup, i2);
                if (onCreateViewHolder.itemView.getParent() == null) {
                    onCreateViewHolder.mItemViewType = i2;
                    return onCreateViewHolder;
                }
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            } finally {
                androidx.core.os.i.a();
            }
        }

        public int findRelativeAdapterPositionIn(Adapter<? extends v> adapter, v vVar, int i2) {
            if (adapter == this) {
                return i2;
            }
            return -1;
        }

        public abstract int getItemCount();

        public long getItemId(int i2) {
            return -1;
        }

        public int getItemViewType(int i2) {
            return 0;
        }

        public final StateRestorationPolicy getStateRestorationPolicy() {
            return this.mStateRestorationPolicy;
        }

        public final boolean hasObservers() {
            return this.mObservable.a();
        }

        public final boolean hasStableIds() {
            return this.mHasStableIds;
        }

        public final void notifyDataSetChanged() {
            this.mObservable.b();
        }

        public final void notifyItemChanged(int i2) {
            this.mObservable.a(i2, 1);
        }

        public final void notifyItemChanged(int i2, Object obj) {
            this.mObservable.a(i2, 1, obj);
        }

        public final void notifyItemInserted(int i2) {
            this.mObservable.b(i2, 1);
        }

        public final void notifyItemMoved(int i2, int i3) {
            this.mObservable.d(i2, i3);
        }

        public final void notifyItemRangeChanged(int i2, int i3) {
            this.mObservable.a(i2, i3);
        }

        public final void notifyItemRangeChanged(int i2, int i3, Object obj) {
            this.mObservable.a(i2, i3, obj);
        }

        public final void notifyItemRangeInserted(int i2, int i3) {
            this.mObservable.b(i2, i3);
        }

        public final void notifyItemRangeRemoved(int i2, int i3) {
            this.mObservable.c(i2, i3);
        }

        public final void notifyItemRemoved(int i2) {
            this.mObservable.c(i2, 1);
        }

        public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        }

        public abstract void onBindViewHolder(VH vh, int i2);

        public void onBindViewHolder(VH vh, int i2, List<Object> list) {
            onBindViewHolder(vh, i2);
        }

        public abstract VH onCreateViewHolder(ViewGroup viewGroup, int i2);

        public void onDetachedFromRecyclerView(RecyclerView recyclerView) {
        }

        public boolean onFailedToRecycleView(VH vh) {
            return false;
        }

        public void onViewAttachedToWindow(VH vh) {
        }

        public void onViewDetachedFromWindow(VH vh) {
        }

        public void onViewRecycled(VH vh) {
        }

        public void registerAdapterDataObserver(b bVar) {
            this.mObservable.registerObserver(bVar);
        }

        public void setHasStableIds(boolean z2) {
            if (!hasObservers()) {
                this.mHasStableIds = z2;
                return;
            }
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }

        public void setStateRestorationPolicy(StateRestorationPolicy stateRestorationPolicy) {
            this.mStateRestorationPolicy = stateRestorationPolicy;
            this.mObservable.c();
        }

        public void unregisterAdapterDataObserver(b bVar) {
            this.mObservable.unregisterObserver(bVar);
        }
    }

    public static class LayoutParams extends ViewGroup.MarginLayoutParams {

        /* renamed from: c  reason: collision with root package name */
        v f3945c;

        /* renamed from: d  reason: collision with root package name */
        final Rect f3946d = new Rect();

        /* renamed from: e  reason: collision with root package name */
        boolean f3947e = true;

        /* renamed from: f  reason: collision with root package name */
        boolean f3948f = false;

        public LayoutParams(int i2, int i3) {
            super(i2, i3);
        }

        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        public LayoutParams(LayoutParams layoutParams) {
            super(layoutParams);
        }

        public boolean c() {
            return this.f3945c.isInvalid();
        }

        public boolean d() {
            return this.f3945c.isRemoved();
        }

        public boolean e() {
            return this.f3945c.isUpdated();
        }

        public int f() {
            return this.f3945c.getLayoutPosition();
        }
    }

    public static class SavedState extends AbsSavedState {
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
        Parcelable f3949a;

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.f3949a = parcel.readParcelable(classLoader == null ? h.class.getClassLoader() : classLoader);
        }

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        /* access modifiers changed from: package-private */
        public void a(SavedState savedState) {
            this.f3949a = savedState.f3949a;
        }

        public void writeToParcel(Parcel parcel, int i2) {
            super.writeToParcel(parcel, i2);
            parcel.writeParcelable(this.f3949a, 0);
        }
    }

    static class a extends Observable<b> {
        a() {
        }

        public void a(int i2, int i3) {
            a(i2, i3, (Object) null);
        }

        public void a(int i2, int i3, Object obj) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((b) this.mObservers.get(size)).a(i2, i3, obj);
            }
        }

        public boolean a() {
            return !this.mObservers.isEmpty();
        }

        public void b() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((b) this.mObservers.get(size)).a();
            }
        }

        public void b(int i2, int i3) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((b) this.mObservers.get(size)).b(i2, i3);
            }
        }

        public void c() {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((b) this.mObservers.get(size)).b();
            }
        }

        public void c(int i2, int i3) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((b) this.mObservers.get(size)).c(i2, i3);
            }
        }

        public void d(int i2, int i3) {
            for (int size = this.mObservers.size() - 1; size >= 0; size--) {
                ((b) this.mObservers.get(size)).a(i2, i3, 1);
            }
        }
    }

    public static abstract class b {
        public void a() {
        }

        public void a(int i2, int i3) {
        }

        public void a(int i2, int i3, int i4) {
        }

        public void a(int i2, int i3, Object obj) {
            a(i2, i3);
        }

        public void b() {
        }

        public void b(int i2, int i3) {
        }

        public void c(int i2, int i3) {
        }
    }

    public interface c {
        int a(int i2, int i3);
    }

    public static class d {
        /* access modifiers changed from: protected */
        public EdgeEffect a(RecyclerView recyclerView, int i2) {
            return new EdgeEffect(recyclerView.getContext());
        }
    }

    public static abstract class e {

        /* renamed from: a  reason: collision with root package name */
        private b f3950a = null;

        /* renamed from: b  reason: collision with root package name */
        private ArrayList<a> f3951b = new ArrayList<>();

        /* renamed from: c  reason: collision with root package name */
        private long f3952c = 120;

        /* renamed from: d  reason: collision with root package name */
        private long f3953d = 120;

        /* renamed from: e  reason: collision with root package name */
        private long f3954e = 250;

        /* renamed from: f  reason: collision with root package name */
        private long f3955f = 250;

        public interface a {
            void a();
        }

        interface b {
            void a(v vVar);
        }

        public static class c {

            /* renamed from: a  reason: collision with root package name */
            public int f3956a;

            /* renamed from: b  reason: collision with root package name */
            public int f3957b;

            /* renamed from: c  reason: collision with root package name */
            public int f3958c;

            /* renamed from: d  reason: collision with root package name */
            public int f3959d;

            public c a(v vVar) {
                return a(vVar, 0);
            }

            public c a(v vVar, int i2) {
                View view = vVar.itemView;
                this.f3956a = view.getLeft();
                this.f3957b = view.getTop();
                this.f3958c = view.getRight();
                this.f3959d = view.getBottom();
                return this;
            }
        }

        static int e(v vVar) {
            int i2 = vVar.mFlags & 14;
            if (vVar.isInvalid()) {
                return 4;
            }
            if ((i2 & 4) != 0) {
                return i2;
            }
            int oldPosition = vVar.getOldPosition();
            int absoluteAdapterPosition = vVar.getAbsoluteAdapterPosition();
            return (oldPosition == -1 || absoluteAdapterPosition == -1 || oldPosition == absoluteAdapterPosition) ? i2 : i2 | 2048;
        }

        public c a(s sVar, v vVar) {
            return j().a(vVar);
        }

        public c a(s sVar, v vVar, int i2, List<Object> list) {
            return j().a(vVar);
        }

        public abstract void a();

        /* access modifiers changed from: package-private */
        public void a(b bVar) {
            this.f3950a = bVar;
        }

        public final boolean a(a aVar) {
            boolean b2 = b();
            if (aVar != null) {
                if (!b2) {
                    aVar.a();
                } else {
                    this.f3951b.add(aVar);
                }
            }
            return b2;
        }

        public abstract boolean a(v vVar, c cVar, c cVar2);

        public abstract boolean a(v vVar, v vVar2, c cVar, c cVar2);

        public boolean a(v vVar, List<Object> list) {
            return h(vVar);
        }

        public abstract boolean b();

        public abstract boolean b(v vVar, c cVar, c cVar2);

        public abstract boolean c(v vVar, c cVar, c cVar2);

        public abstract void d();

        public abstract void d(v vVar);

        public long e() {
            return this.f3954e;
        }

        public long f() {
            return this.f3952c;
        }

        public final void f(v vVar) {
            g(vVar);
            b bVar = this.f3950a;
            if (bVar != null) {
                bVar.a(vVar);
            }
        }

        public long g() {
            return this.f3953d;
        }

        public void g(v vVar) {
        }

        public long h() {
            return this.f3955f;
        }

        public boolean h(v vVar) {
            return true;
        }

        public final void i() {
            int size = this.f3951b.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f3951b.get(i2).a();
            }
            this.f3951b.clear();
        }

        public c j() {
            return new c();
        }
    }

    private class f implements e.b {
        f() {
        }

        public void a(v vVar) {
            vVar.setIsRecyclable(true);
            if (vVar.mShadowedHolder != null && vVar.mShadowingHolder == null) {
                vVar.mShadowedHolder = null;
            }
            vVar.mShadowingHolder = null;
            if (!vVar.shouldBeKeptAsChild() && !RecyclerView.this.a(vVar.itemView) && vVar.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(vVar.itemView, false);
            }
        }
    }

    public static abstract class g {
        @Deprecated
        public void getItemOffsets(Rect rect, int i2, RecyclerView recyclerView) {
            rect.set(0, 0, 0, 0);
        }

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, s sVar) {
            getItemOffsets(rect, ((LayoutParams) view.getLayoutParams()).f(), recyclerView);
        }

        @Deprecated
        public void onDraw(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDraw(Canvas canvas, RecyclerView recyclerView, s sVar) {
            onDraw(canvas, recyclerView);
        }

        @Deprecated
        public void onDrawOver(Canvas canvas, RecyclerView recyclerView) {
        }

        public void onDrawOver(Canvas canvas, RecyclerView recyclerView, s sVar) {
            onDrawOver(canvas, recyclerView);
        }
    }

    public static abstract class h {

        /* renamed from: a  reason: collision with root package name */
        private final y.b f3961a;

        /* renamed from: b  reason: collision with root package name */
        private final y.b f3962b;

        /* renamed from: c  reason: collision with root package name */
        private boolean f3963c = true;

        /* renamed from: d  reason: collision with root package name */
        private boolean f3964d = true;

        /* renamed from: e  reason: collision with root package name */
        private int f3965e;

        /* renamed from: f  reason: collision with root package name */
        private int f3966f;

        /* renamed from: g  reason: collision with root package name */
        private int f3967g;

        /* renamed from: h  reason: collision with root package name */
        private int f3968h;

        /* renamed from: p  reason: collision with root package name */
        d f3969p;

        /* renamed from: q  reason: collision with root package name */
        RecyclerView f3970q;

        /* renamed from: r  reason: collision with root package name */
        y f3971r;

        /* renamed from: s  reason: collision with root package name */
        y f3972s;

        /* renamed from: t  reason: collision with root package name */
        r f3973t;

        /* renamed from: u  reason: collision with root package name */
        boolean f3974u = false;

        /* renamed from: v  reason: collision with root package name */
        boolean f3975v = false;

        /* renamed from: w  reason: collision with root package name */
        boolean f3976w = false;

        /* renamed from: x  reason: collision with root package name */
        int f3977x;

        /* renamed from: y  reason: collision with root package name */
        boolean f3978y;

        public interface a {
            void b(int i2, int i3);
        }

        public static class b {

            /* renamed from: a  reason: collision with root package name */
            public int f3981a;

            /* renamed from: b  reason: collision with root package name */
            public int f3982b;

            /* renamed from: c  reason: collision with root package name */
            public boolean f3983c;

            /* renamed from: d  reason: collision with root package name */
            public boolean f3984d;
        }

        public h() {
            AnonymousClass1 r0 = new y.b() {
                public int a() {
                    return h.this.E();
                }

                public int a(View view) {
                    return h.this.h(view) - ((LayoutParams) view.getLayoutParams()).leftMargin;
                }

                public View a(int i2) {
                    return h.this.i(i2);
                }

                public int b() {
                    return h.this.C() - h.this.G();
                }

                public int b(View view) {
                    return h.this.j(view) + ((LayoutParams) view.getLayoutParams()).rightMargin;
                }
            };
            this.f3961a = r0;
            AnonymousClass2 r1 = new y.b() {
                public int a() {
                    return h.this.F();
                }

                public int a(View view) {
                    return h.this.i(view) - ((LayoutParams) view.getLayoutParams()).topMargin;
                }

                public View a(int i2) {
                    return h.this.i(i2);
                }

                public int b() {
                    return h.this.D() - h.this.H();
                }

                public int b(View view) {
                    return h.this.k(view) + ((LayoutParams) view.getLayoutParams()).bottomMargin;
                }
            };
            this.f3962b = r1;
            this.f3971r = new y(r0);
            this.f3972s = new y(r1);
        }

        public static int a(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i2);
            int size = View.MeasureSpec.getSize(i2);
            return mode != Integer.MIN_VALUE ? mode != 1073741824 ? Math.max(i3, i4) : size : Math.min(size, Math.max(i3, i4));
        }

        /* JADX WARNING: Code restructure failed: missing block: B:6:0x0017, code lost:
            if (r5 == 1073741824) goto L_0x0021;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public static int a(int r4, int r5, int r6, int r7, boolean r8) {
            /*
                int r4 = r4 - r6
                r6 = 0
                int r4 = java.lang.Math.max(r6, r4)
                r0 = -2
                r1 = -1
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = 1073741824(0x40000000, float:2.0)
                if (r8 == 0) goto L_0x001a
                if (r7 < 0) goto L_0x0011
                goto L_0x001c
            L_0x0011:
                if (r7 != r1) goto L_0x002f
                if (r5 == r2) goto L_0x0021
                if (r5 == 0) goto L_0x002f
                if (r5 == r3) goto L_0x0021
                goto L_0x002f
            L_0x001a:
                if (r7 < 0) goto L_0x001f
            L_0x001c:
                r5 = 1073741824(0x40000000, float:2.0)
                goto L_0x0031
            L_0x001f:
                if (r7 != r1) goto L_0x0023
            L_0x0021:
                r7 = r4
                goto L_0x0031
            L_0x0023:
                if (r7 != r0) goto L_0x002f
                if (r5 == r2) goto L_0x002c
                if (r5 != r3) goto L_0x002a
                goto L_0x002c
            L_0x002a:
                r5 = 0
                goto L_0x0021
            L_0x002c:
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                goto L_0x0021
            L_0x002f:
                r5 = 0
                r7 = 0
            L_0x0031:
                int r4 = android.view.View.MeasureSpec.makeMeasureSpec(r7, r5)
                return r4
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.h.a(int, int, int, int, boolean):int");
        }

        public static b a(Context context, AttributeSet attributeSet, int i2, int i3) {
            b bVar = new b();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i2, i3);
            bVar.f3981a = obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_orientation, 1);
            bVar.f3982b = obtainStyledAttributes.getInt(R.styleable.RecyclerView_spanCount, 1);
            bVar.f3983c = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_reverseLayout, false);
            bVar.f3984d = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_stackFromEnd, false);
            obtainStyledAttributes.recycle();
            return bVar;
        }

        private void a(int i2, View view) {
            this.f3969p.e(i2);
        }

        private void a(View view, int i2, boolean z2) {
            v e2 = RecyclerView.e(view);
            if (z2 || e2.isRemoved()) {
                this.f3970q.f3917i.e(e2);
            } else {
                this.f3970q.f3917i.f(e2);
            }
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            if (e2.wasReturnedFromScrap() || e2.isScrap()) {
                if (e2.isScrap()) {
                    e2.unScrap();
                } else {
                    e2.clearReturnedFromScrapFlag();
                }
                this.f3969p.a(view, i2, view.getLayoutParams(), false);
            } else if (view.getParent() == this.f3970q) {
                int b2 = this.f3969p.b(view);
                if (i2 == -1) {
                    i2 = this.f3969p.b();
                }
                if (b2 == -1) {
                    throw new IllegalStateException("Added View has RecyclerView as parent but view is not a real child. Unfiltered index:" + this.f3970q.indexOfChild(view) + this.f3970q.a());
                } else if (b2 != i2) {
                    this.f3970q.f3923o.f(b2, i2);
                }
            } else {
                this.f3969p.a(view, i2, false);
                layoutParams.f3947e = true;
                r rVar = this.f3973t;
                if (rVar != null && rVar.h()) {
                    this.f3973t.b(view);
                }
            }
            if (layoutParams.f3948f) {
                e2.itemView.invalidate();
                layoutParams.f3948f = false;
            }
        }

        private void a(n nVar, int i2, View view) {
            v e2 = RecyclerView.e(view);
            if (!e2.shouldIgnore()) {
                if (!e2.isInvalid() || e2.isRemoved() || this.f3970q.f3922n.hasStableIds()) {
                    h(i2);
                    nVar.c(view);
                    this.f3970q.f3917i.h(e2);
                    return;
                }
                g(i2);
                nVar.b(e2);
            }
        }

        private static boolean b(int i2, int i3, int i4) {
            int mode = View.MeasureSpec.getMode(i3);
            int size = View.MeasureSpec.getSize(i3);
            if (i4 > 0 && i2 != i4) {
                return false;
            }
            if (mode == Integer.MIN_VALUE) {
                return size >= i2;
            }
            if (mode != 0) {
                return mode == 1073741824 && size == i2;
            }
            return true;
        }

        private int[] c(View view, Rect rect) {
            int[] iArr = new int[2];
            int E = E();
            int F = F();
            int C = C() - G();
            int D = D() - H();
            int left = (view.getLeft() + rect.left) - view.getScrollX();
            int top = (view.getTop() + rect.top) - view.getScrollY();
            int width = rect.width() + left;
            int height = rect.height() + top;
            int i2 = left - E;
            int min = Math.min(0, i2);
            int i3 = top - F;
            int min2 = Math.min(0, i3);
            int i4 = width - C;
            int max = Math.max(0, i4);
            int max2 = Math.max(0, height - D);
            if (x() != 1) {
                if (min == 0) {
                    min = Math.min(i2, max);
                }
                max = min;
            } else if (max == 0) {
                max = Math.max(min, i4);
            }
            if (min2 == 0) {
                min2 = Math.min(i3, max2);
            }
            iArr[0] = max;
            iArr[1] = min2;
            return iArr;
        }

        private boolean d(RecyclerView recyclerView, int i2, int i3) {
            View focusedChild = recyclerView.getFocusedChild();
            if (focusedChild == null) {
                return false;
            }
            int E = E();
            int F = F();
            int C = C() - G();
            int D = D() - H();
            Rect rect = this.f3970q.f3920l;
            a(focusedChild, rect);
            return rect.left - i2 < C && rect.right - i2 > E && rect.top - i3 < D && rect.bottom - i3 > F;
        }

        public int A() {
            return this.f3965e;
        }

        public int B() {
            return this.f3966f;
        }

        public int C() {
            return this.f3967g;
        }

        public int D() {
            return this.f3968h;
        }

        public int E() {
            RecyclerView recyclerView = this.f3970q;
            if (recyclerView != null) {
                return recyclerView.getPaddingLeft();
            }
            return 0;
        }

        public int F() {
            RecyclerView recyclerView = this.f3970q;
            if (recyclerView != null) {
                return recyclerView.getPaddingTop();
            }
            return 0;
        }

        public int G() {
            RecyclerView recyclerView = this.f3970q;
            if (recyclerView != null) {
                return recyclerView.getPaddingRight();
            }
            return 0;
        }

        public int H() {
            RecyclerView recyclerView = this.f3970q;
            if (recyclerView != null) {
                return recyclerView.getPaddingBottom();
            }
            return 0;
        }

        public View I() {
            View focusedChild;
            RecyclerView recyclerView = this.f3970q;
            if (recyclerView == null || (focusedChild = recyclerView.getFocusedChild()) == null || this.f3969p.c(focusedChild)) {
                return null;
            }
            return focusedChild;
        }

        public int J() {
            RecyclerView recyclerView = this.f3970q;
            Adapter adapter = recyclerView != null ? recyclerView.getAdapter() : null;
            if (adapter != null) {
                return adapter.getItemCount();
            }
            return 0;
        }

        public int K() {
            return ac.p(this.f3970q);
        }

        public int L() {
            return ac.q(this.f3970q);
        }

        /* access modifiers changed from: package-private */
        public void M() {
            r rVar = this.f3973t;
            if (rVar != null) {
                rVar.f();
            }
        }

        public void N() {
            this.f3974u = true;
        }

        /* access modifiers changed from: package-private */
        public boolean O() {
            int z2 = z();
            for (int i2 = 0; i2 < z2; i2++) {
                ViewGroup.LayoutParams layoutParams = i(i2).getLayoutParams();
                if (layoutParams.width < 0 && layoutParams.height < 0) {
                    return true;
                }
            }
            return false;
        }

        public int a(int i2, n nVar, s sVar) {
            return 0;
        }

        public int a(n nVar, s sVar) {
            return -1;
        }

        public View a(View view, int i2, n nVar, s sVar) {
            return null;
        }

        public abstract LayoutParams a();

        public LayoutParams a(Context context, AttributeSet attributeSet) {
            return new LayoutParams(context, attributeSet);
        }

        public LayoutParams a(ViewGroup.LayoutParams layoutParams) {
            return layoutParams instanceof LayoutParams ? new LayoutParams((LayoutParams) layoutParams) : layoutParams instanceof ViewGroup.MarginLayoutParams ? new LayoutParams((ViewGroup.MarginLayoutParams) layoutParams) : new LayoutParams(layoutParams);
        }

        public void a(int i2, int i3, s sVar, a aVar) {
        }

        public void a(int i2, a aVar) {
        }

        public void a(int i2, n nVar) {
            View i3 = i(i2);
            g(i2);
            nVar.a(i3);
        }

        public void a(Rect rect, int i2, int i3) {
            g(a(i2, rect.width() + E() + G(), K()), a(i3, rect.height() + F() + H(), L()));
        }

        public void a(Parcelable parcelable) {
        }

        public void a(View view) {
            a(view, -1);
        }

        public void a(View view, int i2) {
            a(view, i2, true);
        }

        public void a(View view, int i2, int i3) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect j2 = this.f3970q.j(view);
            int i4 = i2 + j2.left + j2.right;
            int i5 = i3 + j2.top + j2.bottom;
            int a2 = a(C(), A(), E() + G() + layoutParams.leftMargin + layoutParams.rightMargin + i4, layoutParams.width, f());
            int a3 = a(D(), B(), F() + H() + layoutParams.topMargin + layoutParams.bottomMargin + i5, layoutParams.height, g());
            if (b(view, a2, a3, layoutParams)) {
                view.measure(a2, a3);
            }
        }

        public void a(View view, int i2, int i3, int i4, int i5) {
            LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
            Rect rect = layoutParams.f3946d;
            view.layout(i2 + rect.left + layoutParams.leftMargin, i3 + rect.top + layoutParams.topMargin, (i4 - rect.right) - layoutParams.rightMargin, (i5 - rect.bottom) - layoutParams.bottomMargin);
        }

        public void a(View view, int i2, LayoutParams layoutParams) {
            v e2 = RecyclerView.e(view);
            if (e2.isRemoved()) {
                this.f3970q.f3917i.e(e2);
            } else {
                this.f3970q.f3917i.f(e2);
            }
            this.f3969p.a(view, i2, layoutParams, e2.isRemoved());
        }

        public void a(View view, Rect rect) {
            RecyclerView.b(view, rect);
        }

        public void a(View view, n nVar) {
            c(view);
            nVar.a(view);
        }

        /* access modifiers changed from: package-private */
        public void a(View view, u.c cVar) {
            v e2 = RecyclerView.e(view);
            if (e2 != null && !e2.isRemoved() && !this.f3969p.c(e2.itemView)) {
                a(this.f3970q.f3913e, this.f3970q.F, view, cVar);
            }
        }

        public void a(View view, boolean z2, Rect rect) {
            Matrix matrix;
            if (z2) {
                Rect rect2 = ((LayoutParams) view.getLayoutParams()).f3946d;
                rect.set(-rect2.left, -rect2.top, view.getWidth() + rect2.right, view.getHeight() + rect2.bottom);
            } else {
                rect.set(0, 0, view.getWidth(), view.getHeight());
            }
            if (!(this.f3970q == null || (matrix = view.getMatrix()) == null || matrix.isIdentity())) {
                RectF rectF = this.f3970q.f3921m;
                rectF.set(rect);
                matrix.mapRect(rectF);
                rect.set((int) Math.floor((double) rectF.left), (int) Math.floor((double) rectF.top), (int) Math.ceil((double) rectF.right), (int) Math.ceil((double) rectF.bottom));
            }
            rect.offset(view.getLeft(), view.getTop());
        }

        public void a(AccessibilityEvent accessibilityEvent) {
            a(this.f3970q.f3913e, this.f3970q.F, accessibilityEvent);
        }

        public void a(Adapter adapter, Adapter adapter2) {
        }

        public void a(n nVar) {
            for (int z2 = z() - 1; z2 >= 0; z2--) {
                a(nVar, z2, i(z2));
            }
        }

        public void a(n nVar, s sVar, int i2, int i3) {
            this.f3970q.e(i2, i3);
        }

        public void a(n nVar, s sVar, View view, u.c cVar) {
        }

        public void a(n nVar, s sVar, AccessibilityEvent accessibilityEvent) {
            RecyclerView recyclerView = this.f3970q;
            if (recyclerView != null && accessibilityEvent != null) {
                boolean z2 = true;
                if (!recyclerView.canScrollVertically(1) && !this.f3970q.canScrollVertically(-1) && !this.f3970q.canScrollHorizontally(-1) && !this.f3970q.canScrollHorizontally(1)) {
                    z2 = false;
                }
                accessibilityEvent.setScrollable(z2);
                if (this.f3970q.f3922n != null) {
                    accessibilityEvent.setItemCount(this.f3970q.f3922n.getItemCount());
                }
            }
        }

        public void a(n nVar, s sVar, u.c cVar) {
            if (this.f3970q.canScrollVertically(-1) || this.f3970q.canScrollHorizontally(-1)) {
                cVar.a(8192);
                cVar.k(true);
            }
            if (this.f3970q.canScrollVertically(1) || this.f3970q.canScrollHorizontally(1)) {
                cVar.a(4096);
                cVar.k(true);
            }
            cVar.a((Object) c.b.a(a(nVar, sVar), b(nVar, sVar), e(nVar, sVar), d(nVar, sVar)));
        }

        public void a(r rVar) {
            r rVar2 = this.f3973t;
            if (!(rVar2 == null || rVar == rVar2 || !rVar2.h())) {
                this.f3973t.f();
            }
            this.f3973t = rVar;
            rVar.a(this.f3970q, this);
        }

        public void a(s sVar) {
        }

        public void a(RecyclerView recyclerView) {
        }

        public void a(RecyclerView recyclerView, int i2, int i3) {
        }

        public void a(RecyclerView recyclerView, int i2, int i3, int i4) {
        }

        public void a(RecyclerView recyclerView, int i2, int i3, Object obj) {
            c(recyclerView, i2, i3);
        }

        public void a(RecyclerView recyclerView, n nVar) {
            e(recyclerView);
        }

        public void a(RecyclerView recyclerView, s sVar, int i2) {
            Log.e("RecyclerView", "You must override smoothScrollToPosition to support smooth scrolling");
        }

        public void a(String str) {
            RecyclerView recyclerView = this.f3970q;
            if (recyclerView != null) {
                recyclerView.a(str);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(u.c cVar) {
            a(this.f3970q.f3913e, this.f3970q.F, cVar);
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i2, Bundle bundle) {
            return a(this.f3970q.f3913e, this.f3970q.F, i2, bundle);
        }

        /* access modifiers changed from: package-private */
        public boolean a(View view, int i2, int i3, LayoutParams layoutParams) {
            return !this.f3963c || !b(view.getMeasuredWidth(), i2, layoutParams.width) || !b(view.getMeasuredHeight(), i3, layoutParams.height);
        }

        /* access modifiers changed from: package-private */
        public boolean a(View view, int i2, Bundle bundle) {
            return a(this.f3970q.f3913e, this.f3970q.F, view, i2, bundle);
        }

        public boolean a(View view, boolean z2, boolean z3) {
            boolean z4 = this.f3971r.a(view, 24579) && this.f3972s.a(view, 24579);
            return z2 ? z4 : !z4;
        }

        public boolean a(LayoutParams layoutParams) {
            return layoutParams != null;
        }

        /* JADX WARNING: Removed duplicated region for block: B:25:0x0075 A[ADDED_TO_REGION] */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean a(androidx.recyclerview.widget.RecyclerView.n r8, androidx.recyclerview.widget.RecyclerView.s r9, int r10, android.os.Bundle r11) {
            /*
                r7 = this;
                androidx.recyclerview.widget.RecyclerView r8 = r7.f3970q
                r9 = 0
                if (r8 != 0) goto L_0x0006
                return r9
            L_0x0006:
                r11 = 4096(0x1000, float:5.74E-42)
                r0 = 1
                if (r10 == r11) goto L_0x0042
                r11 = 8192(0x2000, float:1.14794E-41)
                if (r10 == r11) goto L_0x0012
                r2 = 0
                r3 = 0
                goto L_0x0073
            L_0x0012:
                r10 = -1
                boolean r8 = r8.canScrollVertically(r10)
                if (r8 == 0) goto L_0x0029
                int r8 = r7.D()
                int r11 = r7.F()
                int r8 = r8 - r11
                int r11 = r7.H()
                int r8 = r8 - r11
                int r8 = -r8
                goto L_0x002a
            L_0x0029:
                r8 = 0
            L_0x002a:
                androidx.recyclerview.widget.RecyclerView r11 = r7.f3970q
                boolean r10 = r11.canScrollHorizontally(r10)
                if (r10 == 0) goto L_0x0071
                int r10 = r7.C()
                int r11 = r7.E()
                int r10 = r10 - r11
                int r11 = r7.G()
                int r10 = r10 - r11
                int r10 = -r10
                goto L_0x006e
            L_0x0042:
                boolean r8 = r8.canScrollVertically(r0)
                if (r8 == 0) goto L_0x0057
                int r8 = r7.D()
                int r10 = r7.F()
                int r8 = r8 - r10
                int r10 = r7.H()
                int r8 = r8 - r10
                goto L_0x0058
            L_0x0057:
                r8 = 0
            L_0x0058:
                androidx.recyclerview.widget.RecyclerView r10 = r7.f3970q
                boolean r10 = r10.canScrollHorizontally(r0)
                if (r10 == 0) goto L_0x0071
                int r10 = r7.C()
                int r11 = r7.E()
                int r10 = r10 - r11
                int r11 = r7.G()
                int r10 = r10 - r11
            L_0x006e:
                r3 = r8
                r2 = r10
                goto L_0x0073
            L_0x0071:
                r3 = r8
                r2 = 0
            L_0x0073:
                if (r3 != 0) goto L_0x0078
                if (r2 != 0) goto L_0x0078
                return r9
            L_0x0078:
                androidx.recyclerview.widget.RecyclerView r1 = r7.f3970q
                r4 = 0
                r5 = -2147483648(0xffffffff80000000, float:-0.0)
                r6 = 1
                r1.a((int) r2, (int) r3, (android.view.animation.Interpolator) r4, (int) r5, (boolean) r6)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.h.a(androidx.recyclerview.widget.RecyclerView$n, androidx.recyclerview.widget.RecyclerView$s, int, android.os.Bundle):boolean");
        }

        public boolean a(n nVar, s sVar, View view, int i2, Bundle bundle) {
            return false;
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z2) {
            return a(recyclerView, view, rect, z2, false);
        }

        public boolean a(RecyclerView recyclerView, View view, Rect rect, boolean z2, boolean z3) {
            int[] c2 = c(view, rect);
            int i2 = c2[0];
            int i3 = c2[1];
            if ((z3 && !d(recyclerView, i2, i3)) || (i2 == 0 && i3 == 0)) {
                return false;
            }
            if (z2) {
                recyclerView.scrollBy(i2, i3);
            } else {
                recyclerView.a(i2, i3);
            }
            return true;
        }

        @Deprecated
        public boolean a(RecyclerView recyclerView, View view, View view2) {
            return w() || recyclerView.o();
        }

        public boolean a(RecyclerView recyclerView, s sVar, View view, View view2) {
            return a(recyclerView, view, view2);
        }

        public boolean a(RecyclerView recyclerView, ArrayList<View> arrayList, int i2, int i3) {
            return false;
        }

        public boolean a(Runnable runnable) {
            RecyclerView recyclerView = this.f3970q;
            if (recyclerView != null) {
                return recyclerView.removeCallbacks(runnable);
            }
            return false;
        }

        public int b(int i2, n nVar, s sVar) {
            return 0;
        }

        public int b(n nVar, s sVar) {
            return -1;
        }

        public int b(s sVar) {
            return 0;
        }

        public void b(View view) {
            b(view, -1);
        }

        public void b(View view, int i2) {
            a(view, i2, false);
        }

        public void b(View view, Rect rect) {
            RecyclerView recyclerView = this.f3970q;
            if (recyclerView == null) {
                rect.set(0, 0, 0, 0);
            } else {
                rect.set(recyclerView.j(view));
            }
        }

        /* access modifiers changed from: package-private */
        public void b(n nVar) {
            int e2 = nVar.e();
            for (int i2 = e2 - 1; i2 >= 0; i2--) {
                View e3 = nVar.e(i2);
                v e4 = RecyclerView.e(e3);
                if (!e4.shouldIgnore()) {
                    e4.setIsRecyclable(false);
                    if (e4.isTmpDetached()) {
                        this.f3970q.removeDetachedView(e3, false);
                    }
                    if (this.f3970q.B != null) {
                        this.f3970q.B.d(e4);
                    }
                    e4.setIsRecyclable(true);
                    nVar.b(e3);
                }
            }
            nVar.f();
            if (e2 > 0) {
                this.f3970q.invalidate();
            }
        }

        /* access modifiers changed from: package-private */
        public void b(r rVar) {
            if (this.f3973t == rVar) {
                this.f3973t = null;
            }
        }

        /* access modifiers changed from: package-private */
        public void b(RecyclerView recyclerView) {
            int i2;
            if (recyclerView == null) {
                this.f3970q = null;
                this.f3969p = null;
                i2 = 0;
                this.f3967g = 0;
            } else {
                this.f3970q = recyclerView;
                this.f3969p = recyclerView.f3916h;
                this.f3967g = recyclerView.getWidth();
                i2 = recyclerView.getHeight();
            }
            this.f3968h = i2;
            this.f3965e = MemoryConstants.GB;
            this.f3966f = MemoryConstants.GB;
        }

        public void b(RecyclerView recyclerView, int i2, int i3) {
        }

        /* access modifiers changed from: package-private */
        public void b(RecyclerView recyclerView, n nVar) {
            this.f3975v = false;
            a(recyclerView, nVar);
        }

        /* access modifiers changed from: package-private */
        public boolean b(View view, int i2, int i3, LayoutParams layoutParams) {
            return view.isLayoutRequested() || !this.f3963c || !b(view.getWidth(), i2, layoutParams.width) || !b(view.getHeight(), i3, layoutParams.height);
        }

        public int c(s sVar) {
            return 0;
        }

        public View c(int i2) {
            int z2 = z();
            for (int i3 = 0; i3 < z2; i3++) {
                View i4 = i(i3);
                v e2 = RecyclerView.e(i4);
                if (e2 != null && e2.getLayoutPosition() == i2 && !e2.shouldIgnore() && (this.f3970q.F.a() || !e2.isRemoved())) {
                    return i4;
                }
            }
            return null;
        }

        public void c(View view) {
            this.f3969p.a(view);
        }

        public void c(View view, int i2) {
            a(view, i2, (LayoutParams) view.getLayoutParams());
        }

        public void c(n nVar) {
            for (int z2 = z() - 1; z2 >= 0; z2--) {
                if (!RecyclerView.e(i(z2)).shouldIgnore()) {
                    a(z2, nVar);
                }
            }
        }

        public void c(n nVar, s sVar) {
            Log.e("RecyclerView", "You must override onLayoutChildren(Recycler recycler, State state) ");
        }

        /* access modifiers changed from: package-private */
        public void c(RecyclerView recyclerView) {
            this.f3975v = true;
            d(recyclerView);
        }

        public void c(RecyclerView recyclerView, int i2, int i3) {
        }

        public boolean c() {
            return false;
        }

        public int d(View view) {
            return ((LayoutParams) view.getLayoutParams()).f();
        }

        public int d(n nVar, s sVar) {
            return 0;
        }

        public int d(s sVar) {
            return 0;
        }

        public View d(View view, int i2) {
            return null;
        }

        /* access modifiers changed from: package-private */
        public void d(int i2, int i3) {
            this.f3967g = View.MeasureSpec.getSize(i2);
            int mode = View.MeasureSpec.getMode(i2);
            this.f3965e = mode;
            if (mode == 0 && !RecyclerView.f3884b) {
                this.f3967g = 0;
            }
            this.f3968h = View.MeasureSpec.getSize(i3);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.f3966f = mode2;
            if (mode2 == 0 && !RecyclerView.f3884b) {
                this.f3968h = 0;
            }
        }

        public void d(RecyclerView recyclerView) {
        }

        public boolean d() {
            return this.f3976w;
        }

        public int e(s sVar) {
            return 0;
        }

        public Parcelable e() {
            return null;
        }

        public View e(View view) {
            View c2;
            RecyclerView recyclerView = this.f3970q;
            if (recyclerView == null || (c2 = recyclerView.c(view)) == null || this.f3969p.c(c2)) {
                return null;
            }
            return c2;
        }

        public void e(int i2) {
        }

        /* access modifiers changed from: package-private */
        public void e(int i2, int i3) {
            int z2 = z();
            if (z2 == 0) {
                this.f3970q.e(i2, i3);
                return;
            }
            int i4 = Integer.MIN_VALUE;
            int i5 = Integer.MIN_VALUE;
            int i6 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            int i7 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
            for (int i8 = 0; i8 < z2; i8++) {
                View i9 = i(i8);
                Rect rect = this.f3970q.f3920l;
                a(i9, rect);
                if (rect.left < i6) {
                    i6 = rect.left;
                }
                if (rect.right > i4) {
                    i4 = rect.right;
                }
                if (rect.top < i7) {
                    i7 = rect.top;
                }
                if (rect.bottom > i5) {
                    i5 = rect.bottom;
                }
            }
            this.f3970q.f3920l.set(i6, i7, i4, i5);
            a(this.f3970q.f3920l, i2, i3);
        }

        @Deprecated
        public void e(RecyclerView recyclerView) {
        }

        public boolean e(n nVar, s sVar) {
            return false;
        }

        public int f(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f3946d;
            return view.getMeasuredWidth() + rect.left + rect.right;
        }

        public void f(int i2, int i3) {
            View i4 = i(i2);
            if (i4 != null) {
                h(i2);
                c(i4, i3);
                return;
            }
            throw new IllegalArgumentException("Cannot move a child from non-existing index:" + i2 + this.f3970q.toString());
        }

        /* access modifiers changed from: package-private */
        public void f(RecyclerView recyclerView) {
            d(View.MeasureSpec.makeMeasureSpec(recyclerView.getWidth(), MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(recyclerView.getHeight(), MemoryConstants.GB));
        }

        public boolean f() {
            return false;
        }

        public int g(View view) {
            Rect rect = ((LayoutParams) view.getLayoutParams()).f3946d;
            return view.getMeasuredHeight() + rect.top + rect.bottom;
        }

        public int g(s sVar) {
            return 0;
        }

        public void g(int i2) {
            if (i(i2) != null) {
                this.f3969p.a(i2);
            }
        }

        public void g(int i2, int i3) {
            this.f3970q.setMeasuredDimension(i2, i3);
        }

        public boolean g() {
            return false;
        }

        public int h(View view) {
            return view.getLeft() - n(view);
        }

        public int h(s sVar) {
            return 0;
        }

        public void h(int i2) {
            a(i2, i(i2));
        }

        public int i(View view) {
            return view.getTop() - l(view);
        }

        public View i(int i2) {
            d dVar = this.f3969p;
            if (dVar != null) {
                return dVar.b(i2);
            }
            return null;
        }

        public int j(View view) {
            return view.getRight() + o(view);
        }

        public void j(int i2) {
            RecyclerView recyclerView = this.f3970q;
            if (recyclerView != null) {
                recyclerView.g(i2);
            }
        }

        public int k(View view) {
            return view.getBottom() + m(view);
        }

        public void k(int i2) {
            RecyclerView recyclerView = this.f3970q;
            if (recyclerView != null) {
                recyclerView.f(i2);
            }
        }

        public int l(View view) {
            return ((LayoutParams) view.getLayoutParams()).f3946d.top;
        }

        public void l(int i2) {
        }

        public int m(View view) {
            return ((LayoutParams) view.getLayoutParams()).f3946d.bottom;
        }

        public int n(View view) {
            return ((LayoutParams) view.getLayoutParams()).f3946d.left;
        }

        /* access modifiers changed from: package-private */
        public boolean n() {
            return false;
        }

        public int o(View view) {
            return ((LayoutParams) view.getLayoutParams()).f3946d.right;
        }

        public void s() {
            RecyclerView recyclerView = this.f3970q;
            if (recyclerView != null) {
                recyclerView.requestLayout();
            }
        }

        public final boolean t() {
            return this.f3964d;
        }

        public boolean u() {
            return this.f3975v;
        }

        public boolean v() {
            RecyclerView recyclerView = this.f3970q;
            return recyclerView != null && recyclerView.f3918j;
        }

        public boolean w() {
            r rVar = this.f3973t;
            return rVar != null && rVar.h();
        }

        public int x() {
            return ac.i(this.f3970q);
        }

        public int y() {
            return -1;
        }

        public int z() {
            d dVar = this.f3969p;
            if (dVar != null) {
                return dVar.b();
            }
            return 0;
        }
    }

    public interface i {
        void a(View view);

        void b(View view);
    }

    public static abstract class j {
        public abstract boolean a(int i2, int i3);
    }

    public interface k {
        void a(boolean z2);

        boolean a(RecyclerView recyclerView, MotionEvent motionEvent);

        void b(RecyclerView recyclerView, MotionEvent motionEvent);
    }

    public static abstract class l {
        public void a(RecyclerView recyclerView, int i2) {
        }

        public void a(RecyclerView recyclerView, int i2, int i3) {
        }
    }

    public static class m {

        /* renamed from: a  reason: collision with root package name */
        SparseArray<a> f3985a = new SparseArray<>();

        /* renamed from: b  reason: collision with root package name */
        private int f3986b = 0;

        static class a {

            /* renamed from: a  reason: collision with root package name */
            final ArrayList<v> f3987a = new ArrayList<>();

            /* renamed from: b  reason: collision with root package name */
            int f3988b = 5;

            /* renamed from: c  reason: collision with root package name */
            long f3989c = 0;

            /* renamed from: d  reason: collision with root package name */
            long f3990d = 0;

            a() {
            }
        }

        private a b(int i2) {
            a aVar = this.f3985a.get(i2);
            if (aVar != null) {
                return aVar;
            }
            a aVar2 = new a();
            this.f3985a.put(i2, aVar2);
            return aVar2;
        }

        /* access modifiers changed from: package-private */
        public long a(long j2, long j3) {
            return j2 == 0 ? j3 : ((j2 / 4) * 3) + (j3 / 4);
        }

        public v a(int i2) {
            a aVar = this.f3985a.get(i2);
            if (aVar == null || aVar.f3987a.isEmpty()) {
                return null;
            }
            ArrayList<v> arrayList = aVar.f3987a;
            for (int size = arrayList.size() - 1; size >= 0; size--) {
                if (!arrayList.get(size).isAttachedToTransitionOverlay()) {
                    return arrayList.remove(size);
                }
            }
            return null;
        }

        public void a() {
            for (int i2 = 0; i2 < this.f3985a.size(); i2++) {
                this.f3985a.valueAt(i2).f3987a.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, long j2) {
            a b2 = b(i2);
            b2.f3989c = a(b2.f3989c, j2);
        }

        /* access modifiers changed from: package-private */
        public void a(Adapter adapter, Adapter adapter2, boolean z2) {
            if (adapter != null) {
                c();
            }
            if (!z2 && this.f3986b == 0) {
                a();
            }
            if (adapter2 != null) {
                b();
            }
        }

        public void a(v vVar) {
            int itemViewType = vVar.getItemViewType();
            ArrayList<v> arrayList = b(itemViewType).f3987a;
            if (this.f3985a.get(itemViewType).f3988b > arrayList.size()) {
                vVar.resetInternal();
                arrayList.add(vVar);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(int i2, long j2, long j3) {
            long j4 = b(i2).f3989c;
            return j4 == 0 || j2 + j4 < j3;
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f3986b++;
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, long j2) {
            a b2 = b(i2);
            b2.f3990d = a(b2.f3990d, j2);
        }

        /* access modifiers changed from: package-private */
        public boolean b(int i2, long j2, long j3) {
            long j4 = b(i2).f3990d;
            return j4 == 0 || j2 + j4 < j3;
        }

        /* access modifiers changed from: package-private */
        public void c() {
            this.f3986b--;
        }
    }

    public final class n {

        /* renamed from: a  reason: collision with root package name */
        final ArrayList<v> f3991a;

        /* renamed from: b  reason: collision with root package name */
        ArrayList<v> f3992b = null;

        /* renamed from: c  reason: collision with root package name */
        final ArrayList<v> f3993c = new ArrayList<>();

        /* renamed from: d  reason: collision with root package name */
        int f3994d;

        /* renamed from: e  reason: collision with root package name */
        m f3995e;

        /* renamed from: g  reason: collision with root package name */
        private final List<v> f3997g;

        /* renamed from: h  reason: collision with root package name */
        private int f3998h;

        /* renamed from: i  reason: collision with root package name */
        private t f3999i;

        public n() {
            ArrayList<v> arrayList = new ArrayList<>();
            this.f3991a = arrayList;
            this.f3997g = Collections.unmodifiableList(arrayList);
            this.f3998h = 2;
            this.f3994d = 2;
        }

        private void a(ViewGroup viewGroup, boolean z2) {
            for (int childCount = viewGroup.getChildCount() - 1; childCount >= 0; childCount--) {
                View childAt = viewGroup.getChildAt(childCount);
                if (childAt instanceof ViewGroup) {
                    a((ViewGroup) childAt, true);
                }
            }
            if (z2) {
                if (viewGroup.getVisibility() == 4) {
                    viewGroup.setVisibility(0);
                    viewGroup.setVisibility(4);
                    return;
                }
                int visibility = viewGroup.getVisibility();
                viewGroup.setVisibility(4);
                viewGroup.setVisibility(visibility);
            }
        }

        private boolean a(v vVar, int i2, int i3, long j2) {
            vVar.mBindingAdapter = null;
            vVar.mOwnerRecyclerView = RecyclerView.this;
            int itemViewType = vVar.getItemViewType();
            long nanoTime = RecyclerView.this.getNanoTime();
            if (j2 != Long.MAX_VALUE && !this.f3995e.b(itemViewType, nanoTime, j2)) {
                return false;
            }
            RecyclerView.this.f3922n.bindViewHolder(vVar, i2);
            this.f3995e.b(vVar.getItemViewType(), RecyclerView.this.getNanoTime() - nanoTime);
            e(vVar);
            if (!RecyclerView.this.F.a()) {
                return true;
            }
            vVar.mPreLayoutPosition = i3;
            return true;
        }

        private void e(v vVar) {
            if (RecyclerView.this.n()) {
                View view = vVar.itemView;
                if (ac.f(view) == 0) {
                    ac.b(view, 1);
                }
                if (RecyclerView.this.J != null) {
                    t.a c2 = RecyclerView.this.J.c();
                    if (c2 instanceof u.a) {
                        ((u.a) c2).c(view);
                    }
                    ac.a(view, c2);
                }
            }
        }

        private void f(v vVar) {
            if (vVar.itemView instanceof ViewGroup) {
                a((ViewGroup) vVar.itemView, false);
            }
        }

        /* access modifiers changed from: package-private */
        public View a(int i2, boolean z2) {
            return a(i2, z2, Long.MAX_VALUE).itemView;
        }

        /* access modifiers changed from: package-private */
        /* JADX WARNING: Removed duplicated region for block: B:16:0x0037  */
        /* JADX WARNING: Removed duplicated region for block: B:25:0x005c  */
        /* JADX WARNING: Removed duplicated region for block: B:27:0x005f  */
        /* JADX WARNING: Removed duplicated region for block: B:79:0x01a4  */
        /* JADX WARNING: Removed duplicated region for block: B:84:0x01cf  */
        /* JADX WARNING: Removed duplicated region for block: B:85:0x01d2  */
        /* JADX WARNING: Removed duplicated region for block: B:95:0x0202  */
        /* JADX WARNING: Removed duplicated region for block: B:97:0x0210  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public androidx.recyclerview.widget.RecyclerView.v a(int r17, boolean r18, long r19) {
            /*
                r16 = this;
                r6 = r16
                r3 = r17
                r0 = r18
                if (r3 < 0) goto L_0x022c
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r1 = r1.F
                int r1 = r1.e()
                if (r3 >= r1) goto L_0x022c
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r1 = r1.F
                boolean r1 = r1.a()
                r2 = 0
                r7 = 1
                r8 = 0
                if (r1 == 0) goto L_0x0027
                androidx.recyclerview.widget.RecyclerView$v r1 = r16.f((int) r17)
                if (r1 == 0) goto L_0x0028
                r4 = 1
                goto L_0x0029
            L_0x0027:
                r1 = r2
            L_0x0028:
                r4 = 0
            L_0x0029:
                if (r1 != 0) goto L_0x005d
                androidx.recyclerview.widget.RecyclerView$v r1 = r16.b((int) r17, (boolean) r18)
                if (r1 == 0) goto L_0x005d
                boolean r5 = r6.a((androidx.recyclerview.widget.RecyclerView.v) r1)
                if (r5 != 0) goto L_0x005c
                if (r0 != 0) goto L_0x005a
                r5 = 4
                r1.addFlags(r5)
                boolean r5 = r1.isScrap()
                if (r5 == 0) goto L_0x004e
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                android.view.View r9 = r1.itemView
                r5.removeDetachedView(r9, r8)
                r1.unScrap()
                goto L_0x0057
            L_0x004e:
                boolean r5 = r1.wasReturnedFromScrap()
                if (r5 == 0) goto L_0x0057
                r1.clearReturnedFromScrapFlag()
            L_0x0057:
                r6.b((androidx.recyclerview.widget.RecyclerView.v) r1)
            L_0x005a:
                r1 = r2
                goto L_0x005d
            L_0x005c:
                r4 = 1
            L_0x005d:
                if (r1 != 0) goto L_0x0183
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r5 = r5.f3915g
                int r5 = r5.b((int) r3)
                if (r5 < 0) goto L_0x014b
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r9 = r9.f3922n
                int r9 = r9.getItemCount()
                if (r5 >= r9) goto L_0x014b
                androidx.recyclerview.widget.RecyclerView r9 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r9 = r9.f3922n
                int r9 = r9.getItemViewType(r5)
                androidx.recyclerview.widget.RecyclerView r10 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r10 = r10.f3922n
                boolean r10 = r10.hasStableIds()
                if (r10 == 0) goto L_0x0096
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r1 = r1.f3922n
                long r10 = r1.getItemId(r5)
                androidx.recyclerview.widget.RecyclerView$v r1 = r6.a((long) r10, (int) r9, (boolean) r0)
                if (r1 == 0) goto L_0x0096
                r1.mPosition = r5
                r4 = 1
            L_0x0096:
                if (r1 != 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView$t r0 = r6.f3999i
                if (r0 == 0) goto L_0x00eb
                android.view.View r0 = r0.a(r6, r3, r9)
                if (r0 == 0) goto L_0x00eb
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$v r1 = r1.b((android.view.View) r0)
                if (r1 == 0) goto L_0x00ce
                boolean r0 = r1.shouldIgnore()
                if (r0 != 0) goto L_0x00b1
                goto L_0x00eb
            L_0x00b1:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view that is ignored. You must call stopIgnoring before returning this view."
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.a()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00ce:
                java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "getViewForPositionAndType returned a view which does not have a ViewHolder"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.a()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x00eb:
                if (r1 != 0) goto L_0x0102
                androidx.recyclerview.widget.RecyclerView$m r0 = r16.g()
                androidx.recyclerview.widget.RecyclerView$v r0 = r0.a((int) r9)
                if (r0 == 0) goto L_0x0101
                r0.resetInternal()
                boolean r1 = androidx.recyclerview.widget.RecyclerView.f3883a
                if (r1 == 0) goto L_0x0101
                r6.f((androidx.recyclerview.widget.RecyclerView.v) r0)
            L_0x0101:
                r1 = r0
            L_0x0102:
                if (r1 != 0) goto L_0x0183
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                long r0 = r0.getNanoTime()
                r10 = 9223372036854775807(0x7fffffffffffffff, double:NaN)
                int r5 = (r19 > r10 ? 1 : (r19 == r10 ? 0 : -1))
                if (r5 == 0) goto L_0x0120
                androidx.recyclerview.widget.RecyclerView$m r10 = r6.f3995e
                r11 = r9
                r12 = r0
                r14 = r19
                boolean r5 = r10.a((int) r11, (long) r12, (long) r14)
                if (r5 != 0) goto L_0x0120
                return r2
            L_0x0120:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$Adapter r2 = r2.f3922n
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$v r2 = r2.createViewHolder(r5, r9)
                boolean r5 = androidx.recyclerview.widget.RecyclerView.f3886d
                if (r5 == 0) goto L_0x013d
                android.view.View r5 = r2.itemView
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.k(r5)
                if (r5 == 0) goto L_0x013d
                java.lang.ref.WeakReference r10 = new java.lang.ref.WeakReference
                r10.<init>(r5)
                r2.mNestedRecyclerView = r10
            L_0x013d:
                androidx.recyclerview.widget.RecyclerView r5 = androidx.recyclerview.widget.RecyclerView.this
                long r10 = r5.getNanoTime()
                androidx.recyclerview.widget.RecyclerView$m r5 = r6.f3995e
                long r10 = r10 - r0
                r5.a((int) r9, (long) r10)
                r9 = r2
                goto L_0x0184
            L_0x014b:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Inconsistency detected. Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "(offset:"
                r1.append(r2)
                r1.append(r5)
                java.lang.String r2 = ").state:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r2 = r2.F
                int r2 = r2.e()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.a()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                throw r0
            L_0x0183:
                r9 = r1
            L_0x0184:
                r10 = r4
                if (r10 == 0) goto L_0x01bf
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r0 = r0.F
                boolean r0 = r0.a()
                if (r0 != 0) goto L_0x01bf
                r0 = 8192(0x2000, float:1.14794E-41)
                boolean r1 = r9.hasAnyOfTheFlags(r0)
                if (r1 == 0) goto L_0x01bf
                r9.setFlags(r8, r0)
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r0 = r0.F
                boolean r0 = r0.f4025j
                if (r0 == 0) goto L_0x01bf
                int r0 = androidx.recyclerview.widget.RecyclerView.e.e(r9)
                r0 = r0 | 4096(0x1000, float:5.74E-42)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$e r1 = r1.B
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r2 = r2.F
                java.util.List r4 = r9.getUnmodifiedPayloads()
                androidx.recyclerview.widget.RecyclerView$e$c r0 = r1.a((androidx.recyclerview.widget.RecyclerView.s) r2, (androidx.recyclerview.widget.RecyclerView.v) r9, (int) r0, (java.util.List<java.lang.Object>) r4)
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                r1.a((androidx.recyclerview.widget.RecyclerView.v) r9, (androidx.recyclerview.widget.RecyclerView.e.c) r0)
            L_0x01bf:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r0 = r0.F
                boolean r0 = r0.a()
                if (r0 == 0) goto L_0x01d2
                boolean r0 = r9.isBound()
                if (r0 == 0) goto L_0x01d2
                r9.mPreLayoutPosition = r3
                goto L_0x01e5
            L_0x01d2:
                boolean r0 = r9.isBound()
                if (r0 == 0) goto L_0x01e7
                boolean r0 = r9.needsUpdate()
                if (r0 != 0) goto L_0x01e7
                boolean r0 = r9.isInvalid()
                if (r0 == 0) goto L_0x01e5
                goto L_0x01e7
            L_0x01e5:
                r0 = 0
                goto L_0x01fa
            L_0x01e7:
                androidx.recyclerview.widget.RecyclerView r0 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.a r0 = r0.f3915g
                int r2 = r0.b((int) r3)
                r0 = r16
                r1 = r9
                r3 = r17
                r4 = r19
                boolean r0 = r0.a(r1, r2, r3, r4)
            L_0x01fa:
                android.view.View r1 = r9.itemView
                android.view.ViewGroup$LayoutParams r1 = r1.getLayoutParams()
                if (r1 != 0) goto L_0x0210
                androidx.recyclerview.widget.RecyclerView r1 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r1.generateDefaultLayoutParams()
            L_0x0208:
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
                android.view.View r2 = r9.itemView
                r2.setLayoutParams(r1)
                goto L_0x0221
            L_0x0210:
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                boolean r2 = r2.checkLayoutParams(r1)
                if (r2 != 0) goto L_0x021f
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                android.view.ViewGroup$LayoutParams r1 = r2.generateLayoutParams((android.view.ViewGroup.LayoutParams) r1)
                goto L_0x0208
            L_0x021f:
                androidx.recyclerview.widget.RecyclerView$LayoutParams r1 = (androidx.recyclerview.widget.RecyclerView.LayoutParams) r1
            L_0x0221:
                r1.f3945c = r9
                if (r10 == 0) goto L_0x0228
                if (r0 == 0) goto L_0x0228
                goto L_0x0229
            L_0x0228:
                r7 = 0
            L_0x0229:
                r1.f3948f = r7
                return r9
            L_0x022c:
                java.lang.IndexOutOfBoundsException r0 = new java.lang.IndexOutOfBoundsException
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "Invalid item position "
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "("
                r1.append(r2)
                r1.append(r3)
                java.lang.String r2 = "). Item count:"
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                androidx.recyclerview.widget.RecyclerView$s r2 = r2.F
                int r2 = r2.e()
                r1.append(r2)
                androidx.recyclerview.widget.RecyclerView r2 = androidx.recyclerview.widget.RecyclerView.this
                java.lang.String r2 = r2.a()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.<init>(r1)
                goto L_0x0265
            L_0x0264:
                throw r0
            L_0x0265:
                goto L_0x0264
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.n.a(int, boolean, long):androidx.recyclerview.widget.RecyclerView$v");
        }

        /* access modifiers changed from: package-private */
        public v a(long j2, int i2, boolean z2) {
            for (int size = this.f3991a.size() - 1; size >= 0; size--) {
                v vVar = this.f3991a.get(size);
                if (vVar.getItemId() == j2 && !vVar.wasReturnedFromScrap()) {
                    if (i2 == vVar.getItemViewType()) {
                        vVar.addFlags(32);
                        if (vVar.isRemoved() && !RecyclerView.this.F.a()) {
                            vVar.setFlags(2, 14);
                        }
                        return vVar;
                    } else if (!z2) {
                        this.f3991a.remove(size);
                        RecyclerView.this.removeDetachedView(vVar.itemView, false);
                        b(vVar.itemView);
                    }
                }
            }
            int size2 = this.f3993c.size();
            while (true) {
                size2--;
                if (size2 < 0) {
                    return null;
                }
                v vVar2 = this.f3993c.get(size2);
                if (vVar2.getItemId() == j2 && !vVar2.isAttachedToTransitionOverlay()) {
                    if (i2 == vVar2.getItemViewType()) {
                        if (!z2) {
                            this.f3993c.remove(size2);
                        }
                        return vVar2;
                    } else if (!z2) {
                        d(size2);
                        return null;
                    }
                }
            }
        }

        public void a() {
            this.f3991a.clear();
            d();
        }

        public void a(int i2) {
            this.f3998h = i2;
            b();
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3) {
            int i4;
            int i5;
            int i6;
            if (i2 < i3) {
                i6 = -1;
                i5 = i2;
                i4 = i3;
            } else {
                i6 = 1;
                i4 = i2;
                i5 = i3;
            }
            int size = this.f3993c.size();
            for (int i7 = 0; i7 < size; i7++) {
                v vVar = this.f3993c.get(i7);
                if (vVar != null && vVar.mPosition >= i5 && vVar.mPosition <= i4) {
                    if (vVar.mPosition == i2) {
                        vVar.offsetPosition(i3 - i2, false);
                    } else {
                        vVar.offsetPosition(i6, false);
                    }
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3, boolean z2) {
            int i4 = i2 + i3;
            for (int size = this.f3993c.size() - 1; size >= 0; size--) {
                v vVar = this.f3993c.get(size);
                if (vVar != null) {
                    if (vVar.mPosition >= i4) {
                        vVar.offsetPosition(-i3, z2);
                    } else if (vVar.mPosition >= i2) {
                        vVar.addFlags(8);
                        d(size);
                    }
                }
            }
        }

        public void a(View view) {
            v e2 = RecyclerView.e(view);
            if (e2.isTmpDetached()) {
                RecyclerView.this.removeDetachedView(view, false);
            }
            if (e2.isScrap()) {
                e2.unScrap();
            } else if (e2.wasReturnedFromScrap()) {
                e2.clearReturnedFromScrapFlag();
            }
            b(e2);
            if (RecyclerView.this.B != null && !e2.isRecyclable()) {
                RecyclerView.this.B.d(e2);
            }
        }

        /* access modifiers changed from: package-private */
        public void a(Adapter adapter, Adapter adapter2, boolean z2) {
            a();
            g().a(adapter, adapter2, z2);
        }

        /* access modifiers changed from: package-private */
        public void a(m mVar) {
            m mVar2 = this.f3995e;
            if (mVar2 != null) {
                mVar2.c();
            }
            this.f3995e = mVar;
            if (mVar != null && RecyclerView.this.getAdapter() != null) {
                this.f3995e.b();
            }
        }

        /* access modifiers changed from: package-private */
        public void a(t tVar) {
            this.f3999i = tVar;
        }

        /* access modifiers changed from: package-private */
        public void a(v vVar, boolean z2) {
            RecyclerView.c(vVar);
            View view = vVar.itemView;
            if (RecyclerView.this.J != null) {
                t.a c2 = RecyclerView.this.J.c();
                ac.a(view, c2 instanceof u.a ? ((u.a) c2).d(view) : null);
            }
            if (z2) {
                d(vVar);
            }
            vVar.mBindingAdapter = null;
            vVar.mOwnerRecyclerView = null;
            g().a(vVar);
        }

        /* access modifiers changed from: package-private */
        public boolean a(v vVar) {
            if (vVar.isRemoved()) {
                return RecyclerView.this.F.a();
            }
            if (vVar.mPosition < 0 || vVar.mPosition >= RecyclerView.this.f3922n.getItemCount()) {
                throw new IndexOutOfBoundsException("Inconsistency detected. Invalid view holder adapter position" + vVar + RecyclerView.this.a());
            } else if (RecyclerView.this.F.a() || RecyclerView.this.f3922n.getItemViewType(vVar.mPosition) == vVar.getItemViewType()) {
                return !RecyclerView.this.f3922n.hasStableIds() || vVar.getItemId() == RecyclerView.this.f3922n.getItemId(vVar.mPosition);
            } else {
                return false;
            }
        }

        public int b(int i2) {
            if (i2 >= 0 && i2 < RecyclerView.this.F.e()) {
                return !RecyclerView.this.F.a() ? i2 : RecyclerView.this.f3915g.b(i2);
            }
            throw new IndexOutOfBoundsException("invalid position " + i2 + ". State item count is " + RecyclerView.this.F.e() + RecyclerView.this.a());
        }

        /* access modifiers changed from: package-private */
        public v b(int i2, boolean z2) {
            View c2;
            int size = this.f3991a.size();
            int i3 = 0;
            int i4 = 0;
            while (i4 < size) {
                v vVar = this.f3991a.get(i4);
                if (vVar.wasReturnedFromScrap() || vVar.getLayoutPosition() != i2 || vVar.isInvalid() || (!RecyclerView.this.F.f4022g && vVar.isRemoved())) {
                    i4++;
                } else {
                    vVar.addFlags(32);
                    return vVar;
                }
            }
            if (z2 || (c2 = RecyclerView.this.f3916h.c(i2)) == null) {
                int size2 = this.f3993c.size();
                while (i3 < size2) {
                    v vVar2 = this.f3993c.get(i3);
                    if (vVar2.isInvalid() || vVar2.getLayoutPosition() != i2 || vVar2.isAttachedToTransitionOverlay()) {
                        i3++;
                    } else {
                        if (!z2) {
                            this.f3993c.remove(i3);
                        }
                        return vVar2;
                    }
                }
                return null;
            }
            v e2 = RecyclerView.e(c2);
            RecyclerView.this.f3916h.e(c2);
            int b2 = RecyclerView.this.f3916h.b(c2);
            if (b2 != -1) {
                RecyclerView.this.f3916h.e(b2);
                c(c2);
                e2.addFlags(8224);
                return e2;
            }
            throw new IllegalStateException("layout index should not be -1 after unhiding a view:" + e2 + RecyclerView.this.a());
        }

        /* access modifiers changed from: package-private */
        public void b() {
            this.f3994d = this.f3998h + (RecyclerView.this.f3923o != null ? RecyclerView.this.f3923o.f3977x : 0);
            for (int size = this.f3993c.size() - 1; size >= 0 && this.f3993c.size() > this.f3994d; size--) {
                d(size);
            }
        }

        /* access modifiers changed from: package-private */
        public void b(int i2, int i3) {
            int size = this.f3993c.size();
            for (int i4 = 0; i4 < size; i4++) {
                v vVar = this.f3993c.get(i4);
                if (vVar != null && vVar.mPosition >= i2) {
                    vVar.offsetPosition(i3, false);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void b(View view) {
            v e2 = RecyclerView.e(view);
            e2.mScrapContainer = null;
            e2.mInChangeScrap = false;
            e2.clearReturnedFromScrapFlag();
            b(e2);
        }

        /* access modifiers changed from: package-private */
        public void b(v vVar) {
            boolean z2;
            boolean z3 = false;
            boolean z4 = true;
            if (vVar.isScrap() || vVar.itemView.getParent() != null) {
                StringBuilder sb = new StringBuilder();
                sb.append("Scrapped or attached views may not be recycled. isScrap:");
                sb.append(vVar.isScrap());
                sb.append(" isAttached:");
                if (vVar.itemView.getParent() != null) {
                    z3 = true;
                }
                sb.append(z3);
                sb.append(RecyclerView.this.a());
                throw new IllegalArgumentException(sb.toString());
            } else if (vVar.isTmpDetached()) {
                throw new IllegalArgumentException("Tmp detached view should be removed from RecyclerView before it can be recycled: " + vVar + RecyclerView.this.a());
            } else if (!vVar.shouldIgnore()) {
                boolean doesTransientStatePreventRecycling = vVar.doesTransientStatePreventRecycling();
                if ((RecyclerView.this.f3922n != null && doesTransientStatePreventRecycling && RecyclerView.this.f3922n.onFailedToRecycleView(vVar)) || vVar.isRecyclable()) {
                    if (this.f3994d <= 0 || vVar.hasAnyOfTheFlags(526)) {
                        z2 = false;
                    } else {
                        int size = this.f3993c.size();
                        if (size >= this.f3994d && size > 0) {
                            d(0);
                            size--;
                        }
                        if (RecyclerView.f3886d && size > 0 && !RecyclerView.this.E.a(vVar.mPosition)) {
                            int i2 = size - 1;
                            while (i2 >= 0) {
                                if (!RecyclerView.this.E.a(this.f3993c.get(i2).mPosition)) {
                                    break;
                                }
                                i2--;
                            }
                            size = i2 + 1;
                        }
                        this.f3993c.add(size, vVar);
                        z2 = true;
                    }
                    if (!z2) {
                        a(vVar, true);
                        z3 = z2;
                        RecyclerView.this.f3917i.g(vVar);
                        if (!z3 && !z4 && doesTransientStatePreventRecycling) {
                            vVar.mBindingAdapter = null;
                            vVar.mOwnerRecyclerView = null;
                            return;
                        }
                        return;
                    }
                    z3 = z2;
                }
                z4 = false;
                RecyclerView.this.f3917i.g(vVar);
                if (!z3) {
                }
            } else {
                throw new IllegalArgumentException("Trying to recycle an ignored view holder. You should first call stopIgnoringView(view) before calling recycle." + RecyclerView.this.a());
            }
        }

        public View c(int i2) {
            return a(i2, false);
        }

        public List<v> c() {
            return this.f3997g;
        }

        /* access modifiers changed from: package-private */
        public void c(int i2, int i3) {
            int i4;
            int i5 = i3 + i2;
            for (int size = this.f3993c.size() - 1; size >= 0; size--) {
                v vVar = this.f3993c.get(size);
                if (vVar != null && (i4 = vVar.mPosition) >= i2 && i4 < i5) {
                    vVar.addFlags(2);
                    d(size);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void c(View view) {
            ArrayList<v> arrayList;
            v e2 = RecyclerView.e(view);
            if (!e2.hasAnyOfTheFlags(12) && e2.isUpdated() && !RecyclerView.this.b(e2)) {
                if (this.f3992b == null) {
                    this.f3992b = new ArrayList<>();
                }
                e2.setScrapContainer(this, true);
                arrayList = this.f3992b;
            } else if (!e2.isInvalid() || e2.isRemoved() || RecyclerView.this.f3922n.hasStableIds()) {
                e2.setScrapContainer(this, false);
                arrayList = this.f3991a;
            } else {
                throw new IllegalArgumentException("Called scrap view with an invalid view. Invalid views cannot be reused from scrap, they should rebound from recycler pool." + RecyclerView.this.a());
            }
            arrayList.add(e2);
        }

        /* access modifiers changed from: package-private */
        public void c(v vVar) {
            (vVar.mInChangeScrap ? this.f3992b : this.f3991a).remove(vVar);
            vVar.mScrapContainer = null;
            vVar.mInChangeScrap = false;
            vVar.clearReturnedFromScrapFlag();
        }

        /* access modifiers changed from: package-private */
        public void d() {
            for (int size = this.f3993c.size() - 1; size >= 0; size--) {
                d(size);
            }
            this.f3993c.clear();
            if (RecyclerView.f3886d) {
                RecyclerView.this.E.a();
            }
        }

        /* access modifiers changed from: package-private */
        public void d(int i2) {
            a(this.f3993c.get(i2), true);
            this.f3993c.remove(i2);
        }

        /* access modifiers changed from: package-private */
        public void d(v vVar) {
            if (RecyclerView.this.f3924p != null) {
                RecyclerView.this.f3924p.onViewRecycled(vVar);
            }
            int size = RecyclerView.this.f3925q.size();
            for (int i2 = 0; i2 < size; i2++) {
                RecyclerView.this.f3925q.get(i2).onViewRecycled(vVar);
            }
            if (RecyclerView.this.f3922n != null) {
                RecyclerView.this.f3922n.onViewRecycled(vVar);
            }
            if (RecyclerView.this.F != null) {
                RecyclerView.this.f3917i.g(vVar);
            }
        }

        /* access modifiers changed from: package-private */
        public int e() {
            return this.f3991a.size();
        }

        /* access modifiers changed from: package-private */
        public View e(int i2) {
            return this.f3991a.get(i2).itemView;
        }

        /* access modifiers changed from: package-private */
        public v f(int i2) {
            int size;
            int b2;
            ArrayList<v> arrayList = this.f3992b;
            if (!(arrayList == null || (size = arrayList.size()) == 0)) {
                int i3 = 0;
                int i4 = 0;
                while (i4 < size) {
                    v vVar = this.f3992b.get(i4);
                    if (vVar.wasReturnedFromScrap() || vVar.getLayoutPosition() != i2) {
                        i4++;
                    } else {
                        vVar.addFlags(32);
                        return vVar;
                    }
                }
                if (RecyclerView.this.f3922n.hasStableIds() && (b2 = RecyclerView.this.f3915g.b(i2)) > 0 && b2 < RecyclerView.this.f3922n.getItemCount()) {
                    long itemId = RecyclerView.this.f3922n.getItemId(b2);
                    while (i3 < size) {
                        v vVar2 = this.f3992b.get(i3);
                        if (vVar2.wasReturnedFromScrap() || vVar2.getItemId() != itemId) {
                            i3++;
                        } else {
                            vVar2.addFlags(32);
                            return vVar2;
                        }
                    }
                }
            }
            return null;
        }

        /* access modifiers changed from: package-private */
        public void f() {
            this.f3991a.clear();
            ArrayList<v> arrayList = this.f3992b;
            if (arrayList != null) {
                arrayList.clear();
            }
        }

        /* access modifiers changed from: package-private */
        public m g() {
            if (this.f3995e == null) {
                this.f3995e = new m();
            }
            return this.f3995e;
        }

        /* access modifiers changed from: package-private */
        public void h() {
            int size = this.f3993c.size();
            for (int i2 = 0; i2 < size; i2++) {
                v vVar = this.f3993c.get(i2);
                if (vVar != null) {
                    vVar.addFlags(6);
                    vVar.addChangePayload((Object) null);
                }
            }
            if (RecyclerView.this.f3922n == null || !RecyclerView.this.f3922n.hasStableIds()) {
                d();
            }
        }

        /* access modifiers changed from: package-private */
        public void i() {
            int size = this.f3993c.size();
            for (int i2 = 0; i2 < size; i2++) {
                this.f3993c.get(i2).clearOldPosition();
            }
            int size2 = this.f3991a.size();
            for (int i3 = 0; i3 < size2; i3++) {
                this.f3991a.get(i3).clearOldPosition();
            }
            ArrayList<v> arrayList = this.f3992b;
            if (arrayList != null) {
                int size3 = arrayList.size();
                for (int i4 = 0; i4 < size3; i4++) {
                    this.f3992b.get(i4).clearOldPosition();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void j() {
            int size = this.f3993c.size();
            for (int i2 = 0; i2 < size; i2++) {
                LayoutParams layoutParams = (LayoutParams) this.f3993c.get(i2).itemView.getLayoutParams();
                if (layoutParams != null) {
                    layoutParams.f3947e = true;
                }
            }
        }
    }

    public interface o {
        void onViewRecycled(v vVar);
    }

    private class p extends b {
        p() {
        }

        public void a() {
            RecyclerView.this.a((String) null);
            RecyclerView.this.F.f4021f = true;
            RecyclerView.this.c(true);
            if (!RecyclerView.this.f3915g.d()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void a(int i2, int i3, int i4) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.f3915g.a(i2, i3, i4)) {
                c();
            }
        }

        public void a(int i2, int i3, Object obj) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.f3915g.a(i2, i3, obj)) {
                c();
            }
        }

        public void b() {
            Adapter adapter;
            if (RecyclerView.this.f3914f != null && (adapter = RecyclerView.this.f3922n) != null && adapter.canRestoreState()) {
                RecyclerView.this.requestLayout();
            }
        }

        public void b(int i2, int i3) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.f3915g.b(i2, i3)) {
                c();
            }
        }

        /* access modifiers changed from: package-private */
        public void c() {
            if (!RecyclerView.f3885c || !RecyclerView.this.f3928t || !RecyclerView.this.f3927s) {
                RecyclerView.this.f3933y = true;
                RecyclerView.this.requestLayout();
                return;
            }
            RecyclerView recyclerView = RecyclerView.this;
            ac.a((View) recyclerView, recyclerView.f3919k);
        }

        public void c(int i2, int i3) {
            RecyclerView.this.a((String) null);
            if (RecyclerView.this.f3915g.c(i2, i3)) {
                c();
            }
        }
    }

    public static class q implements k {
        public void a(boolean z2) {
        }

        public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
            return false;
        }

        public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
        }
    }

    public static abstract class r {

        /* renamed from: a  reason: collision with root package name */
        private int f4001a = -1;

        /* renamed from: b  reason: collision with root package name */
        private RecyclerView f4002b;

        /* renamed from: c  reason: collision with root package name */
        private h f4003c;

        /* renamed from: d  reason: collision with root package name */
        private boolean f4004d;

        /* renamed from: e  reason: collision with root package name */
        private boolean f4005e;

        /* renamed from: f  reason: collision with root package name */
        private View f4006f;

        /* renamed from: g  reason: collision with root package name */
        private final a f4007g = new a(0, 0);

        /* renamed from: h  reason: collision with root package name */
        private boolean f4008h;

        public static class a {

            /* renamed from: a  reason: collision with root package name */
            private int f4009a;

            /* renamed from: b  reason: collision with root package name */
            private int f4010b;

            /* renamed from: c  reason: collision with root package name */
            private int f4011c;

            /* renamed from: d  reason: collision with root package name */
            private int f4012d;

            /* renamed from: e  reason: collision with root package name */
            private Interpolator f4013e;

            /* renamed from: f  reason: collision with root package name */
            private boolean f4014f;

            /* renamed from: g  reason: collision with root package name */
            private int f4015g;

            public a(int i2, int i3) {
                this(i2, i3, Integer.MIN_VALUE, (Interpolator) null);
            }

            public a(int i2, int i3, int i4, Interpolator interpolator) {
                this.f4012d = -1;
                this.f4014f = false;
                this.f4015g = 0;
                this.f4009a = i2;
                this.f4010b = i3;
                this.f4011c = i4;
                this.f4013e = interpolator;
            }

            private void b() {
                if (this.f4013e != null && this.f4011c < 1) {
                    throw new IllegalStateException("If you provide an interpolator, you must set a positive duration");
                } else if (this.f4011c < 1) {
                    throw new IllegalStateException("Scroll duration must be a positive number");
                }
            }

            public void a(int i2) {
                this.f4012d = i2;
            }

            public void a(int i2, int i3, int i4, Interpolator interpolator) {
                this.f4009a = i2;
                this.f4010b = i3;
                this.f4011c = i4;
                this.f4013e = interpolator;
                this.f4014f = true;
            }

            /* access modifiers changed from: package-private */
            public void a(RecyclerView recyclerView) {
                int i2 = this.f4012d;
                if (i2 >= 0) {
                    this.f4012d = -1;
                    recyclerView.b(i2);
                    this.f4014f = false;
                } else if (this.f4014f) {
                    b();
                    recyclerView.C.a(this.f4009a, this.f4010b, this.f4011c, this.f4013e);
                    int i3 = this.f4015g + 1;
                    this.f4015g = i3;
                    if (i3 > 10) {
                        Log.e("RecyclerView", "Smooth Scroll action is being updated too frequently. Make sure you are not changing it unless necessary");
                    }
                    this.f4014f = false;
                } else {
                    this.f4015g = 0;
                }
            }

            /* access modifiers changed from: package-private */
            public boolean a() {
                return this.f4012d >= 0;
            }
        }

        public interface b {
            PointF d(int i2);
        }

        public int a(View view) {
            return this.f4002b.g(view);
        }

        /* access modifiers changed from: protected */
        public abstract void a();

        /* access modifiers changed from: package-private */
        public void a(int i2, int i3) {
            PointF d2;
            RecyclerView recyclerView = this.f4002b;
            if (this.f4001a == -1 || recyclerView == null) {
                f();
            }
            if (!(!this.f4004d || this.f4006f != null || this.f4003c == null || (d2 = d(this.f4001a)) == null || (d2.x == 0.0f && d2.y == 0.0f))) {
                recyclerView.a((int) Math.signum(d2.x), (int) Math.signum(d2.y), (int[]) null);
            }
            this.f4004d = false;
            View view = this.f4006f;
            if (view != null) {
                if (a(view) == this.f4001a) {
                    a(this.f4006f, recyclerView.F, this.f4007g);
                    this.f4007g.a(recyclerView);
                    f();
                } else {
                    Log.e("RecyclerView", "Passed over target position while smooth scrolling.");
                    this.f4006f = null;
                }
            }
            if (this.f4005e) {
                a(i2, i3, recyclerView.F, this.f4007g);
                boolean a2 = this.f4007g.a();
                this.f4007g.a(recyclerView);
                if (a2 && this.f4005e) {
                    this.f4004d = true;
                    recyclerView.C.a();
                }
            }
        }

        /* access modifiers changed from: protected */
        public abstract void a(int i2, int i3, s sVar, a aVar);

        /* access modifiers changed from: protected */
        public void a(PointF pointF) {
            float sqrt = (float) Math.sqrt((double) ((pointF.x * pointF.x) + (pointF.y * pointF.y)));
            pointF.x /= sqrt;
            pointF.y /= sqrt;
        }

        /* access modifiers changed from: protected */
        public abstract void a(View view, s sVar, a aVar);

        /* access modifiers changed from: package-private */
        public void a(RecyclerView recyclerView, h hVar) {
            recyclerView.C.b();
            if (this.f4008h) {
                Log.w("RecyclerView", "An instance of " + getClass().getSimpleName() + " was started more than once. Each instance of" + getClass().getSimpleName() + " is intended to only be used once. You should create a new instance for each use.");
            }
            this.f4002b = recyclerView;
            this.f4003c = hVar;
            if (this.f4001a != -1) {
                recyclerView.F.f4016a = this.f4001a;
                this.f4005e = true;
                this.f4004d = true;
                this.f4006f = e(i());
                a();
                this.f4002b.C.a();
                this.f4008h = true;
                return;
            }
            throw new IllegalArgumentException("Invalid target position");
        }

        /* access modifiers changed from: protected */
        public abstract void b();

        /* access modifiers changed from: protected */
        public void b(View view) {
            if (a(view) == i()) {
                this.f4006f = view;
            }
        }

        public void c(int i2) {
            this.f4001a = i2;
        }

        public PointF d(int i2) {
            h e2 = e();
            if (e2 instanceof b) {
                return ((b) e2).d(i2);
            }
            Log.w("RecyclerView", "You should override computeScrollVectorForPosition when the LayoutManager does not implement " + b.class.getCanonicalName());
            return null;
        }

        public View e(int i2) {
            return this.f4002b.f3923o.c(i2);
        }

        public h e() {
            return this.f4003c;
        }

        /* access modifiers changed from: protected */
        public final void f() {
            if (this.f4005e) {
                this.f4005e = false;
                b();
                this.f4002b.F.f4016a = -1;
                this.f4006f = null;
                this.f4001a = -1;
                this.f4004d = false;
                this.f4003c.b(this);
                this.f4003c = null;
                this.f4002b = null;
            }
        }

        public boolean g() {
            return this.f4004d;
        }

        public boolean h() {
            return this.f4005e;
        }

        public int i() {
            return this.f4001a;
        }

        public int j() {
            return this.f4002b.f3923o.z();
        }
    }

    public static class s {

        /* renamed from: a  reason: collision with root package name */
        int f4016a = -1;

        /* renamed from: b  reason: collision with root package name */
        int f4017b = 0;

        /* renamed from: c  reason: collision with root package name */
        int f4018c = 0;

        /* renamed from: d  reason: collision with root package name */
        int f4019d = 1;

        /* renamed from: e  reason: collision with root package name */
        int f4020e = 0;

        /* renamed from: f  reason: collision with root package name */
        boolean f4021f = false;

        /* renamed from: g  reason: collision with root package name */
        boolean f4022g = false;

        /* renamed from: h  reason: collision with root package name */
        boolean f4023h = false;

        /* renamed from: i  reason: collision with root package name */
        boolean f4024i = false;

        /* renamed from: j  reason: collision with root package name */
        boolean f4025j = false;

        /* renamed from: k  reason: collision with root package name */
        boolean f4026k = false;

        /* renamed from: l  reason: collision with root package name */
        int f4027l;

        /* renamed from: m  reason: collision with root package name */
        long f4028m;

        /* renamed from: n  reason: collision with root package name */
        int f4029n;

        /* renamed from: o  reason: collision with root package name */
        int f4030o;

        /* renamed from: p  reason: collision with root package name */
        int f4031p;

        /* renamed from: q  reason: collision with root package name */
        private SparseArray<Object> f4032q;

        /* access modifiers changed from: package-private */
        public void a(int i2) {
            if ((this.f4019d & i2) == 0) {
                throw new IllegalStateException("Layout state should be one of " + Integer.toBinaryString(i2) + " but it is " + Integer.toBinaryString(this.f4019d));
            }
        }

        /* access modifiers changed from: package-private */
        public void a(Adapter adapter) {
            this.f4019d = 1;
            this.f4020e = adapter.getItemCount();
            this.f4022g = false;
            this.f4023h = false;
            this.f4024i = false;
        }

        public boolean a() {
            return this.f4022g;
        }

        public boolean b() {
            return this.f4026k;
        }

        public int c() {
            return this.f4016a;
        }

        public boolean d() {
            return this.f4016a != -1;
        }

        public int e() {
            return this.f4022g ? this.f4017b - this.f4018c : this.f4020e;
        }

        public String toString() {
            return "State{mTargetPosition=" + this.f4016a + ", mData=" + this.f4032q + ", mItemCount=" + this.f4020e + ", mIsMeasuring=" + this.f4024i + ", mPreviousLayoutItemCount=" + this.f4017b + ", mDeletedInvisibleItemCountSincePreviousLayout=" + this.f4018c + ", mStructureChanged=" + this.f4021f + ", mInPreLayout=" + this.f4022g + ", mRunSimpleAnimations=" + this.f4025j + ", mRunPredictiveAnimations=" + this.f4026k + '}';
        }
    }

    public static abstract class t {
        public abstract View a(n nVar, int i2, int i3);
    }

    class u implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        OverScroller f4033a;

        /* renamed from: b  reason: collision with root package name */
        Interpolator f4034b = RecyclerView.M;

        /* renamed from: d  reason: collision with root package name */
        private int f4036d;

        /* renamed from: e  reason: collision with root package name */
        private int f4037e;

        /* renamed from: f  reason: collision with root package name */
        private boolean f4038f = false;

        /* renamed from: g  reason: collision with root package name */
        private boolean f4039g = false;

        u() {
            this.f4033a = new OverScroller(RecyclerView.this.getContext(), RecyclerView.M);
        }

        private int b(int i2, int i3) {
            int abs = Math.abs(i2);
            int abs2 = Math.abs(i3);
            boolean z2 = abs > abs2;
            RecyclerView recyclerView = RecyclerView.this;
            int width = z2 ? recyclerView.getWidth() : recyclerView.getHeight();
            if (!z2) {
                abs = abs2;
            }
            return Math.min((int) (((((float) abs) / ((float) width)) + 1.0f) * 300.0f), GSYVideoView.CHANGE_DELAY_TIME);
        }

        private void c() {
            RecyclerView.this.removeCallbacks(this);
            ac.a((View) RecyclerView.this, (Runnable) this);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (this.f4038f) {
                this.f4039g = true;
            } else {
                c();
            }
        }

        public void a(int i2, int i3) {
            RecyclerView.this.setScrollState(2);
            this.f4037e = 0;
            this.f4036d = 0;
            if (this.f4034b != RecyclerView.M) {
                this.f4034b = RecyclerView.M;
                this.f4033a = new OverScroller(RecyclerView.this.getContext(), RecyclerView.M);
            }
            this.f4033a.fling(0, 0, i2, i3, Integer.MIN_VALUE, SubsamplingScaleImageView.TILE_SIZE_AUTO, Integer.MIN_VALUE, SubsamplingScaleImageView.TILE_SIZE_AUTO);
            a();
        }

        public void a(int i2, int i3, int i4, Interpolator interpolator) {
            if (i4 == Integer.MIN_VALUE) {
                i4 = b(i2, i3);
            }
            int i5 = i4;
            if (interpolator == null) {
                interpolator = RecyclerView.M;
            }
            if (this.f4034b != interpolator) {
                this.f4034b = interpolator;
                this.f4033a = new OverScroller(RecyclerView.this.getContext(), interpolator);
            }
            this.f4037e = 0;
            this.f4036d = 0;
            RecyclerView.this.setScrollState(2);
            this.f4033a.startScroll(0, 0, i2, i3, i5);
            if (Build.VERSION.SDK_INT < 23) {
                this.f4033a.computeScrollOffset();
            }
            a();
        }

        public void b() {
            RecyclerView.this.removeCallbacks(this);
            this.f4033a.abortAnimation();
        }

        public void run() {
            int i2;
            int i3;
            if (RecyclerView.this.f3923o == null) {
                b();
                return;
            }
            this.f4039g = false;
            this.f4038f = true;
            RecyclerView.this.d();
            OverScroller overScroller = this.f4033a;
            if (overScroller.computeScrollOffset()) {
                int currX = overScroller.getCurrX();
                int currY = overScroller.getCurrY();
                int i4 = currX - this.f4036d;
                int i5 = currY - this.f4037e;
                this.f4036d = currX;
                this.f4037e = currY;
                RecyclerView.this.K[0] = 0;
                RecyclerView.this.K[1] = 0;
                RecyclerView recyclerView = RecyclerView.this;
                if (recyclerView.a(i4, i5, recyclerView.K, (int[]) null, 1)) {
                    i4 -= RecyclerView.this.K[0];
                    i5 -= RecyclerView.this.K[1];
                }
                if (RecyclerView.this.getOverScrollMode() != 2) {
                    RecyclerView.this.c(i4, i5);
                }
                if (RecyclerView.this.f3922n != null) {
                    RecyclerView.this.K[0] = 0;
                    RecyclerView.this.K[1] = 0;
                    RecyclerView recyclerView2 = RecyclerView.this;
                    recyclerView2.a(i4, i5, recyclerView2.K);
                    i3 = RecyclerView.this.K[0];
                    i2 = RecyclerView.this.K[1];
                    i4 -= i3;
                    i5 -= i2;
                    r rVar = RecyclerView.this.f3923o.f3973t;
                    if (rVar != null && !rVar.g() && rVar.h()) {
                        int e2 = RecyclerView.this.F.e();
                        if (e2 == 0) {
                            rVar.f();
                        } else {
                            if (rVar.i() >= e2) {
                                rVar.c(e2 - 1);
                            }
                            rVar.a(i3, i2);
                        }
                    }
                } else {
                    i3 = 0;
                    i2 = 0;
                }
                if (!RecyclerView.this.f3926r.isEmpty()) {
                    RecyclerView.this.invalidate();
                }
                RecyclerView.this.K[0] = 0;
                RecyclerView.this.K[1] = 0;
                RecyclerView recyclerView3 = RecyclerView.this;
                recyclerView3.a(i3, i2, i4, i5, (int[]) null, 1, recyclerView3.K);
                int i6 = i4 - RecyclerView.this.K[0];
                int i7 = i5 - RecyclerView.this.K[1];
                if (!(i3 == 0 && i2 == 0)) {
                    RecyclerView.this.i(i3, i2);
                }
                if (!RecyclerView.this.awakenScrollBars()) {
                    RecyclerView.this.invalidate();
                }
                boolean z2 = overScroller.isFinished() || (((overScroller.getCurrX() == overScroller.getFinalX()) || i6 != 0) && ((overScroller.getCurrY() == overScroller.getFinalY()) || i7 != 0));
                r rVar2 = RecyclerView.this.f3923o.f3973t;
                if ((rVar2 != null && rVar2.g()) || !z2) {
                    a();
                    if (RecyclerView.this.D != null) {
                        RecyclerView.this.D.a(RecyclerView.this, i3, i2);
                    }
                } else {
                    if (RecyclerView.this.getOverScrollMode() != 2) {
                        int currVelocity = (int) overScroller.getCurrVelocity();
                        int i8 = i6 < 0 ? -currVelocity : i6 > 0 ? currVelocity : 0;
                        if (i7 < 0) {
                            currVelocity = -currVelocity;
                        } else if (i7 <= 0) {
                            currVelocity = 0;
                        }
                        RecyclerView.this.d(i8, currVelocity);
                    }
                    if (RecyclerView.f3886d) {
                        RecyclerView.this.E.a();
                    }
                }
            }
            r rVar3 = RecyclerView.this.f3923o.f3973t;
            if (rVar3 != null && rVar3.g()) {
                rVar3.a(0, 0);
            }
            this.f4038f = false;
            if (this.f4039g) {
                c();
                return;
            }
            RecyclerView.this.setScrollState(0);
            RecyclerView.this.j(1);
        }
    }

    public static abstract class v {
        static final int FLAG_ADAPTER_FULLUPDATE = 1024;
        static final int FLAG_ADAPTER_POSITION_UNKNOWN = 512;
        static final int FLAG_APPEARED_IN_PRE_LAYOUT = 4096;
        static final int FLAG_BOUNCED_FROM_HIDDEN_LIST = 8192;
        static final int FLAG_BOUND = 1;
        static final int FLAG_IGNORE = 128;
        static final int FLAG_INVALID = 4;
        static final int FLAG_MOVED = 2048;
        static final int FLAG_NOT_RECYCLABLE = 16;
        static final int FLAG_REMOVED = 8;
        static final int FLAG_RETURNED_FROM_SCRAP = 32;
        static final int FLAG_TMP_DETACHED = 256;
        static final int FLAG_UPDATE = 2;
        private static final List<Object> FULLUPDATE_PAYLOADS = Collections.emptyList();
        static final int PENDING_ACCESSIBILITY_STATE_NOT_SET = -1;
        public final View itemView;
        Adapter<? extends v> mBindingAdapter;
        int mFlags;
        boolean mInChangeScrap = false;
        private int mIsRecyclableCount = 0;
        long mItemId = -1;
        int mItemViewType = -1;
        WeakReference<RecyclerView> mNestedRecyclerView;
        int mOldPosition = -1;
        RecyclerView mOwnerRecyclerView;
        List<Object> mPayloads = null;
        int mPendingAccessibilityState = -1;
        int mPosition = -1;
        int mPreLayoutPosition = -1;
        n mScrapContainer = null;
        v mShadowedHolder = null;
        v mShadowingHolder = null;
        List<Object> mUnmodifiedPayloads = null;
        private int mWasImportantForAccessibilityBeforeHidden = 0;

        public v(View view) {
            if (view != null) {
                this.itemView = view;
                return;
            }
            throw new IllegalArgumentException("itemView may not be null");
        }

        private void createPayloadsIfNeeded() {
            if (this.mPayloads == null) {
                ArrayList arrayList = new ArrayList();
                this.mPayloads = arrayList;
                this.mUnmodifiedPayloads = Collections.unmodifiableList(arrayList);
            }
        }

        /* access modifiers changed from: package-private */
        public void addChangePayload(Object obj) {
            if (obj == null) {
                addFlags(1024);
            } else if ((1024 & this.mFlags) == 0) {
                createPayloadsIfNeeded();
                this.mPayloads.add(obj);
            }
        }

        /* access modifiers changed from: package-private */
        public void addFlags(int i2) {
            this.mFlags = i2 | this.mFlags;
        }

        /* access modifiers changed from: package-private */
        public void clearOldPosition() {
            this.mOldPosition = -1;
            this.mPreLayoutPosition = -1;
        }

        /* access modifiers changed from: package-private */
        public void clearPayload() {
            List<Object> list = this.mPayloads;
            if (list != null) {
                list.clear();
            }
            this.mFlags &= -1025;
        }

        /* access modifiers changed from: package-private */
        public void clearReturnedFromScrapFlag() {
            this.mFlags &= -33;
        }

        /* access modifiers changed from: package-private */
        public void clearTmpDetachFlag() {
            this.mFlags &= -257;
        }

        /* access modifiers changed from: package-private */
        public boolean doesTransientStatePreventRecycling() {
            return (this.mFlags & 16) == 0 && ac.d(this.itemView);
        }

        /* access modifiers changed from: package-private */
        public void flagRemovedAndOffsetPosition(int i2, int i3, boolean z2) {
            addFlags(8);
            offsetPosition(i3, z2);
            this.mPosition = i2;
        }

        public final int getAbsoluteAdapterPosition() {
            RecyclerView recyclerView = this.mOwnerRecyclerView;
            if (recyclerView == null) {
                return -1;
            }
            return recyclerView.d(this);
        }

        @Deprecated
        public final int getAdapterPosition() {
            return getBindingAdapterPosition();
        }

        public final Adapter<? extends v> getBindingAdapter() {
            return this.mBindingAdapter;
        }

        public final int getBindingAdapterPosition() {
            RecyclerView recyclerView;
            Adapter adapter;
            int d2;
            if (this.mBindingAdapter == null || (recyclerView = this.mOwnerRecyclerView) == null || (adapter = recyclerView.getAdapter()) == null || (d2 = this.mOwnerRecyclerView.d(this)) == -1) {
                return -1;
            }
            return adapter.findRelativeAdapterPositionIn(this.mBindingAdapter, this, d2);
        }

        public final long getItemId() {
            return this.mItemId;
        }

        public final int getItemViewType() {
            return this.mItemViewType;
        }

        public final int getLayoutPosition() {
            int i2 = this.mPreLayoutPosition;
            return i2 == -1 ? this.mPosition : i2;
        }

        public final int getOldPosition() {
            return this.mOldPosition;
        }

        @Deprecated
        public final int getPosition() {
            int i2 = this.mPreLayoutPosition;
            return i2 == -1 ? this.mPosition : i2;
        }

        /* access modifiers changed from: package-private */
        public List<Object> getUnmodifiedPayloads() {
            if ((this.mFlags & 1024) != 0) {
                return FULLUPDATE_PAYLOADS;
            }
            List<Object> list = this.mPayloads;
            return (list == null || list.size() == 0) ? FULLUPDATE_PAYLOADS : this.mUnmodifiedPayloads;
        }

        /* access modifiers changed from: package-private */
        public boolean hasAnyOfTheFlags(int i2) {
            return (i2 & this.mFlags) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isAdapterPositionUnknown() {
            return (this.mFlags & 512) != 0 || isInvalid();
        }

        /* access modifiers changed from: package-private */
        public boolean isAttachedToTransitionOverlay() {
            return (this.itemView.getParent() == null || this.itemView.getParent() == this.mOwnerRecyclerView) ? false : true;
        }

        /* access modifiers changed from: package-private */
        public boolean isBound() {
            return (this.mFlags & 1) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isInvalid() {
            return (this.mFlags & 4) != 0;
        }

        public final boolean isRecyclable() {
            return (this.mFlags & 16) == 0 && !ac.d(this.itemView);
        }

        /* access modifiers changed from: package-private */
        public boolean isRemoved() {
            return (this.mFlags & 8) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isScrap() {
            return this.mScrapContainer != null;
        }

        /* access modifiers changed from: package-private */
        public boolean isTmpDetached() {
            return (this.mFlags & 256) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean isUpdated() {
            return (this.mFlags & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean needsUpdate() {
            return (this.mFlags & 2) != 0;
        }

        /* access modifiers changed from: package-private */
        public void offsetPosition(int i2, boolean z2) {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
            if (this.mPreLayoutPosition == -1) {
                this.mPreLayoutPosition = this.mPosition;
            }
            if (z2) {
                this.mPreLayoutPosition += i2;
            }
            this.mPosition += i2;
            if (this.itemView.getLayoutParams() != null) {
                ((LayoutParams) this.itemView.getLayoutParams()).f3947e = true;
            }
        }

        /* access modifiers changed from: package-private */
        public void onEnteredHiddenState(RecyclerView recyclerView) {
            int i2 = this.mPendingAccessibilityState;
            if (i2 == -1) {
                i2 = ac.f(this.itemView);
            }
            this.mWasImportantForAccessibilityBeforeHidden = i2;
            recyclerView.a(this, 4);
        }

        /* access modifiers changed from: package-private */
        public void onLeftHiddenState(RecyclerView recyclerView) {
            recyclerView.a(this, this.mWasImportantForAccessibilityBeforeHidden);
            this.mWasImportantForAccessibilityBeforeHidden = 0;
        }

        /* access modifiers changed from: package-private */
        public void resetInternal() {
            this.mFlags = 0;
            this.mPosition = -1;
            this.mOldPosition = -1;
            this.mItemId = -1;
            this.mPreLayoutPosition = -1;
            this.mIsRecyclableCount = 0;
            this.mShadowedHolder = null;
            this.mShadowingHolder = null;
            clearPayload();
            this.mWasImportantForAccessibilityBeforeHidden = 0;
            this.mPendingAccessibilityState = -1;
            RecyclerView.c(this);
        }

        /* access modifiers changed from: package-private */
        public void saveOldPosition() {
            if (this.mOldPosition == -1) {
                this.mOldPosition = this.mPosition;
            }
        }

        /* access modifiers changed from: package-private */
        public void setFlags(int i2, int i3) {
            this.mFlags = (i2 & i3) | (this.mFlags & (i3 ^ -1));
        }

        public final void setIsRecyclable(boolean z2) {
            int i2;
            int i3 = this.mIsRecyclableCount;
            int i4 = z2 ? i3 - 1 : i3 + 1;
            this.mIsRecyclableCount = i4;
            if (i4 < 0) {
                this.mIsRecyclableCount = 0;
                Log.e("View", "isRecyclable decremented below 0: unmatched pair of setIsRecyable() calls for " + this);
                return;
            }
            if (!z2 && i4 == 1) {
                i2 = this.mFlags | 16;
            } else if (z2 && i4 == 0) {
                i2 = this.mFlags & -17;
            } else {
                return;
            }
            this.mFlags = i2;
        }

        /* access modifiers changed from: package-private */
        public void setScrapContainer(n nVar, boolean z2) {
            this.mScrapContainer = nVar;
            this.mInChangeScrap = z2;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldBeKeptAsChild() {
            return (this.mFlags & 16) != 0;
        }

        /* access modifiers changed from: package-private */
        public boolean shouldIgnore() {
            return (this.mFlags & 128) != 0;
        }

        /* access modifiers changed from: package-private */
        public void stopIgnoring() {
            this.mFlags &= -129;
        }

        public String toString() {
            String simpleName = getClass().isAnonymousClass() ? "ViewHolder" : getClass().getSimpleName();
            StringBuilder sb = new StringBuilder(simpleName + "{" + Integer.toHexString(hashCode()) + " position=" + this.mPosition + " id=" + this.mItemId + ", oldPos=" + this.mOldPosition + ", pLpos:" + this.mPreLayoutPosition);
            if (isScrap()) {
                sb.append(" scrap ");
                sb.append(this.mInChangeScrap ? "[changeScrap]" : "[attachedScrap]");
            }
            if (isInvalid()) {
                sb.append(" invalid");
            }
            if (!isBound()) {
                sb.append(" unbound");
            }
            if (needsUpdate()) {
                sb.append(" update");
            }
            if (isRemoved()) {
                sb.append(" removed");
            }
            if (shouldIgnore()) {
                sb.append(" ignored");
            }
            if (isTmpDetached()) {
                sb.append(" tmpDetached");
            }
            if (!isRecyclable()) {
                sb.append(" not recyclable(" + this.mIsRecyclableCount + ")");
            }
            if (isAdapterPositionUnknown()) {
                sb.append(" undefined adapter position");
            }
            if (this.itemView.getParent() == null) {
                sb.append(" no parent");
            }
            sb.append("}");
            return sb.toString();
        }

        /* access modifiers changed from: package-private */
        public void unScrap() {
            this.mScrapContainer.c(this);
        }

        /* access modifiers changed from: package-private */
        public boolean wasReturnedFromScrap() {
            return (this.mFlags & 32) != 0;
        }
    }

    public RecyclerView(Context context) {
        this(context, (AttributeSet) null);
    }

    public RecyclerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.recyclerViewStyle);
    }

    public RecyclerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.R = new p();
        this.f3913e = new n();
        this.f3917i = new z();
        this.f3919k = new Runnable() {
            public void run() {
                if (RecyclerView.this.f3930v && !RecyclerView.this.isLayoutRequested()) {
                    if (!RecyclerView.this.f3927s) {
                        RecyclerView.this.requestLayout();
                    } else if (RecyclerView.this.f3932x) {
                        RecyclerView.this.f3931w = true;
                    } else {
                        RecyclerView.this.d();
                    }
                }
            }
        };
        this.f3920l = new Rect();
        this.S = new Rect();
        this.f3921m = new RectF();
        this.f3925q = new ArrayList();
        this.f3926r = new ArrayList<>();
        this.T = new ArrayList<>();
        this.V = 0;
        this.f3934z = false;
        this.A = false;
        this.f3890ad = 0;
        this.f3891ae = 0;
        this.f3892af = new d();
        this.B = new f();
        this.f3897ak = 0;
        this.f3898al = -1;
        this.f3908av = Float.MIN_VALUE;
        this.f3909aw = Float.MIN_VALUE;
        boolean z2 = true;
        this.f3910ax = true;
        this.C = new u();
        this.E = f3886d ? new j.a() : null;
        this.F = new s();
        this.G = false;
        this.H = false;
        this.aA = new f();
        this.I = false;
        this.aC = new int[2];
        this.aE = new int[2];
        this.aF = new int[2];
        this.K = new int[2];
        this.L = new ArrayList();
        this.aG = new Runnable() {
            public void run() {
                if (RecyclerView.this.B != null) {
                    RecyclerView.this.B.a();
                }
                RecyclerView.this.I = false;
            }
        };
        this.aI = 0;
        this.aJ = 0;
        this.aK = new z.b() {
            public void a(v vVar) {
                RecyclerView.this.f3923o.a(vVar.itemView, RecyclerView.this.f3913e);
            }

            public void a(v vVar, e.c cVar, e.c cVar2) {
                RecyclerView.this.f3913e.c(vVar);
                RecyclerView.this.b(vVar, cVar, cVar2);
            }

            public void b(v vVar, e.c cVar, e.c cVar2) {
                RecyclerView.this.a(vVar, cVar, cVar2);
            }

            public void c(v vVar, e.c cVar, e.c cVar2) {
                vVar.setIsRecyclable(false);
                if (RecyclerView.this.f3934z) {
                    if (!RecyclerView.this.B.a(vVar, vVar, cVar, cVar2)) {
                        return;
                    }
                } else if (!RecyclerView.this.B.c(vVar, cVar, cVar2)) {
                    return;
                }
                RecyclerView.this.p();
            }
        };
        setScrollContainer(true);
        setFocusableInTouchMode(true);
        ViewConfiguration viewConfiguration = ViewConfiguration.get(context);
        this.f3904ar = viewConfiguration.getScaledTouchSlop();
        this.f3908av = ad.a(viewConfiguration, context);
        this.f3909aw = ad.b(viewConfiguration, context);
        this.f3906at = viewConfiguration.getScaledMinimumFlingVelocity();
        this.f3907au = viewConfiguration.getScaledMaximumFlingVelocity();
        setWillNotDraw(getOverScrollMode() == 2);
        this.B.a(this.aA);
        b();
        z();
        y();
        if (ac.f(this) == 0) {
            ac.b((View) this, 1);
        }
        this.f3888ab = (AccessibilityManager) getContext().getSystemService("accessibility");
        setAccessibilityDelegateCompat(new u(this));
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.RecyclerView, i2, 0);
        ac.a(this, context, R.styleable.RecyclerView, attributeSet, obtainStyledAttributes, i2, 0);
        String string = obtainStyledAttributes.getString(R.styleable.RecyclerView_layoutManager);
        if (obtainStyledAttributes.getInt(R.styleable.RecyclerView_android_descendantFocusability, -1) == -1) {
            setDescendantFocusability(262144);
        }
        this.f3918j = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_android_clipToPadding, true);
        boolean z3 = obtainStyledAttributes.getBoolean(R.styleable.RecyclerView_fastScrollEnabled, false);
        this.f3929u = z3;
        if (z3) {
            a((StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollVerticalThumbDrawable), obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollVerticalTrackDrawable), (StateListDrawable) obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalThumbDrawable), obtainStyledAttributes.getDrawable(R.styleable.RecyclerView_fastScrollHorizontalTrackDrawable));
        }
        obtainStyledAttributes.recycle();
        a(context, string, attributeSet, i2, 0);
        if (Build.VERSION.SDK_INT >= 21) {
            int[] iArr = N;
            TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, iArr, i2, 0);
            ac.a(this, context, iArr, attributeSet, obtainStyledAttributes2, i2, 0);
            z2 = obtainStyledAttributes2.getBoolean(0, true);
            obtainStyledAttributes2.recycle();
        }
        setNestedScrollingEnabled(z2);
    }

    private boolean A() {
        int b2 = this.f3916h.b();
        for (int i2 = 0; i2 < b2; i2++) {
            v e2 = e(this.f3916h.b(i2));
            if (e2 != null && !e2.shouldIgnore() && e2.isUpdated()) {
                return true;
            }
        }
        return false;
    }

    private void B() {
        this.C.b();
        h hVar = this.f3923o;
        if (hVar != null) {
            hVar.M();
        }
    }

    private void C() {
        boolean z2;
        EdgeEffect edgeEffect = this.f3893ag;
        if (edgeEffect != null) {
            edgeEffect.onRelease();
            z2 = this.f3893ag.isFinished();
        } else {
            z2 = false;
        }
        EdgeEffect edgeEffect2 = this.f3894ah;
        if (edgeEffect2 != null) {
            edgeEffect2.onRelease();
            z2 |= this.f3894ah.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f3895ai;
        if (edgeEffect3 != null) {
            edgeEffect3.onRelease();
            z2 |= this.f3895ai.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f3896aj;
        if (edgeEffect4 != null) {
            edgeEffect4.onRelease();
            z2 |= this.f3896aj.isFinished();
        }
        if (z2) {
            ac.e(this);
        }
    }

    private void D() {
        VelocityTracker velocityTracker = this.f3899am;
        if (velocityTracker != null) {
            velocityTracker.clear();
        }
        j(0);
        C();
    }

    private void E() {
        D();
        setScrollState(0);
    }

    private void F() {
        int i2 = this.f3887aa;
        this.f3887aa = 0;
        if (i2 != 0 && n()) {
            AccessibilityEvent obtain = AccessibilityEvent.obtain();
            obtain.setEventType(2048);
            u.b.a(obtain, i2);
            sendAccessibilityEventUnchecked(obtain);
        }
    }

    private boolean G() {
        return this.B != null && this.f3923o.c();
    }

    private void H() {
        if (this.f3934z) {
            this.f3915g.a();
            if (this.A) {
                this.f3923o.a(this);
            }
        }
        if (G()) {
            this.f3915g.b();
        } else {
            this.f3915g.e();
        }
        boolean z2 = false;
        boolean z3 = this.G || this.H;
        this.F.f4025j = this.f3930v && this.B != null && (this.f3934z || z3 || this.f3923o.f3974u) && (!this.f3934z || this.f3922n.hasStableIds());
        s sVar = this.F;
        if (sVar.f4025j && z3 && !this.f3934z && G()) {
            z2 = true;
        }
        sVar.f4026k = z2;
    }

    private void I() {
        v vVar = null;
        View focusedChild = (!this.f3910ax || !hasFocus() || this.f3922n == null) ? null : getFocusedChild();
        if (focusedChild != null) {
            vVar = d(focusedChild);
        }
        if (vVar == null) {
            J();
            return;
        }
        this.F.f4028m = this.f3922n.hasStableIds() ? vVar.getItemId() : -1;
        this.F.f4027l = this.f3934z ? -1 : vVar.isRemoved() ? vVar.mOldPosition : vVar.getAbsoluteAdapterPosition();
        this.F.f4029n = n(vVar.itemView);
    }

    private void J() {
        this.F.f4028m = -1;
        this.F.f4027l = -1;
        this.F.f4029n = -1;
    }

    private View K() {
        v e2;
        int i2 = this.F.f4027l != -1 ? this.F.f4027l : 0;
        int e3 = this.F.e();
        int i3 = i2;
        while (i3 < e3) {
            v e4 = e(i3);
            if (e4 == null) {
                break;
            } else if (e4.itemView.hasFocusable()) {
                return e4.itemView;
            } else {
                i3++;
            }
        }
        int min = Math.min(e3, i2);
        while (true) {
            min--;
            if (min < 0 || (e2 = e(min)) == null) {
                return null;
            }
            if (e2.itemView.hasFocusable()) {
                return e2.itemView;
            }
        }
    }

    private void L() {
        View findViewById;
        if (this.f3910ax && this.f3922n != null && hasFocus() && getDescendantFocusability() != 393216) {
            if (getDescendantFocusability() != 131072 || !isFocused()) {
                if (!isFocused()) {
                    View focusedChild = getFocusedChild();
                    if (!P || (focusedChild.getParent() != null && focusedChild.hasFocus())) {
                        if (!this.f3916h.c(focusedChild)) {
                            return;
                        }
                    } else if (this.f3916h.b() == 0) {
                        requestFocus();
                        return;
                    }
                }
                View view = null;
                v a2 = (this.F.f4028m == -1 || !this.f3922n.hasStableIds()) ? null : a(this.F.f4028m);
                if (a2 != null && !this.f3916h.c(a2.itemView) && a2.itemView.hasFocusable()) {
                    view = a2.itemView;
                } else if (this.f3916h.b() > 0) {
                    view = K();
                }
                if (view != null) {
                    if (!(((long) this.F.f4029n) == -1 || (findViewById = view.findViewById(this.F.f4029n)) == null || !findViewById.isFocusable())) {
                        view = findViewById;
                    }
                    view.requestFocus();
                }
            }
        }
    }

    private void M() {
        boolean z2 = true;
        this.F.a(1);
        a(this.F);
        this.F.f4024i = false;
        e();
        this.f3917i.a();
        l();
        H();
        I();
        s sVar = this.F;
        if (!sVar.f4025j || !this.H) {
            z2 = false;
        }
        sVar.f4023h = z2;
        this.H = false;
        this.G = false;
        s sVar2 = this.F;
        sVar2.f4022g = sVar2.f4026k;
        this.F.f4020e = this.f3922n.getItemCount();
        a(this.aC);
        if (this.F.f4025j) {
            int b2 = this.f3916h.b();
            for (int i2 = 0; i2 < b2; i2++) {
                v e2 = e(this.f3916h.b(i2));
                if (!e2.shouldIgnore() && (!e2.isInvalid() || this.f3922n.hasStableIds())) {
                    this.f3917i.a(e2, this.B.a(this.F, e2, e.e(e2), e2.getUnmodifiedPayloads()));
                    if (this.F.f4023h && e2.isUpdated() && !e2.isRemoved() && !e2.shouldIgnore() && !e2.isInvalid()) {
                        this.f3917i.a(a(e2), e2);
                    }
                }
            }
        }
        if (this.F.f4026k) {
            s();
            boolean z3 = this.F.f4021f;
            this.F.f4021f = false;
            this.f3923o.c(this.f3913e, this.F);
            this.F.f4021f = z3;
            for (int i3 = 0; i3 < this.f3916h.b(); i3++) {
                v e3 = e(this.f3916h.b(i3));
                if (!e3.shouldIgnore() && !this.f3917i.d(e3)) {
                    int e4 = e.e(e3);
                    boolean hasAnyOfTheFlags = e3.hasAnyOfTheFlags(8192);
                    if (!hasAnyOfTheFlags) {
                        e4 |= 4096;
                    }
                    e.c a2 = this.B.a(this.F, e3, e4, e3.getUnmodifiedPayloads());
                    if (hasAnyOfTheFlags) {
                        a(e3, a2);
                    } else {
                        this.f3917i.b(e3, a2);
                    }
                }
            }
        }
        t();
        m();
        a(false);
        this.F.f4019d = 2;
    }

    private void N() {
        e();
        l();
        this.F.a(6);
        this.f3915g.e();
        this.F.f4020e = this.f3922n.getItemCount();
        this.F.f4018c = 0;
        if (this.f3914f != null && this.f3922n.canRestoreState()) {
            if (this.f3914f.f3949a != null) {
                this.f3923o.a(this.f3914f.f3949a);
            }
            this.f3914f = null;
        }
        this.F.f4022g = false;
        this.f3923o.c(this.f3913e, this.F);
        this.F.f4021f = false;
        s sVar = this.F;
        sVar.f4025j = sVar.f4025j && this.B != null;
        this.F.f4019d = 4;
        m();
        a(false);
    }

    private void O() {
        this.F.a(4);
        e();
        l();
        this.F.f4019d = 1;
        if (this.F.f4025j) {
            for (int b2 = this.f3916h.b() - 1; b2 >= 0; b2--) {
                v e2 = e(this.f3916h.b(b2));
                if (!e2.shouldIgnore()) {
                    long a2 = a(e2);
                    e.c a3 = this.B.a(this.F, e2);
                    v a4 = this.f3917i.a(a2);
                    if (a4 != null && !a4.shouldIgnore()) {
                        boolean a5 = this.f3917i.a(a4);
                        boolean a6 = this.f3917i.a(e2);
                        if (!a5 || a4 != e2) {
                            e.c b3 = this.f3917i.b(a4);
                            this.f3917i.c(e2, a3);
                            e.c c2 = this.f3917i.c(e2);
                            if (b3 == null) {
                                a(a2, e2, a4);
                            } else {
                                a(a4, e2, b3, c2, a5, a6);
                            }
                        }
                    }
                    this.f3917i.c(e2, a3);
                }
            }
            this.f3917i.a(this.aK);
        }
        this.f3923o.b(this.f3913e);
        s sVar = this.F;
        sVar.f4017b = sVar.f4020e;
        this.f3934z = false;
        this.A = false;
        this.F.f4025j = false;
        this.F.f4026k = false;
        this.f3923o.f3974u = false;
        if (this.f3913e.f3992b != null) {
            this.f3913e.f3992b.clear();
        }
        if (this.f3923o.f3978y) {
            this.f3923o.f3977x = 0;
            this.f3923o.f3978y = false;
            this.f3913e.b();
        }
        this.f3923o.a(this.F);
        m();
        a(false);
        this.f3917i.a();
        int[] iArr = this.aC;
        if (k(iArr[0], iArr[1])) {
            i(0, 0);
        }
        L();
        J();
    }

    private String a(Context context, String str) {
        if (str.charAt(0) == '.') {
            return context.getPackageName() + str;
        } else if (str.contains(".")) {
            return str;
        } else {
            return RecyclerView.class.getPackage().getName() + '.' + str;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x003d  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0079  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(float r7, float r8, float r9, float r10) {
        /*
            r6 = this;
            r0 = 1065353216(0x3f800000, float:1.0)
            r1 = 1
            r2 = 0
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0021
            r6.g()
            android.widget.EdgeEffect r3 = r6.f3893ag
            float r4 = -r8
            int r5 = r6.getWidth()
            float r5 = (float) r5
            float r4 = r4 / r5
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            float r9 = r0 - r9
        L_0x001c:
            androidx.core.widget.d.a(r3, r4, r9)
            r9 = 1
            goto L_0x0039
        L_0x0021:
            int r3 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x0038
            r6.h()
            android.widget.EdgeEffect r3 = r6.f3895ai
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r4 = r8 / r4
            int r5 = r6.getHeight()
            float r5 = (float) r5
            float r9 = r9 / r5
            goto L_0x001c
        L_0x0038:
            r9 = 0
        L_0x0039:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 >= 0) goto L_0x0053
            r6.i()
            android.widget.EdgeEffect r9 = r6.f3894ah
            float r0 = -r10
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r0 = r0 / r3
            int r3 = r6.getWidth()
            float r3 = (float) r3
            float r7 = r7 / r3
            androidx.core.widget.d.a(r9, r0, r7)
            goto L_0x006f
        L_0x0053:
            int r3 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r3 <= 0) goto L_0x006e
            r6.j()
            android.widget.EdgeEffect r9 = r6.f3896aj
            int r3 = r6.getHeight()
            float r3 = (float) r3
            float r3 = r10 / r3
            int r4 = r6.getWidth()
            float r4 = (float) r4
            float r7 = r7 / r4
            float r0 = r0 - r7
            androidx.core.widget.d.a(r9, r3, r0)
            goto L_0x006f
        L_0x006e:
            r1 = r9
        L_0x006f:
            if (r1 != 0) goto L_0x0079
            int r7 = (r8 > r2 ? 1 : (r8 == r2 ? 0 : -1))
            if (r7 != 0) goto L_0x0079
            int r7 = (r10 > r2 ? 1 : (r10 == r2 ? 0 : -1))
            if (r7 == 0) goto L_0x007c
        L_0x0079:
            t.ac.e(r6)
        L_0x007c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.a(float, float, float, float):void");
    }

    private void a(long j2, v vVar, v vVar2) {
        int b2 = this.f3916h.b();
        for (int i2 = 0; i2 < b2; i2++) {
            v e2 = e(this.f3916h.b(i2));
            if (e2 != vVar && a(e2) == j2) {
                Adapter adapter = this.f3922n;
                if (adapter == null || !adapter.hasStableIds()) {
                    throw new IllegalStateException("Two different ViewHolders have the same change ID. This might happen due to inconsistent Adapter update events or if the LayoutManager lays out the same View multiple times.\n ViewHolder 1:" + e2 + " \n View Holder 2:" + vVar + a());
                }
                throw new IllegalStateException("Two different ViewHolders have the same stable ID. Stable IDs in your adapter MUST BE unique and SHOULD NOT change.\n ViewHolder 1:" + e2 + " \n View Holder 2:" + vVar + a());
            }
        }
        Log.e("RecyclerView", "Problem while matching changed view holders with the newones. The pre-layout information for the change holder " + vVar2 + " cannot be found but it is necessary for " + vVar + a());
    }

    private void a(Context context, String str, AttributeSet attributeSet, int i2, int i3) {
        Constructor<? extends U> constructor;
        if (str != null) {
            String trim = str.trim();
            if (!trim.isEmpty()) {
                String a2 = a(context, trim);
                try {
                    Class<? extends U> asSubclass = Class.forName(a2, false, isInEditMode() ? getClass().getClassLoader() : context.getClassLoader()).asSubclass(h.class);
                    Object[] objArr = null;
                    try {
                        constructor = asSubclass.getConstructor(Q);
                        objArr = new Object[]{context, attributeSet, Integer.valueOf(i2), Integer.valueOf(i3)};
                    } catch (NoSuchMethodException e2) {
                        constructor = asSubclass.getConstructor(new Class[0]);
                    }
                    constructor.setAccessible(true);
                    setLayoutManager((h) constructor.newInstance(objArr));
                } catch (NoSuchMethodException e3) {
                    e3.initCause(e2);
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Error creating LayoutManager " + a2, e3);
                } catch (ClassNotFoundException e4) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Unable to find LayoutManager " + a2, e4);
                } catch (InvocationTargetException e5) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a2, e5);
                } catch (InstantiationException e6) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Could not instantiate the LayoutManager: " + a2, e6);
                } catch (IllegalAccessException e7) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Cannot access non-public constructor " + a2, e7);
                } catch (ClassCastException e8) {
                    throw new IllegalStateException(attributeSet.getPositionDescription() + ": Class is not a LayoutManager " + a2, e8);
                }
            }
        }
    }

    private void a(View view, View view2) {
        View view3 = view2 != null ? view2 : view;
        this.f3920l.set(0, 0, view3.getWidth(), view3.getHeight());
        ViewGroup.LayoutParams layoutParams = view3.getLayoutParams();
        if (layoutParams instanceof LayoutParams) {
            LayoutParams layoutParams2 = (LayoutParams) layoutParams;
            if (!layoutParams2.f3947e) {
                Rect rect = layoutParams2.f3946d;
                this.f3920l.left -= rect.left;
                this.f3920l.right += rect.right;
                this.f3920l.top -= rect.top;
                this.f3920l.bottom += rect.bottom;
            }
        }
        if (view2 != null) {
            offsetDescendantRectToMyCoords(view2, this.f3920l);
            offsetRectIntoDescendantCoords(view, this.f3920l);
        }
        this.f3923o.a(this, view, this.f3920l, !this.f3930v, view2 == null);
    }

    private void a(Adapter adapter, boolean z2, boolean z3) {
        Adapter adapter2 = this.f3922n;
        if (adapter2 != null) {
            adapter2.unregisterAdapterDataObserver(this.R);
            this.f3922n.onDetachedFromRecyclerView(this);
        }
        if (!z2 || z3) {
            c();
        }
        this.f3915g.a();
        Adapter adapter3 = this.f3922n;
        this.f3922n = adapter;
        if (adapter != null) {
            adapter.registerAdapterDataObserver(this.R);
            adapter.onAttachedToRecyclerView(this);
        }
        h hVar = this.f3923o;
        if (hVar != null) {
            hVar.a(adapter3, this.f3922n);
        }
        this.f3913e.a(adapter3, this.f3922n, z2);
        this.F.f4021f = true;
    }

    private void a(v vVar, v vVar2, e.c cVar, e.c cVar2, boolean z2, boolean z3) {
        vVar.setIsRecyclable(false);
        if (z2) {
            e(vVar);
        }
        if (vVar != vVar2) {
            if (z3) {
                e(vVar2);
            }
            vVar.mShadowedHolder = vVar2;
            e(vVar);
            this.f3913e.c(vVar);
            vVar2.setIsRecyclable(false);
            vVar2.mShadowingHolder = vVar;
        }
        if (this.B.a(vVar, vVar2, cVar, cVar2)) {
            p();
        }
    }

    private void a(int[] iArr) {
        int b2 = this.f3916h.b();
        if (b2 == 0) {
            iArr[0] = -1;
            iArr[1] = -1;
            return;
        }
        int i2 = SubsamplingScaleImageView.TILE_SIZE_AUTO;
        int i3 = Integer.MIN_VALUE;
        for (int i4 = 0; i4 < b2; i4++) {
            v e2 = e(this.f3916h.b(i4));
            if (!e2.shouldIgnore()) {
                int layoutPosition = e2.getLayoutPosition();
                if (layoutPosition < i2) {
                    i2 = layoutPosition;
                }
                if (layoutPosition > i3) {
                    i3 = layoutPosition;
                }
            }
        }
        iArr[0] = i2;
        iArr[1] = i3;
    }

    private boolean a(MotionEvent motionEvent) {
        k kVar = this.U;
        if (kVar != null) {
            kVar.b(this, motionEvent);
            int action = motionEvent.getAction();
            if (action == 3 || action == 1) {
                this.U = null;
            }
            return true;
        } else if (motionEvent.getAction() == 0) {
            return false;
        } else {
            return b(motionEvent);
        }
    }

    private boolean a(View view, View view2, int i2) {
        if (view2 == null || view2 == this || view2 == view || c(view2) == null) {
            return false;
        }
        if (view == null || c(view) == null) {
            return true;
        }
        this.f3920l.set(0, 0, view.getWidth(), view.getHeight());
        this.S.set(0, 0, view2.getWidth(), view2.getHeight());
        offsetDescendantRectToMyCoords(view, this.f3920l);
        offsetDescendantRectToMyCoords(view2, this.S);
        char c2 = 65535;
        int i3 = this.f3923o.x() == 1 ? -1 : 1;
        int i4 = ((this.f3920l.left < this.S.left || this.f3920l.right <= this.S.left) && this.f3920l.right < this.S.right) ? 1 : ((this.f3920l.right > this.S.right || this.f3920l.left >= this.S.right) && this.f3920l.left > this.S.left) ? -1 : 0;
        if ((this.f3920l.top < this.S.top || this.f3920l.bottom <= this.S.top) && this.f3920l.bottom < this.S.bottom) {
            c2 = 1;
        } else if ((this.f3920l.bottom <= this.S.bottom && this.f3920l.top < this.S.bottom) || this.f3920l.top <= this.S.top) {
            c2 = 0;
        }
        if (i2 == 1) {
            return c2 < 0 || (c2 == 0 && i4 * i3 < 0);
        }
        if (i2 == 2) {
            return c2 > 0 || (c2 == 0 && i4 * i3 > 0);
        }
        if (i2 == 17) {
            return i4 < 0;
        }
        if (i2 == 33) {
            return c2 < 0;
        }
        if (i2 == 66) {
            return i4 > 0;
        }
        if (i2 == 130) {
            return c2 > 0;
        }
        throw new IllegalArgumentException("Invalid direction: " + i2 + a());
    }

    private void b(int i2, int i3, MotionEvent motionEvent, int i4) {
        h hVar = this.f3923o;
        if (hVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f3932x) {
            int[] iArr = this.K;
            int i5 = 0;
            iArr[0] = 0;
            iArr[1] = 0;
            boolean f2 = hVar.f();
            boolean g2 = this.f3923o.g();
            int i6 = f2 ? 1 : 0;
            if (g2) {
                i6 |= 2;
            }
            j(i6, i4);
            if (a(f2 ? i2 : 0, g2 ? i3 : 0, this.K, this.aE, i4)) {
                int[] iArr2 = this.K;
                i2 -= iArr2[0];
                i3 -= iArr2[1];
            }
            int i7 = f2 ? i2 : 0;
            if (g2) {
                i5 = i3;
            }
            a(i7, i5, motionEvent, i4);
            j jVar = this.D;
            if (!(jVar == null || (i2 == 0 && i3 == 0))) {
                jVar.a(this, i2, i3);
            }
            j(i4);
        }
    }

    static void b(View view, Rect rect) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        Rect rect2 = layoutParams.f3946d;
        rect.set((view.getLeft() - rect2.left) - layoutParams.leftMargin, (view.getTop() - rect2.top) - layoutParams.topMargin, view.getRight() + rect2.right + layoutParams.rightMargin, view.getBottom() + rect2.bottom + layoutParams.bottomMargin);
    }

    private boolean b(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        int size = this.T.size();
        int i2 = 0;
        while (i2 < size) {
            k kVar = this.T.get(i2);
            if (!kVar.a(this, motionEvent) || action == 3) {
                i2++;
            } else {
                this.U = kVar;
                return true;
            }
        }
        return false;
    }

    private void c(MotionEvent motionEvent) {
        int actionIndex = motionEvent.getActionIndex();
        if (motionEvent.getPointerId(actionIndex) == this.f3898al) {
            int i2 = actionIndex == 0 ? 1 : 0;
            this.f3898al = motionEvent.getPointerId(i2);
            int x2 = (int) (motionEvent.getX(i2) + 0.5f);
            this.f3902ap = x2;
            this.f3900an = x2;
            int y2 = (int) (motionEvent.getY(i2) + 0.5f);
            this.f3903aq = y2;
            this.f3901ao = y2;
        }
    }

    static void c(v vVar) {
        if (vVar.mNestedRecyclerView != null) {
            Object obj = vVar.mNestedRecyclerView.get();
            while (true) {
                View view = (View) obj;
                while (true) {
                    if (view == null) {
                        vVar.mNestedRecyclerView = null;
                        return;
                    } else if (view != vVar.itemView) {
                        obj = view.getParent();
                        if (!(obj instanceof View)) {
                            view = null;
                        }
                    } else {
                        return;
                    }
                }
            }
        }
    }

    static v e(View view) {
        if (view == null) {
            return null;
        }
        return ((LayoutParams) view.getLayoutParams()).f3945c;
    }

    private void e(v vVar) {
        View view = vVar.itemView;
        boolean z2 = view.getParent() == this;
        this.f3913e.c(b(view));
        if (vVar.isTmpDetached()) {
            this.f3916h.a(view, -1, view.getLayoutParams(), true);
            return;
        }
        d dVar = this.f3916h;
        if (!z2) {
            dVar.a(view, true);
        } else {
            dVar.d(view);
        }
    }

    private t.p getScrollingChildHelper() {
        if (this.aD == null) {
            this.aD = new t.p(this);
        }
        return this.aD;
    }

    static RecyclerView k(View view) {
        if (!(view instanceof ViewGroup)) {
            return null;
        }
        if (view instanceof RecyclerView) {
            return (RecyclerView) view;
        }
        ViewGroup viewGroup = (ViewGroup) view;
        int childCount = viewGroup.getChildCount();
        for (int i2 = 0; i2 < childCount; i2++) {
            RecyclerView k2 = k(viewGroup.getChildAt(i2));
            if (k2 != null) {
                return k2;
            }
        }
        return null;
    }

    private boolean k(int i2, int i3) {
        a(this.aC);
        int[] iArr = this.aC;
        return (iArr[0] == i2 && iArr[1] == i3) ? false : true;
    }

    private int n(View view) {
        int id2;
        loop0:
        while (true) {
            id2 = view.getId();
            while (true) {
                if (view.isFocused() || !(view instanceof ViewGroup) || !view.hasFocus()) {
                    return id2;
                }
                view = ((ViewGroup) view).getFocusedChild();
                if (view.getId() != -1) {
                }
            }
        }
        return id2;
    }

    private void y() {
        if (ac.a(this) == 0) {
            ac.a((View) this, 8);
        }
    }

    private void z() {
        this.f3916h = new d(new d.b() {
            public int a() {
                return RecyclerView.this.getChildCount();
            }

            public int a(View view) {
                return RecyclerView.this.indexOfChild(view);
            }

            public void a(int i2) {
                View childAt = RecyclerView.this.getChildAt(i2);
                if (childAt != null) {
                    RecyclerView.this.l(childAt);
                    childAt.clearAnimation();
                }
                RecyclerView.this.removeViewAt(i2);
            }

            public void a(View view, int i2) {
                RecyclerView.this.addView(view, i2);
                RecyclerView.this.m(view);
            }

            public void a(View view, int i2, ViewGroup.LayoutParams layoutParams) {
                v e2 = RecyclerView.e(view);
                if (e2 != null) {
                    if (e2.isTmpDetached() || e2.shouldIgnore()) {
                        e2.clearTmpDetachFlag();
                    } else {
                        throw new IllegalArgumentException("Called attach on a child which is not detached: " + e2 + RecyclerView.this.a());
                    }
                }
                RecyclerView.this.attachViewToParent(view, i2, layoutParams);
            }

            public View b(int i2) {
                return RecyclerView.this.getChildAt(i2);
            }

            public v b(View view) {
                return RecyclerView.e(view);
            }

            public void b() {
                int a2 = a();
                for (int i2 = 0; i2 < a2; i2++) {
                    View b2 = b(i2);
                    RecyclerView.this.l(b2);
                    b2.clearAnimation();
                }
                RecyclerView.this.removeAllViews();
            }

            public void c(int i2) {
                v e2;
                View b2 = b(i2);
                if (!(b2 == null || (e2 = RecyclerView.e(b2)) == null)) {
                    if (!e2.isTmpDetached() || e2.shouldIgnore()) {
                        e2.addFlags(256);
                    } else {
                        throw new IllegalArgumentException("called detach on an already detached child " + e2 + RecyclerView.this.a());
                    }
                }
                RecyclerView.this.detachViewFromParent(i2);
            }

            public void c(View view) {
                v e2 = RecyclerView.e(view);
                if (e2 != null) {
                    e2.onEnteredHiddenState(RecyclerView.this);
                }
            }

            public void d(View view) {
                v e2 = RecyclerView.e(view);
                if (e2 != null) {
                    e2.onLeftHiddenState(RecyclerView.this);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public long a(v vVar) {
        return this.f3922n.hasStableIds() ? vVar.getItemId() : (long) vVar.mPosition;
    }

    public View a(float f2, float f3) {
        for (int b2 = this.f3916h.b() - 1; b2 >= 0; b2--) {
            View b3 = this.f3916h.b(b2);
            float translationX = b3.getTranslationX();
            float translationY = b3.getTranslationY();
            if (f2 >= ((float) b3.getLeft()) + translationX && f2 <= ((float) b3.getRight()) + translationX && f3 >= ((float) b3.getTop()) + translationY && f3 <= ((float) b3.getBottom()) + translationY) {
                return b3;
            }
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    public v a(int i2, boolean z2) {
        int c2 = this.f3916h.c();
        v vVar = null;
        for (int i3 = 0; i3 < c2; i3++) {
            v e2 = e(this.f3916h.d(i3));
            if (e2 != null && !e2.isRemoved()) {
                if (z2) {
                    if (e2.mPosition != i2) {
                        continue;
                    }
                } else if (e2.getLayoutPosition() != i2) {
                    continue;
                }
                if (!this.f3916h.c(e2.itemView)) {
                    return e2;
                }
                vVar = e2;
            }
        }
        return vVar;
    }

    public v a(long j2) {
        Adapter adapter = this.f3922n;
        v vVar = null;
        if (adapter != null && adapter.hasStableIds()) {
            int c2 = this.f3916h.c();
            for (int i2 = 0; i2 < c2; i2++) {
                v e2 = e(this.f3916h.d(i2));
                if (e2 != null && !e2.isRemoved() && e2.getItemId() == j2) {
                    if (!this.f3916h.c(e2.itemView)) {
                        return e2;
                    }
                    vVar = e2;
                }
            }
        }
        return vVar;
    }

    /* access modifiers changed from: package-private */
    public String a() {
        return " " + super.toString() + ", adapter:" + this.f3922n + ", layout:" + this.f3923o + ", context:" + getContext();
    }

    public void a(int i2) {
        if (!this.f3932x) {
            f();
            h hVar = this.f3923o;
            if (hVar == null) {
                Log.e("RecyclerView", "Cannot scroll to position a LayoutManager set. Call setLayoutManager with a non-null argument.");
                return;
            }
            hVar.e(i2);
            awakenScrollBars();
        }
    }

    public void a(int i2, int i3) {
        a(i2, i3, (Interpolator) null);
    }

    public final void a(int i2, int i3, int i4, int i5, int[] iArr, int i6, int[] iArr2) {
        getScrollingChildHelper().a(i2, i3, i4, i5, iArr, i6, iArr2);
    }

    public void a(int i2, int i3, Interpolator interpolator) {
        a(i2, i3, interpolator, Integer.MIN_VALUE);
    }

    public void a(int i2, int i3, Interpolator interpolator, int i4) {
        a(i2, i3, interpolator, i4, false);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, Interpolator interpolator, int i4, boolean z2) {
        h hVar = this.f3923o;
        if (hVar == null) {
            Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f3932x) {
            int i5 = 0;
            if (!hVar.f()) {
                i2 = 0;
            }
            if (!this.f3923o.g()) {
                i3 = 0;
            }
            if (i2 != 0 || i3 != 0) {
                if (i4 == Integer.MIN_VALUE || i4 > 0) {
                    if (z2) {
                        if (i2 != 0) {
                            i5 = 1;
                        }
                        if (i3 != 0) {
                            i5 |= 2;
                        }
                        j(i5, 1);
                    }
                    this.C.a(i2, i3, i4, interpolator);
                    return;
                }
                scrollBy(i2, i3);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, Object obj) {
        int c2 = this.f3916h.c();
        int i4 = i2 + i3;
        for (int i5 = 0; i5 < c2; i5++) {
            View d2 = this.f3916h.d(i5);
            v e2 = e(d2);
            if (e2 != null && !e2.shouldIgnore() && e2.mPosition >= i2 && e2.mPosition < i4) {
                e2.addFlags(2);
                e2.addChangePayload(obj);
                ((LayoutParams) d2.getLayoutParams()).f3947e = true;
            }
        }
        this.f3913e.c(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, boolean z2) {
        int i4 = i2 + i3;
        int c2 = this.f3916h.c();
        for (int i5 = 0; i5 < c2; i5++) {
            v e2 = e(this.f3916h.d(i5));
            if (e2 != null && !e2.shouldIgnore()) {
                if (e2.mPosition >= i4) {
                    e2.offsetPosition(-i3, z2);
                } else if (e2.mPosition >= i2) {
                    e2.flagRemovedAndOffsetPosition(i2 - 1, -i3, z2);
                }
                this.F.f4021f = true;
            }
        }
        this.f3913e.a(i2, i3, z2);
        requestLayout();
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, int i3, int[] iArr) {
        e();
        l();
        androidx.core.os.i.a("RV Scroll");
        a(this.F);
        int a2 = i2 != 0 ? this.f3923o.a(i2, this.f3913e, this.F) : 0;
        int b2 = i3 != 0 ? this.f3923o.b(i3, this.f3913e, this.F) : 0;
        androidx.core.os.i.a();
        w();
        m();
        a(false);
        if (iArr != null) {
            iArr[0] = a2;
            iArr[1] = b2;
        }
    }

    /* access modifiers changed from: package-private */
    public void a(StateListDrawable stateListDrawable, Drawable drawable, StateListDrawable stateListDrawable2, Drawable drawable2) {
        if (stateListDrawable == null || drawable == null || stateListDrawable2 == null || drawable2 == null) {
            throw new IllegalArgumentException("Trying to set fast scroller without both required drawables." + a());
        }
        Resources resources = getContext().getResources();
        new i(this, stateListDrawable, drawable, stateListDrawable2, drawable2, resources.getDimensionPixelSize(R.dimen.fastscroll_default_thickness), resources.getDimensionPixelSize(R.dimen.fastscroll_minimum_range), resources.getDimensionPixelOffset(R.dimen.fastscroll_margin));
    }

    public void a(View view, Rect rect) {
        b(view, rect);
    }

    public void a(g gVar) {
        a(gVar, -1);
    }

    public void a(g gVar, int i2) {
        h hVar = this.f3923o;
        if (hVar != null) {
            hVar.a("Cannot add item decoration during a scroll  or layout");
        }
        if (this.f3926r.isEmpty()) {
            setWillNotDraw(false);
        }
        if (i2 < 0) {
            this.f3926r.add(gVar);
        } else {
            this.f3926r.add(i2, gVar);
        }
        r();
        requestLayout();
    }

    public void a(i iVar) {
        if (this.f3889ac == null) {
            this.f3889ac = new ArrayList();
        }
        this.f3889ac.add(iVar);
    }

    public void a(k kVar) {
        this.T.add(kVar);
    }

    public void a(l lVar) {
        if (this.f3912az == null) {
            this.f3912az = new ArrayList();
        }
        this.f3912az.add(lVar);
    }

    /* access modifiers changed from: package-private */
    public final void a(s sVar) {
        if (getScrollState() == 2) {
            OverScroller overScroller = this.C.f4033a;
            sVar.f4030o = overScroller.getFinalX() - overScroller.getCurrX();
            sVar.f4031p = overScroller.getFinalY() - overScroller.getCurrY();
            return;
        }
        sVar.f4030o = 0;
        sVar.f4031p = 0;
    }

    /* access modifiers changed from: package-private */
    public void a(v vVar, e.c cVar) {
        vVar.setFlags(0, 8192);
        if (this.F.f4023h && vVar.isUpdated() && !vVar.isRemoved() && !vVar.shouldIgnore()) {
            this.f3917i.a(a(vVar), vVar);
        }
        this.f3917i.a(vVar, cVar);
    }

    /* access modifiers changed from: package-private */
    public void a(v vVar, e.c cVar, e.c cVar2) {
        vVar.setIsRecyclable(false);
        if (this.B.b(vVar, cVar, cVar2)) {
            p();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(String str) {
        if (o()) {
            if (str == null) {
                throw new IllegalStateException("Cannot call this method while RecyclerView is computing a layout or scrolling" + a());
            }
            throw new IllegalStateException(str);
        } else if (this.f3891ae > 0) {
            Log.w("RecyclerView", "Cannot call this method in a scroll callback. Scroll callbacks mightbe run during a measure & layout pass where you cannot change theRecyclerView data. Any method call that might change the structureof the RecyclerView or the adapter contents should be postponed tothe next frame.", new IllegalStateException("" + a()));
        }
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        if (this.V < 1) {
            this.V = 1;
        }
        if (!z2 && !this.f3932x) {
            this.f3931w = false;
        }
        if (this.V == 1) {
            if (z2 && this.f3931w && !this.f3932x && this.f3923o != null && this.f3922n != null) {
                q();
            }
            if (!this.f3932x) {
                this.f3931w = false;
            }
        }
        this.V--;
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2, int i3, MotionEvent motionEvent, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        int i9 = i2;
        int i10 = i3;
        MotionEvent motionEvent2 = motionEvent;
        d();
        if (this.f3922n != null) {
            int[] iArr = this.K;
            iArr[0] = 0;
            iArr[1] = 0;
            a(i9, i10, iArr);
            int[] iArr2 = this.K;
            int i11 = iArr2[0];
            int i12 = iArr2[1];
            i8 = i12;
            i7 = i11;
            i6 = i9 - i11;
            i5 = i10 - i12;
        } else {
            i8 = 0;
            i7 = 0;
            i6 = 0;
            i5 = 0;
        }
        if (!this.f3926r.isEmpty()) {
            invalidate();
        }
        int[] iArr3 = this.K;
        iArr3[0] = 0;
        iArr3[1] = 0;
        a(i7, i8, i6, i5, this.aE, i4, iArr3);
        int[] iArr4 = this.K;
        int i13 = i6 - iArr4[0];
        int i14 = i5 - iArr4[1];
        boolean z2 = (iArr4[0] == 0 && iArr4[1] == 0) ? false : true;
        int i15 = this.f3902ap;
        int[] iArr5 = this.aE;
        this.f3902ap = i15 - iArr5[0];
        this.f3903aq -= iArr5[1];
        int[] iArr6 = this.aF;
        iArr6[0] = iArr6[0] + iArr5[0];
        iArr6[1] = iArr6[1] + iArr5[1];
        if (getOverScrollMode() != 2) {
            if (motionEvent2 != null && !t.l.e(motionEvent2, 8194)) {
                a(motionEvent.getX(), (float) i13, motionEvent.getY(), (float) i14);
            }
            c(i2, i3);
        }
        if (!(i7 == 0 && i8 == 0)) {
            i(i7, i8);
        }
        if (!awakenScrollBars()) {
            invalidate();
        }
        return (!z2 && i7 == 0 && i8 == 0) ? false : true;
    }

    public boolean a(int i2, int i3, int[] iArr, int[] iArr2, int i4) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2, i4);
    }

    /* access modifiers changed from: package-private */
    public boolean a(View view) {
        e();
        boolean f2 = this.f3916h.f(view);
        if (f2) {
            v e2 = e(view);
            this.f3913e.c(e2);
            this.f3913e.b(e2);
        }
        a(!f2);
        return f2;
    }

    /* access modifiers changed from: package-private */
    public boolean a(AccessibilityEvent accessibilityEvent) {
        int i2 = 0;
        if (!o()) {
            return false;
        }
        int a2 = accessibilityEvent != null ? u.b.a(accessibilityEvent) : 0;
        if (a2 != 0) {
            i2 = a2;
        }
        this.f3887aa |= i2;
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(v vVar, int i2) {
        if (o()) {
            vVar.mPendingAccessibilityState = i2;
            this.L.add(vVar);
            return false;
        }
        ac.b(vVar.itemView, i2);
        return true;
    }

    public void addFocusables(ArrayList<View> arrayList, int i2, int i3) {
        h hVar = this.f3923o;
        if (hVar == null || !hVar.a(this, arrayList, i2, i3)) {
            super.addFocusables(arrayList, i2, i3);
        }
    }

    public v b(View view) {
        ViewParent parent = view.getParent();
        if (parent == null || parent == this) {
            return e(view);
        }
        throw new IllegalArgumentException("View " + view + " is not a direct child of " + this);
    }

    /* access modifiers changed from: package-private */
    public void b() {
        this.f3915g = new a(new a.C0035a() {
            public v a(int i2) {
                v a2 = RecyclerView.this.a(i2, true);
                if (a2 != null && !RecyclerView.this.f3916h.c(a2.itemView)) {
                    return a2;
                }
                return null;
            }

            public void a(int i2, int i3) {
                RecyclerView.this.a(i2, i3, true);
                RecyclerView.this.G = true;
                RecyclerView.this.F.f4018c += i3;
            }

            public void a(int i2, int i3, Object obj) {
                RecyclerView.this.a(i2, i3, obj);
                RecyclerView.this.H = true;
            }

            public void a(a.b bVar) {
                c(bVar);
            }

            public void b(int i2, int i3) {
                RecyclerView.this.a(i2, i3, false);
                RecyclerView.this.G = true;
            }

            public void b(a.b bVar) {
                c(bVar);
            }

            public void c(int i2, int i3) {
                RecyclerView.this.g(i2, i3);
                RecyclerView.this.G = true;
            }

            /* access modifiers changed from: package-private */
            public void c(a.b bVar) {
                int i2 = bVar.f4096a;
                if (i2 == 1) {
                    RecyclerView.this.f3923o.a(RecyclerView.this, bVar.f4097b, bVar.f4099d);
                } else if (i2 == 2) {
                    RecyclerView.this.f3923o.b(RecyclerView.this, bVar.f4097b, bVar.f4099d);
                } else if (i2 == 4) {
                    RecyclerView.this.f3923o.a(RecyclerView.this, bVar.f4097b, bVar.f4099d, bVar.f4098c);
                } else if (i2 == 8) {
                    RecyclerView.this.f3923o.a(RecyclerView.this, bVar.f4097b, bVar.f4099d, 1);
                }
            }

            public void d(int i2, int i3) {
                RecyclerView.this.f(i2, i3);
                RecyclerView.this.G = true;
            }
        });
    }

    /* access modifiers changed from: package-private */
    public void b(int i2) {
        if (this.f3923o != null) {
            setScrollState(2);
            this.f3923o.e(i2);
            awakenScrollBars();
        }
    }

    public void b(g gVar) {
        h hVar = this.f3923o;
        if (hVar != null) {
            hVar.a("Cannot remove item decoration during a scroll  or layout");
        }
        this.f3926r.remove(gVar);
        if (this.f3926r.isEmpty()) {
            setWillNotDraw(getOverScrollMode() == 2);
        }
        r();
        requestLayout();
    }

    public void b(i iVar) {
        List<i> list = this.f3889ac;
        if (list != null) {
            list.remove(iVar);
        }
    }

    public void b(k kVar) {
        this.T.remove(kVar);
        if (this.U == kVar) {
            this.U = null;
        }
    }

    public void b(l lVar) {
        List<l> list = this.f3912az;
        if (list != null) {
            list.remove(lVar);
        }
    }

    /* access modifiers changed from: package-private */
    public void b(v vVar, e.c cVar, e.c cVar2) {
        e(vVar);
        vVar.setIsRecyclable(false);
        if (this.B.a(vVar, cVar, cVar2)) {
            p();
        }
    }

    /* access modifiers changed from: package-private */
    public void b(boolean z2) {
        int i2 = this.f3890ad - 1;
        this.f3890ad = i2;
        if (i2 < 1) {
            this.f3890ad = 0;
            if (z2) {
                F();
                x();
            }
        }
    }

    public boolean b(int i2, int i3) {
        h hVar = this.f3923o;
        int i4 = 0;
        if (hVar == null) {
            Log.e("RecyclerView", "Cannot fling without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            return false;
        } else if (this.f3932x) {
            return false;
        } else {
            boolean f2 = hVar.f();
            boolean g2 = this.f3923o.g();
            if (!f2 || Math.abs(i2) < this.f3906at) {
                i2 = 0;
            }
            if (!g2 || Math.abs(i3) < this.f3906at) {
                i3 = 0;
            }
            if (i2 == 0 && i3 == 0) {
                return false;
            }
            float f3 = (float) i2;
            float f4 = (float) i3;
            if (!dispatchNestedPreFling(f3, f4)) {
                boolean z2 = f2 || g2;
                dispatchNestedFling(f3, f4, z2);
                j jVar = this.f3905as;
                if (jVar != null && jVar.a(i2, i3)) {
                    return true;
                }
                if (z2) {
                    if (f2) {
                        i4 = 1;
                    }
                    if (g2) {
                        i4 |= 2;
                    }
                    j(i4, 1);
                    int i5 = this.f3907au;
                    int max = Math.max(-i5, Math.min(i2, i5));
                    int i6 = this.f3907au;
                    this.C.a(max, Math.max(-i6, Math.min(i3, i6)));
                    return true;
                }
            }
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(v vVar) {
        e eVar = this.B;
        return eVar == null || eVar.a(vVar, vVar.getUnmodifiedPayloads());
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:7:0x0013 A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.view.View c(android.view.View r3) {
        /*
            r2 = this;
        L_0x0000:
            android.view.ViewParent r0 = r3.getParent()
            if (r0 == 0) goto L_0x0010
            if (r0 == r2) goto L_0x0010
            boolean r1 = r0 instanceof android.view.View
            if (r1 == 0) goto L_0x0010
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            goto L_0x0000
        L_0x0010:
            if (r0 != r2) goto L_0x0013
            goto L_0x0014
        L_0x0013:
            r3 = 0
        L_0x0014:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.c(android.view.View):android.view.View");
    }

    /* access modifiers changed from: package-private */
    public void c() {
        e eVar = this.B;
        if (eVar != null) {
            eVar.d();
        }
        h hVar = this.f3923o;
        if (hVar != null) {
            hVar.c(this.f3913e);
            this.f3923o.b(this.f3913e);
        }
        this.f3913e.a();
    }

    public void c(int i2) {
        if (!this.f3932x) {
            h hVar = this.f3923o;
            if (hVar == null) {
                Log.e("RecyclerView", "Cannot smooth scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
            } else {
                hVar.a(this, this.F, i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void c(int i2, int i3) {
        boolean z2;
        EdgeEffect edgeEffect = this.f3893ag;
        if (edgeEffect == null || edgeEffect.isFinished() || i2 <= 0) {
            z2 = false;
        } else {
            this.f3893ag.onRelease();
            z2 = this.f3893ag.isFinished();
        }
        EdgeEffect edgeEffect2 = this.f3895ai;
        if (edgeEffect2 != null && !edgeEffect2.isFinished() && i2 < 0) {
            this.f3895ai.onRelease();
            z2 |= this.f3895ai.isFinished();
        }
        EdgeEffect edgeEffect3 = this.f3894ah;
        if (edgeEffect3 != null && !edgeEffect3.isFinished() && i3 > 0) {
            this.f3894ah.onRelease();
            z2 |= this.f3894ah.isFinished();
        }
        EdgeEffect edgeEffect4 = this.f3896aj;
        if (edgeEffect4 != null && !edgeEffect4.isFinished() && i3 < 0) {
            this.f3896aj.onRelease();
            z2 |= this.f3896aj.isFinished();
        }
        if (z2) {
            ac.e(this);
        }
    }

    /* access modifiers changed from: package-private */
    public void c(boolean z2) {
        this.A = z2 | this.A;
        this.f3934z = true;
        u();
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return (layoutParams instanceof LayoutParams) && this.f3923o.a((LayoutParams) layoutParams);
    }

    public int computeHorizontalScrollExtent() {
        h hVar = this.f3923o;
        if (hVar != null && hVar.f()) {
            return this.f3923o.g(this.F);
        }
        return 0;
    }

    public int computeHorizontalScrollOffset() {
        h hVar = this.f3923o;
        if (hVar != null && hVar.f()) {
            return this.f3923o.d(this.F);
        }
        return 0;
    }

    public int computeHorizontalScrollRange() {
        h hVar = this.f3923o;
        if (hVar != null && hVar.f()) {
            return this.f3923o.b(this.F);
        }
        return 0;
    }

    public int computeVerticalScrollExtent() {
        h hVar = this.f3923o;
        if (hVar != null && hVar.g()) {
            return this.f3923o.h(this.F);
        }
        return 0;
    }

    public int computeVerticalScrollOffset() {
        h hVar = this.f3923o;
        if (hVar != null && hVar.g()) {
            return this.f3923o.e(this.F);
        }
        return 0;
    }

    public int computeVerticalScrollRange() {
        h hVar = this.f3923o;
        if (hVar != null && hVar.g()) {
            return this.f3923o.c(this.F);
        }
        return 0;
    }

    /* access modifiers changed from: package-private */
    public int d(v vVar) {
        if (vVar.hasAnyOfTheFlags(524) || !vVar.isBound()) {
            return -1;
        }
        return this.f3915g.c(vVar.mPosition);
    }

    public v d(int i2) {
        return a(i2, false);
    }

    public v d(View view) {
        View c2 = c(view);
        if (c2 == null) {
            return null;
        }
        return b(c2);
    }

    /* access modifiers changed from: package-private */
    public void d() {
        if (!this.f3930v || this.f3934z) {
            androidx.core.os.i.a("RV FullInvalidate");
            q();
            androidx.core.os.i.a();
        } else if (this.f3915g.d()) {
            if (this.f3915g.a(4) && !this.f3915g.a(11)) {
                androidx.core.os.i.a("RV PartialInvalidate");
                e();
                l();
                this.f3915g.b();
                if (!this.f3931w) {
                    if (A()) {
                        q();
                    } else {
                        this.f3915g.c();
                    }
                }
                a(true);
                m();
            } else if (this.f3915g.d()) {
                androidx.core.os.i.a("RV FullInvalidate");
                q();
            } else {
                return;
            }
            androidx.core.os.i.a();
        }
    }

    /* access modifiers changed from: package-private */
    public void d(int i2, int i3) {
        if (i2 < 0) {
            g();
            if (this.f3893ag.isFinished()) {
                this.f3893ag.onAbsorb(-i2);
            }
        } else if (i2 > 0) {
            h();
            if (this.f3895ai.isFinished()) {
                this.f3895ai.onAbsorb(i2);
            }
        }
        if (i3 < 0) {
            i();
            if (this.f3894ah.isFinished()) {
                this.f3894ah.onAbsorb(-i3);
            }
        } else if (i3 > 0) {
            j();
            if (this.f3896aj.isFinished()) {
                this.f3896aj.onAbsorb(i3);
            }
        }
        if (i2 != 0 || i3 != 0) {
            ac.e(this);
        }
    }

    public boolean dispatchNestedFling(float f2, float f3, boolean z2) {
        return getScrollingChildHelper().a(f2, f3, z2);
    }

    public boolean dispatchNestedPreFling(float f2, float f3) {
        return getScrollingChildHelper().a(f2, f3);
    }

    public boolean dispatchNestedPreScroll(int i2, int i3, int[] iArr, int[] iArr2) {
        return getScrollingChildHelper().a(i2, i3, iArr, iArr2);
    }

    public boolean dispatchNestedScroll(int i2, int i3, int i4, int i5, int[] iArr) {
        return getScrollingChildHelper().a(i2, i3, i4, i5, iArr);
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        onPopulateAccessibilityEvent(accessibilityEvent);
        return true;
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchThawSelfOnly(sparseArray);
    }

    /* access modifiers changed from: protected */
    public void dispatchSaveInstanceState(SparseArray<Parcelable> sparseArray) {
        dispatchFreezeSelfOnly(sparseArray);
    }

    public void draw(Canvas canvas) {
        boolean z2;
        int i2;
        float f2;
        super.draw(canvas);
        int size = this.f3926r.size();
        boolean z3 = false;
        for (int i3 = 0; i3 < size; i3++) {
            this.f3926r.get(i3).onDrawOver(canvas, this, this.F);
        }
        EdgeEffect edgeEffect = this.f3893ag;
        boolean z4 = true;
        if (edgeEffect == null || edgeEffect.isFinished()) {
            z2 = false;
        } else {
            int save = canvas.save();
            int paddingBottom = this.f3918j ? getPaddingBottom() : 0;
            canvas.rotate(270.0f);
            canvas.translate((float) ((-getHeight()) + paddingBottom), 0.0f);
            EdgeEffect edgeEffect2 = this.f3893ag;
            z2 = edgeEffect2 != null && edgeEffect2.draw(canvas);
            canvas.restoreToCount(save);
        }
        EdgeEffect edgeEffect3 = this.f3894ah;
        if (edgeEffect3 != null && !edgeEffect3.isFinished()) {
            int save2 = canvas.save();
            if (this.f3918j) {
                canvas.translate((float) getPaddingLeft(), (float) getPaddingTop());
            }
            EdgeEffect edgeEffect4 = this.f3894ah;
            z2 |= edgeEffect4 != null && edgeEffect4.draw(canvas);
            canvas.restoreToCount(save2);
        }
        EdgeEffect edgeEffect5 = this.f3895ai;
        if (edgeEffect5 != null && !edgeEffect5.isFinished()) {
            int save3 = canvas.save();
            int width = getWidth();
            int paddingTop = this.f3918j ? getPaddingTop() : 0;
            canvas.rotate(90.0f);
            canvas.translate((float) paddingTop, (float) (-width));
            EdgeEffect edgeEffect6 = this.f3895ai;
            z2 |= edgeEffect6 != null && edgeEffect6.draw(canvas);
            canvas.restoreToCount(save3);
        }
        EdgeEffect edgeEffect7 = this.f3896aj;
        if (edgeEffect7 != null && !edgeEffect7.isFinished()) {
            int save4 = canvas.save();
            canvas.rotate(180.0f);
            if (this.f3918j) {
                f2 = (float) ((-getWidth()) + getPaddingRight());
                i2 = (-getHeight()) + getPaddingBottom();
            } else {
                f2 = (float) (-getWidth());
                i2 = -getHeight();
            }
            canvas.translate(f2, (float) i2);
            EdgeEffect edgeEffect8 = this.f3896aj;
            if (edgeEffect8 != null && edgeEffect8.draw(canvas)) {
                z3 = true;
            }
            z2 |= z3;
            canvas.restoreToCount(save4);
        }
        if (z2 || this.B == null || this.f3926r.size() <= 0 || !this.B.b()) {
            z4 = z2;
        }
        if (z4) {
            ac.e(this);
        }
    }

    public boolean drawChild(Canvas canvas, View view, long j2) {
        return super.drawChild(canvas, view, j2);
    }

    public v e(int i2) {
        v vVar = null;
        if (this.f3934z) {
            return null;
        }
        int c2 = this.f3916h.c();
        for (int i3 = 0; i3 < c2; i3++) {
            v e2 = e(this.f3916h.d(i3));
            if (e2 != null && !e2.isRemoved() && d(e2) == i2) {
                if (!this.f3916h.c(e2.itemView)) {
                    return e2;
                }
                vVar = e2;
            }
        }
        return vVar;
    }

    /* access modifiers changed from: package-private */
    public void e() {
        int i2 = this.V + 1;
        this.V = i2;
        if (i2 == 1 && !this.f3932x) {
            this.f3931w = false;
        }
    }

    /* access modifiers changed from: package-private */
    public void e(int i2, int i3) {
        setMeasuredDimension(h.a(i2, getPaddingLeft() + getPaddingRight(), ac.p(this)), h.a(i3, getPaddingTop() + getPaddingBottom(), ac.q(this)));
    }

    public int f(View view) {
        v e2 = e(view);
        if (e2 != null) {
            return e2.getAbsoluteAdapterPosition();
        }
        return -1;
    }

    public void f() {
        setScrollState(0);
        B();
    }

    public void f(int i2) {
        int b2 = this.f3916h.b();
        for (int i3 = 0; i3 < b2; i3++) {
            this.f3916h.b(i3).offsetTopAndBottom(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(int i2, int i3) {
        int i4;
        int i5;
        int i6;
        int c2 = this.f3916h.c();
        if (i2 < i3) {
            i6 = -1;
            i5 = i2;
            i4 = i3;
        } else {
            i4 = i2;
            i5 = i3;
            i6 = 1;
        }
        for (int i7 = 0; i7 < c2; i7++) {
            v e2 = e(this.f3916h.d(i7));
            if (e2 != null && e2.mPosition >= i5 && e2.mPosition <= i4) {
                if (e2.mPosition == i2) {
                    e2.offsetPosition(i3 - i2, false);
                } else {
                    e2.offsetPosition(i6, false);
                }
                this.F.f4021f = true;
            }
        }
        this.f3913e.a(i2, i3);
        requestLayout();
    }

    public View focusSearch(View view, int i2) {
        View view2;
        boolean z2;
        View d2 = this.f3923o.d(view, i2);
        if (d2 != null) {
            return d2;
        }
        boolean z3 = true;
        boolean z4 = this.f3922n != null && this.f3923o != null && !o() && !this.f3932x;
        FocusFinder instance = FocusFinder.getInstance();
        if (!z4 || !(i2 == 2 || i2 == 1)) {
            View findNextFocus = instance.findNextFocus(this, view, i2);
            if (findNextFocus != null || !z4) {
                view2 = findNextFocus;
            } else {
                d();
                if (c(view) == null) {
                    return null;
                }
                e();
                view2 = this.f3923o.a(view, i2, this.f3913e, this.F);
                a(false);
            }
        } else {
            if (this.f3923o.g()) {
                int i3 = i2 == 2 ? IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR : 33;
                z2 = instance.findNextFocus(this, view, i3) == null;
                if (O) {
                    i2 = i3;
                }
            } else {
                z2 = false;
            }
            if (!z2 && this.f3923o.f()) {
                int i4 = (this.f3923o.x() == 1) ^ (i2 == 2) ? 66 : 17;
                if (instance.findNextFocus(this, view, i4) != null) {
                    z3 = false;
                }
                if (O) {
                    i2 = i4;
                }
                z2 = z3;
            }
            if (z2) {
                d();
                if (c(view) == null) {
                    return null;
                }
                e();
                this.f3923o.a(view, i2, this.f3913e, this.F);
                a(false);
            }
            view2 = instance.findNextFocus(this, view, i2);
        }
        if (view2 == null || view2.hasFocusable()) {
            return a(view, view2, i2) ? view2 : super.focusSearch(view, i2);
        }
        if (getFocusedChild() == null) {
            return super.focusSearch(view, i2);
        }
        a(view2, (View) null);
        return view;
    }

    public int g(View view) {
        v e2 = e(view);
        if (e2 != null) {
            return e2.getLayoutPosition();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public void g() {
        int i2;
        int i3;
        if (this.f3893ag == null) {
            EdgeEffect a2 = this.f3892af.a(this, 0);
            this.f3893ag = a2;
            if (this.f3918j) {
                i3 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                i2 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            } else {
                i3 = getMeasuredHeight();
                i2 = getMeasuredWidth();
            }
            a2.setSize(i3, i2);
        }
    }

    public void g(int i2) {
        int b2 = this.f3916h.b();
        for (int i3 = 0; i3 < b2; i3++) {
            this.f3916h.b(i3).offsetLeftAndRight(i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void g(int i2, int i3) {
        int c2 = this.f3916h.c();
        for (int i4 = 0; i4 < c2; i4++) {
            v e2 = e(this.f3916h.d(i4));
            if (e2 != null && !e2.shouldIgnore() && e2.mPosition >= i2) {
                e2.offsetPosition(i3, false);
                this.F.f4021f = true;
            }
        }
        this.f3913e.b(i2, i3);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateDefaultLayoutParams() {
        h hVar = this.f3923o;
        if (hVar != null) {
            return hVar.a();
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + a());
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        h hVar = this.f3923o;
        if (hVar != null) {
            return hVar.a(getContext(), attributeSet);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + a());
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        h hVar = this.f3923o;
        if (hVar != null) {
            return hVar.a(layoutParams);
        }
        throw new IllegalStateException("RecyclerView has no LayoutManager" + a());
    }

    public CharSequence getAccessibilityClassName() {
        return "androidx.recyclerview.widget.RecyclerView";
    }

    public Adapter getAdapter() {
        return this.f3922n;
    }

    public int getBaseline() {
        h hVar = this.f3923o;
        return hVar != null ? hVar.y() : super.getBaseline();
    }

    /* access modifiers changed from: protected */
    public int getChildDrawingOrder(int i2, int i3) {
        c cVar = this.aB;
        return cVar == null ? super.getChildDrawingOrder(i2, i3) : cVar.a(i2, i3);
    }

    public boolean getClipToPadding() {
        return this.f3918j;
    }

    public u getCompatAccessibilityDelegate() {
        return this.J;
    }

    public d getEdgeEffectFactory() {
        return this.f3892af;
    }

    public e getItemAnimator() {
        return this.B;
    }

    public int getItemDecorationCount() {
        return this.f3926r.size();
    }

    public h getLayoutManager() {
        return this.f3923o;
    }

    public int getMaxFlingVelocity() {
        return this.f3907au;
    }

    public int getMinFlingVelocity() {
        return this.f3906at;
    }

    /* access modifiers changed from: package-private */
    public long getNanoTime() {
        if (f3886d) {
            return System.nanoTime();
        }
        return 0;
    }

    public j getOnFlingListener() {
        return this.f3905as;
    }

    public boolean getPreserveFocusAfterLayout() {
        return this.f3910ax;
    }

    public m getRecycledViewPool() {
        return this.f3913e.g();
    }

    public int getScrollState() {
        return this.f3897ak;
    }

    /* access modifiers changed from: package-private */
    public void h() {
        int i2;
        int i3;
        if (this.f3895ai == null) {
            EdgeEffect a2 = this.f3892af.a(this, 2);
            this.f3895ai = a2;
            if (this.f3918j) {
                i3 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
                i2 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
            } else {
                i3 = getMeasuredHeight();
                i2 = getMeasuredWidth();
            }
            a2.setSize(i3, i2);
        }
    }

    public void h(int i2) {
    }

    public void h(int i2, int i3) {
    }

    public void h(View view) {
    }

    public boolean hasNestedScrollingParent() {
        return getScrollingChildHelper().b();
    }

    /* access modifiers changed from: package-private */
    public void i() {
        int i2;
        int i3;
        if (this.f3894ah == null) {
            EdgeEffect a2 = this.f3892af.a(this, 1);
            this.f3894ah = a2;
            if (this.f3918j) {
                i3 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                i2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            } else {
                i3 = getMeasuredWidth();
                i2 = getMeasuredHeight();
            }
            a2.setSize(i3, i2);
        }
    }

    /* access modifiers changed from: package-private */
    public void i(int i2) {
        h hVar = this.f3923o;
        if (hVar != null) {
            hVar.l(i2);
        }
        h(i2);
        l lVar = this.f3911ay;
        if (lVar != null) {
            lVar.a(this, i2);
        }
        List<l> list = this.f3912az;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f3912az.get(size).a(this, i2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void i(int i2, int i3) {
        this.f3891ae++;
        int scrollX = getScrollX();
        int scrollY = getScrollY();
        onScrollChanged(scrollX, scrollY, scrollX - i2, scrollY - i3);
        h(i2, i3);
        l lVar = this.f3911ay;
        if (lVar != null) {
            lVar.a(this, i2, i3);
        }
        List<l> list = this.f3912az;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f3912az.get(size).a(this, i2, i3);
            }
        }
        this.f3891ae--;
    }

    public void i(View view) {
    }

    public boolean isAttachedToWindow() {
        return this.f3927s;
    }

    public final boolean isLayoutSuppressed() {
        return this.f3932x;
    }

    public boolean isNestedScrollingEnabled() {
        return getScrollingChildHelper().a();
    }

    /* access modifiers changed from: package-private */
    public Rect j(View view) {
        LayoutParams layoutParams = (LayoutParams) view.getLayoutParams();
        if (!layoutParams.f3947e) {
            return layoutParams.f3946d;
        }
        if (this.F.a() && (layoutParams.e() || layoutParams.c())) {
            return layoutParams.f3946d;
        }
        Rect rect = layoutParams.f3946d;
        rect.set(0, 0, 0, 0);
        int size = this.f3926r.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f3920l.set(0, 0, 0, 0);
            this.f3926r.get(i2).getItemOffsets(this.f3920l, view, this, this.F);
            rect.left += this.f3920l.left;
            rect.top += this.f3920l.top;
            rect.right += this.f3920l.right;
            rect.bottom += this.f3920l.bottom;
        }
        layoutParams.f3947e = false;
        return rect;
    }

    /* access modifiers changed from: package-private */
    public void j() {
        int i2;
        int i3;
        if (this.f3896aj == null) {
            EdgeEffect a2 = this.f3892af.a(this, 3);
            this.f3896aj = a2;
            if (this.f3918j) {
                i3 = (getMeasuredWidth() - getPaddingLeft()) - getPaddingRight();
                i2 = (getMeasuredHeight() - getPaddingTop()) - getPaddingBottom();
            } else {
                i3 = getMeasuredWidth();
                i2 = getMeasuredHeight();
            }
            a2.setSize(i3, i2);
        }
    }

    public void j(int i2) {
        getScrollingChildHelper().c(i2);
    }

    public boolean j(int i2, int i3) {
        return getScrollingChildHelper().a(i2, i3);
    }

    /* access modifiers changed from: package-private */
    public void k() {
        this.f3896aj = null;
        this.f3894ah = null;
        this.f3895ai = null;
        this.f3893ag = null;
    }

    /* access modifiers changed from: package-private */
    public void l() {
        this.f3890ad++;
    }

    /* access modifiers changed from: package-private */
    public void l(View view) {
        v e2 = e(view);
        i(view);
        Adapter adapter = this.f3922n;
        if (!(adapter == null || e2 == null)) {
            adapter.onViewDetachedFromWindow(e2);
        }
        List<i> list = this.f3889ac;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f3889ac.get(size).b(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void m() {
        b(true);
    }

    /* access modifiers changed from: package-private */
    public void m(View view) {
        v e2 = e(view);
        h(view);
        Adapter adapter = this.f3922n;
        if (!(adapter == null || e2 == null)) {
            adapter.onViewAttachedToWindow(e2);
        }
        List<i> list = this.f3889ac;
        if (list != null) {
            for (int size = list.size() - 1; size >= 0; size--) {
                this.f3889ac.get(size).a(view);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean n() {
        AccessibilityManager accessibilityManager = this.f3888ab;
        return accessibilityManager != null && accessibilityManager.isEnabled();
    }

    public boolean o() {
        return this.f3890ad > 0;
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.f3890ad = 0;
        boolean z2 = true;
        this.f3927s = true;
        if (!this.f3930v || isLayoutRequested()) {
            z2 = false;
        }
        this.f3930v = z2;
        h hVar = this.f3923o;
        if (hVar != null) {
            hVar.c(this);
        }
        this.I = false;
        if (f3886d) {
            j jVar = j.f4222a.get();
            this.D = jVar;
            if (jVar == null) {
                this.D = new j();
                Display L2 = ac.L(this);
                float f2 = 60.0f;
                if (!isInEditMode() && L2 != null) {
                    float refreshRate = L2.getRefreshRate();
                    if (refreshRate >= 30.0f) {
                        f2 = refreshRate;
                    }
                }
                this.D.f4226d = (long) (1.0E9f / f2);
                j.f4222a.set(this.D);
            }
            this.D.a(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        j jVar;
        super.onDetachedFromWindow();
        e eVar = this.B;
        if (eVar != null) {
            eVar.d();
        }
        f();
        this.f3927s = false;
        h hVar = this.f3923o;
        if (hVar != null) {
            hVar.b(this, this.f3913e);
        }
        this.L.clear();
        removeCallbacks(this.aG);
        this.f3917i.b();
        if (f3886d && (jVar = this.D) != null) {
            jVar.b(this);
            this.D = null;
        }
    }

    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int size = this.f3926r.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f3926r.get(i2).onDraw(canvas, this, this.F);
        }
    }

    public boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float f2;
        float f3;
        if (this.f3923o != null && !this.f3932x && motionEvent.getAction() == 8) {
            if ((motionEvent.getSource() & 2) != 0) {
                f3 = this.f3923o.g() ? -motionEvent.getAxisValue(9) : 0.0f;
                if (this.f3923o.f()) {
                    f2 = motionEvent.getAxisValue(10);
                    if (!(f3 == 0.0f && f2 == 0.0f)) {
                        b((int) (f2 * this.f3908av), (int) (f3 * this.f3909aw), motionEvent, 1);
                    }
                }
            } else {
                if ((motionEvent.getSource() & 4194304) != 0) {
                    float axisValue = motionEvent.getAxisValue(26);
                    if (this.f3923o.g()) {
                        f3 = -axisValue;
                    } else if (this.f3923o.f()) {
                        f2 = axisValue;
                        f3 = 0.0f;
                        b((int) (f2 * this.f3908av), (int) (f3 * this.f3909aw), motionEvent, 1);
                    }
                }
                f3 = 0.0f;
            }
            f2 = 0.0f;
            b((int) (f2 * this.f3908av), (int) (f3 * this.f3909aw), motionEvent, 1);
        }
        return false;
    }

    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        boolean z2;
        if (this.f3932x) {
            return false;
        }
        this.U = null;
        if (b(motionEvent)) {
            E();
            return true;
        }
        h hVar = this.f3923o;
        if (hVar == null) {
            return false;
        }
        boolean f2 = hVar.f();
        boolean g2 = this.f3923o.g();
        if (this.f3899am == null) {
            this.f3899am = VelocityTracker.obtain();
        }
        this.f3899am.addMovement(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        int actionIndex = motionEvent.getActionIndex();
        if (actionMasked == 0) {
            if (this.W) {
                this.W = false;
            }
            this.f3898al = motionEvent.getPointerId(0);
            int x2 = (int) (motionEvent.getX() + 0.5f);
            this.f3902ap = x2;
            this.f3900an = x2;
            int y2 = (int) (motionEvent.getY() + 0.5f);
            this.f3903aq = y2;
            this.f3901ao = y2;
            if (this.f3897ak == 2) {
                getParent().requestDisallowInterceptTouchEvent(true);
                setScrollState(1);
                j(1);
            }
            int[] iArr = this.aF;
            iArr[1] = 0;
            iArr[0] = 0;
            if (g2) {
                f2 |= true;
            }
            j(f2 ? 1 : 0, 0);
        } else if (actionMasked == 1) {
            this.f3899am.clear();
            j(0);
        } else if (actionMasked == 2) {
            int findPointerIndex = motionEvent.findPointerIndex(this.f3898al);
            if (findPointerIndex < 0) {
                Log.e("RecyclerView", "Error processing scroll; pointer index for id " + this.f3898al + " not found. Did any MotionEvents get skipped?");
                return false;
            }
            int x3 = (int) (motionEvent.getX(findPointerIndex) + 0.5f);
            int y3 = (int) (motionEvent.getY(findPointerIndex) + 0.5f);
            if (this.f3897ak != 1) {
                int i2 = x3 - this.f3900an;
                int i3 = y3 - this.f3901ao;
                if (!f2 || Math.abs(i2) <= this.f3904ar) {
                    z2 = false;
                } else {
                    this.f3902ap = x3;
                    z2 = true;
                }
                if (g2 && Math.abs(i3) > this.f3904ar) {
                    this.f3903aq = y3;
                    z2 = true;
                }
                if (z2) {
                    setScrollState(1);
                }
            }
        } else if (actionMasked == 3) {
            E();
        } else if (actionMasked == 5) {
            this.f3898al = motionEvent.getPointerId(actionIndex);
            int x4 = (int) (motionEvent.getX(actionIndex) + 0.5f);
            this.f3902ap = x4;
            this.f3900an = x4;
            int y4 = (int) (motionEvent.getY(actionIndex) + 0.5f);
            this.f3903aq = y4;
            this.f3901ao = y4;
        } else if (actionMasked == 6) {
            c(motionEvent);
        }
        return this.f3897ak == 1;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z2, int i2, int i3, int i4, int i5) {
        androidx.core.os.i.a("RV OnLayout");
        q();
        androidx.core.os.i.a();
        this.f3930v = true;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i2, int i3) {
        h hVar = this.f3923o;
        if (hVar == null) {
            e(i2, i3);
            return;
        }
        boolean z2 = false;
        if (hVar.d()) {
            int mode = View.MeasureSpec.getMode(i2);
            int mode2 = View.MeasureSpec.getMode(i3);
            this.f3923o.a(this.f3913e, this.F, i2, i3);
            if (mode == 1073741824 && mode2 == 1073741824) {
                z2 = true;
            }
            this.aH = z2;
            if (!z2 && this.f3922n != null) {
                if (this.F.f4019d == 1) {
                    M();
                }
                this.f3923o.d(i2, i3);
                this.F.f4024i = true;
                N();
                this.f3923o.e(i2, i3);
                if (this.f3923o.n()) {
                    this.f3923o.d(View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), MemoryConstants.GB), View.MeasureSpec.makeMeasureSpec(getMeasuredHeight(), MemoryConstants.GB));
                    this.F.f4024i = true;
                    N();
                    this.f3923o.e(i2, i3);
                }
                this.aI = getMeasuredWidth();
                this.aJ = getMeasuredHeight();
            }
        } else if (this.f3928t) {
            this.f3923o.a(this.f3913e, this.F, i2, i3);
        } else {
            if (this.f3933y) {
                e();
                l();
                H();
                m();
                if (this.F.f4026k) {
                    this.F.f4022g = true;
                } else {
                    this.f3915g.e();
                    this.F.f4022g = false;
                }
                this.f3933y = false;
                a(false);
            } else if (this.F.f4026k) {
                setMeasuredDimension(getMeasuredWidth(), getMeasuredHeight());
                return;
            }
            Adapter adapter = this.f3922n;
            if (adapter != null) {
                this.F.f4020e = adapter.getItemCount();
            } else {
                this.F.f4020e = 0;
            }
            e();
            this.f3923o.a(this.f3913e, this.F, i2, i3);
            a(false);
            this.F.f4022g = false;
        }
    }

    /* access modifiers changed from: protected */
    public boolean onRequestFocusInDescendants(int i2, Rect rect) {
        if (o()) {
            return false;
        }
        return super.onRequestFocusInDescendants(i2, rect);
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        this.f3914f = savedState;
        super.onRestoreInstanceState(savedState.a());
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        SavedState savedState2 = this.f3914f;
        if (savedState2 != null) {
            savedState.a(savedState2);
        } else {
            h hVar = this.f3923o;
            savedState.f3949a = hVar != null ? hVar.e() : null;
        }
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i2, int i3, int i4, int i5) {
        super.onSizeChanged(i2, i3, i4, i5);
        if (i2 != i4 || i3 != i5) {
            k();
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:46:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x00f4  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r18) {
        /*
            r17 = this;
            r6 = r17
            r7 = r18
            boolean r0 = r6.f3932x
            r8 = 0
            if (r0 != 0) goto L_0x01db
            boolean r0 = r6.W
            if (r0 == 0) goto L_0x000f
            goto L_0x01db
        L_0x000f:
            boolean r0 = r17.a((android.view.MotionEvent) r18)
            r9 = 1
            if (r0 == 0) goto L_0x001a
            r17.E()
            return r9
        L_0x001a:
            androidx.recyclerview.widget.RecyclerView$h r0 = r6.f3923o
            if (r0 != 0) goto L_0x001f
            return r8
        L_0x001f:
            boolean r10 = r0.f()
            androidx.recyclerview.widget.RecyclerView$h r0 = r6.f3923o
            boolean r11 = r0.g()
            android.view.VelocityTracker r0 = r6.f3899am
            if (r0 != 0) goto L_0x0033
            android.view.VelocityTracker r0 = android.view.VelocityTracker.obtain()
            r6.f3899am = r0
        L_0x0033:
            int r0 = r18.getActionMasked()
            int r1 = r18.getActionIndex()
            if (r0 != 0) goto L_0x0043
            int[] r2 = r6.aF
            r2[r9] = r8
            r2[r8] = r8
        L_0x0043:
            android.view.MotionEvent r12 = android.view.MotionEvent.obtain(r18)
            int[] r2 = r6.aF
            r3 = r2[r8]
            float r3 = (float) r3
            r2 = r2[r9]
            float r2 = (float) r2
            r12.offsetLocation(r3, r2)
            r2 = 1056964608(0x3f000000, float:0.5)
            if (r0 == 0) goto L_0x01af
            if (r0 == r9) goto L_0x016d
            r3 = 2
            if (r0 == r3) goto L_0x008c
            r3 = 3
            if (r0 == r3) goto L_0x0087
            r3 = 5
            if (r0 == r3) goto L_0x006b
            r1 = 6
            if (r0 == r1) goto L_0x0066
            goto L_0x01d0
        L_0x0066:
            r17.c((android.view.MotionEvent) r18)
            goto L_0x01d0
        L_0x006b:
            int r0 = r7.getPointerId(r1)
            r6.f3898al = r0
            float r0 = r7.getX(r1)
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.f3902ap = r0
            r6.f3900an = r0
            float r0 = r7.getY(r1)
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.f3903aq = r0
            r6.f3901ao = r0
            goto L_0x01d0
        L_0x0087:
            r17.E()
            goto L_0x01d0
        L_0x008c:
            int r0 = r6.f3898al
            int r0 = r7.findPointerIndex(r0)
            if (r0 >= 0) goto L_0x00b2
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Error processing scroll; pointer index for id "
            r0.append(r1)
            int r1 = r6.f3898al
            r0.append(r1)
            java.lang.String r1 = " not found. Did any MotionEvents get skipped?"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "RecyclerView"
            android.util.Log.e(r1, r0)
            return r8
        L_0x00b2:
            float r1 = r7.getX(r0)
            float r1 = r1 + r2
            int r13 = (int) r1
            float r0 = r7.getY(r0)
            float r0 = r0 + r2
            int r14 = (int) r0
            int r0 = r6.f3902ap
            int r0 = r0 - r13
            int r1 = r6.f3903aq
            int r1 = r1 - r14
            int r2 = r6.f3897ak
            if (r2 == r9) goto L_0x00f7
            if (r10 == 0) goto L_0x00dd
            int r2 = r6.f3904ar
            if (r0 <= 0) goto L_0x00d4
            int r0 = r0 - r2
            int r0 = java.lang.Math.max(r8, r0)
            goto L_0x00d9
        L_0x00d4:
            int r0 = r0 + r2
            int r0 = java.lang.Math.min(r8, r0)
        L_0x00d9:
            if (r0 == 0) goto L_0x00dd
            r2 = 1
            goto L_0x00de
        L_0x00dd:
            r2 = 0
        L_0x00de:
            if (r11 == 0) goto L_0x00f2
            int r3 = r6.f3904ar
            if (r1 <= 0) goto L_0x00ea
            int r1 = r1 - r3
            int r1 = java.lang.Math.max(r8, r1)
            goto L_0x00ef
        L_0x00ea:
            int r1 = r1 + r3
            int r1 = java.lang.Math.min(r8, r1)
        L_0x00ef:
            if (r1 == 0) goto L_0x00f2
            r2 = 1
        L_0x00f2:
            if (r2 == 0) goto L_0x00f7
            r6.setScrollState(r9)
        L_0x00f7:
            r15 = r0
            r16 = r1
            int r0 = r6.f3897ak
            if (r0 != r9) goto L_0x01d0
            int[] r3 = r6.K
            r3[r8] = r8
            r3[r9] = r8
            if (r10 == 0) goto L_0x0108
            r1 = r15
            goto L_0x0109
        L_0x0108:
            r1 = 0
        L_0x0109:
            if (r11 == 0) goto L_0x010e
            r2 = r16
            goto L_0x010f
        L_0x010e:
            r2 = 0
        L_0x010f:
            int[] r4 = r6.aE
            r5 = 0
            r0 = r17
            boolean r0 = r0.a((int) r1, (int) r2, (int[]) r3, (int[]) r4, (int) r5)
            if (r0 == 0) goto L_0x013c
            int[] r0 = r6.K
            r1 = r0[r8]
            int r15 = r15 - r1
            r0 = r0[r9]
            int r16 = r16 - r0
            int[] r0 = r6.aF
            r1 = r0[r8]
            int[] r2 = r6.aE
            r3 = r2[r8]
            int r1 = r1 + r3
            r0[r8] = r1
            r1 = r0[r9]
            r2 = r2[r9]
            int r1 = r1 + r2
            r0[r9] = r1
            android.view.ViewParent r0 = r17.getParent()
            r0.requestDisallowInterceptTouchEvent(r9)
        L_0x013c:
            r0 = r16
            int[] r1 = r6.aE
            r2 = r1[r8]
            int r13 = r13 - r2
            r6.f3902ap = r13
            r1 = r1[r9]
            int r14 = r14 - r1
            r6.f3903aq = r14
            if (r10 == 0) goto L_0x014e
            r1 = r15
            goto L_0x014f
        L_0x014e:
            r1 = 0
        L_0x014f:
            if (r11 == 0) goto L_0x0153
            r2 = r0
            goto L_0x0154
        L_0x0153:
            r2 = 0
        L_0x0154:
            boolean r1 = r6.a((int) r1, (int) r2, (android.view.MotionEvent) r7, (int) r8)
            if (r1 == 0) goto L_0x0161
            android.view.ViewParent r1 = r17.getParent()
            r1.requestDisallowInterceptTouchEvent(r9)
        L_0x0161:
            androidx.recyclerview.widget.j r1 = r6.D
            if (r1 == 0) goto L_0x01d0
            if (r15 != 0) goto L_0x0169
            if (r0 == 0) goto L_0x01d0
        L_0x0169:
            r1.a((androidx.recyclerview.widget.RecyclerView) r6, (int) r15, (int) r0)
            goto L_0x01d0
        L_0x016d:
            android.view.VelocityTracker r0 = r6.f3899am
            r0.addMovement(r12)
            android.view.VelocityTracker r0 = r6.f3899am
            r1 = 1000(0x3e8, float:1.401E-42)
            int r2 = r6.f3907au
            float r2 = (float) r2
            r0.computeCurrentVelocity(r1, r2)
            r0 = 0
            if (r10 == 0) goto L_0x0189
            android.view.VelocityTracker r1 = r6.f3899am
            int r2 = r6.f3898al
            float r1 = r1.getXVelocity(r2)
            float r1 = -r1
            goto L_0x018a
        L_0x0189:
            r1 = 0
        L_0x018a:
            if (r11 == 0) goto L_0x0196
            android.view.VelocityTracker r2 = r6.f3899am
            int r3 = r6.f3898al
            float r2 = r2.getYVelocity(r3)
            float r2 = -r2
            goto L_0x0197
        L_0x0196:
            r2 = 0
        L_0x0197:
            int r3 = (r1 > r0 ? 1 : (r1 == r0 ? 0 : -1))
            if (r3 != 0) goto L_0x019f
            int r0 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r0 == 0) goto L_0x01a7
        L_0x019f:
            int r0 = (int) r1
            int r1 = (int) r2
            boolean r0 = r6.b((int) r0, (int) r1)
            if (r0 != 0) goto L_0x01aa
        L_0x01a7:
            r6.setScrollState(r8)
        L_0x01aa:
            r17.D()
            r8 = 1
            goto L_0x01d0
        L_0x01af:
            int r0 = r7.getPointerId(r8)
            r6.f3898al = r0
            float r0 = r18.getX()
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.f3902ap = r0
            r6.f3900an = r0
            float r0 = r18.getY()
            float r0 = r0 + r2
            int r0 = (int) r0
            r6.f3903aq = r0
            r6.f3901ao = r0
            if (r11 == 0) goto L_0x01cd
            r10 = r10 | 2
        L_0x01cd:
            r6.j(r10, r8)
        L_0x01d0:
            if (r8 != 0) goto L_0x01d7
            android.view.VelocityTracker r0 = r6.f3899am
            r0.addMovement(r12)
        L_0x01d7:
            r12.recycle()
            return r9
        L_0x01db:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.RecyclerView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    /* access modifiers changed from: package-private */
    public void p() {
        if (!this.I && this.f3927s) {
            ac.a((View) this, this.aG);
            this.I = true;
        }
    }

    /* access modifiers changed from: package-private */
    public void q() {
        if (this.f3922n == null) {
            Log.w("RecyclerView", "No adapter attached; skipping layout");
        } else if (this.f3923o == null) {
            Log.e("RecyclerView", "No layout manager attached; skipping layout");
        } else {
            this.F.f4024i = false;
            boolean z2 = this.aH && !(this.aI == getWidth() && this.aJ == getHeight());
            this.aI = 0;
            this.aJ = 0;
            this.aH = false;
            if (this.F.f4019d == 1) {
                M();
            } else if (!this.f3915g.f() && !z2 && this.f3923o.C() == getWidth() && this.f3923o.D() == getHeight()) {
                this.f3923o.f(this);
                O();
            }
            this.f3923o.f(this);
            N();
            O();
        }
    }

    /* access modifiers changed from: package-private */
    public void r() {
        int c2 = this.f3916h.c();
        for (int i2 = 0; i2 < c2; i2++) {
            ((LayoutParams) this.f3916h.d(i2).getLayoutParams()).f3947e = true;
        }
        this.f3913e.j();
    }

    /* access modifiers changed from: protected */
    public void removeDetachedView(View view, boolean z2) {
        v e2 = e(view);
        if (e2 != null) {
            if (e2.isTmpDetached()) {
                e2.clearTmpDetachFlag();
            } else if (!e2.shouldIgnore()) {
                throw new IllegalArgumentException("Called removeDetachedView with a view which is not flagged as tmp detached." + e2 + a());
            }
        }
        view.clearAnimation();
        l(view);
        super.removeDetachedView(view, z2);
    }

    public void requestChildFocus(View view, View view2) {
        if (!this.f3923o.a(this, this.F, view, view2) && view2 != null) {
            a(view, view2);
        }
        super.requestChildFocus(view, view2);
    }

    public boolean requestChildRectangleOnScreen(View view, Rect rect, boolean z2) {
        return this.f3923o.a(this, view, rect, z2);
    }

    public void requestDisallowInterceptTouchEvent(boolean z2) {
        int size = this.T.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.T.get(i2).a(z2);
        }
        super.requestDisallowInterceptTouchEvent(z2);
    }

    public void requestLayout() {
        if (this.V != 0 || this.f3932x) {
            this.f3931w = true;
        } else {
            super.requestLayout();
        }
    }

    /* access modifiers changed from: package-private */
    public void s() {
        int c2 = this.f3916h.c();
        for (int i2 = 0; i2 < c2; i2++) {
            v e2 = e(this.f3916h.d(i2));
            if (!e2.shouldIgnore()) {
                e2.saveOldPosition();
            }
        }
    }

    public void scrollBy(int i2, int i3) {
        h hVar = this.f3923o;
        if (hVar == null) {
            Log.e("RecyclerView", "Cannot scroll without a LayoutManager set. Call setLayoutManager with a non-null argument.");
        } else if (!this.f3932x) {
            boolean f2 = hVar.f();
            boolean g2 = this.f3923o.g();
            if (f2 || g2) {
                if (!f2) {
                    i2 = 0;
                }
                if (!g2) {
                    i3 = 0;
                }
                a(i2, i3, (MotionEvent) null, 0);
            }
        }
    }

    public void scrollTo(int i2, int i3) {
        Log.w("RecyclerView", "RecyclerView does not support scrolling to an absolute position. Use scrollToPosition instead");
    }

    public void sendAccessibilityEventUnchecked(AccessibilityEvent accessibilityEvent) {
        if (!a(accessibilityEvent)) {
            super.sendAccessibilityEventUnchecked(accessibilityEvent);
        }
    }

    public void setAccessibilityDelegateCompat(u uVar) {
        this.J = uVar;
        ac.a((View) this, (t.a) uVar);
    }

    public void setAdapter(Adapter adapter) {
        setLayoutFrozen(false);
        a(adapter, false, true);
        c(false);
        requestLayout();
    }

    public void setChildDrawingOrderCallback(c cVar) {
        if (cVar != this.aB) {
            this.aB = cVar;
            setChildrenDrawingOrderEnabled(cVar != null);
        }
    }

    public void setClipToPadding(boolean z2) {
        if (z2 != this.f3918j) {
            k();
        }
        this.f3918j = z2;
        super.setClipToPadding(z2);
        if (this.f3930v) {
            requestLayout();
        }
    }

    public void setEdgeEffectFactory(d dVar) {
        s.f.a(dVar);
        this.f3892af = dVar;
        k();
    }

    public void setHasFixedSize(boolean z2) {
        this.f3928t = z2;
    }

    public void setItemAnimator(e eVar) {
        e eVar2 = this.B;
        if (eVar2 != null) {
            eVar2.d();
            this.B.a((e.b) null);
        }
        this.B = eVar;
        if (eVar != null) {
            eVar.a(this.aA);
        }
    }

    public void setItemViewCacheSize(int i2) {
        this.f3913e.a(i2);
    }

    @Deprecated
    public void setLayoutFrozen(boolean z2) {
        suppressLayout(z2);
    }

    public void setLayoutManager(h hVar) {
        if (hVar != this.f3923o) {
            f();
            if (this.f3923o != null) {
                e eVar = this.B;
                if (eVar != null) {
                    eVar.d();
                }
                this.f3923o.c(this.f3913e);
                this.f3923o.b(this.f3913e);
                this.f3913e.a();
                if (this.f3927s) {
                    this.f3923o.b(this, this.f3913e);
                }
                this.f3923o.b((RecyclerView) null);
                this.f3923o = null;
            } else {
                this.f3913e.a();
            }
            this.f3916h.a();
            this.f3923o = hVar;
            if (hVar != null) {
                if (hVar.f3970q == null) {
                    this.f3923o.b(this);
                    if (this.f3927s) {
                        this.f3923o.c(this);
                    }
                } else {
                    throw new IllegalArgumentException("LayoutManager " + hVar + " is already attached to a RecyclerView:" + hVar.f3970q.a());
                }
            }
            this.f3913e.b();
            requestLayout();
        }
    }

    @Deprecated
    public void setLayoutTransition(LayoutTransition layoutTransition) {
        if (Build.VERSION.SDK_INT < 18) {
            if (layoutTransition == null) {
                suppressLayout(false);
                return;
            } else if (layoutTransition.getAnimator(0) == null && layoutTransition.getAnimator(1) == null && layoutTransition.getAnimator(2) == null && layoutTransition.getAnimator(3) == null && layoutTransition.getAnimator(4) == null) {
                suppressLayout(true);
                return;
            }
        }
        if (layoutTransition == null) {
            super.setLayoutTransition((LayoutTransition) null);
            return;
        }
        throw new IllegalArgumentException("Providing a LayoutTransition into RecyclerView is not supported. Please use setItemAnimator() instead for animating changes to the items in this RecyclerView");
    }

    public void setNestedScrollingEnabled(boolean z2) {
        getScrollingChildHelper().a(z2);
    }

    public void setOnFlingListener(j jVar) {
        this.f3905as = jVar;
    }

    @Deprecated
    public void setOnScrollListener(l lVar) {
        this.f3911ay = lVar;
    }

    public void setPreserveFocusAfterLayout(boolean z2) {
        this.f3910ax = z2;
    }

    public void setRecycledViewPool(m mVar) {
        this.f3913e.a(mVar);
    }

    @Deprecated
    public void setRecyclerListener(o oVar) {
        this.f3924p = oVar;
    }

    /* access modifiers changed from: package-private */
    public void setScrollState(int i2) {
        if (i2 != this.f3897ak) {
            this.f3897ak = i2;
            if (i2 != 2) {
                B();
            }
            i(i2);
        }
    }

    public void setScrollingTouchSlop(int i2) {
        int i3;
        ViewConfiguration viewConfiguration = ViewConfiguration.get(getContext());
        if (i2 != 0) {
            if (i2 != 1) {
                Log.w("RecyclerView", "setScrollingTouchSlop(): bad argument constant " + i2 + "; using default value");
            } else {
                i3 = viewConfiguration.getScaledPagingTouchSlop();
                this.f3904ar = i3;
            }
        }
        i3 = viewConfiguration.getScaledTouchSlop();
        this.f3904ar = i3;
    }

    public void setViewCacheExtension(t tVar) {
        this.f3913e.a(tVar);
    }

    public boolean startNestedScroll(int i2) {
        return getScrollingChildHelper().b(i2);
    }

    public void stopNestedScroll() {
        getScrollingChildHelper().c();
    }

    public final void suppressLayout(boolean z2) {
        if (z2 != this.f3932x) {
            a("Do not suppressLayout in layout or scroll");
            if (!z2) {
                this.f3932x = false;
                if (!(!this.f3931w || this.f3923o == null || this.f3922n == null)) {
                    requestLayout();
                }
                this.f3931w = false;
                return;
            }
            long uptimeMillis = SystemClock.uptimeMillis();
            onTouchEvent(MotionEvent.obtain(uptimeMillis, uptimeMillis, 3, 0.0f, 0.0f, 0));
            this.f3932x = true;
            this.W = true;
            f();
        }
    }

    /* access modifiers changed from: package-private */
    public void t() {
        int c2 = this.f3916h.c();
        for (int i2 = 0; i2 < c2; i2++) {
            v e2 = e(this.f3916h.d(i2));
            if (!e2.shouldIgnore()) {
                e2.clearOldPosition();
            }
        }
        this.f3913e.i();
    }

    /* access modifiers changed from: package-private */
    public void u() {
        int c2 = this.f3916h.c();
        for (int i2 = 0; i2 < c2; i2++) {
            v e2 = e(this.f3916h.d(i2));
            if (e2 != null && !e2.shouldIgnore()) {
                e2.addFlags(6);
            }
        }
        r();
        this.f3913e.h();
    }

    public boolean v() {
        return !this.f3930v || this.f3934z || this.f3915g.d();
    }

    /* access modifiers changed from: package-private */
    public void w() {
        int b2 = this.f3916h.b();
        for (int i2 = 0; i2 < b2; i2++) {
            View b3 = this.f3916h.b(i2);
            v b4 = b(b3);
            if (!(b4 == null || b4.mShadowingHolder == null)) {
                View view = b4.mShadowingHolder.itemView;
                int left = b3.getLeft();
                int top = b3.getTop();
                if (left != view.getLeft() || top != view.getTop()) {
                    view.layout(left, top, view.getWidth() + left, view.getHeight() + top);
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void x() {
        int i2;
        for (int size = this.L.size() - 1; size >= 0; size--) {
            v vVar = this.L.get(size);
            if (vVar.itemView.getParent() == this && !vVar.shouldIgnore() && (i2 = vVar.mPendingAccessibilityState) != -1) {
                ac.b(vVar.itemView, i2);
                vVar.mPendingAccessibilityState = -1;
            }
        }
        this.L.clear();
    }
}
