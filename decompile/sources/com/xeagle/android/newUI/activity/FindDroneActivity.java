package com.xeagle.android.newUI.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.fragment.app.FragmentManager;
import com.blankj.utilcode.util.ToastUtils;
import com.cfly.uav_pro.R;
import com.flypro.core.database.ListenerInfoBeans;
import com.flypro.core.database.UserInfo;
import com.flypro.core.database.UserLiteHelper;
import com.flypro.core.drone.variables.ListenerData;
import com.flypro.core.util.e;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.camera.widgets.ablum.b;
import com.xeagle.android.login.beans.ListenerListBeans;
import com.xeagle.android.login.listener.ListenerReader;
import com.xeagle.android.login.listener.UploadListenerService;
import com.xeagle.android.login.retrofitLogin.RegContract;
import com.xeagle.android.login.retrofitLogin.RegPresenter;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.maps.providers.DPMapProvider;
import com.xeagle.android.newUI.fragment.FindDroneFragment;
import com.xeagle.android.utils.c;
import com.xeagle.android.utils.prefs.a;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import fg.i;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import jo.y;
import kx.d;
import org.greenrobot.eventbus.c;

public class FindDroneActivity extends BaseActivity implements View.OnClickListener, RegContract.lLoadView {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public FindDroneFragment f23849a;

    /* renamed from: b  reason: collision with root package name */
    private FragmentManager f23850b;

    /* renamed from: c  reason: collision with root package name */
    private e f23851c;

    /* renamed from: d  reason: collision with root package name */
    private IImageButton f23852d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public IButton f23853e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public ArrayList<ListenerData> f23854f;

    /* renamed from: g  reason: collision with root package name */
    private RegPresenter f23855g;

    /* renamed from: h  reason: collision with root package name */
    private a f23856h;

    /* renamed from: i  reason: collision with root package name */
    private ListenerListBeans f23857i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public String f23858j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public ListenerReader f23859k;

    /* renamed from: l  reason: collision with root package name */
    private en.a f23860l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public double f23861m;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public double f23862n;

    private void a() {
        String str;
        IButton iButton;
        this.f23852d = (IImageButton) findViewById(R.id.find_drone_close);
        this.f23853e = (IButton) findViewById(R.id.find_drone_map);
        this.f23852d.setOnClickListener(this);
        this.f23853e.setOnClickListener(this);
        if (b.b("pref_map_type", getString(R.string.menu_map_type_satellite)).equals(getString(R.string.menu_map_type_satellite))) {
            iButton = this.f23853e;
            str = "2D";
        } else {
            iButton = this.f23853e;
            str = "3D";
        }
        iButton.setText(str);
        findViewById(R.id.ib_open_map).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FindDroneActivity.this.b(view);
            }
        });
        findViewById(R.id.ib_open_file).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FindDroneActivity.this.a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void a(View view) {
        b();
    }

    /* access modifiers changed from: private */
    public void a(String str) {
        Log.i("TAG", "readFlightData: ===fileName====" + str);
        this.f23859k.openListener(str, this.f23860l, new ListenerReader.OnListenerParse() {
            public void onParseFail(String str) {
            }

            public void onParseSuccess() {
                FindDroneActivity findDroneActivity = FindDroneActivity.this;
                ArrayList unused = findDroneActivity.f23854f = findDroneActivity.f23859k.getListenerDatas();
                Log.i("newUI", "onParseSuccess:--- " + FindDroneActivity.this.f23854f.size());
                if (FindDroneActivity.this.f23854f.size() > 0) {
                    ListenerData listenerData = (ListenerData) FindDroneActivity.this.f23854f.get(FindDroneActivity.this.f23854f.size() - 1);
                    if (listenerData.h().e() || listenerData.h().d() == i.f27244a || listenerData.h().c() == i.f27244a) {
                        ToastUtils.showShort((CharSequence) FindDroneActivity.this.getString(R.string.find_drone_invalid));
                        return;
                    }
                    double unused2 = FindDroneActivity.this.f23861m = listenerData.h().d();
                    double unused3 = FindDroneActivity.this.f23862n = listenerData.h().c();
                    if (FindDroneActivity.this.f23849a != null) {
                        FindDroneActivity.this.f23849a.a(listenerData.h());
                    }
                }
            }
        });
    }

    private void b() {
        new jw.b(this.f23860l) {
            public void a(List<ListenerData> list) {
                FindDroneActivity findDroneActivity;
                int i2;
                if (list.size() > 0) {
                    double unused = FindDroneActivity.this.f23861m = list.get(list.size() - 1).h().d();
                    double unused2 = FindDroneActivity.this.f23862n = list.get(list.size() - 1).h().c();
                    if (FindDroneActivity.this.f23862n == i.f27244a || FindDroneActivity.this.f23861m == i.f27244a) {
                        findDroneActivity = FindDroneActivity.this;
                        i2 = R.string.find_drone_invalid;
                    } else if (FindDroneActivity.this.f23849a != null) {
                        FindDroneActivity.this.f23849a.a(list.get(list.size() - 1).h());
                        return;
                    } else {
                        return;
                    }
                } else {
                    findDroneActivity = FindDroneActivity.this;
                    i2 = R.string.listener_content_null;
                }
                ToastUtils.showShort((CharSequence) findDroneActivity.getString(i2));
            }
        }.a((Context) this);
    }

    /* access modifiers changed from: private */
    public /* synthetic */ void b(View view) {
        Intent intent = new Intent(this, SelectMapActivity.class);
        intent.putExtra("lat", this.f23861m);
        intent.putExtra("lng", this.f23862n);
        startActivity(intent);
    }

    private void b(String str) {
        if (!b.b("pref_maps_providers_key", DPMapProvider.GOOGLE_MAP.name()).equals(DPMapProvider.GOOGLE_MAP.name()) && !b.b("pref_maps_providers_key", DPMapProvider.GOOGLE_MAP.name()).equals(DPMapProvider.LBS_AMAP.name())) {
            if (b.b("pref_maps_providers_key", DPMapProvider.SYSTEM_LOC.name()).equalsIgnoreCase(DPMapProvider.SYSTEM_LOC.name())) {
                boolean equals = Locale.getDefault().getCountry().equals(Locale.CHINA.getCountry());
            } else {
                return;
            }
        }
        b.a("pref_map_type", str);
    }

    public void onClick(View view) {
        IButton iButton;
        Runnable runnable;
        switch (view.getId()) {
            case R.id.find_drone_close:
                finish();
                return;
            case R.id.find_drone_map:
                if (b.b("pref_map_type", getString(R.string.menu_map_type_satellite)).equals(getString(R.string.menu_map_type_satellite))) {
                    b(getString(R.string.menu_map_type_normal));
                    iButton = this.f23853e;
                    runnable = new Runnable() {
                        public void run() {
                            FindDroneActivity.this.f23853e.setText("3D");
                        }
                    };
                } else {
                    b(getString(R.string.menu_map_type_satellite));
                    iButton = this.f23853e;
                    runnable = new Runnable() {
                        public void run() {
                            FindDroneActivity.this.f23853e.setText("2D");
                        }
                    };
                }
                iButton.post(runnable);
                c.a().d(new y(true));
                return;
            default:
                return;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_find_drone);
        this.f23855g = new RegPresenter(this);
        this.f23851c = new e(getApplicationContext());
        a j2 = ((XEagleApp) getApplication()).j();
        this.f23856h = j2;
        j2.l(true);
        this.f23860l = ((XEagleApp) getApplication()).k();
        this.f23859k = new ListenerReader(this);
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.f23850b = supportFragmentManager;
        FindDroneFragment findDroneFragment = (FindDroneFragment) supportFragmentManager.d((int) R.id.mapFragment);
        this.f23849a = findDroneFragment;
        if (findDroneFragment == null) {
            this.f23849a = new FindDroneFragment();
        }
        this.f23850b.a().b(R.id.mapFragment, this.f23849a).d();
        a();
        startService(new Intent(this, UploadListenerService.class));
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f23851c.a(getApplicationContext())) {
            UserInfo userInfo = UserLiteHelper.getUserInfo(this.f23856h.aE());
            HashMap hashMap = new HashMap();
            hashMap.put("token", userInfo.getToken());
            hashMap.put("page", String.valueOf(1));
            this.f23855g.requestListenerList(UserGlobal.BASE_URL, hashMap);
            return;
        }
        ToastUtils.showLong((CharSequence) getString(R.string.check_wifi_available));
    }

    public void regError(int i2, String str) {
    }

    public void regFailure(int i2) {
    }

    public void regSuccess(int i2, Object obj) {
        if (i2 == 7) {
            if (obj instanceof ListenerListBeans) {
                ListenerListBeans listenerListBeans = (ListenerListBeans) obj;
                this.f23857i = listenerListBeans;
                if (listenerListBeans.getData() != null) {
                    ArrayList<ListenerInfoBeans> data = this.f23857i.getData().getData();
                    if (data.size() > 0) {
                        this.f23858j = data.get(0).getName();
                        int id2 = data.get(0).getId();
                        if (new File(d.d(getApplicationContext()) + this.f23858j + ".txt").exists()) {
                            a(d.d(getApplicationContext()) + this.f23858j + ".txt");
                            return;
                        }
                        UserInfo userInfo = UserLiteHelper.getUserInfo(this.f23856h.aE());
                        if (userInfo.getToken() != null) {
                            this.f23855g.downloadListener(UserGlobal.BASE_URL, userInfo.getToken(), id2);
                        }
                    }
                }
            }
        } else if (i2 == 8) {
            byte[] bArr = (byte[]) obj;
            if (this.f23857i != null) {
                com.xeagle.android.utils.c.a(bArr, d.d(getApplicationContext()) + this.f23858j + ".txt", (c.C0151c) new c.C0151c() {
                    public void writeFail(String str) {
                        ToastUtils.showShort((CharSequence) FindDroneActivity.this.getString(R.string.download_failed));
                    }

                    public void writeSuccess() {
                        FindDroneActivity findDroneActivity = FindDroneActivity.this;
                        findDroneActivity.a(findDroneActivity.f23858j);
                    }
                });
            }
        }
    }
}
