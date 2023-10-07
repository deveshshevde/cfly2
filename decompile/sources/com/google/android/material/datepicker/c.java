package com.google.android.material.datepicker;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.google.android.material.R;
import com.google.android.material.internal.k;
import com.google.android.material.textfield.TextInputLayout;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.Date;

abstract class c extends k {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final TextInputLayout f18960a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final DateFormat f18961b;

    /* renamed from: c  reason: collision with root package name */
    private final CalendarConstraints f18962c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final String f18963d;

    /* renamed from: e  reason: collision with root package name */
    private final Runnable f18964e;

    /* renamed from: f  reason: collision with root package name */
    private Runnable f18965f;

    c(final String str, DateFormat dateFormat, TextInputLayout textInputLayout, CalendarConstraints calendarConstraints) {
        this.f18961b = dateFormat;
        this.f18960a = textInputLayout;
        this.f18962c = calendarConstraints;
        this.f18963d = textInputLayout.getContext().getString(R.string.mtrl_picker_out_of_range);
        this.f18964e = new Runnable() {
            public void run() {
                TextInputLayout a2 = c.this.f18960a;
                DateFormat b2 = c.this.f18961b;
                Context context = a2.getContext();
                String string = context.getString(R.string.mtrl_picker_invalid_format);
                String format = String.format(context.getString(R.string.mtrl_picker_invalid_format_use), new Object[]{str});
                String format2 = String.format(context.getString(R.string.mtrl_picker_invalid_format_example), new Object[]{b2.format(new Date(o.b().getTimeInMillis()))});
                a2.setError(string + "\n" + format + "\n" + format2);
                c.this.a();
            }
        };
    }

    private Runnable a(final long j2) {
        return new Runnable() {
            public void run() {
                c.this.f18960a.setError(String.format(c.this.f18963d, new Object[]{d.e(j2)}));
                c.this.a();
            }
        };
    }

    /* access modifiers changed from: package-private */
    public void a() {
    }

    public void a(View view, Runnable runnable) {
        view.postDelayed(runnable, 1000);
    }

    /* access modifiers changed from: package-private */
    public abstract void a(Long l2);

    public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        this.f18960a.removeCallbacks(this.f18964e);
        this.f18960a.removeCallbacks(this.f18965f);
        this.f18960a.setError((CharSequence) null);
        a((Long) null);
        if (!TextUtils.isEmpty(charSequence)) {
            try {
                Date parse = this.f18961b.parse(charSequence.toString());
                this.f18960a.setError((CharSequence) null);
                long time = parse.getTime();
                if (!this.f18962c.a().a(time) || !this.f18962c.a(time)) {
                    Runnable a2 = a(time);
                    this.f18965f = a2;
                    a(this.f18960a, a2);
                    return;
                }
                a(Long.valueOf(parse.getTime()));
            } catch (ParseException unused) {
                a(this.f18960a, this.f18964e);
            }
        }
    }
}
