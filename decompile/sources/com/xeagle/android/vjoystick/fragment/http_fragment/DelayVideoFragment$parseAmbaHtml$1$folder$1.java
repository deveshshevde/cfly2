package com.xeagle.android.vjoystick.fragment.http_fragment;

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
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

@d(b = "DelayVideoFragment.kt", c = {}, d = "invokeSuspend", e = "com.xeagle.android.vjoystick.fragment.http_fragment.DelayVideoFragment$parseAmbaHtml$1$folder$1")
final class DelayVideoFragment$parseAmbaHtml$1$folder$1 extends SuspendLambda implements m<af, c<? super ArrayList<a>>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f25192a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ DelayVideoFragment$parseAmbaHtml$1 f25193b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DelayVideoFragment$parseAmbaHtml$1$folder$1(DelayVideoFragment$parseAmbaHtml$1 delayVideoFragment$parseAmbaHtml$1, c cVar) {
        super(2, cVar);
        this.f25193b = delayVideoFragment$parseAmbaHtml$1;
    }

    public final Object a(Object obj, Object obj2) {
        return ((DelayVideoFragment$parseAmbaHtml$1$folder$1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
    }

    public final c<l> create(Object obj, c<?> cVar) {
        h.d(cVar, "completion");
        return new DelayVideoFragment$parseAmbaHtml$1$folder$1(this.f25193b, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a.a();
        if (this.f25192a == 0) {
            i.a(obj);
            ArrayList arrayList = new ArrayList();
            Elements e2 = org.jsoup.a.a(this.f25193b.f25191c).e("a[class=link]");
            Log.i("UsbDataProxy", "run:---elements size--- " + e2.size());
            Iterator it2 = e2.iterator();
            while (it2.hasNext()) {
                String a2 = ((Element) it2.next()).e("a").a("href");
                Log.i("UsbDataProxy", "parseAmbaHtml:-elements--href--" + a2);
                h.b(a2, "elementName");
                if (f.b(a2, "TIME", false, 2, (Object) null) && f.c(a2, "/", false, 2, (Object) null)) {
                    a aVar = new a(true, "0M", a2, "-", (String) null, 0, 0, 112, (f) null);
                    if (!arrayList.contains(aVar)) {
                        arrayList.add(aVar);
                    }
                }
            }
            return arrayList;
        }
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    }
}
