package com.MAVLink.ardupilotmega;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_digicam_control extends MAVLinkMessage {
    private static final long serialVersionUID = 155;

    /* renamed from: d  reason: collision with root package name */
    public float f6389d;

    /* renamed from: e  reason: collision with root package name */
    public byte f6390e;

    /* renamed from: f  reason: collision with root package name */
    public byte f6391f;

    /* renamed from: g  reason: collision with root package name */
    public byte f6392g;

    /* renamed from: h  reason: collision with root package name */
    public byte f6393h;

    /* renamed from: i  reason: collision with root package name */
    public byte f6394i;

    /* renamed from: j  reason: collision with root package name */
    public byte f6395j;

    /* renamed from: k  reason: collision with root package name */
    public byte f6396k;

    /* renamed from: l  reason: collision with root package name */
    public byte f6397l;

    /* renamed from: m  reason: collision with root package name */
    public byte f6398m;

    public msg_digicam_control() {
        this.f6280c = 155;
    }

    public msg_digicam_control(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 155;
        a(mAVLinkPacket.f6250f);
    }

    public MAVLinkPacket a() {
        MAVLinkPacket mAVLinkPacket = new MAVLinkPacket();
        mAVLinkPacket.f6245a = 13;
        mAVLinkPacket.f6247c = 255;
        mAVLinkPacket.f6248d = 1;
        mAVLinkPacket.f6249e = 155;
        mAVLinkPacket.f6250f.a(this.f6389d);
        mAVLinkPacket.f6250f.b(this.f6390e);
        mAVLinkPacket.f6250f.b(this.f6391f);
        mAVLinkPacket.f6250f.b(this.f6392g);
        mAVLinkPacket.f6250f.b(this.f6393h);
        mAVLinkPacket.f6250f.b(this.f6394i);
        mAVLinkPacket.f6250f.b(this.f6395j);
        mAVLinkPacket.f6250f.b(this.f6396k);
        mAVLinkPacket.f6250f.b(this.f6397l);
        mAVLinkPacket.f6250f.b(this.f6398m);
        return mAVLinkPacket;
    }

    public void a(a aVar) {
        aVar.b();
        this.f6389d = aVar.g();
        this.f6390e = aVar.c();
        this.f6391f = aVar.c();
        this.f6392g = aVar.c();
        this.f6393h = aVar.c();
        this.f6394i = aVar.c();
        this.f6395j = aVar.c();
        this.f6396k = aVar.c();
        this.f6397l = aVar.c();
        this.f6398m = aVar.c();
    }

    public String toString() {
        return "MAVLINK_MSG_ID_DIGICAM_CONTROL - extra_value:" + this.f6389d + " target_system:" + this.f6390e + " target_component:" + this.f6391f + " session:" + this.f6392g + " zoom_pos:" + this.f6393h + " zoom_step:" + this.f6394i + " focus_lock:" + this.f6395j + " shot:" + this.f6396k + " command_id:" + this.f6397l + " extra_param:" + this.f6398m + "";
    }
}
