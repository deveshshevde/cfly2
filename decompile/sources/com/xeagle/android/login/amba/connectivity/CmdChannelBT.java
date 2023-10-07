package com.xeagle.android.login.amba.connectivity;

import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothSocket;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.UUID;

public class CmdChannelBT extends CmdChannel {
    private static final String TAG = "CmdChannelBT";
    private static final UUID UUID_CTRL = UUID.fromString("eeeccf74-680a-c514-d804-765fa0f7c5c9");
    private IChannelListener listener;
    private byte[] mBuffer = new byte[1024];
    private String mDeviceAddr;
    private InputStream mInputStream;
    private OutputStream mOutputStream;
    private BluetoothSocket mSocket;

    public CmdChannelBT(IChannelListener iChannelListener) {
        super(iChannelListener);
        this.listener = iChannelListener;
    }

    private void closeConnection() {
        BluetoothSocket bluetoothSocket = this.mSocket;
        if (bluetoothSocket != null) {
            try {
                bluetoothSocket.close();
            } catch (IOException unused) {
            }
            this.mSocket = null;
        }
    }

    private boolean openConnection() {
        BluetoothAdapter defaultAdapter = BluetoothAdapter.getDefaultAdapter();
        if (!defaultAdapter.isEnabled()) {
            return false;
        }
        for (BluetoothDevice next : defaultAdapter.getBondedDevices()) {
            if (next.getAddress().equals(this.mDeviceAddr)) {
                try {
                    BluetoothSocket createInsecureRfcommSocketToServiceRecord = next.createInsecureRfcommSocketToServiceRecord(UUID_CTRL);
                    createInsecureRfcommSocketToServiceRecord.connect();
                    if (createInsecureRfcommSocketToServiceRecord.isConnected()) {
                        this.mSocket = createInsecureRfcommSocketToServiceRecord;
                        this.mInputStream = createInsecureRfcommSocketToServiceRecord.getInputStream();
                        this.mOutputStream = this.mSocket.getOutputStream();
                        startIO();
                        return true;
                    }
                    Log.e(TAG, "BT ctrl channel can't connect");
                } catch (IOException e2) {
                    Log.e(TAG, "openConnection: " + e2.getMessage());
                }
            }
        }
        return false;
    }

    public boolean connectTo(String str) {
        String str2 = this.mDeviceAddr;
        if (str2 != null && !str2.equals(str)) {
            closeConnection();
        }
        this.mDeviceAddr = str;
        return openConnection();
    }

    /* access modifiers changed from: protected */
    public String readFromChannel() {
        try {
            InputStream inputStream = this.mInputStream;
            if (inputStream == null) {
                return "";
            }
            return new String(this.mBuffer, 0, inputStream.read(this.mBuffer));
        } catch (IOException e2) {
            e2.printStackTrace();
            return "";
        }
    }

    /* access modifiers changed from: protected */
    public void writeToChannel(byte[] bArr) {
        try {
            OutputStream outputStream = this.mOutputStream;
            if (outputStream != null) {
                outputStream.write(bArr);
            }
        } catch (IOException e2) {
            Log.e(TAG, e2.getMessage());
        }
    }
}
