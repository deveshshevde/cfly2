package com.google.android.material.textfield;

import android.text.TextWatcher;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.widget.EditText;
import c.a;
import com.google.android.material.R;
import com.google.android.material.internal.k;
import com.google.android.material.textfield.TextInputLayout;

class h extends e {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final TextWatcher f19873d = new k() {
        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            h.this.f19846c.setChecked(!h.this.c());
        }
    };

    /* renamed from: e  reason: collision with root package name */
    private final TextInputLayout.b f19874e = new TextInputLayout.b() {
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(true);
            textInputLayout.setEndIconCheckable(true);
            h.this.f19846c.setChecked(true ^ h.this.c());
            editText.removeTextChangedListener(h.this.f19873d);
            editText.addTextChangedListener(h.this.f19873d);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final TextInputLayout.c f19875f = new TextInputLayout.c() {
        public void a(TextInputLayout textInputLayout, int i2) {
            final EditText editText = textInputLayout.getEditText();
            if (editText != null && i2 == 1) {
                editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
                editText.post(new Runnable() {
                    public void run() {
                        editText.removeTextChangedListener(h.this.f19873d);
                    }
                });
            }
        }
    };

    h(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    private static boolean a(EditText editText) {
        return editText != null && (editText.getInputType() == 16 || editText.getInputType() == 128 || editText.getInputType() == 144 || editText.getInputType() == 224);
    }

    /* access modifiers changed from: private */
    public boolean c() {
        EditText editText = this.f19844a.getEditText();
        return editText != null && (editText.getTransformationMethod() instanceof PasswordTransformationMethod);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f19844a.setEndIconDrawable(a.b(this.f19845b, R.drawable.design_password_eye));
        this.f19844a.setEndIconContentDescription(this.f19844a.getResources().getText(R.string.password_toggle_content_description));
        this.f19844a.setEndIconOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditText editText = h.this.f19844a.getEditText();
                if (editText != null) {
                    int selectionEnd = editText.getSelectionEnd();
                    editText.setTransformationMethod(h.this.c() ? null : PasswordTransformationMethod.getInstance());
                    if (selectionEnd >= 0) {
                        editText.setSelection(selectionEnd);
                    }
                    h.this.f19844a.h();
                }
            }
        });
        this.f19844a.a(this.f19874e);
        this.f19844a.a(this.f19875f);
        EditText editText = this.f19844a.getEditText();
        if (a(editText)) {
            editText.setTransformationMethod(PasswordTransformationMethod.getInstance());
        }
    }
}
