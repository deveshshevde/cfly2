package nt;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;

public class c {

    /* renamed from: a  reason: collision with root package name */
    public static int f31622a;

    /* renamed from: b  reason: collision with root package name */
    public static Class<?> f31623b;

    public static class a extends androidx.fragment.app.c implements DialogInterface.OnClickListener {
        public void onClick(DialogInterface dialogInterface, int i2) {
            c.a(dialogInterface, i2, getActivity(), getArguments());
        }

        public Dialog onCreateDialog(Bundle bundle) {
            return c.a(getActivity(), getArguments(), this);
        }
    }

    public static Dialog a(Context context, Bundle bundle, DialogInterface.OnClickListener onClickListener) {
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setTitle(bundle.getString("de.greenrobot.eventbus.errordialog.title"));
        builder.setMessage(bundle.getString("de.greenrobot.eventbus.errordialog.message"));
        int i2 = f31622a;
        if (i2 != 0) {
            builder.setIcon(i2);
        }
        builder.setPositiveButton(17039370, onClickListener);
        return builder.create();
    }

    public static void a(DialogInterface dialogInterface, int i2, Activity activity, Bundle bundle) {
        Class<?> cls = f31623b;
        if (cls != null) {
            try {
                d.f31624a.f31621a.a().d(cls.newInstance());
            } catch (Exception e2) {
                throw new RuntimeException("Event cannot be constructed", e2);
            }
        }
        if (bundle.getBoolean("de.greenrobot.eventbus.errordialog.finish_after_dialog", false) && activity != null) {
            activity.finish();
        }
    }
}
