package com.xeagle.android.login.common.ip;

import android.app.AlertDialog;
import android.app.Dialog;
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
import android.view.Window;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;
import androidx.fragment.app.c;
import com.cfly.uav_pro.R;
import com.xeagle.android.vjoystick.IWidgets.IButton;

public class TipsDialog extends c {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String EXTRAL_COPY_STR = "extra_copy_str";
    public static final String EXTRAL_PREF_KEY = "extra_pref_key";
    public static final String EXTRAL_UNLOCK_BTN = "extra_unlock_btn";
    public static final String EXTRAL_UNLOCK_CONTENT = "extra_unlock_content";
    private IButton bt_ok;
    /* access modifiers changed from: private */
    public String copyStr;
    public Listener listener;
    /* access modifiers changed from: private */
    public TextView slide_content;

    public interface Listener {
        void onCheckBtn(boolean z2);

        void onYes();
    }

    public Dialog onCreateDialog(Bundle bundle) {
        int i2;
        int i3;
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        window.setGravity(17);
        create.show();
        int width = getActivity().getWindowManager().getDefaultDisplay().getWidth();
        int height = getActivity().getWindowManager().getDefaultDisplay().getHeight();
        if (width >= height) {
            i3 = width / 2;
            i2 = height * 3;
        } else {
            i3 = (width * 4) / 5;
            i2 = height * 2;
        }
        window.setLayout(i3, i2 / 5);
        return create;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        boolean z2 = false;
        View inflate = layoutInflater.inflate(R.layout.tips_dialog_layout, viewGroup, false);
        Bundle arguments = getArguments();
        String string = getString(R.string.menu_ok);
        String str = "";
        this.copyStr = str;
        if (arguments != null) {
            z2 = arguments.getBoolean(EXTRAL_PREF_KEY, false);
            str = arguments.getString("extra_unlock_content", str);
            string = arguments.getString(EXTRAL_UNLOCK_BTN, string);
            this.copyStr = arguments.getString(EXTRAL_COPY_STR, this.copyStr);
        }
        this.slide_content = (TextView) inflate.findViewById(R.id.notify_content);
        String str2 = this.copyStr;
        if (str2 == null || !str2.contains("http")) {
            this.slide_content.setText(str);
            this.slide_content.setMovementMethod(ScrollingMovementMethod.getInstance());
        } else if (str.contains(this.copyStr)) {
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
                    ((ClipboardManager) TipsDialog.this.getActivity().getApplicationContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", TipsDialog.this.copyStr));
                    TipsDialog tipsDialog = TipsDialog.this;
                    tipsDialog.setText_content(tipsDialog.getString(R.string.link_copy_success));
                }
            }, indexOf2, indexOf3, 33);
            spannableString.setSpan(new ClickableSpan() {
                public void onClick(View view) {
                    Log.i("newUI", "onClick:----clip data ");
                    ((ClipboardManager) TipsDialog.this.getActivity().getApplicationContext().getSystemService("clipboard")).setPrimaryClip(ClipData.newPlainText("simple text", TipsDialog.this.copyStr));
                    TipsDialog tipsDialog = TipsDialog.this;
                    tipsDialog.setText_content(tipsDialog.getString(R.string.link_copy_success));
                }
            }, i2, lastIndexOf, 33);
            this.slide_content.setMovementMethod(ScrollingMovementMethod.getInstance());
            setMovementMethod(LinkMovementMethod.getInstance());
            setText_content((CharSequence) spannableString);
        }
        CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.never_check);
        checkBox.setChecked(z2);
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z2) {
                if (TipsDialog.this.listener != null) {
                    TipsDialog.this.listener.onCheckBtn(z2);
                }
            }
        });
        IButton iButton = (IButton) inflate.findViewById(R.id.ib_close);
        this.bt_ok = iButton;
        iButton.setText(string);
        this.bt_ok.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (TipsDialog.this.listener != null) {
                    TipsDialog.this.listener.onYes();
                }
                TipsDialog.this.dismiss();
            }
        });
        return inflate;
    }

    public void setMovementMethod(MovementMethod movementMethod) {
        TextView textView = this.slide_content;
        if (textView != null) {
            textView.setMovementMethod(LinkMovementMethod.getInstance());
        }
    }

    public void setText_content(final CharSequence charSequence) {
        TextView textView = this.slide_content;
        if (textView != null) {
            textView.post(new Runnable() {
                public void run() {
                    TipsDialog.this.slide_content.setText(charSequence);
                }
            });
        }
    }

    public void setText_content(String str) {
        TextView textView = this.slide_content;
        if (textView != null) {
            textView.setText(str);
        }
    }
}
