package com.afollestad.date.renderers;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.TextView;
import as.c;
import as.e;
import com.afollestad.date.R;
import com.afollestad.date.controllers.b;
import com.afollestad.date.data.DayOfWeek;
import com.afollestad.date.data.f;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.text.f;

public final class a {
    @Deprecated

    /* renamed from: a  reason: collision with root package name */
    public static final C0071a f7478a = new C0071a((f) null);

    /* renamed from: b  reason: collision with root package name */
    private final int f7479b;

    /* renamed from: c  reason: collision with root package name */
    private final int f7480c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final Context f7481d;

    /* renamed from: e  reason: collision with root package name */
    private final Typeface f7482e;

    /* renamed from: f  reason: collision with root package name */
    private final b f7483f;

    /* renamed from: com.afollestad.date.renderers.a$a  reason: collision with other inner class name */
    private static final class C0071a {
        private C0071a() {
        }

        public /* synthetic */ C0071a(f fVar) {
            this();
        }
    }

    public a(Context context, TypedArray typedArray, Typeface typeface, b bVar) {
        h.c(context, "context");
        h.c(typedArray, "typedArray");
        h.c(typeface, "normalFont");
        h.c(bVar, "minMaxController");
        this.f7481d = context;
        this.f7482e = typeface;
        this.f7483f = bVar;
        this.f7479b = as.a.a(typedArray, R.styleable.DatePicker_date_picker_selection_color, new MonthItemRenderer$selectionColor$1(this));
        this.f7480c = as.a.a(typedArray, R.styleable.DatePicker_date_picker_disabled_background_color, new MonthItemRenderer$disabledBackgroundColor$1(this));
    }

    private final String a(int i2) {
        return i2 < 1 ? "" : String.valueOf(i2);
    }

    private final void a(DayOfWeek dayOfWeek, TextView textView) {
        Context context = textView.getContext();
        h.a((Object) context, "context");
        textView.setTextColor(c.a(context, 16842808, (mm.a) null, 2, (Object) null));
        textView.setText(String.valueOf(f.e(dayOfWeek.name())));
        textView.setTypeface(this.f7482e);
    }

    private final void a(f.a aVar, View view, TextView textView, mm.b<? super f.a, l> bVar) {
        int d2;
        Drawable drawable = null;
        view.setBackground(drawable);
        as.h hVar = as.h.f5572a;
        Context context = textView.getContext();
        h.a((Object) context, "context");
        textView.setTextColor(as.h.a(hVar, context, this.f7479b, false, 4, (Object) null));
        textView.setText(a(aVar.c()));
        textView.setTypeface(this.f7482e);
        textView.setGravity(17);
        textView.setBackground(drawable);
        textView.setOnClickListener((View.OnClickListener) null);
        boolean z2 = false;
        if (aVar.c() == -1) {
            view.setEnabled(false);
            textView.setSelected(false);
            return;
        }
        ar.a aVar2 = new ar.a(aVar.b().a(), aVar.c(), aVar.b().b());
        textView.setSelected(aVar.d());
        if (this.f7483f.a(aVar2)) {
            d2 = this.f7483f.b(aVar2);
        } else if (this.f7483f.c(aVar2)) {
            d2 = this.f7483f.d(aVar2);
        } else {
            if (textView.getText().toString().length() > 0) {
                z2 = true;
            }
            view.setEnabled(z2);
            textView.setBackground(as.h.f5572a.a(this.f7479b));
            e.a(textView, new MonthItemRenderer$renderDayOfMonth$$inlined$apply$lambda$1(this, bVar, aVar));
            return;
        }
        as.h hVar2 = as.h.f5572a;
        Context context2 = view.getContext();
        h.a((Object) context2, "context");
        view.setBackground(hVar2.a(context2, d2, this.f7480c));
        view.setEnabled(false);
    }

    public final void a(com.afollestad.date.data.f fVar, View view, TextView textView, mm.b<? super f.a, l> bVar) {
        h.c(fVar, "item");
        h.c(view, "rootView");
        h.c(textView, "textView");
        h.c(bVar, "onSelection");
        if (fVar instanceof f.b) {
            a(((f.b) fVar).a(), textView);
        } else if (fVar instanceof f.a) {
            a((f.a) fVar, view, textView, bVar);
        }
    }
}
