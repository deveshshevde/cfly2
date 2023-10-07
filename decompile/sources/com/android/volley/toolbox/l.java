package com.android.volley.toolbox;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.http.AndroidHttpClient;
import android.os.Build;
import com.android.volley.h;
import java.io.File;

public class l {
    public static h a(Context context) {
        return a(context, (f) null);
    }

    public static h a(Context context, f fVar) {
        String str;
        File file = new File(context.getCacheDir(), "volley");
        try {
            String packageName = context.getPackageName();
            PackageInfo packageInfo = context.getPackageManager().getPackageInfo(packageName, 0);
            str = String.valueOf(packageName) + "/" + packageInfo.versionCode;
        } catch (PackageManager.NameNotFoundException unused) {
            str = "volley/0";
        }
        if (fVar == null) {
            fVar = Build.VERSION.SDK_INT >= 9 ? new g() : new d(AndroidHttpClient.newInstance(str));
        }
        h hVar = new h(new c(file), new a(fVar));
        hVar.a();
        return hVar;
    }
}
