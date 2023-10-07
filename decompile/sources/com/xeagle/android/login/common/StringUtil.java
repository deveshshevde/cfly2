package com.xeagle.android.login.common;

import android.text.TextUtils;
import com.xeagle.android.utils.p;
import java.util.Locale;
import java.util.UUID;

public class StringUtil {
    public static int counterChars(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            char charAt = str.charAt(i3);
            i2 = (charAt <= 0 || charAt >= 127) ? i2 + 2 : i2 + 1;
        }
        return i2;
    }

    public static final String filterUCS4(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        int i2 = 0;
        if (str.codePointCount(0, str.length()) == str.length()) {
            return str;
        }
        StringBuilder sb = new StringBuilder();
        while (i2 < str.length()) {
            int codePointAt = str.codePointAt(i2);
            i2 += Character.charCount(codePointAt);
            if (!Character.isSupplementaryCodePoint(codePointAt)) {
                sb.appendCodePoint(codePointAt);
            }
        }
        return sb.toString();
    }

    public static String get32UUID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

    public static String get36UUID() {
        return UUID.randomUUID().toString();
    }

    public static String getPercentString(float f2) {
        return String.format(Locale.US, "%d%%", new Object[]{Integer.valueOf((int) (f2 * 100.0f))});
    }

    public static boolean isEmpty(String str) {
        return TextUtils.isEmpty(str);
    }

    public static String makeMd5(String str) {
        return p.a(str);
    }

    public static String removeBlanks(String str) {
        if (str == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        for (int length = sb.length() - 1; length >= 0; length--) {
            if (' ' == sb.charAt(length) || 10 == sb.charAt(length) || 9 == sb.charAt(length) || 13 == sb.charAt(length)) {
                sb.deleteCharAt(length);
            }
        }
        return sb.toString();
    }
}
