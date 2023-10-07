package com.xeagle.android.communication.service;

import android.app.IntentService;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.util.Log;
import androidx.core.app.h;
import androidx.core.app.k;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.cfly.uav_pro.R;
import com.xeagle.android.utils.prefs.a;
import es.b;
import java.io.File;
import kx.d;
import org.apache.http.client.HttpResponseException;

public class UploaderService extends IntentService {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public static final String f22478a = "UploaderService";

    /* renamed from: b  reason: collision with root package name */
    private a f22479b;

    /* renamed from: c  reason: collision with root package name */
    private final b f22480c = new b() {

        /* renamed from: b  reason: collision with root package name */
        private int f22483b = 0;

        /* renamed from: c  reason: collision with root package name */
        private Notification f22484c;

        public void a(File file) {
            String a2 = UploaderService.f22478a;
            Log.i(a2, "Upload start: " + file);
        }

        public void a(File file, Exception exc) {
            String a2 = UploaderService.f22478a;
            Log.i(a2, "Upload fail: " + file + " " + exc);
            String message = exc instanceof HttpResponseException ? exc.getMessage() : "Upload Failed";
            if (this.f22484c == null) {
                this.f22484c = UploaderService.this.b().b((CharSequence) message).c((CharSequence) UploaderService.this.getString(R.string.uploader_fail_retry_message)).b();
            }
            UploaderService.this.a(this.f22484c);
            if (!NetworkConnectivityReceiver.a(UploaderService.this.getApplicationContext())) {
                Log.d(UploaderService.f22478a, "Activating connectivity receiver");
                NetworkConnectivityReceiver.a(UploaderService.this.getApplicationContext(), true);
            }
        }

        public void a(File file, String str) {
            if (str == null) {
                Log.i(UploaderService.f22478a, "Server thought flight was boring");
                UploaderService.this.f22481d.a(123);
                return;
            }
            String a2 = UploaderService.f22478a;
            Log.i(a2, "Upload success: " + file + " url=" + str);
            PendingIntent activity = PendingIntent.getActivity(UploaderService.this, 0, new Intent("android.intent.action.VIEW", Uri.parse(str)), AMapEngineUtils.HALF_MAX_P20_WIDTH);
            PendingIntent activity2 = PendingIntent.getActivity(UploaderService.this, 0, new Intent("android.intent.action.SEND").putExtra("android.intent.extra.TEXT", str).setType("text/plain"), AMapEngineUtils.HALF_MAX_P20_WIDTH);
            this.f22483b = this.f22483b + 1;
            h.d a3 = UploaderService.this.b().b((CharSequence) UploaderService.this.getString(R.string.uploader_success_message)).a(activity).a(17301585, (CharSequence) "Web", activity).a(17301586, (CharSequence) "Share", activity2);
            int i2 = this.f22483b;
            if (i2 > 1) {
                a3.b(i2);
            }
            UploaderService.this.a(a3.b());
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public k f22481d;

    public UploaderService() {
        super("Uploader");
    }

    public static Intent a(Context context) {
        return new Intent(context, UploaderService.class);
    }

    /* access modifiers changed from: private */
    public void a(Notification notification) {
        this.f22481d.a(124, notification);
    }

    /* access modifiers changed from: private */
    public h.d b() {
        return new h.d(getApplicationContext()).a((CharSequence) getString(R.string.uploader_notification_title)).a((int) R.drawable.ic_launcher).a(true).c(1);
    }

    private void b(Context context) {
        File n2 = d.n(context);
        File o2 = d.o(context);
        String d2 = this.f22479b.d();
        String f2 = this.f22479b.f();
        if (!d2.isEmpty() && !f2.isEmpty()) {
            es.a aVar = new es.a(n2, o2, this.f22480c, d2, f2, this.f22479b.J(), "2d38fb2e.72afe7b3761d5ee6346c178fdd6b680f", "DEFAULT");
            startForeground(123, b().b((CharSequence) "Uploading log file").b());
            aVar.a();
            stopForeground(true);
        }
    }

    private boolean c() {
        return !this.f22479b.d().isEmpty() && !this.f22479b.f().isEmpty();
    }

    public void onCreate() {
        super.onCreate();
        this.f22479b = new a(this);
        this.f22481d = k.a(getApplicationContext());
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        if (this.f22479b.g() && c()) {
            if (NetworkConnectivityReceiver.a(this)) {
                Log.i(f22478a, "Scanning for new uploads");
                b(getApplicationContext());
                return;
            }
            String str = f22478a;
            Log.v(str, "Not scanning - network offline");
            Log.d(str, "Activating connectivity receiver");
            NetworkConnectivityReceiver.a(getApplicationContext(), true);
        }
    }
}
