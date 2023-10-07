package ls;

import androidx.lifecycle.s;
import java.io.File;
import kotlin.jvm.internal.h;

public class b extends a {

    /* renamed from: a  reason: collision with root package name */
    public static final a f30993a = new a((f) null);

    /* renamed from: d  reason: collision with root package name */
    private static final String f30994d = b.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public static final s<String> f30995e = new s<>();

    /* renamed from: c  reason: collision with root package name */
    private File f30996c;

    public static final class a {
        private a() {
        }

        public /* synthetic */ a(f fVar) {
            this();
        }

        public final s<String> a() {
            return b.f30995e;
        }
    }

    public final File a() {
        return this.f30996c;
    }

    public final String b() {
        String absolutePath = this.f30996c.getAbsolutePath();
        h.b(absolutePath, "file.absolutePath");
        return absolutePath;
    }
}
