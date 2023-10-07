package com.xeagle.android.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import androidx.fragment.app.c;
import com.cfly.uav_pro.R;
import com.google.android.gms.analytics.HitBuilders;
import com.xeagle.android.utils.prefs.a;

public class j extends c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f22672a;

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f22672a = new a(getActivity());
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.droneshare_account, (ViewGroup) null);
        final EditText editText = (EditText) inflate.findViewById(R.id.username);
        final EditText editText2 = (EditText) inflate.findViewById(R.id.password);
        final EditText editText3 = (EditText) inflate.findViewById(R.id.email);
        final RadioButton radioButton = (RadioButton) inflate.findViewById(R.id.radioCreateNew);
        final RadioButton radioButton2 = (RadioButton) inflate.findViewById(R.id.radioLoginExisting);
        final RadioButton radioButton3 = (RadioButton) inflate.findViewById(R.id.radioNoDroneshare);
        editText.setText(this.f22672a.d());
        editText2.setText(this.f22672a.f());
        editText3.setText(this.f22672a.e());
        editText.requestFocus();
        if (!this.f22672a.g()) {
            radioButton3.setSelected(true);
        } else if (this.f22672a.d().isEmpty() || this.f22672a.f().isEmpty()) {
            radioButton.setSelected(true);
        } else {
            radioButton2.setSelected(true);
        }
        builder.setView(inflate).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                String str;
                HitBuilders.SocialBuilder action = new HitBuilders.SocialBuilder().setNetwork("Droneshare").setAction("droneshare_prompt");
                if (radioButton3.isChecked()) {
                    j.this.f22672a.a(false);
                    str = "disabled";
                } else {
                    j.this.f22672a.a(true);
                    j.this.f22672a.a(editText.getText().toString());
                    j.this.f22672a.c(editText2.getText().toString());
                    j.this.f22672a.b(editText3.getText().toString());
                    if (radioButton.isChecked()) {
                        str = "sign up";
                    } else {
                        if (radioButton2.isChecked()) {
                            str = "login";
                        }
                        kt.a.a(action);
                    }
                }
                action.setTarget(str);
                kt.a.a(action);
            }
        });
        return builder.create();
    }

    public void onDismiss(DialogInterface dialogInterface) {
        super.onDismiss(dialogInterface);
        kt.a.a(new HitBuilders.EventBuilder().setCategory("Droneshare").setAction("droneshare_prompt").setLabel("droneshare prompt dismissed"));
    }
}
