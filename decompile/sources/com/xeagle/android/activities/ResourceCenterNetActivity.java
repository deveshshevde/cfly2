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
import android.widget.Button;
import android.widget.Toast;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.volley.VolleyError;
import com.android.volley.h;
import com.android.volley.i;
import com.android.volley.toolbox.k;
import com.android.volley.toolbox.l;
import com.cfly.uav_pro.R;
import com.xeagle.android.widgets.CarouselView.DownAPKService;
import com.xeagle.android.widgets.CarouselView.d;
import com.xeagle.android.widgets.CarouselView.f;
import com.xeagle.android.widgets.CarouselView.g;
import java.io.File;
import java.io.PrintStream;
import java.util.ArrayList;

public class ResourceCenterNetActivity extends Activity {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public RecyclerView f22341a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public ArrayList<f> f22342b;

    /* renamed from: c  reason: collision with root package name */
    private h f22343c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public d f22344d;

    /* renamed from: e  reason: collision with root package name */
    private Button f22345e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f22346f;

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
        this.f22346f = sb.toString();
        File file2 = new File(this.f22346f);
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

    private boolean b() {
        return Environment.getExternalStorageDirectory().getAbsolutePath().equals("mounted");
    }

    /* access modifiers changed from: private */
    public boolean c(String str) {
        try {
            return new File(str).exists();
        } catch (Exception unused) {
            return false;
        }
    }

    public String a(String str) {
        String substring = str.substring(str.lastIndexOf("/") + 1);
        System.out.println(substring);
        return substring;
    }

    public void a(final String str, final String str2) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Warning");
        builder.setMessage(getString(R.string.wifi_warn));
        builder.setPositiveButton(getString(R.string.wifi_open), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                ResourceCenterNetActivity.a((Activity) ResourceCenterNetActivity.this);
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton(getString(R.string.video_open), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                Intent intent = new Intent(ResourceCenterNetActivity.this, YoutubeActivity.class);
                intent.putExtra("open_video", str);
                intent.putExtra("video_info", str2);
                ResourceCenterNetActivity.this.startActivity(intent);
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
                Intent intent = new Intent(ResourceCenterNetActivity.this, DownAPKService.class);
                intent.putExtra("file_url", "http://www.flypro.com/video/" + str4);
                PrintStream printStream = System.out;
                printStream.println("++++++++++++++++++++++++++" + str4);
                intent.putExtra("file_name", str4);
                ResourceCenterNetActivity.this.startService(intent);
                Toast.makeText(ResourceCenterNetActivity.this, str5, 0).show();
                dialogInterface.dismiss();
            }
        });
        builder.setNegativeButton(getString(R.string.download_cancle), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                dialogInterface.dismiss();
            }
        }).create().show();
    }

    public boolean b(String str) {
        return str.endsWith(".pdf");
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().requestFeature(1);
        getWindow().setFlags(1024, 1024);
        setContentView(R.layout.recycle_view);
        a();
        this.f22342b = new ArrayList<>();
        this.f22341a = (RecyclerView) findViewById(R.id.list);
        this.f22345e = (Button) findViewById(R.id.go_back);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.c(true);
        if (getResources().getConfiguration().orientation == 1) {
            linearLayoutManager.b(1);
        } else if (getResources().getConfiguration().orientation == 2) {
            linearLayoutManager.b(0);
        }
        this.f22341a.setLayoutManager(linearLayoutManager);
        this.f22341a.setItemAnimator(new androidx.recyclerview.widget.f());
        this.f22341a.setHasFixedSize(true);
        this.f22343c = l.a(this);
        this.f22343c.a(new k(0, "http://www.flypro.com/app/videoInfo.json", new i.b<String>() {
            public void a(String str) {
                ArrayList<f> a2 = new g().a(str);
                ResourceCenterNetActivity.this.f22342b.clear();
                ResourceCenterNetActivity.this.f22342b.addAll(a2);
                ResourceCenterNetActivity resourceCenterNetActivity = ResourceCenterNetActivity.this;
                d unused = resourceCenterNetActivity.f22344d = new d(resourceCenterNetActivity.getApplicationContext(), ResourceCenterNetActivity.this.f22342b);
                ResourceCenterNetActivity.this.f22341a.setAdapter(ResourceCenterNetActivity.this.f22344d);
                ResourceCenterNetActivity.this.f22344d.a((d.a) new d.a() {
                    public void a(View view, int i2) {
                        int i3;
                        ResourceCenterNetActivity resourceCenterNetActivity;
                        String str;
                        String str2;
                        String str3;
                        String str4;
                        ResourceCenterNetActivity resourceCenterNetActivity2;
                        String b2 = ((f) ResourceCenterNetActivity.this.f22342b.get(i2)).b();
                        String c2 = ((f) ResourceCenterNetActivity.this.f22342b.get(i2)).c();
                        if (ResourceCenterNetActivity.this.b(b2)) {
                            ResourceCenterNetActivity resourceCenterNetActivity3 = ResourceCenterNetActivity.this;
                            if (!resourceCenterNetActivity3.c(ResourceCenterNetActivity.this.f22346f + ResourceCenterNetActivity.this.a(b2))) {
                                PrintStream printStream = System.out;
                                printStream.println("......................" + ResourceCenterNetActivity.this.a(b2));
                                resourceCenterNetActivity2 = ResourceCenterNetActivity.this;
                                str4 = ResourceCenterNetActivity.this.getString(R.string.download_warn);
                                str3 = ResourceCenterNetActivity.this.getString(R.string.download_pdf_check);
                                str2 = ResourceCenterNetActivity.this.getString(R.string.download);
                                str = ResourceCenterNetActivity.this.a(b2);
                                resourceCenterNetActivity = ResourceCenterNetActivity.this;
                                i3 = R.string.pdf_use_whether;
                            } else {
                                resourceCenterNetActivity2 = ResourceCenterNetActivity.this;
                                str4 = ResourceCenterNetActivity.this.getString(R.string.pdf_read);
                                str3 = ResourceCenterNetActivity.this.getString(R.string.pdf_read_whether);
                                str2 = ResourceCenterNetActivity.this.getString(R.string.read);
                                str = ResourceCenterNetActivity.this.a(b2);
                                resourceCenterNetActivity = ResourceCenterNetActivity.this;
                                i3 = R.string.pdf_read_kit;
                            }
                            resourceCenterNetActivity2.a(str4, str3, str2, str, resourceCenterNetActivity.getString(i3));
                        } else if (ResourceCenterNetActivity.a(ResourceCenterNetActivity.this.getApplicationContext())) {
                            Intent intent = new Intent(ResourceCenterNetActivity.this, YoutubeActivity.class);
                            intent.putExtra("open_video", b2);
                            ResourceCenterNetActivity.this.startActivity(intent);
                        } else {
                            ResourceCenterNetActivity.this.a(b2, c2);
                        }
                    }
                });
            }
        }, new i.a() {
            public void a(VolleyError volleyError) {
                Toast.makeText(ResourceCenterNetActivity.this, "download failed!", 0).show();
                System.out.println("download failed");
            }
        }));
        this.f22345e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ResourceCenterNetActivity.this.finish();
            }
        });
    }
}
