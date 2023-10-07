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

public class e extends c {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f22615b = true;

    /* renamed from: a  reason: collision with root package name */
    protected a f22616a;

    public interface a {
        void a();

        void b();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        if (f22615b || window != null) {
            window.setGravity(17);
            create.show();
            window.setLayout((getActivity().getWindowManager().getDefaultDisplay().getWidth() * 3) / 5, (getActivity().getWindowManager().getDefaultDisplay().getHeight() * 3) / 5);
            return create;
        }
        throw new AssertionError();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_common_check, viewGroup, false);
        Bundle arguments = getArguments();
        String string = getString(R.string.mission_control_takeoff);
        String str = "";
        if (arguments != null) {
            arguments.getString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, string);
            str = arguments.getString("extra_unlock_content", str);
        }
        ((TextView) inflate.findViewById(R.id.notify_content)).setText(str);
        inflate.findViewById(R.id.ib_cancel).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e.this.f22616a.b();
                e.this.dismiss();
            }
        });
        inflate.findViewById(R.id.ib_ok).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                e.this.f22616a.a();
                e.this.dismiss();
            }
        });
        return inflate;
    }
}
