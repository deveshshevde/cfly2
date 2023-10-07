package com.MAVLink.common;

import com.MAVLink.MAVLinkPacket;
import com.MAVLink.Messages.MAVLinkMessage;
import com.MAVLink.Messages.a;
import com.xeagle.android.login.amba.connectivity.IChannelListener;

public class msg_encapsulated_data extends MAVLinkMessage {
    private static final long serialVersionUID = 131;

    /* renamed from: d  reason: collision with root package name */
    public short f6635d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f6636e = new byte[253];

    public msg_encapsulated_data() {
        this.f6280c = IChannelListener.CMD_CHANNEL_ERROR_BLE_DISABLED;
    }

    public msg_encapsulated_data(MAVLinkPacket mAVLinkPacket) {
        this.f6278a = mAVLinkPacket.f6247c;
        this.f6279b = mAVLinkPacket.f6248d;
        this.f6280c = IChannelListener.CMD_CHANNEL_ERROR_BLE_DISABLED;
        a(mAVLinkPacket.f6250f);
    }

    public void a(a aVar) {
        aVar.b();
        this.f6635d = aVar.d();
        int i2 = 0;
        while (true) {
            byte[] bArr = this.f6636e;
            if (i2 < bArr.length) {
                bArr[i2] = aVar.c();
                i2++;
            } else {
                return;
            }
        }
    }

    public String toString() {
        return "MAVLINK_MSG_ID_ENCAPSULATED_DATA - seqnr:" + this.f6635d + " data:" + this.f6636e + "";
    }
}
