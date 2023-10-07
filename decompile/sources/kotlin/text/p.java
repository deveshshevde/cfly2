package kotlin.text;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Pair;
import kotlin.collections.b;
import kotlin.j;
import kotlin.jvm.internal.h;
import mr.a;
import mr.c;
import mr.d;

class p extends o {
    public static final int a(CharSequence charSequence, char c2, int i2, boolean z2) {
        h.d(charSequence, "$this$indexOf");
        if (!z2 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(c2, i2);
        }
        return f.a(charSequence, new char[]{c2}, i2, z2);
    }

    public static /* synthetic */ int a(CharSequence charSequence, char c2, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return f.a(charSequence, c2, i2, z2);
    }

    private static final int a(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z2, boolean z3) {
        a cVar = !z3 ? new c(d.c(i2, 0), d.d(i3, charSequence.length())) : d.a(d.d(i2, f.d(charSequence)), d.c(i3, 0));
        if (!(charSequence instanceof String) || !(charSequence2 instanceof String)) {
            int a2 = cVar.a();
            int b2 = cVar.b();
            int c2 = cVar.c();
            if (c2 >= 0) {
                if (a2 > b2) {
                    return -1;
                }
            } else if (a2 < b2) {
                return -1;
            }
            while (true) {
                if (f.a(charSequence2, 0, charSequence, a2, charSequence2.length(), z2)) {
                    return a2;
                }
                if (a2 == b2) {
                    return -1;
                }
                a2 += c2;
            }
        } else {
            int a3 = cVar.a();
            int b3 = cVar.b();
            int c3 = cVar.c();
            if (c3 >= 0) {
                if (a3 > b3) {
                    return -1;
                }
            } else if (a3 < b3) {
                return -1;
            }
            while (true) {
                if (f.a((String) charSequence2, 0, (String) charSequence, a3, charSequence2.length(), z2)) {
                    return a3;
                }
                if (a3 == b3) {
                    return -1;
                }
                a3 += c3;
            }
        }
    }

    static /* synthetic */ int a(CharSequence charSequence, CharSequence charSequence2, int i2, int i3, boolean z2, boolean z3, int i4, Object obj) {
        return a(charSequence, charSequence2, i2, i3, z2, (i4 & 16) != 0 ? false : z3);
    }

    public static final int a(CharSequence charSequence, String str, int i2, boolean z2) {
        h.d(charSequence, "$this$indexOf");
        h.d(str, "string");
        if (!z2 && (charSequence instanceof String)) {
            return ((String) charSequence).indexOf(str, i2);
        }
        return a(charSequence, str, i2, charSequence.length(), z2, false, 16, (Object) null);
    }

    public static /* synthetic */ int a(CharSequence charSequence, String str, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = 0;
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return f.a(charSequence, str, i2, z2);
    }

    public static final int a(CharSequence charSequence, char[] cArr, int i2, boolean z2) {
        boolean z3;
        h.d(charSequence, "$this$indexOfAny");
        h.d(cArr, "chars");
        if (z2 || cArr.length != 1 || !(charSequence instanceof String)) {
            int c2 = d.c(i2, 0);
            int d2 = f.d(charSequence);
            if (c2 > d2) {
                return -1;
            }
            while (true) {
                char charAt = charSequence.charAt(c2);
                int length = cArr.length;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        z3 = false;
                        break;
                    } else if (a.a(cArr[i3], charAt, z2)) {
                        z3 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z3) {
                    return c2;
                }
                if (c2 == d2) {
                    return -1;
                }
                c2++;
            }
        } else {
            return ((String) charSequence).indexOf(b.a(cArr), i2);
        }
    }

    public static final String a(CharSequence charSequence, c cVar) {
        h.d(charSequence, "$this$substring");
        h.d(cVar, "range");
        return charSequence.subSequence(cVar.f().intValue(), cVar.g().intValue() + 1).toString();
    }

    public static final String a(String str, char c2, String str2) {
        h.d(str, "$this$substringBefore");
        h.d(str2, "missingDelimiterValue");
        int a2 = f.a((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (a2 == -1) {
            return str2;
        }
        String substring = str.substring(0, a2);
        h.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String a(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return f.a(str, c2, str2);
    }

    public static final String a(String str, String str2, String str3) {
        h.d(str, "$this$substringBefore");
        h.d(str2, "delimiter");
        h.d(str3, "missingDelimiterValue");
        int a2 = f.a((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (a2 == -1) {
            return str3;
        }
        String substring = str.substring(0, a2);
        h.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String a(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return f.a(str, str2, str3);
    }

    private static final List<String> a(CharSequence charSequence, String str, boolean z2, int i2) {
        int i3 = 0;
        if (i2 >= 0) {
            int a2 = f.a(charSequence, str, 0, z2);
            if (a2 == -1 || i2 == 1) {
                return kotlin.collections.h.a(charSequence.toString());
            }
            boolean z3 = i2 > 0;
            int i4 = 10;
            if (z3) {
                i4 = d.d(i2, 10);
            }
            ArrayList arrayList = new ArrayList(i4);
            do {
                arrayList.add(charSequence.subSequence(i3, a2).toString());
                i3 = str.length() + a2;
                if ((z3 && arrayList.size() == i2 - 1) || (a2 = f.a(charSequence, str, i3, z2)) == -1) {
                    arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
                }
                arrayList.add(charSequence.subSequence(i3, a2).toString());
                i3 = str.length() + a2;
                break;
            } while ((a2 = f.a(charSequence, str, i3, z2)) == -1);
            arrayList.add(charSequence.subSequence(i3, charSequence.length()).toString());
            return arrayList;
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i2 + '.').toString());
    }

    public static final List<String> a(CharSequence charSequence, String[] strArr, boolean z2, int i2) {
        h.d(charSequence, "$this$split");
        h.d(strArr, "delimiters");
        boolean z3 = true;
        if (strArr.length == 1) {
            String str = strArr[0];
            if (str.length() != 0) {
                z3 = false;
            }
            if (!z3) {
                return a(charSequence, str, z2, i2);
            }
        }
        Iterable<c> d2 = mt.c.d(a(charSequence, strArr, 0, z2, i2, 2, (Object) null));
        Collection arrayList = new ArrayList(kotlin.collections.h.a(d2, 10));
        for (c a2 : d2) {
            arrayList.add(f.a(charSequence, a2));
        }
        return (List) arrayList;
    }

    public static /* synthetic */ List a(CharSequence charSequence, String[] strArr, boolean z2, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            z2 = false;
        }
        if ((i3 & 4) != 0) {
            i2 = 0;
        }
        return f.a(charSequence, strArr, z2, i2);
    }

    private static final mt.b<c> a(CharSequence charSequence, String[] strArr, int i2, boolean z2, int i3) {
        if (i3 >= 0) {
            return new e(charSequence, i2, i3, new StringsKt__StringsKt$rangesDelimitedBy$4(b.a(strArr), z2));
        }
        throw new IllegalArgumentException(("Limit must be non-negative, but was " + i3 + '.').toString());
    }

    static /* synthetic */ mt.b a(CharSequence charSequence, String[] strArr, int i2, boolean z2, int i3, int i4, Object obj) {
        if ((i4 & 2) != 0) {
            i2 = 0;
        }
        if ((i4 & 4) != 0) {
            z2 = false;
        }
        if ((i4 & 8) != 0) {
            i3 = 0;
        }
        return a(charSequence, strArr, i2, z2, i3);
    }

    public static final boolean a(CharSequence charSequence, int i2, CharSequence charSequence2, int i3, int i4, boolean z2) {
        h.d(charSequence, "$this$regionMatchesImpl");
        h.d(charSequence2, "other");
        if (i3 < 0 || i2 < 0 || i2 > charSequence.length() - i4 || i3 > charSequence2.length() - i4) {
            return false;
        }
        for (int i5 = 0; i5 < i4; i5++) {
            if (!a.a(charSequence.charAt(i2 + i5), charSequence2.charAt(i3 + i5), z2)) {
                return false;
            }
        }
        return true;
    }

    public static final boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z2) {
        h.d(charSequence, "$this$contains");
        h.d(charSequence2, "other");
        if (charSequence2 instanceof String) {
            if (f.a(charSequence, (String) charSequence2, 0, z2, 2, (Object) null) >= 0) {
                return true;
            }
        } else {
            if (a(charSequence, charSequence2, 0, charSequence.length(), z2, false, 16, (Object) null) >= 0) {
                return true;
            }
        }
        return false;
    }

    public static /* synthetic */ boolean a(CharSequence charSequence, CharSequence charSequence2, boolean z2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        return f.a(charSequence, charSequence2, z2);
    }

    public static final int b(CharSequence charSequence, char c2, int i2, boolean z2) {
        h.d(charSequence, "$this$lastIndexOf");
        if (!z2 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(c2, i2);
        }
        return f.b(charSequence, new char[]{c2}, i2, z2);
    }

    public static /* synthetic */ int b(CharSequence charSequence, char c2, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = f.d(charSequence);
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return f.b(charSequence, c2, i2, z2);
    }

    public static final int b(CharSequence charSequence, String str, int i2, boolean z2) {
        h.d(charSequence, "$this$lastIndexOf");
        h.d(str, "string");
        if (!z2 && (charSequence instanceof String)) {
            return ((String) charSequence).lastIndexOf(str, i2);
        }
        return a(charSequence, (CharSequence) str, i2, 0, z2, true);
    }

    public static /* synthetic */ int b(CharSequence charSequence, String str, int i2, boolean z2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i2 = f.d(charSequence);
        }
        if ((i3 & 4) != 0) {
            z2 = false;
        }
        return f.b(charSequence, str, i2, z2);
    }

    public static final int b(CharSequence charSequence, char[] cArr, int i2, boolean z2) {
        h.d(charSequence, "$this$lastIndexOfAny");
        h.d(cArr, "chars");
        if (z2 || cArr.length != 1 || !(charSequence instanceof String)) {
            for (int d2 = d.d(i2, f.d(charSequence)); d2 >= 0; d2--) {
                char charAt = charSequence.charAt(d2);
                int length = cArr.length;
                boolean z3 = false;
                int i3 = 0;
                while (true) {
                    if (i3 >= length) {
                        break;
                    } else if (a.a(cArr[i3], charAt, z2)) {
                        z3 = true;
                        break;
                    } else {
                        i3++;
                    }
                }
                if (z3) {
                    return d2;
                }
            }
            return -1;
        }
        return ((String) charSequence).lastIndexOf(b.a(cArr), i2);
    }

    public static final CharSequence b(CharSequence charSequence) {
        h.d(charSequence, "$this$trim");
        int length = charSequence.length() - 1;
        int i2 = 0;
        boolean z2 = false;
        while (i2 <= length) {
            boolean a2 = a.a(charSequence.charAt(!z2 ? i2 : length));
            if (!z2) {
                if (!a2) {
                    z2 = true;
                } else {
                    i2++;
                }
            } else if (!a2) {
                break;
            } else {
                length--;
            }
        }
        return charSequence.subSequence(i2, length + 1);
    }

    public static final String b(String str, char c2, String str2) {
        h.d(str, "$this$substringAfterLast");
        h.d(str2, "missingDelimiterValue");
        int b2 = f.b((CharSequence) str, c2, 0, false, 6, (Object) null);
        if (b2 == -1) {
            return str2;
        }
        String substring = str.substring(b2 + 1, str.length());
        h.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String b(String str, char c2, String str2, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str2 = str;
        }
        return f.b(str, c2, str2);
    }

    public static final String b(String str, String str2, String str3) {
        h.d(str, "$this$substringAfter");
        h.d(str2, "delimiter");
        h.d(str3, "missingDelimiterValue");
        int a2 = f.a((CharSequence) str, str2, 0, false, 6, (Object) null);
        if (a2 == -1) {
            return str3;
        }
        String substring = str.substring(a2 + str2.length(), str.length());
        h.b(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return substring;
    }

    public static /* synthetic */ String b(String str, String str2, String str3, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            str3 = str;
        }
        return f.b(str, str2, str3);
    }

    /* access modifiers changed from: private */
    public static final Pair<Integer, String> b(CharSequence charSequence, Collection<String> collection, int i2, boolean z2, boolean z3) {
        int i3;
        Object obj;
        String str;
        Object obj2;
        if (z2 || collection.size() != 1) {
            a cVar = !z3 ? new c(d.c(i2, 0), charSequence.length()) : d.a(d.d(i2, f.d(charSequence)), 0);
            if (charSequence instanceof String) {
                i3 = cVar.a();
                int b2 = cVar.b();
                int c2 = cVar.c();
                if (c2 < 0 ? i3 >= b2 : i3 <= b2) {
                    while (true) {
                        Iterator it2 = collection.iterator();
                        while (true) {
                            if (!it2.hasNext()) {
                                obj2 = null;
                                break;
                            }
                            obj2 = it2.next();
                            String str2 = (String) obj2;
                            if (f.a(str2, 0, (String) charSequence, i3, str2.length(), z2)) {
                                break;
                            }
                        }
                        str = (String) obj2;
                        if (str == null) {
                            if (i3 == b2) {
                                break;
                            }
                            i3 += c2;
                        } else {
                            break;
                        }
                    }
                }
                return null;
            }
            int a2 = cVar.a();
            int b3 = cVar.b();
            int c3 = cVar.c();
            if (c3 < 0 ? a2 >= b3 : a2 <= b3) {
                while (true) {
                    Iterator it3 = collection.iterator();
                    while (true) {
                        if (!it3.hasNext()) {
                            obj = null;
                            break;
                        }
                        obj = it3.next();
                        String str3 = (String) obj;
                        if (f.a((CharSequence) str3, 0, charSequence, i3, str3.length(), z2)) {
                            break;
                        }
                    }
                    str = (String) obj;
                    if (str == null) {
                        if (i3 == b3) {
                            break;
                        }
                        a2 = i3 + c3;
                    } else {
                        break;
                    }
                }
            }
            return null;
            return j.a(Integer.valueOf(i3), str);
        }
        String str4 = (String) kotlin.collections.h.a(collection);
        CharSequence charSequence2 = charSequence;
        String str5 = str4;
        int i4 = i2;
        int a3 = !z3 ? f.a(charSequence2, str5, i4, false, 4, (Object) null) : f.b(charSequence2, str5, i4, false, 4, (Object) null);
        if (a3 < 0) {
            return null;
        }
        return j.a(Integer.valueOf(a3), str4);
    }

    public static final c c(CharSequence charSequence) {
        h.d(charSequence, "$this$indices");
        return new c(0, charSequence.length() - 1);
    }

    public static final int d(CharSequence charSequence) {
        h.d(charSequence, "$this$lastIndex");
        return charSequence.length() - 1;
    }
}
