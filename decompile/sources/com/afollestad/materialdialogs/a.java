package com.afollestad.materialdialogs;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.view.Window;
import com.afollestad.materialdialogs.internal.main.DialogLayout;

public interface a {
    int a(boolean z2);

    ViewGroup a(Context context, Window window, LayoutInflater layoutInflater, b bVar);

    DialogLayout a(ViewGroup viewGroup);

    void a(Context context, Window window, DialogLayout dialogLayout, Integer num);

    void a(b bVar);

    void a(DialogLayout dialogLayout, int i2, float f2);

    boolean a();

    void b(b bVar);
}
