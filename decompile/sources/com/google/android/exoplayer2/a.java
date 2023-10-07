package com.google.android.exoplayer2;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

final class a {

    /* renamed from: a  reason: collision with root package name */
    private final Context f15114a;

    /* renamed from: b  reason: collision with root package name */
    private final C0107a f15115b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public boolean f15116c;

    /* renamed from: com.google.android.exoplayer2.a$a  reason: collision with other inner class name */
    private final class C0107a extends BroadcastReceiver implements Runnable {

        /* renamed from: b  reason: collision with root package name */
        private final b f15118b;

        /* renamed from: c  reason: collision with root package name */
        private final Handler f15119c;

        public C0107a(Handler handler, b bVar) {
            this.f15119c = handler;
            this.f15118b = bVar;
        }

        public void onReceive(Context context, Intent intent) {
            if ("android.media.AUDIO_BECOMING_NOISY".equals(intent.getAction())) {
                this.f15119c.post(this);
            }
        }

        public void run() {
            if (a.this.f15116c) {
                this.f15118b.a();
            }
        }
    }

    public interface b {
        void a();
    }

    public a(Context context, Handler handler, b bVar) {
        this.f15114a = context.getApplicationContext();
        this.f15115b = new C0107a(handler, bVar);
    }

    public void a(boolean z2) {
        boolean z3;
        if (z2 && !this.f15116c) {
            this.f15114a.registerReceiver(this.f15115b, new IntentFilter("android.media.AUDIO_BECOMING_NOISY"));
            z3 = true;
        } else if (!z2 && this.f15116c) {
            this.f15114a.unregisterReceiver(this.f15115b);
            z3 = false;
        } else {
            return;
        }
        this.f15116c = z3;
    }
}
