package com.hoho.android.usbserial.driver;

import android.hardware.usb.UsbDevice;
import android.hardware.usb.UsbDeviceConnection;
import android.hardware.usb.UsbEndpoint;
import android.hardware.usb.UsbRequest;
import android.util.Log;
import com.hoho.android.usbserial.driver.UsbSerialPort;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.EnumSet;

public abstract class CommonUsbSerialPort implements UsbSerialPort {
    private static final int DEFAULT_WRITE_BUFFER_SIZE = 16384;
    private static final int MAX_READ_SIZE = 16384;
    private static final String TAG = "CommonUsbSerialPort";
    protected UsbDeviceConnection mConnection = null;
    protected final UsbDevice mDevice;
    protected final int mPortNumber;
    protected UsbEndpoint mReadEndpoint;
    protected UsbRequest mUsbRequest;
    protected byte[] mWriteBuffer;
    protected final Object mWriteBufferLock = new Object();
    protected UsbEndpoint mWriteEndpoint;

    public CommonUsbSerialPort(UsbDevice usbDevice, int i2) {
        this.mDevice = usbDevice;
        this.mPortNumber = i2;
        this.mWriteBuffer = new byte[16384];
    }

    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:8:0x000f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void close() throws java.io.IOException {
        /*
            r2 = this;
            android.hardware.usb.UsbDeviceConnection r0 = r2.mConnection
            if (r0 == 0) goto L_0x0017
            android.hardware.usb.UsbRequest r0 = r2.mUsbRequest     // Catch:{ Exception -> 0x0009 }
            r0.cancel()     // Catch:{ Exception -> 0x0009 }
        L_0x0009:
            r0 = 0
            r2.mUsbRequest = r0
            r2.closeInt()     // Catch:{ Exception -> 0x000f }
        L_0x000f:
            android.hardware.usb.UsbDeviceConnection r1 = r2.mConnection     // Catch:{ Exception -> 0x0014 }
            r1.close()     // Catch:{ Exception -> 0x0014 }
        L_0x0014:
            r2.mConnection = r0
            return
        L_0x0017:
            java.io.IOException r0 = new java.io.IOException
            java.lang.String r1 = "Already closed"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.hoho.android.usbserial.driver.CommonUsbSerialPort.close():void");
    }

    /* access modifiers changed from: protected */
    public abstract void closeInt();

    public abstract boolean getCD() throws IOException;

    public abstract boolean getCTS() throws IOException;

    public abstract EnumSet<UsbSerialPort.ControlLine> getControlLines() throws IOException;

    public abstract boolean getDSR() throws IOException;

    public abstract boolean getDTR() throws IOException;

    public UsbDevice getDevice() {
        return this.mDevice;
    }

    public int getPortNumber() {
        return this.mPortNumber;
    }

    public abstract boolean getRI() throws IOException;

    public abstract boolean getRTS() throws IOException;

    public String getSerial() {
        return this.mConnection.getSerial();
    }

    public abstract EnumSet<UsbSerialPort.ControlLine> getSupportedControlLines() throws IOException;

    public boolean isOpen() {
        return this.mConnection != null;
    }

    public void open(UsbDeviceConnection usbDeviceConnection) throws IOException {
        if (this.mConnection == null) {
            this.mConnection = usbDeviceConnection;
            try {
                openInt(usbDeviceConnection);
                if (this.mReadEndpoint == null || this.mWriteEndpoint == null) {
                    throw new IOException("Could not get read & write endpoints");
                }
                UsbRequest usbRequest = new UsbRequest();
                this.mUsbRequest = usbRequest;
                usbRequest.initialize(this.mConnection, this.mReadEndpoint);
            } catch (Exception e2) {
                close();
                throw e2;
            }
        } else {
            throw new IOException("Already open");
        }
    }

    /* access modifiers changed from: protected */
    public abstract void openInt(UsbDeviceConnection usbDeviceConnection) throws IOException;

    public boolean purgeHwBuffers(boolean z2, boolean z3) throws IOException {
        return false;
    }

    public int read(byte[] bArr, int i2) throws IOException {
        int i3;
        if (this.mConnection != null) {
            if (i2 != 0) {
                i3 = this.mConnection.bulkTransfer(this.mReadEndpoint, bArr, Math.min(bArr.length, 16384), i2);
            } else {
                ByteBuffer wrap = ByteBuffer.wrap(bArr);
                if (!this.mUsbRequest.queue(wrap, bArr.length)) {
                    throw new IOException("Queueing USB request failed");
                } else if (this.mConnection.requestWait() != null) {
                    i3 = wrap.position();
                } else {
                    throw new IOException("Waiting for USB request failed");
                }
            }
            if (i3 > 0) {
                return readFilter(bArr, i3);
            }
            return 0;
        }
        throw new IOException("Connection closed");
    }

    /* access modifiers changed from: protected */
    public int readFilter(byte[] bArr, int i2) throws IOException {
        return i2;
    }

    public abstract void setDTR(boolean z2) throws IOException;

    public abstract void setParameters(int i2, int i3, int i4, int i5) throws IOException;

    public abstract void setRTS(boolean z2) throws IOException;

    public final void setWriteBufferSize(int i2) {
        synchronized (this.mWriteBufferLock) {
            if (i2 != this.mWriteBuffer.length) {
                this.mWriteBuffer = new byte[i2];
            }
        }
    }

    public String toString() {
        return String.format("<%s device_name=%s device_id=%s port_number=%s>", new Object[]{getClass().getSimpleName(), this.mDevice.getDeviceName(), Integer.valueOf(this.mDevice.getDeviceId()), Integer.valueOf(this.mPortNumber)});
    }

    public int write(byte[] bArr, int i2) throws IOException {
        int min;
        byte[] bArr2;
        int bulkTransfer;
        if (this.mConnection != null) {
            int i3 = 0;
            while (i3 < bArr.length) {
                synchronized (this.mWriteBufferLock) {
                    min = Math.min(bArr.length - i3, this.mWriteBuffer.length);
                    if (i3 == 0) {
                        bArr2 = bArr;
                    } else {
                        System.arraycopy(bArr, i3, this.mWriteBuffer, 0, min);
                        bArr2 = this.mWriteBuffer;
                    }
                    bulkTransfer = this.mConnection.bulkTransfer(this.mWriteEndpoint, bArr2, min, i2);
                }
                if (bulkTransfer > 0) {
                    String str = TAG;
                    Log.d(str, "Wrote amt=" + bulkTransfer + " attempted=" + min);
                    i3 += bulkTransfer;
                } else {
                    throw new IOException("Error writing " + min + " bytes at offset " + i3 + " length=" + bArr.length);
                }
            }
            return i3;
        }
        throw new IOException("Connection closed");
    }
}
