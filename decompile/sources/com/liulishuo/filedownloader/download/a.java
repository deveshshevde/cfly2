package com.liulishuo.filedownloader.download;

import android.text.TextUtils;
import com.liulishuo.filedownloader.download.b;
import com.liulishuo.filedownloader.model.FileDownloadHeader;
import im.b;
import iq.d;
import iq.f;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class a {

    /* renamed from: a  reason: collision with root package name */
    final int f21245a;

    /* renamed from: b  reason: collision with root package name */
    final String f21246b;

    /* renamed from: c  reason: collision with root package name */
    final FileDownloadHeader f21247c;

    /* renamed from: d  reason: collision with root package name */
    private b f21248d;

    /* renamed from: e  reason: collision with root package name */
    private String f21249e;

    /* renamed from: f  reason: collision with root package name */
    private Map<String, List<String>> f21250f;

    /* renamed from: g  reason: collision with root package name */
    private List<String> f21251g;

    /* renamed from: com.liulishuo.filedownloader.download.a$a  reason: collision with other inner class name */
    static class C0140a {

        /* renamed from: a  reason: collision with root package name */
        private Integer f21252a;

        /* renamed from: b  reason: collision with root package name */
        private String f21253b;

        /* renamed from: c  reason: collision with root package name */
        private String f21254c;

        /* renamed from: d  reason: collision with root package name */
        private FileDownloadHeader f21255d;

        /* renamed from: e  reason: collision with root package name */
        private b f21256e;

        C0140a() {
        }

        public C0140a a(int i2) {
            this.f21252a = Integer.valueOf(i2);
            return this;
        }

        public C0140a a(b bVar) {
            this.f21256e = bVar;
            return this;
        }

        public C0140a a(FileDownloadHeader fileDownloadHeader) {
            this.f21255d = fileDownloadHeader;
            return this;
        }

        public C0140a a(String str) {
            this.f21253b = str;
            return this;
        }

        /* access modifiers changed from: package-private */
        public a a() {
            b bVar;
            Integer num = this.f21252a;
            if (num != null && (bVar = this.f21256e) != null && this.f21253b != null) {
                return new a(bVar, num.intValue(), this.f21253b, this.f21254c, this.f21255d);
            }
            throw new IllegalArgumentException();
        }

        public C0140a b(String str) {
            this.f21254c = str;
            return this;
        }
    }

    private a(b bVar, int i2, String str, String str2, FileDownloadHeader fileDownloadHeader) {
        this.f21245a = i2;
        this.f21246b = str;
        this.f21249e = str2;
        this.f21247c = fileDownloadHeader;
        this.f21248d = bVar;
    }

    private void a(b bVar) {
        HashMap<String, List<String>> a2;
        FileDownloadHeader fileDownloadHeader = this.f21247c;
        if (fileDownloadHeader != null && (a2 = fileDownloadHeader.a()) != null) {
            if (d.f29057a) {
                d.e(this, "%d add outside header: %s", Integer.valueOf(this.f21245a), a2);
            }
            for (Map.Entry next : a2.entrySet()) {
                String str = (String) next.getKey();
                List<String> list = (List) next.getValue();
                if (list != null) {
                    for (String a3 : list) {
                        bVar.a(str, a3);
                    }
                }
            }
        }
    }

    private void b(b bVar) throws ProtocolException {
        if (!bVar.a(this.f21249e, this.f21248d.f21257a)) {
            if (!TextUtils.isEmpty(this.f21249e)) {
                bVar.a("If-Match", this.f21249e);
            }
            this.f21248d.a(bVar);
        }
    }

    private void c(b bVar) {
        FileDownloadHeader fileDownloadHeader = this.f21247c;
        if (fileDownloadHeader == null || fileDownloadHeader.a().get("User-Agent") == null) {
            bVar.a("User-Agent", f.e());
        }
    }

    /* access modifiers changed from: package-private */
    public b a() throws IOException, IllegalAccessException {
        b a2 = c.a().a(this.f21246b);
        a(a2);
        b(a2);
        c(a2);
        this.f21250f = a2.b();
        if (d.f29057a) {
            d.c(this, "<---- %s request header %s", Integer.valueOf(this.f21245a), this.f21250f);
        }
        a2.d();
        ArrayList arrayList = new ArrayList();
        this.f21251g = arrayList;
        b a3 = im.d.a(this.f21250f, a2, arrayList);
        if (d.f29057a) {
            d.c(this, "----> %s response header %s", Integer.valueOf(this.f21245a), a3.c());
        }
        return a3;
    }

    /* access modifiers changed from: package-private */
    public void a(long j2) {
        if (j2 == this.f21248d.f21258b) {
            d.d(this, "no data download, no need to update", new Object[0]);
            return;
        }
        long j3 = j2;
        this.f21248d = b.a.a(this.f21248d.f21257a, j3, this.f21248d.f21259c, this.f21248d.f21260d - (j2 - this.f21248d.f21258b));
        if (d.f29057a) {
            d.b(this, "after update profile:%s", this.f21248d);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean b() {
        return this.f21248d.f21258b > 0;
    }

    /* access modifiers changed from: package-private */
    public String c() {
        List<String> list = this.f21251g;
        if (list == null || list.isEmpty()) {
            return null;
        }
        List<String> list2 = this.f21251g;
        return list2.get(list2.size() - 1);
    }

    public Map<String, List<String>> d() {
        return this.f21250f;
    }

    public b e() {
        return this.f21248d;
    }
}
