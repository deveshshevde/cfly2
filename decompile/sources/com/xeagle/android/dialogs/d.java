package com.xeagle.android.dialogs;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.common.ip.WifiConnectDlg;
import com.xeagle.android.vjoystick.IWidgets.IButton;

public class d extends a {

    /* renamed from: b  reason: collision with root package name */
    protected a f22610b;

    /* renamed from: c  reason: collision with root package name */
    private IButton f22611c;

    /* renamed from: d  reason: collision with root package name */
    private IButton f22612d;

    public interface a {
        void onNo();

        void onYes();
    }

    public static d a(String str, String str2) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, str);
        bundle.putString("extra_unlock_content", str2);
        dVar.setArguments(bundle);
        return dVar;
    }

    public static d a(String str, String str2, a aVar) {
        d dVar = new d();
        Bundle bundle = new Bundle();
        bundle.putString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, str);
        bundle.putString("extra_unlock_content", str2);
        dVar.setArguments(bundle);
        dVar.f22610b = aVar;
        return dVar;
    }

    public void a(a aVar) {
        this.f22610b = aVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        int i2;
        IButton iButton;
        View inflate = layoutInflater.inflate(R.layout.dialog_common_yes_check, viewGroup, false);
        Bundle arguments = getArguments();
        String string = getString(R.string.mission_control_takeoff);
        String str = "";
        if (arguments != null) {
            string = arguments.getString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, string);
            str = arguments.getString("extra_unlock_content", str);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.notify_content);
        textView.setText(str);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        ((TextView) inflate.findViewById(R.id.notify_title)).setText(string);
        this.f22611c = (IButton) inflate.findViewById(R.id.ib_cancel);
        this.f22612d = (IButton) inflate.findViewById(R.id.ib_ok);
        if (str.equalsIgnoreCase(getString(R.string.tips_connect_resolve))) {
            this.f22611c.setText(getString(R.string.tips_refuse));
            iButton = this.f22612d;
            i2 = R.string.tips_try;
        } else {
            this.f22611c.setText(getString(R.string.cancel));
            iButton = this.f22612d;
            i2 = R.string.f14099ok;
        }
        iButton.setText(getString(i2));
        this.f22611c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (d.this.f22610b != null) {
                    d.this.f22610b.onNo();
                }
                d.this.dismiss();
            }
        });
        this.f22612d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (d.this.f22610b != null) {
                    d.this.f22610b.onYes();
                }
                d.this.dismiss();
            }
        });
        return inflate;
    }
}
