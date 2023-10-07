package androidx.appcompat.widget;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.database.DataSetObservable;
import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import android.util.Xml;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

class c extends DataSetObservable {

    /* renamed from: a  reason: collision with root package name */
    static final String f1454a = "c";

    /* renamed from: e  reason: collision with root package name */
    private static final Object f1455e = new Object();

    /* renamed from: f  reason: collision with root package name */
    private static final Map<String, c> f1456f = new HashMap();

    /* renamed from: b  reason: collision with root package name */
    final Context f1457b;

    /* renamed from: c  reason: collision with root package name */
    final String f1458c;

    /* renamed from: d  reason: collision with root package name */
    boolean f1459d;

    /* renamed from: g  reason: collision with root package name */
    private final Object f1460g;

    /* renamed from: h  reason: collision with root package name */
    private final List<a> f1461h;

    /* renamed from: i  reason: collision with root package name */
    private final List<C0019c> f1462i;

    /* renamed from: j  reason: collision with root package name */
    private Intent f1463j;

    /* renamed from: k  reason: collision with root package name */
    private b f1464k;

    /* renamed from: l  reason: collision with root package name */
    private int f1465l;

    /* renamed from: m  reason: collision with root package name */
    private boolean f1466m;

    /* renamed from: n  reason: collision with root package name */
    private boolean f1467n;

    /* renamed from: o  reason: collision with root package name */
    private boolean f1468o;

    /* renamed from: p  reason: collision with root package name */
    private d f1469p;

    public static final class a implements Comparable<a> {

        /* renamed from: a  reason: collision with root package name */
        public final ResolveInfo f1470a;

        /* renamed from: b  reason: collision with root package name */
        public float f1471b;

        public a(ResolveInfo resolveInfo) {
            this.f1470a = resolveInfo;
        }

        /* renamed from: a */
        public int compareTo(a aVar) {
            return Float.floatToIntBits(aVar.f1471b) - Float.floatToIntBits(this.f1471b);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            return obj != null && getClass() == obj.getClass() && Float.floatToIntBits(this.f1471b) == Float.floatToIntBits(((a) obj).f1471b);
        }

        public int hashCode() {
            return Float.floatToIntBits(this.f1471b) + 31;
        }

        public String toString() {
            return "[" + "resolveInfo:" + this.f1470a.toString() + "; weight:" + new BigDecimal((double) this.f1471b) + "]";
        }
    }

    public interface b {
        void a(Intent intent, List<a> list, List<C0019c> list2);
    }

    /* renamed from: androidx.appcompat.widget.c$c  reason: collision with other inner class name */
    public static final class C0019c {

        /* renamed from: a  reason: collision with root package name */
        public final ComponentName f1472a;

        /* renamed from: b  reason: collision with root package name */
        public final long f1473b;

        /* renamed from: c  reason: collision with root package name */
        public final float f1474c;

        public C0019c(ComponentName componentName, long j2, float f2) {
            this.f1472a = componentName;
            this.f1473b = j2;
            this.f1474c = f2;
        }

        public C0019c(String str, long j2, float f2) {
            this(ComponentName.unflattenFromString(str), j2, f2);
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C0019c cVar = (C0019c) obj;
            ComponentName componentName = this.f1472a;
            if (componentName == null) {
                if (cVar.f1472a != null) {
                    return false;
                }
            } else if (!componentName.equals(cVar.f1472a)) {
                return false;
            }
            return this.f1473b == cVar.f1473b && Float.floatToIntBits(this.f1474c) == Float.floatToIntBits(cVar.f1474c);
        }

        public int hashCode() {
            ComponentName componentName = this.f1472a;
            int hashCode = componentName == null ? 0 : componentName.hashCode();
            long j2 = this.f1473b;
            return ((((hashCode + 31) * 31) + ((int) (j2 ^ (j2 >>> 32)))) * 31) + Float.floatToIntBits(this.f1474c);
        }

        public String toString() {
            return "[" + "; activity:" + this.f1472a + "; time:" + this.f1473b + "; weight:" + new BigDecimal((double) this.f1474c) + "]";
        }
    }

    public interface d {
        boolean a(c cVar, Intent intent);
    }

    private final class e extends AsyncTask<Object, Void, Void> {
        e() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:10:0x006d, code lost:
            if (r15 != null) goto L_0x006f;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:12:?, code lost:
            r15.close();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0092, code lost:
            if (r15 == null) goto L_0x00d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:23:0x00b2, code lost:
            if (r15 == null) goto L_0x00d5;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:28:0x00d2, code lost:
            if (r15 == null) goto L_0x00d5;
         */
        /* renamed from: a */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.Void doInBackground(java.lang.Object... r15) {
            /*
                r14 = this;
                java.lang.String r0 = "historical-record"
                java.lang.String r1 = "historical-records"
                java.lang.String r2 = "Error writing historical record file: "
                r3 = 0
                r4 = r15[r3]
                java.util.List r4 = (java.util.List) r4
                r5 = 1
                r15 = r15[r5]
                java.lang.String r15 = (java.lang.String) r15
                r6 = 0
                androidx.appcompat.widget.c r7 = androidx.appcompat.widget.c.this     // Catch:{ FileNotFoundException -> 0x00e0 }
                android.content.Context r7 = r7.f1457b     // Catch:{ FileNotFoundException -> 0x00e0 }
                java.io.FileOutputStream r15 = r7.openFileOutput(r15, r3)     // Catch:{ FileNotFoundException -> 0x00e0 }
                org.xmlpull.v1.XmlSerializer r7 = android.util.Xml.newSerializer()
                r7.setOutput(r15, r6)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r8 = "UTF-8"
                java.lang.Boolean r9 = java.lang.Boolean.valueOf(r5)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.startDocument(r8, r9)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.startTag(r6, r1)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                int r8 = r4.size()     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r9 = 0
            L_0x0031:
                if (r9 >= r8) goto L_0x0063
                java.lang.Object r10 = r4.remove(r3)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                androidx.appcompat.widget.c$c r10 = (androidx.appcompat.widget.c.C0019c) r10     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.startTag(r6, r0)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r11 = "activity"
                android.content.ComponentName r12 = r10.f1472a     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r12 = r12.flattenToString()     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.attribute(r6, r11, r12)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r11 = "time"
                long r12 = r10.f1473b     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r12 = java.lang.String.valueOf(r12)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.attribute(r6, r11, r12)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r11 = "weight"
                float r10 = r10.f1474c     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                java.lang.String r10 = java.lang.String.valueOf(r10)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.attribute(r6, r11, r10)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.endTag(r6, r0)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                int r9 = r9 + 1
                goto L_0x0031
            L_0x0063:
                r7.endTag(r6, r1)     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                r7.endDocument()     // Catch:{ IllegalArgumentException -> 0x00b5, IllegalStateException -> 0x0095, IOException -> 0x0075 }
                androidx.appcompat.widget.c r0 = androidx.appcompat.widget.c.this
                r0.f1459d = r5
                if (r15 == 0) goto L_0x00d5
            L_0x006f:
                r15.close()     // Catch:{ IOException -> 0x00d5 }
                goto L_0x00d5
            L_0x0073:
                r0 = move-exception
                goto L_0x00d6
            L_0x0075:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.c.f1454a     // Catch:{ all -> 0x0073 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
                r3.<init>()     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.c r2 = androidx.appcompat.widget.c.this     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r2.f1458c     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0073 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.c r0 = androidx.appcompat.widget.c.this
                r0.f1459d = r5
                if (r15 == 0) goto L_0x00d5
                goto L_0x006f
            L_0x0095:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.c.f1454a     // Catch:{ all -> 0x0073 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
                r3.<init>()     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.c r2 = androidx.appcompat.widget.c.this     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r2.f1458c     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0073 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.c r0 = androidx.appcompat.widget.c.this
                r0.f1459d = r5
                if (r15 == 0) goto L_0x00d5
                goto L_0x006f
            L_0x00b5:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.c.f1454a     // Catch:{ all -> 0x0073 }
                java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0073 }
                r3.<init>()     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.c r2 = androidx.appcompat.widget.c.this     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r2.f1458c     // Catch:{ all -> 0x0073 }
                r3.append(r2)     // Catch:{ all -> 0x0073 }
                java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x0073 }
                android.util.Log.e(r1, r2, r0)     // Catch:{ all -> 0x0073 }
                androidx.appcompat.widget.c r0 = androidx.appcompat.widget.c.this
                r0.f1459d = r5
                if (r15 == 0) goto L_0x00d5
                goto L_0x006f
            L_0x00d5:
                return r6
            L_0x00d6:
                androidx.appcompat.widget.c r1 = androidx.appcompat.widget.c.this
                r1.f1459d = r5
                if (r15 == 0) goto L_0x00df
                r15.close()     // Catch:{ IOException -> 0x00df }
            L_0x00df:
                throw r0
            L_0x00e0:
                r0 = move-exception
                java.lang.String r1 = androidx.appcompat.widget.c.f1454a
                java.lang.StringBuilder r3 = new java.lang.StringBuilder
                r3.<init>()
                r3.append(r2)
                r3.append(r15)
                java.lang.String r15 = r3.toString()
                android.util.Log.e(r1, r15, r0)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.c.e.doInBackground(java.lang.Object[]):java.lang.Void");
        }
    }

    private boolean a(C0019c cVar) {
        boolean add = this.f1462i.add(cVar);
        if (add) {
            this.f1467n = true;
            i();
            d();
            f();
            notifyChanged();
        }
        return add;
    }

    private void d() {
        if (!this.f1466m) {
            throw new IllegalStateException("No preceding call to #readHistoricalData");
        } else if (this.f1467n) {
            this.f1467n = false;
            if (!TextUtils.isEmpty(this.f1458c)) {
                new e().executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, new Object[]{new ArrayList(this.f1462i), this.f1458c});
            }
        }
    }

    private void e() {
        boolean g2 = g() | h();
        i();
        if (g2) {
            f();
            notifyChanged();
        }
    }

    private boolean f() {
        if (this.f1464k == null || this.f1463j == null || this.f1461h.isEmpty() || this.f1462i.isEmpty()) {
            return false;
        }
        this.f1464k.a(this.f1463j, this.f1461h, Collections.unmodifiableList(this.f1462i));
        return true;
    }

    private boolean g() {
        if (!this.f1468o || this.f1463j == null) {
            return false;
        }
        this.f1468o = false;
        this.f1461h.clear();
        List<ResolveInfo> queryIntentActivities = this.f1457b.getPackageManager().queryIntentActivities(this.f1463j, 0);
        int size = queryIntentActivities.size();
        for (int i2 = 0; i2 < size; i2++) {
            this.f1461h.add(new a(queryIntentActivities.get(i2)));
        }
        return true;
    }

    private boolean h() {
        if (!this.f1459d || !this.f1467n || TextUtils.isEmpty(this.f1458c)) {
            return false;
        }
        this.f1459d = false;
        this.f1466m = true;
        j();
        return true;
    }

    private void i() {
        int size = this.f1462i.size() - this.f1465l;
        if (size > 0) {
            this.f1467n = true;
            for (int i2 = 0; i2 < size; i2++) {
                C0019c remove = this.f1462i.remove(0);
            }
        }
    }

    private void j() {
        try {
            FileInputStream openFileInput = this.f1457b.openFileInput(this.f1458c);
            try {
                XmlPullParser newPullParser = Xml.newPullParser();
                newPullParser.setInput(openFileInput, "UTF-8");
                int i2 = 0;
                while (i2 != 1 && i2 != 2) {
                    i2 = newPullParser.next();
                }
                if ("historical-records".equals(newPullParser.getName())) {
                    List<C0019c> list = this.f1462i;
                    list.clear();
                    while (true) {
                        int next = newPullParser.next();
                        if (next == 1) {
                            if (openFileInput == null) {
                                return;
                            }
                        } else if (!(next == 3 || next == 4)) {
                            if ("historical-record".equals(newPullParser.getName())) {
                                list.add(new C0019c(newPullParser.getAttributeValue((String) null, "activity"), Long.parseLong(newPullParser.getAttributeValue((String) null, "time")), Float.parseFloat(newPullParser.getAttributeValue((String) null, "weight"))));
                            } else {
                                throw new XmlPullParserException("Share records file not well-formed.");
                            }
                        }
                    }
                    try {
                        openFileInput.close();
                    } catch (IOException unused) {
                    }
                } else {
                    throw new XmlPullParserException("Share records file does not start with historical-records tag.");
                }
            } catch (XmlPullParserException e2) {
                String str = f1454a;
                Log.e(str, "Error reading historical recrod file: " + this.f1458c, e2);
                if (openFileInput == null) {
                }
            } catch (IOException e3) {
                String str2 = f1454a;
                Log.e(str2, "Error reading historical recrod file: " + this.f1458c, e3);
                if (openFileInput == null) {
                }
            } catch (Throwable th) {
                if (openFileInput != null) {
                    try {
                        openFileInput.close();
                    } catch (IOException unused2) {
                    }
                }
                throw th;
            }
        } catch (FileNotFoundException unused3) {
        }
    }

    public int a() {
        int size;
        synchronized (this.f1460g) {
            e();
            size = this.f1461h.size();
        }
        return size;
    }

    public int a(ResolveInfo resolveInfo) {
        synchronized (this.f1460g) {
            e();
            List<a> list = this.f1461h;
            int size = list.size();
            for (int i2 = 0; i2 < size; i2++) {
                if (list.get(i2).f1470a == resolveInfo) {
                    return i2;
                }
            }
            return -1;
        }
    }

    public ResolveInfo a(int i2) {
        ResolveInfo resolveInfo;
        synchronized (this.f1460g) {
            e();
            resolveInfo = this.f1461h.get(i2).f1470a;
        }
        return resolveInfo;
    }

    public Intent b(int i2) {
        synchronized (this.f1460g) {
            if (this.f1463j == null) {
                return null;
            }
            e();
            a aVar = this.f1461h.get(i2);
            ComponentName componentName = new ComponentName(aVar.f1470a.activityInfo.packageName, aVar.f1470a.activityInfo.name);
            Intent intent = new Intent(this.f1463j);
            intent.setComponent(componentName);
            if (this.f1469p != null) {
                if (this.f1469p.a(this, new Intent(intent))) {
                    return null;
                }
            }
            a(new C0019c(componentName, System.currentTimeMillis(), 1.0f));
            return intent;
        }
    }

    public ResolveInfo b() {
        synchronized (this.f1460g) {
            e();
            if (this.f1461h.isEmpty()) {
                return null;
            }
            ResolveInfo resolveInfo = this.f1461h.get(0).f1470a;
            return resolveInfo;
        }
    }

    public int c() {
        int size;
        synchronized (this.f1460g) {
            e();
            size = this.f1462i.size();
        }
        return size;
    }

    public void c(int i2) {
        synchronized (this.f1460g) {
            e();
            a aVar = this.f1461h.get(i2);
            a aVar2 = this.f1461h.get(0);
            a(new C0019c(new ComponentName(aVar.f1470a.activityInfo.packageName, aVar.f1470a.activityInfo.name), System.currentTimeMillis(), aVar2 != null ? (aVar2.f1471b - aVar.f1471b) + 5.0f : 1.0f));
        }
    }
}
