package com.xeagle.android.dialogs;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import com.xeagle.android.xrichtext.XRichText;

public class PolicyActivity extends Activity {

    /* renamed from: a  reason: collision with root package name */
    private TextView f22496a;

    /* renamed from: b  reason: collision with root package name */
    private XRichText f22497b;

    /* renamed from: c  reason: collision with root package name */
    private IButton f22498c;

    /* renamed from: d  reason: collision with root package name */
    private String f22499d;

    private void a() {
        this.f22496a = (TextView) findViewById(R.id.policy_title);
        this.f22497b = (XRichText) findViewById(R.id.policy_content);
        ViewGroup.LayoutParams layoutParams = this.f22497b.getLayoutParams();
        layoutParams.width = (getWindowManager().getDefaultDisplay().getWidth() * 3) / 5;
        layoutParams.height = (getWindowManager().getDefaultDisplay().getHeight() * 3) / 5;
        this.f22497b.setLayoutParams(layoutParams);
        IButton iButton = (IButton) findViewById(R.id.policy_agree);
        this.f22498c = iButton;
        iButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                PolicyActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        XRichText xRichText;
        int i2;
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        requestWindowFeature(1);
        setFinishOnTouchOutside(false);
        setContentView(R.layout.activity_policy);
        a();
        String stringExtra = getIntent().getStringExtra("policy_title");
        this.f22499d = stringExtra;
        if (stringExtra.equalsIgnoreCase(getString(R.string.policy_privacy_title))) {
            this.f22496a.setVisibility(8);
            this.f22496a.setText(this.f22499d);
            xRichText = this.f22497b;
            i2 = R.string.policy_privacy_text;
        } else if (this.f22499d.equalsIgnoreCase(getString(R.string.user_notice_title))) {
            this.f22496a.setText(this.f22499d);
            xRichText = this.f22497b;
            i2 = R.string.user_notice_text;
        } else {
            return;
        }
        xRichText.a(getString(i2));
    }
}
