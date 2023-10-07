package com.hoho.android.usb.rtsp;

import com.myusb.proxy.proto.Proxy;

public final /* synthetic */ class b {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f20253a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f20254b;

    static {
        int[] iArr = new int[Proxy.MsgType.values().length];
        f20253a = iArr;
        iArr[Proxy.MsgType.RESULT.ordinal()] = 1;
        iArr[Proxy.MsgType.CREATE.ordinal()] = 2;
        iArr[Proxy.MsgType.CONNECT.ordinal()] = 3;
        iArr[Proxy.MsgType.SEND.ordinal()] = 4;
        iArr[Proxy.MsgType.ERROR.ordinal()] = 5;
        iArr[Proxy.MsgType.RELAY_WIFI_STRENGTH.ordinal()] = 6;
        iArr[Proxy.MsgType.RELAY_VERSION.ordinal()] = 7;
        iArr[Proxy.MsgType.RELAY_WIFI_LIST.ordinal()] = 8;
        iArr[Proxy.MsgType.RELAY_WIFI_RENAME.ordinal()] = 9;
        iArr[Proxy.MsgType.TTY_VERSION.ordinal()] = 10;
        int[] iArr2 = new int[Proxy.MsgType.values().length];
        f20254b = iArr2;
        iArr2[Proxy.MsgType.CREATE.ordinal()] = 1;
        iArr2[Proxy.MsgType.CONNECT.ordinal()] = 2;
    }
}
