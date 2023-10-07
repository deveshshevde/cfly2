package com.google.android.exoplayer2.metadata.emsg;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public final class b {

    /* renamed from: a  reason: collision with root package name */
    private final ByteArrayOutputStream f15863a;

    /* renamed from: b  reason: collision with root package name */
    private final DataOutputStream f15864b;

    public b() {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(512);
        this.f15863a = byteArrayOutputStream;
        this.f15864b = new DataOutputStream(byteArrayOutputStream);
    }

    private static void a(DataOutputStream dataOutputStream, long j2) throws IOException {
        dataOutputStream.writeByte(((int) (j2 >>> 24)) & 255);
        dataOutputStream.writeByte(((int) (j2 >>> 16)) & 255);
        dataOutputStream.writeByte(((int) (j2 >>> 8)) & 255);
        dataOutputStream.writeByte(((int) j2) & 255);
    }

    private static void a(DataOutputStream dataOutputStream, String str) throws IOException {
        dataOutputStream.writeBytes(str);
        dataOutputStream.writeByte(0);
    }

    public byte[] a(EventMessage eventMessage) {
        this.f15863a.reset();
        try {
            a(this.f15864b, eventMessage.f15857a);
            a(this.f15864b, eventMessage.f15858b != null ? eventMessage.f15858b : "");
            a(this.f15864b, eventMessage.f15859c);
            a(this.f15864b, eventMessage.f15860d);
            this.f15864b.write(eventMessage.f15861e);
            this.f15864b.flush();
            return this.f15863a.toByteArray();
        } catch (IOException e2) {
            throw new RuntimeException(e2);
        }
    }
}
