package com.google.android.exoplayer2.upstream;

import android.net.Uri;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public interface f {

    /* renamed from: com.google.android.exoplayer2.upstream.f$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static Map $default$b(f fVar) {
            return Collections.emptyMap();
        }
    }

    public interface a {
        f a();
    }

    int a(byte[] bArr, int i2, int i3) throws IOException;

    long a(h hVar) throws IOException;

    Uri a();

    void a(t tVar);

    Map<String, List<String>> b();

    void c() throws IOException;
}
