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
import com.bumptech.glide.R;
import com.bumptech.glide.request.e;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Deprecated
public abstract class k<T extends View, Z> extends a<Z> {

    /* renamed from: b  reason: collision with root package name */
    private static boolean f6145b;

    /* renamed from: c  reason: collision with root package name */
    private static int f6146c = R.id.glide_custom_view_target_tag;

    /* renamed from: a  reason: collision with root package name */
    protected final T f6147a;

    /* renamed from: d  reason: collision with root package name */
    private final a f6148d;

    /* renamed from: e  reason: collision with root package name */
    private View.OnAttachStateChangeListener f6149e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f6150f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f6151g;

    static final class a {

        /* renamed from: a  reason: collision with root package name */
        static Integer f6152a;

        /* renamed from: b  reason: collision with root package name */
        boolean f6153b;

        /* renamed from: c  reason: collision with root package name */
        private final View f6154c;

        /* renamed from: d  reason: collision with root package name */
        private final List<i> f6155d = new ArrayList();

        /* renamed from: e  reason: collision with root package name */
        private C0063a f6156e;

        /* renamed from: bz.k$a$a  reason: collision with other inner class name */
        private static final class C0063a implements ViewTreeObserver.OnPreDrawListener {

            /* renamed from: a  reason: collision with root package name */
            private final WeakReference<a> f6157a;

            C0063a(a aVar) {
                this.f6157a = new WeakReference<>(aVar);
            }

            public boolean onPreDraw() {
                if (Log.isLoggable("ViewTarget", 2)) {
                    Log.v("ViewTarget", "OnGlobalLayoutListener called attachStateListener=" + this);
                }
                a aVar = (a) this.f6157a.get();
                if (aVar == null) {
                    return true;
                }
                aVar.a();
                return true;
            }
        }

        a(View view) {
            this.f6154c = view;
        }

        private int a(int i2, int i3, int i4) {
            int i5 = i3 - i4;
            if (i5 > 0) {
                return i5;
            }
            if (this.f6153b && this.f6154c.isLayoutRequested()) {
                return 0;
            }
            int i6 = i2 - i4;
            if (i6 > 0) {
                return i6;
            }
            if (this.f6154c.isLayoutRequested() || i3 != -2) {
                return 0;
            }
            if (Log.isLoggable("ViewTarget", 4)) {
                Log.i("ViewTarget", "Glide treats LayoutParams.WRAP_CONTENT as a request for an image the size of this device's screen dimensions. If you want to load the original image and are ok with the corresponding memory cost and OOMs (depending on the input size), use override(Target.SIZE_ORIGINAL). Otherwise, use LayoutParams.MATCH_PARENT, set layout_width and layout_height to fixed dimension, or use .override() with fixed dimensions.");
            }
            return a(this.f6154c.getContext());
        }

        private static int a(Context context) {
            if (f6152a == null) {
                Display defaultDisplay = ((WindowManager) cc.k.a((WindowManager) context.getSystemService("window"))).getDefaultDisplay();
                Point point = new Point();
                defaultDisplay.getSize(point);
                f6152a = Integer.valueOf(Math.max(point.x, point.y));
            }
            return f6152a.intValue();
        }

        private void a(int i2, int i3) {
            Iterator it2 = new ArrayList(this.f6155d).iterator();
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
            int paddingTop = this.f6154c.getPaddingTop() + this.f6154c.getPaddingBottom();
            ViewGroup.LayoutParams layoutParams = this.f6154c.getLayoutParams();
            return a(this.f6154c.getHeight(), layoutParams != null ? layoutParams.height : 0, paddingTop);
        }

        private int d() {
            int paddingLeft = this.f6154c.getPaddingLeft() + this.f6154c.getPaddingRight();
            ViewGroup.LayoutParams layoutParams = this.f6154c.getLayoutParams();
            return a(this.f6154c.getWidth(), layoutParams != null ? layoutParams.width : 0, paddingLeft);
        }

        /* access modifiers changed from: package-private */
        public void a() {
            if (!this.f6155d.isEmpty()) {
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
            if (!this.f6155d.contains(iVar)) {
                this.f6155d.add(iVar);
            }
            if (this.f6156e == null) {
                ViewTreeObserver viewTreeObserver = this.f6154c.getViewTreeObserver();
                C0063a aVar = new C0063a(this);
                this.f6156e = aVar;
                viewTreeObserver.addOnPreDrawListener(aVar);
            }
        }

        /* access modifiers changed from: package-private */
        public void b() {
            ViewTreeObserver viewTreeObserver = this.f6154c.getViewTreeObserver();
            if (viewTreeObserver.isAlive()) {
                viewTreeObserver.removeOnPreDrawListener(this.f6156e);
            }
            this.f6156e = null;
            this.f6155d.clear();
        }

        /* access modifiers changed from: package-private */
        public void b(i iVar) {
            this.f6155d.remove(iVar);
        }
    }

    public k(T t2) {
        this.f6147a = (View) cc.k.a(t2);
        this.f6148d = new a(t2);
    }

    private void a(Object obj) {
        f6145b = true;
        this.f6147a.setTag(f6146c, obj);
    }

    private void b() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f6149e;
        if (onAttachStateChangeListener != null && !this.f6151g) {
            this.f6147a.addOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f6151g = true;
        }
    }

    private void c() {
        View.OnAttachStateChangeListener onAttachStateChangeListener = this.f6149e;
        if (onAttachStateChangeListener != null && this.f6151g) {
            this.f6147a.removeOnAttachStateChangeListener(onAttachStateChangeListener);
            this.f6151g = false;
        }
    }

    private Object d() {
        return this.f6147a.getTag(f6146c);
    }

    public e a() {
        Object d2 = d();
        if (d2 == null) {
            return null;
        }
        if (d2 instanceof e) {
            return (e) d2;
        }
        throw new IllegalArgumentException("You must not call setTag() on a view Glide is targeting");
    }

    public void a(Drawable drawable) {
        super.a(drawable);
        this.f6148d.b();
        if (!this.f6150f) {
            c();
        }
    }

    public void a(i iVar) {
        this.f6148d.a(iVar);
    }

    public void a(e eVar) {
        a((Object) eVar);
    }

    public void b(i iVar) {
        this.f6148d.b(iVar);
    }

    public void c(Drawable drawable) {
        super.c(drawable);
        b();
    }

    public String toString() {
        return "Target for: " + this.f6147a;
    }
}
