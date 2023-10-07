package com.afollestad.materialdialogs.internal.button;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.RippleDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import ay.e;
import ay.f;
import com.afollestad.materialdialogs.R;
import kotlin.jvm.internal.h;

public final class DialogActionButton extends AppCompatButton {

    /* renamed from: a  reason: collision with root package name */
    public static final a f7570a = new a((f) null);

    /* renamed from: b  reason: collision with root package name */
    private int f7571b;

    /* renamed from: c  reason: collision with root package name */
    private int f7572c;

    /* renamed from: e  reason: collision with root package name */
    private Integer f7573e;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DialogActionButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.c(context, "context");
        setClickable(true);
        setFocusable(true);
    }

    public final void a(Context context, Context context2, boolean z2) {
        h.c(context, "baseContext");
        h.c(context2, "appContext");
        boolean z3 = true;
        if (e.f5573a.a(context2, R.attr.md_button_casing, 1) != 1) {
            z3 = false;
        }
        setSupportAllCaps(z3);
        boolean a2 = com.afollestad.materialdialogs.e.a(context2);
        this.f7571b = e.a(e.f5573a, context2, (Integer) null, Integer.valueOf(R.attr.md_color_button_text), (mm.a) new DialogActionButton$update$1(context2), 2, (Object) null);
        this.f7572c = e.a(e.f5573a, context, Integer.valueOf(a2 ? R.color.md_disabled_text_light_theme : R.color.md_disabled_text_dark_theme), (Integer) null, (mm.a) null, 12, (Object) null);
        Integer num = this.f7573e;
        setTextColor(num != null ? num.intValue() : this.f7571b);
        Drawable a3 = e.a(e.f5573a, context, (Integer) null, Integer.valueOf(R.attr.md_button_selector), (Drawable) null, 10, (Object) null);
        if (Build.VERSION.SDK_INT >= 21 && (a3 instanceof RippleDrawable)) {
            e eVar = e.f5573a;
            int a4 = e.a(e.f5573a, context, (Integer) null, Integer.valueOf(R.attr.md_ripple_color), (mm.a) new DialogActionButton$update$2(context2), 2, (Object) null);
            if (a4 != 0) {
                ((RippleDrawable) a3).setColor(ColorStateList.valueOf(a4));
            }
        }
        setBackground(a3);
        if (z2) {
            f.b((TextView) this);
        } else {
            setGravity(17);
        }
        setEnabled(isEnabled());
    }

    public void setEnabled(boolean z2) {
        int i2;
        super.setEnabled(z2);
        if (z2) {
            Integer num = this.f7573e;
            i2 = num != null ? num.intValue() : this.f7571b;
        } else {
            i2 = this.f7572c;
        }
        setTextColor(i2);
    }
}
