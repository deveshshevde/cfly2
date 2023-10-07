package com.xeagle.android.proxy.updateFirmware;

public class BootloaderAckMsg extends UploadMessage {
    private static final long serialVersionUID = 858446313924047715L;

    /* renamed from: a  reason: collision with root package name */
    public byte f24219a;

    /* renamed from: b  reason: collision with root package name */
    public byte f24220b;

    /* renamed from: c  reason: collision with root package name */
    public byte f24221c;

    /* renamed from: d  reason: collision with root package name */
    public byte f24222d;

    /* renamed from: e  reason: collision with root package name */
    public byte[] f24223e;

    public BootloaderAckMsg(UploadPacket uploadPacket) {
        a(uploadPacket);
    }

    public void a(UploadPacket uploadPacket) {
        uploadPacket.f24286e.b();
        this.f24219a = (byte) uploadPacket.f24282a;
        this.f24220b = (byte) uploadPacket.f24283b;
        this.f24221c = (byte) uploadPacket.f24284c;
        this.f24222d = (byte) uploadPacket.f24285d;
        int i2 = this.f24219a;
        if (i2 > 0) {
            this.f24223e = new byte[i2];
            for (int i3 = 0; i3 < this.f24219a; i3++) {
                this.f24223e[i3] = uploadPacket.f24286e.f24303a.get(i3);
            }
        }
    }
}
