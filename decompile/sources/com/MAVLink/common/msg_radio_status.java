package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_radio_status extends MAVLinkMessage {
    private static final long serialVersionUID = 109;

    /* renamed from: d  reason: collision with root package name */
    public short f7052d;

    /* renamed from: e  reason: collision with root package name */
    public short f7053e;

    /* renamed from: f  reason: collision with root package name */
    public byte f7054f;

    /* renamed from: g  reason: collision with root package name */
    public byte f7055g;

    /* renamed from: h  reason: collision with root package name */
    public byte f7056h;

    /* renamed from: i  reason: collision with root package name */
    public byte f7057i;

    /* renamed from: j  reason: collision with root package name */
    public byte f7058j;

    public msg_radio_status() {
        this.f6280c = 109;
    }

    public msg_radio_status(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 109;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7052d = aVar.d();
        this.f7053e = aVar.d();
        this.f7054f = aVar.c();
        this.f7055g = aVar.c();
        this.f7056h = aVar.c();
        this.f7057i = aVar.c();
        this.f7058j = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_RADIO_STATUS - rxerrors:" + this.f7052d + " fixed:" + this.f7053e + " rssi:" + this.f7054f + " remrssi:" + this.f7055g + " txbuf:" + this.f7056h + " noise:" + this.f7057i + " remnoise:" + this.f7058j + "";
    }
}
