package com.xeagle.android.proxy.updateFirmware;

public class DataAckMsg extends UploadMessage {
    private static final long serialVersionUID = -6494184149924652579L;

    /* renamed from: a  reason: collision with root package name */
    public byte f24224a;

    /* renamed from: b  reason: collision with root package name */
    public byte f24225b;

    /* renamed from: c  reason: collision with root package name */
    public byte f24226c;

    /* renamed from: d  reason: collision with root package name */
    public byte f24227d;

    public DataAckMsg(UploadPacket uploadPacket) {
        a(uploadPacket);
    }

    public void a(UploadPacket uploadPacket) {
        uploadPacket.f24286e.b();
        this.f24224a = (byte) uploadPacket.f24282a;
        this.f24225b = (byte) uploadPacket.f24283b;
        this.f24226c = (byte) uploadPacket.f24284c;
        this.f24227d = (byte) uploadPacket.f24285d;
    }
}
