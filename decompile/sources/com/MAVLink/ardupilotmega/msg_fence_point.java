package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;
import com.autonavi.amap.mapcore.tools.GlMapUtil;

public class msg_fence_point extends MAVLinkMessage {
    private static final long serialVersionUID = 160;

    /* renamed from: d  reason: collision with root package name */
    public float f6402d;

    /* renamed from: e  reason: collision with root package name */
    public float f6403e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6404f;

    /* renamed from: g  reason: collision with root package name */
    public byte f6405g;

    /* renamed from: h  reason: collision with root package name */
    public byte f6406h;

    /* renamed from: i  reason: collision with root package name */
    public byte f6407i;

    public msg_fence_point() {
        this.f6280c = GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL;
    }

    public msg_fence_point(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = GlMapUtil.DEVICE_DISPLAY_DPI_NORMAL;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6402d = aVar.g();
        this.f6403e = aVar.g();
        this.f6404f = aVar.c();
        this.f6405g = aVar.c();
        this.f6406h = aVar.c();
        this.f6407i = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_FENCE_POINT - lat:" + this.f6402d + " lng:" + this.f6403e + " target_system:" + this.f6404f + " target_component:" + this.f6405g + " idx:" + this.f6406h + " count:" + this.f6407i + "";
    }
}
