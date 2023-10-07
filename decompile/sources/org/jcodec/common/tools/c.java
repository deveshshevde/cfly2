package org.jcodec.common.tools;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.jcodec.common.d;
import org.jcodec.common.i;

public class c {

    /* renamed from: a  reason: collision with root package name */
    static Set<Class> f33256a = new HashSet();

    /* renamed from: b  reason: collision with root package name */
    static Set<String> f33257b = new HashSet();

    static {
        f33256a.add(Boolean.class);
        f33256a.add(Byte.class);
        f33256a.add(Short.class);
        f33256a.add(Integer.class);
        f33256a.add(Long.class);
        f33256a.add(Float.class);
        f33256a.add(Double.class);
        f33256a.add(Character.class);
        f33257b.add("getClass");
        f33257b.add("get");
    }

    private static String a(String str, String str2) {
        if (str2 != null) {
            char[] charArray = str2.toCharArray();
            if (charArray.length == 0) {
                return str;
            }
            if (charArray.length <= 1 || !Character.isUpperCase(charArray[1])) {
                charArray[0] = Character.toUpperCase(charArray[0]);
            } else {
                charArray[0] = Character.toLowerCase(charArray[0]);
            }
            return str + new String(charArray);
        }
        throw new IllegalArgumentException("Passed null string as field name");
    }

    private static Method a(Method[] methodArr, String str) {
        String a2 = a("is", str);
        String a3 = a("get", str);
        for (Method method : methodArr) {
            if ((a2.equals(method.getName()) || a3.equals(method.getName())) && a(method)) {
                return method;
            }
        }
        return null;
    }

    public static List<String> a(Class cls) {
        return a(cls, new String[0]);
    }

    public static List<String> a(Class cls, String... strArr) {
        ArrayList arrayList = new ArrayList();
        for (Method method : cls.getDeclaredMethods()) {
            if (a(method)) {
                try {
                    arrayList.add(b(method));
                } catch (Exception unused) {
                }
            }
        }
        return arrayList;
    }

    public static void a(Object obj, StringBuilder sb, String... strArr) {
        Method[] methods = obj.getClass().getMethods();
        for (String str : strArr) {
            Method a2 = a(methods, str);
            if (a2 != null) {
                a(obj, new d(), sb, a2, str);
            }
        }
    }

    private static void a(Object obj, d dVar, StringBuilder sb) {
        int identityHashCode = System.identityHashCode(obj);
        if (dVar.d(identityHashCode)) {
            sb.append("\"!-!-!-!-LOOP-!-!-!-!\"");
            return;
        }
        dVar.b(identityHashCode);
        if (obj instanceof ByteBuffer) {
            obj = i.a((ByteBuffer) obj);
        }
        if (obj == null) {
            sb.append("null");
        } else {
            String str = "\"";
            if (obj instanceof String) {
                sb.append(str);
                a((String) obj, sb);
            } else {
                if (obj instanceof Map) {
                    Iterator it2 = ((Map) obj).entrySet().iterator();
                    sb.append("{");
                    while (it2.hasNext()) {
                        Map.Entry entry = (Map.Entry) it2.next();
                        sb.append(str);
                        sb.append(entry.getKey());
                        sb.append("\":");
                        a(entry.getValue(), dVar, sb);
                        if (it2.hasNext()) {
                            sb.append(",");
                        }
                    }
                } else {
                    str = "]";
                    if (obj instanceof Iterable) {
                        Iterator it3 = ((Iterable) obj).iterator();
                        sb.append("[");
                        while (it3.hasNext()) {
                            a(it3.next(), dVar, sb);
                            if (it3.hasNext()) {
                                sb.append(",");
                            }
                        }
                    } else {
                        int i2 = 0;
                        if (obj instanceof Object[]) {
                            sb.append("[");
                            int length = Array.getLength(obj);
                            while (i2 < length) {
                                a(Array.get(obj, i2), dVar, sb);
                                if (i2 < length - 1) {
                                    sb.append(",");
                                }
                                i2++;
                            }
                        } else if (obj instanceof long[]) {
                            long[] jArr = (long[]) obj;
                            sb.append("[");
                            for (int i3 = 0; i3 < jArr.length; i3++) {
                                sb.append(String.format("0x%016x", new Object[]{Long.valueOf(jArr[i3])}));
                                if (i3 < jArr.length - 1) {
                                    sb.append(",");
                                }
                            }
                        } else if (obj instanceof int[]) {
                            int[] iArr = (int[]) obj;
                            sb.append("[");
                            for (int i4 = 0; i4 < iArr.length; i4++) {
                                sb.append(String.format("0x%08x", new Object[]{Integer.valueOf(iArr[i4])}));
                                if (i4 < iArr.length - 1) {
                                    sb.append(",");
                                }
                            }
                        } else if (obj instanceof float[]) {
                            float[] fArr = (float[]) obj;
                            sb.append("[");
                            for (int i5 = 0; i5 < fArr.length; i5++) {
                                sb.append(String.format(".3f", new Object[]{Float.valueOf(fArr[i5])}));
                                if (i5 < fArr.length - 1) {
                                    sb.append(",");
                                }
                            }
                        } else if (obj instanceof double[]) {
                            double[] dArr = (double[]) obj;
                            sb.append("[");
                            for (int i6 = 0; i6 < dArr.length; i6++) {
                                sb.append(String.format(".6f", new Object[]{Double.valueOf(dArr[i6])}));
                                if (i6 < dArr.length - 1) {
                                    sb.append(",");
                                }
                            }
                        } else if (obj instanceof short[]) {
                            short[] sArr = (short[]) obj;
                            sb.append("[");
                            for (int i7 = 0; i7 < sArr.length; i7++) {
                                sb.append(String.format("0x%04x", new Object[]{Short.valueOf(sArr[i7])}));
                                if (i7 < sArr.length - 1) {
                                    sb.append(",");
                                }
                            }
                        } else if (obj instanceof byte[]) {
                            byte[] bArr = (byte[]) obj;
                            sb.append("[");
                            for (int i8 = 0; i8 < bArr.length; i8++) {
                                sb.append(String.format("0x%02x", new Object[]{Byte.valueOf(bArr[i8])}));
                                if (i8 < bArr.length - 1) {
                                    sb.append(",");
                                }
                            }
                        } else if (obj instanceof boolean[]) {
                            boolean[] zArr = (boolean[]) obj;
                            sb.append("[");
                            while (i2 < zArr.length) {
                                sb.append(zArr[i2]);
                                if (i2 < zArr.length - 1) {
                                    sb.append(",");
                                }
                                i2++;
                            }
                        } else {
                            sb.append("{");
                            Method[] methods = obj.getClass().getMethods();
                            int length2 = methods.length;
                            while (i2 < length2) {
                                Method method = methods[i2];
                                if (!f33257b.contains(method.getName()) && a(method)) {
                                    a(obj, dVar, sb, method, b(method));
                                }
                                i2++;
                            }
                        }
                    }
                }
                sb.append("}");
            }
            sb.append(str);
        }
        dVar.b();
    }

    private static void a(Object obj, d dVar, StringBuilder sb, Method method, String str) {
        try {
            Object invoke = method.invoke(obj, new Object[0]);
            sb.append('\"');
            sb.append(str);
            sb.append("\":");
            if (invoke == null || !f33256a.contains(invoke.getClass())) {
                a(invoke, dVar, sb);
            } else {
                sb.append(invoke);
            }
            sb.append(",");
        } catch (Exception unused) {
        }
    }

    private static void a(String str, StringBuilder sb) {
        for (char c2 : str.toCharArray()) {
            if (c2 < ' ') {
                sb.append(String.format("\\%02x", new Object[]{Integer.valueOf(c2)}));
            } else {
                sb.append(c2);
            }
        }
    }

    public static boolean a(Method method) {
        if (!Modifier.isPublic(method.getModifiers())) {
            return false;
        }
        return (method.getName().startsWith("get") || (method.getName().startsWith("is") && method.getReturnType() == Boolean.TYPE)) && method.getParameterTypes().length == 0 && !Void.TYPE.equals(method.getReturnType());
    }

    private static String b(Method method) {
        if (a(method)) {
            char[] charArray = method.getName().toCharArray();
            int i2 = charArray[0] == 'g' ? 3 : 2;
            charArray[i2] = Character.toLowerCase(charArray[i2]);
            return new String(charArray, i2, charArray.length - i2);
        }
        throw new IllegalArgumentException("Not a getter");
    }
}
