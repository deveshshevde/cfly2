package com.google.android.gms.analytics;

import android.content.Context;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.TreeSet;

public class StandardExceptionParser implements ExceptionParser {
    private final TreeSet<String> zza = new TreeSet<>();

    public StandardExceptionParser(Context context, Collection<String> collection) {
        setIncludedPackages(context, collection);
    }

    /* access modifiers changed from: protected */
    public StackTraceElement getBestStackTraceElement(Throwable th) {
        StackTraceElement[] stackTrace = th.getStackTrace();
        if (stackTrace == null || (r0 = stackTrace.length) == 0) {
            return null;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            String className = stackTraceElement.getClassName();
            Iterator<String> it2 = this.zza.iterator();
            while (it2.hasNext()) {
                if (className.startsWith(it2.next())) {
                    return stackTraceElement;
                }
            }
        }
        return stackTrace[0];
    }

    /* access modifiers changed from: protected */
    public Throwable getCause(Throwable th) {
        while (th.getCause() != null) {
            th = th.getCause();
        }
        return th;
    }

    public String getDescription(String str, Throwable th) {
        return getDescription(getCause(th), getBestStackTraceElement(getCause(th)), str);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0020, code lost:
        r3 = r2.length;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String getDescription(java.lang.Throwable r5, java.lang.StackTraceElement r6, java.lang.String r7) {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.Class r5 = r5.getClass()
            java.lang.String r5 = r5.getSimpleName()
            r0.append(r5)
            r5 = 0
            r1 = 1
            if (r6 == 0) goto L_0x0049
            java.lang.String r2 = r6.getClassName()
            java.lang.String r3 = "\\."
            java.lang.String[] r2 = r2.split(r3)
            if (r2 == 0) goto L_0x0028
            int r3 = r2.length
            if (r3 <= 0) goto L_0x0028
            int r3 = r3 + -1
            r2 = r2[r3]
            goto L_0x002a
        L_0x0028:
            java.lang.String r2 = "unknown"
        L_0x002a:
            r3 = 3
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r3[r5] = r2
            java.lang.String r2 = r6.getMethodName()
            r3[r1] = r2
            r2 = 2
            int r6 = r6.getLineNumber()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            r3[r2] = r6
            java.lang.String r6 = " (@%s:%s:%s)"
            java.lang.String r6 = java.lang.String.format(r6, r3)
            r0.append(r6)
        L_0x0049:
            if (r7 == 0) goto L_0x0058
            java.lang.Object[] r6 = new java.lang.Object[r1]
            r6[r5] = r7
            java.lang.String r5 = " {%s}"
            java.lang.String r5 = java.lang.String.format(r5, r6)
            r0.append(r5)
        L_0x0058:
            java.lang.String r5 = r0.toString()
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.analytics.StandardExceptionParser.getDescription(java.lang.Throwable, java.lang.StackTraceElement, java.lang.String):java.lang.String");
    }

    public void setIncludedPackages(Context context, Collection<String> collection) {
        this.zza.clear();
        HashSet<String> hashSet = new HashSet<>();
        if (collection != null) {
            hashSet.addAll(collection);
        }
        if (context != null) {
            hashSet.add(context.getApplicationContext().getPackageName());
        }
        for (String str : hashSet) {
            Iterator<String> it2 = this.zza.iterator();
            boolean z2 = true;
            while (true) {
                if (!it2.hasNext()) {
                    break;
                }
                String next = it2.next();
                if (str.startsWith(next)) {
                    z2 = false;
                } else if (next.startsWith(str)) {
                    this.zza.remove(next);
                }
            }
            if (z2) {
                this.zza.add(str);
            }
        }
    }
}
