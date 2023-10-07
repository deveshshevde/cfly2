package kotlinx.coroutines.internal;

import kotlin.coroutines.f;
import kotlin.jvm.internal.Lambda;
import kotlinx.coroutines.bx;
import mm.m;

final class ThreadContextKt$restoreState$1 extends Lambda implements m<ad, f.b, ad> {

    /* renamed from: a  reason: collision with root package name */
    public static final ThreadContextKt$restoreState$1 f30381a = new ThreadContextKt$restoreState$1();

    ThreadContextKt$restoreState$1() {
        super(2);
    }

    public final ad a(ad adVar, f.b bVar) {
        if (bVar instanceof bx) {
            ((bx) bVar).a(adVar.c(), adVar.a());
        }
        return adVar;
    }
}
