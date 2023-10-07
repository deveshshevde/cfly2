package com.xeagle.android.login.common.ip;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.c;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.cfly.uav_pro.R;
import com.xeagle.android.dialogs.d;
import com.xeagle.android.login.HostManagerActivity;
import com.xeagle.android.login.beans.WifiBean;
import com.xeagle.android.login.common.ip.WifiListAdapter;
import com.xeagle.android.login.common.ip.WifiSupport;
import com.xeagle.android.vjoystick.IWidgets.IButton;
import com.xeagle.android.vjoystick.utils.e;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import lk.b;

public class WifiConnectDlg extends c {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static final String EXTRAL_UNLOCK_ACTION = "extra_unlock_action";
    public static final String EXTRAL_UNLOCK_CONTENT = "extra_unlock_content";
    private static WifiConnectDlg wcd;
    private IButton bt_ok;
    /* access modifiers changed from: private */
    public int connectType = 0;
    /* access modifiers changed from: private */
    public String curWifi;
    /* access modifiers changed from: private */
    public e handler = new e();
    /* access modifiers changed from: private */
    public SetIpManager ipConfig;
    /* access modifiers changed from: private */
    public boolean isConnectDrone = true;
    /* access modifiers changed from: private */
    public boolean isHasConfig = false;
    private WifiListAdapter.onItemClickListener itemClickListener = new WifiListAdapter.onItemClickListener() {
        public void onItemClick(View view, final int i2, Object obj) {
            d a2 = d.a(WifiConnectDlg.this.getString(R.string.warning), WifiConnectDlg.this.parent.getString(R.string.wifi_dialog_connect, new Object[]{WifiConnectDlg.this.realWifiList.get(i2).getWifiName()}), new d.a() {
                public void onNo() {
                }

                public void onYes() {
                    boolean unused = WifiConnectDlg.this.isConnectDrone = false;
                    WifiConnectDlg.this.handler.a((Runnable) new Runnable() {
                        public void run() {
                            WifiBean wifiBean = WifiConnectDlg.this.realWifiList.get(i2);
                            if (!wifiBean.getState().equals(WifiConnectDlg.this.parent.getString(R.string.disconnected)) && !wifiBean.getState().equals(WifiConnectDlg.this.parent.getString(R.string.connected))) {
                                return;
                            }
                            if (WifiSupport.getWifiCipher(WifiConnectDlg.this.realWifiList.get(i2).getCapabilities()) == WifiSupport.WifiCipherType.WIFICIPHER_NOPASS) {
                                WifiConfiguration isExsits = WifiSupport.isExsits(wifiBean.getWifiName(), WifiConnectDlg.this.parent);
                                if (isExsits == null) {
                                    Log.i("device", "run: ----device has no config");
                                    boolean unused = WifiConnectDlg.this.isHasConfig = false;
                                    WifiSupport.addNetWork(WifiSupport.createWifiConfig(wifiBean.getWifiName(), (String) null, WifiSupport.WifiCipherType.WIFICIPHER_NOPASS), WifiConnectDlg.this.parent.getApplicationContext());
                                    return;
                                }
                                Log.i("device", "run: ----device has  config");
                                boolean unused2 = WifiConnectDlg.this.isHasConfig = true;
                                WifiSupport.addNetWork(isExsits, WifiConnectDlg.this.parent.getApplicationContext());
                                return;
                            }
                            WifiConnectDlg.this.noConfigurationWifi(i2);
                        }
                    });
                }
            });
            if (a2 != null) {
                a2.show(WifiConnectDlg.this.getChildFragmentManager(), "connect_wifi");
            }
        }
    };
    protected Listener listener;
    /* access modifiers changed from: private */
    public TextView mDeviceListTitle;
    /* access modifiers changed from: private */
    public ProgressBar mDevicePb;
    private TextView mPairedDeviceTitle;
    private final BroadcastReceiver mReceiver = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String str;
            String action = intent.getAction();
            if ("android.net.wifi.SCAN_RESULTS".equals(action)) {
                WifiConnectDlg.this.wifiListChange();
                WifiConnectDlg.this.mDeviceListTitle.setText(R.string.select_device);
                WifiConnectDlg.this.mDevicePb.setVisibility(4);
                if (WifiConnectDlg.this.wifiListAdapter.getItemCount() == 0) {
                    WifiConnectDlg.this.mDeviceListTitle.setText(R.string.none_found);
                }
                WifiConnectDlg.this.scanBt.setVisibility(0);
                return;
            }
            if ("android.net.wifi.WIFI_STATE_CHANGED".equals(action)) {
                int intExtra = intent.getIntExtra("wifi_state", -1);
                if (intExtra == 1) {
                    str = "wifiState:WIFI_STATE_DISABLED";
                } else if (intExtra != 3) {
                    if (intExtra == 4) {
                        str = "wifiState:WIFI_STATE_UNKNOWN";
                    } else {
                        return;
                    }
                } else if (!WifiConnectDlg.this.wifiFunction.i().equalsIgnoreCase(WifiConnectDlg.this.curWifi)) {
                    return;
                }
                Log.e("WIFI状态", str);
                return;
            } else if ("android.net.wifi.STATE_CHANGE".equals(intent.getAction())) {
                NetworkInfo networkInfo = (NetworkInfo) intent.getParcelableExtra("networkInfo");
                Log.d("WIFI", "--NetworkInfo--" + networkInfo.toString());
                if (NetworkInfo.State.DISCONNECTED == networkInfo.getState()) {
                    Log.d("WIFI", "wifi没连接上");
                    WifiConnectDlg.this.mDevicePb.setVisibility(4);
                    for (int i2 = 0; i2 < WifiConnectDlg.this.realWifiList.size(); i2++) {
                        WifiConnectDlg.this.realWifiList.get(i2).setState(WifiConnectDlg.this.parent.getString(R.string.disconnected));
                    }
                    WifiConnectDlg.this.wifiListAdapter.notifyDataSetChanged();
                    return;
                } else if (NetworkInfo.State.CONNECTED == networkInfo.getState()) {
                    Log.d("WIFI", "wifi连接上了");
                    WifiConnectDlg.this.listener.onWifiConnected();
                    WifiConnectDlg.this.mDevicePb.setVisibility(4);
                    WifiInfo connectedWifiInfo = WifiSupport.getConnectedWifiInfo(WifiConnectDlg.this.parent);
                    int unused = WifiConnectDlg.this.connectType = 1;
                    WifiConnectDlg.this.wifiListSet(connectedWifiInfo.getSSID(), WifiConnectDlg.this.connectType);
                    if (connectedWifiInfo.getSSID().contains("Controller")) {
                        if (WifiConnectDlg.this.isHasConfig || !WifiConnectDlg.this.ipConfig.getWifiSetting().equals("DHCP")) {
                            Log.i("device", "onReceive:----is already static---ip--- " + WifiConnectDlg.this.ipConfig.getIpStr());
                        } else {
                            Log.i("device", "onReceive:---is dhcp---ip--- " + WifiConnectDlg.this.ipConfig.getIpStr());
                            int random = ((int) (Math.random() * 100.0d)) + ((int) (Math.random() * 100.0d)) + 30;
                            if (random == 254) {
                                random--;
                            }
                            if (random == 123) {
                                random++;
                            }
                            boolean ipWithTfiStaticIp = WifiConnectDlg.this.ipConfig.setIpWithTfiStaticIp(false, "172.50.10." + random, 24, "8.8.8.8", "172.50.10.1");
                            Log.i("device", "onReceive: ---set static---" + ipWithTfiStaticIp);
                            if (!ipWithTfiStaticIp) {
                                WifiConnectDlg.this.listener.onConnectMav(false);
                            }
                        }
                        WifiConnectDlg.this.listener.onConnectMav(true);
                    }
                    if (!WifiConnectDlg.this.isConnectDrone) {
                        boolean unused2 = WifiConnectDlg.this.isConnectDrone = true;
                    } else {
                        return;
                    }
                } else if (NetworkInfo.State.CONNECTING == networkInfo.getState()) {
                    Log.d("WIFI", "wifi正在连接");
                    WifiConnectDlg.this.mDevicePb.setVisibility(0);
                    WifiInfo connectedWifiInfo2 = WifiSupport.getConnectedWifiInfo(WifiConnectDlg.this.parent);
                    int unused3 = WifiConnectDlg.this.connectType = 2;
                    WifiConnectDlg.this.wifiListSet(connectedWifiInfo2.getSSID(), WifiConnectDlg.this.connectType);
                    return;
                } else {
                    return;
                }
            } else {
                return;
            }
            WifiConnectDlg.this.dismiss();
        }
    };
    private RecyclerView newDeviceList;
    /* access modifiers changed from: private */
    public HostManagerActivity parent;
    List<WifiBean> realWifiList = new ArrayList();
    /* access modifiers changed from: private */
    public List<ScanResult> results;
    /* access modifiers changed from: private */
    public IButton scanBt;
    /* access modifiers changed from: private */
    public com.flypro.core.util.e wifiFunction;
    /* access modifiers changed from: private */
    public WifiListAdapter wifiListAdapter;

    private class FileComparator implements Comparator<ScanResult> {
        private FileComparator() {
        }

        public int compare(ScanResult scanResult, ScanResult scanResult2) {
            return Math.abs(scanResult.level) < Math.abs(scanResult2.level) ? 1 : -1;
        }
    }

    public interface Listener {
        void onConnectMav(boolean z2);

        void onNo();

        void onWifiConnected();

        void onYes();
    }

    /* access modifiers changed from: private */
    public void doScanWifi() {
        List<ScanResult> noSameName = WifiSupport.noSameName(WifiSupport.getWifiScanResult(this.parent));
        this.realWifiList.clear();
        if (!CollectionUtils.isNullOrEmpty(noSameName)) {
            for (int i2 = 0; i2 < noSameName.size(); i2++) {
                WifiBean wifiBean = new WifiBean();
                wifiBean.setWifiName(noSameName.get(i2).SSID);
                wifiBean.setState(this.parent.getString(R.string.disconnected));
                wifiBean.setCapabilities(noSameName.get(i2).capabilities);
                wifiBean.setLevel(noSameName.get(i2).level);
                this.realWifiList.add(wifiBean);
                Collections.sort(this.realWifiList);
                this.wifiListAdapter.notifyDataSetChanged();
            }
        }
    }

    public static WifiConnectDlg newInstance(String str, String str2, Listener listener2) {
        if (wcd == null) {
            wcd = new WifiConnectDlg();
        }
        Bundle bundle = new Bundle();
        bundle.putString(EXTRAL_UNLOCK_ACTION, str);
        bundle.putString("extra_unlock_content", str2);
        wcd.setArguments(bundle);
        WifiConnectDlg wifiConnectDlg = wcd;
        wifiConnectDlg.listener = listener2;
        return wifiConnectDlg;
    }

    /* access modifiers changed from: private */
    public void noConfigurationWifi(int i2) {
        WifiLinkDialog wifiLinkDialog = new WifiLinkDialog(this.parent, R.style.dialog_download, this.realWifiList.get(i2).getWifiName(), this.realWifiList.get(i2).getCapabilities());
        if (!wifiLinkDialog.isShowing()) {
            wifiLinkDialog.show();
        }
    }

    /* access modifiers changed from: private */
    public void startScan() {
        this.handler.a((Runnable) new Runnable() {
            public void run() {
                if (WifiConnectDlg.this.wifiFunction != null) {
                    WifiConnectDlg.this.wifiFunction.a();
                    WifiConnectDlg.this.mDevicePb.setVisibility(0);
                    WifiConnectDlg.this.mDeviceListTitle.setText(R.string.scanning);
                    WifiConnectDlg.this.wifiFunction.d();
                }
            }
        });
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this.parent = (HostManagerActivity) activity;
    }

    public Dialog onCreateDialog(Bundle bundle) {
        AlertDialog create = new AlertDialog.Builder(getActivity(), R.style.dialog).create();
        create.requestWindowFeature(1);
        create.setCanceledOnTouchOutside(false);
        Window window = create.getWindow();
        window.setGravity(17);
        create.show();
        window.setLayout((this.parent.getWindowManager().getDefaultDisplay().getWidth() * 4) / 5, this.parent.getWindowManager().getDefaultDisplay().getHeight() / 2);
        return create;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.wifi_connect_layout, viewGroup, false);
        this.wifiFunction = new com.flypro.core.util.e(this.parent.getApplicationContext());
        this.ipConfig = new SetIpManager(this.parent);
        this.results = new ArrayList();
        this.mDeviceListTitle = (TextView) inflate.findViewById(R.id.bt_device_list_title);
        this.mDevicePb = (ProgressBar) inflate.findViewById(R.id.bt_scan_progress_bar);
        this.newDeviceList = (RecyclerView) inflate.findViewById(R.id.paired_devices);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this.parent.getApplicationContext());
        linearLayoutManager.b(1);
        RecyclerView recyclerView = this.newDeviceList;
        recyclerView.setItemAnimator(new b(recyclerView));
        this.newDeviceList.setLayoutManager(linearLayoutManager);
        this.newDeviceList.setHasFixedSize(true);
        WifiListAdapter wifiListAdapter2 = new WifiListAdapter(this.parent, this.realWifiList);
        this.wifiListAdapter = wifiListAdapter2;
        wifiListAdapter2.setOnItemClickListener(this.itemClickListener);
        this.newDeviceList.setAdapter(this.wifiListAdapter);
        startScan();
        doScanWifi();
        IButton iButton = (IButton) inflate.findViewById(R.id.button_scan);
        this.scanBt = iButton;
        iButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                if (WifiConnectDlg.this.results.size() > 0) {
                    WifiConnectDlg.this.results.clear();
                }
                WifiConnectDlg.this.startScan();
                WifiConnectDlg.this.doScanWifi();
                view.setVisibility(8);
            }
        });
        IButton iButton2 = (IButton) inflate.findViewById(R.id.ib_ok);
        this.bt_ok = iButton2;
        iButton2.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                WifiConnectDlg.this.listener.onYes();
                WifiConnectDlg.this.dismiss();
            }
        });
        return inflate;
    }

    public void onPause() {
        super.onPause();
        this.parent.unregisterReceiver(this.mReceiver);
    }

    public void onResume() {
        super.onResume();
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.net.wifi.WIFI_STATE_CHANGED");
        intentFilter.addAction("android.net.wifi.STATE_CHANGE");
        intentFilter.addAction("android.net.wifi.SCAN_RESULTS");
        this.parent.registerReceiver(this.mReceiver, intentFilter);
    }

    public void wifiListChange() {
        doScanWifi();
        WifiInfo connectedWifiInfo = WifiSupport.getConnectedWifiInfo(this.parent);
        if (connectedWifiInfo != null) {
            wifiListSet(connectedWifiInfo.getSSID(), this.connectType);
        }
    }

    public void wifiListSet(String str, int i2) {
        int i3;
        HostManagerActivity hostManagerActivity;
        WifiBean wifiBean = new WifiBean();
        if (!CollectionUtils.isNullOrEmpty(this.realWifiList)) {
            for (int i4 = 0; i4 < this.realWifiList.size(); i4++) {
                this.realWifiList.get(i4).setState(this.parent.getString(R.string.disconnected));
            }
            Collections.sort(this.realWifiList);
            int i5 = -1;
            for (int i6 = 0; i6 < this.realWifiList.size(); i6++) {
                WifiBean wifiBean2 = this.realWifiList.get(i6);
                if (i5 == -1) {
                    if (("\"" + wifiBean2.getWifiName() + "\"").equals(str)) {
                        wifiBean.setLevel(wifiBean2.getLevel());
                        wifiBean.setWifiName(wifiBean2.getWifiName());
                        wifiBean.setCapabilities(wifiBean2.getCapabilities());
                        if (i2 == 1) {
                            hostManagerActivity = this.parent;
                            i3 = R.string.connected;
                        } else {
                            hostManagerActivity = this.parent;
                            i3 = R.string.connecting;
                        }
                        wifiBean.setState(hostManagerActivity.getString(i3));
                        i5 = i6;
                    }
                }
            }
            if (i5 != -1) {
                this.realWifiList.remove(i5);
                this.realWifiList.add(0, wifiBean);
                this.wifiListAdapter.notifyDataSetChanged();
            }
        }
    }
}
