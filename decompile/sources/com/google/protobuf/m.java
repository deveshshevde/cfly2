package com.google.protobuf;

import com.google.protobuf.GeneratedMessageLite;
import fg.i;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

final class m {
    static String a(k kVar, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        a(kVar, sb, 0);
        return sb.toString();
    }

    private static final String a(String str) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < str.length(); i2++) {
            char charAt = str.charAt(i2);
            if (Character.isUpperCase(charAt)) {
                sb.append("_");
            }
            sb.append(Character.toLowerCase(charAt));
        }
        return sb.toString();
    }

    private static void a(k kVar, StringBuilder sb, int i2) {
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        for (Method method : kVar.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String replaceFirst : treeSet) {
            String replaceFirst2 = replaceFirst.replaceFirst("get", "");
            boolean z2 = true;
            if (replaceFirst2.endsWith("List") && !replaceFirst2.endsWith("OrBuilderList")) {
                String str = replaceFirst2.substring(0, 1).toLowerCase() + replaceFirst2.substring(1, replaceFirst2.length() - 4);
                Method method2 = (Method) hashMap.get("get" + replaceFirst2);
                if (method2 != null) {
                    a(sb, i2, a(str), GeneratedMessageLite.a(method2, (Object) kVar, new Object[0]));
                }
            }
            if (((Method) hashMap2.get("set" + replaceFirst2)) != null) {
                if (replaceFirst2.endsWith("Bytes")) {
                    if (hashMap.containsKey("get" + replaceFirst2.substring(0, replaceFirst2.length() - 5))) {
                    }
                }
                String str2 = replaceFirst2.substring(0, 1).toLowerCase() + replaceFirst2.substring(1);
                Method method3 = (Method) hashMap.get("get" + replaceFirst2);
                Method method4 = (Method) hashMap.get("has" + replaceFirst2);
                if (method3 != null) {
                    Object a2 = GeneratedMessageLite.a(method3, (Object) kVar, new Object[0]);
                    if (method4 != null) {
                        z2 = ((Boolean) GeneratedMessageLite.a(method4, (Object) kVar, new Object[0])).booleanValue();
                    } else if (a(a2)) {
                        z2 = false;
                    }
                    if (z2) {
                        a(sb, i2, a(str2), a2);
                    }
                }
            }
        }
        if (kVar instanceof GeneratedMessageLite.c) {
            Iterator<Map.Entry<GeneratedMessageLite.e, Object>> d2 = ((GeneratedMessageLite.c) kVar).f20065d.d();
            while (d2.hasNext()) {
                Map.Entry next = d2.next();
                a(sb, i2, "[" + ((GeneratedMessageLite.e) next.getKey()).c() + "]", next.getValue());
            }
        }
        GeneratedMessageLite generatedMessageLite = (GeneratedMessageLite) kVar;
        if (generatedMessageLite.f11843b != null) {
            generatedMessageLite.f11843b.a(sb, i2);
        }
    }

    static final void a(StringBuilder sb, int i2, String str, Object obj) {
        String str2;
        String a2;
        if (obj instanceof List) {
            for (Object a3 : (List) obj) {
                a(sb, i2, str, a3);
            }
            return;
        }
        sb.append(10);
        for (int i3 = 0; i3 < i2; i3++) {
            sb.append(' ');
        }
        sb.append(str);
        if (obj instanceof String) {
            sb.append(": \"");
            a2 = p.a((String) obj);
        } else if (obj instanceof ByteString) {
            sb.append(": \"");
            a2 = p.a((ByteString) obj);
        } else {
            if (obj instanceof GeneratedMessageLite) {
                sb.append(" {");
                a((GeneratedMessageLite) obj, sb, i2 + 2);
                sb.append("\n");
                for (int i4 = 0; i4 < i2; i4++) {
                    sb.append(' ');
                }
                str2 = "}";
            } else {
                sb.append(": ");
                str2 = obj.toString();
            }
            sb.append(str2);
            return;
        }
        sb.append(a2);
        sb.append('\"');
    }

    private static boolean a(Object obj) {
        Object obj2;
        if (obj instanceof Boolean) {
            return !((Boolean) obj).booleanValue();
        }
        if (obj instanceof Integer) {
            return ((Integer) obj).intValue() == 0;
        }
        if (obj instanceof Float) {
            return ((Float) obj).floatValue() == 0.0f;
        }
        if (obj instanceof Double) {
            return ((Double) obj).doubleValue() == i.f27244a;
        }
        if (obj instanceof String) {
            obj2 = "";
        } else if (!(obj instanceof ByteString)) {
            return obj instanceof k ? obj == ((k) obj).k() : (obj instanceof Enum) && ((Enum) obj).ordinal() == 0;
        } else {
            obj2 = ByteString.f20030a;
        }
        return obj.equals(obj2);
    }
}
