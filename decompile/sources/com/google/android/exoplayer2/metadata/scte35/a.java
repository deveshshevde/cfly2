package com.google.android.exoplayer2.metadata.scte35;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.c;
import com.google.android.exoplayer2.util.aa;
import com.google.android.exoplayer2.util.p;
import com.google.android.exoplayer2.util.q;
import java.nio.ByteBuffer;

public final class a implements com.google.android.exoplayer2.metadata.a {

    /* renamed from: a  reason: collision with root package name */
    private final q f15965a = new q();

    /* renamed from: b  reason: collision with root package name */
    private final p f15966b = new p();

    /* renamed from: c  reason: collision with root package name */
    private aa f15967c;

    public Metadata a(c cVar) {
        ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.b(cVar.f13099b);
        if (this.f15967c == null || cVar.f15843f != this.f15967c.c()) {
            aa aaVar = new aa(cVar.f13101d);
            this.f15967c = aaVar;
            aaVar.c(cVar.f13101d - cVar.f15843f);
        }
        byte[] array = byteBuffer.array();
        int limit = byteBuffer.limit();
        this.f15965a.a(array, limit);
        this.f15966b.a(array, limit);
        this.f15966b.b(39);
        long c2 = (((long) this.f15966b.c(1)) << 32) | ((long) this.f15966b.c(32));
        this.f15966b.b(20);
        int c3 = this.f15966b.c(12);
        int c4 = this.f15966b.c(8);
        Metadata.Entry entry = null;
        this.f15965a.d(14);
        if (c4 == 0) {
            entry = new SpliceNullCommand();
        } else if (c4 == 255) {
            entry = PrivateCommand.a(this.f15965a, c3, c2);
        } else if (c4 == 4) {
            entry = SpliceScheduleCommand.a(this.f15965a);
        } else if (c4 == 5) {
            entry = SpliceInsertCommand.a(this.f15965a, c2, this.f15967c);
        } else if (c4 == 6) {
            entry = TimeSignalCommand.a(this.f15965a, c2, this.f15967c);
        }
        if (entry == null) {
            return new Metadata(new Metadata.Entry[0]);
        }
        return new Metadata(entry);
    }
}
