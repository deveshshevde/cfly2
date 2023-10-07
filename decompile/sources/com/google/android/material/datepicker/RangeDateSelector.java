package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.R;
import com.google.android.material.internal.s;
import com.google.android.material.textfield.TextInputLayout;
import gt.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import s.d;

public class RangeDateSelector implements DateSelector<d<Long, Long>> {
    public static final Parcelable.Creator<RangeDateSelector> CREATOR = new Parcelable.Creator<RangeDateSelector>() {
        /* renamed from: a */
        public RangeDateSelector createFromParcel(Parcel parcel) {
            RangeDateSelector rangeDateSelector = new RangeDateSelector();
            Long unused = rangeDateSelector.f18931c = (Long) parcel.readValue(Long.class.getClassLoader());
            Long unused2 = rangeDateSelector.f18932d = (Long) parcel.readValue(Long.class.getClassLoader());
            return rangeDateSelector;
        }

        /* renamed from: a */
        public RangeDateSelector[] newArray(int i2) {
            return new RangeDateSelector[i2];
        }
    };

    /* renamed from: a  reason: collision with root package name */
    private String f18929a;

    /* renamed from: b  reason: collision with root package name */
    private final String f18930b = " ";
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public Long f18931c = null;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Long f18932d = null;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public Long f18933e = null;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public Long f18934f = null;

    private void a(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        if (textInputLayout.getError() != null && this.f18929a.contentEquals(textInputLayout.getError())) {
            textInputLayout.setError((CharSequence) null);
        }
        if (textInputLayout2.getError() != null && " ".contentEquals(textInputLayout2.getError())) {
            textInputLayout2.setError((CharSequence) null);
        }
    }

    /* access modifiers changed from: private */
    public void a(TextInputLayout textInputLayout, TextInputLayout textInputLayout2, k<d<Long, Long>> kVar) {
        Long l2 = this.f18933e;
        if (l2 == null || this.f18934f == null) {
            a(textInputLayout, textInputLayout2);
            kVar.a();
        } else if (a(l2.longValue(), this.f18934f.longValue())) {
            this.f18931c = this.f18933e;
            this.f18932d = this.f18934f;
            kVar.a(a());
        } else {
            b(textInputLayout, textInputLayout2);
            kVar.a();
        }
    }

    private boolean a(long j2, long j3) {
        return j2 <= j3;
    }

    private void b(TextInputLayout textInputLayout, TextInputLayout textInputLayout2) {
        textInputLayout.setError(this.f18929a);
        textInputLayout2.setError(" ");
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, k<d<Long, Long>> kVar) {
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date_range, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_start);
        TextInputLayout textInputLayout2 = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_range_end);
        EditText editText = textInputLayout.getEditText();
        EditText editText2 = textInputLayout2.getEditText();
        if (com.google.android.material.internal.d.d()) {
            editText.setInputType(17);
            editText2.setInputType(17);
        }
        this.f18929a = inflate.getResources().getString(R.string.mtrl_picker_invalid_range);
        SimpleDateFormat d2 = o.d();
        Long l2 = this.f18931c;
        if (l2 != null) {
            editText.setText(d2.format(l2));
            this.f18933e = this.f18931c;
        }
        Long l3 = this.f18932d;
        if (l3 != null) {
            editText2.setText(d2.format(l3));
            this.f18934f = this.f18932d;
        }
        String a2 = o.a(inflate.getResources(), d2);
        textInputLayout.setPlaceholderText(a2);
        textInputLayout2.setPlaceholderText(a2);
        SimpleDateFormat simpleDateFormat = d2;
        CalendarConstraints calendarConstraints2 = calendarConstraints;
        final TextInputLayout textInputLayout3 = textInputLayout;
        AnonymousClass1 r9 = r0;
        final TextInputLayout textInputLayout4 = textInputLayout2;
        String str = a2;
        final k<d<Long, Long>> kVar2 = kVar;
        AnonymousClass1 r0 = new c(a2, simpleDateFormat, textInputLayout, calendarConstraints2) {
            /* access modifiers changed from: package-private */
            public void a() {
                Long unused = RangeDateSelector.this.f18933e = null;
                RangeDateSelector.this.a(textInputLayout3, textInputLayout4, kVar2);
            }

            /* access modifiers changed from: package-private */
            public void a(Long l2) {
                Long unused = RangeDateSelector.this.f18933e = l2;
                RangeDateSelector.this.a(textInputLayout3, textInputLayout4, kVar2);
            }
        };
        editText.addTextChangedListener(r9);
        editText2.addTextChangedListener(new c(str, simpleDateFormat, textInputLayout2, calendarConstraints2) {
            /* access modifiers changed from: package-private */
            public void a() {
                Long unused = RangeDateSelector.this.f18934f = null;
                RangeDateSelector.this.a(textInputLayout3, textInputLayout4, kVar2);
            }

            /* access modifiers changed from: package-private */
            public void a(Long l2) {
                Long unused = RangeDateSelector.this.f18934f = l2;
                RangeDateSelector.this.a(textInputLayout3, textInputLayout4, kVar2);
            }
        });
        s.b(editText);
        return inflate;
    }

    public String a(Context context) {
        Resources resources = context.getResources();
        Long l2 = this.f18931c;
        if (l2 == null && this.f18932d == null) {
            return resources.getString(R.string.mtrl_picker_range_header_unselected);
        }
        Long l3 = this.f18932d;
        if (l3 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_start_selected, new Object[]{d.e(this.f18931c.longValue())});
        } else if (l2 == null) {
            return resources.getString(R.string.mtrl_picker_range_header_only_end_selected, new Object[]{d.e(this.f18932d.longValue())});
        } else {
            d<String, String> a2 = d.a(l2, l3);
            return resources.getString(R.string.mtrl_picker_range_header_selected, new Object[]{a2.f34394a, a2.f34395b});
        }
    }

    public void a(long j2) {
        Long l2 = this.f18931c;
        if (l2 != null) {
            if (this.f18932d != null || !a(l2.longValue(), j2)) {
                this.f18932d = null;
            } else {
                this.f18932d = Long.valueOf(j2);
                return;
            }
        }
        this.f18931c = Long.valueOf(j2);
    }

    public int b(Context context) {
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        return b.a(context, Math.min(displayMetrics.widthPixels, displayMetrics.heightPixels) > resources.getDimensionPixelSize(R.dimen.mtrl_calendar_maximum_default_fullscreen_minor_axis) ? R.attr.materialCalendarTheme : R.attr.materialCalendarFullscreenTheme, f.class.getCanonicalName());
    }

    public boolean b() {
        Long l2 = this.f18931c;
        return (l2 == null || this.f18932d == null || !a(l2.longValue(), this.f18932d.longValue())) ? false : true;
    }

    public Collection<Long> c() {
        ArrayList arrayList = new ArrayList();
        Long l2 = this.f18931c;
        if (l2 != null) {
            arrayList.add(l2);
        }
        Long l3 = this.f18932d;
        if (l3 != null) {
            arrayList.add(l3);
        }
        return arrayList;
    }

    public Collection<d<Long, Long>> d() {
        if (this.f18931c == null || this.f18932d == null) {
            return new ArrayList();
        }
        ArrayList arrayList = new ArrayList();
        arrayList.add(new d(this.f18931c, this.f18932d));
        return arrayList;
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public d<Long, Long> a() {
        return new d<>(this.f18931c, this.f18932d);
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeValue(this.f18931c);
        parcel.writeValue(this.f18932d);
    }
}
