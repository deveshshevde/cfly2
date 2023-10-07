package com.xeagle.android.newUI.fragment.remindFragment;

import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.common.ip.WifiConnectDlg;
import com.xeagle.android.vjoystick.IWidgets.IButton;

public class a extends com.xeagle.android.dialogs.a {

    /* renamed from: b  reason: collision with root package name */
    public C0150a f24031b;

    /* renamed from: c  reason: collision with root package name */
    private IButton f24032c;

    /* renamed from: d  reason: collision with root package name */
    private IButton f24033d;

    /* renamed from: com.xeagle.android.newUI.fragment.remindFragment.a$a  reason: collision with other inner class name */
    public interface C0150a {
        void a();

        void b();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        this.f24031b.a();
        dismiss();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        this.f24031b.b();
        dismiss();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_active_guide, viewGroup, false);
        Bundle arguments = getArguments();
        String string = getString(R.string.mission_control_takeoff);
        if (arguments != null) {
            arguments.getString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, string);
        }
        this.f24032c = (IButton) inflate.findViewById(R.id.bt_active);
        this.f24033d = (IButton) inflate.findViewById(R.id.bt_skip);
        TextView textView = (TextView) inflate.findViewById(R.id.tv_active_content);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        this.f24033d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.b(view);
            }
        });
        this.f24032c.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                a.this.a(view);
            }
        });
        return inflate;
    }
}
