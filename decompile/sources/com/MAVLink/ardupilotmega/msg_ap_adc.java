package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_ap_adc extends MAVLinkMessage {
    private static final long serialVersionUID = 153;

    /* renamed from: d  reason: collision with root package name */
    public short f6330d;

    /* renamed from: e  reason: collision with root package name */
    public short f6331e;

    /* renamed from: f  reason: collision with root package name */
    public short f6332f;

    /* renamed from: g  reason: collision with root package name */
    public short f6333g;

    /* renamed from: h  reason: collision with root package name */
    public short f6334h;

    /* renamed from: i  reason: collision with root package name */
    public short f6335i;

    public msg_ap_adc() {
        this.f6280c = 153;
    }

    public msg_ap_adc(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 153;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6330d = aVar.d();
        this.f6331e = aVar.d();
        this.f6332f = aVar.d();
        this.f6333g = aVar.d();
        this.f6334h = aVar.d();
        this.f6335i = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_AP_ADC - adc1:" + this.f6330d + " adc2:" + this.f6331e + " adc3:" + this.f6332f + " adc4:" + this.f6333g + " adc5:" + this.f6334h + " adc6:" + this.f6335i + "";
    }
}
