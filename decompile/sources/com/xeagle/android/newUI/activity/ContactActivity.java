package com.xeagle.android.newUI.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.flypro.core.database.UserInfo;
import com.flypro.core.database.UserLiteHelper;
import com.xeagle.android.XEagleApp;
import ea.e;
import java.util.Locale;
import ka.a;

public class ContactActivity extends BaseActivity {

    /* renamed from: a  reason: collision with root package name */
    private TextView f23831a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public EditText f23832b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public EditText f23833c;

    /* renamed from: d  reason: collision with root package name */
    private Button f23834d;

    private void a() {
        this.f23831a = (TextView) findViewById(R.id.tv_back);
        this.f23832b = (EditText) findViewById(R.id.et_title);
        this.f23833c = (EditText) findViewById(R.id.et_content);
        this.f23834d = (Button) findViewById(R.id.btn_send);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public void a(final String str, final String str2, final String str3) {
        a.a().b().execute(new Runnable() {
            public void run() {
                try {
                    com.xeagle.android.utils.prefs.a j2 = ((XEagleApp) ContactActivity.this.getApplicationContext()).j();
                    e n2 = ((XEagleApp) ContactActivity.this.getApplicationContext()).n();
                    UserInfo userInfo = UserLiteHelper.getUserInfo(j2.aE());
                    new kl.a().a(str, String.format(Locale.US, "%s\n--from--%s--userId:%s-userEmail:%s--AppName--%s", new Object[]{str2, n2.i(), j2.aE(), userInfo.getEmail(), "C-FLY2"}), str3);
                    ToastUtils.showShort((int) R.string.send_email_success);
                    ContactActivity.this.finish();
                } catch (Exception e2) {
                    ToastUtils.showShort((CharSequence) ContactActivity.this.getString(R.string.send_email_error) + e2.getMessage());
                    e2.printStackTrace();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public boolean a(String str, String str2) {
        int i2;
        if (TextUtils.isEmpty(str)) {
            i2 = R.string.newui_input_title;
        } else if (str.length() > 20) {
            i2 = R.string.newui_input_title_tip;
        } else if (TextUtils.isEmpty(str2)) {
            i2 = R.string.newui_input_content;
        } else if (str2.length() <= 500) {
            return true;
        } else {
            i2 = R.string.newui_input_content_tip;
        }
        ToastUtils.showShort(i2);
        return false;
    }

    private void b() {
        this.f23831a.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ContactActivity.this.a(view);
            }
        });
        this.f23834d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String trim = ContactActivity.this.f23832b.getText().toString().trim();
                String trim2 = ContactActivity.this.f23833c.getText().toString().trim();
                if (ContactActivity.this.a(trim, trim2)) {
                    ContactActivity.this.a(trim, trim2, "contacts-china@cfly-cn.com");
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.newui_activity_contact);
        a();
        b();
    }
}
