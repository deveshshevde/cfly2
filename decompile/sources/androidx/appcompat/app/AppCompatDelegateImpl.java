package androidx.appcompat.app;

import android.app.Activity;
import android.app.Dialog;
import android.app.UiModeManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.os.LocaleList;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.PowerManager;
import android.text.TextUtils;
import android.util.AndroidRuntimeException;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.ActionMode;
import android.view.ContextThemeWrapper;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.KeyboardShortcutGroup;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import androidx.appcompat.R;
import androidx.appcompat.app.a;
import androidx.appcompat.view.menu.g;
import androidx.appcompat.view.menu.m;
import androidx.appcompat.widget.ActionBarContextView;
import androidx.appcompat.widget.ContentFrameLayout;
import androidx.appcompat.widget.Toolbar;
import androidx.appcompat.widget.af;
import androidx.appcompat.widget.al;
import androidx.appcompat.widget.o;
import androidx.appcompat.widget.s;
import androidx.lifecycle.Lifecycle;
import f.b;
import f.f;
import java.lang.Thread;
import java.util.List;
import l.f;
import org.xmlpull.v1.XmlPullParser;
import t.ac;
import t.ag;
import t.ah;
import t.ai;
import t.ak;
import t.g;
import t.u;

class AppCompatDelegateImpl extends d implements LayoutInflater.Factory2, g.a {

    /* renamed from: u  reason: collision with root package name */
    private static final j.g<String, Integer> f573u = new j.g<>();

    /* renamed from: v  reason: collision with root package name */
    private static final boolean f574v;

    /* renamed from: w  reason: collision with root package name */
    private static final int[] f575w = {16842836};

    /* renamed from: x  reason: collision with root package name */
    private static final boolean f576x = (!"robolectric".equals(Build.FINGERPRINT));

    /* renamed from: y  reason: collision with root package name */
    private static final boolean f577y;

    /* renamed from: z  reason: collision with root package name */
    private static boolean f578z = true;
    private h A;
    private CharSequence B;
    private o C;
    private b D;
    private n E;
    private boolean F;
    private boolean G;
    private TextView H;
    private View I;
    private boolean J;
    private boolean K;
    private boolean L;
    private PanelFeatureState[] M;
    private PanelFeatureState N;
    private boolean O;
    private boolean P;
    private boolean Q;
    private boolean R;
    private int S;
    private int T;
    private boolean U;
    private boolean V;
    private j W;
    private j X;
    private final Runnable Y;
    private boolean Z;

    /* renamed from: a  reason: collision with root package name */
    final Object f579a;

    /* renamed from: aa  reason: collision with root package name */
    private Rect f580aa;

    /* renamed from: ab  reason: collision with root package name */
    private Rect f581ab;

    /* renamed from: ac  reason: collision with root package name */
    private g f582ac;

    /* renamed from: ad  reason: collision with root package name */
    private h f583ad;

    /* renamed from: b  reason: collision with root package name */
    final Context f584b;

    /* renamed from: c  reason: collision with root package name */
    Window f585c;

    /* renamed from: d  reason: collision with root package name */
    final c f586d;

    /* renamed from: e  reason: collision with root package name */
    ActionBar f587e;

    /* renamed from: f  reason: collision with root package name */
    MenuInflater f588f;

    /* renamed from: g  reason: collision with root package name */
    f.b f589g;

    /* renamed from: h  reason: collision with root package name */
    ActionBarContextView f590h;

    /* renamed from: i  reason: collision with root package name */
    PopupWindow f591i;

    /* renamed from: j  reason: collision with root package name */
    Runnable f592j;

    /* renamed from: k  reason: collision with root package name */
    ag f593k;

    /* renamed from: l  reason: collision with root package name */
    ViewGroup f594l;

    /* renamed from: m  reason: collision with root package name */
    boolean f595m;

    /* renamed from: n  reason: collision with root package name */
    boolean f596n;

    /* renamed from: o  reason: collision with root package name */
    boolean f597o;

    /* renamed from: p  reason: collision with root package name */
    boolean f598p;

    /* renamed from: q  reason: collision with root package name */
    boolean f599q;

    /* renamed from: r  reason: collision with root package name */
    boolean f600r;

    /* renamed from: s  reason: collision with root package name */
    boolean f601s;

    /* renamed from: t  reason: collision with root package name */
    int f602t;

    protected static final class PanelFeatureState {

        /* renamed from: a  reason: collision with root package name */
        int f611a;

        /* renamed from: b  reason: collision with root package name */
        int f612b;

        /* renamed from: c  reason: collision with root package name */
        int f613c;

        /* renamed from: d  reason: collision with root package name */
        int f614d;

        /* renamed from: e  reason: collision with root package name */
        int f615e;

        /* renamed from: f  reason: collision with root package name */
        int f616f;

        /* renamed from: g  reason: collision with root package name */
        ViewGroup f617g;

        /* renamed from: h  reason: collision with root package name */
        View f618h;

        /* renamed from: i  reason: collision with root package name */
        View f619i;

        /* renamed from: j  reason: collision with root package name */
        androidx.appcompat.view.menu.g f620j;

        /* renamed from: k  reason: collision with root package name */
        androidx.appcompat.view.menu.e f621k;

        /* renamed from: l  reason: collision with root package name */
        Context f622l;

        /* renamed from: m  reason: collision with root package name */
        boolean f623m;

        /* renamed from: n  reason: collision with root package name */
        boolean f624n;

        /* renamed from: o  reason: collision with root package name */
        boolean f625o;

        /* renamed from: p  reason: collision with root package name */
        public boolean f626p;

        /* renamed from: q  reason: collision with root package name */
        boolean f627q = false;

        /* renamed from: r  reason: collision with root package name */
        boolean f628r;

        /* renamed from: s  reason: collision with root package name */
        Bundle f629s;

        private static class SavedState implements Parcelable {
            public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel) {
                    return SavedState.a(parcel, (ClassLoader) null);
                }

                /* renamed from: a */
                public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                    return SavedState.a(parcel, classLoader);
                }

                /* renamed from: a */
                public SavedState[] newArray(int i2) {
                    return new SavedState[i2];
                }
            };

            /* renamed from: a  reason: collision with root package name */
            int f630a;

            /* renamed from: b  reason: collision with root package name */
            boolean f631b;

            /* renamed from: c  reason: collision with root package name */
            Bundle f632c;

            SavedState() {
            }

            static SavedState a(Parcel parcel, ClassLoader classLoader) {
                SavedState savedState = new SavedState();
                savedState.f630a = parcel.readInt();
                boolean z2 = true;
                if (parcel.readInt() != 1) {
                    z2 = false;
                }
                savedState.f631b = z2;
                if (z2) {
                    savedState.f632c = parcel.readBundle(classLoader);
                }
                return savedState;
            }

            public int describeContents() {
                return 0;
            }

            public void writeToParcel(Parcel parcel, int i2) {
                parcel.writeInt(this.f630a);
                parcel.writeInt(this.f631b ? 1 : 0);
                if (this.f631b) {
                    parcel.writeBundle(this.f632c);
                }
            }
        }

        PanelFeatureState(int i2) {
            this.f611a = i2;
        }

        /* access modifiers changed from: package-private */
        public androidx.appcompat.view.menu.n a(m.a aVar) {
            if (this.f620j == null) {
                return null;
            }
            if (this.f621k == null) {
                androidx.appcompat.view.menu.e eVar = new androidx.appcompat.view.menu.e(this.f622l, R.layout.abc_list_menu_item_layout);
                this.f621k = eVar;
                eVar.a(aVar);
                this.f620j.a((androidx.appcompat.view.menu.m) this.f621k);
            }
            return this.f621k.a(this.f617g);
        }

        /* access modifiers changed from: package-private */
        public void a(Context context) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme newTheme = context.getResources().newTheme();
            newTheme.setTo(context.getTheme());
            newTheme.resolveAttribute(R.attr.actionBarPopupTheme, typedValue, true);
            if (typedValue.resourceId != 0) {
                newTheme.applyStyle(typedValue.resourceId, true);
            }
            newTheme.resolveAttribute(R.attr.panelMenuListTheme, typedValue, true);
            newTheme.applyStyle(typedValue.resourceId != 0 ? typedValue.resourceId : R.style.Theme_AppCompat_CompactMenu, true);
            f.d dVar = new f.d(context, 0);
            dVar.getTheme().setTo(newTheme);
            this.f622l = dVar;
            TypedArray obtainStyledAttributes = dVar.obtainStyledAttributes(R.styleable.AppCompatTheme);
            this.f612b = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_panelBackground, 0);
            this.f616f = obtainStyledAttributes.getResourceId(R.styleable.AppCompatTheme_android_windowAnimationStyle, 0);
            obtainStyledAttributes.recycle();
        }

        /* access modifiers changed from: package-private */
        public void a(androidx.appcompat.view.menu.g gVar) {
            androidx.appcompat.view.menu.e eVar;
            androidx.appcompat.view.menu.g gVar2 = this.f620j;
            if (gVar != gVar2) {
                if (gVar2 != null) {
                    gVar2.b((androidx.appcompat.view.menu.m) this.f621k);
                }
                this.f620j = gVar;
                if (gVar != null && (eVar = this.f621k) != null) {
                    gVar.a((androidx.appcompat.view.menu.m) eVar);
                }
            }
        }

        public boolean a() {
            if (this.f618h == null) {
                return false;
            }
            return this.f619i != null || this.f621k.a().getCount() > 0;
        }
    }

    private class a implements a.C0017a {
        a() {
        }

        public void a(int i2) {
            ActionBar a2 = AppCompatDelegateImpl.this.a();
            if (a2 != null) {
                a2.a(i2);
            }
        }
    }

    private final class b implements m.a {
        b() {
        }

        public void a(androidx.appcompat.view.menu.g gVar, boolean z2) {
            AppCompatDelegateImpl.this.b(gVar);
        }

        public boolean a(androidx.appcompat.view.menu.g gVar) {
            Window.Callback m2 = AppCompatDelegateImpl.this.m();
            if (m2 == null) {
                return true;
            }
            m2.onMenuOpened(108, gVar);
            return true;
        }
    }

    class c implements b.a {

        /* renamed from: b  reason: collision with root package name */
        private b.a f636b;

        public c(b.a aVar) {
            this.f636b = aVar;
        }

        public void a(f.b bVar) {
            this.f636b.a(bVar);
            if (AppCompatDelegateImpl.this.f591i != null) {
                AppCompatDelegateImpl.this.f585c.getDecorView().removeCallbacks(AppCompatDelegateImpl.this.f592j);
            }
            if (AppCompatDelegateImpl.this.f590h != null) {
                AppCompatDelegateImpl.this.r();
                AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
                appCompatDelegateImpl.f593k = ac.r(appCompatDelegateImpl.f590h).a(0.0f);
                AppCompatDelegateImpl.this.f593k.a((ah) new ai() {
                    public void b(View view) {
                        AppCompatDelegateImpl.this.f590h.setVisibility(8);
                        if (AppCompatDelegateImpl.this.f591i != null) {
                            AppCompatDelegateImpl.this.f591i.dismiss();
                        } else if (AppCompatDelegateImpl.this.f590h.getParent() instanceof View) {
                            ac.w((View) AppCompatDelegateImpl.this.f590h.getParent());
                        }
                        AppCompatDelegateImpl.this.f590h.c();
                        AppCompatDelegateImpl.this.f593k.a((ah) null);
                        AppCompatDelegateImpl.this.f593k = null;
                        ac.w(AppCompatDelegateImpl.this.f594l);
                    }
                });
            }
            if (AppCompatDelegateImpl.this.f586d != null) {
                AppCompatDelegateImpl.this.f586d.onSupportActionModeFinished(AppCompatDelegateImpl.this.f589g);
            }
            AppCompatDelegateImpl.this.f589g = null;
            ac.w(AppCompatDelegateImpl.this.f594l);
        }

        public boolean a(f.b bVar, Menu menu) {
            return this.f636b.a(bVar, menu);
        }

        public boolean a(f.b bVar, MenuItem menuItem) {
            return this.f636b.a(bVar, menuItem);
        }

        public boolean b(f.b bVar, Menu menu) {
            ac.w(AppCompatDelegateImpl.this.f594l);
            return this.f636b.b(bVar, menu);
        }
    }

    static class d {
        static Context a(Context context, Configuration configuration) {
            return context.createConfigurationContext(configuration);
        }

        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            if (configuration.densityDpi != configuration2.densityDpi) {
                configuration3.densityDpi = configuration2.densityDpi;
            }
        }
    }

    static class e {
        static boolean a(PowerManager powerManager) {
            return powerManager.isPowerSaveMode();
        }
    }

    static class f {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            LocaleList locales = configuration.getLocales();
            LocaleList locales2 = configuration2.getLocales();
            if (!locales.equals(locales2)) {
                configuration3.setLocales(locales2);
                configuration3.locale = configuration2.locale;
            }
        }
    }

    static class g {
        static void a(Configuration configuration, Configuration configuration2, Configuration configuration3) {
            if ((configuration.colorMode & 3) != (configuration2.colorMode & 3)) {
                configuration3.colorMode |= configuration2.colorMode & 3;
            }
            if ((configuration.colorMode & 12) != (configuration2.colorMode & 12)) {
                configuration3.colorMode |= configuration2.colorMode & 12;
            }
        }
    }

    class h extends f.i {
        h(Window.Callback callback) {
            super(callback);
        }

        /* access modifiers changed from: package-private */
        public final ActionMode a(ActionMode.Callback callback) {
            f.a aVar = new f.a(AppCompatDelegateImpl.this.f584b, callback);
            f.b a2 = AppCompatDelegateImpl.this.a((b.a) aVar);
            if (a2 != null) {
                return aVar.b(a2);
            }
            return null;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean dispatchKeyShortcutEvent(KeyEvent keyEvent) {
            return super.dispatchKeyShortcutEvent(keyEvent) || AppCompatDelegateImpl.this.a(keyEvent.getKeyCode(), keyEvent);
        }

        public void onContentChanged() {
        }

        public boolean onCreatePanelMenu(int i2, Menu menu) {
            if (i2 != 0 || (menu instanceof androidx.appcompat.view.menu.g)) {
                return super.onCreatePanelMenu(i2, menu);
            }
            return false;
        }

        public boolean onMenuOpened(int i2, Menu menu) {
            super.onMenuOpened(i2, menu);
            AppCompatDelegateImpl.this.f(i2);
            return true;
        }

        public void onPanelClosed(int i2, Menu menu) {
            super.onPanelClosed(i2, menu);
            AppCompatDelegateImpl.this.e(i2);
        }

        public boolean onPreparePanel(int i2, View view, Menu menu) {
            androidx.appcompat.view.menu.g gVar = menu instanceof androidx.appcompat.view.menu.g ? (androidx.appcompat.view.menu.g) menu : null;
            if (i2 == 0 && gVar == null) {
                return false;
            }
            if (gVar != null) {
                gVar.c(true);
            }
            boolean onPreparePanel = super.onPreparePanel(i2, view, menu);
            if (gVar != null) {
                gVar.c(false);
            }
            return onPreparePanel;
        }

        public void onProvideKeyboardShortcuts(List<KeyboardShortcutGroup> list, Menu menu, int i2) {
            PanelFeatureState a2 = AppCompatDelegateImpl.this.a(0, true);
            if (!(a2 == null || a2.f620j == null)) {
                menu = a2.f620j;
            }
            super.onProvideKeyboardShortcuts(list, menu, i2);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback) {
            if (Build.VERSION.SDK_INT >= 23) {
                return null;
            }
            return AppCompatDelegateImpl.this.q() ? a(callback) : super.onWindowStartingActionMode(callback);
        }

        public ActionMode onWindowStartingActionMode(ActionMode.Callback callback, int i2) {
            return (!AppCompatDelegateImpl.this.q() || i2 != 0) ? super.onWindowStartingActionMode(callback, i2) : a(callback);
        }
    }

    private class i extends j {

        /* renamed from: c  reason: collision with root package name */
        private final PowerManager f640c;

        i(Context context) {
            super();
            this.f640c = (PowerManager) context.getApplicationContext().getSystemService("power");
        }

        public int a() {
            return (Build.VERSION.SDK_INT < 21 || !e.a(this.f640c)) ? 1 : 2;
        }

        public void b() {
            AppCompatDelegateImpl.this.u();
        }

        /* access modifiers changed from: package-private */
        public IntentFilter c() {
            if (Build.VERSION.SDK_INT < 21) {
                return null;
            }
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.os.action.POWER_SAVE_MODE_CHANGED");
            return intentFilter;
        }
    }

    abstract class j {

        /* renamed from: a  reason: collision with root package name */
        private BroadcastReceiver f641a;

        j() {
        }

        /* access modifiers changed from: package-private */
        public abstract int a();

        /* access modifiers changed from: package-private */
        public abstract void b();

        /* access modifiers changed from: package-private */
        public abstract IntentFilter c();

        /* access modifiers changed from: package-private */
        public void d() {
            e();
            IntentFilter c2 = c();
            if (c2 != null && c2.countActions() != 0) {
                if (this.f641a == null) {
                    this.f641a = new BroadcastReceiver() {
                        public void onReceive(Context context, Intent intent) {
                            j.this.b();
                        }
                    };
                }
                AppCompatDelegateImpl.this.f584b.registerReceiver(this.f641a, c2);
            }
        }

        /* access modifiers changed from: package-private */
        public void e() {
            if (this.f641a != null) {
                try {
                    AppCompatDelegateImpl.this.f584b.unregisterReceiver(this.f641a);
                } catch (IllegalArgumentException unused) {
                }
                this.f641a = null;
            }
        }
    }

    private class k extends j {

        /* renamed from: c  reason: collision with root package name */
        private final l f645c;

        k(l lVar) {
            super();
            this.f645c = lVar;
        }

        public int a() {
            return this.f645c.a() ? 2 : 1;
        }

        public void b() {
            AppCompatDelegateImpl.this.u();
        }

        /* access modifiers changed from: package-private */
        public IntentFilter c() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.TIME_SET");
            intentFilter.addAction("android.intent.action.TIMEZONE_CHANGED");
            intentFilter.addAction("android.intent.action.TIME_TICK");
            return intentFilter;
        }
    }

    private static class l {
        static void a(ContextThemeWrapper contextThemeWrapper, Configuration configuration) {
            contextThemeWrapper.applyOverrideConfiguration(configuration);
        }
    }

    private class m extends ContentFrameLayout {
        public m(Context context) {
            super(context);
        }

        private boolean a(int i2, int i3) {
            return i2 < -5 || i3 < -5 || i2 > getWidth() + 5 || i3 > getHeight() + 5;
        }

        public boolean dispatchKeyEvent(KeyEvent keyEvent) {
            return AppCompatDelegateImpl.this.a(keyEvent) || super.dispatchKeyEvent(keyEvent);
        }

        public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
            if (motionEvent.getAction() != 0 || !a((int) motionEvent.getX(), (int) motionEvent.getY())) {
                return super.onInterceptTouchEvent(motionEvent);
            }
            AppCompatDelegateImpl.this.g(0);
            return true;
        }

        public void setBackgroundResource(int i2) {
            setBackgroundDrawable(c.a.b(getContext(), i2));
        }
    }

    private final class n implements m.a {
        n() {
        }

        public void a(androidx.appcompat.view.menu.g gVar, boolean z2) {
            androidx.appcompat.view.menu.g q2 = gVar.q();
            boolean z3 = q2 != gVar;
            AppCompatDelegateImpl appCompatDelegateImpl = AppCompatDelegateImpl.this;
            if (z3) {
                gVar = q2;
            }
            PanelFeatureState a2 = appCompatDelegateImpl.a((Menu) gVar);
            if (a2 == null) {
                return;
            }
            if (z3) {
                AppCompatDelegateImpl.this.a(a2.f611a, a2, (Menu) q2);
                AppCompatDelegateImpl.this.a(a2, true);
                return;
            }
            AppCompatDelegateImpl.this.a(a2, z2);
        }

        public boolean a(androidx.appcompat.view.menu.g gVar) {
            Window.Callback m2;
            if (gVar != gVar.q() || !AppCompatDelegateImpl.this.f595m || (m2 = AppCompatDelegateImpl.this.m()) == null || AppCompatDelegateImpl.this.f600r) {
                return true;
            }
            m2.onMenuOpened(108, gVar);
            return true;
        }
    }

    static {
        boolean z2 = false;
        boolean z3 = Build.VERSION.SDK_INT < 21;
        f574v = z3;
        if (Build.VERSION.SDK_INT >= 17) {
            z2 = true;
        }
        f577y = z2;
        if (z3 && !f578z) {
            final Thread.UncaughtExceptionHandler defaultUncaughtExceptionHandler = Thread.getDefaultUncaughtExceptionHandler();
            Thread.setDefaultUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
                private boolean a(Throwable th) {
                    String message;
                    if (!(th instanceof Resources.NotFoundException) || (message = th.getMessage()) == null) {
                        return false;
                    }
                    return message.contains("drawable") || message.contains("Drawable");
                }

                public void uncaughtException(Thread thread, Throwable th) {
                    if (a(th)) {
                        Resources.NotFoundException notFoundException = new Resources.NotFoundException(th.getMessage() + ". If the resource you are trying to use is a vector resource, you may be referencing it in an unsupported way. See AppCompatDelegate.setCompatVectorFromResourcesEnabled() for more info.");
                        notFoundException.initCause(th.getCause());
                        notFoundException.setStackTrace(th.getStackTrace());
                        defaultUncaughtExceptionHandler.uncaughtException(thread, notFoundException);
                        return;
                    }
                    defaultUncaughtExceptionHandler.uncaughtException(thread, th);
                }
            });
        }
    }

    AppCompatDelegateImpl(Activity activity, c cVar) {
        this(activity, (Window) null, cVar, activity);
    }

    AppCompatDelegateImpl(Dialog dialog, c cVar) {
        this(dialog.getContext(), dialog.getWindow(), cVar, dialog);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0036, code lost:
        r3 = f573u;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private AppCompatDelegateImpl(android.content.Context r3, android.view.Window r4, androidx.appcompat.app.c r5, java.lang.Object r6) {
        /*
            r2 = this;
            r2.<init>()
            r0 = 0
            r2.f593k = r0
            r0 = 1
            r2.F = r0
            r0 = -100
            r2.S = r0
            androidx.appcompat.app.AppCompatDelegateImpl$2 r1 = new androidx.appcompat.app.AppCompatDelegateImpl$2
            r1.<init>()
            r2.Y = r1
            r2.f584b = r3
            r2.f586d = r5
            r2.f579a = r6
            int r3 = r2.S
            if (r3 != r0) goto L_0x0032
            boolean r3 = r6 instanceof android.app.Dialog
            if (r3 == 0) goto L_0x0032
            androidx.appcompat.app.AppCompatActivity r3 = r2.B()
            if (r3 == 0) goto L_0x0032
            androidx.appcompat.app.d r3 = r3.getDelegate()
            int r3 = r3.j()
            r2.S = r3
        L_0x0032:
            int r3 = r2.S
            if (r3 != r0) goto L_0x0059
            j.g<java.lang.String, java.lang.Integer> r3 = f573u
            java.lang.Class r5 = r6.getClass()
            java.lang.String r5 = r5.getName()
            java.lang.Object r5 = r3.get(r5)
            java.lang.Integer r5 = (java.lang.Integer) r5
            if (r5 == 0) goto L_0x0059
            int r5 = r5.intValue()
            r2.S = r5
            java.lang.Class r5 = r6.getClass()
            java.lang.String r5 = r5.getName()
            r3.remove(r5)
        L_0x0059:
            if (r4 == 0) goto L_0x005e
            r2.a((android.view.Window) r4)
        L_0x005e:
            androidx.appcompat.widget.f.a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.<init>(android.content.Context, android.view.Window, androidx.appcompat.app.c, java.lang.Object):void");
    }

    private void A() {
        ContentFrameLayout contentFrameLayout = (ContentFrameLayout) this.f594l.findViewById(16908290);
        View decorView = this.f585c.getDecorView();
        contentFrameLayout.a(decorView.getPaddingLeft(), decorView.getPaddingTop(), decorView.getPaddingRight(), decorView.getPaddingBottom());
        TypedArray obtainStyledAttributes = this.f584b.obtainStyledAttributes(R.styleable.AppCompatTheme);
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMajor, contentFrameLayout.getMinWidthMajor());
        obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowMinWidthMinor, contentFrameLayout.getMinWidthMinor());
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMajor, contentFrameLayout.getFixedWidthMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedWidthMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedWidthMinor, contentFrameLayout.getFixedWidthMinor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMajor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMajor, contentFrameLayout.getFixedHeightMajor());
        }
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowFixedHeightMinor)) {
            obtainStyledAttributes.getValue(R.styleable.AppCompatTheme_windowFixedHeightMinor, contentFrameLayout.getFixedHeightMinor());
        }
        obtainStyledAttributes.recycle();
        contentFrameLayout.requestLayout();
    }

    private AppCompatActivity B() {
        Context context = this.f584b;
        while (context != null) {
            if (!(context instanceof AppCompatActivity)) {
                if (!(context instanceof ContextWrapper)) {
                    break;
                }
                context = ((ContextWrapper) context).getBaseContext();
            } else {
                return (AppCompatActivity) context;
            }
        }
        return null;
    }

    private void C() {
        if (this.G) {
            throw new AndroidRuntimeException("Window feature must be requested before adding content");
        }
    }

    private int D() {
        int i2 = this.S;
        return i2 != -100 ? i2 : k();
    }

    private boolean E() {
        if (!this.V && (this.f579a instanceof Activity)) {
            PackageManager packageManager = this.f584b.getPackageManager();
            if (packageManager == null) {
                return false;
            }
            try {
                ActivityInfo activityInfo = packageManager.getActivityInfo(new ComponentName(this.f584b, this.f579a.getClass()), Build.VERSION.SDK_INT >= 29 ? 269221888 : Build.VERSION.SDK_INT >= 24 ? 786432 : 0);
                this.U = (activityInfo == null || (activityInfo.configChanges & 512) == 0) ? false : true;
            } catch (PackageManager.NameNotFoundException e2) {
                Log.d("AppCompatDelegate", "Exception while getting ActivityInfo", e2);
                this.U = false;
            }
        }
        this.V = true;
        return this.U;
    }

    private Configuration a(Context context, int i2, Configuration configuration) {
        int i3 = i2 != 1 ? i2 != 2 ? context.getApplicationContext().getResources().getConfiguration().uiMode & 48 : 32 : 16;
        Configuration configuration2 = new Configuration();
        configuration2.fontScale = 0.0f;
        if (configuration != null) {
            configuration2.setTo(configuration);
        }
        configuration2.uiMode = i3 | (configuration2.uiMode & -49);
        return configuration2;
    }

    private static Configuration a(Configuration configuration, Configuration configuration2) {
        Configuration configuration3 = new Configuration();
        configuration3.fontScale = 0.0f;
        if (!(configuration2 == null || configuration.diff(configuration2) == 0)) {
            if (configuration.fontScale != configuration2.fontScale) {
                configuration3.fontScale = configuration2.fontScale;
            }
            if (configuration.mcc != configuration2.mcc) {
                configuration3.mcc = configuration2.mcc;
            }
            if (configuration.mnc != configuration2.mnc) {
                configuration3.mnc = configuration2.mnc;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                f.a(configuration, configuration2, configuration3);
            } else if (!s.c.a((Object) configuration.locale, (Object) configuration2.locale)) {
                configuration3.locale = configuration2.locale;
            }
            if (configuration.touchscreen != configuration2.touchscreen) {
                configuration3.touchscreen = configuration2.touchscreen;
            }
            if (configuration.keyboard != configuration2.keyboard) {
                configuration3.keyboard = configuration2.keyboard;
            }
            if (configuration.keyboardHidden != configuration2.keyboardHidden) {
                configuration3.keyboardHidden = configuration2.keyboardHidden;
            }
            if (configuration.navigation != configuration2.navigation) {
                configuration3.navigation = configuration2.navigation;
            }
            if (configuration.navigationHidden != configuration2.navigationHidden) {
                configuration3.navigationHidden = configuration2.navigationHidden;
            }
            if (configuration.orientation != configuration2.orientation) {
                configuration3.orientation = configuration2.orientation;
            }
            if ((configuration.screenLayout & 15) != (configuration2.screenLayout & 15)) {
                configuration3.screenLayout |= configuration2.screenLayout & 15;
            }
            if ((configuration.screenLayout & 192) != (configuration2.screenLayout & 192)) {
                configuration3.screenLayout |= configuration2.screenLayout & 192;
            }
            if ((configuration.screenLayout & 48) != (configuration2.screenLayout & 48)) {
                configuration3.screenLayout |= configuration2.screenLayout & 48;
            }
            if ((configuration.screenLayout & 768) != (configuration2.screenLayout & 768)) {
                configuration3.screenLayout |= configuration2.screenLayout & 768;
            }
            if (Build.VERSION.SDK_INT >= 26) {
                g.a(configuration, configuration2, configuration3);
            }
            if ((configuration.uiMode & 15) != (configuration2.uiMode & 15)) {
                configuration3.uiMode |= configuration2.uiMode & 15;
            }
            if ((configuration.uiMode & 48) != (configuration2.uiMode & 48)) {
                configuration3.uiMode |= configuration2.uiMode & 48;
            }
            if (configuration.screenWidthDp != configuration2.screenWidthDp) {
                configuration3.screenWidthDp = configuration2.screenWidthDp;
            }
            if (configuration.screenHeightDp != configuration2.screenHeightDp) {
                configuration3.screenHeightDp = configuration2.screenHeightDp;
            }
            if (configuration.smallestScreenWidthDp != configuration2.smallestScreenWidthDp) {
                configuration3.smallestScreenWidthDp = configuration2.smallestScreenWidthDp;
            }
            if (Build.VERSION.SDK_INT >= 17) {
                d.a(configuration, configuration2, configuration3);
            }
        }
        return configuration3;
    }

    private void a(int i2, boolean z2, Configuration configuration) {
        Resources resources = this.f584b.getResources();
        Configuration configuration2 = new Configuration(resources.getConfiguration());
        if (configuration != null) {
            configuration2.updateFrom(configuration);
        }
        configuration2.uiMode = i2 | (resources.getConfiguration().uiMode & -49);
        resources.updateConfiguration(configuration2, (DisplayMetrics) null);
        if (Build.VERSION.SDK_INT < 26) {
            i.a(resources);
        }
        int i3 = this.T;
        if (i3 != 0) {
            this.f584b.setTheme(i3);
            if (Build.VERSION.SDK_INT >= 23) {
                this.f584b.getTheme().applyStyle(this.T, true);
            }
        }
        if (z2) {
            Object obj = this.f579a;
            if (obj instanceof Activity) {
                Activity activity = (Activity) obj;
                if (activity instanceof androidx.lifecycle.n) {
                    if (!((androidx.lifecycle.n) activity).getLifecycle().a().a(Lifecycle.State.STARTED)) {
                        return;
                    }
                } else if (!this.R) {
                    return;
                }
                activity.onConfigurationChanged(configuration2);
            }
        }
    }

    private void a(Window window) {
        if (this.f585c == null) {
            Window.Callback callback = window.getCallback();
            if (!(callback instanceof h)) {
                h hVar = new h(callback);
                this.A = hVar;
                window.setCallback(hVar);
                af a2 = af.a(this.f584b, (AttributeSet) null, f575w);
                Drawable b2 = a2.b(0);
                if (b2 != null) {
                    window.setBackgroundDrawable(b2);
                }
                a2.b();
                this.f585c = window;
                return;
            }
            throw new IllegalStateException("AppCompat has already installed itself into the Window");
        }
        throw new IllegalStateException("AppCompat has already installed itself into the Window");
    }

    private void a(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        int i2;
        ViewGroup.LayoutParams layoutParams;
        if (!panelFeatureState.f625o && !this.f600r) {
            if (panelFeatureState.f611a == 0) {
                if ((this.f584b.getResources().getConfiguration().screenLayout & 15) == 4) {
                    return;
                }
            }
            Window.Callback m2 = m();
            if (m2 == null || m2.onMenuOpened(panelFeatureState.f611a, panelFeatureState.f620j)) {
                WindowManager windowManager = (WindowManager) this.f584b.getSystemService("window");
                if (windowManager != null && b(panelFeatureState, keyEvent)) {
                    if (panelFeatureState.f617g == null || panelFeatureState.f627q) {
                        if (panelFeatureState.f617g == null) {
                            if (!a(panelFeatureState) || panelFeatureState.f617g == null) {
                                return;
                            }
                        } else if (panelFeatureState.f627q && panelFeatureState.f617g.getChildCount() > 0) {
                            panelFeatureState.f617g.removeAllViews();
                        }
                        if (!c(panelFeatureState) || !panelFeatureState.a()) {
                            panelFeatureState.f627q = true;
                            return;
                        }
                        ViewGroup.LayoutParams layoutParams2 = panelFeatureState.f618h.getLayoutParams();
                        if (layoutParams2 == null) {
                            layoutParams2 = new ViewGroup.LayoutParams(-2, -2);
                        }
                        panelFeatureState.f617g.setBackgroundResource(panelFeatureState.f612b);
                        ViewParent parent = panelFeatureState.f618h.getParent();
                        if (parent instanceof ViewGroup) {
                            ((ViewGroup) parent).removeView(panelFeatureState.f618h);
                        }
                        panelFeatureState.f617g.addView(panelFeatureState.f618h, layoutParams2);
                        if (!panelFeatureState.f618h.hasFocus()) {
                            panelFeatureState.f618h.requestFocus();
                        }
                    } else if (!(panelFeatureState.f619i == null || (layoutParams = panelFeatureState.f619i.getLayoutParams()) == null || layoutParams.width != -1)) {
                        i2 = -1;
                        panelFeatureState.f624n = false;
                        WindowManager.LayoutParams layoutParams3 = new WindowManager.LayoutParams(i2, -2, panelFeatureState.f614d, panelFeatureState.f615e, 1002, 8519680, -3);
                        layoutParams3.gravity = panelFeatureState.f613c;
                        layoutParams3.windowAnimations = panelFeatureState.f616f;
                        windowManager.addView(panelFeatureState.f617g, layoutParams3);
                        panelFeatureState.f625o = true;
                        return;
                    }
                    i2 = -2;
                    panelFeatureState.f624n = false;
                    WindowManager.LayoutParams layoutParams32 = new WindowManager.LayoutParams(i2, -2, panelFeatureState.f614d, panelFeatureState.f615e, 1002, 8519680, -3);
                    layoutParams32.gravity = panelFeatureState.f613c;
                    layoutParams32.windowAnimations = panelFeatureState.f616f;
                    windowManager.addView(panelFeatureState.f617g, layoutParams32);
                    panelFeatureState.f625o = true;
                    return;
                }
                return;
            }
            a(panelFeatureState, true);
        }
    }

    private void a(boolean z2) {
        o oVar = this.C;
        if (oVar == null || !oVar.e() || (ViewConfiguration.get(this.f584b).hasPermanentMenuKey() && !this.C.g())) {
            PanelFeatureState a2 = a(0, true);
            a2.f627q = true;
            a(a2, false);
            a(a2, (KeyEvent) null);
            return;
        }
        Window.Callback m2 = m();
        if (this.C.f() && z2) {
            this.C.i();
            if (!this.f600r) {
                m2.onPanelClosed(108, a(0, true).f620j);
            }
        } else if (m2 != null && !this.f600r) {
            if (this.f601s && (this.f602t & 1) != 0) {
                this.f585c.getDecorView().removeCallbacks(this.Y);
                this.Y.run();
            }
            PanelFeatureState a3 = a(0, true);
            if (a3.f620j != null && !a3.f628r && m2.onPreparePanel(0, a3.f619i, a3.f620j)) {
                m2.onMenuOpened(108, a3.f620j);
                this.C.h();
            }
        }
    }

    private boolean a(ViewParent viewParent) {
        if (viewParent == null) {
            return false;
        }
        View decorView = this.f585c.getDecorView();
        while (viewParent != null) {
            if (viewParent == decorView || !(viewParent instanceof View) || ac.J((View) viewParent)) {
                return false;
            }
            viewParent = viewParent.getParent();
        }
        return true;
    }

    private boolean a(PanelFeatureState panelFeatureState) {
        panelFeatureState.a(n());
        panelFeatureState.f617g = new m(panelFeatureState.f622l);
        panelFeatureState.f613c = 81;
        return true;
    }

    private boolean a(PanelFeatureState panelFeatureState, int i2, KeyEvent keyEvent, int i3) {
        boolean z2 = false;
        if (keyEvent.isSystem()) {
            return false;
        }
        if ((panelFeatureState.f623m || b(panelFeatureState, keyEvent)) && panelFeatureState.f620j != null) {
            z2 = panelFeatureState.f620j.performShortcut(i2, keyEvent, i3);
        }
        if (z2 && (i3 & 1) == 0 && this.C == null) {
            a(panelFeatureState, true);
        }
        return z2;
    }

    private void b(View view) {
        int i2;
        Context context;
        if ((ac.v(view) & 8192) != 0) {
            context = this.f584b;
            i2 = R.color.abc_decor_view_status_guard_light;
        } else {
            context = this.f584b;
            i2 = R.color.abc_decor_view_status_guard;
        }
        view.setBackgroundColor(androidx.core.content.b.c(context, i2));
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0053  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean b(int r7, boolean r8) {
        /*
            r6 = this;
            android.content.Context r0 = r6.f584b
            r1 = 0
            android.content.res.Configuration r0 = r6.a((android.content.Context) r0, (int) r7, (android.content.res.Configuration) r1)
            boolean r2 = r6.E()
            android.content.Context r3 = r6.f584b
            android.content.res.Resources r3 = r3.getResources()
            android.content.res.Configuration r3 = r3.getConfiguration()
            int r3 = r3.uiMode
            r3 = r3 & 48
            int r0 = r0.uiMode
            r0 = r0 & 48
            r4 = 1
            if (r3 == r0) goto L_0x0047
            if (r8 == 0) goto L_0x0047
            if (r2 != 0) goto L_0x0047
            boolean r8 = r6.P
            if (r8 == 0) goto L_0x0047
            boolean r8 = f576x
            if (r8 != 0) goto L_0x0030
            boolean r8 = r6.Q
            if (r8 == 0) goto L_0x0047
        L_0x0030:
            java.lang.Object r8 = r6.f579a
            boolean r5 = r8 instanceof android.app.Activity
            if (r5 == 0) goto L_0x0047
            android.app.Activity r8 = (android.app.Activity) r8
            boolean r8 = r8.isChild()
            if (r8 != 0) goto L_0x0047
            java.lang.Object r8 = r6.f579a
            android.app.Activity r8 = (android.app.Activity) r8
            androidx.core.app.a.e(r8)
            r8 = 1
            goto L_0x0048
        L_0x0047:
            r8 = 0
        L_0x0048:
            if (r8 != 0) goto L_0x0050
            if (r3 == r0) goto L_0x0050
            r6.a((int) r0, (boolean) r2, (android.content.res.Configuration) r1)
            goto L_0x0051
        L_0x0050:
            r4 = r8
        L_0x0051:
            if (r4 == 0) goto L_0x005e
            java.lang.Object r8 = r6.f579a
            boolean r0 = r8 instanceof androidx.appcompat.app.AppCompatActivity
            if (r0 == 0) goto L_0x005e
            androidx.appcompat.app.AppCompatActivity r8 = (androidx.appcompat.app.AppCompatActivity) r8
            r8.onNightModeChanged(r7)
        L_0x005e:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.b(int, boolean):boolean");
    }

    private boolean b(PanelFeatureState panelFeatureState) {
        Context context = this.f584b;
        if ((panelFeatureState.f611a == 0 || panelFeatureState.f611a == 108) && this.C != null) {
            TypedValue typedValue = new TypedValue();
            Resources.Theme theme = context.getTheme();
            theme.resolveAttribute(R.attr.actionBarTheme, typedValue, true);
            Resources.Theme theme2 = null;
            if (typedValue.resourceId != 0) {
                theme2 = context.getResources().newTheme();
                theme2.setTo(theme);
                theme2.applyStyle(typedValue.resourceId, true);
                theme2.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            } else {
                theme.resolveAttribute(R.attr.actionBarWidgetTheme, typedValue, true);
            }
            if (typedValue.resourceId != 0) {
                if (theme2 == null) {
                    theme2 = context.getResources().newTheme();
                    theme2.setTo(theme);
                }
                theme2.applyStyle(typedValue.resourceId, true);
            }
            if (theme2 != null) {
                f.d dVar = new f.d(context, 0);
                dVar.getTheme().setTo(theme2);
                context = dVar;
            }
        }
        androidx.appcompat.view.menu.g gVar = new androidx.appcompat.view.menu.g(context);
        gVar.a((g.a) this);
        panelFeatureState.a(gVar);
        return true;
    }

    private boolean b(PanelFeatureState panelFeatureState, KeyEvent keyEvent) {
        o oVar;
        o oVar2;
        o oVar3;
        if (this.f600r) {
            return false;
        }
        if (panelFeatureState.f623m) {
            return true;
        }
        PanelFeatureState panelFeatureState2 = this.N;
        if (!(panelFeatureState2 == null || panelFeatureState2 == panelFeatureState)) {
            a(panelFeatureState2, false);
        }
        Window.Callback m2 = m();
        if (m2 != null) {
            panelFeatureState.f619i = m2.onCreatePanelView(panelFeatureState.f611a);
        }
        boolean z2 = panelFeatureState.f611a == 0 || panelFeatureState.f611a == 108;
        if (z2 && (oVar3 = this.C) != null) {
            oVar3.j();
        }
        if (panelFeatureState.f619i == null && (!z2 || !(l() instanceof j))) {
            if (panelFeatureState.f620j == null || panelFeatureState.f628r) {
                if (panelFeatureState.f620j == null && (!b(panelFeatureState) || panelFeatureState.f620j == null)) {
                    return false;
                }
                if (z2 && this.C != null) {
                    if (this.D == null) {
                        this.D = new b();
                    }
                    this.C.a(panelFeatureState.f620j, this.D);
                }
                panelFeatureState.f620j.h();
                if (!m2.onCreatePanelMenu(panelFeatureState.f611a, panelFeatureState.f620j)) {
                    panelFeatureState.a((androidx.appcompat.view.menu.g) null);
                    if (z2 && (oVar2 = this.C) != null) {
                        oVar2.a((Menu) null, this.D);
                    }
                    return false;
                }
                panelFeatureState.f628r = false;
            }
            panelFeatureState.f620j.h();
            if (panelFeatureState.f629s != null) {
                panelFeatureState.f620j.d(panelFeatureState.f629s);
                panelFeatureState.f629s = null;
            }
            if (!m2.onPreparePanel(0, panelFeatureState.f619i, panelFeatureState.f620j)) {
                if (z2 && (oVar = this.C) != null) {
                    oVar.a((Menu) null, this.D);
                }
                panelFeatureState.f620j.i();
                return false;
            }
            panelFeatureState.f626p = KeyCharacterMap.load(keyEvent != null ? keyEvent.getDeviceId() : -1).getKeyboardType() != 1;
            panelFeatureState.f620j.setQwertyMode(panelFeatureState.f626p);
            panelFeatureState.f620j.i();
        }
        panelFeatureState.f623m = true;
        panelFeatureState.f624n = false;
        this.N = panelFeatureState;
        return true;
    }

    private boolean b(boolean z2) {
        if (this.f600r) {
            return false;
        }
        int D2 = D();
        boolean b2 = b(a(this.f584b, D2), z2);
        if (D2 == 0) {
            c(this.f584b).d();
        } else {
            j jVar = this.W;
            if (jVar != null) {
                jVar.e();
            }
        }
        if (D2 == 3) {
            d(this.f584b).d();
        } else {
            j jVar2 = this.X;
            if (jVar2 != null) {
                jVar2.e();
            }
        }
        return b2;
    }

    private j c(Context context) {
        if (this.W == null) {
            this.W = new k(l.a(context));
        }
        return this.W;
    }

    private boolean c(PanelFeatureState panelFeatureState) {
        if (panelFeatureState.f619i != null) {
            panelFeatureState.f618h = panelFeatureState.f619i;
            return true;
        } else if (panelFeatureState.f620j == null) {
            return false;
        } else {
            if (this.E == null) {
                this.E = new n();
            }
            panelFeatureState.f618h = (View) panelFeatureState.a((m.a) this.E);
            return panelFeatureState.f618h != null;
        }
    }

    private j d(Context context) {
        if (this.X == null) {
            this.X = new i(context);
        }
        return this.X;
    }

    private boolean d(int i2, KeyEvent keyEvent) {
        if (keyEvent.getRepeatCount() != 0) {
            return false;
        }
        PanelFeatureState a2 = a(i2, true);
        if (!a2.f625o) {
            return b(a2, keyEvent);
        }
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:34:0x006c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean e(int r4, android.view.KeyEvent r5) {
        /*
            r3 = this;
            f.b r0 = r3.f589g
            r1 = 0
            if (r0 == 0) goto L_0x0006
            return r1
        L_0x0006:
            r0 = 1
            androidx.appcompat.app.AppCompatDelegateImpl$PanelFeatureState r2 = r3.a((int) r4, (boolean) r0)
            if (r4 != 0) goto L_0x0043
            androidx.appcompat.widget.o r4 = r3.C
            if (r4 == 0) goto L_0x0043
            boolean r4 = r4.e()
            if (r4 == 0) goto L_0x0043
            android.content.Context r4 = r3.f584b
            android.view.ViewConfiguration r4 = android.view.ViewConfiguration.get(r4)
            boolean r4 = r4.hasPermanentMenuKey()
            if (r4 != 0) goto L_0x0043
            androidx.appcompat.widget.o r4 = r3.C
            boolean r4 = r4.f()
            if (r4 != 0) goto L_0x003c
            boolean r4 = r3.f600r
            if (r4 != 0) goto L_0x0062
            boolean r4 = r3.b((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r2, (android.view.KeyEvent) r5)
            if (r4 == 0) goto L_0x0062
            androidx.appcompat.widget.o r4 = r3.C
            boolean r0 = r4.h()
            goto L_0x006a
        L_0x003c:
            androidx.appcompat.widget.o r4 = r3.C
            boolean r0 = r4.i()
            goto L_0x006a
        L_0x0043:
            boolean r4 = r2.f625o
            if (r4 != 0) goto L_0x0064
            boolean r4 = r2.f624n
            if (r4 == 0) goto L_0x004c
            goto L_0x0064
        L_0x004c:
            boolean r4 = r2.f623m
            if (r4 == 0) goto L_0x0062
            boolean r4 = r2.f628r
            if (r4 == 0) goto L_0x005b
            r2.f623m = r1
            boolean r4 = r3.b((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r2, (android.view.KeyEvent) r5)
            goto L_0x005c
        L_0x005b:
            r4 = 1
        L_0x005c:
            if (r4 == 0) goto L_0x0062
            r3.a((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r2, (android.view.KeyEvent) r5)
            goto L_0x006a
        L_0x0062:
            r0 = 0
            goto L_0x006a
        L_0x0064:
            boolean r4 = r2.f625o
            r3.a((androidx.appcompat.app.AppCompatDelegateImpl.PanelFeatureState) r2, (boolean) r0)
            r0 = r4
        L_0x006a:
            if (r0 == 0) goto L_0x0087
            android.content.Context r4 = r3.f584b
            android.content.Context r4 = r4.getApplicationContext()
            java.lang.String r5 = "audio"
            java.lang.Object r4 = r4.getSystemService(r5)
            android.media.AudioManager r4 = (android.media.AudioManager) r4
            if (r4 == 0) goto L_0x0080
            r4.playSoundEffect(r1)
            goto L_0x0087
        L_0x0080:
            java.lang.String r4 = "AppCompatDelegate"
            java.lang.String r5 = "Couldn't get audio manager"
            android.util.Log.w(r4, r5)
        L_0x0087:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.e(int, android.view.KeyEvent):boolean");
    }

    private void i(int i2) {
        this.f602t = (1 << i2) | this.f602t;
        if (!this.f601s) {
            ac.a(this.f585c.getDecorView(), this.Y);
            this.f601s = true;
        }
    }

    private int j(int i2) {
        if (i2 == 8) {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR id when requesting this feature.");
            return 108;
        } else if (i2 != 9) {
            return i2;
        } else {
            Log.i("AppCompatDelegate", "You should now use the AppCompatDelegate.FEATURE_SUPPORT_ACTION_BAR_OVERLAY id when requesting this feature.");
            return 109;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:13:0x0032  */
    /* JADX WARNING: Removed duplicated region for block: B:16:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void v() {
        /*
            r3 = this;
            r3.y()
            boolean r0 = r3.f595m
            if (r0 == 0) goto L_0x0037
            androidx.appcompat.app.ActionBar r0 = r3.f587e
            if (r0 == 0) goto L_0x000c
            goto L_0x0037
        L_0x000c:
            java.lang.Object r0 = r3.f579a
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0020
            androidx.appcompat.app.m r0 = new androidx.appcompat.app.m
            java.lang.Object r1 = r3.f579a
            android.app.Activity r1 = (android.app.Activity) r1
            boolean r2 = r3.f596n
            r0.<init>(r1, r2)
        L_0x001d:
            r3.f587e = r0
            goto L_0x002e
        L_0x0020:
            boolean r0 = r0 instanceof android.app.Dialog
            if (r0 == 0) goto L_0x002e
            androidx.appcompat.app.m r0 = new androidx.appcompat.app.m
            java.lang.Object r1 = r3.f579a
            android.app.Dialog r1 = (android.app.Dialog) r1
            r0.<init>(r1)
            goto L_0x001d
        L_0x002e:
            androidx.appcompat.app.ActionBar r0 = r3.f587e
            if (r0 == 0) goto L_0x0037
            boolean r1 = r3.Z
            r0.c(r1)
        L_0x0037:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.v():void");
    }

    private void w() {
        j jVar = this.W;
        if (jVar != null) {
            jVar.e();
        }
        j jVar2 = this.X;
        if (jVar2 != null) {
            jVar2.e();
        }
    }

    private void x() {
        if (this.f585c == null) {
            Object obj = this.f579a;
            if (obj instanceof Activity) {
                a(((Activity) obj).getWindow());
            }
        }
        if (this.f585c == null) {
            throw new IllegalStateException("We have not been given a Window");
        }
    }

    private void y() {
        if (!this.G) {
            this.f594l = z();
            CharSequence o2 = o();
            if (!TextUtils.isEmpty(o2)) {
                o oVar = this.C;
                if (oVar != null) {
                    oVar.setWindowTitle(o2);
                } else if (l() != null) {
                    l().a(o2);
                } else {
                    TextView textView = this.H;
                    if (textView != null) {
                        textView.setText(o2);
                    }
                }
            }
            A();
            a(this.f594l);
            this.G = true;
            PanelFeatureState a2 = a(0, false);
            if (this.f600r) {
                return;
            }
            if (a2 == null || a2.f620j == null) {
                i(108);
            }
        }
    }

    private ViewGroup z() {
        ViewGroup viewGroup;
        TypedArray obtainStyledAttributes = this.f584b.obtainStyledAttributes(R.styleable.AppCompatTheme);
        if (obtainStyledAttributes.hasValue(R.styleable.AppCompatTheme_windowActionBar)) {
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowNoTitle, false)) {
                d(1);
            } else if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBar, false)) {
                d(108);
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionBarOverlay, false)) {
                d(109);
            }
            if (obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_windowActionModeOverlay, false)) {
                d(10);
            }
            this.f598p = obtainStyledAttributes.getBoolean(R.styleable.AppCompatTheme_android_windowIsFloating, false);
            obtainStyledAttributes.recycle();
            x();
            this.f585c.getDecorView();
            LayoutInflater from = LayoutInflater.from(this.f584b);
            if (this.f599q) {
                viewGroup = (ViewGroup) from.inflate(this.f597o ? R.layout.abc_screen_simple_overlay_action_mode : R.layout.abc_screen_simple, (ViewGroup) null);
            } else if (this.f598p) {
                viewGroup = (ViewGroup) from.inflate(R.layout.abc_dialog_title_material, (ViewGroup) null);
                this.f596n = false;
                this.f595m = false;
            } else if (this.f595m) {
                TypedValue typedValue = new TypedValue();
                this.f584b.getTheme().resolveAttribute(R.attr.actionBarTheme, typedValue, true);
                viewGroup = (ViewGroup) LayoutInflater.from(typedValue.resourceId != 0 ? new f.d(this.f584b, typedValue.resourceId) : this.f584b).inflate(R.layout.abc_screen_toolbar, (ViewGroup) null);
                o oVar = (o) viewGroup.findViewById(R.id.decor_content_parent);
                this.C = oVar;
                oVar.setWindowCallback(m());
                if (this.f596n) {
                    this.C.a(109);
                }
                if (this.J) {
                    this.C.a(2);
                }
                if (this.K) {
                    this.C.a(5);
                }
            } else {
                viewGroup = null;
            }
            if (viewGroup != null) {
                if (Build.VERSION.SDK_INT >= 21) {
                    ac.a((View) viewGroup, (u) new u() {
                        public ak a(View view, ak akVar) {
                            int b2 = akVar.b();
                            int a2 = AppCompatDelegateImpl.this.a(akVar, (Rect) null);
                            if (b2 != a2) {
                                akVar = akVar.a(akVar.a(), a2, akVar.c(), akVar.d());
                            }
                            return ac.a(view, akVar);
                        }
                    });
                } else if (viewGroup instanceof s) {
                    ((s) viewGroup).setOnFitSystemWindowsListener(new s.a() {
                        public void a(Rect rect) {
                            rect.top = AppCompatDelegateImpl.this.a((ak) null, rect);
                        }
                    });
                }
                if (this.C == null) {
                    this.H = (TextView) viewGroup.findViewById(R.id.title);
                }
                al.b(viewGroup);
                ContentFrameLayout contentFrameLayout = (ContentFrameLayout) viewGroup.findViewById(R.id.action_bar_activity_content);
                ViewGroup viewGroup2 = (ViewGroup) this.f585c.findViewById(16908290);
                if (viewGroup2 != null) {
                    while (viewGroup2.getChildCount() > 0) {
                        View childAt = viewGroup2.getChildAt(0);
                        viewGroup2.removeViewAt(0);
                        contentFrameLayout.addView(childAt);
                    }
                    viewGroup2.setId(-1);
                    contentFrameLayout.setId(16908290);
                    if (viewGroup2 instanceof FrameLayout) {
                        ((FrameLayout) viewGroup2).setForeground((Drawable) null);
                    }
                }
                this.f585c.setContentView(viewGroup);
                contentFrameLayout.setAttachListener(new ContentFrameLayout.a() {
                    public void a() {
                    }

                    public void b() {
                        AppCompatDelegateImpl.this.t();
                    }
                });
                return viewGroup;
            }
            throw new IllegalArgumentException("AppCompat does not support the current theme features: { windowActionBar: " + this.f595m + ", windowActionBarOverlay: " + this.f596n + ", android:windowIsFloating: " + this.f598p + ", windowActionModeOverlay: " + this.f597o + ", windowNoTitle: " + this.f599q + " }");
        }
        obtainStyledAttributes.recycle();
        throw new IllegalStateException("You need to use a Theme.AppCompat theme (or descendant) with this activity.");
    }

    /* access modifiers changed from: package-private */
    public int a(Context context, int i2) {
        j c2;
        if (i2 == -100) {
            return -1;
        }
        if (i2 != -1) {
            if (i2 != 0) {
                if (!(i2 == 1 || i2 == 2)) {
                    if (i2 == 3) {
                        c2 = d(context);
                    } else {
                        throw new IllegalStateException("Unknown value set for night mode. Please use one of the MODE_NIGHT values from AppCompatDelegate.");
                    }
                }
            } else if (Build.VERSION.SDK_INT >= 23 && ((UiModeManager) context.getApplicationContext().getSystemService("uimode")).getNightMode() == 0) {
                return -1;
            } else {
                c2 = c(context);
            }
            return c2.a();
        }
        return i2;
    }

    /* access modifiers changed from: package-private */
    public final int a(ak akVar, Rect rect) {
        boolean z2;
        boolean z3;
        int i2 = 0;
        int b2 = akVar != null ? akVar.b() : rect != null ? rect.top : 0;
        ActionBarContextView actionBarContextView = this.f590h;
        if (actionBarContextView == null || !(actionBarContextView.getLayoutParams() instanceof ViewGroup.MarginLayoutParams)) {
            z2 = false;
        } else {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f590h.getLayoutParams();
            boolean z4 = true;
            if (this.f590h.isShown()) {
                if (this.f580aa == null) {
                    this.f580aa = new Rect();
                    this.f581ab = new Rect();
                }
                Rect rect2 = this.f580aa;
                Rect rect3 = this.f581ab;
                if (akVar == null) {
                    rect2.set(rect);
                } else {
                    rect2.set(akVar.a(), akVar.b(), akVar.c(), akVar.d());
                }
                al.a(this.f594l, rect2, rect3);
                int i3 = rect2.top;
                int i4 = rect2.left;
                int i5 = rect2.right;
                ak y2 = ac.y(this.f594l);
                int a2 = y2 == null ? 0 : y2.a();
                int c2 = y2 == null ? 0 : y2.c();
                if (marginLayoutParams.topMargin == i3 && marginLayoutParams.leftMargin == i4 && marginLayoutParams.rightMargin == i5) {
                    z3 = false;
                } else {
                    marginLayoutParams.topMargin = i3;
                    marginLayoutParams.leftMargin = i4;
                    marginLayoutParams.rightMargin = i5;
                    z3 = true;
                }
                if (i3 <= 0 || this.I != null) {
                    View view = this.I;
                    if (view != null) {
                        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
                        if (!(marginLayoutParams2.height == marginLayoutParams.topMargin && marginLayoutParams2.leftMargin == a2 && marginLayoutParams2.rightMargin == c2)) {
                            marginLayoutParams2.height = marginLayoutParams.topMargin;
                            marginLayoutParams2.leftMargin = a2;
                            marginLayoutParams2.rightMargin = c2;
                            this.I.setLayoutParams(marginLayoutParams2);
                        }
                    }
                } else {
                    View view2 = new View(this.f584b);
                    this.I = view2;
                    view2.setVisibility(8);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, marginLayoutParams.topMargin, 51);
                    layoutParams.leftMargin = a2;
                    layoutParams.rightMargin = c2;
                    this.f594l.addView(this.I, -1, layoutParams);
                }
                View view3 = this.I;
                if (view3 == null) {
                    z4 = false;
                }
                if (z4 && view3.getVisibility() != 0) {
                    b(this.I);
                }
                if (!this.f597o && z4) {
                    b2 = 0;
                }
                z2 = z4;
                z4 = z3;
            } else if (marginLayoutParams.topMargin != 0) {
                marginLayoutParams.topMargin = 0;
                z2 = false;
            } else {
                z2 = false;
                z4 = false;
            }
            if (z4) {
                this.f590h.setLayoutParams(marginLayoutParams);
            }
        }
        View view4 = this.I;
        if (view4 != null) {
            if (!z2) {
                i2 = 8;
            }
            view4.setVisibility(i2);
        }
        return b2;
    }

    public View a(View view, String str, Context context, AttributeSet attributeSet) {
        boolean z2;
        g gVar;
        boolean z3 = false;
        if (this.f582ac == null) {
            String string = this.f584b.obtainStyledAttributes(R.styleable.AppCompatTheme).getString(R.styleable.AppCompatTheme_viewInflaterClass);
            if (string == null) {
                gVar = new g();
            } else {
                try {
                    this.f582ac = (g) Class.forName(string).getDeclaredConstructor(new Class[0]).newInstance(new Object[0]);
                } catch (Throwable th) {
                    Log.i("AppCompatDelegate", "Failed to instantiate custom view inflater " + string + ". Falling back to default.", th);
                    gVar = new g();
                }
            }
            this.f582ac = gVar;
        }
        boolean z4 = f574v;
        if (z4) {
            if (this.f583ad == null) {
                this.f583ad = new h();
            }
            if (this.f583ad.a(attributeSet)) {
                z2 = true;
            } else {
                if (!(attributeSet instanceof XmlPullParser)) {
                    z3 = a((ViewParent) view);
                } else if (((XmlPullParser) attributeSet).getDepth() > 1) {
                    z3 = true;
                }
                z2 = z3;
            }
        } else {
            z2 = false;
        }
        return this.f582ac.a(view, str, context, attributeSet, z2, z4, true, androidx.appcompat.widget.ak.a());
    }

    public ActionBar a() {
        v();
        return this.f587e;
    }

    /* access modifiers changed from: protected */
    public PanelFeatureState a(int i2, boolean z2) {
        PanelFeatureState[] panelFeatureStateArr = this.M;
        if (panelFeatureStateArr == null || panelFeatureStateArr.length <= i2) {
            PanelFeatureState[] panelFeatureStateArr2 = new PanelFeatureState[(i2 + 1)];
            if (panelFeatureStateArr != null) {
                System.arraycopy(panelFeatureStateArr, 0, panelFeatureStateArr2, 0, panelFeatureStateArr.length);
            }
            this.M = panelFeatureStateArr2;
            panelFeatureStateArr = panelFeatureStateArr2;
        }
        PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
        if (panelFeatureState != null) {
            return panelFeatureState;
        }
        PanelFeatureState panelFeatureState2 = new PanelFeatureState(i2);
        panelFeatureStateArr[i2] = panelFeatureState2;
        return panelFeatureState2;
    }

    /* access modifiers changed from: package-private */
    public PanelFeatureState a(Menu menu) {
        PanelFeatureState[] panelFeatureStateArr = this.M;
        int length = panelFeatureStateArr != null ? panelFeatureStateArr.length : 0;
        for (int i2 = 0; i2 < length; i2++) {
            PanelFeatureState panelFeatureState = panelFeatureStateArr[i2];
            if (panelFeatureState != null && panelFeatureState.f620j == menu) {
                return panelFeatureState;
            }
        }
        return null;
    }

    public f.b a(b.a aVar) {
        c cVar;
        if (aVar != null) {
            f.b bVar = this.f589g;
            if (bVar != null) {
                bVar.c();
            }
            c cVar2 = new c(aVar);
            ActionBar a2 = a();
            if (a2 != null) {
                f.b a3 = a2.a((b.a) cVar2);
                this.f589g = a3;
                if (!(a3 == null || (cVar = this.f586d) == null)) {
                    cVar.onSupportActionModeStarted(a3);
                }
            }
            if (this.f589g == null) {
                this.f589g = b((b.a) cVar2);
            }
            return this.f589g;
        }
        throw new IllegalArgumentException("ActionMode callback can not be null.");
    }

    public void a(int i2) {
        this.T = i2;
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, PanelFeatureState panelFeatureState, Menu menu) {
        if (menu == null) {
            if (panelFeatureState == null && i2 >= 0) {
                PanelFeatureState[] panelFeatureStateArr = this.M;
                if (i2 < panelFeatureStateArr.length) {
                    panelFeatureState = panelFeatureStateArr[i2];
                }
            }
            if (panelFeatureState != null) {
                menu = panelFeatureState.f620j;
            }
        }
        if ((panelFeatureState == null || panelFeatureState.f625o) && !this.f600r) {
            this.A.a().onPanelClosed(i2, menu);
        }
    }

    public void a(Configuration configuration) {
        ActionBar a2;
        if (this.f595m && this.G && (a2 = a()) != null) {
            a2.a(configuration);
        }
        androidx.appcompat.widget.f.b().a(this.f584b);
        b(false);
    }

    public void a(Bundle bundle) {
        this.P = true;
        b(false);
        x();
        Object obj = this.f579a;
        if (obj instanceof Activity) {
            String str = null;
            try {
                str = androidx.core.app.f.c((Activity) obj);
            } catch (IllegalArgumentException unused) {
            }
            if (str != null) {
                ActionBar l2 = l();
                if (l2 == null) {
                    this.Z = true;
                } else {
                    l2.c(true);
                }
            }
            a((d) this);
        }
        this.Q = true;
    }

    public void a(View view) {
        y();
        ViewGroup viewGroup = (ViewGroup) this.f594l.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view);
        this.A.a().onContentChanged();
    }

    public void a(View view, ViewGroup.LayoutParams layoutParams) {
        y();
        ViewGroup viewGroup = (ViewGroup) this.f594l.findViewById(16908290);
        viewGroup.removeAllViews();
        viewGroup.addView(view, layoutParams);
        this.A.a().onContentChanged();
    }

    /* access modifiers changed from: package-private */
    public void a(ViewGroup viewGroup) {
    }

    /* access modifiers changed from: package-private */
    public void a(PanelFeatureState panelFeatureState, boolean z2) {
        o oVar;
        if (!z2 || panelFeatureState.f611a != 0 || (oVar = this.C) == null || !oVar.f()) {
            WindowManager windowManager = (WindowManager) this.f584b.getSystemService("window");
            if (!(windowManager == null || !panelFeatureState.f625o || panelFeatureState.f617g == null)) {
                windowManager.removeView(panelFeatureState.f617g);
                if (z2) {
                    a(panelFeatureState.f611a, panelFeatureState, (Menu) null);
                }
            }
            panelFeatureState.f623m = false;
            panelFeatureState.f624n = false;
            panelFeatureState.f625o = false;
            panelFeatureState.f618h = null;
            panelFeatureState.f627q = true;
            if (this.N == panelFeatureState) {
                this.N = null;
                return;
            }
            return;
        }
        b(panelFeatureState.f620j);
    }

    public void a(androidx.appcompat.view.menu.g gVar) {
        a(true);
    }

    public void a(Toolbar toolbar) {
        Window window;
        Window.Callback callback;
        if (this.f579a instanceof Activity) {
            ActionBar a2 = a();
            if (!(a2 instanceof m)) {
                this.f588f = null;
                if (a2 != null) {
                    a2.i();
                }
                if (toolbar != null) {
                    j jVar = new j(toolbar, o(), this.A);
                    this.f587e = jVar;
                    window = this.f585c;
                    callback = jVar.j();
                } else {
                    this.f587e = null;
                    window = this.f585c;
                    callback = this.A;
                }
                window.setCallback(callback);
                f();
                return;
            }
            throw new IllegalStateException("This Activity already has an action bar supplied by the window decor. Do not request Window.FEATURE_SUPPORT_ACTION_BAR and set windowActionBar to false in your theme to use a Toolbar instead.");
        }
    }

    public final void a(CharSequence charSequence) {
        this.B = charSequence;
        o oVar = this.C;
        if (oVar != null) {
            oVar.setWindowTitle(charSequence);
        } else if (l() != null) {
            l().a(charSequence);
        } else {
            TextView textView = this.H;
            if (textView != null) {
                textView.setText(charSequence);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public boolean a(int i2, KeyEvent keyEvent) {
        ActionBar a2 = a();
        if (a2 != null && a2.a(i2, keyEvent)) {
            return true;
        }
        PanelFeatureState panelFeatureState = this.N;
        if (panelFeatureState == null || !a(panelFeatureState, keyEvent.getKeyCode(), keyEvent, 1)) {
            if (this.N == null) {
                PanelFeatureState a3 = a(0, true);
                b(a3, keyEvent);
                boolean a4 = a(a3, keyEvent.getKeyCode(), keyEvent, 1);
                a3.f623m = false;
                if (a4) {
                    return true;
                }
            }
            return false;
        }
        PanelFeatureState panelFeatureState2 = this.N;
        if (panelFeatureState2 != null) {
            panelFeatureState2.f624n = true;
        }
        return true;
    }

    /* access modifiers changed from: package-private */
    public boolean a(KeyEvent keyEvent) {
        View decorView;
        Object obj = this.f579a;
        boolean z2 = true;
        if (((obj instanceof g.a) || (obj instanceof e)) && (decorView = this.f585c.getDecorView()) != null && t.g.a(decorView, keyEvent)) {
            return true;
        }
        if (keyEvent.getKeyCode() == 82 && this.A.a().dispatchKeyEvent(keyEvent)) {
            return true;
        }
        int keyCode = keyEvent.getKeyCode();
        if (keyEvent.getAction() != 0) {
            z2 = false;
        }
        return z2 ? c(keyCode, keyEvent) : b(keyCode, keyEvent);
    }

    public boolean a(androidx.appcompat.view.menu.g gVar, MenuItem menuItem) {
        PanelFeatureState a2;
        Window.Callback m2 = m();
        if (m2 == null || this.f600r || (a2 = a((Menu) gVar.q())) == null) {
            return false;
        }
        return m2.onMenuItemSelected(a2.f611a, menuItem);
    }

    public Context b(Context context) {
        boolean z2 = true;
        this.P = true;
        int a2 = a(context, D());
        Configuration configuration = null;
        if (f577y && (context instanceof ContextThemeWrapper)) {
            try {
                l.a((ContextThemeWrapper) context, a(context, a2, (Configuration) null));
                return context;
            } catch (IllegalStateException unused) {
            }
        }
        if (context instanceof f.d) {
            try {
                ((f.d) context).a(a(context, a2, (Configuration) null));
                return context;
            } catch (IllegalStateException unused2) {
            }
        }
        if (!f576x) {
            return super.b(context);
        }
        if (Build.VERSION.SDK_INT >= 17) {
            Configuration configuration2 = new Configuration();
            configuration2.uiMode = -1;
            configuration2.fontScale = 0.0f;
            Configuration configuration3 = d.a(context, configuration2).getResources().getConfiguration();
            Configuration configuration4 = context.getResources().getConfiguration();
            configuration3.uiMode = configuration4.uiMode;
            if (!configuration3.equals(configuration4)) {
                configuration = a(configuration3, configuration4);
            }
        }
        Configuration a3 = a(context, a2, configuration);
        f.d dVar = new f.d(context, R.style.Theme_AppCompat_Empty);
        dVar.a(a3);
        boolean z3 = false;
        try {
            if (context.getTheme() == null) {
                z2 = false;
            }
            z3 = z2;
        } catch (NullPointerException unused3) {
        }
        if (z3) {
            f.d.a(dVar.getTheme());
        }
        return super.b((Context) dVar);
    }

    public MenuInflater b() {
        if (this.f588f == null) {
            v();
            ActionBar actionBar = this.f587e;
            this.f588f = new f.g(actionBar != null ? actionBar.d() : this.f584b);
        }
        return this.f588f;
    }

    public <T extends View> T b(int i2) {
        y();
        return this.f585c.findViewById(i2);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0029  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public f.b b(f.b.a r8) {
        /*
            r7 = this;
            r7.r()
            f.b r0 = r7.f589g
            if (r0 == 0) goto L_0x000a
            r0.c()
        L_0x000a:
            boolean r0 = r8 instanceof androidx.appcompat.app.AppCompatDelegateImpl.c
            if (r0 != 0) goto L_0x0014
            androidx.appcompat.app.AppCompatDelegateImpl$c r0 = new androidx.appcompat.app.AppCompatDelegateImpl$c
            r0.<init>(r8)
            r8 = r0
        L_0x0014:
            androidx.appcompat.app.c r0 = r7.f586d
            r1 = 0
            if (r0 == 0) goto L_0x0022
            boolean r2 = r7.f600r
            if (r2 != 0) goto L_0x0022
            f.b r0 = r0.onWindowStartingSupportActionMode(r8)     // Catch:{ AbstractMethodError -> 0x0022 }
            goto L_0x0023
        L_0x0022:
            r0 = r1
        L_0x0023:
            if (r0 == 0) goto L_0x0029
            r7.f589g = r0
            goto L_0x0162
        L_0x0029:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f590h
            r2 = 0
            r3 = 1
            if (r0 != 0) goto L_0x00d4
            boolean r0 = r7.f598p
            if (r0 == 0) goto L_0x00b5
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            android.content.Context r4 = r7.f584b
            android.content.res.Resources$Theme r4 = r4.getTheme()
            int r5 = androidx.appcompat.R.attr.actionBarTheme
            r4.resolveAttribute(r5, r0, r3)
            int r5 = r0.resourceId
            if (r5 == 0) goto L_0x0068
            android.content.Context r5 = r7.f584b
            android.content.res.Resources r5 = r5.getResources()
            android.content.res.Resources$Theme r5 = r5.newTheme()
            r5.setTo(r4)
            int r4 = r0.resourceId
            r5.applyStyle(r4, r3)
            f.d r4 = new f.d
            android.content.Context r6 = r7.f584b
            r4.<init>((android.content.Context) r6, (int) r2)
            android.content.res.Resources$Theme r6 = r4.getTheme()
            r6.setTo(r5)
            goto L_0x006a
        L_0x0068:
            android.content.Context r4 = r7.f584b
        L_0x006a:
            androidx.appcompat.widget.ActionBarContextView r5 = new androidx.appcompat.widget.ActionBarContextView
            r5.<init>(r4)
            r7.f590h = r5
            android.widget.PopupWindow r5 = new android.widget.PopupWindow
            int r6 = androidx.appcompat.R.attr.actionModePopupWindowStyle
            r5.<init>(r4, r1, r6)
            r7.f591i = r5
            r6 = 2
            androidx.core.widget.h.a((android.widget.PopupWindow) r5, (int) r6)
            android.widget.PopupWindow r5 = r7.f591i
            androidx.appcompat.widget.ActionBarContextView r6 = r7.f590h
            r5.setContentView(r6)
            android.widget.PopupWindow r5 = r7.f591i
            r6 = -1
            r5.setWidth(r6)
            android.content.res.Resources$Theme r5 = r4.getTheme()
            int r6 = androidx.appcompat.R.attr.actionBarSize
            r5.resolveAttribute(r6, r0, r3)
            int r0 = r0.data
            android.content.res.Resources r4 = r4.getResources()
            android.util.DisplayMetrics r4 = r4.getDisplayMetrics()
            int r0 = android.util.TypedValue.complexToDimensionPixelSize(r0, r4)
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f590h
            r4.setContentHeight(r0)
            android.widget.PopupWindow r0 = r7.f591i
            r4 = -2
            r0.setHeight(r4)
            androidx.appcompat.app.AppCompatDelegateImpl$6 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$6
            r0.<init>()
            r7.f592j = r0
            goto L_0x00d4
        L_0x00b5:
            android.view.ViewGroup r0 = r7.f594l
            int r4 = androidx.appcompat.R.id.action_mode_bar_stub
            android.view.View r0 = r0.findViewById(r4)
            androidx.appcompat.widget.ViewStubCompat r0 = (androidx.appcompat.widget.ViewStubCompat) r0
            if (r0 == 0) goto L_0x00d4
            android.content.Context r4 = r7.n()
            android.view.LayoutInflater r4 = android.view.LayoutInflater.from(r4)
            r0.setLayoutInflater(r4)
            android.view.View r0 = r0.a()
            androidx.appcompat.widget.ActionBarContextView r0 = (androidx.appcompat.widget.ActionBarContextView) r0
            r7.f590h = r0
        L_0x00d4:
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f590h
            if (r0 == 0) goto L_0x0162
            r7.r()
            androidx.appcompat.widget.ActionBarContextView r0 = r7.f590h
            r0.c()
            f.e r0 = new f.e
            androidx.appcompat.widget.ActionBarContextView r4 = r7.f590h
            android.content.Context r4 = r4.getContext()
            androidx.appcompat.widget.ActionBarContextView r5 = r7.f590h
            android.widget.PopupWindow r6 = r7.f591i
            if (r6 != 0) goto L_0x00ef
            goto L_0x00f0
        L_0x00ef:
            r3 = 0
        L_0x00f0:
            r0.<init>(r4, r5, r8, r3)
            android.view.Menu r3 = r0.b()
            boolean r8 = r8.a((f.b) r0, (android.view.Menu) r3)
            if (r8 == 0) goto L_0x0160
            r0.d()
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f590h
            r8.a(r0)
            r7.f589g = r0
            boolean r8 = r7.p()
            r0 = 1065353216(0x3f800000, float:1.0)
            if (r8 == 0) goto L_0x012a
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f590h
            r1 = 0
            r8.setAlpha(r1)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f590h
            t.ag r8 = t.ac.r(r8)
            t.ag r8 = r8.a((float) r0)
            r7.f593k = r8
            androidx.appcompat.app.AppCompatDelegateImpl$7 r0 = new androidx.appcompat.app.AppCompatDelegateImpl$7
            r0.<init>()
            r8.a((t.ah) r0)
            goto L_0x0150
        L_0x012a:
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f590h
            r8.setAlpha(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f590h
            r8.setVisibility(r2)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f590h
            r0 = 32
            r8.sendAccessibilityEvent(r0)
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f590h
            android.view.ViewParent r8 = r8.getParent()
            boolean r8 = r8 instanceof android.view.View
            if (r8 == 0) goto L_0x0150
            androidx.appcompat.widget.ActionBarContextView r8 = r7.f590h
            android.view.ViewParent r8 = r8.getParent()
            android.view.View r8 = (android.view.View) r8
            t.ac.w(r8)
        L_0x0150:
            android.widget.PopupWindow r8 = r7.f591i
            if (r8 == 0) goto L_0x0162
            android.view.Window r8 = r7.f585c
            android.view.View r8 = r8.getDecorView()
            java.lang.Runnable r0 = r7.f592j
            r8.post(r0)
            goto L_0x0162
        L_0x0160:
            r7.f589g = r1
        L_0x0162:
            f.b r8 = r7.f589g
            if (r8 == 0) goto L_0x016d
            androidx.appcompat.app.c r0 = r7.f586d
            if (r0 == 0) goto L_0x016d
            r0.onSupportActionModeStarted(r8)
        L_0x016d:
            f.b r8 = r7.f589g
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.b(f.b$a):f.b");
    }

    public void b(Bundle bundle) {
        y();
    }

    public void b(View view, ViewGroup.LayoutParams layoutParams) {
        y();
        ((ViewGroup) this.f594l.findViewById(16908290)).addView(view, layoutParams);
        this.A.a().onContentChanged();
    }

    /* access modifiers changed from: package-private */
    public void b(androidx.appcompat.view.menu.g gVar) {
        if (!this.L) {
            this.L = true;
            this.C.k();
            Window.Callback m2 = m();
            if (m2 != null && !this.f600r) {
                m2.onPanelClosed(108, gVar);
            }
            this.L = false;
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            boolean z2 = this.O;
            this.O = false;
            PanelFeatureState a2 = a(0, false);
            if (a2 != null && a2.f625o) {
                if (!z2) {
                    a(a2, true);
                }
                return true;
            } else if (s()) {
                return true;
            }
        } else if (i2 == 82) {
            e(0, keyEvent);
            return true;
        }
        return false;
    }

    public void c() {
        this.R = true;
        u();
    }

    public void c(int i2) {
        y();
        ViewGroup viewGroup = (ViewGroup) this.f594l.findViewById(16908290);
        viewGroup.removeAllViews();
        LayoutInflater.from(this.f584b).inflate(i2, viewGroup);
        this.A.a().onContentChanged();
    }

    public void c(Bundle bundle) {
    }

    /* access modifiers changed from: package-private */
    public boolean c(int i2, KeyEvent keyEvent) {
        boolean z2 = true;
        if (i2 == 4) {
            if ((keyEvent.getFlags() & 128) == 0) {
                z2 = false;
            }
            this.O = z2;
        } else if (i2 == 82) {
            d(0, keyEvent);
            return true;
        }
        return false;
    }

    public void d() {
        this.R = false;
        ActionBar a2 = a();
        if (a2 != null) {
            a2.d(false);
        }
    }

    public boolean d(int i2) {
        int j2 = j(i2);
        if (this.f599q && j2 == 108) {
            return false;
        }
        if (this.f595m && j2 == 1) {
            this.f595m = false;
        }
        if (j2 == 1) {
            C();
            this.f599q = true;
            return true;
        } else if (j2 == 2) {
            C();
            this.J = true;
            return true;
        } else if (j2 == 5) {
            C();
            this.K = true;
            return true;
        } else if (j2 == 10) {
            C();
            this.f597o = true;
            return true;
        } else if (j2 == 108) {
            C();
            this.f595m = true;
            return true;
        } else if (j2 != 109) {
            return this.f585c.requestFeature(j2);
        } else {
            C();
            this.f596n = true;
            return true;
        }
    }

    public void e() {
        ActionBar a2 = a();
        if (a2 != null) {
            a2.d(true);
        }
    }

    /* access modifiers changed from: package-private */
    public void e(int i2) {
        if (i2 == 108) {
            ActionBar a2 = a();
            if (a2 != null) {
                a2.e(false);
            }
        } else if (i2 == 0) {
            PanelFeatureState a3 = a(i2, true);
            if (a3.f625o) {
                a(a3, false);
            }
        }
    }

    public void f() {
        ActionBar a2 = a();
        if (a2 == null || !a2.g()) {
            i(0);
        }
    }

    /* access modifiers changed from: package-private */
    public void f(int i2) {
        ActionBar a2;
        if (i2 == 108 && (a2 = a()) != null) {
            a2.e(true);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x005b  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void g() {
        /*
            r3 = this;
            java.lang.Object r0 = r3.f579a
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x0009
            b((androidx.appcompat.app.d) r3)
        L_0x0009:
            boolean r0 = r3.f601s
            if (r0 == 0) goto L_0x0018
            android.view.Window r0 = r3.f585c
            android.view.View r0 = r0.getDecorView()
            java.lang.Runnable r1 = r3.Y
            r0.removeCallbacks(r1)
        L_0x0018:
            r0 = 0
            r3.R = r0
            r0 = 1
            r3.f600r = r0
            int r0 = r3.S
            r1 = -100
            if (r0 == r1) goto L_0x0048
            java.lang.Object r0 = r3.f579a
            boolean r1 = r0 instanceof android.app.Activity
            if (r1 == 0) goto L_0x0048
            android.app.Activity r0 = (android.app.Activity) r0
            boolean r0 = r0.isChangingConfigurations()
            if (r0 == 0) goto L_0x0048
            j.g<java.lang.String, java.lang.Integer> r0 = f573u
            java.lang.Object r1 = r3.f579a
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            int r2 = r3.S
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.put(r1, r2)
            goto L_0x0057
        L_0x0048:
            j.g<java.lang.String, java.lang.Integer> r0 = f573u
            java.lang.Object r1 = r3.f579a
            java.lang.Class r1 = r1.getClass()
            java.lang.String r1 = r1.getName()
            r0.remove(r1)
        L_0x0057:
            androidx.appcompat.app.ActionBar r0 = r3.f587e
            if (r0 == 0) goto L_0x005e
            r0.i()
        L_0x005e:
            r3.w()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.g():void");
    }

    /* access modifiers changed from: package-private */
    public void g(int i2) {
        a(a(i2, true), true);
    }

    public final a.C0017a h() {
        return new a();
    }

    /* access modifiers changed from: package-private */
    public void h(int i2) {
        PanelFeatureState a2;
        PanelFeatureState a3 = a(i2, true);
        if (a3.f620j != null) {
            Bundle bundle = new Bundle();
            a3.f620j.c(bundle);
            if (bundle.size() > 0) {
                a3.f629s = bundle;
            }
            a3.f620j.h();
            a3.f620j.clear();
        }
        a3.f628r = true;
        a3.f627q = true;
        if ((i2 == 108 || i2 == 0) && this.C != null && (a2 = a(0, false)) != null) {
            a2.f623m = false;
            b(a2, (KeyEvent) null);
        }
    }

    public void i() {
        LayoutInflater from = LayoutInflater.from(this.f584b);
        if (from.getFactory() == null) {
            t.h.a(from, (LayoutInflater.Factory2) this);
        } else if (!(from.getFactory2() instanceof AppCompatDelegateImpl)) {
            Log.i("AppCompatDelegate", "The Activity's LayoutInflater already has a Factory installed so we can not install AppCompat's");
        }
    }

    public int j() {
        return this.S;
    }

    /* access modifiers changed from: package-private */
    public final ActionBar l() {
        return this.f587e;
    }

    /* access modifiers changed from: package-private */
    public final Window.Callback m() {
        return this.f585c.getCallback();
    }

    /* access modifiers changed from: package-private */
    public final Context n() {
        ActionBar a2 = a();
        Context d2 = a2 != null ? a2.d() : null;
        return d2 == null ? this.f584b : d2;
    }

    /* access modifiers changed from: package-private */
    public final CharSequence o() {
        Object obj = this.f579a;
        return obj instanceof Activity ? ((Activity) obj).getTitle() : this.B;
    }

    public final View onCreateView(View view, String str, Context context, AttributeSet attributeSet) {
        return a(view, str, context, attributeSet);
    }

    public View onCreateView(String str, Context context, AttributeSet attributeSet) {
        return onCreateView((View) null, str, context, attributeSet);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f594l;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean p() {
        /*
            r1 = this;
            boolean r0 = r1.G
            if (r0 == 0) goto L_0x0010
            android.view.ViewGroup r0 = r1.f594l
            if (r0 == 0) goto L_0x0010
            boolean r0 = t.ac.G(r0)
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.app.AppCompatDelegateImpl.p():boolean");
    }

    public boolean q() {
        return this.F;
    }

    /* access modifiers changed from: package-private */
    public void r() {
        ag agVar = this.f593k;
        if (agVar != null) {
            agVar.b();
        }
    }

    /* access modifiers changed from: package-private */
    public boolean s() {
        f.b bVar = this.f589g;
        if (bVar != null) {
            bVar.c();
            return true;
        }
        ActionBar a2 = a();
        return a2 != null && a2.h();
    }

    /* access modifiers changed from: package-private */
    public void t() {
        o oVar = this.C;
        if (oVar != null) {
            oVar.k();
        }
        if (this.f591i != null) {
            this.f585c.getDecorView().removeCallbacks(this.f592j);
            if (this.f591i.isShowing()) {
                try {
                    this.f591i.dismiss();
                } catch (IllegalArgumentException unused) {
                }
            }
            this.f591i = null;
        }
        r();
        PanelFeatureState a2 = a(0, false);
        if (a2 != null && a2.f620j != null) {
            a2.f620j.close();
        }
    }

    public boolean u() {
        return b(true);
    }
}
