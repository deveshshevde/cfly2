package com.xeagle.android.login.pickImage.adapter;

import android.view.View;

public interface OnItemClickListener<T> {
    void onClick(View view, int i2, T t2);

    boolean onLongClick(View view, int i2, T t2);
}
