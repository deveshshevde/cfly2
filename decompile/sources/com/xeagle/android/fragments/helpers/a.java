package com.xeagle.android.fragments.helpers;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.c;
import com.cfly.uav_pro.R;
import com.xeagle.android.XEagleApp;
import java.util.Set;

public class a extends c {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public BluetoothAdapter f23389a;

    /* renamed from: b  reason: collision with root package name */
    private C0146a f23390b;
    /* access modifiers changed from: private */

    /* renamed from: c  reason: collision with root package name */
    public C0146a f23391c;
    /* access modifiers changed from: private */

    /* renamed from: d  reason: collision with root package name */
    public TextView f23392d;
    /* access modifiers changed from: private */

    /* renamed from: e  reason: collision with root package name */
    public ProgressBar f23393e;

    /* renamed from: f  reason: collision with root package name */
    private TextView f23394f;
    /* access modifiers changed from: private */

    /* renamed from: g  reason: collision with root package name */
    public TextView f23395g;

    /* renamed from: h  reason: collision with root package name */
    private final BroadcastReceiver f23396h = new BroadcastReceiver() {
        public void onReceive(Context context, Intent intent) {
            String action = intent.getAction();
            if ("android.bluetooth.device.action.FOUND".equals(action)) {
                BluetoothDevice bluetoothDevice = (BluetoothDevice) intent.getParcelableExtra("android.bluetooth.device.extra.DEVICE");
                if (bluetoothDevice.getBondState() != 12) {
                    a.this.f23391c.add(bluetoothDevice);
                }
            } else if ("android.bluetooth.adapter.action.DISCOVERY_FINISHED".equals(action)) {
                a.this.f23392d.setText(R.string.select_device);
                a.this.f23393e.setVisibility(4);
                if (a.this.f23391c.getCount() == 0) {
                    a.this.f23395g.setText(R.string.none_found);
                }
            }
        }
    };

    /* renamed from: i  reason: collision with root package name */
    private final AdapterView.OnItemClickListener f23397i = new AdapterView.OnItemClickListener() {
        public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
            a.this.f23389a.cancelDiscovery();
            BluetoothDevice bluetoothDevice = (BluetoothDevice) adapterView.getItemAtPosition(i2);
            com.xeagle.android.utils.prefs.a aVar = new com.xeagle.android.utils.prefs.a(a.this.getActivity().getApplicationContext());
            aVar.p(bluetoothDevice.getAddress() + ";" + bluetoothDevice.getName());
            ((XEagleApp) a.this.getActivity().getApplication()).k().j().a(13);
            a.this.dismiss();
        }
    };

    /* renamed from: com.xeagle.android.fragments.helpers.a$a  reason: collision with other inner class name */
    public static class C0146a extends ArrayAdapter<BluetoothDevice> {

        /* renamed from: a  reason: collision with root package name */
        private final LayoutInflater f23401a;

        public C0146a(Context context) {
            super(context, R.layout.list_device_name);
            this.f23401a = (LayoutInflater) context.getSystemService("layout_inflater");
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            if (view == null) {
                view = this.f23401a.inflate(R.layout.list_device_name, viewGroup, false);
            }
            TextView textView = (TextView) view;
            BluetoothDevice bluetoothDevice = (BluetoothDevice) getItem(i2);
            textView.setText(bluetoothDevice.getName() + "\n" + bluetoothDevice.getAddress());
            return textView;
        }
    }

    /* access modifiers changed from: private */
    public void a() {
        this.f23393e.setVisibility(0);
        this.f23392d.setText(R.string.scanning);
        this.f23395g.setVisibility(0);
        if (this.f23389a.isDiscovering()) {
            this.f23389a.cancelDiscovery();
        }
        this.f23389a.startDiscovery();
    }

    public void onActivityResult(int i2, int i3, Intent intent) {
        if (i2 != 111) {
            super.onActivityResult(i2, i3, intent);
        } else if (i3 == 0) {
            dismiss();
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(1, 0);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        FragmentActivity activity = getActivity();
        View inflate = layoutInflater.inflate(R.layout.fragment_bluetooth_device_list, viewGroup, false);
        this.f23389a = BluetoothAdapter.getDefaultAdapter();
        this.f23392d = (TextView) inflate.findViewById(R.id.bt_device_list_title);
        this.f23393e = (ProgressBar) inflate.findViewById(R.id.bt_scan_progress_bar);
        this.f23395g = (TextView) inflate.findViewById(R.id.title_new_devices);
        this.f23394f = (TextView) inflate.findViewById(R.id.title_paired_devices);
        ((Button) inflate.findViewById(R.id.button_scan)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                a.this.a();
                view.setVisibility(8);
            }
        });
        this.f23390b = new C0146a(activity);
        this.f23391c = new C0146a(activity);
        ListView listView = (ListView) inflate.findViewById(R.id.paired_devices);
        listView.setAdapter(this.f23390b);
        listView.setOnItemClickListener(this.f23397i);
        ListView listView2 = (ListView) inflate.findViewById(R.id.new_devices);
        listView2.setAdapter(this.f23391c);
        listView2.setOnItemClickListener(this.f23397i);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.bluetooth.device.action.FOUND");
        intentFilter.addAction("android.bluetooth.adapter.action.DISCOVERY_FINISHED");
        activity.registerReceiver(this.f23396h, intentFilter);
        return inflate;
    }

    public void onDestroy() {
        super.onDestroy();
        BluetoothAdapter bluetoothAdapter = this.f23389a;
        if (bluetoothAdapter != null) {
            bluetoothAdapter.cancelDiscovery();
        }
        getActivity().unregisterReceiver(this.f23396h);
    }

    public void onResume() {
        super.onResume();
        if (this.f23389a.isEnabled()) {
            Set<BluetoothDevice> bondedDevices = this.f23389a.getBondedDevices();
            if (bondedDevices.size() > 0) {
                this.f23394f.setVisibility(0);
                for (BluetoothDevice add : bondedDevices) {
                    this.f23390b.add(add);
                }
                return;
            }
            this.f23394f.setText(R.string.none_paired);
            return;
        }
        startActivityForResult(new Intent("android.bluetooth.adapter.action.REQUEST_ENABLE"), 111);
    }
}
