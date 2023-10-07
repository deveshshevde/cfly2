package com.google.android.exoplayer2.upstream;

import android.text.TextUtils;
import com.google.android.exoplayer2.upstream.f;
import com.google.android.exoplayer2.util.ad;
import com.google.android.exoplayer2.util.s;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface HttpDataSource extends f {

    /* renamed from: a  reason: collision with root package name */
    public static final s<String> f16933a = $$Lambda$HttpDataSource$IaZ_10fWhQIR6oDnzRMDcej8Va0.INSTANCE;

    /* renamed from: com.google.android.exoplayer2.upstream.HttpDataSource$-CC  reason: invalid class name */
    public final /* synthetic */ class CC {
        public static /* synthetic */ boolean a(String str) {
            String d2 = ad.d(str);
            return !TextUtils.isEmpty(d2) && (!d2.contains("text") || d2.contains("text/vtt")) && !d2.contains("html") && !d2.contains("xml");
        }
    }

    public static class HttpDataSourceException extends IOException {

        /* renamed from: a  reason: collision with root package name */
        public final int f16934a;

        /* renamed from: b  reason: collision with root package name */
        public final h f16935b;

        public HttpDataSourceException(IOException iOException, h hVar, int i2) {
            super(iOException);
            this.f16935b = hVar;
            this.f16934a = i2;
        }

        public HttpDataSourceException(String str, h hVar, int i2) {
            super(str);
            this.f16935b = hVar;
            this.f16934a = i2;
        }

        public HttpDataSourceException(String str, IOException iOException, h hVar, int i2) {
            super(str, iOException);
            this.f16935b = hVar;
            this.f16934a = i2;
        }
    }

    public static final class InvalidContentTypeException extends HttpDataSourceException {

        /* renamed from: c  reason: collision with root package name */
        public final String f16936c;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public InvalidContentTypeException(java.lang.String r4, com.google.android.exoplayer2.upstream.h r5) {
            /*
                r3 = this;
                java.lang.String r0 = java.lang.String.valueOf(r4)
                int r1 = r0.length()
                java.lang.String r2 = "Invalid content type: "
                if (r1 == 0) goto L_0x0011
                java.lang.String r0 = r2.concat(r0)
                goto L_0x0016
            L_0x0011:
                java.lang.String r0 = new java.lang.String
                r0.<init>(r2)
            L_0x0016:
                r1 = 1
                r3.<init>((java.lang.String) r0, (com.google.android.exoplayer2.upstream.h) r5, (int) r1)
                r3.f16936c = r4
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.HttpDataSource.InvalidContentTypeException.<init>(java.lang.String, com.google.android.exoplayer2.upstream.h):void");
        }
    }

    public static final class InvalidResponseCodeException extends HttpDataSourceException {

        /* renamed from: c  reason: collision with root package name */
        public final int f16937c;

        /* renamed from: d  reason: collision with root package name */
        public final String f16938d;

        /* renamed from: e  reason: collision with root package name */
        public final Map<String, List<String>> f16939e;

        /* JADX WARNING: Illegal instructions before constructor call */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public InvalidResponseCodeException(int r3, java.lang.String r4, java.util.Map<java.lang.String, java.util.List<java.lang.String>> r5, com.google.android.exoplayer2.upstream.h r6) {
            /*
                r2 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                r1 = 26
                r0.<init>(r1)
                java.lang.String r1 = "Response code: "
                r0.append(r1)
                r0.append(r3)
                java.lang.String r0 = r0.toString()
                r1 = 1
                r2.<init>((java.lang.String) r0, (com.google.android.exoplayer2.upstream.h) r6, (int) r1)
                r2.f16937c = r3
                r2.f16938d = r4
                r2.f16939e = r5
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.google.android.exoplayer2.upstream.HttpDataSource.InvalidResponseCodeException.<init>(int, java.lang.String, java.util.Map, com.google.android.exoplayer2.upstream.h):void");
        }
    }

    public static abstract class a implements b {

        /* renamed from: a  reason: collision with root package name */
        private final c f16940a = new c();

        /* renamed from: b */
        public final HttpDataSource a() {
            return b(this.f16940a);
        }

        /* access modifiers changed from: protected */
        public abstract HttpDataSource b(c cVar);
    }

    public interface b extends f.a {

        /* renamed from: com.google.android.exoplayer2.upstream.HttpDataSource$b$-CC  reason: invalid class name */
        public final /* synthetic */ class CC {
        }

        /* synthetic */ f a();

        HttpDataSource b();
    }

    public static final class c {

        /* renamed from: a  reason: collision with root package name */
        private final Map<String, String> f16941a = new HashMap();

        /* renamed from: b  reason: collision with root package name */
        private Map<String, String> f16942b;

        public synchronized Map<String, String> a() {
            if (this.f16942b == null) {
                this.f16942b = Collections.unmodifiableMap(new HashMap(this.f16941a));
            }
            return this.f16942b;
        }
    }
}
