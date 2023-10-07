package com.xeagle.android.vjoystick.fragment.http_activity;

import java.util.ArrayList;
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
import org.jsoup.select.Elements;

@d(b = "HttpSdDetailActivity.kt", c = {}, d = "invokeSuspend", e = "com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity$parseAmbaPhotoHtml$1$photoModels$1")
final class HttpSdDetailActivity$parseAmbaPhotoHtml$1$photoModels$1 extends SuspendLambda implements m<af, c<? super ArrayList<a>>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f25148a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ HttpSdDetailActivity$parseAmbaPhotoHtml$1 f25149b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    HttpSdDetailActivity$parseAmbaPhotoHtml$1$photoModels$1(HttpSdDetailActivity$parseAmbaPhotoHtml$1 httpSdDetailActivity$parseAmbaPhotoHtml$1, c cVar) {
        super(2, cVar);
        this.f25149b = httpSdDetailActivity$parseAmbaPhotoHtml$1;
    }

    public final Object a(Object obj, Object obj2) {
        return ((HttpSdDetailActivity$parseAmbaPhotoHtml$1$photoModels$1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
    }

    public final c<l> create(Object obj, c<?> cVar) {
        h.d(cVar, "completion");
        return new HttpSdDetailActivity$parseAmbaPhotoHtml$1$photoModels$1(this.f25149b, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a.a();
        if (this.f25148a == 0) {
            i.a(obj);
            Document document = null;
            ArrayList arrayList = new ArrayList();
            try {
                document = org.jsoup.a.b("http://172.50.10.1/SD/AMBA/" + this.f25149b.f25147c).a(5000).a();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            Elements<Element> e3 = document != null ? document.e("tr") : null;
            if (e3 != null) {
                for (Element element : e3) {
                    String b2 = element.e("a[class=link]").b();
                    h.b(b2, "element.select(\"a[class=link]\").text()");
                    if (f.a((CharSequence) b2, (CharSequence) "JPG", false, 2, (Object) null)) {
                        String b3 = element.e("span").b();
                        h.b(b3, "element.select(\"span\").text()");
                        arrayList.add(new a(false, f.a(b3, " ", "", false, 4, (Object) null), "/tmp/SD0/AMBA/" + this.f25149b.f25147c + element.e("a").a("href"), "0", (String) null, 0, 0, 112, (f) null));
                    }
                }
            }
            return arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
