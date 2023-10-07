package com.xeagle.android.activities;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.SpinnerAdapter;
import android.widget.Toast;
import com.cfly.uav_pro.R;
import com.xeagle.android.widgets.CarouselView.CarouselAdapter;
import com.xeagle.android.widgets.CarouselView.CarouselImageView;
import com.xeagle.android.widgets.CarouselView.DownAPKService;
import com.xeagle.android.widgets.CarouselView.c;
import java.io.File;
import java.util.ArrayList;

public class ResourceCenterActivity extends Activity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public String f22330a;

    /* renamed from: b  reason: collision with root package name */
    private CarouselImageView f22331b;

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
        this.f22330a = sb.toString();
        File file2 = new File(this.f22330a);
        if (!file2.exists()) {
            file2.mkdirs();
        }
    }

    public static void a(Activity activity) {
        Intent intent;
        if (Build.VERSION.SDK_INT > 10) {
            intent = new Intent("android.settings.SETTINGS");
        } else {
            intent = new Intent();
            intent.setComponent(new ComponentName("com.android.settings", "com.android.settings.WirelessSettings"));
            intent.setAction("android.intent.action.VIEW");
        }
        activity.startActivity(intent);
    }

    public static boolean a(Context context) {
        int i2;
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        if (connectivityManager == null) {
            i2 = R.string.network_available;
        } else if (connectivityManager.getNetworkInfo(1).isConnected()) {
            Toast.makeText(context, R.string.network_wifi, 0).show();
            return true;
        } else {
            i2 = R.string.network_nowifi;
        }
        Toast.makeText(context, i2, 0).show();
        return false;
    }

    /* access modifiers changed from: private */
    public boolean a(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    private boolean b() {
        return Environment.getExternalStorageDirectory().getAbsolutePath().equals("mounted");
    }

    public void a(final String str, final String str2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(R.string.gps_warning);
        builder.setMessage(getString(R.string.wifi_warn));
        builder.setPositiveButton(getString(R.string.wifi_open), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                ResourceCenterActivity.a((Activity) ResourceCenterActivity.this);
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton(getString(R.string.video_open), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                Intent intent = new Intent(ResourceCenterActivity.this, OpenVideoActivity.class);
                intent.putExtra("open_video", str);
                intent.putExtra("video_info", str2);
                ResourceCenterActivity.this.startActivity(intent);
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    public void a(String str, String str2, String str3, final String str4, final String str5) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(str);
        builder.setMessage(str2);
        builder.setPositiveButton(str3, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                Intent intent = new Intent(ResourceCenterActivity.this, DownAPKService.class);
                intent.putExtra("file_url", "http://iflypro.com/video/" + str4);
                intent.putExtra("file_name", str4);
                ResourceCenterActivity.this.startService(intent);
                Toast.makeText(ResourceCenterActivity.this, str5, 0).show();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton(getString(R.string.download_cancle), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().requestFeature(1);
        setContentView(R.layout.activity_resource_center);
        a();
        this.f22331b = (CarouselImageView) findViewById(R.id.carousel);
        ArrayList arrayList = new ArrayList();
        arrayList.add(getResources().getDrawable(R.drawable.px_manul));
        arrayList.add(getResources().getDrawable(R.drawable.px_vedio));
        this.f22331b.setAdapter((SpinnerAdapter) new c(this, arrayList, true));
        this.f22331b.setOnItemClickListener(new CarouselAdapter.c() {
            public void a(CarouselAdapter<?> carouselAdapter, View view, int i2, long j2) {
                int i3 = i2;
                if (i3 == 0) {
                    ResourceCenterActivity resourceCenterActivity = ResourceCenterActivity.this;
                    if (!resourceCenterActivity.a(ResourceCenterActivity.this.f22330a + ResourceCenterActivity.this.getString(R.string.pdf_name))) {
                        ResourceCenterActivity resourceCenterActivity2 = ResourceCenterActivity.this;
                        resourceCenterActivity2.a(resourceCenterActivity2.getString(R.string.download_warn), ResourceCenterActivity.this.getString(R.string.download_pdf_check), ResourceCenterActivity.this.getString(R.string.download), ResourceCenterActivity.this.getString(R.string.pdf_name), ResourceCenterActivity.this.getString(R.string.pdf_use_whether));
                        return;
                    }
                    ResourceCenterActivity resourceCenterActivity3 = ResourceCenterActivity.this;
                    resourceCenterActivity3.a(resourceCenterActivity3.getString(R.string.pdf_read), ResourceCenterActivity.this.getString(R.string.pdf_read_whether), ResourceCenterActivity.this.getString(R.string.read), ResourceCenterActivity.this.getString(R.string.pdf_name), ResourceCenterActivity.this.getString(R.string.pdf_read_kit));
                } else if (i3 == 1) {
                    if (ResourceCenterActivity.a(ResourceCenterActivity.this.getApplicationContext())) {
                        Intent intent = new Intent(ResourceCenterActivity.this, YoutubeActivity.class);
                        intent.putExtra("open_video", "https://www.youtube.com/embed/bE7eXRDtJWQ");
                        ResourceCenterActivity.this.startActivity(intent);
                        return;
                    }
                    ResourceCenterActivity resourceCenterActivity4 = ResourceCenterActivity.this;
                    resourceCenterActivity4.a("https://www.youtube.com/embed/bE7eXRDtJWQ", resourceCenterActivity4.getString(R.string.px400_ad));
                }
            }
        });
    }
}
