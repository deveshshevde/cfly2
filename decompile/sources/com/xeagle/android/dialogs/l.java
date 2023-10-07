package com.xeagle.android.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.c;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.common.ip.WifiConnectDlg;
import com.xeagle.android.vjoystick.IWidgets.IButton;

public class l extends c {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f22684b = true;

    /* renamed from: a  reason: collision with root package name */
    protected a f22685a;

    /* renamed from: c  reason: collision with root package name */
    private IButton f22686c;

    /* renamed from: d  reason: collision with root package name */
    private IButton f22687d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public EditText f22688e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f22689f;

    public interface a {
        void a();

        void a(EditText editText);
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(8);
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        if (f22684b || window != null) {
            window.setGravity(17);
            create.show();
            window.setLayout((getActivity().getWindowManager().getDefaultDisplay().getWidth() * 1) / 2, (getActivity().getWindowManager().getDefaultDisplay().getHeight() * 2) / 5);
            return create;
        }
        throw new AssertionError();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        String str;
        View inflate = layoutInflater.inflate(R.layout.editor_common_dialog, viewGroup, false);
        Bundle arguments = getArguments();
        String string = getString(R.string.mission_control_takeoff);
        int i2 = 50;
        if (arguments != null) {
            string = arguments.getString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, string);
            str = arguments.getString("extra_unlock_content", "");
            i2 = arguments.getInt("extra_unlock_value", 50);
        } else {
            str = "";
        }
        TextView textView = (TextView) inflate.findViewById(R.id.editor_warn);
        this.f22689f = textView;
        textView.setText(str);
        ((TextView) inflate.findViewById(R.id.notify_title)).setText(string);
        EditText editText = (EditText) inflate.findViewById(R.id.editor_set);
        this.f22688e = editText;
        editText.setHint(i2 + "");
        this.f22686c = (IButton) inflate.findViewById(R.id.ib_cancel);
        this.f22687d = (IButton) inflate.findViewById(R.id.ib_ok);
        this.f22686c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                l.this.f22685a.a();
                l.this.dismiss();
            }
        });
        this.f22687d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                l.this.f22685a.a(l.this.f22688e);
                l.this.dismiss();
            }
        });
        return inflate;
    }
}
