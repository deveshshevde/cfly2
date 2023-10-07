package com.xeagle.android.login;

import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.ServiceConnection;
import android.content.res.Resources;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.t;
import com.blankj.utilcode.util.ScreenUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.flypro.core.database.FirmwareInfoData;
import com.flypro.core.database.UserLiteHelper;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.dialogs.c;
import com.xeagle.android.dialogs.d;
import com.xeagle.android.dialogs.i;
import com.xeagle.android.dialogs.r;
import com.xeagle.android.fragments.ParamsFragment;
import com.xeagle.android.login.HostManagerActivity;
import com.xeagle.android.login.beans.sochipBeans.SochipVersionBean;
import com.xeagle.android.login.common.service.UdpDataService;
import com.xeagle.android.login.fragment.AcademyFragment;
import com.xeagle.android.login.fragment.DeviceFragment;
import com.xeagle.android.login.fragment.MineFragment;
import com.xeagle.android.login.listener.UploadListenerService;
import com.xeagle.android.login.retrofitLogin.CameraGlobal;
import com.xeagle.android.newUI.activity.BaseActivity;
import com.xeagle.android.newUI.activity.TipsConnectActivity;
import com.xeagle.android.newUI.beans.ModuleBean;
import com.xeagle.android.newUI.widgets.NoScrollViewPager;
import com.xeagle.android.utils.prefs.a;
import ha.e;
import ha.h;
import io.reactivex.disposables.b;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import jo.aj;
import jo.ao;
import jo.aw;
import jo.ax;
import jp.g;
import l.f;
import net.lucode.hackware.magicindicator.MagicIndicator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.CommonNavigator;
import net.lucode.hackware.magicindicator.buildins.commonnavigator.titles.CommonPagerTitleView;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.l;
import org.litepal.crud.callback.FindMultiCallback;

public class HostManagerActivity extends BaseActivity {
    private static final int REFUSE_TIME = 172800000;
    private static final int REQUEST_CODE = 0;
    private int camera_type;
    private int change_fps = -1;
    private d connectTipsDlg;
    ServiceConnection connection = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            UdpDataService unused = HostManagerActivity.this.udpService = ((UdpDataService.UdpBinder) iBinder).getService();
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    };
    private b disposable;
    private long firstTime;
    /* access modifiers changed from: private */
    public FirmwareInfoData fwData;
    private String hardware;
    private boolean hasSession;
    private boolean isBind = false;
    private boolean isGetSwVersion = false;
    public boolean isHasSdcard;
    private boolean isReUpload;
    /* access modifiers changed from: private */
    public boolean isSendSessionInfo = false;
    private ProgressDialog mProgressDialog;
    /* access modifiers changed from: private */
    public List<ModuleBean> moduleBeanList = new ArrayList();
    private ParamsFragment paramsFragment;
    /* access modifiers changed from: private */
    public a prefs;
    public int secFps = 30;
    public int secHeight = 1080;
    public int secWidth = 1920;
    private int sessionCount = 0;
    /* access modifiers changed from: private */
    public UdpDataService udpService;
    private c updateWarnDlg;
    private i upgradeDlg;
    /* access modifiers changed from: private */
    public NoScrollViewPager vpr;
    private c wifiBindDlg;
    /* access modifiers changed from: private */
    public XEagleApp xEagleApp;

    private void checkLoc() {
        XEagleApp xEagleApp2;
        LocationManager locationManager = (LocationManager) getSystemService("location");
        if (locationManager != null && !locationManager.isProviderEnabled("gps") && System.currentTimeMillis() - this.prefs.aK() >= 172800000 && (xEagleApp2 = this.xEagleApp) != null && xEagleApp2.m().e()) {
            this.xEagleApp.m().f(false);
            new AlertDialog.Builder(this).setTitle(R.string.warning).setMessage(R.string.gps_message).setCancelable(false).setPositiveButton(R.string.settings, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    dialogInterface.dismiss();
                    HostManagerActivity.this.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
                }
            }).setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                public void onClick(DialogInterface dialogInterface, int i2) {
                    HostManagerActivity.this.prefs.a(System.currentTimeMillis());
                    dialogInterface.dismiss();
                    Toast.makeText(HostManagerActivity.this, R.string.gps_close, 0).show();
                }
            }).show();
        }
    }

    private void dismissDialog() {
        ProgressDialog progressDialog = this.mProgressDialog;
        if (progressDialog != null) {
            progressDialog.dismiss();
        }
    }

    private float getSmallestWidth() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int screenHeight = ScreenUtils.getScreenHeight();
        int screenWidth = ScreenUtils.getScreenWidth();
        float f2 = displayMetrics.density;
        float f3 = ((float) screenHeight) / f2;
        float f4 = ((float) screenWidth) / f2;
        return f4 < f3 ? f4 : f3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0088, code lost:
        android.util.Log.i("Error", r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x008f, code lost:
        android.util.Log.i("CmdChannel", r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void handleCmdChannelError(int r4, java.lang.Object r5) {
        /*
            r3 = this;
            r0 = 137(0x89, float:1.92E-43)
            r1 = 0
            if (r4 == r0) goto L_0x00cd
            java.lang.String r0 = "Error"
            java.lang.String r2 = "CmdChannel"
            switch(r4) {
                case 128: goto L_0x0094;
                case 129: goto L_0x008d;
                case 130: goto L_0x0086;
                default: goto L_0x000c;
            }
        L_0x000c:
            switch(r4) {
                case 132: goto L_0x0083;
                case 133: goto L_0x0080;
                case 134: goto L_0x007d;
                default: goto L_0x000f;
            }
        L_0x000f:
            switch(r4) {
                case 515: goto L_0x005b;
                case 516: goto L_0x004e;
                case 517: goto L_0x0014;
                default: goto L_0x0012;
            }
        L_0x0012:
            goto L_0x0127
        L_0x0014:
            r3.dismissDialog()
            com.xeagle.android.XEagleApp r4 = r3.xEagleApp
            com.xeagle.android.newUI.cameraManager.AmbaClient r4 = r4.g()
            if (r4 == 0) goto L_0x0028
            com.xeagle.android.XEagleApp r4 = r3.xEagleApp
            com.xeagle.android.newUI.cameraManager.AmbaClient r4 = r4.g()
            r4.i()
        L_0x0028:
            com.xeagle.android.dialogs.r r4 = com.xeagle.android.dialogs.r.a()
            r5 = 2131821035(0x7f1101eb, float:1.9274802E38)
            java.lang.String r5 = r3.getString(r5)
            r0 = 2131823060(0x7f1109d4, float:1.927891E38)
            java.lang.String r0 = r3.getString(r0)
            com.xeagle.android.login.HostManagerActivity$14 r1 = new com.xeagle.android.login.HostManagerActivity$14
            r1.<init>()
            com.xeagle.android.dialogs.c r4 = r4.a((java.lang.String) r5, (java.lang.String) r0, (com.xeagle.android.dialogs.c.a) r1)
            androidx.fragment.app.FragmentManager r5 = r3.getSupportFragmentManager()
            java.lang.String r0 = "upgrade"
        L_0x0049:
            r4.show(r5, r0)
            goto L_0x0127
        L_0x004e:
            java.lang.Integer r5 = (java.lang.Integer) r5
            int r4 = r5.intValue()
            android.app.ProgressDialog r5 = r3.mProgressDialog
            r5.setProgress(r4)
            goto L_0x0127
        L_0x005b:
            java.lang.String r5 = (java.lang.String) r5
            java.io.File r4 = new java.io.File
            r4.<init>(r5)
            long r0 = r4.length()
            int r4 = (int) r0
            r0 = 2131821504(0x7f1103c0, float:1.9275753E38)
            java.lang.String r0 = r3.getString(r0)
            com.xeagle.android.login.HostManagerActivity$12 r1 = new com.xeagle.android.login.HostManagerActivity$12
            r1.<init>(r5)
            r3.showProgressDialog(r0, r1)
            android.app.ProgressDialog r5 = r3.mProgressDialog
            r5.setMax(r4)
            goto L_0x0127
        L_0x007d:
            java.lang.String r4 = "Cannot connect to the Camera. \nPlease make sure the selected camera is on. \nIf problem persists, please reboot both camera and this device."
            goto L_0x0088
        L_0x0080:
            java.lang.String r4 = "Cannot wakeup the Remote Camera"
            goto L_0x0088
        L_0x0083:
            java.lang.String r4 = "Lost connection with Remote Camera!"
            goto L_0x008f
        L_0x0086:
            java.lang.String r4 = "Invalid bluetooth device"
        L_0x0088:
            android.util.Log.i(r0, r4)
            goto L_0x0127
        L_0x008d:
            java.lang.String r4 = "Invalid Session! Please start session first!"
        L_0x008f:
            android.util.Log.i(r2, r4)
            goto L_0x0127
        L_0x0094:
            java.lang.String r4 = "Timeout! No response from Remote Camera!---"
            android.util.Log.i(r2, r4)
            java.lang.String r5 = (java.lang.String) r5
            java.lang.String r4 = "\"msg_id\":4"
            boolean r4 = r5.contains(r4)
            if (r4 == 0) goto L_0x00a5
            goto L_0x0127
        L_0x00a5:
            java.lang.String r4 = "\"msg_id\":257"
            boolean r4 = r5.contains(r4)
            if (r4 == 0) goto L_0x0127
            int r4 = r3.sessionCount
            r5 = 5
            if (r4 > r5) goto L_0x00ca
            com.xeagle.android.XEagleApp r4 = r3.xEagleApp
            com.xeagle.android.newUI.cameraManager.AmbaClient r4 = r4.g()
            if (r4 == 0) goto L_0x0127
            com.xeagle.android.XEagleApp r4 = r3.xEagleApp
            com.xeagle.android.newUI.cameraManager.AmbaClient r4 = r4.g()
            r4.e()
            int r4 = r3.sessionCount
            int r4 = r4 + 1
            r3.sessionCount = r4
            goto L_0x0127
        L_0x00ca:
            r3.sessionCount = r1
            goto L_0x0127
        L_0x00cd:
            java.lang.String r4 = "LOOK_LOG"
            java.lang.String r5 = "START_SESSION失败"
            android.util.Log.i(r4, r5)
            com.xeagle.android.XEagleApp r4 = r3.xEagleApp
            boolean r4 = r4.c()
            if (r4 == 0) goto L_0x00dd
            return
        L_0x00dd:
            r3.sessionCount = r1
            android.content.Context r4 = r3.getApplicationContext()
            com.xeagle.android.XEagleApp r4 = (com.xeagle.android.XEagleApp) r4
            en.a r4 = r4.k()
            com.xeagle.android.utils.c.a((en.a) r4)
            com.xeagle.android.dialogs.c r4 = r3.wifiBindDlg
            r5 = 2131821020(0x7f1101dc, float:1.9274771E38)
            if (r4 != 0) goto L_0x010e
            com.xeagle.android.dialogs.r r4 = com.xeagle.android.dialogs.r.a()
            r0 = 2131823185(0x7f110a51, float:1.9279163E38)
            java.lang.String r0 = r3.getString(r0)
            java.lang.String r5 = r3.getString(r5)
            com.xeagle.android.login.HostManagerActivity$13 r1 = new com.xeagle.android.login.HostManagerActivity$13
            r1.<init>()
            com.xeagle.android.dialogs.c r4 = r4.a((java.lang.String) r0, (java.lang.String) r5, (com.xeagle.android.dialogs.c.a) r1)
            r3.wifiBindDlg = r4
            goto L_0x0115
        L_0x010e:
            java.lang.String r5 = r3.getString(r5)
            r4.b((java.lang.String) r5)
        L_0x0115:
            com.xeagle.android.dialogs.c r4 = r3.wifiBindDlg
            boolean r4 = r4.isAdded()
            if (r4 != 0) goto L_0x0127
            com.xeagle.android.dialogs.c r4 = r3.wifiBindDlg
            androidx.fragment.app.FragmentManager r5 = r3.getSupportFragmentManager()
            java.lang.String r0 = "bindWifi"
            goto L_0x0049
        L_0x0127:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.HostManagerActivity.handleCmdChannelError(int, java.lang.Object):void");
    }

    private void initView() {
        this.hasSession = false;
        ModuleBean moduleBean = new ModuleBean();
        moduleBean.b(R.drawable.newui_tab_device_normal);
        moduleBean.a((int) R.drawable.newui_tab_device_pressed);
        moduleBean.a(getString(R.string.device));
        this.moduleBeanList.add(moduleBean);
        ModuleBean moduleBean2 = new ModuleBean();
        moduleBean2.b(R.drawable.newui_tab_school_normal);
        moduleBean2.a((int) R.drawable.newui_tab_school_pressed);
        moduleBean2.a(getString(R.string.tab_academy));
        this.moduleBeanList.add(moduleBean2);
        ModuleBean moduleBean3 = new ModuleBean();
        moduleBean3.b(R.drawable.newui_tab_mine_normal);
        moduleBean3.a((int) R.drawable.newui_tab_mine_pressed);
        moduleBean3.a(getString(R.string.tab_mine));
        this.moduleBeanList.add(moduleBean3);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new DeviceFragment());
        arrayList.add(new AcademyFragment());
        arrayList.add(new MineFragment());
        NoScrollViewPager noScrollViewPager = (NoScrollViewPager) findViewById(R.id.vpr);
        this.vpr = noScrollViewPager;
        noScrollViewPager.setOffscreenPageLimit(0);
        this.vpr.setAdapter(new la.b(arrayList, getSupportFragmentManager()));
        final MagicIndicator magicIndicator = (MagicIndicator) findViewById(R.id.magic_indicator);
        magicIndicator.setBackgroundColor(-1);
        CommonNavigator commonNavigator = new CommonNavigator(this);
        commonNavigator.setAdjustMode(true);
        commonNavigator.setAdapter(new mz.a() {
            public int getCount() {
                if (HostManagerActivity.this.moduleBeanList != null) {
                    return HostManagerActivity.this.moduleBeanList.size();
                }
                return 0;
            }

            public mz.c getIndicator(Context context) {
                return null;
            }

            public mz.d getTitleView(Context context, int i2) {
                CommonPagerTitleView commonPagerTitleView = new CommonPagerTitleView(context);
                final ModuleBean moduleBean = (ModuleBean) HostManagerActivity.this.moduleBeanList.get(i2);
                View inflate = LayoutInflater.from(context).inflate(R.layout.newui_item_tab_layout, (ViewGroup) null);
                final ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_tab);
                final TextView textView = (TextView) inflate.findViewById(R.id.tv_tab_name);
                imageView.setImageResource(moduleBean.c());
                textView.setText(moduleBean.a());
                commonPagerTitleView.setContentView(inflate);
                commonPagerTitleView.setOnPagerTitleChangeListener(new CommonPagerTitleView.b() {
                    public void onDeselected(int i2, int i3) {
                        textView.setTextColor(f.b(HostManagerActivity.this.getResources(), R.color.grey400transparent, (Resources.Theme) null));
                        imageView.setImageResource(moduleBean.c());
                    }

                    public void onEnter(int i2, int i3, float f2, boolean z2) {
                    }

                    public void onLeave(int i2, int i3, float f2, boolean z2) {
                    }

                    public void onSelected(int i2, int i3) {
                        textView.setTextColor(HostManagerActivity.this.getResources().getColor(R.color.colorAccent_blue));
                        imageView.setImageResource(moduleBean.b());
                    }
                });
                commonPagerTitleView.setOnClickListener(new View.OnClickListener(i2, magicIndicator) {
                    public final /* synthetic */ int f$1;
                    public final /* synthetic */ MagicIndicator f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        HostManagerActivity.AnonymousClass6.this.lambda$getTitleView$0$HostManagerActivity$6(this.f$1, this.f$2, view);
                    }
                });
                return commonPagerTitleView;
            }

            public /* synthetic */ void lambda$getTitleView$0$HostManagerActivity$6(int i2, MagicIndicator magicIndicator, View view) {
                HostManagerActivity.this.vpr.setCurrentItem(i2, false);
                magicIndicator.a(i2);
            }
        });
        magicIndicator.setNavigator(commonNavigator);
    }

    private void showImageUpdateDlg(String str, String str2) {
        if (this.updateWarnDlg == null) {
            this.updateWarnDlg = r.a().a(getString(R.string.dialog_tips), str2, str, new c.a() {
                public void onNo() {
                }

                public void onYes() {
                }
            });
        }
        if (!this.updateWarnDlg.isAdded()) {
            this.updateWarnDlg.show(getSupportFragmentManager(), "updateWarn");
        }
    }

    private void showProgressDialog(String str, DialogInterface.OnClickListener onClickListener) {
        dismissDialog();
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.mProgressDialog = progressDialog;
        progressDialog.setTitle(str);
        this.mProgressDialog.setMax(100);
        this.mProgressDialog.setProgressStyle(1);
        this.mProgressDialog.setCancelable(false);
        this.mProgressDialog.setButton(-2, getString(R.string.cancel), onClickListener);
        this.mProgressDialog.show();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Removed duplicated region for block: B:166:0x049e A[Catch:{ JSONException -> 0x04c1 }] */
    /* JADX WARNING: Removed duplicated region for block: B:169:0x04b7 A[Catch:{ JSONException -> 0x04c1 }] */
    @org.greenrobot.eventbus.l(a = org.greenrobot.eventbus.ThreadMode.MAIN)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void channelEvent(jo.c r17) {
        /*
            r16 = this;
            r1 = r16
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r2 = "channelEvent: "
            r0.append(r2)
            int r2 = r17.a()
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            java.lang.String r2 = "setStatus"
            android.util.Log.i(r2, r0)
            int r0 = r17.a()
            r3 = 80
            if (r0 < r3) goto L_0x0030
            int r0 = r17.a()
            java.lang.Object r2 = r17.b()
            r1.handleCmdChannelError(r0, r2)
            return
        L_0x0030:
            int r0 = r17.a()
            r3 = 12
            java.lang.String r4 = "SecStream_resolution"
            java.lang.String r5 = "SecStream_FPS"
            java.lang.String r7 = "type"
            java.lang.String r8 = "rval"
            r9 = 0
            r10 = 1
            if (r0 == r3) goto L_0x046c
            java.lang.String r3 = "hw_version"
            r11 = 15
            java.lang.String r12 = "_"
            java.lang.String r13 = "param"
            java.lang.String r14 = "FTP"
            if (r0 == r11) goto L_0x038d
            r15 = 23
            java.lang.String r6 = "sw_version"
            if (r0 == r15) goto L_0x02f0
            r2 = 40
            if (r0 == r2) goto L_0x0293
            r2 = 51
            java.lang.String r15 = "CmdChannel"
            if (r0 == r2) goto L_0x01d6
            r2 = 57
            if (r0 == r2) goto L_0x0178
            r2 = 54
            if (r0 == r2) goto L_0x0171
            r2 = 55
            if (r0 == r2) goto L_0x006c
            goto L_0x04c5
        L_0x006c:
            java.lang.Object r0 = r17.b()     // Catch:{ JSONException -> 0x04c1 }
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ JSONException -> 0x04c1 }
            int r2 = r0.getInt(r8)     // Catch:{ JSONException -> 0x04c1 }
            if (r2 >= 0) goto L_0x007a
            goto L_0x04c5
        L_0x007a:
            java.lang.String r2 = r0.getString(r7)     // Catch:{ JSONException -> 0x04c1 }
            int r3 = r2.hashCode()     // Catch:{ JSONException -> 0x04c1 }
            java.lang.String r6 = "EV_Value"
            java.lang.String r7 = "ISO"
            r8 = 3
            r12 = 2
            switch(r3) {
                case 72805: goto L_0x00a3;
                case 564274843: goto L_0x009b;
                case 1195741850: goto L_0x0094;
                case 1812923459: goto L_0x008c;
                default: goto L_0x008b;
            }
        L_0x008b:
            goto L_0x00ab
        L_0x008c:
            boolean r2 = r2.equals(r6)     // Catch:{ JSONException -> 0x04c1 }
            if (r2 == 0) goto L_0x00ab
            r9 = 3
            goto L_0x00ac
        L_0x0094:
            boolean r2 = r2.equals(r4)     // Catch:{ JSONException -> 0x04c1 }
            if (r2 == 0) goto L_0x00ab
            goto L_0x00ac
        L_0x009b:
            boolean r2 = r2.equals(r5)     // Catch:{ JSONException -> 0x04c1 }
            if (r2 == 0) goto L_0x00ab
            r9 = 1
            goto L_0x00ac
        L_0x00a3:
            boolean r2 = r2.equals(r7)     // Catch:{ JSONException -> 0x04c1 }
            if (r2 == 0) goto L_0x00ab
            r9 = 2
            goto L_0x00ac
        L_0x00ab:
            r9 = -1
        L_0x00ac:
            if (r9 == 0) goto L_0x011a
            if (r9 == r10) goto L_0x00e5
            if (r9 == r12) goto L_0x00c5
            if (r9 == r8) goto L_0x00b6
            goto L_0x04c5
        L_0x00b6:
            java.lang.String r0 = r0.getString(r13)     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.XEagleApp r2 = r1.xEagleApp     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.a r2 = r2.m()     // Catch:{ JSONException -> 0x04c1 }
            r2.a((java.lang.String) r0)     // Catch:{ JSONException -> 0x04c1 }
            goto L_0x04c5
        L_0x00c5:
            java.lang.String r0 = r0.getString(r13)     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.XEagleApp r2 = r1.xEagleApp     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.a r2 = r2.m()     // Catch:{ JSONException -> 0x04c1 }
            r2.b((java.lang.String) r0)     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.g()     // Catch:{ JSONException -> 0x04c1 }
            if (r0 == 0) goto L_0x04c5
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.g()     // Catch:{ JSONException -> 0x04c1 }
            r0.c((java.lang.String) r6)     // Catch:{ JSONException -> 0x04c1 }
            goto L_0x04c5
        L_0x00e5:
            java.lang.String r0 = r0.getString(r13)     // Catch:{ JSONException -> 0x04c1 }
            java.lang.String r2 = "30fps"
            boolean r2 = r0.equalsIgnoreCase(r2)     // Catch:{ JSONException -> 0x04c1 }
            if (r2 == 0) goto L_0x00f6
            r0 = 30
            r1.secFps = r0     // Catch:{ JSONException -> 0x04c1 }
            goto L_0x0100
        L_0x00f6:
            java.lang.String r2 = "15fps"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ JSONException -> 0x04c1 }
            if (r0 == 0) goto L_0x0100
            r1.secFps = r11     // Catch:{ JSONException -> 0x04c1 }
        L_0x0100:
            com.xeagle.android.utils.prefs.a r0 = r1.prefs     // Catch:{ JSONException -> 0x04c1 }
            int r2 = r1.secFps     // Catch:{ JSONException -> 0x04c1 }
            r0.d((int) r2)     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.g()     // Catch:{ JSONException -> 0x04c1 }
            if (r0 == 0) goto L_0x04c5
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.g()     // Catch:{ JSONException -> 0x04c1 }
            r0.c((java.lang.String) r7)     // Catch:{ JSONException -> 0x04c1 }
            goto L_0x04c5
        L_0x011a:
            java.lang.String r0 = r0.getString(r13)     // Catch:{ JSONException -> 0x04c1 }
            java.lang.String r2 = "1080P"
            boolean r2 = r0.equalsIgnoreCase(r2)     // Catch:{ JSONException -> 0x04c1 }
            if (r2 == 0) goto L_0x012f
            r0 = 1080(0x438, float:1.513E-42)
            r1.secHeight = r0     // Catch:{ JSONException -> 0x04c1 }
            r0 = 1920(0x780, float:2.69E-42)
            r1.secWidth = r0     // Catch:{ JSONException -> 0x04c1 }
            goto L_0x0150
        L_0x012f:
            java.lang.String r2 = "720P"
            boolean r2 = r0.equalsIgnoreCase(r2)     // Catch:{ JSONException -> 0x04c1 }
            if (r2 == 0) goto L_0x0140
            r0 = 1280(0x500, float:1.794E-42)
            r1.secWidth = r0     // Catch:{ JSONException -> 0x04c1 }
            r0 = 720(0x2d0, float:1.009E-42)
            r1.secHeight = r0     // Catch:{ JSONException -> 0x04c1 }
            goto L_0x0150
        L_0x0140:
            java.lang.String r2 = "WVGA"
            boolean r0 = r0.equalsIgnoreCase(r2)     // Catch:{ JSONException -> 0x04c1 }
            if (r0 == 0) goto L_0x0150
            r0 = 480(0x1e0, float:6.73E-43)
            r1.secHeight = r0     // Catch:{ JSONException -> 0x04c1 }
            r0 = 848(0x350, float:1.188E-42)
            r1.secWidth = r0     // Catch:{ JSONException -> 0x04c1 }
        L_0x0150:
            com.xeagle.android.utils.prefs.a r0 = r1.prefs     // Catch:{ JSONException -> 0x04c1 }
            int r2 = r1.secHeight     // Catch:{ JSONException -> 0x04c1 }
            r0.e((int) r2)     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.utils.prefs.a r0 = r1.prefs     // Catch:{ JSONException -> 0x04c1 }
            int r2 = r1.secWidth     // Catch:{ JSONException -> 0x04c1 }
            r0.f((int) r2)     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.g()     // Catch:{ JSONException -> 0x04c1 }
            if (r0 == 0) goto L_0x04c5
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.g()     // Catch:{ JSONException -> 0x04c1 }
            r0.n()     // Catch:{ JSONException -> 0x04c1 }
            goto L_0x04c5
        L_0x0171:
            java.lang.String r0 = "handleResponse: ------new device requests to connect111111111111"
            android.util.Log.i(r15, r0)
            goto L_0x04c5
        L_0x0178:
            java.lang.Object r0 = r17.b()
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            java.lang.String r2 = "state"
            int r2 = r0.getInt(r2)     // Catch:{ JSONException -> 0x04c1 }
            java.lang.String r3 = "progress"
            int r0 = r0.getInt(r3)     // Catch:{ JSONException -> 0x04c1 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x04c1 }
            r3.<init>()     // Catch:{ JSONException -> 0x04c1 }
            java.lang.String r4 = "channelEvent:---drone upgrade===state== "
            r3.append(r4)     // Catch:{ JSONException -> 0x04c1 }
            r3.append(r2)     // Catch:{ JSONException -> 0x04c1 }
            java.lang.String r4 = "==progress=="
            r3.append(r4)     // Catch:{ JSONException -> 0x04c1 }
            r3.append(r0)     // Catch:{ JSONException -> 0x04c1 }
            java.lang.String r0 = r3.toString()     // Catch:{ JSONException -> 0x04c1 }
            android.util.Log.i(r14, r0)     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.newUI.cameraManager.AmbaClient$UpgradeDroneState r0 = com.xeagle.android.newUI.cameraManager.AmbaClient.UpgradeDroneState.NOTIFY_DATA_TRAN_DONE     // Catch:{ JSONException -> 0x04c1 }
            int r0 = r0.a()     // Catch:{ JSONException -> 0x04c1 }
            if (r2 != r0) goto L_0x01be
            ka.a r0 = ka.a.a()     // Catch:{ JSONException -> 0x04c1 }
            java.util.concurrent.ThreadPoolExecutor r0 = r0.b()     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.login.HostManagerActivity$10 r3 = new com.xeagle.android.login.HostManagerActivity$10     // Catch:{ JSONException -> 0x04c1 }
            r3.<init>()     // Catch:{ JSONException -> 0x04c1 }
            r0.execute(r3)     // Catch:{ JSONException -> 0x04c1 }
        L_0x01be:
            java.lang.String r0 = "CameraClient"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x04c1 }
            r3.<init>()     // Catch:{ JSONException -> 0x04c1 }
            java.lang.String r4 = "run: ===state==="
            r3.append(r4)     // Catch:{ JSONException -> 0x04c1 }
            r3.append(r2)     // Catch:{ JSONException -> 0x04c1 }
            java.lang.String r2 = r3.toString()     // Catch:{ JSONException -> 0x04c1 }
            android.util.Log.i(r0, r2)     // Catch:{ JSONException -> 0x04c1 }
            goto L_0x04c5
        L_0x01d6:
            java.lang.Object r0 = r17.b()
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r4 = "handleCmdChannelEvent:--- version  "
            r2.append(r4)
            r2.append(r0)
            java.lang.String r2 = r2.toString()
            java.lang.String r4 = "GET_VERSION"
            android.util.Log.i(r4, r2)
            int r2 = r0.getInt(r8)     // Catch:{ JSONException -> 0x04c1 }
            if (r2 >= 0) goto L_0x01ff
            java.lang.String r0 = "handleCmdChannelEvent: --get version failed."
            android.util.Log.e(r14, r0)     // Catch:{ JSONException -> 0x04c1 }
            goto L_0x04c5
        L_0x01ff:
            java.lang.String r2 = r0.getString(r7)     // Catch:{ JSONException -> 0x04c1 }
            boolean r4 = r2.equalsIgnoreCase(r6)     // Catch:{ JSONException -> 0x04c1 }
            if (r4 == 0) goto L_0x0255
            java.lang.String r2 = "channelEvent:---sw version "
            android.util.Log.i(r14, r2)     // Catch:{ JSONException -> 0x04c1 }
            java.lang.String r0 = r0.getString(r13)     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.XEagleApp r2 = r1.xEagleApp     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.utils.prefs.a r2 = r2.j()     // Catch:{ JSONException -> 0x04c1 }
            r2.g((java.lang.String) r0)     // Catch:{ JSONException -> 0x04c1 }
            com.flypro.core.database.FirmwareInfoData r2 = r1.fwData     // Catch:{ JSONException -> 0x04c1 }
            com.flypro.core.database.UserLiteHelper.updateImageVersion(r2, r0)     // Catch:{ JSONException -> 0x04c1 }
            int r2 = r0.lastIndexOf(r12)     // Catch:{ JSONException -> 0x04c1 }
            int r2 = r2 + r10
            java.lang.String r0 = r0.substring(r2)     // Catch:{ JSONException -> 0x04c1 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x04c1 }
            r2.<init>()     // Catch:{ JSONException -> 0x04c1 }
            java.lang.String r3 = "run: ---sw version--"
            r2.append(r3)     // Catch:{ JSONException -> 0x04c1 }
            r2.append(r0)     // Catch:{ JSONException -> 0x04c1 }
            java.lang.String r0 = r2.toString()     // Catch:{ JSONException -> 0x04c1 }
            android.util.Log.i(r14, r0)     // Catch:{ JSONException -> 0x04c1 }
            java.lang.String r0 = "channelEvent:=====get sdcard sw space "
            android.util.Log.i(r14, r0)     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.g()     // Catch:{ JSONException -> 0x04c1 }
            if (r0 == 0) goto L_0x04c5
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.g()     // Catch:{ JSONException -> 0x04c1 }
            r0.z()     // Catch:{ JSONException -> 0x04c1 }
            goto L_0x04c5
        L_0x0255:
            boolean r2 = r2.equalsIgnoreCase(r3)     // Catch:{ JSONException -> 0x04c1 }
            if (r2 == 0) goto L_0x04c5
            java.lang.String r2 = "channelEvent: ---getHardVersion"
            android.util.Log.i(r15, r2)     // Catch:{ JSONException -> 0x04c1 }
            java.lang.String r0 = r0.getString(r13)     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.utils.prefs.a r2 = r1.prefs     // Catch:{ JSONException -> 0x04c1 }
            r2.t()     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.XEagleApp r2 = r1.xEagleApp     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.utils.prefs.a r2 = r2.j()     // Catch:{ JSONException -> 0x04c1 }
            r2.h((java.lang.String) r0)     // Catch:{ JSONException -> 0x04c1 }
            com.flypro.core.database.FirmwareInfoData r2 = r1.fwData     // Catch:{ JSONException -> 0x04c1 }
            int r3 = r0.lastIndexOf(r12)     // Catch:{ JSONException -> 0x04c1 }
            int r3 = r3 + r10
            java.lang.String r0 = r0.substring(r3)     // Catch:{ JSONException -> 0x04c1 }
            com.flypro.core.database.UserLiteHelper.updateImageChipType(r2, r0)     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.g()     // Catch:{ JSONException -> 0x04c1 }
            if (r0 == 0) goto L_0x04c5
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.g()     // Catch:{ JSONException -> 0x04c1 }
            r0.o()     // Catch:{ JSONException -> 0x04c1 }
            goto L_0x04c5
        L_0x0293:
            java.lang.Object r0 = r17.b()
            java.lang.String r0 = (java.lang.String) r0
            r0.hashCode()
            java.lang.String r2 = "Card_New_Insert"
            boolean r2 = r0.equals(r2)
            if (r2 != 0) goto L_0x02cf
            java.lang.String r2 = "Card_Removed"
            boolean r0 = r0.equals(r2)
            if (r0 != 0) goto L_0x02ae
            goto L_0x04c5
        L_0x02ae:
            r1.isHasSdcard = r9
            com.xeagle.android.utils.prefs.a r0 = r1.prefs
            r0.t((boolean) r9)
            kz.a r0 = kz.a.e()
            r0.a((boolean) r10)
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x04c5
            kz.a r0 = kz.a.e()
            com.xeagle.android.XEagleApp r2 = r1.xEagleApp
            r0.a((com.xeagle.android.XEagleApp) r2)
            goto L_0x04c5
        L_0x02cf:
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.g()
            if (r0 == 0) goto L_0x04c5
            r1.isHasSdcard = r10
            com.xeagle.android.utils.prefs.a r0 = r1.prefs
            r0.t((boolean) r10)
            kz.a r0 = kz.a.e()
            r0.a((boolean) r10)
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.g()
            r0.z()
            goto L_0x04c5
        L_0x02f0:
            java.lang.String r0 = "StartSession成功"
            android.util.Log.i(r2, r0)
            r1.sessionCount = r9
            org.greenrobot.eventbus.c r0 = org.greenrobot.eventbus.c.a()
            jo.ao r2 = new jo.ao
            r2.<init>(r10)
            r0.d(r2)
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x0322
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.g()
            if (r0 == 0) goto L_0x0321
            java.lang.String r0 = "channelEvent:========usb get sw version "
            android.util.Log.i(r14, r0)
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.g()
            r0.n(r6)
        L_0x0321:
            return
        L_0x0322:
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp
            com.flypro.core.util.e r0 = r0.a()
            boolean r0 = r0.c()
            if (r0 == 0) goto L_0x04c5
            com.xeagle.android.dialogs.c r0 = r1.wifiBindDlg
            r2 = 2131821013(0x7f1101d5, float:1.9274757E38)
            if (r0 != 0) goto L_0x0350
            com.xeagle.android.dialogs.r r0 = com.xeagle.android.dialogs.r.a()
            r3 = 2131823185(0x7f110a51, float:1.9279163E38)
            java.lang.String r3 = r1.getString(r3)
            java.lang.String r2 = r1.getString(r2)
            com.xeagle.android.login.HostManagerActivity$9 r4 = new com.xeagle.android.login.HostManagerActivity$9
            r4.<init>()
            com.xeagle.android.dialogs.c r0 = r0.a((java.lang.String) r3, (java.lang.String) r2, (com.xeagle.android.dialogs.c.a) r4)
            r1.wifiBindDlg = r0
            goto L_0x0357
        L_0x0350:
            java.lang.String r2 = r1.getString(r2)
            r0.b((java.lang.String) r2)
        L_0x0357:
            java.lang.String r0 = "channelEvent:========start session======= "
            android.util.Log.i(r14, r0)
            com.xeagle.android.dialogs.c r0 = r1.wifiBindDlg
            boolean r0 = r0.isAdded()
            if (r0 != 0) goto L_0x04c5
            java.lang.String r0 = "channelEvent:========GET SW VERSION======= "
            android.util.Log.i(r14, r0)
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.g()
            if (r0 == 0) goto L_0x037a
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.g()
            r0.n(r6)
        L_0x037a:
            boolean r0 = r1.hasSession
            if (r0 != 0) goto L_0x04c5
            com.xeagle.android.dialogs.c r0 = r1.wifiBindDlg
            androidx.fragment.app.FragmentManager r2 = r16.getSupportFragmentManager()
            java.lang.String r3 = "wifiBind"
            r0.show(r2, r3)
            r1.hasSession = r10
            goto L_0x04c5
        L_0x038d:
            java.lang.Object r0 = r17.b()
            org.json.JSONObject r0 = (org.json.JSONObject) r0
            java.lang.String r2 = "channelEvent: ---getSdCard space"
            android.util.Log.i(r14, r2)
            int r2 = r0.getInt(r8)     // Catch:{ JSONException -> 0x0440 }
            if (r2 >= 0) goto L_0x03b2
            r1.isHasSdcard = r9     // Catch:{ JSONException -> 0x0440 }
            com.xeagle.android.utils.prefs.a r0 = r1.prefs     // Catch:{ JSONException -> 0x0440 }
            r0.t((boolean) r9)     // Catch:{ JSONException -> 0x0440 }
            kz.a r0 = kz.a.e()     // Catch:{ JSONException -> 0x0440 }
            r0.a((boolean) r10)     // Catch:{ JSONException -> 0x0440 }
            java.lang.String r0 = "sd is not inserted or it is broken !"
            android.util.Log.i(r14, r0)     // Catch:{ JSONException -> 0x0440 }
            goto L_0x041d
        L_0x03b2:
            r1.isHasSdcard = r10     // Catch:{ JSONException -> 0x0440 }
            com.xeagle.android.utils.prefs.a r2 = r1.prefs     // Catch:{ JSONException -> 0x0440 }
            r2.t((boolean) r10)     // Catch:{ JSONException -> 0x0440 }
            kz.a r2 = kz.a.e()     // Catch:{ JSONException -> 0x0440 }
            r2.a((boolean) r10)     // Catch:{ JSONException -> 0x0440 }
            com.xeagle.android.utils.prefs.a r2 = r1.prefs     // Catch:{ JSONException -> 0x0440 }
            java.lang.String r2 = r2.t()     // Catch:{ JSONException -> 0x0440 }
            int r4 = r2.lastIndexOf(r12)     // Catch:{ JSONException -> 0x0440 }
            int r4 = r4 + r10
            java.lang.String r2 = r2.substring(r4)     // Catch:{ JSONException -> 0x0440 }
            int r2 = java.lang.Integer.parseInt(r2)     // Catch:{ JSONException -> 0x0440 }
            r4 = 2020121101(0x78689a0d, float:1.8870897E34)
            r5 = 4596373779694328218(0x3fc999999999999a, double:0.2)
            r7 = 1149239296(0x44800000, float:1024.0)
            if (r2 < r4) goto L_0x03f5
            java.lang.String r2 = "total"
            long r10 = r0.getLong(r2)     // Catch:{ JSONException -> 0x0440 }
            float r0 = (float) r10     // Catch:{ JSONException -> 0x0440 }
            float r0 = r0 / r7
            float r0 = r0 / r7
            double r7 = (double) r0     // Catch:{ JSONException -> 0x0440 }
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x041d
            r1.isHasSdcard = r9     // Catch:{ JSONException -> 0x0440 }
            com.xeagle.android.utils.prefs.a r0 = r1.prefs     // Catch:{ JSONException -> 0x0440 }
        L_0x03f1:
            r0.t((boolean) r9)     // Catch:{ JSONException -> 0x0440 }
            goto L_0x041d
        L_0x03f5:
            java.lang.String r0 = r0.getString(r13)     // Catch:{ JSONException -> 0x0440 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ JSONException -> 0x0440 }
            r2.<init>()     // Catch:{ JSONException -> 0x0440 }
            java.lang.String r4 = "sd card---"
            r2.append(r4)     // Catch:{ JSONException -> 0x0440 }
            r2.append(r0)     // Catch:{ JSONException -> 0x0440 }
            java.lang.String r2 = r2.toString()     // Catch:{ JSONException -> 0x0440 }
            android.util.Log.i(r14, r2)     // Catch:{ JSONException -> 0x0440 }
            float r0 = java.lang.Float.parseFloat(r0)     // Catch:{ JSONException -> 0x0440 }
            float r0 = r0 / r7
            float r0 = r0 / r7
            double r7 = (double) r0     // Catch:{ JSONException -> 0x0440 }
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x041d
            r1.isHasSdcard = r9     // Catch:{ JSONException -> 0x0440 }
            com.xeagle.android.utils.prefs.a r0 = r1.prefs     // Catch:{ JSONException -> 0x0440 }
            goto L_0x03f1
        L_0x041d:
            kz.a r0 = kz.a.e()     // Catch:{ JSONException -> 0x0440 }
            boolean r0 = r0.f13915a     // Catch:{ JSONException -> 0x0440 }
            if (r0 != 0) goto L_0x042c
            kz.a r0 = kz.a.e()     // Catch:{ JSONException -> 0x0440 }
            r0.k()     // Catch:{ JSONException -> 0x0440 }
        L_0x042c:
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp     // Catch:{ JSONException -> 0x0440 }
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.g()     // Catch:{ JSONException -> 0x0440 }
            if (r0 == 0) goto L_0x045c
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp     // Catch:{ JSONException -> 0x0440 }
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.g()     // Catch:{ JSONException -> 0x0440 }
            r0.n(r3)     // Catch:{ JSONException -> 0x0440 }
            goto L_0x045c
        L_0x043e:
            r0 = move-exception
            goto L_0x0464
        L_0x0440:
            r0 = move-exception
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x043e }
            r2.<init>()     // Catch:{ all -> 0x043e }
            java.lang.String r3 = "channelEvent: ====GET SPACE ERROR----"
            r2.append(r3)     // Catch:{ all -> 0x043e }
            java.lang.String r3 = r0.getMessage()     // Catch:{ all -> 0x043e }
            r2.append(r3)     // Catch:{ all -> 0x043e }
            java.lang.String r2 = r2.toString()     // Catch:{ all -> 0x043e }
            android.util.Log.e(r14, r2)     // Catch:{ all -> 0x043e }
            r0.printStackTrace()     // Catch:{ all -> 0x043e }
        L_0x045c:
            kz.a r0 = kz.a.e()
            r0.g()
            goto L_0x04c5
        L_0x0464:
            kz.a r2 = kz.a.e()
            r2.g()
            throw r0
        L_0x046c:
            java.lang.Object r0 = r17.b()     // Catch:{ JSONException -> 0x04c1 }
            org.json.JSONObject r0 = (org.json.JSONObject) r0     // Catch:{ JSONException -> 0x04c1 }
            int r2 = r0.getInt(r8)     // Catch:{ JSONException -> 0x04c1 }
            if (r2 >= 0) goto L_0x0479
            goto L_0x04c5
        L_0x0479:
            java.lang.String r0 = r0.getString(r7)     // Catch:{ JSONException -> 0x04c1 }
            int r2 = r0.hashCode()     // Catch:{ JSONException -> 0x04c1 }
            r3 = 564274843(0x21a2269b, float:1.0987766E-18)
            if (r2 == r3) goto L_0x0493
            r3 = 1195741850(0x4745929a, float:50578.6)
            if (r2 == r3) goto L_0x048c
            goto L_0x049b
        L_0x048c:
            boolean r0 = r0.equals(r4)     // Catch:{ JSONException -> 0x04c1 }
            if (r0 == 0) goto L_0x049b
            goto L_0x049c
        L_0x0493:
            boolean r0 = r0.equals(r5)     // Catch:{ JSONException -> 0x04c1 }
            if (r0 == 0) goto L_0x049b
            r9 = 1
            goto L_0x049c
        L_0x049b:
            r9 = -1
        L_0x049c:
            if (r9 == 0) goto L_0x04b7
            if (r9 == r10) goto L_0x04a1
            goto L_0x04c5
        L_0x04a1:
            r0 = -1
            r1.change_fps = r0     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.g()     // Catch:{ JSONException -> 0x04c1 }
            r0.s()     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.g()     // Catch:{ JSONException -> 0x04c1 }
            r0.n()     // Catch:{ JSONException -> 0x04c1 }
            goto L_0x04c5
        L_0x04b7:
            com.xeagle.android.XEagleApp r0 = r1.xEagleApp     // Catch:{ JSONException -> 0x04c1 }
            com.xeagle.android.newUI.cameraManager.AmbaClient r0 = r0.g()     // Catch:{ JSONException -> 0x04c1 }
            r0.o()     // Catch:{ JSONException -> 0x04c1 }
            goto L_0x04c5
        L_0x04c1:
            r0 = move-exception
            r0.printStackTrace()
        L_0x04c5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.HostManagerActivity.channelEvent(jo.c):void");
    }

    public /* synthetic */ void lambda$onCreate$0$HostManagerActivity(Long l2) throws Exception {
        if (!this.xEagleApp.e().f11901a) {
            this.xEagleApp.e().f();
        }
        if (this.xEagleApp.e().e() && !this.xEagleApp.e().i()) {
            hf.d.a("重新连接USB");
            org.greenrobot.eventbus.c.a().d(new e(7, true));
            this.xEagleApp.e().h();
        }
    }

    public /* synthetic */ void lambda$onCreate$1$HostManagerActivity(Long l2) throws Exception {
        kz.a.e().g();
        ks.e.b(this);
        ks.e.c(this);
        ks.e.a(this);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        setContentView((int) R.layout.host_manager_layout);
        XEagleApp xEagleApp2 = (XEagleApp) getApplicationContext();
        this.xEagleApp = xEagleApp2;
        xEagleApp2.a(com.hoho.android.usb.usb.data_proxy.d.a((AppCompatActivity) this));
        this.xEagleApp.m().l(false);
        this.prefs = this.xEagleApp.j();
        kz.a.e().a((AppCompatActivity) this);
        this.disposable = io.reactivex.f.a(2, 3, TimeUnit.SECONDS).b(lz.a.b()).a(lu.a.a()).a(new lv.d() {
            public final void accept(Object obj) {
                HostManagerActivity.this.lambda$onCreate$0$HostManagerActivity((Long) obj);
            }
        });
        initView();
        UserLiteHelper.requestFwVersionInfo(new FindMultiCallback<FirmwareInfoData>() {
            public void onFinish(List<FirmwareInfoData> list) {
                if (list == null || list.size() <= 0) {
                    UserLiteHelper.saveFwVersionInfo("-", "-", "-", "-", "-", "-", "-", "-", "-", "-");
                } else {
                    FirmwareInfoData unused = HostManagerActivity.this.fwData = list.get(0);
                }
            }
        });
        this.isBind = getApplicationContext().bindService(new Intent(this, UdpDataService.class), this.connection, 1);
        ha.b.a().a("VERSION_USB").b(this, new t<Object>() {
            public void onChanged(Object obj) {
                h hVar = (h) obj;
                if (HostManagerActivity.this.fwData != null) {
                    Log.i("FTP", "onChanged: ====" + hVar.a());
                    HostManagerActivity.this.xEagleApp.n().g(hVar.a());
                    UserLiteHelper.updateRepeaterVersion(HostManagerActivity.this.fwData, hVar.a());
                }
            }
        });
        io.reactivex.f.a(3, TimeUnit.SECONDS).a(new lv.d() {
            public final void accept(Object obj) {
                HostManagerActivity.this.lambda$onCreate$1$HostManagerActivity((Long) obj);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        b bVar = this.disposable;
        if (bVar != null) {
            bVar.dispose();
        }
        org.greenrobot.eventbus.c.a().d(new e(2, false));
        if (this.isBind) {
            UdpDataService udpDataService = this.udpService;
            if (udpDataService != null) {
                udpDataService.stop();
            }
            getApplicationContext().unbindService(this.connection);
            this.isBind = false;
            this.wifiBindDlg = null;
        }
    }

    public boolean onKeyDown(int i2, KeyEvent keyEvent) {
        if (i2 == 4) {
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - this.firstTime > 1000) {
                ToastUtils.showShort((int) R.string.warning_back);
                this.firstTime = currentTimeMillis;
                return true;
            }
            finish();
        }
        return super.onKeyDown(i2, keyEvent);
    }

    /* access modifiers changed from: protected */
    public void onPause() {
        super.onPause();
        hf.d.a("失去焦点");
        com.xeagle.android.vjoystick.utils.b.b(this);
        if (org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().c(this);
        }
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        com.xeagle.android.vjoystick.utils.b.a(this);
        if (!org.greenrobot.eventbus.c.a().b(this)) {
            org.greenrobot.eventbus.c.a().a((Object) this);
        }
        this.camera_type = this.xEagleApp.m().a();
    }

    public void onWindowFocusChanged(boolean z2) {
        super.onWindowFocusChanged(z2);
        if (!z2) {
            return;
        }
        if (this.prefs.aE().equalsIgnoreCase("-")) {
            c a2 = r.a().a(getString(R.string.warning), getString(R.string.no_login_warn), (c.a) new c.a() {
                public void onNo() {
                }

                public void onYes() {
                    HostManagerActivity.this.startActivity(new Intent(HostManagerActivity.this, SplashActivity.class));
                }
            });
            if (!a2.isAdded()) {
                a2.show(getSupportFragmentManager(), "noLogin");
                return;
            }
            return;
        }
        checkLoc();
        startService(new Intent(this, UploadListenerService.class));
    }

    @l(a = ThreadMode.ASYNC)
    public void recentAppsEvent(aj ajVar) {
        if (ajVar.a()) {
            Log.i("Sochip", "recentAppsEvent:-----exit ");
            SystemClock.sleep(100);
            System.exit(0);
        }
    }

    @l(a = ThreadMode.MAIN)
    public void socSuccessEvent(jp.f fVar) {
        SochipVersionBean sochipVersionBean;
        if (fVar.a() == 2001 && (sochipVersionBean = (SochipVersionBean) fVar.b()) != null && sochipVersionBean.getVersion() != null) {
            Log.i("Sochip", "socSuccess:--version--- " + sochipVersionBean.getVersion());
            this.prefs.g(sochipVersionBean.getVersion());
            SystemClock.sleep(100);
            this.isSendSessionInfo = true;
            new Thread(new Runnable() {
                public void run() {
                    while (HostManagerActivity.this.isSendSessionInfo) {
                        if (HostManagerActivity.this.xEagleApp.h() != null) {
                            HostManagerActivity.this.xEagleApp.h().startSession(HostManagerActivity.this.getApplicationContext());
                            SystemClock.sleep(1000);
                        }
                    }
                }
            }, "getSocVersion").start();
        }
    }

    @l(a = ThreadMode.MAIN)
    public void sochipTcpEvent(g gVar) {
        if (gVar.a() == 4) {
            this.isSendSessionInfo = false;
            int intValue = ((Integer) gVar.b()).intValue();
            if (intValue == 0) {
                this.sessionCount = 0;
                org.greenrobot.eventbus.c.a().d(new ao(true));
                c cVar = this.wifiBindDlg;
                if (cVar == null) {
                    this.wifiBindDlg = r.a().a(getString(R.string.warning), getString(R.string.device_bind_success), (c.a) new c.a() {
                        public void onNo() {
                        }

                        public void onYes() {
                        }
                    });
                } else {
                    cVar.b(getString(R.string.device_bind_success));
                }
                if (!this.wifiBindDlg.isAdded() && !this.hasSession) {
                    this.wifiBindDlg.show(getSupportFragmentManager(), "wifiBind");
                    this.hasSession = true;
                }
            } else if (intValue == -31) {
                this.sessionCount = 0;
                com.xeagle.android.utils.c.a(((XEagleApp) getApplicationContext()).k());
                if (this.xEagleApp.h() != null) {
                    this.xEagleApp.h().disconnect();
                }
                c cVar2 = this.wifiBindDlg;
                if (cVar2 == null) {
                    this.wifiBindDlg = r.a().a(getString(R.string.warning), getString(R.string.device_other_bind), (c.a) new c.a() {
                        public void onNo() {
                        }

                        public void onYes() {
                            System.exit(0);
                        }
                    });
                } else {
                    cVar2.b(getString(R.string.device_other_bind));
                }
                if (!this.wifiBindDlg.isAdded()) {
                    this.wifiBindDlg.show(getSupportFragmentManager(), "bindWifi");
                }
            }
        }
    }

    @l(a = ThreadMode.MAIN, b = true)
    public void tcpConnectFailEvent(aw awVar) {
        String a2 = awVar.a();
        if (this.xEagleApp.a().i().contains("Ground") && a2.contains("from")) {
            String substring = a2.substring(a2.indexOf("from"));
            if (!substring.contains("172.50.10") && !substring.contains("192.168.10") && this.connectTipsDlg == null) {
                d a3 = d.a(getString(R.string.dialog_tips), getString(R.string.tips_connect_resolve), new d.a() {
                    public void onNo() {
                    }

                    public void onYes() {
                        HostManagerActivity.this.startActivity(new Intent(HostManagerActivity.this, TipsConnectActivity.class));
                    }
                });
                this.connectTipsDlg = a3;
                if (!a3.isAdded()) {
                    this.connectTipsDlg.show(getSupportFragmentManager(), "tips");
                }
            }
        }
    }

    @l(a = ThreadMode.MAIN, b = true)
    public void tcpSuccessEvent(ax axVar) {
        if (!this.xEagleApp.c()) {
            if (axVar.a() == 1) {
                if (this.xEagleApp.g() != null) {
                    this.xEagleApp.g().e();
                }
            } else if (axVar.a() == 2 && this.xEagleApp.h() != null) {
                this.xEagleApp.h().getFirmwareVersion(CameraGlobal.BASE_URL, 1, CameraGlobal.GET_VERSION);
            }
        }
    }

    public void updateDroneChipTypeToDatabase(String str) {
        UserLiteHelper.updateDroneChipType(this.fwData, str);
        UserLiteHelper.updateRepeaterChipType(this.fwData, str);
    }

    public void updateDroneFwVersionToDatabase(String str) {
        UserLiteHelper.updateDroneVersion(this.fwData, str);
    }

    public void updateDroneTypeToDatabase(String str) {
        UserLiteHelper.updateDroneType(this.fwData, str);
    }
}
