package com.amap.api.mapcore.util;

import android.content.Context;
import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;

public final class ap extends Thread {

    /* renamed from: a  reason: collision with root package name */
    private Context f7858a;

    /* renamed from: b  reason: collision with root package name */
    private bb f7859b;

    public ap(Context context) {
        this.f7858a = context;
        this.f7859b = bb.a(context);
    }

    private static aw a(File file) {
        String a2 = dl.a(file);
        aw awVar = new aw();
        awVar.b(a2);
        return awVar;
    }

    private aw a(String str) {
        if (str.equals("quanguo")) {
            str = "quanguogaiyaotu";
        }
        am a2 = am.a(this.f7858a);
        aw awVar = null;
        if (a2 != null) {
            String f2 = a2.f(str);
            File[] listFiles = new File(dl.c(this.f7858a)).listFiles();
            if (listFiles == null) {
                return null;
            }
            for (File file : listFiles) {
                if ((file.getName().contains(f2) || file.getName().contains(str)) && file.getName().endsWith(".zip.tmp.dt")) {
                    awVar = a(file);
                    if (awVar.c() != null) {
                        return awVar;
                    }
                }
            }
        }
        return awVar;
    }

    private void a() {
        aw a2;
        String b2;
        int indexOf;
        String b3;
        int indexOf2;
        String b4;
        int indexOf3;
        ArrayList arrayList = new ArrayList();
        ArrayList<aw> a3 = this.f7859b.a();
        a((ArrayList<String>) arrayList, "vmap/");
        a((ArrayList<String>) arrayList, "map/");
        b(arrayList, "map/");
        ArrayList<String> b5 = b();
        Iterator<aw> it2 = a3.iterator();
        while (it2.hasNext()) {
            aw next = it2.next();
            if (!(next == null || next.c() == null)) {
                boolean z2 = true;
                if (next.f7895l == 4 || next.f7895l == 7) {
                    boolean contains = arrayList.contains(next.h());
                    if (contains || (b2 = bj.b(next.f())) == null || (indexOf = arrayList.indexOf(b2)) == -1) {
                        z2 = contains;
                    } else {
                        arrayList.set(indexOf, next.h());
                    }
                    if (z2) {
                    }
                } else {
                    boolean z3 = false;
                    if (next.f7895l == 0 || next.f7895l == 1) {
                        if (b5.contains(next.e()) || b5.contains(next.h())) {
                            z3 = true;
                        }
                        if (z3 || (b3 = bj.b(next.f())) == null || (indexOf2 = b5.indexOf(b3)) == -1) {
                            z2 = z3;
                        } else {
                            b5.set(indexOf2, next.h());
                        }
                        if (z2) {
                        }
                    } else if (next.f7895l == 3 && next.g() != 0) {
                        if (b5.contains(next.e()) || b5.contains(next.h())) {
                            z3 = true;
                        }
                        if (z3 || (b4 = bj.b(next.f())) == null || (indexOf3 = b5.indexOf(b4)) == -1) {
                            z2 = z3;
                        } else {
                            b5.set(indexOf3, next.h());
                        }
                        if (z2) {
                        }
                    }
                }
                this.f7859b.b(next);
            }
        }
        Iterator it3 = arrayList.iterator();
        while (it3.hasNext()) {
            String str = (String) it3.next();
            if (!a(str, a3) && (a2 = a(str)) != null) {
                this.f7859b.a(a2);
            }
        }
        am a4 = am.a(this.f7858a);
        if (a4 != null) {
            a4.b();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003b, code lost:
        r3 = r3.getName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void a(java.util.ArrayList<java.lang.String> r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.content.Context r1 = r6.f7858a
            java.lang.String r1 = com.amap.api.mapcore.util.dl.b((android.content.Context) r1)
            r0.append(r1)
            r0.append(r8)
            java.io.File r8 = new java.io.File
            java.lang.String r0 = r0.toString()
            r8.<init>(r0)
            boolean r0 = r8.exists()
            if (r0 != 0) goto L_0x0021
            return
        L_0x0021:
            java.io.File[] r8 = r8.listFiles()
            if (r8 != 0) goto L_0x0028
            return
        L_0x0028:
            int r0 = r8.length
            r1 = 0
            r2 = 0
        L_0x002b:
            if (r2 >= r0) goto L_0x005d
            r3 = r8[r2]
            java.lang.String r4 = r3.getName()
            java.lang.String r5 = ".dat"
            boolean r4 = r4.endsWith(r5)
            if (r4 == 0) goto L_0x005a
            java.lang.String r3 = r3.getName()
            r4 = 46
            int r4 = r3.lastIndexOf(r4)
            if (r4 < 0) goto L_0x005a
            int r5 = r3.length()
            if (r4 >= r5) goto L_0x005a
            java.lang.String r3 = r3.substring(r1, r4)
            boolean r4 = r7.contains(r3)
            if (r4 != 0) goto L_0x005a
            r7.add(r3)
        L_0x005a:
            int r2 = r2 + 1
            goto L_0x002b
        L_0x005d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ap.a(java.util.ArrayList, java.lang.String):void");
    }

    private static boolean a(String str, ArrayList<aw> arrayList) {
        Iterator<aw> it2 = arrayList.iterator();
        while (it2.hasNext()) {
            if (str.equals(it2.next().h())) {
                return true;
            }
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x003d, code lost:
        r5 = r5.getName();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.ArrayList<java.lang.String> b() {
        /*
            r8 = this;
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.Context r2 = r8.f7858a
            java.lang.String r2 = com.amap.api.mapcore.util.dl.c((android.content.Context) r2)
            r1.append(r2)
            java.io.File r2 = new java.io.File
            java.lang.String r1 = r1.toString()
            r2.<init>(r1)
            boolean r1 = r2.exists()
            if (r1 != 0) goto L_0x0023
            return r0
        L_0x0023:
            java.io.File[] r1 = r2.listFiles()
            if (r1 != 0) goto L_0x002a
            return r0
        L_0x002a:
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x002d:
            if (r4 >= r2) goto L_0x0059
            r5 = r1[r4]
            java.lang.String r6 = r5.getName()
            java.lang.String r7 = ".zip"
            boolean r6 = r6.endsWith(r7)
            if (r6 == 0) goto L_0x0056
            java.lang.String r5 = r5.getName()
            r6 = 46
            int r6 = r5.lastIndexOf(r6)
            if (r6 < 0) goto L_0x0056
            int r7 = r5.length()
            if (r6 >= r7) goto L_0x0056
            java.lang.String r5 = r5.substring(r3, r6)
            r0.add(r5)
        L_0x0056:
            int r4 = r4 + 1
            goto L_0x002d
        L_0x0059:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ap.b():java.util.ArrayList");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0086, code lost:
        if (r10 != false) goto L_0x008a;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void b(java.util.ArrayList<java.lang.String> r14, java.lang.String r15) {
        /*
            r13 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            android.content.Context r1 = r13.f7858a
            java.lang.String r1 = com.amap.api.mapcore.util.dl.a((android.content.Context) r1)
            r0.append(r1)
            r0.append(r15)
            java.io.File r15 = new java.io.File
            java.lang.String r0 = r0.toString()
            r15.<init>(r0)
            boolean r0 = r15.exists()
            if (r0 != 0) goto L_0x0021
            return
        L_0x0021:
            java.io.File[] r15 = r15.listFiles()
            if (r15 != 0) goto L_0x0028
            return
        L_0x0028:
            int r0 = r15.length
            r1 = 0
            r2 = 0
        L_0x002b:
            if (r2 >= r0) goto L_0x0092
            r3 = r15[r2]
            boolean r4 = r3.isDirectory()
            if (r4 == 0) goto L_0x008f
            java.lang.String r4 = r3.getName()
            boolean r5 = android.text.TextUtils.isEmpty(r4)
            if (r5 != 0) goto L_0x008f
            java.lang.String[] r3 = r3.list()
            if (r3 == 0) goto L_0x008f
            int r5 = r3.length
            if (r5 <= 0) goto L_0x008f
            boolean r5 = r14.contains(r4)
            if (r5 != 0) goto L_0x008f
            java.lang.String r5 = "a0"
            boolean r5 = r4.equals(r5)
            java.lang.String r6 = "m1.ans"
            r7 = 1
            if (r5 == 0) goto L_0x0069
            int r5 = r3.length
            r8 = 0
        L_0x005b:
            if (r8 >= r5) goto L_0x0089
            r9 = r3[r8]
            boolean r9 = r6.equals(r9)
            if (r9 == 0) goto L_0x0066
            goto L_0x008a
        L_0x0066:
            int r8 = r8 + 1
            goto L_0x005b
        L_0x0069:
            int r5 = r3.length
            r8 = 0
            r9 = 0
            r10 = 0
        L_0x006d:
            if (r8 >= r5) goto L_0x0084
            r11 = r3[r8]
            boolean r12 = r6.equals(r11)
            if (r12 == 0) goto L_0x0078
            r9 = 1
        L_0x0078:
            java.lang.String r12 = "m3.ans"
            boolean r11 = r12.equals(r11)
            if (r11 == 0) goto L_0x0081
            r10 = 1
        L_0x0081:
            int r8 = r8 + 1
            goto L_0x006d
        L_0x0084:
            if (r9 == 0) goto L_0x0089
            if (r10 == 0) goto L_0x0089
            goto L_0x008a
        L_0x0089:
            r7 = 0
        L_0x008a:
            if (r7 == 0) goto L_0x008f
            r14.add(r4)
        L_0x008f:
            int r2 = r2 + 1
            goto L_0x002b
        L_0x0092:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ap.b(java.util.ArrayList, java.lang.String):void");
    }

    public final void run() {
        try {
            a();
        } catch (Throwable th) {
            th.printStackTrace();
        }
    }
}
