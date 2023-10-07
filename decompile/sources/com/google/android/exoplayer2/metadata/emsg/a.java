package com.google.android.exoplayer2.metadata.emsg;

import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.metadata.c;
import com.google.android.exoplayer2.util.q;
import java.nio.ByteBuffer;
import java.util.Arrays;

public final class a implements com.google.android.exoplayer2.metadata.a {
    public Metadata a(c cVar) {
        ByteBuffer byteBuffer = (ByteBuffer) com.google.android.exoplayer2.util.a.b(cVar.f13099b);
        return new Metadata(a(new q(byteBuffer.array(), byteBuffer.limit())));
    }

    public EventMessage a(q qVar) {
        return new EventMessage((String) com.google.android.exoplayer2.util.a.b(qVar.A()), (String) com.google.android.exoplayer2.util.a.b(qVar.A()), qVar.n(), qVar.n(), Arrays.copyOfRange(qVar.f17159a, qVar.d(), qVar.c()));
    }
}
