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
import com.xeagle.android.xrichtext.XRichText;

public class u extends c {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f22744b = true;

    /* renamed from: a  reason: collision with root package name */
    protected a f22745a;

    /* renamed from: c  reason: collision with root package name */
    private IButton f22746c;

    public interface a {
        void onYes();
    }

    public static u a(String str, String str2, a aVar) {
        u uVar = new u();
        Bundle bundle = new Bundle();
        bundle.putString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, str);
        bundle.putString("extra_unlock_content", str2);
        uVar.setArguments(bundle);
        uVar.f22745a = aVar;
        return uVar;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        if (f22744b || window != null) {
            window.setGravity(17);
            create.show();
            window.setLayout((getActivity().getWindowManager().getDefaultDisplay().getWidth() * 4) / 5, (getActivity().getWindowManager().getDefaultDisplay().getHeight() * 9) / 10);
            return create;
        }
        throw new AssertionError();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.activity_policy, viewGroup, false);
        Bundle arguments = getArguments();
        String string = getString(R.string.mission_control_takeoff);
        String str = "";
        if (arguments != null) {
            string = arguments.getString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, string);
            str = arguments.getString("extra_unlock_content", str);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.policy_title);
        textView.setText(string);
        ((XRichText) inflate.findViewById(R.id.policy_content)).a(str);
        if (string.equals(getString(R.string.policy_privacy_title))) {
            textView.setVisibility(8);
        }
        IButton iButton = (IButton) inflate.findViewById(R.id.policy_agree);
        this.f22746c = iButton;
        iButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                u.this.f22745a.onYes();
                u.this.dismiss();
            }
        });
        return inflate;
    }
}
