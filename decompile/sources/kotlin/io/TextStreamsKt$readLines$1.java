package kotlin.io;

import java.util.ArrayList;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import kotlin.l;
import mm.b;

final class TextStreamsKt$readLines$1 extends Lambda implements b<String, l> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ ArrayList f30221a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TextStreamsKt$readLines$1(ArrayList arrayList) {
        super(1);
        this.f30221a = arrayList;
    }

    public final void a(String str) {
        h.d(str, "it");
        this.f30221a.add(str);
    }

    public /* synthetic */ Object invoke(Object obj) {
        a((String) obj);
        return l.f30254a;
    }
}
