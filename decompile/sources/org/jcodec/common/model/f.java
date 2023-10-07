package org.jcodec.common.model;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private short f33238a;

    /* renamed from: b  reason: collision with root package name */
    private byte f33239b;

    /* renamed from: c  reason: collision with root package name */
    private byte f33240c;

    /* renamed from: d  reason: collision with root package name */
    private byte f33241d;

    /* renamed from: e  reason: collision with root package name */
    private boolean f33242e;

    public short a() {
        return this.f33238a;
    }

    public byte b() {
        return this.f33239b;
    }

    public byte c() {
        return this.f33240c;
    }

    public byte d() {
        return this.f33241d;
    }

    public boolean e() {
        return this.f33242e;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d:%02d:%02d", new Object[]{Short.valueOf(this.f33238a), Byte.valueOf(this.f33239b), Byte.valueOf(this.f33240c)}));
        sb.append(this.f33242e ? ";" : ":");
        sb.append(String.format("%02d", new Object[]{Byte.valueOf(this.f33241d)}));
        return sb.toString();
    }
}
