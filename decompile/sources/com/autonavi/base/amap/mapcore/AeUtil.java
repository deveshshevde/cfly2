package com.autonavi.base.amap.mapcore;

import android.content.Context;
import android.os.Looper;
import com.amap.api.mapcore.util.di;
import com.amap.api.mapcore.util.dj;
import com.amap.api.mapcore.util.dl;
import com.amap.api.mapcore.util.dm;
import com.amap.api.mapcore.util.dn;
import com.amap.api.mapcore.util.ff;
import com.amap.api.mapcore.util.fz;
import com.amap.api.mapcore.util.gh;
import com.amap.api.mapcore.util.gj;
import com.amap.api.mapcore.util.ie;
import com.autonavi.amap.mapcore.MsgProcessor;
import com.autonavi.base.ae.gmap.GLMapEngine;
import com.autonavi.config.a;
import java.io.File;

public class AeUtil {
    private static final String AMAP_ASSETS_DB_CK_PATH = "ae/res.ck";
    private static final String AMAP_GLOBAL_DB_NAME = "global.db";
    private static final String AMAP_GLOBAL_SP_ITEM_MD5 = "amap_res_global_db_md5";
    private static final String AMAP_GLOBAL_SP_NAME = "amap_res_global_db";
    public static final String AMAP_RESZIP_TARGET_DIR_NAME = "res780";
    public static final String CONFIGNAME = "GNaviConfig.xml";
    public static final boolean IS_AE = true;
    public static final String RESZIPNAME = "res.zip";
    public static final String ROOTPATH = "/amap/";
    public static final String ROOT_DATA_PATH_NAME = "data_v6";
    public static final String ROOT_DATA_PATH_OLD_NAME = "data";
    private static String global_db_path;

    private static boolean checkEngineRes(File file) {
        File[] listFiles = file.listFiles();
        if (listFiles != null && listFiles.length > 0) {
            for (File file2 : listFiles) {
                if (file2 != null && file2.getName().contains(AMAP_GLOBAL_DB_NAME)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static String formatFileSeparator(String str) {
        return str != null ? str.replace("//", "/") : str;
    }

    private static String getAssetsGlobalDbMd5(Context context) {
        return new String(FileUtil.readFileContentsFromAssets(context, AMAP_ASSETS_DB_CK_PATH));
    }

    public static String getGlobalDbPath() {
        return global_db_path;
    }

    public static void initCrashHandle(Context context) {
        ff a2;
        try {
            gj.a();
            if (gh.a(dl.a()).a(context) && (a2 = dl.a()) != null) {
                MsgProcessor.nativeInitInfo(context, gh.a(a2).b(context), a2.a(), a2.b(), a2.c(), a2.g());
            }
        } catch (Throwable th) {
            dl.a(th);
        }
    }

    public static GLMapEngine.InitParam initResource(final Context context) {
        final String mapBaseStorage = FileUtil.getMapBaseStorage(context);
        String str = mapBaseStorage + "/data_v6/";
        File file = new File(mapBaseStorage);
        if (!file.exists()) {
            file.mkdir();
        }
        File file2 = new File(str);
        if (!file2.exists()) {
            file2.mkdir();
        }
        if (Looper.myLooper() == Looper.getMainLooper()) {
            try {
                dj.a().a(new ie() {
                    public final void runTask() {
                        AeUtil.loadEngineRes(mapBaseStorage, context);
                    }
                });
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } else {
            loadEngineRes(mapBaseStorage, context);
        }
        GLMapEngine.InitParam initParam = new GLMapEngine.InitParam();
        byte[] readFileContentsFromAssets = FileUtil.readFileContentsFromAssets(context, "ae/GNaviConfig.xml");
        initParam.mRootPath = mapBaseStorage;
        if (readFileContentsFromAssets != null) {
            try {
                initParam.mConfigContent = new String(readFileContentsFromAssets, "utf-8");
                if (!initParam.mConfigContent.contains(ROOT_DATA_PATH_NAME)) {
                    throw new Exception("GNaviConfig.xml 和数据目录data_v6不匹配");
                }
            } catch (Throwable th) {
                th.printStackTrace();
                di.c(context, "initConfig error:" + th.getMessage());
            }
        }
        initParam.mOfflineDataPath = str + "/map/";
        initParam.mP3dCrossPath = str;
        initParam.mOfflineDataPath = formatFileSeparator(initParam.mOfflineDataPath);
        initParam.mRootPath = formatFileSeparator(initParam.mRootPath);
        initParam.mP3dCrossPath = formatFileSeparator(initParam.mP3dCrossPath);
        return initParam;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0040, code lost:
        if (r8.equals(r10) != false) goto L_0x0043;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0047  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x004f A[SYNTHETIC, Splitter:B:19:0x004f] */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00c9  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00dc  */
    /* JADX WARNING: Removed duplicated region for block: B:49:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void loadEngineRes(java.lang.String r10, android.content.Context r11) {
        /*
            java.lang.String r0 = "loadEngineRes error:"
            java.io.File r1 = new java.io.File
            java.lang.String r2 = "res780"
            r1.<init>(r10, r2)
            boolean r10 = r1.exists()
            r2 = 1
            r3 = 0
            r4 = 0
            if (r10 == 0) goto L_0x0018
            boolean r10 = r1.isDirectory()
            if (r10 != 0) goto L_0x0024
        L_0x0018:
            boolean r10 = r1.mkdirs()
            if (r10 == 0) goto L_0x0024
            java.lang.String r10 = getAssetsGlobalDbMd5(r11)
            r5 = 1
            goto L_0x0026
        L_0x0024:
            r10 = r4
            r5 = 0
        L_0x0026:
            java.lang.String r6 = "amap_res_global_db_md5"
            java.lang.String r7 = "amap_res_global_db"
            if (r5 != 0) goto L_0x0043
            java.lang.String r10 = getAssetsGlobalDbMd5(r11)
            java.lang.String r8 = ""
            java.lang.String r8 = com.amap.api.mapcore.util.db.a((android.content.Context) r11, (java.lang.String) r7, (java.lang.String) r6, (java.lang.String) r8)
            boolean r9 = android.text.TextUtils.isEmpty(r8)
            if (r9 != 0) goto L_0x0044
            boolean r8 = r8.equals(r10)
            if (r8 != 0) goto L_0x0043
            goto L_0x0044
        L_0x0043:
            r2 = r5
        L_0x0044:
            if (r2 == 0) goto L_0x0047
            goto L_0x004b
        L_0x0047:
            boolean r3 = checkEngineRes(r1)
        L_0x004b:
            java.lang.String r5 = "/global.db"
            if (r3 != 0) goto L_0x00c9
            android.content.res.AssetManager r3 = r11.getAssets()     // Catch:{ Exception -> 0x009e, OutOfMemoryError -> 0x007e }
            java.lang.String r8 = "ae/res.zip"
            java.io.InputStream r4 = r3.open(r8)     // Catch:{ Exception -> 0x009e, OutOfMemoryError -> 0x007e }
            java.lang.String r3 = r1.getAbsolutePath()     // Catch:{ Exception -> 0x009e, OutOfMemoryError -> 0x007e }
            com.autonavi.base.amap.mapcore.FileUtil.decompress(r4, r3)     // Catch:{ Exception -> 0x009e, OutOfMemoryError -> 0x007e }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x009e, OutOfMemoryError -> 0x007e }
            r3.<init>()     // Catch:{ Exception -> 0x009e, OutOfMemoryError -> 0x007e }
            r3.append(r1)     // Catch:{ Exception -> 0x009e, OutOfMemoryError -> 0x007e }
            r3.append(r5)     // Catch:{ Exception -> 0x009e, OutOfMemoryError -> 0x007e }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x009e, OutOfMemoryError -> 0x007e }
            global_db_path = r1     // Catch:{ Exception -> 0x009e, OutOfMemoryError -> 0x007e }
            if (r4 == 0) goto L_0x00da
            r4.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x00da
        L_0x0077:
            r0 = move-exception
            r0.printStackTrace()
            goto L_0x00da
        L_0x007c:
            r10 = move-exception
            goto L_0x00be
        L_0x007e:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x007c }
            com.amap.api.mapcore.util.dl.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x007c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            r3.<init>(r0)     // Catch:{ all -> 0x007c }
            java.lang.String r0 = r1.getMessage()     // Catch:{ all -> 0x007c }
            r3.append(r0)     // Catch:{ all -> 0x007c }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x007c }
            com.amap.api.mapcore.util.di.c((android.content.Context) r11, (java.lang.String) r0)     // Catch:{ all -> 0x007c }
            if (r4 == 0) goto L_0x00da
            r4.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x00da
        L_0x009e:
            r1 = move-exception
            r1.printStackTrace()     // Catch:{ all -> 0x007c }
            com.amap.api.mapcore.util.dl.a((java.lang.Throwable) r1)     // Catch:{ all -> 0x007c }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x007c }
            r3.<init>(r0)     // Catch:{ all -> 0x007c }
            java.lang.String r0 = r1.getMessage()     // Catch:{ all -> 0x007c }
            r3.append(r0)     // Catch:{ all -> 0x007c }
            java.lang.String r0 = r3.toString()     // Catch:{ all -> 0x007c }
            com.amap.api.mapcore.util.di.c((android.content.Context) r11, (java.lang.String) r0)     // Catch:{ all -> 0x007c }
            if (r4 == 0) goto L_0x00da
            r4.close()     // Catch:{ IOException -> 0x0077 }
            goto L_0x00da
        L_0x00be:
            if (r4 == 0) goto L_0x00c8
            r4.close()     // Catch:{ IOException -> 0x00c4 }
            goto L_0x00c8
        L_0x00c4:
            r11 = move-exception
            r11.printStackTrace()
        L_0x00c8:
            throw r10
        L_0x00c9:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r1)
            r0.append(r5)
            java.lang.String r0 = r0.toString()
            global_db_path = r0
        L_0x00da:
            if (r2 == 0) goto L_0x00df
            com.amap.api.mapcore.util.db.a((android.content.Context) r11, (java.lang.String) r7, (java.lang.String) r6, (java.lang.Object) r10)
        L_0x00df:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.amap.mapcore.AeUtil.loadEngineRes(java.lang.String, android.content.Context):void");
    }

    public static boolean loadLib(Context context) {
        try {
            if (!a.f10020b) {
                System.loadLibrary(a.f10019a);
                a.f10020b = true;
            }
            return true;
        } catch (Throwable th) {
            fz.c(th, "AeUtil", "loadLib");
            dl.a(th);
            String str = dm.f8269c;
            dn.b(str, "load so failed " + th.getMessage());
            return false;
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r4v7, resolved type: java.io.FileOutputStream} */
    /* JADX WARNING: type inference failed for: r4v1, types: [java.io.FileOutputStream] */
    /* JADX WARNING: type inference failed for: r4v4 */
    /* JADX WARNING: type inference failed for: r4v6 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0059 A[SYNTHETIC, Splitter:B:35:0x0059] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x0063 A[SYNTHETIC, Splitter:B:40:0x0063] */
    /* JADX WARNING: Removed duplicated region for block: B:60:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void readAssetsFileAndSave(java.lang.String r4, java.lang.String r5, android.content.Context r6) {
        /*
            boolean r0 = android.text.TextUtils.isEmpty(r4)
            if (r0 == 0) goto L_0x0007
            return
        L_0x0007:
            r0 = 0
            android.content.res.AssetManager r6 = r6.getAssets()     // Catch:{ all -> 0x0052 }
            java.io.InputStream r4 = r6.open(r4)     // Catch:{ all -> 0x0052 }
            java.io.File r6 = new java.io.File     // Catch:{ all -> 0x004d }
            r6.<init>(r5)     // Catch:{ all -> 0x004d }
            boolean r5 = r6.exists()     // Catch:{ all -> 0x004d }
            if (r5 == 0) goto L_0x001e
            r6.delete()     // Catch:{ all -> 0x004d }
        L_0x001e:
            r6.createNewFile()     // Catch:{ all -> 0x004d }
            java.io.FileOutputStream r5 = new java.io.FileOutputStream     // Catch:{ all -> 0x004d }
            r5.<init>(r6)     // Catch:{ all -> 0x004d }
            r6 = 1024(0x400, float:1.435E-42)
            byte[] r0 = new byte[r6]     // Catch:{ all -> 0x0048 }
        L_0x002a:
            r1 = 0
            int r2 = r4.read(r0, r1, r6)     // Catch:{ all -> 0x0048 }
            if (r2 <= 0) goto L_0x0035
            r5.write(r0, r1, r2)     // Catch:{ all -> 0x0048 }
            goto L_0x002a
        L_0x0035:
            if (r4 == 0) goto L_0x003f
            r4.close()     // Catch:{ IOException -> 0x003b }
            goto L_0x003f
        L_0x003b:
            r4 = move-exception
            r4.printStackTrace()
        L_0x003f:
            r5.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0047:
            return
        L_0x0048:
            r6 = move-exception
            r0 = r4
            r4 = r5
            r5 = r6
            goto L_0x0054
        L_0x004d:
            r5 = move-exception
            r3 = r0
            r0 = r4
            r4 = r3
            goto L_0x0054
        L_0x0052:
            r5 = move-exception
            r4 = r0
        L_0x0054:
            r5.printStackTrace()     // Catch:{ all -> 0x006c }
            if (r0 == 0) goto L_0x0061
            r0.close()     // Catch:{ IOException -> 0x005d }
            goto L_0x0061
        L_0x005d:
            r5 = move-exception
            r5.printStackTrace()
        L_0x0061:
            if (r4 == 0) goto L_0x006b
            r4.close()     // Catch:{ IOException -> 0x0067 }
            goto L_0x006b
        L_0x0067:
            r4 = move-exception
            r4.printStackTrace()
        L_0x006b:
            return
        L_0x006c:
            r5 = move-exception
            if (r0 == 0) goto L_0x0077
            r0.close()     // Catch:{ IOException -> 0x0073 }
            goto L_0x0077
        L_0x0073:
            r6 = move-exception
            r6.printStackTrace()
        L_0x0077:
            if (r4 == 0) goto L_0x0081
            r4.close()     // Catch:{ IOException -> 0x007d }
            goto L_0x0081
        L_0x007d:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0081:
            goto L_0x0083
        L_0x0082:
            throw r5
        L_0x0083:
            goto L_0x0082
        */
        throw new UnsupportedOperationException("Method not decompiled: com.autonavi.base.amap.mapcore.AeUtil.readAssetsFileAndSave(java.lang.String, java.lang.String, android.content.Context):void");
    }
}
