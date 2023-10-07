package com.xeagle.android.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.cfly.uav_pro.R;

public class k extends al {

    /* renamed from: a  reason: collision with root package name */
    protected a f22680a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public EditText f22681c;

    public interface a {
        void a();

        void a(CharSequence charSequence);
    }

    public static k a(Context context, String str, String str2, a aVar) {
        k kVar = new k();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        if (str2 == null) {
            str2 = "";
        }
        bundle.putString("hint", str2);
        kVar.setArguments(bundle);
        kVar.f22680a = aVar;
        return kVar;
    }

    /* access modifiers changed from: protected */
    public AlertDialog.Builder a(Bundle bundle) {
        return new AlertDialog.Builder(getActivity()).setTitle(getArguments().getString("title")).setView(b(bundle)).setPositiveButton(17039370, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                CharSequence text = k.this.f22681c.getText();
                if (text == null) {
                    text = k.this.f22681c.getHint();
                }
                k.this.f22680a.a(text);
            }
        }).setNegativeButton(17039360, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialogInterface, int i2) {
                k.this.f22680a.a();
            }
        });
    }

    /* access modifiers changed from: protected */
    public View b(Bundle bundle) {
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_edit_input_content, (ViewGroup) null);
        if (inflate == null) {
            return inflate;
        }
        EditText editText = (EditText) inflate.findViewById(R.id.dialog_edit_text_content);
        this.f22681c = editText;
        editText.setHint(getArguments().getString("hint"));
        return inflate;
    }
}
