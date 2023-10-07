package il;

import java.util.ArrayList;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    public static final List<String> f13592a;

    static {
        ArrayList arrayList = new ArrayList();
        f13592a = arrayList;
        arrayList.add("ISO-8859-1");
        arrayList.add("GB2312");
        arrayList.add("GBK");
        arrayList.add("GB18030");
        arrayList.add("US-ASCII");
        arrayList.add("ASCII");
        arrayList.add("ISO-2022-KR");
        arrayList.add("ISO-8859-2");
        arrayList.add("ISO-2022-JP");
        arrayList.add("ISO-2022-JP-2");
        arrayList.add("UTF-8");
    }

    public static String a(String str, int i2) {
        for (String next : f13592a) {
            if (b(str, next, i2)) {
                return next;
            }
        }
        return "ISO-8859-1";
    }

    public static String a(String str, String str2, int i2) {
        try {
            return new String(str.getBytes(a(str, i2)), str2);
        } catch (Throwable th) {
            c.a(th);
            return str;
        }
    }

    public static boolean b(String str, String str2, int i2) {
        try {
            if (str.length() > i2) {
                str = str.substring(0, i2);
            }
            return str.equals(new String(str.getBytes(str2), str2));
        } catch (Throwable unused) {
            return false;
        }
    }
}
