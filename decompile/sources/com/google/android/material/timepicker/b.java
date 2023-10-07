package com.google.android.material.timepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Pair;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.c;
import com.google.android.material.R;
import com.google.android.material.button.MaterialButton;
import com.google.android.material.timepicker.TimePickerView;
import gw.h;
import java.util.LinkedHashSet;
import java.util.Set;

public final class b extends c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Set<View.OnClickListener> f19949a = new LinkedHashSet();
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public final Set<View.OnClickListener> f19950b = new LinkedHashSet();

    /* renamed from: c  reason: collision with root package name */
    private final Set<DialogInterface.OnCancelListener> f19951c = new LinkedHashSet();

    /* renamed from: d  reason: collision with root package name */
    private final Set<DialogInterface.OnDismissListener> f19952d = new LinkedHashSet();

    /* renamed from: e  reason: collision with root package name */
    private TimePickerView f19953e;

    /* renamed from: f  reason: collision with root package name */
    private ViewStub f19954f;

    /* renamed from: g  reason: collision with root package name */
    private d f19955g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public g f19956h;

    /* renamed from: i  reason: collision with root package name */
    private e f19957i;

    /* renamed from: j  reason: collision with root package name */
    private int f19958j;

    /* renamed from: k  reason: collision with root package name */
    private int f19959k;

    /* renamed from: l  reason: collision with root package name */
    private int f19960l = 0;

    /* renamed from: m  reason: collision with root package name */
    private String f19961m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public MaterialButton f19962n;
    /* access modifiers changed from: private */

    /* renamed from: o  reason: collision with root package name */
    public int f19963o = 0;

    /* renamed from: p  reason: collision with root package name */
    private TimeModel f19964p;

    /* renamed from: q  reason: collision with root package name */
    private int f19965q = 0;

    private int a() {
        int i2 = this.f19965q;
        if (i2 != 0) {
            return i2;
        }
        TypedValue a2 = gt.b.a(requireContext(), R.attr.materialTimePickerTheme);
        if (a2 == null) {
            return 0;
        }
        return a2.data;
    }

    private e a(int i2) {
        if (i2 == 0) {
            d dVar = this.f19955g;
            if (dVar == null) {
                dVar = new d(this.f19953e, this.f19964p);
            }
            this.f19955g = dVar;
            return dVar;
        }
        if (this.f19956h == null) {
            this.f19956h = new g((LinearLayout) this.f19954f.inflate(), this.f19964p);
        }
        this.f19956h.f();
        return this.f19956h;
    }

    private void a(Bundle bundle) {
        if (bundle != null) {
            TimeModel timeModel = (TimeModel) bundle.getParcelable("TIME_PICKER_TIME_MODEL");
            this.f19964p = timeModel;
            if (timeModel == null) {
                this.f19964p = new TimeModel();
            }
            this.f19963o = bundle.getInt("TIME_PICKER_INPUT_MODE", 0);
            this.f19960l = bundle.getInt("TIME_PICKER_TITLE_RES", 0);
            this.f19961m = bundle.getString("TIME_PICKER_TITLE_TEXT");
            this.f19965q = bundle.getInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", 0);
        }
    }

    /* access modifiers changed from: private */
    public void a(MaterialButton materialButton) {
        e eVar = this.f19957i;
        if (eVar != null) {
            eVar.d();
        }
        e a2 = a(this.f19963o);
        this.f19957i = a2;
        a2.c();
        this.f19957i.b();
        Pair<Integer, Integer> b2 = b(this.f19963o);
        materialButton.setIconResource(((Integer) b2.first).intValue());
        materialButton.setContentDescription(getResources().getString(((Integer) b2.second).intValue()));
    }

    private Pair<Integer, Integer> b(int i2) {
        if (i2 == 0) {
            return new Pair<>(Integer.valueOf(this.f19958j), Integer.valueOf(R.string.material_timepicker_text_input_mode_description));
        }
        if (i2 == 1) {
            return new Pair<>(Integer.valueOf(this.f19959k), Integer.valueOf(R.string.material_timepicker_clock_mode_description));
        }
        throw new IllegalArgumentException("no icon for mode: " + i2);
    }

    public final void onCancel(DialogInterface dialogInterface) {
        for (DialogInterface.OnCancelListener onCancel : this.f19951c) {
            onCancel.onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        a(bundle);
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), a());
        Context context = dialog.getContext();
        int a2 = gt.b.a(context, R.attr.colorSurface, b.class.getCanonicalName());
        h hVar = new h(context, (AttributeSet) null, R.attr.materialTimePickerStyle, R.style.Widget_MaterialComponents_TimePicker);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes((AttributeSet) null, R.styleable.MaterialTimePicker, R.attr.materialTimePickerStyle, R.style.Widget_MaterialComponents_TimePicker);
        this.f19959k = obtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_clockIcon, 0);
        this.f19958j = obtainStyledAttributes.getResourceId(R.styleable.MaterialTimePicker_keyboardIcon, 0);
        obtainStyledAttributes.recycle();
        hVar.a(context);
        hVar.g(ColorStateList.valueOf(a2));
        Window window = dialog.getWindow();
        window.setBackgroundDrawable(hVar);
        window.requestFeature(1);
        window.setLayout(-2, -2);
        return dialog;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        ViewGroup viewGroup2 = (ViewGroup) layoutInflater.inflate(R.layout.material_timepicker_dialog, viewGroup);
        TimePickerView timePickerView = (TimePickerView) viewGroup2.findViewById(R.id.material_timepicker_view);
        this.f19953e = timePickerView;
        timePickerView.a((TimePickerView.a) new TimePickerView.a() {
            public void a() {
                int unused = b.this.f19963o = 1;
                b bVar = b.this;
                bVar.a(bVar.f19962n);
                b.this.f19956h.e();
            }
        });
        this.f19954f = (ViewStub) viewGroup2.findViewById(R.id.material_textinput_timepicker);
        this.f19962n = (MaterialButton) viewGroup2.findViewById(R.id.material_timepicker_mode_button);
        TextView textView = (TextView) viewGroup2.findViewById(R.id.header_title);
        if (!TextUtils.isEmpty(this.f19961m)) {
            textView.setText(this.f19961m);
        }
        int i2 = this.f19960l;
        if (i2 != 0) {
            textView.setText(i2);
        }
        a(this.f19962n);
        ((Button) viewGroup2.findViewById(R.id.material_timepicker_ok_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                for (View.OnClickListener onClick : b.this.f19949a) {
                    onClick.onClick(view);
                }
                b.this.dismiss();
            }
        });
        ((Button) viewGroup2.findViewById(R.id.material_timepicker_cancel_button)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                for (View.OnClickListener onClick : b.this.f19950b) {
                    onClick.onClick(view);
                }
                b.this.dismiss();
            }
        });
        this.f19962n.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                b bVar = b.this;
                int unused = bVar.f19963o = bVar.f19963o == 0 ? 1 : 0;
                b bVar2 = b.this;
                bVar2.a(bVar2.f19962n);
            }
        });
        return viewGroup2;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        for (DialogInterface.OnDismissListener onDismiss : this.f19952d) {
            onDismiss.onDismiss(dialogInterface);
        }
        super.onDismiss(dialogInterface);
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putParcelable("TIME_PICKER_TIME_MODEL", this.f19964p);
        bundle.putInt("TIME_PICKER_INPUT_MODE", this.f19963o);
        bundle.putInt("TIME_PICKER_TITLE_RES", this.f19960l);
        bundle.putString("TIME_PICKER_TITLE_TEXT", this.f19961m);
        bundle.putInt("TIME_PICKER_OVERRIDE_THEME_RES_ID", this.f19965q);
    }

    public void onStop() {
        super.onStop();
        this.f19957i = null;
        this.f19955g = null;
        this.f19956h = null;
        this.f19953e = null;
    }
}
