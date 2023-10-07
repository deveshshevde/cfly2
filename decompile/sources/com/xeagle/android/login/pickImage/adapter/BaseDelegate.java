package com.xeagle.android.login.pickImage.adapter;

import android.view.ViewGroup;

public abstract class BaseDelegate<T> {
    /* access modifiers changed from: package-private */
    public final BaseViewHolder createViewHolder(BaseAdapter<T> baseAdapter, ViewGroup viewGroup, int i2) {
        BaseViewHolder onCreateViewHolder = onCreateViewHolder(viewGroup, i2);
        if (onCreateViewHolder != null) {
            onCreateViewHolder.adapter = baseAdapter;
        }
        return onCreateViewHolder;
    }

    public abstract int getItemViewType(T t2, int i2);

    public abstract BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i2);

    public void onDataSetChanged() {
    }
}
