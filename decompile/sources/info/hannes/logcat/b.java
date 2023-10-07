package info.hannes.logcat;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.io.BufferedReader;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.text.d;
import kotlin.text.f;

public final class b extends info.hannes.logcat.base.b {

    /* renamed from: a  reason: collision with root package name */
    public static final a f28630a = new a((f) null);

    /* renamed from: c  reason: collision with root package name */
    private final ArrayList<String> f28631c = new ArrayList<>();

    /* renamed from: d  reason: collision with root package name */
    private HashMap f28632d;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public static /* synthetic */ b a(a aVar, String str, String str2, String str3, int i2, Object obj) {
            if ((i2 & 4) != 0) {
                str3 = "";
            }
            return aVar.a(str, str2, str3);
        }

        public final b a(String str, String str2, String str3) {
            h.d(str, "targetFileName");
            h.d(str2, "searchHint");
            h.d(str3, "logMail");
            b bVar = new b();
            Bundle bundle = new Bundle();
            bundle.putString("targetFilename", str);
            bundle.putString("search_hint", str2);
            bundle.putString("mail_logger", str3);
            bVar.setArguments(bundle);
            return bVar;
        }
    }

    public ArrayList<String> a() {
        Throwable th;
        try {
            Process exec = Runtime.getRuntime().exec("logcat -dv time");
            h.b(exec, "process");
            InputStream inputStream = exec.getInputStream();
            h.b(inputStream, "process.inputStream");
            Reader inputStreamReader = new InputStreamReader(inputStream, d.f30261a);
            Closeable bufferedReader = inputStreamReader instanceof BufferedReader ? (BufferedReader) inputStreamReader : new BufferedReader(inputStreamReader, 8192);
            Throwable th2 = null;
            try {
                Iterable<String> a2 = kotlin.io.h.a((Reader) (BufferedReader) bufferedReader);
                Collection arrayList = new ArrayList(kotlin.collections.h.a(a2, 10));
                for (String a3 : a2) {
                    String a4 = f.a(f.a(f.a(f.a(f.a(a3, " W/", " W: ", false, 4, (Object) null), " E/", " E: ", false, 4, (Object) null), " V/", " V: ", false, 4, (Object) null), " I/", " I: ", false, 4, (Object) null), " D/", " D: ", false, 4, (Object) null);
                    if (!this.f28631c.contains(a4)) {
                        this.f28631c.add(a4);
                    }
                    arrayList.add(l.f30254a);
                }
                List list = (List) arrayList;
                kotlin.io.a.a(bufferedReader, th2);
                return this.f28631c;
            } catch (Throwable th3) {
                Throwable th4 = th3;
                kotlin.io.a.a(bufferedReader, th);
                throw th4;
            }
        } catch (IOException e2) {
            String message = e2.getMessage();
            h.a((Object) message);
            Log.e("LoadingLogcatTask", message);
        }
    }

    public void b() {
        Runtime.getRuntime().exec("logcat -c");
        this.f28631c.clear();
    }

    public void c() {
        HashMap hashMap = this.f28632d;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        h.d(layoutInflater, "inflater");
        a(true);
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public /* synthetic */ void onDestroyView() {
        super.onDestroyView();
        c();
    }
}
