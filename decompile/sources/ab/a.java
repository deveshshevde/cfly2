package ab;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.drawerlayout.widget.DrawerLayout;
import java.lang.reflect.Method;
import t.ac;

@Deprecated
public class a implements DrawerLayout.c {

    /* renamed from: b  reason: collision with root package name */
    private static final int[] f9b = {16843531};

    /* renamed from: a  reason: collision with root package name */
    final Activity f10a;

    /* renamed from: c  reason: collision with root package name */
    private final C0000a f11c;

    /* renamed from: d  reason: collision with root package name */
    private final DrawerLayout f12d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f13e;

    /* renamed from: f  reason: collision with root package name */
    private boolean f14f;

    /* renamed from: g  reason: collision with root package name */
    private Drawable f15g;

    /* renamed from: h  reason: collision with root package name */
    private Drawable f16h;

    /* renamed from: i  reason: collision with root package name */
    private d f17i;

    /* renamed from: j  reason: collision with root package name */
    private final int f18j;

    /* renamed from: k  reason: collision with root package name */
    private final int f19k;

    /* renamed from: l  reason: collision with root package name */
    private final int f20l;

    /* renamed from: m  reason: collision with root package name */
    private c f21m;

    @Deprecated
    /* renamed from: ab.a$a  reason: collision with other inner class name */
    public interface C0000a {
        Drawable a();

        void a(int i2);

        void a(Drawable drawable, int i2);
    }

    @Deprecated
    public interface b {
        C0000a a();
    }

    private static class c {

        /* renamed from: a  reason: collision with root package name */
        Method f22a;

        /* renamed from: b  reason: collision with root package name */
        Method f23b;

        /* renamed from: c  reason: collision with root package name */
        ImageView f24c;

        c(Activity activity) {
            try {
                this.f22a = ActionBar.class.getDeclaredMethod("setHomeAsUpIndicator", new Class[]{Drawable.class});
                this.f23b = ActionBar.class.getDeclaredMethod("setHomeActionContentDescription", new Class[]{Integer.TYPE});
            } catch (NoSuchMethodException unused) {
                View findViewById = activity.findViewById(16908332);
                if (findViewById != null) {
                    ViewGroup viewGroup = (ViewGroup) findViewById.getParent();
                    if (viewGroup.getChildCount() == 2) {
                        View childAt = viewGroup.getChildAt(0);
                        childAt = childAt.getId() == 16908332 ? viewGroup.getChildAt(1) : childAt;
                        if (childAt instanceof ImageView) {
                            this.f24c = (ImageView) childAt;
                        }
                    }
                }
            }
        }
    }

    private class d extends InsetDrawable implements Drawable.Callback {

        /* renamed from: b  reason: collision with root package name */
        private final boolean f26b;

        /* renamed from: c  reason: collision with root package name */
        private final Rect f27c;

        /* renamed from: d  reason: collision with root package name */
        private float f28d;

        /* renamed from: e  reason: collision with root package name */
        private float f29e;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        d(Drawable drawable) {
            super(drawable, 0);
            boolean z2 = false;
            this.f26b = Build.VERSION.SDK_INT > 18 ? true : z2;
            this.f27c = new Rect();
        }

        public float a() {
            return this.f28d;
        }

        public void a(float f2) {
            this.f28d = f2;
            invalidateSelf();
        }

        public void b(float f2) {
            this.f29e = f2;
            invalidateSelf();
        }

        public void draw(Canvas canvas) {
            copyBounds(this.f27c);
            canvas.save();
            int i2 = 1;
            boolean z2 = ac.i(a.this.f10a.getWindow().getDecorView()) == 1;
            if (z2) {
                i2 = -1;
            }
            float width = (float) this.f27c.width();
            canvas.translate((-this.f29e) * width * this.f28d * ((float) i2), 0.0f);
            if (z2 && !this.f26b) {
                canvas.translate(width, 0.0f);
                canvas.scale(-1.0f, 1.0f);
            }
            super.draw(canvas);
            canvas.restore();
        }
    }

    public a(Activity activity, DrawerLayout drawerLayout, int i2, int i3, int i4) {
        this(activity, drawerLayout, !a((Context) activity), i2, i3, i4);
    }

    public a(Activity activity, DrawerLayout drawerLayout, boolean z2, int i2, int i3, int i4) {
        this.f13e = true;
        this.f10a = activity;
        this.f11c = activity instanceof b ? ((b) activity).a() : null;
        this.f12d = drawerLayout;
        this.f18j = i2;
        this.f19k = i3;
        this.f20l = i4;
        this.f15g = b();
        this.f16h = androidx.core.content.b.a((Context) activity, i2);
        d dVar = new d(this.f16h);
        this.f17i = dVar;
        dVar.b(z2 ? 0.33333334f : 0.0f);
    }

    private void a(Drawable drawable, int i2) {
        C0000a aVar = this.f11c;
        if (aVar != null) {
            aVar.a(drawable, i2);
        } else if (Build.VERSION.SDK_INT >= 18) {
            ActionBar actionBar = this.f10a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeAsUpIndicator(drawable);
                actionBar.setHomeActionContentDescription(i2);
            }
        } else {
            if (this.f21m == null) {
                this.f21m = new c(this.f10a);
            }
            if (this.f21m.f22a != null) {
                try {
                    ActionBar actionBar2 = this.f10a.getActionBar();
                    this.f21m.f22a.invoke(actionBar2, new Object[]{drawable});
                    this.f21m.f23b.invoke(actionBar2, new Object[]{Integer.valueOf(i2)});
                } catch (Exception e2) {
                    Log.w("ActionBarDrawerToggle", "Couldn't set home-as-up indicator via JB-MR2 API", e2);
                }
            } else if (this.f21m.f24c != null) {
                this.f21m.f24c.setImageDrawable(drawable);
            } else {
                Log.w("ActionBarDrawerToggle", "Couldn't set home-as-up indicator");
            }
        }
    }

    private static boolean a(Context context) {
        return context.getApplicationInfo().targetSdkVersion >= 21 && Build.VERSION.SDK_INT >= 21;
    }

    private Drawable b() {
        TypedArray obtainStyledAttributes;
        C0000a aVar = this.f11c;
        if (aVar != null) {
            return aVar.a();
        }
        if (Build.VERSION.SDK_INT >= 18) {
            ActionBar actionBar = this.f10a.getActionBar();
            obtainStyledAttributes = (actionBar != null ? actionBar.getThemedContext() : this.f10a).obtainStyledAttributes((AttributeSet) null, f9b, 16843470, 0);
        } else {
            obtainStyledAttributes = this.f10a.obtainStyledAttributes(f9b);
        }
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        obtainStyledAttributes.recycle();
        return drawable;
    }

    private void b(int i2) {
        C0000a aVar = this.f11c;
        if (aVar != null) {
            aVar.a(i2);
        } else if (Build.VERSION.SDK_INT >= 18) {
            ActionBar actionBar = this.f10a.getActionBar();
            if (actionBar != null) {
                actionBar.setHomeActionContentDescription(i2);
            }
        } else {
            if (this.f21m == null) {
                this.f21m = new c(this.f10a);
            }
            if (this.f21m.f22a != null) {
                try {
                    ActionBar actionBar2 = this.f10a.getActionBar();
                    this.f21m.f23b.invoke(actionBar2, new Object[]{Integer.valueOf(i2)});
                    actionBar2.setSubtitle(actionBar2.getSubtitle());
                } catch (Exception e2) {
                    Log.w("ActionBarDrawerToggle", "Couldn't set content description via JB-MR2 API", e2);
                }
            }
        }
    }

    public void a() {
        float f2;
        d dVar;
        if (this.f12d.g(8388611)) {
            dVar = this.f17i;
            f2 = 1.0f;
        } else {
            dVar = this.f17i;
            f2 = 0.0f;
        }
        dVar.a(f2);
        if (this.f13e) {
            a((Drawable) this.f17i, this.f12d.g(8388611) ? this.f20l : this.f19k);
        }
    }

    public void a(int i2) {
    }

    public void a(Configuration configuration) {
        if (!this.f14f) {
            this.f15g = b();
        }
        this.f16h = androidx.core.content.b.a((Context) this.f10a, this.f18j);
        a();
    }

    public void a(View view) {
        this.f17i.a(1.0f);
        if (this.f13e) {
            b(this.f20l);
        }
    }

    public void a(View view, float f2) {
        float a2 = this.f17i.a();
        this.f17i.a(f2 > 0.5f ? Math.max(a2, Math.max(0.0f, f2 - 0.5f) * 2.0f) : Math.min(a2, f2 * 2.0f));
    }

    public boolean a(MenuItem menuItem) {
        if (menuItem == null || menuItem.getItemId() != 16908332 || !this.f13e) {
            return false;
        }
        if (this.f12d.h(8388611)) {
            this.f12d.f(8388611);
            return true;
        }
        this.f12d.e(8388611);
        return true;
    }

    public void b(View view) {
        this.f17i.a(0.0f);
        if (this.f13e) {
            b(this.f19k);
        }
    }
}
