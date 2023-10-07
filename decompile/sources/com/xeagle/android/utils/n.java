package com.xeagle.android.utils;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.afollestad.materialdialogs.b;
import com.afollestad.materialdialogs.lifecycle.a;
import com.cfly.uav_pro.R;
import kotlin.jvm.internal.h;

public final class n {

    /* renamed from: a  reason: collision with root package name */
    private static b f24490a;

    /* renamed from: b  reason: collision with root package name */
    private static ProgressDialog f24491b;

    public static final ProgressDialog a(AppCompatActivity appCompatActivity, String str, DialogInterface.OnClickListener onClickListener) {
        h.d(appCompatActivity, "$this$showProgressExt");
        h.d(str, "message");
        h.d(onClickListener, "listener");
        ProgressDialog progressDialog = f24491b;
        if (progressDialog != null) {
            h.a((Object) progressDialog);
            if (progressDialog.isShowing()) {
                ProgressDialog progressDialog2 = f24491b;
                h.a((Object) progressDialog2);
                progressDialog2.dismiss();
            }
        }
        if (!appCompatActivity.isFinishing()) {
            ProgressDialog progressDialog3 = new ProgressDialog(appCompatActivity);
            progressDialog3.setTitle(str);
            progressDialog3.setProgressStyle(1);
            progressDialog3.setCancelable(false);
            progressDialog3.setButton(-2, appCompatActivity.getString(R.string.cancel), onClickListener);
            f24491b = progressDialog3;
        }
        ProgressDialog progressDialog4 = f24491b;
        if (progressDialog4 != null) {
            progressDialog4.show();
        }
        return f24491b;
    }

    public static /* synthetic */ ProgressDialog a(AppCompatActivity appCompatActivity, String str, DialogInterface.OnClickListener onClickListener, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = appCompatActivity.getString(R.string.download);
            h.b(str, "getString(R.string.download)");
        }
        return a(appCompatActivity, str, onClickListener);
    }

    public static final void a(Activity activity) {
        h.d(activity, "$this$dismissLoadingExt");
        b bVar = f24490a;
        if (bVar != null) {
            bVar.dismiss();
        }
        f24490a = null;
    }

    public static final void a(AppCompatActivity appCompatActivity, String str) {
        View a2;
        h.d(appCompatActivity, "$this$showLoadingExt");
        h.d(str, "message");
        if (!appCompatActivity.isFinishing()) {
            if (f24490a == null) {
                Context context = appCompatActivity;
                b a3 = a.a(com.afollestad.materialdialogs.customview.a.a(b.a(new b(context, (com.afollestad.materialdialogs.a) null, 2, (f) null).a(true).b(false), Float.valueOf(12.0f), (Integer) null, 2, (Object) null), Integer.valueOf(R.layout.layout_custom_dialog_view), (View) null, false, false, false, false, 62, (Object) null), appCompatActivity);
                f24490a = a3;
                if (!(a3 == null || (a2 = com.afollestad.materialdialogs.customview.a.a(a3)) == null)) {
                    View findViewById = a2.findViewById(R.id.loading_tips);
                    h.b(findViewById, "this.findViewById<TextView>(R.id.loading_tips)");
                    ((TextView) findViewById).setText(str);
                    View findViewById2 = a2.findViewById(R.id.progressBar);
                    h.b(findViewById2, "this.findViewById<ProgressBar>(R.id.progressBar)");
                    ((ProgressBar) findViewById2).setIndeterminateTintList(u.f24533a.b(context));
                }
            }
            b bVar = f24490a;
            if (bVar != null) {
                bVar.show();
            }
        }
    }

    public static final void a(AppCompatActivity appCompatActivity, String str, View.OnClickListener onClickListener) {
        b bVar;
        View a2;
        h.d(appCompatActivity, "$this$showLoadingExt");
        h.d(str, "message");
        h.d(onClickListener, "listener");
        if (!appCompatActivity.isFinishing()) {
            if (f24490a == null) {
                b a3 = a.a(com.afollestad.materialdialogs.customview.a.a(b.a(new b(appCompatActivity, (com.afollestad.materialdialogs.a) null, 2, (f) null).a(false).b(false), Float.valueOf(12.0f), (Integer) null, 2, (Object) null), Integer.valueOf(R.layout.layout_custom_dialog_view), (View) null, false, false, false, false, 62, (Object) null), appCompatActivity);
                f24490a = a3;
                if (!(a3 == null || (a2 = com.afollestad.materialdialogs.customview.a.a(a3)) == null)) {
                    View findViewById = a2.findViewById(R.id.loading_tips);
                    h.b(findViewById, "this.findViewById<TextView>(R.id.loading_tips)");
                    ((TextView) findViewById).setText(str);
                    ((TextView) a2.findViewById(R.id.tvCancel)).setOnClickListener(onClickListener);
                }
            }
            b bVar2 = f24490a;
            if (!(bVar2 == null || !bVar2.isShowing() || (bVar = f24490a) == null)) {
                bVar.dismiss();
            }
            b bVar3 = f24490a;
            if (bVar3 != null) {
                bVar3.show();
            }
        }
    }

    public static final void b(Activity activity) {
        h.d(activity, "$this$dismissProgressExt");
        ProgressDialog progressDialog = f24491b;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
        f24491b = null;
    }

    public static final void b(AppCompatActivity appCompatActivity, String str) {
        b bVar;
        View a2;
        h.d(appCompatActivity, "$this$showLoadingDig");
        h.d(str, "message");
        if (!appCompatActivity.isFinishing()) {
            if (f24490a == null) {
                b a3 = a.a(com.afollestad.materialdialogs.customview.a.a(b.a(new b(appCompatActivity, (com.afollestad.materialdialogs.a) null, 2, (f) null).a(false).b(false), Float.valueOf(12.0f), (Integer) null, 2, (Object) null), Integer.valueOf(R.layout.layout_custom_dialog_view), (View) null, false, false, false, false, 62, (Object) null), appCompatActivity);
                f24490a = a3;
                if (!(a3 == null || (a2 = com.afollestad.materialdialogs.customview.a.a(a3)) == null)) {
                    View findViewById = a2.findViewById(R.id.loading_tips);
                    h.b(findViewById, "this.findViewById<TextView>(R.id.loading_tips)");
                    ((TextView) findViewById).setText(str);
                    View findViewById2 = a2.findViewById(R.id.tvCancel);
                    h.b(findViewById2, "this.findViewById<TextView>(R.id.tvCancel)");
                    ((TextView) findViewById2).setVisibility(8);
                }
            }
            b bVar2 = f24490a;
            if (!(bVar2 == null || !bVar2.isShowing() || (bVar = f24490a) == null)) {
                bVar.dismiss();
            }
            b bVar3 = f24490a;
            if (bVar3 != null) {
                bVar3.show();
            }
        }
    }
}
