package com.xeagle.android.login.fragment;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.SpannableString;
import android.text.method.LinkMovementMethod;
import android.text.style.ClickableSpan;
import android.text.style.ForegroundColorSpan;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.t;
import com.amap.api.mapcore.util.fx;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.flypro.core.database.ListenerTotalData;
import com.flypro.core.database.UserInfo;
import com.flypro.core.database.UserLiteHelper;
import com.flypro.core.util.e;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.communication.ftp.FtpBase;
import com.xeagle.android.dialogs.ai;
import com.xeagle.android.dialogs.d;
import com.xeagle.android.dialogs.q;
import com.xeagle.android.dialogs.u;
import com.xeagle.android.dialogs.w;
import com.xeagle.android.login.FlightListenerActivity;
import com.xeagle.android.login.HostManagerActivity;
import com.xeagle.android.login.SplashActivity;
import com.xeagle.android.login.beans.ListenerListBeans;
import com.xeagle.android.login.beans.ServiceBeans;
import com.xeagle.android.login.beans.UserInfoAcceptBeans;
import com.xeagle.android.login.beans.UserInfoBeans;
import com.xeagle.android.login.common.CircleImageView;
import com.xeagle.android.login.common.ToastHelper;
import com.xeagle.android.login.retrofitLogin.RegContract;
import com.xeagle.android.login.retrofitLogin.RegPresenter;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.newUI.activity.AccountActivity;
import com.xeagle.android.newUI.activity.DeviceManageActivity;
import com.xeagle.android.newUI.activity.MoreActivity;
import com.xeagle.android.newUI.activity.PersonInfoActivity;
import com.xeagle.android.newUI.cameraManager.AmbaClient;
import com.xeagle.android.sobot.SobotWebViewActivity;
import com.xeagle.android.utils.c;
import com.xeagle.android.utils.o;
import com.xeagle.android.utils.prefs.a;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import ha.b;
import ha.h;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Locale;
import org.litepal.crud.callback.FindCallback;
import org.litepal.crud.callback.SaveCallback;

public class MineFragment extends Fragment implements RegContract.lLoadView {
    private IButton btn_logout;
    /* access modifiers changed from: private */

    /* renamed from: info  reason: collision with root package name */
    public UserInfo f23801info;
    private boolean isHasSdcard;
    /* access modifiers changed from: private */
    public CircleImageView iv_avatar;
    private LinearLayout ll_go_detail;
    /* access modifiers changed from: private */
    public ListenerListBeans llb;
    /* access modifiers changed from: private */
    public Handler mHandler = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            super.handleMessage(message);
            if (message.obj != null) {
                long longValue = ((Long) message.obj).longValue();
                Log.i("FTP", "handleMessage: ===PROGRESS===" + longValue);
            }
        }
    };
    /* access modifiers changed from: private */
    public HostManagerActivity parent;
    /* access modifiers changed from: private */
    public a prefs;
    private RegPresenter presenter;
    private RelativeLayout rl_account_safe;
    private RelativeLayout rl_device_manage;
    private RelativeLayout rl_firmware;
    private RelativeLayout rl_more;
    private RelativeLayout rl_rc_pair;
    private RelativeLayout rl_service_online;
    private View service_divide;
    /* access modifiers changed from: private */
    public String totalDuration;
    /* access modifiers changed from: private */
    public String totalMiles;
    /* access modifiers changed from: private */
    public TextView tv_duration_unit;
    /* access modifiers changed from: private */
    public TextView tv_fly_duration;
    /* access modifiers changed from: private */
    public TextView tv_fly_mileage;
    /* access modifiers changed from: private */
    public TextView tv_fly_num;
    /* access modifiers changed from: private */
    public TextView tv_id;
    /* access modifiers changed from: private */
    public TextView tv_mileage_unit;
    /* access modifiers changed from: private */
    public TextView tv_name;
    private View view;
    private e wifiFunction;

    private void initView(View view2) {
        RelativeLayout relativeLayout;
        int i2;
        int i3;
        int i4;
        int i5;
        a j2 = ((XEagleApp) this.parent.getApplicationContext()).j();
        this.prefs = j2;
        this.f23801info = UserLiteHelper.getUserInfo(j2.aE());
        this.tv_id = (TextView) view2.findViewById(R.id.tv_id);
        this.tv_name = (TextView) view2.findViewById(R.id.tv_name);
        this.iv_avatar = (CircleImageView) view2.findViewById(R.id.iv_avatar);
        this.tv_fly_num = (TextView) view2.findViewById(R.id.tv_fly_num);
        this.tv_fly_mileage = (TextView) view2.findViewById(R.id.tv_fly_mileage);
        this.tv_fly_duration = (TextView) view2.findViewById(R.id.tv_fly_duration);
        this.ll_go_detail = (LinearLayout) view2.findViewById(R.id.ll_go_detail);
        this.rl_account_safe = (RelativeLayout) view2.findViewById(R.id.rl_account_safe);
        this.rl_rc_pair = (RelativeLayout) view2.findViewById(R.id.rl_rc_pair);
        this.rl_firmware = (RelativeLayout) view2.findViewById(R.id.rl_firmware);
        this.rl_service_online = (RelativeLayout) view2.findViewById(R.id.rl_service_online);
        this.service_divide = view2.findViewById(R.id.divide_service);
        this.rl_more = (RelativeLayout) view2.findViewById(R.id.rl_more);
        this.rl_device_manage = (RelativeLayout) view2.findViewById(R.id.rl_device_manage);
        this.btn_logout = (IButton) view2.findViewById(R.id.btn_logout);
        this.tv_duration_unit = (TextView) view2.findViewById(R.id.tv_duration_unit);
        this.tv_mileage_unit = (TextView) view2.findViewById(R.id.tv_mileage_unit);
        this.presenter = new RegPresenter(this);
        this.wifiFunction = new e(this.parent.getApplicationContext());
        int i6 = 8;
        this.tv_id.setVisibility(8);
        boolean c2 = ((XEagleApp) this.parent.getApplicationContext()).c();
        this.rl_firmware.setVisibility(8);
        if (c.b(this.parent.getApplicationContext())) {
            relativeLayout = this.rl_service_online;
            i6 = 0;
        } else {
            relativeLayout = this.rl_service_online;
        }
        relativeLayout.setVisibility(i6);
        this.service_divide.setVisibility(i6);
        this.rl_service_online.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MineFragment.this.lambda$initView$0$MineFragment(view);
            }
        });
        TextView textView = (TextView) view2.findViewById(R.id.app_policy);
        SpannableString spannableString = new SpannableString(getString(R.string.policy_notice_mine));
        if (!c.b(this.parent.getApplicationContext()) && !c.a(this.parent.getApplicationContext())) {
            i2 = 0;
            i3 = 14;
            i4 = 15;
            i5 = 26;
        } else {
            i2 = 0;
            i3 = 5;
            i4 = 6;
            i5 = spannableString.length();
        }
        spanLocalize(spannableString, i2, i3, i4, i5);
        textView.setMovementMethod(LinkMovementMethod.getInstance());
        textView.setText(spannableString);
    }

    private void logout() {
        Intent intent = new Intent(this.parent, SplashActivity.class);
        this.prefs.K("-");
        startActivity(intent);
        this.parent.finish();
    }

    private void setDataToView() {
        setInfo();
        if (!this.wifiFunction.a(this.parent.getApplicationContext())) {
            UserLiteHelper.getTotalFlightData(new FindCallback<ListenerTotalData>() {
                public void onFinish(final ListenerTotalData listenerTotalData) {
                    if (listenerTotalData != null) {
                        MineFragment.this.parent.runOnUiThread(new Runnable() {
                            public void run() {
                                TextView access$300;
                                String string;
                                int i2;
                                HostManagerActivity hostManagerActivity;
                                TextView textView;
                                MineFragment.this.tv_fly_duration.setText(listenerTotalData.getTotalFlightTime());
                                if (!listenerTotalData.getTotalFlightTime().contains("s") && listenerTotalData.getTotalFlightTime().contains(fx.f8866g)) {
                                    access$300 = MineFragment.this.tv_duration_unit;
                                    string = MineFragment.this.parent.getString(R.string.newui_duration_h);
                                } else {
                                    access$300 = MineFragment.this.tv_duration_unit;
                                    string = MineFragment.this.parent.getString(R.string.newui_duration_s);
                                }
                                access$300.setText(string);
                                MineFragment.this.tv_fly_mileage.setText(listenerTotalData.getTotalMileage());
                                if (listenerTotalData.getTotalMileage().contains("km")) {
                                    textView = MineFragment.this.tv_mileage_unit;
                                    hostManagerActivity = MineFragment.this.parent;
                                    i2 = R.string.newui_mileage_km;
                                } else {
                                    textView = MineFragment.this.tv_mileage_unit;
                                    hostManagerActivity = MineFragment.this.parent;
                                    i2 = R.string.newui_mileage_m;
                                }
                                textView.setText(hostManagerActivity.getString(i2));
                                MineFragment.this.tv_fly_num.setText(listenerTotalData.getTotalDegree());
                            }
                        });
                    }
                }
            });
        }
    }

    private void setInfo() {
        if (this.wifiFunction.a(this.parent.getApplicationContext())) {
            this.presenter.getUserInfo(UserGlobal.BASE_URL, this.f23801info.getToken());
            HashMap hashMap = new HashMap();
            hashMap.put("token", this.f23801info.getToken());
            hashMap.put("page", String.valueOf(1));
            this.presenter.requestListenerList(UserGlobal.BASE_URL, hashMap);
            return;
        }
        this.tv_name.setText(this.f23801info.getUserName());
        if (this.f23801info.getIconPath() == null || this.f23801info.getIconPath().equals("-") || this.f23801info.getIconPath().equals("") || !new File(this.f23801info.getIconPath()).exists()) {
            this.iv_avatar.setImageDrawable(this.parent.getDrawable(R.drawable.avatar_default));
        } else {
            this.iv_avatar.setImageBitmap(c.b(this.f23801info.getIconPath()));
        }
    }

    private void setListener() {
        this.iv_avatar.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MineFragment.this.lambda$setListener$1$MineFragment(view);
            }
        });
        this.tv_name.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MineFragment.this.lambda$setListener$2$MineFragment(view);
            }
        });
        this.tv_id.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MineFragment.this.lambda$setListener$3$MineFragment(view);
            }
        });
        this.ll_go_detail.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MineFragment.this.lambda$setListener$4$MineFragment(view);
            }
        });
        this.rl_account_safe.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MineFragment.this.lambda$setListener$5$MineFragment(view);
            }
        });
        this.rl_firmware.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (XEagleApp.d().c()) {
                    new o(MineFragment.this.parent).a((Context) MineFragment.this.parent, MineFragment.this.prefs);
                } else {
                    ToastUtils.showShort((int) R.string.connect_usb_warn);
                }
            }
        });
        this.rl_device_manage.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MineFragment.this.lambda$setListener$6$MineFragment(view);
            }
        });
        this.rl_rc_pair.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                HostManagerActivity access$200;
                int i2;
                en.a k2 = ((XEagleApp) MineFragment.this.parent.getApplicationContext()).k();
                e eVar = new e(MineFragment.this.parent.getApplicationContext());
                if (k2.d().c()) {
                    access$200 = MineFragment.this.parent;
                    i2 = R.string.flying_operate_warn;
                } else if (eVar.i().contains("Ground")) {
                    w a2 = w.a(MineFragment.this.parent.getString(R.string.pair_rc), "pair rc", new w.a() {
                        public void onNo() {
                        }

                        public void onYes() {
                        }
                    });
                    if (a2 != null) {
                        a2.show(MineFragment.this.getChildFragmentManager(), "pair");
                        return;
                    }
                    return;
                } else if (eVar.i().contains("Drone")) {
                    q a3 = q.a(MineFragment.this.parent.getString(R.string.pair_rc), "pair rc", new q.b() {
                        public void onNo() {
                        }

                        public void onYes() {
                        }
                    });
                    if (a3 != null) {
                        a3.show(MineFragment.this.getChildFragmentManager(), "wifi-name");
                        return;
                    }
                    return;
                } else if (((XEagleApp) MineFragment.this.parent.getApplicationContext()).c()) {
                    ai a4 = ai.a().a(MineFragment.this.parent.getString(R.string.pair_rc), "pair rc", new ai.a() {
                        public void onNo() {
                        }

                        public void onYes() {
                        }
                    });
                    if (!a4.isAdded()) {
                        a4.show(MineFragment.this.getChildFragmentManager(), "usb_pair");
                        return;
                    }
                    return;
                } else {
                    access$200 = MineFragment.this.parent;
                    i2 = R.string.scan_sure_connect;
                }
                ToastUtils.showShort((CharSequence) access$200.getString(i2));
            }
        });
        this.rl_more.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MineFragment.this.lambda$setListener$7$MineFragment(view);
            }
        });
        this.btn_logout.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                MineFragment.this.lambda$setListener$9$MineFragment(view);
            }
        });
    }

    private void spanLocalize(SpannableString spannableString, int i2, int i3, int i4, int i5) {
        ForegroundColorSpan foregroundColorSpan = new ForegroundColorSpan(Color.parseColor("#0099EE"));
        spannableString.setSpan(foregroundColorSpan, i2, i3, 17);
        spannableString.setSpan(foregroundColorSpan, i4, i5, 17);
        spannableString.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                u a2 = u.a(MineFragment.this.getString(R.string.policy_privacy_title), MineFragment.this.getString(R.string.policy_privacy_text), new u.a() {
                    public void onNo() {
                    }

                    public void onYes() {
                    }
                });
                if (a2 != null) {
                    a2.show(MineFragment.this.getChildFragmentManager(), "policy");
                }
            }
        }, i2, i3, 17);
        spannableString.setSpan(new ClickableSpan() {
            public void onClick(View view) {
                u a2 = u.a(MineFragment.this.getString(R.string.user_notice_title), MineFragment.this.getString(R.string.user_notice_text), new u.a() {
                    public void onNo() {
                    }

                    public void onYes() {
                    }
                });
                if (a2 != null) {
                    a2.show(MineFragment.this.getChildFragmentManager(), "user");
                }
            }
        }, i4, i5, 17);
    }

    private void upgradeDroneFirmware() {
        d.a(this.parent.getString(R.string.dialog_tips), this.parent.getString(R.string.update_camera_firmware), new d.a() {
            public void onNo() {
            }

            public void onYes() {
                final com.xeagle.android.communication.ftp.a aVar = new com.xeagle.android.communication.ftp.a(MineFragment.this.parent.getApplicationContext(), "192.168.10.1", "root", "cfly", "21");
                ka.a.a().b().execute(new Runnable() {
                    public void run() {
                        try {
                            if (aVar.a("172.50.10.1", 21, "root", "cfly")) {
                                com.xeagle.android.communication.ftp.a aVar = aVar;
                                FtpBase.UploadStatus a2 = aVar.a(kx.d.i(MineFragment.this.parent.getApplicationContext()) + "DRONE_FWUPDATE.bin", "/tmp/SD0/DRONE_FWUPDATE.bin", MineFragment.this.mHandler);
                                if ("UPLOAD_FROM_BREAK_SUCCESS".equalsIgnoreCase(a2.name()) || "UPLOAD_NEW_FILE_SUCCESS".equalsIgnoreCase(a2.name()) || "FILE_EXIST".equalsIgnoreCase(a2.name())) {
                                    AmbaClient g2 = ((XEagleApp) MineFragment.this.parent.getApplicationContext()).g();
                                    g2.j(kx.d.i(MineFragment.this.parent.getApplicationContext()) + "DRONE_FWUPDATE.bin");
                                }
                            }
                        } catch (IOException e2) {
                            Log.i("FTP", "onYes: ====exception===" + e2.getMessage());
                            e2.printStackTrace();
                        }
                    }
                });
                Log.i("FTP", "onYes:---- ");
            }
        }).show(getChildFragmentManager(), "updateFirmware");
    }

    public /* synthetic */ void lambda$initView$0$MineFragment(View view2) {
        HashMap hashMap = new HashMap();
        hashMap.put("token", this.f23801info.getToken());
        this.presenter.serviceOnline(UserGlobal.BASE_URL, hashMap);
    }

    public /* synthetic */ void lambda$setListener$1$MineFragment(View view2) {
        startActivity(new Intent(getActivity(), PersonInfoActivity.class));
    }

    public /* synthetic */ void lambda$setListener$2$MineFragment(View view2) {
        startActivity(new Intent(getActivity(), PersonInfoActivity.class));
    }

    public /* synthetic */ void lambda$setListener$3$MineFragment(View view2) {
        startActivity(new Intent(getActivity(), PersonInfoActivity.class));
    }

    public /* synthetic */ void lambda$setListener$4$MineFragment(View view2) {
        startActivity(new Intent(getActivity(), FlightListenerActivity.class));
    }

    public /* synthetic */ void lambda$setListener$5$MineFragment(View view2) {
        startActivity(new Intent(getActivity(), AccountActivity.class));
    }

    public /* synthetic */ void lambda$setListener$6$MineFragment(View view2) {
        this.parent.startActivity(new Intent(this.parent, DeviceManageActivity.class));
    }

    public /* synthetic */ void lambda$setListener$7$MineFragment(View view2) {
        startActivity(new Intent(getActivity(), MoreActivity.class));
    }

    public /* synthetic */ void lambda$setListener$8$MineFragment(DialogInterface dialogInterface, int i2) {
        logout();
    }

    public /* synthetic */ void lambda$setListener$9$MineFragment(View view2) {
        new AlertDialog.Builder(getActivity()).setMessage(this.parent.getString(R.string.newui_logout)).setPositiveButton(this.parent.getString(R.string.sure), new DialogInterface.OnClickListener() {
            public final void onClick(DialogInterface dialogInterface, int i2) {
                MineFragment.this.lambda$setListener$8$MineFragment(dialogInterface, i2);
            }
        }).setNeutralButton(this.parent.getString(R.string.cancel), (DialogInterface.OnClickListener) null).create().show();
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.parent = (HostManagerActivity) activity;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.mine_fragment_layout, (ViewGroup) null);
        this.view = inflate;
        return inflate;
    }

    public void onPause() {
        super.onPause();
    }

    public void onResume() {
        super.onResume();
        initView(this.view);
        setListener();
        setDataToView();
        b.a().a("VERSION_USB").b(this, new t<Object>() {
            public void onChanged(Object obj) {
                MineFragment.this.tv_id.setText(((h) obj).a());
            }
        });
    }

    public void regError(int i2, String str) {
        Log.i("ServeTest", "regError: ======mine===" + str + "==type==" + i2);
        if (str.equalsIgnoreCase("HTTP 500 Internal Server Error")) {
            HostManagerActivity hostManagerActivity = this.parent;
            ToastHelper.showToast((Context) hostManagerActivity, hostManagerActivity.getString(R.string.login_timeout_warn));
        }
    }

    public void regFailure(int i2) {
    }

    public void regSuccess(int i2, Object obj) {
        String str;
        String str2;
        if (i2 != 7) {
            if (i2 == 9) {
                if (getActivity() != null) {
                    getActivity().runOnUiThread(new Runnable() {
                        public void run() {
                            MineFragment.this.iv_avatar.setImageBitmap(c.b(MineFragment.this.f23801info.getIconPath()));
                        }
                    });
                }
                if (obj instanceof UserInfoAcceptBeans) {
                    final UserInfoBeans data = ((UserInfoAcceptBeans) obj).getData();
                    if (!data.getNickname().equals(this.f23801info.getUserName())) {
                        UserLiteHelper.updateUserName(this.f23801info.getUid(), data.getAccount(), new SaveCallback() {
                            public void onFinish(boolean z2) {
                            }
                        });
                    }
                    this.tv_name.post(new Runnable() {
                        public void run() {
                            MineFragment.this.tv_name.setText(data.getNickname());
                        }
                    });
                }
            } else if (i2 == 27 && (obj instanceof ServiceBeans)) {
                ServiceBeans serviceBeans = (ServiceBeans) obj;
                Intent intent = new Intent(this.parent, SobotWebViewActivity.class);
                Log.i("ServeTest", "regSuccess:===html url=== " + serviceBeans.getOnline_service());
                intent.putExtra("address", serviceBeans.getOnline_service());
                this.parent.startActivity(intent);
            }
        } else if (obj instanceof ListenerListBeans) {
            ListenerListBeans listenerListBeans = (ListenerListBeans) obj;
            this.llb = listenerListBeans;
            if (listenerListBeans.getData().getTotalMileage() >= 1000.0f) {
                str = String.format(Locale.US, "%.1fkm", new Object[]{Float.valueOf(this.llb.getData().getTotalMileage() / 1000.0f)});
            } else {
                str = String.format(Locale.US, "%.1fm", new Object[]{Float.valueOf(this.llb.getData().getTotalMileage())});
            }
            this.totalMiles = str;
            if (this.llb.getData().getTotalFlightTime() >= 3600.0f) {
                str2 = String.format(Locale.US, "%.1fh", new Object[]{Float.valueOf(this.llb.getData().getTotalFlightTime() / 3600.0f)});
            } else {
                str2 = String.format(Locale.US, "%.1fs", new Object[]{Float.valueOf(this.llb.getData().getTotalFlightTime())});
            }
            this.totalDuration = str2;
            UserLiteHelper.getTotalFlightData(new FindCallback<ListenerTotalData>() {
                public void onFinish(ListenerTotalData listenerTotalData) {
                    if (listenerTotalData == null) {
                        UserLiteHelper.saveTotalFlightData(MineFragment.this.llb.getData().getTotalDegree() + "", MineFragment.this.totalMiles, MineFragment.this.totalDuration);
                        return;
                    }
                    UserLiteHelper.updateTotalFlightData(1, MineFragment.this.llb.getData().getTotalDegree() + "", MineFragment.this.totalMiles, MineFragment.this.totalDuration);
                }
            });
            this.parent.runOnUiThread(new Runnable() {
                public void run() {
                    int i2;
                    MineFragment mineFragment;
                    TextView textView;
                    int i3;
                    MineFragment mineFragment2;
                    TextView textView2;
                    MineFragment.this.tv_fly_duration.setText(MineFragment.this.totalDuration);
                    if (MineFragment.this.totalDuration.contains(fx.f8866g)) {
                        textView = MineFragment.this.tv_duration_unit;
                        mineFragment = MineFragment.this;
                        i2 = R.string.newui_duration_h;
                    } else {
                        textView = MineFragment.this.tv_duration_unit;
                        mineFragment = MineFragment.this;
                        i2 = R.string.newui_duration_s;
                    }
                    textView.setText(mineFragment.getString(i2));
                    MineFragment.this.tv_fly_mileage.setText(MineFragment.this.totalMiles);
                    if (MineFragment.this.totalMiles.contains("km")) {
                        textView2 = MineFragment.this.tv_mileage_unit;
                        mineFragment2 = MineFragment.this;
                        i3 = R.string.newui_mileage_km;
                    } else {
                        textView2 = MineFragment.this.tv_mileage_unit;
                        mineFragment2 = MineFragment.this;
                        i3 = R.string.newui_mileage_m;
                    }
                    textView2.setText(mineFragment2.getString(i3));
                    MineFragment.this.tv_fly_num.setText(String.valueOf(MineFragment.this.llb.getData().getTotalDegree()));
                }
            });
        }
    }
}
