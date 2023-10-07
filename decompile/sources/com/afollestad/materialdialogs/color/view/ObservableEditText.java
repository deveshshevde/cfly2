package com.afollestad.materialdialogs.color.view;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import androidx.appcompat.widget.AppCompatEditText;
import kotlin.TypeCastException;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.text.f;
import mm.b;

public final class ObservableEditText extends AppCompatEditText {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public b<? super String, l> f7532a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public boolean f7533b;

    /* renamed from: c  reason: collision with root package name */
    private final a f7534c = new a(this);

    public static final class a implements TextWatcher {

        /* renamed from: a  reason: collision with root package name */
        final /* synthetic */ ObservableEditText f7535a;

        a(ObservableEditText observableEditText) {
            this.f7535a = observableEditText;
        }

        public void afterTextChanged(Editable editable) {
            this.f7535a.f7533b = false;
        }

        public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
        }

        public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            b b2;
            h.c(charSequence, "s");
            if (!this.f7535a.f7533b && (b2 = this.f7535a.f7532a) != null) {
                l lVar = (l) b2.invoke(charSequence.toString());
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ObservableEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        h.c(context, "context");
    }

    public final void a(CharSequence charSequence) {
        h.c(charSequence, "text");
        this.f7533b = true;
        setText(charSequence);
    }

    public final void a(b<? super String, l> bVar) {
        this.f7532a = bVar;
    }

    public final int getTextLength() {
        return getTextOrEmpty().length();
    }

    public final String getTextOrEmpty() {
        String obj;
        Editable text = getText();
        if (!(text == null || (obj = text.toString()) == null)) {
            if (obj != null) {
                String obj2 = f.b(obj).toString();
                if (obj2 != null) {
                    return obj2;
                }
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.CharSequence");
            }
        }
        return "";
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        addTextChangedListener(this.f7534c);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        removeTextChangedListener(this.f7534c);
    }
}
