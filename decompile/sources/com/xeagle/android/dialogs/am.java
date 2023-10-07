package com.xeagle.android.dialogs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Toast;
import com.cfly.uav_pro.R;
import com.google.android.gms.analytics.HitBuilders;
import com.xeagle.android.dialogs.al;
import com.xeagle.android.utils.prefs.a;

public class am extends al {

    /* renamed from: a  reason: collision with root package name */
    protected a f22575a;

    /* renamed from: c  reason: collision with root package name */
    protected CheckBox f22576c;

    public static am a(Context context, String str, String str2, al.a aVar, String str3) {
        return a(context, str, str2, context.getString(17039379), context.getString(17039369), aVar, str3);
    }

    public static am a(Context context, String str, String str2, String str3, String str4, al.a aVar, String str5) {
        if (str5 != null && !str5.isEmpty()) {
            String string = new a(context).f12775b.getString(str5, context.getString(R.string.pref_dialog_entry_ask));
            if (!string.equals(context.getString(R.string.pref_dialog_entry_ask))) {
                if (aVar == null) {
                    return null;
                }
                if (string.equals(context.getString(R.string.pref_dialog_entry_always))) {
                    aVar.a();
                    return null;
                } else if (!string.equals(context.getString(R.string.pref_dialog_entry_never))) {
                    return null;
                } else {
                    aVar.b();
                    return null;
                }
            }
        }
        am amVar = new am();
        Bundle bundle = new Bundle();
        bundle.putString("title", str);
        bundle.putString("message", str2);
        bundle.putString("positive_label", str3);
        bundle.putString("negative_label", str4);
        bundle.putString("extra_dialog_pref_key", str5);
        amVar.setArguments(bundle);
        amVar.f22572b = aVar;
        return amVar;
    }

    /* access modifiers changed from: private */
    public void a(String str, boolean z2) {
        int i2;
        if (this.f22576c != null) {
            SharedPreferences.Editor edit = this.f22575a.f12775b.edit();
            boolean isChecked = this.f22576c.isChecked();
            if (isChecked) {
                Toast.makeText(getActivity(), R.string.pref_dialog_selection_reset_desc, 1).show();
                i2 = z2 ? R.string.pref_dialog_entry_always : R.string.pref_dialog_entry_never;
            } else {
                i2 = R.string.pref_dialog_entry_ask;
            }
            edit.putString(str, getString(i2));
            edit.apply();
            HitBuilders.EventBuilder action = new HitBuilders.EventBuilder().setCategory("Preference Dialogs").setAction(getArguments().getString("title"));
            StringBuilder sb = new StringBuilder();
            sb.append("Response: ");
            sb.append(z2 ? "Yes" : "No");
            sb.append(isChecked ? " (Always)" : " (Just once)");
            kt.a.a(action.setLabel(sb.toString()));
        }
    }

    private boolean a(String str) {
        String string = getString(R.string.pref_dialog_entry_ask);
        return !this.f22575a.f12775b.getString(str, string).equals(string);
    }

    /* access modifiers changed from: protected */
    public AlertDialog.Builder a(Bundle bundle) {
        AlertDialog.Builder a2 = super.a(bundle);
        Bundle arguments = getArguments();
        final String string = arguments.getString("extra_dialog_pref_key");
        if (string != null && !string.isEmpty()) {
            a2.setPositiveButton(arguments.getString("positive_label"), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    am.this.a(string, true);
                    am.this.f22572b.a();
                }
            }).setNegativeButton(arguments.getString("negative_label"), new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    am.this.a(string, false);
                    am.this.f22572b.b();
                }
            });
        }
        return a2;
    }

    /* access modifiers changed from: protected */
    public View b(Bundle bundle) {
        View b2 = super.b(bundle);
        if (b2 == null) {
            return null;
        }
        String string = getArguments().getString("extra_dialog_pref_key");
        if (string != null && !string.isEmpty()) {
            CheckBox checkBox = (CheckBox) b2.findViewById(R.id.yes_no_dont_show_checkbox);
            this.f22576c = checkBox;
            checkBox.setVisibility(0);
            this.f22576c.setChecked(a(string));
        }
        return b2;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f22575a = new a(getActivity());
    }
}
