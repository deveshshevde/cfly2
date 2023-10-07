package retrofit2;

import java.io.IOException;
import java.util.regex.Pattern;
import okhttp3.aa;
import okhttp3.q;
import okhttp3.s;
import okhttp3.t;
import okhttp3.v;
import okhttp3.w;
import okhttp3.z;
import okio.c;
import okio.d;

final class RequestBuilder {
    private static final char[] HEX_DIGITS = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};
    private static final String PATH_SEGMENT_ALWAYS_ENCODE_SET = " \"<>^`{}|\\?#";
    private static final Pattern PATH_TRAVERSAL = Pattern.compile("(.*/)?(\\.|%2e|%2E){1,2}(/.*)?");
    private final t baseUrl;
    private aa body;
    private v contentType;
    private q.a formBuilder;
    private final boolean hasBody;
    private final s.a headersBuilder;
    private final String method;
    private w.a multipartBuilder;
    private String relativeUrl;
    private final z.a requestBuilder = new z.a();
    private t.a urlBuilder;

    private static class ContentTypeOverridingRequestBody extends aa {
        private final v contentType;
        private final aa delegate;

        ContentTypeOverridingRequestBody(aa aaVar, v vVar) {
            this.delegate = aaVar;
            this.contentType = vVar;
        }

        public long contentLength() throws IOException {
            return this.delegate.contentLength();
        }

        public v contentType() {
            return this.contentType;
        }

        public void writeTo(d dVar) throws IOException {
            this.delegate.writeTo(dVar);
        }
    }

    RequestBuilder(String str, t tVar, String str2, s sVar, v vVar, boolean z2, boolean z3, boolean z4) {
        this.method = str;
        this.baseUrl = tVar;
        this.relativeUrl = str2;
        this.contentType = vVar;
        this.hasBody = z2;
        this.headersBuilder = sVar != null ? sVar.b() : new s.a();
        if (z3) {
            this.formBuilder = new q.a();
        } else if (z4) {
            w.a aVar = new w.a();
            this.multipartBuilder = aVar;
            aVar.a(w.f32329e);
        }
    }

    private static String canonicalizeForPath(String str, boolean z2) {
        int length = str.length();
        int i2 = 0;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            if (codePointAt < 32 || codePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) != -1 || (!z2 && (codePointAt == 47 || codePointAt == 37))) {
                c cVar = new c();
                cVar.a(str, 0, i2);
                canonicalizeForPath(cVar, str, i2, length, z2);
                return cVar.p();
            }
            i2 += Character.charCount(codePointAt);
        }
        return str;
    }

    private static void canonicalizeForPath(c cVar, String str, int i2, int i3, boolean z2) {
        c cVar2 = null;
        while (i2 < i3) {
            int codePointAt = str.codePointAt(i2);
            if (!z2 || !(codePointAt == 9 || codePointAt == 10 || codePointAt == 12 || codePointAt == 13)) {
                if (codePointAt < 32 || codePointAt >= 127 || PATH_SEGMENT_ALWAYS_ENCODE_SET.indexOf(codePointAt) != -1 || (!z2 && (codePointAt == 47 || codePointAt == 37))) {
                    if (cVar2 == null) {
                        cVar2 = new c();
                    }
                    cVar2.a(codePointAt);
                    while (!cVar2.f()) {
                        byte i4 = cVar2.i() & 255;
                        cVar.i(37);
                        char[] cArr = HEX_DIGITS;
                        cVar.i((int) cArr[(i4 >> 4) & 15]);
                        cVar.i((int) cArr[i4 & 15]);
                    }
                } else {
                    cVar.a(codePointAt);
                }
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    /* access modifiers changed from: package-private */
    public void addFormField(String str, String str2, boolean z2) {
        if (z2) {
            this.formBuilder.b(str, str2);
        } else {
            this.formBuilder.a(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void addHeader(String str, String str2) {
        if ("Content-Type".equalsIgnoreCase(str)) {
            try {
                this.contentType = v.a(str2);
            } catch (IllegalArgumentException e2) {
                throw new IllegalArgumentException("Malformed content type: " + str2, e2);
            }
        } else {
            this.headersBuilder.a(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public void addHeaders(s sVar) {
        this.headersBuilder.a(sVar);
    }

    /* access modifiers changed from: package-private */
    public void addPart(s sVar, aa aaVar) {
        this.multipartBuilder.a(sVar, aaVar);
    }

    /* access modifiers changed from: package-private */
    public void addPart(w.b bVar) {
        this.multipartBuilder.a(bVar);
    }

    /* access modifiers changed from: package-private */
    public void addPathParam(String str, String str2, boolean z2) {
        if (this.relativeUrl != null) {
            String canonicalizeForPath = canonicalizeForPath(str2, z2);
            String str3 = this.relativeUrl;
            String replace = str3.replace("{" + str + "}", canonicalizeForPath);
            if (!PATH_TRAVERSAL.matcher(replace).matches()) {
                this.relativeUrl = replace;
                return;
            }
            throw new IllegalArgumentException("@Path parameters shouldn't perform path traversal ('.' or '..'): " + str2);
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    public void addQueryParam(String str, String str2, boolean z2) {
        String str3 = this.relativeUrl;
        if (str3 != null) {
            t.a d2 = this.baseUrl.d(str3);
            this.urlBuilder = d2;
            if (d2 != null) {
                this.relativeUrl = null;
            } else {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        if (z2) {
            this.urlBuilder.b(str, str2);
        } else {
            this.urlBuilder.a(str, str2);
        }
    }

    /* access modifiers changed from: package-private */
    public <T> void addTag(Class<T> cls, T t2) {
        this.requestBuilder.a(cls, t2);
    }

    /* access modifiers changed from: package-private */
    public z.a get() {
        t tVar;
        t.a aVar = this.urlBuilder;
        if (aVar != null) {
            tVar = aVar.c();
        } else {
            tVar = this.baseUrl.c(this.relativeUrl);
            if (tVar == null) {
                throw new IllegalArgumentException("Malformed URL. Base: " + this.baseUrl + ", Relative: " + this.relativeUrl);
            }
        }
        ContentTypeOverridingRequestBody contentTypeOverridingRequestBody = this.body;
        if (contentTypeOverridingRequestBody == null) {
            q.a aVar2 = this.formBuilder;
            if (aVar2 != null) {
                contentTypeOverridingRequestBody = aVar2.a();
            } else {
                w.a aVar3 = this.multipartBuilder;
                if (aVar3 != null) {
                    contentTypeOverridingRequestBody = aVar3.a();
                } else if (this.hasBody) {
                    contentTypeOverridingRequestBody = aa.create((v) null, new byte[0]);
                }
            }
        }
        v vVar = this.contentType;
        if (vVar != null) {
            if (contentTypeOverridingRequestBody != null) {
                contentTypeOverridingRequestBody = new ContentTypeOverridingRequestBody(contentTypeOverridingRequestBody, vVar);
            } else {
                this.headersBuilder.a("Content-Type", vVar.toString());
            }
        }
        return this.requestBuilder.a(tVar).a(this.headersBuilder.a()).a(this.method, contentTypeOverridingRequestBody);
    }

    /* access modifiers changed from: package-private */
    public void setBody(aa aaVar) {
        this.body = aaVar;
    }

    /* access modifiers changed from: package-private */
    public void setRelativeUrl(Object obj) {
        this.relativeUrl = obj.toString();
    }
}
