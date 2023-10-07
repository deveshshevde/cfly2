package bz;

import android.content.Context;
import android.graphics.Point;
import android.graphics.drawable.Drawable;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import cc.k;
import com.bumptech.glide.R;
import com.bumptech.glide.request.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public abstract class d<T extends View, Z> implements j<Z> {

    /* renamed from: b  reason: collision with root package name */
    private static final int f6130b = R.id.glide_custom_view_target_tag;

    /* renamed from: a  reason: collision with root package name */
    protected final T f6131a;

    /* renamed from: c  reason: collision with root package name */
    private final a f6132c;

    /* renamed from: d  reason: collision with root package name */
    private View.OnAttachStateChangeListener f6133d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f6134e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6135f;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        static Integer f6136a;

        /* renamed from: b  reason: collision with root package name */
        boolean f6137b;

        /* renamed from: c  reason: collision with root package name */
        private final View f6138c;

        /* renamed from: d  reason: collision with root package name */
        private final List<i> f6139d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        private C0062a f6140e;

        /* renamed from: bz.d$a$a  reason: collision with other inner class name */
        private static final class C0062a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<a> f6141a;

            C0062a(a aVar) {
                this.f6141a = new WeakReference<>(aVar);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable("CustomViewTarget", 2)) {
                    Log.v("CustomViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = (a) this.f6141a.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        a(View view) {
            this.f6138c = view;
        }

        private int a(int i2, int i3, int i4) {
            int i5 = i3 - i4;
            if (i5 > 0) {
                return i5;
            }
            if (this.f6137b && this.f6138c.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.f6138c.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            if (Log.isLoggable("CustomViewTarget", 4)) {
                Log.i("CustomViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use .override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return a(this.f6138c.getContext());
        }

        private static int a(Context context) {
            if (f6136a == null) {
                Display defaultDisplay = ((WindowManager) k.a((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f6136a = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f6136a.intValue();
        }

        private void a(int i2, int i3) {
            Iterator it2 = new ArrayList(this.f6139d).iterator();
            while (it2.hasNext()) {
                ((i) it2.next()).a(i2, i3);
            }
        }

        private boolean a(int i2) {
            return i2 > 0 || i2 == Integer.MIN_VALUE;
        }

        private boolean b(int i2, int i3) {
            return a(i2) && a(i3);
        }

        private int c() {
            int paddingTop = this.f6138c.getPaddingTop() + this.f6138c.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f6138c.getLayoutParams();
            return a(this.f6138c.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int d() {
            int paddingLeft = this.f6138c.getPaddingLeft() + this.f6138c.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f6138c.getLayoutParams();
            return a(this.f6138c.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (!this.f6139d.isEmpty()) {
                int d2 = d();
                int c2 = c();
                if (b(d2, c2)) {
                    a(d2, c2);
                    b();
                }
            }
        }

        /* access modifiers changed from: package-private */
        public void a(i iVar) {
            int d2 = d();
            int c2 = c();
            if (b(d2, c2)) {
                iVar.a(d2, c2);
                return;
            }
            if (!this.f6139d.contains(iVar)) {
                this.f6139d.add(iVar);
            }
            if (this.f6140e == null) {
                ViewTreeObserver viewTreeObserver = this.f6138c.getViewTreeObserver();
                C0062a aVar = new C0062a(this);
                this.f6140e = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            ViewTreeObserver viewTreeObserver = this.f6138c.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f6140e);
            }
            this.f6140e = null;
            this.f6139d.clear();
        }

        /* access modifiers changed from: package-private */
        public void b(i iVar) {
            this.f6139d.remove(iVar);
        }
    }

    public d(T t2) {
        this.f6131a = (View) k.a(t2);
        this.f6132c = new a(t2);
    }

    private void a(Object obj) {
        this.f6131a.setTag(f6130b, obj);
    }

    private Object b() {
        return this.f6131a.getTag(f6130b);
    }

    private void c() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f6133d;
        if (onAttachStateChangeListener != null && !this.f6135f) {
            this.f6131a.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f6135f = true;
        }
    }

    private void d() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f6133d;
        if (onAttachStateChangeListener != null && this.f6135f) {
            this.f6131a.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f6135f = false;
        }
    }

    public final e a() {
        Object b2 = b();
        if (b2 == null) {
            return null;
        }
        if (b2 instanceof e) {
            return (e) b2;
        }
        throw new IllegalArgumentException("You must not pass non-R.id ids to setTag(id)");
    }

    public final void a(Drawable drawable) {
        this.f6132c.b();
        a_(drawable);
        if (!this.f6134e) {
            d();
        }
    }

    public final void a(i iVar) {
        this.f6132c.a(iVar);
    }

    public final void a(e eVar) {
        a((Object) eVar);
    }

    /* access modifiers changed from: protected */
    public abstract void a_(Drawable drawable);

    public final void b(i iVar) {
        this.f6132c.b(iVar);
    }

    public final void c(Drawable drawable) {
        c();
        d(drawable);
    }

    /* access modifiers changed from: protected */
    public void d(Drawable drawable) {
    }

    public void e() {
    }

    public void f() {
    }

    public void g() {
    }

    public String toString() {
        return "Target for: " + this.f6131a;
    }
}
