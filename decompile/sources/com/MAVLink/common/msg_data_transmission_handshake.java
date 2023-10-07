package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;
import com.xeagle.android.login.amba.connectivity.IChannelListener;

public class msg_data_transmission_handshake extends MAVLinkMessage {
    private static final long serialVersionUID = 130;

    /* renamed from: d  reason: collision with root package name */
    public int f6610d;

    /* renamed from: e  reason: collision with root package name */
    public short f6611e;

    /* renamed from: f  reason: collision with root package name */
    public short f6612f;

    /* renamed from: g  reason: collision with root package name */
    public short f6613g;

    /* renamed from: h  reason: collision with root package name */
    public byte f6614h;

    /* renamed from: i  reason: collision with root package name */
    public byte f6615i;

    /* renamed from: j  reason: collision with root package name */
    public byte f6616j;

    public msg_data_transmission_handshake() {
        this.f6280c = IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR;
    }

    public msg_data_transmission_handshake(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6610d = aVar.e();
        this.f6611e = aVar.d();
        this.f6612f = aVar.d();
        this.f6613g = aVar.d();
        this.f6614h = aVar.c();
        this.f6615i = aVar.c();
        this.f6616j = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DATA_TRANSMISSION_HANDSHAKE - size:" + this.f6610d + " width:" + this.f6611e + " height:" + this.f6612f + " packets:" + this.f6613g + " type:" + this.f6614h + " payload:" + this.f6615i + " jpg_quality:" + this.f6616j + "";
    }
}
