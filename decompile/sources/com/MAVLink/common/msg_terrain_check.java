package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;
import com.xeagle.android.login.amba.connectivity.IChannelListener;

public class msg_terrain_check extends MAVLinkMessage {
    private static final long serialVersionUID = 135;

    /* renamed from: d  reason: collision with root package name */
    public int f7284d;

    /* renamed from: e  reason: collision with root package name */
    public int f7285e;

    public msg_terrain_check() {
        this.f6280c = IChannelListener.CMD_CHANNEL_NO_MORE_SPACE;
    }

    public msg_terrain_check(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = IChannelListener.CMD_CHANNEL_NO_MORE_SPACE;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7284d = aVar.e();
        this.f7285e = aVar.e();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_TERRAIN_CHECK - lat:" + this.f7284d + " lon:" + this.f7285e + "";
    }
}
