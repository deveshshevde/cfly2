package com.xeagle.android.vjoystick.fragment.http_activity;

import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.c;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.i;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.text.f;
import kotlinx.coroutines.af;
import lc.a;
import mm.m;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@d(b = "HttpSdDetailActivity.kt", c = {}, d = "invokeSuspend", e = "com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity$parseAmbaVideo$1$videoModels$1")
final class HttpSdDetailActivity$parseAmbaVideo$1$videoModels$1 extends SuspendLambda implements m<af, c<? super ArrayList<a>>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f25154a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ HttpSdDetailActivity$parseAmbaVideo$1 f25155b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpSdDetailActivity$parseAmbaVideo$1$videoModels$1(HttpSdDetailActivity$parseAmbaVideo$1 httpSdDetailActivity$parseAmbaVideo$1, c cVar) {
        super(2, cVar);
        this.f25155b = httpSdDetailActivity$parseAmbaVideo$1;
    }

    public final Object a(Object obj, Object obj2) {
        return ((HttpSdDetailActivity$parseAmbaVideo$1$videoModels$1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
    }

    public final c<l> create(Object obj, c<?> cVar) {
        h.d(cVar, "completion");
        return new HttpSdDetailActivity$parseAmbaVideo$1$videoModels$1(this.f25155b, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        ArrayList arrayList;
        Iterator it2;
        ArrayList arrayList2;
        kotlin.coroutines.intrinsics.a.a();
        if (this.f25154a == 0) {
            i.a(obj);
            ArrayList arrayList3 = new ArrayList();
            ArrayList arrayList4 = new ArrayList();
            try {
                String a2 = f.a(this.f25155b.f25152c, "http://172.50.10.1/SD/AMBA/", "", false, 4, (Object) null);
                Document a3 = org.jsoup.a.a(this.f25155b.f25153d);
                Iterator it3 = a3.e("tr").iterator();
                while (it3.hasNext()) {
                    Element element = (Element) it3.next();
                    String b2 = element.e("a[class=link]").b();
                    h.b(b2, "element.select(\"a[class=link]\").text()");
                    if (f.a((CharSequence) b2, (CharSequence) "MP4", false, 2, (Object) null)) {
                        it2 = it3;
                        StringBuilder sb = new StringBuilder();
                        arrayList = arrayList4;
                        sb.append("run:===video== ");
                        sb.append(this.f25155b.f25152c);
                        Log.i("UsbDataProxy", sb.toString());
                        String b3 = element.e("span").b();
                        h.b(b3, "element.select(\"span\").text()");
                        String a4 = f.a(b3, " ", "", false, 4, (Object) null);
                        arrayList3.add(new a(false, a4, "/tmp/SD0/AMBA/" + a2 + element.e("a").a("href"), "0", (String) null, 0, 0, 112, (f) null));
                    } else {
                        arrayList = arrayList4;
                        it2 = it3;
                    }
                    if (h.a((Object) this.f25155b.f25151b.f12951l, (Object) "TIME")) {
                        Iterator it4 = a3.e("a[class=link]").iterator();
                        while (it4.hasNext()) {
                            String a5 = ((Element) it4.next()).e("a").a("href");
                            h.b(a5, "elementName");
                            Iterator it5 = it4;
                            String str = a2;
                            Document document = a3;
                            if (!f.b(a5, ".", false, 2, (Object) null)) {
                                if (!f.b(a5, "~", false, 2, (Object) null)) {
                                    if (f.b(a5, "TIME", false, 2, (Object) null)) {
                                        arrayList3.add(new a(true, "0M", a5, "-", (String) null, 0, 0, 112, (f) null));
                                    }
                                }
                            }
                            it4 = it5;
                            a2 = str;
                            a3 = document;
                        }
                    }
                    String str2 = a2;
                    Document document2 = a3;
                    String b4 = element.e("a[class=link]").b();
                    h.b(b4, "element.select(\"a[class=link]\").text()");
                    if (f.a((CharSequence) b4, (CharSequence) "AB", false, 2, (Object) null)) {
                        String b5 = element.e("span").b();
                        h.b(b5, "element.select(\"span\").text()");
                        String a6 = f.a(b5, " ", "", false, 4, (Object) null);
                        arrayList2 = arrayList;
                        arrayList2.add(new a(false, a6, "/tmp/SD0/AMBA/" + this.f25155b.f25152c + element.e("a").a("href"), "0", (String) null, 0, 0, 112, (f) null));
                    } else {
                        arrayList2 = arrayList;
                    }
                    arrayList4 = arrayList2;
                    it3 = it2;
                    a2 = str2;
                    a3 = document2;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return arrayList3;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
