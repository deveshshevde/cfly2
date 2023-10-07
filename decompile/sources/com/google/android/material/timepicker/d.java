package com.google.android.material.timepicker;

import android.os.Build;
import android.view.accessibility.AccessibilityManager;
import androidx.core.content.b;
import com.google.android.material.R;
import com.google.android.material.timepicker.ClockHandView;
import com.google.android.material.timepicker.TimePickerView;
import t.a;

class d implements ClockHandView.a, ClockHandView.b, TimePickerView.b, TimePickerView.c, e {

    /* renamed from: a  reason: collision with root package name */
    private static final String[] f19971a = {"12", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11"};

    /* renamed from: b  reason: collision with root package name */
    private static final String[] f19972b = {"00", "2", "4", "6", "8", "10", "12", "14", "16", "18", "20", "22"};

    /* renamed from: c  reason: collision with root package name */
    private static final String[] f19973c = {"00", "5", "10", "15", "20", "25", "30", "35", "40", "45", "50", "55"};

    /* renamed from: d  reason: collision with root package name */
    private TimePickerView f19974d;

    /* renamed from: e  reason: collision with root package name */
    private TimeModel f19975e;

    /* renamed from: f  reason: collision with root package name */
    private float f19976f;

    /* renamed from: g  reason: collision with root package name */
    private float f19977g;

    /* renamed from: h  reason: collision with root package name */
    private boolean f19978h = false;

    public d(TimePickerView timePickerView, TimeModel timeModel) {
        this.f19974d = timePickerView;
        this.f19975e = timeModel;
        a();
    }

    private void a(int i2, int i3) {
        if (this.f19975e.f19929c != i3 || this.f19975e.f19928b != i2) {
            this.f19974d.performHapticFeedback(Build.VERSION.SDK_INT >= 21 ? 4 : 1);
        }
    }

    private void a(String[] strArr, String str) {
        for (int i2 = 0; i2 < strArr.length; i2++) {
            strArr[i2] = TimeModel.a(this.f19974d.getResources(), strArr[i2], str);
        }
    }

    private String[] e() {
        return this.f19975e.f19927a == 1 ? f19972b : f19971a;
    }

    private int f() {
        return this.f19975e.f19927a == 1 ? 15 : 30;
    }

    private void g() {
        this.f19974d.b(this.f19975e.f19931e, this.f19975e.a(), this.f19975e.f19929c);
    }

    private void h() {
        a(f19971a, "%d");
        a(f19972b, "%d");
        a(f19973c, "%02d");
    }

    public void a() {
        if (this.f19975e.f19927a == 0) {
            this.f19974d.a();
        }
        this.f19974d.a((ClockHandView.b) this);
        this.f19974d.a((TimePickerView.c) this);
        this.f19974d.a((TimePickerView.b) this);
        this.f19974d.a((ClockHandView.a) this);
        h();
        b();
    }

    public void a(float f2, boolean z2) {
        if (!this.f19978h) {
            int i2 = this.f19975e.f19928b;
            int i3 = this.f19975e.f19929c;
            int round = Math.round(f2);
            if (this.f19975e.f19930d == 12) {
                this.f19975e.b((round + 3) / 6);
                this.f19976f = (float) Math.floor((double) (this.f19975e.f19929c * 6));
            } else {
                this.f19975e.a((round + (f() / 2)) / f());
                this.f19977g = (float) (this.f19975e.a() * f());
            }
            if (!z2) {
                g();
                a(i2, i3);
            }
        }
    }

    public void a(int i2) {
        a(i2, true);
    }

    /* access modifiers changed from: package-private */
    public void a(int i2, boolean z2) {
        boolean z3 = i2 == 12;
        this.f19974d.a(z3);
        this.f19975e.f19930d = i2;
        this.f19974d.a(z3 ? f19973c : e(), z3 ? R.string.material_minute_suffix : R.string.material_hour_suffix);
        this.f19974d.a(z3 ? this.f19976f : this.f19977g, z2);
        this.f19974d.a(i2);
        TimePickerView timePickerView = this.f19974d;
        timePickerView.a((a) new a(timePickerView.getContext(), R.string.material_hour_selection));
        TimePickerView timePickerView2 = this.f19974d;
        timePickerView2.b((a) new a(timePickerView2.getContext(), R.string.material_minute_selection));
    }

    public void b() {
        this.f19977g = (float) (this.f19975e.a() * f());
        this.f19976f = (float) (this.f19975e.f19929c * 6);
        a(this.f19975e.f19930d, false);
        g();
    }

    public void b(float f2, boolean z2) {
        this.f19978h = true;
        int i2 = this.f19975e.f19929c;
        int i3 = this.f19975e.f19928b;
        if (this.f19975e.f19930d == 10) {
            this.f19974d.a(this.f19977g, false);
            if (!((AccessibilityManager) b.a(this.f19974d.getContext(), AccessibilityManager.class)).isTouchExplorationEnabled()) {
                a(12, true);
            }
        } else {
            int round = Math.round(f2);
            if (!z2) {
                this.f19975e.b(((round + 15) / 30) * 5);
                this.f19976f = (float) (this.f19975e.f19929c * 6);
            }
            this.f19974d.a(this.f19976f, z2);
        }
        this.f19978h = false;
        g();
        a(i3, i2);
    }

    public void b(int i2) {
        this.f19975e.c(i2);
    }

    public void c() {
        this.f19974d.setVisibility(0);
    }

    public void d() {
        this.f19974d.setVisibility(8);
    }
}
