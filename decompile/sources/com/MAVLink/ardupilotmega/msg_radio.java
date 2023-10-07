package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_radio extends MAVLinkMessage {
    private static final long serialVersionUID = 166;

    /* renamed from: d  reason: collision with root package name */
    public short f6442d;

    /* renamed from: e  reason: collision with root package name */
    public short f6443e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6444f;

    /* renamed from: g  reason: collision with root package name */
    public byte f6445g;

    /* renamed from: h  reason: collision with root package name */
    public byte f6446h;

    /* renamed from: i  reason: collision with root package name */
    public byte f6447i;

    /* renamed from: j  reason: collision with root package name */
    public byte f6448j;

    public msg_radio() {
        this.f6280c = 166;
    }

    public msg_radio(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 166;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6442d = aVar.d();
        this.f6443e = aVar.d();
        this.f6444f = aVar.c();
        this.f6445g = aVar.c();
        this.f6446h = aVar.c();
        this.f6447i = aVar.c();
        this.f6448j = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RADIO - rxerrors:" + this.f6442d + " fixed:" + this.f6443e + " rssi:" + this.f6444f + " remrssi:" + this.f6445g + " txbuf:" + this.f6446h + " noise:" + this.f6447i + " remnoise:" + this.f6448j + "";
    }
}
