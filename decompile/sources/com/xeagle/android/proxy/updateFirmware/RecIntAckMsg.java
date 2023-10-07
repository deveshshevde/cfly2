package com.xeagle.android.proxy.updateFirmware;

public class RecIntAckMsg extends UploadMessage {
    private static final long serialVersionUID = 8378706034203537422L;

    /* renamed from: a  reason: collision with root package name */
    public byte f24272a;

    /* renamed from: b  reason: collision with root package name */
    public byte f24273b;

    /* renamed from: c  reason: collision with root package name */
    public byte f24274c;

    /* renamed from: d  reason: collision with root package name */
    public byte f24275d;

    /* renamed from: e  reason: collision with root package name */
    public int f24276e;

    public RecIntAckMsg(UploadPacket uploadPacket) {
        a(uploadPacket);
    }

    public void a(UploadPacket uploadPacket) {
        uploadPacket.f24286e.b();
        this.f24272a = (byte) uploadPacket.f24282a;
        this.f24273b = (byte) uploadPacket.f24283b;
        this.f24274c = (byte) uploadPacket.f24284c;
        this.f24275d = (byte) uploadPacket.f24285d;
        this.f24276e = uploadPacket.f24286e.c();
    }
}
