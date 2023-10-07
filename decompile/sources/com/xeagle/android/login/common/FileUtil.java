package com.xeagle.android.login.common;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.MimeTypeMap;
import com.cfly.uav_pro.R;
import java.util.Locale;

public class FileUtil {
    private static final String TAG = "FileUtil";

    /* renamed from: com.xeagle.android.login.common.FileUtil$1  reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$xeagle$android$login$common$FileUtil$SizeUnit;

        /* JADX WARNING: Can't wrap try/catch for region: R(12:0|1|2|3|4|5|6|7|8|9|10|12) */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.xeagle.android.login.common.FileUtil$SizeUnit[] r0 = com.xeagle.android.login.common.FileUtil.SizeUnit.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$xeagle$android$login$common$FileUtil$SizeUnit = r0
                com.xeagle.android.login.common.FileUtil$SizeUnit r1 = com.xeagle.android.login.common.FileUtil.SizeUnit.Byte     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$xeagle$android$login$common$FileUtil$SizeUnit     // Catch:{ NoSuchFieldError -> 0x001d }
                com.xeagle.android.login.common.FileUtil$SizeUnit r1 = com.xeagle.android.login.common.FileUtil.SizeUnit.KB     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$xeagle$android$login$common$FileUtil$SizeUnit     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.xeagle.android.login.common.FileUtil$SizeUnit r1 = com.xeagle.android.login.common.FileUtil.SizeUnit.MB     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$xeagle$android$login$common$FileUtil$SizeUnit     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.xeagle.android.login.common.FileUtil$SizeUnit r1 = com.xeagle.android.login.common.FileUtil.SizeUnit.GB     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$xeagle$android$login$common$FileUtil$SizeUnit     // Catch:{ NoSuchFieldError -> 0x003e }
                com.xeagle.android.login.common.FileUtil$SizeUnit r1 = com.xeagle.android.login.common.FileUtil.SizeUnit.TB     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.common.FileUtil.AnonymousClass1.<clinit>():void");
        }
    }

    public enum SizeUnit {
        Byte,
        KB,
        MB,
        GB,
        TB,
        Auto
    }

    public static String formatFileSize(Context context, long j2) {
        return formatFileSize(context, j2, SizeUnit.Auto);
    }

    public static String formatFileSize(Context context, long j2, SizeUnit sizeUnit) {
        if (j2 < 0) {
            return context.getString(R.string.error_sd_unknown);
        }
        if (sizeUnit == SizeUnit.Auto) {
            double d2 = (double) j2;
            sizeUnit = d2 < 1024.0d ? SizeUnit.Byte : d2 < 1048576.0d ? SizeUnit.KB : d2 < 1.073741824E9d ? SizeUnit.MB : d2 < 1.099511627776E12d ? SizeUnit.GB : SizeUnit.TB;
        }
        int i2 = AnonymousClass1.$SwitchMap$com$xeagle$android$login$common$FileUtil$SizeUnit[sizeUnit.ordinal()];
        if (i2 == 1) {
            return j2 + "B";
        } else if (i2 == 2) {
            Locale locale = Locale.US;
            double d3 = (double) j2;
            Double.isNaN(d3);
            return String.format(locale, "%.2fKB", new Object[]{Double.valueOf(d3 / 1024.0d)});
        } else if (i2 == 3) {
            Locale locale2 = Locale.US;
            double d4 = (double) j2;
            Double.isNaN(d4);
            return String.format(locale2, "%.2fMB", new Object[]{Double.valueOf(d4 / 1048576.0d)});
        } else if (i2 == 4) {
            Locale locale3 = Locale.US;
            double d5 = (double) j2;
            Double.isNaN(d5);
            return String.format(locale3, "%.2fGB", new Object[]{Double.valueOf(d5 / 1.073741824E9d)});
        } else if (i2 != 5) {
            return j2 + "B";
        } else {
            Locale locale4 = Locale.US;
            double d6 = (double) j2;
            Double.isNaN(d6);
            return String.format(locale4, "%.2fPB", new Object[]{Double.valueOf(d6 / 1.099511627776E12d)});
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = r2.lastIndexOf(46);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getExtensionName(java.lang.String r2) {
        /*
            if (r2 == 0) goto L_0x0020
            int r0 = r2.length()
            if (r0 <= 0) goto L_0x0020
            r0 = 46
            int r0 = r2.lastIndexOf(r0)
            r1 = -1
            if (r0 <= r1) goto L_0x0020
            int r1 = r2.length()
            int r1 = r1 + -1
            if (r0 >= r1) goto L_0x0020
            int r0 = r0 + 1
            java.lang.String r2 = r2.substring(r0)
            return r2
        L_0x0020:
            java.lang.String r2 = ""
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.common.FileUtil.getExtensionName(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = r2.lastIndexOf(47);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileNameFromPath(java.lang.String r2) {
        /*
            if (r2 == 0) goto L_0x001f
            int r0 = r2.length()
            if (r0 <= 0) goto L_0x001f
            r0 = 47
            int r0 = r2.lastIndexOf(r0)
            r1 = -1
            if (r0 <= r1) goto L_0x001f
            int r1 = r2.length()
            int r1 = r1 + -1
            if (r0 >= r1) goto L_0x001f
            int r0 = r0 + 1
            java.lang.String r2 = r2.substring(r0)
        L_0x001f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.common.FileUtil.getFileNameFromPath(java.lang.String):java.lang.String");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = r2.lastIndexOf(46);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String getFileNameNoEx(java.lang.String r2) {
        /*
            if (r2 == 0) goto L_0x001c
            int r0 = r2.length()
            if (r0 <= 0) goto L_0x001c
            r0 = 46
            int r0 = r2.lastIndexOf(r0)
            r1 = -1
            if (r0 <= r1) goto L_0x001c
            int r1 = r2.length()
            if (r0 >= r1) goto L_0x001c
            r1 = 0
            java.lang.String r2 = r2.substring(r1, r0)
        L_0x001c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.common.FileUtil.getFileNameNoEx(java.lang.String):java.lang.String");
    }

    public static String getMimeType(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String str2 = null;
        String extensionName = getExtensionName(str.toLowerCase());
        if (!TextUtils.isEmpty(extensionName)) {
            str2 = MimeTypeMap.getSingleton().getMimeTypeFromExtension(extensionName);
        }
        Log.i(TAG, "url:" + str + " type:" + str2);
        return (!StringUtil.isEmpty(str2) || !str.endsWith("aac")) ? str2 : "audio/aac";
    }

    public static boolean hasExtentsion(String str) {
        int lastIndexOf = str.lastIndexOf(46);
        return lastIndexOf > -1 && lastIndexOf < str.length() - 1;
    }
}
