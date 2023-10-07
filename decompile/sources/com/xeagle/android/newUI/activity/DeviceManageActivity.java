package com.xeagle.android.newUI.activity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ci.a;
import com.blankj.utilcode.util.ClipboardUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.flypro.core.database.UserInfo;
import com.flypro.core.database.UserLiteHelper;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.login.beans.DeviceInServerBeans;
import com.xeagle.android.login.beans.DroneInfoInDevice;
import com.xeagle.android.login.retrofitLogin.RegContract;
import com.xeagle.android.login.retrofitLogin.RegPresenter;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import ja.j;
import java.util.ArrayList;
import java.util.HashMap;
import jb.d;
import kk.a;

public class DeviceManageActivity extends BaseActivity implements RegContract.lLoadView {

    /* renamed from: a  reason: collision with root package name */
    private SmartRefreshLayout f23840a;

    /* renamed from: b  reason: collision with root package name */
    private RecyclerView f23841b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public a f23842c;

    /* renamed from: d  reason: collision with root package name */
    private RegPresenter f23843d;

    private void a() {
        findViewById(R.id.tv_return).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                DeviceManageActivity.this.a(view);
            }
        });
        this.f23840a = (SmartRefreshLayout) findViewById(R.id.refreshLayout);
        this.f23841b = (RecyclerView) findViewById(R.id.list_device_manage);
        a aVar = new a(this, ((XEagleApp) getApplicationContext()).k(), R.layout.device_manage_item, new ArrayList());
        this.f23842c = aVar;
        this.f23841b.setAdapter(aVar);
        this.f23842c.setOnItemChildLongClickListener(new a.b() {
            public boolean a(ci.a aVar, View view, int i2) {
                if (view.getId() != R.id.active_drone_sn) {
                    return false;
                }
                ClipboardUtils.copyText(((DroneInfoInDevice) DeviceManageActivity.this.f23842c.getData().get(i2)).getSn());
                ToastUtils.showLong((int) R.string.copy_success);
                return false;
            }
        });
        this.f23843d = new RegPresenter(this);
        this.f23841b.setLayoutManager(new LinearLayoutManager(this, 1, false));
        b();
        this.f23840a.a((d) new d() {
            public final void onRefresh(j jVar) {
                DeviceManageActivity.this.a(jVar);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        finish();
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(j jVar) {
        b();
    }

    private void b() {
        UserInfo userInfo = UserLiteHelper.getUserInfo(this.prefs.aE());
        if (userInfo != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("token", userInfo.getToken());
            this.f23843d.getDeviceInServer(UserGlobal.BASE_URL, hashMap);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_device_manage);
        a();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        kk.a aVar = this.f23842c;
        if (aVar != null) {
            aVar.a();
        }
    }

    public void regError(int i2, String str) {
        Log.i("ServeTest", "regError: ====error===" + str + "==type==" + i2);
        if (i2 == 18) {
            this.f23840a.g(false);
        }
    }

    public void regFailure(int i2) {
        if (i2 == 18) {
            this.f23840a.g(false);
        }
    }

    public void regSuccess(int i2, Object obj) {
        if (i2 == 18) {
            DeviceInServerBeans deviceInServerBeans = (DeviceInServerBeans) obj;
            kk.a aVar = this.f23842c;
            if (aVar != null) {
                aVar.a();
                this.f23842c.replaceData(deviceInServerBeans.getData().getDrone());
                this.f23840a.g(true);
            }
        } else if (i2 == 24) {
            b();
        }
    }
}
