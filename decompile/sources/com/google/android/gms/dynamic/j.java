package com.google.android.gms.dynamic;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.View;

final class j implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ Context f18005a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ Intent f18006b;

    j(Context context, Intent intent) {
        this.f18005a = context;
        this.f18006b = intent;
    }

    public final void onClick(View view) {
        try {
            this.f18005a.startActivity(this.f18006b);
        } catch (ActivityNotFoundException e2) {
            Log.e("DeferredLifecycleHelper", "Failed to start resolution intent", e2);
        }
    }
}
