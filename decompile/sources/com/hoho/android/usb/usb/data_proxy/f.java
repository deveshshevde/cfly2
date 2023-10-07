package com.hoho.android.usb.usb.data_proxy;

import com.myusb.proxy.proto.Proxy;

public interface f {
    void a(int i2, int i3, int i4, String str, byte[] bArr);

    void a(int i2, int i3, String str, Proxy.ConnType connType);

    void a(int i2, String str, int i3, Proxy.ConnType connType);

    void a(int i2, String str, Proxy.ConnType connType);
}
