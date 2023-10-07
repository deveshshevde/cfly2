package com.xeagle.android.login.common;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.WindowManager;
import android.widget.TextView;
import com.cfly.uav_pro.R;

public class EasyProgressDialog extends Dialog {
    private Context mContext;
    private int mLayoutId;
    private String mMessage;
    private TextView message;

    public EasyProgressDialog(Context context) {
        this(context, (int) R.style.easy_dialog_style, (int) R.layout.easy_progress_dialog);
    }

    public EasyProgressDialog(Context context, int i2, int i3) {
        super(context, i2);
        this.mContext = context;
        WindowManager.LayoutParams attributes = getWindow().getAttributes();
        attributes.width = -1;
        attributes.height = -1;
        getWindow().setAttributes(attributes);
        this.mLayoutId = i3;
    }

    public EasyProgressDialog(Context context, int i2, String str) {
        this(context, (int) R.style.easy_dialog_style, i2);
        setMessage(str);
    }

    public EasyProgressDialog(Context context, String str) {
        this(context, (int) R.style.easy_dialog_style, (int) R.layout.easy_progress_dialog);
        setMessage(str);
    }

    private void showMessage() {
        if (this.message != null && !TextUtils.isEmpty(this.mMessage)) {
            this.message.setVisibility(0);
            this.message.setText(this.mMessage);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(this.mLayoutId);
        this.message = (TextView) findViewById(R.id.easy_progress_dialog_message);
        showMessage();
    }

    public void setMessage(String str) {
        this.mMessage = str;
    }

    public void updateLoadingMessage(String str) {
        this.mMessage = str;
        showMessage();
    }
}
