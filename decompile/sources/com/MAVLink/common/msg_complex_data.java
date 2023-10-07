package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_complex_data extends MAVLinkMessage {
    private static final long serialVersionUID = 17;

    /* renamed from: d  reason: collision with root package name */
    public short f6590d;

    /* renamed from: e  reason: collision with root package name */
    public short f6591e;

    /* renamed from: f  reason: collision with root package name */
    public short f6592f;

    /* renamed from: g  reason: collision with root package name */
    public short f6593g;

    /* renamed from: h  reason: collision with root package name */
    public byte f6594h;

    /* renamed from: i  reason: collision with root package name */
    public byte f6595i;

    public msg_complex_data() {
        this.f6280c = 17;
    }

    public msg_complex_data(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 17;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6590d = aVar.d();
        this.f6591e = aVar.d();
        this.f6592f = aVar.d();
        this.f6593g = aVar.d();
        this.f6594h = aVar.c();
        this.f6595i = aVar.c();
    }

    public boolean a() {
        return (this.f6595i & 14) > 0;
    }

    public boolean b() {
        return (this.f6595i & 128) != 128;
    }

    public boolean c() {
        return (this.f6595i & 64) == 64;
    }

    public boolean d() {
        return e() > 0 && f() < 100;
    }

    public int e() {
        return this.f6592f & 15;
    }

    public int f() {
        return (this.f6592f >> 8) & 255;
    }

    public boolean g() {
        return (this.f6595i & 32) == 32;
    }

    public boolean h() {
        return (this.f6592f & 16) > 0;
    }

    public String toString() {
        return "MAVLINK_MSG_ID_COMPLEX_DATA - rtl_volt:" + this.f6590d + " curr_volt:" + this.f6591e + " extra2:" + this.f6592f + " extra3:" + this.f6593g + " count_down:" + this.f6594h + " extra1:" + this.f6595i + "";
    }
}
