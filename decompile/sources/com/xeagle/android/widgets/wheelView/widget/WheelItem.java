package com.xeagle.android.widgets.wheelView.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import lo.a;

public class WheelItem extends FrameLayout {

    /* renamed from: a  reason: collision with root package name */
    private ImageView f26151a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f26152b;

    public WheelItem(Context context) {
        super(context);
        a();
    }

    public WheelItem(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        a();
    }

    public WheelItem(Context context, AttributeSet attributeSet, int i2) {
        super(context, attributeSet, i2);
        a();
    }

    private void a() {
        LinearLayout linearLayout = new LinearLayout(getContext());
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, a.a(getContext(), 45.0f));
        linearLayout.setOrientation(0);
        linearLayout.setPadding(20, 20, 20, 20);
        linearLayout.setGravity(17);
        addView(linearLayout, layoutParams);
        ImageView imageView = new ImageView(getContext());
        this.f26151a = imageView;
        imageView.setTag(100);
        this.f26151a.setVisibility(8);
        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(-2, -2);
        layoutParams2.rightMargin = 20;
        linearLayout.addView(this.f26151a, layoutParams2);
        TextView textView = new TextView(getContext());
        this.f26152b = textView;
        textView.setTag(101);
        this.f26152b.setEllipsize(TextUtils.TruncateAt.END);
        this.f26152b.setSingleLine();
        this.f26152b.setIncludeFontPadding(false);
        this.f26152b.setGravity(17);
        this.f26152b.setTextColor(-16777216);
        linearLayout.addView(this.f26152b, new FrameLayout.LayoutParams(-1, -1));
    }

    public void setImage(int i2) {
        this.f26151a.setVisibility(0);
        this.f26151a.setImageResource(i2);
    }

    public void setText(CharSequence charSequence) {
        this.f26152b.setText(charSequence);
    }
}
