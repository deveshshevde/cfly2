package com.flypro.core.util;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import androidx.core.app.JobIntentService;

public class ListenerWriteService extends JobIntentService {
    public static void a(Context context, Intent intent) {
        a(context, (Class<?>) ListenerWriteService.class, 1111, intent);
    }

    /* access modifiers changed from: protected */
    public void a(Intent intent) {
        Log.i("ListenerService", "onHandleWork:=======START ");
        a.a().c(getApplicationContext());
    }

    public void onDestroy() {
        super.onDestroy();
        Log.i("ListenerService", "onDestroy: ======");
    }
}
