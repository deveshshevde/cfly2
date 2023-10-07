package com.xeagle.android.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.TextView;
import androidx.fragment.app.c;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.common.ip.WifiConnectDlg;
import com.xeagle.android.vjoystick.IWidgets.IButton;

public class f extends c {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f22619b = true;

    /* renamed from: a  reason: collision with root package name */
    protected a f22620a;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public IButton f22621c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public IButton f22622d;

    public interface a {
        void a();

        void b();
    }

    public static f a(String str, String str2, String str3, String str4, a aVar) {
        f fVar = new f();
        Bundle bundle = new Bundle();
        bundle.putString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, str);
        bundle.putString("extra_unlock_content", str2);
        bundle.putString("extra_unlock_close", str3);
        bundle.putString("extra_unlock_ok", str4);
        fVar.setArguments(bundle);
        fVar.f22620a = aVar;
        return fVar;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        if (f22619b || window != null) {
            window.setGravity(17);
            create.show();
            window.setLayout((getActivity().getWindowManager().getDefaultDisplay().getWidth() * 1) / 2, (getActivity().getWindowManager().getDefaultDisplay().getHeight() * 2) / 5);
            return create;
        }
        throw new AssertionError();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        final String str;
        final String str2;
        final String str3;
        final String str4;
        View inflate = layoutInflater.inflate(R.layout.dialog_common_yes_check, viewGroup, false);
        Bundle arguments = getArguments();
        String string = getString(R.string.mission_control_takeoff);
        if (arguments != null) {
            String string2 = arguments.getString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, string);
            String string3 = arguments.getString("extra_unlock_content", "");
            String string4 = arguments.getString("extra_unlock_close", "");
            str3 = string2;
            str = arguments.getString("extra_unlock_ok", "");
            str4 = string3;
            str2 = string4;
        } else {
            str3 = string;
            str4 = "";
            str2 = str4;
            str = str2;
        }
        final TextView textView = (TextView) inflate.findViewById(R.id.notify_content);
        final TextView textView2 = (TextView) inflate.findViewById(R.id.notify_title);
        this.f22621c = (IButton) inflate.findViewById(R.id.ib_cancel);
        this.f22622d = (IButton) inflate.findViewById(R.id.ib_ok);
        if (getActivity() != null) {
            getActivity().runOnUiThread(new Runnable() {
                public void run() {
                    textView.setText(str4);
                    textView2.setText(str3);
                    f.this.f22621c.setText(str2);
                    f.this.f22622d.setText(str);
                }
            });
        }
        this.f22621c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.f22620a.b();
                f.this.dismiss();
            }
        });
        this.f22622d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                f.this.f22620a.a();
                f.this.dismiss();
            }
        });
        return inflate;
    }
}
