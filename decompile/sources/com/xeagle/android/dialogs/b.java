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

public class b extends c {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f22592b = true;

    /* renamed from: a  reason: collision with root package name */
    protected a f22593a;

    /* renamed from: c  reason: collision with root package name */
    private IButton f22594c;

    /* renamed from: d  reason: collision with root package name */
    private IButton f22595d;

    /* renamed from: e  reason: collision with root package name */
    private IButton f22596e;

    public interface a {
        void a();

        void b();

        void c();
    }

    public static b a(String str, String str2, String str3, String str4, String str5, a aVar) {
        b bVar = new b();
        Bundle bundle = new Bundle();
        bundle.putString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, str);
        bundle.putString("extra_unlock_content", str2);
        bundle.putString("extra_unlock_left", str3);
        bundle.putString("extra_unlock_middle", str4);
        bundle.putString("extra_unlock_right", str5);
        bVar.setArguments(bundle);
        bVar.f22593a = aVar;
        return bVar;
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        dismiss();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        if (f22592b || window != null) {
            window.setGravity(17);
            create.show();
            window.setLayout((getActivity().getWindowManager().getDefaultDisplay().getWidth() * 1) / 2, (getActivity().getWindowManager().getDefaultDisplay().getHeight() * 2) / 5);
            return create;
        }
        throw new AssertionError();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        String str2;
        String str3;
        View inflate = layoutInflater.inflate(R.layout.btn_mul_dlg, viewGroup, false);
        Bundle arguments = getArguments();
        String string = getString(R.string.mission_control_takeoff);
        String str4 = "";
        if (arguments != null) {
            string = arguments.getString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, string);
            String string2 = arguments.getString("extra_unlock_content", str4);
            str3 = arguments.getString("extra_unlock_left", str4);
            str2 = arguments.getString("extra_unlock_middle", str4);
            str = arguments.getString("extra_unlock_right", str4);
            str4 = string2;
        } else {
            str = str4;
            str3 = str;
            str2 = str3;
        }
        ((TextView) inflate.findViewById(R.id.notify_content)).setText(str4);
        ((TextView) inflate.findViewById(R.id.notify_title)).setText(string);
        inflate.findViewById(R.id.ib_go_back).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                b.this.a(view);
            }
        });
        this.f22594c = (IButton) inflate.findViewById(R.id.ib_left);
        this.f22595d = (IButton) inflate.findViewById(R.id.ib_middle);
        this.f22596e = (IButton) inflate.findViewById(R.id.ib_right);
        this.f22594c.setText(str3);
        this.f22595d.setText(str2);
        this.f22596e.setText(str);
        this.f22594c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                b.this.f22593a.c();
                b.this.dismiss();
            }
        });
        this.f22595d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                b.this.f22593a.b();
                b.this.dismiss();
            }
        });
        this.f22596e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                b.this.f22593a.a();
                b.this.dismiss();
            }
        });
        return inflate;
    }
}
