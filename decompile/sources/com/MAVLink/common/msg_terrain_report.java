package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;
import com.xeagle.android.login.amba.connectivity.IChannelListener;

public class msg_terrain_report extends MAVLinkMessage {
    private static final long serialVersionUID = 136;

    /* renamed from: d  reason: collision with root package name */
    public int f7291d;

    /* renamed from: e  reason: collision with root package name */
    public int f7292e;

    /* renamed from: f  reason: collision with root package name */
    public float f7293f;

    /* renamed from: g  reason: collision with root package name */
    public float f7294g;

    /* renamed from: h  reason: collision with root package name */
    public short f7295h;

    /* renamed from: i  reason: collision with root package name */
    public short f7296i;

    /* renamed from: j  reason: collision with root package name */
    public short f7297j;

    public msg_terrain_report() {
        this.f6280c = IChannelListener.CMD_CHANNEL_CARD_PROTECTED;
    }

    public msg_terrain_report(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = IChannelListener.CMD_CHANNEL_CARD_PROTECTED;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7291d = aVar.e();
        this.f7292e = aVar.e();
        this.f7293f = aVar.g();
        this.f7294g = aVar.g();
        this.f7295h = aVar.d();
        this.f7296i = aVar.d();
        this.f7297j = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_TERRAIN_REPORT - lat:" + this.f7291d + " lon:" + this.f7292e + " terrain_height:" + this.f7293f + " current_height:" + this.f7294g + " spacing:" + this.f7295h + " pending:" + this.f7296i + " loaded:" + this.f7297j + "";
    }
}
