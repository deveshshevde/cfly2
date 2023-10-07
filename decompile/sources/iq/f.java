package iq;

import android.app.ActivityManager;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Build;
import android.os.Environment;
import android.os.PowerManager;
import android.os.Process;
import android.os.StatFs;
import android.text.TextUtils;
import com.liulishuo.filedownloader.download.c;
import com.liulishuo.filedownloader.exception.FileDownloadGiveUpRetryException;
import com.liulishuo.filedownloader.exception.FileDownloadSecurityException;
import com.liulishuo.filedownloader.model.FileDownloadModel;
import im.b;
import ip.a;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLDecoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class f {

    /* renamed from: a  reason: collision with root package name */
    private static int f29067a = 65536;

    /* renamed from: b  reason: collision with root package name */
    private static long f29068b = 2000;

    /* renamed from: c  reason: collision with root package name */
    private static String f29069c;

    /* renamed from: d  reason: collision with root package name */
    private static Boolean f29070d;

    /* renamed from: e  reason: collision with root package name */
    private static Boolean f29071e;

    /* renamed from: f  reason: collision with root package name */
    private static final Pattern f29072f = Pattern.compile("attachment;\\s*filename\\*\\s*=\\s*\"*([^\"]*)'\\S*'([^\"]*)\"*");

    /* renamed from: g  reason: collision with root package name */
    private static final Pattern f29073g = Pattern.compile("attachment;\\s*filename\\s*=\\s*\"*([^\"\\n]*)\"*");

    public static int a() {
        return f29067a;
    }

    public static int a(String str, String str2, boolean z2) {
        return c.a().b().a(str, str2, z2);
    }

    public static long a(b bVar) {
        long b2 = b(bVar);
        if (b2 < 0) {
            d.d(f.class, "don't get instance length fromContent-Range header", new Object[0]);
            b2 = -1;
        }
        if (b2 != 0 || !e.a().f29065h) {
            return b2;
        }
        return -1;
    }

    public static String a(int i2, b bVar) {
        if (bVar != null) {
            String a2 = bVar.a("Etag");
            if (d.f29057a) {
                d.c(f.class, "etag find %s for task(%d)", a2, Integer.valueOf(i2));
            }
            return a2;
        }
        throw new RuntimeException("connection is null when findEtag");
    }

    public static String a(b bVar, String str) throws FileDownloadSecurityException {
        String h2 = h(bVar.a("Content-Disposition"));
        if (TextUtils.isEmpty(h2)) {
            h2 = q(str);
        }
        if (TextUtils.isEmpty(h2)) {
            return c(str);
        }
        if (!h2.contains("../")) {
            return h2;
        }
        throw new FileDownloadSecurityException(a("The filename [%s] from the response is not allowable, because it contains '../', which can raise the directory traversal vulnerability", h2));
    }

    public static String a(String str, String str2) {
        if (str2 == null) {
            throw new IllegalStateException("can't generate real path, the file name is null");
        } else if (str != null) {
            return a("%s%s%s", str, File.separator, str2);
        } else {
            throw new IllegalStateException("can't generate real path, the directory is null");
        }
    }

    public static String a(String str, boolean z2, String str2) {
        if (str == null) {
            return null;
        }
        if (!z2) {
            return str;
        }
        if (str2 == null) {
            return null;
        }
        return a(str, str2);
    }

    public static String a(String str, Object... objArr) {
        return String.format(Locale.ENGLISH, str, objArr);
    }

    public static void a(int i2) throws IllegalAccessException {
        if (a(c.a())) {
            f29067a = i2;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-step'.");
    }

    public static void a(long j2) throws IllegalAccessException {
        if (a(c.a())) {
            f29068b = j2;
            return;
        }
        throw new IllegalAccessException("This value is used in the :filedownloader process, so set this value in your process is without effect. You can add 'process.non-separate=true' in 'filedownloader.properties' to share the main process to FileDownloadService. Or you can configure this value in 'filedownloader.properties' by 'download.min-progress-time'.");
    }

    public static boolean a(int i2, FileDownloadModel fileDownloadModel) {
        return a(i2, fileDownloadModel, (Boolean) null);
    }

    public static boolean a(int i2, FileDownloadModel fileDownloadModel, Boolean bool) {
        Class<f> cls = f.class;
        if (fileDownloadModel == null) {
            if (d.f29057a) {
                d.c(cls, "can't continue %d model == null", Integer.valueOf(i2));
            }
            return false;
        } else if (fileDownloadModel.e() != null) {
            return a(i2, fileDownloadModel, fileDownloadModel.e(), bool);
        } else {
            if (d.f29057a) {
                d.c(cls, "can't continue %d temp path == null", Integer.valueOf(i2));
            }
            return false;
        }
    }

    public static boolean a(int i2, FileDownloadModel fileDownloadModel, String str, Boolean bool) {
        Class<f> cls = f.class;
        if (str != null) {
            File file = new File(str);
            boolean exists = file.exists();
            boolean isDirectory = file.isDirectory();
            if (exists && !isDirectory) {
                long length = file.length();
                long g2 = fileDownloadModel.g();
                if (fileDownloadModel.n() > 1 || g2 != 0) {
                    long h2 = fileDownloadModel.h();
                    if (length < g2 || (h2 != -1 && (length > h2 || g2 >= h2))) {
                        if (!d.f29057a) {
                            return false;
                        }
                        d.c(cls, "can't continue %d dirty data fileLength[%d] sofar[%d] total[%d]", Integer.valueOf(i2), Long.valueOf(length), Long.valueOf(g2), Long.valueOf(h2));
                        return false;
                    } else if (bool == null || bool.booleanValue() || h2 != length) {
                        return true;
                    } else {
                        if (!d.f29057a) {
                            return false;
                        }
                        d.c(cls, "can't continue %d, because of the output stream doesn't support seek, but the task has already pre-allocated, so we only can download it from the very beginning.", Integer.valueOf(i2));
                        return false;
                    }
                } else if (!d.f29057a) {
                    return false;
                } else {
                    d.c(cls, "can't continue %d the downloaded-record is zero.", Integer.valueOf(i2));
                    return false;
                }
            } else if (!d.f29057a) {
                return false;
            } else {
                d.c(cls, "can't continue %d file not suit, exists[%B], directory[%B]", Integer.valueOf(i2), Boolean.valueOf(exists), Boolean.valueOf(isDirectory));
                return false;
            }
        } else if (!d.f29057a) {
            return false;
        } else {
            d.c(cls, "can't continue %d path = null", Integer.valueOf(i2));
            return false;
        }
    }

    public static boolean a(long j2, long j3) {
        return j2 > ((long) a()) && j3 > b();
    }

    public static boolean a(Context context) {
        Class<f> cls = f.class;
        Boolean bool = f29070d;
        if (bool != null) {
            return bool.booleanValue();
        }
        boolean z2 = false;
        if (!e.a().f29061d) {
            int myPid = Process.myPid();
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            if (activityManager != null) {
                List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
                if (runningAppProcesses != null && !runningAppProcesses.isEmpty()) {
                    Iterator<ActivityManager.RunningAppProcessInfo> it2 = runningAppProcesses.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        ActivityManager.RunningAppProcessInfo next = it2.next();
                        if (next.pid == myPid) {
                            z2 = next.processName.endsWith(":filedownloader");
                            break;
                        }
                    }
                } else {
                    d.d(cls, "The running app process info list from ActivityManager is null or empty, maybe current App is not running.", new Object[0]);
                    return false;
                }
            } else {
                d.d(cls, "fail to get the activity manager!", new Object[0]);
                return false;
            }
        } else {
            z2 = true;
        }
        Boolean valueOf = Boolean.valueOf(z2);
        f29070d = valueOf;
        return valueOf.booleanValue();
    }

    public static boolean a(String str) {
        return true;
    }

    public static int b(String str, String str2) {
        return c.a().b().a(str, str2, false);
    }

    public static long b() {
        return f29068b;
    }

    public static long b(b bVar) {
        return g(d(bVar));
    }

    public static String b(String str) {
        return a(c(), c(str));
    }

    public static void b(Context context) {
        File c2 = c(context);
        try {
            c2.getParentFile().mkdirs();
            c2.createNewFile();
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    public static boolean b(int i2, b bVar) {
        if (i2 == 206 || i2 == 1) {
            return true;
        }
        return "bytes".equals(bVar.a("Accept-Ranges"));
    }

    public static long c(int i2, b bVar) {
        long l2 = l(bVar.a("Content-Length"));
        String a2 = bVar.a("Transfer-Encoding");
        if (l2 >= 0) {
            return l2;
        }
        if (!(a2 != null && a2.equals("chunked"))) {
            if (!e.a().f29060c) {
                throw new FileDownloadGiveUpRetryException("can't know the size of the download file, and its Transfer-Encoding is not Chunked either.\nyou can ignore such exception by add http.lenient=true to the filedownloader.properties");
            } else if (d.f29057a) {
                d.c(f.class, "%d response header is not legal but HTTP lenient is true, so handle as the case of transfer encoding chunk", Integer.valueOf(i2));
            }
        }
        return -1;
    }

    public static long c(b bVar) {
        long m2 = m(d(bVar));
        if (m2 < 0) {
            return -1;
        }
        return m2;
    }

    public static File c(Context context) {
        return new File(context.getFilesDir().getAbsolutePath() + File.separator + "filedownloader", ".old_file_converted");
    }

    public static String c() {
        if (!TextUtils.isEmpty(f29069c)) {
            return f29069c;
        }
        boolean z2 = false;
        if (c.a().getExternalCacheDir() != null && Environment.getExternalStorageState().equals("mounted") && Environment.getExternalStorageDirectory().getFreeSpace() > 0) {
            z2 = true;
        }
        return (z2 ? c.a().getExternalCacheDir() : c.a().getCacheDir()).getAbsolutePath();
    }

    public static String c(String str) {
        return e(str);
    }

    public static void c(String str, String str2) {
        o(str2);
        p(str);
    }

    private static String d(b bVar) {
        return bVar.a("Content-Range");
    }

    public static String d(String str) {
        return a("%s.temp", str);
    }

    public static boolean d() {
        ConnectivityManager connectivityManager = (ConnectivityManager) c.a().getSystemService("connectivity");
        if (connectivityManager == null) {
            d.d(f.class, "failed to get connectivity manager!", new Object[0]);
            return true;
        }
        NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
        return activeNetworkInfo == null || activeNetworkInfo.getType() != 1;
    }

    public static boolean d(Context context) {
        return Build.VERSION.SDK_INT >= 26 && !e(context);
    }

    public static String e() {
        return a("FileDownloader/%s", "1.7.7");
    }

    public static String e(String str) {
        try {
            byte[] digest = MessageDigest.getInstance("MD5").digest(str.getBytes("UTF-8"));
            StringBuilder sb = new StringBuilder(digest.length * 2);
            for (byte b2 : digest) {
                byte b3 = b2 & 255;
                if (b3 < 16) {
                    sb.append("0");
                }
                sb.append(Integer.toHexString(b3));
            }
            return sb.toString();
        } catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException("Huh, MD5 should be supported?", e2);
        } catch (UnsupportedEncodingException e3) {
            throw new RuntimeException("Huh, UTF-8 should be supported?", e3);
        }
    }

    private static boolean e(Context context) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses;
        PowerManager powerManager;
        ActivityManager activityManager = (ActivityManager) context.getApplicationContext().getSystemService("activity");
        if (activityManager == null || (runningAppProcesses = activityManager.getRunningAppProcesses()) == null || (powerManager = (PowerManager) context.getSystemService("power")) == null) {
            return false;
        }
        if (Build.VERSION.SDK_INT > 19) {
            if (!powerManager.isInteractive()) {
                return false;
            }
        } else if (!powerManager.isScreenOn()) {
            return false;
        }
        String packageName = context.getApplicationContext().getPackageName();
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.processName.equals(packageName) && next.importance == 100) {
                return true;
            }
        }
        return false;
    }

    public static long f(String str) {
        StatFs statFs = new StatFs(str);
        return Build.VERSION.SDK_INT >= 18 ? statFs.getAvailableBytes() : ((long) statFs.getAvailableBlocks()) * ((long) statFs.getBlockSize());
    }

    public static long g(String str) {
        if (str == null) {
            return -1;
        }
        String[] split = str.split("/");
        if (split.length >= 2) {
            try {
                return Long.parseLong(split[1]);
            } catch (NumberFormatException unused) {
                d.d(f.class, "parse instance length failed with %s", str);
            }
        }
        return -1;
    }

    public static String h(String str) {
        if (str == null) {
            return null;
        }
        try {
            Matcher matcher = f29072f.matcher(str);
            if (matcher.find()) {
                return URLDecoder.decode(matcher.group(2), matcher.group(1));
            }
            Matcher matcher2 = f29073g.matcher(str);
            if (matcher2.find()) {
                return matcher2.group(1);
            }
            return null;
        } catch (UnsupportedEncodingException | IllegalStateException unused) {
        }
    }

    public static String i(String str) {
        int length = str.length();
        int i2 = 2;
        int i3 = (File.separatorChar == '\\' && length > 2 && str.charAt(1) == ':') ? 2 : 0;
        int lastIndexOf = str.lastIndexOf(File.separatorChar);
        if (lastIndexOf != -1 || i3 <= 0) {
            i2 = lastIndexOf;
        }
        if (i2 == -1 || str.charAt(length - 1) == File.separatorChar) {
            return null;
        }
        return (str.indexOf(File.separatorChar) == i2 && str.charAt(i3) == File.separatorChar) ? str.substring(0, i2 + 1) : str.substring(0, i2);
    }

    public static String j(String str) {
        return "FileDownloader-" + str;
    }

    public static boolean k(String str) {
        return c.a().checkCallingOrSelfPermission(str) == 0;
    }

    public static long l(String str) {
        if (str == null) {
            return -1;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return -1;
        }
    }

    public static long m(String str) {
        if (!(str == null || str.length() == 0)) {
            try {
                Matcher matcher = Pattern.compile("bytes (\\d+)-(\\d+)/\\d+").matcher(str);
                if (matcher.find()) {
                    return (Long.parseLong(matcher.group(2)) - Long.parseLong(matcher.group(1))) + 1;
                }
            } catch (Exception e2) {
                d.a((Object) f.class, (Throwable) e2, "parse content length from content range error", new Object[0]);
            }
        }
        return -1;
    }

    public static a n(String str) throws IOException {
        if (TextUtils.isEmpty(str)) {
            throw new RuntimeException("found invalid internal destination path, empty");
        } else if (a(str)) {
            File file = new File(str);
            if (file.exists() && file.isDirectory()) {
                throw new RuntimeException(a("found invalid internal destination path[%s], & path is directory[%B]", str, Boolean.valueOf(file.isDirectory())));
            } else if (file.exists() || file.createNewFile()) {
                return c.a().a(file);
            } else {
                throw new IOException(a("create new file error  %s", file.getAbsolutePath()));
            }
        } else {
            throw new RuntimeException(a("found invalid internal destination filename %s", str));
        }
    }

    public static void o(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    public static void p(String str) {
        if (str != null) {
            File file = new File(str);
            if (file.exists()) {
                file.delete();
            }
        }
    }

    static String q(String str) {
        if (str != null && !str.isEmpty()) {
            try {
                String path = new URL(str).getPath();
                String substring = path.substring(path.lastIndexOf(47) + 1);
                if (substring.isEmpty()) {
                    return null;
                }
                return substring;
            } catch (MalformedURLException unused) {
            }
        }
        return null;
    }
}
