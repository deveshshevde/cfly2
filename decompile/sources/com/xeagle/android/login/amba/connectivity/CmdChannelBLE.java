package com.xeagle.android.login.amba.connectivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothGattCallback;
import android.bluetooth.BluetoothGattCharacteristic;
import android.content.Context;
import android.util.Log;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;

public class CmdChannelBLE extends CmdChannel {
    private static final UUID AMBA_CHARACTERISTIC_INPUT_0 = UUID.fromString("00003333-0000-1000-8000-00805f9b34fb");
    private static final UUID AMBA_CHARACTERISTIC_INPUT_1 = UUID.fromString("33333333-616d-6261-5f69-645f62617365");
    private static final UUID AMBA_CHARACTERISTIC_OUTPUT_0 = UUID.fromString("00001111-0000-1000-8000-00805f9b34fb");
    private static final UUID AMBA_CHARACTERISTIC_OUTPUT_1 = UUID.fromString("11111111-616d-6261-5f69-645f62617365");
    private static final UUID AMBA_SERVICE_0 = UUID.fromString("00000000-0000-1000-8000-00805f9b34fb");
    private static final UUID AMBA_SERVICE_1 = UUID.fromString("00000000-616d-6261-5f69-645f62617365");
    private static final UUID CLIENT_CHARACTERISTIC_CONFIG = UUID.fromString("00002902-0000-1000-8000-00805f9b34fb");
    private static final String TAG = "CmdChannelBLE";
    /* access modifiers changed from: private */
    public static final ScheduledExecutorService worker = Executors.newSingleThreadScheduledExecutor();
    /* access modifiers changed from: private */
    public IChannelListener listener;
    /* access modifiers changed from: private */
    public BluetoothDevice mBluetoothDevice;
    /* access modifiers changed from: private */
    public BluetoothGatt mBluetoothGatt;
    /* access modifiers changed from: private */
    public Context mContext;
    private String mDeviceAddr;
    /* access modifiers changed from: private */
    public final BluetoothGattCallback mGattCallback = new BluetoothGattCallback() {
        public void onCharacteristicChanged(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic) {
            try {
                CmdChannelBLE.this.mNotificationQueue.put(bluetoothGattCharacteristic.getValue());
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }

        public void onCharacteristicRead(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            if (i2 == 0) {
                Log.e(CmdChannelBLE.TAG, "onCharacteristicRead " + new String(bluetoothGattCharacteristic.getValue()));
                Log.e(CmdChannelBLE.TAG, "onCharacteristicRead " + Arrays.toString(bluetoothGattCharacteristic.getValue()));
            }
        }

        public void onCharacteristicWrite(BluetoothGatt bluetoothGatt, BluetoothGattCharacteristic bluetoothGattCharacteristic, int i2) {
            if (i2 == 0) {
                Log.e(CmdChannelBLE.TAG, "onCharacteristicWrite " + bluetoothGattCharacteristic.getValue().length);
                CmdChannelBLE cmdChannelBLE = CmdChannelBLE.this;
                CmdChannelBLE.access$512(cmdChannelBLE, cmdChannelBLE.mMtuSize);
                if (CmdChannelBLE.this.mOutgoingIndex < CmdChannelBLE.this.mOutgoingTotal) {
                    CmdChannelBLE.this.mGattOutput.setValue(Arrays.copyOfRange(CmdChannelBLE.this.mOutgoingMsg, CmdChannelBLE.this.mOutgoingIndex, CmdChannelBLE.this.mOutgoingIndex + Math.min(CmdChannelBLE.this.mOutgoingTotal - CmdChannelBLE.this.mOutgoingIndex, CmdChannelBLE.this.mMtuSize)));
                    CmdChannelBLE.this.mBluetoothGatt.writeCharacteristic(CmdChannelBLE.this.mGattOutput);
                    return;
                }
                return;
            }
            Log.e(CmdChannelBLE.TAG, "onCharacteristicWrite failure " + i2);
        }

        public void onConnectionStateChange(BluetoothGatt bluetoothGatt, int i2, int i3) {
            Log.e(CmdChannelBLE.TAG, "Gattcallback onConnectionStateChanged, status(" + i2 + "), newState(" + i3 + ")");
            if (i3 == 2) {
                Log.e(CmdChannelBLE.TAG, "Connected to GATT server.");
                Log.e(CmdChannelBLE.TAG, "Attempting to start service discovery:" + CmdChannelBLE.this.mBluetoothGatt.discoverServices());
            } else if (i3 == 0) {
                Log.e(CmdChannelBLE.TAG, "Disconnected from GATT server.");
                CmdChannelBLE.this.disConnect();
                CmdChannelBLE.this.listener.onChannelEvent(IChannelListener.CMD_CHANNEL_ERROR_BROKEN_CHANNEL, (Object) null, new String[0]);
            }
        }

        public void onServicesDiscovered(BluetoothGatt bluetoothGatt, int i2) {
            if (i2 == 0) {
                CmdChannelBLE.this.mScheduledFuture.cancel(true);
                CmdChannelBLE.this.getAmbaCharacristics();
                return;
            }
            Log.e(CmdChannelBLE.TAG, "onServicesDiscovered received: " + i2);
        }
    };
    private BluetoothGattCharacteristic mGattInput;
    private final Object mGattLock;
    /* access modifiers changed from: private */
    public BluetoothGattCharacteristic mGattOutput;
    /* access modifiers changed from: private */
    public int mMtuSize;
    /* access modifiers changed from: private */
    public LinkedBlockingQueue<byte[]> mNotificationQueue = new LinkedBlockingQueue<>(32);
    /* access modifiers changed from: private */
    public int mOutgoingIndex;
    /* access modifiers changed from: private */
    public byte[] mOutgoingMsg;
    /* access modifiers changed from: private */
    public int mOutgoingTotal;
    /* access modifiers changed from: private */
    public ScheduledFuture<?> mScheduledFuture;

    public CmdChannelBLE(IChannelListener iChannelListener) {
        super(iChannelListener);
        this.listener = iChannelListener;
        this.mGattLock = new Object();
    }

    static /* synthetic */ int access$512(CmdChannelBLE cmdChannelBLE, int i2) {
        int i3 = cmdChannelBLE.mOutgoingIndex + i2;
        cmdChannelBLE.mOutgoingIndex = i3;
        return i3;
    }

    private boolean connect(String str) {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!defaultAdapter.isEnabled()) {
            this.listener.onChannelEvent(IChannelListener.CMD_CHANNEL_ERROR_BLE_DISABLED, (Object) null, new String[0]);
            return false;
        }
        BluetoothDevice remoteDevice = defaultAdapter.getRemoteDevice(str);
        this.mBluetoothDevice = remoteDevice;
        this.mBluetoothGatt = remoteDevice.connectGatt(this.mContext, false, this.mGattCallback);
        this.listener.onChannelEvent(32, (Object) null, new String[0]);
        this.mScheduledFuture = worker.schedule(new Runnable() {
            public void run() {
                CmdChannelBLE.this.disConnect();
                CmdChannelBLE cmdChannelBLE = CmdChannelBLE.this;
                BluetoothGatt unused = cmdChannelBLE.mBluetoothGatt = cmdChannelBLE.mBluetoothDevice.connectGatt(CmdChannelBLE.this.mContext, false, CmdChannelBLE.this.mGattCallback);
                ScheduledFuture unused2 = CmdChannelBLE.this.mScheduledFuture = CmdChannelBLE.worker.schedule(new Runnable() {
                    public void run() {
                        CmdChannelBLE.this.disConnect();
                        CmdChannelBLE.this.listener.onChannelEvent(IChannelListener.CMD_CHANNEL_ERROR_CONNECT, (Object) null, new String[0]);
                    }
                }, 30, TimeUnit.SECONDS);
            }
        }, 5, TimeUnit.SECONDS);
        try {
            synchronized (this.mGattLock) {
                this.mGattLock.wait();
            }
            if (this.mGattOutput == null || this.mGattInput == null) {
                Log.e(TAG, "Can't find target amba characteristics");
                return false;
            }
            this.listener.onChannelEvent(13, (Object) null, new String[0]);
            Log.e(TAG, "connnection established");
            this.mBluetoothGatt.setCharacteristicNotification(this.mGattInput, true);
            this.mDeviceAddr = str;
            startIO();
            return true;
        } catch (InterruptedException unused) {
            return false;
        }
    }

    /* access modifiers changed from: private */
    public void disConnect() {
        BluetoothGatt bluetoothGatt = this.mBluetoothGatt;
        if (bluetoothGatt != null) {
            bluetoothGatt.close();
            this.mBluetoothGatt = null;
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0096, code lost:
        r5.mMtuSize = r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void getAmbaCharacristics() {
        /*
            r5 = this;
            android.bluetooth.BluetoothGatt r0 = r5.mBluetoothGatt
            java.util.List r0 = r0.getServices()
            r1 = 0
            r5.mGattOutput = r1
            r5.mGattInput = r1
            java.util.Iterator r0 = r0.iterator()
        L_0x000f:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00f7
            java.lang.Object r1 = r0.next()
            android.bluetooth.BluetoothGattService r1 = (android.bluetooth.BluetoothGattService) r1
            java.lang.String r2 = "CmdChannelBLE"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Service: "
            r3.append(r4)
            java.util.UUID r4 = r1.getUuid()
            java.lang.String r4 = r4.toString()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r2, r3)
            java.util.UUID r2 = r1.getUuid()
            java.util.UUID r3 = AMBA_SERVICE_0
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0099
            java.util.List r0 = r1.getCharacteristics()
            java.util.Iterator r0 = r0.iterator()
        L_0x004d:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x0094
            java.lang.Object r1 = r0.next()
            android.bluetooth.BluetoothGattCharacteristic r1 = (android.bluetooth.BluetoothGattCharacteristic) r1
            java.lang.String r2 = "CmdChannelBLE"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "characteristic0: "
            r3.append(r4)
            java.util.UUID r4 = r1.getUuid()
            java.lang.String r4 = r4.toString()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r2, r3)
            java.util.UUID r2 = r1.getUuid()
            java.util.UUID r3 = AMBA_CHARACTERISTIC_OUTPUT_0
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0085
            r5.mGattOutput = r1
        L_0x0085:
            java.util.UUID r2 = r1.getUuid()
            java.util.UUID r3 = AMBA_CHARACTERISTIC_INPUT_0
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x004d
            r5.mGattInput = r1
            goto L_0x004d
        L_0x0094:
            r0 = 509(0x1fd, float:7.13E-43)
        L_0x0096:
            r5.mMtuSize = r0
            goto L_0x00f7
        L_0x0099:
            java.util.UUID r2 = r1.getUuid()
            java.util.UUID r3 = AMBA_SERVICE_1
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x000f
            java.util.List r0 = r1.getCharacteristics()
            java.util.Iterator r0 = r0.iterator()
        L_0x00ad:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x00f4
            java.lang.Object r1 = r0.next()
            android.bluetooth.BluetoothGattCharacteristic r1 = (android.bluetooth.BluetoothGattCharacteristic) r1
            java.lang.String r2 = "CmdChannelBLE"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "characteristic1: "
            r3.append(r4)
            java.util.UUID r4 = r1.getUuid()
            java.lang.String r4 = r4.toString()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.e(r2, r3)
            java.util.UUID r2 = r1.getUuid()
            java.util.UUID r3 = AMBA_CHARACTERISTIC_OUTPUT_1
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00e5
            r5.mGattOutput = r1
        L_0x00e5:
            java.util.UUID r2 = r1.getUuid()
            java.util.UUID r3 = AMBA_CHARACTERISTIC_INPUT_1
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x00ad
            r5.mGattInput = r1
            goto L_0x00ad
        L_0x00f4:
            r0 = 18
            goto L_0x0096
        L_0x00f7:
            java.lang.Object r0 = r5.mGattLock
            monitor-enter(r0)
            java.lang.Object r1 = r5.mGattLock     // Catch:{ all -> 0x0101 }
            r1.notify()     // Catch:{ all -> 0x0101 }
            monitor-exit(r0)     // Catch:{ all -> 0x0101 }
            return
        L_0x0101:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0101 }
            goto L_0x0105
        L_0x0104:
            throw r1
        L_0x0105:
            goto L_0x0104
        */
        throw new UnsupportedOperationException("Method not decompiled: com.xeagle.android.login.amba.connectivity.CmdChannelBLE.getAmbaCharacristics():void");
    }

    public boolean connectTo(String str) {
        if (str.equals("00:00:00:00:00:00")) {
            this.listener.onChannelEvent(IChannelListener.CMD_CHANNEL_ERROR_BLE_INVALID_ADDR, (Object) null, new String[0]);
            return false;
        }
        Log.e(TAG, "Connecting to " + str);
        String str2 = this.mDeviceAddr;
        if (str2 != null && !str2.equals(str)) {
            disConnect();
        }
        return connect(str);
    }

    /* access modifiers changed from: protected */
    public String readFromChannel() {
        try {
            return new String(this.mNotificationQueue.take());
        } catch (InterruptedException e2) {
            e2.printStackTrace();
            return null;
        }
    }

    public CmdChannelBLE setContext(Context context) {
        this.mContext = context;
        return this;
    }

    /* access modifiers changed from: protected */
    public void writeToChannel(byte[] bArr) {
        if (this.mGattOutput != null) {
            byte[] copyOf = Arrays.copyOf(bArr, bArr.length);
            this.mOutgoingMsg = copyOf;
            this.mOutgoingIndex = 0;
            int length = copyOf.length;
            this.mOutgoingTotal = length;
            this.mGattOutput.setValue(Arrays.copyOfRange(copyOf, 0, Math.min(length, this.mMtuSize)));
            this.mBluetoothGatt.writeCharacteristic(this.mGattOutput);
        }
    }
}
