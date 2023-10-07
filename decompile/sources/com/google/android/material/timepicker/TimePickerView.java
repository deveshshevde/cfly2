package com.google.android.material.timepicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Checkable;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButtonToggleGroup;
import com.google.android.material.chip.Chip;
import com.google.android.material.timepicker.ClockHandView;
import java.util.Locale;
import t.ac;

class TimePickerView extends ConstraintLayout {

    /* renamed from: a  reason: collision with root package name */
    private final Chip f19934a;

    /* renamed from: b  reason: collision with root package name */
    private final Chip f19935b;

    /* renamed from: c  reason: collision with root package name */
    private final ClockHandView f19936c;

    /* renamed from: d  reason: collision with root package name */
    private final ClockFaceView f19937d;

    /* renamed from: e  reason: collision with root package name */
    private final MaterialButtonToggleGroup f19938e;

    /* renamed from: f  reason: collision with root package name */
    private final View.OnClickListener f19939f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public b f19940g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public c f19941h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public a f19942i;

    interface a {
        void a();
    }

    interface b {
        void b(int i2);
    }

    interface c {
        void a(int i2);
    }

    public TimePickerView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public TimePickerView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f19939f = new View.OnClickListener() {
            public void onClick(View view) {
                if (TimePickerView.this.f19941h != null) {
                    TimePickerView.this.f19941h.a(((Integer) view.getTag(R.id.selection_type)).intValue());
                }
            }
        };
        LayoutInflater.from(context).inflate(R.layout.material_timepicker, this);
        this.f19937d = (ClockFaceView) findViewById(R.id.material_clock_face);
        MaterialButtonToggleGroup materialButtonToggleGroup = (MaterialButtonToggleGroup) findViewById(R.id.material_clock_period_toggle);
        this.f19938e = materialButtonToggleGroup;
        materialButtonToggleGroup.a((MaterialButtonToggleGroup.c) new MaterialButtonToggleGroup.c() {
            public void a(MaterialButtonToggleGroup materialButtonToggleGroup, int i2, boolean z2) {
                int i3 = i2 == R.id.material_clock_period_pm_button ? 1 : 0;
                if (TimePickerView.this.f19940g != null && z2) {
                    TimePickerView.this.f19940g.b(i3);
                }
            }
        });
        this.f19934a = (Chip) findViewById(R.id.material_minute_tv);
        this.f19935b = (Chip) findViewById(R.id.material_hour_tv);
        this.f19936c = (ClockHandView) findViewById(R.id.material_clock_hand);
        b();
        c();
    }

    private void b() {
        final GestureDetector gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() {
            public boolean onDoubleTap(MotionEvent motionEvent) {
                boolean onDoubleTap = super.onDoubleTap(motionEvent);
                if (TimePickerView.this.f19942i != null) {
                    TimePickerView.this.f19942i.a();
                }
                return onDoubleTap;
            }
        });
        AnonymousClass4 r1 = new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (((Checkable) view).isChecked()) {
                    return gestureDetector.onTouchEvent(motionEvent);
                }
                return false;
            }
        };
        this.f19934a.setOnTouchListener(r1);
        this.f19935b.setOnTouchListener(r1);
    }

    private void c() {
        this.f19934a.setTag(R.id.selection_type, 12);
        this.f19935b.setTag(R.id.selection_type, 10);
        this.f19934a.setOnClickListener(this.f19939f);
        this.f19935b.setOnClickListener(this.f19939f);
    }

    private void d() {
        if (this.f19938e.getVisibility() == 0) {
            androidx.constraintlayout.widget.b bVar = new androidx.constraintlayout.widget.b();
            bVar.b((ConstraintLayout) this);
            int i2 = 1;
            if (ac.i(this) == 0) {
                i2 = 2;
            }
            bVar.a(R.id.material_clock_display, i2);
            bVar.c((ConstraintLayout) this);
        }
    }

    public void a() {
        this.f19938e.setVisibility(0);
    }

    public void a(float f2, boolean z2) {
        this.f19936c.a(f2, z2);
    }

    public void a(int i2) {
        boolean z2 = true;
        this.f19934a.setChecked(i2 == 12);
        Chip chip = this.f19935b;
        if (i2 != 10) {
            z2 = false;
        }
        chip.setChecked(z2);
    }

    public void a(ClockHandView.a aVar) {
        this.f19936c.a(aVar);
    }

    public void a(ClockHandView.b bVar) {
        this.f19936c.a(bVar);
    }

    /* access modifiers changed from: package-private */
    public void a(a aVar) {
        this.f19942i = aVar;
    }

    /* access modifiers changed from: package-private */
    public void a(b bVar) {
        this.f19940g = bVar;
    }

    /* access modifiers changed from: package-private */
    public void a(c cVar) {
        this.f19941h = cVar;
    }

    public void a(t.a aVar) {
        ac.a((View) this.f19935b, aVar);
    }

    public void a(boolean z2) {
        this.f19936c.a(z2);
    }

    public void a(String[] strArr, int i2) {
        this.f19937d.a(strArr, i2);
    }

    public void b(int i2, int i3, int i4) {
        this.f19938e.a(i2 == 1 ? R.id.material_clock_period_pm_button : R.id.material_clock_period_am_button);
        Locale locale = getResources().getConfiguration().locale;
        String format = String.format(locale, "%02d", new Object[]{Integer.valueOf(i4)});
        String format2 = String.format(locale, "%02d", new Object[]{Integer.valueOf(i3)});
        this.f19934a.setText(format);
        this.f19935b.setText(format2);
    }

    public void b(t.a aVar) {
        ac.a((View) this.f19934a, aVar);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        d();
    }

    /* access modifiers changed from: protected */
    public void onVisibilityChanged(View view, int i2) {
        super.onVisibilityChanged(view, i2);
        if (view == this && i2 == 0) {
            d();
        }
    }
}
