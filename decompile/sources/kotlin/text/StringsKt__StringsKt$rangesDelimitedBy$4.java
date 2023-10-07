package kotlin.text;

import java.util.Collection;
import java.util.List;
import kotlin.Pair;
import kotlin.j;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.h;
import mm.m;

final class StringsKt__StringsKt$rangesDelimitedBy$4 extends Lambda implements m<CharSequence, Integer, Pair<? extends Integer, ? extends Integer>> {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f30259a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ boolean f30260b;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    StringsKt__StringsKt$rangesDelimitedBy$4(List list, boolean z2) {
        super(2);
        this.f30259a = list;
        this.f30260b = z2;
    }

    public /* synthetic */ Object a(Object obj, Object obj2) {
        return a((CharSequence) obj, ((Number) obj2).intValue());
    }

    public final Pair<Integer, Integer> a(CharSequence charSequence, int i2) {
        h.d(charSequence, "$receiver");
        Pair a2 = p.b(charSequence, (Collection<String>) this.f30259a, i2, this.f30260b, false);
        if (a2 != null) {
            return j.a(a2.a(), Integer.valueOf(((String) a2.b()).length()));
        }
        return null;
    }
}
