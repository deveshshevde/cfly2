package oh;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;

public final class c {

    /* renamed from: a  reason: collision with root package name */
    static final String[] f31765a = {"", " ", "  ", "   ", "    ", "     ", "      ", "       ", "        ", "         ", "          ", "           ", "            ", "             ", "              ", "               ", "                ", "                 ", "                  ", "                   ", "                    "};

    /* renamed from: b  reason: collision with root package name */
    private static final Stack<StringBuilder> f31766b = new Stack<>();

    public static String a(int i2) {
        if (i2 >= 0) {
            String[] strArr = f31765a;
            if (i2 < strArr.length) {
                return strArr[i2];
            }
            char[] cArr = new char[i2];
            for (int i3 = 0; i3 < i2; i3++) {
                cArr[i3] = ' ';
            }
            return String.valueOf(cArr);
        }
        throw new IllegalArgumentException("width must be > 0");
    }

    public static String a(String str, String str2) {
        try {
            try {
                return a(new URL(str), str2).toExternalForm();
            } catch (MalformedURLException unused) {
                return "";
            }
        } catch (MalformedURLException unused2) {
            return new URL(str2).toExternalForm();
        }
    }

    public static String a(StringBuilder sb) {
        org.jsoup.helper.c.a((Object) sb);
        String sb2 = sb.toString();
        if (sb.length() > 8192) {
            sb = new StringBuilder(8192);
        } else {
            sb.delete(0, sb.length());
        }
        Stack<StringBuilder> stack = f31766b;
        synchronized (stack) {
            stack.push(sb);
            while (true) {
                Stack<StringBuilder> stack2 = f31766b;
                if (stack2.size() > 8) {
                    stack2.pop();
                }
            }
        }
        return sb2;
    }

    public static String a(Collection collection, String str) {
        return a(collection.iterator(), str);
    }

    public static String a(Iterator it2, String str) {
        if (!it2.hasNext()) {
            return "";
        }
        String obj = it2.next().toString();
        if (!it2.hasNext()) {
            return obj;
        }
        StringBuilder a2 = a();
        a2.append(obj);
        while (it2.hasNext()) {
            a2.append(str);
            a2.append(it2.next());
        }
        return a(a2);
    }

    public static StringBuilder a() {
        StringBuilder sb;
        Stack<StringBuilder> stack = f31766b;
        synchronized (stack) {
            sb = stack.empty() ? new StringBuilder(8192) : stack.pop();
        }
        return sb;
    }

    public static URL a(URL url, String str) throws MalformedURLException {
        if (str.startsWith("?")) {
            str = url.getPath() + str;
        }
        if (str.indexOf(46) == 0 && url.getFile().indexOf(47) != 0) {
            url = new URL(url.getProtocol(), url.getHost(), url.getPort(), "/" + url.getFile());
        }
        return new URL(url, str);
    }

    public static void a(StringBuilder sb, String str, boolean z2) {
        int length = str.length();
        int i2 = 0;
        boolean z3 = false;
        boolean z4 = false;
        while (i2 < length) {
            int codePointAt = str.codePointAt(i2);
            if (c(codePointAt)) {
                if ((!z2 || z3) && !z4) {
                    sb.append(' ');
                    z4 = true;
                }
            } else if (!d(codePointAt)) {
                sb.appendCodePoint(codePointAt);
                z3 = true;
                z4 = false;
            }
            i2 += Character.charCount(codePointAt);
        }
    }

    public static boolean a(String str) {
        if (!(str == null || str.length() == 0)) {
            int length = str.length();
            for (int i2 = 0; i2 < length; i2++) {
                if (!b(str.codePointAt(i2))) {
                    return false;
                }
            }
        }
        return true;
    }

    public static boolean a(String str, String... strArr) {
        for (String equals : strArr) {
            if (equals.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public static boolean b(int i2) {
        return i2 == 32 || i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13;
    }

    public static boolean b(String str) {
        if (str == null || str.length() == 0) {
            return false;
        }
        int length = str.length();
        for (int i2 = 0; i2 < length; i2++) {
            if (!Character.isDigit(str.codePointAt(i2))) {
                return false;
            }
        }
        return true;
    }

    public static boolean b(String str, String[] strArr) {
        return Arrays.binarySearch(strArr, str) >= 0;
    }

    public static boolean c(int i2) {
        return i2 == 32 || i2 == 9 || i2 == 10 || i2 == 12 || i2 == 13 || i2 == 160;
    }

    public static boolean d(int i2) {
        return i2 == 8203 || i2 == 173;
    }
}
