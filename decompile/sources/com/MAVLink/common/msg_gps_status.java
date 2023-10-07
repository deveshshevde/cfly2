package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;

public class msg_gps_status extends MAVLinkMessage {
    private static final long serialVersionUID = 25;

    /* renamed from: d  reason: collision with root package name */
    public byte f6726d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f6727e = new byte[20];

    /* renamed from: f  reason: collision with root package name */
    public byte[] f6728f = new byte[20];

    /* renamed from: g  reason: collision with root package name */
    public byte[] f6729g = new byte[20];

    /* renamed from: h  reason: collision with root package name */
    public byte[] f6730h = new byte[20];

    /* renamed from: i  reason: collision with root package name */
    public byte[] f6731i = new byte[20];

    public msg_gps_status() {
        this.f6280c = 25;
    }

    public msg_gps_status(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = 25;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6726d = aVar.c();
        int i2 = 0;
        int i3 = 0;
        while (true) {
            byte[] bArr = this.f6727e;
            if (i3 >= bArr.length) {
                break;
            }
            bArr[i3] = aVar.c();
            i3++;
        }
        int i4 = 0;
        while (true) {
            byte[] bArr2 = this.f6728f;
            if (i4 >= bArr2.length) {
                break;
            }
            bArr2[i4] = aVar.c();
            i4++;
        }
        int i5 = 0;
        while (true) {
            byte[] bArr3 = this.f6729g;
            if (i5 >= bArr3.length) {
                break;
            }
            bArr3[i5] = aVar.c();
            i5++;
        }
        int i6 = 0;
        while (true) {
            byte[] bArr4 = this.f6730h;
            if (i6 >= bArr4.length) {
                break;
            }
            bArr4[i6] = aVar.c();
            i6++;
        }
        while (true) {
            byte[] bArr5 = this.f6731i;
            if (i2 < bArr5.length) {
                bArr5[i2] = aVar.c();
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_GPS_STATUS - satellites_visible:" + this.f6726d + " satellite_prn:" + this.f6727e + " satellite_used:" + this.f6728f + " satellite_elevation:" + this.f6729g + " satellite_azimuth:" + this.f6730h + " satellite_snr:" + this.f6731i + "";
    }
}
