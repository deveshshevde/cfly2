package com.xeagle.android.widgets.menu;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.fragment.app.c;
import com.cfly.uav_pro.R;
import java.util.ArrayList;

public class b extends c implements e, f {

    /* renamed from: a  reason: collision with root package name */
    private static final String f25931a = "b";

    /* renamed from: b  reason: collision with root package name */
    private LinearLayout f25932b;

    /* renamed from: c  reason: collision with root package name */
    private LinearLayout f25933c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public d f25934d;

    /* renamed from: e  reason: collision with root package name */
    private ArrayList<MenuObject> f25935e;

    /* renamed from: f  reason: collision with root package name */
    private int f25936f;

    /* renamed from: g  reason: collision with root package name */
    private g f25937g;

    /* renamed from: h  reason: collision with root package name */
    private h f25938h;

    /* renamed from: i  reason: collision with root package name */
    private int f25939i = 0;

    /* renamed from: j  reason: collision with root package name */
    private int f25940j;

    private void a() {
        d dVar = new d(getActivity(), this.f25932b, this.f25933c, this.f25935e, this.f25936f);
        this.f25934d = dVar;
        dVar.a((e) this);
        this.f25934d.a((f) this);
        this.f25934d.a(this.f25940j);
    }

    private void b() {
        new Handler().postDelayed(new Runnable() {
            public void run() {
                b.this.dismiss();
            }
        }, (long) this.f25939i);
    }

    private void c(View view) {
        this.f25932b = (LinearLayout) view.findViewById(R.id.wrapper_buttons);
        this.f25933c = (LinearLayout) view.findViewById(R.id.wrapper_text);
    }

    public void a(View view) {
        g gVar = this.f25937g;
        if (gVar != null) {
            gVar.a(view, this.f25932b.indexOfChild(view));
        }
        b();
    }

    public void b(View view) {
        h hVar = this.f25938h;
        if (hVar != null) {
            hVar.a(view, this.f25932b.indexOfChild(view));
        }
        b();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            this.f25937g = (g) activity;
        } catch (ClassCastException unused) {
            String str = f25931a;
            Log.e(str, activity.getClass().getSimpleName() + " should implement " + g.class.getSimpleName());
        }
        try {
            this.f25938h = (h) activity;
        } catch (ClassCastException unused2) {
            String str2 = f25931a;
            Log.e(str2, activity.getClass().getSimpleName() + " should implement " + h.class.getSimpleName());
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(2, R.style.MenuFragmentStyle);
        if (getArguments() != null) {
            this.f25936f = getArguments().getInt("action_bar_size");
            this.f25935e = getArguments().getParcelableArrayList("menu_objects");
            if (getArguments().containsKey("animation_delay")) {
                this.f25939i = getArguments().getInt("animation_delay");
            }
            this.f25940j = getArguments().containsKey("animation_duration") ? getArguments().getInt("animation_duration") : 100;
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_menu, viewGroup, false);
        c(inflate);
        getDialog().getWindow().clearFlags(2);
        a();
        new Handler().postDelayed(new Runnable() {
            public void run() {
                b.this.f25934d.b();
            }
        }, (long) this.f25939i);
        return inflate;
    }
}
