package com.MAVLink.Messages;

import com.MAVLink.MAVLinkPacket;

public class b {

    /* renamed from: a  reason: collision with root package name */
    public int f6283a;

    /* renamed from: b  reason: collision with root package name */
    public int f6284b;

    /* renamed from: c  reason: collision with root package name */
    public int f6285c;

    /* renamed from: d  reason: collision with root package name */
    private int f6286d;

    private void b(MAVLinkPacket mAVLinkPacket) {
        int i2 = mAVLinkPacket.f6246b - this.f6286d;
        int i3 = mAVLinkPacket.f6246b;
        this.f6285c += i2 < 0 ? (i3 - this.f6286d) + 255 : i3 - this.f6286d;
    }

    private void c() {
        this.f6286d = (this.f6286d + 1) & 255;
    }

    private boolean c(MAVLinkPacket mAVLinkPacket) {
        return this.f6286d > 0 && mAVLinkPacket.f6246b != this.f6286d;
    }

    public void a() {
        this.f6284b++;
    }

    public void a(MAVLinkPacket mAVLinkPacket) {
        c();
        if (c(mAVLinkPacket)) {
            b(mAVLinkPacket);
        }
        this.f6286d = mAVLinkPacket.f6246b;
        this.f6283a++;
    }

    public void b() {
        this.f6286d = -1;
        this.f6285c = 0;
        this.f6284b = 0;
        this.f6283a = 0;
    }
}
