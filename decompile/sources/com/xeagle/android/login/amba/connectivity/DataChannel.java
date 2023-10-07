package com.xeagle.android.login.amba.connectivity;

import android.util.Log;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.SocketTimeoutException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import ka.a;

public class DataChannel {
    private static final int PROGRESS_MIN_STEP = 1;
    private static final String TAG = "DataChannel";
    private static final ExecutorService worker = Executors.newSingleThreadExecutor();
    protected boolean mContinueRx;
    protected boolean mContinueTx;
    protected InputStream mInputStream;
    protected IChannelListener mListener;
    protected OutputStream mOutputStream;
    protected int mTxBytes;
    protected final Object mTxLock = new Object();

    public DataChannel(IChannelListener iChannelListener) {
        this.mListener = iChannelListener;
    }

    /* access modifiers changed from: private */
    public void rxStream(String str, int i2) {
        try {
            byte[] bArr = new byte[1024];
            FileOutputStream fileOutputStream = new FileOutputStream(str);
            this.mListener.onChannelEvent(512, Integer.valueOf(i2), new String[0]);
            int i3 = 0;
            int i4 = 0;
            while (i3 < i2) {
                try {
                    int read = this.mInputStream.read(bArr);
                    Log.e("RTSP", "read bytes " + read);
                    fileOutputStream.write(bArr, 0, read);
                    i3 += read;
                    int i5 = (int) ((((long) i3) * 100) / ((long) i2));
                    if (i5 - i4 >= 1) {
                        this.mListener.onChannelEvent(IChannelListener.DATA_CHANNEL_EVENT_GET_PROGRESS, Integer.valueOf(i3), new String[0]);
                        i4 = i5;
                    }
                } catch (SocketTimeoutException unused) {
                    if (!this.mContinueRx) {
                        Log.e(TAG, "RX canceled");
                        fileOutputStream.close();
                        return;
                    }
                } catch (ArrayIndexOutOfBoundsException unused2) {
                    if (!this.mContinueRx) {
                        Log.e(TAG, "RX canceled");
                        fileOutputStream.close();
                        return;
                    }
                }
            }
            fileOutputStream.close();
            this.mListener.onChannelEvent(IChannelListener.DATA_CHANNEL_EVENT_GET_FINISH, str, new String[0]);
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    public void txStream(String str) {
        try {
            byte[] bArr = new byte[1024];
            File file = new File(str);
            FileInputStream fileInputStream = new FileInputStream(file);
            int length = (int) file.length();
            this.mTxBytes = 0;
            this.mListener.onChannelEvent(IChannelListener.DATA_CHANNEL_EVENT_PUT_START, str, new String[0]);
            int i2 = 0;
            int i3 = 0;
            while (true) {
                if (!this.mContinueTx) {
                    break;
                }
                int read = fileInputStream.read(bArr);
                Log.i("CameraClient", "txStream:===read=== " + read);
                if (read <= 0) {
                    break;
                }
                this.mOutputStream.write(bArr, 0, read);
                this.mTxBytes += read;
                Log.i("CameraClient", "txStream: ----progress---" + read);
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
            Log.i("CameraClient", "txStream:----exception--- " + e2.getMessage());
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
        worker.execute(new Runnable() {
            public void run() {
                DataChannel.this.rxStream(str, i2);
            }
        });
    }

    public void putFile(final String str) {
        this.mContinueTx = true;
        a.a().b().execute(new Runnable() {
            public void run() {
                DataChannel.this.txStream(str);
            }
        });
    }

    public DataChannel setStream(InputStream inputStream, OutputStream outputStream) {
        this.mInputStream = inputStream;
        this.mOutputStream = outputStream;
        return this;
    }
}
