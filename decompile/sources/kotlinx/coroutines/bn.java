package kotlinx.coroutines;

import kotlinx.coroutines.internal.w;

public final class bn {

    /* renamed from: a  reason: collision with root package name */
    public static final w f30356a = new w("COMPLETING_WAITING_CHILDREN");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final w f30357b = new w("COMPLETING_ALREADY");
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public static final w f30358c = new w("COMPLETING_RETRY");
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public static final w f30359d = new w("TOO_LATE_TO_CANCEL");
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final w f30360e = new w("SEALED");
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public static final as f30361f = new as(false);
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public static final as f30362g = new as(true);

    public static final Object a(Object obj) {
        return obj instanceof bb ? new bc((bb) obj) : obj;
    }

    public static final Object b(Object obj) {
        bb bbVar;
        bc bcVar = (bc) (!(obj instanceof bc) ? null : obj);
        return (bcVar == null || (bbVar = bcVar.f30338a) == null) ? obj : bbVar;
    }
}
