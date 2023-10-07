package com.xeagle.android.hicamera.net;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import org.json.JSONObject;
import org.json.JSONTokener;

public class MessageService extends Service {
    /* access modifiers changed from: private */

    /* renamed from: a  reason: collision with root package name */
    public ServerSocket f23626a = null;
    /* access modifiers changed from: private */

    /* renamed from: b  reason: collision with root package name */
    public volatile boolean f23627b = false;

    /* renamed from: c  reason: collision with root package name */
    private final Thread f23628c = new Thread("messageServerThread") {
        public void run() {
            do {
                try {
                    if (MessageService.this.f23626a != null && !MessageService.this.f23626a.isClosed()) {
                        MessageService.this.f23626a.close();
                    }
                    ServerSocket unused = MessageService.this.f23626a = new ServerSocket(5678);
                    MessageService.this.f23626a.setReuseAddress(true);
                    while (!MessageService.this.f23627b) {
                        Log.d("MessageService", "Server begin accept");
                        Socket accept = MessageService.this.f23626a.accept();
                        accept.setSoTimeout(3000);
                        new a(MessageService.this, accept).start();
                    }
                } catch (Exception e2) {
                    e2.printStackTrace();
                    Log.e("MessageService", e2.getClass().getSimpleName());
                }
            } while (!MessageService.this.f23627b);
        }
    };

    private static class a extends Thread {

        /* renamed from: a  reason: collision with root package name */
        private Context f23630a;

        /* renamed from: b  reason: collision with root package name */
        private Socket f23631b;

        public a(Context context, Socket socket) {
            this.f23630a = context;
            this.f23631b = socket;
        }

        public void run() {
            byte[] bArr = new byte[512];
            try {
                InputStream inputStream = this.f23631b.getInputStream();
                int i2 = 0;
                while (true) {
                    int read = inputStream.read(bArr, i2, 512 - i2);
                    if (read < 0) {
                        break;
                    }
                    i2 += read;
                }
                if (i2 > 0) {
                    String str = new String(bArr, 0, i2);
                    Log.d("MessageService", "Receive: " + str);
                    JSONObject jSONObject = (JSONObject) new JSONTokener(str).nextValue();
                    if (!jSONObject.equals(JSONObject.NULL)) {
                        Intent intent = new Intent("com.xeagle.MESSAGE_ACTION");
                        intent.putExtra("state", jSONObject.getInt("state"));
                        intent.putExtra("event", jSONObject.getInt("event"));
                        intent.putExtra("pasttime", jSONObject.getInt("pasttime"));
                        intent.putExtra("mode", jSONObject.getInt("mode"));
                        this.f23630a.sendBroadcast(intent);
                    }
                }
                try {
                    this.f23631b.close();
                } catch (IOException e2) {
                    e2.printStackTrace();
                }
            } catch (Exception e3) {
                e3.printStackTrace();
                Log.e("MessageService", e3.getClass().getSimpleName());
                this.f23631b.close();
            } catch (Throwable th) {
                try {
                    this.f23631b.close();
                } catch (IOException e4) {
                    e4.printStackTrace();
                }
                throw th;
            }
        }
    }

    public IBinder onBind(Intent intent) {
        return null;
    }

    public void onCreate() {
        super.onCreate();
    }

    public void onDestroy() {
        Log.d("MessageService", "onDestroy");
        this.f23627b = true;
        try {
            ServerSocket serverSocket = this.f23626a;
            if (serverSocket != null && !serverSocket.isClosed()) {
                this.f23626a.close();
            }
            Thread thread = this.f23628c;
            if (thread != null && thread.isAlive()) {
                this.f23628c.interrupt();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        super.onDestroy();
    }

    public int onStartCommand(Intent intent, int i2, int i3) {
        Log.d("MessageService", "onStartCommand");
        this.f23627b = false;
        if (this.f23628c.isAlive()) {
            return 1;
        }
        this.f23628c.start();
        return 1;
    }
}
