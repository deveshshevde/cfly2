package com.afollestad.materialdialogs.datetime.internal;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.Calendar;
import kotlin.l;
import mm.b;

public final class TimeChangeListener$receiver$1 extends BroadcastReceiver {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f7563a;

    public void onReceive(Context context, Intent intent) {
        Calendar instance = Calendar.getInstance();
        int i2 = instance.get(11);
        int i3 = instance.get(12);
        if (this.f7563a.f7568c == null) {
            return;
        }
        if (this.f7563a.f7566a != i2 || this.f7563a.f7567b != i3) {
            b d2 = this.f7563a.f7569d;
            if (d2 != null) {
                l lVar = (l) d2.invoke(this.f7563a.f7568c);
            }
            this.f7563a.f7566a = i2;
            this.f7563a.f7567b = i3;
        }
    }
}
