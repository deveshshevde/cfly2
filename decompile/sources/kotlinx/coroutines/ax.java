package kotlinx.coroutines;

import kotlinx.coroutines.internal.w;

public final class ax {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final w f30332a = new w("REMOVED_TASK");
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public static final w f30333b = new w("CLOSED_EMPTY");

    public static final long a(long j2) {
        if (j2 <= 0) {
            return 0;
        }
        if (j2 >= 9223372036854L) {
            return Long.MAX_VALUE;
        }
        return 1000000 * j2;
    }
}
