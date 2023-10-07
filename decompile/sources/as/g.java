package as;

import android.graphics.Typeface;
import java.util.HashMap;
import kotlin.jvm.internal.h;
import kotlin.text.f;

public final class g {

    /* renamed from: a  reason: collision with root package name */
    public static final g f5570a = new g();

    /* renamed from: b  reason: collision with root package name */
    private static final HashMap<String, Typeface> f5571b = new HashMap<>();

    private g() {
    }

    private final Typeface b(String str) {
        Typeface typeface;
        String str2;
        try {
            Typeface create = Typeface.create(str, 0);
            h.a((Object) create, "it");
            f5571b.put(str, create);
            h.a((Object) create, "Typeface.create(familyNa… cache[familyName] = it }");
            return create;
        } catch (Exception unused) {
            CharSequence charSequence = str;
            if (f.a(charSequence, (CharSequence) "medium", false, 2, (Object) null) || f.a(charSequence, (CharSequence) "bold", false, 2, (Object) null)) {
                typeface = Typeface.DEFAULT_BOLD;
                str2 = "Typeface.DEFAULT_BOLD";
            } else {
                typeface = Typeface.DEFAULT;
                str2 = "Typeface.DEFAULT";
            }
            h.a((Object) typeface, str2);
            return typeface;
        }
    }

    public final Typeface a(String str) {
        h.c(str, "familyName");
        Typeface typeface = f5571b.get(str);
        return typeface != null ? typeface : b(str);
    }
}
