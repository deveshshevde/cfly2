package com.blankj.utilcode.util;

import android.content.Intent;
import android.content.res.AssetFileDescriptor;
import android.net.Uri;
import android.os.Build;
import android.os.StatFs;
import android.text.TextUtils;
import com.blankj.utilcode.constant.RegexConstants;
import java.io.File;
import java.io.FileFilter;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import javax.net.ssl.HttpsURLConnection;

public final class FileUtils {
    private static final String LINE_SEP = System.getProperty("line.separator");

    public interface OnReplaceListener {
        boolean onReplace(File file, File file2);
    }

    private FileUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    public static boolean copy(File file, File file2) {
        return copy(file, file2, (OnReplaceListener) null);
    }

    public static boolean copy(File file, File file2, OnReplaceListener onReplaceListener) {
        if (file == null) {
            return false;
        }
        return file.isDirectory() ? copyDir(file, file2, onReplaceListener) : copyFile(file, file2, onReplaceListener);
    }

    public static boolean copy(String str, String str2) {
        return copy(getFileByPath(str), getFileByPath(str2), (OnReplaceListener) null);
    }

    public static boolean copy(String str, String str2, OnReplaceListener onReplaceListener) {
        return copy(getFileByPath(str), getFileByPath(str2), onReplaceListener);
    }

    private static boolean copyDir(File file, File file2, OnReplaceListener onReplaceListener) {
        return copyOrMoveDir(file, file2, onReplaceListener, false);
    }

    private static boolean copyFile(File file, File file2, OnReplaceListener onReplaceListener) {
        return copyOrMoveFile(file, file2, onReplaceListener, false);
    }

    private static boolean copyOrMoveDir(File file, File file2, OnReplaceListener onReplaceListener, boolean z2) {
        if (file == null || file2 == null) {
            return false;
        }
        String str = file2.getPath() + File.separator;
        if (str.contains(file.getPath() + File.separator) || !file.exists() || !file.isDirectory() || !createOrExistsDir(file2)) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file3 : listFiles) {
                File file4 = new File(str + file3.getName());
                if (file3.isFile()) {
                    if (!copyOrMoveFile(file3, file4, onReplaceListener, z2)) {
                        return false;
                    }
                } else if (file3.isDirectory() && !copyOrMoveDir(file3, file4, onReplaceListener, z2)) {
                    return false;
                }
            }
        }
        return !z2 || deleteDir(file);
    }

    private static boolean copyOrMoveFile(File file, File file2, OnReplaceListener onReplaceListener, boolean z2) {
        if (file != null && file2 != null && !file.equals(file2) && file.exists() && file.isFile()) {
            if (file2.exists()) {
                if (onReplaceListener != null && !onReplaceListener.onReplace(file, file2)) {
                    return true;
                }
                if (!file2.delete()) {
                    return false;
                }
            }
            if (!createOrExistsDir(file2.getParentFile())) {
                return false;
            }
            try {
                if (UtilsBridge.writeFileFromIS(file2.getAbsolutePath(), new FileInputStream(file))) {
                    return !z2 || deleteFile(file);
                }
                return false;
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
            }
        }
        return false;
    }

    public static boolean createFileByDeleteOldFile(File file) {
        if (file == null) {
            return false;
        }
        if ((file.exists() && !file.delete()) || !createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean createFileByDeleteOldFile(String str) {
        return createFileByDeleteOldFile(getFileByPath(str));
    }

    public static boolean createOrExistsDir(File file) {
        return file != null && (!file.exists() ? file.mkdirs() : file.isDirectory());
    }

    public static boolean createOrExistsDir(String str) {
        return createOrExistsDir(getFileByPath(str));
    }

    public static boolean createOrExistsFile(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return file.isFile();
        }
        if (!createOrExistsDir(file.getParentFile())) {
            return false;
        }
        try {
            return file.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
            return false;
        }
    }

    public static boolean createOrExistsFile(String str) {
        return createOrExistsFile(getFileByPath(str));
    }

    public static boolean delete(File file) {
        if (file == null) {
            return false;
        }
        return file.isDirectory() ? deleteDir(file) : deleteFile(file);
    }

    public static boolean delete(String str) {
        return delete(getFileByPath(str));
    }

    public static boolean deleteAllInDir(File file) {
        return deleteFilesInDirWithFilter(file, (FileFilter) new FileFilter() {
            public boolean accept(File file) {
                return true;
            }
        });
    }

    public static boolean deleteAllInDir(String str) {
        return deleteAllInDir(getFileByPath(str));
    }

    private static boolean deleteDir(File file) {
        if (file == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2.isFile()) {
                    if (!file2.delete()) {
                        return false;
                    }
                } else if (file2.isDirectory() && !deleteDir(file2)) {
                    return false;
                }
            }
        }
        return file.delete();
    }

    private static boolean deleteFile(File file) {
        return file != null && (!file.exists() || (file.isFile() && file.delete()));
    }

    public static boolean deleteFilesInDir(File file) {
        return deleteFilesInDirWithFilter(file, (FileFilter) new FileFilter() {
            public boolean accept(File file) {
                return file.isFile();
            }
        });
    }

    public static boolean deleteFilesInDir(String str) {
        return deleteFilesInDir(getFileByPath(str));
    }

    public static boolean deleteFilesInDirWithFilter(File file, FileFilter fileFilter) {
        if (file == null || fileFilter == null) {
            return false;
        }
        if (!file.exists()) {
            return true;
        }
        if (!file.isDirectory()) {
            return false;
        }
        File[] listFiles = file.listFiles();
        if (!(listFiles == null || listFiles.length == 0)) {
            for (File file2 : listFiles) {
                if (fileFilter.accept(file2)) {
                    if (file2.isFile()) {
                        if (!file2.delete()) {
                            return false;
                        }
                    } else if (file2.isDirectory() && !deleteDir(file2)) {
                        return false;
                    }
                }
            }
        }
        return true;
    }

    public static boolean deleteFilesInDirWithFilter(String str, FileFilter fileFilter) {
        return deleteFilesInDirWithFilter(getFileByPath(str), fileFilter);
    }

    private static long getDirLength(File file) {
        long j2 = 0;
        if (!isDir(file)) {
            return 0;
        }
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                j2 += file2.isDirectory() ? getDirLength(file2) : file2.length();
            }
        }
        return j2;
    }

    public static String getDirName(File file) {
        return file == null ? "" : getDirName(file.getAbsolutePath());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0009, code lost:
        r0 = r3.lastIndexOf(java.io.File.separator);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getDirName(java.lang.String r3) {
        /*
            boolean r0 = com.blankj.utilcode.util.UtilsBridge.isSpace(r3)
            java.lang.String r1 = ""
            if (r0 == 0) goto L_0x0009
            return r1
        L_0x0009:
            java.lang.String r0 = java.io.File.separator
            int r0 = r3.lastIndexOf(r0)
            r2 = -1
            if (r0 != r2) goto L_0x0013
            goto L_0x001a
        L_0x0013:
            r1 = 0
            int r0 = r0 + 1
            java.lang.String r1 = r3.substring(r1, r0)
        L_0x001a:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.FileUtils.getDirName(java.lang.String):java.lang.String");
    }

    private static String getDirSize(File file) {
        long dirLength = getDirLength(file);
        return dirLength == -1 ? "" : UtilsBridge.byte2FitMemorySize(dirLength);
    }

    public static File getFileByPath(String str) {
        if (UtilsBridge.isSpace(str)) {
            return null;
        }
        return new File(str);
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x003c A[SYNTHETIC, Splitter:B:24:0x003c] */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0044  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x004f A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x0054 A[SYNTHETIC, Splitter:B:34:0x0054] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileCharsetSimple(java.io.File r4) {
        /*
            if (r4 != 0) goto L_0x0005
            java.lang.String r4 = ""
            return r4
        L_0x0005:
            boolean r0 = isUtf8((java.io.File) r4)
            if (r0 == 0) goto L_0x000e
            java.lang.String r4 = "UTF-8"
            return r4
        L_0x000e:
            r0 = 0
            r1 = 0
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0036 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0036 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0036 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0036 }
            int r4 = r2.read()     // Catch:{ IOException -> 0x0031, all -> 0x002e }
            int r4 = r4 << 8
            int r0 = r2.read()     // Catch:{ IOException -> 0x0031, all -> 0x002e }
            int r0 = r0 + r4
            r2.close()     // Catch:{ IOException -> 0x0029 }
            goto L_0x003f
        L_0x0029:
            r4 = move-exception
            r4.printStackTrace()
            goto L_0x003f
        L_0x002e:
            r4 = move-exception
            r1 = r2
            goto L_0x0052
        L_0x0031:
            r4 = move-exception
            r1 = r2
            goto L_0x0037
        L_0x0034:
            r4 = move-exception
            goto L_0x0052
        L_0x0036:
            r4 = move-exception
        L_0x0037:
            r4.printStackTrace()     // Catch:{ all -> 0x0034 }
            if (r1 == 0) goto L_0x003f
            r1.close()     // Catch:{ IOException -> 0x0029 }
        L_0x003f:
            r4 = 65279(0xfeff, float:9.1475E-41)
            if (r0 == r4) goto L_0x004f
            r4 = 65534(0xfffe, float:9.1833E-41)
            if (r0 == r4) goto L_0x004c
            java.lang.String r4 = "GBK"
            return r4
        L_0x004c:
            java.lang.String r4 = "Unicode"
            return r4
        L_0x004f:
            java.lang.String r4 = "UTF-16BE"
            return r4
        L_0x0052:
            if (r1 == 0) goto L_0x005c
            r1.close()     // Catch:{ IOException -> 0x0058 }
            goto L_0x005c
        L_0x0058:
            r0 = move-exception
            r0.printStackTrace()
        L_0x005c:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.FileUtils.getFileCharsetSimple(java.io.File):java.lang.String");
    }

    public static String getFileCharsetSimple(String str) {
        return getFileCharsetSimple(getFileByPath(str));
    }

    public static String getFileExtension(File file) {
        return file == null ? "" : getFileExtension(file.getPath());
    }

    public static String getFileExtension(String str) {
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        return (lastIndexOf == -1 || str.lastIndexOf(File.separator) >= lastIndexOf) ? "" : str.substring(lastIndexOf + 1);
    }

    public static long getFileLastModified(File file) {
        if (file == null) {
            return -1;
        }
        return file.lastModified();
    }

    public static long getFileLastModified(String str) {
        return getFileLastModified(getFileByPath(str));
    }

    private static long getFileLength(File file) {
        if (!isFile(file)) {
            return -1;
        }
        return file.length();
    }

    public static long getFileLength(String str) {
        if (str.matches(RegexConstants.REGEX_URL)) {
            try {
                HttpsURLConnection httpsURLConnection = (HttpsURLConnection) new URL(str).openConnection();
                httpsURLConnection.setRequestProperty("Accept-Encoding", "identity");
                httpsURLConnection.connect();
                if (httpsURLConnection.getResponseCode() == 200) {
                    return (long) httpsURLConnection.getContentLength();
                }
                return -1;
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
        return getFileLength(getFileByPath(str));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0023, code lost:
        if (r6 >= r3) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        if (r1[r6] != 10) goto L_0x002d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x002b, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x002d, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0030, code lost:
        r3 = r2.read(r1, 0, 1024);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0034, code lost:
        if (r3 == -1) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0036, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0037, code lost:
        if (r6 >= r3) goto L_0x0030;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x003d, code lost:
        if (r1[r6] != 13) goto L_0x0041;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x003f, code lost:
        r0 = r0 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:0x0041, code lost:
        r6 = r6 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:?, code lost:
        r2.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0048, code lost:
        r9 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x0049, code lost:
        r9.printStackTrace();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x001a, code lost:
        if (LINE_SEP.endsWith("\n") != false) goto L_0x001c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x001c, code lost:
        r3 = r2.read(r1, 0, 1024);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0020, code lost:
        if (r3 == -1) goto L_0x0044;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        r6 = 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x005b A[SYNTHETIC, Splitter:B:37:0x005b] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x0061 A[SYNTHETIC, Splitter:B:41:0x0061] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static int getFileLines(java.io.File r9) {
        /*
            r0 = 1
            r1 = 0
            java.io.BufferedInputStream r2 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0055 }
            java.io.FileInputStream r3 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0055 }
            r3.<init>(r9)     // Catch:{ IOException -> 0x0055 }
            r2.<init>(r3)     // Catch:{ IOException -> 0x0055 }
            r9 = 1024(0x400, float:1.435E-42)
            byte[] r1 = new byte[r9]     // Catch:{ IOException -> 0x0050, all -> 0x004d }
            java.lang.String r3 = LINE_SEP     // Catch:{ IOException -> 0x0050, all -> 0x004d }
            java.lang.String r4 = "\n"
            boolean r3 = r3.endsWith(r4)     // Catch:{ IOException -> 0x0050, all -> 0x004d }
            r4 = -1
            r5 = 0
            if (r3 == 0) goto L_0x0030
        L_0x001c:
            int r3 = r2.read(r1, r5, r9)     // Catch:{ IOException -> 0x0050, all -> 0x004d }
            if (r3 == r4) goto L_0x0044
            r6 = 0
        L_0x0023:
            if (r6 >= r3) goto L_0x001c
            byte r7 = r1[r6]     // Catch:{ IOException -> 0x0050, all -> 0x004d }
            r8 = 10
            if (r7 != r8) goto L_0x002d
            int r0 = r0 + 1
        L_0x002d:
            int r6 = r6 + 1
            goto L_0x0023
        L_0x0030:
            int r3 = r2.read(r1, r5, r9)     // Catch:{ IOException -> 0x0050, all -> 0x004d }
            if (r3 == r4) goto L_0x0044
            r6 = 0
        L_0x0037:
            if (r6 >= r3) goto L_0x0030
            byte r7 = r1[r6]     // Catch:{ IOException -> 0x0050, all -> 0x004d }
            r8 = 13
            if (r7 != r8) goto L_0x0041
            int r0 = r0 + 1
        L_0x0041:
            int r6 = r6 + 1
            goto L_0x0037
        L_0x0044:
            r2.close()     // Catch:{ IOException -> 0x0048 }
            goto L_0x005e
        L_0x0048:
            r9 = move-exception
            r9.printStackTrace()
            goto L_0x005e
        L_0x004d:
            r9 = move-exception
            r1 = r2
            goto L_0x005f
        L_0x0050:
            r9 = move-exception
            r1 = r2
            goto L_0x0056
        L_0x0053:
            r9 = move-exception
            goto L_0x005f
        L_0x0055:
            r9 = move-exception
        L_0x0056:
            r9.printStackTrace()     // Catch:{ all -> 0x0053 }
            if (r1 == 0) goto L_0x005e
            r1.close()     // Catch:{ IOException -> 0x0048 }
        L_0x005e:
            return r0
        L_0x005f:
            if (r1 == 0) goto L_0x0069
            r1.close()     // Catch:{ IOException -> 0x0065 }
            goto L_0x0069
        L_0x0065:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0069:
            goto L_0x006b
        L_0x006a:
            throw r9
        L_0x006b:
            goto L_0x006a
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.FileUtils.getFileLines(java.io.File):int");
    }

    public static int getFileLines(String str) {
        return getFileLines(getFileByPath(str));
    }

    /* JADX WARNING: Removed duplicated region for block: B:23:0x003e A[SYNTHETIC, Splitter:B:23:0x003e] */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004b A[SYNTHETIC, Splitter:B:31:0x004b] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static byte[] getFileMD5(java.io.File r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0004
            return r0
        L_0x0004:
            java.io.FileInputStream r1 = new java.io.FileInputStream     // Catch:{ NoSuchAlgorithmException -> 0x0037, IOException -> 0x0035, all -> 0x0033 }
            r1.<init>(r3)     // Catch:{ NoSuchAlgorithmException -> 0x0037, IOException -> 0x0035, all -> 0x0033 }
            java.lang.String r3 = "MD5"
            java.security.MessageDigest r3 = java.security.MessageDigest.getInstance(r3)     // Catch:{ NoSuchAlgorithmException -> 0x0037, IOException -> 0x0035, all -> 0x0033 }
            java.security.DigestInputStream r2 = new java.security.DigestInputStream     // Catch:{ NoSuchAlgorithmException -> 0x0037, IOException -> 0x0035, all -> 0x0033 }
            r2.<init>(r1, r3)     // Catch:{ NoSuchAlgorithmException -> 0x0037, IOException -> 0x0035, all -> 0x0033 }
            r3 = 262144(0x40000, float:3.67342E-40)
            byte[] r3 = new byte[r3]     // Catch:{ NoSuchAlgorithmException -> 0x0031, IOException -> 0x002f }
        L_0x0018:
            int r1 = r2.read(r3)     // Catch:{ NoSuchAlgorithmException -> 0x0031, IOException -> 0x002f }
            if (r1 > 0) goto L_0x0018
            java.security.MessageDigest r3 = r2.getMessageDigest()     // Catch:{ NoSuchAlgorithmException -> 0x0031, IOException -> 0x002f }
            byte[] r3 = r3.digest()     // Catch:{ NoSuchAlgorithmException -> 0x0031, IOException -> 0x002f }
            r2.close()     // Catch:{ IOException -> 0x002a }
            goto L_0x002e
        L_0x002a:
            r0 = move-exception
            r0.printStackTrace()
        L_0x002e:
            return r3
        L_0x002f:
            r3 = move-exception
            goto L_0x0039
        L_0x0031:
            r3 = move-exception
            goto L_0x0039
        L_0x0033:
            r3 = move-exception
            goto L_0x0049
        L_0x0035:
            r3 = move-exception
            goto L_0x0038
        L_0x0037:
            r3 = move-exception
        L_0x0038:
            r2 = r0
        L_0x0039:
            r3.printStackTrace()     // Catch:{ all -> 0x0047 }
            if (r2 == 0) goto L_0x0046
            r2.close()     // Catch:{ IOException -> 0x0042 }
            goto L_0x0046
        L_0x0042:
            r3 = move-exception
            r3.printStackTrace()
        L_0x0046:
            return r0
        L_0x0047:
            r3 = move-exception
            r0 = r2
        L_0x0049:
            if (r0 == 0) goto L_0x0053
            r0.close()     // Catch:{ IOException -> 0x004f }
            goto L_0x0053
        L_0x004f:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0053:
            goto L_0x0055
        L_0x0054:
            throw r3
        L_0x0055:
            goto L_0x0054
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.FileUtils.getFileMD5(java.io.File):byte[]");
    }

    public static byte[] getFileMD5(String str) {
        return getFileMD5(getFileByPath(str));
    }

    public static String getFileMD5ToString(File file) {
        return UtilsBridge.bytes2HexString(getFileMD5(file));
    }

    public static String getFileMD5ToString(String str) {
        return getFileMD5ToString(UtilsBridge.isSpace(str) ? null : new File(str));
    }

    public static String getFileName(File file) {
        return file == null ? "" : getFileName(file.getAbsolutePath());
    }

    public static String getFileName(String str) {
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(File.separator);
        return lastIndexOf == -1 ? str : str.substring(lastIndexOf + 1);
    }

    public static String getFileNameNoExtension(File file) {
        return file == null ? "" : getFileNameNoExtension(file.getPath());
    }

    public static String getFileNameNoExtension(String str) {
        if (UtilsBridge.isSpace(str)) {
            return "";
        }
        int lastIndexOf = str.lastIndexOf(46);
        int lastIndexOf2 = str.lastIndexOf(File.separator);
        return lastIndexOf2 == -1 ? lastIndexOf == -1 ? str : str.substring(0, lastIndexOf) : (lastIndexOf == -1 || lastIndexOf2 > lastIndexOf) ? str.substring(lastIndexOf2 + 1) : str.substring(lastIndexOf2 + 1, lastIndexOf);
    }

    private static String getFileSize(File file) {
        long fileLength = getFileLength(file);
        return fileLength == -1 ? "" : UtilsBridge.byte2FitMemorySize(fileLength);
    }

    public static long getFsAvailableSize(String str) {
        long j2;
        long j3;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        StatFs statFs = new StatFs(str);
        if (Build.VERSION.SDK_INT >= 18) {
            j3 = statFs.getBlockSizeLong();
            j2 = statFs.getAvailableBlocksLong();
        } else {
            j3 = (long) statFs.getBlockSize();
            j2 = (long) statFs.getAvailableBlocks();
        }
        return j3 * j2;
    }

    public static long getFsTotalSize(String str) {
        long j2;
        long j3;
        if (TextUtils.isEmpty(str)) {
            return 0;
        }
        StatFs statFs = new StatFs(str);
        if (Build.VERSION.SDK_INT >= 18) {
            j3 = statFs.getBlockSizeLong();
            j2 = statFs.getBlockCountLong();
        } else {
            j3 = (long) statFs.getBlockSize();
            j2 = (long) statFs.getBlockCount();
        }
        return j3 * j2;
    }

    public static long getLength(File file) {
        if (file == null) {
            return 0;
        }
        return file.isDirectory() ? getDirLength(file) : getFileLength(file);
    }

    public static long getLength(String str) {
        return getLength(getFileByPath(str));
    }

    public static String getSize(File file) {
        return file == null ? "" : file.isDirectory() ? getDirSize(file) : getFileSize(file);
    }

    public static String getSize(String str) {
        return getSize(getFileByPath(str));
    }

    public static boolean isDir(File file) {
        return file != null && file.exists() && file.isDirectory();
    }

    public static boolean isDir(String str) {
        return isDir(getFileByPath(str));
    }

    public static boolean isFile(File file) {
        return file != null && file.exists() && file.isFile();
    }

    public static boolean isFile(String str) {
        return isFile(getFileByPath(str));
    }

    public static boolean isFileExists(File file) {
        if (file == null) {
            return false;
        }
        if (file.exists()) {
            return true;
        }
        return isFileExists(file.getAbsolutePath());
    }

    public static boolean isFileExists(String str) {
        File fileByPath = getFileByPath(str);
        if (fileByPath == null) {
            return false;
        }
        if (fileByPath.exists()) {
            return true;
        }
        return isFileExistsApi29(str);
    }

    private static boolean isFileExistsApi29(String str) {
        if (Build.VERSION.SDK_INT >= 29) {
            try {
                AssetFileDescriptor openAssetFileDescriptor = Utils.getApp().getContentResolver().openAssetFileDescriptor(Uri.parse(str), "r");
                if (openAssetFileDescriptor == null) {
                    return false;
                }
                try {
                    openAssetFileDescriptor.close();
                    return true;
                } catch (IOException unused) {
                    return true;
                }
            } catch (FileNotFoundException unused2) {
            }
        }
        return false;
    }

    private static int isUtf8(byte[] bArr) {
        if (bArr.length > 3 && bArr[0] == -17 && bArr[1] == -69 && bArr[2] == -65) {
            return 100;
        }
        int length = bArr.length;
        int i2 = 0;
        int i3 = 0;
        int i4 = 0;
        loop0:
        while (true) {
            int i5 = 0;
            while (i2 < length) {
                if ((bArr[i2] & -1) == -1 || (bArr[i2] & -2) == -2) {
                    return 0;
                }
                if (i5 == 0) {
                    if ((bArr[i2] & Byte.MAX_VALUE) == bArr[i2] && bArr[i2] != 0) {
                        i3++;
                    } else if ((bArr[i2] & -64) == -64) {
                        int i6 = i5;
                        for (int i7 = 0; i7 < 8; i7++) {
                            byte b2 = (byte) (128 >> i7);
                            if ((bArr[i2] & b2) != b2) {
                                break;
                            }
                            i6 = i7;
                        }
                        i4++;
                        i5 = i6;
                    }
                    i2++;
                } else {
                    if (bArr.length - i2 <= i5) {
                        i5 = bArr.length - i2;
                    }
                    boolean z2 = false;
                    for (int i8 = 0; i8 < i5; i8++) {
                        int i9 = i2 + i8;
                        if ((bArr[i9] & Byte.MIN_VALUE) != Byte.MIN_VALUE) {
                            if ((bArr[i9] & Byte.MAX_VALUE) == bArr[i9] && bArr[i2] != 0) {
                                i3++;
                            }
                            z2 = true;
                        }
                    }
                    if (z2) {
                        i4--;
                        i2++;
                    } else {
                        i4 += i5;
                        i2 += i5;
                    }
                }
            }
            if (i3 == length) {
                return 100;
            }
            return (int) ((((float) (i4 + i3)) / ((float) length)) * 100.0f);
        }
        return 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:32:0x0048 A[SYNTHETIC, Splitter:B:32:0x0048] */
    /* JADX WARNING: Removed duplicated region for block: B:38:0x0053 A[SYNTHETIC, Splitter:B:38:0x0053] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static boolean isUtf8(java.io.File r5) {
        /*
            r0 = 0
            if (r5 != 0) goto L_0x0004
            return r0
        L_0x0004:
            r1 = 0
            r2 = 24
            byte[] r2 = new byte[r2]     // Catch:{ IOException -> 0x0042 }
            java.io.BufferedInputStream r3 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0042 }
            java.io.FileInputStream r4 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0042 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0042 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0042 }
            int r5 = r3.read(r2)     // Catch:{ IOException -> 0x003d, all -> 0x003a }
            r1 = -1
            if (r5 == r1) goto L_0x0031
            byte[] r1 = new byte[r5]     // Catch:{ IOException -> 0x003d, all -> 0x003a }
            java.lang.System.arraycopy(r2, r0, r1, r0, r5)     // Catch:{ IOException -> 0x003d, all -> 0x003a }
            int r5 = isUtf8((byte[]) r1)     // Catch:{ IOException -> 0x003d, all -> 0x003a }
            r1 = 100
            if (r5 != r1) goto L_0x0028
            r0 = 1
        L_0x0028:
            r3.close()     // Catch:{ IOException -> 0x002c }
            goto L_0x0030
        L_0x002c:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0030:
            return r0
        L_0x0031:
            r3.close()     // Catch:{ IOException -> 0x0035 }
            goto L_0x0039
        L_0x0035:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0039:
            return r0
        L_0x003a:
            r5 = move-exception
            r1 = r3
            goto L_0x0051
        L_0x003d:
            r5 = move-exception
            r1 = r3
            goto L_0x0043
        L_0x0040:
            r5 = move-exception
            goto L_0x0051
        L_0x0042:
            r5 = move-exception
        L_0x0043:
            r5.printStackTrace()     // Catch:{ all -> 0x0040 }
            if (r1 == 0) goto L_0x0050
            r1.close()     // Catch:{ IOException -> 0x004c }
            goto L_0x0050
        L_0x004c:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0050:
            return r0
        L_0x0051:
            if (r1 == 0) goto L_0x005b
            r1.close()     // Catch:{ IOException -> 0x0057 }
            goto L_0x005b
        L_0x0057:
            r0 = move-exception
            r0.printStackTrace()
        L_0x005b:
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.blankj.utilcode.util.FileUtils.isUtf8(java.io.File):boolean");
    }

    public static boolean isUtf8(String str) {
        return isUtf8(getFileByPath(str));
    }

    public static List<File> listFilesInDir(File file) {
        return listFilesInDir(file, (Comparator<File>) null);
    }

    public static List<File> listFilesInDir(File file, Comparator<File> comparator) {
        return listFilesInDir(file, false, comparator);
    }

    public static List<File> listFilesInDir(File file, boolean z2) {
        return listFilesInDir(file, z2, (Comparator<File>) null);
    }

    public static List<File> listFilesInDir(File file, boolean z2, Comparator<File> comparator) {
        return listFilesInDirWithFilter(file, (FileFilter) new FileFilter() {
            public boolean accept(File file) {
                return true;
            }
        }, z2, comparator);
    }

    public static List<File> listFilesInDir(String str) {
        return listFilesInDir(str, (Comparator<File>) null);
    }

    public static List<File> listFilesInDir(String str, Comparator<File> comparator) {
        return listFilesInDir(getFileByPath(str), false, comparator);
    }

    public static List<File> listFilesInDir(String str, boolean z2) {
        return listFilesInDir(getFileByPath(str), z2);
    }

    public static List<File> listFilesInDir(String str, boolean z2, Comparator<File> comparator) {
        return listFilesInDir(getFileByPath(str), z2, comparator);
    }

    public static List<File> listFilesInDirWithFilter(File file, FileFilter fileFilter) {
        return listFilesInDirWithFilter(file, fileFilter, false, (Comparator<File>) null);
    }

    public static List<File> listFilesInDirWithFilter(File file, FileFilter fileFilter, Comparator<File> comparator) {
        return listFilesInDirWithFilter(file, fileFilter, false, comparator);
    }

    public static List<File> listFilesInDirWithFilter(File file, FileFilter fileFilter, boolean z2) {
        return listFilesInDirWithFilter(file, fileFilter, z2, (Comparator<File>) null);
    }

    public static List<File> listFilesInDirWithFilter(File file, FileFilter fileFilter, boolean z2, Comparator<File> comparator) {
        List<File> listFilesInDirWithFilterInner = listFilesInDirWithFilterInner(file, fileFilter, z2);
        if (comparator != null) {
            Collections.sort(listFilesInDirWithFilterInner, comparator);
        }
        return listFilesInDirWithFilterInner;
    }

    public static List<File> listFilesInDirWithFilter(String str, FileFilter fileFilter) {
        return listFilesInDirWithFilter(getFileByPath(str), fileFilter);
    }

    public static List<File> listFilesInDirWithFilter(String str, FileFilter fileFilter, Comparator<File> comparator) {
        return listFilesInDirWithFilter(getFileByPath(str), fileFilter, comparator);
    }

    public static List<File> listFilesInDirWithFilter(String str, FileFilter fileFilter, boolean z2) {
        return listFilesInDirWithFilter(getFileByPath(str), fileFilter, z2);
    }

    public static List<File> listFilesInDirWithFilter(String str, FileFilter fileFilter, boolean z2, Comparator<File> comparator) {
        return listFilesInDirWithFilter(getFileByPath(str), fileFilter, z2, comparator);
    }

    private static List<File> listFilesInDirWithFilterInner(File file, FileFilter fileFilter, boolean z2) {
        File[] listFiles;
        ArrayList arrayList = new ArrayList();
        if (isDir(file) && (listFiles = file.listFiles()) != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (fileFilter.accept(file2)) {
                    arrayList.add(file2);
                }
                if (z2 && file2.isDirectory()) {
                    arrayList.addAll(listFilesInDirWithFilterInner(file2, fileFilter, true));
                }
            }
        }
        return arrayList;
    }

    public static boolean move(File file, File file2) {
        return move(file, file2, (OnReplaceListener) null);
    }

    public static boolean move(File file, File file2, OnReplaceListener onReplaceListener) {
        if (file == null) {
            return false;
        }
        return file.isDirectory() ? moveDir(file, file2, onReplaceListener) : moveFile(file, file2, onReplaceListener);
    }

    public static boolean move(String str, String str2) {
        return move(getFileByPath(str), getFileByPath(str2), (OnReplaceListener) null);
    }

    public static boolean move(String str, String str2, OnReplaceListener onReplaceListener) {
        return move(getFileByPath(str), getFileByPath(str2), onReplaceListener);
    }

    public static boolean moveDir(File file, File file2, OnReplaceListener onReplaceListener) {
        return copyOrMoveDir(file, file2, onReplaceListener, true);
    }

    public static boolean moveFile(File file, File file2, OnReplaceListener onReplaceListener) {
        return copyOrMoveFile(file, file2, onReplaceListener, true);
    }

    public static void notifySystemToScan(File file) {
        if (file != null && file.exists()) {
            Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
            intent.setData(Uri.parse("file://" + file.getAbsolutePath()));
            Utils.getApp().sendBroadcast(intent);
        }
    }

    public static void notifySystemToScan(String str) {
        notifySystemToScan(getFileByPath(str));
    }

    public static boolean rename(File file, String str) {
        if (file == null || !file.exists() || UtilsBridge.isSpace(str)) {
            return false;
        }
        if (str.equals(file.getName())) {
            return true;
        }
        File file2 = new File(file.getParent() + File.separator + str);
        return !file2.exists() && file.renameTo(file2);
    }

    public static boolean rename(String str, String str2) {
        return rename(getFileByPath(str), str2);
    }
}
