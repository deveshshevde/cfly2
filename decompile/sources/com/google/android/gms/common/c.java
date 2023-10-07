package com.google.android.gms.common;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ProgressBar;
import androidx.core.app.h;
import androidx.fragment.app.FragmentActivity;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.google.android.gms.base.R;
import com.google.android.gms.common.api.GoogleApiActivity;
import com.google.android.gms.common.api.internal.bn;
import com.google.android.gms.common.api.internal.i;
import com.google.android.gms.common.api.internal.zabx;
import com.google.android.gms.common.internal.aa;
import com.google.android.gms.common.internal.m;
import com.google.android.gms.common.internal.w;
import com.google.android.gms.common.util.g;
import com.google.android.gms.common.util.l;
import com.google.android.gms.internal.base.zal;
import gi.a;

public class c extends d {

    /* renamed from: a  reason: collision with root package name */
    public static final int f17668a = d.f17673b;

    /* renamed from: c  reason: collision with root package name */
    private static final Object f17669c = new Object();

    /* renamed from: d  reason: collision with root package name */
    private static final c f17670d = new c();

    /* renamed from: e  reason: collision with root package name */
    private String f17671e;

    public static c a() {
        return f17670d;
    }

    public int a(Context context) {
        return super.a(context);
    }

    public int a(Context context, int i2) {
        return super.a(context, i2);
    }

    public Dialog a(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        return a((Context) activity, i2, aa.a(activity, a((Context) activity, i2, "d"), i3), onCancelListener);
    }

    public final Dialog a(Activity activity, DialogInterface.OnCancelListener onCancelListener) {
        ProgressBar progressBar = new ProgressBar(activity, (AttributeSet) null, 16842874);
        progressBar.setIndeterminate(true);
        progressBar.setVisibility(0);
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        builder.setView(progressBar);
        builder.setMessage(w.b(activity, 18));
        builder.setPositiveButton("", (DialogInterface.OnClickListener) null);
        AlertDialog create = builder.create();
        a(activity, (Dialog) create, "GooglePlayServicesUpdatingDialog", onCancelListener);
        return create;
    }

    /* access modifiers changed from: package-private */
    public final Dialog a(Context context, int i2, aa aaVar, DialogInterface.OnCancelListener onCancelListener) {
        AlertDialog.Builder builder = null;
        if (i2 == 0) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(16843529, typedValue, true);
        if ("Theme.Dialog.Alert".equals(context.getResources().getResourceEntryName(typedValue.resourceId))) {
            builder = new AlertDialog.Builder(context, 5);
        }
        if (builder == null) {
            builder = new AlertDialog.Builder(context);
        }
        builder.setMessage(w.b(context, i2));
        if (onCancelListener != null) {
            builder.setOnCancelListener(onCancelListener);
        }
        String a2 = w.a(context, i2);
        if (a2 != null) {
            builder.setPositiveButton(a2, aaVar);
        }
        String e2 = w.e(context, i2);
        if (e2 != null) {
            builder.setTitle(e2);
        }
        Log.w("GoogleApiAvailability", String.format("Creating dialog for Google Play services availability issue. ConnectionResult=%s", new Object[]{Integer.valueOf(i2)}), new IllegalArgumentException());
        return builder.create();
    }

    public PendingIntent a(Context context, int i2, int i3) {
        return super.a(context, i2, i3);
    }

    public PendingIntent a(Context context, ConnectionResult connectionResult) {
        return connectionResult.d() ? connectionResult.b() : a(context, connectionResult.a(), 0);
    }

    public Intent a(Context context, int i2, String str) {
        return super.a(context, i2, str);
    }

    public final zabx a(Context context, bn bnVar) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.PACKAGE_ADDED");
        intentFilter.addDataScheme("package");
        zabx zabx = new zabx(bnVar);
        context.registerReceiver(zabx, intentFilter);
        zabx.a(context);
        if (a(context, "com.google.android.gms")) {
            return zabx;
        }
        bnVar.a();
        zabx.a();
        return null;
    }

    public final String a(int i2) {
        return super.a(i2);
    }

    /* access modifiers changed from: package-private */
    public final void a(Activity activity, Dialog dialog, String str, DialogInterface.OnCancelListener onCancelListener) {
        try {
            if (activity instanceof FragmentActivity) {
                h.a(dialog, onCancelListener).show(((FragmentActivity) activity).getSupportFragmentManager(), str);
                return;
            }
        } catch (NoClassDefFoundError unused) {
        }
        b.a(dialog, onCancelListener).show(activity.getFragmentManager(), str);
    }

    /* access modifiers changed from: package-private */
    public final void a(Context context, int i2, String str, PendingIntent pendingIntent) {
        int i3;
        String str2;
        Log.w("GoogleApiAvailability", String.format("GMS core API Availability. ConnectionResult=%s, tag=%s", new Object[]{Integer.valueOf(i2), null}), new IllegalArgumentException());
        if (i2 == 18) {
            b(context);
        } else if (pendingIntent != null) {
            String d2 = w.d(context, i2);
            String c2 = w.c(context, i2);
            Resources resources = context.getResources();
            NotificationManager notificationManager = (NotificationManager) m.a(context.getSystemService("notification"));
            h.d a2 = new h.d(context).b(true).a(true).a((CharSequence) d2).a((h.e) new h.b().a((CharSequence) c2));
            if (g.b(context)) {
                m.b(l.c());
                a2.a(context.getApplicationInfo().icon).c(2);
                if (g.c(context)) {
                    a2.a(R.drawable.common_full_open_on_phone, (CharSequence) resources.getString(R.string.common_open_on_phone), pendingIntent);
                } else {
                    a2.a(pendingIntent);
                }
            } else {
                a2.a(17301642).e(resources.getString(R.string.common_google_play_services_notification_ticker)).a(System.currentTimeMillis()).a(pendingIntent).b((CharSequence) c2);
            }
            if (l.f()) {
                m.b(l.f());
                synchronized (f17669c) {
                    str2 = this.f17671e;
                }
                if (str2 == null) {
                    str2 = "com.google.android.gms.availability";
                    NotificationChannel notificationChannel = notificationManager.getNotificationChannel(str2);
                    String b2 = w.b(context);
                    if (notificationChannel == null) {
                        notificationChannel = new NotificationChannel(str2, b2, 4);
                    } else if (!b2.contentEquals(notificationChannel.getName())) {
                        notificationChannel.setName(b2);
                    }
                    notificationManager.createNotificationChannel(notificationChannel);
                }
                a2.a(str2);
            }
            Notification b3 = a2.b();
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                f.f17697c.set(false);
                i3 = 10436;
            } else {
                i3 = 39789;
            }
            notificationManager.notify(i3, b3);
        } else if (i2 == 6) {
            Log.w("GoogleApiAvailability", "Missing resolution for ConnectionResult.RESOLUTION_REQUIRED. Call GoogleApiAvailability#showErrorNotification(Context, ConnectionResult) instead.");
        }
    }

    public final boolean a(Activity activity, i iVar, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog a2 = a((Context) activity, i2, aa.a(iVar, a((Context) activity, i2, "d"), 2), onCancelListener);
        if (a2 == null) {
            return false;
        }
        a(activity, a2, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }

    public final boolean a(Context context, ConnectionResult connectionResult, int i2) {
        PendingIntent a2;
        if (a.a(context) || (a2 = a(context, connectionResult)) == null) {
            return false;
        }
        a(context, connectionResult.a(), (String) null, zal.zaa(context, 0, GoogleApiActivity.a(context, a2, i2, true), zal.zaa | AMapEngineUtils.HALF_MAX_P20_WIDTH));
        return true;
    }

    /* access modifiers changed from: package-private */
    public final void b(Context context) {
        new i(this, context).sendEmptyMessageDelayed(1, 120000);
    }

    public void b(Context context, int i2) {
        a(context, i2, (String) null, a(context, i2, 0, "n"));
    }

    public final boolean b(int i2) {
        return super.b(i2);
    }

    public boolean b(Activity activity, int i2, int i3, DialogInterface.OnCancelListener onCancelListener) {
        Dialog a2 = a(activity, i2, i3, onCancelListener);
        if (a2 == null) {
            return false;
        }
        a(activity, a2, "GooglePlayServicesErrorDialog", onCancelListener);
        return true;
    }
}
