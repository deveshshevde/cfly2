package com.xeagle.android.login.amba.connectivity;

import android.content.Context;
import android.util.Log;
import com.hoho.android.usb.usb.data_proxy.log.b;
import com.xeagle.android.XEagleApp;
import ha.f;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.concurrent.LinkedBlockingQueue;
import ka.a;
import org.greenrobot.eventbus.ThreadMode;
import org.greenrobot.eventbus.c;
import org.greenrobot.eventbus.l;

public class UsbDataChannel {
    private static final int PROGRESS_MIN_STEP = 1;
    private static final String TAG = "RTSP";
    private LinkedBlockingQueue<byte[]> dataQueue = new LinkedBlockingQueue<>();
    protected boolean mContinueRx;
    protected boolean mContinueTx;
    protected IChannelListener mListener;
    protected int mTxBytes;
    protected final Object mTxLock = new Object();
    private XEagleApp xEagleApp;

    public UsbDataChannel(Context context, IChannelListener iChannelListener) {
        this.mListener = iChannelListener;
        this.xEagleApp = (XEagleApp) context.getApplicationContext();
    }

    /* access modifiers changed from: private */
    public void rxStream(String str, int i2) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            this.mListener.onChannelEvent(512, Integer.valueOf(i2), new String[0]);
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                try {
                    Log.i(TAG, "rxStream: ===get data=====");
                    byte[] take = this.dataQueue.take();
                    Log.i(TAG, "rxStream: ======" + take.length);
                    fileOutputStream.write(take, 0, take.length);
                    i3 += take.length;
                    int i5 = (int) ((((long) i3) * 100) / ((long) i2));
                    if (i5 - i4 >= 1) {
                        this.mListener.onChannelEvent(IChannelListener.DATA_CHANNEL_EVENT_GET_PROGRESS, Integer.valueOf(i3), new String[0]);
                        i4 = i5;
                    }
                } catch (Exception e2) {
                    Log.e(TAG, "RX canceled=====" + e2.getMessage());
                    if (!this.mContinueRx) {
                        fileOutputStream.close();
                        return;
                    }
                }
            }
            fileOutputStream.close();
            this.mListener.onChannelEvent(IChannelListener.DATA_CHANNEL_EVENT_GET_FINISH, str, new String[0]);
        } catch (Exception e3) {
            Log.i(TAG, "rxStream: ====IOExce===" + e3.getMessage());
            e3.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void txStream(String str) {
        try {
            byte[] bArr = new byte[1024];
            File file = new File(str);
            FileInputStream fileInputStream = new FileInputStream(file);
            int length = (int) file.length();
            b.e(TAG, "txStream===size===" + length, new Object[0]);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (!this.mContinueTx) {
                    break;
                }
                int read = fileInputStream.read(bArr);
                b.e(TAG, "txStream===read===" + read, new Object[0]);
                if (read <= 0) {
                    break;
                }
                this.xEagleApp.f().b(bArr);
                this.mTxBytes += read;
                b.e(TAG, "===txStream===progress==" + read, new Object[0]);
                i2 += read;
                int i4 = (int) ((((long) i2) * 100) / ((long) length));
                if (i4 - i3 >= 1) {
                    this.mListener.onChannelEvent(516, Integer.valueOf(i2), new String[0]);
                    i3 = i4;
                }
            }
            fileInputStream.close();
            if (this.mContinueTx) {
                this.mListener.onChannelEvent(IChannelListener.DATA_CHANNEL_EVENT_PUT_FINISH, str, new String[0]);
                return;
            }
            synchronized (this.mTxLock) {
                this.mTxLock.notify();
            }
        } catch (Exception e2) {
            b.h(TAG, "txStream===exception===" + e2.getMessage(), new Object[0]);
            e2.printStackTrace();
        }
    }

    public void cancelGetFile() {
        this.mContinueRx = false;
    }

    public int cancelPutFile() {
        this.mContinueTx = false;
        synchronized (this.mTxLock) {
            try {
                this.mTxLock.wait();
            } catch (InterruptedException e2) {
                e2.printStackTrace();
            }
        }
        return this.mTxBytes;
    }

    public void getFile(final String str, final int i2) {
        this.mContinueRx = true;
        a.a().b().execute(new Runnable() {
            public void run() {
                UsbDataChannel.this.rxStream(str, i2);
            }
        });
    }

    public void putFile(final String str) {
        this.mContinueTx = true;
        a.a().b().execute(new Runnable() {
            public void run() {
                UsbDataChannel.this.txStream(str);
            }
        });
    }

    public void registerEventbus() {
        if (!c.a().b(this)) {
            c.a().a((Object) this);
        }
    }

    public void unRegisterEventbus() {
        if (c.a().b(this)) {
            c.a().c(this);
        }
    }

    @l(a = ThreadMode.BACKGROUND)
    public void usbTcpDataEvent(f fVar) {
        if (fVar.b() == 5 && !this.dataQueue.offer(fVar.a())) {
            b.h(TAG, "===DATA DOWNLOAD FAIL", new Object[0]);
        }
    }
}
