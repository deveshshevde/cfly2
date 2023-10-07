package androidx.work;

import java.util.List;

public abstract class h {

    /* renamed from: a  reason: collision with root package name */
    private static final String f5153a = j.a("InputMerger");

    public static h a(String str) {
        try {
            return (h) Class.forName(str).newInstance();
        } catch (Exception e2) {
            j a2 = j.a();
            String str2 = f5153a;
            a2.e(str2, "Trouble instantiating + " + str, e2);
            return null;
        }
    }

    public abstract d a(List<d> list);
}
