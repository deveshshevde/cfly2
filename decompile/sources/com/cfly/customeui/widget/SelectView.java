package com.cfly.customeui.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.cfly.customeui.R;

public class SelectView extends LinearLayout {

    /* renamed from: a  reason: collision with root package name */
    private TextView f10638a;

    /* renamed from: b  reason: collision with root package name */
    private TextView f10639b;

    /* renamed from: c  reason: collision with root package name */
    private boolean f10640c;

    public SelectView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        int i2;
        Resources resources;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.SelectView);
        int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SelectView_sub_text_size, 12);
        int color = obtainStyledAttributes.getColor(R.styleable.SelectView_sub_text_color, 0);
        String string = obtainStyledAttributes.getString(R.styleable.SelectView_sub_text);
        int dimensionPixelSize2 = obtainStyledAttributes.getDimensionPixelSize(R.styleable.SelectView_sub_text_size, 12);
        int color2 = obtainStyledAttributes.getColor(R.styleable.SelectView_sub_text_color, 0);
        String string2 = obtainStyledAttributes.getString(R.styleable.SelectView_sub_text);
        this.f10640c = obtainStyledAttributes.getBoolean(R.styleable.SelectView_is_selected, false);
        obtainStyledAttributes.recycle();
        this.f10638a = new TextView(context, attributeSet);
        this.f10639b = new TextView(context, attributeSet);
        this.f10638a.setGravity(1);
        this.f10639b.setGravity(1);
        this.f10638a.setPadding(0, 0, 0, 0);
        this.f10639b.setPadding(0, 0, 0, 0);
        this.f10638a.setText(string);
        this.f10638a.setTextSize((float) dimensionPixelSize);
        this.f10638a.setTextColor(color);
        this.f10639b.setText(string2);
        this.f10639b.setTextSize((float) dimensionPixelSize2);
        this.f10639b.setTextColor(color2);
        setGravity(17);
        setClickable(true);
        setFocusable(true);
        setOrientation(1);
        if (this.f10640c) {
            this.f10638a.setVisibility(0);
            resources = context.getResources();
            i2 = R.drawable.bt_corner_blue;
        } else {
            this.f10638a.setVisibility(8);
            resources = context.getResources();
            i2 = R.drawable.bt_corner_white;
        }
        setBackground(resources.getDrawable(i2));
    }

    public void setMainText(String str) {
        this.f10639b.setText(str);
    }

    public void setMainTextColor(int i2) {
        this.f10639b.setTextColor(i2);
    }

    public void setMainTextSize(int i2) {
        this.f10639b.setTextSize((float) i2);
    }

    public void setSelected(boolean z2) {
        this.f10640c = z2;
        invalidate();
    }

    public void setSubText(String str) {
        this.f10638a.setText(str);
    }

    public void setSubTextColor(int i2) {
        this.f10638a.setTextColor(i2);
    }

    public void setSubTextSize(int i2) {
        this.f10638a.setTextSize((float) i2);
    }
}
