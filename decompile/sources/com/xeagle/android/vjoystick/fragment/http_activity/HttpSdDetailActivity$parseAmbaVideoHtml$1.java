package com.xeagle.android.vjoystick.fragment.http_activity;

import java.util.ArrayList;
import java.util.Iterator;
import kotlin.coroutines.c;
import kotlin.coroutines.intrinsics.a;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.coroutines.jvm.internal.d;
import kotlin.i;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.h;
import kotlin.l;
import kotlin.text.f;
import kotlinx.coroutines.af;
import kotlinx.coroutines.ap;
import kotlinx.coroutines.e;
import mm.m;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

@d(b = "HttpSdDetailActivity.kt", c = {1814}, d = "invokeSuspend", e = "com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity$parseAmbaVideoHtml$1")
final class HttpSdDetailActivity$parseAmbaVideoHtml$1 extends SuspendLambda implements m<af, c<? super l>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f25156a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ HttpSdDetailActivity f25157b;

    /* renamed from: c  reason: collision with root package name */
    final /* synthetic */ String f25158c;

    @d(b = "HttpSdDetailActivity.kt", c = {1847}, d = "invokeSuspend", e = "com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity$parseAmbaVideoHtml$1$1")
    /* renamed from: com.xeagle.android.vjoystick.fragment.http_activity.HttpSdDetailActivity$parseAmbaVideoHtml$1$1  reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements m<af, c<? super l>, Object> {

        /* renamed from: a  reason: collision with root package name */
        int f25159a;

        /* renamed from: b  reason: collision with root package name */
        final /* synthetic */ HttpSdDetailActivity$parseAmbaVideoHtml$1 f25160b;

        {
            this.f25160b = r1;
        }

        public final Object a(Object obj, Object obj2) {
            return ((AnonymousClass1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
        }

        public final c<l> create(Object obj, c<?> cVar) {
            h.d(cVar, "completion");
            return new AnonymousClass1(this.f25160b, cVar);
        }

        public final Object invokeSuspend(Object obj) {
            Iterator it2;
            String str = "a[class=link]";
            Object a2 = a.a();
            int i2 = this.f25159a;
            if (i2 == 0) {
                i.a(obj);
                Object obj2 = null;
                Document document = null;
                final Ref.ObjectRef objectRef = new Ref.ObjectRef();
                objectRef.f30237a = new ArrayList();
                ArrayList arrayList = new ArrayList();
                try {
                    Iterator it3 = org.jsoup.a.b("http://172.50.10.1/SD/AMBA/" + this.f25160b.f25158c).a(5000).a().e("tr").iterator();
                    while (it3.hasNext()) {
                        Element element = (Element) it3.next();
                        String b2 = element.e(str).b();
                        h.b(b2, "element.select(\"a[class=link]\").text()");
                        if (f.a((CharSequence) b2, (CharSequence) "AA", false, 2, obj2)) {
                            String b3 = element.e("span").b();
                            h.b(b3, "element.select(\"span\").text()");
                            String a3 = f.a(b3, " ", "", false, 4, (Object) null);
                            StringBuilder sb = new StringBuilder();
                            sb.append("/tmp/SD0/AMBA/");
                            it2 = it3;
                            sb.append(this.f25160b.f25158c);
                            sb.append(element.e("a").a("href"));
                            ((ArrayList) objectRef.f30237a).add(new lc.a(false, a3, sb.toString(), "0", (String) null, 0, 0, 112, (f) null));
                        } else {
                            it2 = it3;
                        }
                        String b4 = element.e(str).b();
                        h.b(b4, "element.select(\"a[class=link]\").text()");
                        String str2 = str;
                        if (f.a((CharSequence) b4, (CharSequence) "AB", false, 2, (Object) null)) {
                            String b5 = element.e("span").b();
                            h.b(b5, "element.select(\"span\").text()");
                            arrayList.add(new lc.a(false, f.a(b5, " ", "", false, 4, (Object) null), "/tmp/SD0/AMBA/" + this.f25160b.f25158c + element.e("a").a("href"), "0", (String) null, 0, 0, 112, (f) null));
                        }
                        str = str2;
                        it3 = it2;
                        obj2 = null;
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                }
                this.f25159a = 1;
                if (e.a(ap.b(), new m<af, c<? super l>, Object>(this, (c) null) {

                    /* renamed from: a  reason: collision with root package name */
                    int f25161a;

                    /* renamed from: b  reason: collision with root package name */
                    final /* synthetic */ AnonymousClass1 f25162b;

                    {
                        this.f25162b = r1;
                    }

                    public final Object a(Object obj, Object obj2) {
                        return ((AnonymousClass1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
                    }

                    public final c<l> create(Object obj, c<?> cVar) {
                        h.d(cVar, "completion");
                        return 

                        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
                        HttpSdDetailActivity$parseAmbaVideoHtml$1(HttpSdDetailActivity httpSdDetailActivity, String str, c cVar) {
                            super(2, cVar);
                            this.f25157b = httpSdDetailActivity;
                            this.f25158c = str;
                        }

                        public final Object a(Object obj, Object obj2) {
                            return ((HttpSdDetailActivity$parseAmbaVideoHtml$1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
                        }

                        public final c<l> create(Object obj, c<?> cVar) {
                            h.d(cVar, "completion");
                            return new HttpSdDetailActivity$parseAmbaVideoHtml$1(this.f25157b, this.f25158c, cVar);
                        }

                        public final Object invokeSuspend(Object obj) {
                            Object a2 = a.a();
                            int i2 = this.f25156a;
                            if (i2 == 0) {
                                i.a(obj);
                                this.f25156a = 1;
                                if (e.a(ap.c(), new AnonymousClass1(this, (c) null), this) == a2) {
                                    return a2;
                                }
                            } else if (i2 == 1) {
                                i.a(obj);
                            } else {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            return l.f30254a;
                        }
                    }
