package com.xeagle.android.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import ci.a;
import com.amap.api.mapcore.util.fx;
import com.cfly.uav_pro.R;
import com.flypro.core.database.ListenerInfoBeans;
import com.flypro.core.database.ListenerTotalData;
import com.flypro.core.database.UploadData;
import com.flypro.core.database.UserInfo;
import com.flypro.core.database.UserLiteHelper;
import com.flypro.core.util.e;
import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.dialogs.d;
import com.xeagle.android.login.beans.ListenerDataBean;
import com.xeagle.android.login.beans.ListenerListBeans;
import com.xeagle.android.login.beans.UploadAcceptBeans;
import com.xeagle.android.login.common.ListenerStickView;
import com.xeagle.android.login.common.ToastHelper;
import com.xeagle.android.login.common.UI;
import com.xeagle.android.login.listener.ListenerMapActivity;
import com.xeagle.android.login.retrofitLogin.RegContract;
import com.xeagle.android.login.retrofitLogin.RegPresenter;
import com.xeagle.android.login.retrofitLogin.UploadCallBack;
import com.xeagle.android.login.retrofitLogin.UserGlobal;
import com.xeagle.android.utils.c;
import com.xeagle.android.utils.prefs.a;
import fg.i;
import ja.j;
import java.io.File;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import kk.b;
import okhttp3.aa;
import okhttp3.v;
import org.litepal.crud.callback.FindCallback;
import org.litepal.crud.callback.FindMultiCallback;
import org.litepal.crud.callback.SaveCallback;
import org.litepal.crud.callback.UpdateOrDeleteCallback;
import retrofit2.Call;
import retrofit2.Response;

public class FlightListenerActivity extends UI implements RegContract.lLoadView {
    private static final int UPDATE_DATA = 3;
    /* access modifiers changed from: private */
    public d checkWifiDlg;
    /* access modifiers changed from: private */
    public int clickPosition;
    /* access modifiers changed from: private */
    public int currentPage = 1;
    private ListenerDataBean dataBean;
    /* access modifiers changed from: private */
    public File file;
    /* access modifiers changed from: private */
    public b flyRecordAdapter;
    /* access modifiers changed from: private */
    public e function;
    /* access modifiers changed from: private */
    public ArrayList<ListenerInfoBeans> infoDatas;
    /* access modifiers changed from: private */
    public boolean isUpload;
    private int lastLoadDataItemPosition;
    /* access modifiers changed from: private */
    public ListenerListBeans llb;
    private int maxPage = 1;
    /* access modifiers changed from: private */
    public a prefs;
    /* access modifiers changed from: private */
    public RegPresenter presenter;
    private RecyclerView recyclerview;
    /* access modifiers changed from: private */
    public SmartRefreshLayout refreshLayout;
    /* access modifiers changed from: private */
    public String totalDuration;
    /* access modifiers changed from: private */
    public String totalMiles;
    private TextView tv_back;
    /* access modifiers changed from: private */
    public TextView tv_duration_unit;
    /* access modifiers changed from: private */
    public TextView tv_fly_duration;
    /* access modifiers changed from: private */
    public TextView tv_fly_mileage;
    /* access modifiers changed from: private */
    public TextView tv_fly_num;
    /* access modifiers changed from: private */
    public TextView tv_mileage_unit;

    private void initView() {
        this.infoDatas = new ArrayList<>();
        this.prefs.l(false);
        this.tv_back = (TextView) findViewById(R.id.tv_back);
        this.tv_fly_num = (TextView) findViewById(R.id.tv_fly_num);
        this.tv_fly_mileage = (TextView) findViewById(R.id.tv_fly_mileage);
        this.tv_fly_duration = (TextView) findViewById(R.id.tv_fly_duration);
        this.tv_duration_unit = (TextView) findViewById(R.id.tv_duration_unit);
        this.tv_mileage_unit = (TextView) findViewById(R.id.tv_mileage_unit);
        this.refreshLayout = (SmartRefreshLayout) findViewById(R.id.refreshLayout);
        this.recyclerview = (RecyclerView) findViewById(R.id.recyclerview);
        b bVar = new b(R.layout.newui_fly_record_item_layout, new ArrayList());
        this.flyRecordAdapter = bVar;
        this.recyclerview.setAdapter(bVar);
        this.flyRecordAdapter.setOnItemClickListener(new a.c() {
            public void onItemClick(ci.a aVar, View view, final int i2) {
                int i3;
                FlightListenerActivity flightListenerActivity;
                int unused = FlightListenerActivity.this.clickPosition = i2;
                if (!((ListenerInfoBeans) FlightListenerActivity.this.infoDatas.get(i2)).getName().contains(".txt")) {
                    FlightListenerActivity flightListenerActivity2 = FlightListenerActivity.this;
                    File unused2 = flightListenerActivity2.file = new File(kx.d.d(FlightListenerActivity.this.getApplicationContext()) + ((ListenerInfoBeans) FlightListenerActivity.this.infoDatas.get(i2)).getName() + ".txt");
                } else {
                    FlightListenerActivity flightListenerActivity3 = FlightListenerActivity.this;
                    File unused3 = flightListenerActivity3.file = new File(kx.d.d(FlightListenerActivity.this.getApplicationContext()) + ((ListenerInfoBeans) FlightListenerActivity.this.infoDatas.get(i2)).getName());
                }
                if (FlightListenerActivity.this.file.exists()) {
                    if (((ListenerInfoBeans) FlightListenerActivity.this.infoDatas.get(i2)).isUpload()) {
                        Intent intent = new Intent(FlightListenerActivity.this, ListenerMapActivity.class);
                        intent.putExtra("listenerPath", FlightListenerActivity.this.file.getPath());
                        intent.putExtra("mileage", ((ListenerInfoBeans) FlightListenerActivity.this.infoDatas.get(i2)).getMileage());
                        FlightListenerActivity.this.startActivity(intent);
                    } else if (!FlightListenerActivity.this.function.a(FlightListenerActivity.this.getApplicationContext())) {
                        if (FlightListenerActivity.this.checkWifiDlg == null) {
                            FlightListenerActivity flightListenerActivity4 = FlightListenerActivity.this;
                            d unused4 = flightListenerActivity4.checkWifiDlg = d.a(flightListenerActivity4.getString(R.string.warning), FlightListenerActivity.this.getString(R.string.upload_no_wifi), new d.a() {
                                public void onNo() {
                                    Intent intent = new Intent(FlightListenerActivity.this, ListenerMapActivity.class);
                                    intent.putExtra("listenerPath", FlightListenerActivity.this.file.getPath());
                                    intent.putExtra("mileage", ((ListenerInfoBeans) FlightListenerActivity.this.infoDatas.get(i2)).getMileage());
                                    FlightListenerActivity.this.startActivity(intent);
                                }

                                public void onYes() {
                                    FlightListenerActivity.this.startActivity(new Intent("android.settings.WIFI_SETTINGS"));
                                }
                            });
                        }
                        if (!FlightListenerActivity.this.checkWifiDlg.isAdded()) {
                            FlightListenerActivity.this.checkWifiDlg.show(FlightListenerActivity.this.getSupportFragmentManager(), "checkWif");
                        }
                    } else {
                        final String name = ((ListenerInfoBeans) FlightListenerActivity.this.infoDatas.get(i2)).getName();
                        UserLiteHelper.findUploadDataByFileName(name, new FindCallback<UploadData>() {
                            public void onFinish(UploadData uploadData) {
                                UserInfo userInfo;
                                if (uploadData != null && (userInfo = UserLiteHelper.getUserInfo(FlightListenerActivity.this.prefs.aE())) != null && !FlightListenerActivity.this.isUpload) {
                                    boolean unused = FlightListenerActivity.this.isUpload = true;
                                    HashMap hashMap = new HashMap();
                                    String str = kx.d.d(FlightListenerActivity.this.getApplicationContext()) + name;
                                    hashMap.put("token", FlightListenerActivity.this.toRequestBody(userInfo.getToken()));
                                    hashMap.put("flying_off", FlightListenerActivity.this.toRequestBody(uploadData.getFlying_off()));
                                    hashMap.put("fly_total_time", FlightListenerActivity.this.toRequestBody(uploadData.getFly_total_time()));
                                    hashMap.put("mileage", FlightListenerActivity.this.toRequestBody(uploadData.getMileage()));
                                    Log.i("ServeTest", "onFinish:===== " + name + "===" + uploadData.getDroneSn() + "===" + uploadData.getBatterySn());
                                    if (uploadData.getDroneSn() != null) {
                                        hashMap.put("drone_sn", FlightListenerActivity.this.toRequestBody(uploadData.getDroneSn()));
                                    }
                                    if (uploadData.getBatterySn() != null) {
                                        hashMap.put("battery_sn", FlightListenerActivity.this.toRequestBody(uploadData.getBatterySn()));
                                    }
                                    FlightListenerActivity.this.presenter.uploadFile(UserGlobal.BASE_URL, str, hashMap, new UploadCallBack<UploadAcceptBeans>() {
                                        public void onFailure(Call<UploadAcceptBeans> call, Throwable th) {
                                            boolean unused = FlightListenerActivity.this.isUpload = false;
                                            Intent intent = new Intent(FlightListenerActivity.this, ListenerMapActivity.class);
                                            intent.putExtra("listenerPath", FlightListenerActivity.this.file.getPath());
                                            intent.putExtra("mileage", ((ListenerInfoBeans) FlightListenerActivity.this.infoDatas.get(i2)).getMileage());
                                            FlightListenerActivity.this.startActivity(intent);
                                        }

                                        public void onSuccess(Call<UploadAcceptBeans> call, Response<UploadAcceptBeans> response) {
                                            ((ListenerInfoBeans) FlightListenerActivity.this.infoDatas.get(i2)).setUpload(true);
                                            UserLiteHelper.deleteUploadDataByName(name, new UpdateOrDeleteCallback() {
                                                public void onFinish(int i2) {
                                                    boolean unused = FlightListenerActivity.this.isUpload = false;
                                                }
                                            });
                                            Intent intent = new Intent(FlightListenerActivity.this, ListenerMapActivity.class);
                                            intent.putExtra("listenerPath", FlightListenerActivity.this.file.getPath());
                                            intent.putExtra("mileage", ((ListenerInfoBeans) FlightListenerActivity.this.infoDatas.get(i2)).getMileage());
                                            FlightListenerActivity.this.startActivity(intent);
                                        }
                                    });
                                }
                            }
                        });
                    }
                } else if (((ListenerInfoBeans) FlightListenerActivity.this.infoDatas.get(i2)).isUpload() && FlightListenerActivity.this.llb != null) {
                    UserInfo userInfo = UserLiteHelper.getUserInfo(FlightListenerActivity.this.prefs.aE());
                    if (userInfo == null || userInfo.getToken() == null) {
                        flightListenerActivity = FlightListenerActivity.this;
                        i3 = R.string.down_failed;
                    } else if (FlightListenerActivity.this.function.a(FlightListenerActivity.this.getApplicationContext())) {
                        FlightListenerActivity.this.presenter.downloadListener(UserGlobal.BASE_URL, userInfo.getToken(), ((ListenerInfoBeans) FlightListenerActivity.this.infoDatas.get(i2)).getId());
                        return;
                    } else {
                        flightListenerActivity = FlightListenerActivity.this;
                        i3 = R.string.connect_internet_download;
                    }
                    ToastHelper.showToast((Context) flightListenerActivity, flightListenerActivity.getString(i3));
                }
            }
        });
        this.recyclerview.setLayoutManager(new LinearLayoutManager(this, 1, false));
        setListener();
        loadData();
        this.refreshLayout.a((jb.d) new jb.d() {
            public void onRefresh(j jVar) {
                int unused = FlightListenerActivity.this.currentPage = 1;
                FlightListenerActivity.this.loadData();
            }
        });
        this.refreshLayout.a((jb.b) new jb.b() {
            public final void onLoadMore(j jVar) {
                FlightListenerActivity.this.lambda$initView$0$FlightListenerActivity(jVar);
            }
        });
    }

    /* access modifiers changed from: private */
    public void loadData() {
        ka.a.a().b().execute(new Runnable() {
            public void run() {
                if (FlightListenerActivity.this.function.a(FlightListenerActivity.this.getApplicationContext())) {
                    Log.i("newUI", "loadData:----current page--- " + FlightListenerActivity.this.currentPage);
                    UserInfo userInfo = UserLiteHelper.getUserInfo(FlightListenerActivity.this.prefs.aE());
                    if (userInfo != null) {
                        HashMap hashMap = new HashMap();
                        hashMap.put("token", userInfo.getToken());
                        hashMap.put("page", String.valueOf(FlightListenerActivity.this.currentPage));
                        FlightListenerActivity.this.presenter.requestListenerList(UserGlobal.BASE_URL, hashMap);
                        return;
                    }
                    return;
                }
                UserLiteHelper.getTotalFlightData(new FindCallback<ListenerTotalData>() {
                    public void onFinish(final ListenerTotalData listenerTotalData) {
                        if (listenerTotalData != null) {
                            FlightListenerActivity.this.runOnUiThread(new Runnable() {
                                public void run() {
                                    int i2;
                                    FlightListenerActivity flightListenerActivity;
                                    TextView textView;
                                    int i3;
                                    FlightListenerActivity flightListenerActivity2;
                                    TextView textView2;
                                    FlightListenerActivity.this.tv_fly_duration.setText(listenerTotalData.getTotalFlightTime());
                                    if (listenerTotalData.getTotalFlightTime().contains(fx.f8866g)) {
                                        textView = FlightListenerActivity.this.tv_duration_unit;
                                        flightListenerActivity = FlightListenerActivity.this;
                                        i2 = R.string.newui_duration_h;
                                    } else {
                                        textView = FlightListenerActivity.this.tv_duration_unit;
                                        flightListenerActivity = FlightListenerActivity.this;
                                        i2 = R.string.newui_duration_s;
                                    }
                                    textView.setText(flightListenerActivity.getString(i2));
                                    FlightListenerActivity.this.tv_fly_mileage.setText(listenerTotalData.getTotalMileage());
                                    if (listenerTotalData.getTotalMileage().contains("km")) {
                                        textView2 = FlightListenerActivity.this.tv_mileage_unit;
                                        flightListenerActivity2 = FlightListenerActivity.this;
                                        i3 = R.string.newui_mileage_km;
                                    } else {
                                        textView2 = FlightListenerActivity.this.tv_mileage_unit;
                                        flightListenerActivity2 = FlightListenerActivity.this;
                                        i3 = R.string.newui_mileage_m;
                                    }
                                    textView2.setText(flightListenerActivity2.getString(i3));
                                    FlightListenerActivity.this.tv_fly_num.setText(listenerTotalData.getTotalDegree());
                                }
                            });
                        }
                    }
                });
                UserLiteHelper.getKnownListenerList(new UserLiteHelper.GetKnownListenerListCallback() {
                    public void getKnownListenrListCallback(final ArrayList<ListenerInfoBeans> arrayList) {
                        UserLiteHelper.getUploadListener(new FindMultiCallback<UploadData>() {
                            public void onFinish(List<UploadData> list) {
                                FlightListenerActivity.this.infoDatas.clear();
                                if (list != null && list.size() > 0) {
                                    for (int i2 = 0; i2 < list.size(); i2++) {
                                        ListenerInfoBeans listenerInfoBeans = new ListenerInfoBeans();
                                        Log.i("newUI", "onFinish:===size=== " + list.size() + "==name===" + list.get(i2).getFileName());
                                        listenerInfoBeans.setFly_total_time(list.get(i2).getFly_total_time());
                                        listenerInfoBeans.setFlying_off(list.get(i2).getFlying_off());
                                        try {
                                            listenerInfoBeans.setMileage(BigDecimal.valueOf(Double.parseDouble(list.get(i2).getMileage())).setScale(1, 4).doubleValue());
                                        } catch (NumberFormatException unused) {
                                            listenerInfoBeans.setMileage(i.f27244a);
                                        }
                                        listenerInfoBeans.setName(list.get(i2).getFileName());
                                        listenerInfoBeans.setUpload(false);
                                        FlightListenerActivity.this.infoDatas.add(listenerInfoBeans);
                                    }
                                }
                                ArrayList arrayList = arrayList;
                                if (arrayList != null && arrayList.size() > 0) {
                                    FlightListenerActivity.this.infoDatas.addAll(arrayList);
                                }
                                if (FlightListenerActivity.this.flyRecordAdapter != null) {
                                    FlightListenerActivity.this.flyRecordAdapter.replaceData(FlightListenerActivity.this.infoDatas);
                                }
                            }
                        });
                    }
                });
            }
        });
    }

    private void setListener() {
        this.tv_back.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                FlightListenerActivity.this.lambda$setListener$1$FlightListenerActivity(view);
            }
        });
    }

    /* access modifiers changed from: private */
    public aa toRequestBody(String str) {
        return aa.create(v.b("text/plain"), str);
    }

    public /* synthetic */ void lambda$initView$0$FlightListenerActivity(j jVar) {
        int i2 = this.currentPage;
        if (i2 < this.maxPage) {
            this.currentPage = i2 + 1;
            loadData();
            return;
        }
        ToastHelper.showToast((Context) this, getString(R.string.reached_the_bottom));
        this.flyRecordAdapter.notifyDataSetChanged();
        this.refreshLayout.a(1000, true, (Boolean) true);
    }

    public /* synthetic */ void lambda$setListener$1$FlightListenerActivity(View view) {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().setFlags(1024, 1024);
        requestWindowFeature(1);
        setContentView((int) R.layout.flight_listener_activity);
        this.prefs = ((XEagleApp) getApplication()).j();
        this.presenter = new RegPresenter(this);
        this.function = new e(getApplicationContext());
        initView();
    }

    public void regError(int i2, String str) {
        Log.i("ServeTest", "regError:---" + i2 + "--- " + str);
    }

    public void regFailure(int i2) {
    }

    public void regSuccess(int i2, Object obj) {
        String str;
        String str2;
        if (i2 == 7) {
            if (obj instanceof ListenerListBeans) {
                ListenerListBeans listenerListBeans = (ListenerListBeans) obj;
                this.llb = listenerListBeans;
                this.maxPage = listenerListBeans.getData().getLastPage();
                Log.i("newUI", "regSuccess: --maxpage--" + this.maxPage);
                this.dataBean = this.llb.getData();
                if (this.llb.getData().getCurrentPage() == 1) {
                    Log.i("newUI", "regSuccess: ---refresh");
                    this.infoDatas.clear();
                    UserLiteHelper.getUploadListener(new FindMultiCallback<UploadData>() {
                        public void onFinish(List<UploadData> list) {
                            if (list != null && list.size() > 0) {
                                for (int i2 = 0; i2 < list.size(); i2++) {
                                    try {
                                        ListenerInfoBeans listenerInfoBeans = new ListenerInfoBeans();
                                        listenerInfoBeans.setFly_total_time(list.get(i2).getFly_total_time());
                                        listenerInfoBeans.setFlying_off(list.get(i2).getFlying_off());
                                        listenerInfoBeans.setMileage(Double.parseDouble(list.get(i2).getMileage()));
                                        listenerInfoBeans.setName(list.get(i2).getFileName());
                                        listenerInfoBeans.setUpload(false);
                                        FlightListenerActivity.this.infoDatas.add(listenerInfoBeans);
                                    } catch (NumberFormatException e2) {
                                        e2.printStackTrace();
                                    }
                                }
                            }
                            FlightListenerActivity.this.infoDatas.addAll(FlightListenerActivity.this.llb.getData().getData());
                            UserLiteHelper.deleteAllListenerList();
                            UserLiteHelper.saveNewList(FlightListenerActivity.this.llb.getData().getData(), (SaveCallback) null);
                            if (FlightListenerActivity.this.flyRecordAdapter != null) {
                                FlightListenerActivity.this.flyRecordAdapter.replaceData(FlightListenerActivity.this.infoDatas);
                                FlightListenerActivity.this.refreshLayout.g(true);
                            }
                        }
                    });
                } else {
                    Log.i("newUI", "regSuccess:---add data 0000000");
                    if (!this.infoDatas.contains(this.llb.getData().getData().get(0))) {
                        Log.i("newUI", "regSuccess:---add data ");
                        this.infoDatas.addAll(this.llb.getData().getData());
                        this.flyRecordAdapter.addData(this.llb.getData().getData());
                        UserLiteHelper.saveNewList(this.llb.getData().getData(), (SaveCallback) null);
                        this.refreshLayout.c((int) ListenerStickView.RC_TRIM);
                    }
                }
                if (this.llb.getData().getTotalMileage() >= 1000.0f) {
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
                            UserLiteHelper.saveTotalFlightData(FlightListenerActivity.this.llb.getData().getTotalDegree() + "", FlightListenerActivity.this.totalMiles, FlightListenerActivity.this.totalDuration);
                            return;
                        }
                        UserLiteHelper.updateTotalFlightData(1, FlightListenerActivity.this.llb.getData().getTotalDegree() + "", FlightListenerActivity.this.totalMiles, FlightListenerActivity.this.totalDuration);
                    }
                });
                runOnUiThread(new Runnable() {
                    public void run() {
                        int i2;
                        FlightListenerActivity flightListenerActivity;
                        TextView textView;
                        int i3;
                        FlightListenerActivity flightListenerActivity2;
                        TextView textView2;
                        FlightListenerActivity.this.tv_fly_duration.setText(FlightListenerActivity.this.totalDuration);
                        if (FlightListenerActivity.this.totalDuration.contains(fx.f8866g)) {
                            textView = FlightListenerActivity.this.tv_duration_unit;
                            flightListenerActivity = FlightListenerActivity.this;
                            i2 = R.string.newui_duration_h;
                        } else {
                            textView = FlightListenerActivity.this.tv_duration_unit;
                            flightListenerActivity = FlightListenerActivity.this;
                            i2 = R.string.newui_duration_s;
                        }
                        textView.setText(flightListenerActivity.getString(i2));
                        FlightListenerActivity.this.tv_fly_mileage.setText(FlightListenerActivity.this.totalMiles);
                        if (FlightListenerActivity.this.totalMiles.contains("km")) {
                            textView2 = FlightListenerActivity.this.tv_mileage_unit;
                            flightListenerActivity2 = FlightListenerActivity.this;
                            i3 = R.string.newui_mileage_km;
                        } else {
                            textView2 = FlightListenerActivity.this.tv_mileage_unit;
                            flightListenerActivity2 = FlightListenerActivity.this;
                            i3 = R.string.newui_mileage_m;
                        }
                        textView2.setText(flightListenerActivity2.getString(i3));
                        FlightListenerActivity.this.tv_fly_num.setText(String.valueOf(FlightListenerActivity.this.llb.getData().getTotalDegree()));
                    }
                });
                UserLiteHelper.updateUserFlight(this.prefs.aE(), this.llb.getData().getTotalFlightTime(), this.llb.getData().getTotalMileage(), this.llb.getData().getTotalMileage(), new SaveCallback() {
                    public void onFinish(boolean z2) {
                        Log.i("newUI", "onFinish:-----已更新最新数据 ");
                    }
                });
                return;
            }
            Log.i("newUI", "regSuccess:----getList--- " + obj.toString());
        } else if (i2 == 8) {
            byte[] bArr = (byte[]) obj;
            if (this.llb != null) {
                final String str3 = kx.d.d(getApplicationContext()) + this.infoDatas.get(this.clickPosition).getName() + ".txt";
                c.a(bArr, str3, (c.C0151c) new c.C0151c() {
                    public void writeFail(String str) {
                        FlightListenerActivity flightListenerActivity = FlightListenerActivity.this;
                        ToastHelper.showToast((Context) flightListenerActivity, FlightListenerActivity.this.getString(R.string.download_failed) + str);
                    }

                    public void writeSuccess() {
                        Intent intent = new Intent(FlightListenerActivity.this, ListenerMapActivity.class);
                        intent.putExtra("listenerPath", str3);
                        intent.putExtra("mileage", ((ListenerInfoBeans) FlightListenerActivity.this.infoDatas.get(FlightListenerActivity.this.clickPosition)).getMileage());
                        FlightListenerActivity.this.startActivity(intent);
                    }
                });
            }
        }
    }
}
