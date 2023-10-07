package com.xeagle.android.dialogs;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.common.ip.TipsDialog;
import com.xeagle.android.login.common.ip.WifiConnectDlg;
import com.xeagle.android.vjoystick.IWidgets.IButton;

public class o extends a {

    /* renamed from: b  reason: collision with root package name */
    protected a f22702b;

    /* renamed from: c  reason: collision with root package name */
    private IButton f22703c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f22704d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f22705e;

    public interface a {
        void a();
    }

    public static o a(String str, String str2, a aVar) {
        o oVar = new o();
        Bundle bundle = new Bundle();
        bundle.putString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, str);
        bundle.putString("extra_unlock_content", str2);
        oVar.setArguments(bundle);
        oVar.f22702b = aVar;
        return oVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.image_btn_dialog, viewGroup, false);
        Bundle arguments = getArguments();
        String string = getString(R.string.mission_control_takeoff);
        String string2 = getString(R.string.menu_ok);
        String str = "";
        if (arguments != null) {
            string = arguments.getString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, string);
            str = arguments.getString("extra_unlock_content", str);
            string2 = arguments.getString(TipsDialog.EXTRAL_UNLOCK_BTN, string2);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.notify_content);
        this.f22704d = textView;
        textView.setText(str);
        this.f22704d.setMovementMethod(ScrollingMovementMethod.getInstance());
        TextView textView2 = (TextView) inflate.findViewById(R.id.notify_title);
        this.f22705e = textView2;
        textView2.setText(string);
        IButton iButton = (IButton) inflate.findViewById(R.id.ib_ok);
        this.f22703c = iButton;
        iButton.setText(string2);
        this.f22703c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                o.this.f22702b.a();
                o.this.dismiss();
            }
        });
        return inflate;
    }
}
