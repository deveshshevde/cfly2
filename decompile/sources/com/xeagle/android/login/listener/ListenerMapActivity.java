package com.xeagle.android.login.listener;

import android.content.Context;
import android.content.Intent;
import android.location.Address;
import android.location.Geocoder;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentManager;
import com.cfly.customeui.widget.b;
import com.cfly.uav_pro.R;
import com.flypro.core.drone.variables.ListenerData;
import com.flypro.core.util.d;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.login.FlightListenerActivity;
import com.xeagle.android.login.common.ListenerStickView;
import com.xeagle.android.login.common.TimeUtil;
import com.xeagle.android.login.common.ToastHelper;
import com.xeagle.android.login.event.ListenerIndexEvent;
import com.xeagle.android.login.listener.ListenerReader;
import com.xeagle.android.login.retrofitLogin.SimpleHttpClient;
import com.xeagle.android.maps.providers.DPMapProvider;
import com.xeagle.android.vjoystick.IWidgets.IImageButton;
import en.a;
import fg.i;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import jo.y;
import okhttp3.ab;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;

public class ListenerMapActivity extends AppCompatActivity implements View.OnClickListener, SeekBar.OnSeekBarChangeListener {
    double distance;
    private a drone;
    private String filePath;
    private int flightTime;
    private FragmentManager fragmentManager;
    private IImageButton ib_listener_play;
    private TextView ib_listener_speed;
    private IImageButton ib_listener_stick;
    private IImageButton ib_map_normal;
    private IImageButton ib_map_satellite;
    private IImageButton ib_map_select;
    /* access modifiers changed from: private */
    public int index = 0;
    private boolean isPlay;
    private boolean isShowMap;
    private boolean isShowStick;
    double lastDistance;
    private ef.a lastDroneCoord;
    private ListenerStickView left_stick;
    /* access modifiers changed from: private */
    public ArrayList<ListenerData> listenerDatas;
    /* access modifiers changed from: private */
    public ListenerMapFragment listenerMapFragment;
    Runnable listenerRunnable = new Runnable() {
        public void run() {
            ListenerMapActivity.this.playListener();
        }
    };
    private IImageButton listener_back;
    /* access modifiers changed from: private */
    public TextView listener_drone_gps;
    /* access modifiers changed from: private */
    public TextView listener_flight_bat;
    /* access modifiers changed from: private */
    public TextView listener_flight_gps;
    /* access modifiers changed from: private */
    public TextView listener_flight_mode;
    /* access modifiers changed from: private */
    public SeekBar listener_seek;
    private ConstraintLayout map_type_cl;
    private double mileage;
    /* access modifiers changed from: private */
    public ListenerReader reader;
    private double ret = 1.0d;
    private ListenerStickView right_stick;
    private int speedLevel = 1;
    private b tipListView;
    /* access modifiers changed from: private */
    public double totalMileage;
    /* access modifiers changed from: private */
    public TextView tv_listener_alt;
    /* access modifiers changed from: private */
    public TextView tv_listener_area;
    /* access modifiers changed from: private */
    public TextView tv_listener_date;
    /* access modifiers changed from: private */
    public TextView tv_listener_distance;
    /* access modifiers changed from: private */
    public TextView tv_listener_hs;
    /* access modifiers changed from: private */
    public TextView tv_listener_mileage_value;
    /* access modifiers changed from: private */
    public TextView tv_listener_time_value;
    /* access modifiers changed from: private */
    public TextView tv_listener_vs;
    private Handler watchDog = new Handler();

    /* access modifiers changed from: private */
    public String getCurrentMode(String str) {
        if (!d.c(str)) {
            return str;
        }
        str.hashCode();
        char c2 = 65535;
        switch (str.hashCode()) {
            case 50:
                if (str.equals("2")) {
                    c2 = 0;
                    break;
                }
                break;
            case 51:
                if (str.equals("3")) {
                    c2 = 1;
                    break;
                }
                break;
            case 52:
                if (str.equals("4")) {
                    c2 = 2;
                    break;
                }
                break;
            case 53:
                if (str.equals("5")) {
                    c2 = 3;
                    break;
                }
                break;
            case 54:
                if (str.equals("6")) {
                    c2 = 4;
                    break;
                }
                break;
            case 55:
                if (str.equals("7")) {
                    c2 = 5;
                    break;
                }
                break;
            case 57:
                if (str.equals("9")) {
                    c2 = 6;
                    break;
                }
                break;
            case 1573:
                if (str.equals("16")) {
                    c2 = 7;
                    break;
                }
                break;
        }
        int i2 = R.string.spinner_mode_loiter;
        switch (c2) {
            case 0:
                i2 = R.string.spinner_mode_althold;
                break;
            case 1:
                i2 = R.string.auto_flight_mode;
                break;
            case 2:
                i2 = R.string.spinner_mode_follow;
                break;
            case 4:
                i2 = R.string.spinner_mode_rth;
                break;
            case 5:
                i2 = R.string.spinner_mode_circle;
                break;
            case 6:
                i2 = R.string.spinner_mode_land;
                break;
            case 7:
                getString(R.string.spinner_mode_shot);
                return "";
        }
        return getString(i2);
    }

    private void handleGoogleAddress(final ef.a aVar, TextView textView) {
        ka.a.a().b().execute(new Runnable() {
            public void run() {
                StringBuilder sb = new StringBuilder();
                sb.append("http://maps.googleapis.com/maps/api/geocode/json?latlng=");
                sb.append(aVar.d());
                sb.append(",");
                sb.append(aVar.c());
                sb.append("&language=");
                sb.append(Locale.getDefault());
                sb.append("&sensor=false");
                Log.i("TAG", "run:===google url=== " + sb);
                SimpleHttpClient.getInstance().getRequest(sb.toString(), new SimpleHttpClient.RequestCallBack() {
                    public void onFail(IOException iOException) {
                        Log.i("TAG", "onFail:---geo-== " + iOException.getMessage());
                    }

                    public void onSuccess(ab abVar) {
                        Log.i("TAG", "onSuccess: ---geo-== ===" + abVar.toString());
                    }
                });
            }
        });
    }

    private void handleMapType(String str) {
        if (!com.xeagle.android.camera.widgets.ablum.b.b("pref_maps_providers_key", DPMapProvider.GOOGLE_MAP.name()).equals(DPMapProvider.GOOGLE_MAP.name()) && !com.xeagle.android.camera.widgets.ablum.b.b("pref_maps_providers_key", DPMapProvider.GOOGLE_MAP.name()).equals(DPMapProvider.LBS_AMAP.name())) {
            if (com.xeagle.android.camera.widgets.ablum.b.b("pref_maps_providers_key", DPMapProvider.SYSTEM_LOC.name()).equalsIgnoreCase(DPMapProvider.SYSTEM_LOC.name())) {
                boolean equals = Locale.getDefault().getCountry().equals(Locale.CHINA.getCountry());
            } else {
                return;
            }
        }
        com.xeagle.android.camera.widgets.ablum.b.a("pref_map_type", str);
    }

    /* access modifiers changed from: private */
    public void handleSystemAddress(final ef.a aVar) {
        ka.a.a().b().execute(new Runnable() {
            public void run() {
                Geocoder geocoder = new Geocoder(ListenerMapActivity.this, Locale.getDefault());
                try {
                    Log.i("Map", "onParseSuccess:==== 11111111");
                    if (aVar.d() != i.f27244a) {
                        if (aVar.c() != i.f27244a) {
                            Log.i("TAG", "onParseSuccess:==== 6666====" + aVar.d() + "===lng===" + aVar.c());
                            List<Address> fromLocation = geocoder.getFromLocation(aVar.d(), aVar.c(), 1);
                            StringBuilder sb = new StringBuilder();
                            sb.append("onParseSuccess:==== 33333===");
                            sb.append(fromLocation.size());
                            Log.i("Map", sb.toString());
                            if (fromLocation.size() > 0) {
                                final Address address = fromLocation.get(0);
                                Log.i("Map", "onParseSuccess:==== 444444===" + address.getLocality());
                                ListenerMapActivity.this.tv_listener_area.post(new Runnable() {
                                    public void run() {
                                        ListenerMapActivity.this.tv_listener_area.setText(address.getLocality());
                                    }
                                });
                                return;
                            }
                            return;
                        }
                    }
                    Log.i("Map", "onParseSuccess:==== 222222222");
                } catch (IOException e2) {
                    Log.i("TAG", "onParseSuccess:==== 555555===" + e2.getMessage());
                    e2.printStackTrace();
                }
            }
        });
    }

    private void initView() {
        this.lastDroneCoord = new ef.a(i.f27244a, i.f27244a);
        this.tipListView = new b(this, (LinearLayout) findViewById(R.id.ll_tip_layout));
        this.listener_back = (IImageButton) findViewById(R.id.listener_back);
        this.listener_flight_mode = (TextView) findViewById(R.id.listener_flight_mode);
        this.listener_flight_gps = (TextView) findViewById(R.id.listener_flight_gps);
        this.listener_flight_bat = (TextView) findViewById(R.id.listener_flight_bat);
        this.tv_listener_date = (TextView) findViewById(R.id.tv_listener_date);
        this.tv_listener_area = (TextView) findViewById(R.id.tv_listener_area);
        this.tv_listener_mileage_value = (TextView) findViewById(R.id.tv_listener_mileage_value);
        this.tv_listener_time_value = (TextView) findViewById(R.id.tv_listener_time_value);
        this.tv_listener_alt = (TextView) findViewById(R.id.tv_listener_alt);
        this.tv_listener_distance = (TextView) findViewById(R.id.tv_listener_distance);
        this.tv_listener_hs = (TextView) findViewById(R.id.tv_listener_hs);
        this.tv_listener_vs = (TextView) findViewById(R.id.tv_listener_vs);
        this.listener_drone_gps = (TextView) findViewById(R.id.listener_drone_gps);
        this.listener_seek = (SeekBar) findViewById(R.id.listener_seek);
        this.ib_listener_stick = (IImageButton) findViewById(R.id.ib_listener_stick);
        this.ib_listener_play = (IImageButton) findViewById(R.id.ib_listener_play);
        this.ib_listener_speed = (TextView) findViewById(R.id.ib_listener_speed);
        this.left_stick = (ListenerStickView) findViewById(R.id.listener_left_stick);
        this.right_stick = (ListenerStickView) findViewById(R.id.listener_right_stick);
        this.ib_map_select = (IImageButton) findViewById(R.id.ib_map_select);
        this.map_type_cl = (ConstraintLayout) findViewById(R.id.map_type_cl);
        this.ib_map_normal = (IImageButton) findViewById(R.id.ib_map_normal);
        this.ib_map_satellite = (IImageButton) findViewById(R.id.ib_map_satellite);
        this.listener_back.setOnClickListener(this);
        this.listener_seek.setOnSeekBarChangeListener(this);
        this.ib_listener_stick.setOnClickListener(this);
        this.ib_listener_play.setOnClickListener(this);
        this.ib_listener_speed.setOnClickListener(this);
        this.ib_map_select.setOnClickListener(this);
        this.ib_map_normal.setOnClickListener(this);
        this.ib_map_satellite.setOnClickListener(this);
        this.left_stick.setIsRC(true);
        this.right_stick.setIsRC(true);
        this.left_stick.setLeftHand(true);
        this.right_stick.setLeftHand(true);
    }

    /* access modifiers changed from: private */
    public void playListener() {
        if (this.isPlay) {
            if (this.index < this.listenerDatas.size()) {
                this.listener_seek.setProgress(this.index);
                c.a().d(new ListenerIndexEvent(this.index));
                this.ib_listener_play.setImageResource(R.drawable.ic_player_pause);
                this.index++;
                this.watchDog.removeCallbacks(this.listenerRunnable);
                this.watchDog.postDelayed(this.listenerRunnable, (long) (120 / this.speedLevel));
                return;
            }
            this.index = 0;
            this.mileage = i.f27244a;
            this.isPlay = false;
            this.listener_seek.setProgress(0);
        }
        this.ib_listener_play.setImageResource(R.drawable.ic_player_start);
        this.watchDog.removeCallbacks(this.listenerRunnable);
    }

    private void updateStick(float f2, float f3, float f4, float f5) {
        ListenerStickView listenerStickView = this.left_stick;
        listenerStickView.setmRockerBtn_X((((f2 - 1500.0f) / 400.0f) * listenerStickView.getR()) + this.left_stick.getPoint().x);
        ListenerStickView listenerStickView2 = this.left_stick;
        listenerStickView2.setmRockerBtn_Y((((-(f3 - 1500.0f)) / 400.0f) * listenerStickView2.getR()) + this.left_stick.getPoint().y);
        ListenerStickView listenerStickView3 = this.right_stick;
        listenerStickView3.setmRockerBtn_X((((f4 - 1500.0f) / 400.0f) * listenerStickView3.getR()) + this.right_stick.getPoint().x);
        ListenerStickView listenerStickView4 = this.right_stick;
        listenerStickView4.setmRockerBtn_Y((((f5 - 1500.0f) / 400.0f) * listenerStickView4.getR()) + this.right_stick.getPoint().y);
    }

    public void onClick(View view) {
        TextView textView;
        String str;
        c cVar;
        y yVar;
        int id2 = view.getId();
        if (id2 != R.id.listener_back) {
            switch (id2) {
                case R.id.ib_listener_play /*2131297410*/:
                    if (this.isPlay) {
                        this.isPlay = false;
                        this.ib_listener_play.setImageResource(R.drawable.ic_player_start);
                        return;
                    }
                    this.isPlay = true;
                    this.ib_listener_play.setImageResource(R.drawable.ic_player_pause);
                    if (this.index == 0) {
                        this.mileage = i.f27244a;
                        this.listenerMapFragment.clearFlightPath();
                    }
                    if (this.listenerDatas.size() > 1) {
                        playListener();
                        return;
                    }
                    this.ib_listener_play.setImageResource(R.drawable.ic_player_start);
                    ToastHelper.showToast((Context) this, getString(R.string.no_flight_data));
                    return;
                case R.id.ib_listener_speed /*2131297411*/:
                    int i2 = this.speedLevel;
                    if (i2 == 1) {
                        this.speedLevel = 2;
                        textView = this.ib_listener_speed;
                        str = "X2";
                    } else if (i2 == 2) {
                        this.speedLevel = 4;
                        textView = this.ib_listener_speed;
                        str = "X4";
                    } else if (i2 == 4) {
                        this.speedLevel = 8;
                        textView = this.ib_listener_speed;
                        str = "X8";
                    } else {
                        this.speedLevel = 1;
                        textView = this.ib_listener_speed;
                        str = "X1";
                    }
                    textView.setText(str);
                    return;
                case R.id.ib_listener_stick /*2131297412*/:
                    if (this.isShowStick) {
                        this.isShowStick = false;
                        this.left_stick.setIsRC(true);
                        this.right_stick.setIsRC(true);
                        return;
                    }
                    this.isShowStick = true;
                    this.left_stick.setIsRC(false);
                    this.right_stick.setIsRC(false);
                    return;
                default:
                    switch (id2) {
                        case R.id.ib_map_normal /*2131297414*/:
                            handleMapType(getString(R.string.menu_map_type_normal));
                            cVar = c.a();
                            yVar = new y(true);
                            break;
                        case R.id.ib_map_satellite /*2131297415*/:
                            handleMapType(getString(R.string.menu_map_type_satellite));
                            cVar = c.a();
                            yVar = new y(true);
                            break;
                        case R.id.ib_map_select /*2131297416*/:
                            if (this.isShowMap) {
                                this.isShowMap = false;
                                break;
                            } else {
                                this.isShowMap = true;
                                this.map_type_cl.setVisibility(0);
                                return;
                            }
                        default:
                            return;
                    }
                    cVar.d(yVar);
                    this.map_type_cl.setVisibility(8);
                    return;
            }
        } else {
            finish();
            startActivity(new Intent(this, FlightListenerActivity.class));
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        getWindow().addFlags(128);
        getWindow().setFlags(1024, 1024);
        requestWindowFeature(1);
        setContentView((int) R.layout.listener_map_activity);
        this.filePath = getIntent().getStringExtra("listenerPath");
        this.totalMileage = getIntent().getDoubleExtra("mileage", i.f27244a);
        this.drone = ((XEagleApp) getApplication()).k();
        FragmentManager supportFragmentManager = getSupportFragmentManager();
        this.fragmentManager = supportFragmentManager;
        ListenerMapFragment listenerMapFragment2 = (ListenerMapFragment) supportFragmentManager.d((int) R.id.mapFragment);
        this.listenerMapFragment = listenerMapFragment2;
        if (listenerMapFragment2 == null) {
            this.listenerMapFragment = new ListenerMapFragment();
        }
        this.fragmentManager.a().b(R.id.mapFragment, this.listenerMapFragment).d();
        initView();
        this.reader = new ListenerReader(this);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.isPlay = false;
        Runnable runnable = this.listenerRunnable;
        if (runnable != null) {
            this.watchDog.removeCallbacks(runnable);
        }
    }

    public void onProgressChanged(SeekBar seekBar, int i2, boolean z2) {
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        this.reader.openListener(this.filePath, this.drone, new ListenerReader.OnListenerParse() {
            public void onParseFail(String str) {
                Log.i("Listener", "onParseFail: ---" + str);
            }

            public void onParseSuccess() {
                ListenerMapActivity listenerMapActivity = ListenerMapActivity.this;
                ArrayList unused = listenerMapActivity.listenerDatas = listenerMapActivity.reader.getListenerDatas();
                if (ListenerMapActivity.this.listenerDatas.size() > 0) {
                    ListenerMapActivity.this.listener_seek.setMax(ListenerMapActivity.this.listenerDatas.size());
                    ListenerMapActivity.this.listener_seek.setProgress(ListenerMapActivity.this.index);
                    final ListenerData listenerData = (ListenerData) ListenerMapActivity.this.listenerDatas.get(0);
                    ListenerMapActivity.this.listenerMapFragment.updateListenerDatas(ListenerMapActivity.this.listenerDatas);
                    ListenerMapActivity.this.runOnUiThread(new Runnable() {
                        public void run() {
                            TextView access$1100;
                            String str;
                            String str2;
                            TextView textView;
                            ListenerMapActivity.this.listener_flight_mode.setText(ListenerMapActivity.this.getCurrentMode(listenerData.a()));
                            ListenerMapActivity.this.listener_flight_gps.setText(String.valueOf(listenerData.b()));
                            ListenerMapActivity.this.listener_flight_bat.setText(String.format(Locale.US, "%.2fv", new Object[]{Float.valueOf(((float) listenerData.d()) / 1000.0f)}));
                            ListenerMapActivity.this.tv_listener_alt.setText(String.format(Locale.US, "%.1fm", new Object[]{Double.valueOf(listenerData.l())}));
                            ListenerMapActivity.this.tv_listener_date.setText(listenerData.k().substring(0, 10));
                            if (listenerData.S() != -1.0d) {
                                access$1100 = ListenerMapActivity.this.tv_listener_distance;
                                str = String.format(Locale.US, "%.1fm", new Object[]{Double.valueOf(listenerData.S())});
                            } else if (listenerData.h() == null || (listenerData.h().d() == i.f27244a && listenerData.h().c() == i.f27244a)) {
                                access$1100 = ListenerMapActivity.this.tv_listener_distance;
                                str = "0.0";
                            } else {
                                access$1100 = ListenerMapActivity.this.tv_listener_distance;
                                str = String.format(Locale.US, "%.1fm", new Object[]{Double.valueOf(eg.a.c(listenerData.h(), listenerData.h()).a())});
                            }
                            access$1100.setText(str);
                            if (listenerData.h().d() == i.f27244a || listenerData.h().c() == i.f27244a) {
                                textView = ListenerMapActivity.this.listener_drone_gps;
                                str2 = ListenerMapActivity.this.getString(R.string.poor_gps_signal);
                            } else {
                                textView = ListenerMapActivity.this.listener_drone_gps;
                                str2 = String.format(Locale.US, "%.7f,%.7f", new Object[]{Double.valueOf(listenerData.h().d()), Double.valueOf(listenerData.h().c())});
                            }
                            textView.setText(str2);
                            ListenerMapActivity.this.tv_listener_hs.setText(String.format(Locale.US, "%.1fm/s", new Object[]{Double.valueOf(listenerData.m())}));
                            ListenerMapActivity.this.tv_listener_vs.setText(String.format(Locale.US, "%.1fm/s", new Object[]{Double.valueOf(listenerData.n())}));
                            ListenerMapActivity.this.tv_listener_mileage_value.setText(String.format(Locale.US, "%.1fm", new Object[]{Double.valueOf(ListenerMapActivity.this.totalMileage)}));
                            ListenerMapActivity.this.tv_listener_time_value.setText("00:00");
                        }
                    });
                    ListenerMapActivity.this.handleSystemAddress(((ListenerData) ListenerMapActivity.this.listenerDatas.get(0)).h());
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onStart() {
        super.onStart();
        if (!c.a().b(this)) {
            c.a().a((Object) this);
        }
    }

    public void onStartTrackingTouch(SeekBar seekBar) {
        this.isPlay = false;
    }

    /* access modifiers changed from: protected */
    public void onStop() {
        super.onStop();
        if (c.a().b(this)) {
            c.a().c(this);
        }
    }

    public void onStopTrackingTouch(SeekBar seekBar) {
        this.isPlay = true;
        this.index = seekBar.getProgress();
        Log.i("Listener", "onStopTrackingTouch: ---index---" + this.index + "...size..." + this.listenerDatas.size());
        this.listenerMapFragment.clearFlightPath();
        this.mileage = i.f27244a;
        int i2 = this.index;
        if (i2 > 0) {
            this.lastDroneCoord = this.listenerDatas.get(i2 - 1).h();
            for (int i3 = 1; i3 < this.index; i3++) {
                if (!this.listenerDatas.get(i3).h().e()) {
                    this.mileage += eg.a.c(this.listenerDatas.get(i3 - 1).h(), this.listenerDatas.get(i3).h()).a();
                }
            }
        } else {
            this.lastDroneCoord = this.listenerDatas.get(0).h();
        }
        this.watchDog.postDelayed(this.listenerRunnable, (long) (120 / this.speedLevel));
        this.listenerMapFragment.updateListenerDatas(this.listenerDatas);
    }

    @l(a = ThreadMode.MAIN)
    public void playListenerEvent(ListenerIndexEvent listenerIndexEvent) {
        String str;
        TextView textView;
        String str2;
        TextView textView2;
        this.listener_flight_mode.setText(getCurrentMode(this.listenerDatas.get(listenerIndexEvent.getIndex()).a()));
        this.listener_flight_gps.setText(String.valueOf(this.listenerDatas.get(listenerIndexEvent.getIndex()).b()));
        this.listener_flight_bat.setText(String.format(Locale.US, "%.2fv", new Object[]{Float.valueOf(((float) this.listenerDatas.get(listenerIndexEvent.getIndex()).d()) / 1000.0f)}));
        this.tv_listener_alt.setText(String.format(Locale.US, "%.1fm", new Object[]{Double.valueOf(this.listenerDatas.get(listenerIndexEvent.getIndex()).l())}));
        if (this.listenerDatas.get(0).S() == -1.0d) {
            double d2 = 1.35d;
            if (this.listenerDatas.get(0).h() == null || (this.listenerDatas.get(0).h().d() == i.f27244a && this.listenerDatas.get(0).h().c() == i.f27244a)) {
                this.ret = 1.35d;
                textView = this.tv_listener_distance;
                str = "0.0";
            } else {
                double a2 = eg.a.c(this.listenerDatas.get(0).h(), this.listenerDatas.get(listenerIndexEvent.getIndex()).h()).a();
                this.distance = a2;
                if (a2 <= 1500.0d) {
                    d2 = ((a2 / 1500.0d) * 0.35d) + 1.0d;
                }
                this.ret = d2;
                this.distance = a2 * this.ret;
                textView = this.tv_listener_distance;
                str = String.format(Locale.US, "%.1fm", new Object[]{Double.valueOf(this.distance)});
            }
        } else {
            textView = this.tv_listener_distance;
            str = String.format(Locale.US, "%.1fm", new Object[]{Double.valueOf(this.listenerDatas.get(listenerIndexEvent.getIndex()).S())});
        }
        textView.setText(str);
        if (this.listenerDatas.get(listenerIndexEvent.getIndex()).h().d() == i.f27244a || this.listenerDatas.get(listenerIndexEvent.getIndex()).h().c() == i.f27244a) {
            textView2 = this.listener_drone_gps;
            str2 = getString(R.string.poor_gps_signal);
        } else {
            textView2 = this.listener_drone_gps;
            str2 = String.format(Locale.US, "%.7f,%.7f", new Object[]{Double.valueOf(this.listenerDatas.get(listenerIndexEvent.getIndex()).h().d()), Double.valueOf(this.listenerDatas.get(listenerIndexEvent.getIndex()).h().c())});
        }
        textView2.setText(str2);
        this.tv_listener_hs.setText(String.format(Locale.US, "%.1fm/s", new Object[]{Double.valueOf(this.listenerDatas.get(listenerIndexEvent.getIndex()).m())}));
        this.tv_listener_vs.setText(String.format(Locale.US, "%.1fm/s", new Object[]{Double.valueOf(this.listenerDatas.get(listenerIndexEvent.getIndex()).n())}));
        int index2 = listenerIndexEvent.getIndex() * 120;
        this.flightTime = index2;
        this.tv_listener_time_value.setText(TimeUtil.secToTime(index2 / 1000));
        if (listenerIndexEvent.getIndex() == 0) {
            this.mileage = i.f27244a;
            this.lastDroneCoord = new ef.a(i.f27244a, i.f27244a);
        }
        String Q = this.listenerDatas.get(listenerIndexEvent.getIndex()).Q();
        String A = this.listenerDatas.get(listenerIndexEvent.getIndex()).A();
        if (!Q.isEmpty() && !Q.equals("-")) {
            this.tipListView.a(Q);
        }
        if (!A.isEmpty() && !A.equals("-") && !A.equalsIgnoreCase(Q)) {
            this.tipListView.a(A);
        }
        updateStick((float) this.listenerDatas.get(listenerIndexEvent.getIndex()).r(), (float) this.listenerDatas.get(listenerIndexEvent.getIndex()).q(), (float) this.listenerDatas.get(listenerIndexEvent.getIndex()).o(), (float) this.listenerDatas.get(listenerIndexEvent.getIndex()).p());
        if (!(this.lastDroneCoord.d() == i.f27244a || this.lastDroneCoord.c() == i.f27244a)) {
            this.mileage += eg.a.c(this.lastDroneCoord, this.listenerDatas.get(listenerIndexEvent.getIndex()).h()).a() * this.ret;
        }
        double d3 = this.mileage;
        double d4 = this.distance;
        if (d3 < d4) {
            this.mileage = d4 + (this.ret * 10.0d);
        }
        this.tv_listener_mileage_value.setText(String.format(Locale.US, "%.1fm", new Object[]{Double.valueOf(this.totalMileage)}));
        this.lastDroneCoord = this.listenerDatas.get(listenerIndexEvent.getIndex()).h();
    }
}
