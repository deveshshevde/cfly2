package com.xeagle.android.widgets.spinners;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

public class a extends ArrayAdapter<String> {

    /* renamed from: a  reason: collision with root package name */
    private boolean f26089a = false;

    /* renamed from: b  reason: collision with root package name */
    private boolean f26090b = false;

    public a(Context context, int i2) {
        super(context, i2);
    }

    public View getDropDownView(int i2, View view, ViewGroup viewGroup) {
        return super.getDropDownView(i2, view, viewGroup);
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        if (i2 >= getCount()) {
            i2 = 0;
        }
        TextView textView = (TextView) super.getView(i2, view, viewGroup);
        textView.setText((String) getItem(i2));
        return textView;
    }
}
