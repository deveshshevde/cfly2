package com.google.android.material.datepicker;

import android.content.Context;
import android.util.DisplayMetrics;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.o;

class m extends LinearLayoutManager {
    m(Context context, int i2, boolean z2) {
        super(context, i2, z2);
    }

    public void a(RecyclerView recyclerView, RecyclerView.s sVar, int i2) {
        AnonymousClass1 r2 = new o(recyclerView.getContext()) {
            /* access modifiers changed from: protected */
            public float a(DisplayMetrics displayMetrics) {
                return 100.0f / ((float) displayMetrics.densityDpi);
            }
        };
        r2.c(i2);
        a((RecyclerView.r) r2);
    }
}
