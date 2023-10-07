package org.jcodec.containers.mp4.boxes;

import java.nio.ByteBuffer;
import java.util.Arrays;

public class at extends u {

    /* renamed from: c  reason: collision with root package name */
    public long f33344c;

    /* renamed from: d  reason: collision with root package name */
    public long f33345d;

    /* renamed from: e  reason: collision with root package name */
    public long f33346e;

    /* renamed from: f  reason: collision with root package name */
    public long f33347f;

    /* renamed from: g  reason: collision with root package name */
    public int f33348g;

    /* renamed from: h  reason: collision with root package name */
    public int f33349h;

    /* renamed from: j  reason: collision with root package name */
    public a[] f33350j;

    public static class a {

        /* renamed from: a  reason: collision with root package name */
        public boolean f33351a;

        /* renamed from: b  reason: collision with root package name */
        public long f33352b;

        /* renamed from: c  reason: collision with root package name */
        public long f33353c;

        /* renamed from: d  reason: collision with root package name */
        public boolean f33354d;

        /* renamed from: e  reason: collision with root package name */
        public int f33355e;

        /* renamed from: f  reason: collision with root package name */
        public long f33356f;

        public String toString() {
            return "Reference [reference_type=" + this.f33351a + ", referenced_size=" + this.f33352b + ", subsegment_duration=" + this.f33353c + ", starts_with_SAP=" + this.f33354d + ", SAP_type=" + this.f33355e + ", SAP_delta_time=" + this.f33356f + "]";
        }
    }

    public at() {
        super(new y(a()));
    }

    public static String a() {
        return "sidx";
    }

    /* access modifiers changed from: protected */
    public void a(ByteBuffer byteBuffer) {
        super.a(byteBuffer);
        byteBuffer.putInt((int) this.f33344c);
        byteBuffer.putInt((int) this.f33345d);
        if (this.f33538a == 0) {
            byteBuffer.putInt((int) this.f33346e);
            byteBuffer.putInt((int) this.f33347f);
        } else {
            byteBuffer.putLong(this.f33346e);
            byteBuffer.putLong(this.f33347f);
        }
        byteBuffer.putShort((short) this.f33348g);
        byteBuffer.putShort((short) this.f33349h);
        for (int i2 = 0; i2 < this.f33349h; i2++) {
            a aVar = this.f33350j[i2];
            int i3 = (int) (((long) ((aVar.f33351a ? 1 : 0) << true)) | aVar.f33352b);
            int i4 = (int) aVar.f33353c;
            int i5 = aVar.f33354d ? Integer.MIN_VALUE : 0;
            byteBuffer.putInt(i3);
            byteBuffer.putInt(i4);
            byteBuffer.putInt((int) (((long) (i5 | ((aVar.f33355e & 7) << 28))) | (aVar.f33356f & 268435455)));
        }
    }

    public String toString() {
        return "SegmentIndexBox [reference_ID=" + this.f33344c + ", timescale=" + this.f33345d + ", earliest_presentation_time=" + this.f33346e + ", first_offset=" + this.f33347f + ", reserved=" + this.f33348g + ", reference_count=" + this.f33349h + ", references=" + Arrays.toString(this.f33350j) + ", version=" + this.f33538a + ", flags=" + this.f33539b + ", header=" + this.f33452i + "]";
    }
}
