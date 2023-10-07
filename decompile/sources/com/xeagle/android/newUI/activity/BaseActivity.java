package com.xeagle.android.newUI.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import androidx.appcompat.app.AppCompatActivity;
import com.blankj.utilcode.util.RomUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.flypro.core.MAVLink.q;
import com.flypro.core.database.BatteryInfoData;
import com.flypro.core.database.DroneInfoData;
import com.flypro.core.database.UserInfo;
import com.flypro.core.database.UserLiteHelper;
import com.flypro.core.util.e;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.dialogs.c;
import com.xeagle.android.dialogs.r;
import com.xeagle.android.login.HostManagerActivity;
import com.xeagle.android.login.beans.BatteryInServerBeans;
import com.xeagle.android.login.beans.DroneInServerBeans;
import com.xeagle.android.login.beans.UploadAcceptBeans;
import com.xeagle.android.login.retrofitLogin.RegContract;
import com.xeagle.android.login.retrofitLogin.RegPresenter;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.login.retrofitLogin.sochip.SochipPresenter;
import com.xeagle.android.newUI.cameraManager.AmbaClient;
import com.xeagle.android.newUI.fragment.remindFragment.InsuranceActivity;
import com.xeagle.android.newUI.fragment.remindFragment.a;
import com.xeagle.android.utils.g;
import com.xeagle.android.utils.h;
import com.xeagle.android.utils.n;
import com.xeagle.android.utils.y;
import dy.ab;
import dy.ad;
import en.a;
import io.reactivex.f;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import lv.d;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;
import org.litepal.crud.callback.FindMultiCallback;

public class BaseActivity extends AppCompatActivity implements RegContract.lLoadView {
    private static final int BATTERY_FLAG = 2;
    private static final int DRONE_FLAG = 1;
    protected int camera_type;
    /* access modifiers changed from: private */
    public int deviceFlag = 1;
    public a drone;
    protected String droneSn;
    /* access modifiers changed from: private */
    public e function;
    private long getBatteryTime = 0;
    /* access modifiers changed from: private */
    public boolean isActived = false;
    private boolean isGetDroneActivated = false;
    private boolean isHasBattery = false;
    public com.xeagle.android.utils.prefs.a prefs;
    protected SochipPresenter presenter;
    protected RegPresenter regPresenter;
    protected AmbaClient remoteCam;
    private int usbDetachTime = 5;
    public XEagleApp xEagleApp;

    private void finishHomeActivity() {
        if (getClass() != HostManagerActivity.class) {
            Log.i("LOOK_LOG", "usbConnectStateEvent: 回到首页");
            finish();
            startActivity(new Intent(this, HostManagerActivity.class));
        }
    }

    private void setBatteryActivatedTime(String str) {
        int parseInt = Integer.parseInt(str.substring(0, 4));
        String substring = str.substring(5, 7);
        if (substring.startsWith("0")) {
            substring = substring.substring(1);
        }
        int parseInt2 = Integer.parseInt(substring);
        String substring2 = str.substring(8, 10);
        if (substring2.startsWith("0")) {
            substring2 = substring2.substring(1);
        }
        int parseInt3 = Integer.parseInt(substring2);
        this.isHasBattery = false;
        q.a(this.drone, ei.a.a(parseInt, parseInt2, parseInt3));
        f.a(2, TimeUnit.SECONDS).a(new d(parseInt, parseInt2, parseInt3) {
            public final /* synthetic */ int f$1;
            public final /* synthetic */ int f$2;
            public final /* synthetic */ int f$3;

            {
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void accept(Object obj) {
                BaseActivity.this.lambda$setBatteryActivatedTime$0$BaseActivity(this.f$1, this.f$2, this.f$3, (Long) obj);
            }
        });
    }

    private void setDroneActivatedTime(String str) {
        try {
            int parseInt = Integer.parseInt(str.substring(0, 4));
            String substring = str.substring(5, 7);
            if (substring.startsWith("0")) {
                substring = substring.substring(1);
            }
            int parseInt2 = Integer.parseInt(substring);
            String substring2 = str.substring(8, 10);
            if (substring2.startsWith("0")) {
                substring2 = substring2.substring(1);
            }
            q.b(this.drone, ei.a.a(parseInt, parseInt2, Integer.parseInt(substring2)));
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
        }
    }

    private void showActiveDlg() {
        com.xeagle.android.newUI.fragment.remindFragment.a a2 = r.a().a(new a.C0150a() {
            public void a() {
                UserInfo userInfo = UserLiteHelper.getUserInfo(BaseActivity.this.prefs.aE());
                if (userInfo != null) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("token", userInfo.getToken());
                    hashMap.put("sn", BaseActivity.this.drone.S().c());
                    hashMap.put("uid", userInfo.getUid());
                    hashMap.put("model", "DF" + BaseActivity.this.prefs.j());
                    String a2 = y.a(System.currentTimeMillis());
                    if (BaseActivity.this.drone.S().d() != null) {
                        Log.e("ServeTest", "regSuccess:=====dev type======= " + BaseActivity.this.drone.S().d());
                        return;
                    }
                    Log.i("ServeTest", "regSuccess:====date=== " + a2);
                    hashMap.put("actived_at", a2);
                    BaseActivity.this.regPresenter.activeDevice(UserGlobal.BASE_URL, hashMap);
                }
            }

            public void b() {
                c a2 = r.a().a(BaseActivity.this.getString(R.string.warning), BaseActivity.this.getString(R.string.no_active_warn), (c.a) new c.a() {
                    public void onYes() {
                    }
                });
                if (!a2.isAdded()) {
                    a2.show(BaseActivity.this.getSupportFragmentManager(), "noActiveDrone");
                }
            }
        });
        if (!a2.isAdded()) {
            a2.show(getSupportFragmentManager(), "activeDrone");
        }
    }

    public void disDialog() {
        n.a(this);
        n.b(this);
    }

    @l(a = ThreadMode.BACKGROUND)
    public void droneFirmwareEvent(ab abVar) {
        if (this.drone.y() != null) {
            String y2 = this.drone.y();
            if (!y2.contains(this.prefs.j())) {
                this.prefs.d(y2.substring(y2.indexOf("DF") + 2, y2.indexOf("-v")));
            }
        } else {
            this.prefs.d(UserGlobal.DRONE_NAME_DF808);
        }
        if (h.c(this.prefs, this.drone) && !this.xEagleApp.m().k()) {
            q.b(this.drone);
            this.xEagleApp.m().j(true);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void droneWarnning(ad adVar) {
        if (this.drone.d().f().equalsIgnoreCase(getString(R.string.set_drone_time_detail))) {
            this.isGetDroneActivated = true;
            q.b(this.drone);
        } else if (this.drone.d().f().equalsIgnoreCase(getString(R.string.set_battery_time_detail))) {
            this.isHasBattery = true;
            q.a(this.drone);
        }
    }

    public /* synthetic */ void lambda$setBatteryActivatedTime$0$BaseActivity(int i2, int i3, int i4, Long l2) throws Exception {
        if (!this.isHasBattery) {
            q.a(this.drone, ei.a.a(i2, i3, i4));
        }
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.i("newUI", "onCreate:---sdk-- " + Build.VERSION.SDK_INT);
        if (Build.VERSION.SDK_INT >= 28) {
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            attributes.layoutInDisplayCutoutMode = 2;
            getWindow().setAttributes(attributes);
        } else if (RomUtils.isHuawei() && com.xeagle.android.utils.c.e((Context) this)) {
            com.xeagle.android.utils.c.a(getWindow());
        } else if (RomUtils.isXiaomi() && com.xeagle.android.utils.c.f((Context) this)) {
            com.xeagle.android.utils.c.b(getWindow());
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        getWindow().addFlags(128);
        this.drone = ((XEagleApp) getApplication().getApplicationContext()).k();
        this.prefs = ((XEagleApp) getApplicationContext()).j();
        this.xEagleApp = (XEagleApp) getApplicationContext();
        this.regPresenter = new RegPresenter(this);
        this.function = new e(getApplicationContext());
        int a2 = this.xEagleApp.m().a();
        this.camera_type = a2;
        if (a2 == 1) {
            this.remoteCam = this.xEagleApp.g();
        } else if (a2 == 2) {
            this.presenter = this.xEagleApp.h();
        }
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
    }

    public void regError(int i2, String str) {
        if (i2 == 19) {
            if (this.deviceFlag == 1) {
                this.deviceFlag = 2;
                q.a(this.drone);
            }
        } else if (i2 == 24) {
            Log.i("ServeTest", "regError: =====" + str);
            ToastUtils.showLong((int) R.string.insurance_fail);
        }
    }

    public void regFailure(int i2) {
        if (i2 != 19) {
            return;
        }
        if (this.deviceFlag == 1) {
            this.deviceFlag = 2;
            q.a(this.drone);
        } else if (i2 == 24) {
            Log.i("ServeTest", "regFailure:------- ");
        }
    }

    public void regSuccess(int i2, Object obj) {
        UserInfo userInfo;
        String str;
        int i3;
        if (i2 == 20) {
            if (((UploadAcceptBeans) obj).isStatus()) {
                UserInfo userInfo2 = UserLiteHelper.getUserInfo(this.prefs.aE());
                HashMap hashMap = new HashMap();
                hashMap.put("token", userInfo2.getToken());
                hashMap.put("sn", this.drone.S().c());
                this.regPresenter.getDroneInServer(UserGlobal.BASE_URL, hashMap);
                return;
            }
            i3 = R.string.drone_active_fail;
        } else if (i2 == 25) {
            if (((UploadAcceptBeans) obj).isStatus()) {
                UserInfo userInfo3 = UserLiteHelper.getUserInfo(this.prefs.aE());
                if (userInfo3 == null) {
                    Log.e("msg", "onFinish: =====user info is null");
                    return;
                }
                HashMap hashMap2 = new HashMap();
                hashMap2.put("token", userInfo3.getToken());
                hashMap2.put("sn", this.drone.T().c());
                this.regPresenter.getBatteryInServer(UserGlobal.BASE_URL, hashMap2);
                return;
            }
            i3 = R.string.battery_active_fail;
        } else if (i2 == 19) {
            Log.i("ServeTest", "regSuccess: ====drone========");
            DroneInServerBeans droneInServerBeans = (DroneInServerBeans) obj;
            if (droneInServerBeans.getData() == null || droneInServerBeans.getData().getSn() == null || droneInServerBeans.getData().getActivated() != 1 || droneInServerBeans.getData().getActivated_at() == null) {
                if (this.deviceFlag == 1 && !this.isActived) {
                    Log.i("ServeTest", "regSuccess:======drone is not actived......... ");
                    showActiveDlg();
                }
                if (this.drone.y() != null) {
                    this.xEagleApp.m().c(this.prefs.j());
                }
            } else {
                int i4 = this.deviceFlag;
                if (i4 != 1 || !this.isActived) {
                    if (i4 == 1 && !this.isActived) {
                        str = droneInServerBeans.getData().getActivated_at();
                    }
                    String model = droneInServerBeans.getData().getModel();
                    this.xEagleApp.m().c(model.substring(model.indexOf("DF") + 2));
                } else {
                    str = droneInServerBeans.getData().getActivated_at();
                    if (str.substring(0, 10).replace("-", "").equalsIgnoreCase(this.drone.S().a())) {
                        long a2 = y.a(str);
                        Log.i("ServeTest", "regSuccess:=====activeTime===== " + (System.currentTimeMillis() - a2) + "=======" + a2);
                        if (System.currentTimeMillis() - a2 <= 180000 && com.xeagle.android.utils.c.b(getApplicationContext())) {
                            Intent intent = new Intent(this, InsuranceActivity.class);
                            intent.putExtra("droneSn", this.droneSn);
                            startActivity(intent);
                        }
                        this.deviceFlag = 2;
                        q.a(this.drone);
                        String model2 = droneInServerBeans.getData().getModel();
                        this.xEagleApp.m().c(model2.substring(model2.indexOf("DF") + 2));
                    }
                }
                setDroneActivatedTime(str);
                String model22 = droneInServerBeans.getData().getModel();
                this.xEagleApp.m().c(model22.substring(model22.indexOf("DF") + 2));
            }
            if (!kz.a.e().f13916b) {
                kz.a.e().j();
                return;
            }
            return;
        } else if (i2 == 26) {
            Log.i("ServeTest", "regSuccess:===battert======= ");
            BatteryInServerBeans batteryInServerBeans = (BatteryInServerBeans) obj;
            Log.i("ServeTest", "regSuccess: =====" + batteryInServerBeans.toString());
            if (batteryInServerBeans.getData() == null || batteryInServerBeans.getData().getSn() == null || batteryInServerBeans.getData().getActivated() != 1 || batteryInServerBeans.getData().getActivated_at() == null) {
                if (this.deviceFlag == 2 && !this.isActived && (userInfo = UserLiteHelper.getUserInfo(this.prefs.aE())) != null) {
                    HashMap hashMap3 = new HashMap();
                    hashMap3.put("token", userInfo.getToken());
                    hashMap3.put("sn", this.drone.T().c());
                    String str2 = this.droneSn;
                    if (str2 != null) {
                        hashMap3.put("drone_sn", str2);
                    }
                    hashMap3.put("uid", userInfo.getUid());
                    if (g.a(this.drone.T().d())) {
                        hashMap3.put("model", this.drone.T().d());
                        String a3 = y.a(System.currentTimeMillis());
                        Log.i("ServeTest", "regSuccess:====date=== " + a3);
                        hashMap3.put("actived_at", a3);
                        this.regPresenter.activeBattery(UserGlobal.BASE_URL, hashMap3);
                        return;
                    }
                    return;
                }
                return;
            } else if (this.deviceFlag != 2 || this.isActived) {
                String activated_at = batteryInServerBeans.getData().getActivated_at();
                if (!activated_at.substring(0, 10).replace("-", "").equalsIgnoreCase(this.drone.T().a())) {
                    setBatteryActivatedTime(activated_at);
                    return;
                }
                return;
            } else {
                try {
                    setBatteryActivatedTime(batteryInServerBeans.getData().getActivated_at());
                    return;
                } catch (NumberFormatException e2) {
                    e2.printStackTrace();
                    return;
                }
            }
        } else if (i2 == 24) {
            UploadAcceptBeans uploadAcceptBeans = (UploadAcceptBeans) obj;
            if (uploadAcceptBeans.isStatus()) {
                ToastUtils.showLong((CharSequence) getString(R.string.bound_insurance_success));
            } else {
                if (uploadAcceptBeans.getCode() == 400) {
                    ToastUtils.showShort((CharSequence) getString(R.string.insurance_pwd_error));
                } else {
                    uploadAcceptBeans.getCode();
                }
                try {
                    int parseInt = Integer.parseInt(uploadAcceptBeans.getMessage());
                    ToastUtils.showLong((CharSequence) String.format(Locale.US, "%s%d", new Object[]{getString(R.string.insurance_pwd_remain_warn), Integer.valueOf(parseInt)}));
                } catch (NumberFormatException e3) {
                    e3.printStackTrace();
                }
            }
            Log.i("ServeTest", "regSuccess: ====" + uploadAcceptBeans.toString());
            return;
        } else {
            return;
        }
        ToastUtils.showLong(i3);
    }

    public void showDialog(String str) {
        n.a(this, str);
    }

    public void showDialog(String str, View.OnClickListener onClickListener) {
        n.a((AppCompatActivity) this, str, onClickListener);
    }

    @l(a = ThreadMode.MAIN)
    public void updateInfo(com.flypro.core.drone.f fVar) {
        ThreadPoolExecutor threadPoolExecutor;
        Runnable runnable;
        if (fVar.a().equalsIgnoreCase("drone")) {
            int parseInt = Integer.parseInt(this.drone.S().a().substring(0, 4));
            this.droneSn = this.drone.S().c();
            this.xEagleApp.n().a(this.droneSn);
            Log.i("msg", "updateInfo:---- " + parseInt);
            if (parseInt > 2100 || parseInt < 2021) {
                this.deviceFlag = 1;
                this.isActived = false;
                if (this.function.a(getApplicationContext())) {
                    UserInfo userInfo = UserLiteHelper.getUserInfo(this.prefs.aE());
                    HashMap hashMap = new HashMap();
                    hashMap.put("token", userInfo.getToken());
                    hashMap.put("sn", this.drone.S().c());
                    this.regPresenter.getDroneInServer(UserGlobal.BASE_URL, hashMap);
                    return;
                } else if (this.drone.d().c() || this.drone.d().d()) {
                    return;
                }
            } else {
                threadPoolExecutor = ka.a.a().b();
                runnable = new Runnable() {
                    public void run() {
                        UserLiteHelper.requestDroneInfo(new FindMultiCallback<DroneInfoData>() {
                            public void onFinish(List<DroneInfoData> list) {
                                if (list == null || list.size() <= 0) {
                                    UserLiteHelper.saveDroneInfo(BaseActivity.this.drone.S().c(), BaseActivity.this.drone.S().a(), "-", "-");
                                } else {
                                    new DroneInfoData(BaseActivity.this.drone.S().c(), BaseActivity.this.drone.S().a(), "-", "-").saveOrUpdate("id=?", "1");
                                }
                                boolean unused = BaseActivity.this.isActived = true;
                                int unused2 = BaseActivity.this.deviceFlag = 1;
                                if (BaseActivity.this.function.a(BaseActivity.this.getApplicationContext())) {
                                    UserInfo userInfo = UserLiteHelper.getUserInfo(BaseActivity.this.prefs.aE());
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("token", userInfo.getToken());
                                    hashMap.put("sn", BaseActivity.this.drone.S().c());
                                    BaseActivity.this.regPresenter.getDroneInServer(UserGlobal.BASE_URL, hashMap);
                                }
                            }
                        });
                    }
                };
                threadPoolExecutor.execute(runnable);
                return;
            }
        } else if (fVar.a().equalsIgnoreCase("battery")) {
            this.deviceFlag = 2;
            int parseInt2 = Integer.parseInt(this.drone.T().a().substring(0, 4));
            Log.i("msg", "updateInfo:--bat-- " + parseInt2);
            if (parseInt2 > 2100 || parseInt2 < 2021) {
                this.isActived = false;
                UserInfo userInfo2 = UserLiteHelper.getUserInfo(this.prefs.aE());
                if (userInfo2 == null) {
                    Log.e("msg", "updateInfo: ====user info is null");
                    return;
                } else if (this.function.a(getApplicationContext())) {
                    HashMap hashMap2 = new HashMap();
                    hashMap2.put("token", userInfo2.getToken());
                    hashMap2.put("sn", this.drone.T().c());
                    this.regPresenter.getBatteryInServer(UserGlobal.BASE_URL, hashMap2);
                    return;
                } else if (this.drone.d().c() || this.drone.d().d()) {
                    return;
                }
            } else {
                threadPoolExecutor = ka.a.a().b();
                runnable = new Runnable() {
                    public void run() {
                        UserLiteHelper.requestBatteryInfo(new FindMultiCallback<BatteryInfoData>() {
                            public void onFinish(List<BatteryInfoData> list) {
                                if (list == null || list.size() <= 0) {
                                    UserLiteHelper.saveBatteryInfo(BaseActivity.this.drone.T().c(), BaseActivity.this.drone.T().a(), BaseActivity.this.drone.T().b(), BaseActivity.this.drone.T().d());
                                } else {
                                    new BatteryInfoData(BaseActivity.this.drone.T().c(), BaseActivity.this.drone.T().a(), BaseActivity.this.drone.T().b(), BaseActivity.this.drone.T().d()).saveOrUpdate("id=?", "1");
                                }
                                boolean unused = BaseActivity.this.isActived = true;
                                int unused2 = BaseActivity.this.deviceFlag = 2;
                                if (BaseActivity.this.function.a(BaseActivity.this.getApplicationContext())) {
                                    UserInfo userInfo = UserLiteHelper.getUserInfo(BaseActivity.this.prefs.aE());
                                    if (userInfo == null) {
                                        Log.e("msg", "onFinish: =====user info is null");
                                        return;
                                    }
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("token", userInfo.getToken());
                                    hashMap.put("sn", BaseActivity.this.drone.T().c());
                                    BaseActivity.this.regPresenter.getBatteryInServer(UserGlobal.BASE_URL, hashMap);
                                }
                            }
                        });
                    }
                };
                threadPoolExecutor.execute(runnable);
                return;
            }
        } else {
            return;
        }
        ToastUtils.showLong((int) R.string.active_device_no_network);
    }

    @l(a = ThreadMode.MAIN)
    public void usbConnectStateEvent(ha.e eVar) {
        if (eVar.a() == 2 && !eVar.b() && !this.function.c()) {
            finishHomeActivity();
        }
    }
}
