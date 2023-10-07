package com.xeagle.android.login.common;

import android.text.TextUtils;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class AttachmentStore {
    /* JADX WARNING: Removed duplicated region for block: B:42:0x0086 A[SYNTHETIC, Splitter:B:42:0x0086] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x008b A[Catch:{ IOException -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x0097 A[SYNTHETIC, Splitter:B:51:0x0097] */
    /* JADX WARNING: Removed duplicated region for block: B:56:0x009f A[Catch:{ IOException -> 0x009b }] */
    /* JADX WARNING: Removed duplicated region for block: B:61:0x00aa A[SYNTHETIC, Splitter:B:61:0x00aa] */
    /* JADX WARNING: Removed duplicated region for block: B:66:0x00b2 A[Catch:{ IOException -> 0x00ae }] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:39:0x0081=Splitter:B:39:0x0081, B:48:0x0092=Splitter:B:48:0x0092} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long copy(java.lang.String r6, java.lang.String r7) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r6)
            r1 = -1
            if (r0 != 0) goto L_0x00ba
            boolean r0 = android.text.TextUtils.isEmpty(r7)
            if (r0 == 0) goto L_0x0010
            goto L_0x00ba
        L_0x0010:
            java.io.File r0 = new java.io.File
            r0.<init>(r6)
            boolean r3 = r0.exists()
            if (r3 != 0) goto L_0x001c
            return r1
        L_0x001c:
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x0027
            long r6 = r0.length()
            return r6
        L_0x0027:
            r6 = 0
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x007e, all -> 0x007a }
            r3.<init>(r0)     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x007e, all -> 0x007a }
            java.nio.channels.FileChannel r3 = r3.getChannel()     // Catch:{ FileNotFoundException -> 0x008f, IOException -> 0x007e, all -> 0x007a }
            java.io.FileOutputStream r4 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x0075, IOException -> 0x0070, all -> 0x006b }
            java.io.File r7 = create(r7)     // Catch:{ FileNotFoundException -> 0x0075, IOException -> 0x0070, all -> 0x006b }
            r4.<init>(r7)     // Catch:{ FileNotFoundException -> 0x0075, IOException -> 0x0070, all -> 0x006b }
            java.nio.channels.FileChannel r6 = r4.getChannel()     // Catch:{ FileNotFoundException -> 0x0075, IOException -> 0x0070, all -> 0x006b }
            r7 = 4096(0x1000, float:5.74E-42)
            java.nio.ByteBuffer r7 = java.nio.ByteBuffer.allocateDirect(r7)     // Catch:{ FileNotFoundException -> 0x0075, IOException -> 0x0070, all -> 0x006b }
        L_0x0044:
            int r4 = r3.read(r7)     // Catch:{ FileNotFoundException -> 0x0075, IOException -> 0x0070, all -> 0x006b }
            r5 = -1
            if (r4 == r5) goto L_0x0055
            r7.flip()     // Catch:{ FileNotFoundException -> 0x0075, IOException -> 0x0070, all -> 0x006b }
            r6.write(r7)     // Catch:{ FileNotFoundException -> 0x0075, IOException -> 0x0070, all -> 0x006b }
            r7.clear()     // Catch:{ FileNotFoundException -> 0x0075, IOException -> 0x0070, all -> 0x006b }
            goto L_0x0044
        L_0x0055:
            long r0 = r0.length()     // Catch:{ FileNotFoundException -> 0x0075, IOException -> 0x0070, all -> 0x006b }
            if (r3 == 0) goto L_0x0061
            r3.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x0061
        L_0x005f:
            r6 = move-exception
            goto L_0x0067
        L_0x0061:
            if (r6 == 0) goto L_0x006a
            r6.close()     // Catch:{ IOException -> 0x005f }
            goto L_0x006a
        L_0x0067:
            r6.printStackTrace()
        L_0x006a:
            return r0
        L_0x006b:
            r7 = move-exception
            r0 = r7
            r7 = r6
            r6 = r3
            goto L_0x00a8
        L_0x0070:
            r7 = move-exception
            r0 = r7
            r7 = r6
            r6 = r3
            goto L_0x0081
        L_0x0075:
            r7 = move-exception
            r0 = r7
            r7 = r6
            r6 = r3
            goto L_0x0092
        L_0x007a:
            r7 = move-exception
            r0 = r7
            r7 = r6
            goto L_0x00a8
        L_0x007e:
            r7 = move-exception
            r0 = r7
            r7 = r6
        L_0x0081:
            r0.printStackTrace()     // Catch:{ all -> 0x00a7 }
            if (r6 == 0) goto L_0x0089
            r6.close()     // Catch:{ IOException -> 0x009b }
        L_0x0089:
            if (r7 == 0) goto L_0x00a6
            r7.close()     // Catch:{ IOException -> 0x009b }
            goto L_0x00a6
        L_0x008f:
            r7 = move-exception
            r0 = r7
            r7 = r6
        L_0x0092:
            r0.printStackTrace()     // Catch:{ all -> 0x00a7 }
            if (r6 == 0) goto L_0x009d
            r6.close()     // Catch:{ IOException -> 0x009b }
            goto L_0x009d
        L_0x009b:
            r6 = move-exception
            goto L_0x00a3
        L_0x009d:
            if (r7 == 0) goto L_0x00a6
            r7.close()     // Catch:{ IOException -> 0x009b }
            goto L_0x00a6
        L_0x00a3:
            r6.printStackTrace()
        L_0x00a6:
            return r1
        L_0x00a7:
            r0 = move-exception
        L_0x00a8:
            if (r6 == 0) goto L_0x00b0
            r6.close()     // Catch:{ IOException -> 0x00ae }
            goto L_0x00b0
        L_0x00ae:
            r6 = move-exception
            goto L_0x00b6
        L_0x00b0:
            if (r7 == 0) goto L_0x00b9
            r7.close()     // Catch:{ IOException -> 0x00ae }
            goto L_0x00b9
        L_0x00b6:
            r6.printStackTrace()
        L_0x00b9:
            throw r0
        L_0x00ba:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.common.AttachmentStore.copy(java.lang.String, java.lang.String):long");
    }

    public static File create(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        File file = new File(str);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
            return file;
        } catch (IOException unused) {
            if (file.exists()) {
                file.delete();
            }
            return null;
        }
    }

    public static boolean delete(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        File file = new File(str);
        if (file.exists()) {
            return renameOnDelete(file).delete();
        }
        return false;
    }

    public static boolean deleteDir(String str) {
        return deleteDir(str, true);
    }

    private static boolean deleteDir(String str, boolean z2) {
        File file = new File(str);
        boolean z3 = false;
        if (file.exists()) {
            if (z2) {
                file = renameOnDelete(file);
            }
            File[] listFiles = file.listFiles();
            boolean z4 = true;
            if (listFiles != null) {
                int length = listFiles.length;
                for (int i2 = 0; i2 < length; i2++) {
                    if (listFiles[i2].isDirectory()) {
                        deleteDir(listFiles[i2].getPath(), false);
                    } else if (!listFiles[i2].delete()) {
                        z4 = false;
                    }
                }
                z3 = z4;
            } else {
                z3 = true;
            }
        }
        if (z3) {
            file.delete();
        }
        return z3;
    }

    public static void deleteOnExit(String str) {
        if (!TextUtils.isEmpty(str)) {
            File file = new File(str);
            if (file.exists()) {
                file.deleteOnExit();
            }
        }
    }

    public static long getFileLength(String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        File file = new File(str);
        if (!file.exists()) {
            return -1;
        }
        return file.length();
    }

    public static boolean isFileExist(String str) {
        return !TextUtils.isEmpty(str) && new File(str).exists();
    }

    public static byte[] load(String str) {
        try {
            File file = new File(str);
            int length = (int) file.length();
            int i2 = 0;
            byte[] bArr = new byte[length];
            FileInputStream fileInputStream = new FileInputStream(file);
            do {
                int read = fileInputStream.read(bArr, i2, length);
                i2 += read;
                length -= read;
            } while (length != 0);
            fileInputStream.close();
            return bArr;
        } catch (FileNotFoundException | IOException unused) {
            return null;
        }
    }

    public static String loadAsString(String str) {
        if (isFileExist(str)) {
            return new String(load(str));
        }
        return null;
    }

    public static boolean move(String str, String str2) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(str2)) {
            File file = new File(str);
            if (file.exists() && file.isFile()) {
                File file2 = new File(str2);
                if (file2.getParentFile() == null) {
                    return false;
                }
                if (!file2.getParentFile().exists()) {
                    file2.getParentFile().mkdirs();
                }
                return file.renameTo(file2);
            }
        }
        return false;
    }

    private static File renameOnDelete(File file) {
        File file2 = new File(file.getParent() + "/" + System.currentTimeMillis() + "_tmp");
        return file.renameTo(file2) ? file2 : file;
    }

    /* JADX WARNING: Removed duplicated region for block: B:29:0x0052 A[Catch:{ all -> 0x008c }] */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0083 A[SYNTHETIC, Splitter:B:37:0x0083] */
    /* JADX WARNING: Removed duplicated region for block: B:49:0x0098 A[SYNTHETIC, Splitter:B:49:0x0098] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static long save(java.io.InputStream r6, java.lang.String r7) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r7)
            java.io.File r1 = r0.getParentFile()
            boolean r1 = r1.exists()
            if (r1 != 0) goto L_0x0016
            java.io.File r1 = r0.getParentFile()
            r1.mkdirs()
        L_0x0016:
            r1 = 0
            r0.createNewFile()     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0048, all -> 0x0046 }
            r1 = 8091(0x1f9b, float:1.1338E-41)
            byte[] r1 = new byte[r1]     // Catch:{ IOException -> 0x0044 }
        L_0x0023:
            int r3 = r6.read(r1)     // Catch:{ IOException -> 0x0044 }
            r4 = -1
            if (r3 == r4) goto L_0x002f
            r4 = 0
            r2.write(r1, r4, r3)     // Catch:{ IOException -> 0x0044 }
            goto L_0x0023
        L_0x002f:
            long r0 = r0.length()     // Catch:{ IOException -> 0x0044 }
            r6.close()     // Catch:{ IOException -> 0x0037 }
            goto L_0x003b
        L_0x0037:
            r6 = move-exception
            r6.printStackTrace()
        L_0x003b:
            r2.close()     // Catch:{ IOException -> 0x003f }
            goto L_0x0043
        L_0x003f:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0043:
            return r0
        L_0x0044:
            r1 = move-exception
            goto L_0x004c
        L_0x0046:
            r7 = move-exception
            goto L_0x008e
        L_0x0048:
            r2 = move-exception
            r5 = r2
            r2 = r1
            r1 = r5
        L_0x004c:
            boolean r3 = r0.exists()     // Catch:{ all -> 0x008c }
            if (r3 == 0) goto L_0x0055
            r0.delete()     // Catch:{ all -> 0x008c }
        L_0x0055:
            java.lang.String r0 = "file"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x008c }
            r3.<init>()     // Catch:{ all -> 0x008c }
            java.lang.String r4 = "save is to "
            r3.append(r4)     // Catch:{ all -> 0x008c }
            r3.append(r7)     // Catch:{ all -> 0x008c }
            java.lang.String r7 = " failed: "
            r3.append(r7)     // Catch:{ all -> 0x008c }
            java.lang.String r7 = r1.getMessage()     // Catch:{ all -> 0x008c }
            r3.append(r7)     // Catch:{ all -> 0x008c }
            java.lang.String r7 = r3.toString()     // Catch:{ all -> 0x008c }
            android.util.Log.e(r0, r7)     // Catch:{ all -> 0x008c }
            r0 = -1
            r6.close()     // Catch:{ IOException -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0081:
            if (r2 == 0) goto L_0x008b
            r2.close()     // Catch:{ IOException -> 0x0087 }
            goto L_0x008b
        L_0x0087:
            r6 = move-exception
            r6.printStackTrace()
        L_0x008b:
            return r0
        L_0x008c:
            r7 = move-exception
            r1 = r2
        L_0x008e:
            r6.close()     // Catch:{ IOException -> 0x0092 }
            goto L_0x0096
        L_0x0092:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0096:
            if (r1 == 0) goto L_0x00a0
            r1.close()     // Catch:{ IOException -> 0x009c }
            goto L_0x00a0
        L_0x009c:
            r6 = move-exception
            r6.printStackTrace()
        L_0x00a0:
            goto L_0x00a2
        L_0x00a1:
            throw r7
        L_0x00a2:
            goto L_0x00a1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.common.AttachmentStore.save(java.io.InputStream, java.lang.String):long");
    }

    public static long save(String str, String str2) {
        return save(str2.getBytes(), str);
    }

    public static long save(byte[] bArr, String str) {
        if (TextUtils.isEmpty(str)) {
            return -1;
        }
        File file = new File(str);
        if (file.getParentFile() == null) {
            return -1;
        }
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        try {
            file.createNewFile();
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(bArr);
            fileOutputStream.close();
            return file.length();
        } catch (IOException e2) {
            e2.printStackTrace();
            return -1;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0030 A[SYNTHETIC, Splitter:B:22:0x0030] */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x003e A[SYNTHETIC, Splitter:B:30:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0045  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean saveBitmap(android.graphics.Bitmap r3, java.lang.String r4, boolean r5) {
        /*
            r0 = 0
            if (r3 == 0) goto L_0x0048
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 == 0) goto L_0x000a
            goto L_0x0048
        L_0x000a:
            r1 = 0
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x003b, all -> 0x002d }
            r2.<init>(r4)     // Catch:{ FileNotFoundException -> 0x003b, all -> 0x002d }
            java.io.BufferedOutputStream r4 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x003b, all -> 0x002d }
            r4.<init>(r2)     // Catch:{ FileNotFoundException -> 0x003b, all -> 0x002d }
            android.graphics.Bitmap$CompressFormat r1 = android.graphics.Bitmap.CompressFormat.JPEG     // Catch:{ FileNotFoundException -> 0x002b, all -> 0x0028 }
            r2 = 80
            r3.compress(r1, r2, r4)     // Catch:{ FileNotFoundException -> 0x002b, all -> 0x0028 }
            r0 = 1
            r4.close()     // Catch:{ IOException -> 0x0021 }
            goto L_0x0022
        L_0x0021:
        L_0x0022:
            if (r5 == 0) goto L_0x0027
            r3.recycle()
        L_0x0027:
            return r0
        L_0x0028:
            r0 = move-exception
            r1 = r4
            goto L_0x002e
        L_0x002b:
            r1 = r4
            goto L_0x003c
        L_0x002d:
            r0 = move-exception
        L_0x002e:
            if (r1 == 0) goto L_0x0035
            r1.close()     // Catch:{ IOException -> 0x0034 }
            goto L_0x0035
        L_0x0034:
        L_0x0035:
            if (r5 == 0) goto L_0x003a
            r3.recycle()
        L_0x003a:
            throw r0
        L_0x003b:
        L_0x003c:
            if (r1 == 0) goto L_0x0043
            r1.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0043
        L_0x0042:
        L_0x0043:
            if (r5 == 0) goto L_0x0048
            r3.recycle()
        L_0x0048:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.common.AttachmentStore.saveBitmap(android.graphics.Bitmap, java.lang.String, boolean):boolean");
    }
}
