package com.google.android.gms.internal.gtm;

import fg.i;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

final class zzwm {
    static String zza(zzwk zzwk, String str) {
        StringBuilder sb = new StringBuilder();
        sb.append("# ");
        sb.append(str);
        zzd(zzwk, sb, 0);
        return sb.toString();
    }

    static final void zzb(StringBuilder sb, int i2, String str, Object obj) {
        if (obj instanceof List) {
            for (Object zzb : (List) obj) {
                zzb(sb, i2, str, zzb);
            }
        } else if (obj instanceof Map) {
            for (Map.Entry zzb2 : ((Map) obj).entrySet()) {
                zzb(sb, i2, str, zzb2);
            }
        } else {
            sb.append(10);
            int i3 = 0;
            for (int i4 = 0; i4 < i2; i4++) {
                sb.append(' ');
            }
            sb.append(str);
            if (obj instanceof String) {
                sb.append(": \"");
                sb.append(zzxm.zza(zztd.zzo((String) obj)));
                sb.append('\"');
            } else if (obj instanceof zztd) {
                sb.append(": \"");
                sb.append(zzxm.zza((zztd) obj));
                sb.append('\"');
            } else if (obj instanceof zzuz) {
                sb.append(" {");
                zzd((zzuz) obj, sb, i2 + 2);
                sb.append("\n");
                while (i3 < i2) {
                    sb.append(' ');
                    i3++;
                }
                sb.append("}");
            } else if (obj instanceof Map.Entry) {
                sb.append(" {");
                Map.Entry entry = (Map.Entry) obj;
                int i5 = i2 + 2;
                zzb(sb, i5, "key", entry.getKey());
                zzb(sb, i5, "value", entry.getValue());
                sb.append("\n");
                while (i3 < i2) {
                    sb.append(' ');
                    i3++;
                }
                sb.append("}");
            } else {
                sb.append(": ");
                sb.append(obj.toString());
            }
        }
    }

    private static final String zzc(String str) {
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

    private static void zzd(zzwk zzwk, StringBuilder sb, int i2) {
        Object obj;
        HashMap hashMap = new HashMap();
        HashMap hashMap2 = new HashMap();
        TreeSet<String> treeSet = new TreeSet<>();
        for (Method method : zzwk.getClass().getDeclaredMethods()) {
            hashMap2.put(method.getName(), method);
            if (method.getParameterTypes().length == 0) {
                hashMap.put(method.getName(), method);
                if (method.getName().startsWith("get")) {
                    treeSet.add(method.getName());
                }
            }
        }
        for (String str : treeSet) {
            String substring = str.startsWith("get") ? str.substring(3) : str;
            if (substring.endsWith("List") && !substring.endsWith("OrBuilderList") && !substring.equals("List")) {
                String valueOf = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf2 = String.valueOf(substring.substring(1, substring.length() - 4));
                String concat = valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
                Method method2 = (Method) hashMap.get(str);
                if (method2 != null && method2.getReturnType().equals(List.class)) {
                    zzb(sb, i2, zzc(concat), zzuz.zzai(method2, zzwk, new Object[0]));
                }
            }
            if (substring.endsWith("Map") && !substring.equals("Map")) {
                String valueOf3 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf4 = String.valueOf(substring.substring(1, substring.length() - 3));
                String concat2 = valueOf4.length() != 0 ? valueOf3.concat(valueOf4) : new String(valueOf3);
                Method method3 = (Method) hashMap.get(str);
                if (method3 != null && method3.getReturnType().equals(Map.class) && !method3.isAnnotationPresent(Deprecated.class) && Modifier.isPublic(method3.getModifiers())) {
                    zzb(sb, i2, zzc(concat2), zzuz.zzai(method3, zzwk, new Object[0]));
                }
            }
            String valueOf5 = String.valueOf(substring);
            if (((Method) hashMap2.get(valueOf5.length() != 0 ? "set".concat(valueOf5) : new String("set"))) != null) {
                if (substring.endsWith("Bytes")) {
                    String valueOf6 = String.valueOf(substring.substring(0, substring.length() - 5));
                    if (hashMap.containsKey(valueOf6.length() != 0 ? "get".concat(valueOf6) : new String("get"))) {
                    }
                }
                String valueOf7 = String.valueOf(substring.substring(0, 1).toLowerCase());
                String valueOf8 = String.valueOf(substring.substring(1));
                String concat3 = valueOf8.length() != 0 ? valueOf7.concat(valueOf8) : new String(valueOf7);
                String valueOf9 = String.valueOf(substring);
                Method method4 = (Method) hashMap.get(valueOf9.length() != 0 ? "get".concat(valueOf9) : new String("get"));
                String valueOf10 = String.valueOf(substring);
                Method method5 = (Method) hashMap.get(valueOf10.length() != 0 ? "has".concat(valueOf10) : new String("has"));
                if (method4 != null) {
                    Object zzai = zzuz.zzai(method4, zzwk, new Object[0]);
                    if (method5 == null) {
                        if (zzai instanceof Boolean) {
                            if (!((Boolean) zzai).booleanValue()) {
                            }
                        } else if (zzai instanceof Integer) {
                            if (((Integer) zzai).intValue() == 0) {
                            }
                        } else if (zzai instanceof Float) {
                            if (((Float) zzai).floatValue() == 0.0f) {
                            }
                        } else if (!(zzai instanceof Double)) {
                            if (zzai instanceof String) {
                                obj = "";
                            } else if (zzai instanceof zztd) {
                                obj = zztd.zzb;
                            } else if (zzai instanceof zzwk) {
                                if (zzai == ((zzwk) zzai).zzar()) {
                                }
                            } else if ((zzai instanceof Enum) && ((Enum) zzai).ordinal() == 0) {
                            }
                            if (zzai.equals(obj)) {
                            }
                        } else if (((Double) zzai).doubleValue() == i.f27244a) {
                        }
                    } else if (!((Boolean) zzuz.zzai(method5, zzwk, new Object[0])).booleanValue()) {
                    }
                    zzb(sb, i2, zzc(concat3), zzai);
                }
            }
        }
        if (zzwk instanceof zzuv) {
            Iterator<Map.Entry<zzuw, Object>> zzf = ((zzuv) zzwk).zza.zzf();
            while (zzf.hasNext()) {
                Map.Entry next = zzf.next();
                int i3 = ((zzuw) next.getKey()).zzb;
                StringBuilder sb2 = new StringBuilder(13);
                sb2.append("[");
                sb2.append(i3);
                sb2.append("]");
                zzb(sb, i2, sb2.toString(), next.getValue());
            }
        }
        zzxp zzxp = ((zzuz) zzwk).zzc;
        if (zzxp != null) {
            zzxp.zzg(sb, i2);
        }
    }
}
