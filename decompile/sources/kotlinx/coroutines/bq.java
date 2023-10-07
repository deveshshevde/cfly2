package kotlinx.coroutines;

import kotlin.jvm.internal.h;
import kotlinx.coroutines.internal.j;
import kotlinx.coroutines.internal.k;
import kotlinx.coroutines.internal.l;

public final class bq extends j implements bb {
    public final String a(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("List{");
        sb.append(str);
        sb.append("}[");
        j jVar = this;
        l lVar = (l) jVar.e();
        boolean z2 = true;
        while ((!h.a((Object) lVar, (Object) jVar)) && lVar != null) {
            if (lVar instanceof bl) {
                bl blVar = (bl) lVar;
                if (z2) {
                    z2 = false;
                } else {
                    sb.append(", ");
                }
                sb.append(blVar);
            }
            Object e2 = lVar.e();
            lVar = e2 != null ? k.a(e2) : null;
        }
        sb.append("]");
        String sb2 = sb.toString();
        h.b(sb2, "StringBuilder().apply(builderAction).toString()");
        return sb2;
    }

    public boolean b() {
        return true;
    }

    public String toString() {
        return ag.b() ? a("Active") : super.toString();
    }

    public bq z_() {
        return this;
    }
}
