package com.google.android.material.timepicker;

import android.text.Editable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.textfield.TextInputLayout;

class f implements View.OnKeyListener, TextView.OnEditorActionListener {

    /* renamed from: a  reason: collision with root package name */
    private final ChipTextInputComboView f19979a;

    /* renamed from: b  reason: collision with root package name */
    private final ChipTextInputComboView f19980b;

    /* renamed from: c  reason: collision with root package name */
    private final TimeModel f19981c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f19982d = false;

    f(ChipTextInputComboView chipTextInputComboView, ChipTextInputComboView chipTextInputComboView2, TimeModel timeModel) {
        this.f19979a = chipTextInputComboView;
        this.f19980b = chipTextInputComboView2;
        this.f19981c = timeModel;
    }

    private void a(int i2) {
        boolean z2 = true;
        this.f19980b.setChecked(i2 == 12);
        ChipTextInputComboView chipTextInputComboView = this.f19979a;
        if (i2 != 10) {
            z2 = false;
        }
        chipTextInputComboView.setChecked(z2);
        this.f19981c.f19930d = i2;
    }

    private boolean a(int i2, KeyEvent keyEvent, EditText editText) {
        if (!(i2 == 67 && keyEvent.getAction() == 0 && TextUtils.isEmpty(editText.getText()))) {
            return false;
        }
        a(10);
        return true;
    }

    private boolean b(int i2, KeyEvent keyEvent, EditText editText) {
        Editable text = editText.getText();
        if (text == null) {
            return false;
        }
        if (!(i2 >= 7 && i2 <= 16 && keyEvent.getAction() == 1 && editText.getSelectionStart() == 2 && text.length() == 2)) {
            return false;
        }
        a(12);
        return true;
    }

    public void a() {
        TextInputLayout a2 = this.f19979a.a();
        TextInputLayout a3 = this.f19980b.a();
        EditText editText = a2.getEditText();
        EditText editText2 = a3.getEditText();
        editText.setImeOptions(268435461);
        editText2.setImeOptions(268435462);
        editText.setOnEditorActionListener(this);
        editText.setOnKeyListener(this);
        editText2.setOnKeyListener(this);
    }

    public boolean onEditorAction(TextView textView, int i2, KeyEvent keyEvent) {
        boolean z2 = i2 == 5;
        if (z2) {
            a(12);
        }
        return z2;
    }

    public boolean onKey(View view, int i2, KeyEvent keyEvent) {
        if (this.f19982d) {
            return false;
        }
        this.f19982d = true;
        EditText editText = (EditText) view;
        boolean a2 = this.f19981c.f19930d == 12 ? a(i2, keyEvent, editText) : b(i2, keyEvent, editText);
        this.f19982d = false;
        return a2;
    }
}
