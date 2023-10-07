package com.autonavi.amap.mapcore;

import android.content.Context;
import com.amap.api.mapcore.util.gi;

public class MsgProcessor {
    private static gi mDelegate = new gi();

    public static native int nativeInit(Context context);

    public static void nativeInitInfo(Context context, boolean z2, String str, String str2, String str3, String[] strArr) {
        mDelegate.a(context, z2, str, str2, str3, strArr);
        nativeInit(context);
    }

    public static void nativeMsgProcessor(String str, String str2) {
        mDelegate.a(str, str2);
    }
}
