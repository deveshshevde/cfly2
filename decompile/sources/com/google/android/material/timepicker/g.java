package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.b;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.internal.k;
import com.google.android.material.timepicker.TimePickerView;
import gn.a;
import java.lang.reflect.Field;
import java.util.Locale;

class g implements TimePickerView.c, e {

    /* renamed from: a  reason: collision with root package name */
    private final LinearLayout f19983a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final TimeModel f19984b;

    /* renamed from: c  reason: collision with root package name */
    private final TextWatcher f19985c = new k() {
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    g.this.f19984b.b(0);
                    return;
                }
                g.this.f19984b.b(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    };

    /* renamed from: d  reason: collision with root package name */
    private final TextWatcher f19986d = new k() {
        public void afterTextChanged(Editable editable) {
            try {
                if (TextUtils.isEmpty(editable)) {
                    g.this.f19984b.a(0);
                    return;
                }
                g.this.f19984b.a(Integer.parseInt(editable.toString()));
            } catch (NumberFormatException unused) {
            }
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final ChipTextInputComboView f19987e;

    /* renamed from: f  reason: collision with root package name */
    private final ChipTextInputComboView f19988f;

    /* renamed from: g  reason: collision with root package name */
    private final f f19989g;

    /* renamed from: h  reason: collision with root package name */
    private final EditText f19990h;

    /* renamed from: i  reason: collision with root package name */
    private final EditText f19991i;

    /* renamed from: j  reason: collision with root package name */
    private MaterialButtonToggleGroup f19992j;

    public g(LinearLayout linearLayout, TimeModel timeModel) {
        this.f19983a = linearLayout;
        this.f19984b = timeModel;
        Resources resources = linearLayout.getResources();
        ChipTextInputComboView chipTextInputComboView = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_minute_text_input);
        this.f19987e = chipTextInputComboView;
        ChipTextInputComboView chipTextInputComboView2 = (ChipTextInputComboView) linearLayout.findViewById(R.id.material_hour_text_input);
        this.f19988f = chipTextInputComboView2;
        ((TextView) chipTextInputComboView.findViewById(R.id.material_label)).setText(resources.getString(R.string.material_timepicker_minute));
        ((TextView) chipTextInputComboView2.findViewById(R.id.material_label)).setText(resources.getString(R.string.material_timepicker_hour));
        chipTextInputComboView.setTag(R.id.selection_type, 12);
        chipTextInputComboView2.setTag(R.id.selection_type, 10);
        if (timeModel.f19927a == 0) {
            i();
        }
        AnonymousClass3 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                g.this.a(((Integer) view.getTag(R.id.selection_type)).intValue());
            }
        };
        chipTextInputComboView2.setOnClickListener(r0);
        chipTextInputComboView.setOnClickListener(r0);
        chipTextInputComboView2.a((InputFilter) timeModel.c());
        chipTextInputComboView.a((InputFilter) timeModel.b());
        EditText editText = chipTextInputComboView2.a().getEditText();
        this.f19990h = editText;
        EditText editText2 = chipTextInputComboView.a().getEditText();
        this.f19991i = editText2;
        if (Build.VERSION.SDK_INT < 21) {
            int a2 = a.a((View) linearLayout, R.attr.colorPrimary);
            a(editText, a2);
            a(editText2, a2);
        }
        this.f19989g = new f(chipTextInputComboView2, chipTextInputComboView, timeModel);
        chipTextInputComboView2.a((t.a) new a(linearLayout.getContext(), R.string.material_hour_selection));
        chipTextInputComboView.a((t.a) new a(linearLayout.getContext(), R.string.material_minute_selection));
        a();
    }

    private static void a(EditText editText, int i2) {
        try {
            Context context = editText.getContext();
            Field declaredField = TextView.class.getDeclaredField("mCursorDrawableRes");
            declaredField.setAccessible(true);
            int i3 = declaredField.getInt(editText);
            Field declaredField2 = TextView.class.getDeclaredField("mEditor");
            declaredField2.setAccessible(true);
            Object obj = declaredField2.get(editText);
            Field declaredField3 = obj.getClass().getDeclaredField("mCursorDrawable");
            declaredField3.setAccessible(true);
            Drawable b2 = c.a.b(context, i3);
            b2.setColorFilter(i2, PorterDuff.Mode.SRC_IN);
            declaredField3.set(obj, new Drawable[]{b2, b2});
        } catch (Throwable unused) {
        }
    }

    private void a(TimeModel timeModel) {
        h();
        Locale locale = this.f19983a.getResources().getConfiguration().locale;
        String format = String.format(locale, "%02d", new Object[]{Integer.valueOf(timeModel.f19929c)});
        String format2 = String.format(locale, "%02d", new Object[]{Integer.valueOf(timeModel.a())});
        this.f19987e.a((CharSequence) format);
        this.f19988f.a((CharSequence) format2);
        g();
        j();
    }

    private void g() {
        this.f19990h.addTextChangedListener(this.f19986d);
        this.f19991i.addTextChangedListener(this.f19985c);
    }

    private void h() {
        this.f19990h.removeTextChangedListener(this.f19986d);
        this.f19991i.removeTextChangedListener(this.f19985c);
    }

    private void i() {
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) this.f19983a.findViewById(R.id.material_clock_period_toggle);
        this.f19992j = materialButtonToggleGroup;
        materialButtonToggleGroup.a((MaterialButtonToggleGroup.c) new MaterialButtonToggleGroup.c() {
            public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z2) {
                g.this.f19984b.c(i2 == R.id.material_clock_period_pm_button ? 1 : 0);
            }
        });
        this.f19992j.setVisibility(0);
        j();
    }

    private void j() {
        MaterialButtonToggleGroup materialButtonToggleGroup = this.f19992j;
        if (materialButtonToggleGroup != null) {
            materialButtonToggleGroup.a(this.f19984b.f19931e == 0 ? R.id.material_clock_period_am_button : R.id.material_clock_period_pm_button);
        }
    }

    public void a() {
        g();
        a(this.f19984b);
        this.f19989g.a();
    }

    public void a(int i2) {
        this.f19984b.f19930d = i2;
        boolean z2 = true;
        this.f19987e.setChecked(i2 == 12);
        ChipTextInputComboView chipTextInputComboView = this.f19988f;
        if (i2 != 10) {
            z2 = false;
        }
        chipTextInputComboView.setChecked(z2);
        j();
    }

    public void b() {
        a(this.f19984b);
    }

    public void c() {
        this.f19983a.setVisibility(0);
    }

    public void d() {
        InputMethodManager inputMethodManager;
        View focusedChild = this.f19983a.getFocusedChild();
        if (!(focusedChild == null || (inputMethodManager = (InputMethodManager) b.a(this.f19983a.getContext(), InputMethodManager.class)) == null)) {
            inputMethodManager.hideSoftInputFromWindow(focusedChild.getWindowToken(), 0);
        }
        this.f19983a.setVisibility(8);
    }

    public void e() {
        boolean z2 = true;
        this.f19987e.setChecked(this.f19984b.f19930d == 12);
        ChipTextInputComboView chipTextInputComboView = this.f19988f;
        if (this.f19984b.f19930d != 10) {
            z2 = false;
        }
        chipTextInputComboView.setChecked(z2);
    }

    public void f() {
        this.f19987e.setChecked(false);
        this.f19988f.setChecked(false);
    }
}
