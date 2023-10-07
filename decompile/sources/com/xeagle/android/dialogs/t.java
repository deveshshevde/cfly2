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

public class t extends c {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f22740b = true;

    /* renamed from: a  reason: collision with root package name */
    protected a f22741a;

    /* renamed from: c  reason: collision with root package name */
    private IButton f22742c;

    public interface a {
        void a();
    }

    public static t a(String str, String str2, String str3, String str4, a aVar) {
        t tVar = new t();
        Bundle bundle = new Bundle();
        bundle.putString("extra_file_name", str);
        bundle.putString("extra_file_time", str2);
        bundle.putString("extra_file_resolution", str3);
        bundle.putString("extra_file_size", str4);
        tVar.setArguments(bundle);
        tVar.f22741a = aVar;
        return tVar;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        if (f22740b || window != null) {
            window.setGravity(17);
            create.show();
            window.setLayout((getActivity().getWindowManager().getDefaultDisplay().getWidth() * 1) / 2, (getActivity().getWindowManager().getDefaultDisplay().getHeight() * 1) / 2);
            return create;
        }
        throw new AssertionError();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        String str2;
        View inflate = layoutInflater.inflate(R.layout.photo_info_dlg, viewGroup, false);
        Bundle arguments = getArguments();
        String string = getString(R.string.mission_control_takeoff);
        String str3 = "";
        if (arguments != null) {
            string = arguments.getString("extra_file_name");
            String string2 = arguments.getString("extra_file_time");
            String string3 = arguments.getString("extra_file_resolution");
            str2 = arguments.getString("extra_file_size");
            str = string2;
            str3 = string3;
        } else {
            str = str3;
            str2 = str;
        }
        ((TextView) inflate.findViewById(R.id.file_name_value)).setText(string);
        ((TextView) inflate.findViewById(R.id.file_resolution_value)).setText(str3);
        ((TextView) inflate.findViewById(R.id.file_time_value)).setText(str);
        ((TextView) inflate.findViewById(R.id.file_size_value)).setText(String.format(str2 + "MB", new Object[0]));
        IButton iButton = (IButton) inflate.findViewById(R.id.ib_ok);
        this.f22742c = iButton;
        iButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                t.this.f22741a.a();
                t.this.dismiss();
            }
        });
        return inflate;
    }
}
