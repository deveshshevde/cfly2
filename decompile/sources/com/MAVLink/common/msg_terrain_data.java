package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;
import com.xeagle.android.login.amba.connectivity.IChannelListener;

public class msg_terrain_data extends MAVLinkMessage {
    private static final long serialVersionUID = 134;

    /* renamed from: d  reason: collision with root package name */
    public int f7286d;

    /* renamed from: e  reason: collision with root package name */
    public int f7287e;

    /* renamed from: f  reason: collision with root package name */
    public short f7288f;

    /* renamed from: g  reason: collision with root package name */
    public short[] f7289g = new short[16];

    /* renamed from: h  reason: collision with root package name */
    public byte f7290h;

    public msg_terrain_data() {
        this.f6280c = IChannelListener.CMD_CHANNEL_ERROR_CONNECT;
    }

    public msg_terrain_data(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = IChannelListener.CMD_CHANNEL_ERROR_CONNECT;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f7286d = aVar.e();
        this.f7287e = aVar.e();
        this.f7288f = aVar.d();
        int i2 = 0;
        while (true) {
            short[] sArr = this.f7289g;
            if (i2 < sArr.length) {
                sArr[i2] = aVar.d();
                i2++;
            } else {
                this.f7290h = aVar.c();
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_TERRAIN_DATA - lat:" + this.f7286d + " lon:" + this.f7287e + " grid_spacing:" + this.f7288f + " data:" + this.f7289g + " gridbit:" + this.f7290h + "";
    }
}
