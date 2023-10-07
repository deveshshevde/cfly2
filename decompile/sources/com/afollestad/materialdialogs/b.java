package com.afollestad.materialdialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Typeface;
import android.graphics.drawable.ColorDrawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import androidx.recyclerview.widget.RecyclerView;
import ay.d;
import ay.e;
import com.afollestad.materialdialogs.internal.main.DialogLayout;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.h;
import kotlin.l;

public final class b extends Dialog {

    /* renamed from: a  reason: collision with root package name */
    public static final a f7500a = new a((f) null);

    /* renamed from: u  reason: collision with root package name */
    private static a f7501u = d.f7558a;

    /* renamed from: b  reason: collision with root package name */
    private final Map<String, Object> f7502b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f7503c;

    /* renamed from: d  reason: collision with root package name */
    private Typeface f7504d;

    /* renamed from: e  reason: collision with root package name */
    private Typeface f7505e;

    /* renamed from: f  reason: collision with root package name */
    private Typeface f7506f;

    /* renamed from: g  reason: collision with root package name */
    private boolean f7507g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f7508h;

    /* renamed from: i  reason: collision with root package name */
    private Float f7509i;

    /* renamed from: j  reason: collision with root package name */
    private Integer f7510j;

    /* renamed from: k  reason: collision with root package name */
    private final DialogLayout f7511k;

    /* renamed from: l  reason: collision with root package name */
    private final List<mm.b<b, l>> f7512l;

    /* renamed from: m  reason: collision with root package name */
    private final List<mm.b<b, l>> f7513m;

    /* renamed from: n  reason: collision with root package name */
    private final List<mm.b<b, l>> f7514n;

    /* renamed from: o  reason: collision with root package name */
    private final List<mm.b<b, l>> f7515o;

    /* renamed from: p  reason: collision with root package name */
    private final List<mm.b<b, l>> f7516p;

    /* renamed from: q  reason: collision with root package name */
    private final List<mm.b<b, l>> f7517q;

    /* renamed from: r  reason: collision with root package name */
    private final List<mm.b<b, l>> f7518r;

    /* renamed from: s  reason: collision with root package name */
    private final Context f7519s;

    /* renamed from: t  reason: collision with root package name */
    private final a f7520t;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public b(Context context, a aVar) {
        super(context, e.a(context, aVar));
        h.c(context, "windowContext");
        h.c(aVar, "dialogBehavior");
        this.f7519s = context;
        this.f7520t = aVar;
        this.f7502b = new LinkedHashMap();
        this.f7503c = true;
        this.f7507g = true;
        this.f7508h = true;
        this.f7512l = new ArrayList();
        this.f7513m = new ArrayList();
        this.f7514n = new ArrayList();
        this.f7515o = new ArrayList();
        this.f7516p = new ArrayList();
        this.f7517q = new ArrayList();
        this.f7518r = new ArrayList();
        LayoutInflater from = LayoutInflater.from(context);
        Window window = getWindow();
        if (window == null) {
            h.a();
        }
        h.a((Object) window, "window!!");
        h.a((Object) from, "layoutInflater");
        ViewGroup a2 = aVar.a(context, window, from, this);
        setContentView(a2);
        DialogLayout a3 = aVar.a(a2);
        a3.a(this);
        this.f7511k = a3;
        this.f7504d = d.a(this, (Integer) null, Integer.valueOf(R.attr.md_font_title), 1, (Object) null);
        this.f7505e = d.a(this, (Integer) null, Integer.valueOf(R.attr.md_font_body), 1, (Object) null);
        this.f7506f = d.a(this, (Integer) null, Integer.valueOf(R.attr.md_font_button), 1, (Object) null);
        f();
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ b(Context context, a aVar, int i2, f fVar) {
        this(context, (i2 & 2) != 0 ? f7501u : aVar);
    }

    public static /* synthetic */ b a(b bVar, Float f2, Integer num, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            f2 = null;
        }
        if ((i2 & 2) != 0) {
            num = null;
        }
        return bVar.a(f2, num);
    }

    public static /* synthetic */ b a(b bVar, Integer num, Integer num2, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            num = null;
        }
        if ((i2 & 2) != 0) {
            num2 = null;
        }
        return bVar.a(num, num2);
    }

    private final void e() {
        a aVar = this.f7520t;
        Context context = this.f7519s;
        Integer num = this.f7510j;
        Window window = getWindow();
        if (window == null) {
            h.a();
        }
        h.a((Object) window, "window!!");
        aVar.a(context, window, this.f7511k, num);
    }

    private final void f() {
        int a2 = ay.a.a(this, (Integer) null, Integer.valueOf(R.attr.md_background_color), new MaterialDialog$invalidateBackgroundColorAndRadius$backgroundColor$1(this), 1, (Object) null);
        Window window = getWindow();
        if (window != null) {
            window.setBackgroundDrawable(new ColorDrawable(0));
        }
        a aVar = this.f7520t;
        DialogLayout dialogLayout = this.f7511k;
        Float f2 = this.f7509i;
        aVar.a(dialogLayout, a2, f2 != null ? f2.floatValue() : e.f5573a.a(this.f7519s, R.attr.md_corner_radius, (mm.a<Float>) new MaterialDialog$invalidateBackgroundColorAndRadius$1(this)));
    }

    public final b a(Float f2, Integer num) {
        float applyDimension;
        b bVar = this;
        e.f5573a.a("cornerRadius", (Object) f2, num);
        if (num != null) {
            applyDimension = bVar.f7519s.getResources().getDimension(num.intValue());
        } else {
            Resources resources = bVar.f7519s.getResources();
            h.a((Object) resources, "windowContext.resources");
            DisplayMetrics displayMetrics = resources.getDisplayMetrics();
            if (f2 == null) {
                h.a();
            }
            applyDimension = TypedValue.applyDimension(1, f2.floatValue(), displayMetrics);
        }
        bVar.f7509i = Float.valueOf(applyDimension);
        bVar.f();
        return bVar;
    }

    public final b a(Integer num, Integer num2) {
        b bVar = this;
        e.f5573a.a("maxWidth", (Object) num, num2);
        Integer num3 = bVar.f7510j;
        boolean z2 = (num3 == null || num3 == null || num3.intValue() != 0) ? false : true;
        if (num != null) {
            num2 = Integer.valueOf(bVar.f7519s.getResources().getDimensionPixelSize(num.intValue()));
        } else if (num2 == null) {
            h.a();
        }
        bVar.f7510j = num2;
        if (z2) {
            bVar.e();
        }
        return bVar;
    }

    public final b a(boolean z2) {
        b bVar = this;
        bVar.setCancelable(z2);
        return bVar;
    }

    public final Map<String, Object> a() {
        return this.f7502b;
    }

    public final void a(WhichButton whichButton) {
        List<mm.b<b, l>> list;
        h.c(whichButton, "which");
        int i2 = c.f7523a[whichButton.ordinal()];
        if (i2 != 1) {
            if (i2 == 2) {
                list = this.f7517q;
            } else if (i2 == 3) {
                list = this.f7518r;
            }
            au.a.a(list, this);
        } else {
            au.a.a(this.f7516p, this);
            RecyclerView.Adapter<?> a2 = ax.a.a(this);
            if (!(a2 instanceof com.afollestad.materialdialogs.internal.list.a)) {
                a2 = null;
            }
            com.afollestad.materialdialogs.internal.list.a aVar = (com.afollestad.materialdialogs.internal.list.a) a2;
            if (aVar != null) {
                aVar.a();
            }
        }
        if (this.f7503c) {
            dismiss();
        }
    }

    public final b b(boolean z2) {
        b bVar = this;
        bVar.setCanceledOnTouchOutside(z2);
        return bVar;
    }

    public final DialogLayout b() {
        return this.f7511k;
    }

    public final List<mm.b<b, l>> c() {
        return this.f7512l;
    }

    public final Context d() {
        return this.f7519s;
    }

    public void dismiss() {
        if (!this.f7520t.a()) {
            ay.b.b(this);
            super.dismiss();
        }
    }

    public void setCancelable(boolean z2) {
        this.f7508h = z2;
        super.setCancelable(z2);
    }

    public void setCanceledOnTouchOutside(boolean z2) {
        this.f7507g = z2;
        super.setCanceledOnTouchOutside(z2);
    }

    public void show() {
        e();
        ay.b.a(this);
        this.f7520t.a(this);
        super.show();
        this.f7520t.b(this);
    }
}
