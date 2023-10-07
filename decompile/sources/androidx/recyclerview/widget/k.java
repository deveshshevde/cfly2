package androidx.recyclerview.widget;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.os.Build;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.animation.Interpolator;
import androidx.recyclerview.R;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import t.ac;
import t.e;

public class k extends RecyclerView.g implements RecyclerView.i {
    private b A;
    private final RecyclerView.k B = new RecyclerView.k() {
        public void a(boolean z2) {
            if (z2) {
                k.this.a((RecyclerView.v) null, 0);
            }
        }

        public boolean a(RecyclerView recyclerView, MotionEvent motionEvent) {
            int findPointerIndex;
            c b2;
            k.this.f4252p.a(motionEvent);
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked == 0) {
                k.this.f4243g = motionEvent.getPointerId(0);
                k.this.f4239c = motionEvent.getX();
                k.this.f4240d = motionEvent.getY();
                k.this.d();
                if (k.this.f4238b == null && (b2 = k.this.b(motionEvent)) != null) {
                    k.this.f4239c -= b2.f4287m;
                    k.this.f4240d -= b2.f4288n;
                    k.this.a(b2.f4282h, true);
                    if (k.this.f4237a.remove(b2.f4282h.itemView)) {
                        k.this.f4244h.d(k.this.f4247k, b2.f4282h);
                    }
                    k.this.a(b2.f4282h, b2.f4283i);
                    k kVar = k.this;
                    kVar.a(motionEvent, kVar.f4245i, 0);
                }
            } else if (actionMasked == 3 || actionMasked == 1) {
                k.this.f4243g = -1;
                k.this.a((RecyclerView.v) null, 0);
            } else if (k.this.f4243g != -1 && (findPointerIndex = motionEvent.findPointerIndex(k.this.f4243g)) >= 0) {
                k.this.a(actionMasked, motionEvent, findPointerIndex);
            }
            if (k.this.f4249m != null) {
                k.this.f4249m.addMovement(motionEvent);
            }
            return k.this.f4238b != null;
        }

        public void b(RecyclerView recyclerView, MotionEvent motionEvent) {
            k.this.f4252p.a(motionEvent);
            if (k.this.f4249m != null) {
                k.this.f4249m.addMovement(motionEvent);
            }
            if (k.this.f4243g != -1) {
                int actionMasked = motionEvent.getActionMasked();
                int findPointerIndex = motionEvent.findPointerIndex(k.this.f4243g);
                if (findPointerIndex >= 0) {
                    k.this.a(actionMasked, motionEvent, findPointerIndex);
                }
                RecyclerView.v vVar = k.this.f4238b;
                if (vVar != null) {
                    int i2 = 0;
                    if (actionMasked != 1) {
                        if (actionMasked != 2) {
                            if (actionMasked != 3) {
                                if (actionMasked == 6) {
                                    int actionIndex = motionEvent.getActionIndex();
                                    if (motionEvent.getPointerId(actionIndex) == k.this.f4243g) {
                                        if (actionIndex == 0) {
                                            i2 = 1;
                                        }
                                        k.this.f4243g = motionEvent.getPointerId(i2);
                                        k kVar = k.this;
                                        kVar.a(motionEvent, kVar.f4245i, actionIndex);
                                        return;
                                    }
                                    return;
                                }
                                return;
                            } else if (k.this.f4249m != null) {
                                k.this.f4249m.clear();
                            }
                        } else if (findPointerIndex >= 0) {
                            k kVar2 = k.this;
                            kVar2.a(motionEvent, kVar2.f4245i, findPointerIndex);
                            k.this.a(vVar);
                            k.this.f4247k.removeCallbacks(k.this.f4248l);
                            k.this.f4248l.run();
                            k.this.f4247k.invalidate();
                            return;
                        } else {
                            return;
                        }
                    }
                    k.this.a((RecyclerView.v) null, 0);
                    k.this.f4243g = -1;
                }
            }
        }
    };
    private Rect C;
    private long D;

    /* renamed from: a  reason: collision with root package name */
    final List<View> f4237a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    RecyclerView.v f4238b = null;

    /* renamed from: c  reason: collision with root package name */
    float f4239c;

    /* renamed from: d  reason: collision with root package name */
    float f4240d;

    /* renamed from: e  reason: collision with root package name */
    float f4241e;

    /* renamed from: f  reason: collision with root package name */
    float f4242f;

    /* renamed from: g  reason: collision with root package name */
    int f4243g = -1;

    /* renamed from: h  reason: collision with root package name */
    a f4244h;

    /* renamed from: i  reason: collision with root package name */
    int f4245i;

    /* renamed from: j  reason: collision with root package name */
    List<c> f4246j = new ArrayList();

    /* renamed from: k  reason: collision with root package name */
    RecyclerView f4247k;

    /* renamed from: l  reason: collision with root package name */
    final Runnable f4248l = new Runnable() {
        public void run() {
            if (k.this.f4238b != null && k.this.c()) {
                if (k.this.f4238b != null) {
                    k kVar = k.this;
                    kVar.a(kVar.f4238b);
                }
                k.this.f4247k.removeCallbacks(k.this.f4248l);
                ac.a((View) k.this.f4247k, (Runnable) this);
            }
        }
    };

    /* renamed from: m  reason: collision with root package name */
    VelocityTracker f4249m;

    /* renamed from: n  reason: collision with root package name */
    View f4250n = null;

    /* renamed from: o  reason: collision with root package name */
    int f4251o = -1;

    /* renamed from: p  reason: collision with root package name */
    e f4252p;

    /* renamed from: q  reason: collision with root package name */
    private final float[] f4253q = new float[2];

    /* renamed from: r  reason: collision with root package name */
    private float f4254r;

    /* renamed from: s  reason: collision with root package name */
    private float f4255s;

    /* renamed from: t  reason: collision with root package name */
    private float f4256t;

    /* renamed from: u  reason: collision with root package name */
    private float f4257u;

    /* renamed from: v  reason: collision with root package name */
    private int f4258v = 0;

    /* renamed from: w  reason: collision with root package name */
    private int f4259w;

    /* renamed from: x  reason: collision with root package name */
    private List<RecyclerView.v> f4260x;

    /* renamed from: y  reason: collision with root package name */
    private List<Integer> f4261y;

    /* renamed from: z  reason: collision with root package name */
    private RecyclerView.c f4262z = null;

    public static abstract class a {

        /* renamed from: a  reason: collision with root package name */
        private static final Interpolator f4272a = new Interpolator() {
            public float getInterpolation(float f2) {
                return f2 * f2 * f2 * f2 * f2;
            }
        };

        /* renamed from: b  reason: collision with root package name */
        private static final Interpolator f4273b = new Interpolator() {
            public float getInterpolation(float f2) {
                float f3 = f2 - 1.0f;
                return (f3 * f3 * f3 * f3 * f3) + 1.0f;
            }
        };

        /* renamed from: c  reason: collision with root package name */
        private int f4274c = -1;

        public static int a(int i2, int i3) {
            int i4;
            int i5 = i2 & 789516;
            if (i5 == 0) {
                return i2;
            }
            int i6 = i2 & (i5 ^ -1);
            if (i3 == 0) {
                i4 = i5 << 2;
            } else {
                int i7 = i5 << 1;
                i6 |= -789517 & i7;
                i4 = (i7 & 789516) << 2;
            }
            return i6 | i4;
        }

        private int a(RecyclerView recyclerView) {
            if (this.f4274c == -1) {
                this.f4274c = recyclerView.getResources().getDimensionPixelSize(R.dimen.item_touch_helper_max_drag_scroll_per_frame);
            }
            return this.f4274c;
        }

        public static int b(int i2, int i3) {
            int c2 = c(0, i3 | i2);
            return c(2, i2) | c(1, i3) | c2;
        }

        public static int c(int i2, int i3) {
            return i3 << (i2 * 8);
        }

        public float a(float f2) {
            return f2;
        }

        public float a(RecyclerView.v vVar) {
            return 0.5f;
        }

        public int a(RecyclerView recyclerView, int i2, int i3, int i4, long j2) {
            float f2 = 1.0f;
            int signum = (int) (((float) (((int) Math.signum((float) i3)) * a(recyclerView))) * f4273b.getInterpolation(Math.min(1.0f, (((float) Math.abs(i3)) * 1.0f) / ((float) i2))));
            if (j2 <= 2000) {
                f2 = ((float) j2) / 2000.0f;
            }
            int interpolation = (int) (((float) signum) * f4272a.getInterpolation(f2));
            return interpolation == 0 ? i3 > 0 ? 1 : -1 : interpolation;
        }

        public abstract int a(RecyclerView recyclerView, RecyclerView.v vVar);

        public long a(RecyclerView recyclerView, int i2, float f2, float f3) {
            RecyclerView.e itemAnimator = recyclerView.getItemAnimator();
            return itemAnimator == null ? i2 == 8 ? 200 : 250 : i2 == 8 ? itemAnimator.e() : itemAnimator.g();
        }

        public RecyclerView.v a(RecyclerView.v vVar, List<RecyclerView.v> list, int i2, int i3) {
            int bottom;
            int abs;
            int top;
            int abs2;
            int left;
            int abs3;
            int right;
            int abs4;
            RecyclerView.v vVar2 = vVar;
            int width = i2 + vVar2.itemView.getWidth();
            int height = i3 + vVar2.itemView.getHeight();
            int left2 = i2 - vVar2.itemView.getLeft();
            int top2 = i3 - vVar2.itemView.getTop();
            int size = list.size();
            RecyclerView.v vVar3 = null;
            int i4 = -1;
            for (int i5 = 0; i5 < size; i5++) {
                RecyclerView.v vVar4 = list.get(i5);
                if (left2 > 0 && (right = vVar4.itemView.getRight() - width) < 0 && vVar4.itemView.getRight() > vVar2.itemView.getRight() && (abs4 = Math.abs(right)) > i4) {
                    vVar3 = vVar4;
                    i4 = abs4;
                }
                if (left2 < 0 && (left = vVar4.itemView.getLeft() - i2) > 0 && vVar4.itemView.getLeft() < vVar2.itemView.getLeft() && (abs3 = Math.abs(left)) > i4) {
                    vVar3 = vVar4;
                    i4 = abs3;
                }
                if (top2 < 0 && (top = vVar4.itemView.getTop() - i3) > 0 && vVar4.itemView.getTop() < vVar2.itemView.getTop() && (abs2 = Math.abs(top)) > i4) {
                    vVar3 = vVar4;
                    i4 = abs2;
                }
                if (top2 > 0 && (bottom = vVar4.itemView.getBottom() - height) < 0 && vVar4.itemView.getBottom() > vVar2.itemView.getBottom() && (abs = Math.abs(bottom)) > i4) {
                    vVar3 = vVar4;
                    i4 = abs;
                }
            }
            return vVar3;
        }

        public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.v vVar, float f2, float f3, int i2, boolean z2) {
            m.f4292a.a(canvas, recyclerView, vVar.itemView, f2, f3, i2, z2);
        }

        /* access modifiers changed from: package-private */
        public void a(Canvas canvas, RecyclerView recyclerView, RecyclerView.v vVar, List<c> list, int i2, float f2, float f3) {
            Canvas canvas2 = canvas;
            int size = list.size();
            for (int i3 = 0; i3 < size; i3++) {
                c cVar = list.get(i3);
                cVar.c();
                int save = canvas.save();
                a(canvas, recyclerView, cVar.f4282h, cVar.f4287m, cVar.f4288n, cVar.f4283i, false);
                canvas.restoreToCount(save);
            }
            if (vVar != null) {
                int save2 = canvas.save();
                a(canvas, recyclerView, vVar, f2, f3, i2, true);
                canvas.restoreToCount(save2);
            }
        }

        public abstract void a(RecyclerView.v vVar, int i2);

        public void a(RecyclerView recyclerView, RecyclerView.v vVar, int i2, RecyclerView.v vVar2, int i3, int i4, int i5) {
            RecyclerView.h layoutManager = recyclerView.getLayoutManager();
            if (layoutManager instanceof d) {
                ((d) layoutManager).a(vVar.itemView, vVar2.itemView, i4, i5);
                return;
            }
            if (layoutManager.f()) {
                if (layoutManager.h(vVar2.itemView) <= recyclerView.getPaddingLeft()) {
                    recyclerView.a(i3);
                }
                if (layoutManager.j(vVar2.itemView) >= recyclerView.getWidth() - recyclerView.getPaddingRight()) {
                    recyclerView.a(i3);
                }
            }
            if (layoutManager.g()) {
                if (layoutManager.i(vVar2.itemView) <= recyclerView.getPaddingTop()) {
                    recyclerView.a(i3);
                }
                if (layoutManager.k(vVar2.itemView) >= recyclerView.getHeight() - recyclerView.getPaddingBottom()) {
                    recyclerView.a(i3);
                }
            }
        }

        public boolean a() {
            return true;
        }

        public boolean a(RecyclerView recyclerView, RecyclerView.v vVar, RecyclerView.v vVar2) {
            return true;
        }

        public float b(float f2) {
            return f2;
        }

        public float b(RecyclerView.v vVar) {
            return 0.5f;
        }

        /* access modifiers changed from: package-private */
        public final int b(RecyclerView recyclerView, RecyclerView.v vVar) {
            return d(a(recyclerView, vVar), ac.i(recyclerView));
        }

        public void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.v vVar, float f2, float f3, int i2, boolean z2) {
            m.f4292a.b(canvas, recyclerView, vVar.itemView, f2, f3, i2, z2);
        }

        /* access modifiers changed from: package-private */
        public void b(Canvas canvas, RecyclerView recyclerView, RecyclerView.v vVar, List<c> list, int i2, float f2, float f3) {
            Canvas canvas2 = canvas;
            List<c> list2 = list;
            int size = list.size();
            boolean z2 = false;
            for (int i3 = 0; i3 < size; i3++) {
                c cVar = list2.get(i3);
                int save = canvas.save();
                b(canvas, recyclerView, cVar.f4282h, cVar.f4287m, cVar.f4288n, cVar.f4283i, false);
                canvas.restoreToCount(save);
            }
            if (vVar != null) {
                int save2 = canvas.save();
                b(canvas, recyclerView, vVar, f2, f3, i2, true);
                canvas.restoreToCount(save2);
            }
            for (int i4 = size - 1; i4 >= 0; i4--) {
                c cVar2 = list2.get(i4);
                if (cVar2.f4290p && !cVar2.f4286l) {
                    list2.remove(i4);
                } else if (!cVar2.f4290p) {
                    z2 = true;
                }
            }
            if (z2) {
                recyclerView.invalidate();
            }
        }

        public void b(RecyclerView.v vVar, int i2) {
            if (vVar != null) {
                m.f4292a.b(vVar.itemView);
            }
        }

        public boolean b() {
            return true;
        }

        public abstract boolean b(RecyclerView recyclerView, RecyclerView.v vVar, RecyclerView.v vVar2);

        public int c() {
            return 0;
        }

        /* access modifiers changed from: package-private */
        public boolean c(RecyclerView recyclerView, RecyclerView.v vVar) {
            return (b(recyclerView, vVar) & 16711680) != 0;
        }

        public int d(int i2, int i3) {
            int i4;
            int i5 = i2 & 3158064;
            if (i5 == 0) {
                return i2;
            }
            int i6 = i2 & (i5 ^ -1);
            if (i3 == 0) {
                i4 = i5 >> 2;
            } else {
                int i7 = i5 >> 1;
                i6 |= -3158065 & i7;
                i4 = (i7 & 3158064) >> 2;
            }
            return i6 | i4;
        }

        public void d(RecyclerView recyclerView, RecyclerView.v vVar) {
            m.f4292a.a(vVar.itemView);
        }
    }

    private class b extends GestureDetector.SimpleOnGestureListener {

        /* renamed from: b  reason: collision with root package name */
        private boolean f4276b = true;

        b() {
        }

        /* access modifiers changed from: package-private */
        public void a() {
            this.f4276b = false;
        }

        public boolean onDown(MotionEvent motionEvent) {
            return true;
        }

        public void onLongPress(MotionEvent motionEvent) {
            View a2;
            RecyclerView.v b2;
            if (this.f4276b && (a2 = k.this.a(motionEvent)) != null && (b2 = k.this.f4247k.b(a2)) != null && k.this.f4244h.c(k.this.f4247k, b2) && motionEvent.getPointerId(0) == k.this.f4243g) {
                int findPointerIndex = motionEvent.findPointerIndex(k.this.f4243g);
                float x2 = motionEvent.getX(findPointerIndex);
                float y2 = motionEvent.getY(findPointerIndex);
                k.this.f4239c = x2;
                k.this.f4240d = y2;
                k kVar = k.this;
                kVar.f4242f = 0.0f;
                kVar.f4241e = 0.0f;
                if (k.this.f4244h.a()) {
                    k.this.a(b2, 2);
                }
            }
        }
    }

    static class c implements Animator.AnimatorListener {

        /* renamed from: a  reason: collision with root package name */
        private float f4277a;

        /* renamed from: d  reason: collision with root package name */
        final float f4278d;

        /* renamed from: e  reason: collision with root package name */
        final float f4279e;

        /* renamed from: f  reason: collision with root package name */
        final float f4280f;

        /* renamed from: g  reason: collision with root package name */
        final float f4281g;

        /* renamed from: h  reason: collision with root package name */
        final RecyclerView.v f4282h;

        /* renamed from: i  reason: collision with root package name */
        final int f4283i;

        /* renamed from: j  reason: collision with root package name */
        final ValueAnimator f4284j;

        /* renamed from: k  reason: collision with root package name */
        final int f4285k;

        /* renamed from: l  reason: collision with root package name */
        boolean f4286l;

        /* renamed from: m  reason: collision with root package name */
        float f4287m;

        /* renamed from: n  reason: collision with root package name */
        float f4288n;

        /* renamed from: o  reason: collision with root package name */
        boolean f4289o = false;

        /* renamed from: p  reason: collision with root package name */
        boolean f4290p = false;

        c(RecyclerView.v vVar, int i2, int i3, float f2, float f3, float f4, float f5) {
            this.f4283i = i3;
            this.f4285k = i2;
            this.f4282h = vVar;
            this.f4278d = f2;
            this.f4279e = f3;
            this.f4280f = f4;
            this.f4281g = f5;
            ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
            this.f4284j = ofFloat;
            ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    c.this.a(valueAnimator.getAnimatedFraction());
                }
            });
            ofFloat.setTarget(vVar.itemView);
            ofFloat.addListener(this);
            a(0.0f);
        }

        public void a() {
            this.f4282h.setIsRecyclable(false);
            this.f4284j.start();
        }

        public void a(float f2) {
            this.f4277a = f2;
        }

        public void a(long j2) {
            this.f4284j.setDuration(j2);
        }

        public void b() {
            this.f4284j.cancel();
        }

        public void c() {
            float f2 = this.f4278d;
            float f3 = this.f4280f;
            this.f4287m = f2 == f3 ? this.f4282h.itemView.getTranslationX() : f2 + (this.f4277a * (f3 - f2));
            float f4 = this.f4279e;
            float f5 = this.f4281g;
            this.f4288n = f4 == f5 ? this.f4282h.itemView.getTranslationY() : f4 + (this.f4277a * (f5 - f4));
        }

        public void onAnimationCancel(Animator animator) {
            a(1.0f);
        }

        public void onAnimationEnd(Animator animator) {
            if (!this.f4290p) {
                this.f4282h.setIsRecyclable(true);
            }
            this.f4290p = true;
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }
    }

    public interface d {
        void a(View view, View view2, int i2, int i3);
    }

    public k(a aVar) {
        this.f4244h = aVar;
    }

    private void a() {
        this.f4259w = ViewConfiguration.get(this.f4247k.getContext()).getScaledTouchSlop();
        this.f4247k.a((RecyclerView.g) this);
        this.f4247k.a(this.B);
        this.f4247k.a((RecyclerView.i) this);
        f();
    }

    private void a(float[] fArr) {
        if ((this.f4245i & 12) != 0) {
            fArr[0] = (this.f4256t + this.f4241e) - ((float) this.f4238b.itemView.getLeft());
        } else {
            fArr[0] = this.f4238b.itemView.getTranslationX();
        }
        if ((this.f4245i & 3) != 0) {
            fArr[1] = (this.f4257u + this.f4242f) - ((float) this.f4238b.itemView.getTop());
        } else {
            fArr[1] = this.f4238b.itemView.getTranslationY();
        }
    }

    private static boolean a(View view, float f2, float f3, float f4, float f5) {
        return f2 >= f4 && f2 <= f4 + ((float) view.getWidth()) && f3 >= f5 && f3 <= f5 + ((float) view.getHeight());
    }

    private int b(RecyclerView.v vVar, int i2) {
        if ((i2 & 12) == 0) {
            return 0;
        }
        int i3 = 8;
        int i4 = this.f4241e > 0.0f ? 8 : 4;
        VelocityTracker velocityTracker = this.f4249m;
        if (velocityTracker != null && this.f4243g > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f4244h.b(this.f4255s));
            float xVelocity = this.f4249m.getXVelocity(this.f4243g);
            float yVelocity = this.f4249m.getYVelocity(this.f4243g);
            if (xVelocity <= 0.0f) {
                i3 = 4;
            }
            float abs = Math.abs(xVelocity);
            if ((i3 & i2) != 0 && i4 == i3 && abs >= this.f4244h.a(this.f4254r) && abs > Math.abs(yVelocity)) {
                return i3;
            }
        }
        float width = ((float) this.f4247k.getWidth()) * this.f4244h.a(vVar);
        if ((i2 & i4) == 0 || Math.abs(this.f4241e) <= width) {
            return 0;
        }
        return i4;
    }

    private List<RecyclerView.v> b(RecyclerView.v vVar) {
        RecyclerView.v vVar2 = vVar;
        List<RecyclerView.v> list = this.f4260x;
        if (list == null) {
            this.f4260x = new ArrayList();
            this.f4261y = new ArrayList();
        } else {
            list.clear();
            this.f4261y.clear();
        }
        int c2 = this.f4244h.c();
        int round = Math.round(this.f4256t + this.f4241e) - c2;
        int round2 = Math.round(this.f4257u + this.f4242f) - c2;
        int i2 = c2 * 2;
        int width = vVar2.itemView.getWidth() + round + i2;
        int height = vVar2.itemView.getHeight() + round2 + i2;
        int i3 = (round + width) / 2;
        int i4 = (round2 + height) / 2;
        RecyclerView.h layoutManager = this.f4247k.getLayoutManager();
        int z2 = layoutManager.z();
        int i5 = 0;
        while (i5 < z2) {
            View i6 = layoutManager.i(i5);
            if (i6 != vVar2.itemView && i6.getBottom() >= round2 && i6.getTop() <= height && i6.getRight() >= round && i6.getLeft() <= width) {
                RecyclerView.v b2 = this.f4247k.b(i6);
                if (this.f4244h.a(this.f4247k, this.f4238b, b2)) {
                    int abs = Math.abs(i3 - ((i6.getLeft() + i6.getRight()) / 2));
                    int abs2 = Math.abs(i4 - ((i6.getTop() + i6.getBottom()) / 2));
                    int i7 = (abs * abs) + (abs2 * abs2);
                    int size = this.f4260x.size();
                    int i8 = 0;
                    int i9 = 0;
                    while (i8 < size && i7 > this.f4261y.get(i8).intValue()) {
                        i9++;
                        i8++;
                        RecyclerView.v vVar3 = vVar;
                    }
                    this.f4260x.add(i9, b2);
                    this.f4261y.add(i9, Integer.valueOf(i7));
                }
            }
            i5++;
            vVar2 = vVar;
        }
        return this.f4260x;
    }

    private int c(RecyclerView.v vVar) {
        if (this.f4258v == 2) {
            return 0;
        }
        int a2 = this.f4244h.a(this.f4247k, vVar);
        int d2 = (this.f4244h.d(a2, ac.i(this.f4247k)) & 65280) >> 8;
        if (d2 == 0) {
            return 0;
        }
        int i2 = (a2 & 65280) >> 8;
        if (Math.abs(this.f4241e) > Math.abs(this.f4242f)) {
            int b2 = b(vVar, d2);
            if (b2 > 0) {
                return (i2 & b2) == 0 ? a.a(b2, ac.i(this.f4247k)) : b2;
            }
            int c2 = c(vVar, d2);
            if (c2 > 0) {
                return c2;
            }
        } else {
            int c3 = c(vVar, d2);
            if (c3 > 0) {
                return c3;
            }
            int b3 = b(vVar, d2);
            if (b3 > 0) {
                return (i2 & b3) == 0 ? a.a(b3, ac.i(this.f4247k)) : b3;
            }
        }
        return 0;
    }

    private int c(RecyclerView.v vVar, int i2) {
        if ((i2 & 3) == 0) {
            return 0;
        }
        int i3 = 2;
        int i4 = this.f4242f > 0.0f ? 2 : 1;
        VelocityTracker velocityTracker = this.f4249m;
        if (velocityTracker != null && this.f4243g > -1) {
            velocityTracker.computeCurrentVelocity(1000, this.f4244h.b(this.f4255s));
            float xVelocity = this.f4249m.getXVelocity(this.f4243g);
            float yVelocity = this.f4249m.getYVelocity(this.f4243g);
            if (yVelocity <= 0.0f) {
                i3 = 1;
            }
            float abs = Math.abs(yVelocity);
            if ((i3 & i2) != 0 && i3 == i4 && abs >= this.f4244h.a(this.f4254r) && abs > Math.abs(xVelocity)) {
                return i3;
            }
        }
        float height = ((float) this.f4247k.getHeight()) * this.f4244h.a(vVar);
        if ((i2 & i4) == 0 || Math.abs(this.f4242f) <= height) {
            return 0;
        }
        return i4;
    }

    private RecyclerView.v c(MotionEvent motionEvent) {
        View a2;
        RecyclerView.h layoutManager = this.f4247k.getLayoutManager();
        int i2 = this.f4243g;
        if (i2 == -1) {
            return null;
        }
        int findPointerIndex = motionEvent.findPointerIndex(i2);
        float abs = Math.abs(motionEvent.getX(findPointerIndex) - this.f4239c);
        float abs2 = Math.abs(motionEvent.getY(findPointerIndex) - this.f4240d);
        int i3 = this.f4259w;
        if (abs < ((float) i3) && abs2 < ((float) i3)) {
            return null;
        }
        if (abs > abs2 && layoutManager.f()) {
            return null;
        }
        if ((abs2 <= abs || !layoutManager.g()) && (a2 = a(motionEvent)) != null) {
            return this.f4247k.b(a2);
        }
        return null;
    }

    private void e() {
        this.f4247k.b((RecyclerView.g) this);
        this.f4247k.b(this.B);
        this.f4247k.b((RecyclerView.i) this);
        for (int size = this.f4246j.size() - 1; size >= 0; size--) {
            c cVar = this.f4246j.get(0);
            cVar.b();
            this.f4244h.d(this.f4247k, cVar.f4282h);
        }
        this.f4246j.clear();
        this.f4250n = null;
        this.f4251o = -1;
        h();
        g();
    }

    private void f() {
        this.A = new b();
        this.f4252p = new e(this.f4247k.getContext(), this.A);
    }

    private void g() {
        b bVar = this.A;
        if (bVar != null) {
            bVar.a();
            this.A = null;
        }
        if (this.f4252p != null) {
            this.f4252p = null;
        }
    }

    private void h() {
        VelocityTracker velocityTracker = this.f4249m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
            this.f4249m = null;
        }
    }

    private void i() {
        if (Build.VERSION.SDK_INT < 21) {
            if (this.f4262z == null) {
                this.f4262z = new RecyclerView.c() {
                    public int a(int i2, int i3) {
                        if (k.this.f4250n == null) {
                            return i3;
                        }
                        int i4 = k.this.f4251o;
                        if (i4 == -1) {
                            i4 = k.this.f4247k.indexOfChild(k.this.f4250n);
                            k.this.f4251o = i4;
                        }
                        return i3 == i2 + -1 ? i4 : i3 < i4 ? i3 : i3 + 1;
                    }
                };
            }
            this.f4247k.setChildDrawingOrderCallback(this.f4262z);
        }
    }

    /* access modifiers changed from: package-private */
    public View a(MotionEvent motionEvent) {
        float x2 = motionEvent.getX();
        float y2 = motionEvent.getY();
        RecyclerView.v vVar = this.f4238b;
        if (vVar != null) {
            View view = vVar.itemView;
            if (a(view, x2, y2, this.f4256t + this.f4241e, this.f4257u + this.f4242f)) {
                return view;
            }
        }
        for (int size = this.f4246j.size() - 1; size >= 0; size--) {
            c cVar = this.f4246j.get(size);
            View view2 = cVar.f4282h.itemView;
            if (a(view2, x2, y2, cVar.f4287m, cVar.f4288n)) {
                return view2;
            }
        }
        return this.f4247k.a(x2, y2);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, MotionEvent motionEvent, int i3) {
        RecyclerView.v c2;
        int b2;
        if (this.f4238b == null && i2 == 2 && this.f4258v != 2 && this.f4244h.b() && this.f4247k.getScrollState() != 1 && (c2 = c(motionEvent)) != null && (b2 = (this.f4244h.b(this.f4247k, c2) & 65280) >> 8) != 0) {
            float x2 = motionEvent.getX(i3);
            float y2 = motionEvent.getY(i3);
            float f2 = x2 - this.f4239c;
            float f3 = y2 - this.f4240d;
            float abs = Math.abs(f2);
            float abs2 = Math.abs(f3);
            int i4 = this.f4259w;
            if (abs >= ((float) i4) || abs2 >= ((float) i4)) {
                if (abs > abs2) {
                    if (f2 < 0.0f && (b2 & 4) == 0) {
                        return;
                    }
                    if (f2 > 0.0f && (b2 & 8) == 0) {
                        return;
                    }
                } else if (f3 < 0.0f && (b2 & 1) == 0) {
                    return;
                } else {
                    if (f3 > 0.0f && (b2 & 2) == 0) {
                        return;
                    }
                }
                this.f4242f = 0.0f;
                this.f4241e = 0.0f;
                this.f4243g = motionEvent.getPointerId(0);
                a(c2, 1);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(MotionEvent motionEvent, int i2, int i3) {
        float x2 = motionEvent.getX(i3);
        float y2 = motionEvent.getY(i3);
        float f2 = x2 - this.f4239c;
        this.f4241e = f2;
        this.f4242f = y2 - this.f4240d;
        if ((i2 & 4) == 0) {
            this.f4241e = Math.max(0.0f, f2);
        }
        if ((i2 & 8) == 0) {
            this.f4241e = Math.min(0.0f, this.f4241e);
        }
        if ((i2 & 1) == 0) {
            this.f4242f = Math.max(0.0f, this.f4242f);
        }
        if ((i2 & 2) == 0) {
            this.f4242f = Math.min(0.0f, this.f4242f);
        }
    }

    public void a(View view) {
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.v vVar) {
        if (!this.f4247k.isLayoutRequested() && this.f4258v == 2) {
            float b2 = this.f4244h.b(vVar);
            int i2 = (int) (this.f4256t + this.f4241e);
            int i3 = (int) (this.f4257u + this.f4242f);
            if (((float) Math.abs(i3 - vVar.itemView.getTop())) >= ((float) vVar.itemView.getHeight()) * b2 || ((float) Math.abs(i2 - vVar.itemView.getLeft())) >= ((float) vVar.itemView.getWidth()) * b2) {
                List<RecyclerView.v> b3 = b(vVar);
                if (b3.size() != 0) {
                    RecyclerView.v a2 = this.f4244h.a(vVar, b3, i2, i3);
                    if (a2 == null) {
                        this.f4260x.clear();
                        this.f4261y.clear();
                        return;
                    }
                    int absoluteAdapterPosition = a2.getAbsoluteAdapterPosition();
                    int absoluteAdapterPosition2 = vVar.getAbsoluteAdapterPosition();
                    if (this.f4244h.b(this.f4247k, vVar, a2)) {
                        this.f4244h.a(this.f4247k, vVar, absoluteAdapterPosition2, a2, absoluteAdapterPosition, i2, i3);
                    }
                }
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x012b  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x0137  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void a(androidx.recyclerview.widget.RecyclerView.v r24, int r25) {
        /*
            r23 = this;
            r11 = r23
            r12 = r24
            r13 = r25
            androidx.recyclerview.widget.RecyclerView$v r0 = r11.f4238b
            if (r12 != r0) goto L_0x000f
            int r0 = r11.f4258v
            if (r13 != r0) goto L_0x000f
            return
        L_0x000f:
            r0 = -9223372036854775808
            r11.D = r0
            int r4 = r11.f4258v
            r14 = 1
            r11.a((androidx.recyclerview.widget.RecyclerView.v) r12, (boolean) r14)
            r11.f4258v = r13
            r15 = 2
            if (r13 != r15) goto L_0x0030
            if (r12 == 0) goto L_0x0028
            android.view.View r0 = r12.itemView
            r11.f4250n = r0
            r23.i()
            goto L_0x0030
        L_0x0028:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.String r1 = "Must pass a ViewHolder when dragging"
            r0.<init>(r1)
            throw r0
        L_0x0030:
            int r0 = r13 * 8
            r10 = 8
            int r0 = r0 + r10
            int r0 = r14 << r0
            int r16 = r0 + -1
            androidx.recyclerview.widget.RecyclerView$v r9 = r11.f4238b
            r8 = 0
            if (r9 == 0) goto L_0x00ee
            android.view.View r0 = r9.itemView
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x00da
            if (r4 != r15) goto L_0x004a
            r7 = 0
            goto L_0x004f
        L_0x004a:
            int r0 = r11.c((androidx.recyclerview.widget.RecyclerView.v) r9)
            r7 = r0
        L_0x004f:
            r23.h()
            r0 = 4
            r1 = 0
            if (r7 == r14) goto L_0x007b
            if (r7 == r15) goto L_0x007b
            if (r7 == r0) goto L_0x0067
            if (r7 == r10) goto L_0x0067
            r2 = 16
            if (r7 == r2) goto L_0x0067
            r2 = 32
            if (r7 == r2) goto L_0x0067
            r17 = 0
            goto L_0x0078
        L_0x0067:
            float r2 = r11.f4241e
            float r2 = java.lang.Math.signum(r2)
            androidx.recyclerview.widget.RecyclerView r3 = r11.f4247k
            int r3 = r3.getWidth()
            float r3 = (float) r3
            float r2 = r2 * r3
            r17 = r2
        L_0x0078:
            r18 = 0
            goto L_0x008e
        L_0x007b:
            float r2 = r11.f4242f
            float r2 = java.lang.Math.signum(r2)
            androidx.recyclerview.widget.RecyclerView r3 = r11.f4247k
            int r3 = r3.getHeight()
            float r3 = (float) r3
            float r2 = r2 * r3
            r18 = r2
            r17 = 0
        L_0x008e:
            if (r4 != r15) goto L_0x0093
            r6 = 8
            goto L_0x0098
        L_0x0093:
            if (r7 <= 0) goto L_0x0097
            r6 = 2
            goto L_0x0098
        L_0x0097:
            r6 = 4
        L_0x0098:
            float[] r0 = r11.f4253q
            r11.a((float[]) r0)
            float[] r0 = r11.f4253q
            r19 = r0[r8]
            r20 = r0[r14]
            androidx.recyclerview.widget.k$3 r5 = new androidx.recyclerview.widget.k$3
            r0 = r5
            r1 = r23
            r2 = r9
            r3 = r6
            r14 = r5
            r5 = r19
            r15 = r6
            r6 = r20
            r21 = r7
            r7 = r17
            r8 = r18
            r22 = r9
            r9 = r21
            r21 = 8
            r10 = r22
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10)
            androidx.recyclerview.widget.k$a r0 = r11.f4244h
            androidx.recyclerview.widget.RecyclerView r1 = r11.f4247k
            float r2 = r17 - r19
            float r3 = r18 - r20
            long r0 = r0.a((androidx.recyclerview.widget.RecyclerView) r1, (int) r15, (float) r2, (float) r3)
            r14.a((long) r0)
            java.util.List<androidx.recyclerview.widget.k$c> r0 = r11.f4246j
            r0.add(r14)
            r14.a()
            r8 = 1
            goto L_0x00ea
        L_0x00da:
            r0 = r9
            r21 = 8
            android.view.View r1 = r0.itemView
            r11.c((android.view.View) r1)
            androidx.recyclerview.widget.k$a r1 = r11.f4244h
            androidx.recyclerview.widget.RecyclerView r2 = r11.f4247k
            r1.d((androidx.recyclerview.widget.RecyclerView) r2, (androidx.recyclerview.widget.RecyclerView.v) r0)
            r8 = 0
        L_0x00ea:
            r0 = 0
            r11.f4238b = r0
            goto L_0x00f1
        L_0x00ee:
            r21 = 8
            r8 = 0
        L_0x00f1:
            if (r12 == 0) goto L_0x0122
            androidx.recyclerview.widget.k$a r0 = r11.f4244h
            androidx.recyclerview.widget.RecyclerView r1 = r11.f4247k
            int r0 = r0.b((androidx.recyclerview.widget.RecyclerView) r1, (androidx.recyclerview.widget.RecyclerView.v) r12)
            r0 = r0 & r16
            int r1 = r11.f4258v
            int r1 = r1 * 8
            int r0 = r0 >> r1
            r11.f4245i = r0
            android.view.View r0 = r12.itemView
            int r0 = r0.getLeft()
            float r0 = (float) r0
            r11.f4256t = r0
            android.view.View r0 = r12.itemView
            int r0 = r0.getTop()
            float r0 = (float) r0
            r11.f4257u = r0
            r11.f4238b = r12
            r0 = 2
            if (r13 != r0) goto L_0x0122
            android.view.View r0 = r12.itemView
            r1 = 0
            r0.performHapticFeedback(r1)
            goto L_0x0123
        L_0x0122:
            r1 = 0
        L_0x0123:
            androidx.recyclerview.widget.RecyclerView r0 = r11.f4247k
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x0135
            androidx.recyclerview.widget.RecyclerView$v r2 = r11.f4238b
            if (r2 == 0) goto L_0x0131
            r14 = 1
            goto L_0x0132
        L_0x0131:
            r14 = 0
        L_0x0132:
            r0.requestDisallowInterceptTouchEvent(r14)
        L_0x0135:
            if (r8 != 0) goto L_0x0140
            androidx.recyclerview.widget.RecyclerView r0 = r11.f4247k
            androidx.recyclerview.widget.RecyclerView$h r0 = r0.getLayoutManager()
            r0.N()
        L_0x0140:
            androidx.recyclerview.widget.k$a r0 = r11.f4244h
            androidx.recyclerview.widget.RecyclerView$v r1 = r11.f4238b
            int r2 = r11.f4258v
            r0.b((androidx.recyclerview.widget.RecyclerView.v) r1, (int) r2)
            androidx.recyclerview.widget.RecyclerView r0 = r11.f4247k
            r0.invalidate()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.k.a(androidx.recyclerview.widget.RecyclerView$v, int):void");
    }

    /* access modifiers changed from: package-private */
    public void a(RecyclerView.v vVar, boolean z2) {
        for (int size = this.f4246j.size() - 1; size >= 0; size--) {
            c cVar = this.f4246j.get(size);
            if (cVar.f4282h == vVar) {
                cVar.f4289o |= z2;
                if (!cVar.f4290p) {
                    cVar.b();
                }
                this.f4246j.remove(size);
                return;
            }
        }
    }

    public void a(RecyclerView recyclerView) {
        RecyclerView recyclerView2 = this.f4247k;
        if (recyclerView2 != recyclerView) {
            if (recyclerView2 != null) {
                e();
            }
            this.f4247k = recyclerView;
            if (recyclerView != null) {
                Resources resources = recyclerView.getResources();
                this.f4254r = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_velocity);
                this.f4255s = resources.getDimension(R.dimen.item_touch_helper_swipe_escape_max_velocity);
                a();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void a(final c cVar, final int i2) {
        this.f4247k.post(new Runnable() {
            public void run() {
                if (k.this.f4247k != null && k.this.f4247k.isAttachedToWindow() && !cVar.f4289o && cVar.f4282h.getAbsoluteAdapterPosition() != -1) {
                    RecyclerView.e itemAnimator = k.this.f4247k.getItemAnimator();
                    if ((itemAnimator == null || !itemAnimator.a((RecyclerView.e.a) null)) && !k.this.b()) {
                        k.this.f4244h.a(cVar.f4282h, i2);
                    } else {
                        k.this.f4247k.post(this);
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public c b(MotionEvent motionEvent) {
        if (this.f4246j.isEmpty()) {
            return null;
        }
        View a2 = a(motionEvent);
        for (int size = this.f4246j.size() - 1; size >= 0; size--) {
            c cVar = this.f4246j.get(size);
            if (cVar.f4282h.itemView == a2) {
                return cVar;
            }
        }
        return null;
    }

    public void b(View view) {
        c(view);
        RecyclerView.v b2 = this.f4247k.b(view);
        if (b2 != null) {
            RecyclerView.v vVar = this.f4238b;
            if (vVar == null || b2 != vVar) {
                a(b2, false);
                if (this.f4237a.remove(b2.itemView)) {
                    this.f4244h.d(this.f4247k, b2);
                    return;
                }
                return;
            }
            a((RecyclerView.v) null, 0);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        int size = this.f4246j.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (!this.f4246j.get(i2).f4290p) {
                return true;
            }
        }
        return false;
    }

    /* access modifiers changed from: package-private */
    public void c(View view) {
        if (view == this.f4250n) {
            this.f4250n = null;
            if (this.f4262z != null) {
                this.f4247k.setChildDrawingOrderCallback((RecyclerView.c) null);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00c1, code lost:
        if (r1 > 0) goto L_0x00c5;
     */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0084  */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00c7  */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x00e1  */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x00fd  */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0100 A[ADDED_TO_REGION] */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x010c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean c() {
        /*
            r16 = this;
            r0 = r16
            androidx.recyclerview.widget.RecyclerView$v r1 = r0.f4238b
            r2 = 0
            r3 = -9223372036854775808
            if (r1 != 0) goto L_0x000c
            r0.D = r3
            return r2
        L_0x000c:
            long r5 = java.lang.System.currentTimeMillis()
            long r7 = r0.D
            int r1 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r1 != 0) goto L_0x0019
            r7 = 0
            goto L_0x001b
        L_0x0019:
            long r7 = r5 - r7
        L_0x001b:
            androidx.recyclerview.widget.RecyclerView r1 = r0.f4247k
            androidx.recyclerview.widget.RecyclerView$h r1 = r1.getLayoutManager()
            android.graphics.Rect r9 = r0.C
            if (r9 != 0) goto L_0x002c
            android.graphics.Rect r9 = new android.graphics.Rect
            r9.<init>()
            r0.C = r9
        L_0x002c:
            androidx.recyclerview.widget.RecyclerView$v r9 = r0.f4238b
            android.view.View r9 = r9.itemView
            android.graphics.Rect r10 = r0.C
            r1.b((android.view.View) r9, (android.graphics.Rect) r10)
            boolean r9 = r1.f()
            r10 = 0
            if (r9 == 0) goto L_0x007d
            float r9 = r0.f4256t
            float r11 = r0.f4241e
            float r9 = r9 + r11
            int r9 = (int) r9
            android.graphics.Rect r11 = r0.C
            int r11 = r11.left
            int r11 = r9 - r11
            androidx.recyclerview.widget.RecyclerView r12 = r0.f4247k
            int r12 = r12.getPaddingLeft()
            int r11 = r11 - r12
            float r12 = r0.f4241e
            int r13 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r13 >= 0) goto L_0x0059
            if (r11 >= 0) goto L_0x0059
            r12 = r11
            goto L_0x007e
        L_0x0059:
            int r11 = (r12 > r10 ? 1 : (r12 == r10 ? 0 : -1))
            if (r11 <= 0) goto L_0x007d
            androidx.recyclerview.widget.RecyclerView$v r11 = r0.f4238b
            android.view.View r11 = r11.itemView
            int r11 = r11.getWidth()
            int r9 = r9 + r11
            android.graphics.Rect r11 = r0.C
            int r11 = r11.right
            int r9 = r9 + r11
            androidx.recyclerview.widget.RecyclerView r11 = r0.f4247k
            int r11 = r11.getWidth()
            androidx.recyclerview.widget.RecyclerView r12 = r0.f4247k
            int r12 = r12.getPaddingRight()
            int r11 = r11 - r12
            int r9 = r9 - r11
            if (r9 <= 0) goto L_0x007d
            r12 = r9
            goto L_0x007e
        L_0x007d:
            r12 = 0
        L_0x007e:
            boolean r1 = r1.g()
            if (r1 == 0) goto L_0x00c4
            float r1 = r0.f4257u
            float r9 = r0.f4242f
            float r1 = r1 + r9
            int r1 = (int) r1
            android.graphics.Rect r9 = r0.C
            int r9 = r9.top
            int r9 = r1 - r9
            androidx.recyclerview.widget.RecyclerView r11 = r0.f4247k
            int r11 = r11.getPaddingTop()
            int r9 = r9 - r11
            float r11 = r0.f4242f
            int r13 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1))
            if (r13 >= 0) goto L_0x00a1
            if (r9 >= 0) goto L_0x00a1
            r1 = r9
            goto L_0x00c5
        L_0x00a1:
            int r9 = (r11 > r10 ? 1 : (r11 == r10 ? 0 : -1))
            if (r9 <= 0) goto L_0x00c4
            androidx.recyclerview.widget.RecyclerView$v r9 = r0.f4238b
            android.view.View r9 = r9.itemView
            int r9 = r9.getHeight()
            int r1 = r1 + r9
            android.graphics.Rect r9 = r0.C
            int r9 = r9.bottom
            int r1 = r1 + r9
            androidx.recyclerview.widget.RecyclerView r9 = r0.f4247k
            int r9 = r9.getHeight()
            androidx.recyclerview.widget.RecyclerView r10 = r0.f4247k
            int r10 = r10.getPaddingBottom()
            int r9 = r9 - r10
            int r1 = r1 - r9
            if (r1 <= 0) goto L_0x00c4
            goto L_0x00c5
        L_0x00c4:
            r1 = 0
        L_0x00c5:
            if (r12 == 0) goto L_0x00de
            androidx.recyclerview.widget.k$a r9 = r0.f4244h
            androidx.recyclerview.widget.RecyclerView r10 = r0.f4247k
            androidx.recyclerview.widget.RecyclerView$v r11 = r0.f4238b
            android.view.View r11 = r11.itemView
            int r11 = r11.getWidth()
            androidx.recyclerview.widget.RecyclerView r13 = r0.f4247k
            int r13 = r13.getWidth()
            r14 = r7
            int r12 = r9.a(r10, r11, r12, r13, r14)
        L_0x00de:
            r14 = r12
            if (r1 == 0) goto L_0x00fd
            androidx.recyclerview.widget.k$a r9 = r0.f4244h
            androidx.recyclerview.widget.RecyclerView r10 = r0.f4247k
            androidx.recyclerview.widget.RecyclerView$v r11 = r0.f4238b
            android.view.View r11 = r11.itemView
            int r11 = r11.getHeight()
            androidx.recyclerview.widget.RecyclerView r12 = r0.f4247k
            int r13 = r12.getHeight()
            r12 = r1
            r1 = r14
            r14 = r7
            int r7 = r9.a(r10, r11, r12, r13, r14)
            r12 = r1
            r1 = r7
            goto L_0x00fe
        L_0x00fd:
            r12 = r14
        L_0x00fe:
            if (r12 != 0) goto L_0x0106
            if (r1 == 0) goto L_0x0103
            goto L_0x0106
        L_0x0103:
            r0.D = r3
            return r2
        L_0x0106:
            long r7 = r0.D
            int r2 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r2 != 0) goto L_0x010e
            r0.D = r5
        L_0x010e:
            androidx.recyclerview.widget.RecyclerView r2 = r0.f4247k
            r2.scrollBy(r12, r1)
            r1 = 1
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.k.c():boolean");
    }

    /* access modifiers changed from: package-private */
    public void d() {
        VelocityTracker velocityTracker = this.f4249m;
        if (velocityTracker != null) {
            velocityTracker.recycle();
        }
        this.f4249m = VelocityTracker.obtain();
    }

    public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.s sVar) {
        rect.setEmpty();
    }

    public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        float f2;
        float f3;
        this.f4251o = -1;
        if (this.f4238b != null) {
            a(this.f4253q);
            float[] fArr = this.f4253q;
            float f4 = fArr[0];
            f2 = fArr[1];
            f3 = f4;
        } else {
            f3 = 0.0f;
            f2 = 0.0f;
        }
        this.f4244h.a(canvas, recyclerView, this.f4238b, this.f4246j, this.f4258v, f3, f2);
    }

    public void onDrawOver(Canvas canvas, RecyclerView recyclerView, RecyclerView.s sVar) {
        float f2;
        float f3;
        if (this.f4238b != null) {
            a(this.f4253q);
            float[] fArr = this.f4253q;
            float f4 = fArr[0];
            f2 = fArr[1];
            f3 = f4;
        } else {
            f3 = 0.0f;
            f2 = 0.0f;
        }
        this.f4244h.b(canvas, recyclerView, this.f4238b, this.f4246j, this.f4258v, f3, f2);
    }
}
