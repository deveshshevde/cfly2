package com.google.android.exoplayer2.source.hls;

import android.net.Uri;
import android.text.TextUtils;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.extractor.mp4.e;
import com.google.android.exoplayer2.extractor.mp4.j;
import com.google.android.exoplayer2.metadata.Metadata;
import com.google.android.exoplayer2.source.hls.g;
import com.google.android.exoplayer2.util.aa;
import com.google.android.exoplayer2.util.n;
import fj.h;
import fq.a;
import fq.ab;
import java.io.EOFException;
import java.io.IOException;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class c implements g {

    /* renamed from: b  reason: collision with root package name */
    private final int f16192b;

    /* renamed from: c  reason: collision with root package name */
    private final boolean f16193c;

    public c() {
        this(0, true);
    }

    public c(int i2, boolean z2) {
        this.f16192b = i2;
        this.f16193c = z2;
    }

    private static e a(aa aaVar, Format format, List<Format> list) {
        int i2 = a(format) ? 4 : 0;
        if (list == null) {
            list = Collections.emptyList();
        }
        return new e(i2, aaVar, (j) null, list);
    }

    private static g.a a(fj.g gVar) {
        return new g.a(gVar, (gVar instanceof fq.e) || (gVar instanceof a) || (gVar instanceof fq.c) || (gVar instanceof fn.c), b(gVar));
    }

    private static g.a a(fj.g gVar, Format format, aa aaVar) {
        fj.g cVar;
        if (gVar instanceof n) {
            cVar = new n(format.A, aaVar);
        } else if (gVar instanceof fq.e) {
            cVar = new fq.e();
        } else if (gVar instanceof a) {
            cVar = new a();
        } else if (gVar instanceof fq.c) {
            cVar = new fq.c();
        } else if (!(gVar instanceof fn.c)) {
            return null;
        } else {
            cVar = new fn.c();
        }
        return a(cVar);
    }

    private fj.g a(Uri uri, Format format, List<Format> list, aa aaVar) {
        String lastPathSegment = uri.getLastPathSegment();
        if (lastPathSegment == null) {
            lastPathSegment = "";
        }
        return ("text/vtt".equals(format.f15092i) || lastPathSegment.endsWith(".webvtt") || lastPathSegment.endsWith(".vtt")) ? new n(format.A, aaVar) : lastPathSegment.endsWith(".aac") ? new fq.e() : (lastPathSegment.endsWith(".ac3") || lastPathSegment.endsWith(".ec3")) ? new a() : lastPathSegment.endsWith(".ac4") ? new fq.c() : lastPathSegment.endsWith(".mp3") ? new fn.c(0, 0) : (lastPathSegment.endsWith(".mp4") || lastPathSegment.startsWith(".m4", lastPathSegment.length() + -4) || lastPathSegment.startsWith(".mp4", lastPathSegment.length() + -5) || lastPathSegment.startsWith(".cmf", lastPathSegment.length() + -5)) ? a(aaVar, format, list) : a(this.f16192b, this.f16193c, format, list, aaVar);
    }

    private static ab a(int i2, boolean z2, Format format, List<Format> list, aa aaVar) {
        int i3 = i2 | 16;
        if (list != null) {
            i3 |= 32;
        } else {
            list = z2 ? Collections.singletonList(Format.a((String) null, "application/cea-608", 0, (String) null)) : Collections.emptyList();
        }
        String str = format.f15089f;
        if (!TextUtils.isEmpty(str)) {
            if (!"audio/mp4a-latm".equals(n.f(str))) {
                i3 |= 2;
            }
            if (!"video/avc".equals(n.e(str))) {
                i3 |= 4;
            }
        }
        return new ab(2, aaVar, new fq.g(i3, list));
    }

    private static boolean a(Format format) {
        Metadata metadata = format.f15090g;
        if (metadata == null) {
            return false;
        }
        for (int i2 = 0; i2 < metadata.a(); i2++) {
            Metadata.Entry a2 = metadata.a(i2);
            if (a2 instanceof HlsTrackMetadataEntry) {
                return !((HlsTrackMetadataEntry) a2).f16181c.isEmpty();
            }
        }
        return false;
    }

    /* JADX INFO: finally extract failed */
    private static boolean a(fj.g gVar, h hVar) throws InterruptedException, IOException {
        try {
            boolean a2 = gVar.a(hVar);
            hVar.a();
            return a2;
        } catch (EOFException unused) {
            hVar.a();
            return false;
        } catch (Throwable th) {
            hVar.a();
            throw th;
        }
    }

    private static boolean b(fj.g gVar) {
        return (gVar instanceof ab) || (gVar instanceof e);
    }

    public g.a a(fj.g gVar, Uri uri, Format format, List<Format> list, aa aaVar, Map<String, List<String>> map, h hVar) throws InterruptedException, IOException {
        if (gVar != null) {
            if (b(gVar)) {
                return a(gVar);
            }
            if (a(gVar, format, aaVar) == null) {
                String valueOf = String.valueOf(gVar.getClass().getSimpleName());
                throw new IllegalArgumentException(valueOf.length() != 0 ? "Unexpected previousExtractor type: ".concat(valueOf) : new String("Unexpected previousExtractor type: "));
            }
        }
        fj.g a2 = a(uri, format, list, aaVar);
        hVar.a();
        if (a(a2, hVar)) {
            return a(a2);
        }
        if (!(a2 instanceof n)) {
            n nVar = new n(format.A, aaVar);
            if (a(nVar, hVar)) {
                return a((fj.g) nVar);
            }
        }
        if (!(a2 instanceof fq.e)) {
            fq.e eVar = new fq.e();
            if (a(eVar, hVar)) {
                return a((fj.g) eVar);
            }
        }
        if (!(a2 instanceof a)) {
            a aVar = new a();
            if (a(aVar, hVar)) {
                return a((fj.g) aVar);
            }
        }
        if (!(a2 instanceof fq.c)) {
            fq.c cVar = new fq.c();
            if (a(cVar, hVar)) {
                return a((fj.g) cVar);
            }
        }
        if (!(a2 instanceof fn.c)) {
            fn.c cVar2 = new fn.c(0, 0);
            if (a(cVar2, hVar)) {
                return a((fj.g) cVar2);
            }
        }
        if (!(a2 instanceof e)) {
            e a3 = a(aaVar, format, list);
            if (a(a3, hVar)) {
                return a((fj.g) a3);
            }
        }
        if (!(a2 instanceof ab)) {
            ab a4 = a(this.f16192b, this.f16193c, format, list, aaVar);
            if (a(a4, hVar)) {
                return a((fj.g) a4);
            }
        }
        return a(a2);
    }
}
