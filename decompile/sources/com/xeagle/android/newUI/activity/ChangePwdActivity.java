package com.xeagle.android.newUI.activity;

import android.content.Intent;
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
import com.xeagle.android.login.WelcomeActivity;
import com.xeagle.android.login.beans.UploadAcceptBeans;
import com.xeagle.android.login.retrofitLogin.RegContract;
import com.xeagle.android.login.retrofitLogin.RegPresenter;
import com.xeagle.android.login.retrofitLogin.UploadCallBack;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.utils.prefs.a;
import java.util.ArrayList;
import okhttp3.w;
import org.litepal.crud.callback.SaveCallback;
import retrofit2.Call;
import retrofit2.Response;

public class ChangePwdActivity extends BaseActivity implements RegContract.lLoadView {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f23820a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public UserInfo f23821b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public RegPresenter f23822c;

    /* renamed from: d  reason: collision with root package name */
    private TextView f23823d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public EditText f23824e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public EditText f23825f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public EditText f23826g;

    /* renamed from: h  reason: collision with root package name */
    private Button f23827h;

    /* access modifiers changed from: private */
    public w.b a(String str, String str2) {
        return w.b.a(str, str2);
    }

    private void a() {
        a j2 = ((XEagleApp) getApplication()).j();
        this.f23820a = j2;
        this.f23821b = UserLiteHelper.getUserInfo(j2.aE());
        this.f23822c = new RegPresenter(this);
        this.f23823d = (TextView) findViewById(R.id.tv_back);
        this.f23824e = (EditText) findViewById(R.id.et_old_pwd);
        this.f23825f = (EditText) findViewById(R.id.et_new_pwd);
        this.f23826g = (EditText) findViewById(R.id.et_confirm_pwd);
        this.f23827h = (Button) findViewById(R.id.btn_change_pwd);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public boolean a(String str, String str2, String str3) {
        int i2;
        if (TextUtils.isEmpty(str)) {
            i2 = R.string.newui_input_old_pwd;
        } else if (!TextUtils.equals(str, this.f23821b.getPassword())) {
            i2 = R.string.enter_old_pw_incorrectly;
        } else if (TextUtils.isEmpty(str2)) {
            i2 = R.string.newui_input_new_pwd;
        } else if (str2.length() > 20 || str2.length() < 8) {
            i2 = R.string.characters_warn;
        } else if (TextUtils.equals(str2, str3)) {
            return true;
        } else {
            i2 = R.string.newui_pwd_no_same;
        }
        ToastUtils.showShort(i2);
        return false;
    }

    private void b() {
        this.f23823d.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ChangePwdActivity.this.a(view);
            }
        });
        this.f23827h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                String trim = ChangePwdActivity.this.f23824e.getText().toString().trim();
                String trim2 = ChangePwdActivity.this.f23825f.getText().toString().trim();
                String trim3 = ChangePwdActivity.this.f23826g.getText().toString().trim();
                if (ChangePwdActivity.this.f23821b != null && ChangePwdActivity.this.a(trim, trim2, trim3)) {
                    ArrayList arrayList = new ArrayList();
                    ChangePwdActivity changePwdActivity = ChangePwdActivity.this;
                    arrayList.add(changePwdActivity.a("token", changePwdActivity.f23821b.getToken()));
                    arrayList.add(ChangePwdActivity.this.a("oldPassword", trim));
                    arrayList.add(ChangePwdActivity.this.a("newPassword", trim2));
                    ChangePwdActivity.this.f23822c.getUserInfoResult(UserGlobal.BASE_URL, arrayList, new UploadCallBack<UploadAcceptBeans>() {
                        public void onFailure(Call<UploadAcceptBeans> call, Throwable th) {
                        }

                        public void onSuccess(Call<UploadAcceptBeans> call, Response<UploadAcceptBeans> response) {
                            UserLiteHelper.updateUserPassword(ChangePwdActivity.this.f23820a.aE(), ChangePwdActivity.this.f23825f.getText().toString(), new SaveCallback() {
                                public void onFinish(boolean z2) {
                                    ChangePwdActivity.this.f23820a.K("-");
                                    ChangePwdActivity.this.startActivity(new Intent(ChangePwdActivity.this, WelcomeActivity.class));
                                    ChangePwdActivity.this.finish();
                                }
                            });
                        }
                    });
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.newui_activity_change_pwd);
        a();
        b();
    }

    public void regError(int i2, String str) {
    }

    public void regFailure(int i2) {
    }

    public void regSuccess(int i2, Object obj) {
    }
}
