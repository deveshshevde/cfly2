package com.xeagle.android.vjoystick.fragment.http_fragment;

import android.content.Context;
import android.util.AttributeSet;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ExGridLayoutManager extends GridLayoutManager {
    public ExGridLayoutManager(Context context, int i2) {
        super(context, i2);
    }

    public ExGridLayoutManager(Context context, AttributeSet attributeSet, int i2, int i3) {
        super(context, attributeSet, i2, i3);
    }

    public void c(RecyclerView.n nVar, RecyclerView.s sVar) {
        try {
            super.c(nVar, sVar);
        } catch (IndexOutOfBoundsException e2) {
            e2.printStackTrace();
        }
    }
}
