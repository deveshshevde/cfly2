package hw;

import android.text.format.DateUtils;

public class a {
    /* JADX WARNING: Removed duplicated region for block: B:13:0x001f  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long a(java.lang.String r4) {
        /*
            r0 = 0
            android.media.MediaMetadataRetriever r1 = new android.media.MediaMetadataRetriever     // Catch:{ Exception -> 0x0023, all -> 0x001c }
            r1.<init>()     // Catch:{ Exception -> 0x0023, all -> 0x001c }
            r1.setDataSource(r4)     // Catch:{ Exception -> 0x001a, all -> 0x0017 }
            r4 = 9
            java.lang.String r4 = r1.extractMetadata(r4)     // Catch:{ Exception -> 0x001a, all -> 0x0017 }
            long r2 = java.lang.Long.parseLong(r4)     // Catch:{ Exception -> 0x001a, all -> 0x0017 }
            r1.release()
            return r2
        L_0x0017:
            r4 = move-exception
            r0 = r1
            goto L_0x001d
        L_0x001a:
            r0 = r1
            goto L_0x0024
        L_0x001c:
            r4 = move-exception
        L_0x001d:
            if (r0 == 0) goto L_0x0022
            r0.release()
        L_0x0022:
            throw r4
        L_0x0023:
        L_0x0024:
            if (r0 == 0) goto L_0x0029
            r0.release()
        L_0x0029:
            r0 = 0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: hw.a.a(java.lang.String):long");
    }

    public static String a(long j2) {
        long j3 = j2 / 1000;
        if (j3 == 0) {
            j3++;
        }
        return DateUtils.formatElapsedTime(j3);
    }
}
