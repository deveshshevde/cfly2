package com.huawei.android.multiscreen.mirror.sdk.ui;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.huawei.android.multiscreen.R;
import com.huawei.android.multiscreen.dlna.sdk.dlnamanager.ELogLevel;
import com.huawei.android.multiscreen.dlna.sdk.dlnamanager.b;
import com.huawei.android.multiscreen.mirror.sdk.api.EMirrorLogLevel;
import com.huawei.android.multiscreen.mirror.sdk.api.IMRDiscoveryCallback;
import com.huawei.android.multiscreen.mirror.sdk.api.IMRSourceCallback;
import com.huawei.android.multiscreen.mirror.sdk.api.MRComponentManager;
import com.huawei.android.multiscreen.mirror.sdk.api.MRDiscovery;
import com.huawei.android.multiscreen.mirror.sdk.api.MRSource;
import com.huawei.android.multiscreen.mirror.sdk.structs.SDeviceDescription;
import com.huawei.android.multiscreen.mirror.sdk.structs.SDiscoveryProperty;
import com.huawei.android.multiscreen.mirror.sdk.structs.SSourceProperty;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class MirrorSenderActivity extends Activity {
    private static final int DISCOVERY_ERROR = 12;
    private static final int DISCOVERY_STARTED = 10;
    private static final int DISCOVERY_STOPPED = 11;
    private static final int DISCOVERY_UPDATED = 13;
    private static final int SOURCE_CLOSE_BY_SINK = 27;
    private static final int SOURCE_CONNECTED = 25;
    private static final int SOURCE_DISCONNECTED = 26;
    private static final int SOURCE_ERROR = 22;
    private static final int SOURCE_ON_CONNECTING = 28;
    private static final int SOURCE_PAUSED = 23;
    private static final int SOURCE_RESUMED = 24;
    private static final int SOURCE_STARTED = 20;
    private static final int SOURCE_STOPPED = 21;
    private static final String TAG = "MIRROR_SDK";
    /* access modifiers changed from: private */
    public boolean mAbortStopTest;
    /* access modifiers changed from: private */
    public DeviceListAdapter mAdapter;
    Context mContext;
    private ListView mDeviceList;
    private Button mDisconnect;
    /* access modifiers changed from: private */
    public MRDiscovery mDiscovery;
    /* access modifiers changed from: private */
    public EditText mEditIP;
    /* access modifiers changed from: private */
    public Handler mHander = new Handler(new Handler.Callback() {
        public boolean handleMessage(Message message) {
            TextView textView;
            String str;
            MirrorSenderActivity mirrorSenderActivity = MirrorSenderActivity.this;
            mirrorSenderActivity.mContext = mirrorSenderActivity.getApplicationContext();
            int i2 = message.what;
            switch (i2) {
                case 10:
                    textView = MirrorSenderActivity.this.mMessageText;
                    str = "IMRDiscoveryCallback Started";
                    break;
                case 11:
                    textView = MirrorSenderActivity.this.mMessageText;
                    str = "IMRDiscoveryCallback Stopped";
                    break;
                case 12:
                    int i3 = message.arg1;
                    TextView access$0 = MirrorSenderActivity.this.mMessageText;
                    access$0.setText("IMRDiscoveryCallback Error:code " + i3 + ",msg " + ((String) message.obj));
                    break;
                case 13:
                    Toast.makeText(MirrorSenderActivity.this.mContext, "IMRDiscoveryCallback DeviceListUpdated", 0).show();
                    ArrayList arrayList = new ArrayList(Arrays.asList((SDeviceDescription[]) message.obj));
                    MirrorSenderActivity.this.mAdapter.setDeviceList(arrayList);
                    MirrorSenderActivity.this.mAdapter.notifyDataSetChanged();
                    if (arrayList.size() != 0) {
                        Log.d(MirrorSenderActivity.TAG, "DISCOVERY_UPDATED :: " + String.valueOf(((SDeviceDescription) arrayList.get(0)).c()));
                        MirrorSenderActivity.this.mEditIP.setText(((SDeviceDescription) arrayList.get(0)).a());
                        break;
                    }
                    break;
                default:
                    switch (i2) {
                        case 20:
                            textView = MirrorSenderActivity.this.mMessageText;
                            str = "IMRSourceCallback Started";
                            break;
                        case 21:
                            textView = MirrorSenderActivity.this.mMessageText;
                            str = "IMRSourceCallback Stopped";
                            break;
                        case 22:
                            int i4 = message.arg1;
                            Context context = MirrorSenderActivity.this.mContext;
                            Toast.makeText(context, "IMRSourceCallback Error:code " + i4 + ",msg " + ((String) message.obj), 0).show();
                            break;
                        case 23:
                            textView = MirrorSenderActivity.this.mMessageText;
                            str = "Paused";
                            break;
                        case 24:
                            textView = MirrorSenderActivity.this.mMessageText;
                            str = "Resumed";
                            break;
                        case 25:
                            textView = MirrorSenderActivity.this.mMessageText;
                            str = "Connected";
                            break;
                        case 26:
                            textView = MirrorSenderActivity.this.mMessageText;
                            str = "Disconnected";
                            break;
                        case 27:
                            textView = MirrorSenderActivity.this.mMessageText;
                            str = "MirrorClosedBySink";
                            break;
                        case 28:
                            textView = MirrorSenderActivity.this.mMessageText;
                            str = "OnConnecting";
                            break;
                    }
            }
            textView.setText(str);
            return false;
        }
    });
    private MRComponentManager mManager;
    /* access modifiers changed from: private */
    public TextView mMessageText;
    private Button mMute;
    private Button mPause;
    private Button mRefresh;
    private Button mResume;
    /* access modifiers changed from: private */
    public MRSource mSource;
    private Button mStabilityTest;
    private Button mStart;
    private Button mStop;
    private Button mStopTest;

    private class DeviceListAdapter extends BaseAdapter {
        private List<SDeviceDescription> mDevices = new ArrayList();

        private class ViewHolder {
            public TextView mTextIPAddress;
            public TextView mTextName;

            private ViewHolder() {
            }

            /* synthetic */ ViewHolder(DeviceListAdapter deviceListAdapter, ViewHolder viewHolder) {
                this();
            }
        }

        public DeviceListAdapter() {
        }

        public int getCount() {
            return this.mDevices.size();
        }

        public SDeviceDescription getItem(int i2) {
            return this.mDevices.get(i2);
        }

        public long getItemId(int i2) {
            return (long) i2;
        }

        public View getView(int i2, View view, ViewGroup viewGroup) {
            ViewHolder viewHolder = new ViewHolder(this, (ViewHolder) null);
            if (view == null) {
                view = LayoutInflater.from(MirrorSenderActivity.this.getApplicationContext()).inflate(R.layout.list_device, (ViewGroup) null);
                viewHolder.mTextName = (TextView) view.findViewById(R.id.text_name);
                viewHolder.mTextIPAddress = (TextView) view.findViewById(R.id.text_ip);
                view.setTag(viewHolder);
            } else {
                viewHolder = (ViewHolder) view.getTag();
            }
            SDeviceDescription sDeviceDescription = this.mDevices.get(i2);
            if (sDeviceDescription != null) {
                viewHolder.mTextName.setText(sDeviceDescription.b());
                TextView textView = viewHolder.mTextIPAddress;
                textView.setText(String.valueOf(sDeviceDescription.a()) + "  Version: " + String.valueOf(sDeviceDescription.c()));
            }
            return view;
        }

        public void setDeviceList(List<SDeviceDescription> list) {
            this.mDevices = list;
        }
    }

    private class DiscoveryCallBackImpl implements IMRDiscoveryCallback {
        private DiscoveryCallBackImpl() {
        }

        /* synthetic */ DiscoveryCallBackImpl(MirrorSenderActivity mirrorSenderActivity, DiscoveryCallBackImpl discoveryCallBackImpl) {
            this();
        }

        public int DeviceListUpdated(SDeviceDescription[] sDeviceDescriptionArr) {
            Message obtainMessage = MirrorSenderActivity.this.mHander.obtainMessage(13);
            obtainMessage.obj = sDeviceDescriptionArr;
            MirrorSenderActivity.this.mHander.sendMessage(obtainMessage);
            return 0;
        }

        public int Error(int i2, String str) {
            Message obtainMessage = MirrorSenderActivity.this.mHander.obtainMessage(12);
            obtainMessage.arg1 = i2;
            obtainMessage.obj = str;
            MirrorSenderActivity.this.mHander.sendMessage(obtainMessage);
            return 0;
        }

        public int Started() {
            MirrorSenderActivity.this.mHander.sendEmptyMessage(10);
            return 0;
        }

        public int Stopped() {
            MirrorSenderActivity.this.mHander.sendEmptyMessage(11);
            return 0;
        }
    }

    private class SourceCallBackImpl implements IMRSourceCallback {
        private SourceCallBackImpl() {
        }

        /* synthetic */ SourceCallBackImpl(MirrorSenderActivity mirrorSenderActivity, SourceCallBackImpl sourceCallBackImpl) {
            this();
        }

        public int Connected() {
            MirrorSenderActivity.this.mHander.sendEmptyMessage(25);
            return 0;
        }

        public int Disconnected() {
            MirrorSenderActivity.this.mHander.sendEmptyMessage(26);
            return 0;
        }

        public int Error(int i2, String str) {
            Message obtainMessage = MirrorSenderActivity.this.mHander.obtainMessage(22);
            obtainMessage.arg1 = i2;
            obtainMessage.obj = str;
            MirrorSenderActivity.this.mHander.sendMessage(obtainMessage);
            return 0;
        }

        public int MirrorClosedBySink() {
            MirrorSenderActivity.this.mHander.sendEmptyMessage(27);
            return 0;
        }

        public int OnConnecting() {
            MirrorSenderActivity.this.mHander.sendEmptyMessage(28);
            return 0;
        }

        public int Paused() {
            MirrorSenderActivity.this.mHander.sendEmptyMessage(23);
            return 0;
        }

        public int Resumed() {
            MirrorSenderActivity.this.mHander.sendEmptyMessage(24);
            return 0;
        }

        public int Started() {
            MirrorSenderActivity.this.mHander.sendEmptyMessage(20);
            return 0;
        }

        public int Stopped() {
            MirrorSenderActivity.this.mHander.sendEmptyMessage(21);
            return 0;
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.source_main);
        this.mEditIP = (EditText) findViewById(R.id.edit_ip);
        TextView textView = (TextView) findViewById(R.id.message);
        this.mMessageText = textView;
        textView.setTextColor(-256);
        this.mStart = (Button) findViewById(R.id.btn_start);
        this.mStop = (Button) findViewById(R.id.btn_stop);
        this.mDisconnect = (Button) findViewById(R.id.btn_disconnect);
        this.mPause = (Button) findViewById(R.id.btn_pause);
        this.mResume = (Button) findViewById(R.id.btn_resume);
        this.mRefresh = (Button) findViewById(R.id.btn_refresh);
        this.mMute = (Button) findViewById(R.id.btn_mute);
        this.mStabilityTest = (Button) findViewById(R.id.btn_test);
        this.mStopTest = (Button) findViewById(R.id.btn_stopTest);
        this.mDeviceList = (ListView) findViewById(R.id.list_device);
        DeviceListAdapter deviceListAdapter = new DeviceListAdapter();
        this.mAdapter = deviceListAdapter;
        this.mDeviceList.setAdapter(deviceListAdapter);
        MRComponentManager mRComponentManager = new MRComponentManager(this);
        this.mManager = mRComponentManager;
        mRComponentManager.a(EMirrorLogLevel.DEBUG);
        b.a().a(ELogLevel.TRACE);
        Log.d(TAG, "BUILD MRDiscovery");
        this.mManager.a("ICOS.MIRROR.DISCOVERY", false);
        Log.d(TAG, "BUILD MRSource");
        this.mManager.a("ICOS.MIRROR.SOURCE", false);
        Log.d(TAG, "GET MRDiscovery");
        this.mDiscovery = this.mManager.c();
        Log.d(TAG, "GET MRSource");
        this.mSource = this.mManager.d();
        IPManager iPManager = new IPManager(this);
        SDiscoveryProperty sDiscoveryProperty = new SDiscoveryProperty(iPManager.getIPAddress(), iPManager.getMacAddress());
        DiscoveryCallBackImpl discoveryCallBackImpl = new DiscoveryCallBackImpl(this, (DiscoveryCallBackImpl) null);
        this.mDiscovery.a(sDiscoveryProperty);
        this.mDiscovery.a((IMRDiscoveryCallback) discoveryCallBackImpl);
        SSourceProperty sSourceProperty = new SSourceProperty(false, true, "Source");
        SourceCallBackImpl sourceCallBackImpl = new SourceCallBackImpl(this, (SourceCallBackImpl) null);
        this.mSource.a(sSourceProperty);
        this.mSource.a((IMRSourceCallback) sourceCallBackImpl);
        this.mDiscovery.a();
        this.mSource.a();
        this.mStart.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d(MirrorSenderActivity.TAG, "Start Click");
                MirrorSenderActivity.this.mSource.a();
            }
        });
        this.mStop.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                Log.d(MirrorSenderActivity.TAG, "Stop Click");
                MirrorSenderActivity.this.mSource.b();
            }
        });
        this.mDisconnect.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int c2 = MirrorSenderActivity.this.mSource.c();
                if (c2 != 0) {
                    TextView access$0 = MirrorSenderActivity.this.mMessageText;
                    access$0.setText("disconnect ERROR " + c2 + "; Status = " + MirrorSenderActivity.this.mSource.d());
                }
            }
        });
        this.mPause.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        this.mResume.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
            }
        });
        this.mMute.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int e2 = MirrorSenderActivity.this.mSource.e();
                if (e2 != 0) {
                    TextView access$0 = MirrorSenderActivity.this.mMessageText;
                    access$0.setText("disconnect ERROR " + e2 + "; Status = " + MirrorSenderActivity.this.mSource.d());
                }
            }
        });
        this.mRefresh.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                int c2 = MirrorSenderActivity.this.mDiscovery.c();
                if (c2 != 0) {
                    TextView access$0 = MirrorSenderActivity.this.mMessageText;
                    access$0.setText("disconnect ERROR " + c2 + "; Status = " + MirrorSenderActivity.this.mSource.d());
                }
            }
        });
        this.mStopTest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MirrorSenderActivity.this.mAbortStopTest = true;
            }
        });
        this.mStabilityTest.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                new Thread(new Runnable() {
                    public void run() {
                        new Random();
                        MirrorSenderActivity.this.mAbortStopTest = false;
                        for (int i2 = 0; 10000 > i2 && !MirrorSenderActivity.this.mAbortStopTest; i2++) {
                            if (MirrorSenderActivity.this.mAdapter.getCount() > 0) {
                                MirrorSenderActivity.this.mSource.a(MirrorSenderActivity.this.mAdapter.getItem(0));
                            }
                            try {
                                Thread.sleep(1000);
                            } catch (InterruptedException e2) {
                                Log.e(MirrorSenderActivity.TAG, "Thread.sleep Exception", e2);
                            }
                        }
                    }
                }, "search lyric").start();
            }
        });
        this.mDeviceList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> adapterView, View view, int i2, long j2) {
                int a2 = MirrorSenderActivity.this.mSource.a(MirrorSenderActivity.this.mAdapter.getItem(i2));
                if (a2 != 0) {
                    TextView access$0 = MirrorSenderActivity.this.mMessageText;
                    access$0.setText("Connecte ERROR " + a2 + "; Status = " + MirrorSenderActivity.this.mSource.d());
                }
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        this.mDiscovery.b();
        this.mSource.b();
        this.mManager.a();
        super.onDestroy();
    }
}
