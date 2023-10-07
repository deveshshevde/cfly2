package com.xeagle.android.newUI.activity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.flypro.core.database.UserInfo;
import com.flypro.core.database.UserLiteHelper;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.dialogs.s;
import com.xeagle.android.login.HostManagerActivity;
import com.xeagle.android.login.beans.AvatarAcceptBeans;
import com.xeagle.android.login.beans.UploadAcceptBeans;
import com.xeagle.android.login.beans.UserInfoAcceptBeans;
import com.xeagle.android.login.common.CircleImageView;
import com.xeagle.android.login.common.ToastHelper;
import com.xeagle.android.login.pickImage.Constants;
import com.xeagle.android.login.pickImage.TakeIconActivity;
import com.xeagle.android.login.pickImage.data.GLImage;
import com.xeagle.android.login.retrofitLogin.RegContract;
import com.xeagle.android.login.retrofitLogin.RegPresenter;
import com.xeagle.android.login.retrofitLogin.UploadCallBack;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.utils.c;
import com.xeagle.android.utils.e;
import com.xeagle.android.utils.prefs.a;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import le.b;
import le.d;
import okhttp3.aa;
import okhttp3.v;
import okhttp3.w;
import org.litepal.crud.callback.SaveCallback;
import retrofit2.Call;
import retrofit2.Response;

public class PersonInfoActivity extends BaseActivity implements View.OnClickListener, RegContract.lLoadView {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public a f23891a;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public UserInfo f23892b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public RegPresenter f23893c;

    /* renamed from: d  reason: collision with root package name */
    private boolean f23894d = false;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f23895e;

    /* renamed from: f  reason: collision with root package name */
    private String f23896f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public String f23897g;

    /* renamed from: h  reason: collision with root package name */
    private TextView f23898h;

    /* renamed from: i  reason: collision with root package name */
    private RelativeLayout f23899i;

    /* renamed from: j  reason: collision with root package name */
    private RelativeLayout f23900j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public TextView f23901k;

    /* renamed from: l  reason: collision with root package name */
    private IButton f23902l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public CircleImageView f23903m;

    private aa a(String str) {
        return aa.create(v.b("text/plain"), str);
    }

    private w.b a(String str, String str2) {
        return w.b.a(str, str2);
    }

    private void a() {
        a j2 = ((XEagleApp) getApplication()).j();
        this.f23891a = j2;
        this.f23892b = UserLiteHelper.getUserInfo(j2.aE());
        this.f23893c = new RegPresenter(this);
        this.f23895e = (ProgressBar) findViewById(R.id.update_pb);
        this.f23898h = (TextView) findViewById(R.id.tv_back);
        this.f23899i = (RelativeLayout) findViewById(R.id.rl_avatar);
        this.f23900j = (RelativeLayout) findViewById(R.id.rl_name);
        this.f23901k = (TextView) findViewById(R.id.tv_name);
        this.f23902l = (IButton) findViewById(R.id.ib_save);
        this.f23903m = (CircleImageView) findViewById(R.id.ci_avatar);
        this.f23898h.setOnClickListener(this);
        this.f23902l.setOnClickListener(this);
        this.f23899i.setOnClickListener(this);
        this.f23900j.setOnClickListener(this);
        b();
    }

    private void a(Intent intent) {
        ArrayList arrayList;
        if (intent != null && (arrayList = (ArrayList) intent.getSerializableExtra(Constants.EXTRA_RESULT_ITEMS)) != null && !arrayList.isEmpty()) {
            GLImage gLImage = (GLImage) arrayList.get(0);
            this.f23896f = gLImage.getPath();
            b(gLImage.getPath());
        }
    }

    private void b() {
        this.f23901k.setText(this.f23892b.getUserName());
        if (this.f23892b.getIconPath() == null || this.f23892b.getIconPath().equals("-") || this.f23892b.getIconPath().equals("") || !new File(this.f23892b.getIconPath()).exists()) {
            this.f23903m.setImageDrawable(getDrawable(R.drawable.avatar_default));
        } else {
            this.f23903m.setImageBitmap(c.b(this.f23892b.getIconPath()));
        }
    }

    private void b(String str) {
        if (!TextUtils.isEmpty(str)) {
            new File(str);
            this.f23894d = true;
            final Bitmap b2 = c.b(str);
            runOnUiThread(new Runnable() {
                public void run() {
                    PersonInfoActivity.this.f23903m.setImageBitmap(b2);
                }
            });
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i2, int i3, Intent intent) {
        super.onActivityResult(i2, i3, intent);
        if (i2 == 1010 && i3 == -1) {
            a(intent);
        }
    }

    public void onBackPressed() {
        super.onBackPressed();
        finish();
        startActivity(new Intent(this, HostManagerActivity.class));
    }

    public void onClick(View view) {
        AlertDialog.Builder builder;
        switch (view.getId()) {
            case R.id.ib_save:
                if (this.f23894d) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("token", a(this.f23892b.getToken()));
                    if (!this.f23892b.getUserName().equals(this.f23901k.getText().toString())) {
                        hashMap.put("nickname", a(this.f23901k.getText().toString()));
                    }
                    this.f23895e.setVisibility(0);
                    this.f23893c.uploadAvatar(UserGlobal.BASE_URL, this.f23896f, hashMap, new UploadCallBack<AvatarAcceptBeans>() {
                        public void onFailure(Call<AvatarAcceptBeans> call, Throwable th) {
                            Log.i("Listener", "onFailure: ----avatar---" + th.getMessage());
                            PersonInfoActivity personInfoActivity = PersonInfoActivity.this;
                            ToastHelper.showToast((Context) personInfoActivity, personInfoActivity.getString(R.string.network_no_available));
                        }

                        public void onSuccess(Call<AvatarAcceptBeans> call, Response<AvatarAcceptBeans> response) {
                            AvatarAcceptBeans body = response.body();
                            d dVar = new d(UserGlobal.BASE_URL, new b() {
                                public void onFail(String str) {
                                    Log.i("Sochip", "onFail: ---save avar--" + str);
                                    ToastHelper.showToast((Context) PersonInfoActivity.this, PersonInfoActivity.this.getString(R.string.network_no_available));
                                }

                                public void onFinishDownload() {
                                    UserLiteHelper.updateUserIcon(PersonInfoActivity.this.f23891a.aE(), PersonInfoActivity.this.f23897g, new SaveCallback() {
                                        public void onFinish(boolean z2) {
                                            if (!PersonInfoActivity.this.f23892b.getUserName().equals(PersonInfoActivity.this.f23901k.getText().toString())) {
                                                UserLiteHelper.updateUserName(PersonInfoActivity.this.f23891a.aE(), PersonInfoActivity.this.f23901k.getText().toString(), new SaveCallback() {
                                                    public void onFinish(boolean z2) {
                                                        PersonInfoActivity.this.startActivity(new Intent(PersonInfoActivity.this, HostManagerActivity.class));
                                                        PersonInfoActivity.this.finish();
                                                    }
                                                });
                                                return;
                                            }
                                            PersonInfoActivity.this.f23895e.post(new Runnable() {
                                                public void run() {
                                                    PersonInfoActivity.this.f23895e.setVisibility(8);
                                                }
                                            });
                                            PersonInfoActivity.this.startActivity(new Intent(PersonInfoActivity.this, HostManagerActivity.class));
                                            PersonInfoActivity.this.finish();
                                        }
                                    });
                                }

                                public void onProgress(int i2) {
                                }

                                public void onStartDownload() {
                                }
                            });
                            PersonInfoActivity personInfoActivity = PersonInfoActivity.this;
                            String unused = personInfoActivity.f23897g = kx.d.k(PersonInfoActivity.this.getApplicationContext()) + com.flypro.core.util.d.a(body.getData().getAvatar());
                            dVar.a(body.getData().getAvatar(), PersonInfoActivity.this.f23903m, 120, 120, PersonInfoActivity.this.f23897g);
                        }
                    });
                    return;
                } else if (!this.f23892b.getUserName().equals(this.f23901k.getText().toString())) {
                    this.f23895e.setVisibility(0);
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(a("token", this.f23892b.getToken()));
                    arrayList.add(a("nickname", this.f23901k.getText().toString()));
                    this.f23893c.getUserInfoResult(UserGlobal.BASE_URL, arrayList, new UploadCallBack<UploadAcceptBeans>() {
                        public void onFailure(Call<UploadAcceptBeans> call, Throwable th) {
                            Log.i("Listener", "onFailure: ---" + th.getMessage());
                            ToastHelper.showToast((Context) PersonInfoActivity.this, th.getMessage());
                            PersonInfoActivity.this.f23895e.setVisibility(8);
                        }

                        public void onSuccess(Call<UploadAcceptBeans> call, Response<UploadAcceptBeans> response) {
                            PersonInfoActivity.this.f23893c.getUserInfo(UserGlobal.BASE_URL, PersonInfoActivity.this.f23892b.getToken());
                        }
                    });
                    return;
                } else {
                    return;
                }
            case R.id.rl_avatar:
                com.xeagle.android.utils.permission.a aVar = new com.xeagle.android.utils.permission.a(getApplicationContext());
                ArrayList arrayList2 = new ArrayList();
                arrayList2.add("android.permission.CAMERA");
                if (aVar.a((ArrayList<String>) arrayList2)) {
                    com.permissionx.guolindev.b.a(this).a(arrayList2).a().a((iw.b) new iw.b() {
                        public void onExplainReason(iy.c cVar, List<String> list, boolean z2) {
                            Log.i("newUI", "onExplainReason: ");
                            PersonInfoActivity personInfoActivity = PersonInfoActivity.this;
                            cVar.a(new s(personInfoActivity, R.style.dialog, personInfoActivity.getString(R.string.permission_title), PersonInfoActivity.this.getString(R.string.bt_allow), PersonInfoActivity.this.getString(R.string.bt_deny), list));
                        }
                    }).a((iw.c) new iw.c() {
                        public void onForwardToSettings(iy.d dVar, List<String> list) {
                            PersonInfoActivity personInfoActivity = PersonInfoActivity.this;
                            dVar.a(new s(personInfoActivity, R.style.dialog, personInfoActivity.getString(R.string.permission_forward_title), PersonInfoActivity.this.getString(R.string.bt_allow), PersonInfoActivity.this.getString(R.string.bt_deny), list));
                        }
                    }).a((iw.d) new iw.d() {
                        public void onResult(boolean z2, List<String> list, List<String> list2) {
                            if (z2) {
                                ToastUtils.showLong((CharSequence) PersonInfoActivity.this.getString(R.string.permission_all_allow));
                                PersonInfoActivity.this.startActivityForResult(new Intent(PersonInfoActivity.this, TakeIconActivity.class), Constants.RESULT_CODE_GET_IMAGE);
                            }
                        }
                    });
                    return;
                } else {
                    startActivityForResult(new Intent(this, TakeIconActivity.class), Constants.RESULT_CODE_GET_IMAGE);
                    return;
                }
            case R.id.rl_name:
                try {
                    builder = new AlertDialog.Builder(this, R.style.dialog);
                } catch (Exception unused) {
                    Log.e("TEST", "Older SDK, using old Builder");
                    builder = new AlertDialog.Builder(this);
                }
                View inflate = View.inflate(this, R.layout.editor_common_dialog, (ViewGroup) null);
                builder.setView(inflate);
                final AlertDialog create = builder.create();
                final EditText editText = (EditText) inflate.findViewById(R.id.editor_set);
                editText.setSingleLine();
                editText.setText(this.f23901k.getText());
                editText.setHint("");
                editText.setTextColor(-1);
                ((TextView) inflate.findViewById(R.id.notify_title)).setText(getString(R.string.change_nick_name));
                TextView textView = (TextView) inflate.findViewById(R.id.editor_warn);
                textView.setText(getString(R.string.no_special_symbols));
                textView.setVisibility(8);
                ((IButton) inflate.findViewById(R.id.ib_cancel)).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        create.dismiss();
                    }
                });
                ((IButton) inflate.findViewById(R.id.ib_ok)).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        String obj = editText.getText().toString();
                        String charSequence = editText.getHint().toString();
                        if (editText.getText().toString().equals("")) {
                            PersonInfoActivity personInfoActivity = PersonInfoActivity.this;
                            Toast.makeText(personInfoActivity, personInfoActivity.getString(R.string.set_limit_value), 0).show();
                            obj = charSequence;
                        }
                        PersonInfoActivity.this.f23901k.setText(obj);
                        create.dismiss();
                    }
                });
                create.show();
                Window window = create.getWindow();
                WindowManager.LayoutParams attributes = window.getAttributes();
                int b2 = e.b(this);
                int a2 = e.a((Context) this);
                double d2 = (double) b2;
                Double.isNaN(d2);
                attributes.height = (int) (d2 * 0.4d);
                double d3 = (double) a2;
                Double.isNaN(d3);
                attributes.width = (int) (d3 * 0.8d);
                window.setAttributes(attributes);
                return;
            case R.id.tv_back:
                finish();
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.newui_activity_person_info);
        a();
    }

    public void regError(int i2, String str) {
        Log.i("Listener", "regError: ---修改---" + str + "...type..." + i2);
    }

    public void regFailure(int i2) {
    }

    public void regSuccess(int i2, Object obj) {
        if (i2 == 9) {
            UserInfoAcceptBeans userInfoAcceptBeans = (UserInfoAcceptBeans) obj;
            if (!this.f23892b.getUserName().equals(userInfoAcceptBeans.getData().getNickname())) {
                UserLiteHelper.updateUserName(this.f23891a.aE(), userInfoAcceptBeans.getData().getNickname(), new SaveCallback() {
                    public void onFinish(boolean z2) {
                        PersonInfoActivity.this.f23895e.post(new Runnable() {
                            public void run() {
                                PersonInfoActivity.this.f23895e.setVisibility(8);
                                ToastHelper.showToast((Context) PersonInfoActivity.this, PersonInfoActivity.this.getString(R.string.modify_success));
                                PersonInfoActivity.this.startActivity(new Intent(PersonInfoActivity.this, HostManagerActivity.class));
                                PersonInfoActivity.this.finish();
                            }
                        });
                    }
                });
            }
        }
    }
}
