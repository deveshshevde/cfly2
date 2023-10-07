package com.transitionseverywhere;

import android.view.View;
import android.view.ViewGroup;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    Runnable f21908a;

    /* renamed from: b  reason: collision with root package name */
    private ViewGroup f21909b;

    public static c a(View view) {
        return (c) view.getTag(R.id.current_scene);
    }

    static void a(View view, c cVar) {
        view.setTag(R.id.current_scene, cVar);
    }

    public void a() {
        Runnable runnable;
        if (a(this.f21909b) == this && (runnable = this.f21908a) != null) {
            runnable.run();
        }
    }
}
