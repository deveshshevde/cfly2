package f;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.PorterDuff;
import android.util.AttributeSet;
import android.util.Log;
import android.util.Xml;
import android.view.InflateException;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.SubMenu;
import android.view.View;
import androidx.appcompat.R;
import androidx.appcompat.view.menu.i;
import androidx.appcompat.view.menu.j;
import androidx.appcompat.widget.af;
import androidx.appcompat.widget.q;
import java.io.IOException;
import java.lang.reflect.Constructor;
import java.lang.reflect.Method;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;
import t.k;

public class g extends MenuInflater {

    /* renamed from: a  reason: collision with root package name */
    static final Class<?>[] f27030a;

    /* renamed from: b  reason: collision with root package name */
    static final Class<?>[] f27031b;

    /* renamed from: c  reason: collision with root package name */
    final Object[] f27032c;

    /* renamed from: d  reason: collision with root package name */
    final Object[] f27033d;

    /* renamed from: e  reason: collision with root package name */
    Context f27034e;

    /* renamed from: f  reason: collision with root package name */
    private Object f27035f;

    private static class a implements MenuItem.OnMenuItemClickListener {

        /* renamed from: a  reason: collision with root package name */
        private static final Class<?>[] f27036a = {MenuItem.class};

        /* renamed from: b  reason: collision with root package name */
        private Object f27037b;

        /* renamed from: c  reason: collision with root package name */
        private Method f27038c;

        public a(Object obj, String str) {
            this.f27037b = obj;
            Class<?> cls = obj.getClass();
            try {
                this.f27038c = cls.getMethod(str, f27036a);
            } catch (Exception e2) {
                InflateException inflateException = new InflateException("Couldn't resolve menu item onClick handler " + str + " in class " + cls.getName());
                inflateException.initCause(e2);
                throw inflateException;
            }
        }

        public boolean onMenuItemClick(MenuItem menuItem) {
            try {
                if (this.f27038c.getReturnType() == Boolean.TYPE) {
                    return ((Boolean) this.f27038c.invoke(this.f27037b, new Object[]{menuItem})).booleanValue();
                }
                this.f27038c.invoke(this.f27037b, new Object[]{menuItem});
                return true;
            } catch (Exception e2) {
                throw new RuntimeException(e2);
            }
        }
    }

    private class b {
        private String A;
        private String B;
        private CharSequence C;
        private CharSequence D;
        private ColorStateList E = null;
        private PorterDuff.Mode F = null;

        /* renamed from: a  reason: collision with root package name */
        t.b f27039a;

        /* renamed from: c  reason: collision with root package name */
        private Menu f27041c;

        /* renamed from: d  reason: collision with root package name */
        private int f27042d;

        /* renamed from: e  reason: collision with root package name */
        private int f27043e;

        /* renamed from: f  reason: collision with root package name */
        private int f27044f;

        /* renamed from: g  reason: collision with root package name */
        private int f27045g;

        /* renamed from: h  reason: collision with root package name */
        private boolean f27046h;

        /* renamed from: i  reason: collision with root package name */
        private boolean f27047i;

        /* renamed from: j  reason: collision with root package name */
        private boolean f27048j;

        /* renamed from: k  reason: collision with root package name */
        private int f27049k;

        /* renamed from: l  reason: collision with root package name */
        private int f27050l;

        /* renamed from: m  reason: collision with root package name */
        private CharSequence f27051m;

        /* renamed from: n  reason: collision with root package name */
        private CharSequence f27052n;

        /* renamed from: o  reason: collision with root package name */
        private int f27053o;

        /* renamed from: p  reason: collision with root package name */
        private char f27054p;

        /* renamed from: q  reason: collision with root package name */
        private int f27055q;

        /* renamed from: r  reason: collision with root package name */
        private char f27056r;

        /* renamed from: s  reason: collision with root package name */
        private int f27057s;

        /* renamed from: t  reason: collision with root package name */
        private int f27058t;

        /* renamed from: u  reason: collision with root package name */
        private boolean f27059u;

        /* renamed from: v  reason: collision with root package name */
        private boolean f27060v;

        /* renamed from: w  reason: collision with root package name */
        private boolean f27061w;

        /* renamed from: x  reason: collision with root package name */
        private int f27062x;

        /* renamed from: y  reason: collision with root package name */
        private int f27063y;

        /* renamed from: z  reason: collision with root package name */
        private String f27064z;

        public b(Menu menu) {
            this.f27041c = menu;
            a();
        }

        private char a(String str) {
            if (str == null) {
                return 0;
            }
            return str.charAt(0);
        }

        private <T> T a(String str, Class<?>[] clsArr, Object[] objArr) {
            try {
                Constructor<?> constructor = Class.forName(str, false, g.this.f27034e.getClassLoader()).getConstructor(clsArr);
                constructor.setAccessible(true);
                return constructor.newInstance(objArr);
            } catch (Exception e2) {
                Log.w("SupportMenuInflater", "Cannot instantiate class: " + str, e2);
                return null;
            }
        }

        private void a(MenuItem menuItem) {
            boolean z2 = false;
            menuItem.setChecked(this.f27059u).setVisible(this.f27060v).setEnabled(this.f27061w).setCheckable(this.f27058t >= 1).setTitleCondensed(this.f27052n).setIcon(this.f27053o);
            int i2 = this.f27062x;
            if (i2 >= 0) {
                menuItem.setShowAsAction(i2);
            }
            if (this.B != null) {
                if (!g.this.f27034e.isRestricted()) {
                    menuItem.setOnMenuItemClickListener(new a(g.this.a(), this.B));
                } else {
                    throw new IllegalStateException("The android:onClick attribute cannot be used within a restricted context");
                }
            }
            if (this.f27058t >= 2) {
                if (menuItem instanceof i) {
                    ((i) menuItem).a(true);
                } else if (menuItem instanceof j) {
                    ((j) menuItem).a(true);
                }
            }
            String str = this.f27064z;
            if (str != null) {
                menuItem.setActionView((View) a(str, g.f27030a, g.this.f27032c));
                z2 = true;
            }
            int i3 = this.f27063y;
            if (i3 > 0) {
                if (!z2) {
                    menuItem.setActionView(i3);
                } else {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'itemActionViewLayout'. Action view already specified.");
                }
            }
            t.b bVar = this.f27039a;
            if (bVar != null) {
                k.a(menuItem, bVar);
            }
            k.a(menuItem, this.C);
            k.b(menuItem, this.D);
            k.b(menuItem, this.f27054p, this.f27055q);
            k.a(menuItem, this.f27056r, this.f27057s);
            PorterDuff.Mode mode = this.F;
            if (mode != null) {
                k.a(menuItem, mode);
            }
            ColorStateList colorStateList = this.E;
            if (colorStateList != null) {
                k.a(menuItem, colorStateList);
            }
        }

        public void a() {
            this.f27042d = 0;
            this.f27043e = 0;
            this.f27044f = 0;
            this.f27045g = 0;
            this.f27046h = true;
            this.f27047i = true;
        }

        public void a(AttributeSet attributeSet) {
            TypedArray obtainStyledAttributes = g.this.f27034e.obtainStyledAttributes(attributeSet, R.styleable.MenuGroup);
            this.f27042d = obtainStyledAttributes.getResourceId(R.styleable.MenuGroup_android_id, 0);
            this.f27043e = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_menuCategory, 0);
            this.f27044f = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_orderInCategory, 0);
            this.f27045g = obtainStyledAttributes.getInt(R.styleable.MenuGroup_android_checkableBehavior, 0);
            this.f27046h = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_visible, true);
            this.f27047i = obtainStyledAttributes.getBoolean(R.styleable.MenuGroup_android_enabled, true);
            obtainStyledAttributes.recycle();
        }

        public void b() {
            this.f27048j = true;
            a(this.f27041c.add(this.f27042d, this.f27049k, this.f27050l, this.f27051m));
        }

        public void b(AttributeSet attributeSet) {
            af a2 = af.a(g.this.f27034e, attributeSet, R.styleable.MenuItem);
            this.f27049k = a2.g(R.styleable.MenuItem_android_id, 0);
            this.f27050l = (a2.a(R.styleable.MenuItem_android_menuCategory, this.f27043e) & -65536) | (a2.a(R.styleable.MenuItem_android_orderInCategory, this.f27044f) & 65535);
            this.f27051m = a2.c(R.styleable.MenuItem_android_title);
            this.f27052n = a2.c(R.styleable.MenuItem_android_titleCondensed);
            this.f27053o = a2.g(R.styleable.MenuItem_android_icon, 0);
            this.f27054p = a(a2.d(R.styleable.MenuItem_android_alphabeticShortcut));
            this.f27055q = a2.a(R.styleable.MenuItem_alphabeticModifiers, 4096);
            this.f27056r = a(a2.d(R.styleable.MenuItem_android_numericShortcut));
            this.f27057s = a2.a(R.styleable.MenuItem_numericModifiers, 4096);
            this.f27058t = a2.g(R.styleable.MenuItem_android_checkable) ? a2.a(R.styleable.MenuItem_android_checkable, false) : this.f27045g;
            this.f27059u = a2.a(R.styleable.MenuItem_android_checked, false);
            this.f27060v = a2.a(R.styleable.MenuItem_android_visible, this.f27046h);
            this.f27061w = a2.a(R.styleable.MenuItem_android_enabled, this.f27047i);
            this.f27062x = a2.a(R.styleable.MenuItem_showAsAction, -1);
            this.B = a2.d(R.styleable.MenuItem_android_onClick);
            this.f27063y = a2.g(R.styleable.MenuItem_actionLayout, 0);
            this.f27064z = a2.d(R.styleable.MenuItem_actionViewClass);
            String d2 = a2.d(R.styleable.MenuItem_actionProviderClass);
            this.A = d2;
            boolean z2 = d2 != null;
            if (z2 && this.f27063y == 0 && this.f27064z == null) {
                this.f27039a = (t.b) a(d2, g.f27031b, g.this.f27033d);
            } else {
                if (z2) {
                    Log.w("SupportMenuInflater", "Ignoring attribute 'actionProviderClass'. Action view already specified.");
                }
                this.f27039a = null;
            }
            this.C = a2.c(R.styleable.MenuItem_contentDescription);
            this.D = a2.c(R.styleable.MenuItem_tooltipText);
            if (a2.g(R.styleable.MenuItem_iconTintMode)) {
                this.F = q.a(a2.a(R.styleable.MenuItem_iconTintMode, -1), this.F);
            } else {
                this.F = null;
            }
            if (a2.g(R.styleable.MenuItem_iconTint)) {
                this.E = a2.e(R.styleable.MenuItem_iconTint);
            } else {
                this.E = null;
            }
            a2.b();
            this.f27048j = false;
        }

        public SubMenu c() {
            this.f27048j = true;
            SubMenu addSubMenu = this.f27041c.addSubMenu(this.f27042d, this.f27049k, this.f27050l, this.f27051m);
            a(addSubMenu.getItem());
            return addSubMenu;
        }

        public boolean d() {
            return this.f27048j;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v1, resolved type: java.lang.Class<?>[]} */
    /* JADX WARNING: Multi-variable type inference failed */
    static {
        /*
            r0 = 1
            java.lang.Class[] r0 = new java.lang.Class[r0]
            r1 = 0
            java.lang.Class<android.content.Context> r2 = android.content.Context.class
            r0[r1] = r2
            f27030a = r0
            f27031b = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: f.g.<clinit>():void");
    }

    public g(Context context) {
        super(context);
        this.f27034e = context;
        Object[] objArr = {context};
        this.f27032c = objArr;
        this.f27033d = objArr;
    }

    private Object a(Object obj) {
        return (!(obj instanceof Activity) && (obj instanceof ContextWrapper)) ? a(((ContextWrapper) obj).getBaseContext()) : obj;
    }

    private void a(XmlPullParser xmlPullParser, AttributeSet attributeSet, Menu menu) throws XmlPullParserException, IOException {
        b bVar = new b(menu);
        int eventType = xmlPullParser.getEventType();
        while (true) {
            if (eventType != 2) {
                eventType = xmlPullParser.next();
                if (eventType == 1) {
                    break;
                }
            } else {
                String name = xmlPullParser.getName();
                if (name.equals("menu")) {
                    eventType = xmlPullParser.next();
                } else {
                    throw new RuntimeException("Expecting menu, got " + name);
                }
            }
        }
        String str = null;
        boolean z2 = false;
        boolean z3 = false;
        while (!z2) {
            if (eventType != 1) {
                if (eventType != 2) {
                    if (eventType == 3) {
                        String name2 = xmlPullParser.getName();
                        if (z3 && name2.equals(str)) {
                            str = null;
                            z3 = false;
                        } else if (name2.equals("group")) {
                            bVar.a();
                        } else if (name2.equals("item")) {
                            if (!bVar.d()) {
                                if (bVar.f27039a == null || !bVar.f27039a.c()) {
                                    bVar.b();
                                } else {
                                    bVar.c();
                                }
                            }
                        } else if (name2.equals("menu")) {
                            z2 = true;
                        }
                    }
                } else if (!z3) {
                    String name3 = xmlPullParser.getName();
                    if (name3.equals("group")) {
                        bVar.a(attributeSet);
                    } else if (name3.equals("item")) {
                        bVar.b(attributeSet);
                    } else if (name3.equals("menu")) {
                        a(xmlPullParser, attributeSet, bVar.c());
                    } else {
                        str = name3;
                        z3 = true;
                    }
                }
                eventType = xmlPullParser.next();
            } else {
                throw new RuntimeException("Unexpected end of document");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public Object a() {
        if (this.f27035f == null) {
            this.f27035f = a(this.f27034e);
        }
        return this.f27035f;
    }

    public void inflate(int i2, Menu menu) {
        if (!(menu instanceof n.a)) {
            super.inflate(i2, menu);
            return;
        }
        XmlResourceParser xmlResourceParser = null;
        try {
            xmlResourceParser = this.f27034e.getResources().getLayout(i2);
            a(xmlResourceParser, Xml.asAttributeSet(xmlResourceParser), menu);
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
        } catch (XmlPullParserException e2) {
            throw new InflateException("Error inflating menu XML", e2);
        } catch (IOException e3) {
            throw new InflateException("Error inflating menu XML", e3);
        } catch (Throwable th) {
            if (xmlResourceParser != null) {
                xmlResourceParser.close();
            }
            throw th;
        }
    }
}
