package info.hannes.logcat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.lifecycle.t;
import info.hannes.logcat.base.b;
import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.text.f;

public final class c extends b implements t<String> {

    /* renamed from: a  reason: collision with root package name */
    public static final a f28659a = new a((f) null);

    /* renamed from: c  reason: collision with root package name */
    private String f28660c;

    /* renamed from: d  reason: collision with root package name */
    private HashMap f28661d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public static /* synthetic */ c a(a aVar, String str, String str2, String str3, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                str3 = "";
            }
            return aVar.a(str, str2, str3);
        }

        public final c a(String str, String str2, String str3) {
            h.d(str, "targetFileName");
            h.d(str2, "searchHint");
            h.d(str3, "logMail");
            c cVar = new c();
            Bundle bundle = new Bundle();
            bundle.putString("targetFilename", str);
            bundle.putString("search_hint", str2);
            bundle.putString("mail_logger", str3);
            cVar.setArguments(bundle);
            return cVar;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004b, code lost:
        r3 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
        kotlin.io.a.a(r2, r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x004f, code lost:
        throw r3;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.util.ArrayList<java.lang.String> a() {
        /*
            r5 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.String r1 = r5.f28660c     // Catch:{ Exception -> 0x0050 }
            if (r1 == 0) goto L_0x0050
            java.io.File r2 = new java.io.File     // Catch:{ Exception -> 0x0050 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0050 }
            java.nio.charset.Charset r1 = kotlin.text.d.f30261a     // Catch:{ Exception -> 0x0050 }
            r3 = 8192(0x2000, float:1.14794E-41)
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ Exception -> 0x0050 }
            r4.<init>(r2)     // Catch:{ Exception -> 0x0050 }
            java.io.InputStream r4 = (java.io.InputStream) r4     // Catch:{ Exception -> 0x0050 }
            java.io.InputStreamReader r2 = new java.io.InputStreamReader     // Catch:{ Exception -> 0x0050 }
            r2.<init>(r4, r1)     // Catch:{ Exception -> 0x0050 }
            java.io.Reader r2 = (java.io.Reader) r2     // Catch:{ Exception -> 0x0050 }
            boolean r1 = r2 instanceof java.io.BufferedReader     // Catch:{ Exception -> 0x0050 }
            if (r1 == 0) goto L_0x0027
            java.io.BufferedReader r2 = (java.io.BufferedReader) r2     // Catch:{ Exception -> 0x0050 }
            goto L_0x002d
        L_0x0027:
            java.io.BufferedReader r1 = new java.io.BufferedReader     // Catch:{ Exception -> 0x0050 }
            r1.<init>(r2, r3)     // Catch:{ Exception -> 0x0050 }
            r2 = r1
        L_0x002d:
            java.io.Closeable r2 = (java.io.Closeable) r2     // Catch:{ Exception -> 0x0050 }
            r1 = 0
            java.lang.Throwable r1 = (java.lang.Throwable) r1     // Catch:{ Exception -> 0x0050 }
            r3 = r2
            java.io.BufferedReader r3 = (java.io.BufferedReader) r3     // Catch:{ all -> 0x0049 }
            mt.b r3 = kotlin.io.h.a((java.io.BufferedReader) r3)     // Catch:{ all -> 0x0049 }
            java.util.ArrayList r4 = new java.util.ArrayList     // Catch:{ all -> 0x0049 }
            java.util.List r3 = mt.c.b(r3)     // Catch:{ all -> 0x0049 }
            java.util.Collection r3 = (java.util.Collection) r3     // Catch:{ all -> 0x0049 }
            r4.<init>(r3)     // Catch:{ all -> 0x0049 }
            kotlin.io.a.a(r2, r1)     // Catch:{ Exception -> 0x0050 }
            r0 = r4
            goto L_0x0050
        L_0x0049:
            r1 = move-exception
            throw r1     // Catch:{ all -> 0x004b }
        L_0x004b:
            r3 = move-exception
            kotlin.io.a.a(r2, r1)     // Catch:{ Exception -> 0x0050 }
            throw r3     // Catch:{ Exception -> 0x0050 }
        L_0x0050:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: info.hannes.logcat.c.a():java.util.ArrayList");
    }

    /* renamed from: a */
    public void onChanged(String str) {
        info.hannes.logcat.base.c d2;
        if (str != null && (d2 = d()) != null) {
            d2.a(str);
        }
    }

    public void b() {
        String parent;
        File[] listFiles;
        ls.b a2 = ls.c.a();
        if (a2 != null && (parent = a2.a().getParent()) != null && (listFiles = new File(parent).listFiles()) != null) {
            Collection arrayList = new ArrayList();
            for (File file : listFiles) {
                h.b(file, "it");
                String name = file.getName();
                h.b(name, "it.name");
                if (f.c(name, ".log", false, 2, (Object) null)) {
                    arrayList.add(file);
                }
            }
            for (File file2 : (List) arrayList) {
                if (file2.exists()) {
                    file2.delete();
                }
            }
        }
    }

    public void c() {
        HashMap hashMap = this.f28661d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.d(layoutInflater, "inflater");
        ls.b a2 = ls.c.a();
        this.f28660c = a2 != null ? a2.b() : null;
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        c();
    }

    public void onStart() {
        super.onStart();
        ls.b.f30993a.a().a(this);
    }

    public void onStop() {
        ls.b.f30993a.a().b(this);
        super.onStop();
    }
}
