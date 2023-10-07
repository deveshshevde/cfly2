package com.xeagle.android.widgets.CarouselView;

import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Environment;
import android.os.IBinder;
import android.os.Vibrator;
import android.widget.Toast;
import androidx.core.app.h;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.cfly.uav_pro.R;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.HttpHandler;
import com.lidroid.xutils.http.c;
import ig.a;
import ih.d;
import java.io.File;
import java.text.DecimalFormat;

public class DownAPKService extends Service {

    /* renamed from: a  reason: collision with root package name */
    private final int f25532a = 65536;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public NotificationManager f25533b = null;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public h.d f25534c;

    /* renamed from: d  reason: collision with root package name */
    private HttpHandler<File> f25535d;

    /* renamed from: e  reason: collision with root package name */
    private String f25536e = "";

    /* renamed from: f  reason: collision with root package name */
    private String f25537f = "";

    /* renamed from: g  reason: collision with root package name */
    private String f25538g = "";

    /* access modifiers changed from: private */
    public String a(int i2, int i3) {
        double d2 = (double) i2;
        Double.isNaN(d2);
        double d3 = (double) i3;
        Double.isNaN(d3);
        return new DecimalFormat("0.00%").format((d2 * 1.0d) / d3);
    }

    private void a() {
        File file;
        StringBuilder sb;
        if (b()) {
            sb = new StringBuilder();
            file = getApplicationContext().getFilesDir();
        } else {
            sb = new StringBuilder();
            file = Environment.getExternalStorageDirectory();
        }
        sb.append(file.getAbsolutePath());
        sb.append("/FlyPro/download/");
        this.f25538g = sb.toString();
        File file2 = new File(this.f25538g);
        if (!file2.exists()) {
            file2.mkdirs();
        }
    }

    private void a(String str, String str2) {
        if (a(str2)) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.DEFAULT");
            intent.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
            intent.setDataAndType(Uri.fromFile(new File(str2)), "application/pdf");
            startActivity(intent);
            return;
        }
        this.f25535d = new a().a(str, str2, true, new d<File>() {

            /* renamed from: a  reason: collision with root package name */
            static final /* synthetic */ boolean f25539a = true;

            static {
                Class<DownAPKService> cls = DownAPKService.class;
            }

            public void a(long j2, long j3, boolean z2) {
                super.a(j2, j3, z2);
                System.out.println("文件下载中");
                int intValue = Long.valueOf(j3).intValue();
                int intValue2 = Long.valueOf(j2).intValue();
                DownAPKService.this.f25534c.a(intValue2, intValue, false);
                DownAPKService.this.f25534c.d(DownAPKService.this.a(intValue, intValue2));
                DownAPKService.this.f25533b.notify(65536, DownAPKService.this.f25534c.b());
            }

            public void a(HttpException httpException, String str) {
                System.out.println("文件下载失败");
                DownAPKService.this.f25533b.cancel(65536);
                Toast.makeText(DownAPKService.this.getApplicationContext(), R.string.download_fail_network, 0).show();
            }

            public void a(c<File> cVar) {
                System.out.println("文件下载完成");
                Intent intent = new Intent("android.intent.action.VIEW");
                System.out.println(((File) cVar.f21052a).getPath());
                intent.addCategory("android.intent.category.DEFAULT");
                intent.setDataAndType(Uri.fromFile(new File(((File) cVar.f21052a).getPath())), "application/pdf");
                intent.addFlags(AMapEngineUtils.MAX_P20_WIDTH);
                PendingIntent activity = PendingIntent.getActivity(DownAPKService.this, 0, intent, 0);
                DownAPKService.this.f25534c.b((CharSequence) DownAPKService.this.getString(R.string.download_check));
                DownAPKService.this.f25534c.a(activity);
                DownAPKService.this.f25533b.notify(65536, DownAPKService.this.f25534c.b());
                Vibrator vibrator = (Vibrator) DownAPKService.this.getSystemService("vibrator");
                if (f25539a || vibrator != null) {
                    vibrator.vibrate(1000);
                    DownAPKService.this.stopSelf();
                    DownAPKService.this.startActivity(intent);
                    DownAPKService.this.f25533b.cancel(65536);
                    return;
                }
                throw new AssertionError();
            }

            public void b() {
                super.b();
                System.out.println("开始下载文件");
                DownAPKService downAPKService = DownAPKService.this;
                NotificationManager unused = downAPKService.f25533b = (NotificationManager) downAPKService.getSystemService("notification");
                DownAPKService downAPKService2 = DownAPKService.this;
                h.d unused2 = downAPKService2.f25534c = new h.d(downAPKService2.getApplicationContext());
                DownAPKService.this.f25534c.a((int) R.drawable.ic_launcher);
                DownAPKService.this.f25534c.e(DownAPKService.this.getString(R.string.new_version_download));
                DownAPKService.this.f25534c.a((CharSequence) DownAPKService.this.c());
                DownAPKService.this.f25534c.b((CharSequence) DownAPKService.this.getString(R.string.download_wait));
                DownAPKService.this.f25534c.b(0);
                DownAPKService.this.f25534c.a(true);
                DownAPKService.this.f25533b.notify(65536, DownAPKService.this.f25534c.b());
            }
        });
    }

    private boolean a(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean b() {
        return Environment.getExternalStorageDirectory().getAbsolutePath().equals("mounted");
    }

    /* access modifiers changed from: private */
    public String c() {
        PackageManager packageManager;
        ApplicationInfo applicationInfo = null;
        try {
            packageManager = getApplicationContext().getPackageManager();
            try {
                applicationInfo = packageManager.getApplicationInfo(getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException unused) {
            }
        } catch (PackageManager.NameNotFoundException unused2) {
            packageManager = null;
        }
        return (String) packageManager.getApplicationLabel(applicationInfo);
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
        a();
    }

    public void onDestroy() {
        super.onDestroy();
        stopSelf();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        System.out.println("onStartCommand");
        this.f25536e = intent.getStringExtra("file_url");
        this.f25537f = intent.getStringExtra("file_name");
        String str = this.f25536e;
        a(str, this.f25538g + File.separator + this.f25537f);
        return super.onStartCommand(intent, i2, i3);
    }
}
