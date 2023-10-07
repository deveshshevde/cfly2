package com.xeagle.android.helpers;

import android.content.Context;
import com.google.android.gms.maps.model.Tile;
import com.google.android.gms.maps.model.h;
import java.util.Locale;
import kx.g;

public class LocalMapTileProvider implements h {
    private static final int BUFFER_SIZE = 16384;
    private static final int TILE_HEIGHT = 256;
    private static final int TILE_WIDTH = 256;
    private Context context;

    public LocalMapTileProvider(Context context2) {
        this.context = context2;
        tryToAddANoMediaFile();
    }

    private String getTileFilename(int i2, int i3, int i4) {
        return String.format(Locale.US, "%d/%d/%d.jpg", new Object[]{Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)});
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(9:6|7|(2:8|(1:10)(1:77))|11|12|13|14|15|16) */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:14:0x003e */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x005d A[SYNTHETIC, Splitter:B:36:0x005d] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0064 A[SYNTHETIC, Splitter:B:40:0x0064] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x006c A[SYNTHETIC, Splitter:B:47:0x006c] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0073 A[SYNTHETIC, Splitter:B:51:0x0073] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x007b A[SYNTHETIC, Splitter:B:58:0x007b] */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0082 A[SYNTHETIC, Splitter:B:62:0x0082] */
    /* JADX WARNING: Removed duplicated region for block: B:69:0x008a A[SYNTHETIC, Splitter:B:69:0x008a] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0091 A[SYNTHETIC, Splitter:B:73:0x0091] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private byte[] readTileImage(int r6, int r7, int r8) {
        /*
            r5 = this;
            r0 = 0
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x0077, OutOfMemoryError -> 0x0055, all -> 0x0052 }
            r1.<init>()     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x0077, OutOfMemoryError -> 0x0055, all -> 0x0052 }
            android.content.Context r2 = r5.context     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x0077, OutOfMemoryError -> 0x0055, all -> 0x0052 }
            java.lang.String r2 = kx.d.v(r2)     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x0077, OutOfMemoryError -> 0x0055, all -> 0x0052 }
            r1.append(r2)     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x0077, OutOfMemoryError -> 0x0055, all -> 0x0052 }
            java.lang.String r6 = r5.getTileFilename(r6, r7, r8)     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x0077, OutOfMemoryError -> 0x0055, all -> 0x0052 }
            r1.append(r6)     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x0077, OutOfMemoryError -> 0x0055, all -> 0x0052 }
            java.lang.String r6 = r1.toString()     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x0077, OutOfMemoryError -> 0x0055, all -> 0x0052 }
            java.io.FileInputStream r7 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x0077, OutOfMemoryError -> 0x0055, all -> 0x0052 }
            r7.<init>(r6)     // Catch:{ FileNotFoundException -> 0x0086, IOException -> 0x0077, OutOfMemoryError -> 0x0055, all -> 0x0052 }
            java.io.ByteArrayOutputStream r6 = new java.io.ByteArrayOutputStream     // Catch:{ FileNotFoundException -> 0x0050, IOException -> 0x004e, OutOfMemoryError -> 0x004b, all -> 0x0048 }
            r6.<init>()     // Catch:{ FileNotFoundException -> 0x0050, IOException -> 0x004e, OutOfMemoryError -> 0x004b, all -> 0x0048 }
            r8 = 16384(0x4000, float:2.2959E-41)
            byte[] r1 = new byte[r8]     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044, OutOfMemoryError -> 0x0042 }
        L_0x0028:
            r2 = 0
            int r3 = r7.read(r1, r2, r8)     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044, OutOfMemoryError -> 0x0042 }
            r4 = -1
            if (r3 == r4) goto L_0x0034
            r6.write(r1, r2, r3)     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044, OutOfMemoryError -> 0x0042 }
            goto L_0x0028
        L_0x0034:
            r6.flush()     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044, OutOfMemoryError -> 0x0042 }
            byte[] r8 = r6.toByteArray()     // Catch:{ FileNotFoundException -> 0x0046, IOException -> 0x0044, OutOfMemoryError -> 0x0042 }
            r7.close()     // Catch:{ Exception -> 0x003e }
        L_0x003e:
            r6.close()     // Catch:{ Exception -> 0x0041 }
        L_0x0041:
            return r8
        L_0x0042:
            r8 = move-exception
            goto L_0x0058
        L_0x0044:
            goto L_0x0079
        L_0x0046:
            goto L_0x0088
        L_0x0048:
            r8 = move-exception
            r6 = r0
            goto L_0x0069
        L_0x004b:
            r8 = move-exception
            r6 = r0
            goto L_0x0058
        L_0x004e:
            r6 = r0
            goto L_0x0079
        L_0x0050:
            r6 = r0
            goto L_0x0088
        L_0x0052:
            r8 = move-exception
            r6 = r0
            goto L_0x006a
        L_0x0055:
            r8 = move-exception
            r6 = r0
            r7 = r6
        L_0x0058:
            r8.printStackTrace()     // Catch:{ all -> 0x0068 }
            if (r7 == 0) goto L_0x0062
            r7.close()     // Catch:{ Exception -> 0x0061 }
            goto L_0x0062
        L_0x0061:
        L_0x0062:
            if (r6 == 0) goto L_0x0067
            r6.close()     // Catch:{ Exception -> 0x0067 }
        L_0x0067:
            return r0
        L_0x0068:
            r8 = move-exception
        L_0x0069:
            r0 = r7
        L_0x006a:
            if (r0 == 0) goto L_0x0071
            r0.close()     // Catch:{ Exception -> 0x0070 }
            goto L_0x0071
        L_0x0070:
        L_0x0071:
            if (r6 == 0) goto L_0x0076
            r6.close()     // Catch:{ Exception -> 0x0076 }
        L_0x0076:
            throw r8
        L_0x0077:
            r6 = r0
            r7 = r6
        L_0x0079:
            if (r7 == 0) goto L_0x0080
            r7.close()     // Catch:{ Exception -> 0x007f }
            goto L_0x0080
        L_0x007f:
        L_0x0080:
            if (r6 == 0) goto L_0x0085
            r6.close()     // Catch:{ Exception -> 0x0085 }
        L_0x0085:
            return r0
        L_0x0086:
            r6 = r0
            r7 = r6
        L_0x0088:
            if (r7 == 0) goto L_0x008f
            r7.close()     // Catch:{ Exception -> 0x008e }
            goto L_0x008f
        L_0x008e:
        L_0x008f:
            if (r6 == 0) goto L_0x0094
            r6.close()     // Catch:{ Exception -> 0x0094 }
        L_0x0094:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.helpers.LocalMapTileProvider.readTileImage(int, int, int):byte[]");
    }

    private void tryToAddANoMediaFile() {
        try {
            g.b(this.context);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public Tile getTile(int i2, int i3, int i4) {
        byte[] readTileImage = readTileImage(i2, i3, i4);
        return readTileImage == null ? f18318a : new Tile(256, 256, readTileImage);
    }
}
