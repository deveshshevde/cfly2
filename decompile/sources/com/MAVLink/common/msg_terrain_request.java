package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;
import com.xeagle.android.login.amba.connectivity.IChannelListener;

public class msg_terrain_request extends MAVLinkMessage {
    private static final long serialVersionUID = 133;

    /* renamed from: d  reason: collision with root package name */
    public long f7298d;

    /* renamed from: e  reason: collision with root package name */
    public int f7299e;

    /* renamed from: f  reason: collision with root package name */
    public int f7300f;

    /* renamed from: g  reason: collision with root package name */
    public short f7301g;

    public msg_terrain_request() {
        this.f6280c = IChannelListener.CMD_CHANNEL_ERROR_WAKEUP;
    }

    public msg_terrain_request(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = IChannelListener.CMD_CHANNEL_ERROR_WAKEUP;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7298d = aVar.f();
        this.f7299e = aVar.e();
        this.f7300f = aVar.e();
        this.f7301g = aVar.d();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_TERRAIN_REQUEST - mask:" + this.f7298d + " lat:" + this.f7299e + " lon:" + this.f7300f + " grid_spacing:" + this.f7301g + "";
    }
}
