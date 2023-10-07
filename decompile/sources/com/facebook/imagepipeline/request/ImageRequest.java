package com.facebook.imagepipeline.request;

import android.net.Uri;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.common.a;
import com.facebook.imagepipeline.common.b;
import com.facebook.imagepipeline.common.d;
import com.facebook.imagepipeline.common.e;
import java.io.File;

public class ImageRequest {

    /* renamed from: a  reason: collision with root package name */
    private final CacheChoice f11371a;

    /* renamed from: b  reason: collision with root package name */
    private final Uri f11372b;

    /* renamed from: c  reason: collision with root package name */
    private File f11373c;

    /* renamed from: d  reason: collision with root package name */
    private final b f11374d;

    /* renamed from: e  reason: collision with root package name */
    private final d f11375e;

    /* renamed from: f  reason: collision with root package name */
    private final e f11376f;

    /* renamed from: g  reason: collision with root package name */
    private final a f11377g;

    /* renamed from: h  reason: collision with root package name */
    private final Priority f11378h;

    /* renamed from: i  reason: collision with root package name */
    private final a f11379i;

    /* renamed from: j  reason: collision with root package name */
    private final Boolean f11380j;

    public enum CacheChoice {
        SMALL,
        DEFAULT
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ImageRequest)) {
            return false;
        }
        ImageRequest imageRequest = (ImageRequest) obj;
        if (!df.b.a(this.f11372b, imageRequest.f11372b) || !df.b.a(this.f11371a, imageRequest.f11371a) || !df.b.a(this.f11373c, imageRequest.f11373c) || !df.b.a(this.f11377g, imageRequest.f11377g) || !df.b.a(this.f11374d, imageRequest.f11374d) || !df.b.a(this.f11375e, imageRequest.f11375e) || !df.b.a(this.f11376f, imageRequest.f11376f)) {
            return false;
        }
        a aVar = this.f11379i;
        de.a aVar2 = null;
        de.a a2 = aVar != null ? aVar.a() : null;
        a aVar3 = imageRequest.f11379i;
        if (aVar3 != null) {
            aVar2 = aVar3.a();
        }
        return df.b.a(a2, aVar2);
    }

    public int hashCode() {
        a aVar = this.f11379i;
        return df.b.a(this.f11371a, this.f11372b, this.f11373c, this.f11377g, this.f11374d, this.f11375e, this.f11376f, aVar != null ? aVar.a() : null, this.f11380j);
    }

    public String toString() {
        return df.b.a((Object) this).a("uri", (Object) this.f11372b).a("cacheChoice", (Object) this.f11371a).a("decodeOptions", (Object) this.f11374d).a("postprocessor", (Object) this.f11379i).a("priority", (Object) this.f11378h).a("resizeOptions", (Object) this.f11375e).a("rotationOptions", (Object) this.f11376f).a("bytesRange", (Object) this.f11377g).a("resizingAllowedOverride", (Object) this.f11380j).toString();
    }
}
