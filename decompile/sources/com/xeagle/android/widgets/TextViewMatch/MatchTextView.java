package com.xeagle.android.widgets.TextViewMatch;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextUtils;
import android.util.AttributeSet;
import com.xeagle.R;

public class MatchTextView extends MatchView {

    /* renamed from: a  reason: collision with root package name */
    String f25627a;

    /* renamed from: b  reason: collision with root package name */
    float f25628b;

    /* renamed from: c  reason: collision with root package name */
    int f25629c;

    public MatchTextView(Context context) {
        super(context);
        a();
    }

    public MatchTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a(attributeSet);
    }

    public MatchTextView(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a(attributeSet);
    }

    /* access modifiers changed from: package-private */
    public void a() {
        setBackgroundColor(0);
        if (!TextUtils.isEmpty(this.f25627a)) {
            a(this.f25629c);
            setTextSize(this.f25628b);
            a(this.f25627a);
            c();
        }
    }

    /* access modifiers changed from: package-private */
    public void a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, R.styleable.match);
        this.f25628b = obtainStyledAttributes.getDimension(2, 25.0f);
        this.f25629c = obtainStyledAttributes.getColor(1, -1);
        this.f25627a = obtainStyledAttributes.getString(0);
        a();
    }

    public void setText(String str) {
        this.f25627a = str;
        a();
    }
}
