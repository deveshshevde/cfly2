package com.huawei.android.multiscreen.dlna.sdk.dlnamanager;

import com.huawei.android.multiscreen.dlna.sdk.jni.DlnaUniswitch;

public abstract class a implements d {

    /* renamed from: a  reason: collision with root package name */
    private static String f20782a;

    /* renamed from: b  reason: collision with root package name */
    private static EDlnaProductType f20783b;

    private static void b(EDlnaProductType eDlnaProductType) {
        f20783b = eDlnaProductType;
    }

    private static void b(String str) {
        f20782a = str;
    }

    public String a() {
        return f20782a;
    }

    public void a(EDlnaProductType eDlnaProductType) {
        b(eDlnaProductType);
        DlnaUniswitch.a().dlnaApiSetProductType(eDlnaProductType.a());
    }

    public void a(String str) {
        b(str);
        DlnaUniswitch.a().dlnaApiSetDeviceName(str);
    }

    public EDlnaProductType b() {
        return f20783b;
    }
}
