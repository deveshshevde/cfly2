package com.google.android.exoplayer2.source.hls.playlist;

import android.net.Uri;
import com.google.android.exoplayer2.Format;
import com.google.android.exoplayer2.drm.DrmInitData;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public final class c extends e {

    /* renamed from: a  reason: collision with root package name */
    public static final c f16292a = new c("", Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), (Format) null, Collections.emptyList(), false, Collections.emptyMap(), Collections.emptyList());

    /* renamed from: b  reason: collision with root package name */
    public final List<Uri> f16293b;

    /* renamed from: c  reason: collision with root package name */
    public final List<b> f16294c;

    /* renamed from: d  reason: collision with root package name */
    public final List<a> f16295d;

    /* renamed from: e  reason: collision with root package name */
    public final List<a> f16296e;

    /* renamed from: f  reason: collision with root package name */
    public final List<a> f16297f;

    /* renamed from: g  reason: collision with root package name */
    public final List<a> f16298g;

    /* renamed from: h  reason: collision with root package name */
    public final Format f16299h;

    /* renamed from: i  reason: collision with root package name */
    public final List<Format> f16300i;

    /* renamed from: j  reason: collision with root package name */
    public final Map<String, String> f16301j;

    /* renamed from: k  reason: collision with root package name */
    public final List<DrmInitData> f16302k;

    public static final class a {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f16303a;

        /* renamed from: b  reason: collision with root package name */
        public final Format f16304b;

        /* renamed from: c  reason: collision with root package name */
        public final String f16305c;

        /* renamed from: d  reason: collision with root package name */
        public final String f16306d;

        public a(Uri uri, Format format, String str, String str2) {
            this.f16303a = uri;
            this.f16304b = format;
            this.f16305c = str;
            this.f16306d = str2;
        }
    }

    public static final class b {

        /* renamed from: a  reason: collision with root package name */
        public final Uri f16307a;

        /* renamed from: b  reason: collision with root package name */
        public final Format f16308b;

        /* renamed from: c  reason: collision with root package name */
        public final String f16309c;

        /* renamed from: d  reason: collision with root package name */
        public final String f16310d;

        /* renamed from: e  reason: collision with root package name */
        public final String f16311e;

        /* renamed from: f  reason: collision with root package name */
        public final String f16312f;

        public b(Uri uri, Format format, String str, String str2, String str3, String str4) {
            this.f16307a = uri;
            this.f16308b = format;
            this.f16309c = str;
            this.f16310d = str2;
            this.f16311e = str3;
            this.f16312f = str4;
        }

        public static b a(Uri uri) {
            return new b(uri, Format.b("0", (String) null, "application/x-mpegURL", (String) null, (String) null, -1, 0, 0, (String) null), (String) null, (String) null, (String) null, (String) null);
        }

        public b a(Format format) {
            return new b(this.f16307a, format, this.f16309c, this.f16310d, this.f16311e, this.f16312f);
        }
    }

    public c(String str, List<String> list, List<b> list2, List<a> list3, List<a> list4, List<a> list5, List<a> list6, Format format, List<Format> list7, boolean z2, Map<String, String> map, List<DrmInitData> list8) {
        super(str, list, z2);
        this.f16293b = Collections.unmodifiableList(a(list2, list3, list4, list5, list6));
        this.f16294c = Collections.unmodifiableList(list2);
        this.f16295d = Collections.unmodifiableList(list3);
        this.f16296e = Collections.unmodifiableList(list4);
        this.f16297f = Collections.unmodifiableList(list5);
        this.f16298g = Collections.unmodifiableList(list6);
        this.f16299h = format;
        this.f16300i = list7 != null ? Collections.unmodifiableList(list7) : null;
        this.f16301j = Collections.unmodifiableMap(map);
        this.f16302k = Collections.unmodifiableList(list8);
    }

    public static c a(String str) {
        return new c("", Collections.emptyList(), Collections.singletonList(b.a(Uri.parse(str))), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), Collections.emptyList(), (Format) null, (List<Format>) null, false, Collections.emptyMap(), Collections.emptyList());
    }

    private static List<Uri> a(List<b> list, List<a> list2, List<a> list3, List<a> list4, List<a> list5) {
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < list.size(); i2++) {
            Uri uri = list.get(i2).f16307a;
            if (!arrayList.contains(uri)) {
                arrayList.add(uri);
            }
        }
        a(list2, arrayList);
        a(list3, arrayList);
        a(list4, arrayList);
        a(list5, arrayList);
        return arrayList;
    }

    private static void a(List<a> list, List<Uri> list2) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            Uri uri = list.get(i2).f16303a;
            if (uri != null && !list2.contains(uri)) {
                list2.add(uri);
            }
        }
    }
}
