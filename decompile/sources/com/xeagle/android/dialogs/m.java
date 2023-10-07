package com.xeagle.android.dialogs;

import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.common.ip.WifiConnectDlg;
import com.xeagle.android.vjoystick.IWidgets.IButton;

public class m extends a {

    /* renamed from: b  reason: collision with root package name */
    protected a f22692b;

    /* renamed from: c  reason: collision with root package name */
    private IButton f22693c;

    /* renamed from: d  reason: collision with root package name */
    private IButton f22694d;

    /* renamed from: e  reason: collision with root package name */
    private IButton f22695e;

    public interface a {
        void a();

        void b();

        void c();
    }

    private View a() {
        View inflate = getActivity().getLayoutInflater().inflate(R.layout.dialog_force_check, (ViewGroup) null, false);
        a(inflate);
        return inflate;
    }

    private void a(View view) {
        IButton iButton;
        int i2;
        Bundle arguments = getArguments();
        String string = getString(R.string.mission_control_takeoff);
        String str = "";
        if (arguments != null) {
            string = arguments.getString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, string);
            str = arguments.getString("extra_unlock_content", str);
        }
        Log.i("Force", "hideMiddleBtn:===initView: ");
        TextView textView = (TextView) view.findViewById(R.id.notify_content);
        textView.setText(str);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        ((TextView) view.findViewById(R.id.notify_title)).setText(string);
        this.f22693c = (IButton) view.findViewById(R.id.ib_cancel);
        this.f22694d = (IButton) view.findViewById(R.id.ib_ok);
        this.f22695e = (IButton) view.findViewById(R.id.ib_middle);
        if (str.equalsIgnoreCase(getString(R.string.tips_connect_resolve))) {
            this.f22693c.setText(getString(R.string.tips_refuse));
            iButton = this.f22694d;
            i2 = R.string.tips_try;
        } else {
            this.f22693c.setText(getString(R.string.cancel));
            iButton = this.f22694d;
            i2 = R.string.f14099ok;
        }
        iButton.setText(getString(i2));
        this.f22693c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (m.this.f22692b != null) {
                    m.this.f22692b.b();
                }
                m.this.dismiss();
            }
        });
        this.f22695e.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                m.this.b(view);
            }
        });
        this.f22694d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (m.this.f22692b != null) {
                    m.this.f22692b.a();
                }
                m.this.dismiss();
            }
        });
        a aVar = this.f22692b;
        if (aVar != null) {
            aVar.c();
        }
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        a aVar = this.f22692b;
        if (aVar != null) {
            aVar.a();
        }
        dismiss();
    }

    public void a(a aVar) {
        this.f22692b = aVar;
    }

    public void a(boolean z2) {
        IButton iButton;
        int i2;
        Log.i("Force", "hideMiddleBtn:==== ");
        if (this.f22695e != null) {
            Log.i("Force", "hideMiddleBtn:====1111111 ");
            if (z2) {
                iButton = this.f22695e;
                i2 = 8;
            } else {
                iButton = this.f22695e;
                i2 = 0;
            }
            iButton.setVisibility(i2);
        }
    }

    public void b(boolean z2) {
        IButton iButton;
        if (this.f22694d != null && (iButton = this.f22693c) != null) {
            int i2 = z2 ? 8 : 0;
            iButton.setVisibility(i2);
            this.f22694d.setVisibility(i2);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        Dialog onCreateDialog = super.onCreateDialog(bundle);
        onCreateDialog.setContentView(a());
        onCreateDialog.setOnKeyListener(new DialogInterface.OnKeyListener() {
            public boolean onKey(DialogInterface dialogInterface, int i2, KeyEvent keyEvent) {
                return keyEvent.getKeyCode() == 4;
            }
        });
        return onCreateDialog;
    }
}
