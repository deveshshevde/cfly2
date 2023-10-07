package com.alibaba.android.arouter.facade.enums;

public enum RouteType {
    ACTIVITY(0, "android.app.Activity"),
    SERVICE(1, "android.app.Service"),
    PROVIDER(2, "com.alibaba.android.arouter.facade.template.IProvider"),
    CONTENT_PROVIDER(-1, "android.app.ContentProvider"),
    BOARDCAST(-1, ""),
    METHOD(-1, ""),
    FRAGMENT(-1, "android.app.Fragment"),
    UNKNOWN(-1, "Unknown route type");
    

    /* renamed from: i  reason: collision with root package name */
    int f7661i;

    /* renamed from: j  reason: collision with root package name */
    String f7662j;

    private RouteType(int i2, String str) {
        this.f7661i = i2;
        this.f7662j = str;
    }
}
