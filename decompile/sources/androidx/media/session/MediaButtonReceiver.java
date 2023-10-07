package androidx.media.session;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.os.Build;
import android.os.Bundle;
import android.os.RemoteException;
import android.support.v4.media.MediaBrowserCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.util.Log;
import android.view.KeyEvent;
import java.util.List;

public class MediaButtonReceiver extends BroadcastReceiver {

    private static class a extends MediaBrowserCompat.b {

        /* renamed from: c  reason: collision with root package name */
        private final Context f3809c;

        /* renamed from: d  reason: collision with root package name */
        private final Intent f3810d;

        /* renamed from: e  reason: collision with root package name */
        private final BroadcastReceiver.PendingResult f3811e;

        /* renamed from: f  reason: collision with root package name */
        private MediaBrowserCompat f3812f;

        a(Context context, Intent intent, BroadcastReceiver.PendingResult pendingResult) {
            this.f3809c = context;
            this.f3810d = intent;
            this.f3811e = pendingResult;
        }

        private void d() {
            this.f3812f.b();
            this.f3811e.finish();
        }

        public void a() {
            try {
                new MediaControllerCompat(this.f3809c, this.f3812f.c()).a((KeyEvent) this.f3810d.getParcelableExtra("android.intent.extra.KEY_EVENT"));
            } catch (RemoteException e2) {
                Log.e("MediaButtonReceiver", "Failed to create a media controller", e2);
            }
            d();
        }

        /* access modifiers changed from: package-private */
        public void a(MediaBrowserCompat mediaBrowserCompat) {
            this.f3812f = mediaBrowserCompat;
        }

        public void b() {
            d();
        }

        public void c() {
            d();
        }
    }

    private static ComponentName a(Context context, String str) {
        PackageManager packageManager = context.getPackageManager();
        Intent intent = new Intent(str);
        intent.setPackage(context.getPackageName());
        List<ResolveInfo> queryIntentServices = packageManager.queryIntentServices(intent, 0);
        if (queryIntentServices.size() == 1) {
            ResolveInfo resolveInfo = queryIntentServices.get(0);
            return new ComponentName(resolveInfo.serviceInfo.packageName, resolveInfo.serviceInfo.name);
        } else if (queryIntentServices.isEmpty()) {
            return null;
        } else {
            throw new IllegalStateException("Expected 1 service that handles " + str + ", found " + queryIntentServices.size());
        }
    }

    private static void a(Context context, Intent intent) {
        if (Build.VERSION.SDK_INT >= 26) {
            context.startForegroundService(intent);
        } else {
            context.startService(intent);
        }
    }

    public void onReceive(Context context, Intent intent) {
        if (intent == null || !"android.intent.action.MEDIA_BUTTON".equals(intent.getAction()) || !intent.hasExtra("android.intent.extra.KEY_EVENT")) {
            Log.d("MediaButtonReceiver", "Ignore unsupported intent: " + intent);
            return;
        }
        ComponentName a2 = a(context, "android.intent.action.MEDIA_BUTTON");
        if (a2 != null) {
            intent.setComponent(a2);
            a(context, intent);
            return;
        }
        ComponentName a3 = a(context, "android.media.browse.MediaBrowserService");
        if (a3 != null) {
            BroadcastReceiver.PendingResult goAsync = goAsync();
            Context applicationContext = context.getApplicationContext();
            a aVar = new a(applicationContext, intent, goAsync);
            MediaBrowserCompat mediaBrowserCompat = new MediaBrowserCompat(applicationContext, a3, aVar, (Bundle) null);
            aVar.a(mediaBrowserCompat);
            mediaBrowserCompat.a();
            return;
        }
        throw new IllegalStateException("Could not find any Service that handles android.intent.action.MEDIA_BUTTON or implements a media browser service.");
    }
}
