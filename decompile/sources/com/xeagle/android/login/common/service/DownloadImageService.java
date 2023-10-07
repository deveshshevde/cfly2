package com.xeagle.android.login.common.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.widget.ImageView;
import com.flypro.core.database.UserLiteHelper;
import com.flypro.core.util.d;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import java.util.ArrayList;
import le.b;
import org.litepal.crud.callback.SaveCallback;

public class DownloadImageService extends Service {
    /* access modifiers changed from: private */
    public String iconPath;

    public class DownloadBinder extends Binder {
        public DownloadBinder() {
        }

        public DownloadImageService getService() {
            return DownloadImageService.this;
        }
    }

    public interface OnServiceListener {
        void onServiceListener();
    }

    public void downloadAvatar(final String str, String str2, String str3, final OnServiceListener onServiceListener) {
        if (!d.a(str2).equalsIgnoreCase(d.a(str3))) {
            le.d dVar = new le.d(UserGlobal.BASE_URL, new b() {
                public void onFail(String str) {
                }

                public void onFinishDownload() {
                    UserLiteHelper.updateUserIcon(str, DownloadImageService.this.iconPath, new SaveCallback() {
                        public void onFinish(boolean z2) {
                            onServiceListener.onServiceListener();
                        }
                    });
                }

                public void onFinishDownload(ArrayList<Object> arrayList) {
                }

                public void onProgress(int i2) {
                }

                public void onStartDownload() {
                }
            });
            String str4 = kx.d.k(getApplicationContext()) + d.a(str2);
            this.iconPath = str4;
            dVar.a(str2, (ImageView) null, 120, 120, str4);
            return;
        }
        onServiceListener.onServiceListener();
    }

    public IBinder onBind(Intent intent) {
        return new DownloadBinder();
    }

    public void onCreate() {
        super.onCreate();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        return super.onStartCommand(intent, i2, i3);
    }
}
