package com.xeagle.android.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.fragment.app.c;
import com.cfly.uav_pro.R;

public class al extends c {

    /* renamed from: b  reason: collision with root package name */
    protected a f22572b;

    public interface a {
        void a();

        void b();
    }

    public static al a(Context context, String str, String str2, a aVar) {
        al alVar = new al();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("message", str2);
        bundle.putString("positive_label", context.getString(17039379));
        bundle.putString("negative_label", context.getString(17039369));
        alVar.setArguments(bundle);
        alVar.f22572b = aVar;
        return alVar;
    }

    /* access modifiers changed from: protected */
    public AlertDialog.Builder a(Bundle bundle) {
        Bundle arguments = getArguments();
        return new AlertDialog.Builder(getActivity()).setIcon(R.drawable.arma).setTitle(arguments.getString("title")).setView(b(bundle)).setPositiveButton(arguments.getString("positive_label"), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                al.this.f22572b.a();
            }
        }).setNegativeButton(arguments.getString("negative_label"), new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                al.this.f22572b.b();
            }
        });
    }

    /* access modifiers changed from: protected */
    public View b(Bundle bundle) {
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_yes_no_content, (ViewGroup) null);
        if (inflate == null) {
            return inflate;
        }
        ((TextView) inflate.findViewById(R.id.yes_no_message)).setText(getArguments().getString("message"));
        return inflate;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        return a(bundle).create();
    }
}
