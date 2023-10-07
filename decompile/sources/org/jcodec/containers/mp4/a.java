package org.jcodec.containers.mp4;

import java.nio.ByteBuffer;
import org.jcodec.common.model.f;

public class a extends org.jcodec.common.model.a {

    /* renamed from: b  reason: collision with root package name */
    private long f33280b;

    /* renamed from: c  reason: collision with root package name */
    private int f33281c;

    public a(ByteBuffer byteBuffer, long j2, long j3, long j4, long j5, boolean z2, f fVar, long j6, int i2) {
        super(byteBuffer, j2, j3, j4, j5, z2, fVar);
        this.f33280b = j6;
        this.f33281c = i2;
    }

    public int g() {
        return this.f33281c;
    }
}
