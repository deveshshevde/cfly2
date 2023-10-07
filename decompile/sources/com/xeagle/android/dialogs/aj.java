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
import com.xeagle.android.vjoystick.IWidgets.IButton;

public class aj extends c {

    /* renamed from: a  reason: collision with root package name */
    static final /* synthetic */ boolean f22558a = true;

    /* renamed from: b  reason: collision with root package name */
    private IButton f22559b;

    /* renamed from: c  reason: collision with root package name */
    private TextView f22560c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f22561d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f22562e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f22563f;

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        if (f22558a || window != null) {
            window.setGravity(17);
            create.show();
            window.setLayout((getActivity().getWindowManager().getDefaultDisplay().getWidth() * 3) / 5, (getActivity().getWindowManager().getDefaultDisplay().getHeight() * 3) / 5);
            return create;
        }
        throw new AssertionError();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        View inflate = layoutInflater.inflate(R.layout.dlg_version_info, viewGroup, false);
        Bundle arguments = getArguments();
        if (arguments != null) {
            str7 = arguments.getString("extra_title", "");
            str6 = arguments.getString("extra_app", "");
            str5 = arguments.getString("extra_drone", "");
            str4 = arguments.getString("extra_wifi", "");
            str3 = arguments.getString("extra_rc", "");
            str2 = arguments.getString("extra_camera", "");
            str = arguments.getString("extra_mac", "");
        } else {
            str = "";
            str7 = str;
            str6 = str7;
            str5 = str6;
            str4 = str5;
            str3 = str4;
            str2 = str3;
        }
        ((TextView) inflate.findViewById(R.id.notify_title)).setText(str7);
        ((TextView) inflate.findViewById(R.id.version_app_txt)).setText(str6);
        ((TextView) inflate.findViewById(R.id.version_drone_firmware_txt)).setText(str5);
        this.f22563f = (TextView) inflate.findViewById(R.id.version_wifi_firmware_txt);
        this.f22560c = (TextView) inflate.findViewById(R.id.version_wifi_firmware);
        if (str4.equalsIgnoreCase("")) {
            this.f22560c.setVisibility(8);
            this.f22563f.setVisibility(8);
        } else {
            this.f22560c.setVisibility(0);
            this.f22563f.setVisibility(0);
        }
        this.f22563f.setText(str4);
        this.f22562e = (TextView) inflate.findViewById(R.id.version_rc_firmware_txt);
        this.f22561d = (TextView) inflate.findViewById(R.id.version_rc_firmware);
        if (str3.equalsIgnoreCase("")) {
            this.f22562e.setVisibility(8);
            this.f22561d.setVisibility(8);
        } else {
            this.f22562e.setVisibility(0);
            this.f22561d.setVisibility(0);
        }
        this.f22562e.setText(str3);
        ((TextView) inflate.findViewById(R.id.version_camera_firmware_txt)).setText(str2);
        ((TextView) inflate.findViewById(R.id.device_mac_txt)).setText(str);
        IButton iButton = (IButton) inflate.findViewById(R.id.ib_ok);
        this.f22559b = iButton;
        iButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                aj.this.dismiss();
            }
        });
        return inflate;
    }
}
