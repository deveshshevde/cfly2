package kotlin.text;

import java.io.Serializable;
import java.util.regex.Pattern;
import kotlin.jvm.internal.h;

public final class Regex implements Serializable {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30257a = new a((f) null);

    /* renamed from: b  reason: collision with root package name */
    private final Pattern f30258b;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public Regex(java.lang.String r2) {
        /*
            r1 = this;
            java.lang.String r0 = "pattern"
            kotlin.jvm.internal.h.d(r2, r0)
            java.util.regex.Pattern r2 = java.util.regex.Pattern.compile(r2)
            java.lang.String r0 = "Pattern.compile(pattern)"
            kotlin.jvm.internal.h.b(r2, r0)
            r1.<init>((java.util.regex.Pattern) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlin.text.Regex.<init>(java.lang.String):void");
    }

    public Regex(Pattern pattern) {
        h.d(pattern, "nativePattern");
        this.f30258b = pattern;
    }

    public final String a(CharSequence charSequence, String str) {
        h.d(charSequence, "input");
        h.d(str, "replacement");
        String replaceAll = this.f30258b.matcher(charSequence).replaceAll(str);
        h.b(replaceAll, "nativePattern.matcher(in…).replaceAll(replacement)");
        return replaceAll;
    }

    public String toString() {
        String pattern = this.f30258b.toString();
        h.b(pattern, "nativePattern.toString()");
        return pattern;
    }
}
