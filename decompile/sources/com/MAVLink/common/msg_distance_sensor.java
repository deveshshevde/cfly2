package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;
import com.xeagle.android.login.amba.connectivity.IChannelListener;

public class msg_distance_sensor extends MAVLinkMessage {
    private static final long serialVersionUID = 132;

    /* renamed from: d  reason: collision with root package name */
    public int f6625d;

    /* renamed from: e  reason: collision with root package name */
    public short f6626e;

    /* renamed from: f  reason: collision with root package name */
    public short f6627f;

    /* renamed from: g  reason: collision with root package name */
    public short f6628g;

    /* renamed from: h  reason: collision with root package name */
    public byte f6629h;

    /* renamed from: i  reason: collision with root package name */
    public byte f6630i;

    /* renamed from: j  reason: collision with root package name */
    public byte f6631j;

    /* renamed from: k  reason: collision with root package name */
    public byte f6632k;

    public msg_distance_sensor() {
        this.f6280c = IChannelListener.CMD_CHANNEL_ERROR_BROKEN_CHANNEL;
    }

    public msg_distance_sensor(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = IChannelListener.CMD_CHANNEL_ERROR_BROKEN_CHANNEL;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6625d = aVar.e();
        this.f6626e = aVar.d();
        this.f6627f = aVar.d();
        this.f6628g = aVar.d();
        this.f6629h = aVar.c();
        this.f6630i = aVar.c();
        this.f6631j = aVar.c();
        this.f6632k = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DISTANCE_SENSOR - time_boot_ms:" + this.f6625d + " min_distance:" + this.f6626e + " max_distance:" + this.f6627f + " current_distance:" + this.f6628g + " type:" + this.f6629h + " id:" + this.f6630i + " orientation:" + this.f6631j + " covariance:" + this.f6632k + "";
    }
}
