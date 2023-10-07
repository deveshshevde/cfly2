package x;

import android.graphics.Rect;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityManager;
import com.davemorrissey.labs.subscaleview.SubsamplingScaleImageView;
import com.xeagle.android.login.amba.connectivity.IChannelListener;
import j.h;
import java.util.ArrayList;
import java.util.List;
import t.ac;
import t.af;
import u.c;
import u.d;
import u.e;
import x.b;

public abstract class a extends t.a {

    /* renamed from: c  reason: collision with root package name */
    private static final Rect f34587c = new Rect(SubsamplingScaleImageView.TILE_SIZE_AUTO, SubsamplingScaleImageView.TILE_SIZE_AUTO, Integer.MIN_VALUE, Integer.MIN_VALUE);

    /* renamed from: l  reason: collision with root package name */
    private static final b.a<c> f34588l = new b.a<c>() {
        public void a(c cVar, Rect rect) {
            cVar.a(rect);
        }
    };

    /* renamed from: m  reason: collision with root package name */
    private static final b.C0264b<h<c>, c> f34589m = new b.C0264b<h<c>, c>() {
        public int a(h<c> hVar) {
            return hVar.b();
        }

        public c a(h<c> hVar, int i2) {
            return hVar.d(i2);
        }
    };

    /* renamed from: a  reason: collision with root package name */
    int f34590a = Integer.MIN_VALUE;

    /* renamed from: b  reason: collision with root package name */
    int f34591b = Integer.MIN_VALUE;

    /* renamed from: d  reason: collision with root package name */
    private final Rect f34592d = new Rect();

    /* renamed from: e  reason: collision with root package name */
    private final Rect f34593e = new Rect();

    /* renamed from: f  reason: collision with root package name */
    private final Rect f34594f = new Rect();

    /* renamed from: g  reason: collision with root package name */
    private final int[] f34595g = new int[2];

    /* renamed from: h  reason: collision with root package name */
    private final AccessibilityManager f34596h;

    /* renamed from: i  reason: collision with root package name */
    private final View f34597i;

    /* renamed from: j  reason: collision with root package name */
    private C0263a f34598j;

    /* renamed from: k  reason: collision with root package name */
    private int f34599k = Integer.MIN_VALUE;

    /* renamed from: x.a$a  reason: collision with other inner class name */
    private class C0263a extends d {
        C0263a() {
        }

        public c a(int i2) {
            return c.a(a.this.b(i2));
        }

        public boolean a(int i2, int i3, Bundle bundle) {
            return a.this.a(i2, i3, bundle);
        }

        public c b(int i2) {
            int i3 = i2 == 2 ? a.this.f34590a : a.this.f34591b;
            if (i3 == Integer.MIN_VALUE) {
                return null;
            }
            return a(i3);
        }
    }

    public a(View view) {
        if (view != null) {
            this.f34597i = view;
            this.f34596h = (AccessibilityManager) view.getContext().getSystemService("accessibility");
            view.setFocusable(true);
            if (ac.f(view) == 0) {
                ac.b(view, 1);
                return;
            }
            return;
        }
        throw new IllegalArgumentException("View may not be null");
    }

    private static Rect a(View view, int i2, Rect rect) {
        int width = view.getWidth();
        int height = view.getHeight();
        if (i2 == 17) {
            rect.set(width, 0, width, height);
        } else if (i2 == 33) {
            rect.set(0, height, width, height);
        } else if (i2 == 66) {
            rect.set(-1, 0, -1, height);
        } else if (i2 == 130) {
            rect.set(0, -1, width, -1);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        return rect;
    }

    private void a(int i2, Rect rect) {
        b(i2).a(rect);
    }

    private boolean a(int i2, Bundle bundle) {
        return ac.a(this.f34597i, i2, bundle);
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x001d  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x002f A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean a(android.graphics.Rect r4) {
        /*
            r3 = this;
            r0 = 0
            if (r4 == 0) goto L_0x0032
            boolean r4 = r4.isEmpty()
            if (r4 == 0) goto L_0x000a
            goto L_0x0032
        L_0x000a:
            android.view.View r4 = r3.f34597i
            int r4 = r4.getWindowVisibility()
            if (r4 == 0) goto L_0x0013
            return r0
        L_0x0013:
            android.view.View r4 = r3.f34597i
        L_0x0015:
            android.view.ViewParent r4 = r4.getParent()
            boolean r1 = r4 instanceof android.view.View
            if (r1 == 0) goto L_0x002f
            android.view.View r4 = (android.view.View) r4
            float r1 = r4.getAlpha()
            r2 = 0
            int r1 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r1 <= 0) goto L_0x002e
            int r1 = r4.getVisibility()
            if (r1 == 0) goto L_0x0015
        L_0x002e:
            return r0
        L_0x002f:
            if (r4 == 0) goto L_0x0032
            r0 = 1
        L_0x0032:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: x.a.a(android.graphics.Rect):boolean");
    }

    private boolean b(int i2, Rect rect) {
        Object obj;
        h<c> d2 = d();
        int i3 = this.f34591b;
        int i4 = Integer.MIN_VALUE;
        c a2 = i3 == Integer.MIN_VALUE ? null : d2.a(i3);
        if (i2 == 1 || i2 == 2) {
            obj = b.a(d2, f34589m, f34588l, a2, i2, ac.i(this.f34597i) == 1, false);
        } else if (i2 == 17 || i2 == 33 || i2 == 66 || i2 == 130) {
            Rect rect2 = new Rect();
            int i5 = this.f34591b;
            if (i5 != Integer.MIN_VALUE) {
                a(i5, rect2);
            } else if (rect != null) {
                rect2.set(rect);
            } else {
                a(this.f34597i, i2, rect2);
            }
            obj = b.a(d2, f34589m, f34588l, a2, rect2, i2);
        } else {
            throw new IllegalArgumentException("direction must be one of {FOCUS_FORWARD, FOCUS_BACKWARD, FOCUS_UP, FOCUS_DOWN, FOCUS_LEFT, FOCUS_RIGHT}.");
        }
        c cVar = (c) obj;
        if (cVar != null) {
            i4 = d2.c(d2.a(cVar));
        }
        return c(i4);
    }

    private AccessibilityEvent c(int i2, int i3) {
        return i2 != -1 ? d(i2, i3) : g(i3);
    }

    private boolean c(int i2, int i3, Bundle bundle) {
        return i3 != 1 ? i3 != 2 ? i3 != 64 ? i3 != 128 ? b(i2, i3, bundle) : j(i2) : i(i2) : d(i2) : c(i2);
    }

    private AccessibilityEvent d(int i2, int i3) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i3);
        c b2 = b(i2);
        obtain.getText().add(b2.t());
        obtain.setContentDescription(b2.u());
        obtain.setScrollable(b2.q());
        obtain.setPassword(b2.p());
        obtain.setEnabled(b2.o());
        obtain.setChecked(b2.g());
        a(i2, obtain);
        if (!obtain.getText().isEmpty() || obtain.getContentDescription() != null) {
            obtain.setClassName(b2.s());
            e.a(obtain, this.f34597i, i2);
            obtain.setPackageName(this.f34597i.getContext().getPackageName());
            return obtain;
        }
        throw new RuntimeException("Callbacks must add text or a content description in populateEventForVirtualViewId()");
    }

    private h<c> d() {
        ArrayList arrayList = new ArrayList();
        a((List<Integer>) arrayList);
        h<c> hVar = new h<>();
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            hVar.b(i2, h(i2));
        }
        return hVar;
    }

    private static int e(int i2) {
        if (i2 == 19) {
            return 33;
        }
        if (i2 == 21) {
            return 17;
        }
        if (i2 != 22) {
            return IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR;
        }
        return 66;
    }

    private boolean e() {
        int i2 = this.f34591b;
        return i2 != Integer.MIN_VALUE && b(i2, 16, (Bundle) null);
    }

    private c f() {
        c a2 = c.a(this.f34597i);
        ac.a(this.f34597i, a2);
        ArrayList arrayList = new ArrayList();
        a((List<Integer>) arrayList);
        if (a2.c() <= 0 || arrayList.size() <= 0) {
            int size = arrayList.size();
            for (int i2 = 0; i2 < size; i2++) {
                a2.b(this.f34597i, ((Integer) arrayList.get(i2)).intValue());
            }
            return a2;
        }
        throw new RuntimeException("Views cannot have both real and virtual children");
    }

    private void f(int i2) {
        int i3 = this.f34599k;
        if (i3 != i2) {
            this.f34599k = i2;
            a(i2, 128);
            a(i3, 256);
        }
    }

    private AccessibilityEvent g(int i2) {
        AccessibilityEvent obtain = AccessibilityEvent.obtain(i2);
        this.f34597i.onInitializeAccessibilityEvent(obtain);
        return obtain;
    }

    private c h(int i2) {
        c b2 = c.b();
        b2.j(true);
        b2.c(true);
        b2.b((CharSequence) "android.view.View");
        Rect rect = f34587c;
        b2.b(rect);
        b2.d(rect);
        b2.d(this.f34597i);
        a(i2, b2);
        if (b2.t() == null && b2.u() == null) {
            throw new RuntimeException("Callbacks must add text or a content description in populateNodeForVirtualViewId()");
        }
        b2.a(this.f34593e);
        if (!this.f34593e.equals(rect)) {
            int d2 = b2.d();
            if ((d2 & 64) != 0) {
                throw new RuntimeException("Callbacks must not add ACTION_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            } else if ((d2 & 128) == 0) {
                b2.a((CharSequence) this.f34597i.getContext().getPackageName());
                b2.a(this.f34597i, i2);
                if (this.f34590a == i2) {
                    b2.f(true);
                    b2.a(128);
                } else {
                    b2.f(false);
                    b2.a(64);
                }
                boolean z2 = this.f34591b == i2;
                if (z2) {
                    b2.a(2);
                } else if (b2.h()) {
                    b2.a(1);
                }
                b2.d(z2);
                this.f34597i.getLocationOnScreen(this.f34595g);
                b2.c(this.f34592d);
                if (this.f34592d.equals(rect)) {
                    b2.a(this.f34592d);
                    if (b2.f34528a != -1) {
                        c b3 = c.b();
                        for (int i3 = b2.f34528a; i3 != -1; i3 = b3.f34528a) {
                            b3.c(this.f34597i, -1);
                            b3.b(f34587c);
                            a(i3, b3);
                            b3.a(this.f34593e);
                            this.f34592d.offset(this.f34593e.left, this.f34593e.top);
                        }
                        b3.v();
                    }
                    this.f34592d.offset(this.f34595g[0] - this.f34597i.getScrollX(), this.f34595g[1] - this.f34597i.getScrollY());
                }
                if (this.f34597i.getLocalVisibleRect(this.f34594f)) {
                    this.f34594f.offset(this.f34595g[0] - this.f34597i.getScrollX(), this.f34595g[1] - this.f34597i.getScrollY());
                    if (this.f34592d.intersect(this.f34594f)) {
                        b2.d(this.f34592d);
                        if (a(this.f34592d)) {
                            b2.e(true);
                        }
                    }
                }
                return b2;
            } else {
                throw new RuntimeException("Callbacks must not add ACTION_CLEAR_ACCESSIBILITY_FOCUS in populateNodeForVirtualViewId()");
            }
        } else {
            throw new RuntimeException("Callbacks must set parent bounds in populateNodeForVirtualViewId()");
        }
    }

    private boolean i(int i2) {
        int i3;
        if (!this.f34596h.isEnabled() || !this.f34596h.isTouchExplorationEnabled() || (i3 = this.f34590a) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            j(i3);
        }
        this.f34590a = i2;
        this.f34597i.invalidate();
        a(i2, 32768);
        return true;
    }

    private boolean j(int i2) {
        if (this.f34590a != i2) {
            return false;
        }
        this.f34590a = Integer.MIN_VALUE;
        this.f34597i.invalidate();
        a(i2, 65536);
        return true;
    }

    /* access modifiers changed from: protected */
    public abstract int a(float f2, float f3);

    public d a(View view) {
        if (this.f34598j == null) {
            this.f34598j = new C0263a();
        }
        return this.f34598j;
    }

    public final void a(int i2) {
        b(i2, 0);
    }

    /* access modifiers changed from: protected */
    public void a(int i2, AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public abstract void a(int i2, c cVar);

    /* access modifiers changed from: protected */
    public void a(int i2, boolean z2) {
    }

    public void a(View view, c cVar) {
        super.a(view, cVar);
        a(cVar);
    }

    /* access modifiers changed from: protected */
    public void a(AccessibilityEvent accessibilityEvent) {
    }

    /* access modifiers changed from: protected */
    public abstract void a(List<Integer> list);

    /* access modifiers changed from: protected */
    public void a(c cVar) {
    }

    public final void a(boolean z2, int i2, Rect rect) {
        int i3 = this.f34591b;
        if (i3 != Integer.MIN_VALUE) {
            d(i3);
        }
        if (z2) {
            b(i2, rect);
        }
    }

    public final boolean a(int i2, int i3) {
        ViewParent parent;
        if (i2 == Integer.MIN_VALUE || !this.f34596h.isEnabled() || (parent = this.f34597i.getParent()) == null) {
            return false;
        }
        return af.a(parent, this.f34597i, c(i2, i3));
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2, int i3, Bundle bundle) {
        return i2 != -1 ? c(i2, i3, bundle) : a(i3, bundle);
    }

    public final boolean a(KeyEvent keyEvent) {
        int i2 = 0;
        if (keyEvent.getAction() == 1) {
            return false;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyCode != 61) {
            if (keyCode != 66) {
                switch (keyCode) {
                    case 19:
                    case 20:
                    case 21:
                    case 22:
                        if (!keyEvent.hasNoModifiers()) {
                            return false;
                        }
                        int e2 = e(keyCode);
                        int repeatCount = keyEvent.getRepeatCount() + 1;
                        boolean z2 = false;
                        while (i2 < repeatCount && b(e2, (Rect) null)) {
                            i2++;
                            z2 = true;
                        }
                        return z2;
                    case 23:
                        break;
                    default:
                        return false;
                }
            }
            if (!keyEvent.hasNoModifiers() || keyEvent.getRepeatCount() != 0) {
                return false;
            }
            e();
            return true;
        } else if (keyEvent.hasNoModifiers()) {
            return b(2, (Rect) null);
        } else {
            if (keyEvent.hasModifiers(1)) {
                return b(1, (Rect) null);
            }
            return false;
        }
    }

    public final boolean a(MotionEvent motionEvent) {
        if (!this.f34596h.isEnabled() || !this.f34596h.isTouchExplorationEnabled()) {
            return false;
        }
        int action = motionEvent.getAction();
        if (action == 7 || action == 9) {
            int a2 = a(motionEvent.getX(), motionEvent.getY());
            f(a2);
            return a2 != Integer.MIN_VALUE;
        } else if (action != 10 || this.f34599k == Integer.MIN_VALUE) {
            return false;
        } else {
            f(Integer.MIN_VALUE);
            return true;
        }
    }

    public final int b() {
        return this.f34590a;
    }

    /* access modifiers changed from: package-private */
    public c b(int i2) {
        return i2 == -1 ? f() : h(i2);
    }

    public final void b(int i2, int i3) {
        ViewParent parent;
        if (i2 != Integer.MIN_VALUE && this.f34596h.isEnabled() && (parent = this.f34597i.getParent()) != null) {
            AccessibilityEvent c2 = c(i2, 2048);
            u.b.a(c2, i3);
            af.a(parent, this.f34597i, c2);
        }
    }

    /* access modifiers changed from: protected */
    public abstract boolean b(int i2, int i3, Bundle bundle);

    public final int c() {
        return this.f34591b;
    }

    public final boolean c(int i2) {
        int i3;
        if ((!this.f34597i.isFocused() && !this.f34597i.requestFocus()) || (i3 = this.f34591b) == i2) {
            return false;
        }
        if (i3 != Integer.MIN_VALUE) {
            d(i3);
        }
        this.f34591b = i2;
        a(i2, true);
        a(i2, 8);
        return true;
    }

    public void d(View view, AccessibilityEvent accessibilityEvent) {
        super.d(view, accessibilityEvent);
        a(accessibilityEvent);
    }

    public final boolean d(int i2) {
        if (this.f34591b != i2) {
            return false;
        }
        this.f34591b = Integer.MIN_VALUE;
        a(i2, false);
        a(i2, 8);
        return true;
    }
}
