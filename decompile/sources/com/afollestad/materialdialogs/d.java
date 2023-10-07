package com.afollestad.materialdialogs;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import ay.e;
import ay.f;
import com.afollestad.materialdialogs.internal.button.DialogActionButton;
import com.afollestad.materialdialogs.internal.main.DialogLayout;
import com.google.android.gms.analytics.ecommerce.Promotion;
import kotlin.Pair;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;

public final class d implements a {

    /* renamed from: a  reason: collision with root package name */
    public static final d f7558a = new d();

    static final class a implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DialogActionButton f7559a;

        a(DialogActionButton dialogActionButton) {
            this.f7559a = dialogActionButton;
        }

        public final void run() {
            this.f7559a.requestFocus();
        }
    }

    static final class b implements Runnable {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ DialogActionButton f7560a;

        b(DialogActionButton dialogActionButton) {
            this.f7560a = dialogActionButton;
        }

        public final void run() {
            this.f7560a.requestFocus();
        }
    }

    private d() {
    }

    public int a(boolean z2) {
        return z2 ? R.style.MD_Dark : R.style.MD_Light;
    }

    public ViewGroup a(Context context, Window window, LayoutInflater layoutInflater, b bVar) {
        h.c(context, "creatingContext");
        h.c(window, "dialogWindow");
        h.c(layoutInflater, "layoutInflater");
        h.c(bVar, "dialog");
        View inflate = layoutInflater.inflate(R.layout.md_dialog_base, (ViewGroup) null, false);
        if (inflate != null) {
            return (ViewGroup) inflate;
        }
        throw new TypeCastException("null cannot be cast to non-null type android.view.ViewGroup");
    }

    public DialogLayout a(ViewGroup viewGroup) {
        h.c(viewGroup, "root");
        return (DialogLayout) viewGroup;
    }

    public void a(Context context, Window window, DialogLayout dialogLayout, Integer num) {
        h.c(context, "context");
        h.c(window, "window");
        h.c(dialogLayout, Promotion.ACTION_VIEW);
        if (num == null || num.intValue() != 0) {
            window.setSoftInputMode(16);
            WindowManager windowManager = window.getWindowManager();
            if (windowManager != null) {
                Resources resources = context.getResources();
                Pair<Integer, Integer> a2 = e.f5573a.a(windowManager);
                int intValue = a2.c().intValue();
                dialogLayout.setMaxHeight(a2.d().intValue() - (resources.getDimensionPixelSize(R.dimen.md_dialog_vertical_margin) * 2));
                WindowManager.LayoutParams layoutParams = new WindowManager.LayoutParams();
                layoutParams.copyFrom(window.getAttributes());
                layoutParams.width = Math.min(num != null ? num.intValue() : resources.getDimensionPixelSize(R.dimen.md_dialog_max_width), intValue - (resources.getDimensionPixelSize(R.dimen.md_dialog_horizontal_margin) * 2));
                window.setAttributes(layoutParams);
            }
        }
    }

    public void a(b bVar) {
        h.c(bVar, "dialog");
    }

    public void a(DialogLayout dialogLayout, int i2, float f2) {
        h.c(dialogLayout, Promotion.ACTION_VIEW);
        dialogLayout.setCornerRadii(new float[]{f2, f2, f2, f2, 0.0f, 0.0f, 0.0f, 0.0f});
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius(f2);
        gradientDrawable.setColor(i2);
        dialogLayout.setBackground(gradientDrawable);
    }

    public boolean a() {
        return false;
    }

    public void b(b bVar) {
        h.c(bVar, "dialog");
        DialogActionButton a2 = at.a.a(bVar, WhichButton.NEGATIVE);
        if (f.a(a2)) {
            a2.post(new a(a2));
            return;
        }
        DialogActionButton a3 = at.a.a(bVar, WhichButton.POSITIVE);
        if (f.a(a3)) {
            a3.post(new b(a3));
        }
    }
}
