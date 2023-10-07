package com.hoho.android.usb.usb.data_proxy;

import com.myusb.proxy.proto.Proxy;

public class b extends a {
    public b(d dVar, int i2) {
        super(dVar, i2);
    }

    public int a(String str, int i2) {
        return this.f20267c.a(this.f20265a, Proxy.ConnType.TCP, Proxy.MsgType.CONNECT, str, i2, 0, 0, "", (byte[]) null);
    }

    public int a(byte[] bArr) {
        return this.f20267c.a(this.f20265a, Proxy.ConnType.TCP, Proxy.MsgType.SEND, "", 0, 0, 0, "", bArr);
    }

    public void b() {
        this.f20267c.a(this.f20265a, Proxy.ConnType.TCP, Proxy.MsgType.CLOSE, "", 0, 0, 0, "", (byte[]) null);
    }
}
