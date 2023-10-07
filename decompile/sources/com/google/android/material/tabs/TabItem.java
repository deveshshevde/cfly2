package com.google.android.material.tabs;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.af;
import com.google.android.material.R;

public class TabItem extends View {

    /* renamed from: a  reason: collision with root package name */
    public final CharSequence f19657a;

    /* renamed from: b  reason: collision with root package name */
    public final Drawable f19658b;

    /* renamed from: c  reason: collision with root package name */
    public final int f19659c;

    public TabItem(Context context) {
        this(context, (AttributeSet) null);
    }

    public TabItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        af a2 = af.a(context, attributeSet, R.styleable.TabItem);
        this.f19657a = a2.c(R.styleable.TabItem_android_text);
        this.f19658b = a2.a(R.styleable.TabItem_android_icon);
        this.f19659c = a2.g(R.styleable.TabItem_android_layout, 0);
        a2.b();
    }
}
