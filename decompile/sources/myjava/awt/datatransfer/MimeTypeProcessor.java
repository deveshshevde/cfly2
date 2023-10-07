package myjava.awt.datatransfer;

import java.io.Serializable;
import java.util.Enumeration;
import java.util.Hashtable;

final class MimeTypeProcessor {

    /* renamed from: a  reason: collision with root package name */
    private static MimeTypeProcessor f31297a;

    static final class MimeType implements Serializable, Cloneable {
        private static final long serialVersionUID = -6693571907475992044L;
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public String f31298a;
        /* access modifiers changed from: private */

        /* renamed from: b  reason: collision with root package name */
        public String f31299b;
        /* access modifiers changed from: private */

        /* renamed from: c  reason: collision with root package name */
        public Hashtable<String, String> f31300c;
        /* access modifiers changed from: private */

        /* renamed from: d  reason: collision with root package name */
        public Hashtable<String, Object> f31301d;

        MimeType() {
            this.f31298a = null;
            this.f31299b = null;
            this.f31300c = null;
            this.f31301d = null;
        }

        MimeType(String str, String str2) {
            this.f31298a = str;
            this.f31299b = str2;
            this.f31300c = new Hashtable<>();
            this.f31301d = new Hashtable<>();
        }

        /* access modifiers changed from: package-private */
        public String a() {
            return this.f31298a;
        }

        /* access modifiers changed from: package-private */
        public String a(String str) {
            return this.f31300c.get(str);
        }

        /* access modifiers changed from: package-private */
        public void a(String str, String str2) {
            if (str2 != null) {
                if (str2.charAt(0) == '\"' && str2.charAt(str2.length() - 1) == '\"') {
                    str2 = str2.substring(1, str2.length() - 2);
                }
                if (str2.length() != 0) {
                    this.f31300c.put(str, str2);
                }
            }
        }

        /* access modifiers changed from: package-private */
        public boolean a(MimeType mimeType) {
            if (mimeType == null) {
                return false;
            }
            return c().equals(mimeType.c());
        }

        /* access modifiers changed from: package-private */
        public String b() {
            return this.f31299b;
        }

        /* access modifiers changed from: package-private */
        public String c() {
            return String.valueOf(this.f31298a) + "/" + this.f31299b;
        }

        public Object clone() {
            MimeType mimeType = new MimeType(this.f31298a, this.f31299b);
            mimeType.f31300c = (Hashtable) this.f31300c.clone();
            mimeType.f31301d = (Hashtable) this.f31301d.clone();
            return mimeType;
        }
    }

    private static final class a {

        /* renamed from: a  reason: collision with root package name */
        int f31302a;

        private a() {
            this.f31302a = 0;
        }

        /* synthetic */ a(a aVar) {
            this();
        }
    }

    private MimeTypeProcessor() {
    }

    private static int a(String str, int i2) {
        while (i2 < str.length() && !b(str.charAt(i2))) {
            i2++;
        }
        return i2;
    }

    private static String a(String str, a aVar) {
        StringBuilder sb = new StringBuilder();
        aVar.f31302a++;
        boolean z2 = true;
        do {
            if (str.charAt(aVar.f31302a) != '\"' || !z2) {
                int i2 = aVar.f31302a;
                aVar.f31302a = i2 + 1;
                char charAt = str.charAt(i2);
                if (!z2) {
                    z2 = true;
                } else if (charAt == '\\') {
                    z2 = false;
                }
                if (z2) {
                    sb.append(charAt);
                }
            } else {
                aVar.f31302a++;
                return sb.toString();
            }
        } while (aVar.f31302a != str.length());
        throw new IllegalArgumentException();
    }

    static String a(MimeType mimeType) {
        StringBuilder sb = new StringBuilder();
        sb.append(mimeType.c());
        Enumeration keys = mimeType.f31300c.keys();
        while (keys.hasMoreElements()) {
            String str = (String) keys.nextElement();
            sb.append("; ");
            sb.append(str);
            sb.append("=\"");
            sb.append((String) mimeType.f31300c.get(str));
            sb.append('\"');
        }
        return sb.toString();
    }

    static MimeType a(String str) {
        if (f31297a == null) {
            f31297a = new MimeTypeProcessor();
        }
        MimeType mimeType = new MimeType();
        if (str != null) {
            a aVar = new a((a) null);
            a(str, mimeType, aVar);
            b(str, mimeType, aVar);
        }
        return mimeType;
    }

    private static void a(String str, MimeType mimeType, a aVar) {
        mimeType.f31298a = b(str, aVar).toLowerCase();
        aVar.f31302a = a(str, aVar.f31302a);
        if (aVar.f31302a >= str.length() || str.charAt(aVar.f31302a) != '/') {
            throw new IllegalArgumentException();
        }
        aVar.f31302a++;
        mimeType.f31299b = b(str, aVar).toLowerCase();
    }

    private static boolean a(char c2) {
        return c2 == '(' || c2 == ')' || c2 == '[' || c2 == ']' || c2 == '<' || c2 == '>' || c2 == '@' || c2 == ',' || c2 == ';' || c2 == ':' || c2 == '\\' || c2 == '\"' || c2 == '/' || c2 == '?' || c2 == '=';
    }

    private static String b(String str, a aVar) {
        StringBuilder sb = new StringBuilder();
        aVar.f31302a = a(str, aVar.f31302a);
        if (aVar.f31302a >= str.length() || a(str.charAt(aVar.f31302a))) {
            throw new IllegalArgumentException();
        }
        do {
            int i2 = aVar.f31302a;
            aVar.f31302a = i2 + 1;
            sb.append(str.charAt(i2));
            if (aVar.f31302a >= str.length() || !b(str.charAt(aVar.f31302a)) || a(str.charAt(aVar.f31302a))) {
            }
            int i22 = aVar.f31302a;
            aVar.f31302a = i22 + 1;
            sb.append(str.charAt(i22));
            break;
        } while (a(str.charAt(aVar.f31302a)));
        return sb.toString();
    }

    private static void b(String str, MimeType mimeType, a aVar) {
        mimeType.f31300c = new Hashtable();
        mimeType.f31301d = new Hashtable();
        while (true) {
            aVar.f31302a = a(str, aVar.f31302a);
            if (aVar.f31302a < str.length()) {
                if (str.charAt(aVar.f31302a) == ';') {
                    aVar.f31302a++;
                    c(str, mimeType, aVar);
                } else {
                    throw new IllegalArgumentException();
                }
            } else {
                return;
            }
        }
    }

    private static boolean b(char c2) {
        return c2 >= '!' && c2 <= '~';
    }

    private static void c(String str, MimeType mimeType, a aVar) {
        String lowerCase = b(str, aVar).toLowerCase();
        aVar.f31302a = a(str, aVar.f31302a);
        if (aVar.f31302a >= str.length() || str.charAt(aVar.f31302a) != '=') {
            throw new IllegalArgumentException();
        }
        aVar.f31302a++;
        aVar.f31302a = a(str, aVar.f31302a);
        if (aVar.f31302a < str.length()) {
            mimeType.f31300c.put(lowerCase, str.charAt(aVar.f31302a) == '\"' ? a(str, aVar) : b(str, aVar));
            return;
        }
        throw new IllegalArgumentException();
    }
}
