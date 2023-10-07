package com.xeagle.android.widgets.actionProviders;

import android.content.Context;
import android.view.View;
import android.widget.Spinner;
import com.cfly.uav_pro.R;
import com.xeagle.android.enums.DroneModes;
import com.xeagle.android.widgets.spinners.SpinnerSelfSelect;
import java.util.Collections;
import java.util.List;

public abstract class a {

    /* renamed from: a  reason: collision with root package name */
    protected final int f25684a;

    /* renamed from: b  reason: collision with root package name */
    protected View f25685b;

    /* renamed from: com.xeagle.android.widgets.actionProviders.a$a  reason: collision with other inner class name */
    public static class C0160a extends a {

        /* renamed from: c  reason: collision with root package name */
        private int f25686c = -1;

        /* renamed from: d  reason: collision with root package name */
        private com.xeagle.android.widgets.spinners.a f25687d;
        /* access modifiers changed from: private */

        /* renamed from: e  reason: collision with root package name */
        public en.a f25688e;

        public C0160a(Context context, View view, en.a aVar) {
            super(context, view, aVar, R.id.bar_flight_mode);
        }

        /* access modifiers changed from: protected */
        public void a(Context context, View view, en.a aVar) {
            a.super.a(context, view, aVar);
            if (this.f25685b != null) {
                SpinnerSelfSelect spinnerSelfSelect = (SpinnerSelfSelect) this.f25685b;
                com.xeagle.android.widgets.spinners.a aVar2 = new com.xeagle.android.widgets.spinners.a(context, R.layout.spinner_drop_down);
                this.f25687d = aVar2;
                spinnerSelfSelect.setAdapter(aVar2);
                spinnerSelfSelect.setOnSpinnerItemSelectedListener(new SpinnerSelfSelect.a() {
                    public void a(Spinner spinner, int i2) {
                        if (C0160a.this.f25688e != null) {
                            DroneModes droneModes = (DroneModes) spinner.getItemAtPosition(i2);
                        }
                    }
                });
                a(context, aVar);
            }
        }

        public void a(Context context, en.a aVar) {
            this.f25688e = aVar;
            if (this.f25685b != null) {
                SpinnerSelfSelect spinnerSelfSelect = (SpinnerSelfSelect) this.f25685b;
                int f2 = aVar == null ? -1 : aVar.f();
                if (f2 != this.f25686c) {
                    List<String> emptyList = f2 == -1 ? Collections.emptyList() : DroneModes.a(context, f2);
                    this.f25687d.clear();
                    this.f25687d.addAll(emptyList);
                    this.f25687d.notifyDataSetChanged();
                    this.f25686c = f2;
                }
                en.a aVar2 = this.f25688e;
                if (aVar2 != null) {
                    spinnerSelfSelect.a(this.f25687d.getPosition(aVar2.d().e().b()));
                }
            }
        }
    }

    protected a(Context context, View view, en.a aVar, int i2) {
        this.f25684a = i2;
        a(context, view, aVar);
    }

    /* access modifiers changed from: protected */
    public void a(Context context, View view, en.a aVar) {
        this.f25685b = view.findViewById(this.f25684a);
    }

    public void a(Context context, en.a aVar) {
    }
}
