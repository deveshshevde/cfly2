package com.google.android.material.datepicker;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.InsetDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Bundle;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.c;
import androidx.fragment.app.s;
import com.google.android.material.R;
import com.google.android.material.datepicker.CalendarConstraints;
import com.google.android.material.internal.CheckableImageButton;
import gt.b;
import gw.h;
import java.util.Iterator;
import java.util.LinkedHashSet;
import t.a;
import t.ac;

public final class f<S> extends c {

    /* renamed from: a  reason: collision with root package name */
    static final Object f18974a = "CONFIRM_BUTTON_TAG";

    /* renamed from: b  reason: collision with root package name */
    static final Object f18975b = "CANCEL_BUTTON_TAG";

    /* renamed from: c  reason: collision with root package name */
    static final Object f18976c = "TOGGLE_BUTTON_TAG";
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final LinkedHashSet<g<? super S>> f18977d = new LinkedHashSet<>();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final LinkedHashSet<View.OnClickListener> f18978e = new LinkedHashSet<>();

    /* renamed from: f  reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnCancelListener> f18979f = new LinkedHashSet<>();

    /* renamed from: g  reason: collision with root package name */
    private final LinkedHashSet<DialogInterface.OnDismissListener> f18980g = new LinkedHashSet<>();

    /* renamed from: h  reason: collision with root package name */
    private int f18981h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public DateSelector<S> f18982i;

    /* renamed from: j  reason: collision with root package name */
    private l<S> f18983j;

    /* renamed from: k  reason: collision with root package name */
    private CalendarConstraints f18984k;

    /* renamed from: l  reason: collision with root package name */
    private MaterialCalendar<S> f18985l;

    /* renamed from: m  reason: collision with root package name */
    private int f18986m;

    /* renamed from: n  reason: collision with root package name */
    private CharSequence f18987n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f18988o;

    /* renamed from: p  reason: collision with root package name */
    private int f18989p;

    /* renamed from: q  reason: collision with root package name */
    private TextView f18990q;
    /* access modifiers changed from: private */

    /* renamed from: r  reason: collision with root package name */
    public CheckableImageButton f18991r;

    /* renamed from: s  reason: collision with root package name */
    private h f18992s;
    /* access modifiers changed from: private */

    /* renamed from: t  reason: collision with root package name */
    public Button f18993t;

    /* access modifiers changed from: private */
    public void a(CheckableImageButton checkableImageButton) {
        this.f18991r.setContentDescription(checkableImageButton.getContext().getString(this.f18991r.isChecked() ? R.string.mtrl_picker_toggle_to_calendar_input_mode : R.string.mtrl_picker_toggle_to_text_input_mode));
    }

    static boolean a(Context context) {
        return a(context, 16843277);
    }

    static boolean a(Context context, int i2) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(b.a(context, R.attr.materialCalendarStyle, MaterialCalendar.class.getCanonicalName()), new int[]{i2});
        boolean z2 = obtainStyledAttributes.getBoolean(0, false);
        obtainStyledAttributes.recycle();
        return z2;
    }

    static boolean b(Context context) {
        return a(context, R.attr.nestedScrollable);
    }

    private int c(Context context) {
        int i2 = this.f18981h;
        return i2 != 0 ? i2 : this.f18982i.b(context);
    }

    /* access modifiers changed from: private */
    public void c() {
        String a2 = a();
        this.f18990q.setContentDescription(String.format(getString(R.string.mtrl_picker_announce_current_selection), new Object[]{a2}));
        this.f18990q.setText(a2);
    }

    /* access modifiers changed from: private */
    public void d() {
        int c2 = c(requireContext());
        this.f18985l = MaterialCalendar.a(this.f18982i, c2, this.f18984k);
        this.f18983j = this.f18991r.isChecked() ? h.a(this.f18982i, c2, this.f18984k) : this.f18985l;
        c();
        s a2 = getChildFragmentManager().a();
        a2.b(R.id.mtrl_calendar_frame, this.f18983j);
        a2.e();
        this.f18983j.a(new k<S>() {
            public void a() {
                f.this.f18993t.setEnabled(false);
            }

            public void a(S s2) {
                f.this.c();
                f.this.f18993t.setEnabled(f.this.f18982i.b());
            }
        });
    }

    private void d(Context context) {
        this.f18991r.setTag(f18976c);
        this.f18991r.setImageDrawable(e(context));
        this.f18991r.setChecked(this.f18989p != 0);
        ac.a((View) this.f18991r, (a) null);
        a(this.f18991r);
        this.f18991r.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.f18993t.setEnabled(f.this.f18982i.b());
                f.this.f18991r.toggle();
                f fVar = f.this;
                fVar.a(fVar.f18991r);
                f.this.d();
            }
        });
    }

    private static Drawable e(Context context) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{16842912}, c.a.b(context, R.drawable.material_ic_calendar_black_24dp));
        stateListDrawable.addState(new int[0], c.a.b(context, R.drawable.material_ic_edit_black_24dp));
        return stateListDrawable;
    }

    private static int f(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelSize = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_navigation_height) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_top_padding) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_navigation_bottom_padding);
        int dimensionPixelSize2 = resources.getDimensionPixelSize(R.dimen.mtrl_calendar_days_of_week_height);
        return dimensionPixelSize + dimensionPixelSize2 + (i.f19002a * resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_height)) + ((i.f19002a - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_vertical_padding)) + resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_bottom_padding);
    }

    private static int g(Context context) {
        Resources resources = context.getResources();
        int dimensionPixelOffset = resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_content_padding);
        int i2 = Month.a().f18924c;
        return (dimensionPixelOffset * 2) + (resources.getDimensionPixelSize(R.dimen.mtrl_calendar_day_width) * i2) + ((i2 - 1) * resources.getDimensionPixelOffset(R.dimen.mtrl_calendar_month_horizontal_padding));
    }

    public String a() {
        return this.f18982i.a(getContext());
    }

    public final S b() {
        return this.f18982i.a();
    }

    public final void onCancel(DialogInterface dialogInterface) {
        Iterator it2 = this.f18979f.iterator();
        while (it2.hasNext()) {
            ((DialogInterface.OnCancelListener) it2.next()).onCancel(dialogInterface);
        }
        super.onCancel(dialogInterface);
    }

    public final void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle == null) {
            bundle = getArguments();
        }
        this.f18981h = bundle.getInt("OVERRIDE_THEME_RES_ID");
        this.f18982i = (DateSelector) bundle.getParcelable("DATE_SELECTOR_KEY");
        this.f18984k = (CalendarConstraints) bundle.getParcelable("CALENDAR_CONSTRAINTS_KEY");
        this.f18986m = bundle.getInt("TITLE_TEXT_RES_ID_KEY");
        this.f18987n = bundle.getCharSequence("TITLE_TEXT_KEY");
        this.f18989p = bundle.getInt("INPUT_MODE_KEY");
    }

    public final Dialog onCreateDialog(Bundle bundle) {
        Dialog dialog = new Dialog(requireContext(), c(requireContext()));
        Context context = dialog.getContext();
        this.f18988o = a(context);
        int a2 = b.a(context, R.attr.colorSurface, f.class.getCanonicalName());
        h hVar = new h(context, (AttributeSet) null, R.attr.materialCalendarStyle, R.style.Widget_MaterialComponents_MaterialCalendar);
        this.f18992s = hVar;
        hVar.a(context);
        this.f18992s.g(ColorStateList.valueOf(a2));
        this.f18992s.r(ac.s(dialog.getWindow().getDecorView()));
        return dialog;
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(this.f18988o ? R.layout.mtrl_picker_fullscreen : R.layout.mtrl_picker_dialog, viewGroup);
        Context context = inflate.getContext();
        if (this.f18988o) {
            inflate.findViewById(R.id.mtrl_calendar_frame).setLayoutParams(new LinearLayout.LayoutParams(g(context), -2));
        } else {
            View findViewById = inflate.findViewById(R.id.mtrl_calendar_main_pane);
            View findViewById2 = inflate.findViewById(R.id.mtrl_calendar_frame);
            findViewById.setLayoutParams(new LinearLayout.LayoutParams(g(context), -1));
            findViewById2.setMinimumHeight(f(requireContext()));
        }
        TextView textView = (TextView) inflate.findViewById(R.id.mtrl_picker_header_selection_text);
        this.f18990q = textView;
        ac.d((View) textView, 1);
        this.f18991r = (CheckableImageButton) inflate.findViewById(R.id.mtrl_picker_header_toggle);
        TextView textView2 = (TextView) inflate.findViewById(R.id.mtrl_picker_title_text);
        CharSequence charSequence = this.f18987n;
        if (charSequence != null) {
            textView2.setText(charSequence);
        } else {
            textView2.setText(this.f18986m);
        }
        d(context);
        this.f18993t = (Button) inflate.findViewById(R.id.confirm_button);
        if (this.f18982i.b()) {
            this.f18993t.setEnabled(true);
        } else {
            this.f18993t.setEnabled(false);
        }
        this.f18993t.setTag(f18974a);
        this.f18993t.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Iterator it2 = f.this.f18977d.iterator();
                while (it2.hasNext()) {
                    ((g) it2.next()).a(f.this.b());
                }
                f.this.dismiss();
            }
        });
        Button button = (Button) inflate.findViewById(R.id.cancel_button);
        button.setTag(f18975b);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Iterator it2 = f.this.f18978e.iterator();
                while (it2.hasNext()) {
                    ((View.OnClickListener) it2.next()).onClick(view);
                }
                f.this.dismiss();
            }
        });
        return inflate;
    }

    public final void onDismiss(DialogInterface dialogInterface) {
        Iterator it2 = this.f18980g.iterator();
        while (it2.hasNext()) {
            ((DialogInterface.OnDismissListener) it2.next()).onDismiss(dialogInterface);
        }
        ViewGroup viewGroup = (ViewGroup) getView();
        if (viewGroup != null) {
            viewGroup.removeAllViews();
        }
        super.onDismiss(dialogInterface);
    }

    public final void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putInt("OVERRIDE_THEME_RES_ID", this.f18981h);
        bundle.putParcelable("DATE_SELECTOR_KEY", this.f18982i);
        CalendarConstraints.a aVar = new CalendarConstraints.a(this.f18984k);
        if (this.f18985l.a() != null) {
            aVar.a(this.f18985l.a().f18926e);
        }
        bundle.putParcelable("CALENDAR_CONSTRAINTS_KEY", aVar.a());
        bundle.putInt("TITLE_TEXT_RES_ID_KEY", this.f18986m);
        bundle.putCharSequence("TITLE_TEXT_KEY", this.f18987n);
    }

    public void onStart() {
        super.onStart();
        Window window = requireDialog().getWindow();
        if (this.f18988o) {
            window.setLayout(-1, -1);
            window.setBackgroundDrawable(this.f18992s);
        } else {
            window.setLayout(-2, -2);
            int dimensionPixelOffset = getResources().getDimensionPixelOffset(R.dimen.mtrl_calendar_dialog_background_inset);
            Rect rect = new Rect(dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset);
            window.setBackgroundDrawable(new InsetDrawable(this.f18992s, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset, dimensionPixelOffset));
            window.getDecorView().setOnTouchListener(new go.a(requireDialog(), rect));
        }
        d();
    }

    public void onStop() {
        this.f18983j.g();
        super.onStop();
    }
}
