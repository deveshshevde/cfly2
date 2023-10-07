package com.google.android.material.datepicker;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.google.android.material.R;
import com.google.android.material.internal.d;
import com.google.android.material.internal.s;
import com.google.android.material.textfield.TextInputLayout;
import gt.b;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;

public class SingleDateSelector implements DateSelector<Long> {
    public static final Parcelable.Creator<SingleDateSelector> CREATOR = new Parcelable.Creator<SingleDateSelector>() {
        /* renamed from: a */
        public SingleDateSelector createFromParcel(Parcel parcel) {
            SingleDateSelector singleDateSelector = new SingleDateSelector();
            Long unused = singleDateSelector.f18943a = (Long) parcel.readValue(Long.class.getClassLoader());
            return singleDateSelector;
        }

        /* renamed from: a */
        public SingleDateSelector[] newArray(int i2) {
            return new SingleDateSelector[i2];
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Long f18943a;

    /* access modifiers changed from: private */
    public void f() {
        this.f18943a = null;
    }

    public View a(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle, CalendarConstraints calendarConstraints, k<Long> kVar) {
        View inflate = layoutInflater.inflate(R.layout.mtrl_picker_text_input_date, viewGroup, false);
        TextInputLayout textInputLayout = (TextInputLayout) inflate.findViewById(R.id.mtrl_picker_text_input_date);
        EditText editText = textInputLayout.getEditText();
        if (d.d()) {
            editText.setInputType(17);
        }
        SimpleDateFormat d2 = o.d();
        String a2 = o.a(inflate.getResources(), d2);
        textInputLayout.setPlaceholderText(a2);
        Long l2 = this.f18943a;
        if (l2 != null) {
            editText.setText(d2.format(l2));
        }
        final k<Long> kVar2 = kVar;
        editText.addTextChangedListener(new c(a2, d2, textInputLayout, calendarConstraints) {
            /* access modifiers changed from: package-private */
            public void a() {
                kVar2.a();
            }

            /* access modifiers changed from: package-private */
            public void a(Long l2) {
                if (l2 == null) {
                    SingleDateSelector.this.f();
                } else {
                    SingleDateSelector.this.a(l2.longValue());
                }
                kVar2.a(SingleDateSelector.this.a());
            }
        });
        s.b(editText);
        return inflate;
    }

    public String a(Context context) {
        Resources resources = context.getResources();
        Long l2 = this.f18943a;
        if (l2 == null) {
            return resources.getString(R.string.mtrl_picker_date_header_unselected);
        }
        String a2 = d.a(l2.longValue());
        return resources.getString(R.string.mtrl_picker_date_header_selected, new Object[]{a2});
    }

    public void a(long j2) {
        this.f18943a = Long.valueOf(j2);
    }

    public int b(Context context) {
        return b.a(context, R.attr.materialCalendarTheme, f.class.getCanonicalName());
    }

    public boolean b() {
        return this.f18943a != null;
    }

    public Collection<Long> c() {
        ArrayList arrayList = new ArrayList();
        Long l2 = this.f18943a;
        if (l2 != null) {
            arrayList.add(l2);
        }
        return arrayList;
    }

    public Collection<s.d<Long, Long>> d() {
        return new ArrayList();
    }

    public int describeContents() {
        return 0;
    }

    /* renamed from: e */
    public Long a() {
        return this.f18943a;
    }

    public void writeToParcel(Parcel parcel, int i2) {
        parcel.writeValue(this.f18943a);
    }
}
