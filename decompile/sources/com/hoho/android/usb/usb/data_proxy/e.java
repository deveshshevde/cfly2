package com.hoho.android.usb.usb.data_proxy;

import com.myusb.proxy.proto.Proxy;

public final /* synthetic */ class e {

    /* renamed from: a  reason: collision with root package name */
    public static final /* synthetic */ int[] f20272a;

    /* renamed from: b  reason: collision with root package name */
    public static final /* synthetic */ int[] f20273b;

    /* renamed from: c  reason: collision with root package name */
    public static final /* synthetic */ int[] f20274c;

    static {
        int[] iArr = new int[Proxy.ConnType.values().length];
        f20272a = iArr;
        iArr[Proxy.ConnType.RTSP.ordinal()] = 1;
        iArr[Proxy.ConnType.HTTP.ordinal()] = 2;
        iArr[Proxy.ConnType.FTP.ordinal()] = 3;
        int[] iArr2 = new int[Proxy.MsgType.values().length];
        f20273b = iArr2;
        iArr2[Proxy.MsgType.RECV.ordinal()] = 1;
        iArr2[Proxy.MsgType.ERROR.ordinal()] = 2;
        iArr2[Proxy.MsgType.RESULT.ordinal()] = 3;
        int[] iArr3 = new int[Proxy.MsgType.values().length];
        f20274c = iArr3;
        iArr3[Proxy.MsgType.RECV.ordinal()] = 1;
        iArr3[Proxy.MsgType.ERROR.ordinal()] = 2;
        iArr3[Proxy.MsgType.HTTP_PROGRESS.ordinal()] = 3;
        iArr3[Proxy.MsgType.SEND.ordinal()] = 4;
        iArr3[Proxy.MsgType.RESULT.ordinal()] = 5;
    }
}
