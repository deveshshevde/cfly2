package com.xeagle.android.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.c;
import com.cfly.uav_pro.R;

public class af extends c implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    protected a f22517a;

    public interface a {
        void a();

        void b();

        void c();
    }

    private void a(View view) {
        Bundle arguments = getArguments();
        ((TextView) view.findViewById(R.id.title_dlg_tv)).setText(arguments.getString("title"));
        ((TextView) view.findViewById(R.id.message_dlg_tv)).setText(arguments.getString("message"));
        Button button = (Button) view.findViewById(R.id.bt_download);
        Button button2 = (Button) view.findViewById(R.id.bt_play);
        Button button3 = (Button) view.findViewById(R.id.bt_delete);
        button.setText(arguments.getString("positive_label"));
        String string = arguments.getString("neutral_label");
        if (string == null || !string.equals("neutral")) {
            button2.setVisibility(0);
            button2.setText(string);
        } else {
            button2.setVisibility(8);
        }
        button3.setText(arguments.getString("negative_label"));
        button.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 == R.id.bt_delete) {
            this.f22517a.c();
        } else if (id2 == R.id.bt_download) {
            this.f22517a.a();
        } else if (id2 == R.id.bt_play) {
            this.f22517a.b();
        } else {
            return;
        }
        dismiss();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(false);
        create.getWindow().setGravity(17);
        create.show();
        return create;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.custom_dialog_layout, viewGroup, false);
        a(inflate);
        getDialog().setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                if (i2 != 4) {
                    return false;
                }
                dialogInterface.dismiss();
                return false;
            }
        });
        return inflate;
    }
}
