package com.hoho.android.usb.rtsp;

public class RtspPacketDecode {

    /* renamed from: a  reason: collision with root package name */
    public static long f20231a = 0;

    /* renamed from: e  reason: collision with root package name */
    private static final byte[] f20232e = {0, 0, 0, 1};

    /* renamed from: b  reason: collision with root package name */
    private byte[] f20233b;

    /* renamed from: c  reason: collision with root package name */
    private int f20234c = 0;

    /* renamed from: d  reason: collision with root package name */
    private int f20235d = 0;

    static {
        System.loadLibrary("rtpDemo");
    }

    public RtspPacketDecode(int i2, int i3) {
        this.f20233b = new byte[a(i2, i3)];
    }

    public int a(int i2, int i3) {
        double d2 = (double) i2;
        Double.isNaN(d2);
        Double.isNaN(d2);
        return (((int) Math.ceil(d2 / 16.0d)) * 16 * i3) + ((((((int) Math.ceil(d2 / 32.0d)) * 16) * i3) / 2) * 2);
    }

    public native byte[] rtp2h264ByJni(byte[] bArr, int i2);
}
