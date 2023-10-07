package kotlin.text;

import java.util.NoSuchElementException;
import kotlin.jvm.internal.h;
import mr.d;

class r extends q {
    public static final String c(String str, int i2) {
        h.d(str, "$this$takeLast");
        if (i2 >= 0) {
            int length = str.length();
            String substring = str.substring(length - d.d(i2, length));
            h.b(substring, "(this as java.lang.String).substring(startIndex)");
            return substring;
        }
        throw new IllegalArgumentException(("Requested character count " + i2 + " is less than zero.").toString());
    }

    public static final char e(CharSequence charSequence) {
        h.d(charSequence, "$this$first");
        if (!(charSequence.length() == 0)) {
            return charSequence.charAt(0);
        }
        throw new NoSuchElementException("Char sequence is empty.");
    }
}
