package com.google.android.gms.common;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.base.R;
import com.google.android.gms.common.api.Scope;
import com.google.android.gms.common.internal.al;
import com.google.android.gms.common.internal.zaaa;
import com.google.android.gms.dynamic.RemoteCreator;

public final class SignInButton extends FrameLayout implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    private int f17363a;

    /* renamed from: b  reason: collision with root package name */
    private int f17364b;

    /* renamed from: c  reason: collision with root package name */
    private View f17365c;

    /* renamed from: d  reason: collision with root package name */
    private View.OnClickListener f17366d;

    public SignInButton(Context context) {
        this(context, (AttributeSet) null);
    }

    public SignInButton(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: finally extract failed */
    public SignInButton(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        this.f17366d = null;
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.SignInButton, 0, 0);
        try {
            this.f17363a = obtainStyledAttributes.getInt(R.styleable.SignInButton_buttonSize, 0);
            this.f17364b = obtainStyledAttributes.getInt(R.styleable.SignInButton_colorScheme, 2);
            obtainStyledAttributes.recycle();
            a(this.f17363a, this.f17364b);
        } catch (Throwable th) {
            obtainStyledAttributes.recycle();
            throw th;
        }
    }

    private final void a(Context context) {
        View view = this.f17365c;
        if (view != null) {
            removeView(view);
        }
        try {
            this.f17365c = al.a(context, this.f17363a, this.f17364b);
        } catch (RemoteCreator.RemoteCreatorException unused) {
            Log.w("SignInButton", "Sign in button not found, using placeholder instead");
            int i2 = this.f17363a;
            int i3 = this.f17364b;
            zaaa zaaa = new zaaa(context, (AttributeSet) null);
            zaaa.a(context.getResources(), i2, i3);
            this.f17365c = zaaa;
        }
        addView(this.f17365c);
        this.f17365c.setEnabled(isEnabled());
        this.f17365c.setOnClickListener(this);
    }

    public void a(int i2, int i3) {
        this.f17363a = i2;
        this.f17364b = i3;
        a(getContext());
    }

    public void onClick(View view) {
        View.OnClickListener onClickListener = this.f17366d;
        if (onClickListener != null && view == this.f17365c) {
            onClickListener.onClick(this);
        }
    }

    public void setColorScheme(int i2) {
        a(this.f17363a, i2);
    }

    public void setEnabled(boolean z2) {
        super.setEnabled(z2);
        this.f17365c.setEnabled(z2);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.f17366d = onClickListener;
        View view = this.f17365c;
        if (view != null) {
            view.setOnClickListener(this);
        }
    }

    @Deprecated
    public void setScopes(Scope[] scopeArr) {
        a(this.f17363a, this.f17364b);
    }

    public void setSize(int i2) {
        a(i2, this.f17364b);
    }
}
