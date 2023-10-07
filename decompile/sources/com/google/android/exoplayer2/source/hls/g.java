package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.util.aa;
import fj.h;
import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f16220a = new c();

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final fj.g f16221a;

        /* renamed from: b  reason: collision with root package name */
        public final boolean f16222b;

        /* renamed from: c  reason: collision with root package name */
        public final boolean f16223c;

        public a(fj.g gVar, boolean z2, boolean z3) {
            this.f16221a = gVar;
            this.f16222b = z2;
            this.f16223c = z3;
        }
    }

    a a(fj.g gVar, Uri uri, Format format, List<Format> list, aa aaVar, Map<String, List<String>> map, h hVar) throws InterruptedException, IOException;
}
