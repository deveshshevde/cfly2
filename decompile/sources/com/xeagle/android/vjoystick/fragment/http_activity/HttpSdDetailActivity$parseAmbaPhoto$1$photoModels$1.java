package com.xeagle.android.vjoystick.fragment.http_activity;

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

@d(b = "HttpSdDetailActivity.kt", c = {}, d = "invokeSuspend", e = "com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity$parseAmbaPhoto$1$photoModels$1")
final class HttpSdDetailActivity$parseAmbaPhoto$1$photoModels$1 extends SuspendLambda implements m<af, c<? super ArrayList<a>>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f25143a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ HttpSdDetailActivity$parseAmbaPhoto$1 f25144b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpSdDetailActivity$parseAmbaPhoto$1$photoModels$1(HttpSdDetailActivity$parseAmbaPhoto$1 httpSdDetailActivity$parseAmbaPhoto$1, c cVar) {
        super(2, cVar);
        this.f25144b = httpSdDetailActivity$parseAmbaPhoto$1;
    }

    public final Object a(Object obj, Object obj2) {
        return ((HttpSdDetailActivity$parseAmbaPhoto$1$photoModels$1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
    }

    public final c<l> create(Object obj, c<?> cVar) {
        h.d(cVar, "completion");
        return new HttpSdDetailActivity$parseAmbaPhoto$1$photoModels$1(this.f25144b, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a.a();
        if (this.f25143a == 0) {
            i.a(obj);
            ArrayList arrayList = new ArrayList();
            try {
                String a2 = f.a(this.f25144b.f25141c, "http://172.50.10.1/SD/AMBA/", "", false, 4, (Object) null);
                Document a3 = org.jsoup.a.a(this.f25144b.f25142d);
                Iterator it2 = a3.e("tr").iterator();
                while (it2.hasNext()) {
                    Element element = (Element) it2.next();
                    String b2 = element.e("a[class=link]").b();
                    if (h.a((Object) this.f25144b.f25140b.f12951l, (Object) "IMAGE")) {
                        h.b(b2, "elementName");
                        if (b2 != null) {
                            h.b(b2.toUpperCase(), "(this as java.lang.String).toUpperCase()");
                            if (f.c(b2, ".JPG", false, 2, (Object) null)) {
                                String b3 = element.e("span").b();
                                h.b(b3, "element.select(\"span\").text()");
                                String a4 = f.a(b3, " ", "", false, 4, (Object) null);
                                arrayList.add(new a(false, a4, "/tmp/SD0/AMBA/" + a2 + element.e("a").a("href"), "0", (String) null, 0, 0, 112, (f) null));
                            }
                        } else {
                            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
                        }
                    }
                }
                if (h.a((Object) this.f25144b.f25140b.f12951l, (Object) "PANO")) {
                    Iterator it3 = a3.e("a[class=link]").iterator();
                    while (it3.hasNext()) {
                        String a5 = ((Element) it3.next()).e("a").a("href");
                        h.b(a5, "elementName");
                        if (f.b(a5, "PAN", false, 2, (Object) null)) {
                            arrayList.add(new a(true, "0M", a5, "-", (String) null, 0, 0, 112, (f) null));
                        }
                    }
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            return arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
