package com.google.android.material.timepicker;

import android.content.Context;
import android.content.res.Configuration;
import android.os.Build;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Checkable;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.material.R;
import com.google.android.material.chip.Chip;
import com.google.android.material.internal.k;
import com.google.android.material.textfield.TextInputLayout;
import java.util.Arrays;
import t.ac;

class ChipTextInputComboView extends FrameLayout implements Checkable {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public final Chip f19882a;

    /* renamed from: b  reason: collision with root package name */
    private final TextInputLayout f19883b;

    /* renamed from: c  reason: collision with root package name */
    private final EditText f19884c;

    /* renamed from: d  reason: collision with root package name */
    private TextWatcher f19885d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f19886e;

    private class a extends k {
        private a() {
        }

        public void afterTextChanged(Editable editable) {
            if (TextUtils.isEmpty(editable)) {
                ChipTextInputComboView.this.f19882a.setText(ChipTextInputComboView.this.b("00"));
            } else {
                ChipTextInputComboView.this.f19882a.setText(ChipTextInputComboView.this.b(editable));
            }
        }
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ChipTextInputComboView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        LayoutInflater from = LayoutInflater.from(context);
        Chip chip = (Chip) from.inflate(R.layout.material_time_chip, this, false);
        this.f19882a = chip;
        TextInputLayout textInputLayout = (TextInputLayout) from.inflate(R.layout.material_time_input, this, false);
        this.f19883b = textInputLayout;
        EditText editText = textInputLayout.getEditText();
        this.f19884c = editText;
        editText.setVisibility(4);
        a aVar = new a();
        this.f19885d = aVar;
        editText.addTextChangedListener(aVar);
        b();
        addView(chip);
        addView(textInputLayout);
        this.f19886e = (TextView) findViewById(R.id.material_label);
        editText.setSaveEnabled(false);
    }

    /* access modifiers changed from: private */
    public String b(CharSequence charSequence) {
        return TimeModel.a(getResources(), charSequence);
    }

    private void b() {
        if (Build.VERSION.SDK_INT >= 24) {
            this.f19884c.setImeHintLocales(getContext().getResources().getConfiguration().getLocales());
        }
    }

    public TextInputLayout a() {
        return this.f19883b;
    }

    public void a(InputFilter inputFilter) {
        InputFilter[] filters = this.f19884c.getFilters();
        InputFilter[] inputFilterArr = (InputFilter[]) Arrays.copyOf(filters, filters.length + 1);
        inputFilterArr[filters.length] = inputFilter;
        this.f19884c.setFilters(inputFilterArr);
    }

    public void a(CharSequence charSequence) {
        this.f19882a.setText(b(charSequence));
        if (!TextUtils.isEmpty(this.f19884c.getText())) {
            this.f19884c.removeTextChangedListener(this.f19885d);
            this.f19884c.setText((CharSequence) null);
            this.f19884c.addTextChangedListener(this.f19885d);
        }
    }

    public void a(t.a aVar) {
        ac.a((View) this.f19882a, aVar);
    }

    public boolean isChecked() {
        return this.f19882a.isChecked();
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        b();
    }

    public void setChecked(boolean z2) {
        this.f19882a.setChecked(z2);
        int i2 = 0;
        this.f19884c.setVisibility(z2 ? 0 : 4);
        Chip chip = this.f19882a;
        if (z2) {
            i2 = 8;
        }
        chip.setVisibility(i2);
        if (isChecked()) {
            this.f19884c.requestFocus();
            if (!TextUtils.isEmpty(this.f19884c.getText())) {
                EditText editText = this.f19884c;
                editText.setSelection(editText.getText().length());
            }
        }
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f19882a.setOnClickListener(onClickListener);
    }

    public void setTag(int i2, Object obj) {
        this.f19882a.setTag(i2, obj);
    }

    public void toggle() {
        this.f19882a.toggle();
    }
}
