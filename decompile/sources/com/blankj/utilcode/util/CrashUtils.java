package com.blankj.utilcode.util;

import com.blankj.utilcode.util.UtilsBridge;
import java.io.File;
import java.lang.Thread;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.Objects;

public final class CrashUtils {
    /* access modifiers changed from: private */
    public static final Thread.UncaughtExceptionHandler DEFAULT_UNCAUGHT_EXCEPTION_HANDLER = Thread.getDefaultUncaughtExceptionHandler();
    private static final String FILE_SEP = System.getProperty("file.separator");

    public static final class CrashInfo {
        private UtilsBridge.FileHead mFileHeadProvider;
        private Throwable mThrowable;

        private CrashInfo(String str, Throwable th) {
            this.mThrowable = th;
            UtilsBridge.FileHead fileHead = new UtilsBridge.FileHead("Crash");
            this.mFileHeadProvider = fileHead;
            fileHead.addFirst("Time Of Crash", str);
        }

        public final void addExtraHead(String str, String str2) {
            this.mFileHeadProvider.append(str, str2);
        }

        public final void addExtraHead(Map<String, String> map) {
            this.mFileHeadProvider.append(map);
        }

        public final Throwable getThrowable() {
            return this.mThrowable;
        }

        public String toString() {
            return this.mFileHeadProvider.toString() + UtilsBridge.getFullStackTrace(this.mThrowable);
        }
    }

    public interface OnCrashListener {
        void onCrash(CrashInfo crashInfo);
    }

    private CrashUtils() {
        throw new UnsupportedOperationException("u can't instantiate me...");
    }

    private static Thread.UncaughtExceptionHandler getUncaughtExceptionHandler(final String str, final OnCrashListener onCrashListener) {
        return new Thread.UncaughtExceptionHandler() {
            public void uncaughtException(Thread thread, Throwable th) {
                Objects.requireNonNull(thread, "Argument 't' of type Thread (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                Objects.requireNonNull(th, "Argument 'e' of type Throwable (#1 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
                String format = new SimpleDateFormat("yyyy_MM_dd-HH_mm_ss").format(new Date());
                CrashInfo crashInfo = new CrashInfo(format, th);
                OnCrashListener onCrashListener = onCrashListener;
                if (onCrashListener != null) {
                    onCrashListener.onCrash(crashInfo);
                }
                UtilsBridge.writeFileFromString(str + format + ".txt", crashInfo.toString(), true);
                if (CrashUtils.DEFAULT_UNCAUGHT_EXCEPTION_HANDLER != null) {
                    CrashUtils.DEFAULT_UNCAUGHT_EXCEPTION_HANDLER.uncaughtException(thread, th);
                }
            }
        };
    }

    public static void init() {
        init("");
    }

    public static void init(OnCrashListener onCrashListener) {
        init("", onCrashListener);
    }

    public static void init(File file) {
        Objects.requireNonNull(file, "Argument 'crashDir' of type File (#0 out of 1, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        init(file.getAbsolutePath(), (OnCrashListener) null);
    }

    public static void init(File file, OnCrashListener onCrashListener) {
        Objects.requireNonNull(file, "Argument 'crashDir' of type File (#0 out of 2, zero-based) is marked by @androidx.annotation.NonNull but got null for it");
        init(file.getAbsolutePath(), onCrashListener);
    }

    public static void init(String str) {
        init(str, (OnCrashListener) null);
    }

    public static void init(String str, OnCrashListener onCrashListener) {
        StringBuilder sb;
        File file;
        if (UtilsBridge.isSpace(str)) {
            if (!UtilsBridge.isSDCardEnableByEnvironment() || Utils.getApp().getExternalFilesDir((String) null) == null) {
                sb = new StringBuilder();
                file = Utils.getApp().getFilesDir();
            } else {
                sb = new StringBuilder();
                file = Utils.getApp().getExternalFilesDir((String) null);
            }
            sb.append(file);
            String str2 = FILE_SEP;
            sb.append(str2);
            sb.append("crash");
            sb.append(str2);
            str = sb.toString();
        } else {
            String str3 = FILE_SEP;
            if (!str.endsWith(str3)) {
                str = str + str3;
            }
        }
        Thread.setDefaultUncaughtExceptionHandler(getUncaughtExceptionHandler(str, onCrashListener));
    }
}
