package id;

import com.huawei.android.multiscreen.dlna.sdk.dms.ShareOperationFlagEnum;
import com.huawei.android.multiscreen.dlna.sdk.dms.ShareStateEnum;
import com.huawei.android.multiscreen.dlna.sdk.jni.DlnaDmsShareDir;
import java.util.ArrayList;
import java.util.List;

public class a {

    /* renamed from: a  reason: collision with root package name */
    private final List<DlnaDmsShareDir> f13520a = new ArrayList();

    /* renamed from: b  reason: collision with root package name */
    private b f13521b = new b();

    private synchronized void a(List<DlnaDmsShareDir> list, DlnaDmsShareDir dlnaDmsShareDir) {
        int i2 = 0;
        while (i2 < list.size()) {
            DlnaDmsShareDir dlnaDmsShareDir2 = list.get(i2);
            if ((String.valueOf(dlnaDmsShareDir2.j()) + '/').startsWith(String.valueOf(dlnaDmsShareDir.j()) + '/') && dlnaDmsShareDir2.a() == dlnaDmsShareDir.a()) {
                list.remove(i2);
                i2--;
            }
            i2++;
        }
    }

    public synchronized void a() {
        c().clear();
    }

    public synchronized void a(DlnaDmsShareDir dlnaDmsShareDir, ShareOperationFlagEnum shareOperationFlagEnum) {
        if (dlnaDmsShareDir != null) {
            dlnaDmsShareDir.b(ShareStateEnum.ALL_SHARE_FLAG.a());
            dlnaDmsShareDir.a(shareOperationFlagEnum.a());
            a(this.f13520a, dlnaDmsShareDir);
            this.f13520a.add(dlnaDmsShareDir);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0043, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void a(com.huawei.android.multiscreen.dlna.sdk.jni.a r8, com.huawei.android.multiscreen.dlna.sdk.dms.ShareOperationFlagEnum r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            if (r8 != 0) goto L_0x0005
            monitor-exit(r7)
            return
        L_0x0005:
            java.lang.String r0 = r8.k()     // Catch:{ all -> 0x009d }
            if (r0 != 0) goto L_0x000d
            monitor-exit(r7)
            return
        L_0x000d:
            r1 = 0
            java.util.List<com.huawei.android.multiscreen.dlna.sdk.jni.DlnaDmsShareDir> r2 = r7.f13520a     // Catch:{ all -> 0x009d }
            java.util.Iterator r2 = r2.iterator()     // Catch:{ all -> 0x009d }
            r3 = 1
        L_0x0015:
            boolean r4 = r2.hasNext()     // Catch:{ all -> 0x009d }
            if (r4 != 0) goto L_0x0044
            if (r1 != 0) goto L_0x0042
            com.huawei.android.multiscreen.dlna.sdk.jni.DlnaDmsShareDir r1 = new com.huawei.android.multiscreen.dlna.sdk.jni.DlnaDmsShareDir     // Catch:{ all -> 0x009d }
            r1.<init>(r0)     // Catch:{ all -> 0x009d }
            com.huawei.android.multiscreen.dlna.sdk.dms.ShareStateEnum r0 = com.huawei.android.multiscreen.dlna.sdk.dms.ShareStateEnum.PART_SHARE_FLAG     // Catch:{ all -> 0x009d }
            int r0 = r0.a()     // Catch:{ all -> 0x009d }
            r1.b(r0)     // Catch:{ all -> 0x009d }
            int r9 = r9.a()     // Catch:{ all -> 0x009d }
            r1.a((int) r9)     // Catch:{ all -> 0x009d }
            java.util.concurrent.ConcurrentHashMap r9 = r1.c()     // Catch:{ all -> 0x009d }
            java.lang.String r0 = r8.i()     // Catch:{ all -> 0x009d }
            r9.put(r0, r8)     // Catch:{ all -> 0x009d }
            java.util.List<com.huawei.android.multiscreen.dlna.sdk.jni.DlnaDmsShareDir> r8 = r7.f13520a     // Catch:{ all -> 0x009d }
            r8.add(r1)     // Catch:{ all -> 0x009d }
        L_0x0042:
            monitor-exit(r7)
            return
        L_0x0044:
            java.lang.Object r4 = r2.next()     // Catch:{ all -> 0x009d }
            com.huawei.android.multiscreen.dlna.sdk.jni.DlnaDmsShareDir r4 = (com.huawei.android.multiscreen.dlna.sdk.jni.DlnaDmsShareDir) r4     // Catch:{ all -> 0x009d }
            java.lang.String r5 = r4.j()     // Catch:{ all -> 0x009d }
            boolean r5 = r5.equals(r0)     // Catch:{ all -> 0x009d }
            if (r5 == 0) goto L_0x0015
            java.util.concurrent.ConcurrentHashMap r5 = r4.c()     // Catch:{ all -> 0x009d }
            java.lang.String r6 = r8.i()     // Catch:{ all -> 0x009d }
            boolean r5 = r5.containsKey(r6)     // Catch:{ all -> 0x009d }
            if (r5 != 0) goto L_0x0079
            int r5 = r4.a()     // Catch:{ all -> 0x009d }
            int r6 = r9.a()     // Catch:{ all -> 0x009d }
            if (r5 != r6) goto L_0x0079
            java.util.concurrent.ConcurrentHashMap r1 = r4.c()     // Catch:{ all -> 0x009d }
            java.lang.String r4 = r8.i()     // Catch:{ all -> 0x009d }
            r1.put(r4, r8)     // Catch:{ all -> 0x009d }
        L_0x0077:
            r1 = 1
            goto L_0x0015
        L_0x0079:
            java.util.concurrent.ConcurrentHashMap r5 = r4.c()     // Catch:{ all -> 0x009d }
            java.lang.String r6 = r8.i()     // Catch:{ all -> 0x009d }
            boolean r5 = r5.containsKey(r6)     // Catch:{ all -> 0x009d }
            if (r5 == 0) goto L_0x0015
            int r5 = r4.a()     // Catch:{ all -> 0x009d }
            int r6 = r9.a()     // Catch:{ all -> 0x009d }
            if (r5 == r6) goto L_0x0015
            java.util.concurrent.ConcurrentHashMap r1 = r4.c()     // Catch:{ all -> 0x009d }
            java.lang.String r4 = r8.i()     // Catch:{ all -> 0x009d }
            r1.remove(r4)     // Catch:{ all -> 0x009d }
            goto L_0x0077
        L_0x009d:
            r8 = move-exception
            monitor-exit(r7)
            goto L_0x00a1
        L_0x00a0:
            throw r8
        L_0x00a1:
            goto L_0x00a0
        */
        throw new UnsupportedOperationException("Method not decompiled: id.a.a(com.huawei.android.multiscreen.dlna.sdk.jni.a, com.huawei.android.multiscreen.dlna.sdk.dms.ShareOperationFlagEnum):void");
    }

    public synchronized void a(String str, ShareOperationFlagEnum shareOperationFlagEnum) {
        com.huawei.android.multiscreen.dlna.sdk.jni.a c2 = this.f13521b.c(str);
        if (c2.d()) {
            a((DlnaDmsShareDir) c2, shareOperationFlagEnum);
        } else {
            a(c2, shareOperationFlagEnum);
        }
    }

    public int b() {
        return this.f13520a.size();
    }

    public List<DlnaDmsShareDir> c() {
        return this.f13520a;
    }

    public synchronized DlnaDmsShareDir[] d() {
        for (DlnaDmsShareDir g2 : c()) {
            g2.g();
        }
        return (DlnaDmsShareDir[]) c().toArray(new DlnaDmsShareDir[this.f13520a.size()]);
    }
}
