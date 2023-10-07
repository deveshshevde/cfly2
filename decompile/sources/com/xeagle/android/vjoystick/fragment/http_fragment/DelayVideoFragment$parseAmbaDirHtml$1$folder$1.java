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

@d(b = "DelayVideoFragment.kt", c = {}, d = "invokeSuspend", e = "com.xeagle.android.vjoystick.fragment.http_fragment.DelayVideoFragment$parseAmbaDirHtml$1$folder$1")
final class DelayVideoFragment$parseAmbaDirHtml$1$folder$1 extends SuspendLambda implements m<af, c<? super ArrayList<a>>, Object> {

    /* renamed from: a  reason: collision with root package name */
    int f25187a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ DelayVideoFragment$parseAmbaDirHtml$1 f25188b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    DelayVideoFragment$parseAmbaDirHtml$1$folder$1(DelayVideoFragment$parseAmbaDirHtml$1 delayVideoFragment$parseAmbaDirHtml$1, c cVar) {
        super(2, cVar);
        this.f25188b = delayVideoFragment$parseAmbaDirHtml$1;
    }

    public final Object a(Object obj, Object obj2) {
        return ((DelayVideoFragment$parseAmbaDirHtml$1$folder$1) create(obj, (c) obj2)).invokeSuspend(l.f30254a);
    }

    public final c<l> create(Object obj, c<?> cVar) {
        h.d(cVar, "completion");
        return new DelayVideoFragment$parseAmbaDirHtml$1$folder$1(this.f25188b, cVar);
    }

    public final Object invokeSuspend(Object obj) {
        kotlin.coroutines.intrinsics.a.a();
        if (this.f25187a == 0) {
            i.a(obj);
            ArrayList arrayList = new ArrayList();
            try {
                Iterator it2 = org.jsoup.a.b(this.f25188b.f25186c).a(5000).a().e("a[class=link]").iterator();
                while (it2.hasNext()) {
                    String a2 = ((Element) it2.next()).e("a").a("href");
                    Log.i("UsbDataProxy", "parseAmbaDirHtml:---href--" + a2);
                    h.b(a2, "elementName");
                    if (f.c(a2, "/", false, 2, (Object) null)) {
                        arrayList.add(new a(true, "0M", a2, "-", (String) null, 0, 0, 112, (f) null));
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
