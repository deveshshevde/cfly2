package com.xeagle.android.login.common.ip;

import android.app.Dialog;
import android.net.wifi.WifiConfiguration;
import android.os.Bundle;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.cfly.uav_pro.R;

public class WifiLinkDialog extends Dialog implements View.OnClickListener {
    private Button cancel_button;
    /* access modifiers changed from: private */
    public String capabilities;
    /* access modifiers changed from: private */
    public Button cofirm_button;
    private AppCompatActivity mContext;
    /* access modifiers changed from: private */
    public EditText password_edit;
    private TextView text_name;
    private String text_nameString = null;

    public WifiLinkDialog(AppCompatActivity appCompatActivity, int i2, String str, String str2) {
        super(appCompatActivity, i2);
        this.text_nameString = str;
        this.capabilities = str2;
        this.mContext = appCompatActivity;
    }

    private void initListener() {
        this.cancel_button.setOnClickListener(this);
        this.cofirm_button.setOnClickListener(this);
        this.password_edit.addTextChangedListener(new TextWatcher() {
            /* JADX WARNING: Code restructure failed: missing block: B:11:0x005b, code lost:
                if (com.xeagle.android.login.common.ip.WifiLinkDialog.access$100(r4.this$0).getText().toString().length() < 8) goto L_0x007e;
             */
            /* JADX WARNING: Code restructure failed: missing block: B:15:0x007c, code lost:
                if (com.xeagle.android.login.common.ip.WifiLinkDialog.access$100(r4.this$0).getText().toString().length() < 8) goto L_0x007e;
             */
            /* Code decompiled incorrectly, please refer to instructions dump. */
            public void afterTextChanged(android.text.Editable r5) {
                /*
                    r4 = this;
                    com.xeagle.android.login.common.ip.WifiLinkDialog r5 = com.xeagle.android.login.common.ip.WifiLinkDialog.this
                    java.lang.String r5 = r5.capabilities
                    java.lang.String r0 = "WPA"
                    boolean r5 = r5.contains(r0)
                    r0 = 0
                    r1 = 8
                    r2 = 1
                    if (r5 != 0) goto L_0x005e
                    com.xeagle.android.login.common.ip.WifiLinkDialog r5 = com.xeagle.android.login.common.ip.WifiLinkDialog.this
                    java.lang.String r5 = r5.capabilities
                    java.lang.String r3 = "WPA2"
                    boolean r5 = r5.contains(r3)
                    if (r5 != 0) goto L_0x005e
                    com.xeagle.android.login.common.ip.WifiLinkDialog r5 = com.xeagle.android.login.common.ip.WifiLinkDialog.this
                    java.lang.String r5 = r5.capabilities
                    java.lang.String r3 = "WPS"
                    boolean r5 = r5.contains(r3)
                    if (r5 == 0) goto L_0x002f
                    goto L_0x005e
                L_0x002f:
                    com.xeagle.android.login.common.ip.WifiLinkDialog r5 = com.xeagle.android.login.common.ip.WifiLinkDialog.this
                    java.lang.String r5 = r5.capabilities
                    java.lang.String r3 = "WEP"
                    boolean r5 = r5.contains(r3)
                    if (r5 == 0) goto L_0x0091
                    com.xeagle.android.login.common.ip.WifiLinkDialog r5 = com.xeagle.android.login.common.ip.WifiLinkDialog.this
                    android.widget.EditText r5 = r5.password_edit
                    android.text.Editable r5 = r5.getText()
                    if (r5 != 0) goto L_0x0088
                    com.xeagle.android.login.common.ip.WifiLinkDialog r5 = com.xeagle.android.login.common.ip.WifiLinkDialog.this
                    android.widget.EditText r5 = r5.password_edit
                    android.text.Editable r5 = r5.getText()
                    java.lang.String r5 = r5.toString()
                    int r5 = r5.length()
                    if (r5 >= r1) goto L_0x0088
                    goto L_0x007e
                L_0x005e:
                    com.xeagle.android.login.common.ip.WifiLinkDialog r5 = com.xeagle.android.login.common.ip.WifiLinkDialog.this
                    android.widget.EditText r5 = r5.password_edit
                    android.text.Editable r5 = r5.getText()
                    if (r5 != 0) goto L_0x0088
                    com.xeagle.android.login.common.ip.WifiLinkDialog r5 = com.xeagle.android.login.common.ip.WifiLinkDialog.this
                    android.widget.EditText r5 = r5.password_edit
                    android.text.Editable r5 = r5.getText()
                    java.lang.String r5 = r5.toString()
                    int r5 = r5.length()
                    if (r5 >= r1) goto L_0x0088
                L_0x007e:
                    com.xeagle.android.login.common.ip.WifiLinkDialog r5 = com.xeagle.android.login.common.ip.WifiLinkDialog.this
                    android.widget.Button r5 = r5.cofirm_button
                    r5.setClickable(r0)
                    goto L_0x0091
                L_0x0088:
                    com.xeagle.android.login.common.ip.WifiLinkDialog r5 = com.xeagle.android.login.common.ip.WifiLinkDialog.this
                    android.widget.Button r5 = r5.cofirm_button
                    r5.setClickable(r2)
                L_0x0091:
                    return
                */
                throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.common.ip.WifiLinkDialog.AnonymousClass1.afterTextChanged(android.text.Editable):void");
            }

            public void beforeTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }

            public void onTextChanged(CharSequence charSequence, int i2, int i3, int i4) {
            }
        });
    }

    private void initView(View view) {
        this.text_name = (TextView) view.findViewById(R.id.wifi_title);
        this.password_edit = (EditText) view.findViewById(R.id.password_edit);
        this.cancel_button = (Button) view.findViewById(R.id.cancel_button);
        this.cofirm_button = (Button) view.findViewById(R.id.cofirm_button);
    }

    public void onClick(View view) {
        int id2 = view.getId();
        if (id2 != R.id.cancel_button) {
            if (id2 == R.id.cofirm_button) {
                WifiConfiguration isExsits = WifiSupport.isExsits(this.text_nameString, getContext());
                if (isExsits == null) {
                    isExsits = WifiSupport.createWifiConfig(this.text_nameString, this.password_edit.getText().toString(), WifiSupport.getWifiCipher(this.capabilities));
                }
                WifiSupport.addNetWork(isExsits, getContext());
            } else {
                return;
            }
        }
        dismiss();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.setting_wifi_link_dialog, (ViewGroup) null);
        setContentView(inflate);
        Window window = getWindow();
        if (window != null) {
            WindowManager.LayoutParams attributes = window.getAttributes();
            attributes.width = (this.mContext.getWindowManager().getDefaultDisplay().getWidth() * 4) / 5;
            attributes.height = (this.mContext.getWindowManager().getDefaultDisplay().getHeight() * 2) / 5;
            window.setAttributes(attributes);
        }
        initView(inflate);
        this.text_name.setText(this.text_nameString);
        initListener();
    }
}
