package com.google.android.material.datepicker;

import android.os.Bundle;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Iterator;

public final class h<S> extends l<S> {

    /* renamed from: a  reason: collision with root package name */
    private int f18998a;

    /* renamed from: b  reason: collision with root package name */
    private DateSelector<S> f18999b;

    /* renamed from: c  reason: collision with root package name */
    private CalendarConstraints f19000c;

    static <T> h<T> a(DateSelector<T> dateSelector, int i2, CalendarConstraints calendarConstraints) {
        h<T> hVar = new h<>();
        Bundle bundle = new Bundle();
        bundle.putInt("THEME_RES_ID_KEY", i2);
        bundle.putParcelable("DATE_SELECTOR_KEY", dateSelector);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", calendarConstraints);
        hVar.setArguments(bundle);
        return hVar;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f18998a = bundle.getInt("THEME_RES_ID_KEY");
        this.f18999b = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f19000c = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        return this.f18999b.a(layoutInflater.cloneInContext(new ContextThemeWrapper(getContext(), this.f18998a)), viewGroup, bundle, this.f19000c, new k<S>() {
            public void a() {
                Iterator it2 = h.this.f19017e.iterator();
                while (it2.hasNext()) {
                    ((k) it2.next()).a();
                }
            }

            public void a(S s2) {
                Iterator it2 = h.this.f19017e.iterator();
                while (it2.hasNext()) {
                    ((k) it2.next()).a(s2);
                }
            }
        });
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("THEME_RES_ID_KEY", this.f18998a);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f18999b);
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", this.f19000c);
    }
}
