package np;

import java.security.AccessController;
import java.security.PrivilegedAction;
import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static ResourceBundle f31606a;

    static {
        try {
            f31606a = a(Locale.getDefault(), "org.apache.harmony.awt.internal.nls.messages");
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }

    public static String a(String str) {
        ResourceBundle resourceBundle = f31606a;
        if (resourceBundle == null) {
            return str;
        }
        try {
            return resourceBundle.getString(str);
        } catch (MissingResourceException unused) {
            return "Missing message: " + str;
        }
    }

    public static String a(String str, Object obj) {
        return a(str, new Object[]{obj});
    }

    public static String a(String str, Object[] objArr) {
        ResourceBundle resourceBundle = f31606a;
        if (resourceBundle != null) {
            try {
                str = resourceBundle.getString(str);
            } catch (MissingResourceException unused) {
            }
        }
        return b(str, objArr);
    }

    public static ResourceBundle a(final Locale locale, final String str) {
        try {
            return (ResourceBundle) AccessController.doPrivileged(new PrivilegedAction<Object>((ClassLoader) null) {
                public Object run() {
                    String str = str;
                    Locale locale = locale;
                    ClassLoader classLoader = null;
                    if (classLoader == null) {
                        classLoader = ClassLoader.getSystemClassLoader();
                    }
                    return ResourceBundle.getBundle(str, locale, classLoader);
                }
            });
        } catch (MissingResourceException unused) {
            return null;
        }
    }

    public static String b(String str, Object[] objArr) {
        int i2;
        StringBuilder sb = new StringBuilder(str.length() + (objArr.length * 20));
        int length = objArr.length;
        String[] strArr = new String[length];
        int i3 = 0;
        for (int i4 = 0; i4 < objArr.length; i4++) {
            if (objArr[i4] == null) {
                strArr[i4] = "<null>";
            } else {
                strArr[i4] = objArr[i4].toString();
            }
        }
        while (true) {
            int indexOf = str.indexOf(123, i3);
            if (indexOf < 0) {
                break;
            }
            if (indexOf != 0) {
                int i5 = indexOf - 1;
                if (str.charAt(i5) == '\\') {
                    if (indexOf != 1) {
                        sb.append(str.substring(i3, i5));
                    }
                    sb.append('{');
                    i2 = indexOf + 1;
                    i3 = i2;
                }
            }
            if (indexOf > str.length() - 3) {
                sb.append(str.substring(i3, str.length()));
                i2 = str.length();
            } else {
                int i6 = indexOf + 1;
                byte digit = (byte) Character.digit(str.charAt(i6), 10);
                if (digit < 0 || str.charAt(indexOf + 2) != '}') {
                    sb.append(str.substring(i3, i6));
                    i3 = i6;
                } else {
                    sb.append(str.substring(i3, indexOf));
                    sb.append(digit >= length ? "<missing argument>" : strArr[digit]);
                    i2 = indexOf + 3;
                }
            }
            i3 = i2;
        }
        if (i3 < str.length()) {
            sb.append(str.substring(i3, str.length()));
        }
        return sb.toString();
    }
}
