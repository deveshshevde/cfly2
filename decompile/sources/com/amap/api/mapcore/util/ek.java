package com.amap.api.mapcore.util;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.HashSet;

public final class ek extends ContextThemeWrapper {

    /* renamed from: d  reason: collision with root package name */
    private static final String[] f8508d = {"android.widget", "android.webkit", "android.app"};

    /* renamed from: a  reason: collision with root package name */
    private Resources f8509a = el.a();

    /* renamed from: b  reason: collision with root package name */
    private LayoutInflater f8510b;

    /* renamed from: c  reason: collision with root package name */
    private ClassLoader f8511c;

    /* renamed from: e  reason: collision with root package name */
    private a f8512e = new a();

    /* renamed from: f  reason: collision with root package name */
    private LayoutInflater.Factory f8513f = new LayoutInflater.Factory() {
        public final View onCreateView(String str, Context context, AttributeSet attributeSet) {
            return ek.this.a(str, context, attributeSet);
        }
    };

    public class a {

        /* renamed from: a  reason: collision with root package name */
        public HashSet<String> f8515a = new HashSet<>();

        /* renamed from: b  reason: collision with root package name */
        public HashMap<String, Constructor<?>> f8516b = new HashMap<>();

        public a() {
        }
    }

    public ek(Context context, int i2, ClassLoader classLoader) {
        super(context, i2);
        this.f8511c = classLoader;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0067  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x006f A[SYNTHETIC, Splitter:B:32:0x006f] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final android.view.View a(java.lang.String r12, android.content.Context r13, android.util.AttributeSet r14) {
        /*
            r11 = this;
            com.amap.api.mapcore.util.ek$a r0 = r11.f8512e
            java.util.HashSet<java.lang.String> r0 = r0.f8515a
            boolean r0 = r0.contains(r12)
            r1 = 0
            if (r0 == 0) goto L_0x000c
            return r1
        L_0x000c:
            com.amap.api.mapcore.util.ek$a r0 = r11.f8512e
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor<?>> r0 = r0.f8516b
            java.lang.Object r0 = r0.get(r12)
            java.lang.reflect.Constructor r0 = (java.lang.reflect.Constructor) r0
            r2 = 2
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x0086
            java.lang.String r5 = "api.navi"
            boolean r5 = r12.contains(r5)     // Catch:{ all -> 0x0063 }
            if (r5 == 0) goto L_0x002a
            java.lang.ClassLoader r5 = r11.f8511c     // Catch:{ all -> 0x0063 }
            java.lang.Class r5 = r5.loadClass(r12)     // Catch:{ all -> 0x0063 }
            goto L_0x0051
        L_0x002a:
            java.lang.String[] r5 = f8508d     // Catch:{ all -> 0x0063 }
            int r6 = r5.length     // Catch:{ all -> 0x0063 }
            r7 = 0
        L_0x002e:
            if (r7 >= r6) goto L_0x0050
            r8 = r5[r7]     // Catch:{ all -> 0x0063 }
            java.lang.ClassLoader r9 = r11.f8511c     // Catch:{ all -> 0x004d }
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x004d }
            r10.<init>()     // Catch:{ all -> 0x004d }
            r10.append(r8)     // Catch:{ all -> 0x004d }
            java.lang.String r8 = "."
            r10.append(r8)     // Catch:{ all -> 0x004d }
            r10.append(r12)     // Catch:{ all -> 0x004d }
            java.lang.String r8 = r10.toString()     // Catch:{ all -> 0x004d }
            java.lang.Class r5 = r9.loadClass(r8)     // Catch:{ all -> 0x004d }
            goto L_0x0051
        L_0x004d:
            int r7 = r7 + 1
            goto L_0x002e
        L_0x0050:
            r5 = r1
        L_0x0051:
            if (r5 != 0) goto L_0x0054
            goto L_0x0064
        L_0x0054:
            java.lang.Class<android.view.ViewStub> r6 = android.view.ViewStub.class
            if (r5 == r6) goto L_0x0064
            java.lang.ClassLoader r6 = r5.getClassLoader()     // Catch:{ all -> 0x0064 }
            java.lang.ClassLoader r7 = r11.f8511c     // Catch:{ all -> 0x0064 }
            if (r6 == r7) goto L_0x0061
            goto L_0x0064
        L_0x0061:
            r6 = 1
            goto L_0x0065
        L_0x0063:
            r5 = r1
        L_0x0064:
            r6 = 0
        L_0x0065:
            if (r6 != 0) goto L_0x006f
            com.amap.api.mapcore.util.ek$a r13 = r11.f8512e
            java.util.HashSet<java.lang.String> r13 = r13.f8515a
            r13.add(r12)
            return r1
        L_0x006f:
            java.lang.Class[] r6 = new java.lang.Class[r2]     // Catch:{ all -> 0x0085 }
            java.lang.Class<android.content.Context> r7 = android.content.Context.class
            r6[r4] = r7     // Catch:{ all -> 0x0085 }
            java.lang.Class<android.util.AttributeSet> r7 = android.util.AttributeSet.class
            r6[r3] = r7     // Catch:{ all -> 0x0085 }
            java.lang.reflect.Constructor r0 = r5.getConstructor(r6)     // Catch:{ all -> 0x0085 }
            com.amap.api.mapcore.util.ek$a r5 = r11.f8512e     // Catch:{ all -> 0x0085 }
            java.util.HashMap<java.lang.String, java.lang.reflect.Constructor<?>> r5 = r5.f8516b     // Catch:{ all -> 0x0085 }
            r5.put(r12, r0)     // Catch:{ all -> 0x0085 }
            goto L_0x0086
        L_0x0085:
        L_0x0086:
            if (r0 == 0) goto L_0x0096
            java.lang.Object[] r12 = new java.lang.Object[r2]     // Catch:{ all -> 0x0096 }
            r12[r4] = r13     // Catch:{ all -> 0x0096 }
            r12[r3] = r14     // Catch:{ all -> 0x0096 }
            java.lang.Object r12 = r0.newInstance(r12)     // Catch:{ all -> 0x0096 }
            android.view.View r12 = (android.view.View) r12     // Catch:{ all -> 0x0096 }
            r1 = r12
        L_0x0096:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.amap.api.mapcore.util.ek.a(java.lang.String, android.content.Context, android.util.AttributeSet):android.view.View");
    }

    public final Resources getResources() {
        Resources resources = this.f8509a;
        return resources != null ? resources : super.getResources();
    }

    public final Object getSystemService(String str) {
        if (!"layout_inflater".equals(str)) {
            return super.getSystemService(str);
        }
        if (this.f8510b == null) {
            LayoutInflater layoutInflater = (LayoutInflater) super.getSystemService(str);
            if (layoutInflater != null) {
                this.f8510b = layoutInflater.cloneInContext(this);
            }
            this.f8510b.setFactory(this.f8513f);
            this.f8510b = this.f8510b.cloneInContext(this);
        }
        return this.f8510b;
    }
}
