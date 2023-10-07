package com.google.android.material.textfield;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.google.android.material.R;
import com.google.android.material.textfield.TextInputLayout;

class a extends e {
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public final TextWatcher f19795d = new TextWatcher() {
        public void afterTextChanged(Editable editable) {
            if (a.this.f19844a.getSuffixText() == null) {
                a aVar = a.this;
                aVar.b(aVar.f19844a.hasFocus() && a.b(editable));
            }
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public final View.OnFocusChangeListener f19796e = new View.OnFocusChangeListener() {
        public void onFocusChange(View view, boolean z2) {
            boolean z3 = true;
            boolean z4 = !TextUtils.isEmpty(((EditText) view).getText());
            a aVar = a.this;
            if (!z4 || !z2) {
                z3 = false;
            }
            aVar.b(z3);
        }
    };

    /* renamed from: f  reason: collision with root package name */
    private final TextInputLayout.b f19797f = new TextInputLayout.b() {
        public void a(TextInputLayout textInputLayout) {
            EditText editText = textInputLayout.getEditText();
            textInputLayout.setEndIconVisible(editText.hasFocus() && a.b(editText.getText()));
            textInputLayout.setEndIconCheckable(false);
            editText.setOnFocusChangeListener(a.this.f19796e);
            editText.removeTextChangedListener(a.this.f19795d);
            editText.addTextChangedListener(a.this.f19795d);
        }
    };

    /* renamed from: g  reason: collision with root package name */
    private final TextInputLayout.c f19798g = new TextInputLayout.c() {
        public void a(TextInputLayout textInputLayout, int i2) {
            final EditText editText = textInputLayout.getEditText();
            if (editText != null && i2 == 2) {
                editText.post(new Runnable() {
                    public void run() {
                        editText.removeTextChangedListener(a.this.f19795d);
                    }
                });
                if (editText.getOnFocusChangeListener() == a.this.f19796e) {
                    editText.setOnFocusChangeListener((View.OnFocusChangeListener) null);
                }
            }
        }
    };

    /* renamed from: h  reason: collision with root package name */
    private AnimatorSet f19799h;

    /* renamed from: i  reason: collision with root package name */
    private ValueAnimator f19800i;

    a(TextInputLayout textInputLayout) {
        super(textInputLayout);
    }

    private ValueAnimator a(float... fArr) {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(fArr);
        ofFloat.setInterpolator(gl.a.f28535a);
        ofFloat.setDuration(100);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                a.this.f19846c.setAlpha(((Float) valueAnimator.getAnimatedValue()).floatValue());
            }
        });
        return ofFloat;
    }

    /* access modifiers changed from: private */
    public void b(boolean z2) {
        boolean z3 = this.f19844a.g() == z2;
        if (z2 && !this.f19799h.isRunning()) {
            this.f19800i.cancel();
            this.f19799h.start();
            if (z3) {
                this.f19799h.end();
            }
        } else if (!z2) {
            this.f19799h.cancel();
            this.f19800i.start();
            if (z3) {
                this.f19800i.end();
            }
        }
    }

    /* access modifiers changed from: private */
    public static boolean b(Editable editable) {
        return editable.length() > 0;
    }

    private void c() {
        ValueAnimator d2 = d();
        ValueAnimator a2 = a(0.0f, 1.0f);
        AnimatorSet animatorSet = new AnimatorSet();
        this.f19799h = animatorSet;
        animatorSet.playTogether(new Animator[]{d2, a2});
        this.f19799h.addListener(new AnimatorListenerAdapter() {
            public void onAnimationStart(Animator animator) {
                a.this.f19844a.setEndIconVisible(true);
            }
        });
        ValueAnimator a3 = a(1.0f, 0.0f);
        this.f19800i = a3;
        a3.addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                a.this.f19844a.setEndIconVisible(false);
            }
        });
    }

    private ValueAnimator d() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.8f, 1.0f});
        ofFloat.setInterpolator(gl.a.f28538d);
        ofFloat.setDuration(150);
        ofFloat.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float floatValue = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                a.this.f19846c.setScaleX(floatValue);
                a.this.f19846c.setScaleY(floatValue);
            }
        });
        return ofFloat;
    }

    /* access modifiers changed from: package-private */
    public void a() {
        this.f19844a.setEndIconDrawable(c.a.b(this.f19845b, R.drawable.mtrl_ic_cancel));
        this.f19844a.setEndIconContentDescription(this.f19844a.getResources().getText(R.string.clear_text_end_icon_content_description));
        this.f19844a.setEndIconOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Editable text = a.this.f19844a.getEditText().getText();
                if (text != null) {
                    text.clear();
                }
                a.this.f19844a.h();
            }
        });
        this.f19844a.a(this.f19797f);
        this.f19844a.a(this.f19798g);
        c();
    }

    /* access modifiers changed from: package-private */
    public void a(boolean z2) {
        if (this.f19844a.getSuffixText() != null) {
            b(z2);
        }
    }
}
