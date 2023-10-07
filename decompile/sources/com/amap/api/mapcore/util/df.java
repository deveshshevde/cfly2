package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.AssetManager;
import java.io.File;

public final class df {

    /* renamed from: a  reason: collision with root package name */
    private static boolean f8249a = new File("/system/framework/amap.jar").exists();

    public static AssetManager a(Context context) {
        if (context == null) {
            return null;
        }
        AssetManager assets = context.getAssets();
        if (f8249a) {
            try {
                assets.getClass().getDeclaredMethod("addAssetPath", new Class[]{String.class}).invoke(assets, new Object[]{"/system/framework/amap.jar"});
            } catch (Throwable th) {
                fz.c(th, "ResourcesUtil", "getSelfAssets");
            }
        }
        return assets;
    }

    public static int b(Context context) {
        return (int) ((context.getResources().getDisplayMetrics().density * 1.0f) + 0.5f);
    }
}
