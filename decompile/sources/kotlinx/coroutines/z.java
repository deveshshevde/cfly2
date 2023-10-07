package kotlinx.coroutines;

import kotlin.coroutines.d;
import kotlin.coroutines.f;
import kotlinx.coroutines.scheduling.b;

public final class z {

    /* renamed from: a  reason: collision with root package name */
    private static final boolean f30516a;

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0028, code lost:
        if (r0.equals("on") != false) goto L_0x0033;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0031, code lost:
        if (r0.equals("") != false) goto L_0x0033;
     */
    static {
        /*
            java.lang.String r0 = "kotlinx.coroutines.scheduler"
            java.lang.String r0 = kotlinx.coroutines.internal.x.a(r0)
            if (r0 != 0) goto L_0x0009
            goto L_0x0033
        L_0x0009:
            int r1 = r0.hashCode()
            if (r1 == 0) goto L_0x002b
            r2 = 3551(0xddf, float:4.976E-42)
            if (r1 == r2) goto L_0x0022
            r2 = 109935(0x1ad6f, float:1.54052E-40)
            if (r1 != r2) goto L_0x0037
            java.lang.String r1 = "off"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0037
            r0 = 0
            goto L_0x0034
        L_0x0022:
            java.lang.String r1 = "on"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0037
            goto L_0x0033
        L_0x002b:
            java.lang.String r1 = ""
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L_0x0037
        L_0x0033:
            r0 = 1
        L_0x0034:
            f30516a = r0
            return
        L_0x0037:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "System property 'kotlinx.coroutines.scheduler' has unrecognized value '"
            r1.append(r2)
            r1.append(r0)
            r0 = 39
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException
            java.lang.String r0 = r0.toString()
            r1.<init>(r0)
            java.lang.Throwable r1 = (java.lang.Throwable) r1
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.z.<clinit>():void");
    }

    public static final String a(f fVar) {
        ad adVar;
        String str;
        if (!ag.b() || (adVar = (ad) fVar.get(ad.f30293a)) == null) {
            return null;
        }
        ae aeVar = (ae) fVar.get(ae.f30295a);
        if (aeVar == null || (str = aeVar.a()) == null) {
            str = "coroutine";
        }
        return str + '#' + adVar.a();
    }

    public static final f a(af afVar, f fVar) {
        f plus = afVar.c().plus(fVar);
        f plus2 = ag.b() ? plus.plus(new ad(ag.d().incrementAndGet())) : plus;
        return (plus == ap.a() || plus.get(d.f30197a) != null) ? plus2 : plus2.plus(ap.a());
    }

    public static final aa a() {
        return f30516a ? b.f30479b : r.f30447b;
    }
}
