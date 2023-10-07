package com.xeagle.android.dialogs;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.common.ip.WifiConnectDlg;

public class x extends a {
    public static x a(String str, String str2) {
        x xVar = new x();
        Bundle bundle = new Bundle();
        bundle.putString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, str);
        bundle.putString("extra_unlock_content", str2);
        xVar.setArguments(bundle);
        return xVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.progress_dlg_check, viewGroup, false);
        Bundle arguments = getArguments();
        String string = getString(R.string.mission_control_takeoff);
        String str = "";
        if (arguments != null) {
            string = arguments.getString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, string);
            str = arguments.getString("extra_unlock_content", str);
        }
        ((TextView) inflate.findViewById(R.id.notify_content)).setText(str);
        ((TextView) inflate.findViewById(R.id.notify_title)).setText(string);
        ((ProgressBar) inflate.findViewById(R.id.progress_bar)).setIndeterminate(true);
        return inflate;
    }
}
