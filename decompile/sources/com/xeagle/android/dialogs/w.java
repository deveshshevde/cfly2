package com.xeagle.android.dialogs;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Bundle;
import android.os.Handler;
import android.os.IBinder;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.cfly.uav_pro.R;
import com.flypro.core.util.e;
import com.xeagle.android.dialogs.d;
import com.xeagle.android.login.common.ip.WifiConnectDlg;
import com.xeagle.android.login.common.service.UdpDataService;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import java.lang.ref.WeakReference;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public class w extends a {

    /* renamed from: c  reason: collision with root package name */
    private static w f22757c;

    /* renamed from: b  reason: collision with root package name */
    ServiceConnection f22758b = new ServiceConnection() {
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            UdpDataService unused = w.this.f22767l = ((UdpDataService.UdpBinder) iBinder).getService();
        }

        public void onServiceDisconnected(ComponentName componentName) {
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public a f22759d;

    /* renamed from: e  reason: collision with root package name */
    private IButton f22760e;

    /* renamed from: f  reason: collision with root package name */
    private e f22761f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public b f22762g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public TextView f22763h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public ProgressBar f22764i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public IButton f22765j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public AppCompatActivity f22766k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public UdpDataService f22767l;
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public boolean f22768m = false;
    /* access modifiers changed from: private */

    /* renamed from: n  reason: collision with root package name */
    public final c f22769n = new c(this);

    /* renamed from: o  reason: collision with root package name */
    private final AdapterView.OnItemClickListener f22770o = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            final String str = (String) adapterView.getItemAtPosition(i2);
            String string = w.this.f22766k.getString(R.string.warning);
            d a2 = d.a(string, w.this.f22766k.getString(R.string.confirm_pair_rc1) + str, new d.a() {
                public void onNo() {
                }

                public void onYes() {
                    UdpDataService h2;
                    String sb;
                    if (str.length() > 6) {
                        if (str.contains("MT7628-TEST")) {
                            h2 = w.this.f22767l;
                            sb = "flyset MT7628-TEST";
                        } else if (str.contains("FLY_TEST")) {
                            h2 = w.this.f22767l;
                            sb = "flyset FLY_TEST";
                        } else {
                            h2 = w.this.f22767l;
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append("flyset Drone-");
                            String str = str;
                            sb2.append(str.substring(str.length() - 6));
                            sb = sb2.toString();
                        }
                        h2.send(sb, "172.50.10.254", IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE);
                    }
                    SystemClock.sleep(300);
                    Toast.makeText(w.this.f22766k, w.this.f22766k.getString(R.string.scan_pair_success), 0).show();
                    w.this.dismiss();
                }
            });
            if (a2 != null) {
                a2.show(w.this.getChildFragmentManager(), "private");
            }
        }
    };

    public interface a {
        void onYes();
    }

    public static class b extends ArrayAdapter<String> {

        /* renamed from: a  reason: collision with root package name */
        private final LayoutInflater f22778a;

        public b(Context context) {
            super(context, R.layout.list_device_name);
            this.f22778a = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f22778a.inflate(R.layout.list_device_name, viewGroup, false);
            }
            TextView textView = (TextView) view;
            String str = (String) getItem(i2);
            if (str != null) {
                textView.setText(str);
            }
            return textView;
        }
    }

    private static class c extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<w> f22779a;

        public c(w wVar) {
            super(Looper.getMainLooper());
            this.f22779a = new WeakReference<>(wVar);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 1) {
                ((w) this.f22779a.get()).f22764i.setVisibility(0);
                ((w) this.f22779a.get()).f22763h.setText(R.string.scanning);
            } else if (i2 == 2) {
                String[] stringArray = message.getData().getStringArray("results");
                if (!stringArray[0].equals("")) {
                    ((w) this.f22779a.get()).f22762g.clear();
                    Log.i("UDP", "handleMessage: -----" + stringArray.length + "---" + stringArray[0]);
                    ((w) this.f22779a.get()).f22762g.addAll(stringArray);
                    ((w) this.f22779a.get()).f22763h.setText(R.string.select_device);
                    ((w) this.f22779a.get()).f22764i.setVisibility(4);
                } else {
                    ((w) this.f22779a.get()).f22763h.setText(R.string.none_found);
                    ((w) this.f22779a.get()).f22764i.setVisibility(4);
                    Toast.makeText(((w) this.f22779a.get()).f22766k, ((w) this.f22779a.get()).f22766k.getString(R.string.scan_no_device), 1).show();
                }
                ((w) this.f22779a.get()).f22765j.setVisibility(0);
            }
        }
    }

    public static w a(String str, String str2, a aVar) {
        if (f22757c == null) {
            f22757c = new w();
        }
        Bundle bundle = new Bundle();
        bundle.putString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, str);
        bundle.putString("extra_unlock_content", str2);
        f22757c.setArguments(bundle);
        w wVar = f22757c;
        wVar.f22759d = aVar;
        return wVar;
    }

    /* access modifiers changed from: private */
    public void a() {
        ka.a.a().b().execute(new Runnable() {
            public void run() {
                if (w.this.f22767l != null && w.this.f22768m) {
                    w.this.f22769n.sendEmptyMessage(1);
                    w.this.f22767l.send("flyget", "172.50.10.254", IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE);
                    SystemClock.sleep(300);
                    String startRecv = w.this.f22767l.startRecv();
                    String[] split = startRecv.split("\n");
                    Log.i("UDP", "doScanWifi: ---" + startRecv);
                    Message message = new Message();
                    message.what = 2;
                    Bundle bundle = new Bundle();
                    bundle.putStringArray("results", split);
                    message.setData(bundle);
                    w.this.f22769n.sendMessage(message);
                }
            }
        });
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f22766k = (AppCompatActivity) activity;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dlg_wifi_list, viewGroup, false);
        this.f22761f = new e(this.f22766k.getApplicationContext());
        this.f22768m = this.f22766k.getApplicationContext().bindService(new Intent(this.f22766k, UdpDataService.class), this.f22758b, 1);
        this.f22763h = (TextView) inflate.findViewById(R.id.bt_device_list_title);
        this.f22764i = (ProgressBar) inflate.findViewById(R.id.bt_scan_progress_bar);
        IButton iButton = (IButton) inflate.findViewById(R.id.button_scan);
        this.f22765j = iButton;
        iButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                w.this.a();
                view.setVisibility(8);
            }
        });
        ListView listView = (ListView) inflate.findViewById(R.id.paired_devices);
        b bVar = new b(this.f22766k.getApplicationContext());
        this.f22762g = bVar;
        listView.setAdapter(bVar);
        listView.setOnItemClickListener(this.f22770o);
        IButton iButton2 = (IButton) inflate.findViewById(R.id.ib_ok);
        this.f22760e = iButton2;
        iButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                w.this.f22759d.onYes();
                w.this.dismiss();
            }
        });
        return inflate;
    }

    public void onResume() {
        super.onResume();
        a();
    }

    public void onStop() {
        super.onStop();
        if (this.f22768m) {
            UdpDataService udpDataService = this.f22767l;
            if (udpDataService != null) {
                udpDataService.stop();
            }
            this.f22766k.getApplicationContext().unbindService(this.f22758b);
            this.f22768m = false;
        }
    }
}
