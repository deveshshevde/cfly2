package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;

public class msg_remote_app_requestorset extends MAVLinkMessage {
    private static final long serialVersionUID = 12;

    /* renamed from: d  reason: collision with root package name */
    public byte f7129d;

    /* renamed from: e  reason: collision with root package name */
    public byte f7130e;

    public msg_remote_app_requestorset() {
        this.f6280c = 12;
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6245a = 2;
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6249e = 12;
        mAVLinkPacket.f6250f.b(this.f7129d);
        mAVLinkPacket.f6250f.b(this.f7130e);
        return mAVLinkPacket;
    }

    public String toString() {
        return "MAVLINK_MSG_ID_REMOTE_APP_REQUESTORSET - param1:" + this.f7129d + " param2:" + this.f7130e + "";
    }
}
