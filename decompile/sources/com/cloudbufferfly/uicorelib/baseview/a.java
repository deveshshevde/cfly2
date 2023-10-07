package com.cloudbufferfly.uicorelib.baseview;

import android.content.Context;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.analytics.ecommerce.Promotion;
import kotlin.jvm.internal.h;
import kotlin.text.f;
import t.i;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f10694a = new a();

    /* renamed from: com.cloudbufferfly.uicorelib.baseview.a$a  reason: collision with other inner class name */
    static final class C0083a implements i {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ LayoutInflater f10695a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ j f10696b;

        C0083a(LayoutInflater layoutInflater, j jVar) {
            this.f10695a = layoutInflater;
            this.f10696b = jVar;
        }

        public final View a(View view, String str, Context context, AttributeSet attributeSet) {
            Context baseContext = context instanceof ContextThemeWrapper ? ((ContextThemeWrapper) context).getBaseContext() : context;
            if (!(baseContext instanceof AppCompatActivity)) {
                return null;
            }
            View a2 = ((AppCompatActivity) baseContext).getDelegate().a(view, str, context, attributeSet);
            if (a2 == null) {
                h.a((Object) str, "name");
                if (-1 != f.a((CharSequence) str, (char) 46, 0, false, 6, (Object) null)) {
                    try {
                        a2 = this.f10695a.createView(str, (String) null, attributeSet);
                    } catch (Exception unused) {
                    }
                    if (a2 != null && (a2 instanceof i)) {
                        this.f10696b.a(((i) a2).getLifecycleDelegate());
                    }
                }
            }
            return a2;
        }
    }

    private a() {
    }

    public final SupportActivity a(View view) {
        Context baseContext;
        h.c(view, Promotion.ACTION_VIEW);
        Context context = view.getContext();
        if (context instanceof SupportActivity) {
            return (SupportActivity) context;
        }
        if (!(context instanceof ContextThemeWrapper) || (baseContext = ((ContextThemeWrapper) context).getBaseContext()) == null || !(baseContext instanceof SupportActivity)) {
            return null;
        }
        return (SupportActivity) baseContext;
    }

    public final void a(LayoutInflater layoutInflater, j jVar) {
        h.c(layoutInflater, "inflater");
        h.c(jVar, "register");
        t.h.a(layoutInflater, (i) new C0083a(layoutInflater, jVar));
    }
}
