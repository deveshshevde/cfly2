package com.xeagle.android.login.amba.connectivity;

import android.util.Log;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;

public class DataChannelWIFI extends DataChannel {
    private static final int CONN_TIME_OUT = 3000;
    private static final int READ_TIME_OUT = 1000;
    private static final String TAG = "DataChannelWIFI";
    private String mHostName;
    private int mPortNum;
    private Socket mSocket;

    public DataChannelWIFI(IChannelListener iChannelListener) {
        super(iChannelListener);
    }

    public boolean connect() {
        if (this.mSocket != null) {
            Log.e(TAG, "close old socket");
            try {
                this.mSocket.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.mSocket = null;
        }
        Log.e(TAG, "Connecting to new socket...");
        try {
            Socket socket = new Socket();
            socket.connect(new InetSocketAddress(this.mHostName, this.mPortNum), CONN_TIME_OUT);
            socket.setSoTimeout(1000);
            setStream(socket.getInputStream(), socket.getOutputStream());
            this.mSocket = socket;
            return true;
        } catch (IOException e3) {
            Log.e(TAG, e3.getMessage());
            this.mListener.onChannelEvent(4, "Can't connect to " + this.mHostName + "/" + this.mPortNum, new String[0]);
            return false;
        }
    }

    public DataChannelWIFI setIP(String str, int i2) {
        this.mHostName = str;
        this.mPortNum = i2;
        return this;
    }
}
