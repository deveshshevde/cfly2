package com.xeagle.android.dialogs;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
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
import com.google.gson.Gson;
import com.hoho.android.usb.usb.data_proxy.g;
import com.myusb.proxy.proto.Proxy;
import com.xeagle.android.XEagleApp;
import com.xeagle.android.dialogs.d;
import com.xeagle.android.login.beans.UsbWifiBeans;
import com.xeagle.android.login.beans.UsbWifiInfo;
import com.xeagle.android.login.common.ip.WifiConnectDlg;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import org.json.JSONException;
import org.json.JSONObject;
import tv.danmaku.ijk.media.player.IMediaPlayer;

public class ai extends a {

    /* renamed from: c  reason: collision with root package name */
    private static ai f22534c;

    /* renamed from: b  reason: collision with root package name */
    private final String f22535b = "USBPAIR";
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public a f22536d;

    /* renamed from: e  reason: collision with root package name */
    private IButton f22537e;
    /* access modifiers changed from: private */

    /* renamed from: f  reason: collision with root package name */
    public d f22538f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f22539g;
    /* access modifiers changed from: private */

    /* renamed from: h  reason: collision with root package name */
    public ProgressBar f22540h;
    /* access modifiers changed from: private */

    /* renamed from: i  reason: collision with root package name */
    public IButton f22541i;
    /* access modifiers changed from: private */

    /* renamed from: j  reason: collision with root package name */
    public AppCompatActivity f22542j;
    /* access modifiers changed from: private */

    /* renamed from: k  reason: collision with root package name */
    public com.hoho.android.usb.usb.data_proxy.d f22543k;
    /* access modifiers changed from: private */

    /* renamed from: l  reason: collision with root package name */
    public final b f22544l = new b(this);
    /* access modifiers changed from: private */

    /* renamed from: m  reason: collision with root package name */
    public d f22545m;

    /* renamed from: n  reason: collision with root package name */
    private final AdapterView.OnItemClickListener f22546n = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            final String ssid = ((UsbWifiInfo) adapterView.getItemAtPosition(i2)).getSsid();
            if (ai.this.f22545m == null) {
                ai aiVar = ai.this;
                d unused = aiVar.f22545m = d.a(aiVar.f22542j.getString(R.string.warning), ai.this.f22542j.getString(R.string.confirm_pair_usb_rc));
            }
            if (!ai.this.f22545m.isAdded()) {
                ai.this.f22545m.a(new d.a() {
                    public void onNo() {
                    }

                    public void onYes() {
                        JSONObject jSONObject = new JSONObject();
                        try {
                            jSONObject.put("ssid", ssid);
                            jSONObject.put("psk", "none");
                            jSONObject.put("key_mgmt", "NONE");
                            ai.this.f22543k.a(-1, Proxy.ConnType.RELAY, Proxy.MsgType.RELAY_WIFI_RENAME, "", IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE, 0, 0, (String) null, jSONObject.toString().getBytes());
                        } catch (JSONException e2) {
                            e2.printStackTrace();
                        }
                        ai.this.dismiss();
                    }
                });
                ai.this.f22545m.show(ai.this.getChildFragmentManager(), "USBPAIR");
            }
        }
    };

    public interface a {
        void onYes();
    }

    private static class b extends Handler {

        /* renamed from: a  reason: collision with root package name */
        private final WeakReference<ai> f22554a;

        public b(ai aiVar) {
            super(Looper.getMainLooper());
            this.f22554a = new WeakReference<>(aiVar);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i2 = message.what;
            if (i2 == 1) {
                ((ai) this.f22554a.get()).f22540h.setVisibility(0);
                ((ai) this.f22554a.get()).f22539g.setText(R.string.scanning);
            } else if (i2 == 2) {
                ArrayList<UsbWifiInfo> body = ((UsbWifiBeans) new Gson().fromJson(message.getData().getString("results"), UsbWifiBeans.class)).getBody();
                if (body == null || body.size() <= 0) {
                    ((ai) this.f22554a.get()).f22539g.setText(R.string.none_found);
                    ((ai) this.f22554a.get()).f22540h.setVisibility(4);
                    Toast.makeText(((ai) this.f22554a.get()).f22542j, ((ai) this.f22554a.get()).f22542j.getString(R.string.scan_no_device), 1).show();
                } else {
                    ((ai) this.f22554a.get()).f22538f.clear();
                    Log.i("UDP", "handleMessage: -----" + body.size() + "---" + body.get(0));
                    Collections.sort(body, new Comparator<UsbWifiInfo>() {
                        /* renamed from: a */
                        public int compare(UsbWifiInfo usbWifiInfo, UsbWifiInfo usbWifiInfo2) {
                            return Integer.compare(usbWifiInfo2.getSignal_level(), usbWifiInfo.getSignal_level());
                        }
                    });
                    ((ai) this.f22554a.get()).f22538f.addAll(body);
                    ((ai) this.f22554a.get()).f22539g.setText(R.string.select_device);
                    ((ai) this.f22554a.get()).f22540h.setVisibility(4);
                }
                ((ai) this.f22554a.get()).f22541i.setVisibility(0);
            }
        }
    }

    public static class c {
        /* access modifiers changed from: private */

        /* renamed from: a  reason: collision with root package name */
        public static final ai f22556a = new ai();
    }

    public static class d extends ArrayAdapter<UsbWifiInfo> {

        /* renamed from: a  reason: collision with root package name */
        private final LayoutInflater f22557a;

        public d(Context context) {
            super(context, R.layout.list_device_name);
            this.f22557a = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f22557a.inflate(R.layout.list_device_name, viewGroup, false);
            }
            TextView textView = (TextView) view;
            String ssid = ((UsbWifiInfo) getItem(i2)).getSsid();
            if (ssid != null) {
                textView.setText(ssid);
            }
            return textView;
        }
    }

    public static ai a() {
        return c.f22556a;
    }

    /* access modifiers changed from: private */
    public void b() {
        ka.a.a().b().execute(new Runnable() {
            public void run() {
                if (ai.this.f22543k == null) {
                    Log.i("UsbDataProxy", "run:======hahah  proxy is null ");
                    return;
                }
                ai.this.f22543k.a("USBPAIR");
                ai.this.f22544l.sendEmptyMessage(1);
                ai.this.f22543k.a("USBPAIR", (g) new g() {
                    public void onRelay(Proxy.MsgType msgType, byte[] bArr) {
                        if (msgType == Proxy.MsgType.RELAY_WIFI_LIST) {
                            String str = new String(bArr);
                            Log.i("USBPAIR", "onRelay: ====wifi list====" + str);
                            Message message = new Message();
                            message.what = 2;
                            Bundle bundle = new Bundle();
                            bundle.putString("results", str);
                            message.setData(bundle);
                            ai.this.f22544l.sendMessage(message);
                        }
                    }
                });
                ai.this.f22543k.a(-1, Proxy.ConnType.RELAY, Proxy.MsgType.RELAY_WIFI_LIST, "", IMediaPlayer.MEDIA_INFO_MEDIA_ACCURATE_SEEK_COMPLETE, 0, 0, (String) null, (byte[]) null);
            }
        });
    }

    public ai a(String str, String str2, a aVar) {
        if (f22534c == null) {
            f22534c = new ai();
        }
        Bundle bundle = new Bundle();
        bundle.putString(WifiConnectDlg.EXTRAL_UNLOCK_ACTION, str);
        bundle.putString("extra_unlock_content", str2);
        f22534c.setArguments(bundle);
        ai aiVar = f22534c;
        aiVar.f22536d = aVar;
        return aiVar;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.f22542j = (AppCompatActivity) activity;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.dlg_wifi_list, viewGroup, false);
        this.f22543k = ((XEagleApp) this.f22542j.getApplicationContext()).e();
        this.f22539g = (TextView) inflate.findViewById(R.id.bt_device_list_title);
        this.f22540h = (ProgressBar) inflate.findViewById(R.id.bt_scan_progress_bar);
        IButton iButton = (IButton) inflate.findViewById(R.id.button_scan);
        this.f22541i = iButton;
        iButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                ai.this.b();
                view.setVisibility(8);
            }
        });
        ListView listView = (ListView) inflate.findViewById(R.id.paired_devices);
        d dVar = new d(this.f22542j.getApplicationContext());
        this.f22538f = dVar;
        listView.setAdapter(dVar);
        listView.setOnItemClickListener(this.f22546n);
        IButton iButton2 = (IButton) inflate.findViewById(R.id.ib_ok);
        this.f22537e = iButton2;
        iButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (ai.this.f22536d != null) {
                    ai.this.f22536d.onYes();
                }
                ai.this.dismiss();
            }
        });
        return inflate;
    }

    public void onResume() {
        super.onResume();
        b();
    }
}
