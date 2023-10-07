package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;

public class msg_image_data extends MAVLinkMessage {
    private static final long serialVersionUID = 18;

    /* renamed from: d  reason: collision with root package name */
    public short f6846d;

    /* renamed from: e  reason: collision with root package name */
    public short f6847e;

    /* renamed from: f  reason: collision with root package name */
    public short f6848f;

    /* renamed from: g  reason: collision with root package name */
    public short f6849g;

    /* renamed from: h  reason: collision with root package name */
    public short f6850h;

    /* renamed from: i  reason: collision with root package name */
    public short f6851i;

    /* renamed from: j  reason: collision with root package name */
    public short f6852j;

    /* renamed from: k  reason: collision with root package name */
    public short f6853k;

    /* renamed from: l  reason: collision with root package name */
    public short f6854l;

    /* renamed from: m  reason: collision with root package name */
    public byte f6855m;

    /* renamed from: n  reason: collision with root package name */
    public byte f6856n;

    /* renamed from: o  reason: collision with root package name */
    public byte f6857o;

    /* renamed from: p  reason: collision with root package name */
    MAVLinkPacket f6858p = new MAVLinkPacket();

    public msg_image_data() {
        this.f6280c = 18;
    }

    public MAVLinkPacket a() {
        this.f6858p.d();
        this.f6858p.f6245a = 21;
        this.f6858p.f6247c = 255;
        this.f6858p.f6248d = 190;
        this.f6858p.f6249e = 18;
        this.f6858p.f6250f.a(this.f6846d);
        this.f6858p.f6250f.a(this.f6847e);
        this.f6858p.f6250f.a(this.f6848f);
        this.f6858p.f6250f.a(this.f6849g);
        this.f6858p.f6250f.a(this.f6850h);
        this.f6858p.f6250f.a(this.f6851i);
        this.f6858p.f6250f.a(this.f6852j);
        this.f6858p.f6250f.a(this.f6853k);
        this.f6858p.f6250f.a(this.f6854l);
        this.f6858p.f6250f.b(this.f6855m);
        this.f6858p.f6250f.b(this.f6856n);
        this.f6858p.f6250f.b(this.f6857o);
        return this.f6858p;
    }

    public String toString() {
        return "MAVLINK_MSG_ID_IMAGE_DATA - vel_x:" + this.f6846d + " vel_y:" + this.f6847e + " offset_x:" + this.f6848f + " offset_y:" + this.f6849g + " factor:" + this.f6850h + " resolution_x:" + this.f6851i + " resolution_y:" + this.f6852j + " target_x:" + this.f6853k + " target_y:" + this.f6854l + " target_type:" + this.f6855m + " mode:" + this.f6856n + " type:" + this.f6857o + "";
    }
}
