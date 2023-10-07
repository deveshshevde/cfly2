package com.xeagle.android.dialogs;

import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.xeagle.android.dialogs.u;
import com.xeagle.android.login.common.ip.WifiConnectDlg;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import hf.c;

public class v extends a {

    /* renamed from: b  reason: collision with root package name */
    protected a f22748b;

    /* renamed from: c  reason: collision with root package name */
    private IButton f22749c;

    /* renamed from: d  reason: collision with root package name */
    private IButton f22750d;

    public interface a {
        void agree();

        void disagree();
    }

    public static v a(String str, a aVar) {
        v vVar = new v();
        Bundle bundle = new Bundle();
        bundle.putString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, str);
        vVar.f22748b = aVar;
        vVar.setArguments(bundle);
        return vVar;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_common_yes_check, viewGroup, false);
        Bundle arguments = getArguments();
        String string = getString(R.string.mission_control_takeoff);
        if (arguments != null) {
            string = arguments.getString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, string);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.notify_content);
        String string2 = getString(R.string.policy_dialog_content);
        int indexOf = string2.indexOf(getString(R.string.find_policy));
        int i2 = indexOf + 1;
        int indexOf2 = string2.indexOf(getString(R.string.find_policy), i2);
        int length = indexOf + getString(R.string.policy_privacy_title).length() + 1;
        int length2 = getString(R.string.user_agreement).length() + indexOf2 + 1;
        SpannableString spannableString = new SpannableString(string2);
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(-16776961);
        spannableString.setSpan(foregroundColorSpan, i2, length, 33);
        int i3 = indexOf2 + 1;
        spannableString.setSpan(foregroundColorSpan, i3, length2, 33);
        spannableString.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                u a2 = u.a(v.this.getString(R.string.policy_privacy_title), v.this.getString(R.string.policy_privacy_text), new u.a() {
                    public void onYes() {
                    }
                });
                if (!a2.isAdded() && !c.a()) {
                    a2.show(v.this.getChildFragmentManager(), "policy");
                }
            }
        }, i2, length, 33);
        spannableString.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                u a2 = u.a(v.this.getString(R.string.user_notice_title), v.this.getString(R.string.user_notice_text), new u.a() {
                    public void onYes() {
                    }
                });
                if (!a2.isAdded() && !c.a()) {
                    a2.show(v.this.getChildFragmentManager(), "user");
                }
            }
        }, i3, length2, 33);
        textView.setMovementMethod(ScrollingMovementMethod.getInstance());
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
        ((TextView) inflate.findViewById(R.id.notify_title)).setText(string);
        this.f22749c = (IButton) inflate.findViewById(R.id.ib_cancel);
        IButton iButton = (IButton) inflate.findViewById(R.id.ib_ok);
        this.f22750d = iButton;
        iButton.setText(getString(R.string.policy_agree_text));
        this.f22749c.setText(getString(R.string.policy_no_use));
        this.f22749c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (v.this.f22748b != null) {
                    v.this.f22748b.disagree();
                }
                v.this.dismiss();
            }
        });
        this.f22750d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (v.this.f22748b != null) {
                    v.this.f22748b.agree();
                }
                v.this.dismiss();
            }
        });
        return inflate;
    }
}
