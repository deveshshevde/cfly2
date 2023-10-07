package com.xeagle.android.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.net.Uri;
import android.net.wifi.ScanResult;
import android.os.Handler;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.flypro.core.parameters.Parameter;
import com.flypro.core.util.e;
import com.google.gson.JsonParseException;
import com.google.gson.JsonParser;
import com.xeagle.android.dialogs.s;
import com.xeagle.android.login.beans.UdpUnbindServer;
import dz.a;
import fg.i;
import iy.d;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.RandomAccessFile;
import java.lang.reflect.InvocationTargetException;
import java.nio.charset.Charset;
import java.nio.charset.MalformedInputException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static boolean f12769a = false;

    /* renamed from: b  reason: collision with root package name */
    private static String f12770b = "CommonTools";

    private static class a implements Comparator<ScanResult> {
        private a() {
        }

        /* renamed from: a */
        public int compare(ScanResult scanResult, ScanResult scanResult2) {
            if (Math.abs(scanResult.level) < Math.abs(scanResult2.level)) {
                return -1;
            }
            Log.i("SSID", "compare: ---o1 ssid--" + scanResult.SSID + "---o1 level---" + scanResult.level);
            Log.i("SSID", "compare: ---o2 ssid--" + scanResult2.SSID + "---o2 level---" + scanResult2.level);
            return 1;
        }
    }

    public interface b {
        void onResultAllow();

        void onResultDeny();
    }

    /* renamed from: com.xeagle.android.utils.c$c  reason: collision with other inner class name */
    public interface C0151c {
        void writeFail(String str);

        void writeSuccess();
    }

    public static double a(double d2, double[] dArr) {
        double d3 = i.f27244a;
        if (b(dArr, (double) i.f27244a) || b(dArr, -1.0d)) {
            Arrays.fill(dArr, d2);
        } else {
            System.arraycopy(dArr, 0, dArr, 1, dArr.length - 1);
            dArr[0] = d2;
        }
        for (double d4 : dArr) {
            d3 += d4;
        }
        double length = (double) dArr.length;
        Double.isNaN(length);
        return d3 / length;
    }

    public static int a(Context context, float f2) {
        return (int) ((f2 * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    public static int a(BitmapFactory.Options options, int i2, int i3) {
        int i4 = options.outHeight;
        int i5 = options.outWidth;
        if (i4 <= i3 && i5 <= i2) {
            return 1;
        }
        int round = Math.round(((float) i4) / ((float) i3));
        int round2 = Math.round(((float) i5) / ((float) i2));
        return round < round2 ? round : round2;
    }

    public static int a(String str, String str2) {
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int indexOf = str.indexOf(str2, i2);
            if (indexOf == -1) {
                return i3;
            }
            i3++;
            i2 = indexOf + str2.length();
        }
    }

    public static SQLiteDatabase a(Context context, String str) {
        File file = new File(str);
        if (file.exists()) {
            return SQLiteDatabase.openOrCreateDatabase(file, (SQLiteDatabase.CursorFactory) null);
        }
        return null;
    }

    public static Bitmap a(Context context, int i2) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(context.getResources(), i2, options);
        options.inSampleSize = a(options, 1920, 1080);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(context.getResources(), i2, options);
    }

    public static Bitmap a(Context context, Uri uri) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        try {
            b(context, uri);
            options.inSampleSize = 3;
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        Bitmap bitmap = null;
        try {
            InputStream openInputStream = context.getContentResolver().openInputStream(uri);
            bitmap = BitmapFactory.decodeStream(openInputStream, (Rect) null, options);
            openInputStream.close();
            return bitmap;
        } catch (FileNotFoundException e3) {
            e3.printStackTrace();
            return bitmap;
        } catch (IOException e4) {
            e4.printStackTrace();
            return bitmap;
        }
    }

    public static Bitmap a(Bitmap bitmap, float f2, float f3) {
        if (bitmap == null) {
            return bitmap;
        }
        Bitmap bitmap2 = null;
        float f4 = 1.0f;
        if (((float) bitmap.getWidth()) < f2 && ((float) bitmap.getHeight()) < f3) {
            if (((float) bitmap.getHeight()) * f2 > ((float) bitmap.getWidth()) * f3) {
                f4 = f3 / ((float) bitmap.getHeight());
            } else if (((float) bitmap.getHeight()) * f2 <= f3 * ((float) bitmap.getWidth())) {
                f4 = f2 / ((float) bitmap.getWidth());
            }
        }
        Matrix matrix = new Matrix();
        matrix.postScale(f4, f4);
        try {
            bitmap2 = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        } catch (OutOfMemoryError unused) {
            Log.i(f12770b, "zoomBitmap OutOfMemoryError");
            bitmap2.recycle();
        }
        bitmap.recycle();
        System.gc();
        return bitmap2;
    }

    public static Bitmap a(String str, int i2, int i3) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = a(options, i2, i3);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap a(byte[] bArr, int i2, int i3) {
        Log.i(f12770b, "start decodeByteArrayForRGB565");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int a2 = a(options, i2, i3);
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inJustDecodeBounds = false;
        options.inSampleSize = a2;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        String str = f12770b;
        Log.i(str, "end decodeByteArrayForRGB565 bitmap=" + decodeByteArray);
        return decodeByteArray;
    }

    public static String a() {
        String country = b().getCountry();
        if (TextUtils.isEmpty(country)) {
            country = "";
        }
        return country.toUpperCase(Locale.US);
    }

    public static String a(long j2) {
        if (j2 >= 100000) {
            return String.format(Locale.US, "%.2f MB", new Object[]{Float.valueOf((((float) j2) / 1000.0f) / 1000.0f)});
        } else if (j2 >= 100) {
            return String.format(Locale.US, "%.1f KB", new Object[]{Float.valueOf(((float) j2) / 1000.0f)});
        } else {
            return String.format(Locale.US, "%d B", new Object[]{Long.valueOf(j2)});
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0008, code lost:
        r0 = r2.lastIndexOf(46);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static java.lang.String a(java.lang.String r2) {
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
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.utils.c.a(java.lang.String):java.lang.String");
    }

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        for (int i2 = 0; i2 < bArr.length; i2++) {
            sb.append(String.format("%x ", new Object[]{Byte.valueOf(bArr[i2])}));
        }
        if (sb.length() > 0) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void a(Window window) {
        String str;
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            try {
                Class<?> cls = Class.forName("com.huawei.android.view.LayoutParamsEx");
                Object newInstance = cls.getConstructor(new Class[]{WindowManager.LayoutParams.class}).newInstance(new Object[]{attributes});
                cls.getMethod("addHwFlags", new Class[]{Integer.TYPE}).invoke(newInstance, new Object[]{256});
                return;
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException unused) {
                str = "hw add notch screen flag api error";
            } catch (Exception unused2) {
                str = "other Exception";
            }
        } else {
            return;
        }
        Log.e("test", str);
    }

    public static void a(final AppCompatActivity appCompatActivity, final b bVar) {
        ArrayList arrayList = new ArrayList();
        arrayList.add("android.permission.READ_EXTERNAL_STORAGE");
        arrayList.add("android.permission.WRITE_EXTERNAL_STORAGE");
        com.permissionx.guolindev.b.a(appCompatActivity).a(arrayList).a().a((iw.b) new iw.b() {
            public void onExplainReason(iy.c cVar, List<String> list, boolean z2) {
                Log.i("newUI", "onExplainReason: ");
                AppCompatActivity appCompatActivity = AppCompatActivity.this;
                cVar.a(new s(appCompatActivity, R.style.dialog, appCompatActivity.getString(R.string.permission_title), AppCompatActivity.this.getString(R.string.bt_allow), AppCompatActivity.this.getString(R.string.bt_deny), list));
            }
        }).a((iw.c) new iw.c() {
            public void onForwardToSettings(d dVar, List<String> list) {
                AppCompatActivity appCompatActivity = AppCompatActivity.this;
                dVar.a(new s(appCompatActivity, R.style.dialog, appCompatActivity.getString(R.string.permission_forward_title), AppCompatActivity.this.getString(R.string.bt_allow), AppCompatActivity.this.getString(R.string.bt_deny), list));
            }
        }).a((iw.d) new iw.d() {
            public void onResult(boolean z2, List<String> list, List<String> list2) {
                int i2;
                AppCompatActivity appCompatActivity;
                if (z2) {
                    b bVar = b.this;
                    if (bVar != null) {
                        bVar.onResultAllow();
                    }
                    appCompatActivity = appCompatActivity;
                    i2 = R.string.permission_all_allow;
                } else {
                    b bVar2 = b.this;
                    if (bVar2 != null) {
                        bVar2.onResultDeny();
                    }
                    appCompatActivity = appCompatActivity;
                    i2 = R.string.permission_deny_warn;
                }
                ToastUtils.showLong((CharSequence) appCompatActivity.getString(i2));
            }
        });
    }

    public static void a(final en.a aVar) {
        ka.a.a().c().execute(new Runnable() {
            public void run() {
                if (en.a.this.j().e()) {
                    en.a.this.j().a(15);
                }
                new UdpUnbindServer().sendBuffer(new byte[]{-2, -1, -1, -1}, "172.50.10.1", IMediaPlayer.MEDIA_INFO_OPEN_INPUT);
            }
        });
    }

    public static void a(en.a aVar, String str, double d2) {
        Parameter parameter = new Parameter(str, d2, 9);
        aVar.e().a(parameter);
        SystemClock.sleep(100);
        aVar.e().a(parameter);
        aVar.e().a(str);
    }

    public static void a(en.a aVar, String str, double d2, a.C0168a aVar2) {
        aVar.e().a(new Parameter(str, d2, 9));
        SystemClock.sleep(100);
        if (aVar2 != null) {
            aVar.e().a(str, aVar2);
        }
    }

    public static void a(final en.a aVar, final String str, final TextView textView) {
        ka.a.a().c().execute(new Runnable() {
            public void run() {
                en.a aVar = en.a.this;
                if (aVar != null && aVar.e() != null) {
                    final Parameter b2 = en.a.this.e().b(str);
                    textView.post(new Runnable() {
                        public void run() {
                            if (b2 != null) {
                                TextView textView = textView;
                                textView.setText(b2.f14456b + "");
                            }
                        }
                    });
                }
            }
        });
    }

    public static void a(InputStream inputStream, File file) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        try {
            byte[] bArr = new byte[1024];
            while (true) {
                int read = inputStream.read(bArr);
                if (read != -1) {
                    Log.i("FTP", "copyInputStreamToFile:===== ");
                    fileOutputStream.write(bArr, 0, read);
                } else {
                    fileOutputStream.close();
                    return;
                }
            }
        } catch (Throwable th) {
            th.addSuppressed(th);
        }
        throw th;
    }

    public static void a(String str, Bitmap bitmap) {
        File file = new File(str);
        if (file.exists()) {
            file.delete();
        }
        Log.i("CmdChannel", "saveImage:--- ");
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
        } catch (IOException e3) {
            e3.printStackTrace();
        }
    }

    public static void a(Timer timer, e eVar, Handler handler) {
        String str;
        if (eVar.e() != null) {
            if (eVar == null || eVar.e() == null) {
                str = "run: ----初始化失败";
            } else {
                ArrayList arrayList = new ArrayList();
                if (arrayList.size() > 0) {
                    arrayList.clear();
                }
                for (ScanResult next : eVar.e()) {
                    if ((next.SSID.contains("Drone") && Math.abs(next.level) < 54) || (next.SSID.contains("Controller") && Math.abs(next.level) < 30)) {
                        arrayList.add(next);
                    }
                }
                if (arrayList.size() > 0) {
                    Log.i("version", "connectWifi: " + arrayList.size() + "...ssid..." + ((ScanResult) arrayList.get(0)).SSID);
                    timer.cancel();
                    Collections.sort(arrayList, new a());
                    eVar.a(((ScanResult) arrayList.get(0)).SSID, "", "OPEN");
                    SystemClock.sleep(500);
                    handler.sendEmptyMessage(4);
                    return;
                }
                str = "run: ----无大于-45db WiFi连接";
            }
            Log.d("WIFI", str);
        }
    }

    public static void a(Timer timer, e eVar, com.xeagle.android.vjoystick.utils.e eVar2) {
        String str;
        if (eVar.e() != null) {
            if (eVar == null || eVar.e() == null) {
                str = "run: ----初始化失败";
            } else {
                ArrayList arrayList = new ArrayList();
                if (arrayList.size() > 0) {
                    arrayList.clear();
                }
                for (ScanResult next : eVar.e()) {
                    if ((next.SSID.contains("Drone") && Math.abs(next.level) < 54) || (next.SSID.contains("Controller") && Math.abs(next.level) < 30)) {
                        arrayList.add(next);
                    }
                }
                if (arrayList.size() > 0) {
                    Log.i("SSID", "connectWifi: " + arrayList.size() + "...ssid..." + ((ScanResult) arrayList.get(0)).SSID);
                    timer.cancel();
                    Collections.sort(arrayList, new a());
                    Log.i("SSID", "connectWifi: ---->>>> range wifi::::::" + ((ScanResult) arrayList.get(0)).SSID + "...level..." + ((ScanResult) arrayList.get(0)).level);
                    eVar.a(((ScanResult) arrayList.get(0)).SSID, "", "OPEN");
                    SystemClock.sleep(500);
                    eVar2.a(4);
                    return;
                }
                str = "run: ----无大于-45db WiFi连接";
            }
            Log.d("WIFI", str);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:35:0x005a A[SYNTHETIC, Splitter:B:35:0x005a] */
    /* JADX WARNING: Removed duplicated region for block: B:40:0x006b A[SYNTHETIC, Splitter:B:40:0x006b] */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x007d A[SYNTHETIC, Splitter:B:47:0x007d] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x008e A[SYNTHETIC, Splitter:B:52:0x008e] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x00a1 A[SYNTHETIC, Splitter:B:58:0x00a1] */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x00b2 A[SYNTHETIC, Splitter:B:63:0x00b2] */
    /* JADX WARNING: Removed duplicated region for block: B:69:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:44:0x0071=Splitter:B:44:0x0071, B:32:0x004e=Splitter:B:32:0x004e} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void a(byte[] r2, java.lang.String r3, com.xeagle.android.utils.c.C0151c r4) {
        /*
            java.io.File r0 = new java.io.File
            r0.<init>(r3)
            boolean r3 = r0.exists()
            if (r3 == 0) goto L_0x000e
            r0.delete()
        L_0x000e:
            r3 = 0
            java.io.FileOutputStream r1 = new java.io.FileOutputStream     // Catch:{ FileNotFoundException -> 0x006f, IOException -> 0x004c, all -> 0x0049 }
            r1.<init>(r0)     // Catch:{ FileNotFoundException -> 0x006f, IOException -> 0x004c, all -> 0x0049 }
            java.io.BufferedOutputStream r0 = new java.io.BufferedOutputStream     // Catch:{ FileNotFoundException -> 0x0045, IOException -> 0x0041, all -> 0x003c }
            r0.<init>(r1)     // Catch:{ FileNotFoundException -> 0x0045, IOException -> 0x0041, all -> 0x003c }
            r0.write(r2)     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x0038, all -> 0x0036 }
            r0.flush()     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x0038, all -> 0x0036 }
            r4.writeSuccess()     // Catch:{ FileNotFoundException -> 0x003a, IOException -> 0x0038, all -> 0x0036 }
            r1.close()     // Catch:{ IOException -> 0x0026 }
            goto L_0x0031
        L_0x0026:
            r2 = move-exception
            r2.printStackTrace()
            java.lang.String r2 = r2.getMessage()
            r4.writeFail(r2)
        L_0x0031:
            r0.close()     // Catch:{ IOException -> 0x0092 }
            goto L_0x009d
        L_0x0036:
            r2 = move-exception
            goto L_0x003e
        L_0x0038:
            r2 = move-exception
            goto L_0x0043
        L_0x003a:
            r2 = move-exception
            goto L_0x0047
        L_0x003c:
            r2 = move-exception
            r0 = r3
        L_0x003e:
            r3 = r1
            goto L_0x009f
        L_0x0041:
            r2 = move-exception
            r0 = r3
        L_0x0043:
            r3 = r1
            goto L_0x004e
        L_0x0045:
            r2 = move-exception
            r0 = r3
        L_0x0047:
            r3 = r1
            goto L_0x0071
        L_0x0049:
            r2 = move-exception
            r0 = r3
            goto L_0x009f
        L_0x004c:
            r2 = move-exception
            r0 = r3
        L_0x004e:
            r2.printStackTrace()     // Catch:{ all -> 0x009e }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x009e }
            r4.writeFail(r2)     // Catch:{ all -> 0x009e }
            if (r3 == 0) goto L_0x0069
            r3.close()     // Catch:{ IOException -> 0x005e }
            goto L_0x0069
        L_0x005e:
            r2 = move-exception
            r2.printStackTrace()
            java.lang.String r2 = r2.getMessage()
            r4.writeFail(r2)
        L_0x0069:
            if (r0 == 0) goto L_0x009d
            r0.close()     // Catch:{ IOException -> 0x0092 }
            goto L_0x009d
        L_0x006f:
            r2 = move-exception
            r0 = r3
        L_0x0071:
            r2.printStackTrace()     // Catch:{ all -> 0x009e }
            java.lang.String r2 = r2.getMessage()     // Catch:{ all -> 0x009e }
            r4.writeFail(r2)     // Catch:{ all -> 0x009e }
            if (r3 == 0) goto L_0x008c
            r3.close()     // Catch:{ IOException -> 0x0081 }
            goto L_0x008c
        L_0x0081:
            r2 = move-exception
            r2.printStackTrace()
            java.lang.String r2 = r2.getMessage()
            r4.writeFail(r2)
        L_0x008c:
            if (r0 == 0) goto L_0x009d
            r0.close()     // Catch:{ IOException -> 0x0092 }
            goto L_0x009d
        L_0x0092:
            r2 = move-exception
            r2.printStackTrace()
            java.lang.String r2 = r2.getMessage()
            r4.writeFail(r2)
        L_0x009d:
            return
        L_0x009e:
            r2 = move-exception
        L_0x009f:
            if (r3 == 0) goto L_0x00b0
            r3.close()     // Catch:{ IOException -> 0x00a5 }
            goto L_0x00b0
        L_0x00a5:
            r3 = move-exception
            r3.printStackTrace()
            java.lang.String r3 = r3.getMessage()
            r4.writeFail(r3)
        L_0x00b0:
            if (r0 == 0) goto L_0x00c1
            r0.close()     // Catch:{ IOException -> 0x00b6 }
            goto L_0x00c1
        L_0x00b6:
            r3 = move-exception
            r3.printStackTrace()
            java.lang.String r3 = r3.getMessage()
            r4.writeFail(r3)
        L_0x00c1:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.utils.c.a(byte[], java.lang.String, com.xeagle.android.utils.c$c):void");
    }

    public static boolean a(double d2, double[] dArr, double d3) {
        if (b(dArr, (double) i.f27244a)) {
            Arrays.fill(dArr, 1.6842798E7d);
        } else {
            System.arraycopy(dArr, 0, dArr, 1, dArr.length - 1);
            dArr[0] = d2;
        }
        return a(dArr, d3);
    }

    public static boolean a(int i2) {
        return i2 == 11 || i2 == 0 || i2 == 8 || i2 == 6;
    }

    public static boolean a(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        return locale.getLanguage().equals("zh") && !locale.getCountry().equals("CN");
    }

    private static boolean a(double[] dArr, double d2) {
        Arrays.sort(dArr);
        return dArr[0] > d2;
    }

    public static byte[] a(byte[] bArr, byte[] bArr2) {
        byte[] bArr3 = new byte[(bArr.length + bArr2.length)];
        System.arraycopy(bArr, 0, bArr3, 0, bArr.length);
        System.arraycopy(bArr2, 0, bArr3, bArr.length, bArr2.length);
        return bArr3;
    }

    public static Bitmap b(String str) {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(str, options);
        options.inSampleSize = a(options, ScreenUtils.getScreenWidth(), ScreenUtils.getScreenHeight());
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public static Bitmap b(byte[] bArr, int i2, int i3) {
        Log.i(f12770b, "start decodeByteArray");
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        int a2 = a(options, i2, i3);
        options.inJustDecodeBounds = false;
        options.inSampleSize = a2;
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length, options);
        Log.i(f12770b, "decodeByteArray: ");
        return a(decodeByteArray, (float) i2, (float) i3);
    }

    private static BitmapFactory.Options b(Context context, Uri uri) throws FileNotFoundException, IOException {
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        options.inSampleSize = 2;
        InputStream openInputStream = context.getContentResolver().openInputStream(uri);
        BitmapFactory.decodeStream(openInputStream, (Rect) null, options);
        openInputStream.close();
        return options;
    }

    public static String b(long j2) {
        int i2 = (j2 > 1000 ? 1 : (j2 == 1000 ? 0 : -1));
        Locale locale = Locale.US;
        Object[] objArr = new Object[1];
        if (i2 >= 0) {
            objArr[0] = Float.valueOf(((float) j2) / 1000.0f);
            return String.format(locale, "%.2f sec", objArr);
        }
        objArr[0] = Long.valueOf(j2);
        return String.format(locale, "%d msec", objArr);
    }

    public static String b(Context context, int i2) {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) context.getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses == null || runningAppProcesses.isEmpty()) {
            return null;
        }
        for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
            if (next.pid == i2) {
                return next.processName;
            }
        }
        return null;
    }

    public static Locale b() {
        try {
            return androidx.core.os.c.a(Resources.getSystem().getConfiguration()).a(0);
        } catch (Exception unused) {
            return Locale.getDefault();
        }
    }

    public static void b(Window window) {
        Class<Window> cls = Window.class;
        try {
            cls.getMethod("addExtraFlags", new Class[]{Integer.TYPE}).invoke(window, new Object[]{1792});
        } catch (Exception unused) {
            Log.e("test", "addExtraFlags not found.");
        }
    }

    public static boolean b(Context context) {
        Locale locale = context.getResources().getConfiguration().locale;
        return locale.getLanguage().equals("zh") && locale.getCountry().equals("CN");
    }

    public static boolean b(en.a aVar, String str, double d2) {
        aVar.e().a(str);
        Parameter b2 = aVar.e().b(str);
        int i2 = 0;
        while (i2 < 5 && b2 == null) {
            aVar.e().a(str);
            b2 = aVar.e().b(str);
            i2++;
            SystemClock.sleep(100);
        }
        if (b2 == null) {
            return false;
        }
        b2.f14456b = d2;
        aVar.e().a(b2);
        aVar.e().a(b2);
        aVar.e().a(b2);
        SystemClock.sleep(100);
        aVar.e().a(str);
        Parameter b3 = aVar.e().b(str);
        int i3 = 0;
        while (i3 < 3 && b3 == null) {
            i3++;
            b3 = aVar.e().b(str);
        }
        return b3 != null && b3.f14456b == d2;
    }

    private static boolean b(double[] dArr, double d2) {
        for (double d3 : dArr) {
            if (d3 == d2) {
                return true;
            }
        }
        return false;
    }

    public static String c(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    public static String c(String str) {
        String[] strArr = {"US-ASCII", "UTF-8", "GB2312", "BIG5", "GBK", "GB18030", "UTF-16BE", "UTF-16LE", "UTF-16", "UNICODE"};
        String displayName = Charset.defaultCharset().displayName();
        int i2 = 0;
        while (i2 < 10) {
            try {
                do {
                } while (new BufferedReader(new InputStreamReader(new FileInputStream(str), Charset.forName(strArr[i2]).newDecoder())).readLine() != null);
                return strArr[i2];
            } catch (FileNotFoundException e2) {
                e2.printStackTrace();
                return displayName;
            } catch (MalformedInputException unused) {
                i2++;
            } catch (IOException e3) {
                e3.printStackTrace();
                return displayName;
            }
        }
        return displayName;
    }

    public static long d(Context context) {
        try {
            return (long) context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionCode;
        } catch (PackageManager.NameNotFoundException e2) {
            e2.printStackTrace();
            return 0;
        }
    }

    public static boolean d(String str) {
        try {
            new JsonParser().parse(str);
            return true;
        } catch (JsonParseException unused) {
            PrintStream printStream = System.out;
            printStream.println("bad json: " + str);
            return false;
        }
    }

    public static void e(final String str) {
        ka.a.a().b().execute(new Runnable() {
            public void run() {
                try {
                    File file = new File(str);
                    if (file.exists()) {
                        file.delete();
                    }
                    BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "RTSP:E *:S", "RTSP:V *:S"}).getInputStream()));
                    while (c.f12769a) {
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                if (readLine.contains("onRtspVideoNalUnitReceived")) {
                                    bufferedOutputStream.write((readLine + "\r\n").getBytes());
                                    bufferedOutputStream.flush();
                                }
                            }
                        }
                    }
                    bufferedOutputStream.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public static boolean e(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("com.huawei.android.util.HwNotchSizeUtil");
            return ((Boolean) loadClass.getMethod("hasNotchInScreen", new Class[0]).invoke(loadClass, new Object[0])).booleanValue();
        } catch (ClassNotFoundException unused) {
            Log.e("test", "hasNotchInScreen ClassNotFoundException");
            return false;
        } catch (NoSuchMethodException unused2) {
            Log.e("test", "hasNotchInScreen NoSuchMethodException");
            return false;
        } catch (Exception unused3) {
            Log.e("test", "hasNotchInScreen Exception");
            return false;
        } catch (Throwable unused4) {
            return false;
        }
    }

    public static void f(final String str) {
        ka.a.a().b().execute(new Runnable() {
            public void run() {
                try {
                    File file = new File(str);
                    RandomAccessFile randomAccessFile = new RandomAccessFile(file, "rw");
                    randomAccessFile.seek(file.length());
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(new String[]{"logcat", "-s", "adb logcat *:V"}).getInputStream()));
                    while (c.f12769a) {
                        while (true) {
                            String readLine = bufferedReader.readLine();
                            if (readLine != null) {
                                randomAccessFile.write((readLine + "\r\n").getBytes());
                            }
                        }
                    }
                    randomAccessFile.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            }
        });
    }

    public static boolean f(Context context) {
        try {
            Class<?> loadClass = context.getClassLoader().loadClass("android.os.SystemProperties");
            return ((Integer) loadClass.getMethod("getInt", new Class[]{String.class, Integer.TYPE}).invoke(loadClass, new Object[]{"ro.miui.notch", 0})).intValue() == 1;
        } catch (Exception e2) {
            e2.printStackTrace();
        } catch (Throwable unused) {
        }
        return false;
    }

    public static String g(String str) {
        try {
            FileInputStream fileInputStream = new FileInputStream(new File(str));
            byte[] bArr = new byte[4096];
            MessageDigest instance = MessageDigest.getInstance("MD5");
            while (true) {
                int read = fileInputStream.read(bArr);
                if (read <= 0) {
                    break;
                }
                instance.update(bArr, 0, read);
            }
            byte[] digest = instance.digest();
            StringBuilder sb = new StringBuilder();
            int length = digest.length;
            for (int i2 = 0; i2 < length; i2++) {
                sb.append(String.format("%02x", new Object[]{Integer.valueOf(digest[i2] & 255)}));
            }
            String sb2 = sb.toString();
            Log.i("FTP", "startBurnDrone:===MD5=== " + sb2 + "===fwPath==" + str);
            fileInputStream.close();
            return sb2;
        } catch (FileNotFoundException e2) {
            e2.printStackTrace();
            return null;
        } catch (NoSuchAlgorithmException e3) {
            e3.printStackTrace();
            return null;
        } catch (IOException e4) {
            e4.printStackTrace();
            return null;
        }
    }

    public static String h(String str) {
        StringBuilder sb;
        String str2;
        String replace = str.replace("000/", "");
        if (replace.contains("AA")) {
            replace = replace.replace("AA", "");
        }
        String substring = replace.substring(replace.lastIndexOf(47) + 1, replace.length());
        if (substring.contains("MP4")) {
            sb = new StringBuilder();
            str2 = "video_20";
        } else if (!substring.contains("JPG")) {
            return substring;
        } else {
            sb = new StringBuilder();
            str2 = "image_20";
        }
        sb.append(str2);
        sb.append(substring);
        return sb.toString();
    }

    public static int i(String str) {
        String replace;
        if (str.equalsIgnoreCase("N/A")) {
            return 0;
        }
        try {
            Log.i("FTP", "getRepeaterFlag: =====" + str.substring(0, str.indexOf("-")));
            if (str.contains("-")) {
                replace = str.substring(0, str.indexOf("-")).replace(".", "");
            } else if (!str.contains("_")) {
                return 0;
            } else {
                replace = str.substring(0, str.indexOf("_")).replace(".", "");
            }
            return Integer.parseInt(replace);
        } catch (Exception e2) {
            e2.printStackTrace();
            return 0;
        }
    }
}
