package com.google.android.material.progressindicator;

import android.content.ContentResolver;
import android.os.Build;
import android.provider.Settings;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static float f19443a = 1.0f;

    public float a(ContentResolver contentResolver) {
        return Build.VERSION.SDK_INT >= 17 ? Settings.Global.getFloat(contentResolver, "animator_duration_scale", 1.0f) : Build.VERSION.SDK_INT == 16 ? Settings.System.getFloat(contentResolver, "animator_duration_scale", 1.0f) : f19443a;
    }
}
