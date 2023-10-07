package com.xeagle.android.login.amba.connectivity;

import android.content.Context;
import android.net.DhcpInfo;
import android.net.wifi.WifiManager;
import android.util.Log;
import com.flypro.core.drone.DroneInterfaces;
import com.xeagle.android.utils.v;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.Arrays;
import java.util.Objects;
import jo.az;
import ka.a;
import org.greenrobot.eventbus.c;

public class CmdChannelWIFI extends CmdChannel {
    private static final int CONN_TIME_OUT = 3000;
    private static final int READ_TIME_OUT = 5000;
    private static final String TAG = "CmdChannelWIFI";
    private static final int WAKEUP_MAX_TRY = 1;
    private Context context;
    private DroneInterfaces.b handler;
    Runnable heartRunnable = new Runnable() {
        public void run() {
            CmdChannelWIFI.this.sendHeart();
        }
    };
    private IChannelListener listener;
    private byte[] mBuffer = new byte[1024];
    private String mHostName;
    private InputStream mInputStream;
    private OutputStream mOutputStream;
    private int mPortNum;
    private Socket mSocket;
    private v tcpListener;

    public CmdChannelWIFI(Context context2, IChannelListener iChannelListener, DroneInterfaces.b bVar) {
        super(context2, iChannelListener);
        this.context = context2;
        this.listener = iChannelListener;
        this.handler = bVar;
    }

    private static InetAddress getBroadcastAddress(WifiManager wifiManager) throws IOException {
        DhcpInfo dhcpInfo = wifiManager.getDhcpInfo();
        int i2 = (dhcpInfo.netmask ^ -1) | (dhcpInfo.ipAddress & dhcpInfo.netmask);
        byte[] bArr = new byte[4];
        for (int i3 = 0; i3 < 4; i3++) {
            bArr[i3] = (byte) ((i2 >> (i3 * 8)) & 255);
        }
        return InetAddress.getByAddress(bArr);
    }

    public boolean connect() {
        Socket socket = this.mSocket;
        if (socket != null) {
            try {
                socket.close();
            } catch (IOException e2) {
                e2.printStackTrace();
            }
            this.mSocket = null;
        }
        Log.e(TAG, "Connecting...");
        try {
            Socket socket2 = new Socket();
            socket2.connect(new InetSocketAddress(this.mHostName, this.mPortNum), CONN_TIME_OUT);
            this.mSocket = socket2;
            this.mInputStream = socket2.getInputStream();
            this.mOutputStream = this.mSocket.getOutputStream();
            startIO();
            v vVar = this.tcpListener;
            if (vVar != null) {
                vVar.a(1);
            }
            return true;
        } catch (IOException e3) {
            String message = e3.getMessage();
            Objects.requireNonNull(message);
            Log.e("CmdChannel", message);
            v vVar2 = this.tcpListener;
            if (vVar2 == null) {
                return false;
            }
            String message2 = e3.getMessage();
            Objects.requireNonNull(message2);
            vVar2.a(1, message2);
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public String readFromChannel() {
        try {
            InputStream inputStream = this.mInputStream;
            if (inputStream == null) {
                return null;
            }
            return new String(this.mBuffer, 0, inputStream.read(this.mBuffer));
        } catch (IOException e2) {
            e2.printStackTrace();
            Log.i("CmdChannel", "readFromChannel:----error---- " + e2.getMessage());
            if (e2.getMessage() != null && e2.getMessage().equalsIgnoreCase("Connection reset")) {
                c.a().d(new az(true));
            }
            this.listener.onChannelEvent(IChannelListener.CMD_CHANNEL_ERROR_BROKEN_CHANNEL, 0, new String[0]);
            return null;
        }
    }

    public void sendHeart() {
        a.a().b().execute(new Runnable() {
            public void run() {
                String heartStr = CmdChannelWIFI.this.getHeartStr();
                Log.i("CmdChannel", "run: ---sendHeart==" + heartStr);
                CmdChannelWIFI.this.writeToChannel(heartStr.getBytes());
            }
        });
        this.handler.removeCallbacks(this.heartRunnable);
        this.handler.postDelayed(this.heartRunnable, 30000);
    }

    public CmdChannelWIFI setIP(String str, int i2) {
        this.mHostName = str;
        this.mPortNum = i2;
        return this;
    }

    public void setTcpListener(v vVar) {
        this.tcpListener = vVar;
    }

    public boolean wakeup(WifiManager wifiManager, String str, int i2, int i3) {
        this.listener.onChannelEvent(34, (Object) null, new String[0]);
        try {
            InetAddress byName = InetAddress.getByName("172.50.10.1");
            int i4 = 0;
            while (i4 < 1) {
                try {
                    Log.e(TAG, "bcAddr is " + byName.toString());
                    DatagramSocket datagramSocket = new DatagramSocket(i2);
                    Log.e(TAG, "created socket " + datagramSocket.toString());
                    DatagramPacket datagramPacket = new DatagramPacket(str.getBytes(), str.length(), byName, i3);
                    Log.e(TAG, "created packet " + datagramPacket.toString());
                    datagramSocket.send(datagramPacket);
                    Log.e(TAG, "Sent the wakeup message ");
                    byte[] bArr = new byte[1024];
                    datagramSocket.setSoTimeout(5000);
                    DatagramPacket datagramPacket2 = new DatagramPacket(bArr, 1024);
                    datagramSocket.receive(datagramPacket2);
                    byte[] copyOf = Arrays.copyOf(bArr, datagramPacket2.getLength());
                    Log.e(TAG, "Received message " + new String(copyOf, "UTF-8"));
                    datagramSocket.close();
                    this.listener.onChannelEvent(35, (Object) null, new String[0]);
                    return true;
                } catch (IOException e2) {
                    e2.printStackTrace();
                    i4++;
                }
            }
            this.listener.onChannelEvent(IChannelListener.CMD_CHANNEL_ERROR_WAKEUP, (Object) null, new String[0]);
            return false;
        } catch (IOException e3) {
            Log.e(TAG, "Can't get broadcast address!!!");
            e3.printStackTrace();
            this.listener.onChannelEvent(IChannelListener.CMD_CHANNEL_ERROR_WAKEUP, (Object) null, new String[0]);
            return false;
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
            if (this.tcpListener != null) {
                Log.e("CmdChannel", "writeToChannel: ---" + e2.getMessage());
                this.tcpListener.b(1, e2.getMessage());
            }
        }
    }
}
