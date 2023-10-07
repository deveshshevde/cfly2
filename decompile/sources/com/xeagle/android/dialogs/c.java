package com.xeagle.android.dialogs;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.method.MovementMethod;
import android.text.method.ScrollingMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.UnderlineSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.xeagle.android.login.common.ip.TipsDialog;
import com.xeagle.android.login.common.ip.WifiConnectDlg;
import com.xeagle.android.vjoystick.IWidgets.IButton;

public class c extends a {

    /* renamed from: b  reason: collision with root package name */
    protected a f22600b;

    /* renamed from: c  reason: collision with root package name */
    private IButton f22601c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextView f22602d;

    /* renamed from: e  reason: collision with root package name */
    private TextView f22603e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public String f22604f;

    public interface a {
        void onYes();
    }

    public void a(int i2) {
        TextView textView = this.f22602d;
        if (textView != null) {
            textView.setTextColor(i2);
        }
    }

    public void a(MovementMethod movementMethod) {
        TextView textView = this.f22602d;
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void a(final CharSequence charSequence) {
        TextView textView = this.f22602d;
        if (textView != null) {
            textView.post(new Runnable() {
                public void run() {
                    c.this.f22602d.setText(charSequence);
                }
            });
        }
    }

    public void a(String str) {
        TextView textView = this.f22603e;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void b(String str) {
        TextView textView = this.f22602d;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dialog_single_check, viewGroup, false);
        Bundle arguments = getArguments();
        String string = getString(R.string.mission_control_takeoff);
        String string2 = getString(R.string.menu_ok);
        String str = "";
        this.f22604f = str;
        if (arguments != null) {
            string = arguments.getString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, string);
            str = arguments.getString("extra_unlock_content", str);
            string2 = arguments.getString(TipsDialog.EXTRAL_UNLOCK_BTN, string2);
            this.f22604f = arguments.getString(TipsDialog.EXTRAL_COPY_STR, this.f22604f);
        }
        this.f22602d = (TextView) inflate.findViewById(R.id.notify_content);
        String str2 = this.f22604f;
        if (str2 == null || !str2.contains("http")) {
            this.f22602d.setText(str);
            this.f22602d.setMovementMethod(ScrollingMovementMethod.getInstance());
        } else if (str.contains(this.f22604f)) {
            int indexOf = str.indexOf("\"");
            int lastIndexOf = str.lastIndexOf("\"");
            int indexOf2 = str.indexOf(getString(R.string.copy));
            int indexOf3 = str.indexOf(getString(R.string.copy)) + getString(R.string.copy).length();
            Log.i("newUI", "showImageUpdateDlg:--startIndex-- " + indexOf2);
            Log.i("newUI", "showImageUpdateDlg: ---endIndex--" + indexOf3);
            SpannableString spannableString = new SpannableString(str);
            UnderlineSpan underlineSpan = new UnderlineSpan();
            int i2 = indexOf + 1;
            spannableString.setSpan(underlineSpan, i2, lastIndexOf, 33);
            ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(-16776961);
            spannableString.setSpan(foregroundColorSpan, i2, lastIndexOf, 33);
            spannableString.setSpan(underlineSpan, indexOf2, indexOf3, 33);
            spannableString.setSpan(foregroundColorSpan, indexOf2, indexOf3, 33);
            spannableString.setSpan(new ClickableSpan() {
                public void onClick(View view) {
                    ((ClipboardManager) c.this.getActivity().getApplicationContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", c.this.f22604f));
                    c cVar = c.this;
                    cVar.b(cVar.getString(R.string.link_copy_success));
                }
            }, indexOf2, indexOf3, 33);
            spannableString.setSpan(new ClickableSpan() {
                public void onClick(View view) {
                    Log.i("newUI", "onClick:----clip data ");
                    ((ClipboardManager) c.this.getActivity().getApplicationContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", c.this.f22604f));
                    c cVar = c.this;
                    cVar.b(cVar.getString(R.string.link_copy_success));
                }
            }, i2, lastIndexOf, 33);
            this.f22602d.setMovementMethod(ScrollingMovementMethod.getInstance());
            a(LinkMovementMethod.getInstance());
            a((CharSequence) spannableString);
        }
        TextView textView = (TextView) inflate.findViewById(R.id.notify_title);
        this.f22603e = textView;
        textView.setText(string);
        IButton iButton = (IButton) inflate.findViewById(R.id.ib_ok);
        this.f22601c = iButton;
        iButton.setText(string2);
        this.f22601c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (c.this.f22600b != null) {
                    c.this.f22600b.onYes();
                }
                c.this.dismiss();
            }
        });
        return inflate;
    }
}
