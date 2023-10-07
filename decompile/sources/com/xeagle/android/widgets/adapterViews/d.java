package com.xeagle.android.widgets.adapterViews;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.flypro.core.parameters.Parameter;
import com.flypro.core.parameters.ParameterMetadata;
import com.xeagle.android.utils.file.IO.f;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class d extends a<ParamsAdapterItem> {

    /* renamed from: a  reason: collision with root package name */
    private static final DecimalFormat f25714a = Parameter.b();

    /* renamed from: b  reason: collision with root package name */
    private final int f25715b;

    /* renamed from: c  reason: collision with root package name */
    private final int f25716c;

    /* renamed from: d  reason: collision with root package name */
    private final LayoutInflater f25717d;

    /* renamed from: e  reason: collision with root package name */
    private Map<String, ParameterMetadata> f25718e;

    /* renamed from: f  reason: collision with root package name */
    private View f25719f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public a f25720g;

    /* renamed from: com.xeagle.android.widgets.adapterViews.d$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f25721a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.xeagle.android.widgets.adapterViews.ParamsAdapterItem$Validation[] r0 = com.xeagle.android.widgets.adapterViews.ParamsAdapterItem.Validation.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f25721a = r0
                com.xeagle.android.widgets.adapterViews.ParamsAdapterItem$Validation r1 = com.xeagle.android.widgets.adapterViews.ParamsAdapterItem.Validation.VALID     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f25721a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xeagle.android.widgets.adapterViews.ParamsAdapterItem$Validation r1 = com.xeagle.android.widgets.adapterViews.ParamsAdapterItem.Validation.INVALID     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.widgets.adapterViews.d.AnonymousClass1.<clinit>():void");
        }
    }

    public interface a {
        void a(int i2, EditText editText);
    }

    private class b implements TextWatcher, View.OnClickListener {

        /* renamed from: b  reason: collision with root package name */
        private int f25723b;

        /* renamed from: c  reason: collision with root package name */
        private TextView f25724c;

        /* renamed from: d  reason: collision with root package name */
        private TextView f25725d;

        /* renamed from: e  reason: collision with root package name */
        private EditText f25726e;

        private b() {
        }

        /* synthetic */ b(d dVar, AnonymousClass1 r2) {
            this();
        }

        public TextView a() {
            return this.f25724c;
        }

        public void a(int i2) {
            this.f25723b = i2;
        }

        public void a(EditText editText) {
            this.f25726e = editText;
        }

        public void a(TextView textView) {
            this.f25724c = textView;
        }

        public void a(ParamsAdapterItem paramsAdapterItem) {
            int i2;
            if (paramsAdapterItem.d()) {
                int i3 = AnonymousClass1.f25721a[paramsAdapterItem.e().ordinal()];
                i2 = i3 != 1 ? i3 != 2 ? R.style.paramValueChanged : R.style.paramValueInvalid : R.style.paramValueValid;
            } else {
                i2 = R.style.paramValueUnchanged;
            }
            this.f25726e.setTextAppearance(d.this.b(), i2);
        }

        public void afterTextChanged(Editable editable) {
            if (this.f25723b < d.this.getCount()) {
                ParamsAdapterItem paramsAdapterItem = (ParamsAdapterItem) d.this.getItem(this.f25723b);
                paramsAdapterItem.a(editable.toString());
                a(paramsAdapterItem);
            }
        }

        public TextView b() {
            return this.f25725d;
        }

        public void b(TextView textView) {
            this.f25725d = textView;
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public EditText c() {
            return this.f25726e;
        }

        public void onClick(View view) {
            d.this.d();
            if (d.this.f25720g != null) {
                d.this.f25720g.a(this.f25723b, this.f25726e);
            }
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    }

    public d(Context context, int i2) {
        this(context, i2, new ArrayList());
    }

    public d(Context context, int i2, List<ParamsAdapterItem> list) {
        super(context, i2, list);
        this.f25715b = i2;
        this.f25716c = context.getResources().getColor(R.color.paramAltRow);
        this.f25717d = LayoutInflater.from(context);
    }

    private ParameterMetadata a(String str) {
        Map<String, ParameterMetadata> map = this.f25718e;
        if (map == null) {
            return null;
        }
        return map.get(str);
    }

    private String a(ParameterMetadata parameterMetadata) {
        if (parameterMetadata == null) {
            return "";
        }
        String b2 = parameterMetadata.b();
        if (parameterMetadata.d() == null) {
            return b2;
        }
        return b2 + " (" + parameterMetadata.d() + ")";
    }

    private void a(View view) {
        if (view != null) {
            view.clearFocus();
            ((InputMethodManager) b().getSystemService("input_method")).hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    private void a(Parameter parameter) {
        try {
            Parameter.a(parameter.f14455a);
            a(new ParamsAdapterItem(parameter, a(parameter.f14455a)));
        } catch (Exception unused) {
        }
    }

    private void b(en.a aVar) {
        String a2;
        this.f25718e = null;
        dz.b i2 = aVar.i();
        if (i2 != null && (a2 = i2.a()) != null) {
            try {
                this.f25718e = f.a(b(), a2);
            } catch (Exception unused) {
            }
        }
    }

    public void a(a aVar) {
        this.f25720g = aVar;
    }

    public void a(en.a aVar) {
        b(aVar);
        for (int i2 = 0; i2 < getCount(); i2++) {
            ParamsAdapterItem paramsAdapterItem = (ParamsAdapterItem) getItem(i2);
            paramsAdapterItem.a(a(paramsAdapterItem.a().f14455a));
        }
        notifyDataSetChanged();
    }

    public void a(en.a aVar, Set<Parameter> set) {
        b(aVar);
        a();
        for (Parameter a2 : set) {
            a(a2);
        }
    }

    public void d() {
        View view = this.f25719f;
        if (view != null) {
            a(view);
            this.f25719f = null;
        }
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        b bVar;
        int i3 = 0;
        if (view == null) {
            view = this.f25717d.inflate(this.f25715b, viewGroup, false);
            bVar = new b(this, (AnonymousClass1) null);
            bVar.a((TextView) view.findViewById(R.id.params_row_name));
            bVar.b((TextView) view.findViewById(R.id.params_row_desc));
            bVar.a((EditText) view.findViewById(R.id.params_row_value));
            view.setTag(bVar);
        } else {
            bVar = (b) view.getTag();
            EditText c2 = bVar.c();
            if (c2.hasFocus()) {
                a((View) c2);
            }
            c2.removeTextChangedListener(bVar);
            c2.setOnFocusChangeListener((View.OnFocusChangeListener) null);
        }
        ParamsAdapterItem paramsAdapterItem = (ParamsAdapterItem) getItem(i2);
        Parameter a2 = paramsAdapterItem.a();
        ParameterMetadata b2 = paramsAdapterItem.b();
        bVar.a(i2);
        bVar.a().setText(a2.f14455a);
        bVar.b().setText(a(b2));
        bVar.a(paramsAdapterItem);
        EditText c3 = bVar.c();
        c3.setText(a2.a());
        bVar.a().setOnClickListener(bVar);
        bVar.b().setOnClickListener(bVar);
        c3.addTextChangedListener(bVar);
        if (i2 % 2 == 1) {
            i3 = this.f25716c;
        }
        view.setBackgroundColor(i3);
        return view;
    }
}
