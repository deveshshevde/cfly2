package com.hoho.android.usb.usb.data_proxy;

import com.myusb.proxy.proto.Proxy;

public class c extends a {
    public c(d dVar, int i2) {
        super(dVar, i2);
    }

    public int a(byte[] bArr, String str, int i2) {
        return this.f20267c.a(this.f20265a, Proxy.ConnType.UDP, Proxy.MsgType.SEND, str, i2, 0, 0, "", bArr);
    }

    public void b() {
        this.f20267c.a(this.f20265a, Proxy.ConnType.UDP, Proxy.MsgType.CLOSE, "", 0, 0, 0, "", (byte[]) null);
    }
}
