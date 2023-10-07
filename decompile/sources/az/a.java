package az;

import android.content.Context;
import bh.c;
import com.alibaba.android.arouter.facade.enums.TypeKind;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private static Context f5577a;

    /* renamed from: az.a$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* renamed from: a  reason: collision with root package name */
        static final /* synthetic */ int[] f5578a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.alibaba.android.arouter.facade.enums.RouteType[] r0 = com.alibaba.android.arouter.facade.enums.RouteType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f5578a = r0
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.PROVIDER     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f5578a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.alibaba.android.arouter.facade.enums.RouteType r1 = com.alibaba.android.arouter.facade.enums.RouteType.FRAGMENT     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: az.a.AnonymousClass1.<clinit>():void");
        }
    }

    public static ba.a a(String str) {
        bc.a aVar = b.f5582d.get(str);
        if (aVar == null) {
            return null;
        }
        return new ba.a(aVar.o(), aVar.p());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x008f, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x00af, code lost:
        throw new com.alibaba.android.arouter.exception.HandlerException("ARouter::Fatal exception when loading group meta. [" + r12.getMessage() + "]");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x0194, code lost:
        r12 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x01af, code lost:
        throw new com.alibaba.android.arouter.exception.HandlerException("Init provider failed! " + r12.getMessage());
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:8:0x0024, B:39:0x017b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static synchronized void a(ba.a r12) {
        /*
            java.lang.Class<az.a> r0 = az.a.class
            monitor-enter(r0)
            if (r12 == 0) goto L_0x01b8
            java.util.Map<java.lang.String, bc.a> r1 = az.b.f5580b     // Catch:{ all -> 0x01b6 }
            java.lang.String r2 = r12.o()     // Catch:{ all -> 0x01b6 }
            java.lang.Object r1 = r1.get(r2)     // Catch:{ all -> 0x01b6 }
            bc.a r1 = (bc.a) r1     // Catch:{ all -> 0x01b6 }
            r2 = 1
            r3 = 2
            r4 = 0
            if (r1 != 0) goto L_0x00dc
            java.util.Map<java.lang.String, java.lang.Class<? extends be.c>> r1 = az.b.f5579a     // Catch:{ all -> 0x01b6 }
            java.lang.String r5 = r12.p()     // Catch:{ all -> 0x01b6 }
            java.lang.Object r1 = r1.get(r5)     // Catch:{ all -> 0x01b6 }
            java.lang.Class r1 = (java.lang.Class) r1     // Catch:{ all -> 0x01b6 }
            if (r1 == 0) goto L_0x00b0
            boolean r5 = bf.a.b()     // Catch:{ Exception -> 0x008f }
            if (r5 == 0) goto L_0x0049
            be.a r5 = bf.a.f5606a     // Catch:{ Exception -> 0x008f }
            java.lang.String r6 = "ARouter::"
            java.util.Locale r7 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x008f }
            java.lang.String r8 = "The group [%s] starts loading, trigger by [%s]"
            java.lang.Object[] r9 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x008f }
            java.lang.String r10 = r12.p()     // Catch:{ Exception -> 0x008f }
            r9[r4] = r10     // Catch:{ Exception -> 0x008f }
            java.lang.String r10 = r12.o()     // Catch:{ Exception -> 0x008f }
            r9[r2] = r10     // Catch:{ Exception -> 0x008f }
            java.lang.String r7 = java.lang.String.format(r7, r8, r9)     // Catch:{ Exception -> 0x008f }
            r5.a(r6, r7)     // Catch:{ Exception -> 0x008f }
        L_0x0049:
            java.lang.Class[] r5 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x008f }
            java.lang.reflect.Constructor r1 = r1.getConstructor(r5)     // Catch:{ Exception -> 0x008f }
            java.lang.Object[] r5 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x008f }
            java.lang.Object r1 = r1.newInstance(r5)     // Catch:{ Exception -> 0x008f }
            be.c r1 = (be.c) r1     // Catch:{ Exception -> 0x008f }
            java.util.Map<java.lang.String, bc.a> r5 = az.b.f5580b     // Catch:{ Exception -> 0x008f }
            r1.a(r5)     // Catch:{ Exception -> 0x008f }
            java.util.Map<java.lang.String, java.lang.Class<? extends be.c>> r1 = az.b.f5579a     // Catch:{ Exception -> 0x008f }
            java.lang.String r5 = r12.p()     // Catch:{ Exception -> 0x008f }
            r1.remove(r5)     // Catch:{ Exception -> 0x008f }
            boolean r1 = bf.a.b()     // Catch:{ Exception -> 0x008f }
            if (r1 == 0) goto L_0x008a
            be.a r1 = bf.a.f5606a     // Catch:{ Exception -> 0x008f }
            java.lang.String r5 = "ARouter::"
            java.util.Locale r6 = java.util.Locale.getDefault()     // Catch:{ Exception -> 0x008f }
            java.lang.String r7 = "The group [%s] has already been loaded, trigger by [%s]"
            java.lang.Object[] r3 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x008f }
            java.lang.String r8 = r12.p()     // Catch:{ Exception -> 0x008f }
            r3[r4] = r8     // Catch:{ Exception -> 0x008f }
            java.lang.String r4 = r12.o()     // Catch:{ Exception -> 0x008f }
            r3[r2] = r4     // Catch:{ Exception -> 0x008f }
            java.lang.String r2 = java.lang.String.format(r6, r7, r3)     // Catch:{ Exception -> 0x008f }
            r1.a(r5, r2)     // Catch:{ Exception -> 0x008f }
        L_0x008a:
            a((ba.a) r12)     // Catch:{ all -> 0x01b6 }
            goto L_0x01b4
        L_0x008f:
            r12 = move-exception
            com.alibaba.android.arouter.exception.HandlerException r1 = new com.alibaba.android.arouter.exception.HandlerException     // Catch:{ all -> 0x01b6 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b6 }
            r2.<init>()     // Catch:{ all -> 0x01b6 }
            java.lang.String r3 = "ARouter::Fatal exception when loading group meta. ["
            r2.append(r3)     // Catch:{ all -> 0x01b6 }
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x01b6 }
            r2.append(r12)     // Catch:{ all -> 0x01b6 }
            java.lang.String r12 = "]"
            r2.append(r12)     // Catch:{ all -> 0x01b6 }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x01b6 }
            r1.<init>(r12)     // Catch:{ all -> 0x01b6 }
            throw r1     // Catch:{ all -> 0x01b6 }
        L_0x00b0:
            com.alibaba.android.arouter.exception.NoRouteFoundException r1 = new com.alibaba.android.arouter.exception.NoRouteFoundException     // Catch:{ all -> 0x01b6 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b6 }
            r2.<init>()     // Catch:{ all -> 0x01b6 }
            java.lang.String r3 = "ARouter::There is no route match the path ["
            r2.append(r3)     // Catch:{ all -> 0x01b6 }
            java.lang.String r3 = r12.o()     // Catch:{ all -> 0x01b6 }
            r2.append(r3)     // Catch:{ all -> 0x01b6 }
            java.lang.String r3 = "], in group ["
            r2.append(r3)     // Catch:{ all -> 0x01b6 }
            java.lang.String r12 = r12.p()     // Catch:{ all -> 0x01b6 }
            r2.append(r12)     // Catch:{ all -> 0x01b6 }
            java.lang.String r12 = "]"
            r2.append(r12)     // Catch:{ all -> 0x01b6 }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x01b6 }
            r1.<init>(r12)     // Catch:{ all -> 0x01b6 }
            throw r1     // Catch:{ all -> 0x01b6 }
        L_0x00dc:
            java.lang.Class r5 = r1.n()     // Catch:{ all -> 0x01b6 }
            r12.a((java.lang.Class<?>) r5)     // Catch:{ all -> 0x01b6 }
            com.alibaba.android.arouter.facade.enums.RouteType r5 = r1.m()     // Catch:{ all -> 0x01b6 }
            r12.a((com.alibaba.android.arouter.facade.enums.RouteType) r5)     // Catch:{ all -> 0x01b6 }
            int r5 = r1.q()     // Catch:{ all -> 0x01b6 }
            r12.a((int) r5)     // Catch:{ all -> 0x01b6 }
            int r5 = r1.r()     // Catch:{ all -> 0x01b6 }
            r12.b((int) r5)     // Catch:{ all -> 0x01b6 }
            android.net.Uri r5 = r12.g()     // Catch:{ all -> 0x01b6 }
            if (r5 == 0) goto L_0x0158
            java.util.Map r6 = bh.c.a((android.net.Uri) r5)     // Catch:{ all -> 0x01b6 }
            java.util.Map r7 = r1.l()     // Catch:{ all -> 0x01b6 }
            boolean r8 = bh.b.a(r7)     // Catch:{ all -> 0x01b6 }
            if (r8 == 0) goto L_0x014f
            java.util.Set r8 = r7.entrySet()     // Catch:{ all -> 0x01b6 }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x01b6 }
        L_0x0114:
            boolean r9 = r8.hasNext()     // Catch:{ all -> 0x01b6 }
            if (r9 == 0) goto L_0x013a
            java.lang.Object r9 = r8.next()     // Catch:{ all -> 0x01b6 }
            java.util.Map$Entry r9 = (java.util.Map.Entry) r9     // Catch:{ all -> 0x01b6 }
            java.lang.Object r10 = r9.getValue()     // Catch:{ all -> 0x01b6 }
            java.lang.Integer r10 = (java.lang.Integer) r10     // Catch:{ all -> 0x01b6 }
            java.lang.Object r11 = r9.getKey()     // Catch:{ all -> 0x01b6 }
            java.lang.String r11 = (java.lang.String) r11     // Catch:{ all -> 0x01b6 }
            java.lang.Object r9 = r9.getKey()     // Catch:{ all -> 0x01b6 }
            java.lang.Object r9 = r6.get(r9)     // Catch:{ all -> 0x01b6 }
            java.lang.String r9 = (java.lang.String) r9     // Catch:{ all -> 0x01b6 }
            a(r12, r10, r11, r9)     // Catch:{ all -> 0x01b6 }
            goto L_0x0114
        L_0x013a:
            android.os.Bundle r6 = r12.f()     // Catch:{ all -> 0x01b6 }
            java.lang.String r8 = "wmHzgD4lOj5o4241"
            java.util.Set r7 = r7.keySet()     // Catch:{ all -> 0x01b6 }
            java.lang.String[] r9 = new java.lang.String[r4]     // Catch:{ all -> 0x01b6 }
            java.lang.Object[] r7 = r7.toArray(r9)     // Catch:{ all -> 0x01b6 }
            java.lang.String[] r7 = (java.lang.String[]) r7     // Catch:{ all -> 0x01b6 }
            r6.putStringArray(r8, r7)     // Catch:{ all -> 0x01b6 }
        L_0x014f:
            java.lang.String r6 = "NTeRQWvye18AkPd6G"
            java.lang.String r5 = r5.toString()     // Catch:{ all -> 0x01b6 }
            r12.a((java.lang.String) r6, (java.lang.String) r5)     // Catch:{ all -> 0x01b6 }
        L_0x0158:
            int[] r5 = az.a.AnonymousClass1.f5578a     // Catch:{ all -> 0x01b6 }
            com.alibaba.android.arouter.facade.enums.RouteType r6 = r1.m()     // Catch:{ all -> 0x01b6 }
            int r6 = r6.ordinal()     // Catch:{ all -> 0x01b6 }
            r5 = r5[r6]     // Catch:{ all -> 0x01b6 }
            if (r5 == r2) goto L_0x016d
            if (r5 == r3) goto L_0x0169
            goto L_0x01b4
        L_0x0169:
            r12.i()     // Catch:{ all -> 0x01b6 }
            goto L_0x01b4
        L_0x016d:
            java.lang.Class r1 = r1.n()     // Catch:{ all -> 0x01b6 }
            java.util.Map<java.lang.Class, be.b> r2 = az.b.f5581c     // Catch:{ all -> 0x01b6 }
            java.lang.Object r2 = r2.get(r1)     // Catch:{ all -> 0x01b6 }
            be.b r2 = (be.b) r2     // Catch:{ all -> 0x01b6 }
            if (r2 != 0) goto L_0x01b0
            java.lang.Class[] r2 = new java.lang.Class[r4]     // Catch:{ Exception -> 0x0194 }
            java.lang.reflect.Constructor r2 = r1.getConstructor(r2)     // Catch:{ Exception -> 0x0194 }
            java.lang.Object[] r3 = new java.lang.Object[r4]     // Catch:{ Exception -> 0x0194 }
            java.lang.Object r2 = r2.newInstance(r3)     // Catch:{ Exception -> 0x0194 }
            be.b r2 = (be.b) r2     // Catch:{ Exception -> 0x0194 }
            android.content.Context r3 = f5577a     // Catch:{ Exception -> 0x0194 }
            r2.a(r3)     // Catch:{ Exception -> 0x0194 }
            java.util.Map<java.lang.Class, be.b> r3 = az.b.f5581c     // Catch:{ Exception -> 0x0194 }
            r3.put(r1, r2)     // Catch:{ Exception -> 0x0194 }
            goto L_0x01b0
        L_0x0194:
            r12 = move-exception
            com.alibaba.android.arouter.exception.HandlerException r1 = new com.alibaba.android.arouter.exception.HandlerException     // Catch:{ all -> 0x01b6 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x01b6 }
            r2.<init>()     // Catch:{ all -> 0x01b6 }
            java.lang.String r3 = "Init provider failed! "
            r2.append(r3)     // Catch:{ all -> 0x01b6 }
            java.lang.String r12 = r12.getMessage()     // Catch:{ all -> 0x01b6 }
            r2.append(r12)     // Catch:{ all -> 0x01b6 }
            java.lang.String r12 = r2.toString()     // Catch:{ all -> 0x01b6 }
            r1.<init>(r12)     // Catch:{ all -> 0x01b6 }
            throw r1     // Catch:{ all -> 0x01b6 }
        L_0x01b0:
            r12.a((be.b) r2)     // Catch:{ all -> 0x01b6 }
            goto L_0x0169
        L_0x01b4:
            monitor-exit(r0)
            return
        L_0x01b6:
            r12 = move-exception
            goto L_0x01c0
        L_0x01b8:
            com.alibaba.android.arouter.exception.NoRouteFoundException r12 = new com.alibaba.android.arouter.exception.NoRouteFoundException     // Catch:{ all -> 0x01b6 }
            java.lang.String r1 = "ARouter::No postcard!"
            r12.<init>(r1)     // Catch:{ all -> 0x01b6 }
            throw r12     // Catch:{ all -> 0x01b6 }
        L_0x01c0:
            monitor-exit(r0)
            goto L_0x01c3
        L_0x01c2:
            throw r12
        L_0x01c3:
            goto L_0x01c2
        */
        throw new UnsupportedOperationException("Method not decompiled: az.a.a(ba.a):void");
    }

    private static void a(ba.a aVar, Integer num, String str, String str2) {
        if (!c.a((CharSequence) str) && !c.a((CharSequence) str2)) {
            if (num != null) {
                try {
                    if (num.intValue() == TypeKind.BOOLEAN.ordinal()) {
                        aVar.a(str, Boolean.parseBoolean(str2));
                        return;
                    } else if (num.intValue() == TypeKind.BYTE.ordinal()) {
                        aVar.a(str, Byte.valueOf(str2).byteValue());
                        return;
                    } else if (num.intValue() == TypeKind.SHORT.ordinal()) {
                        aVar.a(str, Short.valueOf(str2).shortValue());
                        return;
                    } else if (num.intValue() == TypeKind.INT.ordinal()) {
                        aVar.a(str, Integer.valueOf(str2).intValue());
                        return;
                    } else if (num.intValue() == TypeKind.LONG.ordinal()) {
                        aVar.a(str, Long.valueOf(str2).longValue());
                        return;
                    } else if (num.intValue() == TypeKind.FLOAT.ordinal()) {
                        aVar.a(str, Float.valueOf(str2).floatValue());
                        return;
                    } else if (num.intValue() == TypeKind.DOUBLE.ordinal()) {
                        aVar.a(str, Double.valueOf(str2).doubleValue());
                        return;
                    } else if (num.intValue() != TypeKind.STRING.ordinal()) {
                        if (num.intValue() != TypeKind.PARCELABLE.ordinal()) {
                            int intValue = num.intValue();
                            int ordinal = TypeKind.OBJECT.ordinal();
                        } else {
                            return;
                        }
                    }
                } catch (Throwable th) {
                    be.a aVar2 = bf.a.f5606a;
                    aVar2.c("ARouter::", "LogisticsCenter setValue failed! " + th.getMessage());
                    return;
                }
            }
            aVar.a(str, str2);
        }
    }
}
