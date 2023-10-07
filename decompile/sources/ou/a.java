package ou;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;

public final class a {

    /* renamed from: a  reason: collision with root package name */
    static volatile b[] f34106a;

    /* renamed from: b  reason: collision with root package name */
    private static final b[] f34107b;

    /* renamed from: c  reason: collision with root package name */
    private static final List<b> f34108c = new ArrayList();

    /* renamed from: d  reason: collision with root package name */
    private static final b f34109d = new b() {
    };

    /* renamed from: ou.a$a  reason: collision with other inner class name */
    public static class C0249a extends b {

        /* renamed from: a  reason: collision with root package name */
        private static final Pattern f34110a = Pattern.compile("(\\$\\d+)+$");
    }

    public static abstract class b {

        /* renamed from: b  reason: collision with root package name */
        final ThreadLocal<String> f34111b = new ThreadLocal<>();
    }

    static {
        b[] bVarArr = new b[0];
        f34107b = bVarArr;
        f34106a = bVarArr;
    }

    public static List<b> a() {
        List<b> unmodifiableList;
        List<b> list = f34108c;
        synchronized (list) {
            unmodifiableList = Collections.unmodifiableList(new ArrayList(list));
        }
        return unmodifiableList;
    }
}
