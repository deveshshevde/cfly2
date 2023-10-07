package com.xeagle.android.utils;

import android.content.Context;
import android.content.res.AssetManager;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import androidx.appcompat.app.AppCompatActivity;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.liulishuo.filedownloader.q;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.dialogs.d;
import com.xeagle.android.dialogs.i;
import com.xeagle.android.utils.d;
import com.xeagle.android.utils.prefs.a;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;

public class o {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public Context f24492a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public i f24493b;

    /* renamed from: c  reason: collision with root package name */
    private d f24494c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public Handler f24495d = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            long longValue = ((Long) message.obj).longValue();
            if (longValue == 0) {
                if (o.this.f24493b == null) {
                    o oVar = o.this;
                    oVar.a(oVar.f24492a.getString(R.string.upload_title), 100);
                } else {
                    o.this.f24493b.a(o.this.f24492a.getString(R.string.upload_title));
                    o.this.f24493b.a(100);
                }
                o.this.f24493b.a(false);
                o.this.f24493b.a(0);
                if (!o.this.f24493b.isAdded()) {
                    o.this.f24493b.show(((AppCompatActivity) o.this.f24492a).getSupportFragmentManager(), "updateApk");
                }
            } else if (longValue <= 0 || longValue >= 100) {
                if (o.this.f24493b == null) {
                    o oVar2 = o.this;
                    oVar2.a(oVar2.f24492a.getString(R.string.upload_title), 100);
                }
                final int i2 = message.arg1;
                o.this.f24493b.a(longValue);
                o.this.f24495d.postDelayed(new Runnable() {
                    public void run() {
                        int i2 = i2;
                        if (i2 == 2) {
                            o.this.f24493b.a(o.this.f24492a.getString(R.string.upload_drone_complete));
                        } else if (i2 == 8) {
                            o.this.f24493b.setCancelable(false);
                            o.this.f24493b.a(o.this.f24492a.getString(R.string.upload_drone_complete));
                            d.a(o.this.f24493b, 60000, (d.a) null);
                        } else {
                            o.this.f24493b.a(o.this.f24492a.getString(R.string.upload_txt_complete));
                            o.this.f24493b.dismiss();
                        }
                    }
                }, 500);
            } else {
                if (o.this.f24493b != null) {
                    if (!o.this.f24493b.isAdded()) {
                        i unused = o.this.f24493b = null;
                    }
                    o.this.f24493b.a(longValue);
                }
                o oVar3 = o.this;
                oVar3.a(oVar3.f24492a.getString(R.string.upload_title), 100);
                o.this.f24493b.a(longValue);
            }
        }
    };

    public o(Context context) {
        this.f24492a = context;
    }

    /* access modifiers changed from: private */
    public void a(String str, int i2) {
        if (this.f24493b == null) {
            i a2 = i.a(str, this.f24492a.getString(R.string.upgrade_warning), (long) i2, new i.a() {
                public void a() {
                    q.a().b();
                }
            });
            this.f24493b = a2;
            a2.show(((AppCompatActivity) this.f24492a).getSupportFragmentManager(), "updateApk");
        }
        if (!this.f24493b.isAdded()) {
            this.f24493b.show(((AppCompatActivity) this.f24492a).getSupportFragmentManager(), "updateApk");
        }
    }

    public void a(Context context, a aVar) {
        String str;
        if (((XEagleApp) context.getApplicationContext()).c()) {
            AssetManager assets = context.getResources().getAssets();
            try {
                if (c.i(aVar.q()) == 160) {
                    str = "1.6.0-20220630-2.cfly";
                } else if (c.i(aVar.q()) == 150) {
                    str = "1.5.0-20220630-2.cfly";
                } else {
                    return;
                }
                InputStream open = assets.open(str);
                if (open != null) {
                    final File file = new File(kx.d.l(context.getApplicationContext()) + "/proxyserver");
                    c.a(open, file);
                    if (file.length() <= 0) {
                        Log.e("FTP", "upgradeRepeaterByLocal: fail ===file is null ");
                        return;
                    }
                    if (this.f24494c == null) {
                        this.f24494c = com.xeagle.android.dialogs.d.a(context.getString(R.string.warning), context.getString(R.string.upgrade_repeater_tips), new d.a() {
                            public void onNo() {
                            }

                            public void onYes() {
                                ka.a.a().b().execute(new Runnable() {
                                    public void run() {
                                        XEagleApp.d().e().a(file.getAbsolutePath(), "/tmp/proxyserver", o.this.f24495d, 21);
                                    }
                                });
                            }
                        });
                    }
                    if (!this.f24494c.isAdded()) {
                        this.f24494c.show(((AppCompatActivity) context).getSupportFragmentManager(), "repeaterUploadDlg");
                        return;
                    }
                    return;
                }
                ToastUtils.showShort((int) R.string.error_no_repeater_firmware);
                Log.i("FTP", "upgradeRepeaterByLocal:=====assert没有此文件 ");
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        }
    }
}
