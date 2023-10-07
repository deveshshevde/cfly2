package com.xeagle.android.dialogs;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.wifi.ScanResult;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.cfly.uav_pro.R;
import com.flypro.core.util.e;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.dialogs.d;
import com.xeagle.android.login.beans.UdpUnbindServer;
import com.xeagle.android.login.common.ip.WifiConnectDlg;
import com.xeagle.android.login.retrofitLogin.CameraGlobal;
import com.xeagle.android.login.retrofitLogin.sochip.SochipPresenter;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public class q extends androidx.fragment.app.c {

    /* renamed from: b  reason: collision with root package name */
    static final /* synthetic */ boolean f22711b = true;

    /* renamed from: a  reason: collision with root package name */
    protected b f22712a;

    /* renamed from: c  reason: collision with root package name */
    private IButton f22713c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public e f22714d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public c f22715e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public TextView f22716f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public ProgressBar f22717g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public IButton f22718h;

    /* renamed from: i  reason: collision with root package name */
    private final BroadcastReceiver f22719i = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            if ("android.net.wifi.SCAN_RESULTS".equals(intent.getAction())) {
                ArrayList arrayList = new ArrayList();
                if (q.this.f22714d.e() != null) {
                    for (ScanResult next : q.this.f22714d.e()) {
                        if (next.SSID.contains("Controller")) {
                            arrayList.add(next);
                        }
                    }
                    Collections.sort(arrayList, new a());
                    q.this.f22715e.clear();
                    q.this.f22715e.addAll(arrayList);
                    q.this.f22716f.setText(R.string.select_device);
                    q.this.f22717g.setVisibility(4);
                    if (q.this.f22715e.getCount() == 0) {
                        q.this.f22716f.setText(R.string.none_found);
                    }
                    q.this.f22718h.setVisibility(0);
                }
            }
        }
    };

    /* renamed from: j  reason: collision with root package name */
    private final AdapterView.OnItemClickListener f22720j = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            final ScanResult scanResult = (ScanResult) adapterView.getItemAtPosition(i2);
            String string = q.this.getActivity().getString(R.string.warning);
            d a2 = d.a(string, q.this.getActivity().getString(R.string.confirm_pair_rc1) + scanResult.SSID + q.this.getActivity().getString(R.string.confirm_pair_rc2), new d.a() {
                public void onNo() {
                }

                public void onYes() {
                    int a2 = ((XEagleApp) q.this.getActivity().getApplication()).m().a();
                    if (scanResult.SSID.length() > 6) {
                        q.this.a();
                        SystemClock.sleep(200);
                        if (a2 == 1) {
                            ((XEagleApp) q.this.getActivity().getApplication()).g().m(scanResult.SSID.substring(scanResult.SSID.length() - 6));
                        } else if (a2 == 2) {
                            SochipPresenter h2 = ((XEagleApp) q.this.getActivity().getApplication()).h();
                            h2.setCmdAndStr(CameraGlobal.BASE_URL, 1, 3003, "Drone-" + scanResult.SSID.substring(scanResult.SSID.length() - 6));
                        }
                    }
                    q.this.dismiss();
                }
            });
            if (a2 != null) {
                a2.show(q.this.getChildFragmentManager(), "wifi");
            }
        }
    };

    private class a implements Comparator<ScanResult> {
        private a() {
        }

        /* renamed from: a */
        public int compare(ScanResult scanResult, ScanResult scanResult2) {
            return Math.abs(scanResult.level) < Math.abs(scanResult2.level) ? 1 : -1;
        }
    }

    public interface b {
        void onYes();
    }

    public static class c extends ArrayAdapter<ScanResult> {

        /* renamed from: a  reason: collision with root package name */
        private final LayoutInflater f22729a;

        public c(Context context) {
            super(context, R.layout.list_device_name);
            this.f22729a = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f22729a.inflate(R.layout.list_device_name, viewGroup, false);
            }
            TextView textView = (TextView) view;
            ScanResult scanResult = (ScanResult) getItem(i2);
            if (scanResult != null) {
                textView.setText(scanResult.SSID + "\t\t" + scanResult.level);
            }
            return textView;
        }
    }

    public static q a(String str, String str2, b bVar) {
        q qVar = new q();
        Bundle bundle = new Bundle();
        bundle.putString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, str);
        bundle.putString("extra_unlock_content", str2);
        qVar.setArguments(bundle);
        qVar.f22712a = bVar;
        return qVar;
    }

    /* access modifiers changed from: private */
    public void a() {
        new Thread(new Runnable() {
            public void run() {
                new UdpUnbindServer().sendBuffer(com.xeagle.android.utils.c.a(new byte[]{-2, -1, -1, -1}, ch.a.a().replace("_", "").getBytes(StandardCharsets.ISO_8859_1)), "172.50.10.1", IMediaPlayer.MEDIA_INFO_OPEN_INPUT);
            }
        }).start();
    }

    /* access modifiers changed from: private */
    public void b() {
        e eVar = this.f22714d;
        if (eVar != null) {
            eVar.a();
            this.f22717g.setVisibility(0);
            this.f22716f.setText(R.string.scanning);
            this.f22714d.d();
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        if (f22711b || window != null) {
            window.setGravity(17);
            create.show();
            window.setLayout(getActivity().getWindowManager().getDefaultDisplay().getWidth() / 2, (getActivity().getWindowManager().getDefaultDisplay().getHeight() * 3) / 5);
            return create;
        }
        throw new AssertionError();
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dlg_wifi_list, viewGroup, false);
        this.f22714d = new e(getActivity().getApplicationContext());
        this.f22716f = (TextView) inflate.findViewById(R.id.bt_device_list_title);
        this.f22717g = (ProgressBar) inflate.findViewById(R.id.bt_scan_progress_bar);
        IButton iButton = (IButton) inflate.findViewById(R.id.button_scan);
        this.f22718h = iButton;
        iButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                q.this.b();
                view.setVisibility(8);
            }
        });
        ListView listView = (ListView) inflate.findViewById(R.id.paired_devices);
        c cVar = new c(getActivity().getApplicationContext());
        this.f22715e = cVar;
        listView.setAdapter(cVar);
        listView.setOnItemClickListener(this.f22720j);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        getActivity().registerReceiver(this.f22719i, intentFilter);
        IButton iButton2 = (IButton) inflate.findViewById(R.id.ib_ok);
        this.f22713c = iButton2;
        iButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                q.this.f22712a.onYes();
                q.this.dismiss();
            }
        });
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        getActivity().unregisterReceiver(this.f22719i);
    }
}
