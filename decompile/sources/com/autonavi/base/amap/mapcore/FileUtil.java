package com.autonavi.base.amap.mapcore;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Environment;
import android.os.storage.StorageManager;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import com.amap.api.mapcore.util.dl;
import com.amap.api.mapcore.util.dm;
import com.amap.api.mapcore.util.dn;
import com.amap.api.mapcore.util.fz;
import com.amap.api.maps.MapsInitializer;
import java.io.BufferedOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.zip.CRC32;
import java.util.zip.CheckedInputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class FileUtil {
    private static final int BUFFER = 1024;
    private static final String FILE_PATH_ENTRY_BACK = "..";
    private static final String FILE_PATH_ENTRY_SEPARATOR1 = "\\";
    private static final String FILE_PATH_ENTRY_SEPARATOR2 = "%";
    private static final String TAG = "FileUtil";
    private static final char UNIX_SEPARATOR = '/';
    private static final char WINDOWS_SEPARATOR = '\\';

    public static class UnZipFileBrake {
        public boolean mIsAborted = false;
    }

    public interface ZipCompressProgressListener {
        void onFinishProgress(long j2);
    }

    public static boolean checkCanWrite(File file) {
        if (file == null || !file.canWrite()) {
            return false;
        }
        File file2 = new File(file, "amap.tmp");
        try {
            file2.createNewFile();
            if (!file2.exists()) {
                return false;
            }
            try {
                file2.delete();
                return true;
            } catch (Exception e2) {
                e2.printStackTrace();
                return false;
            }
        } catch (IOException e3) {
            e3.printStackTrace();
            return false;
        }
    }

    public static byte[] compress(String str, String str2) {
        GZIPOutputStream gZIPOutputStream = null;
        if (str == null || str.length() == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream2.write(str.getBytes(str2));
                gZIPOutputStream2.close();
                safelyCloseFile((OutputStream) gZIPOutputStream2);
            } catch (IOException e2) {
                e = e2;
                gZIPOutputStream = gZIPOutputStream2;
                try {
                    Log.e("gzip compress error.", e.getMessage());
                    safelyCloseFile((OutputStream) gZIPOutputStream);
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    th = th;
                    safelyCloseFile((OutputStream) gZIPOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream = gZIPOutputStream2;
                safelyCloseFile((OutputStream) gZIPOutputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            Log.e("gzip compress error.", e.getMessage());
            safelyCloseFile((OutputStream) gZIPOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static byte[] compress(byte[] bArr) {
        GZIPOutputStream gZIPOutputStream = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            GZIPOutputStream gZIPOutputStream2 = new GZIPOutputStream(byteArrayOutputStream);
            try {
                gZIPOutputStream2.write(bArr);
                gZIPOutputStream2.close();
                safelyCloseFile((OutputStream) gZIPOutputStream2);
            } catch (IOException e2) {
                e = e2;
                gZIPOutputStream = gZIPOutputStream2;
                try {
                    Log.e("gzip compress error.", e.getMessage());
                    safelyCloseFile((OutputStream) gZIPOutputStream);
                    return byteArrayOutputStream.toByteArray();
                } catch (Throwable th) {
                    th = th;
                    safelyCloseFile((OutputStream) gZIPOutputStream);
                    throw th;
                }
            } catch (Throwable th2) {
                th = th2;
                gZIPOutputStream = gZIPOutputStream2;
                safelyCloseFile((OutputStream) gZIPOutputStream);
                throw th;
            }
        } catch (IOException e3) {
            e = e3;
            Log.e("gzip compress error.", e.getMessage());
            safelyCloseFile((OutputStream) gZIPOutputStream);
            return byteArrayOutputStream.toByteArray();
        }
        return byteArrayOutputStream.toByteArray();
    }

    public static void createNoMediaFileIfNotExist(String str) {
    }

    private static void decompress(File file, File file2, ZipInputStream zipInputStream, long j2, ZipCompressProgressListener zipCompressProgressListener, UnZipFileBrake unZipFileBrake) throws Exception {
        UnZipFileBrake unZipFileBrake2 = unZipFileBrake;
        boolean z2 = false;
        int i2 = 0;
        while (true) {
            ZipEntry nextEntry = zipInputStream.getNextEntry();
            if (nextEntry == null) {
                break;
            } else if (unZipFileBrake2 == null || !unZipFileBrake2.mIsAborted) {
                String name = nextEntry.getName();
                if (TextUtils.isEmpty(name) || !isSafeEntryName(name)) {
                    z2 = true;
                } else {
                    File file3 = new File(file2.getPath() + File.separator + name);
                    fileProber(file3);
                    if (nextEntry.isDirectory()) {
                        file3.mkdirs();
                    } else {
                        i2 += decompressFile(file3, zipInputStream, (long) i2, j2, zipCompressProgressListener, unZipFileBrake);
                    }
                    zipInputStream.closeEntry();
                }
            } else {
                zipInputStream.closeEntry();
                return;
            }
        }
        z2 = true;
        if (z2 && file != null) {
            try {
                file.delete();
            } catch (Exception unused) {
            }
        }
    }

    public static void decompress(InputStream inputStream, String str) throws Exception {
        decompress(inputStream, str, 0, (ZipCompressProgressListener) null);
    }

    private static void decompress(InputStream inputStream, String str, long j2, ZipCompressProgressListener zipCompressProgressListener) throws Exception {
        CheckedInputStream checkedInputStream = new CheckedInputStream(inputStream, new CRC32());
        ZipInputStream zipInputStream = new ZipInputStream(checkedInputStream);
        decompress((File) null, new File(str), zipInputStream, j2, zipCompressProgressListener, (UnZipFileBrake) null);
        zipInputStream.close();
        checkedInputStream.close();
    }

    private static int decompressFile(File file, ZipInputStream zipInputStream, long j2, long j3, ZipCompressProgressListener zipCompressProgressListener, UnZipFileBrake unZipFileBrake) throws Exception {
        BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
        byte[] bArr = new byte[1024];
        int i2 = 0;
        while (true) {
            int read = zipInputStream.read(bArr, 0, 1024);
            if (read == -1) {
                bufferedOutputStream.close();
                return i2;
            } else if (unZipFileBrake == null || !unZipFileBrake.mIsAborted) {
                bufferedOutputStream.write(bArr, 0, read);
                i2 += read;
                if (j3 > 0 && zipCompressProgressListener != null) {
                    long j4 = ((((long) i2) + j2) * 100) / j3;
                    if (unZipFileBrake == null || !unZipFileBrake.mIsAborted) {
                        zipCompressProgressListener.onFinishProgress(j4);
                    }
                }
            } else {
                bufferedOutputStream.close();
                return i2;
            }
        }
    }

    public static boolean deleteFile(File file) {
        File[] listFiles;
        if (file == null || !file.exists()) {
            return false;
        }
        if (file.isDirectory() && (listFiles = file.listFiles()) != null) {
            for (int i2 = 0; i2 < listFiles.length; i2++) {
                if (listFiles[i2].isFile()) {
                    if (!listFiles[i2].delete()) {
                        return false;
                    }
                } else if (!deleteFile(listFiles[i2])) {
                    return false;
                } else {
                    listFiles[i2].delete();
                }
            }
        }
        file.delete();
        return true;
    }

    private static void fileProber(File file) {
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) {
            fileProber(parentFile);
            parentFile.mkdir();
        }
    }

    public static String getExternalStroragePath(Context context) {
        int i2;
        String str;
        Context context2 = context;
        int i3 = Build.VERSION.SDK_INT;
        if (i3 >= 12) {
            try {
                StorageManager storageManager = (StorageManager) context2.getSystemService("storage");
                Method method = StorageManager.class.getMethod("getVolumeList", new Class[0]);
                Method method2 = StorageManager.class.getMethod("getVolumeState", new Class[]{String.class});
                Object[] objArr = (Object[]) method.invoke(storageManager, new Object[0]);
                Boolean bool = Boolean.FALSE;
                int length = objArr.length;
                String str2 = "";
                String str3 = str2;
                int i4 = 0;
                while (true) {
                    if (i4 >= length) {
                        i2 = 18;
                        str = null;
                        break;
                    }
                    Object obj = objArr[i4];
                    Method method3 = obj.getClass().getMethod("getPath", new Class[0]);
                    Method method4 = obj.getClass().getMethod("isRemovable", new Class[0]);
                    str = (String) method3.invoke(obj, new Object[0]);
                    Object[] objArr2 = objArr;
                    String str4 = (String) method2.invoke(storageManager, new Object[]{method3.invoke(obj, new Object[0])});
                    Boolean bool2 = (Boolean) method4.invoke(obj, new Object[0]);
                    if (TextUtils.isEmpty(str) || !str.toLowerCase().contains("private")) {
                        if (!bool2.booleanValue()) {
                            str3 = str4;
                            str2 = str;
                            i4++;
                            objArr = objArr2;
                        } else if (!(str == null || str4 == null || !str4.equals("mounted"))) {
                            if (i3 > 18) {
                                try {
                                    File[] externalFilesDirs = context2.getExternalFilesDirs((String) null);
                                    if (externalFilesDirs == null) {
                                        str = null;
                                    } else if (externalFilesDirs.length > 1) {
                                        str = externalFilesDirs[1].getAbsolutePath();
                                    }
                                } catch (Exception unused) {
                                }
                            }
                            i2 = 18;
                        }
                    }
                    i4++;
                    objArr = objArr2;
                }
                if (i3 > i2) {
                    return (str2 == null || str3 == null || !str3.equals("mounted")) ? str : str2;
                }
                if (!(str != null || str2 == null || str3 == null)) {
                    if (str3.equals("mounted")) {
                        return str2;
                    }
                }
                return str;
            } catch (Throwable unused2) {
            }
        }
        if (Environment.getExternalStorageState().equals("mounted")) {
            return Environment.getExternalStorageDirectory().toString();
        }
        return null;
    }

    public static String getMapBaseStorage(Context context) {
        String str;
        if (context == null) {
            return null;
        }
        String str2 = Build.VERSION.SDK_INT > 18 ? "map_base_path_v44" : "map_base_path";
        SharedPreferences sharedPreferences = context.getSharedPreferences("base_path", 0);
        if (MapsInitializer.sdcardDir == null || MapsInitializer.sdcardDir.trim().length() <= 0) {
            str = sharedPreferences.getString(str2, "");
        } else {
            str = MapsInitializer.sdcardDir + File.separatorChar;
        }
        if (str != null && str.length() > 2) {
            File file = new File(str);
            if (!file.exists()) {
                file.mkdir();
            }
            if (file.isDirectory()) {
                if (checkCanWrite(file)) {
                    return str;
                }
                String str3 = context.getCacheDir().toString() + AeUtil.ROOTPATH;
                if (str3 != null && str3.length() > 2) {
                    File file2 = new File(str3);
                    if (!file2.exists()) {
                        file2.mkdir();
                    }
                    if (file2.isDirectory()) {
                        return str3;
                    }
                }
            }
        }
        String str4 = getExternalStroragePath(context) + AeUtil.ROOTPATH;
        if (str4 != null && str4.length() > 2) {
            File file3 = new File(str4);
            if (!file3.exists()) {
                file3.mkdir();
            }
            if (file3.isDirectory() && file3.canWrite()) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString(str2, str4);
                edit.commit();
                createNoMediaFileIfNotExist(str4);
                return str4;
            }
        }
        String str5 = context.getCacheDir().toString() + AeUtil.ROOTPATH;
        if (str5 != null && str5.length() > 2) {
            File file4 = new File(str5);
            if (!file4.exists()) {
                file4.mkdir();
            }
            if (file4.isDirectory()) {
            }
        }
        return str5;
    }

    public static String getName(String str) {
        if (str == null) {
            return null;
        }
        return str.substring(indexOfLastSeparator(str) + 1);
    }

    private static InputStream getZipInputStream(byte[] bArr) throws IOException {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
        return isGzip(bArr) ? new GZIPInputStream(byteArrayInputStream) : new ZipInputStream(byteArrayInputStream);
    }

    public static int indexOfLastSeparator(String str) {
        if (str == null) {
            return -1;
        }
        return Math.max(str.lastIndexOf(47), str.lastIndexOf(92));
    }

    public static boolean isGzip(byte[] bArr) {
        return ((bArr[1] & 255) | (bArr[0] << 8)) == 8075;
    }

    public static boolean isSafeEntryName(String str) {
        return !str.contains(FILE_PATH_ENTRY_BACK) && !str.contains(FILE_PATH_ENTRY_SEPARATOR1) && !str.contains(FILE_PATH_ENTRY_SEPARATOR2);
    }

    private static byte[] readByteByStream(InputStream inputStream) throws IOException {
        if (inputStream == null) {
            return null;
        }
        byte[] bArr = new byte[1024];
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        while (true) {
            try {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    byteArrayOutputStream.write(bArr, 0, read);
                } else {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    safelyCloseFile((OutputStream) byteArrayOutputStream);
                    return byteArray;
                }
            } catch (IOException e2) {
                throw e2;
            } catch (Throwable th) {
                safelyCloseFile((OutputStream) byteArrayOutputStream);
                throw th;
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v2, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r6v4, resolved type: java.io.FileInputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: java.io.ByteArrayOutputStream} */
    /* JADX WARNING: type inference failed for: r6v1, types: [java.io.InputStream] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] readFileContents(java.lang.String r6) {
        /*
            r0 = 0
            java.io.File r1 = new java.io.File     // Catch:{ all -> 0x003d }
            r1.<init>(r6)     // Catch:{ all -> 0x003d }
            boolean r6 = r1.exists()     // Catch:{ all -> 0x003d }
            if (r6 != 0) goto L_0x0013
            safelyCloseFile((java.io.OutputStream) r0)
            safelyCloseFile((java.io.InputStream) r0)
            return r0
        L_0x0013:
            java.io.FileInputStream r6 = new java.io.FileInputStream     // Catch:{ all -> 0x003d }
            r6.<init>(r1)     // Catch:{ all -> 0x003d }
            r1 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r1]     // Catch:{ all -> 0x003a }
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream     // Catch:{ all -> 0x003a }
            r2.<init>()     // Catch:{ all -> 0x003a }
        L_0x0021:
            int r3 = r6.read(r1)     // Catch:{ all -> 0x0038 }
            r4 = -1
            if (r3 == r4) goto L_0x002d
            r4 = 0
            r2.write(r1, r4, r3)     // Catch:{ all -> 0x0038 }
            goto L_0x0021
        L_0x002d:
            byte[] r0 = r2.toByteArray()     // Catch:{ all -> 0x0038 }
            safelyCloseFile((java.io.OutputStream) r2)
            safelyCloseFile((java.io.InputStream) r6)
            return r0
        L_0x0038:
            r1 = move-exception
            goto L_0x0040
        L_0x003a:
            r1 = move-exception
            r2 = r0
            goto L_0x0040
        L_0x003d:
            r1 = move-exception
            r6 = r0
            r2 = r6
        L_0x0040:
            java.lang.String r3 = "FileUtil"
            java.lang.String r4 = "readFileContents"
            com.amap.api.mapcore.util.fz.c(r1, r3, r4)     // Catch:{ all -> 0x0068 }
            com.amap.api.mapcore.util.dl.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x0068 }
            java.lang.String r3 = com.amap.api.mapcore.util.dm.f8272f     // Catch:{ all -> 0x0068 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x0068 }
            java.lang.String r5 = "read file from disk failed "
            r4.<init>(r5)     // Catch:{ all -> 0x0068 }
            java.lang.String r1 = r1.getMessage()     // Catch:{ all -> 0x0068 }
            r4.append(r1)     // Catch:{ all -> 0x0068 }
            java.lang.String r1 = r4.toString()     // Catch:{ all -> 0x0068 }
            com.amap.api.mapcore.util.dn.b(r3, r1)     // Catch:{ all -> 0x0068 }
            safelyCloseFile((java.io.OutputStream) r2)
            safelyCloseFile((java.io.InputStream) r6)
            return r0
        L_0x0068:
            r0 = move-exception
            safelyCloseFile((java.io.OutputStream) r2)
            safelyCloseFile((java.io.InputStream) r6)
            goto L_0x0071
        L_0x0070:
            throw r0
        L_0x0071:
            goto L_0x0070
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.amap.mapcore.FileUtil.readFileContents(java.lang.String):byte[]");
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:22:0x0031=Splitter:B:22:0x0031, B:28:0x004c=Splitter:B:28:0x004c} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] readFileContentsFromAssets(android.content.Context r5, java.lang.String r6) {
        /*
            java.lang.String r0 = "read file from assets failed "
            android.content.res.AssetManager r5 = r5.getAssets()
            r1 = 0
            java.io.InputStream r5 = r5.open(r6)     // Catch:{ IOException -> 0x004a, OutOfMemoryError -> 0x002f, all -> 0x002d }
            int r6 = r5.available()     // Catch:{ IOException -> 0x002b, OutOfMemoryError -> 0x0029 }
            if (r6 != 0) goto L_0x0015
            safelyCloseFile((java.io.InputStream) r5)
            return r1
        L_0x0015:
            byte[] r2 = new byte[r6]     // Catch:{ IOException -> 0x002b, OutOfMemoryError -> 0x0029 }
            r3 = 0
        L_0x0018:
            if (r3 >= r6) goto L_0x0022
            int r4 = r6 - r3
            int r4 = r5.read(r2, r3, r4)     // Catch:{ IOException -> 0x002b, OutOfMemoryError -> 0x0029 }
            int r3 = r3 + r4
            goto L_0x0018
        L_0x0022:
            safelyCloseFile((java.io.InputStream) r5)
            return r2
        L_0x0026:
            r6 = move-exception
            r1 = r5
            goto L_0x0065
        L_0x0029:
            r6 = move-exception
            goto L_0x0031
        L_0x002b:
            r6 = move-exception
            goto L_0x004c
        L_0x002d:
            r6 = move-exception
            goto L_0x0065
        L_0x002f:
            r6 = move-exception
            r5 = r1
        L_0x0031:
            java.lang.String r2 = com.amap.api.mapcore.util.dm.f8272f     // Catch:{ all -> 0x0026 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0026 }
            r3.<init>(r0)     // Catch:{ all -> 0x0026 }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0026 }
            r3.append(r6)     // Catch:{ all -> 0x0026 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x0026 }
            com.amap.api.mapcore.util.dn.b(r2, r6)     // Catch:{ all -> 0x0026 }
            safelyCloseFile((java.io.InputStream) r5)
            return r1
        L_0x004a:
            r6 = move-exception
            r5 = r1
        L_0x004c:
            java.lang.String r2 = com.amap.api.mapcore.util.dm.f8272f     // Catch:{ all -> 0x0026 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x0026 }
            r3.<init>(r0)     // Catch:{ all -> 0x0026 }
            java.lang.String r6 = r6.getMessage()     // Catch:{ all -> 0x0026 }
            r3.append(r6)     // Catch:{ all -> 0x0026 }
            java.lang.String r6 = r3.toString()     // Catch:{ all -> 0x0026 }
            com.amap.api.mapcore.util.dn.b(r2, r6)     // Catch:{ all -> 0x0026 }
            safelyCloseFile((java.io.InputStream) r5)
            return r1
        L_0x0065:
            safelyCloseFile((java.io.InputStream) r1)
            goto L_0x006a
        L_0x0069:
            throw r6
        L_0x006a:
            goto L_0x0069
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.amap.mapcore.FileUtil.readFileContentsFromAssets(android.content.Context, java.lang.String):byte[]");
    }

    public static byte[] readFileContentsFromAssetsByPreName(Context context, String str, String str2) {
        if (!(context == null || str == null || str2 == null)) {
            try {
                String[] list = context.getAssets().list(str);
                if (list == null) {
                    return null;
                }
                int length = list.length;
                int i2 = 0;
                while (i2 < length) {
                    String str3 = list[i2];
                    if (str3 == null || !str3.contains(str2)) {
                        i2++;
                    } else {
                        return readFileContentsFromAssets(context, str + "/" + str3);
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return null;
    }

    private static void safelyCloseFile(InputStream inputStream) {
        if (inputStream != null) {
            try {
                if (inputStream instanceof ZipInputStream) {
                    ((ZipInputStream) inputStream).closeEntry();
                }
                inputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    private static void safelyCloseFile(OutputStream outputStream) {
        if (outputStream != null) {
            try {
                outputStream.close();
            } catch (Throwable unused) {
            }
        }
    }

    /* JADX WARNING: Unknown top exception splitter block from list: {B:19:0x0055=Splitter:B:19:0x0055, B:24:0x005d=Splitter:B:24:0x005d} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void saveFile(java.lang.String r4, java.lang.String r5, boolean r6) {
        /*
            r0 = 0
            java.io.File r1 = android.os.Environment.getExternalStorageDirectory()     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0054 }
            java.lang.String r1 = r1.getAbsolutePath()     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0054 }
            java.io.File r2 = new java.io.File     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0054 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0054 }
            r3.<init>()     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0054 }
            r3.append(r1)     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0054 }
            java.lang.String r1 = "/"
            r3.append(r1)     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0054 }
            r3.append(r5)     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0054 }
            java.lang.String r5 = r3.toString()     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0054 }
            r2.<init>(r5)     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0054 }
            boolean r5 = r2.exists()     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0054 }
            if (r5 != 0) goto L_0x0037
            java.io.File r5 = new java.io.File     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0054 }
            java.lang.String r1 = r2.getParent()     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0054 }
            r5.<init>(r1)     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0054 }
            r5.mkdirs()     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0054 }
            r2.createNewFile()     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0054 }
        L_0x0037:
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0054 }
            r5.<init>(r2, r6)     // Catch:{ FileNotFoundException -> 0x005c, IOException -> 0x0054 }
            java.lang.String r6 = "utf-8"
            byte[] r4 = r4.getBytes(r6)     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004c, all -> 0x0049 }
            r5.write(r4)     // Catch:{ FileNotFoundException -> 0x004f, IOException -> 0x004c, all -> 0x0049 }
            safelyCloseFile((java.io.OutputStream) r5)
            return
        L_0x0049:
            r4 = move-exception
            r0 = r5
            goto L_0x0064
        L_0x004c:
            r4 = move-exception
            r0 = r5
            goto L_0x0055
        L_0x004f:
            r4 = move-exception
            r0 = r5
            goto L_0x005d
        L_0x0052:
            r4 = move-exception
            goto L_0x0064
        L_0x0054:
            r4 = move-exception
        L_0x0055:
            r4.printStackTrace()     // Catch:{ all -> 0x0052 }
            safelyCloseFile((java.io.OutputStream) r0)
            return
        L_0x005c:
            r4 = move-exception
        L_0x005d:
            r4.printStackTrace()     // Catch:{ all -> 0x0052 }
            safelyCloseFile((java.io.OutputStream) r0)
            return
        L_0x0064:
            safelyCloseFile((java.io.OutputStream) r0)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.amap.mapcore.FileUtil.saveFile(java.lang.String, java.lang.String, boolean):void");
    }

    public static void saveFileContents(String str, byte[] bArr) {
        FileOutputStream fileOutputStream = null;
        try {
            FileOutputStream fileOutputStream2 = new FileOutputStream(new File(str));
            try {
                fileOutputStream2.write(bArr);
                safelyCloseFile((OutputStream) fileOutputStream2);
            } catch (Throwable th) {
                th = th;
                fileOutputStream = fileOutputStream2;
                try {
                    fz.c(th, TAG, "saveFileContents");
                    dl.a(th);
                    String str2 = dm.f8272f;
                    dn.b(str2, "save file from disk failed " + th.getMessage());
                } finally {
                    safelyCloseFile((OutputStream) fileOutputStream);
                }
            }
        } catch (Throwable th2) {
            th = th2;
            fz.c(th, TAG, "saveFileContents");
            dl.a(th);
            String str22 = dm.f8272f;
            dn.b(str22, "save file from disk failed " + th.getMessage());
        }
    }

    public static byte[] uncompress(byte[] bArr) {
        InputStream inputStream;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream = getZipInputStream(bArr);
            if (inputStream != null) {
                try {
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read >= 0) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                        } else {
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            safelyCloseFile(inputStream);
                            return byteArray;
                        }
                    }
                } catch (Throwable th) {
                    th = th;
                    try {
                        Log.e("gzip compress error.", th.getMessage());
                        safelyCloseFile(inputStream);
                        return null;
                    } catch (Throwable th2) {
                        safelyCloseFile(inputStream);
                        throw th2;
                    }
                }
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            Log.e("gzip compress error.", th.getMessage());
            safelyCloseFile(inputStream);
            return null;
        }
        safelyCloseFile(inputStream);
        return null;
    }

    public static Pair<String, byte[]> uncompressToByte(byte[] bArr) {
        InputStream inputStream;
        String str;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream = getZipInputStream(bArr);
            try {
                if (inputStream instanceof ZipInputStream) {
                    str = ((ZipInputStream) inputStream).getNextEntry().getName();
                    if (!isSafeEntryName(str)) {
                        Log.e("gzip compress error.", "gzip name contains ../ ".concat(String.valueOf(str)));
                        safelyCloseFile(inputStream);
                        return null;
                    }
                } else {
                    str = "";
                }
                if (inputStream != null) {
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read >= 0) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                        } else {
                            Pair<String, byte[]> pair = new Pair<>(str, byteArrayOutputStream.toByteArray());
                            safelyCloseFile(inputStream);
                            return pair;
                        }
                    }
                }
            } catch (Throwable th) {
                th = th;
                try {
                    Log.e("gzip compress error.", th.getMessage());
                    safelyCloseFile(inputStream);
                    return null;
                } catch (Throwable th2) {
                    safelyCloseFile(inputStream);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            th = th3;
            inputStream = null;
            Log.e("gzip compress error.", th.getMessage());
            safelyCloseFile(inputStream);
            return null;
        }
        safelyCloseFile(inputStream);
        return null;
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [java.util.Map<java.lang.String, byte[]>] */
    /* JADX WARNING: type inference failed for: r2v2, types: [java.io.InputStream] */
    /* JADX WARNING: type inference failed for: r2v3 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.util.Map<java.lang.String, byte[]> uncompressToByteWithKeys(byte[] r9, java.lang.String[] r10) {
        /*
            java.lang.String r0 = "gzip compress error."
            java.util.HashMap r1 = new java.util.HashMap
            r1.<init>()
            if (r9 == 0) goto L_0x0086
            int r2 = r9.length
            if (r2 != 0) goto L_0x000e
            goto L_0x0086
        L_0x000e:
            r2 = 0
            java.io.InputStream r9 = getZipInputStream(r9)     // Catch:{ all -> 0x0075 }
            boolean r3 = r9 instanceof java.util.zip.ZipInputStream     // Catch:{ all -> 0x0072 }
            if (r3 == 0) goto L_0x006e
            r3 = r9
            java.util.zip.ZipInputStream r3 = (java.util.zip.ZipInputStream) r3     // Catch:{ all -> 0x0072 }
        L_0x001a:
            java.util.zip.ZipEntry r4 = r3.getNextEntry()     // Catch:{ all -> 0x0072 }
            if (r4 == 0) goto L_0x006e
            boolean r5 = r4.isDirectory()     // Catch:{ all -> 0x0072 }
            if (r5 != 0) goto L_0x006a
            java.lang.String r4 = r4.getName()     // Catch:{ IOException -> 0x0066 }
            boolean r5 = isSafeEntryName(r4)     // Catch:{ IOException -> 0x0066 }
            if (r5 != 0) goto L_0x0041
            java.lang.String r5 = "gzip name contains ../ "
            java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ IOException -> 0x0066 }
            java.lang.String r4 = r5.concat(r4)     // Catch:{ IOException -> 0x0066 }
            android.util.Log.e(r0, r4)     // Catch:{ IOException -> 0x0066 }
            safelyCloseFile((java.io.InputStream) r9)
            return r2
        L_0x0041:
            if (r10 != 0) goto L_0x004d
            byte[] r5 = readByteByStream(r3)     // Catch:{ IOException -> 0x0066 }
            if (r5 == 0) goto L_0x006a
            r1.put(r4, r5)     // Catch:{ IOException -> 0x0066 }
            goto L_0x006a
        L_0x004d:
            int r5 = r10.length     // Catch:{ IOException -> 0x0066 }
            r6 = 0
        L_0x004f:
            if (r6 >= r5) goto L_0x006a
            r7 = r10[r6]     // Catch:{ IOException -> 0x0066 }
            boolean r8 = r4.equals(r7)     // Catch:{ IOException -> 0x0066 }
            if (r8 == 0) goto L_0x0063
            byte[] r4 = readByteByStream(r3)     // Catch:{ IOException -> 0x0066 }
            if (r4 == 0) goto L_0x006a
            r1.put(r7, r4)     // Catch:{ IOException -> 0x0066 }
            goto L_0x006a
        L_0x0063:
            int r6 = r6 + 1
            goto L_0x004f
        L_0x0066:
            r4 = move-exception
            r4.printStackTrace()     // Catch:{ all -> 0x0072 }
        L_0x006a:
            r3.closeEntry()     // Catch:{ all -> 0x0072 }
            goto L_0x001a
        L_0x006e:
            safelyCloseFile((java.io.InputStream) r9)
            goto L_0x0080
        L_0x0072:
            r10 = move-exception
            r2 = r9
            goto L_0x0076
        L_0x0075:
            r10 = move-exception
        L_0x0076:
            java.lang.String r9 = r10.getMessage()     // Catch:{ all -> 0x0081 }
            android.util.Log.e(r0, r9)     // Catch:{ all -> 0x0081 }
            safelyCloseFile((java.io.InputStream) r2)
        L_0x0080:
            return r1
        L_0x0081:
            r9 = move-exception
            safelyCloseFile((java.io.InputStream) r2)
            throw r9
        L_0x0086:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.amap.mapcore.FileUtil.uncompressToByteWithKeys(byte[], java.lang.String[]):java.util.Map");
    }

    public static String uncompressToString(byte[] bArr) {
        return uncompressToString(bArr, "UTF-8");
    }

    public static String uncompressToString(byte[] bArr, String str) {
        InputStream inputStream;
        InputStream inputStream2 = null;
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            inputStream = getZipInputStream(bArr);
            if (inputStream != null) {
                try {
                    byte[] bArr2 = new byte[256];
                    while (true) {
                        int read = inputStream.read(bArr2);
                        if (read >= 0) {
                            byteArrayOutputStream.write(bArr2, 0, read);
                        } else {
                            String byteArrayOutputStream2 = byteArrayOutputStream.toString(str);
                            safelyCloseFile(inputStream);
                            return byteArrayOutputStream2;
                        }
                    }
                } catch (IOException e2) {
                    e = e2;
                    try {
                        Log.e("gzip compress error.", e.getMessage());
                        safelyCloseFile(inputStream);
                        return null;
                    } catch (Throwable th) {
                        th = th;
                        inputStream2 = inputStream;
                    }
                }
            }
        } catch (IOException e3) {
            e = e3;
            inputStream = null;
            Log.e("gzip compress error.", e.getMessage());
            safelyCloseFile(inputStream);
            return null;
        } catch (Throwable th2) {
            th = th2;
            safelyCloseFile(inputStream2);
            throw th;
        }
        safelyCloseFile(inputStream);
        return null;
    }

    public static void writeDatasToFile(String str, byte[] bArr) {
        ReentrantReadWriteLock.WriteLock writeLock = new ReentrantReadWriteLock().writeLock();
        writeLock.lock();
        FileOutputStream fileOutputStream = null;
        if (bArr != null) {
            try {
                if (bArr.length != 0) {
                    File file = new File(str);
                    if (file.exists()) {
                        file.delete();
                    }
                    file.createNewFile();
                    FileOutputStream fileOutputStream2 = new FileOutputStream(file);
                    try {
                        fileOutputStream2.write(bArr);
                        fileOutputStream2.flush();
                        writeLock.unlock();
                        safelyCloseFile((OutputStream) fileOutputStream2);
                        return;
                    } catch (Exception e2) {
                        fileOutputStream = fileOutputStream2;
                        e = e2;
                        try {
                            e.printStackTrace();
                            writeLock.unlock();
                            safelyCloseFile((OutputStream) fileOutputStream);
                            return;
                        } catch (Throwable th) {
                            th = th;
                            writeLock.unlock();
                            safelyCloseFile((OutputStream) fileOutputStream);
                            throw th;
                        }
                    } catch (Throwable th2) {
                        fileOutputStream = fileOutputStream2;
                        th = th2;
                        writeLock.unlock();
                        safelyCloseFile((OutputStream) fileOutputStream);
                        throw th;
                    }
                }
            } catch (Exception e3) {
                e = e3;
                e.printStackTrace();
                writeLock.unlock();
                safelyCloseFile((OutputStream) fileOutputStream);
                return;
            }
        }
        writeLock.unlock();
        safelyCloseFile((OutputStream) null);
    }
}
