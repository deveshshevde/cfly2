package com.xeagle.android.widgets.adapterViews;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.List;
import ko.a;

public class c extends ArrayAdapter<a> {

    /* renamed from: a  reason: collision with root package name */
    private List<a> f25713a;

    public c(Context context, List<a> list) {
        super(context, 0, list);
        this.f25713a = list;
    }

    public View getView(int i2, View view, ViewGroup viewGroup) {
        return this.f25713a.get(i2).a(getContext(), viewGroup);
    }
}
