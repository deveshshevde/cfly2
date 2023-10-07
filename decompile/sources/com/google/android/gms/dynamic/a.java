package com.google.android.gms.dynamic;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.dynamic.c;
import java.util.LinkedList;

public abstract class a<T extends c> {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public T f17988a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public Bundle f17989b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public LinkedList<m> f17990c;

    /* renamed from: d  reason: collision with root package name */
    private final e<T> f17991d = new f(this);

    private final void a(int i2) {
        while (!this.f17990c.isEmpty() && this.f17990c.getLast().a() >= i2) {
            this.f17990c.removeLast();
        }
    }

    private final void a(Bundle bundle, m mVar) {
        T t2 = this.f17988a;
        if (t2 != null) {
            mVar.a(t2);
            return;
        }
        if (this.f17990c == null) {
            this.f17990c = new LinkedList<>();
        }
        this.f17990c.add(mVar);
        if (bundle != null) {
            Bundle bundle2 = this.f17989b;
            if (bundle2 == null) {
                this.f17989b = (Bundle) bundle.clone();
            } else {
                bundle2.putAll(bundle);
            }
        }
        a(this.f17991d);
    }

    public static void b(FrameLayout frameLayout) {
        com.google.android.gms.common.c a2 = com.google.android.gms.common.c.a();
        Context context = frameLayout.getContext();
        int a3 = a2.a(context);
        String b2 = w.b(context, a3);
        String a4 = w.a(context, a3);
        LinearLayout linearLayout = new LinearLayout(frameLayout.getContext());
        linearLayout.setOrientation(1);
        linearLayout.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        frameLayout.addView(linearLayout);
        TextView textView = new TextView(frameLayout.getContext());
        textView.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
        textView.setText(b2);
        linearLayout.addView(textView);
        Intent a5 = a2.a(context, a3, (String) null);
        if (a5 != null) {
            Button button = new Button(context);
            button.setId(16908313);
            button.setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            button.setText(a4);
            linearLayout.addView(button);
            button.setOnClickListener(new j(context, a5));
        }
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FrameLayout frameLayout = new FrameLayout(layoutInflater.getContext());
        a(bundle, (m) new i(this, frameLayout, layoutInflater, viewGroup, bundle));
        if (this.f17988a == null) {
            a(frameLayout);
        }
        return frameLayout;
    }

    public T a() {
        return this.f17988a;
    }

    public void a(Activity activity, Bundle bundle, Bundle bundle2) {
        a(bundle2, (m) new g(this, activity, bundle, bundle2));
    }

    public void a(Bundle bundle) {
        a(bundle, (m) new h(this, bundle));
    }

    /* access modifiers changed from: protected */
    public void a(FrameLayout frameLayout) {
        b(frameLayout);
    }

    /* access modifiers changed from: protected */
    public abstract void a(e<T> eVar);

    public void b() {
        T t2 = this.f17988a;
        if (t2 != null) {
            t2.a();
        } else {
            a(1);
        }
    }

    public void b(Bundle bundle) {
        T t2 = this.f17988a;
        if (t2 != null) {
            t2.b(bundle);
            return;
        }
        Bundle bundle2 = this.f17989b;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }

    public void c() {
        T t2 = this.f17988a;
        if (t2 != null) {
            t2.b();
        } else {
            a(2);
        }
    }

    public void d() {
        T t2 = this.f17988a;
        if (t2 != null) {
            t2.c();
        }
    }

    public void e() {
        T t2 = this.f17988a;
        if (t2 != null) {
            t2.d();
        } else {
            a(5);
        }
    }

    public void f() {
        a((Bundle) null, (m) new l(this));
    }

    public void g() {
        a((Bundle) null, (m) new k(this));
    }

    public void h() {
        T t2 = this.f17988a;
        if (t2 != null) {
            t2.g();
        } else {
            a(4);
        }
    }
}
